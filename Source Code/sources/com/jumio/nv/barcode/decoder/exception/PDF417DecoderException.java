package com.jumio.nv.barcode.decoder.exception;

public class PDF417DecoderException extends Exception {
    private static final long serialVersionUID = 8205802214774364823L;

    public PDF417DecoderException(String str) {
        this(null, str);
    }

    public PDF417DecoderException(Exception exception, String str) {
        super(str);
        if (exception != null) {
            setStackTrace(exception.getStackTrace());
        }
    }

    public PDF417DecoderException(String str, Object... objArr) {
        this(null, str, objArr);
    }

    public PDF417DecoderException(Exception exception, String str, Object... objArr) {
        super(String.format(str, objArr));
        if (exception != null) {
            setStackTrace(exception.getStackTrace());
        }
    }
}
