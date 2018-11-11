package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.databinding.ViewStubProxy;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewStub;
import android.widget.AbsoluteLayout;
import android.widget.ImageView;
import com.iqoption.x.R;

/* compiled from: FragmentTutorialBindingImpl */
public class te extends td {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @NonNull
    private final AbsoluteLayout bFb;

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        awV.put(R.id.tutorialLeftDialogStub, 1);
        awV.put(R.id.tutorialRightDialogStub, 2);
        awV.put(R.id.tutorialPointerImageView, 3);
    }

    public te(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, awU, awV));
    }

    private te(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, new ViewStubProxy((ViewStub) objArr[1]), (ImageView) objArr[3], new ViewStubProxy((ViewStub) objArr[2]));
        this.awW = -1;
        this.bFb = (AbsoluteLayout) objArr[0];
        this.bFb.setTag(null);
        this.bEY.setContainingBinding(this);
        this.bFa.setContainingBinding(this);
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
        if (this.bEY.getBinding() != null) {
            ViewDataBinding.executeBindingsOn(this.bEY.getBinding());
        }
        if (this.bFa.getBinding() != null) {
            ViewDataBinding.executeBindingsOn(this.bFa.getBinding());
        }
    }
}
