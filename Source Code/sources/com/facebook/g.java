package com.facebook;

/* compiled from: FacebookCallback */
public interface g<RESULT> {
    void b(FacebookException facebookException);

    void onCancel();

    void onSuccess(RESULT result);
}
