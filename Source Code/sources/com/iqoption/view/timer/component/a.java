package com.iqoption.view.timer.component;

import android.graphics.RectF;

/* compiled from: FlowerDataCalc */
public class a {
    private final int dJP;
    private final float[] dJQ = new float[this.dJP];
    private final float[] dJR = new float[this.dJP];
    private final RectF[] dJS;
    private final int[] dJT;

    public a(int i) {
        this.dJP = i;
        double d = 6.283185307179586d / ((double) this.dJP);
        for (i = 0; i < this.dJP; i++) {
            double d2 = (180.0d + d) - (((double) i) * d);
            this.dJQ[i] = (float) Math.cos(d2);
            this.dJR[i] = (float) Math.sin(d2);
        }
        this.dJS = new RectF[this.dJP];
        this.dJT = new int[this.dJP];
    }

    public RectF[] aJQ() {
        return this.dJS;
    }

    public void d(int i, float f) {
        float f2 = (float) i;
        float f3 = f2 / 2.0f;
        f2 = (f2 - (f / 2.0f)) / 2.0f;
        float f4 = ((f2 * 2.0f) - f) / 2.0f;
        for (int i2 = 0; i2 < this.dJP; i2++) {
            this.dJS[i2] = new RectF(f3 - (this.dJQ[i2] * f2), (this.dJR[i2] * f2) + f3, f3 - (this.dJQ[i2] * f4), (this.dJR[i2] * f4) + f3);
        }
    }

    public int[] aJR() {
        return this.dJT;
    }

    public void w(long j, long j2) {
        if (j < j2) {
            int i;
            long j3 = j2 / ((long) this.dJP);
            int i2 = (int) ((((long) this.dJP) - (j / j3)) - 1);
            for (i = 0; i < i2; i++) {
                this.dJT[i] = 25;
            }
            for (i = i2 + 1; i < this.dJP; i++) {
                this.dJT[i] = 255;
            }
            this.dJT[i2] = ((int) ((((float) (j - Math.max(0, (j2 - (((long) i2) * j3)) - j3))) / ((float) j3)) * 230.0f)) + 25;
        }
    }
}
