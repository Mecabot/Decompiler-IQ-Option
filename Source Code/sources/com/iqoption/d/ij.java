package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import com.iqoption.core.ui.widget.MaxSizeCardViewLayout;
import com.iqoption.view.RobotoTextView;

/* compiled from: DialogConfirmSellPositionBinding */
public abstract class ij extends ViewDataBinding {
    @NonNull
    public final MaxSizeCardViewLayout bmb;
    @NonNull
    public final RobotoTextView boc;
    @NonNull
    public final RobotoTextView brP;
    @NonNull
    public final RobotoTextView brQ;

    protected ij(DataBindingComponent dataBindingComponent, View view, int i, RobotoTextView robotoTextView, RobotoTextView robotoTextView2, MaxSizeCardViewLayout maxSizeCardViewLayout, RobotoTextView robotoTextView3) {
        super(dataBindingComponent, view, i);
        this.boc = robotoTextView;
        this.brP = robotoTextView2;
        this.bmb = maxSizeCardViewLayout;
        this.brQ = robotoTextView3;
    }
}
