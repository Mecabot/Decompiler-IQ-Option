package com.iqoption.view;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.util.AttributeSet;
import java.lang.ref.WeakReference;
import java.util.Locale;

public class NumberAnimateRobotoTextView extends RobotoTextView {
    private ValueAnimator awh;
    private int dCF = 0;
    private double dCG = 0.0d;
    private a dCH;
    private b dCI;

    private static class a implements AnimatorUpdateListener {
        private final WeakReference<NumberAnimateRobotoTextView> dCJ;
        private String mask;

        public a(NumberAnimateRobotoTextView numberAnimateRobotoTextView) {
            this.dCJ = new WeakReference(numberAnimateRobotoTextView);
        }

        public void setMask(String str) {
            this.mask = str;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            NumberAnimateRobotoTextView numberAnimateRobotoTextView = (NumberAnimateRobotoTextView) this.dCJ.get();
            if (numberAnimateRobotoTextView == null) {
                return;
            }
            if (this.mask != null) {
                numberAnimateRobotoTextView.setText(String.format(Locale.US, this.mask, new Object[]{valueAnimator.getAnimatedValue()}));
                return;
            }
            numberAnimateRobotoTextView.setText(String.valueOf(valueAnimator.getAnimatedValue()));
        }
    }

    private static class b implements TypeEvaluator<Double> {
        private b() {
        }

        /* renamed from: a */
        public Double evaluate(float f, Double d, Double d2) {
            return Double.valueOf(d.doubleValue() + (((double) f) * (d2.doubleValue() - d.doubleValue())));
        }
    }

    public NumberAnimateRobotoTextView(Context context) {
        super(context);
    }

    public NumberAnimateRobotoTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NumberAnimateRobotoTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setValue(int i) {
        S(null, i);
    }

    public void setValue(double d) {
        f(null, d);
    }

    public void S(String str, int i) {
        if (this.dCF != i) {
            if (this.awh != null) {
                this.awh.cancel();
            }
            this.awh = ValueAnimator.ofInt(new int[]{this.dCF, i});
            this.awh.setDuration(200);
            if (this.dCH == null) {
                this.dCH = new a(this);
            }
            this.dCH.setMask(str);
            this.awh.addUpdateListener(this.dCH);
            this.awh.start();
            this.dCF = i;
        }
    }

    public void f(String str, double d) {
        if (this.dCG != d) {
            if (this.awh != null) {
                this.awh.cancel();
            }
            if (this.dCI == null) {
                this.dCI = new b();
            }
            this.awh = ValueAnimator.ofObject(this.dCI, new Object[]{Double.valueOf(this.dCG), Double.valueOf(d)});
            this.awh.setDuration(200);
            if (this.dCH == null) {
                this.dCH = new a(this);
            }
            this.dCH.setMask(str);
            this.awh.addUpdateListener(this.dCH);
            this.awh.start();
            this.dCG = d;
        }
    }

    public void clear() {
        if (this.awh != null) {
            this.awh.cancel();
            this.awh = null;
        }
        this.dCG = 0.0d;
        this.dCF = 0;
        this.dCI = null;
        setText("");
    }
}
