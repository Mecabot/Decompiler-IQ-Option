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

/* compiled from: LeftMenuItemProTraderBindingImpl */
public class xz extends xy {
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
        awV.put(R.id.itemProTitle, 1);
        awV.put(R.id.itemProText, 2);
        awV.put(R.id.itemProRightArrow, 3);
        awV.put(R.id.itemProClose, 4);
    }

    public xz(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, awU, awV));
    }

    private xz(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[4], (LinearLayout) objArr[0], (ImageView) objArr[3], (TextView) objArr[2], (TextView) objArr[1]);
        this.awW = -1;
        this.bKA.setTag(null);
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
