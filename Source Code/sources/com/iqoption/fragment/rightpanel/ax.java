package com.iqoption.fragment.rightpanel;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import com.iqoption.view.a.a.d;
import com.iqoption.x.R;

/* compiled from: StateAnimator */
final class ax {
    private final View cHJ;
    private final View cHK;
    private final View cHL;
    private AnimatorSet cwf;
    int mState = 0;
    private final float translationX;

    public ax(View view, View view2, View view3) {
        this.cHJ = view;
        this.cHK = view2;
        this.cHL = view3;
        this.translationX = view.getContext().getResources().getDimension(R.dimen.dp54);
    }

    public ax(View view, View view2, View view3, float f) {
        this.cHJ = view;
        this.cHK = view2;
        this.cHL = view3;
        this.translationX = f;
    }

    public void eY(int i) {
        if (this.mState != i) {
            this.mState = i;
            if (this.cwf != null) {
                this.cwf.cancel();
            }
            this.cwf = new AnimatorSet();
            this.cwf.setInterpolator(d.dEM);
            AnimatorSet animatorSet;
            Animator[] animatorArr;
            switch (this.mState) {
                case 0:
                    animatorSet = this.cwf;
                    animatorArr = new Animator[3];
                    animatorArr[0] = ObjectAnimator.ofFloat(this.cHJ, View.ALPHA, new float[]{1.0f});
                    animatorArr[1] = ObjectAnimator.ofFloat(this.cHK, View.TRANSLATION_X, new float[]{0.0f});
                    animatorArr[2] = ObjectAnimator.ofFloat(this.cHL, View.ALPHA, new float[]{0.0f});
                    animatorSet.playTogether(animatorArr);
                    this.cwf.addListener(new AnimatorListenerAdapter() {
                        public void onAnimationEnd(Animator animator) {
                            ax.this.cHL.setVisibility(8);
                        }
                    });
                    break;
                case 1:
                    animatorSet = this.cwf;
                    Animator[] animatorArr2 = new Animator[3];
                    animatorArr2[0] = ObjectAnimator.ofFloat(this.cHJ, View.ALPHA, new float[]{0.0f});
                    animatorArr2[1] = ObjectAnimator.ofFloat(this.cHK, View.TRANSLATION_X, new float[]{-(this.translationX / 2.0f)});
                    animatorArr2[2] = ObjectAnimator.ofFloat(this.cHL, View.ALPHA, new float[]{0.0f});
                    animatorSet.playTogether(animatorArr2);
                    this.cwf.addListener(new AnimatorListenerAdapter() {
                        public void onAnimationEnd(Animator animator) {
                            ax.this.cHL.setVisibility(8);
                        }
                    });
                    break;
                case 2:
                    animatorSet = this.cwf;
                    animatorArr = new Animator[3];
                    animatorArr[0] = ObjectAnimator.ofFloat(this.cHJ, View.ALPHA, new float[]{0.0f});
                    animatorArr[1] = ObjectAnimator.ofFloat(this.cHK, View.TRANSLATION_X, new float[]{-this.translationX});
                    animatorArr[2] = ObjectAnimator.ofFloat(this.cHL, View.ALPHA, new float[]{1.0f});
                    animatorSet.playTogether(animatorArr);
                    this.cwf.addListener(new AnimatorListenerAdapter() {
                        public void onAnimationStart(Animator animator) {
                            ax.this.cHL.setVisibility(0);
                        }
                    });
                    break;
            }
            this.cwf.start();
        }
    }
}
