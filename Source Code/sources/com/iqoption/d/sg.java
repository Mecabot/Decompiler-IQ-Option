package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.TextViewBindingAdapter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Guideline;
import android.support.v7.widget.RecyclerView;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import com.iqoption.core.ui.a;
import com.iqoption.x.R;

/* compiled from: FragmentSignalsBindingImpl */
public class sg extends sf {
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
        awV.put(R.id.signalList, 2);
        awV.put(R.id.toolbar, 3);
        awV.put(R.id.title, 4);
    }

    public sg(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, awU, awV));
    }

    private sg(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[1], (RecyclerView) objArr[2], (TextView) objArr[4], (Guideline) objArr[3]);
        this.awW = -1;
        this.bAZ.setTag(null);
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
        long j;
        synchronized (this) {
            j = this.awW;
            this.awW = 0;
        }
        if ((j & 1) != 0) {
            TextViewBindingAdapter.setDrawableEnd(this.bAZ, ViewDataBinding.getDrawableFromResource(this.bAZ, R.drawable.ic_arrow_down));
            a.a(this.bAZ, this.bAZ.getResources().getDimension(R.dimen.dp12), ViewDataBinding.getColorFromResource(this.bAZ, R.color.grey_blur_70));
        }
    }
}
