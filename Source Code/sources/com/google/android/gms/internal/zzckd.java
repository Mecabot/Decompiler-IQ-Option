package com.google.android.gms.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.support.annotation.WorkerThread;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.measurement.AppMeasurement.Event;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.android.gms.measurement.AppMeasurement.UserProperty;
import com.google.firebase.analytics.FirebaseAnalytics.a;
import java.io.IOException;
import java.util.Map;

public final class zzckd extends zzcli {
    private static int zzjmt = 65535;
    private static int zzjmu = 2;
    private final Map<String, Map<String, String>> zzjmv = new ArrayMap();
    private final Map<String, Map<String, Boolean>> zzjmw = new ArrayMap();
    private final Map<String, Map<String, Boolean>> zzjmx = new ArrayMap();
    private final Map<String, zzcny> zzjmy = new ArrayMap();
    private final Map<String, Map<String, Integer>> zzjmz = new ArrayMap();
    private final Map<String, String> zzjna = new ArrayMap();

    zzckd(zzckj zzckj) {
        super(zzckj);
    }

    private static Map<String, String> zza(zzcny zzcny) {
        Map<String, String> arrayMap = new ArrayMap();
        if (!(zzcny == null || zzcny.zzjtz == null)) {
            for (zzcnz zzcnz : zzcny.zzjtz) {
                if (zzcnz != null) {
                    arrayMap.put(zzcnz.key, zzcnz.value);
                }
            }
        }
        return arrayMap;
    }

    private final void zza(String str, zzcny zzcny) {
        Map arrayMap = new ArrayMap();
        Map arrayMap2 = new ArrayMap();
        Map arrayMap3 = new ArrayMap();
        if (!(zzcny == null || zzcny.zzjua == null)) {
            for (zzcnx zzcnx : zzcny.zzjua) {
                if (TextUtils.isEmpty(zzcnx.name)) {
                    zzayp().zzbaw().log("EventConfig contained null event name");
                } else {
                    Object zzix = Event.zzix(zzcnx.name);
                    if (!TextUtils.isEmpty(zzix)) {
                        zzcnx.name = zzix;
                    }
                    arrayMap.put(zzcnx.name, zzcnx.zzjtu);
                    arrayMap2.put(zzcnx.name, zzcnx.zzjtv);
                    if (zzcnx.zzjtw != null) {
                        if (zzcnx.zzjtw.intValue() < zzjmu || zzcnx.zzjtw.intValue() > zzjmt) {
                            zzayp().zzbaw().zze("Invalid sampling rate. Event name, sample rate", zzcnx.name, zzcnx.zzjtw);
                        } else {
                            arrayMap3.put(zzcnx.name, zzcnx.zzjtw);
                        }
                    }
                }
            }
        }
        this.zzjmw.put(str, arrayMap);
        this.zzjmx.put(str, arrayMap2);
        this.zzjmz.put(str, arrayMap3);
    }

    @WorkerThread
    private final zzcny zzc(String str, byte[] bArr) {
        if (bArr == null) {
            return new zzcny();
        }
        zzflj zzo = zzflj.zzo(bArr, 0, bArr.length);
        zzfls zzcny = new zzcny();
        try {
            zzcny.zza(zzo);
            zzayp().zzbba().zze("Parsed config. version, gmp_app_id", zzcny.zzjtx, zzcny.zzjfl);
            return zzcny;
        } catch (IOException e) {
            zzayp().zzbaw().zze("Unable to merge remote config. appId", zzcjj.zzjs(str), e);
            return new zzcny();
        }
    }

    @WorkerThread
    private final void zzjz(String str) {
        zzyk();
        zzwj();
        zzbq.zzgv(str);
        if (this.zzjmy.get(str) == null) {
            byte[] zzjl = zzayj().zzjl(str);
            if (zzjl == null) {
                this.zzjmv.put(str, null);
                this.zzjmw.put(str, null);
                this.zzjmx.put(str, null);
                this.zzjmy.put(str, null);
                this.zzjna.put(str, null);
                this.zzjmz.put(str, null);
                return;
            }
            zzcny zzc = zzc(str, zzjl);
            this.zzjmv.put(str, zza(zzc));
            zza(str, zzc);
            this.zzjmy.put(str, zzc);
            this.zzjna.put(str, null);
        }
    }

    @WorkerThread
    final String zzam(String str, String str2) {
        zzwj();
        zzjz(str);
        Map map = (Map) this.zzjmv.get(str);
        return map != null ? (String) map.get(str2) : null;
    }

