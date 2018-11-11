package com.iqoption.d;

import android.arch.lifecycle.LifecycleOwner;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatSpinner2;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.iqoption.view.ConfirmButtonView;
import com.iqoption.view.RobotoTextView;
import com.iqoption.widget.RadioGroupNested;
import com.iqoption.x.R;

/* compiled from: DepositPageContentBindingImpl */
public class gr extends gq {
    @Nullable
    private static final IncludedLayouts awU = new IncludedLayouts(46);
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        awU.setIncludes(0, new String[]{"deposit_terms_layout"}, new int[]{1}, new int[]{R.layout.deposit_terms_layout});
        awV.put(R.id.guideline_payment_method, 2);
        awV.put(R.id.guideline_left_icon_panel, 3);
        awV.put(R.id.guideline_left_icon_panel_middle, 4);
        awV.put(R.id.guideline_left_payment_method, 5);
        awV.put(R.id.guideline_checkbox, 6);
        awV.put(R.id.guidelineIconsTop, 7);
        awV.put(R.id.paymentMethodTextView, 8);
        awV.put(R.id.verifiedByVisa, 9);
        awV.put(R.id.masterCardSecureCode, 10);
        awV.put(R.id.paymentMethodSpinnerFrame, 11);
        awV.put(R.id.paymentMethodSpinner, 12);
        awV.put(R.id.paymentMethodCheck, 13);
        awV.put(R.id.visaBottomLine, 14);
        awV.put(R.id.security3dImage, 15);
        awV.put(R.id.security3dBottomLine, 16);
        awV.put(R.id.sslCertifiedImage, 17);
        awV.put(R.id.sslCertifiedBottomLine, 18);
        awV.put(R.id.fundsImage, 19);
        awV.put(R.id.fundsImageBottomLine, 20);
        awV.put(R.id.amountTextView, 21);
        awV.put(R.id.depositAmountEditText, 22);
        awV.put(R.id.depositButtonSmall, 23);
        awV.put(R.id.currencySpinner, 24);
        awV.put(R.id.currencyTextView, 25);
        awV.put(R.id.currencyCheck, 26);
        awV.put(R.id.depositInfo, 27);
        awV.put(R.id.depositButton, 28);
        awV.put(R.id.depositBonuses, 29);
        awV.put(R.id.bonusCodeText, 30);
        awV.put(R.id.bonusCodeOptionalText, 31);
        awV.put(R.id.bonusCode, 32);
        awV.put(R.id.bonusCodeOkIcon, 33);
        awV.put(R.id.bonusCodeErrorIcon, 34);
        awV.put(R.id.depositBonusInfoIcon, 35);
        awV.put(R.id.textUnderBonusLine1, 36);
        awV.put(R.id.textUnderBonusLine2, 37);
        awV.put(R.id.applyBonusCheckBox, 38);
        awV.put(R.id.bonusTermsAndConditionsLeftBkt, 39);
        awV.put(R.id.bonusTermsAndConditionsClickableText, 40);
        awV.put(R.id.bonusTermsAndConditionsRightBkt, 41);
        awV.put(R.id.depositTermsAndConditionsWebViewFrame, 42);
        awV.put(R.id.bonusTermsAndConditionsText, 43);
        awV.put(R.id.bonusTermsAndConditionsLine, 44);
        awV.put(R.id.depositTermsAndConditionsWebView, 45);
    }

    public gr(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 46, awU, awV));
    }

    private gr(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (TextView) objArr[21], (AppCompatCheckBox) objArr[38], (EditText) objArr[32], (ImageView) objArr[34], (ImageView) objArr[33], (TextView) objArr[31], (TextView) objArr[30], (TextView) objArr[40], (TextView) objArr[39], (View) objArr[44], (TextView) objArr[41], (TextView) objArr[43], (ImageView) objArr[26], (AppCompatSpinner2) objArr[24], (TextView) objArr[25], (EditText) objArr[22], (AppCompatImageView) objArr[35], (RadioGroupNested) objArr[29], (ConfirmButtonView) objArr[28], (ConfirmButtonView) objArr[23], (RobotoTextView) objArr[27], (RelativeLayout) objArr[0], (TextView) objArr[45], (LinearLayout) objArr[42], (ImageView) objArr[19], (View) objArr[20], (View) objArr[6], (View) objArr[7], (View) objArr[3], (View) objArr[4], (View) objArr[5], (View) objArr[2], (ImageView) objArr[10], (ImageView) objArr[13], (AppCompatSpinner2) objArr[12], (FrameLayout) objArr[11], (TextView) objArr[8], (View) objArr[16], (ImageView) objArr[15], (View) objArr[18], (ImageView) objArr[17], (hl) objArr[1], (TextView) objArr[36], (TextView) objArr[37], (ImageView) objArr[9], (View) objArr[14]);
        this.awW = -1;
        this.bpK.setTag(null);
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
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.d.gr.hasPendingBindings():boolean");
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
