package com.google.android.gms.auth;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.RequiresPermission;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.UserRecoverableException;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.zzs;
import com.google.android.gms.internal.zzbhf;
import java.io.IOException;
import java.util.List;

@Hide
public class zzd {
    public static final int CHANGE_TYPE_ACCOUNT_ADDED = 1;
    public static final int CHANGE_TYPE_ACCOUNT_REMOVED = 2;
    public static final int CHANGE_TYPE_ACCOUNT_RENAMED_FROM = 3;
    public static final int CHANGE_TYPE_ACCOUNT_RENAMED_TO = 4;
    public static final String GOOGLE_ACCOUNT_TYPE = "com.google";
    @Hide
    @SuppressLint({"InlinedApi"})
    public static final String KEY_ANDROID_PACKAGE_NAME = "androidPackageName";
    @Hide
    @SuppressLint({"InlinedApi"})
    public static final String KEY_CALLER_UID = "callerUid";
    public static final String KEY_SUPPRESS_PROGRESS_SCREEN = "suppressProgressScreen";
    @Hide
    public static final String WORK_ACCOUNT_TYPE = "com.google.work";
    @Hide
    private static String[] zzehp = new String[]{"com.google", "com.google.work", "cn.google"};
    private static final ComponentName zzehq = new ComponentName("com.google.android.gms", "com.google.android.gms.auth.GetToken");
    private static final zzbhf zzehr = new zzbhf("Auth", "GoogleAuthUtil");

    zzd() {
    }

    public static void clearToken(Context context, String str) {
        zzbq.zzgw("Calling this from your main thread can lead to deadlock");
        zzbo(context);
        Bundle bundle = new Bundle();
        String str2 = context.getApplicationInfo().packageName;
        bundle.putString("clientPackageName", str2);
        if (!bundle.containsKey(KEY_ANDROID_PACKAGE_NAME)) {
            bundle.putString(KEY_ANDROID_PACKAGE_NAME, str2);
        }
        zza(context, zzehq, new zzf(str, bundle));
    }

    public static List<AccountChangeEvent> getAccountChangeEvents(Context context, int i, String str) {
        zzbq.zzh(str, "accountName must be provided");
        zzbq.zzgw("Calling this from your main thread can lead to deadlock");
        zzbo(context);
        return (List) zza(context, zzehq, new zzg(str, i));
    }

    public static String getAccountId(Context context, String str) {
        zzbq.zzh(str, "accountName must be provided");
        zzbq.zzgw("Calling this from your main thread can lead to deadlock");
        zzbo(context);
        return getToken(context, str, "^^_account_id_^^", new Bundle());
    }

    public static String getToken(Context context, Account account, String str) {
        return getToken(context, account, str, new Bundle());
    }

    public static String getToken(Context context, Account account, String str, Bundle bundle) {
        zzc(account);
        return zzb(context, account, str, bundle).getToken();
    }

    @Deprecated
    public static String getToken(Context context, String str, String str2) {
        return getToken(context, new Account(str, "com.google"), str2);
    }

    @Deprecated
    public static String getToken(Context context, String str, String str2, Bundle bundle) {
        return getToken(context, new Account(str, "com.google"), str2, bundle);
    }

    @RequiresPermission("android.permission.MANAGE_ACCOUNTS")
    @Deprecated
    public static void invalidateToken(Context context, String str) {
        AccountManager.get(context).invalidateAuthToken("com.google", str);
    }

    @Hide
    @TargetApi(23)
    public static Bundle removeAccount(Context context, Account account) {
        zzbq.checkNotNull(context);
        zzc(account);
        zzbo(context);
        return (Bundle) zza(context, zzehq, new zzh(account));
    }

