package com.jumio.sdk.exception;

public class JumioException extends Exception {
    private int detailedErrorCase;
    private JumioErrorCase mErrorCase;

    @Deprecated
    public JumioException(String str) {
        super(str);
    }

    @Deprecated
    public JumioException(Exception exception) {
        super(exception.getMessage());
        setStackTrace(exception.getStackTrace());
    }

    public JumioException(JumioErrorCase jumioErrorCase) {
        this.mErrorCase = jumioErrorCase;
        this.detailedErrorCase = 0;
    }

    public JumioException(JumioErrorCase jumioErrorCase, int i) {
        this.mErrorCase = jumioErrorCase;
        this.detailedErrorCase = i;
    }

    public JumioErrorCase getErrorCase() {
        return this.mErrorCase;
    }

    public int getDetailedErrorCase() {
        return this.detailedErrorCase;
    }
}
