package com.iqoption.d;

import android.arch.lifecycle.LifecycleOwner;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.view.RobotoTextView;
import com.iqoption.view.text.FormattedTextView;
import com.iqoption.x.R;

/* compiled from: ClosePositionsItemBindingImpl */
public class fl extends fk {
    @Nullable
    private static final IncludedLayouts awU = new IncludedLayouts(10);
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @NonNull
    private final LinearLayout axx;

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        awU.setIncludes(0, new String[]{"position_item_title_layout"}, new int[]{1}, new int[]{R.layout.position_item_title_layout});
        awV.put(R.id.closeOptionsInfo, 2);
        awV.put(R.id.winIcon, 3);
        awV.put(R.id.active, 4);
        awV.put(R.id.winAmount, 5);
        awV.put(R.id.activeCount, 6);
        awV.put(R.id.optionType, 7);
        awV.put(R.id.buySell, 8);
        awV.put(R.id.activeAmount, 9);
    }

    public fl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 10, awU, awV));
    }

    private fl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (RobotoTextView) objArr[4], (TextView) objArr[9], (TextView) objArr[6], (TextView) objArr[8], (LinearLayout) objArr[2], (agg) objArr[1], (FormattedTextView) objArr[7], (RobotoTextView) objArr[5], (ImageView) objArr[3]);
        this.awW = -1;
        this.axx = (LinearLayout) objArr[0];
        this.axx.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.awW = 2;
        }
        this.bnH.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Missing block: B:8:0x0013, code:
            if (r5.bnH.hasPendingBindings() == false) goto L_0x0016;
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
        r1 = r5.bnH;
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
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.d.fl.hasPendingBindings():boolean");
    }

    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.bnH.setLifecycleOwner(lifecycleOwner);
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return i != 0 ? false : a((agg) obj, i2);
    }

    private boolean a(agg agg, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.awW |= 1;
        }
        return true;
    }

    protected void executeBindings() {
        synchronized (this) {
            long j = this.awW;
            this.awW = 0;
        }
        ViewDataBinding.executeBindingsOn(this.bnH);
    }
}
