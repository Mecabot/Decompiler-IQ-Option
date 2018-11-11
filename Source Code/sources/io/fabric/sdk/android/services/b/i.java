package io.fabric.sdk.android.services.b;

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;

/* compiled from: TimeBasedFileRollOverRunnable */
public class i implements Runnable {
    private final Context context;
    private final e eon;

    public i(Context context, e eVar) {
        this.context = context;
        this.eon = eVar;
    }

    public void run() {
        try {
            CommonUtils.H(this.context, "Performing time based file roll over.");
            if (!this.eon.gB()) {
                this.eon.gC();
            }
        } catch (Throwable e) {
            CommonUtils.a(this.context, "Failed to roll over file", e);
        }
    }
}
