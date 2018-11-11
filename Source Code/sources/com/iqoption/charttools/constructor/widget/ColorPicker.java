package com.iqoption.charttools.constructor.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.iqoption.charttools.o.d;
import com.iqoption.core.ext.g;
import com.iqoption.core.graphics.animation.i;

public final class ColorPicker extends ViewGroup {
    private float avM = 0.0f;
    private a awa;
    private g awb;
    private Paint awc = new Paint();
    private float awd;
    private float awe;
    private float awf;
    private float awg;
    private final ValueAnimator awh = new ValueAnimator();
    private c awi;
    private b awj;

    public interface b {
        void dk(int i);
    }

    public interface c {
        void Lw();
    }

    private class a extends g implements a, a {
        private a() {
        }

        /* synthetic */ a(ColorPicker colorPicker, AnonymousClass1 anonymousClass1) {
            this();
        }

        public void dk(int i) {
            if (ColorPicker.this.awj != null) {
                ColorPicker.this.awj.dk(i);
                if ((i >>> 24) == 255) {
                    ColorPicker.this.awb.setSelected(i);
                } else {
                    ColorPicker.this.awb.setSelected(0);
                }
            }
        }

        public void dn(int i) {
            ColorPicker.this.awa.dm(i);
            ColorPicker.this.awb.setSelected(i);
        }

        public void q(View view) {
            if (ColorPicker.this.awi != null) {
                ColorPicker.this.awi.Lw();
            }
        }
    }

    public ColorPicker(Context context) {
        super(context);
        this.awh.setFloatValues(new float[]{1.0f, 0.0f});
        this.awh.setDuration(250);
        this.awh.setInterpolator(i.TI());
        this.awh.addUpdateListener(new b(this));
        this.awh.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                ColorPicker.this.awb.setVisibility(0);
            }

            public void onAnimationEnd(Animator animator) {
                if (ColorPicker.this.avM == 0.0f) {
                    ColorPicker.this.awb.setVisibility(4);
                }
            }
        });
        init();
    }

    public ColorPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.awh.setFloatValues(new float[]{1.0f, 0.0f});
        this.awh.setDuration(250);
        this.awh.setInterpolator(i.TI());
        this.awh.addUpdateListener(new c(this));
        this.awh.addListener(/* anonymous class already generated */);
        init();
    }

    public ColorPicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.awh.setFloatValues(new float[]{1.0f, 0.0f});
        this.awh.setDuration(250);
        this.awh.setInterpolator(i.TI());
        this.awh.addUpdateListener(new d(this));
        this.awh.addListener(/* anonymous class already generated */);
        init();
    }

    @TargetApi(21)
    public ColorPicker(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.awh.setFloatValues(new float[]{1.0f, 0.0f});
        this.awh.setDuration(250);
        this.awh.setInterpolator(i.TI());
        this.awh.addUpdateListener(new e(this));
        this.awh.addListener(/* anonymous class already generated */);
        init();
    }

    private void init() {
        a aVar = new a(this, null);
        int k = com.iqoption.core.ext.a.k(getContext(), d.dp42);
        int k2 = com.iqoption.core.ext.a.k(getContext(), d.dp136);
        this.awb = new g(getContext(), com.iqoption.charttools.model.indicator.i.ayf);
        this.awb.a((a) aVar);
        this.awb.setAlpha(this.avM);
        if (this.avM == 0.0f) {
            this.awb.setVisibility(4);
        }
        addView(this.awb);
        this.awa = new a(getContext(), k, k2);
        this.awa.setOnClickListener(aVar);
        this.awa.a(aVar);
        addView(this.awa);
        this.awc.setColor(-15262159);
        this.awd = com.iqoption.core.ext.a.j(getContext(), d.separator);
        this.awf = com.iqoption.core.ext.a.j(getContext(), d.dp10);
        this.awg = com.iqoption.core.ext.a.j(getContext(), d.dp11);
        setWillNotDraw(false);
    }

    private int getExpandedHeight() {
        int measuredHeight = this.awb.getMeasuredHeight();
        int lineHeight = this.awb.getLineHeight();
        return Math.round(((float) lineHeight) + (((float) (measuredHeight - lineHeight)) * this.avM));
    }

    protected void onMeasure(int i, int i2) {
        if (this.awb.getMeasuredWidth() == 0) {
            this.awb.measure(0, 0);
        }
        if (this.awa.getMeasuredWidth() == 0) {
            this.awa.measure(0, 0);
        }
        i = (this.awa.getMeasuredWidth() + this.awb.getMeasuredWidth()) + com.iqoption.core.ext.a.s((this.awf * 2.0f) + this.awd);
        i2 = getExpandedHeight();
        this.awe = ((float) i2) - (this.awg * 2.0f);
        setMeasuredDimension(i, i2);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = this.awb.getMeasuredWidth();
        this.awb.layout(0, 0, measuredWidth, i4);
        measuredWidth += com.iqoption.core.ext.a.s((this.awf * 2.0f) + this.awd);
        this.awa.layout(measuredWidth, 0, this.awa.getMeasuredWidth() + measuredWidth, this.awa.getMeasuredHeight());
        this.awa.o(this.avM);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.avM > 0.0f) {
            canvas.save();
            canvas.translate(((float) this.awb.getWidth()) + this.awf, this.awg);
            this.awc.setAlpha(com.iqoption.core.ext.a.s(this.avM * 255.0f));
            canvas.drawRect(0.0f, 0.0f, this.awd, this.awe, this.awc);
            canvas.restore();
        }
    }

    public void setOnColorChangeListener(b bVar) {
        this.awj = bVar;
    }

    public void setOnSliderClickListener(c cVar) {
        this.awi = cVar;
    }

    public void setColor(int i) {
        this.awa.h(i, false);
        this.awb.setSelected(i);
    }

    public void toggle() {
        if (this.avM == 0.0f) {
            this.awh.reverse();
        } else {
            this.awh.start();
        }
    }

    public void setExpanded(boolean z) {
        if (isExpanded() != z) {
            this.avM = z ? 1.0f : 0.0f;
            if (z) {
                this.awb.setAlpha(1.0f);
                this.awb.setVisibility(0);
            } else {
                this.awb.setAlpha(0.0f);
                this.awb.setVisibility(4);
            }
            requestLayout();
        }
    }

    public boolean isExpanded() {
        return this.avM == 1.0f;
    }

    public boolean LJ() {
        return this.awh.isRunning();
    }

    public boolean hasFocusable() {
        return super.hasFocusable();
    }
}
