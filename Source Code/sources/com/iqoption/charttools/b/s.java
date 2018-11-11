package com.iqoption.charttools.b;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import com.iqoption.charttools.constructor.widget.WidthPicker;

/* compiled from: IndicatorConstructorInputLineWidthBinding */
public abstract class s extends ViewDataBinding {
    @NonNull
    public final WidthPicker axD;

    protected s(DataBindingComponent dataBindingComponent, View view, int i, WidthPicker widthPicker) {
        super(dataBindingComponent, view, i);
        this.axD = widthPicker;
    }
}
