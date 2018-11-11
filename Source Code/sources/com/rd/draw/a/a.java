package com.rd.draw.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.rd.animation.type.AnimationType;
import com.rd.b.b;
import com.rd.draw.data.Orientation;
import com.rd.draw.data.RtlMode;

/* compiled from: AttributeController */
public class a {
    private com.rd.draw.data.a ehq;

    public a(@NonNull com.rd.draw.data.a aVar) {
        this.ehq = aVar;
    }

    public void init(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.rd.a.a.a.PageIndicatorView, 0, 0);
        d(obtainStyledAttributes);
        e(obtainStyledAttributes);
        f(obtainStyledAttributes);
        g(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    /* JADX WARNING: Missing block: B:7:0x002b, code:
            if (r7 > r4) goto L_0x002f;
     */
    private void d(@android.support.annotation.NonNull android.content.res.TypedArray r7) {
        /*
        r6 = this;
        r0 = com.rd.a.a.a.PageIndicatorView_piv_viewPager;
        r1 = -1;
        r0 = r7.getResourceId(r0, r1);
        r2 = com.rd.a.a.a.PageIndicatorView_piv_autoVisibility;
        r3 = 1;
        r2 = r7.getBoolean(r2, r3);
        r3 = com.rd.a.a.a.PageIndicatorView_piv_dynamicCount;
        r4 = 0;
        r3 = r7.getBoolean(r3, r4);
        r5 = com.rd.a.a.a.PageIndicatorView_piv_count;
        r5 = r7.getInt(r5, r1);
        if (r5 != r1) goto L_0x001e;
    L_0x001d:
        r5 = 3;
    L_0x001e:
        r1 = com.rd.a.a.a.PageIndicatorView_piv_select;
        r7 = r7.getInt(r1, r4);
        if (r7 >= 0) goto L_0x0027;
    L_0x0026:
        goto L_0x002f;
    L_0x0027:
        if (r5 <= 0) goto L_0x002e;
    L_0x0029:
        r4 = r5 + -1;
        if (r7 <= r4) goto L_0x002e;
    L_0x002d:
        goto L_0x002f;
    L_0x002e:
        r4 = r7;
    L_0x002f:
        r7 = r6.ehq;
        r7.iE(r0);
        r7 = r6.ehq;
        r7.setAutoVisibility(r2);
        r7 = r6.ehq;
        r7.setDynamicCount(r3);
        r7 = r6.ehq;
        r7.setCount(r5);
        r7 = r6.ehq;
        r7.cD(r4);
        r7 = r6.ehq;
        r7.iC(r4);
        r7 = r6.ehq;
        r7.iD(r4);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rd.draw.a.a.d(android.content.res.TypedArray):void");
    }

    private void e(@NonNull TypedArray typedArray) {
        int color = typedArray.getColor(com.rd.a.a.a.PageIndicatorView_piv_unselectedColor, Color.parseColor("#33ffffff"));
        int color2 = typedArray.getColor(com.rd.a.a.a.PageIndicatorView_piv_selectedColor, Color.parseColor("#ffffff"));
        this.ehq.setUnselectedColor(color);
        this.ehq.setSelectedColor(color2);
    }

    private void f(@NonNull TypedArray typedArray) {
        int i = 0;
        boolean z = typedArray.getBoolean(com.rd.a.a.a.PageIndicatorView_piv_interactiveAnimation, false);
        int i2 = typedArray.getInt(com.rd.a.a.a.PageIndicatorView_piv_animationDuration, 350);
        if (i2 >= 0) {
            i = i2;
        }
        AnimationType iz = iz(typedArray.getInt(com.rd.a.a.a.PageIndicatorView_piv_animationType, AnimationType.NONE.ordinal()));
        RtlMode iA = iA(typedArray.getInt(com.rd.a.a.a.PageIndicatorView_piv_rtl_mode, RtlMode.Off.ordinal()));
        this.ehq.setAnimationDuration((long) i);
        this.ehq.setInteractiveAnimation(z);
        this.ehq.setAnimationType(iz);
        this.ehq.setRtlMode(iA);
    }

    private void g(@NonNull TypedArray typedArray) {
        Orientation orientation;
        if (typedArray.getInt(com.rd.a.a.a.PageIndicatorView_piv_orientation, Orientation.HORIZONTAL.ordinal()) == 0) {
            orientation = Orientation.HORIZONTAL;
        } else {
            orientation = Orientation.VERTICAL;
        }
        int dimension = (int) typedArray.getDimension(com.rd.a.a.a.PageIndicatorView_piv_radius, (float) b.dpToPx(6));
        if (dimension < 0) {
            dimension = 0;
        }
        int dimension2 = (int) typedArray.getDimension(com.rd.a.a.a.PageIndicatorView_piv_padding, (float) b.dpToPx(8));
        if (dimension2 < 0) {
            dimension2 = 0;
        }
        float f = typedArray.getFloat(com.rd.a.a.a.PageIndicatorView_piv_scaleFactor, 0.7f);
        if (f < 0.3f) {
            f = 0.3f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        int dimension3 = (int) typedArray.getDimension(com.rd.a.a.a.PageIndicatorView_piv_strokeWidth, (float) b.dpToPx(1));
        if (dimension3 > dimension) {
            dimension3 = dimension;
        }
        if (this.ehq.aTi() != AnimationType.FILL) {
            dimension3 = 0;
        }
        this.ehq.setRadius(dimension);
        this.ehq.setOrientation(orientation);
        this.ehq.setPadding(dimension2);
        this.ehq.setScaleFactor(f);
        this.ehq.it(dimension3);
    }

    private AnimationType iz(int i) {
        switch (i) {
            case 0:
                return AnimationType.NONE;
            case 1:
                return AnimationType.COLOR;
            case 2:
                return AnimationType.SCALE;
            case 3:
                return AnimationType.WORM;
            case 4:
                return AnimationType.SLIDE;
            case 5:
                return AnimationType.FILL;
            case 6:
                return AnimationType.THIN_WORM;
            case 7:
                return AnimationType.DROP;
            case 8:
                return AnimationType.SWAP;
            case 9:
                return AnimationType.SCALE_DOWN;
            default:
                return AnimationType.NONE;
        }
    }

    private RtlMode iA(int i) {
        switch (i) {
            case 0:
                return RtlMode.On;
            case 1:
                return RtlMode.Off;
            case 2:
                return RtlMode.Auto;
            default:
                return RtlMode.Auto;
        }
    }
}
