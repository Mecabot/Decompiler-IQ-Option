package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.SimpleArrayMap;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.R;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.util.zzj;

public final class zzu {
    private static final SimpleArrayMap<String, String> zzgfv = new SimpleArrayMap();

    /* JADX WARNING: Removed duplicated region for block: B:4:0x0011 A:{Splitter: B:1:0x0004, ExcHandler: android.content.pm.PackageManager.NameNotFoundException (unused android.content.pm.PackageManager$NameNotFoundException)} */
    /* JADX WARNING: Missing block: B:4:0x0011, code:
            r2 = r2.getApplicationInfo().name;
     */
    /* JADX WARNING: Missing block: B:5:0x001b, code:
            if (android.text.TextUtils.isEmpty(r2) != false) goto L_0x001d;
     */
    /* JADX WARNING: Missing block: B:6:0x001d, code:
            return r0;
     */
    /* JADX WARNING: Missing block: B:7:0x001e, code:
            return r2;
     */
    private static java.lang.String zzcn(android.content.Context r2) {
        /*
        r0 = r2.getPackageName();
        r1 = com.google.android.gms.internal.zzbih.zzdd(r2);	 Catch:{ NameNotFoundException -> 0x0011, NameNotFoundException -> 0x0011 }
        r1 = r1.zzhc(r0);	 Catch:{ NameNotFoundException -> 0x0011, NameNotFoundException -> 0x0011 }
        r1 = r1.toString();	 Catch:{ NameNotFoundException -> 0x0011, NameNotFoundException -> 0x0011 }
        return r1;
    L_0x0011:
        r2 = r2.getApplicationInfo();
        r2 = r2.name;
        r1 = android.text.TextUtils.isEmpty(r2);
        if (r1 == 0) goto L_0x001e;
    L_0x001d:
        return r0;
    L_0x001e:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.zzu.zzcn(android.content.Context):java.lang.String");
    }

    public static String zzco(Context context) {
        return context.getResources().getString(R.string.common_google_play_services_notification_channel_name);
    }

    /* JADX WARNING: Missing block: B:6:0x0024, code:
            android.util.Log.e(r3, r4);
     */
    /* JADX WARNING: Missing block: B:7:0x0027, code:
            return null;
     */
    /* JADX WARNING: Missing block: B:19:0x006b, code:
            return null;
     */
    @android.support.annotation.Nullable
    public static java.lang.String zzf(android.content.Context r3, int r4) {
        /*
        r0 = r3.getResources();
        r1 = 20;
        if (r4 == r1) goto L_0x0081;
    L_0x0008:
        r1 = 0;
        switch(r4) {
            case 1: goto L_0x007a;
            case 2: goto L_0x0073;
            case 3: goto L_0x006c;
            case 4: goto L_0x006b;
            case 5: goto L_0x005d;
            case 6: goto L_0x006b;
            case 7: goto L_0x004f;
            case 8: goto L_0x004a;
            case 9: goto L_0x0045;
            case 10: goto L_0x0040;
            case 11: goto L_0x003b;
            default: goto L_0x000c;
        };
    L_0x000c:
        switch(r4) {
            case 16: goto L_0x0036;
            case 17: goto L_0x0028;
            case 18: goto L_0x006b;
            default: goto L_0x000f;
        };
    L_0x000f:
        r3 = "GoogleApiAvailability";
        r0 = 33;
        r2 = new java.lang.StringBuilder;
        r2.<init>(r0);
        r0 = "Unexpected error code ";
        r2.append(r0);
        r2.append(r4);
        r4 = r2.toString();
    L_0x0024:
        android.util.Log.e(r3, r4);
        return r1;
    L_0x0028:
        r4 = "GoogleApiAvailability";
        r0 = "The specified account could not be signed in.";
        android.util.Log.e(r4, r0);
        r4 = "common_google_play_services_sign_in_failed_title";
        r3 = zzs(r3, r4);
        return r3;
    L_0x0036:
        r3 = "GoogleApiAvailability";
        r4 = "One of the API components you attempted to connect to is not available.";
        goto L_0x0024;
    L_0x003b:
        r3 = "GoogleApiAvailability";
        r4 = "The application is not licensed to the user.";
        goto L_0x0024;
    L_0x0040:
        r3 = "GoogleApiAvailability";
        r4 = "Developer error occurred. Please see logs for detailed information";
        goto L_0x0024;
    L_0x0045:
        r3 = "GoogleApiAvailability";
        r4 = "Google Play services is invalid. Cannot recover.";
        goto L_0x0024;
    L_0x004a:
        r3 = "GoogleApiAvailability";
        r4 = "Internal error occurred. Please see logs for detailed information";
        goto L_0x0024;
    L_0x004f:
        r4 = "GoogleApiAvailability";
        r0 = "Network error occurred. Please retry request later.";
        android.util.Log.e(r4, r0);
        r4 = "common_google_play_services_network_error_title";
        r3 = zzs(r3, r4);
        return r3;
    L_0x005d:
        r4 = "GoogleApiAvailability";
        r0 = "An invalid account was specified when connecting. Please provide a valid account.";
        android.util.Log.e(r4, r0);
        r4 = "common_google_play_services_invalid_account_title";
        r3 = zzs(r3, r4);
        return r3;
    L_0x006b:
        return r1;
    L_0x006c:
        r3 = com.google.android.gms.R.string.common_google_play_services_enable_title;
        r3 = r0.getString(r3);
        return r3;
    L_0x0073:
        r3 = com.google.android.gms.R.string.common_google_play_services_update_title;
        r3 = r0.getString(r3);
        return r3;
    L_0x007a:
        r3 = com.google.android.gms.R.string.common_google_play_services_install_title;
        r3 = r0.getString(r3);
        return r3;
    L_0x0081:
        r4 = "GoogleApiAvailability";
        r0 = "The current user profile is restricted and could not use authenticated features.";
        android.util.Log.e(r4, r0);
        r4 = "common_google_play_services_restricted_profile_title";
        r3 = zzs(r3, r4);
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.zzu.zzf(android.content.Context, int):java.lang.String");
    }

    @NonNull
    public static String zzg(Context context, int i) {
        String zzs = i == 6 ? zzs(context, "common_google_play_services_resolution_required_title") : zzf(context, i);
        return zzs == null ? context.getResources().getString(R.string.common_google_play_services_notification_ticker) : zzs;
    }

    @NonNull
    public static String zzh(Context context, int i) {
        Resources resources = context.getResources();
        String zzcn = zzcn(context);
        if (i == 5) {
            return zzl(context, "common_google_play_services_invalid_account_text", zzcn);
        }
        if (i == 7) {
            return zzl(context, "common_google_play_services_network_error_text", zzcn);
        }
        if (i == 9) {
            return resources.getString(R.string.common_google_play_services_unsupported_text, new Object[]{zzcn});
        } else if (i == 20) {
            return zzl(context, "common_google_play_services_restricted_profile_text", zzcn);
        } else {
            switch (i) {
                case 1:
                    return resources.getString(R.string.common_google_play_services_install_text, new Object[]{zzcn});
                case 2:
                    if (zzj.zzcv(context)) {
                        return resources.getString(R.string.common_google_play_services_wear_update_text);
                    }
                    return resources.getString(R.string.common_google_play_services_update_text, new Object[]{zzcn});
                case 3:
                    return resources.getString(R.string.common_google_play_services_enable_text, new Object[]{zzcn});
                default:
                    switch (i) {
                        case 16:
                            return zzl(context, "common_google_play_services_api_unavailable_text", zzcn);
                        case 17:
                            return zzl(context, "common_google_play_services_sign_in_failed_text", zzcn);
                        case 18:
                            return resources.getString(R.string.common_google_play_services_updating_text, new Object[]{zzcn});
                        default:
                            return resources.getString(R.string.common_google_play_services_unknown_issue, new Object[]{zzcn});
                    }
            }
        }
    }

    @NonNull
    public static String zzi(Context context, int i) {
        return i == 6 ? zzl(context, "common_google_play_services_resolution_required_text", zzcn(context)) : zzh(context, i);
    }

    @NonNull
    public static String zzj(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                i = R.string.common_google_play_services_install_button;
                break;
            case 2:
                i = R.string.common_google_play_services_update_button;
                break;
            case 3:
                i = R.string.common_google_play_services_enable_button;
                break;
            default:
                i = 17039370;
                break;
        }
        return resources.getString(i);
    }

    private static String zzl(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String zzs = zzs(context, str);
        if (zzs == null) {
            zzs = resources.getString(R.string.common_google_play_services_unknown_issue);
        }
        return String.format(resources.getConfiguration().locale, zzs, new Object[]{str2});
    }

    @Nullable
    private static String zzs(Context context, String str) {
        synchronized (zzgfv) {
            String str2 = (String) zzgfv.get(str);
            if (str2 != null) {
                return str2;
            }
            Resources remoteResource = GooglePlayServicesUtil.getRemoteResource(context);
            if (remoteResource == null) {
                return null;
            }
            int identifier = remoteResource.getIdentifier(str, "string", "com.google.android.gms");
            String str3;
            String str4;
            if (identifier == 0) {
                str3 = "GoogleApiAvailability";
                str4 = "Missing resource: ";
                str = String.valueOf(str);
                Log.w(str3, str.length() != 0 ? str4.concat(str) : new String(str4));
                return null;
            }
            Object string = remoteResource.getString(identifier);
            if (TextUtils.isEmpty(string)) {
                str3 = "GoogleApiAvailability";
                str4 = "Got empty resource: ";
                str = String.valueOf(str);
                Log.w(str3, str.length() != 0 ? str4.concat(str) : new String(str4));
                return null;
            }
            zzgfv.put(str, string);
            return string;
        }
    }
}
