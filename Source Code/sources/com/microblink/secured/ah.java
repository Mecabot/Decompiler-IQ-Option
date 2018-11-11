package com.microblink.secured;

import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;

/* compiled from: line */
public final class ah extends ViewGroup {
    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        i4 -= i2;
        i3 -= i;
        for (i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            childAt.measure(MeasureSpec.makeMeasureSpec(i3, 1073741824), MeasureSpec.makeMeasureSpec(i4, 1073741824));
            childAt.layout(0, 0, i3, i4);
        }
    }
}
