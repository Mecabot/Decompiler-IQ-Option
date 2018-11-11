package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.view.timer.TimerView;
import com.iqoption.x.R;

/* compiled from: AssetSpinnerHandleBindingImpl */
public class as extends ar {
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
        awV.put(R.id.frameAssetHandler, 1);
        awV.put(R.id.iconSwitcher, 2);
        awV.put(R.id.assetIcon, 3);
        awV.put(R.id.timerView, 4);
        awV.put(R.id.titleContainer, 5);
        awV.put(R.id.assetTitle, 6);
        awV.put(R.id.assetType, 7);
        awV.put(R.id.divinerCloseButton1, 8);
        awV.put(R.id.closeSpinner, 9);
        awV.put(R.id.arrowSpinner, 10);
    }

    public as(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 11, awU, awV));
    }

    private as(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[10], (ImageView) objArr[3], (TextView) objArr[6], (TextView) objArr[7], (FrameLayout) objArr[0], (ImageView) objArr[9], (View) objArr[8], (LinearLayout) objArr[1], (ImageSwitcher) objArr[2], (TimerView) objArr[4], (LinearLayout) objArr[5]);
        this.awW = -1;
        this.bkW.setTag(null);
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
