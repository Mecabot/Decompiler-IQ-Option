package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.RecyclerView;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.core.ui.a;
import com.iqoption.x.R;

/* compiled from: FragmentSearchCountryBindingImpl */
public class se extends sd {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @NonNull
    private final FrameLayout biH;

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        awV.put(R.id.countryBackground, 2);
        awV.put(R.id.countryContainer, 3);
        awV.put(R.id.searchCountryToolbar, 4);
        awV.put(R.id.searchCountryTitle, 5);
        awV.put(R.id.searchCountryClose, 6);
        awV.put(R.id.countryInputContainer, 7);
        awV.put(R.id.countryInput, 8);
        awV.put(R.id.countryEdit, 9);
        awV.put(R.id.countrySuggestList, 10);
    }

    public se(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 11, awU, awV));
    }

    private se(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (View) objArr[2], (LinearLayout) objArr[3], (TextInputEditText) objArr[9], (TextInputLayout) objArr[8], (FrameLayout) objArr[7], (ImageView) objArr[1], (RecyclerView) objArr[10], (ImageView) objArr[6], (TextView) objArr[5], (LinearLayout) objArr[4]);
        this.awW = -1;
        this.bBY.setTag(null);
        this.biH = (FrameLayout) objArr[0];
        this.biH.setTag(null);
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
            a.d(this.bBY, 0.5f);
        }
    }
}
