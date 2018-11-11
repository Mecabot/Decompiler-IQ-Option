package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.view.text.FormattedTextView;

/* compiled from: FragmentTradingHistorySearchResultBinding */
public abstract class st extends ViewDataBinding {
    @NonNull
    public final FormattedTextView bEf;
    @NonNull
    public final LinearLayout bEg;
    @NonNull
    public final RecyclerView bEh;
    @NonNull
    public final TextView bEi;
    @NonNull
    public final LinearLayout bEj;
    @NonNull
    public final View biw;
    @NonNull
    public final ContentLoadingProgressBar bnO;

    protected st(DataBindingComponent dataBindingComponent, View view, int i, View view2, ContentLoadingProgressBar contentLoadingProgressBar, LinearLayout linearLayout, RecyclerView recyclerView, TextView textView, FormattedTextView formattedTextView, LinearLayout linearLayout2) {
        super(dataBindingComponent, view, i);
        this.biw = view2;
        this.bnO = contentLoadingProgressBar;
        this.bEg = linearLayout;
        this.bEh = recyclerView;
        this.bEi = textView;
        this.bEf = formattedTextView;
        this.bEj = linearLayout2;
    }
}
