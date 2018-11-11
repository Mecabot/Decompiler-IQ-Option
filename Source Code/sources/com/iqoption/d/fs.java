package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import com.iqoption.view.NumberAnimateRobotoTextView;
import com.iqoption.view.RobotoTextView;
import com.iqoption.view.text.FormattedTextView;

/* compiled from: CryptoConfirmDialogViewBinding */
public abstract class fs extends ViewDataBinding {
    @NonNull
    public final NumberAnimateRobotoTextView blN;
    @NonNull
    public final ImageView blO;
    @NonNull
    public final FormattedTextView blP;
    @NonNull
    public final RobotoTextView blS;
    @NonNull
    public final NumberAnimateRobotoTextView boh;

    protected fs(DataBindingComponent dataBindingComponent, View view, int i, NumberAnimateRobotoTextView numberAnimateRobotoTextView, ImageView imageView, FormattedTextView formattedTextView, RobotoTextView robotoTextView, NumberAnimateRobotoTextView numberAnimateRobotoTextView2) {
        super(dataBindingComponent, view, i);
        this.blN = numberAnimateRobotoTextView;
        this.blO = imageView;
        this.blP = formattedTextView;
        this.blS = robotoTextView;
        this.boh = numberAnimateRobotoTextView2;
    }
}
