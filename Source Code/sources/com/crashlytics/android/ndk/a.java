package com.crashlytics.android.ndk;

import android.content.Context;
import com.crashlytics.android.core.o;
import io.fabric.sdk.android.c;
import java.io.File;
import java.util.TreeSet;

/* compiled from: BreakpadController */
class a implements f {
    private final Context context;
    private final d wi;
    private final b wj;

    a(Context context, d dVar, b bVar) {
        this.context = context;
        this.wi = dVar;
        this.wj = bVar;
    }

    public boolean initialize() {
        File ih = this.wj.ih();
        if (ih == null) {
            return false;
        }
        try {
            return this.wi.a(ih.getCanonicalPath(), this.context.getAssets());
        } catch (Throwable e) {
            c.aUg().e("CrashlyticsNdk", "Error initializing CrashlyticsNdk", e);
            return false;
        }
    }

    public o ig() {
        TreeSet ii = this.wj.ii();
        if (!ii.isEmpty()) {
            ii.pollFirst();
        }
        return new o(ii);
    }
}
