package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import com.iqoption.view.RobotoTextView;
import com.iqoption.view.text.FormattedTextView;

/* compiled from: PortfolioFilterItemBinding */
public abstract class aex extends ViewDataBinding {
    @NonNull
    public final FormattedTextView bEf;
    @NonNull
    public final RobotoTextView bHQ;
    @NonNull
    public final ImageView bmu;

    protected aex(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, FormattedTextView formattedTextView, RobotoTextView robotoTextView) {
        super(dataBindingComponent, view, i);
        this.bmu = imageView;
        this.bEf = formattedTextView;
        this.bHQ = robotoTextView;
    }
}
