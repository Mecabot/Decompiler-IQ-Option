package com.google.firebase.iid;

import android.content.Intent;

final class g implements Runnable {
    private /* synthetic */ Intent Yg;
    private /* synthetic */ f Yh;
    private /* synthetic */ Intent val$intent;

    g(f fVar, Intent intent, Intent intent2) {
        this.Yh = fVar;
        this.val$intent = intent;
        this.Yg = intent2;
    }

    public final void run() {
        this.Yh.n(this.val$intent);
        this.Yh.o(this.Yg);
    }
}
