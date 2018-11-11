package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.x.R;

/* compiled from: FragmentOperationHistoryBindingLandImpl */
public class pc extends pa {
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
        awV.put(R.id.back, 2);
        awV.put(R.id.search_button, 3);
        awV.put(R.id.general_container, 4);
        awV.put(R.id.operation, 5);
        awV.put(R.id.operation_filter, 6);
        awV.put(R.id.status, 7);
        awV.put(R.id.status_filter, 8);
        awV.put(R.id.date, 9);
        awV.put(R.id.date_filter, 10);
    }

    public pc(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 11, awU, awV));
    }

    private pc(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (View) objArr[2], (LinearLayout) objArr[9], (TextView) objArr[10], (LinearLayout) objArr[4], (LinearLayout) objArr[5], (TextView) objArr[6], (TextView) objArr[3], (LinearLayout) objArr[7], (TextView) objArr[8], (LinearLayout) objArr[1]);
        this.awW = -1;
        this.axx = (LinearLayout) objArr[0];
        this.axx.setTag(null);
        this.biz.setTag(null);
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
