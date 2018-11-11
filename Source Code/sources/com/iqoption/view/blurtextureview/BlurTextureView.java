package com.iqoption.view.blurtextureview;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import com.iqoption.core.i;
import com.iqoption.view.b.a;

public class BlurTextureView extends View {
    private static final String TAG = "com.iqoption.view.blurtextureview.BlurTextureView";
    private b dFf;
    int dFg;
    long dFh;
    int dFi;
    long dFj;

    public BlurTextureView(Context context) {
        this(context, null);
    }

    public BlurTextureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BlurTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dFg = 0;
        this.dFh = 0;
        this.dFi = 0;
        this.dFj = 5000;
    }

    public void aIQ() {
        a(null, null);
    }

    public void a(Bitmap bitmap, a aVar) {
        if (aIR() || bitmap == null || aVar == null) {
            this.dFf = new c(this);
        } else if (VERSION.SDK_INT < 21) {
            this.dFf = new d(this, bitmap, aVar);
        } else {
            this.dFf = new a(this, bitmap, aVar);
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.dFf.destroy();
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.dFf.ak(i, i2);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.dFf.draw(canvas);
        aIS();
    }

    private boolean aIR() {
        return VERSION.SDK_INT >= 19 ? ((ActivityManager) getContext().getSystemService("activity")).isLowRamDevice() : true;
    }

    private void aIS() {
        this.dFg++;
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.dFh;
        if (j > this.dFj) {
            this.dFi = (int) ((((long) this.dFg) * this.dFj) / j);
            this.dFg = 0;
            this.dFh = currentTimeMillis;
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("fpsBlurTexture=");
            stringBuilder.append(this.dFi);
            i.v(str, stringBuilder.toString());
        }
    }
}
