package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.view.RobotoTextView;
import com.iqoption.view.text.FormattedTextView;

/* compiled from: DialogReloadPracticeBinding */
public abstract class jp extends ViewDataBinding {
    @NonNull
    public final TextView agA;
    @NonNull
    public final FrameLayout bjF;
    @NonNull
    public final TextView btG;
    @NonNull
    public final ImageView btH;
    @NonNull
    public final FrameLayout btI;
    @NonNull
    public final RobotoTextView btJ;
    @NonNull
    public final ImageView btK;
    @NonNull
    public final FormattedTextView btL;
    @NonNull
    public final RobotoTextView btM;

    protected jp(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, ImageView imageView, FrameLayout frameLayout, FrameLayout frameLayout2, RobotoTextView robotoTextView, ImageView imageView2, FormattedTextView formattedTextView, TextView textView2, RobotoTextView robotoTextView2) {
        super(dataBindingComponent, view, i);
        this.btG = textView;
        this.btH = imageView;
        this.bjF = frameLayout;
        this.btI = frameLayout2;
        this.btJ = robotoTextView;
        this.btK = imageView2;
        this.btL = formattedTextView;
        this.agA = textView2;
        this.btM = robotoTextView2;
    }
}
