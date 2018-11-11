package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.iqoption.core.ui.widget.MaxSizeCardViewLayout;

/* compiled from: ChatDialogCantSendReasonBinding */
public abstract class ca extends ViewDataBinding {
    @NonNull
    public final TextView aip;
    @NonNull
    public final FrameLayout awS;
    @NonNull
    public final TextView bma;
    @NonNull
    public final MaxSizeCardViewLayout bmb;

    protected ca(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, MaxSizeCardViewLayout maxSizeCardViewLayout, FrameLayout frameLayout, TextView textView2) {
        super(dataBindingComponent, view, i);
        this.bma = textView;
        this.bmb = maxSizeCardViewLayout;
        this.awS = frameLayout;
        this.aip = textView2;
    }
}
