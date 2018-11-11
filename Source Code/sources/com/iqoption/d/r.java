package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.ImageViewBindingAdapter;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.e.a.a.a;
import com.iqoption.fragment.account.security.a.d;
import com.iqoption.x.R;

/* compiled from: AccountSecurityResendEmailFragmentBindingImpl */
public class r extends q implements a {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @NonNull
    private final LinearLayout axx;
    @Nullable
    private final OnClickListener bin;

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        awV.put(R.id.emailSentText, 3);
    }

    public r(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, awU, awV));
    }

    private r(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[3], (ImageView) objArr[2], (TextView) objArr[1]);
        this.awW = -1;
        this.axx = (LinearLayout) objArr[0];
        this.axx.setTag(null);
        this.bik.setTag(null);
        this.bil.setTag(null);
        setRootTag(view);
        this.bin = new com.iqoption.e.a.a(this, 1);
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
        a((d) obj);
        return true;
    }

    public void a(@Nullable d dVar) {
        this.bim = dVar;
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
        Drawable drawable = null;
        d dVar = this.bim;
        long j2 = j & 3;
        if (!(j2 == 0 || dVar == null)) {
            drawable = dVar.ajq();
        }
        if (j2 != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.bik, drawable);
        }
        if ((j & 2) != 0) {
            this.bil.setOnClickListener(this.bin);
        }
    }

    public final void a(int i, View view) {
        d dVar = this.bim;
        if ((dVar != null ? 1 : null) != null) {
            dVar.ajn();
        }
    }
}
