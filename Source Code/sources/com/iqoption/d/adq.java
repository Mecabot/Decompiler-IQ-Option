package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.view.RobotoTextView;
import com.iqoption.view.text.FormattedTextView;

/* compiled from: PortfolioAppBarBinding */
public abstract class adq extends ViewDataBinding {
    @NonNull
    public final FrameLayout bOP;
    @NonNull
    public final ImageView bOQ;
    @NonNull
    public final FormattedTextView bOR;
    @NonNull
    public final LinearLayout bOS;
    @NonNull
    public final RobotoTextView bOT;
    @NonNull
    public final TextView bOU;

    protected adq(DataBindingComponent dataBindingComponent, View view, int i, FrameLayout frameLayout, ImageView imageView, FormattedTextView formattedTextView, LinearLayout linearLayout, RobotoTextView robotoTextView, TextView textView) {
        super(dataBindingComponent, view, i);
        this.bOP = frameLayout;
        this.bOQ = imageView;
        this.bOR = formattedTextView;
        this.bOS = linearLayout;
        this.bOT = robotoTextView;
        this.bOU = textView;
    }
}
