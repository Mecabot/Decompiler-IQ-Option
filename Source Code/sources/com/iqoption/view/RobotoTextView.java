package com.iqoption.view;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;

public class RobotoTextView extends AppCompatTextView {
    private a dDB;
    private int dDs;
    private boolean dDt = false;
    private float dDu;
    private float dDv;
    private float dDw = 0.0f;
    private float dDx = 4.0f;

    public interface a {
        void a(TextView textView, float f, float f2);
    }

    public RobotoTextView(Context context) {
        super(context);
        setCustomFont(null);
        init();
    }

    public RobotoTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setCustomFont(attributeSet);
        init();
    }

    public RobotoTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setCustomFont(attributeSet);
        init();
    }

    private void init() {
        this.dDv = getTextSize();
        this.dDu = this.dDv;
        this.dDx = (float) ((int) (((double) this.dDv) * 0.5d));
        if (this.dDs == 0) {
            this.dDs = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
    }

    public void reinit() {
        init();
    }

    private void setCustomFont(AttributeSet attributeSet) {
        k.a(this, attributeSet);
    }

    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.dDt = true;
        aIC();
    }

    public void setOnResizeListener(a aVar) {
        this.dDB = aVar;
    }

    public void setMaxLines(int i) {
        super.setMaxLines(i);
        this.dDs = i;
    }

    public void setSingleLine() {
        super.setSingleLine();
        this.dDs = 1;
    }

    public void setSingleLine(boolean z) {
        super.setSingleLine(z);
        if (z) {
            this.dDs = 1;
        } else {
            this.dDs = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
    }

    public void setLines(int i) {
        super.setLines(i);
        this.dDs = i;
    }

    public void setTextSize(float f) {
        super.setTextSize(f);
        this.dDv = getTextSize();
    }

    public void setTextSize(int i, float f) {
        super.setTextSize(i, f);
        this.dDv = getTextSize();
        this.dDu = getTextSize();
    }

    public void setMaxTextSize(float f) {
        this.dDw = f;
        requestLayout();
        invalidate();
    }

    public float getMaxTextSize() {
        return this.dDw;
    }

    public void setMinTextSize(float f) {
        this.dDx = f;
        requestLayout();
        invalidate();
    }

    public float getMinTextSize() {
        return this.dDx;
    }

    private void aIC() {
        if (this.dDu > 0.0f && this.dDv > 0.0f) {
            setTextSize(0, this.dDu);
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (!(i == i3 && i2 == i4) && this.dDv == this.dDu) {
            this.dDt = true;
        }
        if (this.dDv != this.dDu) {
            aIC();
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z || this.dDt) {
            aC(((i3 - i) - getCompoundPaddingLeft()) - getCompoundPaddingRight(), ((i4 - i2) - getCompoundPaddingBottom()) - getCompoundPaddingTop());
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public void aC(int i, int i2) {
        CharSequence text = getText();
        if (text != null && text.length() != 0 && i2 > 0 && i > 0 && this.dDv != 0.0f) {
            if (getTransformationMethod() != null) {
                text = getTransformationMethod().getTransformation(text, this);
            }
            TextPaint paint = getPaint();
            float textSize = paint.getTextSize();
            float min = this.dDw > 0.0f ? Math.min(this.dDv, this.dDw) : this.dDv;
            int[] a = a(text, paint, i, min);
            while (true) {
                if ((a[0] > i2 || a[1] > this.dDs) && min > this.dDx) {
                    min = Math.max(min - 2.0f, this.dDx);
                    a = a(text, paint, i, min);
                }
            }
            setTextSize(0, min);
            if (this.dDB != null) {
                this.dDB.a(this, textSize, min);
            }
            this.dDt = false;
        }
    }

    private int[] a(CharSequence charSequence, TextPaint textPaint, int i, float f) {
        TextPaint textPaint2 = new TextPaint(textPaint);
        textPaint2.setTextSize(f);
        StaticLayout staticLayout = new StaticLayout(charSequence, textPaint2, i, Alignment.ALIGN_NORMAL, getLineSpacingMultiplier(), getLineSpacingExtra(), getIncludeFontPadding());
        return new int[]{staticLayout.getHeight(), staticLayout.getLineCount()};
    }
}
