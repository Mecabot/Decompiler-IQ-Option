package com.iqoption.view;

import android.view.animation.Interpolator;

/* compiled from: RangeInterpolator */
public final class j implements Interpolator {
    private float dDr;
    private float start;

    public j(float f, float f2) {
        this.start = f;
        this.dDr = f2;
    }

    public float getInterpolation(float f) {
        return this.start + ((this.dDr - this.start) * f);
    }
}
