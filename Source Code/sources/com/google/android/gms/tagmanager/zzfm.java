package com.google.android.gms.tagmanager;

import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzi;

final class zzfm implements zzek {
    private final zze zzata;
    private final long zzedo;
    private final int zzedp;
    private double zzedq;
    private final Object zzeds;
    private long zzkth;

    public zzfm() {
        this(60, 2000);
    }

    private zzfm(int i, long j) {
        this.zzeds = new Object();
        this.zzedp = 60;
        this.zzedq = (double) this.zzedp;
        this.zzedo = 2000;
        this.zzata = zzi.zzanq();
    }

    public final boolean zzaas() {
        synchronized (this.zzeds) {
            long currentTimeMillis = this.zzata.currentTimeMillis();
            if (this.zzedq < ((double) this.zzedp)) {
                double d = ((double) (currentTimeMillis - this.zzkth)) / ((double) this.zzedo);
                if (d > 0.0d) {
                    this.zzedq = Math.min((double) this.zzedp, this.zzedq + d);
                }
            }
            this.zzkth = currentTimeMillis;
            if (this.zzedq >= 1.0d) {
                this.zzedq -= 1.0d;
                return true;
            }
            zzdj.zzcz("No more tokens available.");
            return false;
        }
    }
}
