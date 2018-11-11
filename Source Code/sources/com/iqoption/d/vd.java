package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.iqoption.view.RobotoEditText;
import com.iqoption.x.R;

/* compiled from: FragmentWithdrawalCryptoWalletBindingImpl */
public class vd extends vc {
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
        awV.put(R.id.coordinatorLayout, 1);
        awV.put(R.id.coordinatedLayout, 2);
        awV.put(R.id.withdrawalTitle, 3);
        awV.put(R.id.walletIdTopMargin, 4);
        awV.put(R.id.withdrawalAmountContainer, 5);
        awV.put(R.id.withdrawalAmount, 6);
        awV.put(R.id.withdrawalAmountInfo, 7);
        awV.put(R.id.walletId, 8);
        awV.put(R.id.scannerIcon, 9);
        awV.put(R.id.walletNumberUnderline, 10);
        awV.put(R.id.withdrawalInfo, 11);
        awV.put(R.id.withdrawalErrorIcon, 12);
        awV.put(R.id.cameraView, 13);
        awV.put(R.id.withdrawalButton, 14);
        awV.put(R.id.progress, 15);
    }

    public vd(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 16, awU, awV));
    }

    private vd(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (FrameLayout) objArr[13], (LinearLayout) objArr[2], (CoordinatorLayout) objArr[1], (ProgressBar) objArr[15], (ImageView) objArr[9], (RobotoEditText) objArr[8], (View) objArr[4], (View) objArr[10], (RobotoEditText) objArr[6], (LinearLayout) objArr[5], (TextView) objArr[7], (TextView) objArr[14], (ImageView) objArr[12], (TextView) objArr[11], (TextView) objArr[3]);
        this.awW = -1;
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
        synchronized (this) {
            long j = this.awW;
            this.awW = 0;
        }
    }
}
