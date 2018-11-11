package com.google.android.gms.tagmanager;

import android.os.Handler.Callback;
import android.os.Message;

final class zzft implements Callback {
    private /* synthetic */ zzfs zzktw;

    zzft(zzfs zzfs) {
        this.zzktw = zzfs;
    }

    public final boolean handleMessage(Message message) {
        if (1 == message.what && zzfo.zzkti.equals(message.obj)) {
            this.zzktw.zzktv.dispatch();
            if (!this.zzktw.zzktv.isPowerSaveMode()) {
                this.zzktw.zzs((long) this.zzktw.zzktv.zzktm);
            }
        }
        return true;
    }
}
