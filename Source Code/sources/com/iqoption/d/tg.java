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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.welcomeonboarding.d.g;
import com.iqoption.x.R;

/* compiled from: FragmentTwoStepAuthBindingImpl */
public class tg extends tf {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    private a bFj;
    private b bFk;
    private c bFl;

    /* compiled from: FragmentTwoStepAuthBindingImpl */
    public static class a implements OnClickListener {
        private g bFm;

        public a b(g gVar) {
            this.bFm = gVar;
            return gVar == null ? null : this;
        }

        public void onClick(View view) {
            this.bFm.cv(view);
        }
    }

    /* compiled from: FragmentTwoStepAuthBindingImpl */
    public static class b implements OnClickListener {
        private g bFm;

        public b c(g gVar) {
            this.bFm = gVar;
            return gVar == null ? null : this;
        }

        public void onClick(View view) {
            this.bFm.cm(view);
        }
    }

    /* compiled from: FragmentTwoStepAuthBindingImpl */
    public static class c implements OnClickListener {
        private g bFm;

        public c d(g gVar) {
            this.bFm = gVar;
            return gVar == null ? null : this;
        }

        public void onClick(View view) {
            this.bFm.co(view);
        }
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        awV.put(R.id.title, 5);
        awV.put(R.id.verificationCodeSentText, 6);
        awV.put(R.id.codeInput, 7);
        awV.put(R.id.codeEdit, 8);
        awV.put(R.id.verificationCodeInfoText, 9);
        awV.put(R.id.verificationCodeTimerText, 10);
    }

    public tg(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 11, awU, awV));
    }

    private tg(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[1], (TextView) objArr[3], (TextInputEditText) objArr[8], (TextInputLayout) objArr[7], (LinearLayout) objArr[0], (ContentLoadingProgressBar) objArr[4], (TextView) objArr[2], (TextView) objArr[5], (TextView) objArr[9], (TextView) objArr[6], (TextView) objArr[10]);
        this.awW = -1;
        this.aOU.setTag(null);
        this.bnd.setTag(null);
        this.bjl.setTag(null);
        this.bnn.setTag(null);
        this.bFe.setTag(null);
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
        a((g) obj);
        return true;
    }

    public void a(@Nullable g gVar) {
        this.bFi = gVar;
        synchronized (this) {
            this.awW |= 1;
        }
        notifyPropertyChanged(4);
        super.requestRebind();
    }

    protected void executeBindings() {
        long j;
        OnClickListener onClickListener;
        OnClickListener onClickListener2;
        synchronized (this) {
            j = this.awW;
            this.awW = 0;
        }
        g gVar = this.bFi;
        long j2 = j & 3;
        OnClickListener onClickListener3 = null;
        if (j2 == 0 || gVar == null) {
            onClickListener = null;
            onClickListener2 = onClickListener;
        } else {
            a aVar;
            b bVar;
            c cVar;
            if (this.bFj == null) {
                aVar = new a();
                this.bFj = aVar;
            } else {
                aVar = this.bFj;
            }
            onClickListener3 = aVar.b(gVar);
            if (this.bFk == null) {
                bVar = new b();
                this.bFk = bVar;
            } else {
                bVar = this.bFk;
            }
            onClickListener2 = bVar.c(gVar);
            if (this.bFl == null) {
                cVar = new c();
                this.bFl = cVar;
            } else {
                cVar = this.bFl;
            }
            onClickListener = cVar.d(gVar);
        }
        if (j2 != 0) {
            this.aOU.setOnClickListener(onClickListener2);
            this.bnd.setOnClickListener(onClickListener);
            this.bFe.setOnClickListener(onClickListener3);
        }
        if ((j & 2) != 0) {
            com.iqoption.core.ui.a.a(this.bnn, ViewDataBinding.getColorFromResource(this.bnn, R.color.white));
            com.iqoption.core.ui.a.d(this.bFe, 0.5f);
        }
    }
}
