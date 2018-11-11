package com.iqoption.d;

import android.arch.lifecycle.LifecycleOwner;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.ImageViewBindingAdapter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.view.ConfirmButtonView;
import com.iqoption.x.R;

/* compiled from: FragmentKycDocumentsUploadBindingImpl */
public class mq extends mp {
    @Nullable
    private static final IncludedLayouts awU = new IncludedLayouts(14);
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @NonNull
    private final LinearLayout axx;

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        awU.setIncludes(0, new String[]{"kyc_toolbar_layout"}, new int[]{2}, new int[]{R.layout.kyc_toolbar_layout});
        awV.put(R.id.documentsTittle, 3);
        awV.put(R.id.redirectText, 4);
        awV.put(R.id.proofOfIdentity, 5);
        awV.put(R.id.proofOfIdentityText, 6);
        awV.put(R.id.proofOfIdentityStatus, 7);
        awV.put(R.id.proofOfIdentityProgress, 8);
        awV.put(R.id.addressOfResidence, 9);
        awV.put(R.id.addressOfResidenceText, 10);
        awV.put(R.id.addressOfResidenceStatus, 11);
        awV.put(R.id.addressOfResidenceProgress, 12);
        awV.put(R.id.attachDocumentsLater, 13);
    }

    public mq(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 14, awU, awV));
    }

    private mq(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ImageView) objArr[1], (LinearLayout) objArr[9], (ContentLoadingProgressBar) objArr[12], (TextView) objArr[11], (TextView) objArr[10], (ConfirmButtonView) objArr[13], (TextView) objArr[3], (wr) objArr[2], (LinearLayout) objArr[5], (ContentLoadingProgressBar) objArr[8], (TextView) objArr[7], (TextView) objArr[6], (TextView) objArr[4]);
        this.awW = -1;
        this.bxV.setTag(null);
        this.axx = (LinearLayout) objArr[0];
        this.axx.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.awW = 2;
        }
        this.bxz.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Missing block: B:8:0x0013, code:
            if (r5.bxz.hasPendingBindings() == false) goto L_0x0016;
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
        r1 = r5.bxz;
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
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.d.mq.hasPendingBindings():boolean");
    }

    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.bxz.setLifecycleOwner(lifecycleOwner);
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return i != 0 ? false : a((wr) obj, i2);
    }

    private boolean a(wr wrVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.awW |= 1;
        }
        return true;
    }

    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.awW;
            this.awW = 0;
        }
        if ((j & 2) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.bxV, ViewDataBinding.getDrawableFromResource(this.bxV, R.drawable.ic_kyc_next_selector));
        }
        ViewDataBinding.executeBindingsOn(this.bxz);
    }
}
