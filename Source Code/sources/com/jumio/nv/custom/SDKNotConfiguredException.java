package com.jumio.nv.custom;

public class SDKNotConfiguredException extends Exception {
    private static final long serialVersionUID = -7869139596313029534L;

    public SDKNotConfiguredException(String str) {
        super(str);
    }

    public SDKNotConfiguredException(Throwable th) {
        super(th);
    }

    public SDKNotConfiguredException(String str, Throwable th) {
        super(str, th);
    }
}
