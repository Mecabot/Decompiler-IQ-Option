package com.iqoption.quiz.b;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.iqoption.quiz.ae.c;
import com.iqoption.quiz.widget.CountDownProgressBar;

/* compiled from: AnswerResultLayoutBindingImpl */
public class d extends c {
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
        awV.put(c.answerProgress, 2);
        awV.put(c.onlineCounter, 3);
        awV.put(c.correct, 4);
        awV.put(c.incorrect, 5);
        awV.put(c.questionNOfM, 6);
        awV.put(c.questionText, 7);
        awV.put(c.answerProgress1, 8);
        awV.put(c.answer1, 9);
        awV.put(c.answerCounter1, 10);
        awV.put(c.answerProgress2, 11);
        awV.put(c.answer2, 12);
        awV.put(c.answerCounter2, 13);
        awV.put(c.answerProgress3, 14);
        awV.put(c.answer3, 15);
        awV.put(c.answerCounter3, 16);
    }

    public d(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 17, awU, awV));
    }

    private d(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[9], (TextView) objArr[12], (TextView) objArr[15], (TextView) objArr[10], (TextView) objArr[13], (TextView) objArr[16], (CountDownProgressBar) objArr[2], (ProgressBar) objArr[8], (ProgressBar) objArr[11], (ProgressBar) objArr[14], (TextView) objArr[4], (ImageView) objArr[1], (TextView) objArr[5], (TextView) objArr[3], (TextView) objArr[6], (TextView) objArr[7]);
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
