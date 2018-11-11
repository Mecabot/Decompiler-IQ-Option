package com.iqoption.deposit.a;

import android.arch.lifecycle.LifecycleOwner;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.iqoption.deposit.a;
import com.iqoption.deposit.r.f;
import com.iqoption.deposit.r.g;

/* compiled from: FragmentDepositPerformLightBindingImpl */
public class t extends s {
    @Nullable
    private static final IncludedLayouts awU = new IncludedLayouts(19);
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @NonNull
    private final LinearLayout axx;
    @Nullable
    private final bq bZl;
    @NonNull
    private final LinearLayout biX;
    @NonNull
    private final LinearLayout buZ;
    @NonNull
    private final LinearLayout bva;

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        awU.setIncludes(1, new String[]{"layout_perform_toolbar_title_light"}, new int[]{4}, new int[]{g.layout_perform_toolbar_title_light});
        awU.setIncludes(2, new String[]{"layout_deposit_protected_light"}, new int[]{6}, new int[]{g.layout_deposit_protected_light});
        awU.setIncludes(3, new String[]{"layout_currency_selector_light"}, new int[]{5}, new int[]{g.layout_currency_selector_light});
        awU.setIncludes(0, new String[]{"layout_deposit_button_light"}, new int[]{7}, new int[]{g.layout_deposit_button_light});
        awV.put(f.toolbarBack, 8);
        awV.put(f.depositPerformLightScroll, 9);
        awV.put(f.topFocusableView, 10);
        awV.put(f.depositAmountContainer, 11);
        awV.put(f.depositAmountTitle, 12);
        awV.put(f.depositAmountEdit, 13);
        awV.put(f.depositAmountKycError, 14);
        awV.put(f.depositPresetsList, 15);
        awV.put(f.depositNoData, 16);
        awV.put(f.depositFields, 17);
        awV.put(f.depositTerms, 18);
    }

    public t(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 19, awU, awV));
    }

    private t(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (bg) objArr[5], (LinearLayout) objArr[11], (EditText) objArr[13], (TextView) objArr[14], (TextView) objArr[12], (bk) objArr[7], (FrameLayout) objArr[17], (TextView) objArr[16], (ScrollView) objArr[9], (RecyclerView) objArr[15], (TextView) objArr[18], (ImageView) objArr[8], (bz) objArr[4], (View) objArr[10]);
        this.awW = -1;
        this.axx = (LinearLayout) objArr[0];
        this.axx.setTag(null);
        this.biX = (LinearLayout) objArr[1];
        this.biX.setTag(null);
        this.buZ = (LinearLayout) objArr[2];
        this.buZ.setTag(null);
        this.bZl = (bq) objArr[6];
        setContainedBinding(this.bZl);
        this.bva = (LinearLayout) objArr[3];
        this.bva.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.awW = 8;
        }
        this.bZj.invalidateAll();
        this.bYY.invalidateAll();
        this.bZl.invalidateAll();
        this.bZd.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Missing block: B:8:0x0013, code:
            if (r5.bZj.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Missing block: B:9:0x0015, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:11:0x001c, code:
            if (r5.bYY.hasPendingBindings() == false) goto L_0x001f;
     */
    /* JADX WARNING: Missing block: B:12:0x001e, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:14:0x0025, code:
            if (r5.bZl.hasPendingBindings() == false) goto L_0x0028;
     */
    /* JADX WARNING: Missing block: B:15:0x0027, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:17:0x002e, code:
            if (r5.bZd.hasPendingBindings() == false) goto L_0x0031;
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
        r1 = r5.bZj;
        r1 = r1.hasPendingBindings();
        if (r1 == 0) goto L_0x0016;
    L_0x0015:
        return r0;
    L_0x0016:
        r1 = r5.bYY;
        r1 = r1.hasPendingBindings();
        if (r1 == 0) goto L_0x001f;
    L_0x001e:
        return r0;
    L_0x001f:
        r1 = r5.bZl;
        r1 = r1.hasPendingBindings();
        if (r1 == 0) goto L_0x0028;
    L_0x0027:
        return r0;
    L_0x0028:
        r1 = r5.bZd;
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
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.deposit.a.t.hasPendingBindings():boolean");
    }

    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.bZj.setLifecycleOwner(lifecycleOwner);
        this.bYY.setLifecycleOwner(lifecycleOwner);
        this.bZl.setLifecycleOwner(lifecycleOwner);
        this.bZd.setLifecycleOwner(lifecycleOwner);
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return a((bk) obj, i2);
            case 1:
                return a((bg) obj, i2);
            case 2:
                return a((bz) obj, i2);
            default:
                return false;
        }
    }

    private boolean a(bk bkVar, int i) {
        if (i != a.pb) {
            return false;
        }
        synchronized (this) {
            this.awW |= 1;
        }
        return true;
    }

    private boolean a(bg bgVar, int i) {
        if (i != a.pb) {
            return false;
        }
        synchronized (this) {
            this.awW |= 2;
        }
        return true;
    }

    private boolean a(bz bzVar, int i) {
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
        ViewDataBinding.executeBindingsOn(this.bZj);
        ViewDataBinding.executeBindingsOn(this.bYY);
        ViewDataBinding.executeBindingsOn(this.bZl);
        ViewDataBinding.executeBindingsOn(this.bZd);
    }
}
