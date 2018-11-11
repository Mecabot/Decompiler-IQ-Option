package com.iqoption.core.ui.widget.nps;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

final /* synthetic */ class e implements AnimatorUpdateListener {
    private final NpsRatingBar bfP;

    e(NpsRatingBar npsRatingBar) {
        this.bfP = npsRatingBar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.bfP.b(valueAnimator);
    }
}
