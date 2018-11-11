package com.iqoption.charttools.constructor.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.iqoption.core.ext.c;

@SuppressLint({"ViewConstructor"})
/* compiled from: AlphaSliderView */
final class a extends View implements AnimatorListener, AnimatorUpdateListener {
    private final float avA;
    private final float avB;
    private final GradientDrawable avC;
    private final float avD;
    private final float avE;
    private final j avF;
    private final float avG;
    private final float avH;
    private final float avI;
    private final float avJ;
    private final i avK;
    private int avL = ViewCompat.MEASURED_STATE_MASK;
    private float avM = 1.0f;
    private float avN = 0.0f;
    private final ValueAnimator avO;
    private boolean avP;
    private a avQ;
    private final b avR = new b();
    private final float avy;
    private final float avz;
    private final int height;
    private final int width;

    /* compiled from: AlphaSliderView */
    interface a {
        void dk(int i);
    }

    /* compiled from: AlphaSliderView */
    private class b {
        private final float avS;
        private boolean avT;
        private boolean avU;
        private float avV;
        private float avW;
        private float avX;
        private float avY;
        private final RectF kt;

        private b() {
            this.kt = new RectF();
            this.avS = (float) ViewConfiguration.get(a.this.getContext()).getScaledTouchSlop();
        }

        void a(MotionEvent motionEvent) {
            boolean z = false;
            switch (motionEvent.getAction()) {
                case 0:
                    this.avV = motionEvent.getX();
                    this.avW = motionEvent.getY();
                    if (a.this.avM != 1.0f) {
                        z = true;
                    }
                    this.avT = z;
                    if (!this.avT) {
                        if (!g(this.avV, this.avW)) {
                            bN(true);
                            LI();
                            p(this.avW - LH());
                        }
                        LI();
                        break;
                    }
                    break;
                case 1:
                    if (!this.avU && g(this.avV, this.avW) && g(motionEvent.getX(), motionEvent.getY())) {
                        a.this.performClick();
                    }
                    bN(false);
                    break;
                case 2:
                    if (!this.avT) {
                        float y = motionEvent.getY() - this.avW;
                        if (!this.avU) {
                            if (Math.abs(y) >= this.avS / 4.0f) {
                                bN(true);
                                p(y);
                                break;
                            }
                        }
                        p(y);
                        break;
                    }
                    return;
                    break;
                case 3:
                    bN(false);
                    break;
            }
        }

        private boolean g(float f, float f2) {
            this.kt.set(a.this.avK.getBounds());
            this.kt.offset(a.this.avG, a.this.LC());
            return this.kt.contains(f, f2);
        }

        private float LH() {
            this.kt.set(a.this.avK.getBounds());
            this.kt.offset(a.this.avG, a.this.LC());
            return this.kt.centerY();
        }

        private void LI() {
            this.avX = (-a.this.avJ) * a.this.avN;
            this.avY = a.this.avJ * (1.0f - a.this.avN);
        }

        private void bN(boolean z) {
            this.avU = z;
            a.this.getParent().requestDisallowInterceptTouchEvent(z);
        }

        private void p(float f) {
            a.this.n(c.c(f, this.avY, this.avX));
        }
    }

    public void onAnimationRepeat(Animator animator) {
    }

