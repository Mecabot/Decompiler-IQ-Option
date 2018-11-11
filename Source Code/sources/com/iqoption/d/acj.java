package com.iqoption.d;

import android.arch.lifecycle.LifecycleOwner;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.view.RobotoTextView;
import com.iqoption.view.text.FormattedTextView;
import com.iqoption.view.timer.TimerView;
import com.iqoption.x.R;

/* compiled from: OpenDigitalOptionGroupItemBindingImpl */
public class acj extends aci {
    @Nullable
    private static final IncludedLayouts awU = new IncludedLayouts(19);
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        awU.setIncludes(0, new String[]{"position_item_title_layout"}, new int[]{1}, new int[]{R.layout.position_item_title_layout});
        awV.put(R.id.openGroupItemLayout, 2);
        awV.put(R.id.buyBackGroupFrame, 3);
        awV.put(R.id.buyBackGroupLayout, 4);
        awV.put(R.id.confirmGroupSellingText, 5);
        awV.put(R.id.groupProgress, 6);
        awV.put(R.id.buyBackGroupValue, 7);
        awV.put(R.id.openOptionsInfo, 8);
        awV.put(R.id.timerView, 9);
        awV.put(R.id.active, 10);
        awV.put(R.id.winAmount, 11);
        awV.put(R.id.menuIcon, 12);
        awV.put(R.id.activeCount, 13);
        awV.put(R.id.optionType, 14);
        awV.put(R.id.activeAmount, 15);
        awV.put(R.id.dividerShort, 16);
        awV.put(R.id.space, 17);
        awV.put(R.id.dividerLong, 18);
    }

    public acj(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 19, awU, awV));
    }

    private acj(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (TextView) objArr[10], (TextView) objArr[15], (TextView) objArr[13], (FrameLayout) objArr[3], (LinearLayout) objArr[4], (RobotoTextView) objArr[7], (agg) objArr[1], (FormattedTextView) objArr[5], (View) objArr[18], (View) objArr[16], (ContentLoadingProgressBar) objArr[6], (ImageView) objArr[12], (FrameLayout) objArr[2], (LinearLayout) objArr[8], (LinearLayout) objArr[0], (FormattedTextView) objArr[14], (View) objArr[17], (TimerView) objArr[9], (RobotoTextView) objArr[11]);
        this.awW = -1;
        this.bNc.setTag(null);
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
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.d.acj.hasPendingBindings():boolean");
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
