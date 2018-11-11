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
import android.widget.TextView;
import com.iqoption.x.R;

/* compiled from: ClosePositionDelegateBindingImpl */
public class fj extends fi {
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
        awV.put(R.id.type, 4);
        awV.put(R.id.value, 5);
        awV.put(R.id.investTitle, 6);
        awV.put(R.id.invest, 7);
        awV.put(R.id.closeProfitTilte, 8);
        awV.put(R.id.closeProfit, 9);
        awV.put(R.id.closeProfitPercent, 10);
        awV.put(R.id.closeContainer, 11);
        awV.put(R.id.close, 12);
        awV.put(R.id.progress, 13);
    }

    public fj(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 14, awU, awV));
    }

    private fj(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[12], (FrameLayout) objArr[11], (TextView) objArr[9], (TextView) objArr[10], (TextView) objArr[8], (TextView) objArr[1], (LinearLayout) objArr[3], (TextView) objArr[7], (TextView) objArr[6], (ContentLoadingProgressBar) objArr[13], (ImageView) objArr[2], (TextView) objArr[4], (TextView) objArr[5]);
        this.awW = -1;
        this.bny.setTag(null);
        this.biH = (FrameLayout) objArr[0];
        this.biH.setTag(null);
        this.bno.setTag(null);
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
            TextViewBindingAdapter.setDrawableLeft(this.bny, ViewDataBinding.getDrawableFromResource(this.bny, R.drawable.ic_flag_8_8));
            ImageViewBindingAdapter.setImageDrawable(this.bno, ViewDataBinding.getDrawableFromResource(this.bno, R.drawable.ic_setting_gray_blur_18));
        }
    }
}
