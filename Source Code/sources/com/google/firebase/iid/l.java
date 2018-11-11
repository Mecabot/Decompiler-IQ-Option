package com.google.firebase.iid;

import android.content.BroadcastReceiver.PendingResult;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import com.google.android.gms.common.internal.Hide;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

@Hide
public final class l implements ServiceConnection {
    private final Intent Yp;
    private final Queue<h> Yq;
    private j Yr;
    private boolean Ys;
    private final Context zzaiq;
    private final ScheduledExecutorService zzimq;

    public l(Context context, String str) {
        this(context, str, new ScheduledThreadPoolExecutor(0));
    }

    @VisibleForTesting
    private l(Context context, String str, ScheduledExecutorService scheduledExecutorService) {
        this.Yq = new ArrayDeque();
        this.Ys = false;
        this.zzaiq = context.getApplicationContext();
        this.Yp = new Intent(str).setPackage(this.zzaiq.getPackageName());
        this.zzimq = scheduledExecutorService;
    }

    /* JADX WARNING: Missing block: B:39:0x00b2, code:
            return;
     */
    private final synchronized void wD() {
        /*
        r5 = this;
        monitor-enter(r5);
        r0 = "EnhancedIntentService";
        r1 = 3;
        r0 = android.util.Log.isLoggable(r0, r1);	 Catch:{ all -> 0x00b5 }
        if (r0 == 0) goto L_0x0011;
    L_0x000a:
        r0 = "EnhancedIntentService";
        r2 = "flush queue called";
        android.util.Log.d(r0, r2);	 Catch:{ all -> 0x00b5 }
    L_0x0011:
        r0 = r5.Yq;	 Catch:{ all -> 0x00b5 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x00b5 }
        if (r0 != 0) goto L_0x00b3;
    L_0x0019:
        r0 = "EnhancedIntentService";
        r0 = android.util.Log.isLoggable(r0, r1);	 Catch:{ all -> 0x00b5 }
        if (r0 == 0) goto L_0x0028;
    L_0x0021:
        r0 = "EnhancedIntentService";
        r2 = "found intent to be delivered";
        android.util.Log.d(r0, r2);	 Catch:{ all -> 0x00b5 }
    L_0x0028:
        r0 = r5.Yr;	 Catch:{ all -> 0x00b5 }
        if (r0 == 0) goto L_0x0051;
    L_0x002c:
        r0 = r5.Yr;	 Catch:{ all -> 0x00b5 }
        r0 = r0.isBinderAlive();	 Catch:{ all -> 0x00b5 }
        if (r0 == 0) goto L_0x0051;
    L_0x0034:
        r0 = "EnhancedIntentService";
        r0 = android.util.Log.isLoggable(r0, r1);	 Catch:{ all -> 0x00b5 }
        if (r0 == 0) goto L_0x0043;
    L_0x003c:
        r0 = "EnhancedIntentService";
        r2 = "binder is alive, sending the intent.";
        android.util.Log.d(r0, r2);	 Catch:{ all -> 0x00b5 }
    L_0x0043:
        r0 = r5.Yq;	 Catch:{ all -> 0x00b5 }
        r0 = r0.poll();	 Catch:{ all -> 0x00b5 }
        r0 = (com.google.firebase.iid.h) r0;	 Catch:{ all -> 0x00b5 }
        r2 = r5.Yr;	 Catch:{ all -> 0x00b5 }
        r2.a(r0);	 Catch:{ all -> 0x00b5 }
        goto L_0x0011;
    L_0x0051:
        r0 = "EnhancedIntentService";
        r0 = android.util.Log.isLoggable(r0, r1);	 Catch:{ all -> 0x00b5 }
        r1 = 1;
        if (r0 == 0) goto L_0x0075;
    L_0x005a:
        r0 = "EnhancedIntentService";
        r2 = r5.Ys;	 Catch:{ all -> 0x00b5 }
        r2 = r2 ^ r1;
        r3 = 39;
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00b5 }
        r4.<init>(r3);	 Catch:{ all -> 0x00b5 }
        r3 = "binder is dead. start connection? ";
        r4.append(r3);	 Catch:{ all -> 0x00b5 }
        r4.append(r2);	 Catch:{ all -> 0x00b5 }
        r2 = r4.toString();	 Catch:{ all -> 0x00b5 }
        android.util.Log.d(r0, r2);	 Catch:{ all -> 0x00b5 }
    L_0x0075:
        r0 = r5.Ys;	 Catch:{ all -> 0x00b5 }
        if (r0 != 0) goto L_0x00b1;
    L_0x0079:
        r5.Ys = r1;	 Catch:{ all -> 0x00b5 }
        r0 = com.google.android.gms.common.stats.zza.zzanm();	 Catch:{ SecurityException -> 0x0095 }
        r1 = r5.zzaiq;	 Catch:{ SecurityException -> 0x0095 }
        r2 = r5.Yp;	 Catch:{ SecurityException -> 0x0095 }
        r3 = 65;
        r0 = r0.zza(r1, r2, r5, r3);	 Catch:{ SecurityException -> 0x0095 }
        if (r0 == 0) goto L_0x008d;
    L_0x008b:
        monitor-exit(r5);
        return;
    L_0x008d:
        r0 = "EnhancedIntentService";
        r1 = "binding to the service failed";
        android.util.Log.e(r0, r1);	 Catch:{ SecurityException -> 0x0095 }
        goto L_0x009d;
    L_0x0095:
        r0 = move-exception;
        r1 = "EnhancedIntentService";
        r2 = "Exception while binding the service";
        android.util.Log.e(r1, r2, r0);	 Catch:{ all -> 0x00b5 }
    L_0x009d:
        r0 = r5.Yq;	 Catch:{ all -> 0x00b5 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x00b5 }
        if (r0 != 0) goto L_0x00b1;
    L_0x00a5:
        r0 = r5.Yq;	 Catch:{ all -> 0x00b5 }
        r0 = r0.poll();	 Catch:{ all -> 0x00b5 }
        r0 = (com.google.firebase.iid.h) r0;	 Catch:{ all -> 0x00b5 }
        r0.finish();	 Catch:{ all -> 0x00b5 }
        goto L_0x009d;
    L_0x00b1:
        monitor-exit(r5);
        return;
    L_0x00b3:
        monitor-exit(r5);
        return;
    L_0x00b5:
        r0 = move-exception;
        monitor-exit(r5);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.l.wD():void");
    }

    public final synchronized void a(Intent intent, PendingResult pendingResult) {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "new intent queued in the bind-strategy delivery");
        }
        this.Yq.add(new h(intent, pendingResult, this.zzimq));
        wD();
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this) {
            this.Ys = false;
            this.Yr = (j) iBinder;
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                String valueOf = String.valueOf(componentName);
                StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 20);
                stringBuilder.append("onServiceConnected: ");
                stringBuilder.append(valueOf);
                Log.d("EnhancedIntentService", stringBuilder.toString());
            }
            wD();
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            String valueOf = String.valueOf(componentName);
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 23);
            stringBuilder.append("onServiceDisconnected: ");
            stringBuilder.append(valueOf);
            Log.d("EnhancedIntentService", stringBuilder.toString());
        }
        wD();
    }
}
