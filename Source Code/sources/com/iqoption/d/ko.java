package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.e.a.a.a;
import com.iqoption.fragment.at;
import com.iqoption.x.R;

/* compiled from: DigitalExpirationFragmentBindingImpl */
public class ko extends kn implements a {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @Nullable
    private final OnClickListener bvt;

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        awV.put(R.id.contentLayout, 1);
        awV.put(R.id.mainLinearLayout, 2);
        awV.put(R.id.expTitle, 3);
        awV.put(R.id.strikeTitle, 4);
        awV.put(R.id.profitTitle, 5);
        awV.put(R.id.priceTitle, 6);
        awV.put(R.id.expirtionList, 7);
        awV.put(R.id.strikeList, 8);
        awV.put(R.id.autoSelectionStrike, 9);
        awV.put(R.id.spotTabsTitle, 10);
        awV.put(R.id.spotTabs, 11);
    }

    public ko(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 12, awU, awV));
    }

    private ko(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (SwitchCompat) objArr[9], (FrameLayout) objArr[1], (FrameLayout) objArr[0], (TextView) objArr[3], (RecyclerView) objArr[7], (LinearLayout) objArr[2], (TextView) objArr[6], (TextView) objArr[5], (TabLayout) objArr[11], (TextView) objArr[10], (RecyclerView) objArr[8], (TextView) objArr[4]);
        this.awW = -1;
        this.bjF.setTag(null);
        setRootTag(view);
        this.bvt = new com.iqoption.e.a.a(this, 1);
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
        a((at) obj);
        return true;
    }

    public void a(@Nullable at atVar) {
        this.bvs = atVar;
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
        at atVar = this.bvs;
        if ((j & 2) != 0) {
            this.bjF.setOnClickListener(this.bvt);
        }
    }

    public final void a(int i, View view) {
        at atVar = this.bvs;
        if ((atVar != null ? 1 : null) != null) {
            atVar.aN();
        }
    }
}
