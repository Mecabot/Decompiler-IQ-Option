package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.iqoption.e.a.a.a;
import com.iqoption.fragment.bx;
import com.iqoption.view.RobotoEditText;
import com.iqoption.view.RobotoTextView;
import com.iqoption.widget.SmallNumPad;
import com.iqoption.x.R;

/* compiled from: FragmentPendingChooserBindingImpl */
public class qa extends pz implements a {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @Nullable
    private final OnClickListener bAt;
    @NonNull
    private final FrameLayout biH;

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        awV.put(R.id.contentLayout, 2);
        awV.put(R.id.content, 3);
        awV.put(R.id.main_title, 4);
        awV.put(R.id.editContainer, 5);
        awV.put(R.id.value, 6);
        awV.put(R.id.marketTitle, 7);
        awV.put(R.id.buttonContainer, 8);
        awV.put(R.id.minusButton, 9);
        awV.put(R.id.plusButton, 10);
        awV.put(R.id.numPad, 11);
    }

    public qa(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 12, awU, awV));
    }

    private qa(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RelativeLayout) objArr[8], (ImageView) objArr[1], (LinearLayout) objArr[3], (FrameLayout) objArr[2], (LinearLayout) objArr[5], (RobotoTextView) objArr[4], (TextView) objArr[7], (ImageView) objArr[9], (SmallNumPad) objArr[11], (ImageView) objArr[10], (RobotoEditText) objArr[6]);
        this.awW = -1;
        this.bAk.setTag(null);
        this.biH = (FrameLayout) objArr[0];
        this.biH.setTag(null);
        setRootTag(view);
        this.bAt = new com.iqoption.e.a.a(this, 1);
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
        a((bx) obj);
        return true;
    }

    public void a(@Nullable bx bxVar) {
        this.bAs = bxVar;
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
        bx bxVar = this.bAs;
        if ((j & 2) != 0) {
            com.iqoption.core.ui.a.a(this.bAk, (Void) null);
            this.biH.setOnClickListener(this.bAt);
        }
    }

    public final void a(int i, View view) {
        bx bxVar = this.bAs;
        if ((bxVar != null ? 1 : null) != null) {
            bxVar.aN();
        }
    }
}
