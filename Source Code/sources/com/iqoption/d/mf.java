package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatCheckBox;
import android.view.View;
import android.widget.TextView;
import com.iqoption.kyc.PositionPicker;

/* compiled from: FragmentKycCountryBinding */
public abstract class mf extends ViewDataBinding {
    @NonNull
    public final wp bxE;
    @NonNull
    public final AppCompatCheckBox bxM;
    @NonNull
    public final PositionPicker bxN;
    @NonNull
    public final TextView bxO;
    @NonNull
    public final wr bxz;

    protected mf(DataBindingComponent dataBindingComponent, View view, int i, AppCompatCheckBox appCompatCheckBox, PositionPicker positionPicker, wr wrVar, wp wpVar, TextView textView) {
        super(dataBindingComponent, view, i);
        this.bxM = appCompatCheckBox;
        this.bxN = positionPicker;
        this.bxz = wrVar;
        setContainedBinding(this.bxz);
        this.bxE = wpVar;
        setContainedBinding(this.bxE);
        this.bxO = textView;
    }
}
