package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.iqoption.x.R;

/* compiled from: FragmentVerifyStatusBindingImpl */
public class tm extends tl {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @NonNull
    private final LinearLayout biX;

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        awV.put(R.id.verifyStatusImageView, 2);
        awV.put(R.id.verifyStatusTitle, 3);
        awV.put(R.id.verifyStatusCard, 4);
        awV.put(R.id.verifyStatusDescription, 5);
        awV.put(R.id.verifyStatusFooter, 6);
        awV.put(R.id.verifyStatusOther, 7);
    }

    public tm(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, awU, awV));
    }

    private tm(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[4], (FrameLayout) objArr[0], (TextView) objArr[5], (FrameLayout) objArr[6], (LottieAnimationView) objArr[2], (FrameLayout) objArr[7], (TextView) objArr[3]);
        this.awW = -1;
        this.biX = (LinearLayout) objArr[1];
        this.biX.setTag(null);
        this.bFz.setTag(null);
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
