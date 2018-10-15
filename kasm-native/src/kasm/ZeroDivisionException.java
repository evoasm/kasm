package kasm;

public class ZeroDivisionException extends SignalException {

    public ZeroDivisionException(long address) {
        super(address);
    }

    @Override
    public String getMessage() {
        return "zero division occurred at " + Long.toHexString(getAddress());
    }
}
