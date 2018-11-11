package com.iqoption.dialog.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/* compiled from: QuoteValueDrawable */
public final class e extends Drawable {
    private final f chX = new f();
    private final f chY = new f();
    private float chZ;

    public int getOpacity() {
        return -3;
    }

    public e(float f, int i, int i2) {
        setGapSize(f);
        ej(i);
        ek(i2);
    }

    public void setText(String str) {
        if (str == null) {
            this.chX.setText(null);
            this.chY.setText(null);
            return;
        }
        int length = str.length() - 3;
        this.chX.setText(str.substring(0, length));
        this.chY.setText(str.substring(length));
    }

    public void ej(@ColorInt int i) {
        this.chX.setColor(i);
    }

    public void E(float f) {
        this.chX.setSize(f);
    }

    public void ek(@ColorInt int i) {
        this.chY.setColor(i);
    }

    public void F(float f) {
        this.chY.setSize(f);
    }

    public void setGapSize(float f) {
        this.chZ = f;
    }

    public void draw(@NonNull Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.translate((float) bounds.left, (float) bounds.top);
        this.chX.draw(canvas);
        canvas.translate(((float) this.chX.getIntrinsicWidth()) + this.chZ, (float) (this.chX.getIntrinsicHeight() - this.chY.getIntrinsicHeight()));
        this.chY.draw(canvas);
        canvas.restore();
    }

    public void setAlpha(@IntRange(from = 0, to = 255) int i) {
        this.chX.setAlpha(i);
        this.chY.setAlpha(i);
    }

    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.chX.setColorFilter(colorFilter);
        this.chY.setColorFilter(colorFilter);
    }

    public int getIntrinsicWidth() {
        return (int) (((float) (this.chX.getIntrinsicWidth() + this.chY.getIntrinsicWidth())) + this.chZ);
    }

    public int getIntrinsicHeight() {
        return Math.max(this.chX.getIntrinsicHeight(), this.chY.getIntrinsicHeight());
    }
}
