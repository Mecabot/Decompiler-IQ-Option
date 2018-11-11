package com.iqoption.core.graphics.a.a;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0016J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H&J \u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H&R\u0018\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, aXE = {"Lcom/iqoption/core/graphics/drawable/stateanimator/AnimatorController;", "Lcom/iqoption/core/graphics/drawable/stateanimator/StateControlDrawable$Controller;", "animatorsCount", "", "(I)V", "animators", "", "Landroid/animation/ObjectAnimator;", "[Landroid/animation/ObjectAnimator;", "running", "Landroid/animation/Animator;", "animate", "", "fromSpecIndex", "toSpecIndex", "onCreate", "onPrepare", "animator", "core_release"})
/* compiled from: AnimatorController.kt */
public abstract class a implements com.iqoption.core.graphics.a.a.d.a {
    private final ObjectAnimator[] aRQ;
    private Animator aeO;

    public abstract void a(ObjectAnimator objectAnimator, int i, int i2);

    public abstract ObjectAnimator ah(int i, int i2);

    public a(int i) {
        ObjectAnimator[] objectAnimatorArr = new ObjectAnimator[i];
        int length = objectAnimatorArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            objectAnimatorArr[i2] = null;
        }
        this.aRQ = objectAnimatorArr;
    }

    public void ag(int i, int i2) {
        Animator animator = this.aeO;
        if (animator != null) {
            animator.cancel();
        }
        ObjectAnimator objectAnimator = this.aRQ[i2];
        if (objectAnimator == null) {
            objectAnimator = ah(i, i2);
        }
        a(objectAnimator, i, i2);
        objectAnimator.start();
    }
}
