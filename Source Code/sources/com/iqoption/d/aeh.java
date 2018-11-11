package com.iqoption.d;

import android.arch.lifecycle.LifecycleOwner;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.Space;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.iqoption.x.R;

/* compiled from: PortfolioDelegateBindingImpl */
public class aeh extends aeg {
    @Nullable
    private static final IncludedLayouts awU = new IncludedLayouts(12);
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        awU.setIncludes(2, new String[]{"portfolio_app_bar"}, new int[]{5}, new int[]{R.layout.portfolio_app_bar});
        awU.setIncludes(1, new String[]{"portfolio_title", "portfolio_balances"}, new int[]{3, 4}, new int[]{R.layout.portfolio_title, R.layout.portfolio_balances});
        awV.put(R.id.tabs, 6);
        awV.put(R.id.btnBack, 7);
        awV.put(R.id.appbarLayout, 8);
        awV.put(R.id.balancesStub, 9);
        awV.put(R.id.tabsStub, 10);
        awV.put(R.id.pager, 11);
    }

    public aeh(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 12, awU, awV));
    }

    private aeh(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (adq) objArr[5], (AppBarLayout) objArr[8], (FrameLayout) objArr[2], null, (adw) objArr[4], (Space) objArr[9], (ImageView) objArr[7], null, (LinearLayout) objArr[1], null, (CoordinatorLayout) objArr[0], null, (ViewPager) objArr[11], null, (TabLayout) objArr[6], (Space) objArr[10], (agd) objArr[3]);
        this.awW = -1;
        this.bPA.setTag(null);
        this.bPF.setTag(null);
        this.bHC.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.awW = 8;
        }
        this.bPL.invalidateAll();
        this.bPC.invalidateAll();
        this.bPy.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Missing block: B:8:0x0013, code:
            if (r5.bPL.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Missing block: B:9:0x0015, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:11:0x001c, code:
            if (r5.bPC.hasPendingBindings() == false) goto L_0x001f;
     */
    /* JADX WARNING: Missing block: B:12:0x001e, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:14:0x0025, code:
            if (r5.bPy.hasPendingBindings() == false) goto L_0x0028;
     */
    /* JADX WARNING: Missing block: B:15:0x0027, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:17:0x0029, code:
            return false;
     */
    public boolean hasPendingBindings() {
        /*
        r5 = this;
        monitor-enter(r5);
        r0 = r5.awW;	 Catch:{ all -> 0x002a }
        r2 = 0;
        r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        r0 = 1;
        if (r4 == 0) goto L_0x000c;
    L_0x000a:
        monitor-exit(r5);	 Catch:{ all -> 0x002a }
        return r0;
    L_0x000c:
        monitor-exit(r5);	 Catch:{ all -> 0x002a }
        r1 = r5.bPL;
        r1 = r1.hasPendingBindings();
        if (r1 == 0) goto L_0x0016;
    L_0x0015:
        return r0;
    L_0x0016:
        r1 = r5.bPC;
        r1 = r1.hasPendingBindings();
        if (r1 == 0) goto L_0x001f;
    L_0x001e:
        return r0;
    L_0x001f:
        r1 = r5.bPy;
        r1 = r1.hasPendingBindings();
        if (r1 == 0) goto L_0x0028;
    L_0x0027:
        return r0;
    L_0x0028:
        r0 = 0;
        return r0;
    L_0x002a:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x002a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.d.aeh.hasPendingBindings():boolean");
    }

    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.bPL.setLifecycleOwner(lifecycleOwner);
        this.bPC.setLifecycleOwner(lifecycleOwner);
        this.bPy.setLifecycleOwner(lifecycleOwner);
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return a((adq) obj, i2);
            case 1:
                return a((adw) obj, i2);
            case 2:
                return a((agd) obj, i2);
            default:
                return false;
        }
    }

    private boolean a(adq adq, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.awW |= 1;
        }
        return true;
    }

    private boolean a(adw adw, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.awW |= 2;
        }
        return true;
    }

    private boolean a(agd agd, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.awW |= 4;
        }
        return true;
    }

    protected void executeBindings() {
        synchronized (this) {
            long j = this.awW;
            this.awW = 0;
        }
        ViewDataBinding.executeBindingsOn(this.bPL);
        ViewDataBinding.executeBindingsOn(this.bPC);
        ViewDataBinding.executeBindingsOn(this.bPy);
    }
}
