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
import com.iqoption.fragment.account.security.touchId.c;
import com.iqoption.view.ProgressSwitchView;
import com.iqoption.x.R;

/* compiled from: AccountSecurityTurnOnTouchIdFragmentBindingImpl */
public class v extends u implements a {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @NonNull
    private final LinearLayout axx;
    @Nullable
    private final OnClickListener biv;

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        awV.put(R.id.twoStepAuthSwitchText, 2);
        awV.put(R.id.twoStepAuthSwitch, 3);
    }

    public v(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, awU, awV));
    }

    private v(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[1], (ProgressSwitchView) objArr[3], (TextView) objArr[2]);
        this.awW = -1;
        this.bit.setTag(null);
        this.axx = (LinearLayout) objArr[0];
        this.axx.setTag(null);
        setRootTag(view);
        this.biv = new com.iqoption.e.a.a(this, 1);
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
        this.biu = cVar;
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
        c cVar = this.biu;
        if ((j & 2) != 0) {
            this.bit.setOnClickListener(this.biv);
        }
    }

    public final void a(int i, View view) {
        c cVar = this.biu;
        if ((cVar != null ? 1 : null) != null) {
            cVar.ajg();
        }
    }
}
