package com.jumio.commons.remote.exception;

import java.io.IOException;

public class UnexpectedResponseException extends IOException {
    public static final int STATUS_CODE_OK = 200;
    public static final int STATUS_CODE_UNAUTHORIZED = 401;
    private static final long serialVersionUID = 8800114572597147148L;
    private String message = "";
    private int statusCode = 0;

    public UnexpectedResponseException(int i, String str) {
        this.statusCode = i;
        this.message = str;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public boolean isHttpUnauthorized() {
        return this.statusCode == STATUS_CODE_UNAUTHORIZED;
    }

    public boolean isHttpOk() {
        return this.statusCode == 200;
    }

    public String getMessage() {
        return this.message;
    }
}
