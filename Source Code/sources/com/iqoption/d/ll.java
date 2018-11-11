package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.iqoption.fragment.BalanceSelectionFragment;
import com.iqoption.view.RobotoTextView;
import com.iqoption.x.R;

/* compiled from: FragmentBalanceSelectionBindingXlargeXhdpiImpl */
public class ll extends lj implements com.iqoption.e.a.a.a {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @NonNull
    private final ImageView bwL;
    @Nullable
    private final OnClickListener bxc;
    private a bxd;

    /* compiled from: FragmentBalanceSelectionBindingXlargeXhdpiImpl */
    public static class a implements OnClickListener {
        private BalanceSelectionFragment bxb;

        public a c(BalanceSelectionFragment balanceSelectionFragment) {
            this.bxb = balanceSelectionFragment;
            return balanceSelectionFragment == null ? null : this;
        }

        public void onClick(View view) {
            this.bxb.aO(view);
        }
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        awV.put(R.id.practiceBalanceText, 4);
        awV.put(R.id.realBalance, 5);
        awV.put(R.id.practiceText, 6);
        awV.put(R.id.depositNowText, 7);
    }

    public ll(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, awU, awV));
    }

    private ll(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[0], (RelativeLayout) objArr[3], (RobotoTextView) objArr[7], (TextView) objArr[4], (RelativeLayout) objArr[2], (RobotoTextView) objArr[6], (TextView) objArr[5]);
        this.awW = -1;
        this.bwR.setTag(null);
        this.bwS.setTag(null);
        this.bwL = (ImageView) objArr[1];
        this.bwL.setTag(null);
        this.bwV.setTag(null);
        setRootTag(view);
        this.bxc = new com.iqoption.e.a.a(this, 1);
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
        a((BalanceSelectionFragment) obj);
        return true;
    }

    public void a(@Nullable BalanceSelectionFragment balanceSelectionFragment) {
        this.bwY = balanceSelectionFragment;
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
        OnClickListener onClickListener = null;
        BalanceSelectionFragment balanceSelectionFragment = this.bwY;
        long j2 = j & 3;
        if (!(j2 == 0 || balanceSelectionFragment == null)) {
            a aVar;
            if (this.bxd == null) {
                aVar = new a();
                this.bxd = aVar;
            } else {
                aVar = this.bxd;
            }
            onClickListener = aVar.c(balanceSelectionFragment);
        }
        if (j2 != 0) {
            this.bwS.setOnClickListener(onClickListener);
            this.bwV.setOnClickListener(onClickListener);
        }
        if ((j & 2) != 0) {
            this.bwL.setOnClickListener(this.bxc);
        }
    }

    public final void a(int i, View view) {
        BalanceSelectionFragment balanceSelectionFragment = this.bwY;
        if ((balanceSelectionFragment != null ? 1 : null) != null) {
            balanceSelectionFragment.onClose();
        }
    }
}
