package com.facebook.appevents.codeless.internal;

import android.util.Log;

/* compiled from: UnityReflection */
public class c {
    private static Class<?> Aj;
    private static final String TAG = c.class.getCanonicalName();

    public static void c(String str, String str2, String str3) {
        try {
            if (Aj == null) {
                Aj = Class.forName("com.unity3d.player.UnityPlayer");
            }
            Aj.getMethod("UnitySendMessage", new Class[]{String.class, String.class, String.class}).invoke(Aj, new Object[]{str, str2, str3});
        } catch (Throwable e) {
            Log.e(TAG, "Failed to send message to Unity", e);
        }
    }

    public static void kG() {
        c("UnityFacebookSDKPlugin", "CaptureViewHierarchy", "");
    }

    public static void bs(String str) {
        c("UnityFacebookSDKPlugin", "OnReceiveMapping", str);
    }
}
