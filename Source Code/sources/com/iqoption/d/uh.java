package com.iqoption.d;

import android.arch.lifecycle.LifecycleOwner;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.iqoption.core.ui.a;
import com.iqoption.x.R;

/* compiled from: FragmentWelcomeRegistrationBindingImpl */
public class uh extends ug {
    @Nullable
    private static final IncludedLayouts awU = new IncludedLayouts(28);
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @Nullable
    private final xf bGF;
    @NonNull
    private final LinearLayout buZ;

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        awU.setIncludes(2, new String[]{"layout_welcome_social", "layout_welcome_policy"}, new int[]{8, 9}, new int[]{R.layout.layout_welcome_social, R.layout.layout_welcome_policy});
        awV.put(R.id.backButton, 10);
        awV.put(R.id.title, 11);
        awV.put(R.id.registerContentContainer, 12);
        awV.put(R.id.emailLayout, 13);
        awV.put(R.id.emailEdit, 14);
        awV.put(R.id.passwordLayout, 15);
        awV.put(R.id.passwordEdit, 16);
        awV.put(R.id.countryContainer, 17);
        awV.put(R.id.countryInput, 18);
        awV.put(R.id.countryEdit, 19);
        awV.put(R.id.countryProgress, 20);
        awV.put(R.id.accountCurrencyLayout, 21);
        awV.put(R.id.accountCurrencyTitle, 22);
        awV.put(R.id.currencySpinnerTitle, 23);
        awV.put(R.id.ageLayout, 24);
        awV.put(R.id.checkBoxAge, 25);
        awV.put(R.id.ageAgreeeText, 26);
        awV.put(R.id.button, 27);
    }

    public uh(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 28, awU, awV));
    }

    private uh(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (LinearLayout) objArr[21], (LinearLayout) objArr[6], (TextView) objArr[22], (TextView) objArr[26], (LinearLayout) objArr[24], (ImageView) objArr[10], (TextView) objArr[27], (CheckBox) objArr[25], (FrameLayout) objArr[17], (TextInputEditText) objArr[19], (TextInputLayout) objArr[18], (ImageView) objArr[4], (ImageView) objArr[5], (ContentLoadingProgressBar) objArr[20], (TextView) objArr[23], (TextInputEditText) objArr[14], (TextInputLayout) objArr[13], (TextInputEditText) objArr[16], (TextInputLayout) objArr[15], (ToggleButton) objArr[3], (TextView) objArr[1], (ContentLoadingProgressBar) objArr[7], (FrameLayout) objArr[0], (FrameLayout) objArr[12], (TextView) objArr[11], (xd) objArr[9]);
        this.awW = -1;
        this.bEF.setTag(null);
        this.bBY.setTag(null);
        this.bEL.setTag(null);
        this.buZ = (LinearLayout) objArr[2];
        this.buZ.setTag(null);
        this.bGF = (xf) objArr[8];
        setContainedBinding(this.bGF);
        this.bER.setTag(null);
        this.bGD.setTag(null);
        this.bnn.setTag(null);
        this.bES.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.awW = 2;
        }
        this.bGF.invalidateAll();
        this.bGE.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Missing block: B:8:0x0013, code:
            if (r5.bGF.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Missing block: B:9:0x0015, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:11:0x001c, code:
            if (r5.bGE.hasPendingBindings() == false) goto L_0x001f;
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
        r1 = r5.bGF;
        r1 = r1.hasPendingBindings();
        if (r1 == 0) goto L_0x0016;
    L_0x0015:
        return r0;
    L_0x0016:
        r1 = r5.bGE;
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
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.d.uh.hasPendingBindings():boolean");
    }

    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.bGF.setLifecycleOwner(lifecycleOwner);
        this.bGE.setLifecycleOwner(lifecycleOwner);
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return i != 0 ? false : a((xd) obj, i2);
    }

    private boolean a(xd xdVar, int i) {
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
            a.d(this.bEF, 0.5f);
            a.d(this.bBY, 0.5f);
            a.d(this.bEL, 0.5f);
            a.d(this.bER, 0.5f);
            a.d(this.bGD, 0.5f);
            a.a(this.bnn, ViewDataBinding.getColorFromResource(this.bnn, R.color.white));
        }
        ViewDataBinding.executeBindingsOn(this.bGF);
        ViewDataBinding.executeBindingsOn(this.bGE);
    }
}
