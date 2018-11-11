package com.google.android.gms.internal;

import android.os.Handler;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbq;

@Hide
abstract class zzasn {
    private static volatile Handler zzebe;
    private final zzark zzdyp;
    private volatile long zzebf;
    private final Runnable zzy = new zzaso(this);

    zzasn(zzark zzark) {
        zzbq.checkNotNull(zzark);
        this.zzdyp = zzark;
    }

    private final Handler getHandler() {
        if (zzebe != null) {
            return zzebe;
        }
        Handler handler;
        synchronized (zzasn.class) {
            if (zzebe == null) {
                zzebe = new Handler(this.zzdyp.getContext().getMainLooper());
            }
            handler = zzebe;
        }
        return handler;
    }

    public final void cancel() {
        this.zzebf = 0;
        getHandler().removeCallbacks(this.zzy);
    }

    public abstract void run();

    public final long zzaag() {
        return this.zzebf == 0 ? 0 : Math.abs(this.zzdyp.zzxx().currentTimeMillis() - this.zzebf);
    }

    public final boolean zzea() {
        return this.zzebf != 0;
    }

    public final void zzs(long j) {
        cancel();
        if (j >= 0) {
            this.zzebf = this.zzdyp.zzxx().currentTimeMillis();
            if (!getHandler().postDelayed(this.zzy, j)) {
                this.zzdyp.zzxy().zze("Failed to schedule delayed post. time", Long.valueOf(j));
            }
        }
    }

    public final void zzt(long j) {
        if (zzea()) {
            long j2 = 0;
            if (j < 0) {
                cancel();
                return;
            }
            long abs = j - Math.abs(this.zzdyp.zzxx().currentTimeMillis() - this.zzebf);
            if (abs >= 0) {
                j2 = abs;
            }
            getHandler().removeCallbacks(this.zzy);
            if (!getHandler().postDelayed(this.zzy, j2)) {
                this.zzdyp.zzxy().zze("Failed to adjust delayed post. time", Long.valueOf(j2));
            }
        }
    }
}
