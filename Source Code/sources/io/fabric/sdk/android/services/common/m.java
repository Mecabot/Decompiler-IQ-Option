package io.fabric.sdk.android.services.common;

import android.content.Context;
import android.text.TextUtils;
import io.fabric.sdk.android.c;

/* compiled from: FirebaseInfo */
public class m {
    protected String cB(Context context) {
        int h = CommonUtils.h(context, "google_app_id", "string");
        if (h == 0) {
            return null;
        }
        c.aUg().d("Fabric", "Generating Crashlytics ApiKey from google_app_id in Strings");
        return lD(context.getResources().getString(h));
    }

    protected String lD(String str) {
        return CommonUtils.ly(str).substring(0, 40);
    }

    public boolean cS(Context context) {
        boolean z = false;
        if (CommonUtils.b(context, "com.crashlytics.useFirebaseAppId", false)) {
            return true;
        }
        Object obj = CommonUtils.h(context, "google_app_id", "string") != 0 ? 1 : null;
        Object obj2 = (TextUtils.isEmpty(new g().cC(context)) && TextUtils.isEmpty(new g().cD(context))) ? null : 1;
        if (obj != null && obj2 == null) {
            z = true;
        }
        return z;
    }
}
