package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.core.ui.a;
import com.iqoption.x.R;

/* compiled from: DialogWhatsNewBindingImpl */
public class ka extends jz {
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
        awV.put(R.id.content, 5);
        awV.put(R.id.topBar, 6);
        awV.put(R.id.headerTitle, 7);
        awV.put(R.id.btnClose, 8);
        awV.put(R.id.image, 9);
        awV.put(R.id.title, 10);
        awV.put(R.id.message, 11);
    }

    public ka(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 12, awU, awV));
    }

    private ka(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[8], (TextView) objArr[3], (ImageView) objArr[2], (TextView) objArr[4], (ConstraintLayout) objArr[5], (TextView) objArr[7], (ImageView) objArr[9], (TextView) objArr[11], (TextView) objArr[10], (LinearLayout) objArr[6], (FrameLayout) objArr[0], (View) objArr[1]);
        this.awW = -1;
        this.buE.setTag(null);
        this.buF.setTag(null);
        this.buG.setTag(null);
        this.buJ.setTag(null);
        this.buK.setTag(null);
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
            a.g(this.buE, 0.5f);
            a.j(this.buE, ViewDataBinding.getColorFromResource(this.buE, R.color.grey_blue_10));
            a.a(this.buF, this.buF.getResources().getDimension(R.dimen.dp4), false);
            a.g(this.buG, 0.5f);
            a.j(this.buG, ViewDataBinding.getColorFromResource(this.buG, R.color.green));
            a.j(this.buK, ViewDataBinding.getColorFromResource(this.buK, R.color.black_10));
        }
    }
}
