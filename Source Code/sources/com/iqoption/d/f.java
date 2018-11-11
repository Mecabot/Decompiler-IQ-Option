package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.e.a.a.a;
import com.iqoption.fragment.account.security.sms.b;
import com.iqoption.view.ConfirmButtonView;
import com.iqoption.x.R;

/* compiled from: AccountSecurityConfirmPhone2stepAuthFragmentBindingImpl */
public class f extends e implements a {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @NonNull
    private final LinearLayout axx;
    @Nullable
    private final OnClickListener bhR;

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        awV.put(R.id.confirmationCodeSentText, 2);
    }

    public f(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, awU, awV));
    }

    private f(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ConfirmButtonView) objArr[1], (TextView) objArr[2]);
        this.awW = -1;
        this.bhP.setTag(null);
        this.axx = (LinearLayout) objArr[0];
        this.axx.setTag(null);
        setRootTag(view);
        this.bhR = new com.iqoption.e.a.a(this, 1);
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
        this.bhQ = bVar;
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
        b bVar = this.bhQ;
        if ((j & 2) != 0) {
            this.bhP.setOnClickListener(this.bhR);
        }
    }

    public final void a(int i, View view) {
        b bVar = this.bhQ;
        if ((bVar != null ? 1 : null) != null) {
            bVar.ajC();
        }
    }
}
