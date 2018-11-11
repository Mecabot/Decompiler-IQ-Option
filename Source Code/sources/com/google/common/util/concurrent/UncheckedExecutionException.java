package com.google.common.util.concurrent;

public class UncheckedExecutionException extends RuntimeException {
    private static final long serialVersionUID = 0;

    protected UncheckedExecutionException() {
    }

    public UncheckedExecutionException(Throwable th) {
        super(th);
    }
}
