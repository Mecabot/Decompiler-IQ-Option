package com.iqoption.fragment;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.iqoption.app.IQApp;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.d.ot;
import com.iqoption.fragment.rightpanel.ar;
import com.iqoption.util.ax;
import com.iqoption.util.g;
import com.iqoption.x.R;
import java.io.Serializable;
import java.util.Locale;

/* compiled from: MultiplierFragment */
public final class bq extends com.iqoption.fragment.base.b {
    private ot cpX;

    /* compiled from: MultiplierFragment */
    public static class c {
        public final int multiplier;

        public c(int i) {
            this.multiplier = i;
        }
    }

    /* compiled from: MultiplierFragment */
    private interface e {
        a m(ViewGroup viewGroup);
    }

    /* compiled from: MultiplierFragment */
    private static final class a extends ViewHolder {
        private int multiplier;

        /* compiled from: MultiplierFragment */
        interface a {
            void ar(int i, int i2);
        }

        public a(View view, final a aVar) {
            super(view);
            view.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (a.this.getAdapterPosition() != -1) {
                        aVar.ar(a.this.multiplier, a.this.getAdapterPosition());
                    }
                }
            });
        }

        void eC(int i) {
            this.multiplier = i;
            ((TextView) this.itemView).setText(String.format(Locale.US, "x%d", new Object[]{Integer.valueOf(i)}));
        }
    }

    /* compiled from: MultiplierFragment */
    private static final class b extends Adapter<a> {
        private final e cqb;
        private final int[] cqc;

        private b(e eVar, int[] iArr) {
            this.cqb = eVar;
            this.cqc = iArr;
        }

        /* renamed from: G */
        public a onCreateViewHolder(ViewGroup viewGroup, int i) {
            return this.cqb.m(viewGroup);
        }

        /* renamed from: a */
        public void onBindViewHolder(a aVar, int i) {
            aVar.eC(this.cqc[i]);
        }

        public int getItemCount() {
            return this.cqc.length;
        }
    }

    /* compiled from: MultiplierFragment */
    public static class d extends com.iqoption.system.a.c<Boolean> {
    }

    public static bq b(@NonNull InstrumentType instrumentType, int i) {
        bq bqVar = new bq();
        bqVar.setArguments(new g().a("arg.activeType", (Serializable) instrumentType).O("arg.activeId", i).toBundle());
        return bqVar;
    }

    public static void a(FragmentManager fragmentManager, @IdRes int i, @NonNull InstrumentType instrumentType, int i2) {
        fragmentManager.beginTransaction().add(i, b(instrumentType, i2), "MultiplierFragment").addToBackStack("MultiplierFragment").commit();
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.cpX = (ot) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_multiplier_chooser, viewGroup, false);
        this.cpX.a(this);
        LayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setAutoMeasureEnabled(true);
        this.cpX.bze.setDuplicateParentStateEnabled(false);
        this.cpX.bze.setLayoutManager(linearLayoutManager);
        Bundle arguments = getArguments();
        InstrumentType instrumentType = (InstrumentType) arguments.getSerializable("arg.activeType");
        com.iqoption.core.microservices.tradingengine.response.b.a a = com.iqoption.app.helpers.a.FI().a(instrumentType, arguments.getInt("arg.activeId"));
        if (a != null) {
            this.cpX.bze.setAdapter(new b(new br(this), ar.a(a.ck(com.iqoption.app.a.Cw().Dh()), instrumentType)));
        }
        return this.cpX.getRoot();
    }

    final /* synthetic */ a l(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(getContext()).inflate(R.layout.multiplier_list_item, viewGroup, false), new bs(this));
    }

    final /* synthetic */ void aq(int i, int i2) {
        IQApp.Dn().aE(new c(i));
        aN();
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        IQApp.Dn().aE(new d().setValue(Boolean.valueOf(true)));
    }

    public boolean onClose() {
        getFragmentManager().popBackStack();
        IQApp.Dn().aE(new d().setValue(Boolean.valueOf(false)));
        return true;
    }

    public void ND() {
        this.cpX.blV.setAlpha(0.0f);
        float f;
        if (ax.dws) {
            TimeInterpolator timeInterpolator = com.iqoption.view.a.a.d.dEM;
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.dp12);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.dp6);
            float f2 = (float) dimensionPixelSize2;
            this.cpX.blV.setTranslationX(f2);
            f = (float) (-dimensionPixelSize2);
            this.cpX.blV.setTranslationY(f);
            this.cpX.bze.setTranslationX(f2);
            this.cpX.bze.setTranslationY(f);
            this.cpX.bze.setAlpha(0.0f);
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(this.cpX.blV, this.cpX.blV.getWidth() - dimensionPixelSize, dimensionPixelSize, (float) dimensionPixelSize, (float) Math.hypot((double) this.cpX.blV.getWidth(), (double) this.cpX.blV.getHeight()));
            createCircularReveal.setDuration(400).setInterpolator(timeInterpolator);
            FrameLayout frameLayout = this.cpX.blV;
            r6 = new PropertyValuesHolder[2];
            r6[0] = PropertyValuesHolder.ofFloat("translationX", new float[]{0.0f});
            r6[1] = PropertyValuesHolder.ofFloat("translationY", new float[]{0.0f});
            Animator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(frameLayout, r6);
            ofPropertyValuesHolder.setDuration(200).setInterpolator(timeInterpolator);
            RecyclerView recyclerView = this.cpX.bze;
            r11 = new PropertyValuesHolder[3];
            r11[0] = PropertyValuesHolder.ofFloat("translationX", new float[]{0.0f});
            r11[1] = PropertyValuesHolder.ofFloat("translationY", new float[]{0.0f});
            r11[2] = PropertyValuesHolder.ofFloat("alpha", new float[]{1.0f});
            Animator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(recyclerView, r11);
            ofPropertyValuesHolder2.setDuration(200).setInterpolator(timeInterpolator);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(createCircularReveal).with(ofPropertyValuesHolder);
            animatorSet.play(ofPropertyValuesHolder2).after(100);
            animatorSet.start();
            this.cpX.blV.setAlpha(1.0f);
            return;
        }
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.dp12);
        f = (float) (-dimensionPixelOffset);
        this.cpX.blV.setTranslationX(f);
        this.cpX.blV.setTranslationY(f);
        this.cpX.blV.setPivotX((float) (this.cpX.blV.getWidth() - dimensionPixelOffset));
        this.cpX.blV.setPivotY(1.0f);
        this.cpX.blV.setScaleX(0.3f);
        this.cpX.blV.setScaleY(0.3f);
        this.cpX.blV.animate().alpha(1.0f).scaleY(1.0f).scaleX(1.0f).translationX(0.0f).translationY(0.0f).setDuration(400).setListener(null).setInterpolator(com.iqoption.view.a.a.d.dEM).start();
    }

    public void NE() {
        this.cpX.blV.animate().alpha(0.0f).setInterpolator(com.iqoption.view.a.a.d.dEM).start();
    }
}
