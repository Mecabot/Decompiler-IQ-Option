package com.google.firebase.iid;

import android.content.BroadcastReceiver.PendingResult;
import android.content.Intent;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

final class h {
    private final PendingResult Yi;
    private boolean Yj = false;
    private final ScheduledFuture<?> Yk;
    final Intent intent;

    h(Intent intent, PendingResult pendingResult, ScheduledExecutorService scheduledExecutorService) {
        this.intent = intent;
        this.Yi = pendingResult;
        this.Yk = scheduledExecutorService.schedule(new i(this, intent), 9500, TimeUnit.MILLISECONDS);
    }

    final synchronized void finish() {
        if (!this.Yj) {
            this.Yi.finish();
            this.Yk.cancel(false);
            this.Yj = true;
        }
    }
}
