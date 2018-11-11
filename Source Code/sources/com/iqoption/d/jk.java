package com.iqoption.d;

import android.arch.lifecycle.LifecycleOwner;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import com.iqoption.x.R;

/* compiled from: DialogProTraderBenefitsBindingImpl */
public class jk extends jj {
    @Nullable
    private static final IncludedLayouts awU = new IncludedLayouts(7);
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @NonNull
    private final TableLayout btz;

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        awU.setIncludes(2, new String[]{"layout_pro_trader_benefits_top_row", "layout_pro_trader_benefits_bottom_row"}, new int[]{4, 5}, new int[]{R.layout.layout_pro_trader_benefits_top_row, R.layout.layout_pro_trader_benefits_bottom_row});
        awU.setIncludes(1, new String[]{"layout_dialog_toolbar"}, new int[]{3}, new int[]{R.layout.layout_dialog_toolbar});
        awV.put(R.id.proBenefitsAccessToHigherLeverages, 6);
    }

    public jk(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, awU, awV));
    }

    private jk(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (FrameLayout) objArr[0], (TextView) objArr[6], (wx) objArr[5], (LinearLayout) objArr[1], (wv) objArr[3], (wz) objArr[4]);
        this.awW = -1;
        this.bjF.setTag(null);
        this.btz = (TableLayout) objArr[2];
        this.btz.setTag(null);
        this.btw.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.awW = 8;
        }
        this.btx.invalidateAll();
        this.bty.invalidateAll();
        this.btv.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Missing block: B:8:0x0013, code:
            if (r5.btx.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Missing block: B:9:0x0015, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:11:0x001c, code:
            if (r5.bty.hasPendingBindings() == false) goto L_0x001f;
     */
    /* JADX WARNING: Missing block: B:12:0x001e, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:14:0x0025, code:
            if (r5.btv.hasPendingBindings() == false) goto L_0x0028;
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
        r1 = r5.btx;
        r1 = r1.hasPendingBindings();
        if (r1 == 0) goto L_0x0016;
    L_0x0015:
        return r0;
    L_0x0016:
        r1 = r5.bty;
        r1 = r1.hasPendingBindings();
        if (r1 == 0) goto L_0x001f;
    L_0x001e:
        return r0;
    L_0x001f:
        r1 = r5.btv;
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
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.d.jk.hasPendingBindings():boolean");
    }

    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.btx.setLifecycleOwner(lifecycleOwner);
        this.bty.setLifecycleOwner(lifecycleOwner);
        this.btv.setLifecycleOwner(lifecycleOwner);
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return a((wx) obj, i2);
            case 1:
                return a((wz) obj, i2);
            case 2:
                return a((wv) obj, i2);
            default:
                return false;
        }
    }

    private boolean a(wx wxVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.awW |= 1;
        }
        return true;
    }

    private boolean a(wz wzVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.awW |= 2;
        }
        return true;
    }

    private boolean a(wv wvVar, int i) {
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
        ViewDataBinding.executeBindingsOn(this.btx);
        ViewDataBinding.executeBindingsOn(this.bty);
        ViewDataBinding.executeBindingsOn(this.btv);
    }
}
