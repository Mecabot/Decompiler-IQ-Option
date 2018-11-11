package com.crashlytics.android.core;

import android.content.Context;
import android.os.Bundle;

/* compiled from: ManifestUnityVersionProvider */
class ab implements au {
    private final Context context;
    private final String packageName;

    public ab(Context context, String str) {
        this.context = context;
        this.packageName = str;
    }

    public String hX() {
        String str = null;
        try {
            Bundle bundle = this.context.getPackageManager().getApplicationInfo(this.packageName, 128).metaData;
            if (bundle != null) {
                str = bundle.getString("io.fabric.unity.crashlytics.version");
            }
        } catch (Exception unused) {
            return str;
        }
    }
}
