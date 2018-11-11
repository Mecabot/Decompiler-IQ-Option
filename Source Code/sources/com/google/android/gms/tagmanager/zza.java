package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Process;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzi;

@Hide
public final class zza {
    private static Object zzkmq = new Object();
    private static zza zzkmr;
    private volatile boolean mClosed;
    private final Context mContext;
    private final zze zzata;
    private final Thread zzdeq;
    private volatile Info zzdyc;
    private volatile long zzkmk;
    private volatile long zzkml;
    private volatile long zzkmm;
    private volatile long zzkmn;
    private final Object zzkmo;
    private zzd zzkmp;

    private zza(Context context) {
        this(context, null, zzi.zzanq());
    }

    private zza(Context context, zzd zzd, zze zze) {
        this.zzkmk = 900000;
        this.zzkml = 30000;
        this.mClosed = false;
        this.zzkmo = new Object();
        this.zzkmp = new zzb(this);
        this.zzata = zze;
        if (context != null) {
            context = context.getApplicationContext();
        }
        this.mContext = context;
        this.zzkmm = this.zzata.currentTimeMillis();
        this.zzdeq = new Thread(new zzc(this));
    }

    private final void zzbfc() {
        synchronized (this) {
            if (!this.mClosed) {
                zzbfd();
                wait(500);
            }
            try {
            } catch (InterruptedException unused) {
            }
        }
    }

    private final void zzbfd() {
        if (this.zzata.currentTimeMillis() - this.zzkmm > this.zzkml) {
            synchronized (this.zzkmo) {
                this.zzkmo.notify();
            }
            this.zzkmm = this.zzata.currentTimeMillis();
        }
    }

    private final void zzbfe() {
        if (this.zzata.currentTimeMillis() - this.zzkmn > 3600000) {
            this.zzdyc = null;
        }
    }

    private final void zzbff() {
        Process.setThreadPriority(10);
        while (!this.mClosed) {
            Info zzbfg = this.zzkmp.zzbfg();
            if (zzbfg != null) {
                this.zzdyc = zzbfg;
                this.zzkmn = this.zzata.currentTimeMillis();
                zzdj.zzcy("Obtained fresh AdvertisingId info from GmsCore.");
            }
            synchronized (this) {
                notifyAll();
            }
            try {
                synchronized (this.zzkmo) {
                    this.zzkmo.wait(this.zzkmk);
                }
            } catch (InterruptedException unused) {
                zzdj.zzcy("sleep interrupted in AdvertiserDataPoller thread; continuing");
            }
        }
    }

    public static zza zzeg(Context context) {
        if (zzkmr == null) {
            synchronized (zzkmq) {
                if (zzkmr == null) {
                    zza zza = new zza(context);
                    zzkmr = zza;
                    zza.zzdeq.start();
                }
            }
        }
        return zzkmr;
    }

    public final void close() {
        this.mClosed = true;
        this.zzdeq.interrupt();
    }

    public final boolean isLimitAdTrackingEnabled() {
        if (this.zzdyc == null) {
            zzbfc();
        } else {
            zzbfd();
        }
        zzbfe();
        return this.zzdyc == null ? true : this.zzdyc.isLimitAdTrackingEnabled();
    }

    public final String zzbfb() {
        if (this.zzdyc == null) {
            zzbfc();
        } else {
            zzbfd();
        }
        zzbfe();
        return this.zzdyc == null ? null : this.zzdyc.getId();
    }
}
