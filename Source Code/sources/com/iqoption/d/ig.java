package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.iqoption.e.a.a.a;
import com.iqoption.fragment.ap;
import com.iqoption.x.R;

/* compiled from: DialogCommisionInfoBindingImpl */
public class ig extends if implements a {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @Nullable
    private final OnClickListener brM;

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        awV.put(R.id.contentLayout, 1);
        awV.put(R.id.textCommission, 2);
    }

    public ig(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, awU, awV));
    }

    private ig(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (FrameLayout) objArr[1], (FrameLayout) objArr[0], (TextView) objArr[2]);
        this.awW = -1;
        this.brJ.setTag(null);
        setRootTag(view);
        this.brM = new com.iqoption.e.a.a(this, 1);
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
        if (1 != i) {
            return false;
        }
        a((ap) obj);
        return true;
    }

    public void a(@Nullable ap apVar) {
        this.brL = apVar;
        synchronized (this) {
            this.awW |= 1;
        }
        notifyPropertyChanged(1);
        super.requestRebind();
    }

    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.awW;
            this.awW = 0;
        }
        ap apVar = this.brL;
        if ((j & 2) != 0) {
            this.brJ.setOnClickListener(this.brM);
        }
    }

    public final void a(int i, View view) {
        ap apVar = this.brL;
        if ((apVar != null ? 1 : null) != null) {
            apVar.onClose();
        }
    }
}
