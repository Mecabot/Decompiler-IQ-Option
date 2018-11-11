package com.iqoption.view;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import java.lang.ref.WeakReference;
import java.util.Locale;

public class NumberAnimateTextView extends AppCompatTextView {
    private ValueAnimator awh;
    private int dCF = 0;
    private double dCG = 0.0d;
    private a dCK;
    private b dCL;

    private static class a implements AnimatorUpdateListener {
        private final WeakReference<NumberAnimateTextView> dCJ;
        private String mask;

        public a(NumberAnimateTextView numberAnimateTextView) {
            this.dCJ = new WeakReference(numberAnimateTextView);
        }

        public void setMask(String str) {
            this.mask = str;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            NumberAnimateTextView numberAnimateTextView = (NumberAnimateTextView) this.dCJ.get();
            if (numberAnimateTextView == null) {
                return;
            }
            if (this.mask != null) {
                numberAnimateTextView.setText(String.format(Locale.US, this.mask, new Object[]{valueAnimator.getAnimatedValue()}));
                return;
            }
            numberAnimateTextView.setText(String.valueOf(valueAnimator.getAnimatedValue()));
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

    public NumberAnimateTextView(Context context) {
        super(context);
    }

    public NumberAnimateTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NumberAnimateTextView(Context context, AttributeSet attributeSet, int i) {
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
            if (this.dCK == null) {
                this.dCK = new a(this);
            }
            this.dCK.setMask(str);
            this.awh.addUpdateListener(this.dCK);
            this.awh.start();
            this.dCF = i;
        }
    }

    public void f(String str, double d) {
        if (this.dCG != d) {
            if (this.awh != null) {
                this.awh.cancel();
            }
            if (this.dCL == null) {
                this.dCL = new b();
            }
            this.awh = ValueAnimator.ofObject(this.dCL, new Object[]{Double.valueOf(this.dCG), Double.valueOf(d)});
            this.awh.setDuration(200);
            if (this.dCK == null) {
                this.dCK = new a(this);
            }
            this.dCK.setMask(str);
            this.awh.addUpdateListener(this.dCK);
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
        this.dCL = null;
        setText("");
    }
}
