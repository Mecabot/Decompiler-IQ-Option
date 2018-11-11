package com.iqoption.view.c;

import android.graphics.Canvas;
import android.graphics.Rect;
import com.iqoption.util.aa;

/* compiled from: ViewFrameHelper */
public class a {
    private float dGq;
    private float dGr;
    private int dGs;
    private float dGt;
    private Rect dGu = new Rect();

    public a(float f, int i, float f2, float f3) {
        this.dGq = f;
        this.dGs = i;
        this.dGt = f2;
        this.dGr = f3;
    }

    public void setFrameTopGapSize(float f) {
        this.dGr = f;
    }

    public void onDraw(Canvas canvas) {
        canvas.getClipBounds(this.dGu);
        aa.a(canvas, 0.0f, 0.0f, (float) (this.dGu.width() - 1), (float) (this.dGu.height() - 1), this.dGq, this.dGr, this.dGs, this.dGt);
    }
}
