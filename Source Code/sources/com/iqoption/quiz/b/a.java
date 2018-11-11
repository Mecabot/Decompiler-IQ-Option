package com.iqoption.quiz.b;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.iqoption.quiz.widget.CustomVideoView;
import com.iqoption.quiz.widget.maxsize.MaxSizeFrameLayout;

/* compiled from: ActivityQuizBinding */
public abstract class a extends ViewDataBinding {
    @NonNull
    public final View bqo;
    @NonNull
    public final c djQ;
    @NonNull
    public final TextView djR;
    @NonNull
    public final MaxSizeFrameLayout djS;
    @NonNull
    public final e djT;
    @NonNull
    public final TextView djU;
    @NonNull
    public final LinearLayout djV;
    @NonNull
    public final TextView djW;
    @NonNull
    public final FrameLayout djX;
    @NonNull
    public final g djY;
    @NonNull
    public final i djZ;
    @NonNull
    public final k dka;
    @NonNull
    public final FrameLayout dkb;
    @NonNull
    public final s dkc;
    @NonNull
    public final o dkd;
    @NonNull
    public final u dke;
    @NonNull
    public final ConstraintLayout dkf;
    @NonNull
    public final ScrollView dkg;
    @NonNull
    public final w dkh;
    @NonNull
    public final LinearLayout dki;
    @NonNull
    public final CustomVideoView dkj;
    @NonNull
    public final aa dkk;

    protected a(DataBindingComponent dataBindingComponent, View view, int i, c cVar, TextView textView, MaxSizeFrameLayout maxSizeFrameLayout, e eVar, TextView textView2, LinearLayout linearLayout, TextView textView3, FrameLayout frameLayout, g gVar, i iVar, k kVar, FrameLayout frameLayout2, s sVar, o oVar, u uVar, ConstraintLayout constraintLayout, ScrollView scrollView, w wVar, LinearLayout linearLayout2, View view2, CustomVideoView customVideoView, aa aaVar) {
        super(dataBindingComponent, view, i);
        this.djQ = cVar;
        setContainedBinding(this.djQ);
        this.djR = textView;
        this.djS = maxSizeFrameLayout;
        this.djT = eVar;
        setContainedBinding(this.djT);
        this.djU = textView2;
        this.djV = linearLayout;
        this.djW = textView3;
        this.djX = frameLayout;
        this.djY = gVar;
        setContainedBinding(this.djY);
        this.djZ = iVar;
        setContainedBinding(this.djZ);
        this.dka = kVar;
        setContainedBinding(this.dka);
        this.dkb = frameLayout2;
        this.dkc = sVar;
        setContainedBinding(this.dkc);
        this.dkd = oVar;
        setContainedBinding(this.dkd);
        this.dke = uVar;
        setContainedBinding(this.dke);
        this.dkf = constraintLayout;
        this.dkg = scrollView;
        this.dkh = wVar;
        setContainedBinding(this.dkh);
        this.dki = linearLayout2;
        this.bqo = view2;
        this.dkj = customVideoView;
        this.dkk = aaVar;
        setContainedBinding(this.dkk);
    }
}
