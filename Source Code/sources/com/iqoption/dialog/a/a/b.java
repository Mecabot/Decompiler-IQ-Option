package com.iqoption.dialog.a.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.v7.content.res.AppCompatResources;

/* compiled from: DrawerHelper */
public final class b {
    public static float e(float f, float f2, float f3) {
        return f < f2 ? 0.0f : f < f3 ? (f - f2) / (f3 - f2) : 1.0f;
    }

    public static Drawable m(Context context, @DrawableRes int i) {
        Drawable drawable = AppCompatResources.getDrawable(context, i);
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        return drawable;
    }
}
