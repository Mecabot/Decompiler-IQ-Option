package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.x.R;

/* compiled from: FragmentVipChooseTimeBindingImpl */
public class tw extends tv {
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
        awV.put(R.id.today_title, 4);
        awV.put(R.id.today_periods, 5);
        awV.put(R.id.next_day_title, 6);
        awV.put(R.id.next_day_periods, 7);
        awV.put(R.id.next_next_day_title, 8);
        awV.put(R.id.next_next_day_periods, 9);
        awV.put(R.id.cancel, 10);
        awV.put(R.id.action_button, 11);
    }

    public tw(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 12, awU, awV));
    }

    private tw(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[11], (FrameLayout) objArr[0], (TextView) objArr[10], (ImageView) objArr[3], (LinearLayout) objArr[1], (RecyclerView) objArr[7], (TextView) objArr[6], (RecyclerView) objArr[9], (TextView) objArr[8], (TextView) objArr[2], (RecyclerView) objArr[5], (TextView) objArr[4]);
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
