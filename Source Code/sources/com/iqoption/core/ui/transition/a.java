package com.iqoption.core.ui.transition;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.TextView;

final /* synthetic */ class a implements AnimatorUpdateListener {
    private final TextView bcf;

    a(TextView textView) {
        this.bcf = textView;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        TextScaleResize.a(this.bcf, valueAnimator);
    }
}
