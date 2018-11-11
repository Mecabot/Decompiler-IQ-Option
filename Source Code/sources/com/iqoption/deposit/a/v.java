package com.iqoption.deposit.a;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.iqoption.core.ui.a;
import com.iqoption.deposit.r.f;

/* compiled from: FragmentPaymentCompletedBindingImpl */
public class v extends u {
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
        awV.put(f.copyErrorMessage, 8);
        awV.put(f.buyingText, 9);
        awV.put(f.contactSupportButton, 10);
    }

    public v(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 11, awU, awV));
    }

    private v(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[2], (TextView) objArr[9], (TextView) objArr[10], (LinearLayout) objArr[8], (TextView) objArr[1], (ConstraintLayout) objArr[0], (TextView) objArr[7], (LottieAnimationView) objArr[4], (TextView) objArr[6], (TextView) objArr[5], (TextView) objArr[3]);
        this.awW = -1;
        this.bZq.setTag(null);
        this.bZr.setTag(null);
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
            a.a(this.bZq, (Void) null);
        }
    }
}
