package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

/* compiled from: ChatRoomPublicToolbarBinding */
public abstract class ee extends ViewDataBinding {
    @NonNull
    public final TextView agA;
    @NonNull
    public final TextView bmE;

    protected ee(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, TextView textView2) {
        super(dataBindingComponent, view, i);
        this.bmE = textView;
        this.agA = textView2;
    }
}
