package com.iqoption.d;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.fragment.dialog.nps.b;

/* compiled from: NpsFeedbackFragmentBinding */
public abstract class abq extends ViewDataBinding {
    @NonNull
    public final ConstraintLayout axL;
    @NonNull
    public final TextView bBH;
    @NonNull
    public final ImageView bBI;
    @NonNull
    public final FrameLayout bMr;
    @NonNull
    public final ConstraintLayout bMs;
    @NonNull
    public final EditText bMv;
    @NonNull
    public final FrameLayout bMw;
    @NonNull
    public final TextView bMx;
    @NonNull
    public final TextView bMy;
    @Bindable
    protected b bMz;
    @NonNull
    public final FrameLayout brn;
    @NonNull
    public final TextView bxT;

    public abstract void a(@Nullable b bVar);

    protected abq(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, FrameLayout frameLayout, ConstraintLayout constraintLayout, EditText editText, TextView textView, ConstraintLayout constraintLayout2, FrameLayout frameLayout2, TextView textView2, TextView textView3, TextView textView4, FrameLayout frameLayout3) {
        super(dataBindingComponent, view, i);
        this.bBI = imageView;
        this.bMr = frameLayout;
        this.axL = constraintLayout;
        this.bMv = editText;
        this.bxT = textView;
        this.bMs = constraintLayout2;
        this.bMw = frameLayout2;
        this.bMx = textView2;
        this.bBH = textView3;
        this.bMy = textView4;
        this.brn = frameLayout3;
    }
}
