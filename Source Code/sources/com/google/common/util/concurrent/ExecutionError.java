package com.google.common.util.concurrent;

public class ExecutionError extends Error {
    private static final long serialVersionUID = 0;

    protected ExecutionError() {
    }

    public ExecutionError(Error error) {
        super(error);
    }
}
