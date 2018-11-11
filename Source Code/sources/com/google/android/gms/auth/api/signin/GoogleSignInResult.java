package com.google.android.gms.auth.api.signin;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Hide;

public class GoogleSignInResult implements Result {
    private Status mStatus;
    private GoogleSignInAccount zzenj;

    @Hide
    public GoogleSignInResult(@Nullable GoogleSignInAccount googleSignInAccount, @NonNull Status status) {
        this.zzenj = googleSignInAccount;
        this.mStatus = status;
    }

    @Nullable
    /* renamed from: getSignInAccount */
    public GoogleSignInAccount zzb() {
        return this.zzenj;
    }

    @NonNull
    public Status getStatus() {
        return this.mStatus;
    }

    public boolean isSuccess() {
        return this.mStatus.isSuccess();
    }
}
