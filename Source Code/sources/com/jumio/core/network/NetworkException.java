package com.jumio.core.network;

public class NetworkException extends Exception {
    public NetworkException(Exception exception) {
        super(exception);
    }

    public NetworkException(String str) {
        super(str);
    }
}
