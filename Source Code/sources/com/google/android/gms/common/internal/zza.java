package com.google.android.gms.common.internal;

import android.accounts.Account;

@Hide
public final class zza extends zzao {
    /* JADX WARNING: Missing block: B:8:?, code:
            android.util.Log.w("AccountAccessor", "Remote account accessor probably died");
     */
    /* JADX WARNING: Missing block: B:9:0x0017, code:
            android.os.Binder.restoreCallingIdentity(r0);
     */
    /* JADX WARNING: Missing block: B:10:0x001b, code:
            android.os.Binder.restoreCallingIdentity(r0);
     */
    public static android.accounts.Account zza(com.google.android.gms.common.internal.zzan r3) {
        /*
        if (r3 == 0) goto L_0x001f;
    L_0x0002:
        r0 = android.os.Binder.clearCallingIdentity();
        r3 = r3.getAccount();	 Catch:{ RemoteException -> 0x0010 }
        android.os.Binder.restoreCallingIdentity(r0);
        return r3;
    L_0x000e:
        r3 = move-exception;
        goto L_0x001b;
    L_0x0010:
        r3 = "AccountAccessor";
        r2 = "Remote account accessor probably died";
        android.util.Log.w(r3, r2);	 Catch:{ all -> 0x000e }
        android.os.Binder.restoreCallingIdentity(r0);
        goto L_0x001f;
    L_0x001b:
        android.os.Binder.restoreCallingIdentity(r0);
        throw r3;
    L_0x001f:
        r3 = 0;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.zza.zza(com.google.android.gms.common.internal.zzan):android.accounts.Account");
    }

    public final boolean equals(Object obj) {
        throw new NoSuchMethodError();
    }

    public final Account getAccount() {
        throw new NoSuchMethodError();
    }
}
