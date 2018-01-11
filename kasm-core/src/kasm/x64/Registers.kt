package kasm.x64

import java.util.*

interface CpuFlag

enum class Rflag(isIgnored: Boolean = false) : CpuFlag {
    OF,
    SF,
    ZF,
    PF,
    CF,
    RF(true),
    VIF(true),
    AC(true),
    VM(true),
    NT(true),
    TF(true),
    DF(true),
    IF(true),
    AF(true),
}

enum class MxcsrFlag(isIgnored: Boolean = true) : CpuFlag {
    PE,
    UE,
    OE,
    ME,
    ZE,
    DE,
    IE,
    PM,
    UM,
    OM,
    ZM,
    DM,
    IM,
    MM,
    FZ(false),
    RC(false),
    DAZ(false)
}

enum class InstructionEncodingType {
    RVM, RVMI, RVMR, MVR, RMV, RMVI, VM, VMI,
    RM, RMI, XM, MR, MRI, M, NP,

}


//class InstructionOperand(val instruction: Instruction, val size: BitSize) {
//
//    fun needsRex(parameterSet: ParameterSet) : Boolean {
//        return true
////        if(instruction.needsRex) return true
//
//
//
//    }
//}

enum class BitRange {


    _0_7 {
        override fun contains(bit: Int) = bit >= 0 && bit <= 7
        override val size = BitSize._8
    },
    _8_15 {
        override fun contains(bit: Int) = bit >= 8 && bit <= 15
        override val size = BitSize._8
    },
    _0_15 {
        override fun contains(bit: Int) = bit >= 0 && bit <= 15
        override val size = BitSize._16
    },
    _0_31 {
        override fun contains(bit: Int) = bit >= 0 && bit <= 31
        override val size = BitSize._32
    },
    _0_63 {
        override fun contains(bit: Int) = bit >= 0 && bit <= 63
        override val size = BitSize._64
    },
    _64_127 {
        override fun contains(bit: Int) = bit >= 64 && bit <= 127
        override val size = BitSize._64
    },
    _0_127 {
        override fun contains(bit: Int) = bit >= 0 && bit <= 127
        override val size = BitSize._128
    },
    _0_255 {
        override fun contains(bit: Int) = bit >= 0 && bit <= 255
        override val size = BitSize._256
    },

    //FIXME: should rather be 0_VMAX instead
    _0_511 {
        override fun contains(bit: Int) = bit >= 0 && bit <= 511
        override val size = BitSize._512
    };

    abstract fun contains(bit: Int): Boolean
    abstract val size: BitSize
}

enum class BitSize {
    _8 {
        override fun toBitRange() = BitRange._0_7
        override fun toInt() = 8
    },
    _16 {
        override fun toBitRange() = BitRange._0_15
        override fun toInt() = 16
    },
    _32 {
        override fun toBitRange() = BitRange._0_31
        override fun toInt() = 32
    },
    _64 {
        override fun toBitRange() = BitRange._0_63
        override fun toInt() = 64
    },
    _128 {
        override fun toBitRange() = BitRange._0_127
        override fun toInt() = 128
    },
    _256 {
        override fun toBitRange() = BitRange._0_255
        override fun toInt() = 256
    },
    _512 {
        override fun toBitRange() = BitRange._0_511
        override fun toInt() = 256
    };

    abstract fun toInt() : Int
    val byteSize get() = toInt() / 8
    abstract fun toBitRange(): BitRange;
}

interface VectorRegister : Register {

}

interface Register {
    val type: RegisterType
    val code: Int
    val unextendedCode: Int
        get() = code.rem(8)
    val rexBit: Int
        get() = if (code < 8) 0 else 1

    val name : String
}

interface AddressRegister : Register

enum class IpRegister : Register, AddressRegister {
    RIP;

    override val type = RegisterType.IP
    override val code: Int = 5
}

enum class RflagsRegister : Register, AddressRegister {
    RFLAGS;

    override val type = RegisterType.RFLAGS
    override val code: Int = -1
}

enum class MxcsrRegister : Register, AddressRegister {
    MXCSR;

    override val type = RegisterType.MXCSR
    override val code: Int = -1
}

interface GpRegister : Register {
    companion object {

        fun isSp(baseRegister: Register): Boolean {
            return baseRegister == GpRegister32.ESP || baseRegister == GpRegister64.RSP
        }

        fun isR12(baseRegister: Register): Boolean {
            return baseRegister == GpRegister32.R12D || baseRegister == GpRegister64.R12
        }

        fun isBp(baseRegister: Register): Boolean {
            return baseRegister == GpRegister32.EBP || baseRegister == GpRegister64.RBP
        }

        fun isR13(baseRegister: Register): Boolean {
            return baseRegister == GpRegister32.R13D || baseRegister == GpRegister64.R13
        }
    }
}

