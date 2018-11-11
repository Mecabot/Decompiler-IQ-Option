package com.iqoption.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import com.iqoption.core.i;

/* compiled from: ActivityUtils */
public final class a {
    private static final String TAG = "com.iqoption.util.a";

    private a() {
    }

    public static void s(Activity activity) {
        if (VERSION.SDK_INT >= 21) {
            activity.finishAfterTransition();
        } else {
            activity.finish();
        }
    }

    public static void t(Activity activity) {
        a(activity, null);
    }

    public static void a(Activity activity, @Nullable Intent intent) {
        Intent parentActivityIntent = NavUtils.getParentActivityIntent(activity);
        if (!(intent == null || parentActivityIntent == null)) {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                parentActivityIntent.putExtras(extras);
            }
            parentActivityIntent.setData(intent.getData());
        }
        parentActivityIntent.addFlags(65536);
        if (NavUtils.shouldUpRecreateTask(activity, parentActivityIntent) || activity.isTaskRoot()) {
            i.v(TAG, "create activity stack");
            activity.startActivity(parentActivityIntent);
            s(activity);
            activity.overridePendingTransition(0, 0);
            return;
        }
        i.v(TAG, "navigate to parent");
        parentActivityIntent.setFlags(67108864);
        NavUtils.navigateUpTo(activity, parentActivityIntent);
        activity.overridePendingTransition(0, 0);
    }

    public static void b(Activity activity, Intent intent) {
        try {
            activity.startActivity(intent);
        } catch (Throwable e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("safeStartActivity");
            stringBuilder.append(intent.toString());
            k.log(stringBuilder.toString());
            k.c(e);
        }
    }
}
