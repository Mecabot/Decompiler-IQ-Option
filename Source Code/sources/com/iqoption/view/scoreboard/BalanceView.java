package com.iqoption.view.scoreboard;

import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.AppCompatTextView;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView.BufferType;

public class BalanceView extends AppCompatTextView {
    private float dDv;
    private float dDy;
    private float dDz;
    private Rect dEW;
    private final String[] dIl;
    private int dIm;
    private int dIn;
    private int dIo;
    private Rect dIp;
    private int[] dIq;
    private ObjectAnimator dIr;
    private TypeEvaluator<int[]> dIs;
    private int dIt;
    private TextPaint mTextPaint;

    public BalanceView(Context context) {
        super(context);
        this.dIl = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        this.dIm = 0;
        this.dIn = 0;
        this.dIo = 0;
        this.dEW = null;
        this.dIp = null;
        this.mTextPaint = null;
        this.dDy = 1.0f;
        this.dDz = 0.0f;
        this.dIq = null;
        this.dIr = null;
        this.dIs = null;
        initResource();
    }

    public BalanceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dIl = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        this.dIm = 0;
        this.dIn = 0;
        this.dIo = 0;
        this.dEW = null;
        this.dIp = null;
        this.mTextPaint = null;
        this.dDy = 1.0f;
        this.dDz = 0.0f;
        this.dIq = null;
        this.dIr = null;
        this.dIs = null;
        initResource();
    }

    public BalanceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dIl = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        this.dIm = 0;
        this.dIn = 0;
        this.dIo = 0;
        this.dEW = null;
        this.dIp = null;
        this.mTextPaint = null;
        this.dDy = 1.0f;
        this.dDz = 0.0f;
        this.dIq = null;
        this.dIr = null;
        this.dIs = null;
        initResource();
    }

    public void setLineSpacing(float f, float f2) {
        super.setLineSpacing(f, f2);
        this.dDy = f2;
        this.dDz = f;
    }

    public int[] getOffset() {
        return this.dIq;
    }

    public void setOffset(int[] iArr) {
        this.dIq = iArr;
        invalidate();
    }

    private void initResource() {
        this.dDv = getTextSize();
        this.mTextPaint = new TextPaint(getPaint());
        this.mTextPaint.setColor(getCurrentTextColor());
        this.dIm = (int) StaticLayout.getDesiredWidth(".", this.mTextPaint);
        this.dIn = (int) (this.mTextPaint.descent() - this.mTextPaint.ascent());
        this.dIo = (int) StaticLayout.getDesiredWidth("0", this.mTextPaint);
        this.dEW = new Rect(0, 0, this.dIo, this.dIn);
        this.dIp = new Rect(0, 0, this.dIo, this.dIn);
        if (this.dIr == null) {
            this.dIr = new ObjectAnimator();
            this.dIr.setTarget(this);
            this.dIr.setPropertyName("offset");
        }
        if (this.dIs == null) {
            this.dIs = new TypeEvaluator<int[]>() {
                public int[] evaluate(float f, int[] iArr, int[] iArr2) {
                    if (iArr == null || iArr2 == null) {
                        return null;
                    }
                    int[] iArr3;
                    try {
                        iArr3 = new int[iArr2.length];
                        try {
                            int length = iArr2.length - 1;
                            while (length >= 0) {
                                int a = iArr.length >= length + 1 ? iArr[length] : BalanceView.this.dIn * -1;
                                iArr3[length] = a + ((int) (((float) (iArr2[length] - a)) * f));
                                length--;
                            }
                        } catch (Exception unused) {
                            return iArr3;
                        }
                    } catch (Exception unused2) {
                        iArr3 = null;
                    }
                }
            };
        }
    }

    protected void onDraw(Canvas canvas) {
        try {
            if (this.dDv != getTextSize()) {
                initResource();
            }
            if (TextUtils.isEmpty(getText())) {
                throw new NumberFormatException();
            }
            if (this.dIq == null) {
                kd(getText().toString());
            }
            int length = this.dIq.length;
            float descent = this.mTextPaint.descent();
            this.mTextPaint.setColor(getCurrentTextColor());
            int i = 0;
            while (i < length) {
                int i2 = (i < this.dIt || this.dIt <= 0) ? 0 : this.dIm;
                if (i == this.dIt) {
                    canvas.drawText(".", (float) (this.dIo * i), ((float) this.dIn) - descent, this.mTextPaint);
                }
                this.dEW.top = this.dIq[i];
                this.dEW.bottom = this.dEW.top + this.dIn;
                this.dIp.left = i2 + (this.dIo * i);
                this.dIp.right = this.dIp.left + this.dIo;
                i2 = this.dIn;
                int i3 = i2;
                for (String drawText : this.dIl) {
                    canvas.drawText(drawText, (float) this.dIp.left, (((float) i3) - descent) - ((float) this.dEW.top), this.mTextPaint);
                    i3 += this.dIn;
                }
                i++;
            }
        } catch (Exception unused) {
            super.onDraw(canvas);
        }
    }

    private void kd(String str) {
        char[] toCharArray = str.toCharArray();
        if (this.dIq == null || this.dIq.length != toCharArray.length) {
            this.dIq = new int[toCharArray.length];
        }
        for (int length = toCharArray.length - 1; length >= 0; length--) {
            this.dIq[length] = Character.getNumericValue(toCharArray[length]) * this.dIn;
        }
    }

    private int[] ke(String str) {
        char[] toCharArray = str.toCharArray();
        int[] iArr = new int[toCharArray.length];
        for (int length = toCharArray.length - 1; length >= 0; length--) {
            iArr[length] = Character.getNumericValue(toCharArray[length]) * this.dIn;
        }
        return iArr;
    }

    public void setText(CharSequence charSequence, BufferType bufferType) {
        super.setText(charSequence, bufferType);
        if (this.dIr == null || !(this.dIr.isRunning() || this.dIr.isStarted())) {
            try {
                kd(kf(charSequence.toString()));
                invalidate();
            } catch (Exception unused) {
            }
        }
    }

    public void setTextColor(int i) {
        super.setTextColor(i);
    }

    private int indexOf(String str) {
        int indexOf = str.indexOf(".");
        return indexOf == -1 ? str.indexOf(",") : indexOf;
    }

    private String kf(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        this.dIt = indexOf(str);
        if (this.dIt > -1) {
            str = str.replace(".", "").replace(",", "");
        }
        return str;
    }

    public void kg(String str) {
        try {
            String kf = kf(str);
            if (this.dIq == null) {
                kd(kf);
            }
        } catch (Exception unused) {
            invalidate();
            setText(str);
        } catch (Throwable th) {
            invalidate();
        }
    }

    public void c(String str, int i, int i2) {
        try {
            String kf = kf(str);
            if (this.dIq == null) {
                kd(kf);
            }
            int[] ke = ke(kf);
            this.dIr.setObjectValues(new Object[]{ke});
            this.dIr.setEvaluator(this.dIs);
            this.dIr.setStartDelay((long) i);
            this.dIr.setDuration((long) i2);
            this.dIr.start();
        } catch (Exception unused) {
            invalidate();
        }
        setText(str);
    }
}
