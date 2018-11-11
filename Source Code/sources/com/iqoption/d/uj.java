package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.view.RobotoTextView;
import com.iqoption.view.base.BaseHorizontalScrollView;
import com.iqoption.view.text.FormattedTextView;
import com.iqoption.x.R;

/* compiled from: FragmentWelcomeTrendingBindingImpl */
public class uj extends ui {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        awV.put(R.id.contentContainer, 1);
        awV.put(R.id.closeBtn, 2);
        awV.put(R.id.welcomeBackText, 3);
        awV.put(R.id.trendingToday, 4);
        awV.put(R.id.textInvesting, 5);
        awV.put(R.id.scrollPanel, 6);
        awV.put(R.id.bestProfitabilityTitle, 7);
        awV.put(R.id.mostPopularTitle, 8);
        awV.put(R.id.topGainersTitle, 9);
        awV.put(R.id.topLosersTitle, 10);
        awV.put(R.id.lowestSpreadTitle, 11);
        awV.put(R.id.bigMoversTodayTitle, 12);
        awV.put(R.id.bestProfitabilityList, 13);
        awV.put(R.id.mostPopularList, 14);
        awV.put(R.id.topGainersList, 15);
        awV.put(R.id.topLosersList, 16);
        awV.put(R.id.lowestSpreadList, 17);
        awV.put(R.id.bigMoversTodayList, 18);
    }

    public uj(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 19, awU, awV));
    }

    private uj(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RecyclerView) objArr[13], (RobotoTextView) objArr[7], (RecyclerView) objArr[18], (RobotoTextView) objArr[12], (ImageView) objArr[2], (ConstraintLayout) objArr[1], (RecyclerView) objArr[17], (RobotoTextView) objArr[11], (FrameLayout) objArr[0], (RecyclerView) objArr[14], (RobotoTextView) objArr[8], (BaseHorizontalScrollView) objArr[6], (TextView) objArr[5], (RecyclerView) objArr[15], (RobotoTextView) objArr[9], (RecyclerView) objArr[16], (RobotoTextView) objArr[10], (FormattedTextView) objArr[4], (TextView) objArr[3]);
        this.awW = -1;
        this.blc.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.awW = 1;
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

    protected void executeBindings() {
        synchronized (this) {
            long j = this.awW;
            this.awW = 0;
        }
    }
}
