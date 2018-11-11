package com.iqoption.fragment;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.util.p;
import com.iqoption.d.lm;
import com.iqoption.fragment.dialog.popup.PopupViewModel;
import com.iqoption.util.ax;
import com.iqoption.util.bg;
import com.iqoption.util.g;
import com.iqoption.util.i;
import com.iqoption.util.l;
import com.iqoption.x.R;
import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: CommissionsValueChangedFragment */
public final class aq extends com.iqoption.fragment.base.b {
    private boolean coJ = false;
    private InstrumentType coK = InstrumentType.UNKNOWN;
    private lm coL;
    private Animator coM;
    private int coN;

    /* compiled from: CommissionsValueChangedFragment */
    private static class c {
        public final String coW = l.CD();
        public final Double coX = l.aGa();
    }

    /* compiled from: CommissionsValueChangedFragment */
    private interface d {
        a k(ViewGroup viewGroup);
    }

    /* compiled from: CommissionsValueChangedFragment */
    private static final class a extends ViewHolder {
        private final TextView bnL;
        private final TextView coS;
        private final TextView coT;
        private final c coU;
        private final InstrumentType instrumentType;

        public a(View view, InstrumentType instrumentType, c cVar) {
            super(view);
            this.coU = cVar;
            this.instrumentType = instrumentType;
            this.bnL = (TextView) view.findViewById(R.id.activeName);
            this.coS = (TextView) view.findViewById(R.id.fixCommission);
            this.coT = (TextView) view.findViewById(R.id.percentCommission);
        }

        void a(com.iqoption.core.microservices.tradingengine.response.a.a aVar) {
            if (aVar != null) {
                Context context = this.bnL.getContext();
                com.iqoption.core.microservices.tradingengine.response.active.a a = com.iqoption.app.helpers.a.FI().a(aVar.getActiveId(), this.instrumentType);
                if (a != null) {
                    this.bnL.setText(com.iqoption.util.e.a.s(a));
                }
                com.iqoption.core.microservices.tradingengine.response.a.a.a XH = aVar.XH();
                if (XH != null) {
                    if (XH.XI() == null || com.google.common.c.a.b(0.0d, XH.XI().doubleValue(), 0.1d)) {
                        this.coS.setText(context.getString(R.string.n_a));
                    } else {
                        this.coS.setText(l.e(this.coU.coW, Double.valueOf(XH.XI().doubleValue() / this.coU.coX.doubleValue())));
                    }
                    double doubleValue = XH.XJ() == null ? 0.0d : XH.XJ().doubleValue() * 100.0d;
                    if (com.google.common.c.a.b(0.0d, doubleValue, 0.1d)) {
                        this.coT.setText(context.getString(R.string.n_a));
                    } else {
                        this.coT.setText(p.a(doubleValue, "", 2));
                    }
                }
            }
        }
    }

    /* compiled from: CommissionsValueChangedFragment */
    private static final class b extends Adapter<a> {
        private final ArrayList<com.iqoption.core.microservices.tradingengine.response.a.a> amd;
        private final d coV;

        /* synthetic */ b(d dVar, ArrayList arrayList, AnonymousClass1 anonymousClass1) {
            this(dVar, arrayList);
        }

        private b(d dVar, ArrayList<com.iqoption.core.microservices.tradingengine.response.a.a> arrayList) {
            this.coV = dVar;
            this.amd = arrayList;
        }

        /* renamed from: F */
        public a onCreateViewHolder(ViewGroup viewGroup, int i) {
            return this.coV.k(viewGroup);
        }

        /* renamed from: a */
        public void onBindViewHolder(a aVar, int i) {
            aVar.a((com.iqoption.core.microservices.tradingengine.response.a.a) this.amd.get(i));
        }

        public int getItemCount() {
            return this.amd.size();
        }
    }

    public static aq c(InstrumentType instrumentType, ArrayList<com.iqoption.core.microservices.tradingengine.response.a.a> arrayList) {
        aq aqVar = new aq();
        aqVar.setArguments(new g().a("arg.instrumentType", (Serializable) instrumentType).a("arg.commission_items", (ArrayList) arrayList).toBundle());
        return aqVar;
    }

    public static void a(FragmentActivity fragmentActivity, FragmentManager fragmentManager, @IdRes int i, InstrumentType instrumentType, ArrayList<com.iqoption.core.microservices.tradingengine.response.a.a> arrayList) {
        PopupViewModel j = PopupViewModel.j(fragmentActivity);
        Runnable arVar = new ar(fragmentManager, i, instrumentType, arrayList);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CommissionsValueChangedFragment");
        stringBuilder.append(instrumentType);
        j.a(arVar, stringBuilder.toString());
    }

