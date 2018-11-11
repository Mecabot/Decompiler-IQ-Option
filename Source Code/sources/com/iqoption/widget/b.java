package com.iqoption.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

final /* synthetic */ class b implements AnimatorUpdateListener {
    private final CounterView dOd;

    b(CounterView counterView) {
        this.dOd = counterView;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.dOd.d(valueAnimator);
    }
}
