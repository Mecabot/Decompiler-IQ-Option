package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.TextViewBindingAdapter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import com.iqoption.core.ui.a;
import com.iqoption.x.R;

/* compiled from: ToolsContentTemplatesBindingImpl */
public class akt extends aks {
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
        awV.put(R.id.title, 3);
    }

    public akt(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, awU, awV));
    }

    private akt(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[1], (RecyclerView) objArr[2], (TextView) objArr[3], (ConstraintLayout) objArr[0]);
        this.awW = -1;
        this.bTN.setTag(null);
        this.bTK.setTag(null);
        this.bTL.setTag(null);
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
        long j;
        synchronized (this) {
            j = this.awW;
            this.awW = 0;
        }
        if ((j & 1) != 0) {
            TextViewBindingAdapter.setDrawableStart(this.bTN, ViewDataBinding.getDrawableFromResource(this.bTN, R.drawable.ic_add_template_white_24dp));
            a.g(this.bTN, 0.5f);
            a.c(this.bTN, ViewDataBinding.getColorFromResource(this.bTN, R.color.green));
            a.a(this.bTK, this.bTK.getResources().getBoolean(R.bool.isTrue));
        }
    }
}
