package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.ImageViewBindingAdapter;
import android.databinding.adapters.TextViewBindingAdapter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.iqoption.x.R;

/* compiled from: CloseDelegateBindingImpl */
public class fh extends fg {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @NonNull
    private final FrameLayout biH;

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        awV.put(R.id.expirationContainer, 3);
        awV.put(R.id.countTitle, 4);
        awV.put(R.id.countPosition, 5);
        awV.put(R.id.investTitle, 6);
        awV.put(R.id.invest, 7);
        awV.put(R.id.closeProfitTilte, 8);
        awV.put(R.id.closeProfit, 9);
        awV.put(R.id.closeProfitPercent, 10);
        awV.put(R.id.closeContainer, 11);
        awV.put(R.id.close, 12);
        awV.put(R.id.progress, 13);
        awV.put(R.id.btnWithdraw, 14);
        awV.put(R.id.btnWithdrawProgress, 15);
    }

    public fh(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 16, awU, awV));
    }

    private fh(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (FrameLayout) objArr[14], (ImageView) objArr[2], (ProgressBar) objArr[15], (TextView) objArr[12], (FrameLayout) objArr[11], (TextView) objArr[9], (TextView) objArr[10], (TextView) objArr[8], (TextView) objArr[5], (TextView) objArr[4], (TextView) objArr[1], (LinearLayout) objArr[3], (TextView) objArr[7], (TextView) objArr[6], (ContentLoadingProgressBar) objArr[13]);
        this.awW = -1;
        this.bnf.setTag(null);
        this.bny.setTag(null);
        this.biH = (FrameLayout) objArr[0];
        this.biH.setTag(null);
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
            ImageViewBindingAdapter.setImageDrawable(this.bnf, ViewDataBinding.getDrawableFromResource(this.bnf, R.drawable.ic_withdrawal_white_22));
            TextViewBindingAdapter.setDrawableLeft(this.bny, ViewDataBinding.getDrawableFromResource(this.bny, R.drawable.ic_flag_8_8));
        }
    }
}
