package com.iqoption.quiz.b;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

/* compiled from: QuizQuestionLanguageBinding */
public abstract class s extends ViewDataBinding {
    @NonNull
    public final TextView aip;

    protected s(DataBindingComponent dataBindingComponent, View view, int i, TextView textView) {
        super(dataBindingComponent, view, i);
        this.aip = textView;
    }
}
