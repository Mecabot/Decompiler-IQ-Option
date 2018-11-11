package com.iqoption.fragment.rightpanel;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
import com.iqoption.core.i;
import com.iqoption.view.a.a.d;

/* compiled from: CrossfadeAnimator */
public final class x {
    private final View[] cGq;
    private final a cGr;
    private View cGs;
    private View cGt;
    private AnimatorSet cwf;

    /* compiled from: CrossfadeAnimator */
    public interface a {
        void a(AnimatorSet animatorSet);

        void e(View view, View view2);

        Animator f(View view, View view2);

        Animator g(View view, View view2);
    }

    /* compiled from: CrossfadeAnimator */
    public static class b implements a {
        private final int translationY;

        protected b(int i) {
            this.translationY = i;
        }

        public void e(View view, View view2) {
            view.setTranslationY((float) this.translationY);
            view.setAlpha(0.0f);
        }

        public void a(AnimatorSet animatorSet) {
            animatorSet.setInterpolator(d.dEM);
        }

        public Animator f(View view, View view2) {
            PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[2];
            propertyValuesHolderArr[0] = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{1.0f});
            propertyValuesHolderArr[1] = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{0.0f});
            return ObjectAnimator.ofPropertyValuesHolder(view, propertyValuesHolderArr);
        }

        public Animator g(View view, View view2) {
            PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[2];
            propertyValuesHolderArr[0] = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f});
            propertyValuesHolderArr[1] = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{(float) this.translationY});
            return ObjectAnimator.ofPropertyValuesHolder(view2, propertyValuesHolderArr);
        }
    }

    public x(int i, View... viewArr) {
        this(new b(i), viewArr);
    }

    public x(a aVar, View... viewArr) {
        this.cGq = viewArr;
        if (aVar == null) {
            aVar = new b(0);
        }
        this.cGr = aVar;
    }

    public boolean bl(View view) {
        return view.getVisibility() == 0 && view != this.cGt;
    }

    public void L(View view) {
        if (this.cwf != null) {
            this.cwf.cancel();
        }
        if (bm(view)) {
            this.cwf = new AnimatorSet();
            this.cGs.setVisibility(0);
            this.cGr.e(this.cGs, this.cGt);
            Builder play = this.cwf.play(this.cGr.f(this.cGs, this.cGt));
            if (this.cGt != null) {
                play.with(this.cGr.g(this.cGs, this.cGt));
                this.cwf.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        x.this.cGt.setVisibility(8);
                    }
                });
            }
            this.cGr.a(this.cwf);
            this.cwf.start();
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Wrong view to show: ");
        stringBuilder.append(view);
        i.w("CrossfadeAnimator", stringBuilder.toString());
    }

    private boolean bm(View view) {
        this.cGs = null;
        this.cGt = null;
        boolean z = false;
        for (View view2 : this.cGq) {
            if (view2 == view) {
                this.cGs = view2;
                z = true;
            } else if (view2.getVisibility() == 0) {
                this.cGt = view2;
            }
        }
        return z;
    }
}
