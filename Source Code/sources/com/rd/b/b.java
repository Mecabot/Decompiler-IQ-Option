package com.rd.b;

import android.content.res.Resources;
import android.util.TypedValue;

/* compiled from: DensityUtils */
public class b {
    public static int dpToPx(int i) {
        return (int) TypedValue.applyDimension(1, (float) i, Resources.getSystem().getDisplayMetrics());
    }
}
