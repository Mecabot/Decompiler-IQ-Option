package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.core.ui.widget.MaxSizeCardViewLayout;
import com.iqoption.x.R;

/* compiled from: ChatDialogUserInfoBindingImpl */
public class ch extends cg {
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
        awV.put(R.id.frame, 1);
        awV.put(R.id.avatar, 2);
        awV.put(R.id.vipBadge, 3);
        awV.put(R.id.nameLayout, 4);
        awV.put(R.id.name, 5);
        awV.put(R.id.countryLayout, 6);
        awV.put(R.id.country, 7);
        awV.put(R.id.dateLabel, 8);
        awV.put(R.id.date, 9);
        awV.put(R.id.btnClose, 10);
    }

    public ch(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 11, awU, awV));
    }

    private ch(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[2], (TextView) objArr[10], (TextView) objArr[7], (FrameLayout) objArr[6], (TextView) objArr[9], (TextView) objArr[8], (MaxSizeCardViewLayout) objArr[1], (TextView) objArr[5], (FrameLayout) objArr[4], (FrameLayout) objArr[0], (TextView) objArr[3]);
        this.awW = -1;
        this.awS.setTag(null);
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
