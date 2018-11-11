package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.e.a.a.a;
import com.iqoption.fragment.dialog.nps.b;
import com.iqoption.x.R;

/* compiled from: NpsFeedbackFragmentBindingImpl */
public class abr extends abq implements a {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @Nullable
    private final OnClickListener bMA;

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        awV.put(R.id.rootContainer, 2);
        awV.put(R.id.toolbar, 3);
        awV.put(R.id.tittle, 4);
        awV.put(R.id.closeFrame, 5);
        awV.put(R.id.content, 6);
        awV.put(R.id.question, 7);
        awV.put(R.id.feedback, 8);
        awV.put(R.id.skip, 9);
        awV.put(R.id.send, 10);
    }

    public abr(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 11, awU, awV));
    }

    private abr(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[1], (FrameLayout) objArr[5], (ConstraintLayout) objArr[6], (EditText) objArr[8], (TextView) objArr[7], (ConstraintLayout) objArr[2], (FrameLayout) objArr[0], (TextView) objArr[10], (TextView) objArr[9], (TextView) objArr[4], (FrameLayout) objArr[3]);
        this.awW = -1;
        this.bBI.setTag(null);
        this.bMw.setTag(null);
        setRootTag(view);
        this.bMA = new com.iqoption.e.a.a(this, 1);
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
        a((b) obj);
        return true;
    }

    public void a(@Nullable b bVar) {
        this.bMz = bVar;
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
        b bVar = this.bMz;
        if ((j & 2) != 0) {
            this.bBI.setOnClickListener(this.bMA);
        }
    }

    public final void a(int i, View view) {
        b bVar = this.bMz;
        if ((bVar != null ? 1 : null) != null) {
            bVar.onClose();
        }
    }
}
