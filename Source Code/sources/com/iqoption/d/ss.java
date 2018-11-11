package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import com.iqoption.view.RobotoTextView;
import com.iqoption.view.text.FormattedTextView;
import com.iqoption.x.R;

/* compiled from: FragmentTradingHistorySearchDetailsBindingImpl */
public class ss extends sr {
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
        awV.put(R.id.back, 2);
        awV.put(R.id.title, 3);
        awV.put(R.id.assetName, 4);
        awV.put(R.id.openTime, 5);
        awV.put(R.id.openPriceLayout, 6);
        awV.put(R.id.openPrice, 7);
        awV.put(R.id.closeTime, 8);
        awV.put(R.id.closeValue, 9);
        awV.put(R.id.investmentLayout, 10);
        awV.put(R.id.investment, 11);
        awV.put(R.id.optPriceLayout, 12);
        awV.put(R.id.optPrice, 13);
        awV.put(R.id.qttyLayout, 14);
        awV.put(R.id.qtty, 15);
        awV.put(R.id.multiplyLayout, 16);
        awV.put(R.id.multiply, 17);
        awV.put(R.id.commissionLayout, 18);
        awV.put(R.id.commissionValue, 19);
        awV.put(R.id.swapLayout, 20);
        awV.put(R.id.swapValue, 21);
        awV.put(R.id.profitValue, 22);
    }

    public ss(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 23, awU, awV));
    }

    private ss(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RobotoTextView) objArr[4], (View) objArr[2], (RobotoTextView) objArr[8], (RobotoTextView) objArr[9], (LinearLayout) objArr[18], (RobotoTextView) objArr[19], (RobotoTextView) objArr[11], (LinearLayout) objArr[10], (RobotoTextView) objArr[17], (LinearLayout) objArr[16], (RobotoTextView) objArr[7], (LinearLayout) objArr[6], (RobotoTextView) objArr[5], (RobotoTextView) objArr[13], (LinearLayout) objArr[12], (RobotoTextView) objArr[22], (RobotoTextView) objArr[15], (LinearLayout) objArr[14], (LinearLayout) objArr[20], (RobotoTextView) objArr[21], (FormattedTextView) objArr[3]);
        this.awW = -1;
        this.axx = (LinearLayout) objArr[0];
        this.axx.setTag(null);
        this.biX = (LinearLayout) objArr[1];
        this.biX.setTag(null);
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
