package com.iqoption.view.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* compiled from: BaseFrameLayout */
public class a extends FrameLayout {
    private boolean mAttached;

    public a(Context context) {
        super(context);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean aIN() {
        return this.mAttached;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mAttached = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mAttached = false;
    }
}
