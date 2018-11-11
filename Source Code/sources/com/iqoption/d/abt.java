package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.TextViewBindingAdapter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.core.ui.widget.nps.NpsRatingBar;
import com.iqoption.e.a.a.a;
import com.iqoption.fragment.dialog.nps.c;
import com.iqoption.x.R;

/* compiled from: NpsScoreFragmentBindingImpl */
public class abt extends abs implements a {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @Nullable
    private final OnClickListener bML;

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        awV.put(R.id.toolbar, 4);
        awV.put(R.id.tittle, 5);
        awV.put(R.id.content, 6);
        awV.put(R.id.question, 7);
        awV.put(R.id.ratingBarTitle, 8);
        awV.put(R.id.ratingBar, 9);
        awV.put(R.id.submit, 10);
        awV.put(R.id.error, 11);
        awV.put(R.id.cnErrorIcon, 12);
        awV.put(R.id.errorText, 13);
    }

    public abt(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 14, awU, awV));
    }

    private abt(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[1], (ImageView) objArr[12], (ConstraintLayout) objArr[6], (FrameLayout) objArr[11], (TextView) objArr[13], (TextView) objArr[2], (TextView) objArr[7], (NpsRatingBar) objArr[9], (TextView) objArr[8], (LinearLayout) objArr[0], (TextView) objArr[10], (TextView) objArr[5], (FrameLayout) objArr[4], (TextView) objArr[3]);
        this.awW = -1;
        this.bBI.setTag(null);
        this.bME.setTag(null);
        this.bMH.setTag(null);
        this.bMJ.setTag(null);
        setRootTag(view);
        this.bML = new com.iqoption.e.a.a(this, 1);
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
        a((c) obj);
        return true;
    }

    public void a(@Nullable c cVar) {
        this.bMK = cVar;
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
        c cVar = this.bMK;
        if ((j & 2) != 0) {
            this.bBI.setOnClickListener(this.bML);
            TextViewBindingAdapter.setDrawableStart(this.bME, ViewDataBinding.getDrawableFromResource(this.bME, R.drawable.ic_not_likely));
            Void voidR = (Void) null;
            com.iqoption.core.ui.a.a(this.bME, voidR);
            TextViewBindingAdapter.setDrawableStart(this.bMJ, ViewDataBinding.getDrawableFromResource(this.bMJ, R.drawable.ic_likely));
            com.iqoption.core.ui.a.a(this.bMJ, voidR);
        }
    }

    public final void a(int i, View view) {
        c cVar = this.bMK;
        if ((cVar != null ? 1 : null) != null) {
            cVar.onClose();
        }
    }
}
