package com.iqoption.core.util;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Resources;
import com.iqoption.core.f;
import com.iqoption.core.i;

/* compiled from: SystemUtils */
public class q {
    private static final String TAG = "com.iqoption.core.util.q";

    static String eb(int i) {
        return i <= 160 ? "mdpi" : i <= 240 ? "hdpi" : i <= 320 ? "xhdpi" : i <= 480 ? "xxhdpi" : "xxxhdpi";
    }

    public static String bi(Context context) {
        return eb(context.getResources().getDisplayMetrics().densityDpi);
    }

    public static boolean bj(Context context) {
        return a(context.getResources());
    }

    public static boolean a(Resources resources) {
        return resources.getConfiguration().orientation == 2;
    }

    public static boolean ag(String str, String str2) {
        ClipboardManager clipboardManager = (ClipboardManager) f.RR().getSystemService("clipboard");
        if (clipboardManager == null) {
            return false;
        }
        try {
            clipboardManager.setPrimaryClip(ClipData.newPlainText(str, str2));
            return true;
        } catch (Throwable th) {
            i.w(TAG, th.getMessage(), th);
            return false;
        }
    }

    public static String br(Object obj) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(obj.getClass().getName());
        stringBuilder.append("@");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(obj)));
        return stringBuilder.toString();
    }
}
