package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Guideline;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.e.a.a.a;
import com.iqoption.fragment.rightpanel.ab.c;
import com.iqoption.view.BuyNewDialogView;
import com.iqoption.view.ConfirmDialogView;
import com.iqoption.view.RobotoTextView;
import com.iqoption.x.R;

/* compiled from: RightPanelDelegateDigitalBindingImpl */
public class aih extends aig implements a {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @Nullable
    private final OnClickListener bSn;
    @Nullable
    private final OnClickListener bSo;

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        awV.put(R.id.guideline, 3);
        awV.put(R.id.expLabel, 4);
        awV.put(R.id.expTime, 5);
        awV.put(R.id.strikeLabel, 6);
        awV.put(R.id.strikeValue, 7);
        awV.put(R.id.expPicker, 8);
        awV.put(R.id.amountLabel, 9);
        awV.put(R.id.amountValue, 10);
        awV.put(R.id.amountPicker, 11);
        awV.put(R.id.operationLayout, 12);
        awV.put(R.id.confirmDialog, 13);
        awV.put(R.id.buyNewDialog, 14);
    }

    public aih(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 15, awU, awV));
    }

    private aih(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[9], (FrameLayout) objArr[2], (ImageView) objArr[11], (TextView) objArr[10], (BuyNewDialogView) objArr[14], (ConfirmDialogView) objArr[13], (TextView) objArr[4], (ConstraintLayout) objArr[1], (ImageView) objArr[8], (RobotoTextView) objArr[5], (Guideline) objArr[3], (FrameLayout) objArr[12], (LinearLayout) objArr[0], (TextView) objArr[6], (TextView) objArr[7]);
        this.awW = -1;
        this.bRh.setTag(null);
        this.bSf.setTag(null);
        this.bSj.setTag(null);
        setRootTag(view);
        this.bSn = new com.iqoption.e.a.a(this, 1);
        this.bSo = new com.iqoption.e.a.a(this, 2);
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
        if (3 != i) {
            return false;
        }
        a((c) obj);
        return true;
    }

    public void a(@Nullable c cVar) {
        this.bSm = cVar;
        synchronized (this) {
            this.awW |= 1;
        }
        notifyPropertyChanged(3);
        super.requestRebind();
    }

    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.awW;
            this.awW = 0;
        }
        c cVar = this.bSm;
        if ((j & 2) != 0) {
            this.bRh.setOnClickListener(this.bSo);
            com.iqoption.core.ui.a.d(this.bRh, 0.5f);
            this.bSf.setOnClickListener(this.bSn);
            com.iqoption.core.ui.a.d(this.bSf, 0.5f);
        }
    }

    public final void a(int i, View view) {
        Object obj = null;
        c cVar;
        switch (i) {
            case 1:
                cVar = this.bSm;
                if (cVar != null) {
                    obj = 1;
                }
                if (obj != null) {
                    cVar.amX();
                    return;
                }
                return;
            case 2:
                cVar = this.bSm;
                if (cVar != null) {
                    obj = 1;
                }
                if (obj != null) {
                    cVar.amY();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
