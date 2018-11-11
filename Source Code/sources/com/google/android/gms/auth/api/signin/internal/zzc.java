package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.zzcu;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public final class zzc extends AsyncTaskLoader<Void> implements zzcu {
    private Semaphore zzenn = new Semaphore(0);
    private Set<GoogleApiClient> zzeno;

    public zzc(Context context, Set<GoogleApiClient> set) {
        super(context);
        this.zzeno = set;
    }

    private final Void zzacl() {
        int i = 0;
        for (GoogleApiClient zza : this.zzeno) {
            if (zza.zza((zzcu) this)) {
                i++;
            }
        }
        try {
            this.zzenn.tryAcquire(i, 5, TimeUnit.SECONDS);
        } catch (Throwable e) {
            Log.i("GACSignInLoader", "Unexpected InterruptedException", e);
            Thread.currentThread().interrupt();
        }
        return null;
    }

    protected final void onStartLoading() {
        this.zzenn.drainPermits();
        forceLoad();
    }

    public final void zzacm() {
        this.zzenn.release();
    }
}
