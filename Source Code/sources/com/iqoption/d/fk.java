package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.view.RobotoTextView;
import com.iqoption.view.text.FormattedTextView;

/* compiled from: ClosePositionsItemBinding */
public abstract class fk extends ViewDataBinding {
    @NonNull
    public final RobotoTextView bnC;
    @NonNull
    public final TextView bnD;
    @NonNull
    public final TextView bnE;
    @NonNull
    public final TextView bnF;
    @NonNull
    public final LinearLayout bnG;
    @NonNull
    public final agg bnH;
    @NonNull
    public final FormattedTextView bnI;
    @NonNull
    public final RobotoTextView bnJ;
    @NonNull
    public final ImageView bnK;

    protected fk(DataBindingComponent dataBindingComponent, View view, int i, RobotoTextView robotoTextView, TextView textView, TextView textView2, TextView textView3, LinearLayout linearLayout, agg agg, FormattedTextView formattedTextView, RobotoTextView robotoTextView2, ImageView imageView) {
        super(dataBindingComponent, view, i);
        this.bnC = robotoTextView;
        this.bnD = textView;
        this.bnE = textView2;
        this.bnF = textView3;
        this.bnG = linearLayout;
        this.bnH = agg;
        setContainedBinding(this.bnH);
        this.bnI = formattedTextView;
        this.bnJ = robotoTextView2;
        this.bnK = imageView;
    }
}
