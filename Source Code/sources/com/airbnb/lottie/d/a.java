package com.airbnb.lottie.d;

import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Build.VERSION;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: BaseLottieAnimator */
public abstract class a extends ValueAnimator {
    private final Set<AnimatorUpdateListener> oD = new CopyOnWriteArraySet();
    private final Set<AnimatorListener> oE = new CopyOnWriteArraySet();

    public long getStartDelay() {
        throw new UnsupportedOperationException("LottieAnimator does not support getStartDelay.");
    }

    public void setStartDelay(long j) {
        throw new UnsupportedOperationException("LottieAnimator does not support setStartDelay.");
    }

    public ValueAnimator setDuration(long j) {
        throw new UnsupportedOperationException("LottieAnimator does not support setDuration.");
    }

    public void setInterpolator(TimeInterpolator timeInterpolator) {
        throw new UnsupportedOperationException("LottieAnimator does not support setInterpolator.");
    }

    public void addUpdateListener(AnimatorUpdateListener animatorUpdateListener) {
        this.oD.add(animatorUpdateListener);
    }

    public void removeUpdateListener(AnimatorUpdateListener animatorUpdateListener) {
        this.oD.remove(animatorUpdateListener);
    }

    public void removeAllUpdateListeners() {
        this.oD.clear();
    }

    public void addListener(AnimatorListener animatorListener) {
        this.oE.add(animatorListener);
    }

    public void removeListener(AnimatorListener animatorListener) {
        this.oE.remove(animatorListener);
    }

    public void removeAllListeners() {
        this.oE.clear();
    }

    void x(boolean z) {
        for (AnimatorListener animatorListener : this.oE) {
            if (VERSION.SDK_INT >= 26) {
                animatorListener.onAnimationStart(this, z);
            } else {
                animatorListener.onAnimationStart(this);
            }
        }
    }

    void fe() {
        for (AnimatorListener onAnimationRepeat : this.oE) {
            onAnimationRepeat.onAnimationRepeat(this);
        }
    }

    void y(boolean z) {
        for (AnimatorListener animatorListener : this.oE) {
            if (VERSION.SDK_INT >= 26) {
                animatorListener.onAnimationEnd(this, z);
            } else {
                animatorListener.onAnimationEnd(this);
            }
        }
    }

    void ff() {
        for (AnimatorListener onAnimationCancel : this.oE) {
            onAnimationCancel.onAnimationCancel(this);
        }
    }

    void fg() {
        for (AnimatorUpdateListener onAnimationUpdate : this.oD) {
            onAnimationUpdate.onAnimationUpdate(this);
        }
    }
}
