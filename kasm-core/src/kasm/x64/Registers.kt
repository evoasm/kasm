package kasm.x64

import java.util.*

interface StatusOrControlField

enum class RflagsField(isIgnored: Boolean = false) : StatusOrControlField {
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

enum class X87ControlField : StatusOrControlField {
    IM,
    DM,
    ZM,
    OM,
    UM,
    PM,
    PC,
    RC,
    X
}

enum class X87StatusField : StatusOrControlField {
    B,
    C3,
    TOP,
    C2,
    C1,
    C0,
    ES,
    SF,
    PE,
    UE,
    OE,
    ZE,
    DE,
    IE,
}

enum class X87TagField : StatusOrControlField {
    TAG0,
    TAG1,
    TAG2,
    TAG3,
    TAG4,
    TAG5,
    TAG6,
    TAG7,
}

enum class MxcsrField(isIgnored: Boolean = true) : StatusOrControlField {
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


    BITS_0_7 {
        override fun contains(other: BitRange) = false
        override val size = BitSize.BITS_8
    },
    BITS_8_15 {
        override fun contains(other: BitRange) = false
        override val size = BitSize.BITS_8
    },
    BITS_0_15 {
        override val size = BitSize.BITS_16
    },
    BITS_0_31 {
        override val size = BitSize.BITS_32
    },
    BITS_0_63 {
        override val size = BitSize.BITS_64
    },
    BITS_0_79 {
        override val size = BitSize.BITS_80
    },
    BITS_64_127 {
        override fun contains(other: BitRange) = false
        override val size = BitSize.BITS_64
    },
    BITS_0_127 {
        override val size = BitSize.BITS_128
    },
    BITS_0_255 {
        override val size = BitSize.BITS_256
    },

    //FIXME: should rather be 0_VMAX instead
    BITS_0_511 {
        override val size = BitSize.BITS_512
    },

    BYTES_0_27 {
        override val size = BitSize.BYTES_28
    },

    BYTES_0_107 {
        override val size = BitSize.BYTES_108
    },

    BYTES_0_511 {
        override val size = BitSize.BYTES_512
    }

    ;

    open operator fun contains(other: BitRange) = other.ordinal < this.ordinal
    abstract val size: BitSize
}

enum class BitSize {
    BITS_8 {
        override fun toBitRange() = BitRange.BITS_0_7
        override fun toInt() = 8
    },
    BITS_16 {
        override fun toBitRange() = BitRange.BITS_0_15
        override fun toInt() = 16
    },
    BITS_32 {
        override fun toBitRange() = BitRange.BITS_0_31
        override fun toInt() = 32
    },
    BITS_64 {
        override fun toBitRange() = BitRange.BITS_0_63
        override fun toInt() = 64
    },
    BITS_80 {
        override fun toBitRange() = BitRange.BITS_0_79
        override fun toInt() = 80
    },
    BITS_128 {
        override fun toBitRange() = BitRange.BITS_0_127
        override fun toInt() = 128
    },
    BITS_256 {
        override fun toBitRange() = BitRange.BITS_0_255
        override fun toInt() = 256
    },
    BITS_512 {
        override fun toBitRange() = BitRange.BITS_0_511
        override fun toInt() = 256
    },

    BYTES_28 {
        override fun toBitRange() = BitRange.BYTES_0_27
        override fun toInt() = 224
    },

    BYTES_108 {
        override fun toBitRange() = BitRange.BYTES_0_107
        override fun toInt() = 864
    },

    BYTES_512 {
        override fun toBitRange() = BitRange.BYTES_0_511
        override fun toInt() = 4096
    },


    ;

    abstract fun toInt(): Int
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

    val name: String
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

