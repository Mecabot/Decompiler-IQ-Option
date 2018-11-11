package com.iqoption.core.ui.widget;

import android.graphics.Point;
import android.support.annotation.NonNull;
import android.view.View.MeasureSpec;

public abstract /* synthetic */ class d {
    @NonNull
    public static Point a(c cVar, int i, int i2, int i3, int i4) {
        int size = MeasureSpec.getSize(i3);
        if (i > 0 && i < size) {
            i3 = MeasureSpec.makeMeasureSpec(i, MeasureSpec.getMode(i3));
        }
        size = MeasureSpec.getSize(i4);
        if (i2 > 0 && i2 < size) {
            i4 = MeasureSpec.makeMeasureSpec(i2, MeasureSpec.getMode(i4));
        }
        return new Point(i3, i4);
    }
}
