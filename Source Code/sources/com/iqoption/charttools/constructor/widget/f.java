package com.iqoption.charttools.constructor.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.StateSet;
import com.iqoption.core.graphics.animation.i;

/* compiled from: ColorPresetDrawable */
final class f extends Drawable implements AnimatorUpdateListener {
    private static final int[] awm = new int[]{16842913};
    private ValueAnimator awh;
    private final float awn;
    private final float awo;
    private float awp;
    private int color;
    private boolean isSelected;
    private final Paint kx = new Paint(1);

    public int getOpacity() {
        return -1;
    }

    public boolean isStateful() {
        return true;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(@Nullable ColorFilter colorFilter) {
    }

    f(float f, float f2, float f3) {
        this.awn = f;
        this.awo = f2;
        this.kx.setStrokeWidth(f3);
    }

    public void draw(@NonNull Canvas canvas) {
        Rect bounds = getBounds();
        float centerX = (float) bounds.centerX();
        float centerY = (float) bounds.centerY();
        canvas.save();
        canvas.translate((float) bounds.left, (float) bounds.top);
        if (this.awp != 0.0f) {
            float strokeWidth = ((((this.awn - this.awo) * this.awp) + this.awo) - this.kx.getStrokeWidth()) / 2.0f;
            this.kx.setStyle(Style.STROKE);
            this.kx.setColor(-1);
            canvas.drawCircle(centerX, centerY, strokeWidth, this.kx);
        }
        this.kx.setStyle(Style.FILL);
        this.kx.setColor(this.color);
        canvas.drawCircle(centerX, centerY, (((this.awn - this.awo) * (1.0f - this.awp)) + this.awo) / 2.0f, this.kx);
        canvas.restore();
    }

    protected boolean onStateChange(int[] iArr) {
        boolean stateSetMatches = StateSet.stateSetMatches(awm, iArr);
        if (this.isSelected == stateSetMatches) {
            return super.onStateChange(iArr);
        }
        this.isSelected = stateSetMatches;
        ValueAnimator LK = LK();
        LK.cancel();
        if (this.isSelected) {
            LK.setFloatValues(new float[]{this.awp, 1.0f});
            LK.setDuration((long) ((1.0f - this.awp) * 250.0f));
        } else {
            LK.setFloatValues(new float[]{this.awp, 0.0f});
            LK.setDuration((long) (this.awp * 250.0f));
        }
        LK.start();
        return true;
    }

    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        LK().end();
    }

    private ValueAnimator LK() {
        if (this.awh == null) {
            this.awh = new ValueAnimator();
            this.awh.addUpdateListener(this);
            this.awh.setInterpolator(i.TI());
            this.awh.setFloatValues(new float[]{this.awp, this.awp});
            this.awh.setDuration(0);
        }
        return this.awh;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.awp = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidateSelf();
    }

    public void setColor(int i) {
        if (this.color != i) {
            this.color = i;
            invalidateSelf();
        }
    }
}
