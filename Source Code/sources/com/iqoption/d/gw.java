package com.iqoption.d;

import android.arch.lifecycle.LifecycleOwner;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.deposit.old.PayMethodSelector;
import com.iqoption.view.ConfirmButtonView;
import com.iqoption.x.R;

/* compiled from: DepositPageContentNoBonusOldBindingImpl */
public class gw extends gv {
    @Nullable
    private static final IncludedLayouts awU = new IncludedLayouts(13);
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @NonNull
    private final FrameLayout biH;

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        awU.setIncludes(1, new String[]{"deposit_old_amount_line", "deposit_old_3ds", "deposit_terms_layout"}, new int[]{2, 3, 4}, new int[]{R.layout.deposit_old_amount_line, R.layout.deposit_old_3ds, R.layout.deposit_terms_layout});
        awV.put(R.id.depositPageContentRoot, 5);
        awV.put(R.id.paymentMethodTextView, 6);
        awV.put(R.id.paymentMethodSelector, 7);
        awV.put(R.id.paymentMethodError, 8);
        awV.put(R.id.depositAmountError, 9);
        awV.put(R.id.depositsContainer, 10);
        awV.put(R.id.depositButton, 11);
        awV.put(R.id.veil, 12);
    }

    public gw(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 13, awU, awV));
    }

    private gw(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (gi) objArr[3], (TextView) objArr[9], (gk) objArr[2], (ConfirmButtonView) objArr[11], (LinearLayout) objArr[5], (RecyclerView) objArr[10], (LinearLayout) objArr[1], (TextView) objArr[8], (PayMethodSelector) objArr[7], (TextView) objArr[6], (hl) objArr[4], (View) objArr[12]);
        this.awW = -1;
        this.biH = (FrameLayout) objArr[0];
        this.biH.setTag(null);
        this.bqs.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.awW = 8;
        }
        this.bqq.invalidateAll();
        this.bqp.invalidateAll();
        this.bqe.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Missing block: B:8:0x0013, code:
            if (r5.bqq.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Missing block: B:9:0x0015, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:11:0x001c, code:
            if (r5.bqp.hasPendingBindings() == false) goto L_0x001f;
     */
    /* JADX WARNING: Missing block: B:12:0x001e, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:14:0x0025, code:
            if (r5.bqe.hasPendingBindings() == false) goto L_0x0028;
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
        r1 = r5.bqq;
        r1 = r1.hasPendingBindings();
        if (r1 == 0) goto L_0x0016;
    L_0x0015:
        return r0;
    L_0x0016:
        r1 = r5.bqp;
        r1 = r1.hasPendingBindings();
        if (r1 == 0) goto L_0x001f;
    L_0x001e:
        return r0;
    L_0x001f:
        r1 = r5.bqe;
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
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.d.gw.hasPendingBindings():boolean");
    }

    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.bqq.setLifecycleOwner(lifecycleOwner);
        this.bqp.setLifecycleOwner(lifecycleOwner);
        this.bqe.setLifecycleOwner(lifecycleOwner);
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return a((gk) obj, i2);
            case 1:
                return a((gi) obj, i2);
            case 2:
                return a((hl) obj, i2);
            default:
                return false;
        }
    }

    private boolean a(gk gkVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.awW |= 1;
        }
        return true;
    }

    private boolean a(gi giVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.awW |= 2;
        }
        return true;
    }

    private boolean a(hl hlVar, int i) {
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
        ViewDataBinding.executeBindingsOn(this.bqq);
        ViewDataBinding.executeBindingsOn(this.bqp);
        ViewDataBinding.executeBindingsOn(this.bqe);
    }
}
