package com.google.android.gms.auth.account;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApi.zza;
import com.google.android.gms.common.internal.zzbj;
import com.google.android.gms.internal.zzavq;
import com.google.android.gms.tasks.Task;

public class WorkAccountClient extends GoogleApi<NoOptions> {
    private final WorkAccountApi zzeif = new zzavq();

    WorkAccountClient(@NonNull Activity activity) {
        super(activity, WorkAccount.API, null, zza.zzfsr);
    }

    WorkAccountClient(@NonNull Context context) {
        super(context, WorkAccount.API, null, zza.zzfsr);
    }

    public Task<Account> addWorkAccount(String str) {
        return zzbj.zza(this.zzeif.addWorkAccount(zzahw(), str), new zzg(this));
    }

    public Task<Void> removeWorkAccount(Account account) {
        return zzbj.zzb(this.zzeif.removeWorkAccount(zzahw(), account));
    }

    public Task<Void> setWorkAuthenticatorEnabled(boolean z) {
        return zzbj.zzb(this.zzeif.setWorkAuthenticatorEnabledWithResult(zzahw(), z));
    }
}
