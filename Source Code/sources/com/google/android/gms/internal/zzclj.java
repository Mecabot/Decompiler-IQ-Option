package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbq;

@Hide
public final class zzclj {
    final Context zzaiq;

    public zzclj(Context context) {
        zzbq.checkNotNull(context);
        context = context.getApplicationContext();
        zzbq.checkNotNull(context);
        this.zzaiq = context;
    }
}