    private static void a(@NonNull FragmentManager fragmentManager, @IdRes int i, InstrumentType instrumentType, ArrayList<com.iqoption.core.microservices.tradingengine.response.a.a> arrayList) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CommissionsValueChangedFragment");
        stringBuilder.append(instrumentType);
        if (fragmentManager.findFragmentByTag(stringBuilder.toString()) == null) {
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            Fragment c = c(instrumentType, arrayList);
            stringBuilder = new StringBuilder();
            stringBuilder.append("CommissionsValueChangedFragment");
            stringBuilder.append(instrumentType);
            beginTransaction = beginTransaction.add(i, c, stringBuilder.toString());
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("CommissionsValueChangedFragment");
            stringBuilder2.append(instrumentType);
            beginTransaction.addToBackStack(stringBuilder2.toString()).commitAllowingStateLoss();
        }
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.coL = (lm) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_commission_change, viewGroup, false);
        this.coN = com.iqoption.util.b.bQ(requireContext());
        this.coL.bxe.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                aq.this.onClose();
            }
        });
        this.coL.brN.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                aq.this.ahm();
            }
        });
        this.coL.bxh.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                if (aq.this.coL.bxh.isSelected()) {
                    aq.this.coL.bxh.setSelected(false);
                    aq.this.coL.bxl.setVisibility(8);
                    aq.this.coL.bxk.setVisibility(8);
                    aq.this.coL.bxf.setVisibility(0);
                    aq.this.coL.bxg.setVisibility(0);
                    aq.this.coL.brN.setVisibility(0);
                    return;
                }
                aq.this.coL.bxh.setSelected(true);
                aq.this.coL.bxf.setVisibility(8);
                aq.this.coL.bxg.setVisibility(8);
                aq.this.coL.bxk.setVisibility(0);
                aq.this.coL.bxl.setVisibility(0);
                aq.this.coL.brN.setVisibility(8);
            }
        });
        this.coL.bxi.setLayoutTransition(bg.aGE());
        LayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setAutoMeasureEnabled(true);
        this.coL.bxg.setDuplicateParentStateEnabled(false);
        this.coL.bxg.setLayoutManager(linearLayoutManager);
        Bundle arguments = getArguments();
        this.coK = (InstrumentType) arguments.getSerializable("arg.instrumentType");
        Object parcelableArrayList = arguments.getParcelableArrayList("arg.commission_items");
        final c cVar = new c();
        if (!i.H(parcelableArrayList)) {
            this.coL.bxg.setAdapter(new b(new d() {
                public a k(ViewGroup viewGroup) {
                    return new a(LayoutInflater.from(aq.this.getContext()).inflate(R.layout.commission_list_item, viewGroup, false), aq.this.coK, cVar);
                }
            }, parcelableArrayList, null));
        }
        this.coL.bxj.setText(com.iqoption.util.e.a.O(this.coK));
        return this.coL.getRoot();
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    public void ahm() {
        this.coJ = true;
        onClose();
    }

    public boolean onClose() {
        if (this.coJ) {
            requireFragmentManager().popBackStack();
            PopupViewModel j = PopupViewModel.j(requireActivity());
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("CommissionsValueChangedFragment");
            stringBuilder.append(this.coK);
            j.hO(stringBuilder.toString());
        } else {
            ahn();
        }
        return true;
    }

    private void ahn() {
        if (this.coM != null) {
            this.coM.cancel();
        }
        this.coM = com.iqoption.util.b.o(this.coL.blV, this.coN);
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    public void ND() {
        this.coL.blV.setAlpha(0.0f);
        float f;
        if (ax.dws) {
            TimeInterpolator timeInterpolator = com.iqoption.view.a.a.d.dEM;
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.dp12);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.dp6);
            float f2 = (float) dimensionPixelSize2;
            this.coL.blV.setTranslationX(f2);
            f = (float) (-dimensionPixelSize2);
            this.coL.blV.setTranslationY(f);
            this.coL.bxg.setTranslationX(f2);
            this.coL.bxg.setTranslationY(f);
            this.coL.bxg.setAlpha(0.0f);
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(this.coL.blV, this.coL.blV.getWidth() - dimensionPixelSize, dimensionPixelSize, (float) dimensionPixelSize, (float) Math.hypot((double) this.coL.blV.getWidth(), (double) this.coL.blV.getHeight()));
            createCircularReveal.setDuration(400).setInterpolator(timeInterpolator);
            FrameLayout frameLayout = this.coL.blV;
            r6 = new PropertyValuesHolder[2];
            r6[0] = PropertyValuesHolder.ofFloat("translationX", new float[]{0.0f});
            r6[1] = PropertyValuesHolder.ofFloat("translationY", new float[]{0.0f});
            Animator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(frameLayout, r6);
            ofPropertyValuesHolder.setDuration(200).setInterpolator(timeInterpolator);
            RecyclerView recyclerView = this.coL.bxg;
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
            this.coL.blV.setAlpha(1.0f);
            return;
        }
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.dp12);
        f = (float) (-dimensionPixelOffset);
        this.coL.blV.setTranslationX(f);
        this.coL.blV.setTranslationY(f);
        this.coL.blV.setPivotX((float) (this.coL.blV.getWidth() - dimensionPixelOffset));
        this.coL.blV.setPivotY(1.0f);
        this.coL.blV.setScaleX(0.3f);
        this.coL.blV.setScaleY(0.3f);
        this.coL.blV.animate().alpha(1.0f).scaleY(1.0f).scaleX(1.0f).translationX(0.0f).translationY(0.0f).setDuration(400).setListener(null).setInterpolator(com.iqoption.view.a.a.d.dEM).start();
    }

    public void NE() {
        this.coL.blV.setPivotX((float) this.coL.blV.getWidth());
        this.coL.blV.setPivotY(1.0f);
        this.coL.blV.animate().alpha(0.0f).scaleY(0.7f).scaleX(0.7f).setDuration(300).setInterpolator(com.iqoption.view.a.a.d.dEM).start();
    }
}
