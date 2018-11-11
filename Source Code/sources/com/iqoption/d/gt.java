package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatSpinner2;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import com.iqoption.fragment.cashbox.AmountFrameViewSwitcher;
import com.iqoption.view.ConfirmButtonView;
import com.iqoption.x.R;

/* compiled from: DepositPageContentNoBonusBinding */
public abstract class gt extends ViewDataBinding {
    @NonNull
    public final ConfirmButtonView bpI;
    @NonNull
    public final RelativeLayout bpK;
    @NonNull
    public final ImageView bpN;
    @NonNull
    public final View bpP;
    @NonNull
    public final View bpQ;
    @NonNull
    public final View bpR;
    @NonNull
    public final View bpS;
    @NonNull
    public final View bpT;
    @NonNull
    public final View bpU;
    @NonNull
    public final ImageView bpV;
    @NonNull
    public final ImageView bpW;
    @NonNull
    public final AppCompatSpinner2 bpX;
    @NonNull
    public final FrameLayout bpY;
    @NonNull
    public final TextView bpZ;
    @NonNull
    public final RelativeLayout bpa;
    @NonNull
    public final Switch bpb;
    @NonNull
    public final TextView bpc;
    @NonNull
    public final ImageView bpd;
    @NonNull
    public final ImageView bpe;
    @NonNull
    public final ImageView bpf;
    @NonNull
    public final AmountFrameViewSwitcher bpg;
    @NonNull
    public final TextView bph;
    @NonNull
    public final ImageView bpi;
    @NonNull
    public final AppCompatSpinner2 bpj;
    @NonNull
    public final TextView bpk;
    @NonNull
    public final EditText bpl;
    @NonNull
    public final FrameLayout bpm;
    @NonNull
    public final AppCompatImageView bpn;
    @NonNull
    public final ConfirmButtonView bpo;
    @NonNull
    public final ImageView bqb;
    @NonNull
    public final ImageView bqd;
    @NonNull
    public final hl bqe;
    @NonNull
    public final ImageView bqh;
    @NonNull
    public final TextView bqk;
    @NonNull
    public final TextView bql;
    @NonNull
    public final RecyclerView bqm;
    @NonNull
    public final TextView bqn;
    @NonNull
    public final View bqo;

    protected gt(DataBindingComponent dataBindingComponent, View view, int i, AmountFrameViewSwitcher amountFrameViewSwitcher, TextView textView, TextView textView2, ImageView imageView, AppCompatSpinner2 appCompatSpinner2, TextView textView3, EditText editText, FrameLayout frameLayout, TextView textView4, AppCompatImageView appCompatImageView, ConfirmButtonView confirmButtonView, ConfirmButtonView confirmButtonView2, RelativeLayout relativeLayout, RecyclerView recyclerView, RelativeLayout relativeLayout2, Switch switchR, TextView textView5, ImageView imageView2, View view2, View view3, View view4, View view5, View view6, View view7, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, TextView textView6, AppCompatSpinner2 appCompatSpinner22, FrameLayout frameLayout2, TextView textView7, ImageView imageView8, ImageView imageView9, hl hlVar, View view8, ImageView imageView10) {
        super(dataBindingComponent, view, i);
        this.bpg = amountFrameViewSwitcher;
        this.bph = textView;
        this.bqk = textView2;
        this.bpi = imageView;
        this.bpj = appCompatSpinner2;
        this.bpk = textView3;
        this.bpl = editText;
        this.bpm = frameLayout;
        this.bql = textView4;
        this.bpn = appCompatImageView;
        this.bpI = confirmButtonView;
        this.bpo = confirmButtonView2;
        this.bpK = relativeLayout;
        this.bqm = recyclerView;
        this.bpa = relativeLayout2;
        this.bpb = switchR;
        this.bpc = textView5;
        this.bpN = imageView2;
        this.bpP = view2;
        this.bpQ = view3;
        this.bpR = view4;
        this.bpS = view5;
        this.bpT = view6;
        this.bpU = view7;
        this.bpd = imageView3;
        this.bpe = imageView4;
        this.bpf = imageView5;
        this.bpV = imageView6;
        this.bpW = imageView7;
        this.bqn = textView6;
        this.bpX = appCompatSpinner22;
        this.bpY = frameLayout2;
        this.bpZ = textView7;
        this.bqb = imageView8;
        this.bqd = imageView9;
        this.bqe = hlVar;
        setContainedBinding(this.bqe);
        this.bqo = view8;
        this.bqh = imageView10;
    }

    @NonNull
    public static gt l(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return l(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static gt l(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        return (gt) DataBindingUtil.inflate(layoutInflater, R.layout.deposit_page_content_no_bonus, viewGroup, z, dataBindingComponent);
    }
}
