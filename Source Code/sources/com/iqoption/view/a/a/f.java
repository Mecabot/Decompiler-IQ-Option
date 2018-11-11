package com.iqoption.view.a.a;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import java.lang.ref.WeakReference;

/* compiled from: TopMarginAnimator */
public class f implements AnimatorUpdateListener {
    private final WeakReference<View> dEK;
    private final WeakReference<MarginLayoutParams> dEL;

    public f(View view) {
        this.dEK = new WeakReference(view);
        this.dEL = new WeakReference((MarginLayoutParams) view.getLayoutParams());
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        View view = (View) this.dEK.get();
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.dEL.get();
        if (view != null && marginLayoutParams != null) {
            marginLayoutParams.topMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            view.requestLayout();
        }
    }
}
