package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.iqoption.view.RobotoTextView;
import com.iqoption.x.R;

/* compiled from: BottomSheetOvernightBinding */
public abstract class bm extends ViewDataBinding {
    @NonNull
    public final RecyclerView axw;
    @NonNull
    public final RobotoTextView blA;
    @NonNull
    public final RelativeLayout blB;
    @NonNull
    public final RobotoTextView blC;
    @NonNull
    public final View blp;
    @NonNull
    public final ImageView blw;
    @NonNull
    public final FrameLayout blx;
    @NonNull
    public final ProgressBar bly;
    @NonNull
    public final LinearLayout blz;

    protected bm(DataBindingComponent dataBindingComponent, View view, int i, ImageView imageView, RecyclerView recyclerView, View view2, FrameLayout frameLayout, ProgressBar progressBar, LinearLayout linearLayout, RobotoTextView robotoTextView, RelativeLayout relativeLayout, RobotoTextView robotoTextView2) {
        super(dataBindingComponent, view, i);
        this.blw = imageView;
        this.axw = recyclerView;
        this.blp = view2;
        this.blx = frameLayout;
        this.bly = progressBar;
        this.blz = linearLayout;
        this.blA = robotoTextView;
        this.blB = relativeLayout;
        this.blC = robotoTextView2;
    }

    @NonNull
    public static bm e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return e(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static bm e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (bm) DataBindingUtil.inflate(layoutInflater, R.layout.bottom_sheet_overnight, viewGroup, z, dataBindingComponent);
    }
}
