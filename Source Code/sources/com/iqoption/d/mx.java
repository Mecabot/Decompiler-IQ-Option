package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.view.ConfirmButtonView;
import com.iqoption.view.text.FormattedTextView;

/* compiled from: FragmentKycFinishBinding */
public abstract class mx extends ViewDataBinding {
    @NonNull
    public final ConfirmButtonView bxH;
    @NonNull
    public final TextView byk;
    @NonNull
    public final ImageView byl;
    @NonNull
    public final FormattedTextView bym;

    protected mx(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, ImageView imageView, FormattedTextView formattedTextView, ConfirmButtonView confirmButtonView) {
        super(dataBindingComponent, view, i);
        this.byk = textView;
        this.byl = imageView;
        this.bym = formattedTextView;
        this.bxH = confirmButtonView;
    }
}
