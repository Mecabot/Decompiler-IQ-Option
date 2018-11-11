package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.TextViewBindingAdapter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.RecyclerView;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.iqoption.core.ui.a;
import com.iqoption.x.R;

/* compiled from: ChatFragmentAttachmentPickerBindingImpl */
public class cx extends cw {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        awV.put(R.id.contentLayout, 2);
        awV.put(R.id.previewList, 3);
        awV.put(R.id.btnGalleryOrSend, 4);
        awV.put(R.id.iconAddSend, 5);
        awV.put(R.id.labelAddSend, 6);
    }

    public cx(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, awU, awV));
    }

    private cx(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[1], (LinearLayout) objArr[4], (LinearLayout) objArr[2], (LottieAnimationView) objArr[5], (TextView) objArr[6], (RecyclerView) objArr[3], (CoordinatorLayout) objArr[0]);
        this.awW = -1;
        this.bmv.setTag(null);
        this.bmA.setTag(null);
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
            TextViewBindingAdapter.setDrawableStart(this.bmv, ViewDataBinding.getDrawableFromResource(this.bmv, R.drawable.ic_clip_white_24dp));
            a.c(this.bmv, ViewDataBinding.getColorFromResource(this.bmv, R.color.chat_attachment_picker_button_icon));
        }
    }
}
