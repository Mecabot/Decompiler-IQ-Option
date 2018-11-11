package com.google.zxing;

public final class FormatException extends ReaderException {
    private static final FormatException aaW;

    static {
        FormatException formatException = new FormatException();
        aaW = formatException;
        formatException.setStackTrace(aaZ);
    }

    private FormatException() {
    }

    public static FormatException yt() {
        return aaY ? new FormatException() : aaW;
    }
}
