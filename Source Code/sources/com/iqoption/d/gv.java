package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.deposit.old.PayMethodSelector;
import com.iqoption.view.ConfirmButtonView;

/* compiled from: DepositPageContentNoBonusOldBinding */
public abstract class gv extends ViewDataBinding {
    @NonNull
    public final ConfirmButtonView bpI;
    @NonNull
    public final TextView bpZ;
    @NonNull
    public final hl bqe;
    @NonNull
    public final TextView bql;
    @NonNull
    public final RecyclerView bqm;
    @NonNull
    public final TextView bqn;
    @NonNull
    public final View bqo;
    @NonNull
    public final gi bqp;
    @NonNull
    public final gk bqq;
    @NonNull
    public final LinearLayout bqr;
    @NonNull
    public final LinearLayout bqs;
    @NonNull
    public final PayMethodSelector bqt;

    protected gv(DataBindingComponent dataBindingComponent, View view, int i, gi giVar, TextView textView, gk gkVar, ConfirmButtonView confirmButtonView, LinearLayout linearLayout, RecyclerView recyclerView, LinearLayout linearLayout2, TextView textView2, PayMethodSelector payMethodSelector, TextView textView3, hl hlVar, View view2) {
        super(dataBindingComponent, view, i);
        this.bqp = giVar;
        setContainedBinding(this.bqp);
        this.bql = textView;
        this.bqq = gkVar;
        setContainedBinding(this.bqq);
        this.bpI = confirmButtonView;
        this.bqr = linearLayout;
        this.bqm = recyclerView;
        this.bqs = linearLayout2;
        this.bqn = textView2;
        this.bqt = payMethodSelector;
        this.bpZ = textView3;
        this.bqe = hlVar;
        setContainedBinding(this.bqe);
        this.bqo = view2;
    }
}
