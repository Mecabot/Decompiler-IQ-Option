package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Guideline;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.iqoption.view.RobotoTextView;
import com.iqoption.x.R;

/* compiled from: PortfolioBalanceCashBindingImpl */
public class adt extends ads {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @NonNull
    private final ConstraintLayout biA;

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        awV.put(R.id.headerGuideline, 1);
        awV.put(R.id.infoGuideline, 2);
        awV.put(R.id.highlight, 3);
        awV.put(R.id.symbol, 4);
        awV.put(R.id.currency, 5);
        awV.put(R.id.label, 6);
        awV.put(R.id.amount, 7);
        awV.put(R.id.delimiter, 8);
        awV.put(R.id.btnWithdraw, 9);
        awV.put(R.id.btnWithdrawProgress, 10);
        awV.put(R.id.btnWithdrawLabel, 11);
        awV.put(R.id.btnDeposit, 12);
        awV.put(R.id.header, 13);
    }

    public adt(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 14, awU, awV));
    }

    private adt(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RobotoTextView) objArr[7], (TextView) objArr[12], (FrameLayout) objArr[9], (TextView) objArr[11], (ProgressBar) objArr[10], (TextView) objArr[5], (View) objArr[8], (FrameLayout) objArr[13], (Guideline) objArr[1], (FrameLayout) objArr[3], (Guideline) objArr[2], (TextView) objArr[6], (TextView) objArr[4]);
        this.awW = -1;
        this.biA = (ConstraintLayout) objArr[0];
        this.biA.setTag(null);
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
