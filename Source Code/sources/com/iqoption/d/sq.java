package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import com.iqoption.fragment.cc;
import com.iqoption.view.SettingItemView;
import com.iqoption.x.R;

/* compiled from: FragmentTraderoomSettingsBindingImpl */
public class sq extends sp {
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

    static {
        awV.put(R.id.backButton, 1);
        awV.put(R.id.contentScroll, 2);
        awV.put(R.id.contentLayout, 3);
        awV.put(R.id.expPanelSetting, 4);
        awV.put(R.id.tradersMoodSetting, 5);
        awV.put(R.id.liveDealsSetting, 6);
        awV.put(R.id.shareMyLiveDealsSetting, 7);
        awV.put(R.id.soundSetting, 8);
        awV.put(R.id.investmentAmountSetting, 9);
        awV.put(R.id.hiLowChartSetting, 10);
        awV.put(R.id.purchaseGroup, 11);
        awV.put(R.id.buyInClickClickSetting, 12);
        awV.put(R.id.sellWithConfirmationForexClickSetting, 13);
        awV.put(R.id.marginAddOnSetting, 14);
        awV.put(R.id.trailingStopSetting, 15);
        awV.put(R.id.inAppNotifications, 16);
        awV.put(R.id.sharpJumpSetting, 17);
        awV.put(R.id.latestMovementsSetting, 18);
        awV.put(R.id.topAssetSetting, 19);
        awV.put(R.id.pushSettings, 20);
        awV.put(R.id.progressLoadPushSetting, 21);
        awV.put(R.id.pushSettingsContainer, 22);
        awV.put(R.id.openLicenses, 23);
    }

    public sq(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 24, awU, awV));
    }

    private sq(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[1], (SettingItemView) objArr[12], (LinearLayout) objArr[3], (ScrollView) objArr[2], (SettingItemView) objArr[4], (SettingItemView) objArr[10], (LinearLayout) objArr[16], (SettingItemView) objArr[9], (SettingItemView) objArr[18], (SettingItemView) objArr[6], (SettingItemView) objArr[14], (LinearLayout) objArr[23], (ProgressBar) objArr[21], (LinearLayout) objArr[11], (LinearLayout) objArr[20], (LinearLayout) objArr[22], (SettingItemView) objArr[13], (SettingItemView) objArr[7], (SettingItemView) objArr[17], (SettingItemView) objArr[8], (SettingItemView) objArr[19], (SettingItemView) objArr[5], (SettingItemView) objArr[15]);
        this.awW = -1;
        this.axx = (LinearLayout) objArr[0];
        this.axx.setTag(null);
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
        if (2 != i) {
            return false;
        }
        a((cc) obj);
        return true;
    }

    public void a(@Nullable cc ccVar) {
        this.bDN = ccVar;
    }

    protected void executeBindings() {
        synchronized (this) {
            long j = this.awW;
            this.awW = 0;
        }
    }
}
