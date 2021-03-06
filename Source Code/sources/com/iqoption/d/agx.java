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
import com.iqoption.x.R;

/* compiled from: PriceMovementsItemBindingImpl */
public class agx extends agw {
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
        awV.put(R.id.signalDate, 1);
        awV.put(R.id.signalIcon, 2);
        awV.put(R.id.signalTime, 3);
        awV.put(R.id.signalValue, 4);
        awV.put(R.id.signalActive, 5);
        awV.put(R.id.signalLevel, 6);
        awV.put(R.id.signalLevel1, 7);
        awV.put(R.id.signalLevel2, 8);
        awV.put(R.id.signalLevel3, 9);
        awV.put(R.id.signalType, 10);
    }

    public agx(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 11, awU, awV));
    }

    private agx(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[5], (TextView) objArr[1], (ImageView) objArr[2], (LinearLayout) objArr[6], (ImageView) objArr[7], (ImageView) objArr[8], (ImageView) objArr[9], (TextView) objArr[3], (TextView) objArr[10], (TextView) objArr[4]);
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
