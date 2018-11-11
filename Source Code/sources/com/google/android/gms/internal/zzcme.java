package com.google.android.gms.internal;

import android.content.ComponentName;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbq;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Hide
public final class zzcme extends zzcli {
    private final zzcms zzjrb;
    private zzcjb zzjrc;
    private volatile Boolean zzjrd;
    private final zzcip zzjre;
    private final zzcni zzjrf;
    private final List<Runnable> zzjrg = new ArrayList();
    private final zzcip zzjrh;

    protected zzcme(zzckj zzckj) {
        super(zzckj);
        this.zzjrf = new zzcni(zzckj.zzxx());
        this.zzjrb = new zzcms(this);
        this.zzjre = new zzcmf(this, zzckj);
        this.zzjrh = new zzcmk(this, zzckj);
    }

    @WorkerThread
    private final void onServiceDisconnected(ComponentName componentName) {
        zzwj();
        if (this.zzjrc != null) {
            this.zzjrc = null;
            zzayp().zzbba().zzj("Disconnected from device MeasurementService", componentName);
            zzwj();
            zzzh();
        }
    }

    @WorkerThread
    private final void zzbcl() {
        zzwj();
        zzayp().zzbba().zzj("Processing queued up service tasks", Integer.valueOf(this.zzjrg.size()));
        for (Runnable run : this.zzjrg) {
            try {
                run.run();
            } catch (Throwable th) {
                zzayp().zzbau().zzj("Task exception while flushing queue", th);
            }
        }
        this.zzjrg.clear();
        this.zzjrh.cancel();
    }

    @Nullable
    @WorkerThread
    private final zzcif zzbw(boolean z) {
        return zzaye().zzjo(z ? zzayp().zzbbc() : null);
    }

    @WorkerThread
    private final void zzk(Runnable runnable) {
        zzwj();
        if (isConnected()) {
            runnable.run();
        } else if (((long) this.zzjrg.size()) >= 1000) {
            zzayp().zzbau().log("Discarding data. Max runnable queue size reached");
        } else {
            this.zzjrg.add(runnable);
            this.zzjrh.zzs(60000);
            zzzh();
        }
    }

    @WorkerThread
    private final void zzyw() {
        zzwj();
        this.zzjrf.start();
        this.zzjre.zzs(((Long) zzciz.zzjjt.get()).longValue());
    }

