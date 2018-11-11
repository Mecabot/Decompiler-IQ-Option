package com.iqoption.view;

import android.content.Context;
import android.util.AttributeSet;
import com.iqoption.view.a.a.d;

public class RotatedAnimatedVectorSwitchView extends AnimatedVectorSwitchView {
    private boolean dDC = false;

    public RotatedAnimatedVectorSwitchView(Context context) {
        super(context);
    }

    public RotatedAnimatedVectorSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context, attributeSet);
    }

    public RotatedAnimatedVectorSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b(context, attributeSet);
    }

    private void b(Context context, AttributeSet attributeSet) {
        aID();
    }

    public boolean isReverse() {
        return this.dDC;
    }

    public void setReverse(boolean z) {
        this.dDC = z;
        aID();
    }

    public void reverse() {
        this.dDC ^= 1;
        aID();
    }

    private void aID() {
        animate().rotation(this.dDC ? 180.0f : 0.0f).setInterpolator(d.dEM).start();
    }
}
