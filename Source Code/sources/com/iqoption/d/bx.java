package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.iqoption.e.a.a.a;
import com.iqoption.fragment.ah;
import com.iqoption.x.R;

/* compiled from: CfdExpirationFragmentBindingImpl */
public class bx extends bw implements a {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @Nullable
    private final OnClickListener blX;

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        awV.put(R.id.contentLayout, 1);
        awV.put(R.id.cfdExpirtions, 2);
    }

    public bx(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, awU, awV));
    }

    private bx(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RecyclerView) objArr[2], (FrameLayout) objArr[1], (FrameLayout) objArr[0]);
        this.awW = -1;
        this.bjF.setTag(null);
        setRootTag(view);
        this.blX = new com.iqoption.e.a.a(this, 1);
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
        a((ah) obj);
        return true;
    }

    public void a(@Nullable ah ahVar) {
        this.blW = ahVar;
        synchronized (this) {
            this.awW |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.awW;
            this.awW = 0;
        }
        ah ahVar = this.blW;
        if ((j & 2) != 0) {
            this.bjF.setOnClickListener(this.blX);
        }
    }

    public final void a(int i, View view) {
        ah ahVar = this.blW;
        if ((ahVar != null ? 1 : null) != null) {
            ahVar.aN();
        }
    }
}
