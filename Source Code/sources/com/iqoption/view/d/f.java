package com.iqoption.view.d;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.iqoption.view.a.a.d;

/* compiled from: OnTouchScaleEffect */
public class f implements OnTouchListener {
    private float ju = 0.95f;

    public f(float f) {
        this.ju = f;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.animate().scaleX(this.ju).scaleY(this.ju).setDuration(300).setInterpolator(d.dEM).start();
        } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            view.animate().scaleX(1.0f).scaleY(1.0f).setDuration(300).setInterpolator(d.dEM).start();
        }
        return false;
    }
}
