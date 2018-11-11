package com.google.firebase.iid;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class ab extends Handler {
    private /* synthetic */ aa YV;

    ab(aa aaVar, Looper looper) {
        this.YV = aaVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        this.YV.d(message);
    }
}
