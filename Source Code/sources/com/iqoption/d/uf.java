package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.ViewPager;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.view.scoreboard.OnlineCountBoard;
import com.iqoption.welcomeonboarding.c.d;
import com.iqoption.x.R;

/* compiled from: FragmentWelcomeOnboardingBindingImpl */
public class uf extends ue {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    private a bGA;
    private b bGB;
    @NonNull
    private final ConstraintLayout biA;

    /* compiled from: FragmentWelcomeOnboardingBindingImpl */
    public static class a implements OnClickListener {
        private d bGC;

        public a b(d dVar) {
            this.bGC = dVar;
            return dVar == null ? null : this;
        }

        public void onClick(View view) {
            this.bGC.ct(view);
        }
    }

    /* compiled from: FragmentWelcomeOnboardingBindingImpl */
    public static class b implements OnClickListener {
        private d bGC;

        public b c(d dVar) {
            this.bGC = dVar;
            return dVar == null ? null : this;
        }

        public void onClick(View view) {
            this.bGC.cu(view);
        }
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        awV.put(R.id.dotsContainer, 4);
        awV.put(R.id.viewPager, 5);
        awV.put(R.id.onlineCountContainer, 6);
        awV.put(R.id.onlineCount, 7);
    }

    public uf(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, awU, awV));
    }

    private uf(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[2], (TextView) objArr[1], (Button) objArr[3], (LinearLayout) objArr[4], (OnlineCountBoard) objArr[7], (LinearLayout) objArr[6], (ViewPager) objArr[5]);
        this.awW = -1;
        this.bGs.setTag(null);
        this.bGt.setTag(null);
        this.bGu.setTag(null);
        this.biA = (ConstraintLayout) objArr[0];
        this.biA.setTag(null);
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
        a((d) obj);
        return true;
    }

    public void a(@Nullable d dVar) {
        this.bGz = dVar;
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
        d dVar = this.bGz;
        long j2 = j & 3;
        if (j2 == 0 || dVar == null) {
            onClickListener = null;
            onClickListener2 = onClickListener;
        } else {
            a aVar;
            b bVar;
            if (this.bGA == null) {
                aVar = new a();
                this.bGA = aVar;
            } else {
                aVar = this.bGA;
            }
            onClickListener2 = aVar.b(dVar);
            if (this.bGB == null) {
                bVar = new b();
                this.bGB = bVar;
            } else {
                bVar = this.bGB;
            }
            onClickListener = bVar.c(dVar);
        }
        if (j2 != 0) {
            this.bGs.setOnClickListener(onClickListener2);
            this.bGt.setOnClickListener(onClickListener);
        }
        if ((j & 2) != 0) {
            com.iqoption.core.ui.a.a(this.bGu, (Void) null);
        }
    }
}
