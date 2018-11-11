package com.iqoption.fragment.a;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final /* synthetic */ class f implements OnTouchListener {
    static final OnTouchListener ckx = new f();

    private f() {
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        return view.getParent().requestDisallowInterceptTouchEvent(true);
    }
}
