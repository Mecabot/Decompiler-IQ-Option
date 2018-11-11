package com.iqoption.charttools.constructor.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/* compiled from: ThumbDrawable */
final class i extends Drawable {
    private final Paint kx = new Paint(1);
    private final int size;

    public void setColorFilter(@Nullable ColorFilter colorFilter) {
    }

    i(int i, float f, int i2) {
        this.size = i;
        this.kx.setStyle(Style.STROKE);
        this.kx.setStrokeWidth(f);
        this.kx.setColor(i2);
    }

    public void draw(@NonNull Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.translate((float) bounds.left, (float) bounds.top);
        canvas.drawCircle((float) bounds.centerX(), (float) bounds.centerY(), (((float) this.size) - this.kx.getStrokeWidth()) / 2.0f, this.kx);
        canvas.restore();
    }

    public void setAlpha(int i) {
        this.kx.setAlpha(i);
        invalidateSelf();
    }

    public int getOpacity() {
        int alpha = this.kx.getAlpha();
        if (alpha != 0) {
            return alpha != 255 ? -3 : -1;
        } else {
            return -2;
        }
    }

    public int getIntrinsicWidth() {
        return this.size;
    }

    public int getIntrinsicHeight() {
        return this.size;
    }
}
