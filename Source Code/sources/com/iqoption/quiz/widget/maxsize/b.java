package com.iqoption.quiz.widget.maxsize;

import android.graphics.Point;
import android.support.annotation.NonNull;
import android.view.View.MeasureSpec;

public abstract /* synthetic */ class b {
    @NonNull
    public static Point a(a aVar, int i, int i2, int i3, int i4) {
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

    @NonNull
    public static Point a(a aVar, float f, float f2, int i, int i2) {
        int size = MeasureSpec.getSize(i);
        int round = Math.round(f * ((float) size));
        if (round > 0 && round < size) {
            i = MeasureSpec.makeMeasureSpec(round, MeasureSpec.getMode(i));
        }
        size = MeasureSpec.getSize(i2);
        round = Math.round(f2 * ((float) size));
        if (round > 0 && round < size) {
            i2 = MeasureSpec.makeMeasureSpec(round, MeasureSpec.getMode(i2));
        }
        return new Point(i, i2);
    }
}
