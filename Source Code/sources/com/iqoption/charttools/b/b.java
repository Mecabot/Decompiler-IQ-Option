package com.iqoption.charttools.b;

import android.animation.TimeInterpolator;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.Guideline;
import android.support.v7.widget.RecyclerView;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.charttools.o;
import com.iqoption.charttools.o.c;
import com.iqoption.charttools.o.g;
import com.iqoption.charttools.o.i;
import com.iqoption.core.ui.a;

/* compiled from: FragmentIndicatorSettingsBindingImpl */
public class b extends a {
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
        awV.put(g.btnBack, 4);
        awV.put(g.title, 5);
        awV.put(g.toolbarBottom, 6);
        awV.put(g.buttonBarTop, 7);
    }

    public b(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, awU, awV));
    }

    private b(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[3], (ImageView) objArr[4], (TextView) objArr[2], (Guideline) objArr[7], (View) objArr[0], (RecyclerView) objArr[1], null, (TextView) objArr[5], (Guideline) objArr[6]);
        this.awW = -1;
        this.awM.setTag(null);
        this.awO.setTag(null);
        this.awQ.setTag(null);
        this.awR.setTag(null);
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
            a.g(this.awM, 0.5f);
            a.j(this.awM, ViewDataBinding.getColorFromResource(this.awM, c.green));
            long[] jArr = (long[]) null;
            TimeInterpolator[] timeInterpolatorArr = (TimeInterpolator[]) null;
            a.a(this.awM, com.iqoption.core.ui.b.gS(this.awM.getResources().getString(i.spec_indicator_constructor_button_text_states)), this.awM.getResources().obtainTypedArray(o.a.spec_indicator_constructor_button_apply_text_colors), jArr, timeInterpolatorArr);
            a.g(this.awO, 0.5f);
            a.j(this.awO, ViewDataBinding.getColorFromResource(this.awO, c.bg_dialog));
            a.a(this.awO, com.iqoption.core.ui.b.gS(this.awO.getResources().getString(i.spec_indicator_constructor_button_text_states)), this.awO.getResources().obtainTypedArray(o.a.spec_indicator_constructor_button_restore_text_colors), jArr, timeInterpolatorArr);
            a.a(this.awR, this.awR.getResources().getBoolean(com.iqoption.charttools.o.b.isTrue));
        }
    }
}
