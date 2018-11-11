package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.e.a.a.a;
import com.iqoption.view.text.FormattedTextView;
import com.iqoption.x.R;

/* compiled from: WhatsNewDialogSpotBindingImpl */
public class amf extends ame implements a {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @Nullable
    private final OnClickListener bUJ;
    @Nullable
    private final OnClickListener bUK;
    @NonNull
    private final ConstraintLayout biA;

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        awV.put(R.id.bottomBarBackground, 3);
        awV.put(R.id.whatsNewTittle, 4);
        awV.put(R.id.image, 5);
        awV.put(R.id.title, 6);
        awV.put(R.id.text, 7);
    }

    public amf(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, awU, awV));
    }

    private amf(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (View) objArr[3], (ImageView) objArr[5], (TextView) objArr[7], (TextView) objArr[6], (TextView) objArr[2], (ImageView) objArr[1], (FormattedTextView) objArr[4]);
        this.awW = -1;
        this.biA = (ConstraintLayout) objArr[0];
        this.biA.setTag(null);
        this.bUI.setTag(null);
        this.bll.setTag(null);
        setRootTag(view);
        this.bUJ = new com.iqoption.e.a.a(this, 1);
        this.bUK = new com.iqoption.e.a.a(this, 2);
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
        a((com.iqoption.fragment.dialog.whatsnew.a) obj);
        return true;
    }

    public void a(@Nullable com.iqoption.fragment.dialog.whatsnew.a aVar) {
        this.bln = aVar;
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
        com.iqoption.fragment.dialog.whatsnew.a aVar = this.bln;
        if ((j & 2) != 0) {
            this.bUI.setOnClickListener(this.bUK);
            this.bll.setOnClickListener(this.bUJ);
        }
    }

    public final void a(int i, View view) {
        Object obj = null;
        com.iqoption.fragment.dialog.whatsnew.a aVar;
        switch (i) {
            case 1:
                aVar = this.bln;
                if (aVar != null) {
                    obj = 1;
                }
                if (obj != null) {
                    aVar.onClose();
                    return;
                }
                return;
            case 2:
                aVar = this.bln;
                if (aVar != null) {
                    obj = 1;
                }
                if (obj != null) {
                    aVar.alp();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
