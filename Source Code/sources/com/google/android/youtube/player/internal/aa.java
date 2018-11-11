package com.google.android.youtube.player.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;

public final class aa {
    private static final Uri LM = Uri.parse("http://play.google.com/store/apps/details");
    private static final String[] b = new String[]{"com.google.android.youtube", "com.google.android.youtube.tv", "com.google.android.youtube.googletv", "com.google.android.gms", null};

    public static String at(Context context) {
        PackageManager packageManager = context.getPackageManager();
        for (String str : b) {
            ResolveInfo resolveService = packageManager.resolveService(new Intent("com.google.android.youtube.api.service.START").setPackage(str), 0);
            if (resolveService != null && resolveService.serviceInfo != null && resolveService.serviceInfo.packageName != null) {
                return resolveService.serviceInfo.packageName;
            }
        }
        return packageManager.hasSystemFeature("android.software.leanback") ? "com.google.android.youtube.tv" : packageManager.hasSystemFeature("com.google.android.tv") ? "com.google.android.youtube.googletv" : "com.google.android.youtube";
    }

    public static Context au(Context context) {
        try {
            return context.createPackageContext(at(context), 3);
        } catch (NameNotFoundException unused) {
            return null;
        }
    }

    public static int av(Context context) {
        Context au = au(context);
        int identifier = au != null ? au.getResources().getIdentifier("clientTheme", "style", at(context)) : 0;
        if (identifier == 0) {
            if (VERSION.SDK_INT >= 14) {
                return 16974120;
            }
            if (VERSION.SDK_INT >= 11) {
                return 16973931;
            }
            identifier = 16973829;
        }
        return identifier;
    }

    public static String aw(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Throwable e) {
            throw new IllegalStateException("Cannot retrieve calling Context's PackageInfo", e);
        }
    }

    public static Intent cD(String str) {
        Uri fromParts = Uri.fromParts("package", str, null);
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(fromParts);
        return intent;
    }

    public static Intent cE(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(LM.buildUpon().appendQueryParameter("id", str).build());
        intent.setPackage("com.android.vending");
        intent.addFlags(524288);
        return intent;
    }

    public static boolean s(Context context, String str) {
        try {
            Resources resourcesForApplication = context.getPackageManager().getResourcesForApplication(str);
            if (str.equals("com.google.android.youtube.googletvdev")) {
                str = "com.google.android.youtube.googletv";
            }
            int identifier = resourcesForApplication.getIdentifier("youtube_api_version_code", "integer", str);
            return identifier == 0 || 12 > resourcesForApplication.getInteger(identifier) / 100;
        } catch (NameNotFoundException unused) {
            return true;
        }
    }
}
