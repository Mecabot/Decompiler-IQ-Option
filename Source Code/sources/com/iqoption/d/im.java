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
import com.iqoption.core.ui.a;
import com.iqoption.fragment.dialog.f;
import com.iqoption.view.RobotoTextView;
import com.iqoption.view.scoreboard.BalanceView;
import com.iqoption.x.R;

/* compiled from: DialogCongratOtnEmissionExecutedBindingImpl */
public class im extends il {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        awV.put(R.id.swapConteiner, 2);
        awV.put(R.id.contentLayout, 3);
        awV.put(R.id.info, 4);
        awV.put(R.id.firstScreen, 5);
        awV.put(R.id.infoTitle, 6);
        awV.put(R.id.congratTitle, 7);
        awV.put(R.id.cashContainer, 8);
        awV.put(R.id.plus, 9);
        awV.put(R.id.value, 10);
        awV.put(R.id.fromBalanceValue, 11);
        awV.put(R.id.getit, 12);
        awV.put(R.id.light, 13);
        awV.put(R.id.logo, 14);
    }

    public im(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 15, awU, awV));
    }

    private im(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[8], (RobotoTextView) objArr[7], (FrameLayout) objArr[3], (LinearLayout) objArr[5], (RobotoTextView) objArr[11], (TextView) objArr[12], (ImageView) objArr[4], (RobotoTextView) objArr[6], (RobotoTextView) objArr[1], (ImageView) objArr[13], (ImageView) objArr[14], (TextView) objArr[9], (FrameLayout) objArr[0], (FrameLayout) objArr[2], (BalanceView) objArr[10]);
        this.awW = -1;
        this.brX.setTag(null);
        this.brJ.setTag(null);
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
        if (1 != i) {
            return false;
        }
        a((f) obj);
        return true;
    }

    public void a(@Nullable f fVar) {
        this.bsd = fVar;
    }

    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.awW;
            this.awW = 0;
        }
        if ((j & 2) != 0) {
            a.a(this.brX, (Void) null);
        }
    }
}
