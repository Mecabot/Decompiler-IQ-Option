package com.iqoption.d;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.FrameLayout;
import com.iqoption.fragment.base.i;
import com.iqoption.view.blurtextureview.BlurTextureView;

/* compiled from: BaseSmartFragmentBinding */
public abstract class ax extends ViewDataBinding {
    @NonNull
    public final FrameLayout blc;
    @NonNull
    public final FrameLayout ble;
    @NonNull
    public final BlurTextureView blg;
    @Bindable
    protected i blh;

    public abstract void a(@Nullable i iVar);

    protected ax(DataBindingComponent dataBindingComponent, View view, int i, BlurTextureView blurTextureView, FrameLayout frameLayout, FrameLayout frameLayout2) {
        super(dataBindingComponent, view, i);
        this.blg = blurTextureView;
        this.ble = frameLayout;
        this.blc = frameLayout2;
    }
}
