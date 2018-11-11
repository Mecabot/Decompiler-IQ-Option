package com.iqoption.d;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.fragment.dialog.whatsnew.a;
import com.iqoption.view.text.FormattedTextView;

/* compiled from: WhatsNewDialogSpotBinding */
public abstract class ame extends ViewDataBinding {
    @NonNull
    public final ImageView aEt;
    @NonNull
    public final TextView agA;
    @NonNull
    public final TextView aip;
    @NonNull
    public final View bUH;
    @NonNull
    public final TextView bUI;
    @NonNull
    public final ImageView bll;
    @NonNull
    public final FormattedTextView blm;
    @Bindable
    protected a bln;

    public abstract void a(@Nullable a aVar);

    protected ame(DataBindingComponent dataBindingComponent, View view, int i, View view2, ImageView imageView, TextView textView, TextView textView2, TextView textView3, ImageView imageView2, FormattedTextView formattedTextView) {
        super(dataBindingComponent, view, i);
        this.bUH = view2;
        this.aEt = imageView;
        this.aip = textView;
        this.agA = textView2;
        this.bUI = textView3;
        this.bll = imageView2;
        this.blm = formattedTextView;
    }
}
