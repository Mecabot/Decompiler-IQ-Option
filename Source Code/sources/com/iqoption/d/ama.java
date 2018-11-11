package com.iqoption.d;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.fragment.dialog.whatsnew.a;
import com.iqoption.view.RobotoTextView;

/* compiled from: WhatsNewDialogBinding */
public abstract class ama extends ViewDataBinding {
    @NonNull
    public final RobotoTextView bHT;
    @NonNull
    public final ImageView bUA;
    @NonNull
    public final View bUB;
    @NonNull
    public final TextView bUC;
    @NonNull
    public final TextView bUi;
    @NonNull
    public final LinearLayout bUy;
    @NonNull
    public final AppCompatImageView bUz;
    @NonNull
    public final ImageView bll;
    @Bindable
    protected a bln;

    public abstract void a(@Nullable a aVar);

    protected ama(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, LinearLayout linearLayout, AppCompatImageView appCompatImageView, ImageView imageView, View view2, ImageView imageView2, RobotoTextView robotoTextView, TextView textView2) {
        super(dataBindingComponent, view, i);
        this.bUi = textView;
        this.bUy = linearLayout;
        this.bUz = appCompatImageView;
        this.bUA = imageView;
        this.bUB = view2;
        this.bll = imageView2;
        this.bHT = robotoTextView;
        this.bUC = textView2;
    }
}
