package com.jumio.commons.utils;

import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;

public class DrawableUtil {
    public static void tint(Drawable drawable, int i) {
        if ((drawable instanceof BitmapDrawable) || (drawable instanceof NinePatchDrawable)) {
            drawable.setTint(i);
        } else {
            drawable.setColorFilter(i, Mode.SRC_IN);
        }
    }
}
