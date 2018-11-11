package com.iqoption.view.drawable;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.util.Property;
import com.iqoption.app.IQApp;
import com.iqoption.util.ax;
import com.iqoption.view.a.a.d;
import com.iqoption.x.R;
import java.util.ArrayList;
import java.util.List;

/* compiled from: IQLogo */
public final class b extends Drawable {
    private static final Property<b, Float> dFl = new Property<b, Float>(Float.class, "p1") {
        /* renamed from: c */
        public Float get(b bVar) {
            return Float.valueOf(bVar.dFx[0]);
        }

        /* renamed from: a */
        public void set(b bVar, Float f) {
            bVar.f(f.floatValue(), bVar.dFx[1], bVar.dFx[2]);
        }
    };
    private static final Property<b, Float> dFm = new Property<b, Float>(Float.class, "p2") {
        /* renamed from: c */
        public Float get(b bVar) {
            return Float.valueOf(bVar.dFx[1]);
        }

        /* renamed from: a */
        public void set(b bVar, Float f) {
            bVar.f(bVar.dFx[0], f.floatValue(), bVar.dFx[2]);
        }
    };
    private static final Property<b, Float> dFn = new Property<b, Float>(Float.class, "p3") {
        /* renamed from: c */
        public Float get(b bVar) {
            return Float.valueOf(bVar.dFx[2]);
        }

        /* renamed from: a */
        public void set(b bVar, Float f) {
            bVar.f(bVar.dFx[0], bVar.dFx[1], f.floatValue());
        }
    };
    private static final Property<b, Integer> dFo = new Property<b, Integer>(Integer.class, "empty") {
        /* renamed from: a */
        public void set(b bVar, Integer num) {
        }

        /* renamed from: d */
        public Integer get(b bVar) {
            return Integer.valueOf(0);
        }
    };
    private static RectF[] dFp = new RectF[]{new RectF(0.219f, 0.422f, 0.344f, 0.773f), new RectF(0.422f, 0.305f, 0.547f, 0.773f), new RectF(0.625f, 0.195f, 0.75f, 0.773f)};
    private static float dFq = (ax.dws ? 1.0f : 0.075f);
    private Animator animator;
    private final Paint cij = new Paint(1);
    private float cim;
    private final Path dFA = new Path();
    private float dFr;
    private float dFs;
    private float dFt;
    private float dFu = 1.0f;
    private final RectF[] dFv = new RectF[3];
    private final RectF dFw = new RectF();
    private float[] dFx = new float[]{0.0f, 0.0f, 0.0f};
    private final Paint dFy = new Paint(1);
    private final Paint dFz = new Paint(1);

    public int getOpacity() {
        return -3;
    }

    public b() {
        Context Dk = IQApp.Dk();
        gW(ContextCompat.getColor(Dk, R.color.orange_accent));
        gX(ContextCompat.getColor(Dk, R.color.white_50));
        gY(-1);
    }

    public final void O(float f) {
        this.dFr = f;
        f /= 2.0f;
        this.dFs = f;
        this.dFt = f;
        this.cim = f;
        aIT();
    }

    private void aIT() {
        for (int i = 0; i < this.dFv.length; i++) {
            RectF rectF = dFp[i];
            this.dFv[i] = new RectF(this.dFr * rectF.left, this.dFr * rectF.top, this.dFr * rectF.right, this.dFr * rectF.bottom);
        }
        this.dFu = dFq * this.dFr;
    }

    public final float[] aIU() {
        return this.dFx;
    }

    public final void c(float[] fArr) {
        this.dFx = fArr;
    }

    private void f(float f, float f2, float f3) {
        this.dFx[0] = f;
        this.dFx[1] = f2;
        this.dFx[2] = f3;
        Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public final void gW(int i) {
        this.cij.setColor(i);
    }

    public final void gX(int i) {
        this.dFy.setColor(i);
    }

    public final void gY(int i) {
        this.dFz.setColor(i);
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        O((float) rect.width());
    }

    public void draw(@NonNull Canvas canvas) {
        canvas.save();
        canvas.clipRect(getBounds());
        canvas.drawCircle(this.dFs, this.dFt, this.cim, this.cij);
        for (int i = 0; i < this.dFv.length; i++) {
            canvas.save();
            this.dFw.set(this.dFv[i]);
            this.dFA.reset();
            this.dFA.addRoundRect(this.dFw, this.dFu, this.dFu, Direction.CW);
            canvas.clipPath(this.dFA);
            canvas.drawPaint(this.dFy);
            this.dFw.top = this.dFw.bottom - ((this.dFw.bottom - this.dFw.top) * this.dFx[i]);
            canvas.drawRect(this.dFw, this.dFz);
            canvas.restore();
        }
        canvas.restore();
    }

    public void setAlpha(int i) {
        this.cij.setAlpha(i);
        this.dFy.setAlpha(i);
        this.dFz.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.cij.setColorFilter(colorFilter);
        this.dFy.setColorFilter(colorFilter);
        this.dFz.setColorFilter(colorFilter);
    }

    private void resetProperties() {
        dFl.set(this, Float.valueOf(0.0f));
        dFm.set(this, Float.valueOf(0.0f));
        dFn.set(this, Float.valueOf(0.0f));
    }

    public final void aIV() {
        stop();
        this.animator = fo(true);
        this.animator.start();
    }

    public final void aIW() {
        stop();
        this.animator = fo(false);
        this.animator.start();
    }

    public final void stop() {
        if (this.animator != null) {
            this.animator.cancel();
        }
    }

    public final boolean isRunning() {
        return this.animator != null && this.animator.isRunning();
    }

    private Animator fo(final boolean z) {
        final Animator animatorSet = new AnimatorSet();
        List arrayList = new ArrayList();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, dFl, new float[]{0.0f, 1.0f});
        ofFloat.setInterpolator(d.dEM);
        arrayList.add(ofFloat);
        ofFloat = ObjectAnimator.ofFloat(this, dFm, new float[]{0.0f, 1.0f});
        ofFloat.setInterpolator(d.dEM);
        ofFloat.setStartDelay(100);
        arrayList.add(ofFloat);
        ofFloat = ObjectAnimator.ofFloat(this, dFn, new float[]{0.0f, 1.0f});
        ofFloat.setInterpolator(d.dEM);
        ofFloat.setStartDelay(100);
        arrayList.add(ofFloat);
        ofFloat = ObjectAnimator.ofInt(this, dFo, new int[]{0});
        ofFloat.setDuration(250);
        arrayList.add(ofFloat);
        animatorSet.playSequentially(arrayList);
        animatorSet.addListener(new AnimatorListenerAdapter() {
            private boolean dFB = z;

            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                this.dFB = false;
            }

            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (this.dFB) {
                    b.this.resetProperties();
                    animatorSet.start();
                }
            }
        });
        return animatorSet;
    }
}
