package com.google.firebase.iid;

import android.content.Intent;
import android.util.Log;

final class i implements Runnable {
    private /* synthetic */ h Yl;
    private /* synthetic */ Intent val$intent;

    i(h hVar, Intent intent) {
        this.Yl = hVar;
        this.val$intent = intent;
    }

    public final void run() {
        String action = this.val$intent.getAction();
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(action).length() + 61);
        stringBuilder.append("Service took too long to process intent: ");
        stringBuilder.append(action);
        stringBuilder.append(" App may get closed.");
        Log.w("EnhancedIntentService", stringBuilder.toString());
        this.Yl.finish();
    }
}
