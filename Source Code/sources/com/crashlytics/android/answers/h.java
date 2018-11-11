package com.crashlytics.android.answers;

import android.annotation.SuppressLint;
import android.content.Context;
import io.fabric.sdk.android.services.c.c;
import io.fabric.sdk.android.services.c.d;

/* compiled from: AnswersPreferenceManager */
class h {
    private final c sf;

    public static h K(Context context) {
        return new h(new d(context, "settings"));
    }

    h(c cVar) {
        this.sf = cVar;
    }

    @SuppressLint({"CommitPrefEdits"})
    public void gt() {
        this.sf.a(this.sf.edit().putBoolean("analytics_launched", true));
    }

    @SuppressLint({"CommitPrefEdits"})
    public boolean gu() {
        return this.sf.aVG().getBoolean("analytics_launched", false);
    }
}
