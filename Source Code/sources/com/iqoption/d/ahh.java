package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.dialog.f;
import com.iqoption.x.R;

/* compiled from: RateUsDialogBindingImpl */
public class ahh extends ahg {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        awV.put(R.id.contentLayout, 1);
        awV.put(R.id.star1, 2);
        awV.put(R.id.star2, 3);
        awV.put(R.id.star3, 4);
        awV.put(R.id.star4, 5);
        awV.put(R.id.star5, 6);
        awV.put(R.id.count_star, 7);
        awV.put(R.id.info_text_rate_us, 8);
        awV.put(R.id.cancel, 9);
        awV.put(R.id.next, 10);
    }

    public ahh(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 11, awU, awV));
    }

    private ahh(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[9], (LinearLayout) objArr[1], (TextView) objArr[7], (TextView) objArr[8], (TextView) objArr[10], (FrameLayout) objArr[0], (ImageView) objArr[2], (ImageView) objArr[3], (ImageView) objArr[4], (ImageView) objArr[5], (ImageView) objArr[6]);
        this.awW = -1;
        this.brJ.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.awW = 2;
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

    public boolean setVariable(int i, @Nullable Object obj) {
        if (1 != i) {
            return false;
        }
        a((f) obj);
        return true;
    }

    public void a(@Nullable f fVar) {
        this.bQH = fVar;
    }

    protected void executeBindings() {
        synchronized (this) {
            long j = this.awW;
            this.awW = 0;
        }
    }
}
