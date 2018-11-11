package com.iqoption.charttools.constructor.widget;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;

/* compiled from: ThumbPathDrawable */
final class j extends Drawable {
    private final Canvas awF;
    private final Paint awG;
    private final Paint awH;
    private float awp = 0.0f;
    private final RectF kt = new RectF();
    private final Paint kx;
    private final int maxHeight;
    private final int minHeight;
    private float offset = 0.0f;
    private final float radius;
    private final int width;

    public int getOpacity() {
        return -3;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(@Nullable ColorFilter colorFilter) {
    }

    j(int i, int i2, int i3, float f) {
        this.width = i;
        this.minHeight = i2;
        this.maxHeight = i3;
        this.radius = f;
        Bitmap createBitmap = Bitmap.createBitmap(i, i3, Config.ARGB_8888);
        this.awF = new Canvas(createBitmap);
        this.kx = new Paint(3);
        this.kx.setShader(new BitmapShader(createBitmap, TileMode.CLAMP, TileMode.CLAMP));
        this.awG = new Paint();
        this.awH = new Paint();
        this.awH.setXfermode(new PorterDuffXfermode(Mode.MULTIPLY));
        this.awH.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, (float) i3, -1, ViewCompat.MEASURED_SIZE_MASK, TileMode.CLAMP));
    }

    private void LM() {
        this.awF.drawColor(0, Mode.CLEAR);
        this.awF.save();
        this.awF.translate(0.0f, this.offset * (this.awp - 1.0f));
        this.kt.set(0.0f, 0.0f, (float) this.width, (float) this.maxHeight);
        this.awF.drawRect(this.kt, this.awG);
        this.awF.drawRect(this.kt, this.awH);
        this.awF.restore();
    }

    public void draw(@NonNull Canvas canvas) {
        this.kt.set(0.0f, 0.0f, (float) this.width, (float) LN());
        canvas.drawRoundRect(this.kt, this.radius, this.radius, this.kx);
    }

    public void setColor(int i) {
        if (this.awG.getColor() != i) {
            this.awG.setColor(i | ViewCompat.MEASURED_STATE_MASK);
            LM();
            invalidateSelf();
        }
    }

    public void setFraction(float f) {
        if (this.awp != f) {
            this.awp = f;
            LM();
            invalidateSelf();
        }
    }

    public void setOffset(float f) {
        if (this.offset != f) {
            this.offset = f;
            if (this.awp != 1.0f) {
                LM();
                invalidateSelf();
            }
        }
    }

    private int LN() {
        return this.minHeight + Math.round(((float) (this.maxHeight - this.minHeight)) * this.awp);
    }

    public int getIntrinsicWidth() {
        return this.width;
    }

    public int getIntrinsicHeight() {
        return this.maxHeight;
    }
}