    RAX(0) {
        override val subRegister32 get() = GpRegister32.EAX
        override val subRegister16 get() = GpRegister16.AX
        override val subRegister8 get() = GpRegister8.AL
    },
    RCX(1) {
        override val subRegister32 get() = GpRegister32.ECX
        override val subRegister16 get() = GpRegister16.CX
        override val subRegister8 get() = GpRegister8.CL
    },
    RDX(2) {
        override val subRegister32 get() = GpRegister32.EDX
        override val subRegister16 get() = GpRegister16.DX
        override val subRegister8 get() = GpRegister8.DL
    },
    RBX(3) {
        override val subRegister32 get() = GpRegister32.EBX
        override val subRegister16 get() = GpRegister16.BX
        override val subRegister8 get() = GpRegister8.BL
    },
    RSP(4) {
        override val subRegister32 get() = GpRegister32.ESP
        override val subRegister16 get() = GpRegister16.SP
        override val subRegister8 get() = GpRegister8.SPL
    },
    RBP(5) {
        override val subRegister32 get() = GpRegister32.EBP
        override val subRegister16 get() = GpRegister16.BP
        override val subRegister8 get() = GpRegister8.BPL
    },
    RSI(6) {
        override val subRegister32 get() = GpRegister32.ESI
        override val subRegister16 get() = GpRegister16.SI
        override val subRegister8 get() = GpRegister8.SIL
    },
    RDI(7) {
        override val subRegister32 get() = GpRegister32.EDI
        override val subRegister16 get() = GpRegister16.DI
        override val subRegister8 get() = GpRegister8.DIL
    },
    R8(8) {
        override val subRegister32 get() = GpRegister32.R8D
        override val subRegister16 get() = GpRegister16.R8W
        override val subRegister8 get() = GpRegister8.R8B
    },
    R9(9) {
        override val subRegister32 get() = GpRegister32.R9D
        override val subRegister16 get() = GpRegister16.R9W
        override val subRegister8 get() = GpRegister8.R9B
    },
    R10(10) {
        override val subRegister32 get() = GpRegister32.R10D
        override val subRegister16 get() = GpRegister16.R10W
        override val subRegister8 get() = GpRegister8.R10B
    },
    R11(11) {
        override val subRegister32 get() = GpRegister32.R11D
        override val subRegister16 get() = GpRegister16.R11W
        override val subRegister8 get() = GpRegister8.R11B
    },
    R12(12) {
        override val subRegister32 get() = GpRegister32.R12D
        override val subRegister16 get() = GpRegister16.R12W
        override val subRegister8 get() = GpRegister8.R12B
    },
    R13(13) {
        override val subRegister32 get() = GpRegister32.R13D
        override val subRegister16 get() = GpRegister16.R13W
        override val subRegister8 get() = GpRegister8.R13B
    },
    R14(14) {
        override val subRegister32 get() = GpRegister32.R14D
        override val subRegister16 get() = GpRegister16.R14W
        override val subRegister8 get() = GpRegister8.R14B
    },
    R15(15) {
        override val subRegister32 get() = GpRegister32.R15D
        override val subRegister16 get() = GpRegister16.R15W
        override val subRegister8 get() = GpRegister8.R15B
    };

