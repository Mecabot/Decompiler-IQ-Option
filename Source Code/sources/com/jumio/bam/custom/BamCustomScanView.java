package com.jumio.bam.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.jumio.bam.R;
import com.jumio.sdk.custom.JumioCustomScanView;

public final class BamCustomScanView extends JumioCustomScanView {
    public BamCustomScanView(Context context) {
        super(context);
    }

    public BamCustomScanView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BamCustomScanView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BamCustomScanView, 0, 0);
        try {
            this.ratio = obtainStyledAttributes.getFloat(R.styleable.BamCustomScanView_jumio_ratio, 0.0f);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
