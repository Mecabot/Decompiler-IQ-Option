package com.google.android.gms.auth.api.accounttransfer;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzf;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzawh;
import com.google.android.gms.internal.zzawi;

public final class AccountTransfer {
    public static final String ACTION_ACCOUNT_EXPORT_DATA_AVAILABLE = "com.google.android.gms.auth.ACCOUNT_EXPORT_DATA_AVAILABLE";
    public static final String ACTION_ACCOUNT_IMPORT_DATA_AVAILABLE = "com.google.android.gms.auth.ACCOUNT_IMPORT_DATA_AVAILABLE";
    public static final String ACTION_START_ACCOUNT_EXPORT = "com.google.android.gms.auth.START_ACCOUNT_EXPORT";
    private static final zzf<zzawi> zzeiz = new zzf();
    private static final zza<zzawi, zzn> zzeja = new zza();
    @Hide
    private static Api<zzn> zzejb = new Api("AccountTransfer.ACCOUNT_TRANSFER_API", zzeja, zzeiz);
    @Hide
    @Deprecated
    private static zzb zzejc = new zzawh();
    @Hide
    private static zzq zzejd = new zzawh();

    @Hide
    private AccountTransfer() {
    }

    public static AccountTransferClient getAccountTransferClient(@NonNull Activity activity) {
        return new AccountTransferClient(activity);
    }

    public static AccountTransferClient getAccountTransferClient(@NonNull Context context) {
        return new AccountTransferClient(context);
    }
}
