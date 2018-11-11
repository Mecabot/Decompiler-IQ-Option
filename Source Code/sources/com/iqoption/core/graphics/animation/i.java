package com.iqoption.core.graphics.animation;

import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;

@kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003\"\u0011\u0010\u0006\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0003\"\u0011\u0010\b\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0003\"\u0011\u0010\n\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0003\"\u0011\u0010\f\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0003\"\u0011\u0010\u000e\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0003\"\u0011\u0010\u0010\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0003\"\u0011\u0010\u0012\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0003\"\u0011\u0010\u0014\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0003¨\u0006\u0016"}, aXE = {"accelerate", "Landroid/view/animation/Interpolator;", "getAccelerate", "()Landroid/view/animation/Interpolator;", "accelerationCurve", "getAccelerationCurve", "bounceInterpolator", "getBounceInterpolator", "decelerate", "getDecelerate", "decelerationCurve", "getDecelerationCurve", "fastOutLinearInInterpolator", "getFastOutLinearInInterpolator", "linearInterpolator", "getLinearInterpolator", "linearOutSlowInInterpolator", "getLinearOutSlowInInterpolator", "overshootInterpolator", "getOvershootInterpolator", "standardCurve", "getStandardCurve", "core_release"})
/* compiled from: Interpolators.kt */
public final class i {
    private static final Interpolator aQU = new FastOutSlowInInterpolator();
    private static final Interpolator aQV = new LinearOutSlowInInterpolator();
    private static final Interpolator aQW = new FastOutLinearInInterpolator();
    private static final Interpolator aQX = new LinearOutSlowInInterpolator();
    private static final Interpolator aQY = new FastOutLinearInInterpolator();
    private static final Interpolator aQZ = new LinearInterpolator();
    private static final Interpolator aRa = new BounceInterpolator();
    private static final Interpolator aRb = new AccelerateInterpolator();
    private static final Interpolator aRc = new DecelerateInterpolator();
    private static final Interpolator aRd = new OvershootInterpolator();

    public static final Interpolator TI() {
        return aQU;
    }

    public static final Interpolator TJ() {
        return aQV;
    }

    public static final Interpolator TK() {
        return aQW;
    }

    public static final Interpolator TL() {
        return aQZ;
    }
}
