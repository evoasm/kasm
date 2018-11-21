package kasm.gen.x64

import kasm.x64.*
import java.util.EnumSet


sealed class Operand {
    abstract val name: String
    abstract val isImplicit: Boolean
    var parameterVariants: ParameterVariants = ParameterVariants(null, null)

    open val identifierName
        get() = name.toLowerCase().capitalize()

    abstract val isAlwaysWritten: Boolean
    abstract val isSometimesWritten: Boolean
    val isWritten get() = isAlwaysWritten || isSometimesWritten
    abstract val isRead: Boolean
    data class Parameter(val name: String, val type: String)
    data class ParameterVariants(var registerVariant: Parameter?, var memoryVariant: Parameter? = null)

}

interface SizedOperand {
    val size: BitSize
}

interface ImmediateOperand
interface RegisterOperand : SizedOperand {
    val type: RegisterType
}
interface MemoryOperand : SizedOperand
interface MemoryOrMemoryRegisterOperand {
    val memorySize : BitSize
}

abstract class ImplicitOperand : Operand() {
   override val isImplicit : Boolean get() = true
}

abstract class ExplicitOperand : Operand(), SizedOperand {
    override val isImplicit : Boolean get() = false
}

abstract class StatusOrControlRegisterOperand<T: Enum<T>> : ImplicitOperand() {
    abstract val readFields: EnumSet<T>
    abstract val alwaysWrittenFields: EnumSet<T>
    abstract val sometimesWrittenFields: EnumSet<T>

    override val isAlwaysWritten: Boolean
        get() = alwaysWrittenFields.isNotEmpty()
    override val isSometimesWritten: Boolean
        get() = !isAlwaysWritten && sometimesWrittenFields.isNotEmpty()
    override val isRead: Boolean
        get() = readFields.isNotEmpty()
}

data class RflagsOperand(override val readFields: EnumSet<RflagsField>, override val alwaysWrittenFields: EnumSet<RflagsField>, override val sometimesWrittenFields: EnumSet<RflagsField>) : StatusOrControlRegisterOperand<RflagsField>() {
    override val name = "RFLAGS"
}
data class MxcsrOperand(override val readFields: EnumSet<MxcsrField>, override val alwaysWrittenFields: EnumSet<MxcsrField>, override val sometimesWrittenFields: EnumSet<MxcsrField>) : StatusOrControlRegisterOperand<MxcsrField>() {
    override val name = "MXCSR"
}
data class X87StatusRegisterOperand(override val readFields: EnumSet<X87StatusField>, override val alwaysWrittenFields: EnumSet<X87StatusField>, override val sometimesWrittenFields: EnumSet<X87StatusField>) : StatusOrControlRegisterOperand<X87StatusField>() {
    override val name = "X87Status"
}
data class X87ControlRegisterOperand(override val readFields: EnumSet<X87ControlField>, override val alwaysWrittenFields: EnumSet<X87ControlField>, override val sometimesWrittenFields: EnumSet<X87ControlField>) : StatusOrControlRegisterOperand<X87ControlField>() {
    override val name = "X87Control"
}
data class X87TagRegisterOperand(override val readFields: EnumSet<X87TagField>, override val alwaysWrittenFields: EnumSet<X87TagField>, override val sometimesWrittenFields: EnumSet<X87TagField>) : StatusOrControlRegisterOperand<X87TagField>() {
    override val name = "X87Tag"
}

data class ExplicitRegisterOperand(override val size: BitSize,
                                   val readBits: BitRange?,
                                   val writtenBits: BitRange?,
                                   override val isAlwaysWritten: Boolean,
                                   override val isSometimesWritten: Boolean,
                                   override val isRead: Boolean,
                                   override val type: RegisterType,
                                   override val name: String) : ExplicitOperand(), RegisterOperand {

    override val identifierName = super.identifierName.replace("..", "To").split("\\[|\\]".toRegex()).joinToString("") { it.capitalize() }
}

data class ExplicitMemoryRegisterOperand(override val size: BitSize,
                                         override val memorySize: BitSize,
                                         val readMemoryBits: BitRange?,
                                         val readRegisterBits: BitRange?,
                                         val writtenMemoryBits: BitRange?,
                                         val writtenRegisterBits: BitRange?,
                                         override val isAlwaysWritten: Boolean,
                                         override val isSometimesWritten: Boolean,
                                         override val isRead: Boolean,
                                         override val type: RegisterType,
                                         override val name: String) : ExplicitOperand(), RegisterOperand, MemoryOrMemoryRegisterOperand {

    override val identifierName = super.identifierName.replace("/", "")
}

data class ExplicitMemoryOperand(override val size: BitSize,
                                 val readBits: BitRange?,
                                 val writtenBits: BitRange?,
                                 override val isAlwaysWritten: Boolean,
                                 override val isSometimesWritten: Boolean,
                                 override val isRead: Boolean,
                                 override val name: String) : ExplicitOperand(), MemoryOperand, MemoryOrMemoryRegisterOperand {
    override val memorySize: BitSize
        get() = size
}

data class ExplicitVectorMemoryOperand(override val size: BitSize,
                                       val readBits: BitRange?,
                                       val writtenBits: BitRange?,
                                       override val isAlwaysWritten: Boolean,
                                       override val isSometimesWritten: Boolean,
                                       override val isRead: Boolean,
                                       val indexRegisterType: RegisterType,
                                       override val name: String) : ExplicitOperand(), SizedOperand {
}

data class ImplicitRegisterOperand(override val size: BitSize,
                                   val readBits: BitRange?,
                                   val writtenBits: BitRange?,
                                   override val isAlwaysWritten: Boolean,
                                   override val isSometimesWritten: Boolean,
                                   override val isRead: Boolean,
                                   val register: Register,
                                   override val name: String) : ImplicitOperand(), RegisterOperand {
    override val type = register.type
}

data class ImplicitMemoryOperand(override val size: BitSize,
                                 val readBits: BitRange?,
                                 val writtenBits: BitRange?,
                                 override val isAlwaysWritten: Boolean,
                                 override val isSometimesWritten: Boolean,
                                 override val isRead: Boolean,
                                 val baseRegister: Register,
                                 val indexRegister: Register?,
                                 override val name: String) : ImplicitOperand(), MemoryOperand, MemoryOrMemoryRegisterOperand {
    override val identifierName = super.identifierName.split("\\[|\\]|\\s+\\+\\s+".toRegex()).joinToString("") { it.capitalize() }
    override val memorySize: BitSize get() = size
}

data class ExplicitImmediateOperand(override val size: BitSize,
                                    override val name: String,
                                    val isOffset: Boolean = false) : ExplicitOperand(), ImmediateOperand, SizedOperand {
    override val isAlwaysWritten = false
    override val isSometimesWritten = false
    override val isRead = true
}

data class ImplicitImmediateOperand(val value: Long) : ImplicitOperand(), ImmediateOperand {
    override val name = value.toString()

    override val isAlwaysWritten = false
    override val isSometimesWritten = false
    override val isRead = true
}


data class Rex(val mandatory: Boolean, val w: Int?, val optional: Boolean) {
}

data class Vex(val w: Int?, val m: Int, val l: Int?, val p: Int) {

}
