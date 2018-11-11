package com.google.android.gms.internal;

import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzbj.zza;
import com.google.android.gms.tagmanager.zzdj;
import com.google.android.gms.tagmanager.zzgk;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Hide
public final class zzdkh {
    private static zzbt zza(int i, zzbp zzbp, zzbt[] zzbtArr, Set<Integer> set) {
        StringBuilder stringBuilder;
        if (set.contains(Integer.valueOf(i))) {
            String valueOf = String.valueOf(set);
            stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 90);
            stringBuilder.append("Value cycle detected.  Current value reference: ");
            stringBuilder.append(i);
            stringBuilder.append(".  Previous value references: ");
            stringBuilder.append(valueOf);
            stringBuilder.append(".");
            zzna(stringBuilder.toString());
        }
        zzbt zzbt = (zzbt) zza(zzbp.zzww, i, "values");
        if (zzbtArr[i] != null) {
            return zzbtArr[i];
        }
        zzbt zzbt2 = null;
        set.add(Integer.valueOf(i));
        int i2 = 0;
        int length;
        int i3;
        int i4;
        zza zzm;
        int[] iArr;
        switch (zzbt.type) {
            case 1:
            case 5:
            case 6:
            case 8:
                zzbt2 = zzbt;
                break;
            case 2:
                zza zzm2 = zzm(zzbt);
                zzbt zzl = zzl(zzbt);
                zzl.zzyl = new zzbt[zzm2.zzxx.length];
                int[] iArr2 = zzm2.zzxx;
                length = iArr2.length;
                i3 = 0;
                while (i2 < length) {
                    i4 = i3 + 1;
                    zzl.zzyl[i3] = zza(iArr2[i2], zzbp, zzbtArr, (Set) set);
                    i2++;
                    i3 = i4;
                }
                zzbt2 = zzl;
                break;
            case 3:
                zzbt2 = zzl(zzbt);
                zzm = zzm(zzbt);
                if (zzm.zzxy.length != zzm.zzxz.length) {
                    length = zzm.zzxy.length;
                    i3 = zzm.zzxz.length;
                    StringBuilder stringBuilder2 = new StringBuilder(58);
                    stringBuilder2.append("Uneven map keys (");
                    stringBuilder2.append(length);
                    stringBuilder2.append(") and map values (");
                    stringBuilder2.append(i3);
                    stringBuilder2.append(")");
                    zzna(stringBuilder2.toString());
                }
                zzbt2.zzym = new zzbt[zzm.zzxy.length];
                zzbt2.zzyn = new zzbt[zzm.zzxy.length];
                int[] iArr3 = zzm.zzxy;
                i3 = iArr3.length;
                int i5 = 0;
                int i6 = 0;
                while (i5 < i3) {
                    int i7 = i6 + 1;
                    zzbt2.zzym[i6] = zza(iArr3[i5], zzbp, zzbtArr, (Set) set);
                    i5++;
                    i6 = i7;
                }
                iArr = zzm.zzxz;
                length = iArr.length;
                i3 = 0;
                while (i2 < length) {
                    i4 = i3 + 1;
                    zzbt2.zzyn[i3] = zza(iArr[i2], zzbp, zzbtArr, (Set) set);
                    i2++;
                    i3 = i4;
                }
                break;
            case 4:
                zzbt2 = zzl(zzbt);
                zzbt2.zzyo = zzgk.zzd(zza(zzm(zzbt).zzyc, zzbp, zzbtArr, (Set) set));
                break;
            case 7:
                zzbt2 = zzl(zzbt);
                zzm = zzm(zzbt);
                zzbt2.zzys = new zzbt[zzm.zzyb.length];
                iArr = zzm.zzyb;
                length = iArr.length;
                i3 = 0;
                while (i2 < length) {
                    i4 = i3 + 1;
                    zzbt2.zzys[i3] = zza(iArr[i2], zzbp, zzbtArr, (Set) set);
                    i2++;
                    i3 = i4;
                }
                break;
        }
        if (zzbt2 == null) {
            String valueOf2 = String.valueOf(zzbt);
            stringBuilder = new StringBuilder(String.valueOf(valueOf2).length() + 15);
            stringBuilder.append("Invalid value: ");
            stringBuilder.append(valueOf2);
            zzna(stringBuilder.toString());
        }
        zzbtArr[i] = zzbt2;
        set.remove(Integer.valueOf(i));
        return zzbt2;
    }

    private static zzdkj zza(zzbl zzbl, zzbp zzbp, zzbt[] zzbtArr, int i) {
        zzdkk zzbku = zzdkj.zzbku();
        for (int valueOf : zzbl.zzwh) {
            zzbo zzbo = (zzbo) zza(zzbp.zzwx, Integer.valueOf(valueOf).intValue(), "properties");
            String str = (String) zza(zzbp.zzwv, zzbo.key, "keys");
            zzbt zzbt = (zzbt) zza(zzbtArr, zzbo.value, "values");
            if (zzbi.PUSH_AFTER_EVALUATE.toString().equals(str)) {
                zzbku.zzn(zzbt);
            } else {
                zzbku.zzb(str, zzbt);
            }
        }
        return zzbku.zzbkv();
    }

    public static zzdkl zza(zzbp zzbp) {
        int i;
        zzbt[] zzbtArr = new zzbt[zzbp.zzww.length];
        int i2 = 0;
        for (int i3 = 0; i3 < zzbp.zzww.length; i3++) {
            zza(i3, zzbp, zzbtArr, new HashSet(0));
        }
        zzdkm zzbkw = zzdkl.zzbkw();
        List arrayList = new ArrayList();
        for (int i4 = 0; i4 < zzbp.zzwz.length; i4++) {
            arrayList.add(zza(zzbp.zzwz[i4], zzbp, zzbtArr, i4));
        }
        List arrayList2 = new ArrayList();
        for (int i5 = 0; i5 < zzbp.zzxa.length; i5++) {
            arrayList2.add(zza(zzbp.zzxa[i5], zzbp, zzbtArr, i5));
        }
        List arrayList3 = new ArrayList();
        for (i = 0; i < zzbp.zzwy.length; i++) {
            zzdkj zza = zza(zzbp.zzwy[i], zzbp, zzbtArr, i);
            zzbkw.zzc(zza);
            arrayList3.add(zza);
        }
        zzbq[] zzbqArr = zzbp.zzxb;
        i = zzbqArr.length;
        while (i2 < i) {
            zzbkw.zzb(zza(zzbqArr[i2], arrayList, arrayList3, arrayList2, zzbp));
            i2++;
        }
        zzbkw.zznn(zzbp.version);
        zzbkw.zzfk(zzbp.zzxj);
        return zzbkw.zzbky();
    }

    private static zzdkn zza(zzbq zzbq, List<zzdkj> list, List<zzdkj> list2, List<zzdkj> list3, zzbp zzbp) {
        zzdko zzdko = new zzdko();
        for (int valueOf : zzbq.zzxl) {
            zzdko.zzd((zzdkj) list3.get(Integer.valueOf(valueOf).intValue()));
        }
        for (int valueOf2 : zzbq.zzxm) {
            zzdko.zze((zzdkj) list3.get(Integer.valueOf(valueOf2).intValue()));
        }
        for (int valueOf3 : zzbq.zzxn) {
            zzdko.zzf((zzdkj) list.get(Integer.valueOf(valueOf3).intValue()));
        }
        for (int valueOf32 : zzbq.zzxp) {
            zzdko.zzno(zzbp.zzww[Integer.valueOf(valueOf32).intValue()].string);
        }
        for (int valueOf322 : zzbq.zzxo) {
            zzdko.zzg((zzdkj) list.get(Integer.valueOf(valueOf322).intValue()));
        }
        for (int valueOf4 : zzbq.zzxq) {
            zzdko.zznp(zzbp.zzww[Integer.valueOf(valueOf4).intValue()].string);
        }
        for (int valueOf42 : zzbq.zzxr) {
            zzdko.zzh((zzdkj) list2.get(Integer.valueOf(valueOf42).intValue()));
        }
        for (int valueOf422 : zzbq.zzxt) {
            zzdko.zznq(zzbp.zzww[Integer.valueOf(valueOf422).intValue()].string);
        }
        for (int valueOf4222 : zzbq.zzxs) {
            zzdko.zzi((zzdkj) list2.get(Integer.valueOf(valueOf4222).intValue()));
        }
        for (int valueOf5 : zzbq.zzxu) {
            zzdko.zznr(zzbp.zzww[Integer.valueOf(valueOf5).intValue()].string);
        }
        return zzdko.zzblb();
    }

    private static <T> T zza(T[] tArr, int i, String str) {
        if (i < 0 || i >= tArr.length) {
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 45);
            stringBuilder.append("Index out of bounds detected: ");
            stringBuilder.append(i);
            stringBuilder.append(" in ");
            stringBuilder.append(str);
            zzna(stringBuilder.toString());
        }
        return tArr[i];
    }

    public static void zzb(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    public static zzbt zzl(zzbt zzbt) {
        zzbt zzbt2 = new zzbt();
        zzbt2.type = zzbt.type;
        zzbt2.zzyt = (int[]) zzbt.zzyt.clone();
        if (zzbt.zzyu) {
            zzbt2.zzyu = zzbt.zzyu;
        }
        return zzbt2;
    }

    private static zza zzm(zzbt zzbt) {
        if (((zza) zzbt.zza(zza.zzxv)) == null) {
            String valueOf = String.valueOf(zzbt);
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 54);
            stringBuilder.append("Expected a ServingValue and didn't get one. Value is: ");
            stringBuilder.append(valueOf);
            zzna(stringBuilder.toString());
        }
        return (zza) zzbt.zza(zza.zzxv);
    }

    private static void zzna(String str) {
        zzdj.e(str);
        throw new zzdkp(str);
    }
}
