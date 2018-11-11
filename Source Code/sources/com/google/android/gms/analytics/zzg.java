package com.google.android.gms.analytics;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zze;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@Hide
public final class zzg {
    private final zze zzata;
    private final zzj zzdux;
    private boolean zzduy;
    private long zzduz;
    private long zzdva;
    private long zzdvb;
    private long zzdvc;
    private long zzdvd;
    private boolean zzdve;
    private final Map<Class<? extends zzi>, zzi> zzdvf;
    private final List<zzo> zzdvg;

    private zzg(zzg zzg) {
        this.zzdux = zzg.zzdux;
        this.zzata = zzg.zzata;
        this.zzduz = zzg.zzduz;
        this.zzdva = zzg.zzdva;
        this.zzdvb = zzg.zzdvb;
        this.zzdvc = zzg.zzdvc;
        this.zzdvd = zzg.zzdvd;
        this.zzdvg = new ArrayList(zzg.zzdvg);
        this.zzdvf = new HashMap(zzg.zzdvf.size());
        for (Entry entry : zzg.zzdvf.entrySet()) {
            zzi zzc = zzc((Class) entry.getKey());
            ((zzi) entry.getValue()).zzb(zzc);
            this.zzdvf.put((Class) entry.getKey(), zzc);
        }
    }

    zzg(zzj zzj, zze zze) {
        zzbq.checkNotNull(zzj);
        zzbq.checkNotNull(zze);
        this.zzdux = zzj;
        this.zzata = zze;
        this.zzdvc = 1800000;
        this.zzdvd = 3024000000L;
        this.zzdvf = new HashMap();
        this.zzdvg = new ArrayList();
    }

    @Hide
    @TargetApi(19)
    private static <T extends zzi> T zzc(Class<T> cls) {
        try {
            return (zzi) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable e) {
            if (e instanceof InstantiationException) {
                throw new IllegalArgumentException("dataType doesn't have default constructor", e);
            } else if (e instanceof IllegalAccessException) {
                throw new IllegalArgumentException("dataType default constructor is not accessible", e);
            } else if (VERSION.SDK_INT < 19 || !(e instanceof ReflectiveOperationException)) {
                throw new RuntimeException(e);
            } else {
                throw new IllegalArgumentException("Linkage exception", e);
            }
        }
    }

    public final List<zzo> getTransports() {
        return this.zzdvg;
    }

    @Hide
    public final <T extends zzi> T zza(Class<T> cls) {
        return (zzi) this.zzdvf.get(cls);
    }

    @Hide
    public final void zza(zzi zzi) {
        zzbq.checkNotNull(zzi);
        Class cls = zzi.getClass();
        if (cls.getSuperclass() != zzi.class) {
            throw new IllegalArgumentException();
        }
        zzi.zzb(zzb(cls));
    }

    @Hide
    public final <T extends zzi> T zzb(Class<T> cls) {
        zzi zzi = (zzi) this.zzdvf.get(cls);
        if (zzi != null) {
            return zzi;
        }
        T zzc = zzc(cls);
        this.zzdvf.put(cls, zzc);
        return zzc;
    }

    @Hide
    public final void zzl(long j) {
        this.zzdva = j;
    }

    public final zzg zzvx() {
        return new zzg(this);
    }

    @Hide
    public final Collection<zzi> zzvy() {
        return this.zzdvf.values();
    }

    public final long zzvz() {
        return this.zzduz;
    }

    public final void zzwa() {
        this.zzdux.zzwg().zze(this);
    }

    public final boolean zzwb() {
        return this.zzduy;
    }

    final void zzwc() {
        this.zzdvb = this.zzata.elapsedRealtime();
        this.zzduz = this.zzdva != 0 ? this.zzdva : this.zzata.currentTimeMillis();
        this.zzduy = true;
    }

    final zzj zzwd() {
        return this.zzdux;
    }

    final boolean zzwe() {
        return this.zzdve;
    }

    final void zzwf() {
        this.zzdve = true;
    }
}
