package com.iqoption.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nH\u0014R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, aXE = {"Lcom/iqoption/view/FitsSystemWindowsFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "tempInsets", "Landroid/graphics/Rect;", "windowInsets", "addView", "", "child", "Landroid/view/View;", "index", "params", "Landroid/view/ViewGroup$LayoutParams;", "fitSystemWindows", "", "insets", "IqOption-5.5.1_optionXRelease"})
/* compiled from: FitsSystemWindowsFrameLayout.kt */
public final class FitsSystemWindowsFrameLayout extends FrameLayout {
    private final Rect dBM;
    private final Rect dBN;

    public FitsSystemWindowsFrameLayout(Context context) {
        this(context, null, 0, 6, null);
    }

    public FitsSystemWindowsFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ FitsSystemWindowsFrameLayout(Context context, AttributeSet attributeSet, int i, int i2, f fVar) {
        if ((i2 & 2) != 0) {
            attributeSet = (AttributeSet) null;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        this(context, attributeSet, i);
    }

    public FitsSystemWindowsFrameLayout(Context context, AttributeSet attributeSet, int i) {
        h.e(context, "context");
        super(context, attributeSet, i);
        this.dBM = new Rect();
        this.dBN = new Rect();
    }

    protected boolean fitSystemWindows(Rect rect) {
        h.e(rect, "insets");
        this.dBM.set(rect);
        super.fitSystemWindows(rect);
        return false;
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        h.e(view, "child");
        h.e(layoutParams, "params");
        super.addView(view, i, layoutParams);
        this.dBN.set(this.dBM);
        super.fitSystemWindows(this.dBN);
    }
}
