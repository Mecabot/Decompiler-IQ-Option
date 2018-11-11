package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.x.R;

/* compiled from: VipAboutInfoBindingImpl */
public class alt extends als {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @NonNull
    private final ConstraintLayout biA;

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        awV.put(R.id.avatar, 1);
        awV.put(R.id.name_title, 2);
        awV.put(R.id.name, 3);
        awV.put(R.id.language_title, 4);
        awV.put(R.id.languages, 5);
        awV.put(R.id.information_title, 6);
        awV.put(R.id.information, 7);
        awV.put(R.id.logo, 8);
        awV.put(R.id.iq_work_duration, 9);
        awV.put(R.id.years, 10);
        awV.put(R.id.working_hours_title, 11);
        awV.put(R.id.time_icon, 12);
        awV.put(R.id.working_hours, 13);
    }

    public alt(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 14, awU, awV));
    }

    private alt(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[1], (TextView) objArr[7], (TextView) objArr[6], (TextView) objArr[9], (TextView) objArr[4], (TextView) objArr[5], (ImageView) objArr[8], (TextView) objArr[3], (TextView) objArr[2], (ImageView) objArr[12], (TextView) objArr[13], (TextView) objArr[11], (TextView) objArr[10]);
        this.awW = -1;
        this.biA = (ConstraintLayout) objArr[0];
        this.biA.setTag(null);
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
