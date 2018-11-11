package com.google.android.gms.tagmanager;

import android.os.Handler;
import android.os.Message;

final class zzfs implements zzfr {
    private Handler handler;
    final /* synthetic */ zzfo zzktv;

    private zzfs(zzfo zzfo) {
        this.zzktv = zzfo;
        this.handler = new Handler(this.zzktv.zzktj.getMainLooper(), new zzft(this));
    }

    /* synthetic */ zzfs(zzfo zzfo, zzfp zzfp) {
        this(zzfo);
    }

    private final Message obtainMessage() {
        return this.handler.obtainMessage(1, zzfo.zzkti);
    }

    public final void cancel() {
        this.handler.removeMessages(1, zzfo.zzkti);
    }

    public final void zzbic() {
        this.handler.removeMessages(1, zzfo.zzkti);
        this.handler.sendMessage(obtainMessage());
    }

    public final void zzs(long j) {
        this.handler.removeMessages(1, zzfo.zzkti);
        this.handler.sendMessageDelayed(obtainMessage(), j);
    }
}
