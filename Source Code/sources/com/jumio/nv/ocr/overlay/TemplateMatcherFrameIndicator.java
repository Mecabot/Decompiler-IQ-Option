package com.jumio.nv.ocr.overlay;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.TypedValue;
import android.view.View;
import com.jumio.commons.utils.ScreenUtil;
import com.jumio.nv.ocr.R;

public class TemplateMatcherFrameIndicator extends View {
    protected boolean a;
    private Path b = null;
    private Paint c = null;
    private MyPointF d;
    private MyPointF e;
    private MyPointF f;
    private MyPointF g;
    private MyPointF h;
    private MyPointF i;
    private MyPointF j;
    private MyPointF k;
    private PointF l;

    public class MyPointF extends PointF {
        public MyPointF(PointF pointF) {
            super(pointF.x, pointF.y);
        }

        public void setX(float f) {
            set(f, this.y);
        }

        public void setY(float f) {
            set(this.x, f);
        }
    }

    public TemplateMatcherFrameIndicator(Context context) {
        super(context);
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.netverify_scanOverlayTemplateValid, typedValue, true);
        int dipToPx = (int) ScreenUtil.dipToPx(context, 2.5f);
        this.c = new Paint();
        this.c.setColor(typedValue.data);
        this.c.setStyle(Style.STROKE);
        this.c.setStrokeWidth((float) dipToPx);
        this.c.setDither(true);
        this.c.setAntiAlias(true);
        this.b = new Path();
        setBackgroundColor(0);
    }

    public void a(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4, PointF pointF5) {
        this.l = pointF5;
        if (pointF == null || pointF2 == null || pointF3 == null || pointF4 == null) {
            this.f = null;
            this.d = null;
            this.h = null;
            this.j = null;
            postInvalidate();
            return;
        }
        this.e = new MyPointF(pointF);
        this.g = new MyPointF(pointF2);
        this.i = new MyPointF(pointF4);
        this.k = new MyPointF(pointF3);
        if (!b()) {
            this.f = new MyPointF(pointF2);
            this.d = new MyPointF(pointF);
            this.h = new MyPointF(pointF4);
            this.j = new MyPointF(pointF3);
        }
        if (!this.a) {
            a();
        }
        postInvalidate();
    }

    private void a() {
        AnimatorSet animatorSet = new AnimatorSet();
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("x", new float[]{this.d.x, this.e.x});
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("y", new float[]{this.d.y, this.e.y});
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.d, new PropertyValuesHolder[]{ofFloat, ofFloat2});
        ofFloat2 = PropertyValuesHolder.ofFloat("x", new float[]{this.f.x, this.g.x});
        PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat("y", new float[]{this.f.y, this.g.y});
        ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.f, new PropertyValuesHolder[]{ofFloat2, ofFloat3});
        ofFloat3 = PropertyValuesHolder.ofFloat("x", new float[]{this.h.x, this.i.x});
        PropertyValuesHolder ofFloat4 = PropertyValuesHolder.ofFloat("y", new float[]{this.h.y, this.i.y});
        ObjectAnimator ofPropertyValuesHolder3 = ObjectAnimator.ofPropertyValuesHolder(this.h, new PropertyValuesHolder[]{ofFloat3, ofFloat4});
        ofFloat4 = PropertyValuesHolder.ofFloat("x", new float[]{this.j.x, this.k.x});
        PropertyValuesHolder ofFloat5 = PropertyValuesHolder.ofFloat("y", new float[]{this.j.y, this.k.y});
        ObjectAnimator.ofPropertyValuesHolder(this.j, new PropertyValuesHolder[]{ofFloat4, ofFloat5}).addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                TemplateMatcherFrameIndicator.this.postInvalidate();
            }
        });
        animatorSet.playTogether(new Animator[]{ofPropertyValuesHolder, ofPropertyValuesHolder2, ofPropertyValuesHolder3, r7});
        animatorSet.setDuration(150);
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                TemplateMatcherFrameIndicator.this.a = false;
            }

            public void onAnimationStart(Animator animator) {
                TemplateMatcherFrameIndicator.this.a = true;
            }
        });
        animatorSet.start();
    }

    private boolean b() {
        return (this.d == null || this.f == null || this.h == null || this.j == null) ? false : true;
    }

    public void onDraw(Canvas canvas) {
        a(canvas);
        super.onDraw(canvas);
    }

    public void a(Canvas canvas) {
        if (b()) {
            this.b.reset();
            this.b.moveTo(this.d.x * 0.98f, this.d.y * 0.98f);
            this.b.lineTo(this.f.x * 1.02f, this.f.y * 0.98f);
            this.b.lineTo(this.h.x * 1.02f, this.h.y * 1.02f);
            this.b.lineTo(this.j.x * 0.98f, this.j.y * 1.02f);
            this.b.lineTo(this.d.x * 0.98f, this.d.y * 0.98f);
            this.b.lineTo(this.f.x * 1.02f, this.f.y * 0.98f);
            canvas.drawPath(this.b, this.c);
        }
    }

    public void setBorderColor(int i) {
        this.c.setColor(i);
    }
}
