package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.welcomeonboarding.a.f;
import com.iqoption.x.R;

/* compiled from: FragmentForgotPasswordBindingLandImpl */
public class lu extends ls {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    private a bxw;
    private b bxx;

    /* compiled from: FragmentForgotPasswordBindingLandImpl */
    public static class a implements OnClickListener {
        private f bxv;

        public a d(f fVar) {
            this.bxv = fVar;
            return fVar == null ? null : this;
        }

        public void onClick(View view) {
            this.bxv.cl(view);
        }
    }

    /* compiled from: FragmentForgotPasswordBindingLandImpl */
    public static class b implements OnClickListener {
        private f bxv;

        public b e(f fVar) {
            this.bxv = fVar;
            return fVar == null ? null : this;
        }

        public void onClick(View view) {
            this.bxv.cm(view);
        }
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        awV.put(R.id.title, 4);
        awV.put(R.id.emailInput, 5);
        awV.put(R.id.emailEdit, 6);
    }

    public lu(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, awU, awV));
    }

    private lu(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[1], (TextView) objArr[2], (FrameLayout) objArr[0], (TextInputEditText) objArr[6], (TextInputLayout) objArr[5], (ContentLoadingProgressBar) objArr[3], (TextView) objArr[4]);
        this.awW = -1;
        this.aOU.setTag(null);
        this.bnd.setTag(null);
        this.blV.setTag(null);
        this.bnn.setTag(null);
        setRootTag(view);
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
        if (4 != i) {
            return false;
        }
        a((f) obj);
        return true;
    }

    public void a(@Nullable f fVar) {
        this.bxs = fVar;
        synchronized (this) {
            this.awW |= 1;
        }
        notifyPropertyChanged(4);
        super.requestRebind();
    }

    protected void executeBindings() {
        long j;
        OnClickListener onClickListener;
        synchronized (this) {
            j = this.awW;
            this.awW = 0;
        }
        f fVar = this.bxs;
        long j2 = j & 3;
        OnClickListener onClickListener2 = null;
        if (j2 == 0 || fVar == null) {
            onClickListener = null;
        } else {
            a aVar;
            b bVar;
            if (this.bxw == null) {
                aVar = new a();
                this.bxw = aVar;
            } else {
                aVar = this.bxw;
            }
            onClickListener2 = aVar.d(fVar);
            if (this.bxx == null) {
                bVar = new b();
                this.bxx = bVar;
            } else {
                bVar = this.bxx;
            }
            onClickListener = bVar.e(fVar);
        }
        if (j2 != 0) {
            this.aOU.setOnClickListener(onClickListener);
            this.bnd.setOnClickListener(onClickListener2);
        }
        if ((j & 2) != 0) {
            com.iqoption.core.ui.a.a(this.bnn, ViewDataBinding.getColorFromResource(this.bnn, R.color.white));
        }
    }
}
