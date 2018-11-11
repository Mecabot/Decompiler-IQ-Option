package com.microblink.secured;

import android.content.Context;
import android.support.annotation.UiThread;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.microblink.hardware.orientation.Orientation;
import com.microblink.util.Log;
import com.microblink.view.BaseCameraView;

/* compiled from: line */
public abstract class f extends BaseCameraView {
    private aj dVO;
    private ah dVP;
    private boolean dVQ;
    private int dVR;
    private boolean dVS;

    /* compiled from: line */
    public static class a extends LayoutParams {
        boolean dVT = false;

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            if (attributeSet != null) {
                this.dVT = attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res-auto", "rotatable", this.dVT);
            }
        }

        public a() {
            super(-1, -1);
        }
    }

    @UiThread
    public void addView(View view) {
        if (this.dVS) {
            addView(view, null);
        } else {
            super.addView(view);
        }
    }

    @UiThread
    public void addView(View view, int i) {
        if (this.dVS) {
            addView(view, i, null);
        } else {
            super.addView(view, i);
        }
    }

    @UiThread
    public void addView(View view, int i, LayoutParams layoutParams) {
        if (this.dVS) {
            if (layoutParams == null) {
                layoutParams = new a();
            }
            if (!(layoutParams instanceof a)) {
                throw new RuntimeException("BaseCameraView.LayoutParams are only allowed type of params");
            } else if (((a) layoutParams).dVT) {
                this.dVO.addView(view, i);
                return;
            } else {
                this.dVP.addView(view, i);
                return;
            }
        }
        super.addView(view, i, layoutParams);
    }

    @UiThread
    public void addView(View view, LayoutParams layoutParams) {
        if (this.dVS) {
            if (layoutParams == null) {
                layoutParams = new a();
            }
            if (!(layoutParams instanceof a)) {
                throw new RuntimeException("BaseCameraView.LayoutParams are only allowed type of params");
            } else if (((a) layoutParams).dVT) {
                this.dVO.addView(view);
                return;
            } else {
                this.dVP.addView(view);
                return;
            }
        }
        super.addView(view, layoutParams);
    }

    @UiThread
    public void addView(View view, int i, int i2) {
        if (this.dVS) {
            throw new RuntimeException("addView method has been disabled in CameraView. Please use addChildView(View, boolean).");
        }
        super.addView(view, i, i2);
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new a();
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    @UiThread
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Log.e(this, "Rotatable view responded: {}", Boolean.valueOf(this.dVO.dispatchTouchEvent(motionEvent)));
        if (this.dVO.dispatchTouchEvent(motionEvent)) {
            return true;
        }
        Log.e(this, "Fixed view responded: {}", Boolean.valueOf(this.dVP.dispatchTouchEvent(motionEvent)));
        if (this.dVP.dispatchTouchEvent(motionEvent) || super.dispatchTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    @UiThread
    public final void setAnimateRotation(boolean z) {
        this.dVQ = z;
        this.dVO.setAnimateRotation(z);
    }

    public final int getRotationAnimationDuration() {
        return this.dVR;
    }

    public final void setRotationAnimationDuration(int i) {
        this.dVR = i;
        this.dVO.setAnimationDuration(i);
    }

    @UiThread
    public final void setInitialOrientation(Orientation orientation) {
        super.setInitialOrientation(orientation);
        this.dVO.setInitialOrientation(getInitialOrientation());
    }
}
