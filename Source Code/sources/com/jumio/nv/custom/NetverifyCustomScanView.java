package com.jumio.nv.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.jumio.nv.R;
import com.jumio.sdk.custom.JumioCustomScanView;

public final class NetverifyCustomScanView extends JumioCustomScanView {
    public NetverifyCustomScanView(Context context) {
        super(context);
    }

    public NetverifyCustomScanView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NetverifyCustomScanView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.NetverifyCustomScanView, 0, 0);
        try {
            this.ratio = obtainStyledAttributes.getFloat(R.styleable.NetverifyCustomScanView_jumio_ratio, 0.0f);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
