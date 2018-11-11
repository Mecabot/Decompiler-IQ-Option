package com.iqoption.d;

import android.arch.lifecycle.LifecycleOwner;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.Space;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.iqoption.x.R;

/* compiled from: FragmentOtnLeadingBoardProfileBindingImpl */
public class pm extends pl {
    @Nullable
    private static final IncludedLayouts awU = new IncludedLayouts(12);
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @NonNull
    private final LinearLayout biX;
    @NonNull
    private final LinearLayout buZ;

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        awU.setIncludes(2, new String[]{"fragment_otn_leading_board_user_board_user", "fragment_otn_leading_board_user_board_date", "fragment_otn_leading_board_user_board_place", "fragment_otn_leading_board_user_board_commission"}, new int[]{3, 4, 5, 6}, new int[]{R.layout.fragment_otn_leading_board_user_board_user, R.layout.fragment_otn_leading_board_user_board_date, R.layout.fragment_otn_leading_board_user_board_place, R.layout.fragment_otn_leading_board_user_board_commission});
        awU.setIncludes(1, new String[]{"fragment_otn_leading_board_user_board_trading"}, new int[]{7}, new int[]{R.layout.fragment_otn_leading_board_user_board_trading});
        awV.put(R.id.space1, 8);
        awV.put(R.id.space2, 9);
        awV.put(R.id.space3, 10);
        awV.put(R.id.space4, 11);
    }

    public pm(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 12, awU, awV));
    }

    private pm(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 5, (pn) objArr[6], (pp) objArr[4], (pr) objArr[5], (FrameLayout) objArr[0], (Space) objArr[8], (Space) objArr[9], (Space) objArr[10], (Space) objArr[11], (pv) objArr[7], (px) objArr[3]);
        this.awW = -1;
        this.biX = (LinearLayout) objArr[1];
        this.biX.setTag(null);
        this.buZ = (LinearLayout) objArr[2];
        this.buZ.setTag(null);
        this.bzL.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.awW = 32;
        }
        this.bzY.invalidateAll();
        this.bzR.invalidateAll();
        this.bzS.invalidateAll();
        this.bzQ.invalidateAll();
        this.bzX.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Missing block: B:8:0x0013, code:
            if (r5.bzY.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Missing block: B:9:0x0015, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:11:0x001c, code:
            if (r5.bzR.hasPendingBindings() == false) goto L_0x001f;
     */
    /* JADX WARNING: Missing block: B:12:0x001e, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:14:0x0025, code:
            if (r5.bzS.hasPendingBindings() == false) goto L_0x0028;
     */
    /* JADX WARNING: Missing block: B:15:0x0027, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:17:0x002e, code:
            if (r5.bzQ.hasPendingBindings() == false) goto L_0x0031;
     */
    /* JADX WARNING: Missing block: B:18:0x0030, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:20:0x0037, code:
            if (r5.bzX.hasPendingBindings() == false) goto L_0x003a;
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
        r1 = r5.bzY;
        r1 = r1.hasPendingBindings();
        if (r1 == 0) goto L_0x0016;
    L_0x0015:
        return r0;
    L_0x0016:
        r1 = r5.bzR;
        r1 = r1.hasPendingBindings();
        if (r1 == 0) goto L_0x001f;
    L_0x001e:
        return r0;
    L_0x001f:
        r1 = r5.bzS;
        r1 = r1.hasPendingBindings();
        if (r1 == 0) goto L_0x0028;
    L_0x0027:
        return r0;
    L_0x0028:
        r1 = r5.bzQ;
        r1 = r1.hasPendingBindings();
        if (r1 == 0) goto L_0x0031;
    L_0x0030:
        return r0;
    L_0x0031:
        r1 = r5.bzX;
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
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.d.pm.hasPendingBindings():boolean");
    }

    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.bzY.setLifecycleOwner(lifecycleOwner);
        this.bzR.setLifecycleOwner(lifecycleOwner);
        this.bzS.setLifecycleOwner(lifecycleOwner);
        this.bzQ.setLifecycleOwner(lifecycleOwner);
        this.bzX.setLifecycleOwner(lifecycleOwner);
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return a((pp) obj, i2);
            case 1:
                return a((pv) obj, i2);
            case 2:
                return a((px) obj, i2);
            case 3:
                return a((pn) obj, i2);
            case 4:
                return a((pr) obj, i2);
            default:
                return false;
        }
    }

    private boolean a(pp ppVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.awW |= 1;
        }
        return true;
    }

    private boolean a(pv pvVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.awW |= 2;
        }
        return true;
    }

    private boolean a(px pxVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.awW |= 4;
        }
        return true;
    }

    private boolean a(pn pnVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.awW |= 8;
        }
        return true;
    }

    private boolean a(pr prVar, int i) {
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
        ViewDataBinding.executeBindingsOn(this.bzY);
        ViewDataBinding.executeBindingsOn(this.bzR);
        ViewDataBinding.executeBindingsOn(this.bzS);
        ViewDataBinding.executeBindingsOn(this.bzQ);
        ViewDataBinding.executeBindingsOn(this.bzX);
    }
}
