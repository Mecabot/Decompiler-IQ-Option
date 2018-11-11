package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.TextViewBindingAdapter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.iqoption.dto.ToastEntity;
import com.iqoption.view.RobotoTextView;
import com.iqoption.x.R;

/* compiled from: LocalToastLayoutBindingImpl */
public class yl extends yk {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        awV.put(R.id.localToastTypeIndicator, 3);
        awV.put(R.id.toastActionIcon, 4);
    }

    public yl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, awU, awV));
    }

    private yl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RobotoTextView) objArr[2], (LinearLayout) objArr[0], (RobotoTextView) objArr[1], (View) objArr[3], (ImageView) objArr[4]);
        this.awW = -1;
        this.bKJ.setTag(null);
        this.bjl.setTag(null);
        this.bKK.setTag(null);
        setRootTag(view);
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
        if (6 != i) {
            return false;
        }
        d((ToastEntity) obj);
        return true;
    }

    public void d(@Nullable ToastEntity toastEntity) {
        this.bKN = toastEntity;
        synchronized (this) {
            this.awW |= 1;
        }
        notifyPropertyChanged(6);
        super.requestRebind();
    }

    protected void executeBindings() {
        long j;
        CharSequence charSequence;
        synchronized (this) {
            j = this.awW;
            this.awW = 0;
        }
        ToastEntity toastEntity = this.bKN;
        long j2 = j & 3;
        CharSequence charSequence2 = null;
        if (j2 == 0 || toastEntity == null) {
            charSequence = null;
        } else {
            charSequence2 = toastEntity.getActionText();
            charSequence = toastEntity.getTitle();
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.bKJ, charSequence2);
            TextViewBindingAdapter.setText(this.bKK, charSequence);
        }
    }
}
