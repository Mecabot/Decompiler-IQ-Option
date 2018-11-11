package com.iqoption.operations;

import android.animation.ObjectAnimator;
import android.view.View;
import com.iqoption.fragment.base.b;
import com.iqoption.view.a.a.d;

/* compiled from: BaseOperationHistoryFragment */
public abstract class a extends b {
    public long getAnimationDuration() {
        return 400;
    }

    protected abstract View getRootView();

    public void ND() {
        View rootView = getRootView();
        if (rootView != null) {
            rootView.setTranslationX((float) rootView.getWidth());
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(rootView, View.TRANSLATION_X, new float[]{0.0f});
            ofFloat.setDuration(NF());
            ofFloat.setInterpolator(d.aQV);
            ofFloat.start();
        }
    }

    public void NE() {
        View rootView = getRootView();
        if (rootView != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(rootView, View.TRANSLATION_X, new float[]{(float) rootView.getWidth()});
            ofFloat.setDuration(NG());
            ofFloat.setInterpolator(d.aQV);
            ofFloat.start();
        }
    }
}
