package com.jumio.nv.gui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.view.View;
import com.jumio.commons.utils.ScreenUtil;

public class PieProgressView extends View {
    private boolean a = false;
    private Paint b = new Paint(1);
    private Paint c;
    private Paint d;
    private float e;
    private a f;
    private RectF g;
    private Rect h;
    private float i = 0.0f;
    private final float j = -90.0f;
    private boolean k = false;
    private String l = "";

    public enum a {
        CLOCKWISE,
        COUNTERCLOCKWISE
    }

    public PieProgressView(Context context) {
        super(context);
        this.b.setStyle(Style.STROKE);
        this.b.setTypeface(Typeface.create("sans-serif-light", 2));
        this.c = new Paint(1);
        this.c.setStyle(Style.STROKE);
        this.c.setStrokeJoin(Join.ROUND);
        this.c.setStrokeCap(Cap.ROUND);
        this.d = new Paint(1);
        this.d.setStyle(Style.FILL);
        this.d.setStrokeJoin(Join.ROUND);
        this.d.setStrokeCap(Cap.ROUND);
        this.f = a.CLOCKWISE;
        setBorderWidth(3);
        this.h = new Rect();
    }

    public void updatePosition(PointF pointF) {
        if (!this.a) {
            a(pointF);
        }
    }

    private void a(PointF pointF) {
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("X", new float[]{getX(), pointF.x - (((float) getWidth()) / 2.0f)});
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("Y", new float[]{getY(), pointF.y - (((float) getHeight()) / 2.0f)});
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{ofFloat, ofFloat2});
        ofPropertyValuesHolder.setDuration(150);
        ofPropertyValuesHolder.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                PieProgressView.this.postInvalidate();
            }
        });
        ofPropertyValuesHolder.addListener(new AnimatorListener() {
            public void onAnimationStart(Animator animator) {
                PieProgressView.this.a = true;
            }

            public void onAnimationEnd(Animator animator) {
                PieProgressView.this.a = false;
            }

            public void onAnimationCancel(Animator animator) {
                PieProgressView.this.a = false;
            }

            public void onAnimationRepeat(Animator animator) {
                PieProgressView.this.a = true;
            }
        });
        ofPropertyValuesHolder.start();
    }

    public void setDirection(a aVar) {
        this.f = aVar;
        invalidate();
    }

    public void setInvertFill(boolean z) {
        this.k = z;
        invalidate();
    }

    public void setBorderWidth(int i) {
        this.e = (float) ScreenUtil.dpToPx(getContext(), i);
        this.c.setStrokeWidth(this.e);
        invalidate();
    }

    public void setBorderColor(int i) {
        this.c.setColor(i);
        invalidate();
    }

    public void setPieColor(int i) {
        this.d.setColor(i);
        invalidate();
    }

    public void setTextColor(int i) {
        this.b.setColor(i);
        invalidate();
    }

    public void setProgress(int i) {
        float f = (((float) i) * 360.0f) / 100.0f;
        if (Math.ceil((double) f) != Math.ceil((double) this.i)) {
            invalidate();
        }
        this.i = f;
    }

    public void setProgress(int i, String str) {
        this.l = str;
        setProgress(i);
        invalidate();
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        float f = (float) i2;
        this.g = new RectF(this.e, this.e, ((float) i) - this.e, f - this.e);
        this.b.setTextSize(f / 2.3f);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.g != null) {
            int saveLayer = canvas.saveLayer(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), null, 31);
            canvas.drawCircle(this.g.centerX(), this.g.centerY(), this.g.width() / 2.0f, this.c);
            int i = this.k ? 360 : 0;
            if (this.f.equals(a.CLOCKWISE)) {
                canvas.drawArc(this.g, -90.0f, this.i - ((float) i), true, this.d);
            } else {
                canvas.drawArc(this.g, -90.0f, ((float) i) - this.i, true, this.d);
            }
            canvas.restoreToCount(saveLayer);
            this.b.getTextBounds(this.l, 0, this.l.length(), this.h);
            canvas.drawText(this.l, this.g.centerX() - (this.b.measureText(this.l) / 2.0f), this.g.centerY() + (((float) this.h.height()) / 2.0f), this.b);
        }
    }
}
