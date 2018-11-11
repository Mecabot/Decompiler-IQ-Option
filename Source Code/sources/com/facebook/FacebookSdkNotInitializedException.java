package com.facebook;

public class FacebookSdkNotInitializedException extends FacebookException {
    static final long serialVersionUID = 1;

    public FacebookSdkNotInitializedException(String str) {
        super(str);
    }
}
