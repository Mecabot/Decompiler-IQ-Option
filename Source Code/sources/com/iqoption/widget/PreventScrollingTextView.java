package com.iqoption.widget;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

public class PreventScrollingTextView extends AppCompatTextView {
    public void scrollBy(int i, int i2) {
    }

    public void scrollTo(int i, int i2) {
    }

    public PreventScrollingTextView(Context context) {
        super(context);
    }

    public PreventScrollingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PreventScrollingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
