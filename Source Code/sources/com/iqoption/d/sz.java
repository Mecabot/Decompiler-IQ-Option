package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.iqoption.view.materialcalendar.MaterialCalendarView;

/* compiled from: FragmentTradingHistorySetDateBinding */
public abstract class sz extends ViewDataBinding {
    @NonNull
    public final TextView agA;
    @NonNull
    public final RadioGroup bEA;
    @NonNull
    public final RadioButton bEB;
    @NonNull
    public final RadioButton bEC;
    @NonNull
    public final RadioButton bED;
    @NonNull
    public final MaterialCalendarView bEx;
    @NonNull
    public final RadioButton bEy;
    @NonNull
    public final RadioButton bEz;
    @NonNull
    public final View biw;

    protected sz(DataBindingComponent dataBindingComponent, View view, int i, View view2, MaterialCalendarView materialCalendarView, RadioButton radioButton, RadioButton radioButton2, RadioGroup radioGroup, RadioButton radioButton3, TextView textView, RadioButton radioButton4, RadioButton radioButton5) {
        super(dataBindingComponent, view, i);
        this.biw = view2;
        this.bEx = materialCalendarView;
        this.bEy = radioButton;
        this.bEz = radioButton2;
        this.bEA = radioGroup;
        this.bEB = radioButton3;
        this.agA = textView;
        this.bEC = radioButton4;
        this.bED = radioButton5;
    }
}
