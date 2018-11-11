package com.iqoption.quiz.b;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

/* compiled from: QuizRulesLayoutBinding */
public abstract class u extends ViewDataBinding {
    @NonNull
    public final TextView agA;
    @NonNull
    public final TextView dkS;
    @NonNull
    public final TextView dkT;
    @NonNull
    public final TextView dkU;
    @NonNull
    public final TextView dkV;

    protected u(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        super(dataBindingComponent, view, i);
        this.dkS = textView;
        this.dkT = textView2;
        this.dkU = textView3;
        this.dkV = textView4;
        this.agA = textView5;
    }
}
