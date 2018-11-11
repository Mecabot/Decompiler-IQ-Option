package com.iqoption.quiz.b;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;
import com.iqoption.quiz.widget.CountDownProgressBar;

/* compiled from: QuestionDialogLayoutBinding */
public abstract class m extends ViewDataBinding {
    @NonNull
    public final TextView agA;
    @NonNull
    public final TextView aip;
    @NonNull
    public final TextView dkP;
    @NonNull
    public final CountDownProgressBar dkQ;

    protected m(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, CountDownProgressBar countDownProgressBar, TextView textView2, TextView textView3) {
        super(dataBindingComponent, view, i);
        this.dkP = textView;
        this.dkQ = countDownProgressBar;
        this.aip = textView2;
        this.agA = textView3;
    }
}
