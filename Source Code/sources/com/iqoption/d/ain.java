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
import android.widget.TextView;
import com.iqoption.view.NumberAnimateRobotoTextView;
import com.iqoption.view.NumberAnimateTextView;
import com.iqoption.view.RobotoTextView;
import com.iqoption.x.R;

/* compiled from: RightPanelDelegateSpotBindingImpl */
public class ain extends aim {
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
        awV.put(R.id.guideLineVertical50, 3);
        awV.put(R.id.guideLineVerticalStart8, 4);
        awV.put(R.id.buttonCallProfitFrame, 5);
        awV.put(R.id.buttonCallProfitFrameBackground, 6);
        awV.put(R.id.buttonPutProfitFrame, 7);
        awV.put(R.id.buttonPutProfitFrameBackground, 8);
        awV.put(R.id.putProfitFrame, 9);
        awV.put(R.id.callProfitLabel, 10);
        awV.put(R.id.putProfitValue, 11);
        awV.put(R.id.putProfitPercentFrame, 12);
        awV.put(R.id.putProfitPercent, 13);
        awV.put(R.id.callProfitFrame, 14);
        awV.put(R.id.putProfitLabel, 15);
        awV.put(R.id.callProfitValue, 16);
        awV.put(R.id.callProfitPercent, 17);
    }

    public ain(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 18, awU, awV));
    }

    private ain(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[1], (View) objArr[5], (View) objArr[6], (TextView) objArr[2], (View) objArr[7], (View) objArr[8], (View) objArr[14], (TextView) objArr[10], (NumberAnimateTextView) objArr[17], (NumberAnimateRobotoTextView) objArr[16], (ConstraintLayout) objArr[0], (Guideline) objArr[3], (Guideline) objArr[4], (View) objArr[9], (RobotoTextView) objArr[15], (NumberAnimateRobotoTextView) objArr[13], (View) objArr[12], (NumberAnimateRobotoTextView) objArr[11]);
        this.awW = -1;
        this.bSM.setTag(null);
        this.bSN.setTag(null);
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
            TextViewBindingAdapter.setDrawableLeft(this.bSM, ViewDataBinding.getDrawableFromResource(this.bSM, R.drawable.call_arrow));
            TextViewBindingAdapter.setDrawableLeft(this.bSN, ViewDataBinding.getDrawableFromResource(this.bSN, R.drawable.put_arrow));
        }
    }
}
