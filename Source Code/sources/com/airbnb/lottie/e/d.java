package com.airbnb.lottie.e;

/* compiled from: ScaleXY */
public class d {
    private final float scaleX;
    private final float scaleY;

    public d(float f, float f2) {
        this.scaleX = f;
        this.scaleY = f2;
    }

    public d() {
        this(1.0f, 1.0f);
    }

    public float getScaleX() {
        return this.scaleX;
    }

    public float getScaleY() {
        return this.scaleY;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getScaleX());
        stringBuilder.append("x");
        stringBuilder.append(getScaleY());
        return stringBuilder.toString();
    }
}
