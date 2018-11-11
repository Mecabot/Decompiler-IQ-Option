package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.view.ConfirmButtonView;
import com.iqoption.view.RobotoTextView;
import com.iqoption.view.SelectionButton;
import com.iqoption.x.R;

/* compiled from: PersonalInfoDialogBindingImpl */
public class adh extends adg {
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
        awV.put(R.id.backButton, 2);
        awV.put(R.id.personalName, 3);
        awV.put(R.id.personalId, 4);
        awV.put(R.id.savePersonalInfo, 5);
        awV.put(R.id.kycStatusLayout, 6);
        awV.put(R.id.kycStatus, 7);
        awV.put(R.id.kycStatusIcon, 8);
        awV.put(R.id.kycDocumentStatus, 9);
        awV.put(R.id.kycDaysLeft, 10);
        awV.put(R.id.infoTab, 11);
        awV.put(R.id.passTab, 12);
        awV.put(R.id.docTabContainer, 13);
        awV.put(R.id.docsTab, 14);
        awV.put(R.id.iconAlertDocs, 15);
        awV.put(R.id.cardsTabContainer, 16);
        awV.put(R.id.cardsTab, 17);
        awV.put(R.id.iconAlertCards, 18);
        awV.put(R.id.personalViewPager, 19);
    }

    public adh(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 20, awU, awV));
    }

    private adh(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageButton) objArr[2], (SelectionButton) objArr[17], (FrameLayout) objArr[16], (FrameLayout) objArr[13], (SelectionButton) objArr[14], (ImageView) objArr[18], (ImageView) objArr[15], (SelectionButton) objArr[11], (ConfirmButtonView) objArr[1], (TextView) objArr[10], (TextView) objArr[9], (LinearLayout) objArr[7], (ImageView) objArr[8], (LinearLayout) objArr[6], (SelectionButton) objArr[12], (RobotoTextView) objArr[4], (RobotoTextView) objArr[3], (ViewPager) objArr[19], (TextView) objArr[5]);
        this.awW = -1;
        this.bOg.setTag(null);
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
        long j;
        synchronized (this) {
            j = this.awW;
            this.awW = 0;
        }
        if ((j & 1) != 0) {
            this.bOg.setButtonImageSrc(ViewDataBinding.getDrawableFromResource(this.bOg, R.drawable.ic_kyc_next_selector_green));
        }
    }
}
