package com.iqoption.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.iqoption.b.b;
import com.iqoption.view.a.a.d;
import java.lang.reflect.Field;

public class SmoothViewPager extends ViewPager {
    private boolean dDM;

    public class a extends Scroller {
        public a(Context context) {
            super(context, SmoothViewPager.this.getInterpolator());
        }

        public void startScroll(int i, int i2, int i3, int i4, int i5) {
            super.startScroll(i, i2, i3, i4, SmoothViewPager.this.getDuration());
        }
    }

    protected int getDuration() {
        return 300;
    }

    public SmoothViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        aIE();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.SmoothViewPager);
        try {
            this.dDM = obtainStyledAttributes.getBoolean(0, true);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.dDM && super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.dDM && super.onTouchEvent(motionEvent);
    }

    private void aIE() {
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            declaredField.set(this, new a(getContext()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setSwipeable(boolean z) {
        this.dDM = z;
    }

    protected Interpolator getInterpolator() {
        return d.dEM;
    }
}
