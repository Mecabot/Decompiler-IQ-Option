package com.iqoption.view.a.a;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.lang.ref.WeakReference;

/* compiled from: HeightAnimator */
public class b implements AnimatorUpdateListener {
    private final WeakReference<View> dEK;
    private final WeakReference<LayoutParams> dEL;

    public b(View view) {
        this.dEK = new WeakReference(view);
        this.dEL = new WeakReference(view.getLayoutParams());
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        View view = (View) this.dEK.get();
        LayoutParams layoutParams = (LayoutParams) this.dEL.get();
        if (view != null && layoutParams != null) {
            layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            view.requestLayout();
        }
    }
}
