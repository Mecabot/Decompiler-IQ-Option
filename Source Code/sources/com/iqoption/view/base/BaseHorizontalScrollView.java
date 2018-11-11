package com.iqoption.view.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;

public class BaseHorizontalScrollView extends HorizontalScrollView {
    private a dEQ;
    private boolean mAttached;

    public interface a {
        void onScrollChanged(int i, int i2, int i3, int i4);
    }

    public BaseHorizontalScrollView(Context context) {
        super(context);
    }

    public BaseHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BaseHorizontalScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public BaseHorizontalScrollView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
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

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.dEQ != null) {
            this.dEQ.onScrollChanged(i, i2, i3, i4);
        }
    }

    public void setOnScrollChangedListener(a aVar) {
        this.dEQ = aVar;
    }
}
