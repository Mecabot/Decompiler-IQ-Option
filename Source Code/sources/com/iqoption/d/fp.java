package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.iqoption.view.RobotoTextView;
import com.iqoption.x.R;

/* compiled from: CommissionViewBindingImpl */
public class fp extends fo {
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
        awV.put(R.id.commissionTitle, 3);
        awV.put(R.id.commissionContainer, 4);
        awV.put(R.id.commissionType, 5);
        awV.put(R.id.commissionAmount, 6);
        awV.put(R.id.commissionInfoRect, 7);
        awV.put(R.id.otnPicker, 8);
        awV.put(R.id.otnRewardValue, 9);
    }

    public fp(@Nullable DataBindingComponent dataBindingComponent, @NonNull View[] viewArr) {
        this(dataBindingComponent, viewArr, ViewDataBinding.mapBindings(dataBindingComponent, viewArr, 10, awU, awV));
    }

    private fp(DataBindingComponent dataBindingComponent, View[] viewArr, Object[] objArr) {
        View[] viewArr2 = viewArr;
        super(dataBindingComponent, viewArr2[0], 0, (RobotoTextView) objArr[6], (LinearLayout) objArr[4], (View) objArr[7], (RobotoTextView) objArr[3], (RobotoTextView) objArr[5], (RelativeLayout) objArr[0], (ImageView) objArr[8], (RobotoTextView) objArr[1], (RobotoTextView) objArr[9], (LinearLayout) objArr[2]);
        this.awW = -1;
        this.bnW.setTag(null);
        this.bnY.setTag(null);
        this.boa.setTag(null);
        setRootTag(viewArr2);
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
