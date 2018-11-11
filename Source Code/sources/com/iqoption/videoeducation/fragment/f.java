package com.iqoption.videoeducation.fragment;

import android.content.res.Resources;
import android.support.annotation.DimenRes;
import android.support.v7.widget.RecyclerView;
import com.iqoption.core.graphics.b;
import com.iqoption.x.R;

/* compiled from: VideoCellCalculator */
final class f {
    private Resources aMx;
    private b dzM;
    private int dzX;
    private int spanCount;

    f() {
    }

    void i(RecyclerView recyclerView) {
        if (this.aMx == null) {
            this.aMx = recyclerView.getResources();
        }
        int width = (recyclerView.getWidth() - recyclerView.getPaddingLeft()) - recyclerView.getPaddingRight();
        int ef = ef(R.dimen.dp220);
        int ef2 = ef(R.dimen.dp127);
        this.dzX = ef(R.dimen.dp8);
        int i = width / ef;
        int i2 = i - 1;
        if (width - (i * ef) >= this.dzX * i2) {
            this.spanCount = i;
        } else {
            this.spanCount = i2;
        }
        if (this.spanCount < 2) {
            this.spanCount = 2;
        }
        width = (width - this.dzX) / this.spanCount;
        this.dzM = new b(width, (int) (((float) width) / (((float) ef) / ((float) ef2))));
    }

    int getSpanCount() {
        return this.spanCount;
    }

    int aHR() {
        return this.dzX;
    }

    b aHS() {
        return this.dzM;
    }

    private int ef(@DimenRes int i) {
        return this.aMx.getDimensionPixelSize(i);
    }
}
