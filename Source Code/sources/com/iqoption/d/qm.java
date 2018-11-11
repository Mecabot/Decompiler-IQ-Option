package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.iqoption.e.a.a.a;
import com.iqoption.fragment.cb;
import com.iqoption.x.R;

/* compiled from: FragmentPushSettingsBindingImpl */
public class qm extends ql implements a {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @Nullable
    private final OnClickListener bAT;

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        awV.put(R.id.main_content, 2);
        awV.put(R.id.push_settings_list, 3);
        awV.put(R.id.alert_layout, 4);
        awV.put(R.id.alert_image, 5);
        awV.put(R.id.button_enable, 6);
        awV.put(R.id.progress_bar, 7);
    }

    public qm(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, awU, awV));
    }

    private qm(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (FrameLayout) objArr[0], (ImageView) objArr[5], (LinearLayout) objArr[4], (TextView) objArr[6], (ImageView) objArr[1], (LinearLayout) objArr[2], (ProgressBar) objArr[7], (RecyclerView) objArr[3]);
        this.awW = -1;
        this.bvY.setTag(null);
        this.bwe.setTag(null);
        setRootTag(view);
        this.bAT = new com.iqoption.e.a.a(this, 1);
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
        a((cb) obj);
        return true;
    }

    public void a(@Nullable cb cbVar) {
        this.bAS = cbVar;
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
        cb cbVar = this.bAS;
        if ((j & 2) != 0) {
            this.bwe.setOnClickListener(this.bAT);
        }
    }

    public final void a(int i, View view) {
        cb cbVar = this.bAS;
        if ((cbVar != null ? 1 : null) != null) {
            cbVar.ahJ();
        }
    }
}
