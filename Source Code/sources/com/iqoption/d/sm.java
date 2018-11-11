package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Guideline;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.core.ui.a;
import com.iqoption.x.R;

/* compiled from: FragmentToolsBindingImpl */
public class sm extends sl {
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
        awV.put(R.id.guidelineLeftPanel, 2);
        awV.put(R.id.guidelineTimeScaleBar, 3);
        awV.put(R.id.lineButton, 4);
        awV.put(R.id.trendLineButton, 5);
        awV.put(R.id.horizontalLineButton, 6);
        awV.put(R.id.verticalLineButton, 7);
        awV.put(R.id.fibonacciLinesButton, 8);
        awV.put(R.id.fibonacciArcButton, 9);
        awV.put(R.id.fibonacciSpiralButton, 10);
        awV.put(R.id.activesTools, 11);
        awV.put(R.id.activesToolsTitle, 12);
        awV.put(R.id.activesToolsCount, 13);
        awV.put(R.id.indicators, 14);
        awV.put(R.id.templatesTools, 15);
        awV.put(R.id.templatesTitle, 16);
        awV.put(R.id.activeTemplatesToolsCount, 17);
        awV.put(R.id.otherSettingsTools, 18);
        awV.put(R.id.otherSettingsTitle, 19);
    }

    public sm(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 20, awU, awV));
    }

    private sm(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[17], (LinearLayout) objArr[11], (TextView) objArr[13], (TextView) objArr[12], (ConstraintLayout) objArr[0], (ImageView) objArr[9], (ImageView) objArr[8], (ImageView) objArr[10], (Guideline) objArr[2], (Guideline) objArr[3], (ImageView) objArr[6], (LinearLayout) objArr[14], (ImageView) objArr[4], (LinearLayout) objArr[1], (TextView) objArr[19], (LinearLayout) objArr[18], (TextView) objArr[16], (LinearLayout) objArr[15], (ImageView) objArr[5], (ImageView) objArr[7]);
        this.awW = -1;
        this.bDc.setTag(null);
        this.aOX.setTag(null);
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
        long j;
        synchronized (this) {
            j = this.awW;
            this.awW = 0;
        }
        if ((j & 1) != 0) {
            a.j(this.aOX, ViewDataBinding.getColorFromResource(this.aOX, R.color.bg_second_level));
        }
    }
}
