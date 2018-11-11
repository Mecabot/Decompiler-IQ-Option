package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.zzk;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbq;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Hide
public final class zzaqz extends zzari {
    private final zzarw zzdyh;

    public zzaqz(zzark zzark, zzarm zzarm) {
        super(zzark);
        zzbq.checkNotNull(zzarm);
        this.zzdyh = new zzarw(zzark, zzarm);
    }

    final void onServiceConnected() {
        zzk.zzwj();
        this.zzdyh.onServiceConnected();
    }

    public final void setLocalDispatchPeriod(int i) {
        zzyk();
        zzb("setLocalDispatchPeriod (sec)", Integer.valueOf(i));
        zzya().zzd(new zzara(this, i));
    }

    public final void start() {
        this.zzdyh.start();
    }

    public final long zza(zzarn zzarn) {
        zzyk();
        zzbq.checkNotNull(zzarn);
        zzk.zzwj();
        long zza = this.zzdyh.zza(zzarn, true);
        if (zza == 0) {
            this.zzdyh.zzb(zzarn);
        }
        return zza;
    }

    public final void zza(zzasr zzasr) {
        zzyk();
        zzya().zzd(new zzarf(this, zzasr));
    }

    public final void zza(zzasy zzasy) {
        zzbq.checkNotNull(zzasy);
        zzyk();
        zzb("Hit delivery requested", zzasy);
        zzya().zzd(new zzard(this, zzasy));
    }

    public final void zza(String str, Runnable runnable) {
        zzbq.zzh(str, "campaign param can't be empty");
        zzya().zzd(new zzarc(this, str, runnable));
    }

    protected final void zzwk() {
        this.zzdyh.initialize();
    }

    public final void zzxr() {
        zzyk();
        zzya().zzd(new zzare(this));
    }

    public final void zzxs() {
        zzyk();
        Context context = getContext();
        if (zzatk.zzbj(context) && zzatl.zzbn(context)) {
            Intent intent = new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            intent.setComponent(new ComponentName(context, "com.google.android.gms.analytics.AnalyticsService"));
            context.startService(intent);
            return;
        }
        zza(null);
    }

    public final boolean zzxt() {
        zzyk();
        try {
            zzya().zza(new zzarg(this)).get(4, TimeUnit.SECONDS);
            return true;
        } catch (InterruptedException e) {
            zzd("syncDispatchLocalHits interrupted", e);
            return false;
        } catch (ExecutionException e2) {
            zze("syncDispatchLocalHits failed", e2);
            return false;
        } catch (TimeoutException e3) {
            zzd("syncDispatchLocalHits timed out", e3);
            return false;
        }
    }

    public final void zzxu() {
        zzyk();
        zzk.zzwj();
        zzarh zzarh = this.zzdyh;
        zzk.zzwj();
        zzarh.zzyk();
        zzarh.zzea("Service disconnected");
    }

    final void zzxv() {
        zzk.zzwj();
        this.zzdyh.zzxv();
    }
}
