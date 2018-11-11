package com.facebook;

public class FacebookDialogException extends FacebookException {
    static final long serialVersionUID = 1;
    private int errorCode;
    private String failingUrl;

    public FacebookDialogException(String str, int i, String str2) {
        super(str);
        this.errorCode = i;
        this.failingUrl = str2;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String iQ() {
        return this.failingUrl;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{FacebookDialogException: ");
        stringBuilder.append("errorCode: ");
        stringBuilder.append(getErrorCode());
        stringBuilder.append(", message: ");
        stringBuilder.append(getMessage());
        stringBuilder.append(", url: ");
        stringBuilder.append(iQ());
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
