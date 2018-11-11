package com.iqoption.withdrawal.crypto.barcode.camera;

import android.graphics.Canvas;
import android.view.View;
import java.util.List;
import java.util.Set;
import java.util.Vector;

/* compiled from: GraphicOverlay */
public class b<T extends a> extends View {
    private int dSH;
    private float dSI;
    private int dSJ;
    private float dSK;
    private Set<T> dSL;
    private int dSj;
    private final Object mLock;

    /* compiled from: GraphicOverlay */
    public static abstract class a {
        public abstract void draw(Canvas canvas);
    }

    public void clear() {
        synchronized (this.mLock) {
            this.dSL.clear();
        }
        postInvalidate();
    }

    public List<T> getGraphics() {
        List vector;
        synchronized (this.mLock) {
            vector = new Vector(this.dSL);
        }
        return vector;
    }

    public float getWidthScaleFactor() {
        return this.dSI;
    }

    public float getHeightScaleFactor() {
        return this.dSK;
    }

    public void u(int i, int i2, int i3) {
        synchronized (this.mLock) {
            this.dSH = i;
            this.dSJ = i2;
            this.dSj = i3;
        }
        postInvalidate();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        synchronized (this.mLock) {
            if (!(this.dSH == 0 || this.dSJ == 0)) {
                this.dSI = ((float) canvas.getWidth()) / ((float) this.dSH);
                this.dSK = ((float) canvas.getHeight()) / ((float) this.dSJ);
            }
            for (a draw : this.dSL) {
                draw.draw(canvas);
            }
        }
    }
}
