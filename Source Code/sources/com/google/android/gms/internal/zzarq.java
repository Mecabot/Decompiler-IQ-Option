package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.google.android.gms.analytics.zzk;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.stats.zza;

public final class zzarq implements ServiceConnection {
    final /* synthetic */ zzaro zzdzq;
    private volatile zzasz zzdzr;
    private volatile boolean zzdzs;

    protected zzarq(zzaro zzaro) {
        this.zzdzq = zzaro;
    }

    /* JADX WARNING: Missing block: B:23:?, code:
            r2.zzdzq.zzee("Service connect failed to get IAnalyticsService");
     */
    public final void onServiceConnected(android.content.ComponentName r3, android.os.IBinder r4) {
        /*
        r2 = this;
        r3 = "AnalyticsServiceConnection.onServiceConnected";
        com.google.android.gms.common.internal.zzbq.zzgn(r3);
        monitor-enter(r2);
        if (r4 != 0) goto L_0x0017;
    L_0x0008:
        r3 = r2.zzdzq;	 Catch:{ all -> 0x0014 }
        r4 = "Service connected with null binder";
        r3.zzee(r4);	 Catch:{ all -> 0x0014 }
        r2.notifyAll();	 Catch:{ all -> 0x008c }
        monitor-exit(r2);	 Catch:{ all -> 0x008c }
        return;
    L_0x0014:
        r3 = move-exception;
        goto L_0x0088;
    L_0x0017:
        r3 = 0;
        r0 = r4.getInterfaceDescriptor();	 Catch:{ RemoteException -> 0x004b }
        r1 = "com.google.android.gms.analytics.internal.IAnalyticsService";
        r1 = r1.equals(r0);	 Catch:{ RemoteException -> 0x004b }
        if (r1 == 0) goto L_0x0043;
    L_0x0024:
        if (r4 != 0) goto L_0x0027;
    L_0x0026:
        goto L_0x003b;
    L_0x0027:
        r0 = "com.google.android.gms.analytics.internal.IAnalyticsService";
        r0 = r4.queryLocalInterface(r0);	 Catch:{ RemoteException -> 0x004b }
        r1 = r0 instanceof com.google.android.gms.internal.zzasz;	 Catch:{ RemoteException -> 0x004b }
        if (r1 == 0) goto L_0x0035;
    L_0x0031:
        r0 = (com.google.android.gms.internal.zzasz) r0;	 Catch:{ RemoteException -> 0x004b }
    L_0x0033:
        r3 = r0;
        goto L_0x003b;
    L_0x0035:
        r0 = new com.google.android.gms.internal.zzata;	 Catch:{ RemoteException -> 0x004b }
        r0.<init>(r4);	 Catch:{ RemoteException -> 0x004b }
        goto L_0x0033;
    L_0x003b:
        r4 = r2.zzdzq;	 Catch:{ RemoteException -> 0x004b }
        r0 = "Bound to IAnalyticsService interface";
        r4.zzea(r0);	 Catch:{ RemoteException -> 0x004b }
        goto L_0x0052;
    L_0x0043:
        r4 = r2.zzdzq;	 Catch:{ RemoteException -> 0x004b }
        r1 = "Got binder with a wrong descriptor";
        r4.zze(r1, r0);	 Catch:{ RemoteException -> 0x004b }
        goto L_0x0052;
    L_0x004b:
        r4 = r2.zzdzq;	 Catch:{ all -> 0x0014 }
        r0 = "Service connect failed to get IAnalyticsService";
        r4.zzee(r0);	 Catch:{ all -> 0x0014 }
    L_0x0052:
        if (r3 != 0) goto L_0x0067;
    L_0x0054:
        com.google.android.gms.common.stats.zza.zzanm();	 Catch:{ IllegalArgumentException -> 0x0083 }
        r3 = r2.zzdzq;	 Catch:{ IllegalArgumentException -> 0x0083 }
        r3 = r3.getContext();	 Catch:{ IllegalArgumentException -> 0x0083 }
        r4 = r2.zzdzq;	 Catch:{ IllegalArgumentException -> 0x0083 }
        r4 = r4.zzdzm;	 Catch:{ IllegalArgumentException -> 0x0083 }
        r3.unbindService(r4);	 Catch:{ IllegalArgumentException -> 0x0083 }
        goto L_0x0083;
    L_0x0067:
        r4 = r2.zzdzs;	 Catch:{ all -> 0x0014 }
        if (r4 != 0) goto L_0x0081;
    L_0x006b:
        r4 = r2.zzdzq;	 Catch:{ all -> 0x0014 }
        r0 = "onServiceConnected received after the timeout limit";
        r4.zzed(r0);	 Catch:{ all -> 0x0014 }
        r4 = r2.zzdzq;	 Catch:{ all -> 0x0014 }
        r4 = r4.zzya();	 Catch:{ all -> 0x0014 }
        r0 = new com.google.android.gms.internal.zzarr;	 Catch:{ all -> 0x0014 }
        r0.<init>(r2, r3);	 Catch:{ all -> 0x0014 }
        r4.zzd(r0);	 Catch:{ all -> 0x0014 }
        goto L_0x0083;
    L_0x0081:
        r2.zzdzr = r3;	 Catch:{ all -> 0x0014 }
    L_0x0083:
        r2.notifyAll();	 Catch:{ all -> 0x008c }
        monitor-exit(r2);	 Catch:{ all -> 0x008c }
        return;
    L_0x0088:
        r2.notifyAll();	 Catch:{ all -> 0x008c }
        throw r3;	 Catch:{ all -> 0x008c }
    L_0x008c:
        r3 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x008c }
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzarq.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        zzbq.zzgn("AnalyticsServiceConnection.onServiceDisconnected");
        this.zzdzq.zzya().zzd(new zzars(this, componentName));
    }

    public final zzasz zzyy() {
        zzk.zzwj();
        Intent intent = new Intent("com.google.android.gms.analytics.service.START");
        intent.setComponent(new ComponentName("com.google.android.gms", "com.google.android.gms.analytics.service.AnalyticsService"));
        Context context = this.zzdzq.getContext();
        intent.putExtra("app_package_name", context.getPackageName());
        zza zzanm = zza.zzanm();
        synchronized (this) {
            this.zzdzr = null;
            this.zzdzs = true;
            boolean zza = zzanm.zza(context, intent, this.zzdzq.zzdzm, 129);
            this.zzdzq.zza("Bind to service requested", Boolean.valueOf(zza));
            if (zza) {
                wait(((Long) zzast.zzecw.get()).longValue());
                try {
                } catch (InterruptedException unused) {
                    this.zzdzq.zzed("Wait for service connect was interrupted");
                }
            } else {
                this.zzdzs = false;
                return null;
            }
        }
        this.zzdzs = false;
        zzasz zzasz = this.zzdzr;
        this.zzdzr = null;
        if (zzasz == null) {
            this.zzdzq.zzee("Successfully bound to service but never got onServiceConnected callback");
        }
        return zzasz;
    }
}
