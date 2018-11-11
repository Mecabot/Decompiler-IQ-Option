package com.iqoption.d;

import android.arch.lifecycle.LifecycleOwner;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatSpinner2;
import android.support.v7.widget.RecyclerView;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import com.iqoption.fragment.cashbox.AmountFrameViewSwitcher;
import com.iqoption.view.ConfirmButtonView;
import com.iqoption.x.R;

/* compiled from: DepositPageContentNoBonusBindingImpl */
public class gu extends gt {
    @Nullable
    private static final IncludedLayouts awU = new IncludedLayouts(39);
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @NonNull
    private final FrameLayout biH;

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        awU.setIncludes(1, new String[]{"deposit_terms_layout"}, new int[]{2}, new int[]{R.layout.deposit_terms_layout});
        awV.put(R.id.guideline_payment_method, 3);
        awV.put(R.id.guideline_left_icon_panel, 4);
        awV.put(R.id.guideline_left_icon_panel_middle, 5);
        awV.put(R.id.guideline_left_payment_method, 6);
        awV.put(R.id.guideline_checkbox, 7);
        awV.put(R.id.guidelineIconsTop, 8);
        awV.put(R.id.paymentMethodTextView, 9);
        awV.put(R.id.paymentMethodSpinnerFrame, 10);
        awV.put(R.id.paymentMethodSpinner, 11);
        awV.put(R.id.paymentMethodCheck, 12);
        awV.put(R.id.paymentMethodError, 13);
        awV.put(R.id.amountTextView, 14);
        awV.put(R.id.depositAmountEditTextFrame, 15);
        awV.put(R.id.amountFrameSwitcher, 16);
        awV.put(R.id.depositAmountEditText, 17);
        awV.put(R.id.depositAmountVipIcon, 18);
        awV.put(R.id.depositButtonSmall, 19);
        awV.put(R.id.currencySpinner, 20);
        awV.put(R.id.currencyTextView, 21);
        awV.put(R.id.currencyCheck, 22);
        awV.put(R.id.depositAmountError, 23);
        awV.put(R.id.enable3dsContainer, 24);
        awV.put(R.id.iconLock, 25);
        awV.put(R.id.enable3dsText, 26);
        awV.put(R.id.icon3dsQuestionSmall, 27);
        awV.put(R.id.enable3dsSwitch, 28);
        awV.put(R.id.icon3dsQuestion, 29);
        awV.put(R.id.depositsContainer, 30);
        awV.put(R.id.depositButton, 31);
        awV.put(R.id.verifiedByVisa, 32);
        awV.put(R.id.masterCardSecureCode, 33);
        awV.put(R.id.fundsImage, 34);
        awV.put(R.id.security3dImage, 35);
        awV.put(R.id.sslCertifiedImage, 36);
        awV.put(R.id.bitSecure, 37);
        awV.put(R.id.veil, 38);
    }

    public gu(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 39, awU, awV));
    }

    private gu(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (AmountFrameViewSwitcher) objArr[16], (TextView) objArr[14], (TextView) objArr[37], (ImageView) objArr[22], (AppCompatSpinner2) objArr[20], (TextView) objArr[21], (EditText) objArr[17], (FrameLayout) objArr[15], (TextView) objArr[23], (AppCompatImageView) objArr[18], (ConfirmButtonView) objArr[31], (ConfirmButtonView) objArr[19], (RelativeLayout) objArr[1], (RecyclerView) objArr[30], (RelativeLayout) objArr[24], (Switch) objArr[28], (TextView) objArr[26], (ImageView) objArr[34], (View) objArr[7], (View) objArr[8], (View) objArr[4], (View) objArr[5], (View) objArr[6], (View) objArr[3], (ImageView) objArr[29], (ImageView) objArr[27], (ImageView) objArr[25], (ImageView) objArr[33], (ImageView) objArr[12], (TextView) objArr[13], (AppCompatSpinner2) objArr[11], (FrameLayout) objArr[10], (TextView) objArr[9], (ImageView) objArr[35], (ImageView) objArr[36], (hl) objArr[2], (View) objArr[38], (ImageView) objArr[32]);
        this.awW = -1;
        this.bpK.setTag(null);
        this.biH = (FrameLayout) objArr[0];
        this.biH.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.awW = 2;
        }
        this.bqe.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Missing block: B:8:0x0013, code:
            if (r5.bqe.hasPendingBindings() == false) goto L_0x0016;
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
        r1 = r5.bqe;
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
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.d.gu.hasPendingBindings():boolean");
    }

    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.bqe.setLifecycleOwner(lifecycleOwner);
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return i != 0 ? false : a((hl) obj, i2);
    }

    private boolean a(hl hlVar, int i) {
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
        ViewDataBinding.executeBindingsOn(this.bqe);
    }
}
