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
import com.iqoption.fragment.bo;
import com.iqoption.x.R;

/* compiled from: DialogMultiplierConfirmBindingImpl */
public class iu extends it implements a {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @Nullable
    private final OnClickListener bsB;
    @Nullable
    private final OnClickListener bsC;

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        awV.put(R.id.contentLayout, 2);
    }

    public iu(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, awU, awV));
    }

    private iu(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[1], (FrameLayout) objArr[2], (FrameLayout) objArr[0]);
        this.awW = -1;
        this.brN.setTag(null);
        this.brJ.setTag(null);
        setRootTag(view);
        this.bsB = new com.iqoption.e.a.a(this, 2);
        this.bsC = new com.iqoption.e.a.a(this, 1);
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
        a((bo) obj);
        return true;
    }

    public void a(@Nullable bo boVar) {
        this.bsA = boVar;
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
        bo boVar = this.bsA;
        if ((j & 2) != 0) {
            this.brN.setOnClickListener(this.bsB);
            com.iqoption.core.ui.a.d(this.brN, 0.5f);
            this.brJ.setOnClickListener(this.bsC);
        }
    }

    public final void a(int i, View view) {
        Object obj = null;
        bo boVar;
        switch (i) {
            case 1:
                boVar = this.bsA;
                if (boVar != null) {
                    obj = 1;
                }
                if (obj != null) {
                    boVar.onClose();
                    return;
                }
                return;
            case 2:
                boVar = this.bsA;
                if (boVar != null) {
                    obj = 1;
                }
                if (obj != null) {
                    boVar.ahm();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
