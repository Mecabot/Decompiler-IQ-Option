package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Guideline;
import android.support.v4.widget.Space;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.iqoption.view.RobotoTextView;
import com.iqoption.x.R;

/* compiled from: PortfolioBalanceOtnBindingImpl */
public class adv extends adu {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;

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
        awV.put(R.id.icon, 4);
        awV.put(R.id.amount, 5);
        awV.put(R.id.conversion, 6);
        awV.put(R.id.cashAmount, 7);
        awV.put(R.id.delimiter1, 8);
        awV.put(R.id.gainSpace, 9);
        awV.put(R.id.gainAmount, 10);
        awV.put(R.id.gainLabel, 11);
        awV.put(R.id.turnoverCashAmount, 12);
        awV.put(R.id.turnoverLabel, 13);
        awV.put(R.id.delimiter2, 14);
        awV.put(R.id.payCommissionCheck, 15);
        awV.put(R.id.payCommissionLabel, 16);
        awV.put(R.id.btnWithdraw, 17);
        awV.put(R.id.btnWithdrawProgress, 18);
        awV.put(R.id.btnWithdrawLabel, 19);
        awV.put(R.id.btnHistory, 20);
        awV.put(R.id.btnInfo, 21);
        awV.put(R.id.header, 22);
    }

    public adv(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 23, awU, awV));
    }

    private adv(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RobotoTextView) objArr[5], (TextView) objArr[20], (ImageView) objArr[21], (FrameLayout) objArr[17], (TextView) objArr[19], (ProgressBar) objArr[18], (RobotoTextView) objArr[7], (ConstraintLayout) objArr[0], (TextView) objArr[6], (View) objArr[8], (View) objArr[14], (RobotoTextView) objArr[10], (TextView) objArr[11], (Space) objArr[9], (FrameLayout) objArr[22], (Guideline) objArr[1], (FrameLayout) objArr[3], (ImageView) objArr[4], (Guideline) objArr[2], (CheckBox) objArr[15], (TextView) objArr[16], (RobotoTextView) objArr[12], (TextView) objArr[13]);
        this.awW = -1;
        this.bPg.setTag(null);
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
