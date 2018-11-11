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
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.core.ui.widget.MaxSizeLinearLayout;
import com.iqoption.e.a.a.a;
import com.iqoption.fragment.rightpanel.af.c;
import com.iqoption.view.BuyNewDialogView;
import com.iqoption.view.ConfirmDialogView;
import com.iqoption.view.RobotoTextView;
import com.iqoption.x.R;

/* compiled from: RightPanelFxDelegateBindingImpl */
public class ait extends ais implements a {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @Nullable
    private final OnClickListener bTf;
    @Nullable
    private final OnClickListener bTg;

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        awV.put(R.id.guideline, 5);
        awV.put(R.id.expLabel, 6);
        awV.put(R.id.expTime, 7);
        awV.put(R.id.strikeLabel, 8);
        awV.put(R.id.strikeValue, 9);
        awV.put(R.id.expPicker, 10);
        awV.put(R.id.amountLabel, 11);
        awV.put(R.id.amountValue, 12);
        awV.put(R.id.amountPicker, 13);
        awV.put(R.id.callPut, 14);
        awV.put(R.id.putLayout, 15);
        awV.put(R.id.confirmDialog, 16);
        awV.put(R.id.buyNewDialog, 17);
    }

    public ait(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 18, awU, awV));
    }

    private ait(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[11], (FrameLayout) objArr[2], (ImageView) objArr[13], (TextView) objArr[12], (RobotoTextView) objArr[3], (RobotoTextView) objArr[4], (BuyNewDialogView) objArr[17], (LinearLayout) objArr[14], (ConfirmDialogView) objArr[16], (TextView) objArr[6], (ConstraintLayout) objArr[1], (ImageView) objArr[10], (RobotoTextView) objArr[7], (Guideline) objArr[5], (MaxSizeLinearLayout) objArr[15], (LinearLayout) objArr[0], (TextView) objArr[8], (TextView) objArr[9]);
        this.awW = -1;
        this.bRh.setTag(null);
        this.bSY.setTag(null);
        this.bSZ.setTag(null);
        this.bSf.setTag(null);
        this.bSj.setTag(null);
        setRootTag(view);
        this.bTf = new com.iqoption.e.a.a(this, 2);
        this.bTg = new com.iqoption.e.a.a(this, 1);
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
        this.bTe = cVar;
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
        c cVar = this.bTe;
        if ((j & 2) != 0) {
            this.bRh.setOnClickListener(this.bTf);
            com.iqoption.core.ui.a.d(this.bRh, 0.5f);
            TextViewBindingAdapter.setDrawableLeft(this.bSY, ViewDataBinding.getDrawableFromResource(this.bSY, R.drawable.call_arrow));
            TextViewBindingAdapter.setDrawableLeft(this.bSZ, ViewDataBinding.getDrawableFromResource(this.bSZ, R.drawable.put_arrow));
            this.bSf.setOnClickListener(this.bTg);
            com.iqoption.core.ui.a.d(this.bSf, 0.5f);
        }
    }

    public final void a(int i, View view) {
        Object obj = null;
        c cVar;
        switch (i) {
            case 1:
                cVar = this.bTe;
                if (cVar != null) {
                    obj = 1;
                }
                if (obj != null) {
                    cVar.amX();
                    return;
                }
                return;
            case 2:
                cVar = this.bTe;
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
