package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import com.google.android.gms.R;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbf;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzj;
import com.google.android.gms.common.util.zzz;
import com.google.android.gms.internal.zzbih;
import java.util.concurrent.atomic.AtomicBoolean;

@Hide
public class zzs {
    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = 12211000;
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
    @Hide
    private static boolean zzfrr = false;
    @Hide
    private static boolean zzfrs = false;
    private static boolean zzfrt = false;
    private static boolean zzfru = false;
    static final AtomicBoolean zzfrv = new AtomicBoolean();
    private static final AtomicBoolean zzfrw = new AtomicBoolean();

    zzs() {
    }

    @Deprecated
    public static PendingIntent getErrorPendingIntent(int i, Context context, int i2) {
        return zzf.zzahf().getErrorResolutionPendingIntent(context, i, i2);
    }

    @Deprecated
    public static String getErrorString(int i) {
        return ConnectionResult.getStatusString(i);
    }

    public static Context getRemoteContext(Context context) {
        try {
            return context.createPackageContext("com.google.android.gms", 3);
        } catch (NameNotFoundException unused) {
            return null;
        }
    }

    public static Resources getRemoteResource(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        } catch (NameNotFoundException unused) {
            return null;
        }
    }

    @Deprecated
    public static int isGooglePlayServicesAvailable(Context context) {
        return zzc(context, -1);
    }

    @Deprecated
    public static boolean isUserRecoverableError(int i) {
        if (i != 9) {
            switch (i) {
                case 1:
                case 2:
                case 3:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    private static int zza(Context context, boolean z, int i, int i2) {
        String str;
        String str2;
        boolean z2 = i2 == -1 || i2 >= 0;
        zzbq.checkArgument(z2);
        PackageManager packageManager = context.getPackageManager();
        PackageInfo packageInfo = null;
        if (z) {
            try {
                packageInfo = packageManager.getPackageInfo("com.android.vending", 8256);
            } catch (NameNotFoundException unused) {
                str = "GooglePlayServicesUtil";
                str2 = "Google Play Store is missing.";
            }
        }
        try {
            PackageInfo packageInfo2 = packageManager.getPackageInfo("com.google.android.gms", 64);
            zzt.zzcj(context);
            if (!zzt.zza(packageInfo2, true)) {
                str = "GooglePlayServicesUtil";
                str2 = "Google Play services signature invalid.";
            } else if (!z || (zzt.zza(packageInfo, true) && packageInfo.signatures[0].equals(packageInfo2.signatures[0]))) {
                int i3 = packageInfo2.versionCode / 1000;
                if (i3 >= i / 1000 || (i2 != -1 && i3 >= i2 / 1000)) {
                    ApplicationInfo applicationInfo = packageInfo2.applicationInfo;
                    if (applicationInfo == null) {
                        try {
                            applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                        } catch (Throwable e) {
                            Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.", e);
                            return 1;
                        }
                    }
                    return !applicationInfo.enabled ? 3 : 0;
                } else {
                    int i4 = GOOGLE_PLAY_SERVICES_VERSION_CODE;
                    i = packageInfo2.versionCode;
                    StringBuilder stringBuilder = new StringBuilder(77);
                    stringBuilder.append("Google Play services out of date.  Requires ");
                    stringBuilder.append(i4);
                    stringBuilder.append(" but found ");
                    stringBuilder.append(i);
                    Log.w("GooglePlayServicesUtil", stringBuilder.toString());
                    return 2;
                }
            } else {
                str = "GooglePlayServicesUtil";
                str2 = "Google Play Store signature invalid.";
            }
            Log.w(str, str2);
            return 9;
        } catch (NameNotFoundException unused2) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 1;
        }
    }

    @Hide
    @TargetApi(19)
    @Deprecated
    public static boolean zzb(Context context, int i, String str) {
        return zzz.zzb(context, i, str);
    }

    @Hide
    @Deprecated
    public static void zzbo(Context context) {
        zzf.zzahf();
        int zzc = zzf.zzc(context, -1);
        if (zzc != 0) {
            zzf.zzahf();
            Intent zza = zzf.zza(context, zzc, "e");
            StringBuilder stringBuilder = new StringBuilder(57);
            stringBuilder.append("GooglePlayServices not available due to error ");
            stringBuilder.append(zzc);
            Log.e("GooglePlayServicesUtil", stringBuilder.toString());
            if (zza == null) {
                throw new GooglePlayServicesNotAvailableException(zzc);
            }
            throw new GooglePlayServicesRepairableException(zzc, "Google Play Services not available", zza);
        }
    }

    @Deprecated
    public static int zzc(Context context, int i) {
        try {
            context.getResources().getString(R.string.common_google_play_services_unknown_issue);
        } catch (Throwable unused) {
            Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        if (!("com.google.android.gms".equals(context.getPackageName()) || zzfrw.get())) {
            int zzcs = zzbf.zzcs(context);
            if (zzcs == 0) {
                throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
            } else if (zzcs != GOOGLE_PLAY_SERVICES_VERSION_CODE) {
                i = GOOGLE_PLAY_SERVICES_VERSION_CODE;
                StringBuilder stringBuilder = new StringBuilder(320);
                stringBuilder.append("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected ");
                stringBuilder.append(i);
                stringBuilder.append(" but found ");
                stringBuilder.append(zzcs);
                stringBuilder.append(".  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
                throw new IllegalStateException(stringBuilder.toString());
            }
        }
        boolean z = (zzj.zzcv(context) || zzj.zzcx(context)) ? false : true;
        return zza(context, z, GOOGLE_PLAY_SERVICES_VERSION_CODE, i);
    }

    @Hide
    @Deprecated
    public static void zzcf(Context context) {
        if (!zzfrv.getAndSet(true)) {
            try {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                if (notificationManager != null) {
                    notificationManager.cancel(10436);
                }
            } catch (SecurityException unused) {
            }
        }
    }

    @Hide
    @Deprecated
    public static int zzcg(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        } catch (NameNotFoundException unused) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 0;
        }
    }

    @Hide
    public static boolean zzci(Context context) {
        if (!zzfru) {
            try {
                PackageInfo packageInfo = zzbih.zzdd(context).getPackageInfo("com.google.android.gms", 64);
                zzt.zzcj(context);
                if (packageInfo == null || zzt.zza(packageInfo, false) || !zzt.zza(packageInfo, true)) {
                    zzfrt = false;
                } else {
                    zzfrt = true;
                }
            } catch (Throwable e) {
                Log.w("GooglePlayServicesUtil", "Cannot find Google Play services package name.", e);
            } catch (Throwable th) {
                zzfru = true;
            }
            zzfru = true;
        }
        return zzfrt || !"user".equals(Build.TYPE);
    }

    @Hide
    @Deprecated
    public static boolean zzd(Context context, int i) {
        return i == 18 ? true : i == 1 ? zzr(context, "com.google.android.gms") : false;
    }

    @Hide
    @Deprecated
    public static boolean zze(Context context, int i) {
        return zzz.zze(context, i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0075 A:{RETURN, Splitter: B:12:0x003c, ExcHandler: android.content.pm.PackageManager.NameNotFoundException (unused android.content.pm.PackageManager$NameNotFoundException)} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0074 A:{RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0075 A:{RETURN, Splitter: B:12:0x003c, ExcHandler: android.content.pm.PackageManager.NameNotFoundException (unused android.content.pm.PackageManager$NameNotFoundException)} */
    @android.annotation.TargetApi(21)
    static boolean zzr(android.content.Context r5, java.lang.String r6) {
        /*
        r0 = "com.google.android.gms";
        r0 = r6.equals(r0);
        r1 = com.google.android.gms.common.util.zzs.zzanx();
        r2 = 1;
        r3 = 0;
        if (r1 == 0) goto L_0x0036;
    L_0x000e:
        r1 = r5.getPackageManager();	 Catch:{ Exception -> 0x0035 }
        r1 = r1.getPackageInstaller();	 Catch:{ Exception -> 0x0035 }
        r1 = r1.getAllSessions();	 Catch:{ Exception -> 0x0035 }
        r1 = r1.iterator();
    L_0x001e:
        r4 = r1.hasNext();
        if (r4 == 0) goto L_0x0036;
    L_0x0024:
        r4 = r1.next();
        r4 = (android.content.pm.PackageInstaller.SessionInfo) r4;
        r4 = r4.getAppPackageName();
        r4 = r6.equals(r4);
        if (r4 == 0) goto L_0x001e;
    L_0x0034:
        return r2;
    L_0x0035:
        return r3;
    L_0x0036:
        r1 = r5.getPackageManager();
        r4 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r6 = r1.getApplicationInfo(r6, r4);	 Catch:{ NameNotFoundException -> 0x0075 }
        if (r0 == 0) goto L_0x0045;
    L_0x0042:
        r5 = r6.enabled;	 Catch:{ NameNotFoundException -> 0x0075 }
        return r5;
    L_0x0045:
        r6 = r6.enabled;	 Catch:{ NameNotFoundException -> 0x0075 }
        if (r6 == 0) goto L_0x0075;
    L_0x0049:
        r6 = com.google.android.gms.common.util.zzs.zzanu();	 Catch:{ NameNotFoundException -> 0x0075 }
        if (r6 == 0) goto L_0x0071;
    L_0x004f:
        r6 = "user";
        r6 = r5.getSystemService(r6);	 Catch:{ NameNotFoundException -> 0x0075 }
        r6 = (android.os.UserManager) r6;	 Catch:{ NameNotFoundException -> 0x0075 }
        r5 = r5.getPackageName();	 Catch:{ NameNotFoundException -> 0x0075 }
        r5 = r6.getApplicationRestrictions(r5);	 Catch:{ NameNotFoundException -> 0x0075 }
        if (r5 == 0) goto L_0x0071;
    L_0x0061:
        r6 = "true";
        r0 = "restricted_profile";
        r5 = r5.getString(r0);	 Catch:{ NameNotFoundException -> 0x0075 }
        r5 = r6.equals(r5);	 Catch:{ NameNotFoundException -> 0x0075 }
        if (r5 == 0) goto L_0x0071;
    L_0x006f:
        r5 = 1;
        goto L_0x0072;
    L_0x0071:
        r5 = 0;
    L_0x0072:
        if (r5 != 0) goto L_0x0075;
    L_0x0074:
        return r2;
    L_0x0075:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.zzs.zzr(android.content.Context, java.lang.String):boolean");
    }
}
