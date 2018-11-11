package com.airbnb.lottie.d;

import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.airbnb.lottie.g;

/* compiled from: LottieValueAnimator */
public class c extends a implements FrameCallback {
    @Nullable
    private g ja;
    private float oF = 1.0f;
    private boolean oG = false;
    private long oH = 0;
    private float oI = 0.0f;
    private float oJ = -2.14748365E9f;
    private float oK = 2.14748365E9f;
    private int repeatCount = 0;
    @VisibleForTesting
    protected boolean running = false;

    public Object getAnimatedValue() {
        return Float.valueOf(fh());
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float fh() {
        if (this.ja == null) {
            return 0.0f;
        }
        return (this.oI - this.ja.da()) / (this.ja.db() - this.ja.da());
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getAnimatedFraction() {
        if (this.ja == null) {
            return 0.0f;
        }
        if (eh()) {
            return (getMaxFrame() - this.oI) / (getMaxFrame() - getMinFrame());
        }
        return (this.oI - getMinFrame()) / (getMaxFrame() - getMinFrame());
    }

    public long getDuration() {
        return this.ja == null ? 0 : (long) this.ja.cZ();
    }

    public float fi() {
        return this.oI;
    }

    public boolean isRunning() {
        return this.running;
    }

    public void doFrame(long j) {
        fl();
        if (this.ja != null && isRunning()) {
            j = System.nanoTime();
            float fj = ((float) (j - this.oH)) / fj();
            float f = this.oI;
            if (eh()) {
                fj = -fj;
            }
            this.oI = f + fj;
            int b = e.b(this.oI, getMinFrame(), getMaxFrame()) ^ 1;
            this.oI = e.clamp(this.oI, getMinFrame(), getMaxFrame());
            this.oH = j;
            fg();
            if (b != 0) {
                if (getRepeatCount() == -1 || this.repeatCount < getRepeatCount()) {
                    fe();
                    this.repeatCount++;
                    if (getRepeatMode() == 2) {
                        this.oG ^= 1;
                        fk();
                    } else {
                        this.oI = eh() ? getMaxFrame() : getMinFrame();
                    }
                    this.oH = j;
                } else {
                    this.oI = getMaxFrame();
                    fm();
                    y(eh());
                }
            }
            fn();
        }
    }

    private float fj() {
        if (this.ja == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / this.ja.getFrameRate()) / Math.abs(this.oF);
    }

    public void cX() {
        this.ja = null;
        this.oJ = -2.14748365E9f;
        this.oK = 2.14748365E9f;
    }

    public void setComposition(g gVar) {
        Object obj = this.ja == null ? 1 : null;
        this.ja = gVar;
        if (obj != null) {
            i((int) Math.max(this.oJ, gVar.da()), (int) Math.min(this.oK, gVar.db()));
        } else {
            i((int) gVar.da(), (int) gVar.db());
        }
        setFrame((int) this.oI);
        this.oH = System.nanoTime();
    }

    public void setFrame(int i) {
        float f = (float) i;
        if (this.oI != f) {
            this.oI = e.clamp(f, getMinFrame(), getMaxFrame());
            this.oH = System.nanoTime();
            fg();
        }
    }

    public void setMinFrame(int i) {
        i(i, (int) this.oK);
    }

    public void setMaxFrame(int i) {
        i((int) this.oJ, i);
    }

    public void i(int i, int i2) {
        float da = this.ja == null ? Float.MIN_VALUE : this.ja.da();
        float db = this.ja == null ? Float.MAX_VALUE : this.ja.db();
        float f = (float) i;
        this.oJ = e.clamp(f, da, db);
        float f2 = (float) i2;
        this.oK = e.clamp(f2, da, db);
        setFrame((int) e.clamp(this.oI, f, f2));
    }

    public void fk() {
        setSpeed(-getSpeed());
    }

    public void setSpeed(float f) {
        this.oF = f;
    }

    public float getSpeed() {
        return this.oF;
    }

    public void setRepeatMode(int i) {
        super.setRepeatMode(i);
        if (i != 2 && this.oG) {
            this.oG = false;
            fk();
        }
    }

    public void cT() {
        this.running = true;
        x(eh());
        setFrame((int) (eh() ? getMaxFrame() : getMinFrame()));
        this.oH = System.nanoTime();
        this.repeatCount = 0;
        fl();
    }

    public void dj() {
        fm();
        y(eh());
    }

    public void cW() {
        fm();
    }

    public void cU() {
        this.running = true;
        fl();
        this.oH = System.nanoTime();
        if (eh() && fi() == getMinFrame()) {
            this.oI = getMaxFrame();
        } else if (!eh() && fi() == getMaxFrame()) {
            this.oI = getMinFrame();
        }
    }

    public void cancel() {
        ff();
        fm();
    }

    private boolean eh() {
        return getSpeed() < 0.0f;
    }

    public float getMinFrame() {
        if (this.ja == null) {
            return 0.0f;
        }
        return this.oJ == -2.14748365E9f ? this.ja.da() : this.oJ;
    }

    public float getMaxFrame() {
        if (this.ja == null) {
            return 0.0f;
        }
        return this.oK == 2.14748365E9f ? this.ja.db() : this.oK;
    }

    protected void fl() {
        if (isRunning()) {
            z(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    protected void fm() {
        z(true);
    }

    protected void z(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.running = false;
        }
    }

    private void fn() {
        if (this.ja != null) {
            if (this.oI < this.oJ || this.oI > this.oK) {
                throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", new Object[]{Float.valueOf(this.oJ), Float.valueOf(this.oK), Float.valueOf(this.oI)}));
            }
        }
    }
}
