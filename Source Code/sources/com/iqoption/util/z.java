package com.iqoption.util;

import android.content.Context;
import android.content.res.Resources;

/* compiled from: Dp2PxUtils */
public class z {
    private Resources aMx;
    private float ju;

    public z(Context context) {
        if (context != null) {
            this.aMx = context.getResources();
            this.ju = this.aMx.getDisplayMetrics().density;
            return;
        }
        this.ju = 1.0f;
    }

    public int L(float f) {
        return Math.round(f * this.ju);
    }
}
