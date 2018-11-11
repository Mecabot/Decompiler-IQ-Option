package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.view.text.FormattedTextView;

/* compiled from: FragmentTradingHistorySearchSettingBinding */
public abstract class sv extends ViewDataBinding {
    @NonNull
    public final FormattedTextView bEf;
    @NonNull
    public final LinearLayout bEk;
    @NonNull
    public final TextView bEl;
    @NonNull
    public final LinearLayout bEm;
    @NonNull
    public final TextView bEn;
    @NonNull
    public final LinearLayout bEo;
    @NonNull
    public final TextView bEp;
    @NonNull
    public final LinearLayout bEq;
    @NonNull
    public final TextView bEr;
    @NonNull
    public final TextView bEs;
    @NonNull
    public final View biw;

    protected sv(DataBindingComponent dataBindingComponent, View view, int i, LinearLayout linearLayout, TextView textView, LinearLayout linearLayout2, TextView textView2, View view2, LinearLayout linearLayout3, TextView textView3, LinearLayout linearLayout4, TextView textView4, TextView textView5, FormattedTextView formattedTextView) {
        super(dataBindingComponent, view, i);
        this.bEk = linearLayout;
        this.bEl = textView;
        this.bEm = linearLayout2;
        this.bEn = textView2;
        this.biw = view2;
        this.bEo = linearLayout3;
        this.bEp = textView3;
        this.bEq = linearLayout4;
        this.bEr = textView4;
        this.bEs = textView5;
        this.bEf = formattedTextView;
    }
}
