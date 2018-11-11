package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.RecyclerView;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.x.R;

/* compiled from: BottomSheetPortfolioTpslChooserBindingImpl */
public class br extends bq {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @NonNull
    private final CoordinatorLayout blq;

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        awV.put(R.id.outside, 1);
        awV.put(R.id.sheet, 2);
        awV.put(R.id.takeProfitTitle, 3);
        awV.put(R.id.takeProfitValues, 4);
        awV.put(R.id.stopLossTitle, 5);
        awV.put(R.id.stopLossValues, 6);
        awV.put(R.id.btnCancel, 7);
        awV.put(R.id.btnDone, 8);
    }

    public br(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 9, awU, awV));
    }

    private br(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[7], (TextView) objArr[8], (View) objArr[1], (LinearLayout) objArr[2], (TextView) objArr[5], (RecyclerView) objArr[6], (TextView) objArr[3], (RecyclerView) objArr[4]);
        this.awW = -1;
        this.blq = (CoordinatorLayout) objArr[0];
        this.blq.setTag(null);
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
