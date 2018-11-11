package com.iqoption.d;

import android.arch.lifecycle.LifecycleOwner;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import com.iqoption.x.R;

/* compiled from: RightPanelDelegateOnOpenCfdBindingImpl */
public class ail extends aik {
    @Nullable
    private static final IncludedLayouts awU = new IncludedLayouts(3);
    @Nullable
    private static final SparseIntArray awV = null;
    private long awW;
    @NonNull
    private final FrameLayout biH;

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        awU.setIncludes(0, new String[]{"right_panel_delegate_cfd_on_open_main", "right_panel_delegate_cfd_on_open_confirmation"}, new int[]{1, 2}, new int[]{R.layout.right_panel_delegate_cfd_on_open_main, R.layout.right_panel_delegate_cfd_on_open_confirmation});
    }

    public ail(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, awU, awV));
    }

    private ail(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (ahq) objArr[2], (ahs) objArr[1]);
        this.awW = -1;
        this.biH = (FrameLayout) objArr[0];
        this.biH.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.awW = 4;
        }
        this.bSL.invalidateAll();
        this.bSK.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Missing block: B:8:0x0013, code:
            if (r5.bSL.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Missing block: B:9:0x0015, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:11:0x001c, code:
            if (r5.bSK.hasPendingBindings() == false) goto L_0x001f;
     */
    /* JADX WARNING: Missing block: B:12:0x001e, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:14:0x0020, code:
            return false;
     */
    public boolean hasPendingBindings() {
        /*
        r5 = this;
        monitor-enter(r5);
        r0 = r5.awW;	 Catch:{ all -> 0x0021 }
        r2 = 0;
        r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        r0 = 1;
        if (r4 == 0) goto L_0x000c;
    L_0x000a:
        monitor-exit(r5);	 Catch:{ all -> 0x0021 }
        return r0;
    L_0x000c:
        monitor-exit(r5);	 Catch:{ all -> 0x0021 }
        r1 = r5.bSL;
        r1 = r1.hasPendingBindings();
        if (r1 == 0) goto L_0x0016;
    L_0x0015:
        return r0;
    L_0x0016:
        r1 = r5.bSK;
        r1 = r1.hasPendingBindings();
        if (r1 == 0) goto L_0x001f;
    L_0x001e:
        return r0;
    L_0x001f:
        r0 = 0;
        return r0;
    L_0x0021:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x0021 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.d.ail.hasPendingBindings():boolean");
    }

    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.bSL.setLifecycleOwner(lifecycleOwner);
        this.bSK.setLifecycleOwner(lifecycleOwner);
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return a((ahq) obj, i2);
            case 1:
                return a((ahs) obj, i2);
            default:
                return false;
        }
    }

    private boolean a(ahq ahq, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.awW |= 1;
        }
        return true;
    }

    private boolean a(ahs ahs, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.awW |= 2;
        }
        return true;
    }

    protected void executeBindings() {
        synchronized (this) {
            long j = this.awW;
            this.awW = 0;
        }
        ViewDataBinding.executeBindingsOn(this.bSL);
        ViewDataBinding.executeBindingsOn(this.bSK);
    }
}
