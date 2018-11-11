package com.iqoption.dialog.a.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.Property;
import android.view.View;
import android.view.animation.LinearInterpolator;

/* compiled from: GraphView */
public class d extends View implements c {
    private static final Property<d, Float> chG = new Property<d, Float>(Float.class, "graphProgress") {
        /* renamed from: a */
        public void set(d dVar, Float f) {
            dVar.setGraphProgress(f.floatValue());
        }

        /* renamed from: a */
        public Float get(d dVar) {
            return Float.valueOf(dVar.getGraphProgress());
        }
    };
    private static final Property<d, Float> chI = new Property<d, Float>(Float.class, "decorProgress") {
        /* renamed from: a */
        public void set(d dVar, Float f) {
            dVar.setDecorProgress(f.floatValue());
        }

        /* renamed from: a */
        public Float get(d dVar) {
            return Float.valueOf(dVar.getDecorProgress());
        }
    };
    private a cgY;
    private b chF = new a(getContext());
    private float chH = 1.0f;
    private float chJ = 1.0f;
    private float chK = 1.0f;
    private float chL = 1.0f;
    private float chM = 0.0f;
    private float chN = 0.0f;
    private PointF[] chO;
    private float chP;
    private float chQ;
    private float chR;
    private float chS;
    private float chT = 1.0f;
    private float chU = 1.0f;
    private final RectF chV = new RectF();
    private final RectF chW = new RectF();

    /* compiled from: GraphView */
    public interface a {
        void a(c cVar, Canvas canvas);

        void b(RectF rectF);
    }

    /* compiled from: GraphView */
    public interface b {
        void a(c cVar, Canvas canvas);
    }

    public void setGraphDrawer(b bVar) {
        if (bVar != null && this.chF != bVar) {
            this.chF = bVar;
            invalidate();
        }
    }

    public void setDecorDrawer(a aVar) {
        this.cgY = aVar;
        if (getWidth() != 0 && getHeight() != 0) {
            al(getWidth(), getHeight());
            invalidate();
        }
    }

    public float getGraphProgress() {
        return this.chH;
    }

    public void setGraphProgress(float f) {
        this.chH = f;
        invalidate();
    }

    public float getDecorProgress() {
        return this.chJ;
    }

    public void setDecorProgress(float f) {
        this.chJ = f;
        invalidate();
    }

    public float getGraphScaleX() {
        return this.chK;
    }

    public void setGraphScaleX(float f) {
        if (this.chK != f) {
            this.chK = f;
            aeK();
            invalidate();
        }
    }

    public float getGraphScaleY() {
        return this.chL;
    }

    public void setGraphScaleY(float f) {
        if (this.chL != f) {
            this.chL = f;
            aeL();
            invalidate();
        }
    }

    public float getGraphTranslationX() {
        return this.chM;
    }

    public void setGraphTranslationX(float f) {
        if (this.chM != f) {
            this.chM = f;
            invalidate();
        }
    }

    public float getGraphTranslationY() {
        return this.chN;
    }

    public void setGraphTranslationY(float f) {
        if (this.chN != f) {
            this.chN = f;
            invalidate();
        }
    }

    private float getMaxAvailableTranslationX() {
        return (1.0f - this.chK) * this.chW.right;
    }

    private float getMaxAvailableTranslationY() {
        return (1.0f - this.chL) * this.chW.bottom;
    }

    public d(Context context) {
        super(context);
    }

    public void setGraphPoints(PointF[] pointFArr) {
        this.chO = pointFArr;
        if (this.chP == this.chQ && this.chR == this.chS && this.chP == this.chR) {
            float f = pointFArr[0].x;
            float f2 = pointFArr[0].y;
            float f3 = f2;
            float f4 = f;
            for (int i = 1; i < pointFArr.length; i++) {
                PointF pointF = pointFArr[i];
                if (pointF.x < f) {
                    f = pointF.x;
                } else if (pointF.x > f4) {
                    f4 = pointF.x;
                }
                if (pointF.y < f2) {
                    f2 = pointF.y;
                } else if (pointF.y > f3) {
                    f3 = pointF.y;
                }
            }
            c(f, f4, f2, f3);
        }
        invalidate();
    }

    public void c(float f, float f2, float f3, float f4) {
        this.chP = f;
        this.chQ = f2;
        this.chR = f3;
        this.chS = f4;
        aeK();
        aeL();
        invalidate();
    }

    public int getPointsCount() {
        return this.chO != null ? this.chO.length : 0;
    }

    public int getPointsToDrawCount() {
        return (int) (((float) getPointsCount()) * this.chH);
    }

    public PointF eg(int i) {
        return this.chO[i];
    }

    public float eh(int i) {
        return this.chT * (this.chO[i].x - this.chP);
    }

    public float ei(int i) {
        return this.chU * (this.chO[i].y - this.chR);
    }

    public float C(float f) {
        return this.chT * (f - this.chP);
    }

    public float D(float f) {
        return this.chU * (f - this.chR);
    }

    public float getGraphWidth() {
        return this.chV.width();
    }

    public float getGraphHeight() {
        return this.chV.height();
    }

    public float getViewportWidth() {
        return this.chW.width();
    }

    public float getViewportHeight() {
        return this.chW.height();
    }

    public float getGraphMaxX() {
        return this.chQ;
    }

    public float getGraphMinX() {
        return this.chP;
    }

    public float getGraphMaxY() {
        return this.chS;
    }

    public float getGraphMinY() {
        return this.chR;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        al(i, i2);
    }

    private void al(int i, int i2) {
        this.chW.set(0.0f, 0.0f, (float) i, (float) i2);
        this.chV.set((float) getPaddingLeft(), (float) getPaddingTop(), (float) (i - getPaddingRight()), (float) (i2 - getPaddingBottom()));
        if (this.cgY != null) {
            this.cgY.b(this.chV);
        }
        aeK();
        aeL();
    }

    private void aeK() {
        this.chT = (this.chK * getGraphWidth()) / (this.chQ - this.chP);
    }

    private void aeL() {
        this.chU = (this.chL * getGraphHeight()) / (this.chS - this.chR);
    }

    protected void onDraw(Canvas canvas) {
        canvas.save();
        canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
        canvas.translate(this.chM, this.chN);
        this.chF.a(this, canvas);
        if (this.cgY != null) {
            this.cgY.a(this, canvas);
        }
        canvas.restore();
    }

    public void show() {
        setGraphProgress(0.0f);
        setDecorProgress(0.0f);
        Animator ofFloat = ObjectAnimator.ofFloat(this, chG, new float[]{0.0f, 1.0f});
        ofFloat.setDuration(1000);
        ofFloat.setInterpolator(new LinearInterpolator());
        if (this.cgY != null) {
            ObjectAnimator.ofFloat(this, chI, new float[]{0.0f, 1.0f}).setDuration(700).setInterpolator(new LinearInterpolator());
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playSequentially(new Animator[]{ofFloat, r2});
            animatorSet.start();
            return;
        }
        ofFloat.start();
    }
}
