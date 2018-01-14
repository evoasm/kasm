#include "kasm_NativeBuffer.h"

#include <stdbool.h>

#if defined(__linux__) || defined(__unix__) || defined(__unix) || (defined(__APPLE__) && defined(__MACH__))
#define KASM_UNIX
#endif

#if defined(_WIN32)
#  include <malloc.h>
#endif

#ifdef KASM_UNIX

#  include <unistd.h>
#  include <sys/mman.h>
#include <stdlib.h>
#include <string.h>
#include <errno.h>
#include <stdint.h>

#  if !defined(MAP_ANONYMOUS) && defined(MAP_ANON)
#    define MAP_ANONYMOUS MAP_ANON
#  endif
#endif

#ifdef __GNUC__
# define kasm_unlikely(e) (__builtin_expect(!!(e), 0))
# define kasm_likely(e) (__builtin_expect(!!(e), 1))
# define kasm_used_attr __attribute__((used))
# define kasm_printf_attr(x, y) __attribute__((__format__(__printf__, x, y)))
# define kasm_malloc_attr __attribute__((malloc))
#else
# define kasm_unlikely(e) (e)
# define kasm_likely(e) (e)
# define kasm_used_attr
# define kasm_printf_attr
# define kasm_malloc_attr
#endif

#define KASM_OUT_OF_MEMORY_ERROR "java/lang/OutOfMemoryError"
#define KASM_RUNTIME_EXCEPTION "java/lang/RuntimeException"
#define KASM_ZERO_DIVISION_EXCEPTION "kasm/ZeroDivisionException"
#define KASM_SEGMENTATION_FAULT_EXCEPTION "kasm/SegmentationFaultException"
#define KASM_ILLEGAL_INSTRUCTION_EXCEPTION "kasm/IllegalInstructionException"

#define KASM_ARY_LEN(ary) (sizeof(ary) / sizeof((ary)[0]))

static jclass
kasm_find_class(JNIEnv *env, const char *cls_name) {
  jclass cls = (*env)->FindClass(env, cls_name);
  if(cls == NULL) {
    fprintf(stderr, "cannot find class at %s:%d\n", __FILE__, __LINE__);
    abort();
  }
  return cls;
}

static jint kasm_printf_attr(3, 4)
kasm_throw(JNIEnv *env, const char *excp_cls_name, const char *format, ...) {
  va_list args;
  jclass excp_cls = kasm_find_class(env, excp_cls_name);
  char message[1024];

  va_start(args, format);
  vsnprintf(message, sizeof(message), format, args);
  va_end(args);

  return (*env)->ThrowNew(env, excp_cls, message);
}

static jint
kasm_throw_sig(JNIEnv *env, const char *excp_cls_name, uintptr_t addr) {
  jclass excp_cls;
  excp_cls = kasm_find_class(env, excp_cls_name);

  jmethodID constr_id = (*env)->GetMethodID(env, excp_cls, "<init>", "(J)V");
  jobject excp = (*env)->NewObject(env, excp_cls, constr_id, addr);
  return (*env)->Throw(env, excp);
}


bool
kasm_mprot(JNIEnv *env, void *p, size_t size, bool exec) {

#if defined(_WIN32)
  int mode;
  if(exec) {
    mode = PAGE_EXECUTE_READ;
  } else {
    mode = PAGE_READWRITE;
  }
  if(VirtualProtect(p, size, mode, NULL) != 0) {
    goto error;
  }
#elif defined(_POSIX_VERSION)
  int mode;
  if(exec) {
    mode = PROT_READ | PROT_EXEC;
  } else {
    mode = PROT_READ | PROT_WRITE;
  }

  if(mprotect(p, size, mode) != 0) {
    goto error;
  }
#else
#error
#endif
  return true;

error:
  kasm_throw(env, KASM_RUNTIME_EXCEPTION, "Changing memory protection failed: %s", strerror(errno));
  return false;
}


static void *
kasm_mmap(JNIEnv *env, size_t size, void *p) {
  /* Note that mmap considers the pointer passed soley as a hint address
   * and returns a valid address (possibly at a different address) in any case.
   * VirtualAlloc, on the other hand, will return NULL if the address is
   * not available
   */
  void *mem;

#if defined(_WIN32)
  retry:
      mem = VirtualAlloc(p, size, MEM_COMMIT, PAGE_READWRITE);
      if(mem == NULL) {
        if(p != NULL) {
          goto retry;
        } else {
          goto error;
        }
      }
      return mem;
#elif defined(_POSIX_VERSION)
  mem = mmap(p, size, PROT_READ | PROT_WRITE, MAP_ANONYMOUS | MAP_PRIVATE, -1, 0);
  if(mem == MAP_FAILED) {
    goto error;
  }
#else
#error
#endif
  return mem;

error:
  kasm_throw(env, KASM_OUT_OF_MEMORY_ERROR, "Allocating %zu bytes via mmap failed: %s", size, strerror(errno));
  return NULL;
}

