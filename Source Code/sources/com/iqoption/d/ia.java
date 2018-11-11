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
import com.iqoption.view.RobotoTextView;
import com.iqoption.x.R;

/* compiled from: DialogClosedDealsItemCfdAggregatedBindingImpl */
public class ia extends hz {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @NonNull
    private final LinearLayout axx;

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        awV.put(R.id.startPrice, 1);
        awV.put(R.id.sideIndicator, 2);
        awV.put(R.id.startTime, 3);
        awV.put(R.id.investment, 4);
        awV.put(R.id.endPrice, 5);
        awV.put(R.id.endTime, 6);
        awV.put(R.id.pnl, 7);
        awV.put(R.id.leverage, 8);
        awV.put(R.id.status, 9);
        awV.put(R.id.pnlPercent, 10);
    }

    public ia(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 11, awU, awV));
    }

    private ia(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RobotoTextView) objArr[5], (RobotoTextView) objArr[6], (RobotoTextView) objArr[4], (RobotoTextView) objArr[8], (RobotoTextView) objArr[7], (TextView) objArr[10], (ImageView) objArr[2], (RobotoTextView) objArr[1], (RobotoTextView) objArr[3], (RobotoTextView) objArr[9]);
        this.awW = -1;
        this.axx = (LinearLayout) objArr[0];
        this.axx.setTag(null);
        setRootTag(view);
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
