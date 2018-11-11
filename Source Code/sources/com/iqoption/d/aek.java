package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.TextViewBindingAdapter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.Barrier;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Guideline;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.core.ui.a;
import com.iqoption.x.R;

/* compiled from: PortfolioDelegateMacroBindingImpl */
public class aek extends aej {
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
        awV.put(R.id.toolbarBottom, 2);
        awV.put(R.id.btnBack, 3);
        awV.put(R.id.title, 4);
        awV.put(R.id.titleBarrier, 5);
        awV.put(R.id.value, 6);
        awV.put(R.id.pnl, 7);
        awV.put(R.id.tabs, 8);
        awV.put(R.id.pager, 9);
    }

    public aek(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 10, awU, awV));
    }

    private aek(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[3], (TextView) objArr[1], (ViewPager) objArr[9], (TextView) objArr[7], (TabLayout) objArr[8], (TextView) objArr[4], (Barrier) objArr[5], (Guideline) objArr[2], (TextView) objArr[6]);
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
            a.a(this.bAZ, this.bAZ.getResources().getDimension(R.dimen.dp17), ViewDataBinding.getColorFromResource(this.bAZ, R.color.grey_blur_70));
        }
    }
}
