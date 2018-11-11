package com.google.zxing;

public abstract class ReaderException extends Exception {
    protected static final boolean aaY = (System.getProperty("surefire.test.class.path") != null);
    protected static final StackTraceElement[] aaZ = new StackTraceElement[0];

    ReaderException() {
    }

    public final synchronized Throwable fillInStackTrace() {
        return null;
    }
}
