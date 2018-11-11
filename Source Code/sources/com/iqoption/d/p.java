package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.iqoption.e.a.a.a;
import com.iqoption.fragment.account.security.phone.e;
import com.iqoption.view.ConfirmButtonView;
import com.iqoption.view.text.SoftKeyboardEditText;
import com.iqoption.x.R;

/* compiled from: AccountSecurityPhoneNumberFragmentBindingImpl */
public class p extends o implements a {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @NonNull
    private final LinearLayout axx;
    @Nullable
    private final OnClickListener bii;

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        awV.put(R.id.phone, 2);
    }

    public p(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, awU, awV));
    }

    private p(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (SoftKeyboardEditText) objArr[2], (ConfirmButtonView) objArr[1]);
        this.awW = -1;
        this.axx = (LinearLayout) objArr[0];
        this.axx.setTag(null);
        this.big.setTag(null);
        setRootTag(view);
        this.bii = new com.iqoption.e.a.a(this, 1);
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
        a((e) obj);
        return true;
    }

    public void a(@Nullable e eVar) {
        this.bih = eVar;
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
        e eVar = this.bih;
        if ((j & 2) != 0) {
            this.big.setOnClickListener(this.bii);
        }
    }

    public final void a(int i, View view) {
        e eVar = this.bih;
        if ((eVar != null ? 1 : null) != null) {
            eVar.ajz();
        }
    }
}
