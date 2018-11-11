package com.iqoption.dialogs.a;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.iqoption.core.ui.a;
import com.iqoption.core.ui.widget.MaxSizeConstraintLayout;
import com.iqoption.dialogs.c.c;

/* compiled from: DialogSimpleBindingImpl */
public class d extends c {
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
        awV.put(c.title, 2);
        awV.put(c.text, 3);
        awV.put(c.info, 4);
        awV.put(c.btnAction1, 5);
        awV.put(c.btnAction2, 6);
    }

    public d(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, awU, awV));
    }

    private d(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[5], (TextView) objArr[6], (MaxSizeConstraintLayout) objArr[1], (TextView) objArr[4], (FrameLayout) objArr[0], (TextView) objArr[3], (TextView) objArr[2]);
        this.awW = -1;
        this.btF.setTag(null);
        this.awS.setTag(null);
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
            a.j(this.btF, ViewDataBinding.getColorFromResource(this.btF, com.iqoption.dialogs.c.a.simple_dialog_bg));
        }
    }
}
