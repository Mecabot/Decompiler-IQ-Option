package com.jumio.gui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class DrawView extends RelativeLayout {
    private DrawViewInterface drawViewInterface;

    public interface DrawViewInterface {
        void addChildren(@NonNull ViewGroup viewGroup);

        void draw(Canvas canvas);

        Rect getOverlayBounds();

        void measure(int i, int i2);
    }

    public DrawView(Context context) {
        super(context);
        setWillNotDraw(false);
    }

    public DrawView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setWillNotDraw(false);
    }

    public DrawView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setWillNotDraw(false);
    }

    @TargetApi(21)
    public DrawView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        setWillNotDraw(false);
    }

    public void setDrawViewInterface(DrawViewInterface drawViewInterface) {
        this.drawViewInterface = drawViewInterface;
        if (drawViewInterface != null) {
            drawViewInterface.addChildren(this);
        }
    }

    /* JADX WARNING: Missing block: B:7:0x001a, code:
            return;
     */
    protected void onMeasure(int r2, int r3) {
        /*
        r1 = this;
        super.onMeasure(r2, r3);
        r2 = r1.getMeasuredWidth();
        r3 = r1.getMeasuredHeight();
        if (r2 == 0) goto L_0x001a;
    L_0x000d:
        if (r3 != 0) goto L_0x0010;
    L_0x000f:
        goto L_0x001a;
    L_0x0010:
        r0 = r1.drawViewInterface;
        if (r0 == 0) goto L_0x0019;
    L_0x0014:
        r0 = r1.drawViewInterface;
        r0.measure(r2, r3);
    L_0x0019:
        return;
    L_0x001a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.gui.DrawView.onMeasure(int, int):void");
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.drawViewInterface != null) {
            this.drawViewInterface.draw(canvas);
        }
    }
}