    @TargetApi(26)
    public static Boolean requestGoogleAccountsAccess(Context context) {
        zzbq.checkNotNull(context);
        zzbo(context);
        return (Boolean) zza(context, zzehq, new zzi(context.getApplicationInfo().packageName));
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0021 A:{Splitter: B:2:0x0011, ExcHandler: android.os.RemoteException (r8_2 'e' java.lang.Throwable)} */
    /* JADX WARNING: Missing block: B:7:0x0021, code:
            r8 = move-exception;
     */
    /* JADX WARNING: Missing block: B:9:?, code:
            zzehr.zze("GoogleAuthUtil", "Error on service connection.", r8);
     */
    /* JADX WARNING: Missing block: B:10:0x003b, code:
            throw new java.io.IOException("Error on service connection.", r8);
     */
    private static <T> T zza(android.content.Context r6, android.content.ComponentName r7, com.google.android.gms.auth.zzj<T> r8) {
        /*
        r0 = new com.google.android.gms.common.zza;
        r0.<init>();
        r6 = com.google.android.gms.common.internal.zzag.zzcp(r6);
        r1 = "GoogleAuthUtil";
        r1 = r6.zza(r7, r0, r1);
        if (r1 == 0) goto L_0x0042;
    L_0x0011:
        r1 = r0.zzahd();	 Catch:{ RemoteException -> 0x0021, RemoteException -> 0x0021 }
        r8 = r8.zzac(r1);	 Catch:{ RemoteException -> 0x0021, RemoteException -> 0x0021 }
        r1 = "GoogleAuthUtil";
        r6.zzb(r7, r0, r1);
        return r8;
    L_0x001f:
        r8 = move-exception;
        goto L_0x003c;
    L_0x0021:
        r8 = move-exception;
        r1 = zzehr;	 Catch:{ all -> 0x001f }
        r2 = "GoogleAuthUtil";
        r3 = 2;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x001f }
        r4 = 0;
        r5 = "Error on service connection.";
        r3[r4] = r5;	 Catch:{ all -> 0x001f }
        r4 = 1;
        r3[r4] = r8;	 Catch:{ all -> 0x001f }
        r1.zze(r2, r3);	 Catch:{ all -> 0x001f }
        r1 = new java.io.IOException;	 Catch:{ all -> 0x001f }
        r2 = "Error on service connection.";
        r1.<init>(r2, r8);	 Catch:{ all -> 0x001f }
        throw r1;	 Catch:{ all -> 0x001f }
    L_0x003c:
        r1 = "GoogleAuthUtil";
        r6.zzb(r7, r0, r1);
        throw r8;
    L_0x0042:
        r6 = new java.io.IOException;
        r7 = "Could not bind to service.";
        r6.<init>(r7);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.zzd.zza(android.content.Context, android.content.ComponentName, com.google.android.gms.auth.zzj):T");
    }

    @Hide
    public static TokenData zzb(Context context, Account account, String str, Bundle bundle) {
        zzbq.zzgw("Calling this from your main thread can lead to deadlock");
        zzbq.zzh(str, "Scope cannot be empty or null.");
        zzc(account);
        zzbo(context);
        bundle = bundle == null ? new Bundle() : new Bundle(bundle);
        String str2 = context.getApplicationInfo().packageName;
        bundle.putString("clientPackageName", str2);
        if (TextUtils.isEmpty(bundle.getString(KEY_ANDROID_PACKAGE_NAME))) {
            bundle.putString(KEY_ANDROID_PACKAGE_NAME, str2);
        }
        bundle.putLong("service_connection_start_time_millis", SystemClock.elapsedRealtime());
        return (TokenData) zza(context, zzehq, new zze(account, str, bundle));
    }

    private static void zzbo(Context context) {
        try {
            zzs.zzbo(context.getApplicationContext());
        } catch (UserRecoverableException e) {
            throw new GooglePlayServicesAvailabilityException(e.getConnectionStatusCode(), e.getMessage(), e.getIntent());
        } catch (GooglePlayServicesNotAvailableException e2) {
            throw new GoogleAuthException(e2.getMessage());
        }
    }

    private static void zzc(Account account) {
        if (account == null) {
            throw new IllegalArgumentException("Account cannot be null");
        } else if (TextUtils.isEmpty(account.name)) {
            throw new IllegalArgumentException("Account name cannot be empty!");
        } else {
            String[] strArr = zzehp;
            int length = strArr.length;
            int i = 0;
            while (i < length) {
                if (!strArr[i].equals(account.type)) {
                    i++;
                } else {
                    return;
                }
            }
            throw new IllegalArgumentException("Account type not supported");
        }
    }

    private static <T> T zzp(T t) {
        if (t != null) {
            return t;
        }
        zzehr.zzf("GoogleAuthUtil", "Binder call returned null.");
        throw new IOException("Service unavailable.");
    }
}
