package com.iqoption.quiz.api.response;

import com.google.gson.annotations.SerializedName;

/* compiled from: UserEmail */
public class n {
    @SerializedName("referral_code")
    private final String dit;
    @SerializedName("email")
    private final String email;

    public n(String str, String str2) {
        this.email = str;
        this.dit = str2;
    }
}
