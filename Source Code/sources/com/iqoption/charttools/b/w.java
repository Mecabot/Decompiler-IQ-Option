package com.iqoption.charttools.b;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: IndicatorConstructorInputStepFieldBinding */
public abstract class w extends ViewDataBinding {
    @NonNull
    public final LinearLayout avm;
    @NonNull
    public final TextView avo;
    @NonNull
    public final EditText avp;
    @NonNull
    public final ImageView axF;
    @NonNull
    public final ImageView axG;

    protected w(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, EditText editText, TextView textView) {
        super(dataBindingComponent, view, i);
        this.axF = imageView;
        this.axG = imageView2;
        this.avm = linearLayout;
        this.avp = editText;
        this.avo = textView;
    }
}
