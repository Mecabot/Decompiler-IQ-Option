package com.iqoption.view.toppanel;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.drawable.GradientDrawable;

final /* synthetic */ class g implements AnimatorUpdateListener {
    private final GradientDrawable dKq;

    g(GradientDrawable gradientDrawable) {
        this.dKq = gradientDrawable;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.dKq.setColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }
}
