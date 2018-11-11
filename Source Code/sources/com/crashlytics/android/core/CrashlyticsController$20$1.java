package com.crashlytics.android.core;

import android.text.TextUtils;
import com.crashlytics.android.core.j.AnonymousClass12;
import java.util.HashMap;

class CrashlyticsController$20$1 extends HashMap<String, Object> {
    final /* synthetic */ AnonymousClass12 this$1;

    CrashlyticsController$20$1(AnonymousClass12 anonymousClass12) {
        this.this$1 = anonymousClass12;
        put("app_identifier", r3);
        put("api_key", j.this.tU.sO);
        put("version_code", r4);
        put("version_name", r5);
        put("install_uuid", r6);
        put("delivery_mechanism", Integer.valueOf(r7));
        put("unity_version", TextUtils.isEmpty(j.this.ub) ? "" : j.this.ub);
    }
}
