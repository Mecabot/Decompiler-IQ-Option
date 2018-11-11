package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import com.iqoption.view.CryptoAssetPager;

/* compiled from: RightPanelDelegateCryptoBinding */
public abstract class ahu extends ViewDataBinding {
    @NonNull
    public final CryptoAssetPager bRO;
    @NonNull
    public final ahw bRP;
    @NonNull
    public final ahy bRQ;
    @NonNull
    public final aia bRR;
    @NonNull
    public final aic bRS;
    @NonNull
    public final aie bRT;

    protected ahu(DataBindingComponent dataBindingComponent, View view, int i, CryptoAssetPager cryptoAssetPager, ahw ahw, ahy ahy, aia aia, aic aic, aie aie) {
        super(dataBindingComponent, view, i);
        this.bRO = cryptoAssetPager;
        this.bRP = ahw;
        setContainedBinding(this.bRP);
        this.bRQ = ahy;
        setContainedBinding(this.bRQ);
        this.bRR = aia;
        setContainedBinding(this.bRR);
        this.bRS = aic;
        setContainedBinding(this.bRS);
        this.bRT = aie;
        setContainedBinding(this.bRT);
    }
}
