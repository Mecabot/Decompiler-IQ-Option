package com.google.android.gms.internal;

import android.accounts.Account;
import com.google.android.gms.common.api.Status;

final class zzavt extends zzavw {
    private /* synthetic */ zzavs zzeii;

    zzavt(zzavs zzavs) {
        this.zzeii = zzavs;
    }

    public final void zzd(Account account) {
        this.zzeii.setResult(new zzavx(account != null ? Status.zzftq : zzavq.zzeig, account));
    }
}
