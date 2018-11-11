package com.facebook.internal;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.support.customtabs.CustomTabsIntent.Builder;
import com.facebook.h;

/* compiled from: CustomTab */
public class e {
    private Uri uri;

    public e(String str, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        String mq = v.mq();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(h.iZ());
        stringBuilder.append("/");
        stringBuilder.append("dialog/");
        stringBuilder.append(str);
        this.uri = w.b(mq, stringBuilder.toString(), bundle);
    }

    public void b(Activity activity, String str) {
        CustomTabsIntent build = new Builder().build();
        build.intent.setPackage(str);
        build.intent.addFlags(1073741824);
        build.launchUrl(activity, this.uri);
    }
}
