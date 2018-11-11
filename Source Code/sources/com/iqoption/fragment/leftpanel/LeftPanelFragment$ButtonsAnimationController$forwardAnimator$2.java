package com.iqoption.fragment.leftpanel;

import android.animation.ObjectAnimator;
import android.view.View;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, aXE = {"<anonymous>", "Landroid/animation/ObjectAnimator;", "kotlin.jvm.PlatformType", "invoke"})
/* compiled from: LeftPanelFragment.kt */
final class LeftPanelFragment$ButtonsAnimationController$forwardAnimator$2 extends Lambda implements a<ObjectAnimator> {
    final /* synthetic */ f this$0;

    LeftPanelFragment$ButtonsAnimationController$forwardAnimator$2(f fVar) {
        this.this$0 = fVar;
        super(0);
    }

    /* renamed from: ami */
    public final ObjectAnimator invoke() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.this$0.cDC, View.TRANSLATION_X, new float[]{0.0f});
        ofFloat.setInterpolator(com.iqoption.core.graphics.animation.i.TI());
        return ofFloat;
    }
}
