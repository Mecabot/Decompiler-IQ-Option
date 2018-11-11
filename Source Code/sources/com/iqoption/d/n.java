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
import com.iqoption.view.ConfirmButtonView;
import com.iqoption.view.text.SoftKeyboardEditText;
import com.iqoption.x.R;

/* compiled from: AccountSecurityEmailConfirmFragmentBindingImpl */
public class n extends m implements a {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @NonNull
    private final LinearLayout axx;
    @Nullable
    private final OnClickListener bie;

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        awV.put(R.id.emailEdit, 2);
    }

    public n(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, awU, awV));
    }

    private n(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ConfirmButtonView) objArr[1], (SoftKeyboardEditText) objArr[2]);
        this.awW = -1;
        this.bia.setTag(null);
        this.axx = (LinearLayout) objArr[0];
        this.axx.setTag(null);
        setRootTag(view);
        this.bie = new com.iqoption.e.a.a(this, 1);
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
        a((com.iqoption.fragment.account.security.a.a) obj);
        return true;
    }

    public void a(@Nullable com.iqoption.fragment.account.security.a.a aVar) {
        this.bic = aVar;
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
        com.iqoption.fragment.account.security.a.a aVar = this.bic;
        if ((j & 2) != 0) {
            this.bia.setOnClickListener(this.bie);
        }
    }

    public final void a(int i, View view) {
        com.iqoption.fragment.account.security.a.a aVar = this.bic;
        if ((aVar != null ? 1 : null) != null) {
            aVar.ahq();
        }
    }
}
