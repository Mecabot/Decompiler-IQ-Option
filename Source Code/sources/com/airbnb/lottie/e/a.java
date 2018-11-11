package com.airbnb.lottie.e;

import android.graphics.PointF;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.view.animation.Interpolator;
import com.airbnb.lottie.g;

/* compiled from: Keyframe */
public class a<T> {
    @Nullable
    private final g ja;
    public final float jr;
    @Nullable
    public final T oP;
    @Nullable
    public final T oQ;
    @Nullable
    public final Interpolator oR;
    @Nullable
    public Float oS;
    private float oT;
    private float oU;
    public PointF oV;
    public PointF oW;

    public a(g gVar, @Nullable T t, @Nullable T t2, @Nullable Interpolator interpolator, float f, @Nullable Float f2) {
        this.oT = Float.MIN_VALUE;
        this.oU = Float.MIN_VALUE;
        this.oV = null;
        this.oW = null;
        this.ja = gVar;
        this.oP = t;
        this.oQ = t2;
        this.oR = interpolator;
        this.jr = f;
        this.oS = f2;
    }

    public a(T t) {
        this.oT = Float.MIN_VALUE;
        this.oU = Float.MIN_VALUE;
        this.oV = null;
        this.oW = null;
        this.ja = null;
        this.oP = t;
        this.oQ = t;
        this.oR = null;
        this.jr = Float.MIN_VALUE;
        this.oS = Float.valueOf(Float.MAX_VALUE);
    }

    public float eQ() {
        if (this.ja == null) {
            return 0.0f;
        }
        if (this.oT == Float.MIN_VALUE) {
            this.oT = (this.jr - this.ja.da()) / this.ja.dg();
        }
        return this.oT;
    }

    public float dH() {
        if (this.ja == null) {
            return 1.0f;
        }
        if (this.oU == Float.MIN_VALUE) {
            if (this.oS == null) {
                this.oU = 1.0f;
            } else {
                this.oU = eQ() + ((this.oS.floatValue() - this.jr) / this.ja.dg());
            }
        }
        return this.oU;
    }

    public boolean isStatic() {
        return this.oR == null;
    }

    public boolean j(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        return f >= eQ() && f < dH();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Keyframe{startValue=");
        stringBuilder.append(this.oP);
        stringBuilder.append(", endValue=");
        stringBuilder.append(this.oQ);
        stringBuilder.append(", startFrame=");
        stringBuilder.append(this.jr);
        stringBuilder.append(", endFrame=");
        stringBuilder.append(this.oS);
        stringBuilder.append(", interpolator=");
        stringBuilder.append(this.oR);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
