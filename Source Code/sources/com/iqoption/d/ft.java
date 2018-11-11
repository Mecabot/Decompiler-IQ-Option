package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.iqoption.core.ui.a;
import com.iqoption.view.NumberAnimateRobotoTextView;
import com.iqoption.view.RobotoTextView;
import com.iqoption.view.text.FormattedTextView;
import com.iqoption.x.R;

/* compiled from: CryptoConfirmDialogViewBindingImpl */
public class ft extends fs {
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
        awV.put(R.id.assetPrice, 2);
        awV.put(R.id.investValue, 3);
        awV.put(R.id.quantityValue, 4);
        awV.put(R.id.btnConfirm, 5);
    }

    public ft(@Nullable DataBindingComponent dataBindingComponent, @NonNull View[] viewArr) {
        this(dataBindingComponent, viewArr, ViewDataBinding.mapBindings(dataBindingComponent, viewArr, 6, awU, awV));
    }

    private ft(DataBindingComponent dataBindingComponent, View[] viewArr, Object[] objArr) {
        super(dataBindingComponent, viewArr[0], 0, (NumberAnimateRobotoTextView) objArr[2], (ImageView) objArr[1], (FormattedTextView) objArr[5], (RobotoTextView) objArr[3], (NumberAnimateRobotoTextView) objArr[4]);
        this.awW = -1;
        this.blO.setTag(null);
        this.axx = (LinearLayout) objArr[0];
        this.axx.setTag(null);
        setRootTag(viewArr);
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
