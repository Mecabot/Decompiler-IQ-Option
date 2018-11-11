package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.view.RobotoTextView;
import com.iqoption.view.text.FormattedTextView;
import com.iqoption.x.R;

/* compiled from: OpenCfdGroupItemBindingImpl */
public class acd extends acc {
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
        awV.put(R.id.openGroupItemLayout, 1);
        awV.put(R.id.buyBackGroupFrame, 2);
        awV.put(R.id.buyBackGroupLayout, 3);
        awV.put(R.id.confirmGroupSellingText, 4);
        awV.put(R.id.groupProgress, 5);
        awV.put(R.id.buyBackGroupValue, 6);
        awV.put(R.id.openGroupInfoLayout, 7);
        awV.put(R.id.activeIcon, 8);
        awV.put(R.id.active, 9);
        awV.put(R.id.winAmount, 10);
        awV.put(R.id.menuIcon, 11);
        awV.put(R.id.instrumentType, 12);
        awV.put(R.id.buySell, 13);
        awV.put(R.id.winAmountPercent, 14);
        awV.put(R.id.dividerShort, 15);
        awV.put(R.id.space, 16);
        awV.put(R.id.dividerLong, 17);
    }

    public acd(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 18, awU, awV));
    }

    private acd(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[9], (ImageView) objArr[8], (FrameLayout) objArr[2], (LinearLayout) objArr[3], (RobotoTextView) objArr[6], (TextView) objArr[13], (FormattedTextView) objArr[4], (View) objArr[17], (View) objArr[15], (ContentLoadingProgressBar) objArr[5], (FormattedTextView) objArr[12], (ImageView) objArr[11], (LinearLayout) objArr[7], (FrameLayout) objArr[1], (LinearLayout) objArr[0], (View) objArr[16], (RobotoTextView) objArr[10], (TextView) objArr[14]);
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
