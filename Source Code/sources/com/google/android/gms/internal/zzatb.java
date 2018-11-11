package com.google.android.gms.internal;

import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.util.zze;

@Hide
public final class zzatb {
    private final zze zzata;
    private final String zzdxe;
    private final long zzedo;
    private final int zzedp;
    private double zzedq;
    private long zzedr;
    private final Object zzeds;

    private zzatb(int i, long j, String str, zze zze) {
        this.zzeds = new Object();
        this.zzedp = 60;
        this.zzedq = (double) this.zzedp;
        this.zzedo = 2000;
        this.zzdxe = str;
        this.zzata = zze;
    }

    public zzatb(String str, zze zze) {
        this(60, 2000, str, zze);
    }

    public final boolean zzaas() {
        synchronized (this.zzeds) {
            long currentTimeMillis = this.zzata.currentTimeMillis();
            if (this.zzedq < ((double) this.zzedp)) {
                double d = ((double) (currentTimeMillis - this.zzedr)) / ((double) this.zzedo);
                if (d > 0.0d) {
                    this.zzedq = Math.min((double) this.zzedp, this.zzedq + d);
                }
            }
            this.zzedr = currentTimeMillis;
            if (this.zzedq >= 1.0d) {
                this.zzedq -= 1.0d;
                return true;
            }
            String str = this.zzdxe;
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 34);
            stringBuilder.append("Excessive ");
            stringBuilder.append(str);
            stringBuilder.append(" detected; call ignored.");
            zzatc.zzcz(stringBuilder.toString());
            return false;
        }
    }
}
