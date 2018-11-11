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
import android.widget.TextView;
import com.iqoption.x.R;

/* compiled from: DialogMarginAddOnInfoBindingImpl */
public class iq extends ip {
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
        awV.put(R.id.dialogMarginClickable, 1);
        awV.put(R.id.dialogMarginContainer, 2);
        awV.put(R.id.dialogMarginToolbar, 3);
        awV.put(R.id.dialogMarginTitle, 4);
        awV.put(R.id.dialogMarginClose, 5);
        awV.put(R.id.dialogMarginTopMessage, 6);
        awV.put(R.id.dialogMarginButtonContainer, 7);
        awV.put(R.id.dialogMarginButtonLabel, 8);
        awV.put(R.id.dialogMarginButton, 9);
        awV.put(R.id.dialogMarginEnabledIcon, 10);
        awV.put(R.id.dialogMarginEnabledText, 11);
        awV.put(R.id.dialogMarginTouchablePart, 12);
    }

    public iq(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 13, awU, awV));
    }

    private iq(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[9], (LinearLayout) objArr[7], (TextView) objArr[8], (FrameLayout) objArr[1], (ImageView) objArr[5], (LinearLayout) objArr[2], (ImageView) objArr[10], (TextView) objArr[11], (TextView) objArr[4], (LinearLayout) objArr[3], (TextView) objArr[6], (View) objArr[12], (LinearLayout) objArr[0]);
        this.awW = -1;
        this.bsz.setTag(null);
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
