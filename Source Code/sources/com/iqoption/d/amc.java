package com.iqoption.d;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.fragment.dialog.whatsnew.depositpage.c;

/* compiled from: WhatsNewDialogExperimentalDepositPageBinding */
public abstract class amc extends ViewDataBinding {
    @NonNull
    public final RecyclerView axw;
    @NonNull
    public final TextView bUC;
    @NonNull
    public final TextView bUE;
    @Bindable
    protected c bUF;
    @NonNull
    public final ImageView bll;

    public abstract void a(@Nullable c cVar);

    protected amc(DataBindingComponent dataBindingComponent, View view, int i, TextView textView, RecyclerView recyclerView, ImageView imageView, TextView textView2) {
        super(dataBindingComponent, view, i);
        this.bUE = textView;
        this.axw = recyclerView;
        this.bll = imageView;
        this.bUC = textView2;
    }
}
