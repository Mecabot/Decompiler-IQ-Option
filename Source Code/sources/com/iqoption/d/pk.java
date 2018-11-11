package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.x.R;

/* compiled from: FragmentOtnLeadingBoardBindingImpl */
public class pk extends pj {
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
        awV.put(R.id.leftPanelStub, 1);
        awV.put(R.id.leaderBoardContainer, 2);
        awV.put(R.id.container, 3);
        awV.put(R.id.headerLayout, 4);
        awV.put(R.id.leaderBoardTitle, 5);
        awV.put(R.id.countrySelectorContainer, 6);
        awV.put(R.id.countrySelector, 7);
        awV.put(R.id.tokenBalanceHighlighter, 8);
        awV.put(R.id.leaderBoardList, 9);
        awV.put(R.id.currentUserData, 10);
        awV.put(R.id.placeText, 11);
        awV.put(R.id.countryFlag, 12);
        awV.put(R.id.userName, 13);
        awV.put(R.id.youText, 14);
        awV.put(R.id.userScore, 15);
        awV.put(R.id.progress, 16);
        awV.put(R.id.fragmentContainer, 17);
    }

    public pk(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 18, awU, awV));
    }

    private pk(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (FrameLayout) objArr[3], (ImageView) objArr[12], (TextView) objArr[7], (LinearLayout) objArr[6], (LinearLayout) objArr[10], (FrameLayout) objArr[17], (LinearLayout) objArr[4], (FrameLayout) objArr[2], (RecyclerView) objArr[9], (TextView) objArr[5], (View) objArr[1], (TextView) objArr[11], (FrameLayout) objArr[16], (FrameLayout) objArr[0], (ImageView) objArr[8], (TextView) objArr[13], (TextView) objArr[15], (TextView) objArr[14]);
        this.awW = -1;
        this.bzL.setTag(null);
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
