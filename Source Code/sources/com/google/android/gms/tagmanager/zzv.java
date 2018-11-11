package com.google.android.gms.tagmanager;

import android.os.Looper;
import com.google.android.gms.common.api.Status;

final class zzv implements ContainerHolder {
    private Status mStatus;
    private final Looper zzalj;
    private boolean zzgrz;
    private Container zzknk;
    private Container zzknl;
    private zzx zzknm;
    private zzw zzknn;
    private TagManager zzkno;

    public zzv(Status status) {
        this.mStatus = status;
        this.zzalj = null;
    }

    public zzv(TagManager tagManager, Looper looper, Container container, zzw zzw) {
        this.zzkno = tagManager;
        if (looper == null) {
            looper = Looper.getMainLooper();
        }
        this.zzalj = looper;
        this.zzknk = container;
        this.zzknn = zzw;
        this.mStatus = Status.zzftq;
        tagManager.zza(this);
    }

    private final void zzbfo() {
        if (this.zzknm != null) {
            zzx zzx = this.zzknm;
            zzx.sendMessage(zzx.obtainMessage(1, this.zzknl.zzbfl()));
        }
    }

    public final synchronized Container getContainer() {
        if (this.zzgrz) {
            zzdj.e("ContainerHolder is released.");
            return null;
        }
        if (this.zzknl != null) {
            this.zzknk = this.zzknl;
            this.zzknl = null;
        }
        return this.zzknk;
    }

    final String getContainerId() {
        if (!this.zzgrz) {
            return this.zzknk.getContainerId();
        }
        zzdj.e("getContainerId called on a released ContainerHolder.");
        return "";
    }

    public final Status getStatus() {
        return this.mStatus;
    }

    public final synchronized void refresh() {
        if (this.zzgrz) {
            zzdj.e("Refreshing a released ContainerHolder.");
        } else {
            this.zzknn.zzbfp();
        }
    }

    public final synchronized void release() {
        if (this.zzgrz) {
            zzdj.e("Releasing a released ContainerHolder.");
            return;
        }
        this.zzgrz = true;
        this.zzkno.zzb(this);
        this.zzknk.release();
        this.zzknk = null;
        this.zzknl = null;
        this.zzknn = null;
        this.zzknm = null;
    }

    /* JADX WARNING: Missing block: B:18:0x0024, code:
            return;
     */
    public final synchronized void setContainerAvailableListener(com.google.android.gms.tagmanager.ContainerHolder.ContainerAvailableListener r3) {
        /*
        r2 = this;
        monitor-enter(r2);
        r0 = r2.zzgrz;	 Catch:{ all -> 0x0025 }
        if (r0 == 0) goto L_0x000c;
    L_0x0005:
        r3 = "ContainerHolder is released.";
        com.google.android.gms.tagmanager.zzdj.e(r3);	 Catch:{ all -> 0x0025 }
        monitor-exit(r2);
        return;
    L_0x000c:
        if (r3 != 0) goto L_0x0013;
    L_0x000e:
        r3 = 0;
        r2.zzknm = r3;	 Catch:{ all -> 0x0025 }
        monitor-exit(r2);
        return;
    L_0x0013:
        r0 = new com.google.android.gms.tagmanager.zzx;	 Catch:{ all -> 0x0025 }
        r1 = r2.zzalj;	 Catch:{ all -> 0x0025 }
        r0.<init>(r2, r3, r1);	 Catch:{ all -> 0x0025 }
        r2.zzknm = r0;	 Catch:{ all -> 0x0025 }
        r3 = r2.zzknl;	 Catch:{ all -> 0x0025 }
        if (r3 == 0) goto L_0x0023;
    L_0x0020:
        r2.zzbfo();	 Catch:{ all -> 0x0025 }
    L_0x0023:
        monitor-exit(r2);
        return;
    L_0x0025:
        r3 = move-exception;
        monitor-exit(r2);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzv.setContainerAvailableListener(com.google.android.gms.tagmanager.ContainerHolder$ContainerAvailableListener):void");
    }

    public final synchronized void zza(Container container) {
        if (!this.zzgrz) {
            this.zzknl = container;
            zzbfo();
        }
    }

    final String zzbfn() {
        if (!this.zzgrz) {
            return this.zzknn.zzbfn();
        }
        zzdj.e("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
        return "";
    }

    public final synchronized void zzlj(String str) {
        if (!this.zzgrz) {
            this.zzknk.zzlj(str);
        }
    }

    final void zzlk(String str) {
        if (this.zzgrz) {
            zzdj.e("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
        } else {
            this.zzknn.zzlk(str);
        }
    }
}
