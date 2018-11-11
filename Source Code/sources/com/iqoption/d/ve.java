package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.iqoption.view.RobotoEditText;
import com.iqoption.x.R;

/* compiled from: FragmentWithdrawalCryptoWalletBindingLandImpl */
public class ve extends vc {
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
        awV.put(R.id.withdrawalTitle, 1);
        awV.put(R.id.walletIdTopMargin, 2);
        awV.put(R.id.withdrawalAmountContainer, 3);
        awV.put(R.id.withdrawalAmount, 4);
        awV.put(R.id.withdrawalAmountInfo, 5);
        awV.put(R.id.walletId, 6);
        awV.put(R.id.scannerIcon, 7);
        awV.put(R.id.walletNumberUnderline, 8);
        awV.put(R.id.withdrawalInfo, 9);
        awV.put(R.id.withdrawalErrorIcon, 10);
        awV.put(R.id.withdrawalButton, 11);
        awV.put(R.id.progress, 12);
    }

    public ve(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 13, awU, awV));
    }

    private ve(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, null, null, null, (ProgressBar) objArr[12], (ImageView) objArr[7], (RobotoEditText) objArr[6], (View) objArr[2], (View) objArr[8], (RobotoEditText) objArr[4], (LinearLayout) objArr[3], (TextView) objArr[5], (TextView) objArr[11], (ImageView) objArr[10], (TextView) objArr[9], (TextView) objArr[1]);
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
