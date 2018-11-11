package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.RecyclerView;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.x.R;

/* compiled from: ToolsFragmentBindingImpl */
public class akv extends aku {
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
        awV.put(R.id.contentLayout, 1);
        awV.put(R.id.mainContent, 2);
        awV.put(R.id.lineButton, 3);
        awV.put(R.id.trendLineButton, 4);
        awV.put(R.id.horizontalLineButton, 5);
        awV.put(R.id.verticalLineButton, 6);
        awV.put(R.id.fibonacciLinesButton, 7);
        awV.put(R.id.fibonacciArcButton, 8);
        awV.put(R.id.fibonacciSpiralButton, 9);
        awV.put(R.id.activesTools, 10);
        awV.put(R.id.activesToolsTitle, 11);
        awV.put(R.id.activesToolsCount, 12);
        awV.put(R.id.indicators, 13);
        awV.put(R.id.templatesTools, 14);
        awV.put(R.id.templatesTitle, 15);
        awV.put(R.id.activeTemplatesToolsCount, 16);
        awV.put(R.id.otherSettingsTools, 17);
        awV.put(R.id.otherSettingsTitle, 18);
        awV.put(R.id.divinerListView, 19);
        awV.put(R.id.listViewContainer, 20);
        awV.put(R.id.listTitle, 21);
        awV.put(R.id.listView, 22);
    }

    public akv(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 23, awU, awV));
    }

    private akv(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[16], (LinearLayout) objArr[10], (TextView) objArr[12], (TextView) objArr[11], (LinearLayout) objArr[1], (View) objArr[19], (FrameLayout) objArr[0], (ImageView) objArr[8], (ImageView) objArr[7], (ImageView) objArr[9], (ImageView) objArr[5], (LinearLayout) objArr[13], (ImageView) objArr[3], (TextView) objArr[21], (RecyclerView) objArr[22], (CoordinatorLayout) objArr[20], (LinearLayout) objArr[2], (TextView) objArr[18], (LinearLayout) objArr[17], (TextView) objArr[15], (LinearLayout) objArr[14], (ImageView) objArr[4], (ImageView) objArr[6]);
        this.awW = -1;
        this.bjF.setTag(null);
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
