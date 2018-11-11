package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.iqoption.core.ui.a;
import com.iqoption.core.ui.widget.MaxSizeFrameLayout;
import com.iqoption.x.R;

/* compiled from: ChatDialogFeedbackBindingImpl */
public class cd extends cc {
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
        awV.put(R.id.title, 3);
        awV.put(R.id.note, 4);
        awV.put(R.id.commentLayout, 5);
        awV.put(R.id.counter, 6);
        awV.put(R.id.btnSend, 7);
        awV.put(R.id.btnCancel, 8);
    }

    public cd(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 9, awU, awV));
    }

    private cd(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[8], (TextView) objArr[7], (TextInputEditText) objArr[2], (TextInputLayout) objArr[5], (TextView) objArr[6], (MaxSizeFrameLayout) objArr[1], (TextView) objArr[4], (FrameLayout) objArr[0], (TextView) objArr[3]);
        this.awW = -1;
        this.bmd.setTag(null);
        this.bmg.setTag(null);
        this.awS.setTag(null);
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
            a.a(this.bmd, ViewDataBinding.getColorStateListFromResource(this.bmd, R.color.chat_dialog_feedback_comment_bg_tint), this.bmd.getResources().getDimension(R.dimen.text_input_line_width));
            a.j(this.bmg, ViewDataBinding.getColorFromResource(this.bmg, R.color.chat_dialog_bg_tint));
        }
    }
}
