package kasm;

public class SegmentationFaultException extends SignalException {

    public SegmentationFaultException(long address) {
        super(address);
    }

    @Override
    public String getMessage() {
        return "segmentation fault occurred at " + Long.toHexString(getAddress());
    }
}
