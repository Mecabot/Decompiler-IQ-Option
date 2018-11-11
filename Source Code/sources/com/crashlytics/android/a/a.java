package com.crashlytics.android.a;

import io.fabric.sdk.android.c;
import io.fabric.sdk.android.h;
import io.fabric.sdk.android.services.common.IdManager.DeviceIdentifierType;
import io.fabric.sdk.android.services.common.k;
import java.util.Collections;
import java.util.Map;

/* compiled from: Beta */
public class a extends h<Boolean> implements k {
    public String getIdentifier() {
        return "com.crashlytics.sdk.android:beta";
    }

    public String getVersion() {
        return "1.2.9.26";
    }

    /* renamed from: gp */
    protected Boolean doInBackground() {
        c.aUg().d("Beta", "Beta kit initializing...");
        return Boolean.valueOf(true);
    }

    public Map<DeviceIdentifierType, String> gN() {
        return Collections.emptyMap();
    }
}
