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
import com.iqoption.view.ConfirmButtonView;
import com.iqoption.x.R;

/* compiled from: AccountSecurityConfirmCodeExpiredFragmentBindingImpl */
public class b extends a implements a {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @NonNull
    private final LinearLayout axx;
    @Nullable
    private final OnClickListener bhE;

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        awV.put(R.id.confirmationCodeTitle, 2);
        awV.put(R.id.confirmationCodeSentText, 3);
    }

    public b(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, awU, awV));
    }

    private b(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[3], (TextView) objArr[2], (ConfirmButtonView) objArr[1]);
        this.awW = -1;
        this.axx = (LinearLayout) objArr[0];
        this.axx.setTag(null);
        this.bhC.setTag(null);
        setRootTag(view);
        this.bhE = new com.iqoption.e.a.a(this, 1);
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
        a((com.iqoption.fragment.account.security.phone.a) obj);
        return true;
    }

    public void a(@Nullable com.iqoption.fragment.account.security.phone.a aVar) {
        this.bhD = aVar;
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
        com.iqoption.fragment.account.security.phone.a aVar = this.bhD;
        if ((j & 2) != 0) {
            this.bhC.setOnClickListener(this.bhE);
        }
    }

    public final void a(int i, View view) {
        com.iqoption.fragment.account.security.phone.a aVar = this.bhD;
        if ((aVar != null ? 1 : null) != null) {
            aVar.ajr();
        }
    }
}
