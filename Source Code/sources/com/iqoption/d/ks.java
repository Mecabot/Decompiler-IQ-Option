package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.iqoption.x.R;

/* compiled from: FeedBottomPanelBindingImpl */
public class ks extends kr {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @NonNull
    private final LinearLayout buZ;

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        awV.put(R.id.button_title, 3);
        awV.put(R.id.price_and_gain, 4);
        awV.put(R.id.like_animation, 5);
        awV.put(R.id.like_counter, 6);
        awV.put(R.id.views_count, 7);
    }

    public ks(@Nullable DataBindingComponent dataBindingComponent, @NonNull View[] viewArr) {
        this(dataBindingComponent, viewArr, ViewDataBinding.mapBindings(dataBindingComponent, viewArr, 8, awU, awV));
    }

    private ks(DataBindingComponent dataBindingComponent, View[] viewArr, Object[] objArr) {
        super(dataBindingComponent, viewArr[0], 0, (LinearLayout) objArr[1], (Space) objArr[0], (TextView) objArr[3], (LottieAnimationView) objArr[5], (TextView) objArr[6], (TextView) objArr[4], (TextView) objArr[7]);
        this.awW = -1;
        this.bvE.setTag(null);
        this.bvF.setTag(null);
        this.buZ = (LinearLayout) objArr[2];
        this.buZ.setTag(null);
        setRootTag(viewArr);
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
