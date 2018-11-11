package com.iqoption.core.ui.widget.nps;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.DimenRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.StateSet;
import com.iqoption.core.ext.a;
import com.iqoption.core.graphics.animation.i;
import com.iqoption.core.j.b;

/* compiled from: NpsThumbDrawable */
final class f extends Drawable implements AnimatorUpdateListener {
    private static final int bfS = b.dp36;
    private static final int bfT = b.dp28;
    private static final int bfU = b.dp8;
    private static final int[] bfV = new int[]{16842919};
    private ValueAnimator awh;
    private float awp;
    private final int bfW;
    private final int bfX;
    private float bfY;
    private float bfZ;
    private float bga;
    private boolean bgb;
    private boolean bgc;
    private final Paint kx = new Paint(1);

    public boolean isStateful() {
        return true;
    }

    f(int i, int i2) {
        this.bfW = i;
        this.bfX = i2;
        this.bfY = dU(bfS);
        this.bfZ = dU(bfT);
        this.bga = dU(bfU);
    }

    public void draw(@NonNull Canvas canvas) {
        Rect bounds = getBounds();
        if (!bounds.isEmpty()) {
            canvas.save();
            canvas.translate((float) bounds.left, (float) bounds.top);
            float f = ((this.bfY - this.bfZ) * this.awp) + this.bfZ;
            float f2 = this.bfY / 2.0f;
            this.kx.setColor(this.bfW);
            canvas.drawCircle(f2, f2, f / 2.0f, this.kx);
            this.kx.setColor(this.bfX);
            canvas.drawCircle(f2, f2, this.bga / 2.0f, this.kx);
            canvas.restore();
        }
    }

    public void setAlpha(int i) {
        this.kx.setAlpha(i);
    }

    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.kx.setColorFilter(colorFilter);
    }

    public int getOpacity() {
        int alpha = this.kx.getAlpha();
        if (alpha != 0) {
            return alpha != 255 ? -3 : -1;
        } else {
            return -2;
        }
    }

    protected boolean onStateChange(int[] iArr) {
        boolean stateSetMatches = StateSet.stateSetMatches(bfV, iArr);
        if (this.bgb == stateSetMatches) {
            return super.onStateChange(iArr);
        }
        this.bgb = stateSetMatches;
        ZK();
        return true;
    }

    private void ZK() {
        ValueAnimator LK = LK();
        if (LK.isRunning()) {
            LK.cancel();
        }
        if (this.bgb) {
            if (this.awp != 1.0f) {
                LK.setFloatValues(new float[]{this.awp, 1.0f});
                LK.setDuration((long) ((1.0f - this.awp) * 250.0f));
            } else {
                return;
            }
        } else if (this.awp != 0.0f) {
            LK.setFloatValues(new float[]{this.awp, 0.0f});
            LK.setDuration((long) (this.awp * 250.0f));
        } else {
            return;
        }
        LK.start();
    }

    @NonNull
    private ValueAnimator LK() {
        if (this.awh == null) {
            this.awh = new ValueAnimator();
            this.awh.setInterpolator(i.TI());
            this.awh.addUpdateListener(this);
        }
        return this.awh;
    }

    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        if (this.awh != null && this.awh.isRunning()) {
            this.awh.end();
        }
    }

    public int getIntrinsicWidth() {
        return (int) this.bfY;
    }

    public int getIntrinsicHeight() {
        return (int) this.bfY;
    }

    public int getMinimumWidth() {
        return (int) this.bfZ;
    }

    public int getMinimumHeight() {
        return (int) this.bfZ;
    }

    private float dU(@DimenRes int i) {
        return a.j(com.iqoption.core.f.RR(), i);
    }

    public void bf(long j) {
        final ValueAnimator LK = LK();
        if (!LK.isRunning()) {
            LK.setFloatValues(new float[]{this.awp, 1.0f, 0.0f, 1.0f, 0.0f});
            LK.setInterpolator(i.TL());
            LK.setDuration(j);
            LK.addListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animator) {
                    f.this.bgc = true;
                }

                public void onAnimationEnd(Animator animator) {
                    LK.setInterpolator(i.TI());
                    f.this.bgc = false;
                }
            });
            LK.start();
        }
    }

    public void ZL() {
        if (this.bgc) {
            LK().cancel();
        }
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.awp = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidateSelf();
    }
}