    override val type = RegisterType.GP64
    abstract val subRegister32: GpRegister32
    abstract val subRegister16: GpRegister16
    abstract val subRegister8: GpRegister8
}

enum class GpRegister32(override val code: Int) : GpRegister,
        AddressRegister,
        SubRegister<GpRegister64, GpRegister64> {
    EAX(0) {
        override val superRegister get() = GpRegister64.RAX
        override val topLevelRegister get() = GpRegister64.RAX
        override val subRegister16 get() = GpRegister16.AX
        override val subRegister8 get() = GpRegister8.AL
    },
    ECX(1) {
        override val superRegister get() = GpRegister64.RCX
        override val topLevelRegister get() = GpRegister64.RCX
        override val subRegister16 get() = GpRegister16.CX
        override val subRegister8 get() = GpRegister8.CL
    },
    EDX(2) {
        override val superRegister get() = GpRegister64.RDX
        override val topLevelRegister get() = GpRegister64.RDX
        override val subRegister16 get() = GpRegister16.DX
        override val subRegister8 get() = GpRegister8.DL
    },
    EBX(3) {
        override val superRegister get() = GpRegister64.RBX
        override val topLevelRegister get() = GpRegister64.RBX
        override val subRegister16 get() = GpRegister16.BX
        override val subRegister8 get() = GpRegister8.BL
    },
    ESP(4) {
        override val superRegister get() = GpRegister64.RSP
        override val topLevelRegister get() = GpRegister64.RSP
        override val subRegister16 get() = GpRegister16.SP
        override val subRegister8 get() = GpRegister8.SPL
    },
    EBP(5) {
        override val superRegister get() = GpRegister64.RBP
        override val topLevelRegister get() = GpRegister64.RBP
        override val subRegister16 get() = GpRegister16.BP
        override val subRegister8 get() = GpRegister8.BPL
    },
    ESI(6) {
        override val superRegister get() = GpRegister64.RSI
        override val topLevelRegister get() = GpRegister64.RSI
        override val subRegister16 get() = GpRegister16.SI
        override val subRegister8 get() = GpRegister8.SIL
    },
    EDI(7) {
        override val superRegister get() = GpRegister64.RDI
        override val topLevelRegister get() = GpRegister64.RDI
        override val subRegister16 get() = GpRegister16.DI
        override val subRegister8 get() = GpRegister8.DIL
    },
    R8D(8) {
        override val superRegister get() = GpRegister64.R8
        override val topLevelRegister get() = GpRegister64.R8
        override val subRegister16 get() = GpRegister16.R8W
        override val subRegister8 get() = GpRegister8.R8B
    },
    R9D(9) {
        override val superRegister get() = GpRegister64.R9
        override val topLevelRegister get() = GpRegister64.R9
        override val subRegister16 get() = GpRegister16.R9W
        override val subRegister8 get() = GpRegister8.R9B
    },
    R10D(10) {
        override val superRegister get() = GpRegister64.R10
        override val topLevelRegister get() = GpRegister64.R10
        override val subRegister16 get() = GpRegister16.R10W
        override val subRegister8 get() = GpRegister8.R10B
    },
    R11D(11) {
        override val superRegister get() = GpRegister64.R11
        override val topLevelRegister get() = GpRegister64.R11
        override val subRegister16 get() = GpRegister16.R11W
        override val subRegister8 get() = GpRegister8.R11B
    },
    R12D(12) {
        override val superRegister get() = GpRegister64.R12
        override val topLevelRegister get() = GpRegister64.R12
        override val subRegister16 get() = GpRegister16.R12W
        override val subRegister8 get() = GpRegister8.R12B
    },
    R13D(13) {
        override val superRegister get() = GpRegister64.R13
        override val topLevelRegister get() = GpRegister64.R13
        override val subRegister16 get() = GpRegister16.R13W
        override val subRegister8 get() = GpRegister8.R13B
    },
    R14D(14) {
        override val superRegister get() = GpRegister64.R14
        override val topLevelRegister get() = GpRegister64.R14
        override val subRegister16 get() = GpRegister16.R14W
        override val subRegister8 get() = GpRegister8.R14B
    },
    R15D(15) {
        override val superRegister get() = GpRegister64.R15
        override val topLevelRegister get() = GpRegister64.R15
        override val subRegister16 get() = GpRegister16.R15W
        override val subRegister8 get() = GpRegister8.R15B
    };

    override val type = RegisterType.GP32
    abstract val subRegister16: GpRegister16
    abstract val subRegister8: GpRegister8
}

enum class GpRegister16(override val code: Int) : GpRegister, SubRegister<GpRegister32, GpRegister64> {
    AX(0) {
        override val superRegister get() = GpRegister32.EAX
        override val topLevelRegister get() = GpRegister64.RAX
        override val subRegister8 get() = GpRegister8.AL
    },
    CX(1) {
        override val superRegister get() = GpRegister32.ECX
        override val topLevelRegister get() = GpRegister64.RCX
        override val subRegister8 get() = GpRegister8.CL
    },
    DX(2) {
        override val superRegister get() = GpRegister32.EDX
        override val topLevelRegister get() = GpRegister64.RDX
        override val subRegister8 get() = GpRegister8.DL
    },
    BX(3) {
        override val superRegister get() = GpRegister32.EBX
        override val topLevelRegister get() = GpRegister64.RBX
        override val subRegister8 get() = GpRegister8.BL
    },
    SP(4) {
        override val superRegister get() = GpRegister32.ESP
        override val topLevelRegister get() = GpRegister64.RSP
        override val subRegister8 get() = GpRegister8.SPL
    },
    BP(5) {
        override val superRegister get() = GpRegister32.EBP
        override val topLevelRegister get() = GpRegister64.RBP
        override val subRegister8 get() = GpRegister8.BPL
    },
    SI(6) {
        override val superRegister get() = GpRegister32.ESI
        override val topLevelRegister get() = GpRegister64.RSI
        override val subRegister8 get() = GpRegister8.SIL
    },
    DI(7) {
        override val superRegister get() = GpRegister32.EDI
        override val topLevelRegister get() = GpRegister64.RDI
        override val subRegister8 get() = GpRegister8.DIL
    },
    R8W(8) {
        override val superRegister get() = GpRegister32.R8D
        override val topLevelRegister get() = GpRegister64.R8
        override val subRegister8 get() = GpRegister8.R8B
    },
    R9W(9) {
        override val superRegister get() = GpRegister32.R9D
        override val topLevelRegister get() = GpRegister64.R9
        override val subRegister8 get() = GpRegister8.R9B
    },
    R10W(10) {
        override val superRegister get() = GpRegister32.R10D
        override val topLevelRegister get() = GpRegister64.R10
        override val subRegister8 get() = GpRegister8.R10B
    },
    R11W(11) {
        override val superRegister get() = GpRegister32.R11D
        override val topLevelRegister get() = GpRegister64.R11
        override val subRegister8 get() = GpRegister8.R11B
    },
    R12W(12) {
        override val superRegister get() = GpRegister32.R12D
        override val topLevelRegister get() = GpRegister64.R12
        override val subRegister8 get() = GpRegister8.R12B
    },
    R13W(13) {
        override val superRegister get() = GpRegister32.R13D
        override val topLevelRegister get() = GpRegister64.R13
        override val subRegister8 get() = GpRegister8.R13B
    },
    R14W(14) {
        override val superRegister get() = GpRegister32.R14D
        override val topLevelRegister get() = GpRegister64.R14
        override val subRegister8 get() = GpRegister8.R14B
    },
    R15W(15) {
        override val superRegister get() = GpRegister32.R15D
        override val topLevelRegister get() = GpRegister64.R15
        override val subRegister8 get() = GpRegister8.R15B
    };