    @WorkerThread
    private final void zzyx() {
        zzwj();
        if (isConnected()) {
            zzayp().zzbba().log("Inactivity, disconnecting from the service");
            disconnect();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0012 A:{Splitter: B:1:0x0006, ExcHandler: java.lang.IllegalStateException (unused java.lang.IllegalStateException)} */
    /* JADX WARNING: Missing block: B:3:0x0012, code:
            r2.zzjrc = null;
     */
    /* JADX WARNING: Missing block: B:4:0x0015, code:
            return;
     */
    @android.support.annotation.WorkerThread
    public final void disconnect() {
        /*
        r2 = this;
        r2.zzwj();
        r2.zzyk();
        com.google.android.gms.common.stats.zza.zzanm();	 Catch:{ IllegalStateException -> 0x0012, IllegalStateException -> 0x0012 }
        r0 = r2.getContext();	 Catch:{ IllegalStateException -> 0x0012, IllegalStateException -> 0x0012 }
        r1 = r2.zzjrb;	 Catch:{ IllegalStateException -> 0x0012, IllegalStateException -> 0x0012 }
        r0.unbindService(r1);	 Catch:{ IllegalStateException -> 0x0012, IllegalStateException -> 0x0012 }
    L_0x0012:
        r0 = 0;
        r2.zzjrc = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcme.disconnect():void");
    }

    @WorkerThread
    public final boolean isConnected() {
        zzwj();
        zzyk();
        return this.zzjrc != null;
    }

    @WorkerThread
    protected final void resetAnalyticsData() {
        zzwj();
        zzyk();
        zzcif zzbw = zzbw(false);
        zzayi().resetAnalyticsData();
        zzk(new zzcmg(this, zzbw));
    }

    @WorkerThread
    protected final void zza(zzcjb zzcjb) {
        zzwj();
        zzbq.checkNotNull(zzcjb);
        this.zzjrc = zzcjb;
        zzyw();
        zzbcl();
    }

    @WorkerThread
    final void zza(zzcjb zzcjb, zzbgl zzbgl, zzcif zzcif) {
        zzcjl zzbau;
        String str;
        zzwj();
        zzyk();
        int i = 0;
        int i2 = 100;
        while (i < 1001 && i2 == 100) {
            int size;
            List arrayList = new ArrayList();
            Object zzep = zzayi().zzep(100);
            if (zzep != null) {
                arrayList.addAll(zzep);
                size = zzep.size();
            } else {
                size = 0;
            }
            if (zzbgl != null && size < 100) {
                arrayList.add(zzbgl);
            }
            ArrayList arrayList2 = (ArrayList) arrayList;
            int size2 = arrayList2.size();
            int i3 = 0;
            while (i3 < size2) {
                Object obj = arrayList2.get(i3);
                i3++;
                zzbgl zzbgl2 = (zzbgl) obj;
                if (zzbgl2 instanceof zzcix) {
                    try {
                        zzcjb.zza((zzcix) zzbgl2, zzcif);
                    } catch (RemoteException e) {
                        obj = e;
                        zzbau = zzayp().zzbau();
                        str = "Failed to send event to the service";
                        zzbau.zzj(str, obj);
                    }
                } else if (zzbgl2 instanceof zzcnl) {
                    try {
                        zzcjb.zza((zzcnl) zzbgl2, zzcif);
                    } catch (RemoteException e2) {
                        obj = e2;
                        zzbau = zzayp().zzbau();
                        str = "Failed to send attribute to the service";
                        zzbau.zzj(str, obj);
                    }
                } else if (zzbgl2 instanceof zzcii) {
                    try {
                        zzcjb.zza((zzcii) zzbgl2, zzcif);
                    } catch (RemoteException e3) {
                        obj = e3;
                        zzbau = zzayp().zzbau();
                        str = "Failed to send conditional property to the service";
                        zzbau.zzj(str, obj);
                    }
                } else {
                    zzayp().zzbau().log("Discarding data. Unrecognized parcel type.");
                }
            }
            i++;
            i2 = size;
        }
    }

    @WorkerThread
    protected final void zza(zzclz zzclz) {
        zzwj();
        zzyk();
        zzk(new zzcmj(this, zzclz));
    }

    @WorkerThread
    public final void zza(AtomicReference<String> atomicReference) {
        zzwj();
        zzyk();
        zzk(new zzcmh(this, atomicReference, zzbw(false)));
    }

    @WorkerThread
    protected final void zza(AtomicReference<List<zzcii>> atomicReference, String str, String str2, String str3) {
        zzwj();
        zzyk();
        zzk(new zzcmo(this, atomicReference, str, str2, str3, zzbw(false)));
    }

    @WorkerThread
    protected final void zza(AtomicReference<List<zzcnl>> atomicReference, String str, String str2, String str3, boolean z) {
        zzwj();
        zzyk();
        zzk(new zzcmp(this, atomicReference, str, str2, str3, z, zzbw(false)));
    }

    @WorkerThread
    protected final void zza(AtomicReference<List<zzcnl>> atomicReference, boolean z) {
        zzwj();
        zzyk();
        zzk(new zzcmr(this, atomicReference, zzbw(false), z));
    }

    protected final boolean zzazq() {
        return false;
    }

    @WorkerThread
    protected final void zzb(zzcnl zzcnl) {
        zzwj();
        zzyk();
        zzk(new zzcmq(this, zzayi().zza(zzcnl), zzcnl, zzbw(true)));
    }

    @WorkerThread
    protected final void zzbci() {
        zzwj();
        zzyk();
        zzk(new zzcml(this, zzbw(true)));
    }

    @WorkerThread
    protected final void zzbcj() {
        zzwj();
        zzyk();
        zzk(new zzcmi(this, zzbw(true)));
    }

    final Boolean zzbck() {
        return this.zzjrd;
    }

    @WorkerThread
    protected final void zzc(zzcix zzcix, String str) {
        zzbq.checkNotNull(zzcix);
        zzwj();
        zzyk();
        zzk(new zzcmm(this, true, zzayi().zza(zzcix), zzcix, zzbw(true), str));
    }

    @WorkerThread
    protected final void zzf(zzcii zzcii) {
        zzbq.checkNotNull(zzcii);
        zzwj();
        zzyk();
        zzk(new zzcmn(this, true, zzayi().zzc(zzcii), new zzcii(zzcii), zzbw(true), zzcii));
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00de  */
    @android.support.annotation.WorkerThread
    final void zzzh() {
        /*
        r6 = this;
        r6.zzwj();
        r6.zzyk();
        r0 = r6.isConnected();
        if (r0 == 0) goto L_0x000d;
    L_0x000c:
        return;
    L_0x000d:
        r0 = r6.zzjrd;
        r1 = 0;
        r2 = 1;
        if (r0 != 0) goto L_0x00eb;
    L_0x0013:
        r6.zzwj();
        r6.zzyk();
        r0 = r6.zzayq();
        r0 = r0.zzbbg();
        if (r0 == 0) goto L_0x002c;
    L_0x0023:
        r0 = r0.booleanValue();
        if (r0 == 0) goto L_0x002c;
    L_0x0029:
        r3 = 1;
        goto L_0x00e5;
    L_0x002c:
        r0 = r6.zzaye();
        r0 = r0.zzbas();
        if (r0 != r2) goto L_0x003a;
    L_0x0036:
        r0 = 1;
        r3 = 1;
        goto L_0x00dc;
    L_0x003a:
        r0 = r6.zzayp();
        r0 = r0.zzbba();
        r3 = "Checking service availability";
        r0.log(r3);
        r0 = r6.zzayl();
        r3 = com.google.android.gms.common.zzf.zzahf();
        r0 = r0.getContext();
        r0 = r3.isGooglePlayServicesAvailable(r0);
        r3 = 9;
        if (r0 == r3) goto L_0x00d1;
    L_0x005b:
        r3 = 18;
        if (r0 == r3) goto L_0x00c6;
    L_0x005f:
        switch(r0) {
            case 0: goto L_0x00b7;
            case 1: goto L_0x00a8;
            case 2: goto L_0x0084;
            case 3: goto L_0x0076;
            default: goto L_0x0062;
        };
    L_0x0062:
        r3 = r6.zzayp();
        r3 = r3.zzbaw();
        r4 = "Unexpected service status";
        r0 = java.lang.Integer.valueOf(r0);
        r3.zzj(r4, r0);
    L_0x0073:
        r0 = 0;
    L_0x0074:
        r3 = 0;
        goto L_0x00dc;
    L_0x0076:
        r0 = r6.zzayp();
        r0 = r0.zzbaw();
        r3 = "Service disabled";
    L_0x0080:
        r0.log(r3);
        goto L_0x0073;
    L_0x0084:
        r0 = r6.zzayp();
        r0 = r0.zzbaz();
        r3 = "Service container out of date";
        r0.log(r3);
        r0 = r6.zzayq();
        r0 = r0.zzbbg();
        if (r0 == 0) goto L_0x00a4;
    L_0x009b:
        r0 = r0.booleanValue();
        if (r0 == 0) goto L_0x00a2;
    L_0x00a1:
        goto L_0x00a4;
    L_0x00a2:
        r0 = 0;
        goto L_0x00a5;
    L_0x00a4:
        r0 = 1;
    L_0x00a5:
        r3 = r0;
        r0 = 0;
        goto L_0x00dc;
    L_0x00a8:
        r0 = r6.zzayp();
        r0 = r0.zzbba();
        r3 = "Service missing";
        r0.log(r3);
        r0 = 1;
        goto L_0x0074;
    L_0x00b7:
        r0 = r6.zzayp();
        r0 = r0.zzbba();
        r3 = "Service available";
    L_0x00c1:
        r0.log(r3);
        goto L_0x0036;
    L_0x00c6:
        r0 = r6.zzayp();
        r0 = r0.zzbaw();
        r3 = "Service updating";
        goto L_0x00c1;
    L_0x00d1:
        r0 = r6.zzayp();
        r0 = r0.zzbaw();
        r3 = "Service invalid";
        goto L_0x0080;
    L_0x00dc:
        if (r0 == 0) goto L_0x00e5;
    L_0x00de:
        r0 = r6.zzayq();
        r0.zzbr(r3);
    L_0x00e5:
        r0 = java.lang.Boolean.valueOf(r3);
        r6.zzjrd = r0;
    L_0x00eb:
        r0 = r6.zzjrd;
        r0 = r0.booleanValue();
        if (r0 == 0) goto L_0x00f9;
    L_0x00f3:
        r0 = r6.zzjrb;
        r0.zzbcm();
        return;
    L_0x00f9:
        r0 = r6.getContext();
        r0 = r0.getPackageManager();
        r3 = new android.content.Intent;
        r3.<init>();
        r4 = r6.getContext();
        r5 = "com.google.android.gms.measurement.AppMeasurementService";
        r3 = r3.setClassName(r4, r5);
        r4 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
        r0 = r0.queryIntentServices(r3, r4);
        if (r0 == 0) goto L_0x011f;
    L_0x0118:
        r0 = r0.size();
        if (r0 <= 0) goto L_0x011f;
    L_0x011e:
        r1 = 1;
    L_0x011f:
        if (r1 == 0) goto L_0x013c;
    L_0x0121:
        r0 = new android.content.Intent;
        r1 = "com.google.android.gms.measurement.START";
        r0.<init>(r1);
        r1 = new android.content.ComponentName;
        r2 = r6.getContext();
        r3 = "com.google.android.gms.measurement.AppMeasurementService";
        r1.<init>(r2, r3);
        r0.setComponent(r1);
        r1 = r6.zzjrb;
        r1.zzm(r0);
        return;
    L_0x013c:
        r0 = r6.zzayp();
        r0 = r0.zzbau();
        r1 = "Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest";
        r0.log(r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcme.zzzh():void");
    }
}
