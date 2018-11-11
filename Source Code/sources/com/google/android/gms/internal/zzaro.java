package com.google.android.gms.internal;

import android.content.ComponentName;
import android.os.RemoteException;
import com.google.android.gms.analytics.zzk;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbq;
import java.util.Collections;

@Hide
public final class zzaro extends zzari {
    private final zzarq zzdzm = new zzarq(this);
    private zzasz zzdzn;
    private final zzasn zzdzo;
    private final zzatp zzdzp;

    protected zzaro(zzark zzark) {
        super(zzark);
        this.zzdzp = new zzatp(zzark.zzxx());
        this.zzdzo = new zzarp(this, zzark);
    }

    private final void onServiceDisconnected(ComponentName componentName) {
        zzk.zzwj();
        if (this.zzdzn != null) {
            this.zzdzn = null;
            zza("Disconnected from device AnalyticsService", componentName);
            zzj().zzxu();
        }
    }

    private final void zza(zzasz zzasz) {
        zzk.zzwj();
        this.zzdzn = zzasz;
        zzyw();
        zzj().onServiceConnected();
    }

    private final void zzyw() {
        this.zzdzp.start();
        this.zzdzo.zzs(((Long) zzast.zzecv.get()).longValue());
    }

    private final void zzyx() {
        zzk.zzwj();
        if (isConnected()) {
            zzea("Inactivity, disconnecting from device AnalyticsService");
            disconnect();
        }
    }

    public final boolean connect() {
        zzk.zzwj();
        zzyk();
        if (this.zzdzn != null) {
            return true;
        }
        zzasz zzyy = this.zzdzm.zzyy();
        if (zzyy == null) {
            return false;
        }
        this.zzdzn = zzyy;
        zzyw();
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0012 A:{Splitter: B:1:0x0006, ExcHandler: java.lang.IllegalStateException (unused java.lang.IllegalStateException)} */
    /* JADX WARNING: Missing block: B:4:0x0014, code:
            if (r2.zzdzn != null) goto L_0x0016;
     */
    /* JADX WARNING: Missing block: B:5:0x0016, code:
            r2.zzdzn = null;
            zzj().zzxu();
     */
    /* JADX WARNING: Missing block: B:6:?, code:
            return;
     */
    /* JADX WARNING: Missing block: B:7:?, code:
            return;
     */
    public final void disconnect() {
        /*
        r2 = this;
        com.google.android.gms.analytics.zzk.zzwj();
        r2.zzyk();
        com.google.android.gms.common.stats.zza.zzanm();	 Catch:{ IllegalStateException -> 0x0012, IllegalStateException -> 0x0012 }
        r0 = r2.getContext();	 Catch:{ IllegalStateException -> 0x0012, IllegalStateException -> 0x0012 }
        r1 = r2.zzdzm;	 Catch:{ IllegalStateException -> 0x0012, IllegalStateException -> 0x0012 }
        r0.unbindService(r1);	 Catch:{ IllegalStateException -> 0x0012, IllegalStateException -> 0x0012 }
    L_0x0012:
        r0 = r2.zzdzn;
        if (r0 == 0) goto L_0x0020;
    L_0x0016:
        r0 = 0;
        r2.zzdzn = r0;
        r0 = r2.zzj();
        r0.zzxu();
    L_0x0020:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzaro.disconnect():void");
    }

    public final boolean isConnected() {
        zzk.zzwj();
        zzyk();
        return this.zzdzn != null;
    }

    public final boolean zzb(zzasy zzasy) {
        zzbq.checkNotNull(zzasy);
        zzk.zzwj();
        zzyk();
        zzasz zzasz = this.zzdzn;
        if (zzasz == null) {
            return false;
        }
        try {
            zzasz.zza(zzasy.zzjq(), zzasy.zzaan(), zzasy.zzaap() ? zzasl.zzaab() : zzasl.zzaac(), Collections.emptyList());
            zzyw();
            return true;
        } catch (RemoteException unused) {
            zzea("Failed to send hits to AnalyticsService");
            return false;
        }
    }

    protected final void zzwk() {
    }

    public final boolean zzyv() {
        zzk.zzwj();
        zzyk();
        zzasz zzasz = this.zzdzn;
        if (zzasz == null) {
            return false;
        }
        try {
            zzasz.zzxr();
            zzyw();
            return true;
        } catch (RemoteException unused) {
            zzea("Failed to clear hits from AnalyticsService");
            return false;
        }
    }
}
