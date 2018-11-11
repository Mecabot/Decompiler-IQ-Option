package com.google.android.gms.internal;

public final class zzbt extends zzflm<zzbt> {
    private static volatile zzbt[] zzyk;
    public String string;
    public int type;
    public zzbt[] zzyl;
    public zzbt[] zzym;
    public zzbt[] zzyn;
    public String zzyo;
    public String zzyp;
    public long zzyq;
    public boolean zzyr;
    public zzbt[] zzys;
    public int[] zzyt;
    public boolean zzyu;

    public zzbt() {
        this.type = 1;
        this.string = "";
        this.zzyl = zzx();
        this.zzym = zzx();
        this.zzyn = zzx();
        this.zzyo = "";
        this.zzyp = "";
        this.zzyq = 0;
        this.zzyr = false;
        this.zzys = zzx();
        this.zzyt = zzflv.zzpvy;
        this.zzyu = false;
        this.zzpvl = null;
        this.zzpnr = -1;
    }

    private static int zze(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
                return i;
            default:
                StringBuilder stringBuilder = new StringBuilder(40);
                stringBuilder.append(i);
                stringBuilder.append(" is not a valid enum Escaping");
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    /* JADX WARNING: Can't wrap try/catch for R(5:20|21|22|136|18) */
    /* JADX WARNING: Missing block: B:19:0x0068, code:
            if (r9.zzcyo() > 0) goto L_0x006a;
     */
    /* JADX WARNING: Missing block: B:21:?, code:
            zze(r9.zzcym());
     */
    /* JADX WARNING: Missing block: B:22:0x0071, code:
            r4 = r4 + 1;
     */
    /* JADX WARNING: Missing block: B:23:0x0074, code:
            if (r4 != 0) goto L_0x0076;
     */
    /* JADX WARNING: Missing block: B:24:0x0076, code:
            r9.zzmw(r3);
     */
    /* JADX WARNING: Missing block: B:25:0x007b, code:
            if (r8.zzyt == null) goto L_0x007d;
     */
    /* JADX WARNING: Missing block: B:26:0x007d, code:
            r3 = 0;
     */
    /* JADX WARNING: Missing block: B:27:0x007f, code:
            r3 = r8.zzyt.length;
     */
    /* JADX WARNING: Missing block: B:28:0x0082, code:
            r4 = new int[(r4 + r3)];
     */
    /* JADX WARNING: Missing block: B:29:0x0085, code:
            if (r3 != 0) goto L_0x0087;
     */
    /* JADX WARNING: Missing block: B:30:0x0087, code:
            java.lang.System.arraycopy(r8.zzyt, 0, r4, 0, r3);
     */
    /* JADX WARNING: Missing block: B:32:0x0090, code:
            if (r9.zzcyo() > 0) goto L_0x0092;
     */
    /* JADX WARNING: Missing block: B:33:0x0092, code:
            r2 = r9.getPosition();
     */
    /* JADX WARNING: Missing block: B:35:?, code:
            r4[r3] = zze(r9.zzcym());
     */
    /* JADX WARNING: Missing block: B:36:0x00a0, code:
            r3 = r3 + 1;
     */
    /* JADX WARNING: Missing block: B:37:0x00a3, code:
            r9.zzmw(r2);
            zza(r9, 80);
     */
    /* JADX WARNING: Missing block: B:38:0x00aa, code:
            r8.zzyt = r4;
     */
    /* JADX WARNING: Missing block: B:39:0x00ac, code:
            r9.zzlj(r0);
     */
    private final com.google.android.gms.internal.zzbt zzf(com.google.android.gms.internal.zzflj r9) {
        /*
        r8 = this;
    L_0x0000:
        r0 = r9.zzcxx();
        r1 = 80;
        r2 = 0;
        switch(r0) {
            case 0: goto L_0x0219;
            case 8: goto L_0x01e8;
            case 18: goto L_0x01e0;
            case 26: goto L_0x01a0;
            case 34: goto L_0x0160;
            case 42: goto L_0x0120;
            case 50: goto L_0x0118;
            case 58: goto L_0x0110;
            case 64: goto L_0x0108;
            case 72: goto L_0x0100;
            case 80: goto L_0x00b1;
            case 82: goto L_0x0057;
            case 90: goto L_0x0018;
            case 96: goto L_0x0011;
            default: goto L_0x000a;
        };
    L_0x000a:
        r0 = super.zza(r9, r0);
        if (r0 != 0) goto L_0x0000;
    L_0x0010:
        return r8;
    L_0x0011:
        r0 = r9.zzcyd();
        r8.zzyr = r0;
        goto L_0x0000;
    L_0x0018:
        r0 = 90;
        r0 = com.google.android.gms.internal.zzflv.zzb(r9, r0);
        r1 = r8.zzys;
        if (r1 != 0) goto L_0x0024;
    L_0x0022:
        r1 = 0;
        goto L_0x0027;
    L_0x0024:
        r1 = r8.zzys;
        r1 = r1.length;
    L_0x0027:
        r0 = r0 + r1;
        r0 = new com.google.android.gms.internal.zzbt[r0];
        if (r1 == 0) goto L_0x0031;
    L_0x002c:
        r3 = r8.zzys;
        java.lang.System.arraycopy(r3, r2, r0, r2, r1);
    L_0x0031:
        r2 = r0.length;
        r2 = r2 + -1;
        if (r1 >= r2) goto L_0x0048;
    L_0x0036:
        r2 = new com.google.android.gms.internal.zzbt;
        r2.<init>();
        r0[r1] = r2;
        r2 = r0[r1];
        r9.zza(r2);
        r9.zzcxx();
        r1 = r1 + 1;
        goto L_0x0031;
    L_0x0048:
        r2 = new com.google.android.gms.internal.zzbt;
        r2.<init>();
        r0[r1] = r2;
        r1 = r0[r1];
        r9.zza(r1);
        r8.zzys = r0;
        goto L_0x0000;
    L_0x0057:
        r0 = r9.zzcym();
        r0 = r9.zzli(r0);
        r3 = r9.getPosition();
        r4 = 0;
    L_0x0064:
        r5 = r9.zzcyo();
        if (r5 <= 0) goto L_0x0074;
    L_0x006a:
        r5 = r9.zzcym();	 Catch:{ IllegalArgumentException -> 0x0064 }
        zze(r5);	 Catch:{ IllegalArgumentException -> 0x0064 }
        r4 = r4 + 1;
        goto L_0x0064;
    L_0x0074:
        if (r4 == 0) goto L_0x00ac;
    L_0x0076:
        r9.zzmw(r3);
        r3 = r8.zzyt;
        if (r3 != 0) goto L_0x007f;
    L_0x007d:
        r3 = 0;
        goto L_0x0082;
    L_0x007f:
        r3 = r8.zzyt;
        r3 = r3.length;
    L_0x0082:
        r4 = r4 + r3;
        r4 = new int[r4];
        if (r3 == 0) goto L_0x008c;
    L_0x0087:
        r5 = r8.zzyt;
        java.lang.System.arraycopy(r5, r2, r4, r2, r3);
    L_0x008c:
        r2 = r9.zzcyo();
        if (r2 <= 0) goto L_0x00aa;
    L_0x0092:
        r2 = r9.getPosition();
        r5 = r9.zzcym();	 Catch:{ IllegalArgumentException -> 0x00a3 }
        r5 = zze(r5);	 Catch:{ IllegalArgumentException -> 0x00a3 }
        r4[r3] = r5;	 Catch:{ IllegalArgumentException -> 0x00a3 }
        r3 = r3 + 1;
        goto L_0x008c;
    L_0x00a3:
        r9.zzmw(r2);
        r8.zza(r9, r1);
        goto L_0x008c;
    L_0x00aa:
        r8.zzyt = r4;
    L_0x00ac:
        r9.zzlj(r0);
        goto L_0x0000;
    L_0x00b1:
        r1 = com.google.android.gms.internal.zzflv.zzb(r9, r1);
        r3 = new int[r1];
        r4 = 0;
        r5 = 0;
    L_0x00b9:
        if (r4 >= r1) goto L_0x00da;
    L_0x00bb:
        if (r4 == 0) goto L_0x00c0;
    L_0x00bd:
        r9.zzcxx();
    L_0x00c0:
        r6 = r9.getPosition();
        r7 = r9.zzcym();	 Catch:{ IllegalArgumentException -> 0x00d1 }
        r7 = zze(r7);	 Catch:{ IllegalArgumentException -> 0x00d1 }
        r3[r5] = r7;	 Catch:{ IllegalArgumentException -> 0x00d1 }
        r5 = r5 + 1;
        goto L_0x00d7;
    L_0x00d1:
        r9.zzmw(r6);
        r8.zza(r9, r0);
    L_0x00d7:
        r4 = r4 + 1;
        goto L_0x00b9;
    L_0x00da:
        if (r5 == 0) goto L_0x0000;
    L_0x00dc:
        r0 = r8.zzyt;
        if (r0 != 0) goto L_0x00e2;
    L_0x00e0:
        r0 = 0;
        goto L_0x00e5;
    L_0x00e2:
        r0 = r8.zzyt;
        r0 = r0.length;
    L_0x00e5:
        if (r0 != 0) goto L_0x00ee;
    L_0x00e7:
        r1 = r3.length;
        if (r5 != r1) goto L_0x00ee;
    L_0x00ea:
        r8.zzyt = r3;
        goto L_0x0000;
    L_0x00ee:
        r1 = r0 + r5;
        r1 = new int[r1];
        if (r0 == 0) goto L_0x00f9;
    L_0x00f4:
        r4 = r8.zzyt;
        java.lang.System.arraycopy(r4, r2, r1, r2, r0);
    L_0x00f9:
        java.lang.System.arraycopy(r3, r2, r1, r0, r5);
        r8.zzyt = r1;
        goto L_0x0000;
    L_0x0100:
        r0 = r9.zzcyd();
        r8.zzyu = r0;
        goto L_0x0000;
    L_0x0108:
        r0 = r9.zzcyr();
        r8.zzyq = r0;
        goto L_0x0000;
    L_0x0110:
        r0 = r9.readString();
        r8.zzyp = r0;
        goto L_0x0000;
    L_0x0118:
        r0 = r9.readString();
        r8.zzyo = r0;
        goto L_0x0000;
    L_0x0120:
        r0 = 42;
        r0 = com.google.android.gms.internal.zzflv.zzb(r9, r0);
        r1 = r8.zzyn;
        if (r1 != 0) goto L_0x012c;
    L_0x012a:
        r1 = 0;
        goto L_0x012f;
    L_0x012c:
        r1 = r8.zzyn;
        r1 = r1.length;
    L_0x012f:
        r0 = r0 + r1;
        r0 = new com.google.android.gms.internal.zzbt[r0];
        if (r1 == 0) goto L_0x0139;
    L_0x0134:
        r3 = r8.zzyn;
        java.lang.System.arraycopy(r3, r2, r0, r2, r1);
    L_0x0139:
        r2 = r0.length;
        r2 = r2 + -1;
        if (r1 >= r2) goto L_0x0150;
    L_0x013e:
        r2 = new com.google.android.gms.internal.zzbt;
        r2.<init>();
        r0[r1] = r2;
        r2 = r0[r1];
        r9.zza(r2);
        r9.zzcxx();
        r1 = r1 + 1;
        goto L_0x0139;
    L_0x0150:
        r2 = new com.google.android.gms.internal.zzbt;
        r2.<init>();
        r0[r1] = r2;
        r1 = r0[r1];
        r9.zza(r1);
        r8.zzyn = r0;
        goto L_0x0000;
    L_0x0160:
        r0 = 34;
        r0 = com.google.android.gms.internal.zzflv.zzb(r9, r0);
        r1 = r8.zzym;
        if (r1 != 0) goto L_0x016c;
    L_0x016a:
        r1 = 0;
        goto L_0x016f;
    L_0x016c:
        r1 = r8.zzym;
        r1 = r1.length;
    L_0x016f:
        r0 = r0 + r1;
        r0 = new com.google.android.gms.internal.zzbt[r0];
        if (r1 == 0) goto L_0x0179;
    L_0x0174:
        r3 = r8.zzym;
        java.lang.System.arraycopy(r3, r2, r0, r2, r1);
    L_0x0179:
        r2 = r0.length;
        r2 = r2 + -1;
        if (r1 >= r2) goto L_0x0190;
    L_0x017e:
        r2 = new com.google.android.gms.internal.zzbt;
        r2.<init>();
        r0[r1] = r2;
        r2 = r0[r1];
        r9.zza(r2);
        r9.zzcxx();
        r1 = r1 + 1;
        goto L_0x0179;
    L_0x0190:
        r2 = new com.google.android.gms.internal.zzbt;
        r2.<init>();
        r0[r1] = r2;
        r1 = r0[r1];
        r9.zza(r1);
        r8.zzym = r0;
        goto L_0x0000;
    L_0x01a0:
        r0 = 26;
        r0 = com.google.android.gms.internal.zzflv.zzb(r9, r0);
        r1 = r8.zzyl;
        if (r1 != 0) goto L_0x01ac;
    L_0x01aa:
        r1 = 0;
        goto L_0x01af;
    L_0x01ac:
        r1 = r8.zzyl;
        r1 = r1.length;
    L_0x01af:
        r0 = r0 + r1;
        r0 = new com.google.android.gms.internal.zzbt[r0];
        if (r1 == 0) goto L_0x01b9;
    L_0x01b4:
        r3 = r8.zzyl;
        java.lang.System.arraycopy(r3, r2, r0, r2, r1);
    L_0x01b9:
        r2 = r0.length;
        r2 = r2 + -1;
        if (r1 >= r2) goto L_0x01d0;
    L_0x01be:
        r2 = new com.google.android.gms.internal.zzbt;
        r2.<init>();
        r0[r1] = r2;
        r2 = r0[r1];
        r9.zza(r2);
        r9.zzcxx();
        r1 = r1 + 1;
        goto L_0x01b9;
    L_0x01d0:
        r2 = new com.google.android.gms.internal.zzbt;
        r2.<init>();
        r0[r1] = r2;
        r1 = r0[r1];
        r9.zza(r1);
        r8.zzyl = r0;
        goto L_0x0000;
    L_0x01e0:
        r0 = r9.readString();
        r8.string = r0;
        goto L_0x0000;
    L_0x01e8:
        r1 = r9.getPosition();
        r2 = r9.zzcym();	 Catch:{ IllegalArgumentException -> 0x0211 }
        switch(r2) {
            case 1: goto L_0x01f6;
            case 2: goto L_0x01f6;
            case 3: goto L_0x01f6;
            case 4: goto L_0x01f6;
            case 5: goto L_0x01f6;
            case 6: goto L_0x01f6;
            case 7: goto L_0x01f6;
            case 8: goto L_0x01f6;
            default: goto L_0x01f3;
        };	 Catch:{ IllegalArgumentException -> 0x0211 }
    L_0x01f3:
        r3 = new java.lang.IllegalArgumentException;	 Catch:{ IllegalArgumentException -> 0x0211 }
        goto L_0x01fa;
    L_0x01f6:
        r8.type = r2;	 Catch:{ IllegalArgumentException -> 0x0211 }
        goto L_0x0000;
    L_0x01fa:
        r4 = 36;
        r5 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x0211 }
        r5.<init>(r4);	 Catch:{ IllegalArgumentException -> 0x0211 }
        r5.append(r2);	 Catch:{ IllegalArgumentException -> 0x0211 }
        r2 = " is not a valid enum Type";
        r5.append(r2);	 Catch:{ IllegalArgumentException -> 0x0211 }
        r2 = r5.toString();	 Catch:{ IllegalArgumentException -> 0x0211 }
        r3.<init>(r2);	 Catch:{ IllegalArgumentException -> 0x0211 }
        throw r3;	 Catch:{ IllegalArgumentException -> 0x0211 }
    L_0x0211:
        r9.zzmw(r1);
        r8.zza(r9, r0);
        goto L_0x0000;
    L_0x0219:
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzbt.zzf(com.google.android.gms.internal.zzflj):com.google.android.gms.internal.zzbt");
    }

    public static zzbt[] zzx() {
        if (zzyk == null) {
            synchronized (zzflq.zzpvt) {
                if (zzyk == null) {
                    zzyk = new zzbt[0];
                }
            }
        }
        return zzyk;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzbt)) {
            return false;
        }
        zzbt zzbt = (zzbt) obj;
        if (this.type != zzbt.type) {
            return false;
        }
        if (this.string == null) {
            if (zzbt.string != null) {
                return false;
            }
        } else if (!this.string.equals(zzbt.string)) {
            return false;
        }
        if (!zzflq.equals(this.zzyl, zzbt.zzyl) || !zzflq.equals(this.zzym, zzbt.zzym) || !zzflq.equals(this.zzyn, zzbt.zzyn)) {
            return false;
        }
        if (this.zzyo == null) {
            if (zzbt.zzyo != null) {
                return false;
            }
        } else if (!this.zzyo.equals(zzbt.zzyo)) {
            return false;
        }
        if (this.zzyp == null) {
            if (zzbt.zzyp != null) {
                return false;
            }
        } else if (!this.zzyp.equals(zzbt.zzyp)) {
            return false;
        }
        return (this.zzyq == zzbt.zzyq && this.zzyr == zzbt.zzyr && zzflq.equals(this.zzys, zzbt.zzys) && zzflq.equals(this.zzyt, zzbt.zzyt) && this.zzyu == zzbt.zzyu) ? (this.zzpvl == null || this.zzpvl.isEmpty()) ? zzbt.zzpvl == null || zzbt.zzpvl.isEmpty() : this.zzpvl.equals(zzbt.zzpvl) : false;
    }

    public final int hashCode() {
        int i = 0;
        int i2 = 1237;
        int hashCode = (((((((((((((((((((((((getClass().getName().hashCode() + 527) * 31) + this.type) * 31) + (this.string == null ? 0 : this.string.hashCode())) * 31) + zzflq.hashCode(this.zzyl)) * 31) + zzflq.hashCode(this.zzym)) * 31) + zzflq.hashCode(this.zzyn)) * 31) + (this.zzyo == null ? 0 : this.zzyo.hashCode())) * 31) + (this.zzyp == null ? 0 : this.zzyp.hashCode())) * 31) + ((int) (this.zzyq ^ (this.zzyq >>> 32)))) * 31) + (this.zzyr ? 1231 : 1237)) * 31) + zzflq.hashCode(this.zzys)) * 31) + zzflq.hashCode(this.zzyt)) * 31;
        if (this.zzyu) {
            i2 = 1231;
        }
        hashCode = (hashCode + i2) * 31;
        if (!(this.zzpvl == null || this.zzpvl.isEmpty())) {
            i = this.zzpvl.hashCode();
        }
        return hashCode + i;
    }

    public final void zza(zzflk zzflk) {
        zzflk.zzad(1, this.type);
        if (!(this.string == null || this.string.equals(""))) {
            zzflk.zzp(2, this.string);
        }
        if (this.zzyl != null && this.zzyl.length > 0) {
            for (zzfls zzfls : this.zzyl) {
                if (zzfls != null) {
                    zzflk.zza(3, zzfls);
                }
            }
        }
        if (this.zzym != null && this.zzym.length > 0) {
            for (zzfls zzfls2 : this.zzym) {
                if (zzfls2 != null) {
                    zzflk.zza(4, zzfls2);
                }
            }
        }
        if (this.zzyn != null && this.zzyn.length > 0) {
            for (zzfls zzfls22 : this.zzyn) {
                if (zzfls22 != null) {
                    zzflk.zza(5, zzfls22);
                }
            }
        }
        if (!(this.zzyo == null || this.zzyo.equals(""))) {
            zzflk.zzp(6, this.zzyo);
        }
        if (!(this.zzyp == null || this.zzyp.equals(""))) {
            zzflk.zzp(7, this.zzyp);
        }
        if (this.zzyq != 0) {
            zzflk.zzf(8, this.zzyq);
        }
        if (this.zzyu) {
            zzflk.zzl(9, this.zzyu);
        }
        if (this.zzyt != null && this.zzyt.length > 0) {
            for (int zzad : this.zzyt) {
                zzflk.zzad(10, zzad);
            }
        }
        if (this.zzys != null && this.zzys.length > 0) {
            for (zzfls zzfls3 : this.zzys) {
                if (zzfls3 != null) {
                    zzflk.zza(11, zzfls3);
                }
            }
        }
        if (this.zzyr) {
            zzflk.zzl(12, this.zzyr);
        }
        super.zza(zzflk);
    }

    protected final int zzq() {
        int i;
        int zzq = super.zzq() + zzflk.zzag(1, this.type);
        if (!(this.string == null || this.string.equals(""))) {
            zzq += zzflk.zzq(2, this.string);
        }
        if (this.zzyl != null && this.zzyl.length > 0) {
            i = zzq;
            for (zzfls zzfls : this.zzyl) {
                if (zzfls != null) {
                    i += zzflk.zzb(3, zzfls);
                }
            }
            zzq = i;
        }
        if (this.zzym != null && this.zzym.length > 0) {
            i = zzq;
            for (zzfls zzfls2 : this.zzym) {
                if (zzfls2 != null) {
                    i += zzflk.zzb(4, zzfls2);
                }
            }
            zzq = i;
        }
        if (this.zzyn != null && this.zzyn.length > 0) {
            i = zzq;
            for (zzfls zzfls22 : this.zzyn) {
                if (zzfls22 != null) {
                    i += zzflk.zzb(5, zzfls22);
                }
            }
            zzq = i;
        }
        if (!(this.zzyo == null || this.zzyo.equals(""))) {
            zzq += zzflk.zzq(6, this.zzyo);
        }
        if (!(this.zzyp == null || this.zzyp.equals(""))) {
            zzq += zzflk.zzq(7, this.zzyp);
        }
        if (this.zzyq != 0) {
            zzq += zzflk.zzc(8, this.zzyq);
        }
        if (this.zzyu) {
            zzq += zzflk.zzlw(9) + 1;
        }
        if (this.zzyt != null && this.zzyt.length > 0) {
            int i2 = 0;
            for (int zzlx : this.zzyt) {
                i2 += zzflk.zzlx(zzlx);
            }
            zzq = (zzq + i2) + (this.zzyt.length * 1);
        }
        if (this.zzys != null && this.zzys.length > 0) {
            for (zzfls zzfls3 : this.zzys) {
                if (zzfls3 != null) {
                    zzq += zzflk.zzb(11, zzfls3);
                }
            }
        }
        return this.zzyr ? zzq + (zzflk.zzlw(12) + 1) : zzq;
    }
}
