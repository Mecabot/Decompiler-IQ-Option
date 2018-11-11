package com.iqoption.portfolio.component;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/* compiled from: PageDotsDrawable */
public class h extends Drawable {
    private final int cZa;
    private float cZb = 0.0f;
    private float cZc = 0.0f;
    private final int count;
    private final Paint kx = new Paint(1);
    private final int offset;
    private final float radius;
    private final int size;

    protected void b(float f, int i) {
    }

    public int getOpacity() {
        return -3;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(@Nullable ColorFilter colorFilter) {
    }

    public h(int i, int i2, int i3, float f) {
        this.count = i;
        this.size = i2;
        this.radius = ((float) i2) / 2.0f;
        this.offset = i3;
        this.cZa = Math.round(f * 255.0f);
        this.kx.setColor(-1);
    }

    public void i(float f, float f2) {
        if (this.cZc != f || this.cZb != f2) {
            this.cZc = f;
            this.cZb = f2;
            invalidateSelf();
        }
    }

    public void draw(@NonNull Canvas canvas) {
        canvas.save();
        canvas.translate(this.radius, this.radius);
        float f = this.cZb > 0.0f ? this.cZc + 1.0f : this.cZb < 0.0f ? this.cZc - 1.0f : this.cZc;
        int i = (int) f;
        int i2 = (int) this.cZc;
        float abs = Math.abs(this.cZb);
        for (int i3 = 0; i3 < this.count; i3++) {
            if (i3 > 0) {
                canvas.translate((float) (this.offset + this.size), 0.0f);
            }
            if (i3 == i2) {
                ay(Math.round((((float) (255 - this.cZa)) * (1.0f - abs)) + ((float) this.cZa)), i3);
            } else if (i3 == i) {
                ay(Math.round((((float) (255 - this.cZa)) * abs) + ((float) this.cZa)), i3);
            } else {
                ay(this.cZa, i3);
            }
            canvas.drawCircle(0.0f, 0.0f, this.radius, this.kx);
        }
        canvas.restore();
    }

    private void ay(int i, int i2) {
        this.kx.setAlpha(i);
        b(((float) i) / 255.0f, i2);
    }

    public int getIntrinsicWidth() {
        return (this.count * this.size) + ((this.count - 1) * this.offset);
    }

    public int getIntrinsicHeight() {
        return this.size;
    }
}
