package com.google.firebase.iid;

import android.os.Handler.Callback;
import android.os.Message;

final /* synthetic */ class r implements Callback {
    private final q YF;

    r(q qVar) {
        this.YF = qVar;
    }

    public final boolean handleMessage(Message message) {
        return this.YF.c(message);
    }
}
