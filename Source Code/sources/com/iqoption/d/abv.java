package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.x.R;

/* compiled from: NumpadBindingImpl */
public class abv extends abu {
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
        awV.put(R.id.line1Dialpad, 1);
        awV.put(R.id.one, 2);
        awV.put(R.id.two, 3);
        awV.put(R.id.three, 4);
        awV.put(R.id.line2Dialpad, 5);
        awV.put(R.id.four, 6);
        awV.put(R.id.five, 7);
        awV.put(R.id.six, 8);
        awV.put(R.id.line3Dialpad, 9);
        awV.put(R.id.seven, 10);
        awV.put(R.id.eight, 11);
        awV.put(R.id.nine, 12);
        awV.put(R.id.line4Dialpad, 13);
        awV.put(R.id.customButton, 14);
        awV.put(R.id.zero, 15);
        awV.put(R.id.zeroValue, 16);
        awV.put(R.id.sign, 17);
        awV.put(R.id.back, 18);
    }

    public abv(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 19, awU, awV));
    }

    private abv(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (FrameLayout) objArr[18], (TextView) objArr[14], (LinearLayout) objArr[0], (TextView) objArr[11], (TextView) objArr[7], (TextView) objArr[6], (LinearLayout) objArr[1], (LinearLayout) objArr[5], (LinearLayout) objArr[9], (LinearLayout) objArr[13], (TextView) objArr[12], (TextView) objArr[2], (TextView) objArr[10], (TextView) objArr[17], (TextView) objArr[8], (TextView) objArr[4], (TextView) objArr[3], (LinearLayout) objArr[15], (TextView) objArr[16]);
        this.awW = -1;
        this.buM.setTag(null);
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
