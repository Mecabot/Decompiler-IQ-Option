package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.view.text.FormattedTextView;

/* compiled from: ChatRoomSupportToolbarBinding */
public abstract class ej extends ViewDataBinding {
    @NonNull
    public final TextView agA;
    @Nullable
    public final ImageView bmZ;
    @NonNull
    public final FormattedTextView bna;
    @NonNull
    public final TextView bnb;

    protected ej(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, FormattedTextView formattedTextView, TextView textView, TextView textView2) {
        super(dataBindingComponent, view, i);
        this.bmZ = imageView;
        this.bna = formattedTextView;
        this.agA = textView;
        this.bnb = textView2;
    }
}
