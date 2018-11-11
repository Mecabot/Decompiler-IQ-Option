package com.google.android.gms.tagmanager;

import com.google.android.gms.common.util.zze;

final class zzdh implements zzek {
    private final zze zzata;
    private final String zzdxe;
    private final long zzedo = 900000;
    private final int zzedp = 5;
    private double zzedq = ((double) Math.min(1, 5));
    private long zzedr;
    private final Object zzeds = new Object();
    private final long zzkqu = 5000;

    public zzdh(int i, int i2, long j, long j2, String str, zze zze) {
        this.zzdxe = str;
        this.zzata = zze;
    }

    public final boolean zzaas() {
        synchronized (this.zzeds) {
            long currentTimeMillis = this.zzata.currentTimeMillis();
            String str;
            StringBuilder stringBuilder;
            if (currentTimeMillis - this.zzedr < this.zzkqu) {
                str = this.zzdxe;
                stringBuilder = new StringBuilder(String.valueOf(str).length() + 34);
                stringBuilder.append("Excessive ");
                stringBuilder.append(str);
                stringBuilder.append(" detected; call ignored.");
                zzdj.zzcz(stringBuilder.toString());
                return false;
            }
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
            str = this.zzdxe;
            stringBuilder = new StringBuilder(String.valueOf(str).length() + 34);
            stringBuilder.append("Excessive ");
            stringBuilder.append(str);
            stringBuilder.append(" detected; call ignored.");
            zzdj.zzcz(stringBuilder.toString());
            return false;
        }
    }
}
