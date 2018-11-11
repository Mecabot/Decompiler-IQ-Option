package com.crashlytics.android.answers;

import android.app.Activity;
import android.os.Bundle;
import io.fabric.sdk.android.a.b;

/* compiled from: AnswersLifecycleCallbacks */
class g extends b {
    private final z rP;
    private final k se;

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public g(z zVar, k kVar) {
        this.rP = zVar;
        this.se = kVar;
    }

    public void onActivityStarted(Activity activity) {
        this.rP.a(activity, Type.START);
    }

    public void onActivityResumed(Activity activity) {
        this.rP.a(activity, Type.RESUME);
        this.se.gw();
    }

    public void onActivityPaused(Activity activity) {
        this.rP.a(activity, Type.PAUSE);
        this.se.gx();
    }

    public void onActivityStopped(Activity activity) {
        this.rP.a(activity, Type.STOP);
    }
}
