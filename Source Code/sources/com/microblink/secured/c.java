package com.microblink.secured;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: line */
public final class c {
    SharedPreferences dVK = null;

    public c(Context context) {
        this.dVK = context.getSharedPreferences("com.microblink.ping.preferences", 0);
    }

    public final long aPs() {
        if (this.dVK == null) {
            return 0;
        }
        return this.dVK.getLong("com.microblink.ping.preferences.scansCount", 0);
    }

    @SuppressLint({"CommitPrefEdits, ApplySharedPref"})
    public final void cD(long j) {
        if (this.dVK != null) {
            this.dVK.edit().putLong("com.microblink.ping.preferences.scansCount", j).commit();
        }
    }
}
