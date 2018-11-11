package com.iqoption.core.graphics.a.a;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.drawable.GradientDrawable;
import com.iqoption.core.graphics.a.a.d.a;
import com.iqoption.core.graphics.animation.b;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0015H\u0016R\u0018\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\tX\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, aXE = {"Lcom/iqoption/core/graphics/drawable/stateanimator/DrawableColorController;", "Lcom/iqoption/core/graphics/drawable/stateanimator/StateControlDrawable$Controller;", "drawable", "Landroid/graphics/drawable/GradientDrawable;", "colors", "", "durations", "", "interpolators", "", "Landroid/animation/TimeInterpolator;", "(Landroid/graphics/drawable/GradientDrawable;[I[J[Landroid/animation/TimeInterpolator;)V", "animators", "Landroid/animation/ValueAnimator;", "[Landroid/animation/ValueAnimator;", "[Landroid/animation/TimeInterpolator;", "running", "Landroid/animation/Animator;", "animate", "", "fromSpecIndex", "", "toSpecIndex", "init", "specIndex", "core_release"})
/* compiled from: DrawableColorController.kt */
public final class c implements a {
    private final ValueAnimator[] aRR;
    private final long[] aRU;
    private final TimeInterpolator[] aRV;
    private final GradientDrawable aRW;
    private Animator aeO;
    private final int[] mF;

    public c(GradientDrawable gradientDrawable, int[] iArr, long[] jArr, TimeInterpolator[] timeInterpolatorArr) {
        h.e(gradientDrawable, "drawable");
        h.e(iArr, "colors");
        h.e(jArr, "durations");
        h.e(timeInterpolatorArr, "interpolators");
        this.aRW = gradientDrawable;
        this.mF = iArr;
        this.aRU = jArr;
        this.aRV = timeInterpolatorArr;
        ValueAnimator[] valueAnimatorArr = new ValueAnimator[this.mF.length];
        int length = valueAnimatorArr.length;
        for (int i = 0; i < length; i++) {
            valueAnimatorArr[i] = null;
        }
        this.aRR = valueAnimatorArr;
    }

    public void init(int i) {
        b.aQM.TC().set(this.aRW, Integer.valueOf(this.mF[i]));
    }

    public void ag(int i, int i2) {
        Animator animator = this.aeO;
        if (animator != null) {
            animator.cancel();
        }
        ValueAnimator valueAnimator = this.aRR[i2];
        if (valueAnimator == null) {
            ObjectAnimator objectAnimator = new ObjectAnimator();
            objectAnimator.setTarget(this.aRW);
            objectAnimator.setProperty(b.aQM.TC());
            objectAnimator.setInterpolator(this.aRV[i2]);
            objectAnimator.setDuration(this.aRU[i2]);
            valueAnimator = objectAnimator;
            this.aRR[i2] = valueAnimator;
        }
        this.aeO = valueAnimator;
        valueAnimator.setIntValues(new int[]{this.mF[i], this.mF[i2]});
        valueAnimator.setEvaluator(com.iqoption.core.graphics.animation.a.aQH.TB());
        valueAnimator.start();
    }
}
