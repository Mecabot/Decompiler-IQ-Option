package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.iqoption.view.materialcalendar.MaterialCalendarView;
import com.iqoption.x.R;

/* compiled from: FragmentTradingHistorySetDateBindingImpl */
public class ta extends sz {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @NonNull
    private final LinearLayout axx;
    @NonNull
    private final LinearLayout biX;

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        awV.put(R.id.back, 2);
        awV.put(R.id.title, 3);
        awV.put(R.id.presetDataGroup, 4);
        awV.put(R.id.today, 5);
        awV.put(R.id.yestarday, 6);
        awV.put(R.id.lastSevenDay, 7);
        awV.put(R.id.last30days, 8);
        awV.put(R.id.threeMonths, 9);
        awV.put(R.id.calendarView, 10);
    }

    public ta(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 11, awU, awV));
    }

    private ta(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (View) objArr[2], (MaterialCalendarView) objArr[10], (RadioButton) objArr[8], (RadioButton) objArr[7], (RadioGroup) objArr[4], (RadioButton) objArr[9], (TextView) objArr[3], (RadioButton) objArr[5], (RadioButton) objArr[6]);
        this.awW = -1;
        this.axx = (LinearLayout) objArr[0];
        this.axx.setTag(null);
        this.biX = (LinearLayout) objArr[1];
        this.biX.setTag(null);
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
