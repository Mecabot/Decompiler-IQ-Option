package com.iqoption.core.ui.d;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.iqoption.core.j;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, aXE = {"Lcom/iqoption/core/ui/dialog/DialogAnimatorFactory;", "", "content", "Landroid/view/View;", "frame", "(Landroid/view/View;Landroid/view/View;)V", "makeEnterAnimator", "Landroid/animation/Animator;", "duration", "", "makeExitAnimator", "core_release"})
/* compiled from: DialogAnimatorFactory.kt */
public final class a {
    private final View awQ;
    private final View bbs;

    public a(View view, View view2) {
        h.e(view, b.CONTENT);
        h.e(view2, "frame");
        this.awQ = view;
        this.bbs = view2;
    }

    public static /* synthetic */ Animator a(a aVar, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 250;
        }
        return aVar.bd(j);
    }

    public final Animator bd(long j) {
        AnimatorSet animatorSet = new AnimatorSet();
        Animator[] animatorArr = new Animator[2];
        animatorArr[0] = ObjectAnimator.ofFloat(this.awQ, View.ALPHA, new float[]{0.0f, 1.0f});
        animatorArr[1] = ObjectAnimator.ofFloat(this.bbs, View.TRANSLATION_Y, new float[]{com.iqoption.core.ext.a.e(this.bbs, j.b.dp24), 0.0f});
        animatorSet.playTogether(animatorArr);
        Animator animator = animatorSet;
        com.iqoption.core.ext.a.a(animator, j);
        animatorSet.setInterpolator(com.iqoption.core.graphics.animation.i.TI());
        return animator;
    }

    public static /* synthetic */ Animator b(a aVar, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 250;
        }
        return aVar.be(j);
    }

    public final Animator be(long j) {
        AnimatorSet animatorSet = new AnimatorSet();
        Animator[] animatorArr = new Animator[2];
        animatorArr[0] = ObjectAnimator.ofFloat(this.awQ, View.ALPHA, new float[]{1.0f, 0.0f});
        animatorArr[1] = ObjectAnimator.ofFloat(this.bbs, View.TRANSLATION_Y, new float[]{0.0f, com.iqoption.core.ext.a.e(this.bbs, j.b.dp24)});
        animatorSet.playTogether(animatorArr);
        Animator animator = animatorSet;
        com.iqoption.core.ext.a.a(animator, j);
        animatorSet.setInterpolator(com.iqoption.core.graphics.animation.i.TI());
        return animator;
    }
}
