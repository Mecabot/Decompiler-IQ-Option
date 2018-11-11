package com.google.firebase.messaging;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Color;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Log;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;

final class c {
    private static c Zq;
    private Method Zr;
    private Method Zs;
    private final AtomicInteger Zt = new AtomicInteger((int) SystemClock.elapsedRealtime());
    private final Context mContext;
    private Bundle zzgco;

    private c(Context context) {
        this.mContext = context.getApplicationContext();
    }

    static boolean O(Bundle bundle) {
        return "1".equals(e(bundle, "gcm.n.e")) || e(bundle, "gcm.n.icon") != null;
    }

    @Nullable
    static Uri P(@NonNull Bundle bundle) {
        Object e = e(bundle, "gcm.n.link_android");
        if (TextUtils.isEmpty(e)) {
            e = e(bundle, "gcm.n.link");
        }
        return !TextUtils.isEmpty(e) ? Uri.parse(e) : null;
    }

    static String R(Bundle bundle) {
        Object e = e(bundle, "gcm.n.sound2");
        return TextUtils.isEmpty(e) ? e(bundle, "gcm.n.sound") : e;
    }

    private final PendingIntent S(Bundle bundle) {
        Intent intent;
        Object e = e(bundle, "gcm.n.click_action");
        if (TextUtils.isEmpty(e)) {
            Uri P = P(bundle);
            if (P != null) {
                intent = new Intent("android.intent.action.VIEW");
                intent.setPackage(this.mContext.getPackageName());
                intent.setData(P);
            } else {
                intent = this.mContext.getPackageManager().getLaunchIntentForPackage(this.mContext.getPackageName());
                if (intent == null) {
                    Log.w("FirebaseMessaging", "No activity found to launch app");
                }
            }
        } else {
            intent = new Intent(e);
            intent.setPackage(this.mContext.getPackageName());
            intent.setFlags(268435456);
        }
        if (intent == null) {
            return null;
        }
        intent.addFlags(67108864);
        Bundle bundle2 = new Bundle(bundle);
        FirebaseMessagingService.M(bundle2);
        intent.putExtras(bundle2);
        for (String str : bundle2.keySet()) {
            if (str.startsWith("gcm.n.") || str.startsWith("gcm.notification.")) {
                intent.removeExtra(str);
            }
        }
        return PendingIntent.getActivity(this.mContext, this.Zt.incrementAndGet(), intent, 1073741824);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0077 A:{Splitter: B:24:0x006c, ExcHandler: java.lang.IllegalAccessException (r3_14 'e' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0077 A:{Splitter: B:24:0x006c, ExcHandler: java.lang.IllegalAccessException (r3_14 'e' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0077 A:{Splitter: B:24:0x006c, ExcHandler: java.lang.IllegalAccessException (r3_14 'e' java.lang.Throwable)} */
    /* JADX WARNING: Missing block: B:26:0x0077, code:
            r3 = move-exception;
     */
    /* JADX WARNING: Missing block: B:27:0x0078, code:
            android.util.Log.e("FirebaseMessaging", "Error while setting the notification channel", r3);
     */
    @android.annotation.TargetApi(26)
    private final android.app.Notification a(java.lang.CharSequence r3, java.lang.String r4, int r5, java.lang.Integer r6, android.net.Uri r7, android.app.PendingIntent r8, android.app.PendingIntent r9, java.lang.String r10) {
        /*
        r2 = this;
        r0 = new android.app.Notification$Builder;
        r1 = r2.mContext;
        r0.<init>(r1);
        r1 = 1;
        r0 = r0.setAutoCancel(r1);
        r5 = r0.setSmallIcon(r5);
        r0 = android.text.TextUtils.isEmpty(r3);
        if (r0 != 0) goto L_0x0019;
    L_0x0016:
        r5.setContentTitle(r3);
    L_0x0019:
        r3 = android.text.TextUtils.isEmpty(r4);
        if (r3 != 0) goto L_0x002e;
    L_0x001f:
        r5.setContentText(r4);
        r3 = new android.app.Notification$BigTextStyle;
        r3.<init>();
        r3 = r3.bigText(r4);
        r5.setStyle(r3);
    L_0x002e:
        if (r6 == 0) goto L_0x0037;
    L_0x0030:
        r3 = r6.intValue();
        r5.setColor(r3);
    L_0x0037:
        if (r7 == 0) goto L_0x003c;
    L_0x0039:
        r5.setSound(r7);
    L_0x003c:
        if (r8 == 0) goto L_0x0041;
    L_0x003e:
        r5.setContentIntent(r8);
    L_0x0041:
        if (r9 == 0) goto L_0x0046;
    L_0x0043:
        r5.setDeleteIntent(r9);
    L_0x0046:
        if (r10 == 0) goto L_0x007f;
    L_0x0048:
        r3 = r2.Zr;
        if (r3 != 0) goto L_0x0054;
    L_0x004c:
        r3 = "setChannelId";
        r3 = db(r3);
        r2.Zr = r3;
    L_0x0054:
        r3 = r2.Zr;
        if (r3 != 0) goto L_0x0060;
    L_0x0058:
        r3 = "setChannel";
        r3 = db(r3);
        r2.Zr = r3;
    L_0x0060:
        r3 = r2.Zr;
        if (r3 != 0) goto L_0x006c;
    L_0x0064:
        r3 = "FirebaseMessaging";
        r4 = "Error while setting the notification channel";
        android.util.Log.e(r3, r4);
        goto L_0x007f;
    L_0x006c:
        r3 = r2.Zr;	 Catch:{ IllegalAccessException -> 0x0077, IllegalAccessException -> 0x0077, IllegalAccessException -> 0x0077, IllegalAccessException -> 0x0077 }
        r4 = new java.lang.Object[r1];	 Catch:{ IllegalAccessException -> 0x0077, IllegalAccessException -> 0x0077, IllegalAccessException -> 0x0077, IllegalAccessException -> 0x0077 }
        r6 = 0;
        r4[r6] = r10;	 Catch:{ IllegalAccessException -> 0x0077, IllegalAccessException -> 0x0077, IllegalAccessException -> 0x0077, IllegalAccessException -> 0x0077 }
        r3.invoke(r5, r4);	 Catch:{ IllegalAccessException -> 0x0077, IllegalAccessException -> 0x0077, IllegalAccessException -> 0x0077, IllegalAccessException -> 0x0077 }
        goto L_0x007f;
    L_0x0077:
        r3 = move-exception;
        r4 = "FirebaseMessaging";
        r6 = "Error while setting the notification channel";
        android.util.Log.e(r4, r6, r3);
    L_0x007f:
        r3 = r5.build();
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.c.a(java.lang.CharSequence, java.lang.String, int, java.lang.Integer, android.net.Uri, android.app.PendingIntent, android.app.PendingIntent, java.lang.String):android.app.Notification");
    }

    private static void a(Intent intent, Bundle bundle) {
        for (String str : bundle.keySet()) {
            if (str.startsWith("google.c.a.") || str.equals("from")) {
                intent.putExtra(str, bundle.getString(str));
            }
        }
    }

    static synchronized c aD(Context context) {
        c cVar;
        synchronized (c.class) {
            if (Zq == null) {
                Zq = new c(context);
            }
            cVar = Zq;
        }
        return cVar;
    }

    @TargetApi(26)
    private final boolean bC(int i) {
        if (VERSION.SDK_INT != 26) {
            return true;
        }
        try {
            if (!(this.mContext.getResources().getDrawable(i, null) instanceof AdaptiveIconDrawable)) {
                return true;
            }
            StringBuilder stringBuilder = new StringBuilder(77);
            stringBuilder.append("Adaptive icons cannot be used in notifications. Ignoring icon id: ");
            stringBuilder.append(i);
            Log.e("FirebaseMessaging", stringBuilder.toString());
            return false;
        } catch (NotFoundException unused) {
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x000f A:{Splitter: B:0:0x0000, ExcHandler: java.lang.NoSuchMethodException (unused java.lang.NoSuchMethodException)} */
    /* JADX WARNING: Missing block: B:4:0x0010, code:
            return null;
     */
    @android.annotation.TargetApi(26)
    private static java.lang.reflect.Method db(java.lang.String r4) {
        /*
        r0 = android.app.Notification.Builder.class;
        r1 = 1;
        r1 = new java.lang.Class[r1];	 Catch:{ NoSuchMethodException -> 0x000f, NoSuchMethodException -> 0x000f }
        r2 = 0;
        r3 = java.lang.String.class;
        r1[r2] = r3;	 Catch:{ NoSuchMethodException -> 0x000f, NoSuchMethodException -> 0x000f }
        r4 = r0.getMethod(r4, r1);	 Catch:{ NoSuchMethodException -> 0x000f, NoSuchMethodException -> 0x000f }
        return r4;
    L_0x000f:
        r4 = 0;
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.c.db(java.lang.String):java.lang.reflect.Method");
    }

    private final Integer dc(String str) {
        if (VERSION.SDK_INT < 21) {
            return null;
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.valueOf(Color.parseColor(str));
            } catch (IllegalArgumentException unused) {
                StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 54);
                stringBuilder.append("Color ");
                stringBuilder.append(str);
                stringBuilder.append(" not valid. Notification will use default color.");
                Log.w("FirebaseMessaging", stringBuilder.toString());
            }
        }
        int i = wV().getInt("com.google.firebase.messaging.default_notification_color", 0);
        if (i != 0) {
            try {
                return Integer.valueOf(ContextCompat.getColor(this.mContext, i));
            } catch (NotFoundException unused2) {
                Log.w("FirebaseMessaging", "Cannot find the color resource referenced in AndroidManifest.");
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00e6 A:{Splitter: B:4:0x0012, ExcHandler: java.lang.InstantiationException (r11_14 'e' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00e6 A:{Splitter: B:4:0x0012, ExcHandler: java.lang.InstantiationException (r11_14 'e' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00e6 A:{Splitter: B:4:0x0012, ExcHandler: java.lang.InstantiationException (r11_14 'e' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00e6 A:{Splitter: B:4:0x0012, ExcHandler: java.lang.InstantiationException (r11_14 'e' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00e6 A:{Splitter: B:4:0x0012, ExcHandler: java.lang.InstantiationException (r11_14 'e' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00e6 A:{Splitter: B:4:0x0012, ExcHandler: java.lang.InstantiationException (r11_14 'e' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00e6 A:{Splitter: B:4:0x0012, ExcHandler: java.lang.InstantiationException (r11_14 'e' java.lang.Throwable)} */
    /* JADX WARNING: Missing block: B:27:0x00e6, code:
            r11 = move-exception;
     */
    /* JADX WARNING: Missing block: B:28:0x00e7, code:
            android.util.Log.e("FirebaseMessaging", "Error while setting the notification channel", r11);
     */
    /* JADX WARNING: Missing block: B:29:0x00ee, code:
            return null;
     */
    @android.annotation.TargetApi(26)
    private final java.lang.String dd(java.lang.String r11) {
        /*
        r10 = this;
        r0 = com.google.android.gms.common.util.zzs.isAtLeastO();
        r1 = 0;
        if (r0 != 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r0 = r10.mContext;
        r2 = android.app.NotificationManager.class;
        r0 = r0.getSystemService(r2);
        r0 = (android.app.NotificationManager) r0;
        r2 = r10.Zs;	 Catch:{ InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6 }
        r3 = 0;
        r4 = 1;
        if (r2 != 0) goto L_0x002a;
    L_0x0018:
        r2 = r0.getClass();	 Catch:{ InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6 }
        r5 = "getNotificationChannel";
        r6 = new java.lang.Class[r4];	 Catch:{ InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6 }
        r7 = java.lang.String.class;
        r6[r3] = r7;	 Catch:{ InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6 }
        r2 = r2.getMethod(r5, r6);	 Catch:{ InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6 }
        r10.Zs = r2;	 Catch:{ InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6 }
    L_0x002a:
        r2 = android.text.TextUtils.isEmpty(r11);	 Catch:{ InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6 }
        if (r2 != 0) goto L_0x0062;
    L_0x0030:
        r2 = r10.Zs;	 Catch:{ InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6 }
        r5 = new java.lang.Object[r4];	 Catch:{ InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6 }
        r5[r3] = r11;	 Catch:{ InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6 }
        r2 = r2.invoke(r0, r5);	 Catch:{ InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6 }
        if (r2 == 0) goto L_0x003d;
    L_0x003c:
        return r11;
    L_0x003d:
        r2 = "FirebaseMessaging";
        r5 = java.lang.String.valueOf(r11);	 Catch:{ InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6 }
        r5 = r5.length();	 Catch:{ InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6 }
        r5 = r5 + 122;
        r6 = new java.lang.StringBuilder;	 Catch:{ InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6 }
        r6.<init>(r5);	 Catch:{ InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6 }
        r5 = "Notification Channel requested (";
        r6.append(r5);	 Catch:{ InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6 }
        r6.append(r11);	 Catch:{ InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6 }
        r11 = ") has not been created by the app. Manifest configuration, or default, value will be used.";
        r6.append(r11);	 Catch:{ InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6 }
        r11 = r6.toString();	 Catch:{ InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6 }
        android.util.Log.w(r2, r11);	 Catch:{ InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6 }
    L_0x0062:
        r11 = r10.wV();	 Catch:{ InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6 }
        r2 = "com.google.firebase.messaging.default_notification_channel_id";
        r11 = r11.getString(r2);	 Catch:{ InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6 }
        r2 = android.text.TextUtils.isEmpty(r11);	 Catch:{ InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6 }
        if (r2 != 0) goto L_0x0087;
    L_0x0072:
        r2 = r10.Zs;	 Catch:{ InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6 }
        r5 = new java.lang.Object[r4];	 Catch:{ InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6 }
        r5[r3] = r11;	 Catch:{ InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6 }
        r2 = r2.invoke(r0, r5);	 Catch:{ InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6 }
        if (r2 == 0) goto L_0x007f;
    L_0x007e:
        return r11;
    L_0x007f:
        r11 = "FirebaseMessaging";
        r2 = "Notification Channel set in AndroidManifest.xml has not been created by the app. Default value will be used.";
    L_0x0083:
        android.util.Log.w(r11, r2);	 Catch:{ InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6 }
        goto L_0x008c;
    L_0x0087:
        r11 = "FirebaseMessaging";
        r2 = "Missing Default Notification Channel metadata in AndroidManifest. Default value will be used.";
        goto L_0x0083;
    L_0x008c:
        r11 = r10.Zs;	 Catch:{ InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6 }
        r2 = new java.lang.Object[r4];	 Catch:{ InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6 }
        r5 = "fcm_fallback_notification_channel";
        r2[r3] = r5;	 Catch:{ InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6 }
        r11 = r11.invoke(r0, r2);	 Catch:{ InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6 }
        if (r11 != 0) goto L_0x00e3;
    L_0x009a:
        r11 = "android.app.NotificationChannel";
        r11 = java.lang.Class.forName(r11);	 Catch:{ InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6 }
        r2 = 3;
        r5 = new java.lang.Class[r2];	 Catch:{ InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6 }
        r6 = java.lang.String.class;
        r5[r3] = r6;	 Catch:{ InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6 }
        r6 = java.lang.CharSequence.class;
        r5[r4] = r6;	 Catch:{ InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6 }
        r6 = java.lang.Integer.TYPE;	 Catch:{ InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6 }
        r7 = 2;
        r5[r7] = r6;	 Catch:{ InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6 }
        r5 = r11.getConstructor(r5);	 Catch:{ InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6 }
        r6 = new java.lang.Object[r2];	 Catch:{ InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6 }
        r8 = "fcm_fallback_notification_channel";
        r6[r3] = r8;	 Catch:{ InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6 }
        r8 = r10.mContext;	 Catch:{ InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6 }
        r9 = com.google.android.gms.R.string.fcm_fallback_notification_channel_label;	 Catch:{ InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6 }
        r8 = r8.getString(r9);	 Catch:{ InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6 }
        r6[r4] = r8;	 Catch:{ InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6 }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6 }
        r6[r7] = r2;	 Catch:{ InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6 }
        r2 = r5.newInstance(r6);	 Catch:{ InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6 }
        r5 = r0.getClass();	 Catch:{ InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6 }
        r6 = "createNotificationChannel";
        r7 = new java.lang.Class[r4];	 Catch:{ InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6 }
        r7[r3] = r11;	 Catch:{ InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6 }
        r11 = r5.getMethod(r6, r7);	 Catch:{ InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6 }
        r4 = new java.lang.Object[r4];	 Catch:{ InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6 }
        r4[r3] = r2;	 Catch:{ InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6 }
        r11.invoke(r0, r4);	 Catch:{ InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6, InstantiationException -> 0x00e6 }
    L_0x00e3:
        r11 = "fcm_fallback_notification_channel";
        return r11;
    L_0x00e6:
        r11 = move-exception;
        r0 = "FirebaseMessaging";
        r2 = "Error while setting the notification channel";
        android.util.Log.e(r0, r2, r11);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.c.dd(java.lang.String):java.lang.String");
    }

    static String e(Bundle bundle, String str) {
        String string = bundle.getString(str);
        return string == null ? bundle.getString(str.replace("gcm.n.", "gcm.notification.")) : string;
    }

    static String f(Bundle bundle, String str) {
        str = String.valueOf(str);
        String valueOf = String.valueOf("_loc_key");
        return e(bundle, valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }

    static Object[] g(Bundle bundle, String str) {
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf("_loc_args");
        String e = e(bundle, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        if (TextUtils.isEmpty(e)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(e);
            String[] strArr = new String[jSONArray.length()];
            for (int i = 0; i < strArr.length; i++) {
                strArr[i] = jSONArray.opt(i);
            }
            return strArr;
        } catch (JSONException unused) {
            valueOf = "FirebaseMessaging";
            str = String.valueOf(str);
            String valueOf3 = String.valueOf("_loc_args");
            str = (valueOf3.length() != 0 ? str.concat(valueOf3) : new String(str)).substring(6);
            StringBuilder stringBuilder = new StringBuilder((String.valueOf(str).length() + 41) + String.valueOf(e).length());
            stringBuilder.append("Malformed ");
            stringBuilder.append(str);
            stringBuilder.append(": ");
            stringBuilder.append(e);
            stringBuilder.append("  Default value will be used.");
            Log.w(valueOf, stringBuilder.toString());
            return null;
        }
    }

    private final String h(Bundle bundle, String str) {
        Object e = e(bundle, str);
        if (!TextUtils.isEmpty(e)) {
            return e;
        }
        String f = f(bundle, str);
        if (TextUtils.isEmpty(f)) {
            return null;
        }
        Resources resources = this.mContext.getResources();
        int identifier = resources.getIdentifier(f, "string", this.mContext.getPackageName());
        String str2;
        if (identifier == 0) {
            str2 = "FirebaseMessaging";
            str = String.valueOf(str);
            String valueOf = String.valueOf("_loc_key");
            str = (valueOf.length() != 0 ? str.concat(valueOf) : new String(str)).substring(6);
            StringBuilder stringBuilder = new StringBuilder((String.valueOf(str).length() + 49) + String.valueOf(f).length());
            stringBuilder.append(str);
            stringBuilder.append(" resource not found: ");
            stringBuilder.append(f);
            stringBuilder.append(" Default value will be used.");
            Log.w(str2, stringBuilder.toString());
            return null;
        }
        Object[] g = g(bundle, str);
        if (g == null) {
            return resources.getString(identifier);
        }
        try {
            return resources.getString(identifier, g);
        } catch (Throwable e2) {
            str2 = Arrays.toString(g);
            StringBuilder stringBuilder2 = new StringBuilder((String.valueOf(f).length() + 58) + String.valueOf(str2).length());
            stringBuilder2.append("Missing format argument for ");
            stringBuilder2.append(f);
            stringBuilder2.append(": ");
            stringBuilder2.append(str2);
            stringBuilder2.append(" Default value will be used.");
            Log.w("FirebaseMessaging", stringBuilder2.toString(), e2);
            return null;
        }
    }

    private final Bundle wV() {
        if (this.zzgco != null) {
            return this.zzgco;
        }
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = this.mContext.getPackageManager().getApplicationInfo(this.mContext.getPackageName(), 128);
        } catch (NameNotFoundException unused) {
            if (applicationInfo == null || applicationInfo.metaData == null) {
                return Bundle.EMPTY;
            }
            this.zzgco = applicationInfo.metaData;
            return this.zzgco;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0184  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01f1  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01fa  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x020b  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0214  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0219  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x021e  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0234  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x024b  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005f A:{RETURN} */
    final boolean Q(android.os.Bundle r13) {
        /*
        r12 = this;
        r0 = "1";
        r1 = "gcm.n.noui";
        r1 = e(r13, r1);
        r0 = r0.equals(r1);
        r1 = 1;
        if (r0 == 0) goto L_0x0010;
    L_0x000f:
        return r1;
    L_0x0010:
        r0 = r12.mContext;
        r2 = "keyguard";
        r0 = r0.getSystemService(r2);
        r0 = (android.app.KeyguardManager) r0;
        r0 = r0.inKeyguardRestrictedInputMode();
        r2 = 0;
        if (r0 != 0) goto L_0x005c;
    L_0x0021:
        r0 = com.google.android.gms.common.util.zzs.zzanx();
        if (r0 != 0) goto L_0x002c;
    L_0x0027:
        r3 = 10;
        android.os.SystemClock.sleep(r3);
    L_0x002c:
        r0 = android.os.Process.myPid();
        r3 = r12.mContext;
        r4 = "activity";
        r3 = r3.getSystemService(r4);
        r3 = (android.app.ActivityManager) r3;
        r3 = r3.getRunningAppProcesses();
        if (r3 == 0) goto L_0x005c;
    L_0x0040:
        r3 = r3.iterator();
    L_0x0044:
        r4 = r3.hasNext();
        if (r4 == 0) goto L_0x005c;
    L_0x004a:
        r4 = r3.next();
        r4 = (android.app.ActivityManager.RunningAppProcessInfo) r4;
        r5 = r4.pid;
        if (r5 != r0) goto L_0x0044;
    L_0x0054:
        r0 = r4.importance;
        r3 = 100;
        if (r0 != r3) goto L_0x005c;
    L_0x005a:
        r0 = 1;
        goto L_0x005d;
    L_0x005c:
        r0 = 0;
    L_0x005d:
        if (r0 == 0) goto L_0x0060;
    L_0x005f:
        return r2;
    L_0x0060:
        r0 = "gcm.n.title";
        r0 = r12.h(r13, r0);
        r3 = android.text.TextUtils.isEmpty(r0);
        if (r3 == 0) goto L_0x007c;
    L_0x006c:
        r0 = r12.mContext;
        r0 = r0.getApplicationInfo();
        r3 = r12.mContext;
        r3 = r3.getPackageManager();
        r0 = r0.loadLabel(r3);
    L_0x007c:
        r4 = r0;
        r0 = "gcm.n.body";
        r5 = r12.h(r13, r0);
        r0 = "gcm.n.icon";
        r0 = e(r13, r0);
        r3 = android.text.TextUtils.isEmpty(r0);
        if (r3 != 0) goto L_0x00e5;
    L_0x008f:
        r3 = r12.mContext;
        r3 = r3.getResources();
        r6 = "drawable";
        r7 = r12.mContext;
        r7 = r7.getPackageName();
        r6 = r3.getIdentifier(r0, r6, r7);
        if (r6 == 0) goto L_0x00aa;
    L_0x00a3:
        r7 = r12.bC(r6);
        if (r7 == 0) goto L_0x00aa;
    L_0x00a9:
        goto L_0x010b;
    L_0x00aa:
        r6 = "mipmap";
        r7 = r12.mContext;
        r7 = r7.getPackageName();
        r3 = r3.getIdentifier(r0, r6, r7);
        if (r3 == 0) goto L_0x00c0;
    L_0x00b8:
        r6 = r12.bC(r3);
        if (r6 == 0) goto L_0x00c0;
    L_0x00be:
        r6 = r3;
        goto L_0x010b;
    L_0x00c0:
        r3 = "FirebaseMessaging";
        r6 = java.lang.String.valueOf(r0);
        r6 = r6.length();
        r6 = r6 + 61;
        r7 = new java.lang.StringBuilder;
        r7.<init>(r6);
        r6 = "Icon resource ";
        r7.append(r6);
        r7.append(r0);
        r0 = " not found. Notification will use default icon.";
        r7.append(r0);
        r0 = r7.toString();
        android.util.Log.w(r3, r0);
    L_0x00e5:
        r0 = r12.wV();
        r3 = "com.google.firebase.messaging.default_notification_icon";
        r0 = r0.getInt(r3, r2);
        if (r0 == 0) goto L_0x00f7;
    L_0x00f1:
        r3 = r12.bC(r0);
        if (r3 != 0) goto L_0x00ff;
    L_0x00f7:
        r0 = r12.mContext;
        r0 = r0.getApplicationInfo();
        r0 = r0.icon;
    L_0x00ff:
        if (r0 == 0) goto L_0x0107;
    L_0x0101:
        r3 = r12.bC(r0);
        if (r3 != 0) goto L_0x010a;
    L_0x0107:
        r0 = 17301651; // 0x1080093 float:2.4979667E-38 double:8.5481514E-317;
    L_0x010a:
        r6 = r0;
    L_0x010b:
        r0 = "gcm.n.color";
        r0 = e(r13, r0);
        r7 = r12.dc(r0);
        r0 = R(r13);
        r3 = android.text.TextUtils.isEmpty(r0);
        r8 = 0;
        if (r3 == 0) goto L_0x0122;
    L_0x0120:
        r0 = r8;
        goto L_0x017a;
    L_0x0122:
        r3 = "default";
        r3 = r3.equals(r0);
        if (r3 != 0) goto L_0x0175;
    L_0x012a:
        r3 = r12.mContext;
        r3 = r3.getResources();
        r9 = "raw";
        r10 = r12.mContext;
        r10 = r10.getPackageName();
        r3 = r3.getIdentifier(r0, r9, r10);
        if (r3 == 0) goto L_0x0175;
    L_0x013e:
        r3 = r12.mContext;
        r3 = r3.getPackageName();
        r9 = java.lang.String.valueOf(r3);
        r9 = r9.length();
        r9 = r9 + 24;
        r10 = java.lang.String.valueOf(r0);
        r10 = r10.length();
        r9 = r9 + r10;
        r10 = new java.lang.StringBuilder;
        r10.<init>(r9);
        r9 = "android.resource://";
        r10.append(r9);
        r10.append(r3);
        r3 = "/raw/";
        r10.append(r3);
        r10.append(r0);
        r0 = r10.toString();
        r0 = android.net.Uri.parse(r0);
        goto L_0x017a;
    L_0x0175:
        r0 = 2;
        r0 = android.media.RingtoneManager.getDefaultUri(r0);
    L_0x017a:
        r3 = r12.S(r13);
        r9 = com.google.firebase.messaging.FirebaseMessagingService.N(r13);
        if (r9 == 0) goto L_0x01b7;
    L_0x0184:
        r8 = new android.content.Intent;
        r9 = "com.google.firebase.messaging.NOTIFICATION_OPEN";
        r8.<init>(r9);
        a(r8, r13);
        r9 = "pending_intent";
        r8.putExtra(r9, r3);
        r3 = r12.mContext;
        r9 = r12.Zt;
        r9 = r9.incrementAndGet();
        r10 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r3 = com.google.firebase.iid.ac.a(r3, r9, r8, r10);
        r8 = new android.content.Intent;
        r9 = "com.google.firebase.messaging.NOTIFICATION_DISMISS";
        r8.<init>(r9);
        a(r8, r13);
        r9 = r12.mContext;
        r11 = r12.Zt;
        r11 = r11.incrementAndGet();
        r8 = com.google.firebase.iid.ac.a(r9, r11, r8, r10);
    L_0x01b7:
        r9 = r3;
        r10 = r8;
        r3 = com.google.android.gms.common.util.zzs.isAtLeastO();
        if (r3 == 0) goto L_0x01dc;
    L_0x01bf:
        r3 = r12.mContext;
        r3 = r3.getApplicationInfo();
        r3 = r3.targetSdkVersion;
        r8 = 25;
        if (r3 <= r8) goto L_0x01dc;
    L_0x01cb:
        r3 = "gcm.n.android_channel_id";
        r3 = e(r13, r3);
        r11 = r12.dd(r3);
        r3 = r12;
        r8 = r0;
        r0 = r3.a(r4, r5, r6, r7, r8, r9, r10, r11);
        goto L_0x0225;
    L_0x01dc:
        r3 = new android.support.v4.app.NotificationCompat$Builder;
        r8 = r12.mContext;
        r3.<init>(r8);
        r3 = r3.setAutoCancel(r1);
        r3 = r3.setSmallIcon(r6);
        r6 = android.text.TextUtils.isEmpty(r4);
        if (r6 != 0) goto L_0x01f4;
    L_0x01f1:
        r3.setContentTitle(r4);
    L_0x01f4:
        r4 = android.text.TextUtils.isEmpty(r5);
        if (r4 != 0) goto L_0x0209;
    L_0x01fa:
        r3.setContentText(r5);
        r4 = new android.support.v4.app.NotificationCompat$BigTextStyle;
        r4.<init>();
        r4 = r4.bigText(r5);
        r3.setStyle(r4);
    L_0x0209:
        if (r7 == 0) goto L_0x0212;
    L_0x020b:
        r4 = r7.intValue();
        r3.setColor(r4);
    L_0x0212:
        if (r0 == 0) goto L_0x0217;
    L_0x0214:
        r3.setSound(r0);
    L_0x0217:
        if (r9 == 0) goto L_0x021c;
    L_0x0219:
        r3.setContentIntent(r9);
    L_0x021c:
        if (r10 == 0) goto L_0x0221;
    L_0x021e:
        r3.setDeleteIntent(r10);
    L_0x0221:
        r0 = r3.build();
    L_0x0225:
        r3 = "gcm.n.tag";
        r13 = e(r13, r3);
        r3 = "FirebaseMessaging";
        r4 = 3;
        r3 = android.util.Log.isLoggable(r3, r4);
        if (r3 == 0) goto L_0x023b;
    L_0x0234:
        r3 = "FirebaseMessaging";
        r4 = "Showing notification";
        android.util.Log.d(r3, r4);
    L_0x023b:
        r3 = r12.mContext;
        r4 = "notification";
        r3 = r3.getSystemService(r4);
        r3 = (android.app.NotificationManager) r3;
        r4 = android.text.TextUtils.isEmpty(r13);
        if (r4 == 0) goto L_0x0262;
    L_0x024b:
        r4 = android.os.SystemClock.uptimeMillis();
        r13 = 37;
        r6 = new java.lang.StringBuilder;
        r6.<init>(r13);
        r13 = "FCM-Notification:";
        r6.append(r13);
        r6.append(r4);
        r13 = r6.toString();
    L_0x0262:
        r3.notify(r13, r2, r0);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.c.Q(android.os.Bundle):boolean");
    }
}
