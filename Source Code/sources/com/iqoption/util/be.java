package com.iqoption.util;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Looper;
import android.os.Process;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.google.android.gms.vision.barcode.BarcodeDetector.Builder;
import com.iqoption.app.IQApp;
import com.iqoption.app.af;
import com.iqoption.core.i;
import java.util.UUID;

/* compiled from: SystemUtils */
public class be {
    private static final String TAG = "com.iqoption.util.be";

    static String eb(int i) {
        return i <= 160 ? "mdpi" : i <= 240 ? "hdpi" : i <= 320 ? "xhdpi" : i <= 480 ? "xxhdpi" : "xxxhdpi";
    }

    public static String bi(Context context) {
        return eb(context.getResources().getDisplayMetrics().densityDpi);
    }

    public static String getDeviceId(Context context) {
        String deviceId = af.aR(context).getDeviceId();
        if (!TextUtils.isEmpty(deviceId)) {
            return deviceId;
        }
        deviceId = UUID.randomUUID().toString();
        af.aR(context).eB(deviceId);
        return deviceId;
    }

    public static boolean aGz() {
        return Looper.getMainLooper().equals(Looper.myLooper());
    }

    public static long aGA() {
        return (System.currentTimeMillis() << 20) | (System.nanoTime() & -9223372036854251521L);
    }

    public static void bS(Context context) {
        if (context != null) {
            Intent intent = new Intent();
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setData(Uri.fromParts("package", context.getPackageName(), null));
            intent.addFlags(268435456);
            intent.addFlags(1073741824);
            intent.addFlags(8388608);
            context.startActivity(intent);
        }
    }

    public static void l(Context context, Intent intent) {
        ((AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM)).set(1, System.currentTimeMillis() + 100, PendingIntent.getActivity(context, 123456, intent, 268435456));
        aGB();
    }

    public static void aGB() {
        Process.killProcess(Process.myPid());
    }

    public static void a(Context context, BroadcastReceiver broadcastReceiver) {
        try {
            context.unregisterReceiver(broadcastReceiver);
        } catch (Throwable e) {
            i.e(TAG, "unregisterReceiver error", e);
        }
    }

    public static String jP(String str) {
        if (str.endsWith("/")) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append('/');
        return stringBuilder.toString();
    }

    public static boolean aGC() {
        boolean z = false;
        try {
            if (Camera.getNumberOfCameras() > 0) {
                z = true;
            }
            return z;
        } catch (Throwable e) {
            i.e(TAG, "isCameraExist error", e);
            return false;
        }
    }

    public static boolean bT(Context context) {
        try {
            return new Builder(context).build().isOperational();
        } catch (Throwable e) {
            i.e(TAG, "isBarcodeApiAvailable error", e);
            return false;
        }
    }

    public static boolean a(Resources resources) {
        return resources.getConfiguration().orientation == 2;
    }

    public static boolean ag(String str, String str2) {
        ClipboardManager clipboardManager = (ClipboardManager) IQApp.Dk().getSystemService("clipboard");
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
}
