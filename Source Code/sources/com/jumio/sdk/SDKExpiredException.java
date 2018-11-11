package com.jumio.sdk;

public class SDKExpiredException extends Exception {
    private static final long serialVersionUID = -7869139596313029534L;

    public SDKExpiredException(String str) {
        super(str);
    }

    public SDKExpiredException(Throwable th) {
        super(th);
    }

    public SDKExpiredException(String str, Throwable th) {
        super(str, th);
    }
}
