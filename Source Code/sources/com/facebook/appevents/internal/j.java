package com.facebook.appevents.internal;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import com.facebook.h;

/* compiled from: SourceApplicationInfo */
class j {
    private String Bs;
    private boolean Bt;

    /* compiled from: SourceApplicationInfo */
    public static class a {
        public static j j(Activity activity) {
            String str = "";
            ComponentName callingActivity = activity.getCallingActivity();
            if (callingActivity != null) {
                str = callingActivity.getPackageName();
                if (str.equals(activity.getPackageName())) {
                    return null;
                }
            }
            Intent intent = activity.getIntent();
            boolean z = false;
            if (!(intent == null || intent.getBooleanExtra("_fbSourceApplicationHasBeenSet", false))) {
                intent.putExtra("_fbSourceApplicationHasBeenSet", true);
                Bundle c = a.a.c(intent);
                if (c != null) {
                    Bundle bundle = c.getBundle("referer_app_link");
                    if (bundle != null) {
                        str = bundle.getString("package");
                    }
                    z = true;
                }
            }
            intent.putExtra("_fbSourceApplicationHasBeenSet", true);
            return new j(str, z);
        }
    }

    private j(String str, boolean z) {
        this.Bs = str;
        this.Bt = z;
    }

    public static j lq() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(h.getApplicationContext());
        if (defaultSharedPreferences.contains("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage")) {
            return new j(defaultSharedPreferences.getString("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage", null), defaultSharedPreferences.getBoolean("com.facebook.appevents.SourceApplicationInfo.openedByApplink", false));
        }
        return null;
    }

    public static void lr() {
        Editor edit = PreferenceManager.getDefaultSharedPreferences(h.getApplicationContext()).edit();
        edit.remove("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage");
        edit.remove("com.facebook.appevents.SourceApplicationInfo.openedByApplink");
        edit.apply();
    }

    public String toString() {
        String str = "Unclassified";
        if (this.Bt) {
            str = "Applink";
        }
        if (this.Bs == null) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("(");
        stringBuilder.append(this.Bs);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void ls() {
        Editor edit = PreferenceManager.getDefaultSharedPreferences(h.getApplicationContext()).edit();
        edit.putString("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage", this.Bs);
        edit.putBoolean("com.facebook.appevents.SourceApplicationInfo.openedByApplink", this.Bt);
        edit.apply();
    }
}
