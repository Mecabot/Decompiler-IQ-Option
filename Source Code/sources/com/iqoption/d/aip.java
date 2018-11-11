package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.e.a.a.a;
import com.iqoption.fragment.rightpanel.b.c;
import com.iqoption.view.BuyNewDialogView;
import com.iqoption.view.ConfirmDialogView;
import com.iqoption.view.RobotoTextView;
import com.iqoption.x.R;

/* compiled from: RightPanelDelegateTurboBinaryBindingImpl */
public class aip extends aio implements a {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @Nullable
    private final OnClickListener bSU;
    @Nullable
    private final OnClickListener bSV;
    @Nullable
    private final OnClickListener bSW;
    @Nullable
    private final OnClickListener bSX;

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        awV.put(R.id.expLabel, 5);
        awV.put(R.id.expValue, 6);
        awV.put(R.id.expPicker, 7);
        awV.put(R.id.amountLabel, 8);
        awV.put(R.id.amountValue, 9);
        awV.put(R.id.amountPicker, 10);
        awV.put(R.id.operationLayout, 11);
        awV.put(R.id.confirmDialog, 12);
        awV.put(R.id.buyNewDialog, 13);
    }

    public aip(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 14, awU, awV));
    }

    private aip(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[8], (FrameLayout) objArr[2], (TextView) objArr[3], (ImageView) objArr[10], (TextView) objArr[4], (RobotoTextView) objArr[9], (BuyNewDialogView) objArr[13], (ConfirmDialogView) objArr[12], (TextView) objArr[5], (FrameLayout) objArr[1], (ImageView) objArr[7], (RobotoTextView) objArr[6], (FrameLayout) objArr[11], (LinearLayout) objArr[0]);
        this.awW = -1;
        this.bRh.setTag(null);
        this.bRM.setTag(null);
        this.bRN.setTag(null);
        this.bSR.setTag(null);
        this.bSj.setTag(null);
        setRootTag(view);
        this.bSU = new com.iqoption.e.a.a(this, 2);
        this.bSV = new com.iqoption.e.a.a(this, 3);
        this.bSW = new com.iqoption.e.a.a(this, 1);
        this.bSX = new com.iqoption.e.a.a(this, 4);
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
        this.bST = cVar;
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
        c cVar = this.bST;
        if ((j & 2) != 0) {
            this.bRh.setOnClickListener(this.bSU);
            com.iqoption.core.ui.a.d(this.bRh, 0.5f);
            this.bRM.setOnClickListener(this.bSV);
            com.iqoption.core.ui.a.d(this.bRM, 0.5f);
            this.bRN.setOnClickListener(this.bSX);
            com.iqoption.core.ui.a.d(this.bRN, 0.5f);
            this.bSR.setOnClickListener(this.bSW);
            com.iqoption.core.ui.a.d(this.bSR, 0.5f);
        }
    }

    public final void a(int i, View view) {
        Object obj = null;
        c cVar;
        switch (i) {
            case 1:
                cVar = this.bST;
                if (cVar != null) {
                    obj = 1;
                }
                if (obj != null) {
                    cVar.amX();
                    return;
                }
                return;
            case 2:
                cVar = this.bST;
                if (cVar != null) {
                    obj = 1;
                }
                if (obj != null) {
                    cVar.amY();
                    return;
                }
                return;
            case 3:
                cVar = this.bST;
                if (cVar != null) {
                    obj = 1;
                }
                if (obj != null) {
                    cVar.amZ();
                    return;
                }
                return;
            case 4:
                cVar = this.bST;
                if (cVar != null) {
                    obj = 1;
                }
                if (obj != null) {
                    cVar.ana();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
