package com.jumio.nv.gui;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Typeface;

public class TextOverlayView {
    private Paint a;
    private String[] b;
    private float c;
    private float d;

    public TextOverlayView() {
        this.a = null;
        this.b = null;
        this.c = 0.0f;
        this.d = 0.0f;
        this.a = new Paint();
        this.a.setAntiAlias(true);
    }

    public void setColor(int i) {
        this.a.setColor(i);
    }

    public void setAlpha(int i) {
        this.a.setAlpha(i);
    }

    public void setDropShadow(int i) {
        this.a.setShadowLayer(1.0f, 1.0f, 1.0f, i);
    }

    public void setStyle(Style style) {
        this.a.setStyle(style);
    }

    public void setTextSize(float f) {
        this.a.setTextSize(f);
    }

    public float getTextSize() {
        return this.a.getTextSize();
    }

    public void setTypeface(Typeface typeface) {
        this.a.setTypeface(typeface);
    }

    public void setText(String str) {
        this.b = str.split("\n");
    }

    public float measureText() {
        float f = 0.0f;
        if (!(this.b == null || this.b.length == 0)) {
            for (String measureText : this.b) {
                float measureText2 = this.a.measureText(measureText);
                if (measureText2 > f) {
                    f = measureText2;
                }
            }
        }
        return f;
    }

    public float measureTextHeight() {
        return this.a.descent() - this.a.ascent();
    }

    public void setPosition(float f, float f2) {
        this.c = f;
        this.d = f2;
    }

    public void draw(Canvas canvas) {
        if (this.b != null) {
            int textSize = (int) getTextSize();
            int length = ((this.b.length - 1) * textSize) / 2;
            for (int i = 0; i < this.b.length; i++) {
                canvas.drawText(this.b[i], this.c, (this.d - ((float) length)) + ((float) (i * textSize)), this.a);
            }
        }
    }
}
