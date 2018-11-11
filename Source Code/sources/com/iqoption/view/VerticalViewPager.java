package com.iqoption.view;

import android.content.Context;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.view.ViewPager.PageTransformer;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import com.iqoption.view.a.a.d;

public class VerticalViewPager extends SmoothViewPager {
    private boolean dEv;

    private class a implements PageTransformer {
        private a() {
        }

        /* synthetic */ a(VerticalViewPager verticalViewPager, AnonymousClass1 anonymousClass1) {
            this();
        }

        public void transformPage(View view, float f) {
            int width = view.getWidth();
            int height = view.getHeight();
            if (f < -1.0f) {
                view.setAlpha(0.0f);
            } else if (f <= 1.0f) {
                view.setAlpha(1.0f);
                view.setTranslationX(((float) width) * (-f));
                view.setTranslationY(f * ((float) height));
            } else {
                view.setAlpha(0.0f);
            }
        }
    }

    public VerticalViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        setPageTransformer(true, new a(this, null));
        setOverScrollMode(2);
        setOnPageChangeListener(new OnPageChangeListener() {
            public void onPageSelected(int i) {
            }

            public void onPageScrolled(int i, float f, int i2) {
                if (!VerticalViewPager.this.dEv) {
                    if (VerticalViewPager.this.getCurrentItem() == 0) {
                        if (i == 0 && f > 0.0f) {
                            VerticalViewPager.this.setCurrentItem(1, true);
                        }
                    } else if (i == 0 && f < 1.0f) {
                        VerticalViewPager.this.setCurrentItem(0, true);
                    }
                }
            }

            public void onPageScrollStateChanged(int i) {
                if (i == 0) {
                    VerticalViewPager.this.dEv = false;
                }
            }
        });
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        motionEvent.setLocation(motionEvent.getY(), motionEvent.getX());
        return super.onTouchEvent(motionEvent);
    }

    public void setCurrentItem(int i, boolean z) {
        super.setCurrentItem(i, z);
        this.dEv = true;
    }

    protected Interpolator getInterpolator() {
        return d.dEM;
    }
}