    a(@NonNull Context context, int i, int i2) {
        super(context);
        this.width = i;
        this.height = i2;
        float f = (float) i;
        float f2 = f / 42.0f;
        float f3 = (float) i2;
        float f4 = f3 / 136.0f;
        float f5 = f2 * 30.0f;
        this.avA = 30.0f * f4;
        this.avB = 124.0f * f4;
        float f6 = 1.0f * f2;
        float f7 = 15.0f * f2;
        this.avC = new GradientDrawable();
        this.avC.setCornerRadius(f7);
        this.avC.setStroke(Math.round(f6), -1);
        this.avC.setSize(Math.round(f5), Math.round(this.avB));
        this.avC.setBounds(0, 0, this.avC.getIntrinsicWidth(), this.avC.getIntrinsicHeight());
        this.avC.setCallback(this);
        this.avy = (f - f5) / 2.0f;
        this.avz = (f3 - this.avB) / 2.0f;
        f6 = 12.0f * f2;
        f5 = 106.0f * f4;
        this.avF = new j(Math.round(f6), Math.round(f6), Math.round(f5), 6.0f * f2);
        this.avF.setBounds(0, 0, this.avF.getIntrinsicWidth(), this.avF.getIntrinsicHeight());
        this.avF.setCallback(this);
        this.avD = (f - f6) / 2.0f;
        this.avE = (f3 - f5) / 2.0f;
        f6 = 16.0f * f2;
        this.avK = new i(Math.round(f6), f2 * 2.0f, -1);
        this.avK.setBounds(0, 0, this.avK.getIntrinsicWidth(), this.avK.getIntrinsicHeight());
        this.avK.setCallback(this);
        this.avG = (f - f6) / 2.0f;
        this.avH = 13.0f * f4;
        this.avI = 107.0f * f4;
        this.avJ = f4 * 94.0f;
        this.avO = new ValueAnimator();
        this.avO.setDuration(200);
        this.avO.addListener(this);
        this.avO.addUpdateListener(this);
        LD();
        LE();
        LF();
        LG();
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        h(((Integer) valueAnimator.getAnimatedValue()).intValue(), false);
    }

    public void onAnimationStart(Animator animator) {
        this.avP = false;
    }

    public void onAnimationCancel(Animator animator) {
        this.avP = true;
    }

    public void onAnimationEnd(Animator animator) {
        if (!this.avP) {
            LA();
        }
    }

    void a(a aVar) {
        this.avQ = aVar;
    }

    private void LA() {
        if (this.avQ != null) {
            this.avQ.dk(LB());
        }
    }

    int LB() {
        return this.avL;
    }

    private float LC() {
        return (((this.avI - this.avH) * this.avN) * this.avM) + this.avH;
    }

    void dm(int i) {
        if (this.avL != i) {
            if (this.avO.isRunning()) {
                this.avO.cancel();
            }
            this.avO.setIntValues(new int[]{this.avL, i});
            this.avO.setEvaluator(com.iqoption.core.graphics.animation.a.TB());
            this.avO.start();
        }
    }

    void n(float f) {
        int s = com.iqoption.core.ext.a.s((1.0f - f) * 255.0f);
        if (s != (this.avL >>> 24)) {
            h((s << 24) | (this.avL & ViewCompat.MEASURED_SIZE_MASK), true);
        }
    }

    void h(int i, boolean z) {
        if (this.avL != i) {
            int i2 = this.avL >>> 24;
            int i3 = i >>> 24;
            int i4 = ViewCompat.MEASURED_SIZE_MASK & i;
            Object obj = (this.avL & ViewCompat.MEASURED_SIZE_MASK) != i4 ? 1 : null;
            this.avL = i;
            this.avN = 1.0f - (((float) i3) / 255.0f);
            if (obj != null) {
                this.avF.setColor(i4);
            }
            if (z) {
                LA();
            }
            LF();
            LG();
            invalidate();
        }
    }

    void o(float f) {
        if (this.avM != f) {
            this.avM = f;
            LD();
            LE();
            LG();
            invalidate();
        }
    }

    private void LD() {
        Rect bounds = this.avC.getBounds();
        this.avC.setBounds(bounds.left, bounds.top, bounds.right, Math.round(this.avA + ((this.avB - this.avA) * this.avM)));
    }

    private void LE() {
        this.avF.setFraction(this.avM);
    }

    private void LF() {
        this.avF.setOffset((this.avI - this.avH) * this.avN);
    }

    private void LG() {
        this.avK.setAlpha(Math.round(this.avM * 255.0f));
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(Math.round((float) this.width), Math.round((float) this.height));
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.translate(this.avy, this.avz);
        this.avC.draw(canvas);
        canvas.restore();
        canvas.save();
        canvas.translate(this.avD, this.avE);
        this.avF.draw(canvas);
        canvas.restore();
        canvas.save();
        canvas.translate(this.avG, LC());
        this.avK.draw(canvas);
        canvas.restore();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.avR.a(motionEvent);
        return true;
    }
}
