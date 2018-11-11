package com.iqoption.d;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.fragment.az;
import com.iqoption.view.RobotoTextView;

/* compiled from: ExpirationFragmentBinding */
public abstract class kp extends ViewDataBinding {
    @NonNull
    public final FrameLayout bjF;
    @NonNull
    public final FrameLayout blV;
    @NonNull
    public final TextView bvA;
    @NonNull
    public final RobotoTextView bvB;
    @Bindable
    protected az bvC;
    @NonNull
    public final LinearLayout bvu;
    @NonNull
    public final RecyclerView bvv;
    @NonNull
    public final TextView bvw;
    @NonNull
    public final RobotoTextView bvx;
    @NonNull
    public final LinearLayout bvy;
    @NonNull
    public final RecyclerView bvz;

    public abstract void a(@Nullable az azVar);

    protected kp(DataBindingComponent dataBindingComponent, View view, int i, LinearLayout linearLayout, RecyclerView recyclerView, TextView textView, RobotoTextView robotoTextView, FrameLayout frameLayout, FrameLayout frameLayout2, LinearLayout linearLayout2, RecyclerView recyclerView2, TextView textView2, RobotoTextView robotoTextView2) {
        super(dataBindingComponent, view, i);
        this.bvu = linearLayout;
        this.bvv = recyclerView;
        this.bvw = textView;
        this.bvx = robotoTextView;
        this.blV = frameLayout;
        this.bjF = frameLayout2;
        this.bvy = linearLayout2;
        this.bvz = recyclerView2;
        this.bvA = textView2;
        this.bvB = robotoTextView2;
    }
}
