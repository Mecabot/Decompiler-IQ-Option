package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Looper;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.stats.zza;

public final class zzcms implements ServiceConnection, zzf, zzg {
    final /* synthetic */ zzcme zzjri;
    private volatile boolean zzjrp;
    private volatile zzcji zzjrq;

    protected zzcms(zzcme zzcme) {
        this.zzjri = zzcme;
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:? A:{Catch:{ DeadObjectException -> 0x0022, DeadObjectException -> 0x0022 }, Splitter: B:6:0x0022, ExcHandler: android.os.DeadObjectException (unused android.os.DeadObjectException)} */
    /* JADX WARNING: Missing block: B:7:?, code:
            r3.zzjrq = null;
            r3.zzjrp = false;
     */
    @android.support.annotation.MainThread
    public final void onConnected(@android.support.annotation.Nullable android.os.Bundle r4) {
        /*
        r3 = this;
        r4 = "MeasurementServiceConnection.onConnected";
        com.google.android.gms.common.internal.zzbq.zzgn(r4);
        monitor-enter(r3);
        r4 = 0;
        r0 = r3.zzjrq;	 Catch:{ DeadObjectException -> 0x0022, DeadObjectException -> 0x0022 }
        r0 = r0.zzalw();	 Catch:{ DeadObjectException -> 0x0022, DeadObjectException -> 0x0022 }
        r0 = (com.google.android.gms.internal.zzcjb) r0;	 Catch:{ DeadObjectException -> 0x0022, DeadObjectException -> 0x0022 }
        r3.zzjrq = r4;	 Catch:{ DeadObjectException -> 0x0022, DeadObjectException -> 0x0022 }
        r1 = r3.zzjri;	 Catch:{ DeadObjectException -> 0x0022, DeadObjectException -> 0x0022 }
        r1 = r1.zzayo();	 Catch:{ DeadObjectException -> 0x0022, DeadObjectException -> 0x0022 }
        r2 = new com.google.android.gms.internal.zzcmv;	 Catch:{ DeadObjectException -> 0x0022, DeadObjectException -> 0x0022 }
        r2.<init>(r3, r0);	 Catch:{ DeadObjectException -> 0x0022, DeadObjectException -> 0x0022 }
        r1.zzh(r2);	 Catch:{ DeadObjectException -> 0x0022, DeadObjectException -> 0x0022 }
        goto L_0x0027;
    L_0x0020:
        r4 = move-exception;
        goto L_0x0029;
    L_0x0022:
        r3.zzjrq = r4;	 Catch:{ all -> 0x0020 }
        r4 = 0;
        r3.zzjrp = r4;	 Catch:{ all -> 0x0020 }
    L_0x0027:
        monitor-exit(r3);	 Catch:{ all -> 0x0020 }
        return;
    L_0x0029:
        monitor-exit(r3);	 Catch:{ all -> 0x0020 }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcms.onConnected(android.os.Bundle):void");
    }

    @MainThread
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        zzbq.zzgn("MeasurementServiceConnection.onConnectionFailed");
        zzcjj zzbbo = this.zzjri.zzjev.zzbbo();
        if (zzbbo != null) {
            zzbbo.zzbaw().zzj("Service connection failed", connectionResult);
        }
        synchronized (this) {
            this.zzjrp = false;
            this.zzjrq = null;
        }
        this.zzjri.zzayo().zzh(new zzcmx(this));
    }

    @MainThread
    public final void onConnectionSuspended(int i) {
        zzbq.zzgn("MeasurementServiceConnection.onConnectionSuspended");
        this.zzjri.zzayp().zzbaz().log("Service connection suspended");
        this.zzjri.zzayo().zzh(new zzcmw(this));
    }

    /* JADX WARNING: Missing block: B:22:?, code:
            r3.zzjri.zzayp().zzbau().log("Service connect failed to get IMeasurementService");
     */
    @android.support.annotation.MainThread
    public final void onServiceConnected(android.content.ComponentName r4, android.os.IBinder r5) {
        /*
        r3 = this;
        r4 = "MeasurementServiceConnection.onServiceConnected";
        com.google.android.gms.common.internal.zzbq.zzgn(r4);
        monitor-enter(r3);
        r4 = 0;
        if (r5 != 0) goto L_0x001f;
    L_0x0009:
        r3.zzjrp = r4;	 Catch:{ all -> 0x001c }
        r4 = r3.zzjri;	 Catch:{ all -> 0x001c }
        r4 = r4.zzayp();	 Catch:{ all -> 0x001c }
        r4 = r4.zzbau();	 Catch:{ all -> 0x001c }
        r5 = "Service connected with null binder";
        r4.log(r5);	 Catch:{ all -> 0x001c }
        monitor-exit(r3);	 Catch:{ all -> 0x001c }
        return;
    L_0x001c:
        r4 = move-exception;
        goto L_0x0099;
    L_0x001f:
        r0 = 0;
        r1 = r5.getInterfaceDescriptor();	 Catch:{ RemoteException -> 0x0063 }
        r2 = "com.google.android.gms.measurement.internal.IMeasurementService";
        r2 = r2.equals(r1);	 Catch:{ RemoteException -> 0x0063 }
        if (r2 == 0) goto L_0x0053;
    L_0x002c:
        if (r5 != 0) goto L_0x002f;
    L_0x002e:
        goto L_0x0043;
    L_0x002f:
        r1 = "com.google.android.gms.measurement.internal.IMeasurementService";
        r1 = r5.queryLocalInterface(r1);	 Catch:{ RemoteException -> 0x0063 }
        r2 = r1 instanceof com.google.android.gms.internal.zzcjb;	 Catch:{ RemoteException -> 0x0063 }
        if (r2 == 0) goto L_0x003d;
    L_0x0039:
        r1 = (com.google.android.gms.internal.zzcjb) r1;	 Catch:{ RemoteException -> 0x0063 }
    L_0x003b:
        r0 = r1;
        goto L_0x0043;
    L_0x003d:
        r1 = new com.google.android.gms.internal.zzcjd;	 Catch:{ RemoteException -> 0x0063 }
        r1.<init>(r5);	 Catch:{ RemoteException -> 0x0063 }
        goto L_0x003b;
    L_0x0043:
        r5 = r3.zzjri;	 Catch:{ RemoteException -> 0x0063 }
        r5 = r5.zzayp();	 Catch:{ RemoteException -> 0x0063 }
        r5 = r5.zzbba();	 Catch:{ RemoteException -> 0x0063 }
        r1 = "Bound to IMeasurementService interface";
        r5.log(r1);	 Catch:{ RemoteException -> 0x0063 }
        goto L_0x0072;
    L_0x0053:
        r5 = r3.zzjri;	 Catch:{ RemoteException -> 0x0063 }
        r5 = r5.zzayp();	 Catch:{ RemoteException -> 0x0063 }
        r5 = r5.zzbau();	 Catch:{ RemoteException -> 0x0063 }
        r2 = "Got binder with a wrong descriptor";
        r5.zzj(r2, r1);	 Catch:{ RemoteException -> 0x0063 }
        goto L_0x0072;
    L_0x0063:
        r5 = r3.zzjri;	 Catch:{ all -> 0x001c }
        r5 = r5.zzayp();	 Catch:{ all -> 0x001c }
        r5 = r5.zzbau();	 Catch:{ all -> 0x001c }
        r1 = "Service connect failed to get IMeasurementService";
        r5.log(r1);	 Catch:{ all -> 0x001c }
    L_0x0072:
        if (r0 != 0) goto L_0x0089;
    L_0x0074:
        r3.zzjrp = r4;	 Catch:{ all -> 0x001c }
        com.google.android.gms.common.stats.zza.zzanm();	 Catch:{ IllegalArgumentException -> 0x0097 }
        r4 = r3.zzjri;	 Catch:{ IllegalArgumentException -> 0x0097 }
        r4 = r4.getContext();	 Catch:{ IllegalArgumentException -> 0x0097 }
        r5 = r3.zzjri;	 Catch:{ IllegalArgumentException -> 0x0097 }
        r5 = r5.zzjrb;	 Catch:{ IllegalArgumentException -> 0x0097 }
        r4.unbindService(r5);	 Catch:{ IllegalArgumentException -> 0x0097 }
        goto L_0x0097;
    L_0x0089:
        r4 = r3.zzjri;	 Catch:{ all -> 0x001c }
        r4 = r4.zzayo();	 Catch:{ all -> 0x001c }
        r5 = new com.google.android.gms.internal.zzcmt;	 Catch:{ all -> 0x001c }
        r5.<init>(r3, r0);	 Catch:{ all -> 0x001c }
        r4.zzh(r5);	 Catch:{ all -> 0x001c }
    L_0x0097:
        monitor-exit(r3);	 Catch:{ all -> 0x001c }
        return;
    L_0x0099:
        monitor-exit(r3);	 Catch:{ all -> 0x001c }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcms.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
    }

    @MainThread
    public final void onServiceDisconnected(ComponentName componentName) {
        zzbq.zzgn("MeasurementServiceConnection.onServiceDisconnected");
        this.zzjri.zzayp().zzbaz().log("Service disconnected");
        this.zzjri.zzayo().zzh(new zzcmu(this, componentName));
    }

    @WorkerThread
    public final void zzbcm() {
        this.zzjri.zzwj();
        Context context = this.zzjri.getContext();
        synchronized (this) {
            if (this.zzjrp) {
                this.zzjri.zzayp().zzbba().log("Connection attempt already in progress");
            } else if (this.zzjrq != null) {
                this.zzjri.zzayp().zzbba().log("Already awaiting connection attempt");
            } else {
                this.zzjrq = new zzcji(context, Looper.getMainLooper(), this, this);
                this.zzjri.zzayp().zzbba().log("Connecting to remote service");
                this.zzjrp = true;
                this.zzjrq.zzals();
            }
        }
    }

    @WorkerThread
    public final void zzm(Intent intent) {
        this.zzjri.zzwj();
        Context context = this.zzjri.getContext();
        zza zzanm = zza.zzanm();
        synchronized (this) {
            if (this.zzjrp) {
                this.zzjri.zzayp().zzbba().log("Connection attempt already in progress");
                return;
            }
            this.zzjri.zzayp().zzbba().log("Using local app measurement service");
            this.zzjrp = true;
            zzanm.zza(context, intent, this.zzjri.zzjrb, 129);
        }
    }
}
