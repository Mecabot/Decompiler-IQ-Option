package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: FragmentVideoEducationVideosBinding */
public abstract class tr extends ViewDataBinding {
    @NonNull
    public final TextView agA;
    @NonNull
    public final ImageView awN;
    @NonNull
    public final RecyclerView bFI;
    @NonNull
    public final TextView bFJ;
    @NonNull
    public final ImageView bFK;
    @NonNull
    public final LinearLayout bFL;
    @NonNull
    public final RecyclerView bFM;
    @NonNull
    public final FrameLayout bFN;
    @NonNull
    public final EditText bmL;
    @NonNull
    public final FrameLayout brj;

    protected tr(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, TextView textView, ImageView imageView2, FrameLayout frameLayout, EditText editText, LinearLayout linearLayout, RecyclerView recyclerView, TextView textView2, FrameLayout frameLayout2, RecyclerView recyclerView2) {
        super(dataBindingComponent, view, i);
        this.awN = imageView;
        this.bFJ = textView;
        this.bFK = imageView2;
        this.brj = frameLayout;
        this.bmL = editText;
        this.bFL = linearLayout;
        this.bFM = recyclerView;
        this.agA = textView2;
        this.bFN = frameLayout2;
        this.bFI = recyclerView2;
    }
}
