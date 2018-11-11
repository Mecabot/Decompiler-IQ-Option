package com.crashlytics.android.core;

import android.content.Context;
import android.content.pm.PackageInfo;
import io.fabric.sdk.android.services.common.IdManager;

/* compiled from: AppData */
class a {
    public final String installerPackageName;
    public final String packageName;
    public final String sO;
    public final String th;
    public final String tm;
    public final String versionName;

    public static a a(Context context, IdManager idManager, String str, String str2) {
        String packageName = context.getPackageName();
        String installerPackageName = idManager.getInstallerPackageName();
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
        return new a(str, str2, installerPackageName, packageName, Integer.toString(packageInfo.versionCode), packageInfo.versionName == null ? "0.0" : packageInfo.versionName);
    }

    a(String str, String str2, String str3, String str4, String str5, String str6) {
        this.sO = str;
        this.th = str2;
        this.installerPackageName = str3;
        this.packageName = str4;
        this.tm = str5;
        this.versionName = str6;
    }
}