    override val type = RegisterType.GP16
    abstract val subRegister8: GpRegister8
}


enum class GpRegister8(override val code: Int,
                       val needsRex: Boolean = false,
                       val forbidsRex: Boolean = false) : GpRegister, SubRegister<GpRegister16, GpRegister64> {
    AL(0) {
        override val superRegister get() = GpRegister16.AX
        override val topLevelRegister get() = GpRegister64.RAX
    },
    AH(4, forbidsRex = true) {
        override val superRegister get() = GpRegister16.AX
        override val topLevelRegister get() = GpRegister64.RAX
    },
    CL(1) {
        override val superRegister get() = GpRegister16.CX
        override val topLevelRegister get() = GpRegister64.RCX
    },
    CH(5, forbidsRex = true) {
        override val superRegister get() = GpRegister16.CX
        override val topLevelRegister get() = GpRegister64.RCX
    },
    DL(2) {
        override val superRegister get() = GpRegister16.DX
        override val topLevelRegister get() = GpRegister64.RDX
    },
    DH(6, forbidsRex = true) {
        override val superRegister get() = GpRegister16.DX
        override val topLevelRegister get() = GpRegister64.RDX
    },
    BL(3) {
        override val superRegister get() = GpRegister16.BX
        override val topLevelRegister get() = GpRegister64.RBX
    },
    BH(7, forbidsRex = true) {
        override val superRegister get() = GpRegister16.BX
        override val topLevelRegister get() = GpRegister64.RBX
    },
    SPL(4, needsRex = true) {
        override val superRegister get() = GpRegister16.BX
        override val topLevelRegister get() = GpRegister64.RBX
    },
    BPL(5, needsRex = true) {
        override val superRegister get() = GpRegister16.SP
        override val topLevelRegister get() = GpRegister64.RSP
    },
    SIL(6, needsRex = true) {
        override val superRegister get() = GpRegister16.SI
        override val topLevelRegister get() = GpRegister64.RSI
    },
    DIL(7, needsRex = true) {
        override val superRegister get() = GpRegister16.DI
        override val topLevelRegister get() = GpRegister64.RDI
    },
    R8B(8) {
        override val superRegister get() = GpRegister16.R8W
        override val topLevelRegister get() = GpRegister64.R8
    },
    R9B(9) {
        override val superRegister get() = GpRegister16.R9W
        override val topLevelRegister get() = GpRegister64.R9
    },
    R10B(10) {
        override val superRegister get() = GpRegister16.R10W
        override val topLevelRegister get() = GpRegister64.R10
    },
    R11B(11) {
        override val superRegister get() = GpRegister16.R11W
        override val topLevelRegister get() = GpRegister64.R11
    },
    R12B(12) {
        override val superRegister get() = GpRegister16.R12W
        override val topLevelRegister get() = GpRegister64.R12
    },
    R13B(13) {
        override val superRegister get() = GpRegister16.R13W
        override val topLevelRegister get() = GpRegister64.R13
    },
    R14B(14) {
        override val superRegister get() = GpRegister16.R14W
        override val topLevelRegister get() = GpRegister64.R14
    },
    R15B(15) {
        override val superRegister get() = GpRegister16.R15W
        override val topLevelRegister get() = GpRegister64.R15
    };

    override val type = RegisterType.GP8

}

enum class X87Register(override val code: Int) : Register {
    ST0(0),
    ST1(1),
    ST2(2),
    ST3(3),
    ST4(4),
    ST5(5),
    ST6(6),
    ST7(7);

