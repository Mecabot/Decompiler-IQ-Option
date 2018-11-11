package com.crashlytics.android.core;

import android.os.Build;
import com.crashlytics.android.core.j.AnonymousClass16;
import java.util.HashMap;

class CrashlyticsController$24$1 extends HashMap<String, Object> {
    final /* synthetic */ AnonymousClass16 this$1;

    CrashlyticsController$24$1(AnonymousClass16 anonymousClass16) {
        this.this$1 = anonymousClass16;
        put("arch", Integer.valueOf(r2));
        put("build_model", Build.MODEL);
        put("available_processors", Integer.valueOf(r3));
        put("total_ram", Long.valueOf(r4));
        put("disk_space", Long.valueOf(r6));
        put("is_emulator", Boolean.valueOf(r8));
        put("ids", r9);
        put("state", Integer.valueOf(r10));
        put("build_manufacturer", Build.MANUFACTURER);
        put("build_product", Build.PRODUCT);
    }
}