interface SubRegister<out S : Register, out T : Register> : Register {
    val superRegister: S
    val topLevelRegister: T
}

enum class GpRegister64(override val code: Int) : GpRegister, AddressRegister {
    RAX(0),
    RCX(1),
    RDX(2),
    RBX(3),
    RSP(4),
    RBP(5),
    RSI(6),
    RDI(7),
    R8(8),
    R9(9),
    R10(10),
    R11(11),
    R12(12),
    R13(13),
    R14(14),
    R15(15);

    override val type = RegisterType.GP64
}

enum class GpRegister32(override val code: Int, override val superRegister: GpRegister64, override val topLevelRegister: GpRegister64) : GpRegister, AddressRegister, SubRegister<GpRegister64, GpRegister64> {
    EAX  (0, GpRegister64.RAX,GpRegister64.RAX),
    ECX  (1, GpRegister64.RCX,GpRegister64.RCX),
    EDX(  2, GpRegister64.RDX,GpRegister64.RDX),
    EBX(  3, GpRegister64.RBX,GpRegister64.RBX),
    ESP(  4, GpRegister64.RSP,GpRegister64.RSP),
    EBP(  5, GpRegister64.RBP,GpRegister64.RBP),
    ESI(  6, GpRegister64.RSI,GpRegister64.RSI),
    EDI(  7, GpRegister64.RDI,GpRegister64.RDI),
    R8D(  8, GpRegister64.R8 ,GpRegister64.R8 ),
    R9D(  9, GpRegister64.R9 ,GpRegister64.R9 ),
    R10D(10, GpRegister64.R10,GpRegister64.R10),
    R11D(11, GpRegister64.R11,GpRegister64.R11),
    R12D(12, GpRegister64.R12,GpRegister64.R12),
    R13D(13, GpRegister64.R13,GpRegister64.R13),
    R14D(14, GpRegister64.R14,GpRegister64.R14),
    R15D(15, GpRegister64.R15,GpRegister64.R15);

    override val type = RegisterType.GP32
}

enum class GpRegister16(override val code: Int, override val superRegister: GpRegister32, override val topLevelRegister: GpRegister64) : GpRegister, SubRegister<GpRegister32, GpRegister64> {
    AX(   0, GpRegister32.EAX ,GpRegister64.RAX),
    CX(   1, GpRegister32.ECX ,GpRegister64.RCX),
    DX(   2, GpRegister32.EDX ,GpRegister64.RDX),
    BX(   3, GpRegister32.EBX ,GpRegister64.RBX),
    SP(   4, GpRegister32.ESP ,GpRegister64.RSP),
    BP(   5, GpRegister32.EBP ,GpRegister64.RBP),
    SI(   6, GpRegister32.ESI ,GpRegister64.RSI),
    DI(   7, GpRegister32.EDI ,GpRegister64.RDI),
    R8W(  8, GpRegister32.R8D ,GpRegister64.R8 ),
    R9W(  9, GpRegister32.R9D ,GpRegister64.R9 ),
    R10W(10, GpRegister32.R10D,GpRegister64.R10),
    R11W(11, GpRegister32.R11D,GpRegister64.R11),
    R12W(12, GpRegister32.R12D,GpRegister64.R12),
    R13W(13, GpRegister32.R13D,GpRegister64.R13),
    R14W(14, GpRegister32.R14D,GpRegister64.R14),
    R15W(15, GpRegister32.R15D,GpRegister64.R15);

    override val type = RegisterType.GP16
}


enum class GpRegister8(override val code: Int, override val superRegister: GpRegister16, override val topLevelRegister: GpRegister64, val needsRex: Boolean = false, val forbidsRex: Boolean = false) : GpRegister, SubRegister<GpRegister16, GpRegister64> {
    AL(0, GpRegister16.AX, GpRegister64.RAX),
    AH(4, GpRegister16.AX, GpRegister64.RAX, forbidsRex = true),
    CL(1, GpRegister16.CX, GpRegister64.RCX),
    CH(5, GpRegister16.CX, GpRegister64.RCX, forbidsRex = true),
    DL(2, GpRegister16.DX, GpRegister64.RDX),
    DH(6, GpRegister16.DX, GpRegister64.RDX, forbidsRex = true),
    BL(3, GpRegister16.BX, GpRegister64.RBX),
    BH(7, GpRegister16.BX, GpRegister64.RBX, forbidsRex = true),
    SPL(4, GpRegister16.BX, GpRegister64.RBX, needsRex = true),
    BPL(5, GpRegister16.SP, GpRegister64.RSP, needsRex = true),
    SIL(6, GpRegister16.SI, GpRegister64.RSI, needsRex = true),
    DIL(7, GpRegister16.DI, GpRegister64.RDI, needsRex = true),
    R8B(8, GpRegister16.R8W, GpRegister64.R8),
    R9B(9, GpRegister16.R9W, GpRegister64.R9),
    R10B(10, GpRegister16.R10W, GpRegister64.R10),
    R11B(11, GpRegister16.R11W, GpRegister64.R11),
    R12B(12, GpRegister16.R12W, GpRegister64.R12),
    R13B(13, GpRegister16.R13W, GpRegister64.R13),
    R14B(14, GpRegister16.R14W, GpRegister64.R14),
    R15B(15, GpRegister16.R15W, GpRegister64.R15);

