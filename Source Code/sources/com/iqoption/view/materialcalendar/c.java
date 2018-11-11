package com.iqoption.view.materialcalendar;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;

/* compiled from: CalendarPager */
class c extends ViewPager {
    private boolean dGx = true;

    public c(Context context) {
        super(context);
    }

    public void setPagingEnabled(boolean z) {
        this.dGx = z;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.dGx && super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.dGx && super.onTouchEvent(motionEvent);
    }

    public boolean canScrollVertically(int i) {
        return this.dGx && super.canScrollVertically(i);
    }

    public boolean canScrollHorizontally(int i) {
        return this.dGx && super.canScrollHorizontally(i);
    }
}
