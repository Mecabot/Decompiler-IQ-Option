package com.iqoption.view.scoreboard;

import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView.BufferType;
import com.iqoption.view.RobotoTextView;

public class ScoreBoard extends RobotoTextView {
    private float dDv;
    private float dDy = 1.0f;
    private float dDz = 0.0f;
    private Rect dEW = null;
    private Bitmap dIA = null;
    private int dIn = 0;
    private int dIo = 0;
    private Rect dIp = null;
    private int[] dIq = null;
    private ObjectAnimator dIr = null;
    private TypeEvaluator<int[]> dIs = null;
    private final String dIv = "0\n1\n2\n3\n4\n5\n6\n7\n8\n9";
    private TextPaint mTextPaint = null;

    public ScoreBoard(Context context) {
        super(context);
        initResource();
    }

    public ScoreBoard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initResource();
    }

    public ScoreBoard(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
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
        this.dIn = (int) (this.mTextPaint.descent() - this.mTextPaint.ascent());
        this.dIo = (int) StaticLayout.getDesiredWidth("0", this.mTextPaint);
        this.dIA = Bitmap.createBitmap(this.dIo, this.dIn * 10, Config.ARGB_8888);
        Canvas canvas = new Canvas(this.dIA);
        int i = this.dIn;
        int i2 = i;
        for (String drawText : "0\n1\n2\n3\n4\n5\n6\n7\n8\n9".split("\n")) {
            canvas.drawText(drawText, 0.0f, ((float) i2) - (this.mTextPaint.descent() / 2.0f), this.mTextPaint);
            i2 += this.dIn;
        }
        this.dEW = new Rect(0, 0, this.dIo, this.dIn);
        this.dIp = new Rect(0, 0, this.dIo, this.dIn);
        this.dIr = new ObjectAnimator();
        this.dIr.setTarget(this);
        this.dIr.setPropertyName("offset");
        this.dIs = new TypeEvaluator<int[]>() {
            public int[] evaluate(float f, int[] iArr, int[] iArr2) {
                int[] iArr3 = new int[iArr2.length];
                int length = iArr2.length - 1;
                while (length >= 0) {
                    int a = iArr.length >= length + 1 ? iArr[length] : ScoreBoard.this.dIn * -1;
                    iArr3[length] = a + ((int) (((float) (iArr2[length] - a)) * f));
                    length--;
                }
                return iArr3;
            }
        };
    }

    protected void onDraw(Canvas canvas) {
        try {
            if (this.dDv != getTextSize() || this.dIA == null) {
                initResource();
            }
            if (this.dIA == null) {
                throw new NumberFormatException();
            } else if (TextUtils.isEmpty(getText())) {
                throw new NumberFormatException();
            } else {
                if (this.dIq == null) {
                    kd(getText().toString());
                }
                for (int i = 0; i < this.dIq.length; i++) {
                    this.dEW.top = this.dIq[i];
                    this.dEW.bottom = this.dEW.top + this.dIn;
                    this.dIp.left = this.dIo * i;
                    this.dIp.right = this.dIp.left + this.dIo;
                    canvas.drawBitmap(this.dIA, this.dEW, this.dIp, null);
                }
            }
        } catch (NumberFormatException unused) {
            super.onDraw(canvas);
        }
    }

    private void kd(String str) {
        int parseInt = Integer.parseInt(str);
        if (this.dIq == null || this.dIq.length != str.length()) {
            this.dIq = new int[str.length()];
        }
        for (int length = this.dIq.length - 1; length >= 0; length--) {
            this.dIq[length] = (parseInt % 10) * this.dIn;
            parseInt /= 10;
        }
    }

    public void setText(CharSequence charSequence, BufferType bufferType) {
        super.setText(charSequence, bufferType);
        if (this.dIr == null || !(this.dIr.isRunning() || this.dIr.isStarted())) {
            try {
                kd(charSequence.toString());
                invalidate();
            } catch (Exception unused) {
            }
        }
    }
}
