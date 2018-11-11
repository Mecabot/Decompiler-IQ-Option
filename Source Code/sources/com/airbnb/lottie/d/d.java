package com.airbnb.lottie.d;

/* compiled from: MeanCalculator */
public class d {
    private int n;
    private float oL;

    public void i(float f) {
        this.oL += f;
        this.n++;
        if (this.n == ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) {
            this.oL /= 2.0f;
            this.n /= 2;
        }
    }
}
