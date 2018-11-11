package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import com.iqoption.view.ConfirmButtonView;
import com.iqoption.view.RobotoTextView;

/* compiled from: DepositCardViewBinding */
public abstract class ga extends ViewDataBinding {
    @NonNull
    public final fu boK;
    @NonNull
    public final TableLayout boL;
    @NonNull
    public final FrameLayout boM;
    @NonNull
    public final TextView boN;
    @NonNull
    public final TextView boO;
    @NonNull
    public final View boP;
    @NonNull
    public final FrameLayout boQ;
    @NonNull
    public final RobotoTextView boR;
    @NonNull
    public final fw boS;
    @NonNull
    public final RobotoTextView boT;
    @NonNull
    public final ConfirmButtonView boU;

    protected ga(DataBindingComponent dataBindingComponent, View view, int i, fu fuVar, TableLayout tableLayout, FrameLayout frameLayout, TextView textView, TextView textView2, View view2, FrameLayout frameLayout2, RobotoTextView robotoTextView, fw fwVar, RobotoTextView robotoTextView2, ConfirmButtonView confirmButtonView) {
        super(dataBindingComponent, view, i);
        this.boK = fuVar;
        setContainedBinding(this.boK);
        this.boL = tableLayout;
        this.boM = frameLayout;
        this.boN = textView;
        this.boO = textView2;
        this.boP = view2;
        this.boQ = frameLayout2;
        this.boR = robotoTextView;
        this.boS = fwVar;
        setContainedBinding(this.boS);
        this.boT = robotoTextView2;
        this.boU = confirmButtonView;
    }
}
