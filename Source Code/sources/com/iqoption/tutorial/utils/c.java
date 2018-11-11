package com.iqoption.tutorial.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Point;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.view.View;
import com.google.android.gms.analytics.ecommerce.Promotion;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, aXE = {"translateWithDelayedReverse", "", "view", "Landroid/view/View;", "startPoint", "Landroid/graphics/Point;", "endPoint", "animDurations", "Lcom/iqoption/tutorial/utils/AnimDurations;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: TutorialAnimations.kt */
public final class c {

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, aXE = {"com/iqoption/tutorial/utils/TutorialAnimationsKt$translateWithDelayedReverse$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: TutorialAnimations.kt */
    public static final class a extends AnimatorListenerAdapter {
        final /* synthetic */ View bbd;
        final /* synthetic */ a duJ;
        final /* synthetic */ AnimatorSet duK;
        final /* synthetic */ AnimatorSet duL;

        a(a aVar, AnimatorSet animatorSet, View view, AnimatorSet animatorSet2) {
            this.duJ = aVar;
            this.duK = animatorSet;
            this.bbd = view;
            this.duL = animatorSet2;
        }

        public void onAnimationEnd(Animator animator) {
            if (this.bbd.isAttachedToWindow()) {
                this.duL.start();
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, aXE = {"com/iqoption/tutorial/utils/TutorialAnimationsKt$translateWithDelayedReverse$2$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: TutorialAnimations.kt */
    public static final class b extends AnimatorListenerAdapter {
        final /* synthetic */ View bbd;
        final /* synthetic */ a duJ;
        final /* synthetic */ AnimatorSet duK;

        b(a aVar, View view, AnimatorSet animatorSet) {
            this.duJ = aVar;
            this.bbd = view;
            this.duK = animatorSet;
        }

        public void onAnimationEnd(Animator animator) {
            if (this.bbd.isAttachedToWindow()) {
                this.duK.start();
            }
        }
    }

    public static final void a(View view, Point point, Point point2, a aVar) {
        h.e(view, Promotion.ACTION_VIEW);
        h.e(point, "startPoint");
        h.e(point2, "endPoint");
        h.e(aVar, "animDurations");
        float f = ((float) point2.x) - ((float) point.x);
        float f2 = ((float) point2.y) - ((float) point.y);
        AnimatorSet animatorSet = new AnimatorSet();
        Animator[] animatorArr = new Animator[2];
        animatorArr[0] = ObjectAnimator.ofFloat(view, View.TRANSLATION_X, new float[]{0.0f, f});
        animatorArr[1] = ObjectAnimator.ofFloat(view, View.TRANSLATION_Y, new float[]{0.0f, f2});
        animatorSet.playTogether(animatorArr);
        AnimatorSet animatorSet2 = new AnimatorSet();
        Animator[] animatorArr2 = new Animator[2];
        animatorArr2[0] = ObjectAnimator.ofFloat(view, View.TRANSLATION_X, new float[]{f, 0.0f});
        animatorArr2[1] = ObjectAnimator.ofFloat(view, View.TRANSLATION_Y, new float[]{f2, 0.0f});
        animatorSet2.playTogether(animatorArr2);
        animatorSet.setStartDelay(aVar.getStartDelay());
        com.iqoption.core.ext.a.a((Animator) animatorSet, aVar.aFR());
        animatorSet.setInterpolator(new FastOutSlowInInterpolator());
        animatorSet.addListener(new a(aVar, animatorSet, view, animatorSet2));
        animatorSet2.setStartDelay(aVar.aFS());
        com.iqoption.core.ext.a.a((Animator) animatorSet2, aVar.aFR());
        animatorSet2.setInterpolator(new FastOutSlowInInterpolator());
        animatorSet2.addListener(new b(aVar, view, animatorSet));
        animatorSet.start();
    }
}
