package com.iqoption.microservice.authorization;

import android.support.annotation.Nullable;

public class AuthException extends Exception {
    @Nullable
    public String email;
    @Nullable
    public String errorMessage;
    public boolean isTwoStepAuthScreen;
    @Nullable
    public String password;
    @Nullable
    public String phoneMask;
    public int status;

    public AuthException(int i) {
        this.status = i;
    }

    public AuthException(@Nullable String str, int i, @Nullable String str2, boolean z, @Nullable String str3, @Nullable String str4) {
        super(str);
        this.errorMessage = str;
        this.status = i;
        this.phoneMask = str2;
        this.isTwoStepAuthScreen = z;
        this.email = str3;
        this.password = str4;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AuthException{errorMessage='");
        stringBuilder.append(this.errorMessage);
        stringBuilder.append('\'');
        stringBuilder.append(", status=");
        stringBuilder.append(this.status);
        stringBuilder.append(", phoneMask='");
        stringBuilder.append(this.phoneMask);
        stringBuilder.append('\'');
        stringBuilder.append(", isTwoStepAuthScreen=");
        stringBuilder.append(this.isTwoStepAuthScreen);
        stringBuilder.append(", ");
        stringBuilder.append(this.email);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
