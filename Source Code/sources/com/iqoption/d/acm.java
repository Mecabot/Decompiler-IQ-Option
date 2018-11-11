package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

/* compiled from: OperationHistoryMultiSelectionBinding */
public abstract class acm extends ViewDataBinding {
    @NonNull
    public final TextView agA;
    @NonNull
    public final CheckBox bNM;

    protected acm(DataBindingComponent dataBindingComponent, View view, int i, CheckBox checkBox, TextView textView) {
        super(dataBindingComponent, view, i);
        this.bNM = checkBox;
        this.agA = textView;
    }
}
