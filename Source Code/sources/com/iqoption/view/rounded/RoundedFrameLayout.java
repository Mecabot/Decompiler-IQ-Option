package com.iqoption.view.rounded;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J(\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0007H\u0014R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, aXE = {"Lcom/iqoption/view/rounded/RoundedFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "cornerRadius", "", "path", "Landroid/graphics/Path;", "rect", "Landroid/graphics/RectF;", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "onSizeChanged", "w", "h", "oldw", "oldh", "IqOption-5.5.1_optionXRelease"})
/* compiled from: RoundedFrameLayout.kt */
public class RoundedFrameLayout extends FrameLayout {
    private float dIf;
    private final Path kr;
    private final RectF kt;

    public RoundedFrameLayout(Context context) {
        this(context, null, 0, 6, null);
    }

    public RoundedFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ RoundedFrameLayout(Context context, AttributeSet attributeSet, int i, int i2, f fVar) {
        if ((i2 & 2) != 0) {
            attributeSet = (AttributeSet) null;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        this(context, attributeSet, i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x003d  */
    public RoundedFrameLayout(android.content.Context r3, android.util.AttributeSet r4, int r5) {
        /*
        r2 = this;
        r0 = "context";
        kotlin.jvm.internal.h.e(r3, r0);
        r2.<init>(r3, r4, r5);
        r5 = new android.graphics.RectF;
        r5.<init>();
        r2.kt = r5;
        r5 = new android.graphics.Path;
        r5.<init>();
        r2.kr = r5;
        r5 = 0;
        r5 = (android.content.res.TypedArray) r5;
        r0 = com.iqoption.b.b.RoundedFrameLayout;	 Catch:{ all -> 0x0039 }
        r1 = 0;
        r3 = r3.obtainStyledAttributes(r4, r0, r1, r1);	 Catch:{ all -> 0x0039 }
        r4 = r2.getResources();	 Catch:{ all -> 0x0037 }
        r5 = 2131165822; // 0x7f07027e float:1.7945872E38 double:1.052935818E-314;
        r4 = r4.getDimension(r5);	 Catch:{ all -> 0x0037 }
        r4 = r3.getDimension(r1, r4);	 Catch:{ all -> 0x0037 }
        r2.dIf = r4;	 Catch:{ all -> 0x0037 }
        if (r3 == 0) goto L_0x0036;
    L_0x0033:
        r3.recycle();
    L_0x0036:
        return;
    L_0x0037:
        r4 = move-exception;
        goto L_0x003b;
    L_0x0039:
        r4 = move-exception;
        r3 = r5;
    L_0x003b:
        if (r3 == 0) goto L_0x0040;
    L_0x003d:
        r3.recycle();
    L_0x0040:
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.view.rounded.RoundedFrameLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.kr.reset();
        this.kt.set(0.0f, 0.0f, (float) i, (float) i2);
        this.kr.addRoundRect(this.kt, this.dIf, this.dIf, Direction.CW);
        this.kr.close();
    }

    protected void dispatchDraw(Canvas canvas) {
        Integer valueOf = canvas != null ? Integer.valueOf(canvas.save()) : null;
        if (canvas != null) {
            canvas.clipPath(this.kr);
        }
        super.dispatchDraw(canvas);
        if (canvas != null && valueOf != null) {
            canvas.restoreToCount(valueOf.intValue());
        }
    }
}
