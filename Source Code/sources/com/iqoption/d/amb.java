package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.e.a.a.a;
import com.iqoption.view.RobotoTextView;
import com.iqoption.x.R;

/* compiled from: WhatsNewDialogBindingImpl */
public class amb extends ama implements a {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @NonNull
    private final LinearLayout axx;
    @Nullable
    private final OnClickListener bUD;

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        awV.put(R.id.whatsNewTittle, 2);
        awV.put(R.id.whatsNewDescription, 3);
        awV.put(R.id.thumbnail, 4);
        awV.put(R.id.thumbnailFilter, 5);
        awV.put(R.id.durationContainer, 6);
        awV.put(R.id.duration, 7);
        awV.put(R.id.playButton, 8);
    }

    public amb(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 9, awU, awV));
    }

    private amb(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[7], (LinearLayout) objArr[6], (AppCompatImageView) objArr[8], (ImageView) objArr[4], (View) objArr[5], (ImageView) objArr[1], (RobotoTextView) objArr[3], (TextView) objArr[2]);
        this.awW = -1;
        this.axx = (LinearLayout) objArr[0];
        this.axx.setTag(null);
        this.bll.setTag(null);
        setRootTag(view);
        this.bUD = new com.iqoption.e.a.a(this, 1);
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
            this.bll.setOnClickListener(this.bUD);
        }
    }

    public final void a(int i, View view) {
        com.iqoption.fragment.dialog.whatsnew.a aVar = this.bln;
        if ((aVar != null ? 1 : null) != null) {
            aVar.onClose();
        }
    }
}
