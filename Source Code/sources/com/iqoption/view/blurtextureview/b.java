package com.iqoption.view.blurtextureview;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.view.View;
import com.iqoption.util.z;

/* compiled from: BlurRenderImpl */
abstract class b {
    protected Rect dEV;
    protected Rect dEW;
    protected float dEX;
    protected int dEY;
    protected volatile Bitmap dEZ = null;
    protected z dFa;
    protected int mHeight;
    protected Paint mPaint = null;
    protected View mView;
    protected int mWidth;

    public void destroy() {
    }

    public b(View view) {
        this.dFa = new z(view.getContext());
        this.mView = view;
        this.dEX = (float) this.dFa.L(6.0f);
        this.dEY = this.dFa.L(3.0f);
        this.dEV = new Rect();
        this.dEW = new Rect();
    }

    public void draw(Canvas canvas) {
        canvas.drawColor(0, Mode.CLEAR);
        if (this.dEZ != null) {
            synchronized (this.dEZ) {
                a(canvas, this.dEZ, this.dEW, this.dEV, this.mPaint);
            }
        }
    }

    public void ak(int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
    }

    private void a(Canvas canvas, Bitmap bitmap, Rect rect, Rect rect2, Paint paint) {
        int i;
        rect2.set(0, 0, this.mWidth, this.mHeight);
        rect.set(0, 0, bitmap.getWidth() * this.dEY, bitmap.getHeight() * this.dEY);
        if (rect2.right < rect.right) {
            i = ((rect.right - rect2.right) / this.dEY) / 2;
            rect.left = i;
            rect.right = bitmap.getWidth() - i;
        }
        if (rect2.bottom < rect.bottom) {
            i = ((rect.bottom - rect2.bottom) / this.dEY) / 2;
            rect.top = i;
            rect.bottom = bitmap.getHeight() - i;
        }
        canvas.drawBitmap(bitmap, rect, rect2, paint);
    }
}
