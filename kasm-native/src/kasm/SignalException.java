package kasm;

public class SignalException extends Exception
{
    private final long address;

    public SignalException(long address) {
        this.address = address;
    }

    public long getAddress() {
        return address;
    }
}
