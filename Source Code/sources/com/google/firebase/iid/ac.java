package com.google.firebase.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.VisibleForTesting;
import android.support.v4.util.SimpleArrayMap;
import com.google.android.gms.common.internal.Hide;
import java.util.ArrayDeque;
import java.util.Queue;

@Hide
public final class ac {
    private static ac YW;
    private final SimpleArrayMap<String, String> YX = new SimpleArrayMap();
    private Boolean YY = null;
    @VisibleForTesting
    final Queue<Intent> YZ = new ArrayDeque();
    @VisibleForTesting
    private Queue<Intent> Za = new ArrayDeque();

    private ac() {
    }

    public static PendingIntent a(Context context, int i, Intent intent, int i2) {
        Intent intent2 = new Intent(context, FirebaseInstanceIdReceiver.class);
        intent2.setAction("com.google.firebase.MESSAGING_EVENT");
        intent2.putExtra("wrapped_intent", intent);
        return PendingIntent.getBroadcast(context, i, intent2, 1073741824);
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00db A:{Catch:{ SecurityException -> 0x0138, IllegalStateException -> 0x0110 }} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00f7 A:{Catch:{ SecurityException -> 0x0138, IllegalStateException -> 0x0110 }} */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00f2 A:{Catch:{ SecurityException -> 0x0138, IllegalStateException -> 0x0110 }} */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0104 A:{Catch:{ SecurityException -> 0x0138, IllegalStateException -> 0x0110 }} */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00db A:{Catch:{ SecurityException -> 0x0138, IllegalStateException -> 0x0110 }} */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00f2 A:{Catch:{ SecurityException -> 0x0138, IllegalStateException -> 0x0110 }} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00f7 A:{Catch:{ SecurityException -> 0x0138, IllegalStateException -> 0x0110 }} */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0104 A:{Catch:{ SecurityException -> 0x0138, IllegalStateException -> 0x0110 }} */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x010e  */
    private final int f(android.content.Context r7, android.content.Intent r8) {
        /*
        r6 = this;
        r0 = r6.YX;
        monitor-enter(r0);
        r1 = r6.YX;	 Catch:{ all -> 0x0143 }
        r2 = r8.getAction();	 Catch:{ all -> 0x0143 }
        r1 = r1.get(r2);	 Catch:{ all -> 0x0143 }
        r1 = (java.lang.String) r1;	 Catch:{ all -> 0x0143 }
        monitor-exit(r0);	 Catch:{ all -> 0x0143 }
        r0 = 0;
        if (r1 != 0) goto L_0x00ab;
    L_0x0013:
        r1 = r7.getPackageManager();
        r1 = r1.resolveService(r8, r0);
        if (r1 == 0) goto L_0x00a3;
    L_0x001d:
        r2 = r1.serviceInfo;
        if (r2 != 0) goto L_0x0023;
    L_0x0021:
        goto L_0x00a3;
    L_0x0023:
        r1 = r1.serviceInfo;
        r2 = r7.getPackageName();
        r3 = r1.packageName;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x006d;
    L_0x0031:
        r2 = r1.name;
        if (r2 != 0) goto L_0x0036;
    L_0x0035:
        goto L_0x006d;
    L_0x0036:
        r1 = r1.name;
        r2 = ".";
        r2 = r1.startsWith(r2);
        if (r2 == 0) goto L_0x005c;
    L_0x0040:
        r2 = r7.getPackageName();
        r2 = java.lang.String.valueOf(r2);
        r1 = java.lang.String.valueOf(r1);
        r3 = r1.length();
        if (r3 == 0) goto L_0x0057;
    L_0x0052:
        r1 = r2.concat(r1);
        goto L_0x005c;
    L_0x0057:
        r1 = new java.lang.String;
        r1.<init>(r2);
    L_0x005c:
        r2 = r6.YX;
        monitor-enter(r2);
        r3 = r6.YX;	 Catch:{ all -> 0x006a }
        r4 = r8.getAction();	 Catch:{ all -> 0x006a }
        r3.put(r4, r1);	 Catch:{ all -> 0x006a }
        monitor-exit(r2);	 Catch:{ all -> 0x006a }
        goto L_0x00ab;
    L_0x006a:
        r7 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x006a }
        throw r7;
    L_0x006d:
        r2 = "FirebaseInstanceId";
        r3 = r1.packageName;
        r1 = r1.name;
        r4 = java.lang.String.valueOf(r3);
        r4 = r4.length();
        r4 = r4 + 94;
        r5 = java.lang.String.valueOf(r1);
        r5 = r5.length();
        r4 = r4 + r5;
        r5 = new java.lang.StringBuilder;
        r5.<init>(r4);
        r4 = "Error resolving target intent service, skipping classname enforcement. Resolved service was: ";
        r5.append(r4);
        r5.append(r3);
        r3 = "/";
        r5.append(r3);
        r5.append(r1);
        r1 = r5.toString();
        android.util.Log.e(r2, r1);
        goto L_0x00d7;
    L_0x00a3:
        r1 = "FirebaseInstanceId";
        r2 = "Failed to resolve target intent service, skipping classname enforcement";
        android.util.Log.e(r1, r2);
        goto L_0x00d7;
    L_0x00ab:
        r2 = "FirebaseInstanceId";
        r3 = 3;
        r2 = android.util.Log.isLoggable(r2, r3);
        if (r2 == 0) goto L_0x00d0;
    L_0x00b4:
        r2 = "FirebaseInstanceId";
        r3 = "Restricting intent to a specific service: ";
        r4 = java.lang.String.valueOf(r1);
        r5 = r4.length();
        if (r5 == 0) goto L_0x00c7;
    L_0x00c2:
        r3 = r3.concat(r4);
        goto L_0x00cd;
    L_0x00c7:
        r4 = new java.lang.String;
        r4.<init>(r3);
        r3 = r4;
    L_0x00cd:
        android.util.Log.d(r2, r3);
    L_0x00d0:
        r2 = r7.getPackageName();
        r8.setClassName(r2, r1);
    L_0x00d7:
        r1 = r6.YY;	 Catch:{ SecurityException -> 0x0138, IllegalStateException -> 0x0110 }
        if (r1 != 0) goto L_0x00ea;
    L_0x00db:
        r1 = "android.permission.WAKE_LOCK";
        r1 = r7.checkCallingOrSelfPermission(r1);	 Catch:{ SecurityException -> 0x0138, IllegalStateException -> 0x0110 }
        if (r1 != 0) goto L_0x00e4;
    L_0x00e3:
        r0 = 1;
    L_0x00e4:
        r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ SecurityException -> 0x0138, IllegalStateException -> 0x0110 }
        r6.YY = r0;	 Catch:{ SecurityException -> 0x0138, IllegalStateException -> 0x0110 }
    L_0x00ea:
        r0 = r6.YY;	 Catch:{ SecurityException -> 0x0138, IllegalStateException -> 0x0110 }
        r0 = r0.booleanValue();	 Catch:{ SecurityException -> 0x0138, IllegalStateException -> 0x0110 }
        if (r0 == 0) goto L_0x00f7;
    L_0x00f2:
        r7 = android.support.v4.content.WakefulBroadcastReceiver.startWakefulService(r7, r8);	 Catch:{ SecurityException -> 0x0138, IllegalStateException -> 0x0110 }
        goto L_0x0102;
    L_0x00f7:
        r7 = r7.startService(r8);	 Catch:{ SecurityException -> 0x0138, IllegalStateException -> 0x0110 }
        r8 = "FirebaseInstanceId";
        r0 = "Missing wake lock permission, service start may be delayed";
        android.util.Log.d(r8, r0);	 Catch:{ SecurityException -> 0x0138, IllegalStateException -> 0x0110 }
    L_0x0102:
        if (r7 != 0) goto L_0x010e;
    L_0x0104:
        r7 = "FirebaseInstanceId";
        r8 = "Error while delivering the message: ServiceIntent not found.";
        android.util.Log.e(r7, r8);	 Catch:{ SecurityException -> 0x0138, IllegalStateException -> 0x0110 }
        r7 = 404; // 0x194 float:5.66E-43 double:1.996E-321;
        return r7;
    L_0x010e:
        r7 = -1;
        return r7;
    L_0x0110:
        r7 = move-exception;
        r8 = "FirebaseInstanceId";
        r7 = java.lang.String.valueOf(r7);
        r0 = java.lang.String.valueOf(r7);
        r0 = r0.length();
        r0 = r0 + 45;
        r1 = new java.lang.StringBuilder;
        r1.<init>(r0);
        r0 = "Failed to start service while in background: ";
        r1.append(r0);
        r1.append(r7);
        r7 = r1.toString();
        android.util.Log.e(r8, r7);
        r7 = 402; // 0x192 float:5.63E-43 double:1.986E-321;
        return r7;
    L_0x0138:
        r7 = move-exception;
        r8 = "FirebaseInstanceId";
        r0 = "Error while delivering the message to the serviceIntent";
        android.util.Log.e(r8, r0, r7);
        r7 = 401; // 0x191 float:5.62E-43 double:1.98E-321;
        return r7;
    L_0x0143:
        r7 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0143 }
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.ac.f(android.content.Context, android.content.Intent):int");
    }

    public static synchronized ac wP() {
        ac acVar;
        synchronized (ac.class) {
            if (YW == null) {
                YW = new ac();
            }
            acVar = YW;
        }
        return acVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003a  */
    public final int a(android.content.Context r3, java.lang.String r4, android.content.Intent r5) {
        /*
        r2 = this;
        r0 = r4.hashCode();
        r1 = -842411455; // 0xffffffffcdc9d241 float:-4.23249952E8 double:NaN;
        if (r0 == r1) goto L_0x0019;
    L_0x0009:
        r1 = 41532704; // 0x279bd20 float:1.8347907E-37 double:2.0519882E-316;
        if (r0 == r1) goto L_0x000f;
    L_0x000e:
        goto L_0x0023;
    L_0x000f:
        r0 = "com.google.firebase.MESSAGING_EVENT";
        r0 = r4.equals(r0);
        if (r0 == 0) goto L_0x0023;
    L_0x0017:
        r0 = 1;
        goto L_0x0024;
    L_0x0019:
        r0 = "com.google.firebase.INSTANCE_ID_EVENT";
        r0 = r4.equals(r0);
        if (r0 == 0) goto L_0x0023;
    L_0x0021:
        r0 = 0;
        goto L_0x0024;
    L_0x0023:
        r0 = -1;
    L_0x0024:
        switch(r0) {
            case 0: goto L_0x003d;
            case 1: goto L_0x003a;
            default: goto L_0x0027;
        };
    L_0x0027:
        r3 = "FirebaseInstanceId";
        r5 = "Unknown service action: ";
        r4 = java.lang.String.valueOf(r4);
        r0 = r4.length();
        if (r0 == 0) goto L_0x0053;
    L_0x0035:
        r4 = r5.concat(r4);
        goto L_0x0058;
    L_0x003a:
        r0 = r2.Za;
        goto L_0x003f;
    L_0x003d:
        r0 = r2.YZ;
    L_0x003f:
        r0.offer(r5);
        r5 = new android.content.Intent;
        r5.<init>(r4);
        r4 = r3.getPackageName();
        r5.setPackage(r4);
        r3 = r2.f(r3, r5);
        return r3;
    L_0x0053:
        r4 = new java.lang.String;
        r4.<init>(r5);
    L_0x0058:
        android.util.Log.w(r3, r4);
        r3 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.ac.a(android.content.Context, java.lang.String, android.content.Intent):int");
    }

    public final Intent wQ() {
        return (Intent) this.Za.poll();
    }
}
