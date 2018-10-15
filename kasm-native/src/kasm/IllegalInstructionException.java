package kasm;

public class IllegalInstructionException extends SignalException {

    public IllegalInstructionException(long address) {
        super(address);
    }

    @Override
    public String getMessage() {
        return "illegal instruction at " + Long.toHexString(getAddress());
    }
}
