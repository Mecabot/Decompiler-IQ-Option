package com.google.android.gms.internal;

import android.content.ComponentName;

final class zzars implements Runnable {
    private /* synthetic */ ComponentName val$name;
    private /* synthetic */ zzarq zzdzu;

    zzars(zzarq zzarq, ComponentName componentName) {
        this.zzdzu = zzarq;
        this.val$name = componentName;
    }

    public final void run() {
        this.zzdzu.zzdzq.onServiceDisconnected(this.val$name);
    }
}
