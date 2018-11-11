package com.iqoption.d;

import android.arch.lifecycle.LifecycleOwner;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import com.iqoption.view.ConfirmButtonView;
import com.iqoption.view.RobotoTextView;
import com.iqoption.x.R;

/* compiled from: DepositCardViewBindingImpl */
public class gb extends ga {
    @Nullable
    private static final IncludedLayouts awU = new IncludedLayouts(11);
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        awU.setIncludes(1, new String[]{"deposit_card_back_side", "deposit_card_front_side"}, new int[]{2, 3}, new int[]{R.layout.deposit_card_back_side, R.layout.deposit_card_front_side});
        awV.put(R.id.inTotalTextView, 4);
        awV.put(R.id.description3dsTextView, 5);
        awV.put(R.id.payButton, 6);
        awV.put(R.id.cardProtectedFrame, 7);
        awV.put(R.id.depositCardPciDssTextView, 8);
        awV.put(R.id.depositCardSslTextView, 9);
        awV.put(R.id.depositCardTopFrame, 10);
    }

    public gb(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 11, awU, awV));
    }

    private gb(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (fu) objArr[2], (TableLayout) objArr[7], (FrameLayout) objArr[1], (TextView) objArr[8], (TextView) objArr[9], (View) objArr[10], (FrameLayout) objArr[0], (RobotoTextView) objArr[5], (fw) objArr[3], (RobotoTextView) objArr[4], (ConfirmButtonView) objArr[6]);
        this.awW = -1;
        this.boM.setTag(null);
        this.boQ.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.awW = 4;
        }
        this.boK.invalidateAll();
        this.boS.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Missing block: B:8:0x0013, code:
            if (r5.boK.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Missing block: B:9:0x0015, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:11:0x001c, code:
            if (r5.boS.hasPendingBindings() == false) goto L_0x001f;
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
        r1 = r5.boK;
        r1 = r1.hasPendingBindings();
        if (r1 == 0) goto L_0x0016;
    L_0x0015:
        return r0;
    L_0x0016:
        r1 = r5.boS;
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
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.d.gb.hasPendingBindings():boolean");
    }

    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.boK.setLifecycleOwner(lifecycleOwner);
        this.boS.setLifecycleOwner(lifecycleOwner);
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return a((fu) obj, i2);
            case 1:
                return a((fw) obj, i2);
            default:
                return false;
        }
    }

    private boolean a(fu fuVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.awW |= 1;
        }
        return true;
    }

    private boolean a(fw fwVar, int i) {
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
        ViewDataBinding.executeBindingsOn(this.boK);
        ViewDataBinding.executeBindingsOn(this.boS);
    }
}
