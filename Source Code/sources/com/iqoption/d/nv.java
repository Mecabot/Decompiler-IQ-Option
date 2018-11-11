package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.iqoption.view.text.FormattedTextView;

/* compiled from: FragmentKycRadioButtonBinding */
public abstract class nv extends ViewDataBinding {
    @NonNull
    public final FormattedTextView bxJ;
    @NonNull
    public final LinearLayout bxK;
    @NonNull
    public final ImageView byE;

    protected nv(DataBindingComponent dataBindingComponent, View view, int i, FormattedTextView formattedTextView, LinearLayout linearLayout, ImageView imageView) {
        super(dataBindingComponent, view, i);
        this.bxJ = formattedTextView;
        this.bxK = linearLayout;
        this.byE = imageView;
    }
}
