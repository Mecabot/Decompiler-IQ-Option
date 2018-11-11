package com.iqoption.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint.FontMetrics;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.iqoption.util.au;
import com.iqoption.util.ax;
import com.iqoption.x.R;
import java.util.Arrays;
import java.util.LinkedList;

public final class CounterView extends View {
    private final TextPaint dNP;
    private final TextPaint dNQ;
    private final TextPaint dNR;
    private d dNS;
    private boolean dNT;
    private ColorStateList dNU;
    private int dNV;
    private LinkedList<a> dNW;
    private AnimatorUpdateListener dNX;
    private AnimatorListener dNY;
    private final b dNZ;
    private final c dOa;
    private final c dOb;
    private float dOc;

    private static class a implements TypeEvaluator<Float> {
        private final float aHN;
        private float cwk;
        private final b dOf;
        private final float[] dOg;
        private final float[] dOh;
        private final float[] dOi;
        private final float dOj;
        private final float dOk;
        private final float[] dOl;
        private final float dOm;
        private final int dOn;
        private final int offset;

        /* synthetic */ a(b bVar, int i, int[] iArr, int[] iArr2, AnonymousClass1 anonymousClass1) {
            this(bVar, i, iArr, iArr2);
        }

        private a(b bVar, int i, int[] iArr, int[] iArr2) {
            this.dOf = bVar;
            int max = Math.max(iArr.length, iArr2.length);
            this.dOg = new float[max];
            this.dOh = new float[max];
            this.offset = iArr2.length - iArr.length;
            int abs = Math.abs(this.offset);
            if (this.offset > 0) {
                abs = 0;
                while (abs < max) {
                    this.dOg[abs] = (float) (abs < this.offset ? iArr2[abs] : iArr[abs - this.offset]);
                    this.dOh[abs] = (float) iArr2[abs];
                    abs++;
                }
                this.dOj = 0.0f;
                this.dOk = 1.0f;
                this.dOm = (-bVar.dOp) * ((float) this.offset);
                this.aHN = 0.0f;
                this.dOn = i;
            } else if (this.offset < 0) {
                int i2 = 0;
                while (i2 < max) {
                    this.dOg[i2] = (float) iArr[i2];
                    this.dOh[i2] = (float) (i2 < abs ? iArr[i2] : iArr2[i2 - abs]);
                    i2++;
                }
                this.dOj = 1.0f;
                this.dOk = 0.0f;
                this.dOm = 0.0f;
                this.aHN = bVar.dOp * ((float) this.offset);
                this.dOn = i + abs;
            } else {
                for (int i3 = 0; i3 < max; i3++) {
                    this.dOg[i3] = (float) iArr[i3];
                    this.dOh[i3] = (float) iArr2[i3];
                }
                this.dOj = 1.0f;
                this.dOk = 1.0f;
                this.dOm = 0.0f;
                this.aHN = 0.0f;
                this.dOn = i;
            }
            this.dOi = new float[max];
            System.arraycopy(this.dOg, 0, this.dOi, 0, max);
            this.dOl = new float[max];
            Arrays.fill(this.dOl, 1.0f);
        }

        /* renamed from: a */
        public Float evaluate(float f, Float f2, Float f3) {
            int i;
            int length = this.dOi.length;
            for (i = 0; i < length; i++) {
                float f4 = this.dOg[i];
                this.dOi[i] = f4 + ((this.dOh[i] - f4) * f);
            }
            this.cwk = this.dOm + ((this.aHN - this.dOm) * f);
            float abs = Math.abs(this.cwk);
            int i2;
            if (this.offset > 0) {
                for (i2 = this.offset - 1; i2 >= 0; i2--) {
                    i = (this.offset - 1) - i2;
                    this.dOl[i2] = this.dOj + ((this.dOk - this.dOj) * au.e((((float) this.offset) * this.dOf.dOp) - abs, (((float) i) + 0.75f) * this.dOf.dOp, ((float) (i + 1)) * this.dOf.dOp));
                }
            } else if (this.offset < 0) {
                for (i2 = 0; i2 < (-this.offset); i2++) {
                    float f5 = (float) i2;
                    this.dOl[i2] = this.dOj + ((this.dOk - this.dOj) * au.e(abs, this.dOf.dOp * f5, (f5 + 0.25f) * this.dOf.dOp));
                }
            }
            return Float.valueOf(f);
        }
    }

