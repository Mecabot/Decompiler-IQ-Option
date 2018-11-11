package com.iqoption.quiz.b;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.TextViewBindingAdapter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import com.iqoption.quiz.ae.b;
import com.iqoption.quiz.ae.c;

/* compiled from: QuizRulesLayoutBindingImpl */
public class v extends u {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @NonNull
    private final ConstraintLayout biA;

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        awV.put(c.title, 5);
    }

    public v(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, awU, awV));
    }

    private v(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[1], (TextView) objArr[2], (TextView) objArr[3], (TextView) objArr[4], (TextView) objArr[5]);
        this.awW = -1;
        this.biA = (ConstraintLayout) objArr[0];
        this.biA.setTag(null);
        this.dkS.setTag(null);
        this.dkT.setTag(null);
        this.dkU.setTag(null);
        this.dkV.setTag(null);
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
            TextViewBindingAdapter.setDrawableStart(this.dkS, ViewDataBinding.getDrawableFromResource(this.dkS, b.rect_white_50_rounded_7));
            TextViewBindingAdapter.setDrawableStart(this.dkT, ViewDataBinding.getDrawableFromResource(this.dkT, b.rect_white_50_rounded_7));
            TextViewBindingAdapter.setDrawableStart(this.dkU, ViewDataBinding.getDrawableFromResource(this.dkU, b.rect_white_50_rounded_7));
            TextViewBindingAdapter.setDrawableStart(this.dkV, ViewDataBinding.getDrawableFromResource(this.dkV, b.rect_white_50_rounded_7));
        }
    }
}
