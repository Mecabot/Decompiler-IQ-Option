package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.SwitchCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.iqoption.core.ui.a;
import com.iqoption.view.NumberAnimateRobotoTextView;
import com.iqoption.view.RobotoTextView;
import com.iqoption.view.text.FormattedTextView;
import com.iqoption.x.R;

/* compiled from: CfdConfirmDialogViewBindingImpl */
public class bv extends bu {
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
        awV.put(R.id.assetPrice, 2);
        awV.put(R.id.investValue, 3);
        awV.put(R.id.multValue, 4);
        awV.put(R.id.totalValue, 5);
        awV.put(R.id.buyInOneClickSettingLayout, 6);
        awV.put(R.id.buyInClickSetting, 7);
        awV.put(R.id.btnConfirm, 8);
    }

    public bv(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 9, awU, awV));
    }

    private bv(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (NumberAnimateRobotoTextView) objArr[2], (ImageView) objArr[1], (FormattedTextView) objArr[8], (SwitchCompat) objArr[7], (RelativeLayout) objArr[6], (RobotoTextView) objArr[3], (RobotoTextView) objArr[4], (RobotoTextView) objArr[5]);
        this.awW = -1;
        this.blO.setTag(null);
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
            a.d(this.blO, 0.5f);
        }
    }
}