    private static class c extends FontMetrics {
        float height;
        float width;

        private c() {
        }

        /* synthetic */ c(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    private static class d {
        final int dOn;
        final String dOq;
        final String dOr;
        final String dOs;
        final int[] dOt;
        final String value;

        d() {
            this("");
        }

        d(String str) {
            this.value = str;
            int length = str.length();
            int i = 0;
            int i2 = 0;
            while (i2 < length && !Character.isDigit(str.charAt(i2))) {
                i2++;
            }
            if (i2 == 0) {
                this.dOr = null;
            } else {
                this.dOr = str.substring(0, i2);
            }
            if (i2 == length) {
                this.dOs = null;
                this.dOq = "";
            } else {
                int i3;
                int i4 = length - 1;
                if (length > 0) {
                    i3 = i4;
                    while (i3 >= 0 && !Character.isDigit(str.charAt(i3))) {
                        i3--;
                    }
                } else {
                    i3 = i4;
                }
                if (i3 == i4) {
                    this.dOs = null;
                } else {
                    this.dOs = str.substring(i3 + 1, length);
                }
                this.dOq = str.substring(i2, Math.max(Math.min(i3 + 1, length), i2));
            }
            length = this.dOq.length();
            this.dOn = this.dOq.indexOf(46);
            this.dOt = new int[(this.dOn == -1 ? length : Math.max(length - 1, 0))];
            i2 = 0;
            Object obj = null;
            while (i < length) {
                char charAt = this.dOq.charAt(i);
                if (Character.isDigit(charAt)) {
                    this.dOt[i2] = Character.getNumericValue(charAt);
                } else if (obj == null && charAt == '.') {
                    i2--;
                    obj = 1;
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Wrong value: ");
                    stringBuilder.append(str);
                    stringBuilder.append(", digit value: ");
                    stringBuilder.append(this.dOq);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
                i2++;
                i++;
            }
        }
    }

    private static class b extends c {
        float dOo;
        float dOp;

        private b() {
            super();
        }

        /* synthetic */ b(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    final /* synthetic */ void d(ValueAnimator valueAnimator) {
        invalidate();
    }

    public CounterView(Context context) {
        this(context, null);
    }

    public CounterView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CounterView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dNP = new TextPaint(1);
        this.dNQ = new TextPaint(1);
        this.dNR = new TextPaint(1);
        this.dNS = new d();
        this.dNW = new LinkedList();
        this.dNX = new a(this);
        this.dNY = new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                CounterView.this.dNW.removeFirst();
                if (!CounterView.this.dNW.isEmpty()) {
                    CounterView.this.a((a) CounterView.this.dNW.getFirst());
                }
            }
        };
        this.dNZ = new b();
        this.dOa = new c();
        this.dOb = new c();
        init(context, attributeSet);
    }

    @TargetApi(21)
    public CounterView(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.dNP = new TextPaint(1);
        this.dNQ = new TextPaint(1);
        this.dNR = new TextPaint(1);
        this.dNS = new d();
        this.dNW = new LinkedList();
        this.dNX = new b(this);
        this.dNY = /* anonymous class already generated */;
        this.dNZ = new b();
        this.dOa = new c();
        this.dOb = new c();
        init(context, attributeSet);
    }

    private void init(@NonNull Context context, AttributeSet attributeSet) {
        float f = getResources().getDisplayMetrics().density * 20.0f;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.iqoption.b.b.CounterView);
            try {
                setDigitSize(obtainStyledAttributes.getDimension(5, f));
                setDigitColor(obtainStyledAttributes.getColor(3, ViewCompat.MEASURED_STATE_MASK));
                if (ax.dwu) {
                    setDigitFont(obtainStyledAttributes.getFont(4));
                } else {
                    setDigitFont(ResourcesCompat.getFont(getContext(), obtainStyledAttributes.getResourceId(4, R.font.regular)));
                }
                setDecorSize(obtainStyledAttributes.getDimension(2, f));
                setDecorColor(obtainStyledAttributes.getColor(0, ViewCompat.MEASURED_STATE_MASK));
                if (ax.dwu) {
                    setDecorFont(obtainStyledAttributes.getFont(1));
                } else {
                    setDecorFont(ResourcesCompat.getFont(getContext(), obtainStyledAttributes.getResourceId(1, R.font.regular)));
                }
                setDisableAnimations(obtainStyledAttributes.getBoolean(6, false));
                String string = obtainStyledAttributes.getString(7);
                if (string != null) {
                    setValue(string);
                }
                obtainStyledAttributes.recycle();
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
            }
        } else {
            setDigitSize(f);
            setDigitColor(ViewCompat.MEASURED_STATE_MASK);
        }
    }