    override val type = RegisterType.GP8

}

enum class MmRegister(override val code: Int) : Register {
    MM0(0),
    MM1(1),
    MM2(2),
    MM3(3),
    MM4(4),
    MM5(5),
    MM6(6),
    MM7(7);

    override val type = RegisterType.MM
}


enum class XmmRegister(override val code: Int, override val superRegister: YmmRegister, override val topLevelRegister: ZmmRegister) : Register, VectorRegister, SubRegister<YmmRegister, ZmmRegister> {
    XMM0(0, YmmRegister.YMM0, ZmmRegister.ZMM0),
    XMM1(1, YmmRegister.YMM1, ZmmRegister.ZMM1),
    XMM2(2, YmmRegister.YMM2, ZmmRegister.ZMM2),
    XMM3(3, YmmRegister.YMM3, ZmmRegister.ZMM3),
    XMM4(4, YmmRegister.YMM4, ZmmRegister.ZMM4),
    XMM5(5, YmmRegister.YMM5, ZmmRegister.ZMM5),
    XMM6(6, YmmRegister.YMM6, ZmmRegister.ZMM6),
    XMM7(7, YmmRegister.YMM7, ZmmRegister.ZMM7),
    XMM8(8, YmmRegister.YMM8, ZmmRegister.ZMM8),
    XMM9(9, YmmRegister.YMM9, ZmmRegister.ZMM9),
    XMM10(10, YmmRegister.YMM10, ZmmRegister.ZMM10),
    XMM11(11, YmmRegister.YMM11, ZmmRegister.ZMM11),
    XMM12(12, YmmRegister.YMM12, ZmmRegister.ZMM12),
    XMM13(13, YmmRegister.YMM13, ZmmRegister.ZMM13),
    XMM14(14, YmmRegister.YMM14, ZmmRegister.ZMM14),
    XMM15(15, YmmRegister.YMM15, ZmmRegister.ZMM15);

    override val type = RegisterType.XMM
}

enum class YmmRegister(override val code: Int, override val superRegister: ZmmRegister, override val topLevelRegister: ZmmRegister) : Register, VectorRegister, SubRegister<ZmmRegister, ZmmRegister> {
    YMM0(0, ZmmRegister.ZMM0, ZmmRegister.ZMM0),
    YMM1(1, ZmmRegister.ZMM1, ZmmRegister.ZMM1),
    YMM2(2, ZmmRegister.ZMM2, ZmmRegister.ZMM2),
    YMM3(3, ZmmRegister.ZMM3, ZmmRegister.ZMM3),
    YMM4(4, ZmmRegister.ZMM4, ZmmRegister.ZMM4),
    YMM5(5, ZmmRegister.ZMM5, ZmmRegister.ZMM5),
    YMM6(6, ZmmRegister.ZMM6, ZmmRegister.ZMM6),
    YMM7(7, ZmmRegister.ZMM7, ZmmRegister.ZMM7),
    YMM8(8, ZmmRegister.ZMM8, ZmmRegister.ZMM8),
    YMM9(9, ZmmRegister.ZMM9, ZmmRegister.ZMM9),
    YMM10(10, ZmmRegister.ZMM10, ZmmRegister.ZMM10),
    YMM11(11, ZmmRegister.ZMM11, ZmmRegister.ZMM11),
    YMM12(12, ZmmRegister.ZMM12, ZmmRegister.ZMM12),
    YMM13(13, ZmmRegister.ZMM13, ZmmRegister.ZMM13),
    YMM14(14, ZmmRegister.ZMM14, ZmmRegister.ZMM14),
    YMM15(15, ZmmRegister.ZMM15, ZmmRegister.ZMM15);

    override val type = RegisterType.YMM

}

