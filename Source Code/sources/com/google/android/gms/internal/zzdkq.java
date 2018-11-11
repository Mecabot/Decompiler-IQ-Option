package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Hide;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Hide
public final class zzdkq {
    private static Integer zzldu = Integer.valueOf(0);
    private static Integer zzldv = Integer.valueOf(1);
    private final Context mContext;
    private final ExecutorService zzimc;

    public zzdkq(Context context) {
        this(context, Executors.newSingleThreadExecutor());
    }

    private zzdkq(Context context, ExecutorService executorService) {
        this.mContext = context;
        this.zzimc = executorService;
    }
}
