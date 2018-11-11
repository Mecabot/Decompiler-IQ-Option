package com.airbnb.lottie.model;

import android.graphics.PointF;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;

@RestrictTo({Scope.LIBRARY})
/* compiled from: CubicCurveData */
public class a {
    private final PointF ma;
    private final PointF mb;
    private final PointF mc;

    public a() {
        this.ma = new PointF();
        this.mb = new PointF();
        this.mc = new PointF();
    }

    public a(PointF pointF, PointF pointF2, PointF pointF3) {
        this.ma = pointF;
        this.mb = pointF2;
        this.mc = pointF3;
    }

    public void b(float f, float f2) {
        this.ma.set(f, f2);
    }

    public PointF dP() {
        return this.ma;
    }

    public void c(float f, float f2) {
        this.mb.set(f, f2);
    }

    public PointF dQ() {
        return this.mb;
    }

    public void d(float f, float f2) {
        this.mc.set(f, f2);
    }

    public PointF dR() {
        return this.mc;
    }
}
