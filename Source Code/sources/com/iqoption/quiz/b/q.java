package com.iqoption.quiz.b;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: QuizChatItemBinding */
public abstract class q extends ViewDataBinding {
    @NonNull
    public final TextView aip;
    @NonNull
    public final LinearLayout bUx;
    @NonNull
    public final ImageView bmj;

    protected q(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, LinearLayout linearLayout, TextView textView) {
        super(dataBindingComponent, view, i);
        this.bmj = imageView;
        this.bUx = linearLayout;
        this.aip = textView;
    }
}
