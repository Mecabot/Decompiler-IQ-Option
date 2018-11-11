package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.x.R;

/* compiled from: FragmentLeftPanelBindingImpl */
public class oi extends oh {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @NonNull
    private final LinearLayout axx;

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        awV.put(R.id.menu, 1);
        awV.put(R.id.buttonsLayout, 2);
        awV.put(R.id.portfolio, 3);
        awV.put(R.id.smartFeed, 4);
        awV.put(R.id.quiz, 5);
        awV.put(R.id.quizCountDown, 6);
        awV.put(R.id.quizOnAir, 7);
        awV.put(R.id.signals, 8);
        awV.put(R.id.videoEducation, 9);
        awV.put(R.id.chats, 10);
        awV.put(R.id.otn, 11);
        awV.put(R.id.fragmentContainer, 12);
    }

    public oi(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 13, awU, awV));
    }

    private oi(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[2], (ImageView) objArr[10], (FrameLayout) objArr[12], (ImageView) objArr[1], (ImageView) objArr[11], (ImageView) objArr[3], (ImageView) objArr[5], (TextView) objArr[6], (TextView) objArr[7], (ImageView) objArr[8], (ImageView) objArr[4], (ImageView) objArr[9]);
        this.awW = -1;
        this.axx = (LinearLayout) objArr[0];
        this.axx.setTag(null);
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
