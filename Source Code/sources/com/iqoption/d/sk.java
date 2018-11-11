package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.AppCompatCheckBox;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.iqoption.e.a.a.a;
import com.iqoption.fragment.cn;
import com.iqoption.view.OtnLoyaltyTeaserView;
import com.iqoption.view.RobotoTextView;
import com.iqoption.view.text.FormattedTextView;
import com.iqoption.x.R;

/* compiled from: FragmentTokenBalanceBindingImpl */
public class sk extends sj implements a {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @NonNull
    private final NestedScrollView bCV;
    @Nullable
    private final OnClickListener bCW;
    @Nullable
    private final OnClickListener bCX;

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        awV.put(R.id.contentContainer, 10);
        awV.put(R.id.titleTextOtn, 11);
        awV.put(R.id.otnValue, 12);
        awV.put(R.id.traningBalanceInfo, 13);
        awV.put(R.id.withdrawButton, 14);
        awV.put(R.id.btnOtnWithdrawProgress, 15);
        awV.put(R.id.withdrawButtonTitle, 16);
        awV.put(R.id.balanceContainer, 17);
        awV.put(R.id.balanceToken, 18);
        awV.put(R.id.stockRateValue, 19);
        awV.put(R.id.internalContainer, 20);
        awV.put(R.id.internalRateValue, 21);
        awV.put(R.id.contentContainer2, 22);
        awV.put(R.id.weeklyGainInfo, 23);
        awV.put(R.id.infoContainer, 24);
        awV.put(R.id.turnoverContainer, 25);
        awV.put(R.id.turnoverValue, 26);
        awV.put(R.id.expectedTitle, 27);
        awV.put(R.id.expectedValue, 28);
        awV.put(R.id.distributeContainer, 29);
        awV.put(R.id.yourPosition, 30);
        awV.put(R.id.distributePercenteValue, 31);
        awV.put(R.id.reducingComissionInfo, 32);
        awV.put(R.id.otnCommissionTitle, 33);
        awV.put(R.id.otnRate, 34);
        awV.put(R.id.otnPayCommissionCheck, 35);
        awV.put(R.id.emissionInfo, 36);
        awV.put(R.id.emissionTitleContainer, 37);
        awV.put(R.id.emissionValueContainer, 38);
        awV.put(R.id.emissionLastWeekValue, 39);
        awV.put(R.id.emissionNextWeekValue, 40);
        awV.put(R.id.diviner, 41);
        awV.put(R.id.tokensLeftLayout, 42);
        awV.put(R.id.tokenLeftTitle, 43);
        awV.put(R.id.tokensLeftValue, 44);
    }

    public sk(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 45, awU, awV));
    }

    private sk(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[17], (LinearLayout) objArr[18], (ProgressBar) objArr[15], (LinearLayout) objArr[10], (LinearLayout) objArr[22], (FrameLayout) objArr[29], (RobotoTextView) objArr[31], (View) objArr[41], (RobotoTextView) objArr[9], (TextView) objArr[36], (RobotoTextView) objArr[39], (RobotoTextView) objArr[40], (LinearLayout) objArr[37], (LinearLayout) objArr[38], (LinearLayout) objArr[6], (RobotoTextView) objArr[27], (RobotoTextView) objArr[28], (TextView) objArr[5], (OtnLoyaltyTeaserView) objArr[24], (LinearLayout) objArr[20], (RobotoTextView) objArr[21], (RobotoTextView) objArr[1], (RobotoTextView) objArr[2], (RelativeLayout) objArr[8], (RobotoTextView) objArr[33], (AppCompatCheckBox) objArr[35], (RobotoTextView) objArr[34], (RobotoTextView) objArr[12], (LinearLayout) objArr[3], (RobotoTextView) objArr[7], (TextView) objArr[32], (RobotoTextView) objArr[19], (FormattedTextView) objArr[11], (RobotoTextView) objArr[43], (LinearLayout) objArr[42], (RobotoTextView) objArr[44], (TextView) objArr[13], (LinearLayout) objArr[25], (RobotoTextView) objArr[26], (RobotoTextView) objArr[4], (TextView) objArr[23], (FrameLayout) objArr[14], (RobotoTextView) objArr[16], (RobotoTextView) objArr[30]);
        this.awW = -1;
        this.bCk.setTag(null);
        this.bCq.setTag(null);
        this.bCt.setTag(null);
        this.bCx.setTag(null);
        this.bCV = (NestedScrollView) objArr[0];
        this.bCV.setTag(null);
        this.bCy.setTag(null);
        this.bCz.setTag(null);
        this.bCE.setTag(null);
        this.bCF.setTag(null);
        this.bCP.setTag(null);
        setRootTag(view);
        this.bCW = new com.iqoption.e.a.a(this, 1);
        this.bCX = new com.iqoption.e.a.a(this, 2);
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
        a((cn) obj);
        return true;
    }

    public void a(@Nullable cn cnVar) {
        this.bCU = cnVar;
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
        cn cnVar = this.bCU;
        if ((j & 2) != 0) {
            Void voidR = (Void) null;
            com.iqoption.core.ui.a.a(this.bCk, voidR);
            this.bCq.setOnClickListener(this.bCX);
            com.iqoption.core.ui.a.a(this.bCq, voidR);
            this.bCt.setOnClickListener(this.bCW);
            com.iqoption.core.ui.a.a(this.bCx, voidR);
            com.iqoption.core.ui.a.a(this.bCy, voidR);
            com.iqoption.core.ui.a.a(this.bCz, voidR);
            com.iqoption.core.ui.a.a(this.bCE, voidR);
            com.iqoption.core.ui.a.a(this.bCF, voidR);
            com.iqoption.core.ui.a.a(this.bCP, voidR);
        }
    }

    public final void a(int i, View view) {
        Object obj = null;
        cn cnVar;
        switch (i) {
            case 1:
                cnVar = this.bCU;
                if (cnVar != null) {
                    obj = 1;
                }
                if (obj != null) {
                    cnVar.ahV();
                    return;
                }
                return;
            case 2:
                cnVar = this.bCU;
                if (cnVar != null) {
                    obj = 1;
                }
                if (obj != null) {
                    cnVar.ahV();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
