package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import com.iqoption.view.RobotoTextView;

/* compiled from: ConfirmDialogViewBinding */
public abstract class fq extends ViewDataBinding {
    @NonNull
    public final RobotoTextView bob;
    @NonNull
    public final RobotoTextView boc;
    @NonNull
    public final RobotoTextView bod;
    @NonNull
    public final RobotoTextView boe;
    @NonNull
    public final RobotoTextView bof;
    @NonNull
    public final ImageView bog;

    protected fq(DataBindingComponent dataBindingComponent, View view, int i, RobotoTextView robotoTextView, RobotoTextView robotoTextView2, RobotoTextView robotoTextView3, RobotoTextView robotoTextView4, RobotoTextView robotoTextView5, ImageView imageView) {
        super(dataBindingComponent, view, i);
        this.bob = robotoTextView;
        this.boc = robotoTextView2;
        this.bod = robotoTextView3;
        this.boe = robotoTextView4;
        this.bof = robotoTextView5;
        this.bog = imageView;
    }
}
