package com.crashlytics.android.ndk;

import com.crashlytics.android.core.k;
import com.crashlytics.android.core.m;
import com.crashlytics.android.core.o;
import com.crashlytics.android.core.p;
import io.fabric.sdk.android.h;
import io.fabric.sdk.android.services.c.b;
import io.fabric.sdk.android.services.concurrency.UnmetDependencyException;

/* compiled from: CrashlyticsNdk */
public class c extends h<Void> implements p {
    private f wk;
    private o wl;

    public String getIdentifier() {
        return "com.crashlytics.sdk.android.crashlytics-ndk";
    }

    public String getVersion() {
        return "2.0.3.24";
    }

    protected boolean go() {
        k kVar = (k) io.fabric.sdk.android.c.D(k.class);
        if (kVar != null) {
            return a(new a(getContext(), new JniNativeApi(), new e(new b(this))), kVar, new m());
        }
        throw new UnmetDependencyException("CrashlyticsNdk requires Crashlytics");
    }

    boolean a(f fVar, k kVar, m mVar) {
        this.wk = fVar;
        boolean initialize = fVar.initialize();
        if (initialize) {
            mVar.a(kVar, this);
            io.fabric.sdk.android.c.aUg().d("CrashlyticsNdk", "Crashlytics NDK initialization successful");
        }
        return initialize;
    }

    /* renamed from: gk */
    protected Void doInBackground() {
        try {
            this.wl = this.wk.ig();
        } catch (Throwable e) {
            io.fabric.sdk.android.c.aUg().e("CrashlyticsNdk", "Could not process ndk data; ", e);
        }
        return null;
    }

    public o hF() {
        return this.wl;
    }
}
