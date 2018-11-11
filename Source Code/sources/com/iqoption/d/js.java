package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.SwitchCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.iqoption.core.ui.a;
import com.iqoption.view.RobotoTextView;
import com.iqoption.x.R;

/* compiled from: DialogTpslBindingImpl */
public class js extends jr {
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
        awV.put(R.id.toolbar, 2);
        awV.put(R.id.titleDialog, 3);
        awV.put(R.id.closeButton, 4);
        awV.put(R.id.paramsBar, 5);
        awV.put(R.id.valueTitle, 6);
        awV.put(R.id.valuePrice, 7);
        awV.put(R.id.valuePercente, 8);
        awV.put(R.id.activeName, 9);
        awV.put(R.id.warningText, 10);
        awV.put(R.id.takeProfitSwitcher, 11);
        awV.put(R.id.takeProfitAdd, 12);
        awV.put(R.id.textView, 13);
        awV.put(R.id.takeProfitEdit, 14);
        awV.put(R.id.takeProfitValue, 15);
        awV.put(R.id.takeProfitEditControl, 16);
        awV.put(R.id.takeProfitInputDecr, 17);
        awV.put(R.id.takeProfitInputFrame, 18);
        awV.put(R.id.takeProfitInput, 19);
        awV.put(R.id.takeProfitInputIncr, 20);
        awV.put(R.id.takeProfitResultTouch, 21);
        awV.put(R.id.takeProfitResult, 22);
        awV.put(R.id.takeProfitRemove, 23);
        awV.put(R.id.stopLossSwitcher, 24);
        awV.put(R.id.stopLossAdd, 25);
        awV.put(R.id.stopLossEdit, 26);
        awV.put(R.id.stopLossValue, 27);
        awV.put(R.id.stopLossEditControl, 28);
        awV.put(R.id.stopLossInputDecr, 29);
        awV.put(R.id.stopLossInputFrame, 30);
        awV.put(R.id.stopLossInput, 31);
        awV.put(R.id.stopLossInputIncr, 32);
        awV.put(R.id.stopLossResultTouch, 33);
        awV.put(R.id.stopLossResult, 34);
        awV.put(R.id.stopLossRemove, 35);
        awV.put(R.id.trailingStopContainer, 36);
        awV.put(R.id.trailingStop, 37);
        awV.put(R.id.marginAddOn, 38);
        awV.put(R.id.cancel, 39);
        awV.put(R.id.save, 40);
    }

    public js(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 41, awU, awV));
    }

    private js(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RobotoTextView) objArr[9], (RobotoTextView) objArr[39], (ImageView) objArr[4], (ImageView) objArr[1], (SwitchCompat) objArr[38], (FrameLayout) objArr[5], (RobotoTextView) objArr[40], (LinearLayout) objArr[25], (LinearLayout) objArr[26], (LinearLayout) objArr[28], (RobotoTextView) objArr[31], (ImageView) objArr[29], (FrameLayout) objArr[30], (ImageView) objArr[32], (ImageView) objArr[35], (RobotoTextView) objArr[34], (FrameLayout) objArr[33], (ViewSwitcher) objArr[24], (RobotoTextView) objArr[27], (LinearLayout) objArr[12], (LinearLayout) objArr[14], (LinearLayout) objArr[16], (RobotoTextView) objArr[19], (ImageView) objArr[17], (FrameLayout) objArr[18], (ImageView) objArr[20], (ImageView) objArr[23], (RobotoTextView) objArr[22], (FrameLayout) objArr[21], (ViewSwitcher) objArr[11], (RobotoTextView) objArr[15], (TextView) objArr[13], (TextView) objArr[3], (RelativeLayout) objArr[2], (SwitchCompat) objArr[37], (FrameLayout) objArr[36], (RobotoTextView) objArr[8], (RobotoTextView) objArr[7], (TextView) objArr[6], (RobotoTextView) objArr[10]);
        this.awW = -1;
        this.btO.setTag(null);
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
        long j;
        synchronized (this) {
            j = this.awW;
            this.awW = 0;
        }
        if ((j & 1) != 0) {
            a.a(this.btO, (Void) null);
        }
    }
}
