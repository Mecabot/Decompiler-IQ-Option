package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.SwitchCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.iqoption.a.r.b;
import com.iqoption.x.R;

/* compiled from: PushSettingsGroupItemBindingImpl */
public class ahf extends ahe {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @NonNull
    private final FrameLayout biH;

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        awV.put(R.id.switch_text, 1);
        awV.put(R.id.item_title, 2);
        awV.put(R.id.item_description, 3);
        awV.put(R.id.item_switch_progress, 4);
        awV.put(R.id.item_switch, 5);
    }

    public ahf(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, awU, awV));
    }

    private ahf(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[3], (SwitchCompat) objArr[5], (ProgressBar) objArr[4], (TextView) objArr[2], (LinearLayout) objArr[1]);
        this.awW = -1;
        this.biH = (FrameLayout) objArr[0];
        this.biH.setTag(null);
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
        if (5 != i) {
            return false;
        }
        a((b) obj);
        return true;
    }

    public void a(@Nullable b bVar) {
        this.bQy = bVar;
    }

    protected void executeBindings() {
        synchronized (this) {
            long j = this.awW;
            this.awW = 0;
        }
    }
}
