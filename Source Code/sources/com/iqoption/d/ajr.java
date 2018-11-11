package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.x.R;

/* compiled from: SplashBindingImpl */
public class ajr extends ajq {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @NonNull
    private final LinearLayout axx;
    @NonNull
    private final LinearLayout biX;

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        awV.put(R.id.frontText, 4);
        awV.put(R.id.timerText, 5);
        awV.put(R.id.logText, 6);
        awV.put(R.id.noDurationText, 7);
        awV.put(R.id.ic_cysec, 8);
    }

    public ajr(@Nullable DataBindingComponent dataBindingComponent, @NonNull View[] viewArr) {
        this(dataBindingComponent, viewArr, ViewDataBinding.mapBindings(dataBindingComponent, viewArr, 9, awU, awV));
    }

    private ajr(DataBindingComponent dataBindingComponent, View[] viewArr, Object[] objArr) {
        super(dataBindingComponent, viewArr[0], 0, (ImageView) objArr[2], (View) objArr[3], (TextView) objArr[4], (ImageView) objArr[8], (TextView) objArr[6], (TextView) objArr[7], (TextView) objArr[5]);
        this.awW = -1;
        this.bTu.setTag(null);
        this.bTv.setTag(null);
        this.axx = (LinearLayout) objArr[0];
        this.axx.setTag(null);
        this.biX = (LinearLayout) objArr[1];
        this.biX.setTag(null);
        setRootTag(viewArr);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.awW = 1;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.awW != 0) {
                return true;
            }
            return false;
        }
    }

    protected void executeBindings() {
        synchronized (this) {
            long j = this.awW;
            this.awW = 0;
        }
    }
}
