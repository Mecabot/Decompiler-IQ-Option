package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.e.a.a.a;
import com.iqoption.x.R;

/* compiled from: FragmentAccountSecurityPasscodeErrorBindingImpl */
public class lg extends lf implements a {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @NonNull
    private final ImageView bwL;
    @Nullable
    private final OnClickListener bwM;
    @Nullable
    private final OnClickListener bwN;

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        awV.put(R.id.main_content, 3);
        awV.put(R.id.passcodeErrorText, 4);
    }

    public lg(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, awU, awV));
    }

    private lg(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[3], (FrameLayout) objArr[0], (TextView) objArr[4], (TextView) objArr[2]);
        this.awW = -1;
        this.bwL = (ImageView) objArr[1];
        this.bwL.setTag(null);
        this.bwt.setTag(null);
        this.bwJ.setTag(null);
        setRootTag(view);
        this.bwM = new com.iqoption.e.a.a(this, 2);
        this.bwN = new com.iqoption.e.a.a(this, 1);
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
        if (2 != i) {
            return false;
        }
        a((com.iqoption.fragment.account.security.touchId.a) obj);
        return true;
    }

    public void a(@Nullable com.iqoption.fragment.account.security.touchId.a aVar) {
        this.bwK = aVar;
        synchronized (this) {
            this.awW |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.awW;
            this.awW = 0;
        }
        com.iqoption.fragment.account.security.touchId.a aVar = this.bwK;
        if ((j & 2) != 0) {
            this.bwL.setOnClickListener(this.bwN);
            this.bwJ.setOnClickListener(this.bwM);
        }
    }

    public final void a(int i, View view) {
        Object obj = null;
        com.iqoption.fragment.account.security.touchId.a aVar;
        switch (i) {
            case 1:
                aVar = this.bwK;
                if (aVar != null) {
                    obj = 1;
                }
                if (obj != null) {
                    aVar.ajM();
                    return;
                }
                return;
            case 2:
                aVar = this.bwK;
                if (aVar != null) {
                    obj = 1;
                }
                if (obj != null) {
                    aVar.ajN();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
