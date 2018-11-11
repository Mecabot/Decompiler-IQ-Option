package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.TextViewBindingAdapter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.e.a.a.a;
import com.iqoption.fragment.account.security.phone.b;
import com.iqoption.view.ConfirmButtonView;
import com.iqoption.view.text.SoftKeyboardEditText;
import com.iqoption.widget.CountDownProgressBar;
import com.iqoption.x.R;

/* compiled from: AccountSecurityConfirmCodeFragmentBindingImpl */
public class d extends c implements a {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @NonNull
    private final LinearLayout axx;
    @Nullable
    private final OnClickListener bhM;
    @Nullable
    private final OnClickListener bhN;
    @Nullable
    private final OnClickListener bhO;

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        awV.put(R.id.confirmCodeTitle, 5);
        awV.put(R.id.confirmationCodeSentText, 6);
        awV.put(R.id.countDownProgress, 7);
    }

    public d(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, awU, awV));
    }

    private d(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ConfirmButtonView) objArr[4], (ConfirmButtonView) objArr[3], (SoftKeyboardEditText) objArr[1], (TextView) objArr[5], (TextView) objArr[6], (CountDownProgressBar) objArr[7], (ConfirmButtonView) objArr[2]);
        this.awW = -1;
        this.bhF.setTag(null);
        this.bhG.setTag(null);
        this.bhH.setTag(null);
        this.axx = (LinearLayout) objArr[0];
        this.axx.setTag(null);
        this.bhK.setTag(null);
        setRootTag(view);
        this.bhM = new com.iqoption.e.a.a(this, 3);
        this.bhN = new com.iqoption.e.a.a(this, 1);
        this.bhO = new com.iqoption.e.a.a(this, 2);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.awW = 2;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.awW != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        if (7 != i) {
            return false;
        }
        a((b) obj);
        return true;
    }

    public void a(@Nullable b bVar) {
        this.bhL = bVar;
        synchronized (this) {
            this.awW |= 1;
        }
        notifyPropertyChanged(7);
        super.requestRebind();
    }

    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.awW;
            this.awW = 0;
        }
        b bVar = this.bhL;
        CharSequence charSequence = null;
        long j2 = j & 3;
        if (!(j2 == 0 || bVar == null)) {
            charSequence = bVar.ajs();
        }
        if ((j & 2) != 0) {
            this.bhF.setOnClickListener(this.bhM);
            this.bhG.setOnClickListener(this.bhO);
            this.bhK.setOnClickListener(this.bhN);
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.bhH, charSequence);
        }
    }

    public final void a(int i, View view) {
        Object obj = null;
        b bVar;
        switch (i) {
            case 1:
                bVar = this.bhL;
                if (bVar != null) {
                    obj = 1;
                }
                if (obj != null) {
                    bVar.aju();
                    return;
                }
                return;
            case 2:
                bVar = this.bhL;
                if (bVar != null) {
                    obj = 1;
                }
                if (obj != null) {
                    bVar.ajv();
                    return;
                }
                return;
            case 3:
                bVar = this.bhL;
                if (bVar != null) {
                    obj = 1;
                }
                if (obj != null) {
                    bVar.ajw();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
