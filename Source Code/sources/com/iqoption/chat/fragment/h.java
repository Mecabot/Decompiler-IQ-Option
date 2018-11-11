package com.iqoption.chat.fragment;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import com.iqoption.core.ext.a;
import com.iqoption.fragment.base.b;
import com.iqoption.view.a.a.d;
import com.iqoption.x.R;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, aXE = {"Lcom/iqoption/chat/fragment/DialogAnimationController;", "", "fragment", "Lcom/iqoption/fragment/base/IQAnimationFragment;", "contentView", "Landroid/view/View;", "frameView", "(Lcom/iqoption/fragment/base/IQAnimationFragment;Landroid/view/View;Landroid/view/View;)V", "playEnterAnimation", "", "playExitAnimation", "IqOption-5.5.1_optionXRelease"})
/* compiled from: DialogAnimationController.kt */
public final class h {
    private final b aFZ;
    private final View aGa;
    private final View aGb;

    public h(b bVar, View view, View view2) {
        kotlin.jvm.internal.h.e(bVar, "fragment");
        kotlin.jvm.internal.h.e(view, "contentView");
        kotlin.jvm.internal.h.e(view2, "frameView");
        this.aFZ = bVar;
        this.aGa = view;
        this.aGb = view2;
    }

    public final void PF() {
        AnimatorSet animatorSet = new AnimatorSet();
        a.a((Animator) animatorSet, this.aFZ.getAnimationDuration());
        Animator[] animatorArr = new Animator[2];
        animatorArr[0] = ObjectAnimator.ofFloat(this.aGa, View.ALPHA, new float[]{0.0f, 1.0f});
        animatorArr[1] = ObjectAnimator.ofFloat(this.aGb, View.TRANSLATION_Y, new float[]{this.aFZ.eN(R.dimen.dp24), 0.0f});
        animatorSet.playTogether(animatorArr);
        animatorSet.setInterpolator(d.dEM);
        animatorSet.start();
    }

    public final void PG() {
        AnimatorSet animatorSet = new AnimatorSet();
        a.a((Animator) animatorSet, this.aFZ.getAnimationDuration());
        Animator[] animatorArr = new Animator[2];
        animatorArr[0] = ObjectAnimator.ofFloat(this.aGa, View.ALPHA, new float[]{1.0f, 0.0f});
        animatorArr[1] = ObjectAnimator.ofFloat(this.aGb, View.TRANSLATION_Y, new float[]{0.0f, this.aFZ.eN(R.dimen.dp24)});
        animatorSet.playTogether(animatorArr);
        animatorSet.setInterpolator(d.dEM);
        animatorSet.start();
    }
}
