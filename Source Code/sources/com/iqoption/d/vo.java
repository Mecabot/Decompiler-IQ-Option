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

/* compiled from: IchimokuDialogBindingImpl */
public class vo extends vn {
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
        awV.put(R.id.senkouSpanAColorEdit, 1);
        awV.put(R.id.senkouSpanAWidthEdit, 2);
        awV.put(R.id.kijunSenPeriodEdit, 3);
        awV.put(R.id.kijunSenColorEdit, 4);
        awV.put(R.id.kijunSenWidthEdit, 5);
        awV.put(R.id.senkouSpanBPeriodEdit, 6);
        awV.put(R.id.senkouSpanBColorEdit, 7);
        awV.put(R.id.senkouSpanBWidthEdit, 8);
        awV.put(R.id.chikouSpanPeriodEdit, 9);
        awV.put(R.id.chikouSpanColorEdit, 10);
        awV.put(R.id.chikouSpanWidthEdit, 11);
        awV.put(R.id.tenkanSenPeriodEdit, 12);
        awV.put(R.id.tenkanSenColorEdit, 13);
        awV.put(R.id.tenkanSenWidthEdit, 14);
    }

    public vo(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 15, awU, awV));
    }

    private vo(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ColorPickerView) objArr[10], (EditText) objArr[9], (WidthPickerView) objArr[11], (ColorPickerView) objArr[4], (EditText) objArr[3], (WidthPickerView) objArr[5], (ColorPickerView) objArr[1], (WidthPickerView) objArr[2], (ColorPickerView) objArr[7], (EditText) objArr[6], (WidthPickerView) objArr[8], (ColorPickerView) objArr[13], (EditText) objArr[12], (WidthPickerView) objArr[14]);
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
