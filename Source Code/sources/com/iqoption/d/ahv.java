package com.iqoption.d;

import android.arch.lifecycle.LifecycleOwner;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.iqoption.view.CryptoAssetPager;
import com.iqoption.x.R;

/* compiled from: RightPanelDelegateCryptoBindingImpl */
public class ahv extends ahu {
    @Nullable
    private static final IncludedLayouts awU = new IncludedLayouts(8);
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @NonNull
    private final FrameLayout bRU;
    @NonNull
    private final RelativeLayout boJ;

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        awU.setIncludes(0, new String[]{"right_panel_delegate_crypto_confirmation"}, new int[]{6}, new int[]{R.layout.right_panel_delegate_crypto_confirmation});
        awU.setIncludes(1, new String[]{"right_panel_delegate_crypto_main", "right_panel_delegate_crypto_loading", "right_panel_delegate_crypto_success", "right_panel_delegate_crypto_closed"}, new int[]{2, 3, 4, 5}, new int[]{R.layout.right_panel_delegate_crypto_main, R.layout.right_panel_delegate_crypto_loading, R.layout.right_panel_delegate_crypto_success, R.layout.right_panel_delegate_crypto_closed});
        awV.put(R.id.assetPager, 7);
    }

    public ahv(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, awU, awV));
    }

    private ahv(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 5, (CryptoAssetPager) objArr[7], (ahw) objArr[5], (ahy) objArr[6], (aia) objArr[3], (aic) objArr[2], (aie) objArr[4]);
        this.awW = -1;
        this.boJ = (RelativeLayout) objArr[0];
        this.boJ.setTag(null);
        this.bRU = (FrameLayout) objArr[1];
        this.bRU.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.awW = 32;
        }
        this.bRS.invalidateAll();
        this.bRR.invalidateAll();
        this.bRT.invalidateAll();
        this.bRP.invalidateAll();
        this.bRQ.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Missing block: B:8:0x0013, code:
            if (r5.bRS.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Missing block: B:9:0x0015, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:11:0x001c, code:
            if (r5.bRR.hasPendingBindings() == false) goto L_0x001f;
     */
    /* JADX WARNING: Missing block: B:12:0x001e, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:14:0x0025, code:
            if (r5.bRT.hasPendingBindings() == false) goto L_0x0028;
     */
    /* JADX WARNING: Missing block: B:15:0x0027, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:17:0x002e, code:
            if (r5.bRP.hasPendingBindings() == false) goto L_0x0031;
     */
    /* JADX WARNING: Missing block: B:18:0x0030, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:20:0x0037, code:
            if (r5.bRQ.hasPendingBindings() == false) goto L_0x003a;
     */
    /* JADX WARNING: Missing block: B:21:0x0039, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:23:0x003b, code:
            return false;
     */
    public boolean hasPendingBindings() {
        /*
        r5 = this;
        monitor-enter(r5);
        r0 = r5.awW;	 Catch:{ all -> 0x003c }
        r2 = 0;
        r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        r0 = 1;
        if (r4 == 0) goto L_0x000c;
    L_0x000a:
        monitor-exit(r5);	 Catch:{ all -> 0x003c }
        return r0;
    L_0x000c:
        monitor-exit(r5);	 Catch:{ all -> 0x003c }
        r1 = r5.bRS;
        r1 = r1.hasPendingBindings();
        if (r1 == 0) goto L_0x0016;
    L_0x0015:
        return r0;
    L_0x0016:
        r1 = r5.bRR;
        r1 = r1.hasPendingBindings();
        if (r1 == 0) goto L_0x001f;
    L_0x001e:
        return r0;
    L_0x001f:
        r1 = r5.bRT;
        r1 = r1.hasPendingBindings();
        if (r1 == 0) goto L_0x0028;
    L_0x0027:
        return r0;
    L_0x0028:
        r1 = r5.bRP;
        r1 = r1.hasPendingBindings();
        if (r1 == 0) goto L_0x0031;
    L_0x0030:
        return r0;
    L_0x0031:
        r1 = r5.bRQ;
        r1 = r1.hasPendingBindings();
        if (r1 == 0) goto L_0x003a;
    L_0x0039:
        return r0;
    L_0x003a:
        r0 = 0;
        return r0;
    L_0x003c:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x003c }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.d.ahv.hasPendingBindings():boolean");
    }

    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.bRS.setLifecycleOwner(lifecycleOwner);
        this.bRR.setLifecycleOwner(lifecycleOwner);
        this.bRT.setLifecycleOwner(lifecycleOwner);
        this.bRP.setLifecycleOwner(lifecycleOwner);
        this.bRQ.setLifecycleOwner(lifecycleOwner);
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return a((ahw) obj, i2);
            case 1:
                return a((ahy) obj, i2);
            case 2:
                return a((aic) obj, i2);
            case 3:
                return a((aia) obj, i2);
            case 4:
                return a((aie) obj, i2);
            default:
                return false;
        }
    }

    private boolean a(ahw ahw, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.awW |= 1;
        }
        return true;
    }

    private boolean a(ahy ahy, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.awW |= 2;
        }
        return true;
    }

    private boolean a(aic aic, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.awW |= 4;
        }
        return true;
    }

    private boolean a(aia aia, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.awW |= 8;
        }
        return true;
    }

    private boolean a(aie aie, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.awW |= 16;
        }
        return true;
    }

    protected void executeBindings() {
        synchronized (this) {
            long j = this.awW;
            this.awW = 0;
        }
        ViewDataBinding.executeBindingsOn(this.bRS);
        ViewDataBinding.executeBindingsOn(this.bRR);
        ViewDataBinding.executeBindingsOn(this.bRT);
        ViewDataBinding.executeBindingsOn(this.bRP);
        ViewDataBinding.executeBindingsOn(this.bRQ);
    }
}
