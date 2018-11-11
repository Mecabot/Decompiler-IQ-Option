package com.iqoption.view.rounded;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.iqoption.b.b;

public class RoundedImageView extends ImageView {
    private float dIg;
    private float dIh;
    private float dIi;
    private float dIj;
    private float dIk;
    private Paint kx;
    private int scaleType;

    public RoundedImageView(Context context) {
        this(context, null);
    }

    public RoundedImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundedImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.RoundedImageView);
            this.scaleType = obtainStyledAttributes.getInt(3, 1);
            this.dIg = (float) obtainStyledAttributes.getDimensionPixelSize(2, 0);
            this.dIh = (float) obtainStyledAttributes.getDimensionPixelSize(4, 0);
            this.dIi = (float) obtainStyledAttributes.getDimensionPixelSize(5, 0);
            this.dIj = (float) obtainStyledAttributes.getDimensionPixelSize(0, 0);
            this.dIk = (float) obtainStyledAttributes.getDimensionPixelSize(1, 0);
            obtainStyledAttributes.recycle();
        }
        this.dIg = d(this.dIg, this.dIh, this.dIi, this.dIj, this.dIk);
    }

    private float d(float... fArr) {
        float f = 0.0f;
        for (int i = 0; i < fArr.length; i++) {
            if (f < fArr[i]) {
                f = fArr[i];
            }
        }
        return f;
    }

    /* JADX WARNING: Missing block: B:30:0x00c0, code:
            return;
     */
    protected void onDraw(android.graphics.Canvas r10) {
        /*
        r9 = this;
        r0 = r9.getDrawable();
        r0 = (android.graphics.drawable.BitmapDrawable) r0;
        if (r0 != 0) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        r1 = r9.getWidth();
        if (r1 == 0) goto L_0x00c0;
    L_0x000f:
        r1 = r9.getHeight();
        if (r1 != 0) goto L_0x0017;
    L_0x0015:
        goto L_0x00c0;
    L_0x0017:
        r1 = r0.getBitmap();
        if (r1 != 0) goto L_0x001e;
    L_0x001d:
        return;
    L_0x001e:
        r1 = r9.getMeasuredWidth();
        r2 = r9.getMeasuredHeight();
        r3 = r9.kx;
        if (r3 != 0) goto L_0x0056;
    L_0x002a:
        r0 = r0.getBitmap();
        r3 = r9.scaleType;
        r4 = 1;
        if (r3 != r4) goto L_0x0038;
    L_0x0033:
        r0 = android.graphics.Bitmap.createScaledBitmap(r0, r1, r2, r4);
        goto L_0x003c;
    L_0x0038:
        r0 = com.iqoption.util.f.a(r0, r1, r2);
    L_0x003c:
        r3 = new android.graphics.BitmapShader;
        r5 = android.graphics.Shader.TileMode.CLAMP;
        r6 = android.graphics.Shader.TileMode.CLAMP;
        r3.<init>(r0, r5, r6);
        r0 = new android.graphics.Paint;
        r0.<init>();
        r9.kx = r0;
        r0 = r9.kx;
        r0.setAntiAlias(r4);
        r0 = r9.kx;
        r0.setShader(r3);
    L_0x0056:
        r0 = new android.graphics.RectF;
        r3 = (float) r1;
        r4 = (float) r2;
        r5 = 0;
        r0.<init>(r5, r5, r3, r4);
        r6 = r9.dIg;
        r7 = r9.dIg;
        r8 = r9.kx;
        r10.drawRoundRect(r0, r6, r7, r8);
        r0 = r9.dIh;
        r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1));
        if (r0 != 0) goto L_0x007d;
    L_0x006d:
        r0 = new android.graphics.RectF;
        r6 = r1 / 2;
        r6 = (float) r6;
        r7 = r2 / 2;
        r7 = (float) r7;
        r0.<init>(r5, r5, r6, r7);
        r6 = r9.kx;
        r10.drawRect(r0, r6);
    L_0x007d:
        r0 = r9.dIi;
        r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1));
        if (r0 != 0) goto L_0x0093;
    L_0x0083:
        r0 = new android.graphics.RectF;
        r6 = r1 / 2;
        r6 = (float) r6;
        r7 = r2 / 2;
        r7 = (float) r7;
        r0.<init>(r6, r5, r3, r7);
        r6 = r9.kx;
        r10.drawRect(r0, r6);
    L_0x0093:
        r0 = r9.dIk;
        r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1));
        if (r0 != 0) goto L_0x00a9;
    L_0x0099:
        r0 = new android.graphics.RectF;
        r6 = r1 / 2;
        r6 = (float) r6;
        r7 = r2 / 2;
        r7 = (float) r7;
        r0.<init>(r6, r7, r3, r4);
        r3 = r9.kx;
        r10.drawRect(r0, r3);
    L_0x00a9:
        r0 = r9.dIj;
        r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1));
        if (r0 != 0) goto L_0x00bf;
    L_0x00af:
        r0 = new android.graphics.RectF;
        r2 = r2 / 2;
        r2 = (float) r2;
        r1 = r1 / 2;
        r1 = (float) r1;
        r0.<init>(r5, r2, r1, r4);
        r1 = r9.kx;
        r10.drawRect(r0, r1);
    L_0x00bf:
        return;
    L_0x00c0:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.view.rounded.RoundedImageView.onDraw(android.graphics.Canvas):void");
    }
}
