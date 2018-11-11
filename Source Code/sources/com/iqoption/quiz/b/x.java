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
import pl.droidsonroids.gif.GifImageView;

/* compiled from: SplashLayoutBindingImpl */
public class x extends w {
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
        awV.put(c.iconTriviaHodly, 3);
        awV.put(c.line1, 4);
        awV.put(c.line2, 5);
        awV.put(c.line3, 6);
        awV.put(c.line4, 7);
        awV.put(c.line5, 8);
        awV.put(c.bonusLivesText1, 9);
        awV.put(c.bonusLivesText2, 10);
        awV.put(c.heartAnimated, 11);
        awV.put(c.lifeCount, 12);
        awV.put(c.inviteFriend, 13);
    }

    public x(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 14, awU, awV));
    }

    private x(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[9], (TextView) objArr[10], (GifImageView) objArr[11], (ImageView) objArr[1], (ImageView) objArr[3], (TextView) objArr[13], (TextView) objArr[12], (TextView) objArr[4], (TextView) objArr[5], (TextView) objArr[6], (TextView) objArr[7], (TextView) objArr[8], (TextView) objArr[2]);
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
