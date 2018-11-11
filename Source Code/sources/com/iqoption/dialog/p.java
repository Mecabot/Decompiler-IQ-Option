package com.iqoption.dialog;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

final /* synthetic */ class p implements AnimatorUpdateListener {
    private final j cft;

    p(j jVar) {
        this.cft = jVar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.cft.c(valueAnimator);
    }
}