    public void setValue(@NonNull String str) {
        if (!str.equals(this.dNS.value)) {
            d dVar = this.dNS;
            this.dNS = new d(str);
            if (!(TextUtils.equals(this.dNS.dOr, dVar.dOr) && TextUtils.equals(this.dNS.dOs, dVar.dOs) && this.dNS.dOq.length() == dVar.dOq.length())) {
                requestLayout();
            }
            if (this.dNT) {
                invalidate();
            } else {
                a aVar = new a(this.dNZ, this.dNS.dOn, dVar.dOt, this.dNS.dOt, null);
                this.dNW.add(aVar);
                if (this.dNW.size() == 1) {
                    a(aVar);
                }
            }
        }
    }

    @NonNull
    public String getValue() {
        return this.dNS.value;
    }

    @NonNull
    public String getDigitValue() {
        return this.dNS.dOq;
    }

    private void a(@NonNull a aVar) {
        ValueAnimator ofObject = ValueAnimator.ofObject(aVar, new Object[]{Float.valueOf(0.0f), Float.valueOf(1.0f)});
        ofObject.addUpdateListener(this.dNX);
        ofObject.addListener(this.dNY);
        ofObject.setInterpolator(new FastOutSlowInInterpolator());
        ofObject.setDuration(400);
        ofObject.start();
    }

    public void setTextColor(ColorStateList colorStateList) {
        if (colorStateList == null) {
            throw new NullPointerException();
        }
        this.dNU = colorStateList;
        aMF();
    }

    private void aMF() {
        int i = 0;
        int colorForState = this.dNU.getColorForState(getDrawableState(), 0);
        if (colorForState != this.dNV) {
            this.dNV = colorForState;
            i = 1;
        }
        if (i != 0) {
            setColor(this.dNV);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.dNU != null && this.dNU.isStateful()) {
            aMF();
        }
    }

    public void setColor(int i) {
        this.dNP.setColor(i);
        this.dNQ.setColor(i);
        this.dNR.setColor(i);
        invalidate();
    }

    public void setDigitSize(float f) {
        this.dNP.setTextSize(f);
        requestLayout();
    }

    public void setDigitColor(int i) {
        this.dNP.setColor(i);
        invalidate();
    }

    public void setDigitFont(Typeface typeface) {
        this.dNP.setTypeface(typeface);
        requestLayout();
    }

    public void setLeftDecorSize(float f) {
        this.dNQ.setTextSize(f);
        if (!TextUtils.isEmpty(this.dNS.dOr)) {
            requestLayout();
        }
    }

    public void setLeftDecorColor(int i) {
        this.dNQ.setColor(i);
        if (!TextUtils.isEmpty(this.dNS.dOr)) {
            invalidate();
        }
    }

    public void setLeftDecorFont(Typeface typeface) {
        this.dNQ.setTypeface(typeface);
        if (!TextUtils.isEmpty(this.dNS.dOr)) {
            requestLayout();
        }
    }

    public void setRightDecorSize(float f) {
        this.dNR.setTextSize(f);
        if (!TextUtils.isEmpty(this.dNS.dOs)) {
            requestLayout();
        }
    }

    public void setRightDecorColor(int i) {
        this.dNR.setColor(i);
        if (!TextUtils.isEmpty(this.dNS.dOs)) {
            invalidate();
        }
    }

    public void setRightDecorFont(Typeface typeface) {
        this.dNR.setTypeface(typeface);
        if (!TextUtils.isEmpty(this.dNS.dOs)) {
            requestLayout();
        }
    }

    public void setDecorSize(float f) {
        setLeftDecorSize(f);
        setRightDecorSize(f);
    }

    public void setDecorColor(int i) {
        setLeftDecorColor(i);
        setRightDecorColor(i);
    }

