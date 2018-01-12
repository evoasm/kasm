package kasm

open class SignalException(val address: Long) : Exception()

class ZeroDivisionException(address: Long) : SignalException(address) {
    override val message: String?
        get() = "zero division occurred at ${address.toString(16)}"
}

class SegmentationFaultException(address: Long) : SignalException(address) {
    override val message: String?
        get() = "segmentation fault occurred at ${address.toString(16)}"
}

class IllegalInstructionException(address: Long) : SignalException(address) {
    override val message: String?
        get() = "illegal instruction at ${address.toString(16)}"
}
