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

/* compiled from: FxWhatsNewDialogBinding */
public abstract class vh extends ViewDataBinding {
    @NonNull
    public final TextView blk;
    @NonNull
    public final ImageView bll;
    @NonNull
    public final FormattedTextView blm;
    @Bindable
    protected a bln;

    public abstract void a(@Nullable a aVar);

    protected vh(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, ImageView imageView, FormattedTextView formattedTextView) {
        super(dataBindingComponent, view, i);
        this.blk = textView;
        this.bll = imageView;
        this.blm = formattedTextView;
    }
}
