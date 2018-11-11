package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.x.R;

/* compiled from: LayoutProtectedOldBindingImpl */
public class xc extends xb {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @NonNull
    private final ConstraintLayout biA;

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        awV.put(R.id.protectedMcIcon, 1);
        awV.put(R.id.protectedMcDescription, 2);
        awV.put(R.id.protectedVisaIcon, 3);
        awV.put(R.id.protectedVisaDescription, 4);
        awV.put(R.id.protected3dsIcon, 5);
        awV.put(R.id.protected3dsDescription, 6);
        awV.put(R.id.protectedSslIcon, 7);
        awV.put(R.id.protectedSslDescription, 8);
        awV.put(R.id.protectedSslTitle, 9);
        awV.put(R.id.protectedSslSubtitle, 10);
        awV.put(R.id.protectedBankIcon, 11);
        awV.put(R.id.protectedBankDescription, 12);
    }

    public xc(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 13, awU, awV));
    }

    private xc(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[6], (ImageView) objArr[5], (TextView) objArr[12], (ImageView) objArr[11], (ImageView) objArr[2], (ImageView) objArr[1], (LinearLayout) objArr[8], (ImageView) objArr[7], (TextView) objArr[10], (TextView) objArr[9], (ImageView) objArr[4], (ImageView) objArr[3]);
        this.awW = -1;
        this.biA = (ConstraintLayout) objArr[0];
        this.biA.setTag(null);
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
