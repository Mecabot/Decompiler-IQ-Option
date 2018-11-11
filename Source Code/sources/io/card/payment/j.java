package io.card.payment;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup;

/* compiled from: Preview */
class j extends ViewGroup {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "j";
    SurfaceView dSC;
    private int dSH;
    private int dSJ;

    public j(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet);
        this.dSH = i2;
        this.dSJ = i;
        this.dSC = new SurfaceView(context);
        addView(this.dSC);
    }

    public SurfaceView aTT() {
        return this.dSC;
    }

    SurfaceHolder getSurfaceHolder() {
        return aTT().getHolder();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawARGB(255, 255, 0, 0);
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(resolveSize(getSuggestedMinimumWidth(), i), resolveSize(getSuggestedMinimumHeight(), i2));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z && getChildCount() > 0) {
            i3 -= i;
            i4 -= i2;
            int i5;
            if (this.dSJ * i3 > this.dSH * i4) {
                i5 = (this.dSH * i4) / this.dSJ;
                this.dSC.layout((i3 - i5) / 2, 0, (i3 + i5) / 2, i4);
                return;
            }
            i5 = (this.dSJ * i3) / this.dSH;
            this.dSC.layout(0, (i4 - i5) / 2, i3, (i4 + i5) / 2);
        }
    }
}
