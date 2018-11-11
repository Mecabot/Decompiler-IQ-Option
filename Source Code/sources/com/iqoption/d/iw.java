package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.e.a.a.a;
import com.iqoption.fragment.bt;
import com.iqoption.view.RobotoTextView;
import com.iqoption.x.R;

/* compiled from: DialogOtnCommisionChangedBindingImpl */
public class iw extends iv implements a {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @Nullable
    private final OnClickListener bsN;

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        awV.put(R.id.contentLayout, 1);
        awV.put(R.id.content, 2);
        awV.put(R.id.currentBalance, 3);
        awV.put(R.id.currentCurrency, 4);
        awV.put(R.id.currentValueBalance, 5);
        awV.put(R.id.otnBalance, 6);
        awV.put(R.id.otnCurrency, 7);
        awV.put(R.id.otnInfoValueTitle, 8);
        awV.put(R.id.otnValueBalance, 9);
        awV.put(R.id.otnInfoValue, 10);
        awV.put(R.id.info, 11);
    }

    public iw(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 12, awU, awV));
    }

    private iw(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[2], (FrameLayout) objArr[1], (LinearLayout) objArr[3], (TextView) objArr[4], (RobotoTextView) objArr[5], (RobotoTextView) objArr[11], (LinearLayout) objArr[6], (TextView) objArr[7], (RobotoTextView) objArr[10], (RobotoTextView) objArr[8], (RobotoTextView) objArr[9], (FrameLayout) objArr[0]);
        this.awW = -1;
        this.brJ.setTag(null);
        setRootTag(view);
        this.bsN = new com.iqoption.e.a.a(this, 1);
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
        a((bt) obj);
        return true;
    }

    public void a(@Nullable bt btVar) {
        this.bsM = btVar;
        synchronized (this) {
            this.awW |= 1;
        }
        notifyPropertyChanged(1);
        super.requestRebind();
    }

    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.awW;
            this.awW = 0;
        }
        bt btVar = this.bsM;
        if ((j & 2) != 0) {
            this.brJ.setOnClickListener(this.bsN);
        }
    }

    public final void a(int i, View view) {
        bt btVar = this.bsM;
        if ((btVar != null ? 1 : null) != null) {
            btVar.onClose();
        }
    }
}
