package com.iqoption.charttools.b;

import android.animation.TimeInterpolator;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.iqoption.charttools.o;
import com.iqoption.charttools.o.c;
import com.iqoption.charttools.o.g;
import com.iqoption.charttools.o.i;
import com.iqoption.core.ui.a;
import com.iqoption.core.ui.b;

/* compiled from: FragmentTemplateBindingLandImpl */
public class f extends d {
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
        awV.put(g.topBar, 8);
        awV.put(g.btnBack, 9);
        awV.put(g.title, 10);
        awV.put(g.btnSave, 11);
        awV.put(g.templateFrame, 12);
        awV.put(g.templateContent, 13);
        awV.put(g.inputName, 14);
        awV.put(g.instrumentsList, 15);
        awV.put(g.linesSnippet, 16);
        awV.put(g.switchChartSettings, 17);
        awV.put(g.containerChartType, 18);
        awV.put(g.chartType, 19);
        awV.put(g.containerCandleSize, 20);
        awV.put(g.candleSize, 21);
        awV.put(g.switchHeikenAshi, 22);
        awV.put(g.switchAutoScale, 23);
        awV.put(g.switchTradersMood, 24);
        awV.put(g.switchLiveDeals, 25);
        awV.put(g.switchVolume, 26);
    }

    public f(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 27, awU, awV));
    }

    private f(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[9], (View) objArr[3], (View) objArr[1], (View) objArr[6], (FrameLayout) objArr[11], (TextView) objArr[4], (ProgressBar) objArr[5], (TextView) objArr[21], (TextView) objArr[19], (FrameLayout) objArr[20], (FrameLayout) objArr[18], (FrameLayout) objArr[0], (EditText) objArr[14], (RecyclerView) objArr[15], (TextView) objArr[16], (ProgressBar) objArr[2], (ProgressBar) objArr[7], (SwitchCompat) objArr[23], (SwitchCompat) objArr[17], (SwitchCompat) objArr[22], (SwitchCompat) objArr[25], (SwitchCompat) objArr[24], (SwitchCompat) objArr[26], (LinearLayout) objArr[13], (FrameLayout) objArr[12], (TextView) objArr[10], (View) objArr[8]);
        this.awW = -1;
        this.awX.setTag(null);
        this.awY.setTag(null);
        this.awZ.setTag(null);
        this.axb.setTag(null);
        this.axc.setTag(null);
        this.axh.setTag(null);
        this.axl.setTag(null);
        this.axm.setTag(null);
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
            a.g((TextView) this.awX, 0.5f);
            a.g((TextView) this.awY, 0.5f);
            a.g((TextView) this.awZ, 0.5f);
            a.a(this.axb, b.gS(this.axb.getResources().getString(i.spec_templates_item_button_states)), this.axb.getResources().obtainTypedArray(o.a.spec_templates_item_button_text_colors), (long[]) null, (TimeInterpolator[]) null);
            a.a(this.axc, ViewDataBinding.getColorFromResource(this.axc, c.white));
            a.a(this.axl, ViewDataBinding.getColorFromResource(this.axl, c.white));
            a.a(this.axm, ViewDataBinding.getColorFromResource(this.axm, c.white));
        }
    }
}
