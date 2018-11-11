package com.iqoption.fragment;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final /* synthetic */ class ae implements OnTouchListener {
    private final GestureDetector cnO;

    ae(GestureDetector gestureDetector) {
        this.cnO = gestureDetector;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.cnO.onTouchEvent(motionEvent);
    }
}
