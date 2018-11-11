package com.jumio.nv.data.templatematcher;

import com.jumio.nv.enums.NVErrorCase;

public class TemplateLoadingException extends Exception {
    private static final long serialVersionUID = 3430256624864688129L;
    private NVErrorCase mErrorCase;

    public TemplateLoadingException(String str) {
        super(str);
    }

    public TemplateLoadingException(Exception exception) {
        super(exception.getMessage());
        setStackTrace(exception.getStackTrace());
    }

    public TemplateLoadingException(NVErrorCase nVErrorCase) {
        this.mErrorCase = nVErrorCase;
    }

    public NVErrorCase getErrorCase() {
        return this.mErrorCase;
    }
}
