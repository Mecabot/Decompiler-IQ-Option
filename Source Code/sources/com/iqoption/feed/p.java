package com.iqoption.feed;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.iqoption.d.yo;

final /* synthetic */ class p implements OnTouchListener {
    private final b clS;
    private final yo clZ;

    p(b bVar, yo yoVar) {
        this.clS = bVar;
        this.clZ = yoVar;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.clS.a(this.clZ, view, motionEvent);
    }
}
