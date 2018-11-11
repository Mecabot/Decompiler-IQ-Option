package com.iqoption.fragment.base;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetBehavior.BottomSheetCallback;
import android.view.View;
import com.iqoption.util.b;
import com.iqoption.util.bg;
import com.iqoption.view.a.a.d;

/* compiled from: BaseBottomSheet */
public abstract class a extends b {
    private float offset;

    protected void G(float f) {
    }

    protected abstract View aeO();

    protected abstract View aeP();

    protected void ajR() {
    }

    protected boolean ajT() {
        return true;
    }

    protected void eM(int i) {
    }

    public final long getAnimationDuration() {
        return 300;
    }

    protected boolean getSkipCollapsed() {
        return true;
    }

    public final void ND() {
        View aeO = aeO();
        View aeP = aeP();
        aeO.setTranslationY((float) aeO.getHeight());
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(aeO, View.TRANSLATION_Y, new float[]{0.0f});
        aeP.setAlpha(0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(aeP, View.ALPHA, new float[]{1.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        b.a(animatorSet, getAnimationDuration());
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        animatorSet.setInterpolator(d.aQV);
        animatorSet.start();
    }

    public final void NE() {
        View aeO = aeO();
        View aeP = aeP();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(aeO, View.TRANSLATION_Y, new float[]{(float) aeO.getHeight()});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(aeP, View.ALPHA, new float[]{0.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        b.a(animatorSet, getAnimationDuration());
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        animatorSet.setInterpolator(d.aQW);
        animatorSet.start();
    }

    public final boolean onClose() {
        getFragmentManager().popBackStack();
        ajR();
        return true;
    }

    protected final void m(float f) {
        this.offset = f;
        G(f);
    }

    public final float ajS() {
        return this.offset;
    }

    public final void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        view = aeO();
        aeP().setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                a.this.onClose();
            }
        });
        BottomSheetBehavior from = BottomSheetBehavior.from(view);
        from.setBottomSheetCallback(new BottomSheetCallback() {
            public void onStateChanged(@NonNull View view, int i) {
                a.this.eM(i);
                if (i == 5) {
                    a.this.onClose();
                }
            }

            public void onSlide(@NonNull View view, float f) {
                a.this.m(f);
            }
        });
        from.setSkipCollapsed(getSkipCollapsed());
        from.setPeekHeight(getPeekHeight());
        from.setHideable(ajT());
    }

    protected int getPeekHeight() {
        View aeO = aeO();
        bg.bU(aeO);
        return aeO.getMeasuredHeight();
    }
}
