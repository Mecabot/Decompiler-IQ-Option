package com.google.android.gms.tagmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.google.android.gms.common.internal.Hide;

@Hide
final class zzfo extends zzfn {
    private static final Object zzkti = new Object();
    private static zzfo zzktu;
    private boolean connected = true;
    private Context zzktj;
    private zzcc zzktk;
    private volatile zzbz zzktl;
    private int zzktm = 1800000;
    private boolean zzktn = true;
    private boolean zzkto = false;
    private boolean zzktp = true;
    private zzcd zzktq = new zzfp(this);
    private zzfr zzktr;
    private zzdo zzkts;
    private boolean zzktt = false;

    private zzfo() {
    }

    private final boolean isPowerSaveMode() {
        return this.zzktt || !this.connected || this.zzktm <= 0;
    }

    public static zzfo zzbhz() {
        if (zzktu == null) {
            zzktu = new zzfo();
        }
        return zzktu;
    }

    public final synchronized void dispatch() {
        if (this.zzkto) {
            this.zzktl.zzm(new zzfq(this));
            return;
        }
        zzdj.v("Dispatch call queued. Dispatch will run once initialization is complete.");
        this.zzktn = true;
    }

    /* JADX WARNING: Missing block: B:11:0x0014, code:
            return;
     */
    final synchronized void zza(android.content.Context r2, com.google.android.gms.tagmanager.zzbz r3) {
        /*
        r1 = this;
        monitor-enter(r1);
        r0 = r1.zzktj;	 Catch:{ all -> 0x0015 }
        if (r0 == 0) goto L_0x0007;
    L_0x0005:
        monitor-exit(r1);
        return;
    L_0x0007:
        r2 = r2.getApplicationContext();	 Catch:{ all -> 0x0015 }
        r1.zzktj = r2;	 Catch:{ all -> 0x0015 }
        r2 = r1.zzktl;	 Catch:{ all -> 0x0015 }
        if (r2 != 0) goto L_0x0013;
    L_0x0011:
        r1.zzktl = r3;	 Catch:{ all -> 0x0015 }
    L_0x0013:
        monitor-exit(r1);
        return;
    L_0x0015:
        r2 = move-exception;
        monitor-exit(r1);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzfo.zza(android.content.Context, com.google.android.gms.tagmanager.zzbz):void");
    }

    public final synchronized void zzbhy() {
        if (!isPowerSaveMode()) {
            this.zzktr.zzbic();
        }
    }

    final synchronized zzcc zzbia() {
        if (this.zzktk == null) {
            if (this.zzktj == null) {
                throw new IllegalStateException("Cant get a store unless we have a context");
            }
            this.zzktk = new zzec(this.zzktq, this.zzktj);
        }
        if (this.zzktr == null) {
            this.zzktr = new zzfs(this, null);
            if (this.zzktm > 0) {
                this.zzktr.zzs((long) this.zzktm);
            }
        }
        this.zzkto = true;
        if (this.zzktn) {
            dispatch();
            this.zzktn = false;
        }
        if (this.zzkts == null && this.zzktp) {
            this.zzkts = new zzdo(this);
            BroadcastReceiver broadcastReceiver = this.zzkts;
            Context context = this.zzktj;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            context.registerReceiver(broadcastReceiver, intentFilter);
            intentFilter = new IntentFilter();
            intentFilter.addAction("com.google.analytics.RADIO_POWERED");
            intentFilter.addCategory(context.getPackageName());
            context.registerReceiver(broadcastReceiver, intentFilter);
        }
        return this.zzktk;
    }

    public final synchronized void zzca(boolean z) {
        zzd(this.zzktt, z);
    }

    final synchronized void zzd(boolean z, boolean z2) {
        boolean isPowerSaveMode = isPowerSaveMode();
        this.zzktt = z;
        this.connected = z2;
        if (isPowerSaveMode() != isPowerSaveMode) {
            if (isPowerSaveMode()) {
                this.zzktr.cancel();
                zzdj.v("PowerSaveMode initiated.");
                return;
            }
            this.zzktr.zzs((long) this.zzktm);
            zzdj.v("PowerSaveMode terminated.");
        }
    }
}
