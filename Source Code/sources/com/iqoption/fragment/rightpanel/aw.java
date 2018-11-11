package com.iqoption.fragment.rightpanel;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import com.iqoption.view.a.a.d;
import com.iqoption.x.R;

/* compiled from: SelectAnimator */
final class aw {
    private final View cGs;
    private final View cGt;
    private AnimatorSet cHG;
    private AnimatorSet cHH;
    private final float cHI;

    public aw(View view, View view2) {
        this.cGs = view;
        this.cGt = view2;
        this.cHI = view.getContext().getResources().getDimension(R.dimen.dp27);
    }

    public void select() {
        if (this.cHG == null) {
            this.cHG = new AnimatorSet();
            this.cHG.setInterpolator(d.dEM);
            AnimatorSet animatorSet = this.cHG;
            Animator[] animatorArr = new Animator[2];
            animatorArr[0] = ObjectAnimator.ofFloat(this.cGt, View.ALPHA, new float[]{0.0f});
            animatorArr[1] = ObjectAnimator.ofFloat(this.cGs, View.TRANSLATION_X, new float[]{-this.cHI});
            animatorSet.playTogether(animatorArr);
        } else {
            this.cHG.cancel();
        }
        if (this.cHH != null) {
            this.cHH.cancel();
        }
        this.cHG.start();
    }

    public void aoe() {
        if (this.cHH == null) {
            this.cHH = new AnimatorSet();
            this.cHH.setInterpolator(d.dEM);
            AnimatorSet animatorSet = this.cHH;
            Animator[] animatorArr = new Animator[2];
            animatorArr[0] = ObjectAnimator.ofFloat(this.cGt, View.ALPHA, new float[]{1.0f});
            animatorArr[1] = ObjectAnimator.ofFloat(this.cGs, View.TRANSLATION_X, new float[]{0.0f});
            animatorSet.playTogether(animatorArr);
        } else {
            this.cHH.cancel();
        }
        if (this.cHG != null) {
            this.cHG.cancel();
        }
        this.cHH.start();
    }
}
