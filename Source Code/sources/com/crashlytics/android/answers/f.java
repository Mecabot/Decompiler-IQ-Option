package com.crashlytics.android.answers;

import android.content.Context;
import android.os.Looper;
import io.fabric.sdk.android.services.b.g;
import io.fabric.sdk.android.services.c.a;
import io.fabric.sdk.android.services.common.q;

/* compiled from: AnswersFilesManagerProvider */
class f {
    final Context context;
    final a sc;

    public f(Context context, a aVar) {
        this.context = context;
        this.sc = aVar;
    }

    public x gs() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("AnswersFilesManagerProvider cannot be called on the main thread");
        }
        return new x(this.context, new ac(), new q(), new g(this.context, this.sc.getFilesDir(), "session_analytics.tap", "session_analytics_to_send"));
    }
}
