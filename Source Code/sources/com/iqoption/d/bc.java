package com.iqoption.d;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.fragment.dialog.whatsnew.a;
import com.iqoption.view.text.FormattedTextView;

/* compiled from: BitcoinWhatsNewDialogBinding */
public abstract class bc extends ViewDataBinding {
    @NonNull
    public final TextView blj;
    @NonNull
    public final TextView blk;
    @NonNull
    public final ImageView bll;
    @NonNull
    public final FormattedTextView blm;
    @Bindable
    protected a bln;

    protected bc(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, TextView textView2, ImageView imageView, FormattedTextView formattedTextView) {
        super(dataBindingComponent, view, i);
        this.blj = textView;
        this.blk = textView2;
        this.bll = imageView;
        this.blm = formattedTextView;
    }
}
