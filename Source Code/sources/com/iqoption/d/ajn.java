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
import com.iqoption.core.ui.a;
import com.iqoption.x.R;

/* compiled from: SmallNumpadBindingImpl */
public class ajn extends ajm {
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
        awV.put(R.id.line1Dialpad, 12);
        awV.put(R.id.line2Dialpad, 13);
        awV.put(R.id.line3Dialpad, 14);
        awV.put(R.id.line4Dialpad, 15);
        awV.put(R.id.back, 16);
    }

    public ajn(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 17, awU, awV));
    }

    private ajn(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (FrameLayout) objArr[16], (TextView) objArr[10], (LinearLayout) objArr[0], (TextView) objArr[8], (TextView) objArr[5], (TextView) objArr[4], (LinearLayout) objArr[12], (LinearLayout) objArr[13], (LinearLayout) objArr[14], (LinearLayout) objArr[15], (TextView) objArr[9], (TextView) objArr[1], (TextView) objArr[7], (TextView) objArr[6], (TextView) objArr[3], (TextView) objArr[2], (TextView) objArr[11]);
        this.awW = -1;
        this.bMN.setTag(null);
        this.buM.setTag(null);
        this.bIA.setTag(null);
        this.bIB.setTag(null);
        this.bIC.setTag(null);
        this.bIJ.setTag(null);
        this.bIK.setTag(null);
        this.bIP.setTag(null);
        this.bIQ.setTag(null);
        this.bIS.setTag(null);
        this.bIV.setTag(null);
        this.bIW.setTag(null);
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
            Void voidR = (Void) null;
            a.a(this.bMN, voidR);
            a.a(this.bIA, voidR);
            a.a(this.bIB, voidR);
            a.a(this.bIC, voidR);
            a.a(this.bIJ, voidR);
            a.a(this.bIK, voidR);
            a.a(this.bIP, voidR);
            a.a(this.bIQ, voidR);
            a.a(this.bIS, voidR);
            a.a(this.bIV, voidR);
            a.a(this.bIW, voidR);
        }
    }
}
