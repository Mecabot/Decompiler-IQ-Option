package com.iqoption.charttools.constructor.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

final /* synthetic */ class c implements AnimatorUpdateListener {
    private final ColorPicker awk;

    c(ColorPicker colorPicker) {
        this.awk = colorPicker;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.awk.a(valueAnimator);
    }
}
