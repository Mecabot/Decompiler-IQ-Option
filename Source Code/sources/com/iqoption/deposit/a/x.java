package com.iqoption.deposit.a;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.iqoption.core.ui.a;
import com.iqoption.deposit.r.f;

/* compiled from: FragmentPaymentCompletedLightBindingImpl */
public class x extends w {
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
        awV.put(f.back, 2);
        awV.put(f.title, 3);
        awV.put(f.progressLogo, 4);
        awV.put(f.resultTextTitle, 5);
        awV.put(f.resultText, 6);
        awV.put(f.line1, 7);
        awV.put(f.buyingText, 8);
        awV.put(f.startTradingButton, 9);
        awV.put(f.tryAgainButton, 10);
        awV.put(f.contactSupportButton, 11);
    }

    public x(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 12, awU, awV));
    }

    private x(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[2], (TextView) objArr[8], (TextView) objArr[11], (TextView) objArr[1], (LinearLayout) objArr[0], (TextView) objArr[7], (LottieAnimationView) objArr[4], (TextView) objArr[6], (TextView) objArr[5], (TextView) objArr[9], (TextView) objArr[3], (TextView) objArr[10]);
        this.awW = -1;
        this.bZw.setTag(null);
        this.bZx.setTag(null);
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
            a.d(this.bZw, 0.5f);
        }
    }
}
