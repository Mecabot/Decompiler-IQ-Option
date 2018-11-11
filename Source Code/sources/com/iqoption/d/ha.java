package com.iqoption.d;

import android.arch.lifecycle.LifecycleOwner;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Guideline;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import com.iqoption.view.scroll.TurnOffNestedScrollView;
import com.iqoption.x.R;

/* compiled from: DepositPageOldBindingImpl */
public class ha extends gz {
    @Nullable
    private static final IncludedLayouts awU = new IncludedLayouts(9);
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @Nullable
    private final xb bqJ;
    @NonNull
    private final ConstraintLayout bqK;

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        awU.setIncludes(0, new String[]{"layout_protected_old"}, new int[]{1}, new int[]{R.layout.layout_protected_old});
        awV.put(R.id.depositGuidelineTop, 2);
        awV.put(R.id.depositGuidelineLeft, 3);
        awV.put(R.id.depositGuidelineRight, 4);
        awV.put(R.id.depositBackButton, 5);
        awV.put(R.id.depositTitle, 6);
        awV.put(R.id.depositToolbarSecure, 7);
        awV.put(R.id.pageContentContainer, 8);
    }

    public ha(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 9, awU, awV));
    }

    private ha(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[5], (Guideline) objArr[3], (Space) objArr[4], (Guideline) objArr[2], (TextView) objArr[6], (LinearLayout) objArr[7], (TurnOffNestedScrollView) objArr[8]);
        this.awW = -1;
        this.bqJ = (xb) objArr[1];
        setContainedBinding(this.bqJ);
        this.bqK = (ConstraintLayout) objArr[0];
        this.bqK.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.awW = 1;
        }
        this.bqJ.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Missing block: B:8:0x0013, code:
            if (r5.bqJ.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Missing block: B:9:0x0015, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:11:0x0017, code:
            return false;
     */
    public boolean hasPendingBindings() {
        /*
        r5 = this;
        monitor-enter(r5);
        r0 = r5.awW;	 Catch:{ all -> 0x0018 }
        r2 = 0;
        r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        r0 = 1;
        if (r4 == 0) goto L_0x000c;
    L_0x000a:
        monitor-exit(r5);	 Catch:{ all -> 0x0018 }
        return r0;
    L_0x000c:
        monitor-exit(r5);	 Catch:{ all -> 0x0018 }
        r1 = r5.bqJ;
        r1 = r1.hasPendingBindings();
        if (r1 == 0) goto L_0x0016;
    L_0x0015:
        return r0;
    L_0x0016:
        r0 = 0;
        return r0;
    L_0x0018:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x0018 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.d.ha.hasPendingBindings():boolean");
    }

    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.bqJ.setLifecycleOwner(lifecycleOwner);
    }

    protected void executeBindings() {
        synchronized (this) {
            long j = this.awW;
            this.awW = 0;
        }
        ViewDataBinding.executeBindingsOn(this.bqJ);
    }
}
