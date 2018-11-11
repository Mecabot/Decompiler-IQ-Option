package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.x.R;

/* compiled from: FragmentVipRequestCallBindingImpl */
public class ua extends tz {
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
        awV.put(R.id.main, 1);
        awV.put(R.id.title, 2);
        awV.put(R.id.close_button, 3);
        awV.put(R.id.working_hours_title, 4);
        awV.put(R.id.working_hours, 5);
        awV.put(R.id.time_container, 6);
        awV.put(R.id.when_should_we_call_you, 7);
        awV.put(R.id.call_time, 8);
        awV.put(R.id.direct_call, 9);
        awV.put(R.id.manager_phone, 10);
        awV.put(R.id.cancel, 11);
        awV.put(R.id.action_button, 12);
    }

    public ua(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 13, awU, awV));
    }

    private ua(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[12], (FrameLayout) objArr[0], (TextView) objArr[8], (TextView) objArr[11], (ImageView) objArr[3], (TextView) objArr[9], (LinearLayout) objArr[1], (TextView) objArr[10], (LinearLayout) objArr[6], (TextView) objArr[2], (TextView) objArr[7], (TextView) objArr[5], (TextView) objArr[4]);
        this.awW = -1;
        this.bFR.setTag(null);
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
