package com.iqoption.charttools.b;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.charttools.constructor.widget.ColorPicker;

/* compiled from: IndicatorConstructorInputColorBinding */
public abstract class o extends ViewDataBinding {
    @NonNull
    public final LinearLayout avm;
    @NonNull
    public final TextView avo;
    @NonNull
    public final ImageView axB;
    @NonNull
    public final ColorPicker axC;

    protected o(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, LinearLayout linearLayout, TextView textView, ColorPicker colorPicker) {
        super(dataBindingComponent, view, i);
        this.axB = imageView;
        this.avm = linearLayout;
        this.avo = textView;
        this.axC = colorPicker;
    }
}