static bool
kasm_munmap(JNIEnv *env, void *p, size_t size) {
  bool ret;
#if defined(_WIN32)
  ret = VirtualFree(p, size, MEM_DECOMMIT);
#elif defined(_POSIX_VERSION)
  ret = (munmap(p, size) == 0);
#else
#  error
#endif

  if(!ret) {
    kasm_throw(env, KASM_OUT_OF_MEMORY_ERROR, "Unmapping %zu bytes via munmap failed: %s", size, strerror(errno));
  }
  return ret;
}


static void *kasm_malloc_attr
kasm_aligned_alloc(JNIEnv *env, size_t align, size_t size) {
  void *ptr;

#if defined(__APPLE__)
  int error_code = posix_memalign(&ptr, align, size);
  if(evoasm_unlikely(error_code)) {
#else
#  if defined(_WIN32)
  ptr = _aligned_malloc(size, align);
#  else
  ptr = aligned_alloc(align, size);
#  endif
  if(kasm_unlikely(!ptr)) {
    int error_code = errno;
#endif

    kasm_throw(env, KASM_OUT_OF_MEMORY_ERROR, "Allocating %zu bytes failed: %s", size, strerror(error_code));
    return NULL;
  }

  memset(ptr, 0, size);
  return ptr;
}

jobject Java_kasm_NativeBuffer_allocate(JNIEnv *env, jclass cls, jlong capa, jboolean mmap) {

  void *mem;
  if(mmap) {
    mem = kasm_mmap(env, (size_t) capa, NULL);
  } else {
    mem = kasm_aligned_alloc(env, 64, (size_t) capa);
  }

  jobject buf = (*env)->NewDirectByteBuffer(env, mem, capa);

  return buf;
}

void Java_kasm_NativeBuffer_protect(JNIEnv *env, jclass cls, jobject buf, jboolean exec) {
  void *mem = (*env)->GetDirectBufferAddress(env, buf);
  jlong capa = (*env)->GetDirectBufferCapacity(env, buf);
  kasm_mprot(env, mem, (size_t) capa, exec);
}

#ifdef KASM_UNIX

#include <setjmp.h>
#include <signal.h>

#define KASM_SIG_TRY() (sigsetjmp(_kasm_sig_ctx.env, 1) == 0)

typedef struct {
  sigjmp_buf env;
  volatile int last_sig;
  volatile uintptr_t sig_addr;
} kasm_signal_ctx_t;

_Thread_local kasm_signal_ctx_t _kasm_sig_ctx;
static int _kasm_sigs[] = {SIGFPE, SIGSEGV, SIGILL};
static struct sigaction _kasm_prev_sigactions[KASM_ARY_LEN(_kasm_sigs)];

typedef enum {
  KASM_EXCP_ZERO_DIV,
  KASM_EXCP_SEG_FAULT,
  KASM_EXCP_ILL_INST
} kasm_excp_t;


static void
kasm_sig_uninstall() {
  for(size_t i = 0; i < KASM_ARY_LEN(_kasm_sigs); i++)
    if(sigaction(_kasm_sigs[i], &_kasm_prev_sigactions[i], NULL) < 0) {
      perror("sigaction");
      exit(1);
    }
}

static void
kasm_sig_handler(int sig, siginfo_t *siginfo, void *ctx) {
  bool handle = false;

  switch(sig) {
    case SIGFPE: {
      _kasm_sig_ctx.last_sig = KASM_EXCP_ZERO_DIV;
      handle = true;
      break;
    }
    case SIGSEGV: {
      _kasm_sig_ctx.last_sig = KASM_EXCP_SEG_FAULT;
      handle = true;
      break;
    }
    case SIGILL: {
      _kasm_sig_ctx.last_sig = KASM_EXCP_ILL_INST;
      handle = true;
      break;
    }
    default:
      break;
  }
  if(handle) {
    _kasm_sig_ctx.sig_addr = (uintptr_t) siginfo->si_addr;
    siglongjmp(_kasm_sig_ctx.env, 1);
  } else {
//    kasm_sig_uninstall();
    raise(sig);
  }
}

static void
kasm_sig_install() {

  for(size_t i = 0; i < KASM_ARY_LEN(_kasm_sigs); i++) {
    struct sigaction action = {0};

    action.sa_sigaction = kasm_sig_handler;
    sigemptyset(&action.sa_mask);
    action.sa_flags = SA_SIGINFO;

    if(sigaction(_kasm_sigs[i], &action, &_kasm_prev_sigactions[i]) < 0) {
      perror("sigaction");
      exit(1);
    }
  }

}

void
Java_kasm_NativeBuffer_register(JNIEnv *env, jclass cls) {
}

#else
#error
#endif

static intptr_t
kasm_exec_asm0(void *mem) {
  intptr_t (*func)(void);
  intptr_t result = 0;
  *(void **) (&func) = mem;
  result = func();
  return result;
}

static intptr_t
kasm_exec_asm1(void *mem, intptr_t arg1) {
  intptr_t (*func)(intptr_t);
  intptr_t result = 0;
  *(void **) (&func) = mem;
  result = func(arg1);
  return result;
}

static intptr_t
kasm_exec_asm2(void *mem, intptr_t arg1, intptr_t arg2) {
  intptr_t (*func)(intptr_t, intptr_t);
  intptr_t result = 0;
  *(void **) (&func) = mem;
  result = func(arg1, arg2);
  return result;
}

static intptr_t
kasm_exec_asm6(void *mem, intptr_t arg1, intptr_t arg2, intptr_t arg3, intptr_t arg4, intptr_t arg5, intptr_t arg6) {
  intptr_t (*func)(intptr_t, intptr_t, intptr_t, intptr_t, intptr_t, intptr_t);
  intptr_t result = 0;
  *(void **) (&func) = mem;
  result = func(arg1, arg2, arg3, arg4, arg5, arg6);
  return result;
}

#define KASM_EXEC_ASM_PRE \
  void *mem = (*env)->GetDirectBufferAddress(env, buf);\
  jlong result = -1;\
  \
  kasm_sig_install();\
  \
  if(KASM_SIG_TRY()) {\

#define KASM_EXEC_ASM_POST \
    kasm_sig_uninstall();\
  } else {\
    const char *excp_cls;\
  \
    switch(_kasm_sig_ctx.last_sig) {\
      case KASM_EXCP_ZERO_DIV:\
        excp_cls = KASM_ZERO_DIVISION_EXCEPTION;\
        break;\
      case KASM_EXCP_SEG_FAULT:\
        excp_cls = KASM_SEGMENTATION_FAULT_EXCEPTION;\
        break;\
      case KASM_EXCP_ILL_INST:\
        excp_cls = KASM_ILLEGAL_INSTRUCTION_EXCEPTION;\
        break;\
      default:\
        abort();\
    }\
    kasm_sig_uninstall();\
    kasm_throw_sig(env, excp_cls, _kasm_sig_ctx.sig_addr);\
  }\
  return (jlong) result;

jlong Java_kasm_NativeBuffer_execute0(JNIEnv *env, jclass cls, jobject buf) {
  KASM_EXEC_ASM_PRE
    result = kasm_exec_asm0(mem);
  KASM_EXEC_ASM_POST
}

jlong Java_kasm_NativeBuffer_execute1(JNIEnv *env, jclass cls, jobject buf, jlong arg1) {
  KASM_EXEC_ASM_PRE
    result = kasm_exec_asm1(mem, (intptr_t) arg1);
  KASM_EXEC_ASM_POST
}

jlong Java_kasm_NativeBuffer_execute2(JNIEnv *env, jclass cls, jobject buf, jlong arg1, jlong arg2) {
  KASM_EXEC_ASM_PRE
    result = kasm_exec_asm2(mem, (intptr_t) arg1, (intptr_t) arg2);
  KASM_EXEC_ASM_POST
}

jlong
Java_kasm_NativeBuffer_execute6(JNIEnv *env, jclass cls, jobject buf, jlong arg1, jlong arg2, jlong arg3, jlong arg4,
                                jlong arg5, jlong arg6) {
  KASM_EXEC_ASM_PRE
    result = kasm_exec_asm6(mem, (intptr_t) arg1,
                            (intptr_t) arg2,
                            (intptr_t) arg3,
                            (intptr_t) arg4,
                            (intptr_t) arg5,
                            (intptr_t) arg6);

  KASM_EXEC_ASM_POST
}

void Java_kasm_NativeBuffer_release(JNIEnv *env, jclass cls, jobject buf, jboolean mmap) {
  void *mem = (*env)->GetDirectBufferAddress(env, buf);
  jlong capa = (*env)->GetDirectBufferCapacity(env, buf);

  if(mmap) {
    kasm_munmap(env, mem, (size_t) capa);
  } else {
    free(mem);
  }
}

jbyteArray Java_kasm_NativeBuffer_toArray(JNIEnv *env, jclass cls, jobject buf) {
  void *mem = (*env)->GetDirectBufferAddress(env, buf);
  jlong capa = (*env)->GetDirectBufferCapacity(env, buf);

  jbyteArray ary = (*env)->NewByteArray(env, (jsize) capa);

  (*env)->SetByteArrayRegion(env, ary, 0, (jsize) capa, mem);

  return ary;
}

jlong Java_kasm_NativeBuffer_getAddress(JNIEnv *env, jclass cls, jobject buf) {
  void *mem = (*env)->GetDirectBufferAddress(env, buf);
  return (jlong) mem;
}
