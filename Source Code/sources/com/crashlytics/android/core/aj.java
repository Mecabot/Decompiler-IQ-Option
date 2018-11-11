package com.crashlytics.android.core;

import android.annotation.SuppressLint;
import io.fabric.sdk.android.services.c.c;
import io.fabric.sdk.android.services.c.d;

@SuppressLint({"CommitPrefEdits"})
/* compiled from: PreferenceManager */
class aj {
    private final c vE;
    private final k vF;

    public static aj a(c cVar, k kVar) {
        return new aj(cVar, kVar);
    }

    public aj(c cVar, k kVar) {
        this.vE = cVar;
        this.vF = kVar;
    }

    void H(boolean z) {
        this.vE.a(this.vE.edit().putBoolean("always_send_reports_opt_in", z));
    }

    boolean hY() {
        if (!this.vE.aVG().contains("preferences_migration_complete")) {
            c dVar = new d(this.vF);
            Object obj = (this.vE.aVG().contains("always_send_reports_opt_in") || !dVar.aVG().contains("always_send_reports_opt_in")) ? null : 1;
            if (obj != null) {
                this.vE.a(this.vE.edit().putBoolean("always_send_reports_opt_in", dVar.aVG().getBoolean("always_send_reports_opt_in", false)));
            }
            this.vE.a(this.vE.edit().putBoolean("preferences_migration_complete", true));
        }
        return this.vE.aVG().getBoolean("always_send_reports_opt_in", false);
    }
}
