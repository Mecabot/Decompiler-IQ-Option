package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Guideline;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.core.ui.a;
import com.iqoption.x.R;

/* compiled from: WithdrawHistoryPayoutItemBindingImpl */
public class amo extends amn {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @NonNull
    private final LinearLayout axx;
    @NonNull
    private final ConstraintLayout bUY;

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        awV.put(R.id.includeWithdrawValueAndStatus, 3);
        awV.put(R.id.withdrawIcon, 4);
        awV.put(R.id.withdrawTime, 5);
        awV.put(R.id.withdrawTitle, 6);
        awV.put(R.id.withdrawCenterGuideline, 7);
        awV.put(R.id.withdrawComment, 8);
        awV.put(R.id.withdrawCancelProgress, 9);
    }

    public amo(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 10, awU, awV));
    }

    private amo(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (View) objArr[3], (ImageView) objArr[2], (ContentLoadingProgressBar) objArr[9], (Guideline) objArr[7], (TextView) objArr[8], (ImageView) objArr[4], (TextView) objArr[5], (TextView) objArr[6]);
        this.awW = -1;
        this.axx = (LinearLayout) objArr[0];
        this.axx.setTag(null);
        this.bUY = (ConstraintLayout) objArr[1];
        this.bUY.setTag(null);
        this.bUR.setTag(null);
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
        long j;
        synchronized (this) {
            j = this.awW;
            this.awW = 0;
        }
        if ((j & 1) != 0) {
            a.a(this.bUR, (Void) null);
        }
    }
}
