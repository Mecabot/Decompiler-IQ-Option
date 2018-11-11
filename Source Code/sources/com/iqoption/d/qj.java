package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.iqoption.view.TextureVideoView;

/* compiled from: FragmentPromoVideoBinding */
public abstract class qj extends ViewDataBinding {
    @NonNull
    public final View bAJ;
    @NonNull
    public final ProgressBar bAK;
    @NonNull
    public final FrameLayout bAL;
    @NonNull
    public final FrameLayout bAM;
    @NonNull
    public final TextureVideoView bAN;

    protected qj(DataBindingComponent dataBindingComponent, View view, int i, View view2, ProgressBar progressBar, FrameLayout frameLayout, FrameLayout frameLayout2, TextureVideoView textureVideoView) {
        super(dataBindingComponent, view, i);
        this.bAJ = view2;
        this.bAK = progressBar;
        this.bAL = frameLayout;
        this.bAM = frameLayout2;
        this.bAN = textureVideoView;
    }
}
