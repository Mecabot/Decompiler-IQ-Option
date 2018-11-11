package com.iqoption.view.d;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* compiled from: OnTouchDecorator */
public abstract class e implements OnTouchListener {
    private OnTouchListener dKJ;

    public abstract boolean f(View view, MotionEvent motionEvent);

    public e(OnTouchListener onTouchListener) {
        this.dKJ = onTouchListener;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.dKJ != null) {
            this.dKJ.onTouch(view, motionEvent);
        }
        return f(view, motionEvent);
    }
}