enum class ZmmRegister(override val code: Int) : Register, VectorRegister {
    ZMM0(0),
    ZMM1(1),
    ZMM2(2),
    ZMM3(3),
    ZMM4(4),
    ZMM5(5),
    ZMM6(6),
    ZMM7(7),
    ZMM8(8),
    ZMM9(9),
    ZMM10(10),
    ZMM11(11),
    ZMM12(12),
    ZMM13(13),
    ZMM14(14),
    ZMM15(15),
    ZMM16(16),
    ZMM17(17),
    ZMM18(18),
    ZMM19(19),
    ZMM20(20),
    ZMM21(21),
    ZMM22(22),
    ZMM23(23),
    ZMM24(24),
    ZMM25(25),
    ZMM26(26),
    ZMM27(27),
    ZMM28(28),
    ZMM29(29),
    ZMM30(30),
    ZMM31(31);

    override val type = RegisterType.ZMM

}

enum class RegisterType(val size: BitSize, val superRegisterType: RegisterType?, val topRegisterType: RegisterType?) {
    IP(BitSize._64, null, null),
    RFLAGS(BitSize._64, null, null),
    MXCSR(BitSize._32, null, null),
    GP64(BitSize._64, null, null),
    GP32(BitSize._32, GP64, GP64),
    GP16(BitSize._16, GP32, GP64),
    GP8(BitSize._8, GP16, GP64),
    MM(BitSize._64, null, null) {
        override val isVectorType = true
    },
    ZMM(BitSize._512, null, null) {
        override val isVectorType = true
    },
    YMM(BitSize._256, ZMM, ZMM) {
        override val isVectorType = true
    },
    XMM(BitSize._128, YMM, ZMM) {
        override val isVectorType = true
    };

    val isSubRegisterType = superRegisterType != null
    open val isVectorType = false
}

enum class CpuException {
    SSX, GPX, PF, AC, UD, GPS, PFS, XFSS, UDX, GP, ACS, XFS, SS, TS, NPX, SSXXX, PFXX, DE, SSXX, NM, NMS, UDCPUID, XF, PFX
}

enum class CpuFeature {
    SEP,
    PSN,
    CLFSH,
    DS,
    ACPI,
    SSE,
    SSE2,
    SS,
    HTT,
    TM,
    IA64,
    PBE,
    SSE3,
    PCLMULQDQ,
    DTES64,
    MONITOR,
    DS_CPL,
    VMX,
    SMX,
    EST,
    TM2,
    SSSE3,
    CNXT_ID,
    SDBG,
    FMA,
    CX16,
    XTPR,
    PDCM,
    PCID,
    DCA,
    SSE4_1,
    SSE4_2,
    X2APIC,
    MOVBE,
    POPCNT,
    TSC_DEADLINE,
    AES,
    XSAVE,
    OSXSAVE,
    AVX,
    F16C,
    RDRAND,
    HYPERVISOR,
    FSGSBASE,
    IA32_TSC_ADJUST,
    SGX,
    BMI1,
    HLE,
    AVX2,
    SMEP,
    BMI2,
    ERMS,
    INVPCID,
    RTM,
    PQM,
    FPU_CS_DS_DEPRECATED,
    MPX,
    PQE,
    AVX512F,
    AVX512DQ,
    RDSEED,
    ADX,
    SMAP,
    AVX512IFMA,
    PCOMMIT,
    CLFLUSHOPT,
    CLWB,
    INTEL_PT,
    AVX512PF,
    AVX512ER,
    AVX512CD,
    SHA,
    AVX512BW,
    AVX512VL,
    PREFETCHWT1,
    AVX512VBMI,
    FPU,
    VME,
    DE,
    PSE,
    TSC,
    MSR,
    PAE,
    MCE,
    CX8,
    APIC,
    SYSCALL,
    MTRR,
    PGE,
    MCA,
    CMOV,
    PAT,
    PSE36,
    MP,
    NX,
    MMXEXT,
    MMX,
    FXSR,
    FXSR_OPT,
    PDPE1GB,
    RDTSCP,
    RESERVED,
    LM,
    _3DNOWEXT,
    _3DNOW,
    LAHF_LM,
    CMP_LEGACY,
    SVM,
    EXTAPIC,
    CR8_LEGACY,
    ABM,
    SSE4A,
    MISALIGNSSE,
    PRFCHW,
    OSVW,
    IBS,
    XOP,
    SKINIT,
    WDT,
    LWP,
    FMA4,
    TCE,
    NODEID_MSR,
    TBM,
    TOPOEXT,
    PERFCTR_CORE,
    PERFCTR_NB,
    DBX,
    PERFTSC,
    PCX_L2I;

    companion object {
        val avx512Features = EnumSet.of(
                AVX512F, AVX512DQ, AVX512IFMA, AVX512PF, AVX512ER,
                AVX512CD, AVX512BW, AVX512VL, AVX512VBMI
        )
    }
}



