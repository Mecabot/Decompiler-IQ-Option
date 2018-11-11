package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.internal.zzbq;

public final class zzarm {
    private final Context mApplicationContext;
    private final Context zzdzh;

    public zzarm(Context context) {
        zzbq.checkNotNull(context);
        context = context.getApplicationContext();
        zzbq.checkNotNull(context, "Application context can't be null");
        this.mApplicationContext = context;
        this.zzdzh = context;
    }

    public final Context getApplicationContext() {
        return this.mApplicationContext;
    }

    public final Context zzyl() {
        return this.zzdzh;
    }
}
