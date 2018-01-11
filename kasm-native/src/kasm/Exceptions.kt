package kasm

open class SignalException(val address: Long) : Exception()

class ZeroDivisionException(address: Long) : SignalException(address)
class SegmentationFaultException(address: Long) : SignalException(address) {
    override val message: String?
        get() = "segmentation fault occoured at ${address.toString(16)}"
}
