package com.google.android.gms.internal;

public final class zzbj {

    public static final class zza extends zzflm<zza> {
        public static final zzfln<zzbt, zza> zzxv = zzfln.zza(11, zza.class, 810);
        private static final zza[] zzxw = new zza[0];
        public int[] zzxx;
        public int[] zzxy;
        public int[] zzxz;
        private int zzya;
        public int[] zzyb;
        public int zzyc;
        private int zzyd;

        public zza() {
            this.zzxx = zzflv.zzpvy;
            this.zzxy = zzflv.zzpvy;
            this.zzxz = zzflv.zzpvy;
            this.zzya = 0;
            this.zzyb = zzflv.zzpvy;
            this.zzyc = 0;
            this.zzyd = 0;
            this.zzpvl = null;
            this.zzpnr = -1;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza = (zza) obj;
            return (zzflq.equals(this.zzxx, zza.zzxx) && zzflq.equals(this.zzxy, zza.zzxy) && zzflq.equals(this.zzxz, zza.zzxz) && this.zzya == zza.zzya && zzflq.equals(this.zzyb, zza.zzyb) && this.zzyc == zza.zzyc && this.zzyd == zza.zzyd) ? (this.zzpvl == null || this.zzpvl.isEmpty()) ? zza.zzpvl == null || zza.zzpvl.isEmpty() : this.zzpvl.equals(zza.zzpvl) : false;
        }

        public final int hashCode() {
            int hashCode = (((((((((((((((getClass().getName().hashCode() + 527) * 31) + zzflq.hashCode(this.zzxx)) * 31) + zzflq.hashCode(this.zzxy)) * 31) + zzflq.hashCode(this.zzxz)) * 31) + this.zzya) * 31) + zzflq.hashCode(this.zzyb)) * 31) + this.zzyc) * 31) + this.zzyd) * 31;
            int hashCode2 = (this.zzpvl == null || this.zzpvl.isEmpty()) ? 0 : this.zzpvl.hashCode();
            return hashCode + hashCode2;
        }

        public final void zza(zzflk zzflk) {
            if (this.zzxx != null && this.zzxx.length > 0) {
                for (int zzad : this.zzxx) {
                    zzflk.zzad(1, zzad);
                }
            }
            if (this.zzxy != null && this.zzxy.length > 0) {
                for (int zzad2 : this.zzxy) {
                    zzflk.zzad(2, zzad2);
                }
            }
            if (this.zzxz != null && this.zzxz.length > 0) {
                for (int zzad22 : this.zzxz) {
                    zzflk.zzad(3, zzad22);
                }
            }
            if (this.zzya != 0) {
                zzflk.zzad(4, this.zzya);
            }
            if (this.zzyb != null && this.zzyb.length > 0) {
                for (int zzad3 : this.zzyb) {
                    zzflk.zzad(5, zzad3);
                }
            }
            if (this.zzyc != 0) {
                zzflk.zzad(6, this.zzyc);
            }
            if (this.zzyd != 0) {
                zzflk.zzad(7, this.zzyd);
            }
            super.zza(zzflk);
        }

        protected final int zzq() {
            int i;
            int i2;
            int zzq = super.zzq();
            if (this.zzxx != null && this.zzxx.length > 0) {
                i = 0;
                for (int zzlx : this.zzxx) {
                    i += zzflk.zzlx(zzlx);
                }
                zzq = (zzq + i) + (this.zzxx.length * 1);
            }
            if (this.zzxy != null && this.zzxy.length > 0) {
                i = 0;
                for (int zzlx2 : this.zzxy) {
                    i += zzflk.zzlx(zzlx2);
                }
                zzq = (zzq + i) + (this.zzxy.length * 1);
            }
            if (this.zzxz != null && this.zzxz.length > 0) {
                i = 0;
                for (int zzlx22 : this.zzxz) {
                    i += zzflk.zzlx(zzlx22);
                }
                zzq = (zzq + i) + (this.zzxz.length * 1);
            }
            if (this.zzya != 0) {
                zzq += zzflk.zzag(4, this.zzya);
            }
            if (this.zzyb != null && this.zzyb.length > 0) {
                i2 = 0;
                for (int i3 : this.zzyb) {
                    i2 += zzflk.zzlx(i3);
                }
                zzq = (zzq + i2) + (this.zzyb.length * 1);
            }
            if (this.zzyc != 0) {
                zzq += zzflk.zzag(6, this.zzyc);
            }
            return this.zzyd != 0 ? zzq + zzflk.zzag(7, this.zzyd) : zzq;
        }
    }
}
