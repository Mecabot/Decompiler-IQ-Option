package com.iqoption.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

final /* synthetic */ class a implements AnimatorUpdateListener {
    private final CounterView dOd;

    a(CounterView counterView) {
        this.dOd = counterView;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.dOd.d(valueAnimator);
    }
}
