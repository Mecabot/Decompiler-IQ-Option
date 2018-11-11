package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.e.a.a.a;
import com.iqoption.fragment.az;
import com.iqoption.view.RobotoTextView;
import com.iqoption.x.R;

/* compiled from: ExpirationFragmentBindingImpl */
public class kq extends kp implements a {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @Nullable
    private final OnClickListener bvD;

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        awV.put(R.id.contentLayout, 1);
        awV.put(R.id.binaryContainer, 2);
        awV.put(R.id.binaryProfit, 3);
        awV.put(R.id.binaryTitle, 4);
        awV.put(R.id.turboContainer, 5);
        awV.put(R.id.turboProfit, 6);
        awV.put(R.id.turboTitle, 7);
        awV.put(R.id.binaryExpirtions, 8);
        awV.put(R.id.turboExpirtions, 9);
    }

    public kq(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 10, awU, awV));
    }

    private kq(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[2], (RecyclerView) objArr[8], (TextView) objArr[3], (RobotoTextView) objArr[4], (FrameLayout) objArr[1], (FrameLayout) objArr[0], (LinearLayout) objArr[5], (RecyclerView) objArr[9], (TextView) objArr[6], (RobotoTextView) objArr[7]);
        this.awW = -1;
        this.bjF.setTag(null);
        setRootTag(view);
        this.bvD = new com.iqoption.e.a.a(this, 1);
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
        if (2 != i) {
            return false;
        }
        a((az) obj);
        return true;
    }

    public void a(@Nullable az azVar) {
        this.bvC = azVar;
        synchronized (this) {
            this.awW |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.awW;
            this.awW = 0;
        }
        az azVar = this.bvC;
        if ((j & 2) != 0) {
            this.bjF.setOnClickListener(this.bvD);
        }
    }

    public final void a(int i, View view) {
        az azVar = this.bvC;
        if ((azVar != null ? 1 : null) != null) {
            azVar.aN();
        }
    }
}
