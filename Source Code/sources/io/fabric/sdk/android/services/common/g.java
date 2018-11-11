package io.fabric.sdk.android.services.common;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import io.fabric.sdk.android.c;

/* compiled from: ApiKey */
public class g {
    protected String aUA() {
        return "Fabric could not be initialized, API key missing from AndroidManifest.xml. Add the following tag to your Application element \n\t<meta-data android:name=\"io.fabric.ApiKey\" android:value=\"YOUR_API_KEY\"/>";
    }

    public String cA(Context context) {
        Object cC = cC(context);
        if (TextUtils.isEmpty(cC)) {
            cC = cD(context);
        }
        if (TextUtils.isEmpty(cC)) {
            cC = cB(context);
        }
        if (TextUtils.isEmpty(cC)) {
            cE(context);
        }
        return cC;
    }

    protected String cB(Context context) {
        return new m().cB(context);
    }

    protected String cC(Context context) {
        Object e;
        StringBuilder stringBuilder;
        String str = null;
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle == null) {
                return null;
            }
            String string = bundle.getString("io.fabric.ApiKey");
            try {
                if ("@string/twitter_consumer_secret".equals(string)) {
                    c.aUg().d("Fabric", "Ignoring bad default value for Fabric ApiKey set by FirebaseUI-Auth");
                } else {
                    str = string;
                }
                if (str != null) {
                    return str;
                }
                c.aUg().d("Fabric", "Falling back to Crashlytics key lookup from Manifest");
                return bundle.getString("com.crashlytics.ApiKey");
            } catch (Exception e2) {
                e = e2;
                str = string;
                stringBuilder = new StringBuilder();
                stringBuilder.append("Caught non-fatal exception while retrieving apiKey: ");
                stringBuilder.append(e);
                c.aUg().d("Fabric", stringBuilder.toString());
                return str;
            }
        } catch (Exception e3) {
            e = e3;
            stringBuilder = new StringBuilder();
            stringBuilder.append("Caught non-fatal exception while retrieving apiKey: ");
            stringBuilder.append(e);
            c.aUg().d("Fabric", stringBuilder.toString());
            return str;
        }
    }

    protected String cD(Context context) {
        int h = CommonUtils.h(context, "io.fabric.ApiKey", "string");
        if (h == 0) {
            c.aUg().d("Fabric", "Falling back to Crashlytics key lookup from Strings");
            h = CommonUtils.h(context, "com.crashlytics.ApiKey", "string");
        }
        return h != 0 ? context.getResources().getString(h) : null;
    }

    protected void cE(Context context) {
        if (c.aUh() || CommonUtils.cM(context)) {
            throw new IllegalArgumentException(aUA());
        }
        c.aUg().e("Fabric", aUA());
    }
}
