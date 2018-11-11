package com.iqoption.deposit.a;

import android.arch.lifecycle.LifecycleOwner;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.IQTextInputLayout;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.RecyclerView;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.iqoption.deposit.a;
import com.iqoption.deposit.r.f;
import com.iqoption.deposit.r.g;

/* compiled from: LayoutDepositContentBindingImpl */
public class bn extends bm {
    @Nullable
    private static final IncludedLayouts awU = new IncludedLayouts(13);
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @NonNull
    private final LinearLayout biX;
    @Nullable
    private final bo caf;
    @NonNull
    private final FrameLayout cag;

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        awU.setIncludes(1, new String[]{"layout_pay_method_selector", "layout_deposit_protected", "layout_deposit_button"}, new int[]{4, 5, 6}, new int[]{g.layout_pay_method_selector, g.layout_deposit_protected, g.layout_deposit_button});
        awU.setIncludes(2, new String[]{"layout_currency_selector"}, new int[]{3}, new int[]{g.layout_currency_selector});
        awV.put(f.depositAmountInput, 7);
        awV.put(f.depositAmountEdit, 8);
        awV.put(f.depositPresetsList, 9);
        awV.put(f.depositFields, 10);
        awV.put(f.bottomFocusableView, 11);
        awV.put(f.depositTerms, 12);
    }

    public bn(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 13, awU, awV));
    }

    private bn(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (View) objArr[11], (be) objArr[3], (TextInputEditText) objArr[8], (IQTextInputLayout) objArr[7], (bi) objArr[6], (FrameLayout) objArr[10], (RecyclerView) objArr[9], (ScrollView) objArr[0], (TextView) objArr[12], (bx) objArr[4]);
        this.awW = -1;
        this.cad.setTag(null);
        this.biX = (LinearLayout) objArr[1];
        this.biX.setTag(null);
        this.caf = (bo) objArr[5];
        setContainedBinding(this.caf);
        this.cag = (FrameLayout) objArr[2];
        this.cag.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.awW = 8;
        }
        this.bZZ.invalidateAll();
        this.cae.invalidateAll();
        this.caf.invalidateAll();
        this.cac.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Missing block: B:8:0x0013, code:
            if (r5.bZZ.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Missing block: B:9:0x0015, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:11:0x001c, code:
            if (r5.cae.hasPendingBindings() == false) goto L_0x001f;
     */
    /* JADX WARNING: Missing block: B:12:0x001e, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:14:0x0025, code:
            if (r5.caf.hasPendingBindings() == false) goto L_0x0028;
     */
    /* JADX WARNING: Missing block: B:15:0x0027, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:17:0x002e, code:
            if (r5.cac.hasPendingBindings() == false) goto L_0x0031;
     */
    /* JADX WARNING: Missing block: B:18:0x0030, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:20:0x0032, code:
            return false;
     */
    public boolean hasPendingBindings() {
        /*
        r5 = this;
        monitor-enter(r5);
        r0 = r5.awW;	 Catch:{ all -> 0x0033 }
        r2 = 0;
        r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        r0 = 1;
        if (r4 == 0) goto L_0x000c;
    L_0x000a:
        monitor-exit(r5);	 Catch:{ all -> 0x0033 }
        return r0;
    L_0x000c:
        monitor-exit(r5);	 Catch:{ all -> 0x0033 }
        r1 = r5.bZZ;
        r1 = r1.hasPendingBindings();
        if (r1 == 0) goto L_0x0016;
    L_0x0015:
        return r0;
    L_0x0016:
        r1 = r5.cae;
        r1 = r1.hasPendingBindings();
        if (r1 == 0) goto L_0x001f;
    L_0x001e:
        return r0;
    L_0x001f:
        r1 = r5.caf;
        r1 = r1.hasPendingBindings();
        if (r1 == 0) goto L_0x0028;
    L_0x0027:
        return r0;
    L_0x0028:
        r1 = r5.cac;
        r1 = r1.hasPendingBindings();
        if (r1 == 0) goto L_0x0031;
    L_0x0030:
        return r0;
    L_0x0031:
        r0 = 0;
        return r0;
    L_0x0033:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x0033 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.deposit.a.bn.hasPendingBindings():boolean");
    }

    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.bZZ.setLifecycleOwner(lifecycleOwner);
        this.cae.setLifecycleOwner(lifecycleOwner);
        this.caf.setLifecycleOwner(lifecycleOwner);
        this.cac.setLifecycleOwner(lifecycleOwner);
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return a((bx) obj, i2);
            case 1:
                return a((be) obj, i2);
            case 2:
                return a((bi) obj, i2);
            default:
                return false;
        }
    }

    private boolean a(bx bxVar, int i) {
        if (i != a.pb) {
            return false;
        }
        synchronized (this) {
            this.awW |= 1;
        }
        return true;
    }

    private boolean a(be beVar, int i) {
        if (i != a.pb) {
            return false;
        }
        synchronized (this) {
            this.awW |= 2;
        }
        return true;
    }

    private boolean a(bi biVar, int i) {
        if (i != a.pb) {
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
        ViewDataBinding.executeBindingsOn(this.bZZ);
        ViewDataBinding.executeBindingsOn(this.cae);
        ViewDataBinding.executeBindingsOn(this.caf);
        ViewDataBinding.executeBindingsOn(this.cac);
    }
}
