package com.jumio.analytics;

public class DispatchException extends Exception {
    public DispatchException(String str) {
        super(str);
    }

    public DispatchException(Exception exception) {
        super(exception);
    }
}
