package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzbi;
import com.google.android.gms.internal.zzbr;
import com.google.android.gms.internal.zzbt;
import com.google.android.gms.internal.zzdkh;
import com.google.android.gms.internal.zzdkj;
import com.google.android.gms.internal.zzdkl;
import com.google.android.gms.internal.zzdkn;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class zzfc {
    private static final zzea<zzbt> zzksk = new zzea(zzgk.zzbil(), true);
    private final DataLayer zzknd;
    private final zzdkl zzksl;
    private final zzbo zzksm;
    private final Map<String, zzbr> zzksn;
    private final Map<String, zzbr> zzkso;
    private final Map<String, zzbr> zzksp;
    private final zzp<zzdkj, zzea<zzbt>> zzksq;
    private final zzp<String, zzfi> zzksr;
    private final Set<zzdkn> zzkss;
    private final Map<String, zzfj> zzkst;
    private volatile String zzksu;
    private int zzksv;

    public zzfc(Context context, zzdkl zzdkl, DataLayer dataLayer, zzan zzan, zzan zzan2, zzbo zzbo) {
        if (zzdkl == null) {
            throw new NullPointerException("resource cannot be null");
        }
        zzdkj zzdkj;
        this.zzksl = zzdkl;
        this.zzkss = new HashSet(zzdkl.zzbkb());
        this.zzknd = dataLayer;
        this.zzksm = zzbo;
        zzs zzfd = new zzfd(this);
        zzq zzq = new zzq();
        this.zzksq = zzq.zza(1048576, zzfd);
        zzfd = new zzfe(this);
        zzq zzq2 = new zzq();
        this.zzksr = zzq.zza(1048576, zzfd);
        this.zzksn = new HashMap();
        zzb(new zzm(context));
        zzb(new zzam(zzan2));
        zzb(new zzaz(dataLayer));
        zzb(new zzgl(context, dataLayer));
        this.zzkso = new HashMap();
        zzc(new zzak());
        zzc(new zzbl());
        zzc(new zzbm());
        zzc(new zzbt());
        zzc(new zzbu());
        zzc(new zzdf());
        zzc(new zzdg());
        zzc(new zzem());
        zzc(new zzfz());
        this.zzksp = new HashMap();
        zza(new zze(context));
        zza(new zzf(context));
        zza(new zzh(context));
        zza(new zzi(context));
        zza(new zzj(context));
        zza(new zzk(context));
        zza(new zzl(context));
        zza(new zzt());
        zza(new zzaj(this.zzksl.getVersion()));
        zza(new zzam(zzan));
        zza(new zzas(dataLayer));
        zza(new zzbc(context));
        zza(new zzbd());
        zza(new zzbk());
        zza(new zzbp(this));
        zza(new zzbv());
        zza(new zzbw());
        zza(new zzcw(context));
        zza(new zzcy());
        zza(new zzde());
        zza(new zzdl());
        zza(new zzdn(context));
        zza(new zzeb());
        zza(new zzef());
        zza(new zzej());
        zza(new zzel());
        zza(new zzen(context));
        zza(new zzfk());
        zza(new zzfl());
        zza(new zzgf());
        zza(new zzgm());
        this.zzkst = new HashMap();
        for (zzdkn zzdkn : this.zzkss) {
            for (int i = 0; i < zzdkn.zzbkz().size(); i++) {
                zzdkj zzdkj2 = (zzdkj) zzdkn.zzbkz().get(i);
                zzfj zzg = zzg(this.zzkst, zza(zzdkj2));
                zzg.zza(zzdkn);
                zzg.zza(zzdkn, zzdkj2);
                zzg.zza(zzdkn, "Unknown");
            }
            for (int i2 = 0; i2 < zzdkn.zzbla().size(); i2++) {
                zzdkj = (zzdkj) zzdkn.zzbla().get(i2);
                zzfj zzg2 = zzg(this.zzkst, zza(zzdkj));
                zzg2.zza(zzdkn);
                zzg2.zzb(zzdkn, zzdkj);
                zzg2.zzb(zzdkn, "Unknown");
            }
        }
        for (Entry entry : this.zzksl.zzbkx().entrySet()) {
            for (zzdkj zzdkj3 : (List) entry.getValue()) {
                if (!zzgk.zzh((zzbt) zzdkj3.zzbkd().get(zzbi.NOT_DEFAULT_MACRO.toString())).booleanValue()) {
                    zzg(this.zzkst, (String) entry.getKey()).zzb(zzdkj3);
                }
            }
        }
    }

    private final zzea<zzbt> zza(zzbt zzbt, Set<String> set, zzgn zzgn) {
        if (!zzbt.zzyu) {
            return new zzea(zzbt, true);
        }
        int i = zzbt.type;
        zzbt zzl;
        int i2;
        zzea zza;
        if (i != 7) {
            String str;
            String valueOf;
            switch (i) {
                case 2:
                    zzl = zzdkh.zzl(zzbt);
                    zzl.zzyl = new zzbt[zzbt.zzyl.length];
                    for (i2 = 0; i2 < zzbt.zzyl.length; i2++) {
                        zza = zza(zzbt.zzyl[i2], (Set) set, zzgn.zzfa(i2));
                        if (zza == zzksk) {
                            return zzksk;
                        }
                        zzl.zzyl[i2] = (zzbt) zza.getObject();
                    }
                    return new zzea(zzl, false);
                case 3:
                    zzl = zzdkh.zzl(zzbt);
                    if (zzbt.zzym.length != zzbt.zzyn.length) {
                        str = "Invalid serving value: ";
                        valueOf = String.valueOf(zzbt.toString());
                        zzdj.e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                        return zzksk;
                    }
                    zzl.zzym = new zzbt[zzbt.zzym.length];
                    zzl.zzyn = new zzbt[zzbt.zzym.length];
                    for (i2 = 0; i2 < zzbt.zzym.length; i2++) {
                        zza = zza(zzbt.zzym[i2], (Set) set, zzgn.zzfb(i2));
                        zzea zza2 = zza(zzbt.zzyn[i2], (Set) set, zzgn.zzfc(i2));
                        if (zza == zzksk || zza2 == zzksk) {
                            return zzksk;
                        }
                        zzl.zzym[i2] = (zzbt) zza.getObject();
                        zzl.zzyn[i2] = (zzbt) zza2.getObject();
                    }
                    return new zzea(zzl, false);
                case 4:
                    if (set.contains(zzbt.zzyo)) {
                        valueOf = zzbt.zzyo;
                        str = set.toString();
                        StringBuilder stringBuilder = new StringBuilder((String.valueOf(valueOf).length() + 79) + String.valueOf(str).length());
                        stringBuilder.append("Macro cycle detected.  Current macro reference: ");
                        stringBuilder.append(valueOf);
                        stringBuilder.append(".  Previous macro references: ");
                        stringBuilder.append(str);
                        stringBuilder.append(".");
                        zzdj.e(stringBuilder.toString());
                        return zzksk;
                    }
                    set.add(zzbt.zzyo);
                    zzea<zzbt> zza3 = zzgo.zza(zza(zzbt.zzyo, (Set) set, zzgn.zzbhc()), zzbt.zzyt);
                    set.remove(zzbt.zzyo);
                    return zza3;
                default:
                    int i3 = zzbt.type;
                    StringBuilder stringBuilder2 = new StringBuilder(25);
                    stringBuilder2.append("Unknown type: ");
                    stringBuilder2.append(i3);
                    zzdj.e(stringBuilder2.toString());
                    return zzksk;
            }
        }
        zzl = zzdkh.zzl(zzbt);
        zzl.zzys = new zzbt[zzbt.zzys.length];
        for (i2 = 0; i2 < zzbt.zzys.length; i2++) {
            zza = zza(zzbt.zzys[i2], (Set) set, zzgn.zzfd(i2));
            if (zza == zzksk) {
                return zzksk;
            }
            zzl.zzys[i2] = (zzbt) zza.getObject();
        }
        return new zzea(zzl, false);
    }

    private final zzea<Boolean> zza(zzdkj zzdkj, Set<String> set, zzeo zzeo) {
        zzea zza = zza(this.zzkso, zzdkj, (Set) set, zzeo);
        Boolean zzh = zzgk.zzh((zzbt) zza.getObject());
        zzeo.zza(zzgk.zzam(zzh));
        return new zzea(zzh, zza.zzbhd());
    }

    private final zzea<Boolean> zza(zzdkn zzdkn, Set<String> set, zzer zzer) {
        while (true) {
            boolean z = true;
            for (zzdkj zza : zzdkn.zzbkg()) {
                zzea zza2 = zza(zza, (Set) set, zzer.zzbgv());
                if (((Boolean) zza2.getObject()).booleanValue()) {
                    zzer.zzc(zzgk.zzam(Boolean.valueOf(false)));
                    return new zzea(Boolean.valueOf(false), zza2.zzbhd());
                } else if (!z || !zza2.zzbhd()) {
                    z = false;
                }
            }
            for (zzdkj zza3 : zzdkn.zzbkf()) {
                zzea zza4 = zza(zza3, (Set) set, zzer.zzbgw());
                if (((Boolean) zza4.getObject()).booleanValue()) {
                    z = z && zza4.zzbhd();
                } else {
                    zzer.zzc(zzgk.zzam(Boolean.valueOf(false)));
                    return new zzea(Boolean.valueOf(false), zza4.zzbhd());
                }
            }
            zzer.zzc(zzgk.zzam(Boolean.valueOf(true)));
            return new zzea(Boolean.valueOf(true), z);
        }
    }

    private final zzea<zzbt> zza(String str, Set<String> set, zzdm zzdm) {
        this.zzksv++;
        zzfi zzfi = (zzfi) this.zzksr.get(str);
        if (zzfi != null) {
            this.zzksm.zzbgo();
            zza(zzfi.zzbhr(), (Set) set);
            this.zzksv--;
            return zzfi.zzbhq();
        }
        zzfj zzfj = (zzfj) this.zzkst.get(str);
        if (zzfj == null) {
            String zzbhp = zzbhp();
            StringBuilder stringBuilder = new StringBuilder((String.valueOf(zzbhp).length() + 15) + String.valueOf(str).length());
            stringBuilder.append(zzbhp);
            stringBuilder.append("Invalid macro: ");
            stringBuilder.append(str);
            zzdj.e(stringBuilder.toString());
            this.zzksv--;
            return zzksk;
        }
        zzdkj zzbhx;
        zzea zza = zza(str, zzfj.zzbhs(), zzfj.zzbht(), zzfj.zzbhu(), zzfj.zzbhw(), zzfj.zzbhv(), set, zzdm.zzbgd());
        if (((Set) zza.getObject()).isEmpty()) {
            zzbhx = zzfj.zzbhx();
        } else {
            if (((Set) zza.getObject()).size() > 1) {
                String zzbhp2 = zzbhp();
                StringBuilder stringBuilder2 = new StringBuilder((String.valueOf(zzbhp2).length() + 37) + String.valueOf(str).length());
                stringBuilder2.append(zzbhp2);
                stringBuilder2.append("Multiple macros active for macroName ");
                stringBuilder2.append(str);
                zzdj.zzcz(stringBuilder2.toString());
            }
            zzbhx = (zzdkj) ((Set) zza.getObject()).iterator().next();
        }
        if (zzbhx == null) {
            this.zzksv--;
            return zzksk;
        }
        zzea zza2 = zza(this.zzksp, zzbhx, (Set) set, zzdm.zzbgu());
        boolean z = zza.zzbhd() && zza2.zzbhd();
        zzea<zzbt> zzea = zza2 == zzksk ? zzksk : new zzea((zzbt) zza2.getObject(), z);
        zzbt zzbhr = zzbhx.zzbhr();
        if (zzea.zzbhd()) {
            this.zzksr.zzf(str, new zzfi(zzea, zzbhr));
        }
        zza(zzbhr, (Set) set);
        this.zzksv--;
        return zzea;
    }

    private final zzea<Set<zzdkj>> zza(String str, Set<zzdkn> set, Map<zzdkn, List<zzdkj>> map, Map<zzdkn, List<String>> map2, Map<zzdkn, List<zzdkj>> map3, Map<zzdkn, List<String>> map4, Set<String> set2, zzfb zzfb) {
        return zza((Set) set, (Set) set2, new zzff(this, map, map2, map3, map4), zzfb);
    }

    private final zzea<zzbt> zza(Map<String, zzbr> map, zzdkj zzdkj, Set<String> set, zzeo zzeo) {
        String str;
        zzbt zzbt = (zzbt) zzdkj.zzbkd().get(zzbi.FUNCTION.toString());
        if (zzbt == null) {
            str = "No function id in properties";
        } else {
            String str2 = zzbt.zzyp;
            zzbr zzbr = (zzbr) map.get(str2);
            if (zzbr == null) {
                str = String.valueOf(str2).concat(" has no backing implementation.");
            } else {
                zzea<zzbt> zzea = (zzea) this.zzksq.get(zzdkj);
                if (zzea != null) {
                    this.zzksm.zzbgo();
                    return zzea;
                }
                Map hashMap = new HashMap();
                boolean z = true;
                Object obj = 1;
                for (Entry entry : zzdkj.zzbkd().entrySet()) {
                    zzea zza = zza((zzbt) entry.getValue(), (Set) set, zzeo.zzlz((String) entry.getKey()).zzb((zzbt) entry.getValue()));
                    if (zza == zzksk) {
                        return zzksk;
                    }
                    if (zza.zzbhd()) {
                        zzdkj.zza((String) entry.getKey(), (zzbt) zza.getObject());
                    } else {
                        obj = null;
                    }
                    hashMap.put((String) entry.getKey(), (zzbt) zza.getObject());
                }
                if (zzbr.zzd(hashMap.keySet())) {
                    if (obj == null || !zzbr.zzbfh()) {
                        z = false;
                    }
                    zzea<zzbt> zzea2 = new zzea(zzbr.zzx(hashMap), z);
                    if (z) {
                        this.zzksq.zzf(zzdkj, zzea2);
                    }
                    zzeo.zza((zzbt) zzea2.getObject());
                    return zzea2;
                }
                str = String.valueOf(zzbr.zzbgq());
                String valueOf = String.valueOf(hashMap.keySet());
                StringBuilder stringBuilder = new StringBuilder(((String.valueOf(str2).length() + 43) + String.valueOf(str).length()) + String.valueOf(valueOf).length());
                stringBuilder.append("Incorrect keys for function ");
                stringBuilder.append(str2);
                stringBuilder.append(" required ");
                stringBuilder.append(str);
                stringBuilder.append(" had ");
                stringBuilder.append(valueOf);
                str = stringBuilder.toString();
            }
        }
        zzdj.e(str);
        return zzksk;
    }

    private final zzea<Set<zzdkj>> zza(Set<zzdkn> set, Set<String> set2, zzfh zzfh, zzfb zzfb) {
        Set hashSet = new HashSet();
        Collection hashSet2 = new HashSet();
        while (true) {
            boolean z = true;
            for (zzdkn zzdkn : set) {
                zzer zzbhb = zzfb.zzbhb();
                zzea zza = zza(zzdkn, (Set) set2, zzbhb);
                if (((Boolean) zza.getObject()).booleanValue()) {
                    zzfh.zza(zzdkn, hashSet, hashSet2, zzbhb);
                }
                if (!z || !zza.zzbhd()) {
                    z = false;
                }
            }
            hashSet.removeAll(hashSet2);
            zzfb.zze(hashSet);
            return new zzea(hashSet, z);
        }
    }

    private static String zza(zzdkj zzdkj) {
        return zzgk.zzd((zzbt) zzdkj.zzbkd().get(zzbi.INSTANCE_NAME.toString()));
    }

    private final void zza(zzbt zzbt, Set<String> set) {
        if (zzbt != null) {
            zzea zza = zza(zzbt, (Set) set, new zzdy());
            if (zza != zzksk) {
                Object zzi = zzgk.zzi((zzbt) zza.getObject());
                if (zzi instanceof Map) {
                    this.zzknd.push((Map) zzi);
                } else if (zzi instanceof List) {
                    for (Object next : (List) zzi) {
                        if (next instanceof Map) {
                            this.zzknd.push((Map) next);
                        } else {
                            zzdj.zzcz("pushAfterEvaluate: value not a Map");
                        }
                    }
                } else {
                    zzdj.zzcz("pushAfterEvaluate: value not a Map or List");
                }
            }
        }
    }

    private final void zza(zzbr zzbr) {
        zza(this.zzksp, zzbr);
    }

    private static void zza(Map<String, zzbr> map, zzbr zzbr) {
        if (map.containsKey(zzbr.zzbgp())) {
            String str = "Duplicate function type name: ";
            String valueOf = String.valueOf(zzbr.zzbgp());
            throw new IllegalArgumentException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
        map.put(zzbr.zzbgp(), zzbr);
    }

    private final void zzb(zzbr zzbr) {
        zza(this.zzksn, zzbr);
    }

    private final String zzbhp() {
        if (this.zzksv <= 1) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Integer.toString(this.zzksv));
        for (int i = 2; i < this.zzksv; i++) {
            stringBuilder.append(' ');
        }
        stringBuilder.append(": ");
        return stringBuilder.toString();
    }

    private final void zzc(zzbr zzbr) {
        zza(this.zzkso, zzbr);
    }

    private static zzfj zzg(Map<String, zzfj> map, String str) {
        zzfj zzfj = (zzfj) map.get(str);
        if (zzfj != null) {
            return zzfj;
        }
        zzfj = new zzfj();
        map.put(str, zzfj);
        return zzfj;
    }

    private final synchronized void zzmd(String str) {
        this.zzksu = str;
    }

    public final synchronized void zzan(List<zzbr> list) {
        for (zzbr zzbr : list) {
            if (zzbr.name == null || !zzbr.name.startsWith("gaExperiment:")) {
                String valueOf = String.valueOf(zzbr);
                StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 22);
                stringBuilder.append("Ignored supplemental: ");
                stringBuilder.append(valueOf);
                zzdj.v(stringBuilder.toString());
            } else {
                zzbq.zza(this.zzknd, zzbr);
            }
        }
    }

    final synchronized String zzbho() {
        return this.zzksu;
    }

    public final synchronized void zzlj(String str) {
        zzmd(str);
        zzar zzbgn = this.zzksm.zzlt(str).zzbgn();
        for (zzdkj zza : (Set) zza(this.zzkss, new HashSet(), new zzfg(this), zzbgn.zzbgd()).getObject()) {
            zza(this.zzksn, zza, new HashSet(), zzbgn.zzbgc());
        }
        zzmd(null);
    }

    public final zzea<zzbt> zzmc(String str) {
        this.zzksv = 0;
        return zza(str, new HashSet(), this.zzksm.zzls(str).zzbgm());
    }
}
