package com.iqoption.core.graphics.animation;

import android.view.animation.AlphaAnimation;
import android.view.animation.Transformation;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0014¨\u0006\t"}, aXE = {"Lcom/iqoption/core/graphics/animation/EmptyAnimation;", "Landroid/view/animation/AlphaAnimation;", "()V", "applyTransformation", "", "interpolatedTime", "", "t", "Landroid/view/animation/Transformation;", "core_release"})
/* compiled from: EmptyAnimation.kt */
public final class c extends AlphaAnimation {
    protected void applyTransformation(float f, Transformation transformation) {
        h.e(transformation, "t");
    }

    public c() {
        super(1.0f, 1.0f);
    }
}
