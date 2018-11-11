package com.google.android.gms.internal;

import android.accounts.Account;
import com.google.android.gms.auth.account.WorkAccountApi.AddAccountResult;
import com.google.android.gms.common.api.Status;

final class zzavx implements AddAccountResult {
    private final Status mStatus;
    private final Account zzeho;

    public zzavx(Status status, Account account) {
        this.mStatus = status;
        this.zzeho = account;
    }

    public final Account getAccount() {
        return this.zzeho;
    }

    public final Status getStatus() {
        return this.mStatus;
    }
}
