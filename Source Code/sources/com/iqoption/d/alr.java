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
import android.widget.TextView;
import com.iqoption.e.a.a.a;
import com.iqoption.view.SmoothViewPager;
import com.iqoption.x.R;

/* compiled from: ViewPagerWhatsNewDialogBindingImpl */
public class alr extends alq implements a {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @NonNull
    private final LinearLayout axx;
    @Nullable
    private final OnClickListener bUm;

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        awV.put(R.id.whatsNewTitle, 2);
        awV.put(R.id.viewPager, 3);
        awV.put(R.id.navigateButton, 4);
        awV.put(R.id.dots, 5);
        awV.put(R.id.dot1, 6);
        awV.put(R.id.dot2, 7);
    }

    public alr(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, awU, awV));
    }

    private alr(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[6], (ImageView) objArr[7], (LinearLayout) objArr[5], (TextView) objArr[4], (SmoothViewPager) objArr[3], (ImageView) objArr[1], (TextView) objArr[2]);
        this.awW = -1;
        this.axx = (LinearLayout) objArr[0];
        this.axx.setTag(null);
        this.bll.setTag(null);
        setRootTag(view);
        this.bUm = new com.iqoption.e.a.a(this, 1);
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
        a((com.iqoption.fragment.dialog.whatsnew.a) obj);
        return true;
    }

    public void a(@Nullable com.iqoption.fragment.dialog.whatsnew.a aVar) {
        this.bln = aVar;
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
        com.iqoption.fragment.dialog.whatsnew.a aVar = this.bln;
        if ((j & 2) != 0) {
            this.bll.setOnClickListener(this.bUm);
        }
    }

    public final void a(int i, View view) {
        com.iqoption.fragment.dialog.whatsnew.a aVar = this.bln;
        if ((aVar != null ? 1 : null) != null) {
            aVar.onClose();
        }
    }
}
