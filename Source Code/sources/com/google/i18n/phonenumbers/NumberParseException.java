package com.google.i18n.phonenumbers;

public class NumberParseException extends Exception {
    private ErrorType errorType;
    private String message;

    public enum ErrorType {
        INVALID_COUNTRY_CODE,
        NOT_A_NUMBER,
        TOO_SHORT_AFTER_IDD,
        TOO_SHORT_NSN,
        TOO_LONG
    }

    public NumberParseException(ErrorType errorType, String str) {
        super(str);
        this.message = str;
        this.errorType = errorType;
    }

    public ErrorType xn() {
        return this.errorType;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Error type: ");
        stringBuilder.append(this.errorType);
        stringBuilder.append(". ");
        stringBuilder.append(this.message);
        return stringBuilder.toString();
    }
}