    override val type = RegisterType.X87
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


enum class XmmRegister(override val code: Int,
                       override val superRegister: YmmRegister,
                       override val topLevelRegister: ZmmRegister) : Register,
        VectorRegister,
        SubRegister<YmmRegister, ZmmRegister> {
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

enum class YmmRegister(override val code: Int,
                       override val superRegister: ZmmRegister,
                       override val topLevelRegister: ZmmRegister) : Register,
        VectorRegister,
        SubRegister<ZmmRegister, ZmmRegister> {
    YMM0(0, ZmmRegister.ZMM0, ZmmRegister.ZMM0) {
        override val subRegisterXmm: XmmRegister get() = XmmRegister.XMM0
    },
    YMM1(1, ZmmRegister.ZMM1, ZmmRegister.ZMM1){
        override val subRegisterXmm: XmmRegister get() = XmmRegister.XMM1
    },
    YMM2(2, ZmmRegister.ZMM2, ZmmRegister.ZMM2){
        override val subRegisterXmm: XmmRegister get() = XmmRegister.XMM2
    },
    YMM3(3, ZmmRegister.ZMM3, ZmmRegister.ZMM3){
        override val subRegisterXmm: XmmRegister get() = XmmRegister.XMM3
    },
    YMM4(4, ZmmRegister.ZMM4, ZmmRegister.ZMM4){
        override val subRegisterXmm: XmmRegister get() = XmmRegister.XMM4
    },
    YMM5(5, ZmmRegister.ZMM5, ZmmRegister.ZMM5){
        override val subRegisterXmm: XmmRegister get() = XmmRegister.XMM5
    },
    YMM6(6, ZmmRegister.ZMM6, ZmmRegister.ZMM6){
        override val subRegisterXmm: XmmRegister get() = XmmRegister.XMM6
    },
    YMM7(7, ZmmRegister.ZMM7, ZmmRegister.ZMM7){
        override val subRegisterXmm: XmmRegister get() = XmmRegister.XMM7
    },
    YMM8(8, ZmmRegister.ZMM8, ZmmRegister.ZMM8){
        override val subRegisterXmm: XmmRegister get() = XmmRegister.XMM8
    },
    YMM9(9, ZmmRegister.ZMM9, ZmmRegister.ZMM9){
        override val subRegisterXmm: XmmRegister get() = XmmRegister.XMM9
    },
    YMM10(10, ZmmRegister.ZMM10, ZmmRegister.ZMM10){
        override val subRegisterXmm: XmmRegister get() = XmmRegister.XMM10
    },
    YMM11(11, ZmmRegister.ZMM11, ZmmRegister.ZMM11){
        override val subRegisterXmm: XmmRegister get() = XmmRegister.XMM11
    },
    YMM12(12, ZmmRegister.ZMM12, ZmmRegister.ZMM12){
        override val subRegisterXmm: XmmRegister get() = XmmRegister.XMM12
    },
    YMM13(13, ZmmRegister.ZMM13, ZmmRegister.ZMM13){
        override val subRegisterXmm: XmmRegister get() = XmmRegister.XMM13
    },
    YMM14(14, ZmmRegister.ZMM14, ZmmRegister.ZMM14){
        override val subRegisterXmm: XmmRegister get() = XmmRegister.XMM14
    },
    YMM15(15, ZmmRegister.ZMM15, ZmmRegister.ZMM15){
        override val subRegisterXmm: XmmRegister get() = XmmRegister.XMM15
    };

    override val type = RegisterType.YMM
    abstract val subRegisterXmm: XmmRegister

}

enum class ZmmRegister(override val code: Int) : Register, VectorRegister {
    ZMM0(0) {
        override val subRegisterXmm: XmmRegister get() = XmmRegister.XMM0
        override val subRegisterYmm: YmmRegister get() = YmmRegister.YMM0
    },
    ZMM1(1){
        override val subRegisterXmm: XmmRegister get() = XmmRegister.XMM1
        override val subRegisterYmm: YmmRegister get() = YmmRegister.YMM1
    },
    ZMM2(2){
        override val subRegisterXmm: XmmRegister get() = XmmRegister.XMM2
        override val subRegisterYmm: YmmRegister get() = YmmRegister.YMM2
    },
    ZMM3(3){
        override val subRegisterXmm: XmmRegister get() = XmmRegister.XMM3
        override val subRegisterYmm: YmmRegister get() = YmmRegister.YMM3
    },
    ZMM4(4){
        override val subRegisterXmm: XmmRegister get() = XmmRegister.XMM4
        override val subRegisterYmm: YmmRegister get() = YmmRegister.YMM4
    },
    ZMM5(5){
        override val subRegisterXmm: XmmRegister get() = XmmRegister.XMM5
        override val subRegisterYmm: YmmRegister get() = YmmRegister.YMM5
    },
    ZMM6(6){
        override val subRegisterXmm: XmmRegister get() = XmmRegister.XMM6
        override val subRegisterYmm: YmmRegister get() = YmmRegister.YMM6
    },
    ZMM7(7){
        override val subRegisterXmm: XmmRegister get() = XmmRegister.XMM7
        override val subRegisterYmm: YmmRegister get() = YmmRegister.YMM7
    },
    ZMM8(8){
        override val subRegisterXmm: XmmRegister get() = XmmRegister.XMM8
        override val subRegisterYmm: YmmRegister get() = YmmRegister.YMM8
    },
    ZMM9(9){
        override val subRegisterXmm: XmmRegister get() = XmmRegister.XMM9
        override val subRegisterYmm: YmmRegister get() = YmmRegister.YMM9
    },
    ZMM10(10){
        override val subRegisterXmm: XmmRegister get() = XmmRegister.XMM10
        override val subRegisterYmm: YmmRegister get() = YmmRegister.YMM10
    },
    ZMM11(11){
        override val subRegisterXmm: XmmRegister get() = XmmRegister.XMM11
        override val subRegisterYmm: YmmRegister get() = YmmRegister.YMM11
    },
    ZMM12(12){
        override val subRegisterXmm: XmmRegister get() = XmmRegister.XMM12
        override val subRegisterYmm: YmmRegister get() = YmmRegister.YMM12
    },
    ZMM13(13){
        override val subRegisterXmm: XmmRegister get() = XmmRegister.XMM13
        override val subRegisterYmm: YmmRegister get() = YmmRegister.YMM13
    },
    ZMM14(14){
        override val subRegisterXmm: XmmRegister get() = XmmRegister.XMM14
        override val subRegisterYmm: YmmRegister get() = YmmRegister.YMM14
    },
    ZMM15(15){
        override val subRegisterXmm: XmmRegister get() = XmmRegister.XMM15
        override val subRegisterYmm: YmmRegister get() = YmmRegister.YMM15
    },
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

    open val subRegisterXmm: XmmRegister? = null
    open val subRegisterYmm: YmmRegister? = null

}

enum class RegisterType(val size: BitSize, val superRegisterType: RegisterType?, val topRegisterType: RegisterType?) {
    IP(BitSize.BITS_64, null, null),
    RFLAGS(BitSize.BITS_64, null, null),
    MXCSR(BitSize.BITS_32, null, null),
    GP64(BitSize.BITS_64, null, null),
    GP32(BitSize.BITS_32, GP64, GP64),
    GP16(BitSize.BITS_16, GP32, GP64),
    GP8(BitSize.BITS_8, GP16, GP64),
    MM(BitSize.BITS_64, null, null) {
        override val isVectorType = true
    },
    ZMM(BitSize.BITS_512, null, null) {
        override val isVectorType = true
    },
    YMM(BitSize.BITS_256, ZMM, ZMM) {
        override val isVectorType = true
    },
    XMM(BitSize.BITS_128, YMM, ZMM) {
        override val isVectorType = true
    },
    X87(BitSize.BITS_80, null, null)
    ;

    val isSubRegisterType get() = superRegisterType != null
    open val isVectorType = false
}

enum class VectorRegisterType(val size: BitSize, val alignment: Int) {
    MM(BitSize.BITS_64, 8),
    XMM(BitSize.BITS_128, 16),
    YMM(BitSize.BITS_256, 32),
    ZMM(BitSize.BITS_512, 32)

    ;

    val byteSize get() = size.toInt() / 8
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
    FEATURE_3DNOWEXT,
    FEATURE_3DNOW,
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
    PCX_L2I,
    UMIP,
    PKU,
    OSPKE,
    AVX512VBMI2,
    GFNI,
    VAES,
    VPCLMULQDQ,
    AVX512VNNI,
    AVX512BITALG,
    AVX512VPOPCNTDQ,
    MAWAU,
    RDPID,
    SGX_LC,
    AVX512_4VNNIW,
    AVX512_4FMAPS,

    ;
    companion object {
        val avx512Features = EnumSet.of(
                AVX512F, AVX512DQ, AVX512IFMA, AVX512PF, AVX512ER,
                AVX512CD, AVX512BW, AVX512VL, AVX512VBMI
                                       )
    }
}



