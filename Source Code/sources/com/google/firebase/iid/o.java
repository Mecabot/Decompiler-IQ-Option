package com.google.firebase.iid;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@Hide
public final class o {
    private static o Yv;
    private final ScheduledExecutorService Yw;
    private q Yx = new q(this, null);
    private int Yy = 1;
    private final Context zzaiq;

    @VisibleForTesting
    private o(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.Yw = scheduledExecutorService;
        this.zzaiq = context.getApplicationContext();
    }

    private final synchronized <T> Task<T> a(x<T> xVar) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(xVar);
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 9);
            stringBuilder.append("Queueing ");
            stringBuilder.append(valueOf);
            Log.d("MessengerIpcClient", stringBuilder.toString());
        }
        if (!this.Yx.b(xVar)) {
            this.Yx = new q(this, null);
            this.Yx.b(xVar);
        }
        return xVar.YJ.getTask();
    }

    public static synchronized o aB(Context context) {
        o oVar;
        synchronized (o.class) {
            if (Yv == null) {
                Yv = new o(context, Executors.newSingleThreadScheduledExecutor());
            }
            oVar = Yv;
        }
        return oVar;
    }

    private final synchronized int wE() {
        int i;
        i = this.Yy;
        this.Yy = i + 1;
        return i;
    }

    public final Task<Void> a(int i, Bundle bundle) {
        return a(new w(wE(), 2, bundle));
    }

    public final Task<Bundle> b(int i, Bundle bundle) {
        return a(new y(wE(), 1, bundle));
    }
}
