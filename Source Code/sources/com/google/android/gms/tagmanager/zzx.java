package com.google.android.gms.tagmanager;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.tagmanager.ContainerHolder.ContainerAvailableListener;

final class zzx extends Handler {
    private final ContainerAvailableListener zzknp;
    private /* synthetic */ zzv zzknq;

    public zzx(zzv zzv, ContainerAvailableListener containerAvailableListener, Looper looper) {
        this.zzknq = zzv;
        super(looper);
        this.zzknp = containerAvailableListener;
    }

    public final void handleMessage(Message message) {
        if (message.what != 1) {
            zzdj.e("Don't know how to handle this message.");
            return;
        }
        this.zzknp.onContainerAvailable(this.zzknq, (String) message.obj);
    }
}
