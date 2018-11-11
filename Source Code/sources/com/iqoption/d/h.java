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
import com.iqoption.fragment.account.security.phone.c;
import com.iqoption.view.ConfirmButtonView;
import com.iqoption.view.text.FormattedTextView;
import com.iqoption.x.R;

/* compiled from: AccountSecurityConfirmPhoneFragmentBindingImpl */
public class h extends g implements a {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @NonNull
    private final LinearLayout axx;
    @Nullable
    private final OnClickListener bhV;
    @Nullable
    private final OnClickListener bhW;

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        awV.put(R.id.phone, 3);
    }

    public h(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, awU, awV));
    }

    private h(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ConfirmButtonView) objArr[2], (ConfirmButtonView) objArr[1], (FormattedTextView) objArr[3]);
        this.awW = -1;
        this.bhG.setTag(null);
        this.bhS.setTag(null);
        this.axx = (LinearLayout) objArr[0];
        this.axx.setTag(null);
        setRootTag(view);
        this.bhV = new com.iqoption.e.a.a(this, 1);
        this.bhW = new com.iqoption.e.a.a(this, 2);
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
        a((c) obj);
        return true;
    }

    public void a(@Nullable c cVar) {
        this.bhU = cVar;
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
        c cVar = this.bhU;
        if ((j & 2) != 0) {
            this.bhG.setOnClickListener(this.bhW);
            this.bhS.setOnClickListener(this.bhV);
        }
    }

    public final void a(int i, View view) {
        Object obj = null;
        c cVar;
        switch (i) {
            case 1:
                cVar = this.bhU;
                if (cVar != null) {
                    obj = 1;
                }
                if (obj != null) {
                    cVar.ahq();
                    return;
                }
                return;
            case 2:
                cVar = this.bhU;
                if (cVar != null) {
                    obj = 1;
                }
                if (obj != null) {
                    cVar.ajv();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
