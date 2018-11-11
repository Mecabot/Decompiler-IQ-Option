package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.view.text.FormattedTextView;

/* compiled from: FragmentOtnLeadingBoardUserBoardUserBinding */
public abstract class px extends ViewDataBinding {
    @NonNull
    public final FormattedTextView bAg;
    @NonNull
    public final ImageView bAh;
    @NonNull
    public final ImageView bAi;
    @NonNull
    public final ImageView bzA;
    @NonNull
    public final TextView bzN;

    protected px(DataBindingComponent dataBindingComponent, View view, int i, FormattedTextView formattedTextView, ImageView imageView, ImageView imageView2, TextView textView, ImageView imageView3) {
        super(dataBindingComponent, view, i);
        this.bAg = formattedTextView;
        this.bzA = imageView;
        this.bAh = imageView2;
        this.bzN = textView;
        this.bAi = imageView3;
    }
}
