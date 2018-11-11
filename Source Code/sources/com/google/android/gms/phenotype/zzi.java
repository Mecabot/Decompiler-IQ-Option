package com.google.android.gms.phenotype;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;
import java.util.Arrays;
import java.util.Comparator;

public final class zzi extends zzbgl implements Comparable<zzi> {
    public static final Creator<zzi> CREATOR = new zzk();
    private static Comparator<zzi> zzkgq = new zzj();
    public final String name;
    private String zzgim;
    private boolean zzili;
    private double zzilk;
    private long zzkgm;
    private byte[] zzkgn;
    private int zzkgo;
    public final int zzkgp;

    public zzi(String str, long j, boolean z, double d, String str2, byte[] bArr, int i, int i2) {
        this.name = str;
        this.zzkgm = j;
        this.zzili = z;
        this.zzilk = d;
        this.zzgim = str2;
        this.zzkgn = bArr;
        this.zzkgo = i;
        this.zzkgp = i2;
    }

    private static int compare(int i, int i2) {
        return i < i2 ? -1 : i == i2 ? 0 : 1;
    }

    public final /* synthetic */ int compareTo(Object obj) {
        zzi zzi = (zzi) obj;
        int compareTo = this.name.compareTo(zzi.name);
        if (compareTo != 0) {
            return compareTo;
        }
        compareTo = compare(this.zzkgo, zzi.zzkgo);
        if (compareTo != 0) {
            return compareTo;
        }
        int i = 0;
        switch (this.zzkgo) {
            case 1:
                long j = this.zzkgm;
                long j2 = zzi.zzkgm;
                return j < j2 ? -1 : j == j2 ? 0 : 1;
            case 2:
                boolean z = this.zzili;
                return z == zzi.zzili ? 0 : z ? 1 : -1;
            case 3:
                return Double.compare(this.zzilk, zzi.zzilk);
            case 4:
                String str = this.zzgim;
                String str2 = zzi.zzgim;
                return str == str2 ? 0 : str == null ? -1 : str2 == null ? 1 : str.compareTo(str2);
            case 5:
                if (this.zzkgn == zzi.zzkgn) {
                    return 0;
                }
                if (this.zzkgn == null) {
                    return -1;
                }
                if (zzi.zzkgn == null) {
                    return 1;
                }
                while (i < Math.min(this.zzkgn.length, zzi.zzkgn.length)) {
                    compareTo = this.zzkgn[i] - zzi.zzkgn[i];
                    if (compareTo != 0) {
                        return compareTo;
                    }
                    i++;
                }
                return compare(this.zzkgn.length, zzi.zzkgn.length);
            default:
                compareTo = this.zzkgo;
                StringBuilder stringBuilder = new StringBuilder(31);
                stringBuilder.append("Invalid enum value: ");
                stringBuilder.append(compareTo);
                throw new AssertionError(stringBuilder.toString());
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzi) {
            zzi zzi = (zzi) obj;
            if (!zzn.equals(this.name, zzi.name) || this.zzkgo != zzi.zzkgo || this.zzkgp != zzi.zzkgp) {
                return false;
            }
            switch (this.zzkgo) {
                case 1:
                    if (this.zzkgm == zzi.zzkgm) {
                        return true;
                    }
                    break;
                case 2:
                    return this.zzili == zzi.zzili;
                case 3:
                    return this.zzilk == zzi.zzilk;
                case 4:
                    return zzn.equals(this.zzgim, zzi.zzgim);
                case 5:
                    return Arrays.equals(this.zzkgn, zzi.zzkgn);
                default:
                    int i = this.zzkgo;
                    StringBuilder stringBuilder = new StringBuilder(31);
                    stringBuilder.append("Invalid enum value: ");
                    stringBuilder.append(i);
                    throw new AssertionError(stringBuilder.toString());
            }
        }
        return false;
    }

    /* JADX WARNING: Missing block: B:9:0x0061, code:
            r0.append(r1);
            r1 = "'";
     */
    /* JADX WARNING: Missing block: B:10:0x0066, code:
            r0.append(r1);
     */
    /* JADX WARNING: Missing block: B:14:0x007b, code:
            r0.append(", ");
            r0.append(r5.zzkgo);
            r0.append(", ");
            r0.append(r5.zzkgp);
            r0.append(")");
     */
    /* JADX WARNING: Missing block: B:15:0x0098, code:
            return r0.toString();
     */
    public final java.lang.String toString() {
        /*
        r5 = this;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "Flag(";
        r0.append(r1);
        r1 = r5.name;
        r0.append(r1);
        r1 = ", ";
        r0.append(r1);
        r1 = r5.zzkgo;
        switch(r1) {
            case 1: goto L_0x0076;
            case 2: goto L_0x0070;
            case 3: goto L_0x006a;
            case 4: goto L_0x005a;
            case 5: goto L_0x0046;
            default: goto L_0x0019;
        };
    L_0x0019:
        r0 = new java.lang.AssertionError;
        r1 = r5.name;
        r2 = r5.zzkgo;
        r3 = java.lang.String.valueOf(r1);
        r3 = r3.length();
        r3 = r3 + 27;
        r4 = new java.lang.StringBuilder;
        r4.<init>(r3);
        r3 = "Invalid type: ";
        r4.append(r3);
        r4.append(r1);
        r1 = ", ";
        r4.append(r1);
        r4.append(r2);
        r1 = r4.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0046:
        r1 = r5.zzkgn;
        if (r1 != 0) goto L_0x004d;
    L_0x004a:
        r1 = "null";
        goto L_0x0066;
    L_0x004d:
        r1 = "'";
        r0.append(r1);
        r1 = r5.zzkgn;
        r2 = 3;
        r1 = android.util.Base64.encodeToString(r1, r2);
        goto L_0x0061;
    L_0x005a:
        r1 = "'";
        r0.append(r1);
        r1 = r5.zzgim;
    L_0x0061:
        r0.append(r1);
        r1 = "'";
    L_0x0066:
        r0.append(r1);
        goto L_0x007b;
    L_0x006a:
        r1 = r5.zzilk;
        r0.append(r1);
        goto L_0x007b;
    L_0x0070:
        r1 = r5.zzili;
        r0.append(r1);
        goto L_0x007b;
    L_0x0076:
        r1 = r5.zzkgm;
        r0.append(r1);
    L_0x007b:
        r1 = ", ";
        r0.append(r1);
        r1 = r5.zzkgo;
        r0.append(r1);
        r1 = ", ";
        r0.append(r1);
        r1 = r5.zzkgp;
        r0.append(r1);
        r1 = ")";
        r0.append(r1);
        r0 = r0.toString();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.phenotype.zzi.toString():java.lang.String");
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = zzbgo.zze(parcel);
        zzbgo.zza(parcel, 2, this.name, false);
        zzbgo.zza(parcel, 3, this.zzkgm);
        zzbgo.zza(parcel, 4, this.zzili);
        zzbgo.zza(parcel, 5, this.zzilk);
        zzbgo.zza(parcel, 6, this.zzgim, false);
        zzbgo.zza(parcel, 7, this.zzkgn, false);
        zzbgo.zzc(parcel, 8, this.zzkgo);
        zzbgo.zzc(parcel, 9, this.zzkgp);
        zzbgo.zzai(parcel, i);
    }
}
