package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.TextViewBindingAdapter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Guideline;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Space;
import android.widget.TextView;
import com.iqoption.view.NumberAnimateRobotoTextView;
import com.iqoption.view.NumberAnimateTextView;
import com.iqoption.view.RobotoTextView;
import com.iqoption.x.R;

/* compiled from: RightPanelDelegateDigitalCallPutBindingImpl */
public class aij extends aii {
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
        awV.put(R.id.maxHeightConstraintView, 3);
        awV.put(R.id.guideLineVertical50, 4);
        awV.put(R.id.guideLineVerticalStart8, 5);
        awV.put(R.id.buttonCallProfitFrame, 6);
        awV.put(R.id.buttonCallProfitFrameBackground, 7);
        awV.put(R.id.buttonPutProfitFrame, 8);
        awV.put(R.id.buttonPutProfitFrameBackground, 9);
        awV.put(R.id.buttonPutBackground, 10);
        awV.put(R.id.buttonCall, 11);
        awV.put(R.id.buttonPut, 12);
        awV.put(R.id.callProfitFrame, 13);
        awV.put(R.id.callProfitLabel, 14);
        awV.put(R.id.callProfitValue, 15);
        awV.put(R.id.callProfitPercent, 16);
        awV.put(R.id.putProfitFrame, 17);
        awV.put(R.id.putProfitLabel, 18);
        awV.put(R.id.putProfitValue, 19);
        awV.put(R.id.putProfitPercent, 20);
    }

    public aij(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 21, awU, awV));
    }

    private aij(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (FrameLayout) objArr[11], (TextView) objArr[1], (View) objArr[6], (View) objArr[7], (FrameLayout) objArr[12], (View) objArr[10], (TextView) objArr[2], (View) objArr[8], (View) objArr[9], (View) objArr[13], (RobotoTextView) objArr[14], (NumberAnimateTextView) objArr[16], (NumberAnimateRobotoTextView) objArr[15], (ConstraintLayout) objArr[0], (Guideline) objArr[4], (Guideline) objArr[5], (Space) objArr[3], (View) objArr[17], (RobotoTextView) objArr[18], (NumberAnimateTextView) objArr[20], (NumberAnimateRobotoTextView) objArr[19]);
        this.awW = -1;
        this.bSq.setTag(null);
        this.bSv.setTag(null);
        this.bSC.setTag(null);
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
            TextViewBindingAdapter.setDrawableLeft(this.bSq, ViewDataBinding.getDrawableFromResource(this.bSq, R.drawable.call_arrow));
            TextViewBindingAdapter.setDrawableLeft(this.bSv, ViewDataBinding.getDrawableFromResource(this.bSv, R.drawable.put_arrow));
        }
    }
}
