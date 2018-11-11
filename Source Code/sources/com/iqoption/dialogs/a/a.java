package com.iqoption.dialogs.a;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.core.ui.widget.MaxSizeConstraintLayout;
import com.iqoption.core.ui.widget.StarBar;

/* compiled from: DialogRateUsBinding */
public abstract class a extends ViewDataBinding {
    @NonNull
    public final TextView aip;
    @NonNull
    public final FrameLayout awS;
    @NonNull
    public final StarBar bmT;
    @NonNull
    public final ImageView brZ;
    @NonNull
    public final MaxSizeConstraintLayout btF;
    @NonNull
    public final TextView ckQ;

    protected a(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, MaxSizeConstraintLayout maxSizeConstraintLayout, ImageView imageView, FrameLayout frameLayout, StarBar starBar, TextView textView2) {
        super(dataBindingComponent, view, i);
        this.ckQ = textView;
        this.btF = maxSizeConstraintLayout;
        this.brZ = imageView;
        this.awS = frameLayout;
        this.bmT = starBar;
        this.aip = textView2;
    }
}
