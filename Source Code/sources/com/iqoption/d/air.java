package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.TextViewBindingAdapter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.view.RobotoTextView;
import com.iqoption.x.R;

/* compiled from: RightPanelDelegateTurboBinaryCallPutBindingImpl */
public class air extends aiq {
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
        awV.put(R.id.profitLabel, 3);
        awV.put(R.id.profitValue, 4);
        awV.put(R.id.profitPercent, 5);
    }

    public air(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, awU, awV));
    }

    private air(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RobotoTextView) objArr[1], (RobotoTextView) objArr[2], (LinearLayout) objArr[0], (TextView) objArr[3], (TextView) objArr[5], (RobotoTextView) objArr[4]);
        this.awW = -1;
        this.bSY.setTag(null);
        this.bSZ.setTag(null);
        this.bTa.setTag(null);
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
            TextViewBindingAdapter.setDrawableLeft(this.bSY, ViewDataBinding.getDrawableFromResource(this.bSY, R.drawable.call_arrow));
            TextViewBindingAdapter.setDrawableLeft(this.bSZ, ViewDataBinding.getDrawableFromResource(this.bSZ, R.drawable.put_arrow));
        }
    }
}
