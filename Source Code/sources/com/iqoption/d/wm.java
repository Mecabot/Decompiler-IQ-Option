package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.iqoption.view.ColorPickerView;
import com.iqoption.view.WidthPickerView;
import com.iqoption.x.R;

/* compiled from: KdjDialogBindingImpl */
public class wm extends wl {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @NonNull
    private final LinearLayout axx;

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        awV.put(R.id.smoothEdit, 1);
        awV.put(R.id.jColorEdit, 2);
        awV.put(R.id.jWidthEdit, 3);
        awV.put(R.id.dKPeriodEdit, 4);
        awV.put(R.id.dKColorEdit, 5);
        awV.put(R.id.dKWidthEdit, 6);
        awV.put(R.id.dDPeriodEdit, 7);
        awV.put(R.id.dDColorEdit, 8);
        awV.put(R.id.dDWidthEdit, 9);
        awV.put(R.id.overboughtPeriodEdit, 10);
        awV.put(R.id.overboughtColorEdit, 11);
        awV.put(R.id.overboughtWidthEdit, 12);
        awV.put(R.id.oversoldPeriodEdit, 13);
        awV.put(R.id.oversoldColorEdit, 14);
        awV.put(R.id.oversoldWidthEdit, 15);
    }

    public wm(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 16, awU, awV));
    }

    private wm(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ColorPickerView) objArr[8], (EditText) objArr[7], (WidthPickerView) objArr[9], (ColorPickerView) objArr[5], (EditText) objArr[4], (WidthPickerView) objArr[6], (ColorPickerView) objArr[2], (WidthPickerView) objArr[3], (ColorPickerView) objArr[11], (EditText) objArr[10], (WidthPickerView) objArr[12], (ColorPickerView) objArr[14], (EditText) objArr[13], (WidthPickerView) objArr[15], (EditText) objArr[1]);
        this.awW = -1;
        this.axx = (LinearLayout) objArr[0];
        this.axx.setTag(null);
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
