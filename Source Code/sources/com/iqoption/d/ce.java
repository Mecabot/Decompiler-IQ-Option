package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.iqoption.core.ui.widget.MaxSizeCardViewLayout;

/* compiled from: ChatDialogMessageOptionsBinding */
public abstract class ce extends ViewDataBinding {
    @NonNull
    public final FrameLayout awS;
    @NonNull
    public final MaxSizeCardViewLayout bmb;
    @NonNull
    public final LinearLayout bmi;

    protected ce(DataBindingComponent dataBindingComponent, View view, int i, MaxSizeCardViewLayout maxSizeCardViewLayout, LinearLayout linearLayout, FrameLayout frameLayout) {
        super(dataBindingComponent, view, i);
        this.bmb = maxSizeCardViewLayout;
        this.bmi = linearLayout;
        this.awS = frameLayout;
    }
}
