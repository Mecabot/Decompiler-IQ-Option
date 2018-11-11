package com.jumio.core.exceptions;

public class PlatformNotSupportedException extends Exception {
    private static final long serialVersionUID = 656729418726763588L;

    public PlatformNotSupportedException(String str) {
        super(str);
    }

    public PlatformNotSupportedException(Throwable th) {
        super(th);
    }

    public PlatformNotSupportedException(String str, Throwable th) {
        super(str, th);
    }
}
