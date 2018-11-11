package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import com.iqoption.fragment.base.i;
import com.iqoption.view.blurtextureview.BlurTextureView;
import com.iqoption.x.R;

/* compiled from: BaseSmartFragmentBindingImpl */
public class ay extends ax {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        awV.put(R.id.mainContentainer, 1);
        awV.put(R.id.backgroundView, 2);
    }

    public ay(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, awU, awV));
    }

    private ay(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (BlurTextureView) objArr[2], (FrameLayout) objArr[0], (FrameLayout) objArr[1]);
        this.awW = -1;
        this.ble.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.awW = 2;
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

    public boolean setVariable(int i, @Nullable Object obj) {
        if (2 != i) {
            return false;
        }
        a((i) obj);
        return true;
    }

    public void a(@Nullable i iVar) {
        this.blh = iVar;
    }

    protected void executeBindings() {
        synchronized (this) {
            long j = this.awW;
            this.awW = 0;
        }
    }
}