    @WorkerThread
    final boolean zzan(String str, String str2) {
        zzwj();
        zzjz(str);
        if (zzayl().zzks(str) && zzcno.zzkp(str2)) {
            return true;
        }
        if (zzayl().zzkt(str) && zzcno.zzkh(str2)) {
            return true;
        }
        Map map = (Map) this.zzjmw.get(str);
        if (map == null) {
            return false;
        }
        Boolean bool = (Boolean) map.get(str2);
        return bool == null ? false : bool.booleanValue();
    }

    @WorkerThread
    final boolean zzao(String str, String str2) {
        zzwj();
        zzjz(str);
        if (a.ECOMMERCE_PURCHASE.equals(str2)) {
            return true;
        }
        Map map = (Map) this.zzjmx.get(str);
        if (map == null) {
            return false;
        }
        Boolean bool = (Boolean) map.get(str2);
        return bool == null ? false : bool.booleanValue();
    }

    @WorkerThread
    final int zzap(String str, String str2) {
        zzwj();
        zzjz(str);
        Map map = (Map) this.zzjmz.get(str);
        if (map == null) {
            return 1;
        }
        Integer num = (Integer) map.get(str2);
        return num == null ? 1 : num.intValue();
    }

    protected final boolean zzazq() {
        return false;
    }

    @WorkerThread
    protected final boolean zzb(String str, byte[] bArr, String str2) {
        String str3 = str;
        zzyk();
        zzwj();
        zzbq.zzgv(str);
        zzfls zzc = zzc(str, bArr);
        if (zzc == null) {
            return false;
        }
        byte[] bArr2;
        zza(str3, zzc);
        this.zzjmy.put(str3, zzc);
        this.zzjna.put(str3, str2);
        this.zzjmv.put(str3, zza(zzc));
        zzclh zzayc = zzayc();
        zzcnr[] zzcnrArr = zzc.zzjub;
        zzbq.checkNotNull(zzcnrArr);
        int length = zzcnrArr.length;
        int i = 0;
        while (i < length) {
            int i2;
            zzcnr zzcnr = zzcnrArr[i];
            for (zzcns zzcns : zzcnr.zzjsv) {
                String zzix = Event.zzix(zzcns.zzjsy);
                if (zzix != null) {
                    zzcns.zzjsy = zzix;
                }
                zzcnt[] zzcntArr = zzcns.zzjsz;
                int length2 = zzcntArr.length;
                int i3 = 0;
                while (i3 < length2) {
                    zzcnt zzcnt = zzcntArr[i3];
                    i2 = length;
                    String zzix2 = Param.zzix(zzcnt.zzjtg);
                    if (zzix2 != null) {
                        zzcnt.zzjtg = zzix2;
                    }
                    i3++;
                    length = i2;
                }
                i2 = length;
            }
            i2 = length;
            for (zzcnv zzcnv : zzcnr.zzjsu) {
                String zzix3 = UserProperty.zzix(zzcnv.zzjtn);
                if (zzix3 != null) {
                    zzcnv.zzjtn = zzix3;
                }
            }
            i++;
            length = i2;
        }
        zzayc.zzayj().zza(str3, zzcnrArr);
        try {
            zzc.zzjub = null;
            bArr2 = new byte[zzc.zzhs()];
            zzc.zza(zzflk.zzp(bArr2, 0, bArr2.length));
        } catch (IOException e) {
            zzayp().zzbaw().zze("Unable to serialize reduced-size config. Storing full config instead. appId", zzcjj.zzjs(str), e);
            bArr2 = bArr;
        }
        zzclh zzayj = zzayj();
        zzbq.zzgv(str);
        zzayj.zzwj();
        zzayj.zzyk();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr2);
        try {
            if (((long) zzayj.getWritableDatabase().update("apps", contentValues, "app_id = ?", new String[]{str3})) == 0) {
                zzayj.zzayp().zzbau().zzj("Failed to update remote config (got 0). appId", zzcjj.zzjs(str));
                return true;
            }
        } catch (SQLiteException e2) {
            zzayj.zzayp().zzbau().zze("Error storing remote config. appId", zzcjj.zzjs(str), e2);
        }
        return true;
    }

    @WorkerThread
    protected final zzcny zzka(String str) {
        zzyk();
        zzwj();
        zzbq.zzgv(str);
        zzjz(str);
        return (zzcny) this.zzjmy.get(str);
    }

    @WorkerThread
    protected final String zzkb(String str) {
        zzwj();
        return (String) this.zzjna.get(str);
    }

    @WorkerThread
    protected final void zzkc(String str) {
        zzwj();
        this.zzjna.put(str, null);
    }

    @WorkerThread
    final void zzkd(String str) {
        zzwj();
        this.zzjmy.remove(str);
    }
}
