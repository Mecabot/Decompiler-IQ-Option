package io.card.payment.a;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.TextView;

/* compiled from: ActivityHelper */
public class a {
    @TargetApi(11)
    public static void w(Activity activity) {
        if (aTZ()) {
            activity.requestWindowFeature(8);
        }
    }

    public static void a(Activity activity, TextView textView, String str, String str2, Drawable drawable) {
        if (str2 == null) {
            str2 = "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append(str);
        activity.setTitle(stringBuilder.toString());
        if (aTZ() && x(activity)) {
            a(activity, str, drawable);
            if (textView != null) {
                textView.setVisibility(8);
            }
        } else if (textView != null) {
            textView.setText(str);
        }
    }

    @TargetApi(11)
    private static boolean x(Activity activity) {
        return activity.getActionBar() != null;
    }

    @TargetApi(11)
    private static void a(Activity activity, String str, Drawable drawable) {
        ActionBar actionBar = activity.getActionBar();
        actionBar.setBackgroundDrawable(b.elE);
        actionBar.setTitle(str);
        TextView textView = (TextView) activity.findViewById(Resources.getSystem().getIdentifier("action_bar_title", "id", "android"));
        if (textView != null) {
            textView.setTextColor(-1);
        }
        actionBar.setDisplayHomeAsUpEnabled(false);
        if (drawable == null || VERSION.SDK_INT < 14) {
            actionBar.setDisplayShowHomeEnabled(false);
        } else {
            a(actionBar, drawable);
        }
    }

    private static boolean aTZ() {
        return VERSION.SDK_INT >= 11;
    }

    @TargetApi(14)
    private static void a(ActionBar actionBar, Drawable drawable) {
        actionBar.setIcon(drawable);
    }

    public static boolean aUa() {
        return VERSION.SDK_INT >= 11;
    }

    @TargetApi(11)
    public static void a(Activity activity, boolean z) {
        if (z && activity.getApplicationInfo().theme != 0) {
            activity.setTheme(activity.getApplicationInfo().theme);
        } else if (aUa()) {
            activity.setTheme(16973934);
        } else {
            activity.setTheme(16973836);
        }
    }

    @TargetApi(11)
    public static void y(Activity activity) {
        if (VERSION.SDK_INT >= 11) {
            activity.getWindow().addFlags(8192);
        }
    }
}
