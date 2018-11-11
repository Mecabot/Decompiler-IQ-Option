package com.facebook;

public class FacebookAuthorizationException extends FacebookException {
    static final long serialVersionUID = 1;

    public FacebookAuthorizationException(String str) {
        super(str);
    }
}
