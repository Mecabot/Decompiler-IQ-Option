package com.facebook.marketing.internal;

import android.content.Context;
import android.os.Bundle;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.h;

/* compiled from: MarketingLogger */
public final class d {
    private final AppEventsLogger Gy;

    public d(Context context, String str) {
        this.Gy = AppEventsLogger.o(context, str);
    }

    public void nM() {
        if (h.jd() && h.je()) {
            Bundle bundle = new Bundle();
            bundle.putString("_codeless_action", "sdk_initialized");
            this.Gy.a("fb_codeless_debug", null, bundle);
        }
    }
}
