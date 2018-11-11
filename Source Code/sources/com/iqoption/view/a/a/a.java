package com.iqoption.view.a.a;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.support.annotation.ColorInt;
import android.view.View;
import java.lang.ref.WeakReference;

/* compiled from: BackgroundColorAnimator */
public class a implements AnimatorUpdateListener {
    private final WeakReference<View> dEK;

    public a(View view) {
        this.dEK = new WeakReference(view);
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        View view = (View) this.dEK.get();
        if (view != null) {
            view.setBackgroundColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    public static Animator c(View view, @ColorInt int i, @ColorInt int i2) {
        Animator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        ofObject.addUpdateListener(new a(view));
        return ofObject;
    }
}
