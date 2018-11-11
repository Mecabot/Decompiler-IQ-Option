package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;

/* compiled from: ChatFragmentSearchRoomBinding */
public abstract class de extends ViewDataBinding {
    @NonNull
    public final TextView agA;
    @NonNull
    public final ImageView awN;
    @NonNull
    public final LottieAnimationView bmJ;
    @NonNull
    public final ConstraintLayout bmK;
    @NonNull
    public final EditText bmL;

    protected de(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, LottieAnimationView lottieAnimationView, ConstraintLayout constraintLayout, EditText editText, TextView textView) {
        super(dataBindingComponent, view, i);
        this.awN = imageView;
        this.bmJ = lottieAnimationView;
        this.bmK = constraintLayout;
        this.bmL = editText;
        this.agA = textView;
    }
}
