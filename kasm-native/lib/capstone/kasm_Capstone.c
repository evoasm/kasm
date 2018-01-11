#include "kasm_Capstone.h"
#include <capstone.h>
#include <string.h>

jobjectArray
Java_kasm_Capstone_disassembleX64(JNIEnv *env, jclass cls, jbyteArray code_array) {

  csh handle;
  cs_insn *insns;
  size_t count;
  const uint8_t *code = (const uint8_t *) (*env)->GetByteArrayElements(env, code_array, NULL);
  size_t code_len = (size_t) (*env)->GetArrayLength(env, code_array);

  if(cs_open(CS_ARCH_X86, CS_MODE_64, &handle) != CS_ERR_OK) return NULL;

  count = cs_disasm(handle, code, code_len, (uint64_t) 0, 0, &insns);

  jclass string_array_class = (*env)->FindClass(env, "[Ljava/lang/String;");
  jclass string_class = (*env)->FindClass(env, "Ljava/lang/String;");
  jobjectArray result = (*env)->NewObjectArray(env, (jsize) count, string_array_class, NULL);

  for(size_t i = 0; i < count; i++) {
    jobjectArray array = (*env)->NewObjectArray(env, 2, string_class, NULL);
    jstring mnemonic = (*env)->NewStringUTF(env, insns[i].mnemonic);
    jstring op_str = (*env)->NewStringUTF(env, insns[i].op_str);

    (*env)->SetObjectArrayElement(env, array, 0, mnemonic);
    (*env)->SetObjectArrayElement(env, array, 1, op_str);

    (*env)->SetObjectArrayElement(env, result, (jsize) i, array);
  }
  cs_free(insns, count);
  cs_close(&handle);

  return result;
}

