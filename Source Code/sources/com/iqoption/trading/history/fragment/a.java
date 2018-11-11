package com.iqoption.trading.history.fragment;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import com.iqoption.fragment.base.b;
import com.iqoption.trading.history.TradingHistoryActivity;
import com.iqoption.util.am;
import com.iqoption.view.a.a.d;

/* compiled from: BaseHistoryFragment */
public abstract class a extends b {

    /* compiled from: BaseHistoryFragment */
    public interface a {
        View aeP();
    }

    protected abstract View aeO();

    protected abstract View aeP();

    public long getAnimationDuration() {
        return 400;
    }

    public TradingHistoryActivity aES() {
        return (TradingHistoryActivity) zzakw();
    }

    public void bO(View view) {
        Context aES = aES();
        am.a(aES, view);
        aES.adL.aGp();
    }

    public boolean onClose() {
        getFragmentManager().popBackStack();
        return true;
    }

    public void ND() {
        View aeO = aeO();
        View aeP = aeP();
        aeO.setTranslationX((float) aeO.getWidth());
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(aeO, View.TRANSLATION_X, new float[]{0.0f});
        aeP.setAlpha(0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(aeP, View.ALPHA, new float[]{1.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        com.iqoption.util.b.a(animatorSet, getAnimationDuration());
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        animatorSet.setInterpolator(d.aQV);
        animatorSet.start();
    }

    public void NE() {
        View aeO = aeO();
        View aeP = aeP();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(aeO, View.TRANSLATION_X, new float[]{(float) aeO.getWidth()});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(aeP, View.ALPHA, new float[]{0.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        com.iqoption.util.b.a(animatorSet, getAnimationDuration());
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        animatorSet.setInterpolator(d.aQW);
        animatorSet.start();
    }
}
