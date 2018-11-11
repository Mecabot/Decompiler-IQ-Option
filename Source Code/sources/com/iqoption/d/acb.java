package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import com.iqoption.view.RobotoTextView;
import com.iqoption.view.text.FormattedTextView;
import com.iqoption.x.R;

/* compiled from: OpenBinaryOptionItemBindingImpl */
public class acb extends aca {
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
        awV.put(R.id.buyBackFrame, 1);
        awV.put(R.id.buyBackLayout, 2);
        awV.put(R.id.confirmSellingText, 3);
        awV.put(R.id.buybackOptionProgress, 4);
        awV.put(R.id.buyBackValue, 5);
        awV.put(R.id.positionLayout, 6);
        awV.put(R.id.positionItem, 7);
        awV.put(R.id.itemValue, 8);
        awV.put(R.id.directionImage, 9);
        awV.put(R.id.itemWinAmount, 10);
        awV.put(R.id.itemTimeStamp, 11);
        awV.put(R.id.itemAmount, 12);
        awV.put(R.id.sellingPriceLayout, 13);
        awV.put(R.id.sellingPriceText, 14);
        awV.put(R.id.sellingPriceValue, 15);
        awV.put(R.id.platformIcon, 16);
    }

    public acb(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 17, awU, awV));
    }

    private acb(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (FrameLayout) objArr[1], (LinearLayout) objArr[2], (RobotoTextView) objArr[5], (ContentLoadingProgressBar) objArr[4], (FormattedTextView) objArr[3], (ImageView) objArr[9], (TextView) objArr[12], (TextView) objArr[11], (TextView) objArr[8], (RobotoTextView) objArr[10], (FrameLayout) objArr[0], (ImageView) objArr[16], (TableLayout) objArr[7], (LinearLayout) objArr[6], (TableRow) objArr[13], (TextView) objArr[14], (RobotoTextView) objArr[15]);
        this.awW = -1;
        this.bNq.setTag(null);
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
