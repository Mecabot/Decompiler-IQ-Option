package com.iqoption.view.d;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* compiled from: OnTouchAlphaEffect */
public class d implements OnTouchListener {
    private float mAlpha = 0.5f;

    public d(float f) {
        this.mAlpha = f;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.animate().alpha(this.mAlpha).setInterpolator(com.iqoption.view.a.a.d.dEM).setDuration(150).start();
        } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            view.animate().alpha(1.0f).setInterpolator(com.iqoption.view.a.a.d.dEM).setDuration(300).start();
        }
        return false;
    }
}
