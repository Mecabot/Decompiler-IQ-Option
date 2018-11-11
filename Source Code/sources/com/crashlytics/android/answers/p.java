package com.crashlytics.android.answers;

import android.content.Context;
import com.google.firebase.analytics.FirebaseAnalytics.a;
import io.fabric.sdk.android.c;

/* compiled from: FirebaseAnalyticsApiAdapter */
class p {
    private final Context context;
    private final r sB;
    private o sC;

    public p(Context context) {
        this(context, new r());
    }

    public p(Context context, r rVar) {
        this.context = context;
        this.sB = rVar;
    }

    public o gE() {
        if (this.sC == null) {
            this.sC = j.L(this.context);
        }
        return this.sC;
    }

    public void b(SessionEvent sessionEvent) {
        o gE = gE();
        if (gE == null) {
            c.aUg().d("Answers", "Firebase analytics logging was enabled, but not available...");
            return;
        }
        q c = this.sB.c(sessionEvent);
        if (c == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Fabric event was not mappable to Firebase event: ");
            stringBuilder.append(sessionEvent);
            c.aUg().d("Answers", stringBuilder.toString());
            return;
        }
        gE.logEvent(c.gF(), c.gG());
        if ("levelEnd".equals(sessionEvent.sY)) {
            gE.logEvent(a.POST_SCORE, c.gG());
        }
    }
}
