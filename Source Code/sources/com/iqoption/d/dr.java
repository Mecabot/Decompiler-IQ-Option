package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.chat.fragment.MessageView;
import com.iqoption.core.ui.a;
import com.iqoption.x.R;

/* compiled from: ChatLikeDislikeMessageItemBindingImpl */
public class dr extends dq {
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
        awV.put(R.id.bubbleLayout, 4);
        awV.put(R.id.bubble, 5);
        awV.put(R.id.author, 6);
        awV.put(R.id.message, 7);
        awV.put(R.id.buttonsLayout, 8);
    }

    public dr(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 9, awU, awV));
    }

    private dr(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[6], (ImageView) objArr[3], (LinearLayout) objArr[5], (FrameLayout) objArr[4], (LinearLayout) objArr[8], (ImageView) objArr[2], (ImageView) objArr[1], (MessageView) objArr[7]);
        this.awW = -1;
        this.bmj.setTag(null);
        this.bmQ.setTag(null);
        this.bmR.setTag(null);
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
        long j;
        synchronized (this) {
            j = this.awW;
            this.awW = 0;
        }
        if ((j & 1) != 0) {
            a.e(this.bmj, 0.95f);
            a.f(this.bmQ, this.bmQ.getResources().getDimension(R.dimen._dp4));
            a.f(this.bmR, this.bmR.getResources().getDimension(R.dimen._dp4));
        }
    }
}
