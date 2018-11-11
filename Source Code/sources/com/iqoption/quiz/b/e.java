package com.iqoption.quiz.b;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

/* compiled from: ChatLayoutBinding */
public abstract class e extends ViewDataBinding {
    @NonNull
    public final ImageView bmG;
    @NonNull
    public final ImageView dkB;
    @NonNull
    public final ImageView dkC;
    @NonNull
    public final EditText dkD;
    @NonNull
    public final RecyclerView dkE;
    @NonNull
    public final LinearLayout dkF;

    protected e(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, ImageView imageView2, ImageView imageView3, EditText editText, RecyclerView recyclerView, LinearLayout linearLayout) {
        super(dataBindingComponent, view, i);
        this.dkB = imageView;
        this.bmG = imageView2;
        this.dkC = imageView3;
        this.dkD = editText;
        this.dkE = recyclerView;
        this.dkF = linearLayout;
    }
}
