package com.iqoption.dialog.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextPaint;

/* compiled from: TextDrawable */
public final class f extends Drawable {
    private final TextPaint aHo = new TextPaint(1);
    private boolean cia;
    private float cib;
    private float height;
    private String text;
    private float width;

    public int getOpacity() {
        return -3;
    }

    public f(String str) {
        setText(str);
    }

    private void aeM() {
        this.cia = true;
    }

    private void resize() {
        float descent = this.aHo.descent();
        float ascent = this.aHo.ascent();
        float f = descent / 3.0f;
        if (this.text != null) {
            this.width = this.aHo.measureText(this.text);
        } else {
            this.width = 0.0f;
        }
        this.height = (descent - ascent) - f;
        this.cib = (-ascent) + f;
        this.cia = false;
    }

    public void setText(String str) {
        if (str == null ? this.text == null : !str.equals(this.text)) {
            aeM();
        }
        this.text = str;
    }

    public void setSize(float f) {
        if (f != this.aHo.getTextSize()) {
            aeM();
        }
        this.aHo.setTextSize(f);
    }

    public void setColor(@ColorInt int i) {
        this.aHo.setColor(i);
    }

    public void draw(@NonNull Canvas canvas) {
        if (this.cia) {
            resize();
        }
        Rect bounds = getBounds();
        canvas.save();
        canvas.translate((float) bounds.left, (float) bounds.top);
        canvas.drawText(this.text, 0.0f, this.cib, this.aHo);
        canvas.restore();
    }

    public void setAlpha(@IntRange(from = 0, to = 255) int i) {
        this.aHo.setAlpha(i);
    }

    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.aHo.setColorFilter(colorFilter);
    }

    public int getIntrinsicWidth() {
        if (this.cia) {
            resize();
        }
        return (int) this.width;
    }

    public int getIntrinsicHeight() {
        if (this.cia) {
            resize();
        }
        return (int) this.height;
    }
}
