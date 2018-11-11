package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.view.RobotoTextView;
import com.iqoption.x.R;

/* compiled from: DialogOtnExpectationBindingImpl */
public class iy extends ix {
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
        awV.put(R.id.title, 1);
        awV.put(R.id.subtitle, 2);
        awV.put(R.id.closeButton, 3);
        awV.put(R.id.contentLayout, 4);
        awV.put(R.id.totalCommission, 5);
        awV.put(R.id.btnTotalCommissionInfo, 6);
        awV.put(R.id.totalCommissionDesc, 7);
        awV.put(R.id.yourCommission, 8);
        awV.put(R.id.btnYourCommissionInfo, 9);
        awV.put(R.id.yourCommissionDesc, 10);
        awV.put(R.id.tokensLabel, 11);
        awV.put(R.id.tokensValue, 12);
        awV.put(R.id.btnTokensToDistributeInfo, 13);
        awV.put(R.id.tokensToDistributeDesc, 14);
        awV.put(R.id.youReceiveLayout, 15);
        awV.put(R.id.youReceive, 16);
        awV.put(R.id.btnYouReceiveInfo, 17);
        awV.put(R.id.youReceiveDesc, 18);
    }

    public iy(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 19, awU, awV));
    }

    private iy(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[13], (ImageView) objArr[6], (ImageView) objArr[17], (ImageView) objArr[9], (ImageView) objArr[3], (LinearLayout) objArr[4], (TextView) objArr[2], (TextView) objArr[1], (TextView) objArr[11], (TextView) objArr[14], (TextView) objArr[12], (RobotoTextView) objArr[5], (TextView) objArr[7], (TextView) objArr[16], (TextView) objArr[18], (LinearLayout) objArr[15], (TextView) objArr[8], (TextView) objArr[10]);
        this.awW = -1;
        this.axx = (LinearLayout) objArr[0];
        this.axx.setTag(null);
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
