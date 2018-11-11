package com.google.android.gms.internal;

import android.os.Bundle;
import android.support.annotation.WorkerThread;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.internal.zzbq;
import java.util.Map;

public final class zzcia extends zzclh {
    private final Map<String, Long> zzjff = new ArrayMap();
    private final Map<String, Integer> zzjfg = new ArrayMap();
    private long zzjfh;

    public zzcia(zzckj zzckj) {
        super(zzckj);
    }

    @WorkerThread
    private final void zza(long j, zzclz zzclz) {
        if (zzclz == null) {
            zzayp().zzbba().log("Not logging ad exposure. No active activity");
        } else if (j < 1000) {
            zzayp().zzbba().zzj("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(j));
        } else {
            Bundle bundle = new Bundle();
            bundle.putLong("_xt", j);
            zzcma.zza(zzclz, bundle, true);
            zzayd().zzd("am", "_xa", bundle);
        }
    }

    @WorkerThread
    private final void zza(String str, long j, zzclz zzclz) {
        if (zzclz == null) {
            zzayp().zzbba().log("Not logging ad unit exposure. No active activity");
        } else if (j < 1000) {
            zzayp().zzbba().zzj("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(j));
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str);
            bundle.putLong("_xt", j);
            zzcma.zza(zzclz, bundle, true);
            zzayd().zzd("am", "_xu", bundle);
        }
    }

    @WorkerThread
    private final void zzak(long j) {
        for (String put : this.zzjff.keySet()) {
            this.zzjff.put(put, Long.valueOf(j));
        }
        if (!this.zzjff.isEmpty()) {
            this.zzjfh = j;
        }
    }

    @WorkerThread
    private final void zzd(String str, long j) {
        zzwj();
        zzbq.zzgv(str);
        if (this.zzjfg.isEmpty()) {
            this.zzjfh = j;
        }
        Integer num = (Integer) this.zzjfg.get(str);
        if (num != null) {
            this.zzjfg.put(str, Integer.valueOf(num.intValue() + 1));
        } else if (this.zzjfg.size() >= 100) {
            zzayp().zzbaw().log("Too many ads visible");
        } else {
            this.zzjfg.put(str, Integer.valueOf(1));
            this.zzjff.put(str, Long.valueOf(j));
        }
    }

    @WorkerThread
    private final void zze(String str, long j) {
        zzwj();
        zzbq.zzgv(str);
        Integer num = (Integer) this.zzjfg.get(str);
        if (num != null) {
            zzclz zzbcg = zzayh().zzbcg();
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.zzjfg.remove(str);
                Long l = (Long) this.zzjff.get(str);
                if (l == null) {
                    zzayp().zzbau().log("First ad unit exposure time was never set");
                } else {
                    long longValue = j - l.longValue();
                    this.zzjff.remove(str);
                    zza(str, longValue, zzbcg);
                }
                if (this.zzjfg.isEmpty()) {
                    if (this.zzjfh == 0) {
                        zzayp().zzbau().log("First ad exposure time was never set");
                        return;
                    } else {
                        zza(j - this.zzjfh, zzbcg);
                        this.zzjfh = 0;
                    }
                }
                return;
            }
            this.zzjfg.put(str, Integer.valueOf(intValue));
            return;
        }
        zzayp().zzbau().zzj("Call to endAdUnitExposure for unknown ad unit id", str);
    }

    public final void beginAdUnitExposure(String str) {
        if (str == null || str.length() == 0) {
            zzayp().zzbau().log("Ad unit id must be a non-empty string");
            return;
        }
        zzayo().zzh(new zzcib(this, str, zzxx().elapsedRealtime()));
    }

    public final void endAdUnitExposure(String str) {
        if (str == null || str.length() == 0) {
            zzayp().zzbau().log("Ad unit id must be a non-empty string");
            return;
        }
        zzayo().zzh(new zzcic(this, str, zzxx().elapsedRealtime()));
    }

    @WorkerThread
    public final void zzaj(long j) {
        zzclz zzbcg = zzayh().zzbcg();
        for (String str : this.zzjff.keySet()) {
            zza(str, j - ((Long) this.zzjff.get(str)).longValue(), zzbcg);
        }
        if (!this.zzjff.isEmpty()) {
            zza(j - this.zzjfh, zzbcg);
        }
        zzak(j);
    }
}
