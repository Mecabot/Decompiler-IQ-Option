package com.iqoption.view.a.a;

import android.animation.TimeInterpolator;
import android.view.animation.Interpolator;

/* compiled from: ReverseInterpolator */
public class e implements Interpolator {
    private final TimeInterpolator dEN;

    public e(TimeInterpolator timeInterpolator) {
        this.dEN = timeInterpolator;
    }

    public e() {
        this(d.dEM);
    }

    public float getInterpolation(float f) {
        return 1.0f - this.dEN.getInterpolation(f);
    }
}
