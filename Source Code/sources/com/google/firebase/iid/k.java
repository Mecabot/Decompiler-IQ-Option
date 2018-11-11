package com.google.firebase.iid;

import android.util.Log;

final class k implements Runnable {
    private /* synthetic */ h Yn;
    private /* synthetic */ j Yo;

    k(j jVar, h hVar) {
        this.Yo = jVar;
        this.Yn = hVar;
    }

    public final void run() {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "bg processing of the intent starting now");
        }
        this.Yo.Ym.n(this.Yn.intent);
        this.Yn.finish();
    }
}
