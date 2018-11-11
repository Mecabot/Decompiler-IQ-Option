package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;

/* compiled from: FragmentTradingHistorySetAssetBinding */
public abstract class sx extends ViewDataBinding {
    @NonNull
    public final LinearLayout bEt;
    @NonNull
    public final RecyclerView bEu;
    @NonNull
    public final TextView bEv;
    @NonNull
    public final TextView bEw;
    @NonNull
    public final View biw;
    @NonNull
    public final EditText bjX;
    @NonNull
    public final LottieAnimationView bmJ;

    protected sx(DataBindingComponent dataBindingComponent, View view, int i, LinearLayout linearLayout, RecyclerView recyclerView, View view2, LottieAnimationView lottieAnimationView, TextView textView, EditText editText, TextView textView2) {
        super(dataBindingComponent, view, i);
        this.bEt = linearLayout;
        this.bEu = recyclerView;
        this.biw = view2;
        this.bmJ = lottieAnimationView;
        this.bEv = textView;
        this.bjX = editText;
        this.bEw = textView2;
    }
}