    public void setDecorFont(Typeface typeface) {
        setLeftDecorFont(typeface);
        setRightDecorFont(typeface);
    }

    public void setDisableAnimations(boolean z) {
        this.dNT = z;
    }

    public int getBaseline() {
        return (int) (-this.dNZ.ascent);
    }

    protected void onMeasure(int i, int i2) {
        Object obj = this.dNS.dOq;
        this.dNP.getFontMetrics(this.dNZ);
        if (!TextUtils.isEmpty(obj)) {
            this.dNZ.width = this.dNP.measureText(obj);
            this.dNZ.height = this.dNZ.descent - this.dNZ.ascent;
        }
        this.dNZ.dOo = this.dNP.measureText(".");
        this.dNZ.dOp = this.dNP.measureText("0");
        obj = this.dNS.dOr;
        this.dNQ.getFontMetrics(this.dOa);
        if (!TextUtils.isEmpty(obj)) {
            this.dOa.width = this.dNQ.measureText(obj);
            this.dOa.height = this.dOa.descent - this.dOa.ascent;
        }
        obj = this.dNS.dOs;
        this.dNR.getFontMetrics(this.dOb);
        if (!TextUtils.isEmpty(obj)) {
            this.dOb.width = this.dNR.measureText(obj);
            this.dOb.height = this.dOb.descent - this.dOb.ascent;
        }
        int mode = MeasureSpec.getMode(i);
        if (mode == 1073741824) {
            i = MeasureSpec.getSize(i);
        } else {
            int paddingStart = (((int) ((this.dNZ.width + this.dOa.width) + this.dOb.width)) + ViewCompat.getPaddingStart(this)) + ViewCompat.getPaddingEnd(this);
            i = mode == Integer.MIN_VALUE ? Math.min(paddingStart, MeasureSpec.getSize(i)) : paddingStart;
        }
        if (MeasureSpec.getMode(i2) == 1073741824) {
            i2 = MeasureSpec.getSize(i2);
        } else {
            c cVar;
            if (this.dNZ.height > this.dOa.height) {
                if (this.dNZ.height > this.dOb.height) {
                    cVar = this.dNZ;
                } else {
                    cVar = this.dOb;
                }
            } else if (this.dOa.height > this.dOb.height) {
                cVar = this.dOa;
            } else {
                cVar = this.dOb;
            }
            int paddingTop = (((int) cVar.height) + getPaddingTop()) + getPaddingBottom();
            this.dOc = -cVar.ascent;
            i2 = i2 == Integer.MIN_VALUE ? Math.min(paddingTop, MeasureSpec.getSize(i2)) : paddingTop;
        }
        setMeasuredDimension(i, i2);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.translate((float) ViewCompat.getPaddingStart(this), (float) getPaddingTop());
        if (this.dNS.dOr != null) {
            canvas.drawText(this.dNS.dOr, 0.0f, this.dOc, this.dNQ);
            canvas.translate(this.dOa.width, 0.0f);
        }
        if (this.dNW.isEmpty()) {
            canvas.drawText(this.dNS.dOq, 0.0f, this.dOc, this.dNP);
            canvas.translate(this.dNZ.width, 0.0f);
        } else {
            a aVar = (a) this.dNW.getFirst();
            canvas.translate(aVar.cwk, 0.0f);
            float[] c = aVar.dOi;
            int d = aVar.dOn;
            for (int i = 0; i < c.length; i++) {
                if (d == i) {
                    this.dNP.setAlpha(255);
                    canvas.drawText(".", 0.0f, this.dOc, this.dNP);
                    canvas.translate(this.dNZ.dOo, 0.0f);
                }
                this.dNP.setAlpha((int) (aVar.dOl[i] * 255.0f));
                float f = c[i];
                int i2 = (int) f;
                f = (f - ((float) i2)) * this.dOc;
                if (f != 0.0f) {
                    canvas.drawText(String.valueOf(i2 + 1), 0.0f, f, this.dNP);
                }
                canvas.drawText(String.valueOf(i2), 0.0f, this.dOc + f, this.dNP);
                canvas.translate(this.dNZ.dOp, 0.0f);
            }
        }
        if (this.dNS.dOs != null) {
            canvas.drawText(this.dNS.dOs, 0.0f, this.dOc, this.dNR);
        }
        canvas.restore();
    }
}
