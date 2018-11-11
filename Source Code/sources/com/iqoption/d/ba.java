package com.iqoption.d;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.iqoption.fragment.base.i;
import com.iqoption.view.blurtextureview.BlurTextureView;

/* compiled from: BgChooserDialogBinding */
public abstract class ba extends ViewDataBinding {
    @NonNull
    public final FrameLayout blc;
    @NonNull
    public final BlurTextureView blg;
    @Bindable
    protected i blh;
    @NonNull
    public final LinearLayout bli;

    protected ba(DataBindingComponent dataBindingComponent, View view, int i, BlurTextureView blurTextureView, LinearLayout linearLayout, FrameLayout frameLayout) {
        super(dataBindingComponent, view, i);
        this.blg = blurTextureView;
        this.bli = linearLayout;
        this.blc = frameLayout;
    }
}
