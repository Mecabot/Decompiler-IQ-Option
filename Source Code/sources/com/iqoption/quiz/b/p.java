package com.iqoption.quiz.b;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.quiz.ae.c;
import com.iqoption.quiz.widget.CountDownProgressBar;

/* compiled from: QuestionLayoutBindingImpl */
public class p extends o {
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
        awV.put(c.iconEyeCounter, 1);
        awV.put(c.onlineCounter, 2);
        awV.put(c.questionProgress, 3);
        awV.put(c.questionNOfM, 4);
        awV.put(c.questionText, 5);
        awV.put(c.answer1, 6);
        awV.put(c.answer2, 7);
        awV.put(c.answer3, 8);
    }

    public p(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 9, awU, awV));
    }

    private p(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[6], (TextView) objArr[7], (TextView) objArr[8], (ImageView) objArr[1], (TextView) objArr[2], (TextView) objArr[4], (CountDownProgressBar) objArr[3], (TextView) objArr[5]);
        this.awW = -1;
        this.biA = (ConstraintLayout) objArr[0];
        this.biA.setTag(null);
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
