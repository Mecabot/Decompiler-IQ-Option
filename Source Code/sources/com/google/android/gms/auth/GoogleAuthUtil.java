package com.google.android.gms.auth;

import android.accounts.Account;
import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.RequiresPermission;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.zzs;
import java.net.URISyntaxException;
import java.util.List;

public final class GoogleAuthUtil extends zzd {
    public static final int CHANGE_TYPE_ACCOUNT_ADDED = 1;
    public static final int CHANGE_TYPE_ACCOUNT_REMOVED = 2;
    public static final int CHANGE_TYPE_ACCOUNT_RENAMED_FROM = 3;
    public static final int CHANGE_TYPE_ACCOUNT_RENAMED_TO = 4;
    public static final String GOOGLE_ACCOUNT_TYPE = "com.google";
    @Hide
    private static String KEY_ANDROID_PACKAGE_NAME = zzd.KEY_ANDROID_PACKAGE_NAME;
    @Hide
    private static String KEY_CALLER_UID = zzd.KEY_CALLER_UID;
    public static final String KEY_SUPPRESS_PROGRESS_SCREEN = "suppressProgressScreen";
    public static final String WORK_ACCOUNT_TYPE = "com.google.work";

    private GoogleAuthUtil() {
    }

    public static void clearToken(Context context, String str) {
        zzd.clearToken(context, str);
    }

    public static List<AccountChangeEvent> getAccountChangeEvents(Context context, int i, String str) {
        return zzd.getAccountChangeEvents(context, i, str);
    }

    public static String getAccountId(Context context, String str) {
        return zzd.getAccountId(context, str);
    }

    public static String getToken(Context context, Account account, String str) {
        return zzd.getToken(context, account, str);
    }

    public static String getToken(Context context, Account account, String str, Bundle bundle) {
        return zzd.getToken(context, account, str, bundle);
    }

    @Deprecated
    public static String getToken(Context context, String str, String str2) {
        return zzd.getToken(context, str, str2);
    }

    @Deprecated
    public static String getToken(Context context, String str, String str2, Bundle bundle) {
        return zzd.getToken(context, str, str2, bundle);
    }

    public static String getTokenWithNotification(Context context, Account account, String str, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putBoolean("handle_notification", true);
        return zza(context, account, str, bundle).getToken();
    }

    public static String getTokenWithNotification(Context context, Account account, String str, Bundle bundle, Intent intent) {
        if (intent == null) {
            throw new IllegalArgumentException("Callback cannot be null.");
        }
        try {
            Intent.parseUri(intent.toUri(1), 1);
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putParcelable("callback_intent", intent);
            bundle.putBoolean("handle_notification", true);
            return zza(context, account, str, bundle).getToken();
        } catch (URISyntaxException unused) {
            throw new IllegalArgumentException("Parameter callback contains invalid data. It must be serializable using toUri() and parseUri().");
        }
    }

    public static String getTokenWithNotification(Context context, Account account, String str, Bundle bundle, String str2, Bundle bundle2) {
        zzbq.zzh(str2, "Authority cannot be empty or null.");
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        ContentResolver.validateSyncExtrasBundle(bundle2);
        bundle.putString("authority", str2);
        bundle.putBundle("sync_extras", bundle2);
        bundle.putBoolean("handle_notification", true);
        return zza(context, account, str, bundle).getToken();
    }

    @Deprecated
    public static String getTokenWithNotification(Context context, String str, String str2, Bundle bundle) {
        return getTokenWithNotification(context, new Account(str, "com.google"), str2, bundle);
    }

    @Deprecated
    public static String getTokenWithNotification(Context context, String str, String str2, Bundle bundle, Intent intent) {
        return getTokenWithNotification(context, new Account(str, "com.google"), str2, bundle, intent);
    }

    @Deprecated
    public static String getTokenWithNotification(Context context, String str, String str2, Bundle bundle, String str3, Bundle bundle2) {
        return getTokenWithNotification(context, new Account(str, "com.google"), str2, bundle, str3, bundle2);
    }

    @RequiresPermission("android.permission.MANAGE_ACCOUNTS")
    @Deprecated
    public static void invalidateToken(Context context, String str) {
        zzd.invalidateToken(context, str);
    }

    @TargetApi(23)
    public static Bundle removeAccount(Context context, Account account) {
        return zzd.removeAccount(context, account);
    }

    @TargetApi(26)
    public static Boolean requestGoogleAccountsAccess(Context context) {
        return zzd.requestGoogleAccountsAccess(context);
    }

    private static TokenData zza(Context context, Account account, String str, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        try {
            TokenData zzb = zzd.zzb(context, account, str, bundle);
            zzs.zzcf(context);
            return zzb;
        } catch (Throwable e) {
            GooglePlayServicesUtil.showErrorNotification(e.getConnectionStatusCode(), context);
            Log.w("GoogleAuthUtil", "Error when getting token", e);
            throw new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.");
        } catch (Throwable e2) {
            zzs.zzcf(context);
            Log.w("GoogleAuthUtil", "Error when getting token", e2);
            throw new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.");
        }
    }
}
