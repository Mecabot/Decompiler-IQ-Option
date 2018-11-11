package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.core.ui.a;
import com.iqoption.view.text.FormattedTextView;
import com.iqoption.x.R;

/* compiled from: FragmentTradingHistorySearchSettingBindingImpl */
public class sw extends sv {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @NonNull
    private final LinearLayout axx;
    @NonNull
    private final LinearLayout biX;

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        awV.put(R.id.back, 6);
        awV.put(R.id.title, 7);
        awV.put(R.id.search, 8);
        awV.put(R.id.optionTypeValue, 9);
        awV.put(R.id.accountTypeValue, 10);
        awV.put(R.id.assetValue, 11);
        awV.put(R.id.dateValue, 12);
    }

    public sw(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 13, awU, awV));
    }

    private sw(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[3], (TextView) objArr[10], (LinearLayout) objArr[4], (TextView) objArr[11], (View) objArr[6], (LinearLayout) objArr[5], (TextView) objArr[12], (LinearLayout) objArr[2], (TextView) objArr[9], (TextView) objArr[8], (FormattedTextView) objArr[7]);
        this.awW = -1;
        this.bEk.setTag(null);
        this.bEm.setTag(null);
        this.bEo.setTag(null);
        this.axx = (LinearLayout) objArr[0];
        this.axx.setTag(null);
        this.biX = (LinearLayout) objArr[1];
        this.biX.setTag(null);
        this.bEq.setTag(null);
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
            a.d(this.bEk, 0.5f);
            a.d(this.bEm, 0.5f);
            a.d(this.bEo, 0.5f);
            a.d(this.bEq, 0.5f);
        }
    }
}
