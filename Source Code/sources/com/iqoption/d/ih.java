package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;
import com.iqoption.core.ui.widget.MaxSizeCardViewLayout;
import com.iqoption.view.RobotoTextView;

/* compiled from: DialogConfirmClosePendingPositionBinding */
public abstract class ih extends ViewDataBinding {
    @NonNull
    public final TextView blE;
    @NonNull
    public final MaxSizeCardViewLayout bmb;
    @NonNull
    public final TextView brN;
    @NonNull
    public final RobotoTextView brO;

    protected ih(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, TextView textView2, MaxSizeCardViewLayout maxSizeCardViewLayout, RobotoTextView robotoTextView) {
        super(dataBindingComponent, view, i);
        this.blE = textView;
        this.brN = textView2;
        this.bmb = maxSizeCardViewLayout;
        this.brO = robotoTextView;
    }
}
