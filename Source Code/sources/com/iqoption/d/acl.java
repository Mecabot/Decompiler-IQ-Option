package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.view.RobotoTextView;
import com.iqoption.x.R;

/* compiled from: OpenDigitalOptionItemBindingImpl */
public class acl extends ack {
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
        awV.put(R.id.strikeValue1, 1);
        awV.put(R.id.strikeValue2, 2);
        awV.put(R.id.winAmount, 3);
        awV.put(R.id.investTitle, 4);
        awV.put(R.id.investValue, 5);
        awV.put(R.id.percent, 6);
        awV.put(R.id.sellButton, 7);
        awV.put(R.id.sellingPriceText, 8);
        awV.put(R.id.sellingPriceValue, 9);
        awV.put(R.id.buybackOptionProgress, 10);
    }

    public acl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 11, awU, awV));
    }

    private acl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ContentLoadingProgressBar) objArr[10], (RobotoTextView) objArr[4], (RobotoTextView) objArr[5], (LinearLayout) objArr[0], (RobotoTextView) objArr[6], (LinearLayout) objArr[7], (TextView) objArr[8], (RobotoTextView) objArr[9], (RobotoTextView) objArr[1], (RobotoTextView) objArr[2], (RobotoTextView) objArr[3]);
        this.awW = -1;
        this.bNc.setTag(null);
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
