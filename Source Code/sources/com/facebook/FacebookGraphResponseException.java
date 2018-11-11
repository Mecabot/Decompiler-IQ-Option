package com.facebook;

public class FacebookGraphResponseException extends FacebookException {
    private final l graphResponse;

    public FacebookGraphResponseException(l lVar, String str) {
        super(str);
        this.graphResponse = lVar;
    }

    public final String toString() {
        FacebookRequestError jJ = this.graphResponse != null ? this.graphResponse.jJ() : null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{FacebookGraphResponseException: ");
        String message = getMessage();
        if (message != null) {
            stringBuilder.append(message);
            stringBuilder.append(" ");
        }
        if (jJ != null) {
            stringBuilder.append("httpResponseCode: ");
            stringBuilder.append(jJ.iR());
            stringBuilder.append(", facebookErrorCode: ");
            stringBuilder.append(jJ.getErrorCode());
            stringBuilder.append(", facebookErrorType: ");
            stringBuilder.append(jJ.iT());
            stringBuilder.append(", message: ");
            stringBuilder.append(jJ.getErrorMessage());
            stringBuilder.append("}");
        }
        return stringBuilder.toString();
    }
}
