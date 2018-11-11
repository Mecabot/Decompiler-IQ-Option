package com.crashlytics.android.core;

import android.os.Build.VERSION;
import com.crashlytics.android.core.j.AnonymousClass14;
import java.util.HashMap;

class CrashlyticsController$22$1 extends HashMap<String, Object> {
    final /* synthetic */ AnonymousClass14 this$1;

    CrashlyticsController$22$1(AnonymousClass14 anonymousClass14) {
        this.this$1 = anonymousClass14;
        put("version", VERSION.RELEASE);
        put("build_version", VERSION.CODENAME);
        put("is_rooted", Boolean.valueOf(r0));
    }
}
