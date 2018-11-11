package com.iqoption.quiz.b;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: EmailLayoutBinding */
public abstract class g extends ViewDataBinding {
    @NonNull
    public final TextView agA;
    @NonNull
    public final TextView bQB;
    @NonNull
    public final ImageView dkG;
    @NonNull
    public final EditText dkH;
    @NonNull
    public final EditText dkI;

    protected g(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, EditText editText, TextView textView, EditText editText2, TextView textView2) {
        super(dataBindingComponent, view, i);
        this.dkG = imageView;
        this.dkH = editText;
        this.bQB = textView;
        this.dkI = editText2;
        this.agA = textView2;
    }
}
