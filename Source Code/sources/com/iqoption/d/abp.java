package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.e.a.a.a;
import com.iqoption.x.R;

/* compiled from: NpsCompletedFragmentBindingImpl */
public class abp extends abo implements a {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @Nullable
    private final OnClickListener bMu;

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        awV.put(R.id.closeFrame, 2);
        awV.put(R.id.icon, 3);
        awV.put(R.id.text, 4);
    }

    public abp(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, awU, awV));
    }

    private abp(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[1], (FrameLayout) objArr[2], (ImageView) objArr[3], (ConstraintLayout) objArr[0], (TextView) objArr[4]);
        this.awW = -1;
        this.bBI.setTag(null);
        this.bMs.setTag(null);
        setRootTag(view);
        this.bMu = new com.iqoption.e.a.a(this, 1);
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
        a((com.iqoption.fragment.dialog.nps.a) obj);
        return true;
    }

    public void a(@Nullable com.iqoption.fragment.dialog.nps.a aVar) {
        this.bMt = aVar;
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
        com.iqoption.fragment.dialog.nps.a aVar = this.bMt;
        if ((j & 2) != 0) {
            this.bBI.setOnClickListener(this.bMu);
        }
    }

    public final void a(int i, View view) {
        com.iqoption.fragment.dialog.nps.a aVar = this.bMt;
        if ((aVar != null ? 1 : null) != null) {
            aVar.onClose();
        }
    }
}
