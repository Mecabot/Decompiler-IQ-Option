package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatCheckBox;
import android.view.View;
import android.widget.LinearLayout;
import com.iqoption.view.text.FormattedTextView;

/* compiled from: FragmentKycCheckBoxBinding */
public abstract class md extends ViewDataBinding {
    @NonNull
    public final FormattedTextView bxJ;
    @NonNull
    public final LinearLayout bxK;
    @NonNull
    public final AppCompatCheckBox bxL;

    protected md(DataBindingComponent dataBindingComponent, View view, int i, FormattedTextView formattedTextView, LinearLayout linearLayout, AppCompatCheckBox appCompatCheckBox) {
        super(dataBindingComponent, view, i);
        this.bxJ = formattedTextView;
        this.bxK = linearLayout;
        this.bxL = appCompatCheckBox;
    }
}
