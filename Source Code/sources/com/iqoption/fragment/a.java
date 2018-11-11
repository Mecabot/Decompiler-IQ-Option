package com.iqoption.fragment;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.o;
import com.iqoption.analytics.EventManager;
import com.iqoption.app.IQApp;
import com.iqoption.app.af;
import com.iqoption.app.managers.ae;
import com.iqoption.app.managers.tab.a.g;
import com.iqoption.app.managers.y;
import com.iqoption.core.data.model.ActiveType;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.ui.navigation.h;
import com.iqoption.core.util.i;
import com.iqoption.d.ap;
import com.iqoption.dto.Event;
import com.iqoption.dto.Event.Builder;
import com.iqoption.fragment.dialog.n;
import com.iqoption.fragment.localeasset.LocaleAssetViewModel;
import com.iqoption.protrader.f;
import com.iqoption.tutorial.TutorialViewModel;
import com.iqoption.tutorial.dictionary.TutorialAction;
import com.iqoption.tutorial.e;
import com.iqoption.util.am;
import com.iqoption.util.ax;
import com.iqoption.util.bg;
import com.iqoption.view.text.x;
import com.iqoption.x.R;
import java.util.Set;
import java.util.concurrent.Callable;

/* compiled from: AssetFragment */
public class a extends com.iqoption.fragment.base.b implements com.iqoption.tutorial.c.b, com.iqoption.util.am.a {
    private Builder adT;
    @NonNull
    private TutorialViewModel aeq;
    private boolean ant;
    private com.iqoption.a.a cnp;
    private ac cnq;
    private boolean cnr;
    private ap cns;
    private c cnt = new c(this);
    @NonNull
    private OnClickListener cnu = new b(this);
    @NonNull
    private LocaleAssetViewModel cnv;
    @NonNull
    private e cnw;
    @NonNull
    private e cnx;
    private Set<Pair<View, Integer>> cny = Sets.uI();
    private int cnz = 0;

    /* compiled from: AssetFragment */
    private static class a implements Callable<Drawable> {
        @DrawableRes
        final int cnF;

        public a(@DrawableRes int i) {
            this.cnF = i;
        }

        /* renamed from: agX */
        public Drawable call() {
            return ContextCompat.getDrawable(IQApp.Dk(), this.cnF);
        }
    }

    /* compiled from: AssetFragment */
    public static class d {
        public boolean aos;
        public boolean cnr;

        public d(boolean z, boolean z2) {
            this.aos = z;
            this.cnr = z2;
        }
    }

    /* compiled from: AssetFragment */
    private static class b extends com.iqoption.system.c.b<View, Drawable> {
        b(View view) {
            super((Object) view);
        }

        /* renamed from: a */
        public void z(@NonNull View view, @NonNull Drawable drawable) {
            view.setBackground(drawable);
            ((AnimationDrawable) ((LayerDrawable) drawable).getDrawable(1)).start();
        }
    }

    /* compiled from: AssetFragment */
    private static class c extends com.iqoption.system.a.e<a> {
        public c(a aVar) {
            super(aVar);
        }

        @com.google.common.b.e
        public void onCommissionActiveChangeEvent(com.iqoption.app.helpers.a.b bVar) {
            com.iqoption.core.d.a.aSe.execute(new z(this));
        }

        final /* synthetic */ void agZ() {
            a aVar = (a) this.drU.get();
            if (aVar != null && aVar.isAdded()) {
                if (a.a(aVar.cnq, ActiveType.TURBO_ACTIVE, ActiveType.BINARY_ACTIVE)) {
                    aVar.agN();
                }
            }
        }

        @com.google.common.b.e
        public void onScheduleActiveChangeEvent(com.iqoption.app.helpers.a.d dVar) {
            com.iqoption.core.d.a.aSe.execute(new aa(this, dVar));
        }

        final /* synthetic */ void a(com.iqoption.app.helpers.a.d dVar) {
            a aVar = (a) this.drU.get();
            if (aVar != null && aVar.isAdded()) {
                aVar.F((InstrumentType) dVar.getValue());
            }
        }

        @com.google.common.b.e
        public void onUpdateActiveSpreadEvent(com.iqoption.app.helpers.a.e eVar) {
            com.iqoption.core.d.a.aSe.execute(new ab(this));
        }

        final /* synthetic */ void agY() {
            a aVar = (a) this.drU.get();
            if (aVar != null && aVar.isAdded()) {
                aVar.agN();
                if (!com.iqoption.tutorial.c.q(aVar.getFragmentManager())) {
                    aVar.agP();
                }
            }
        }
    }

    public long NF() {
        return 400;
    }

    public long NG() {
        return 300;
    }

    private static a c(boolean z, int i) {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putBoolean("add_tab_flag", z);
        bundle.putInt("leftMargin", i);
        aVar.setArguments(bundle);
        return aVar;
    }

    public static void a(FragmentManager fragmentManager, @IdRes int i, boolean z, int i2) {
        fragmentManager.beginTransaction().add(i, c(z, i2), "AssetFragment").addToBackStack("AssetFragment").commit();
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.cnv = LocaleAssetViewModel.cEt.S(this);
        this.aeq = TutorialViewModel.duq.D(requireActivity());
        this.cnw = new e(requireFragmentManager(), c.aeC, new n(this), new s(this), null, false);
        this.cnx = new e(requireFragmentManager(), t.aeC, new u(this), new v(this), null, false);
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i = 0;
        this.cns = (ap) DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.asset_fragment, viewGroup, false);
        this.cns.a(this);
        if (getArguments() != null) {
            this.cnr = getArguments().getBoolean("add_tab_flag", false);
            i = getArguments().getInt("leftMargin", 0);
        }
        if (i != 0) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.dp518);
            cr ajW = ajW();
            if (!(ajW == null || ajW.getView() == null)) {
                int width = ajW.getView().getWidth();
                if (i + dimensionPixelSize > width) {
                    i = width - dimensionPixelSize;
                }
            }
            LayoutParams layoutParams = (LayoutParams) this.cns.bjl.getLayoutParams();
            layoutParams.setMargins(i, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            this.cns.bjl.setLayoutParams(layoutParams);
        }
        boolean HG = com.iqoption.app.managers.feature.a.HG();
        com.iqoption.core.microservices.tradingengine.response.active.a Iw = com.iqoption.app.managers.tab.a.Il().Iw();
        if (Iw == null) {
            requireFragmentManager().popBackStack();
            return null;
        }
        InstrumentType instrumentType = Iw.getInstrumentType();
        ActiveType activeType = Iw.getActiveType();
        if (HG && instrumentType == InstrumentType.DIGITAL_INSTRUMENT) {
            instrumentType = InstrumentType.BINARY_INSTRUMENT;
            if (activeType != null) {
                activeType = ActiveType.BINARY_ACTIVE;
            }
        }
        this.cnq = new be(instrumentType, activeType);
        agF();
        this.cns.bjI.setOnClickListener(new w(this));
        final com.iqoption.videoeducation.c cVar = new com.iqoption.videoeducation.c(new x(this));
        this.cns.bjX.addTextChangedListener(new x() {
            private String aIV;

            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                Object obj = editable.toString();
                if (this.aIV == null || !TextUtils.equals(this.aIV, obj)) {
                    cVar.a(editable, 150);
                    this.aIV = obj;
                }
            }
        });
        this.cns.bjW.setLayoutTransition(bg.aGE());
        this.cnp = new com.iqoption.a.a(new y(this));
        this.cns.bjF.setOnClickListener(this.cnu);
        this.cnp.setHasStableIds(true);
        Context requireContext = requireContext();
        LayoutManager linearLayoutManager = new LinearLayoutManager(requireContext);
        ItemDecoration dividerItemDecoration = new DividerItemDecoration(requireContext, linearLayoutManager.getOrientation());
        dividerItemDecoration.setDrawable(getDrawable(R.drawable.line_divider_black20_1px));
        this.cns.bjd.setLayoutManager(linearLayoutManager);
        this.cns.bjd.setAdapter(this.cnp);
        this.cns.bjd.setHasFixedSize(true);
        this.cns.bjd.addItemDecoration(dividerItemDecoration);
        this.cns.bjg.setOnClickListener(new d(this));
        this.cns.bjV.setOnClickListener(new e(this));
        this.cns.bjC.setOnClickListener(new f(this));
        this.cns.bkn.setOnClickListener(new g(this));
        this.cns.bjM.setOnClickListener(new h(this));
        if (com.iqoption.app.managers.feature.a.eW("local-assets") && com.iqoption.app.managers.feature.a.HK()) {
            this.cns.bjN.setOnClickListener(new i(this));
            this.cns.bjO.setOnClickListener(new j(this));
            this.cnv.amz().observe(this, new k(this));
        }
        return this.cns.getRoot();
    }

    final /* synthetic */ void x(CharSequence charSequence) {
        this.cnp.dS(charSequence.toString());
    }

    final /* synthetic */ void l(View view, int i) {
        if (i >= 0 && i < this.cnp.getItemCount() && this.cnp.getItemCount() > 0) {
            com.iqoption.a.a.a cq = this.cnp.cq(i);
            if (cq != null) {
                if (this.cnr) {
                    com.iqoption.app.managers.tab.a.Il().e(new g(cq.activeId, cq.instrumentType));
                    EventManager.Bm().a(Event.Builder(Event.CATEGORY_POPUP_SERVED, "traderoom_new-tab-plus").setValue(Double.valueOf((double) com.iqoption.app.managers.tab.a.Il().IG())).setParameters(i.ZZ().l("instrument_type", agR()).aab()).build());
                } else {
                    g IC = com.iqoption.app.managers.tab.a.Il().IC();
                    if (!(IC == null || (IC.getActiveId() == cq.activeId && IC.getInstrumentType().equals(cq.instrumentType)))) {
                        com.iqoption.app.managers.tab.a.Il().c(cq.activeId, cq.instrumentType);
                    }
                }
                ae.h(IQApp.Dk(), 256);
                EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "change-asset_chose-asset").setParameters(i.ZZ().l("instrument_type", agR()).aab()).setValue(Double.valueOf((double) cq.activeId)).build());
                onClose();
            }
        }
    }

    public void onResume() {
        super.onResume();
        am.a(this);
        this.adT = Event.Builder(Event.CATEGORY_SCREEN_OPENED, "change-asset");
        if (this.ant) {
            agM();
            this.ant = false;
        }
    }

    public void onPause() {
        super.onPause();
        am.b(this);
        if (this.adT != null) {
            EventManager.Bm().a(this.adT.calcDuration().build());
        }
        this.ant = true;
    }

    public void cp(boolean z) {
        if (!z) {
            com.iqoption.activity.d ajX = ajX();
            if (ajX != null) {
                ajX.adL.aGp();
            }
        }
    }

    public void onViewCreated(@NonNull View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        bg.b(this.cns.getRoot(), new l(this, a(this.cnq, true, true)));
        IQApp.Dn().aE(new d(true, this.cnr));
    }

    final /* synthetic */ void aE(View view) {
        if (view != null) {
            ay(view);
        }
        d(this.cnq);
        if (a(ActiveType.TURBO_ACTIVE, ActiveType.BINARY_ACTIVE, ActiveType.DIGITAL_ACTIVE, ActiveType.FX_ACTIVE)) {
            az(this.cns.bkC);
        }
    }

    private void ay(@NonNull View view) {
        view.postDelayed(new m(this, view), 100);
    }

    final /* synthetic */ void aD(@NonNull View view) {
        int height = this.cns.bjW.getHeight() - this.cns.bkD.getHeight();
        int i = this.cns.bkD.getHeight() / 2 > view.getTop() ? -1 : 1;
        if (height > 0) {
            this.cns.bkD.smoothScrollBy(0, i * height);
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    private void agA() {
        boolean a = a(ActiveType.FOREX_ACTIVE);
        int i = a ? 9 : 1;
        int i2 = a ? 10 : 2;
        com.iqoption.a.a aVar;
        if (this.cns.bjf.aHX()) {
            this.cns.bjf.reverse();
            aVar = this.cnp;
            if (!this.cns.bjf.isReverse()) {
                i2 = i;
            }
            aVar.cp(i2);
        } else {
            this.cns.bjf.setSwitched(true);
            this.cns.bjU.setSwitched(false);
            this.cns.bjB.setSwitched(false);
            this.cns.bkm.setSwitched(false);
            this.cns.bjL.setSwitched(false);
            aVar = this.cnp;
            if (!this.cns.bjf.isReverse()) {
                i2 = i;
            }
            aVar.cp(i2);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("asset_sort_type_");
        stringBuilder.append(agS());
        af.setInt(stringBuilder.toString(), this.cnp.AH());
    }

    private void agB() {
        int i = 3;
        com.iqoption.a.a aVar;
        if (this.cns.bjU.aHX()) {
            this.cns.bjU.reverse();
            aVar = this.cnp;
            if (this.cns.bjU.isReverse()) {
                i = 4;
            }
            aVar.cp(i);
        } else {
            this.cns.bjf.setSwitched(false);
            this.cns.bjB.setSwitched(false);
            this.cns.bkm.setSwitched(false);
            this.cns.bjL.setSwitched(false);
            this.cns.bjU.setSwitched(true);
            aVar = this.cnp;
            if (this.cns.bjU.isReverse()) {
                i = 4;
            }
            aVar.cp(i);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("asset_sort_type_");
        stringBuilder.append(agS());
        af.setInt(stringBuilder.toString(), this.cnp.AH());
    }

    private void agC() {
        int i = 5;
        com.iqoption.a.a aVar;
        if (this.cns.bjB.aHX()) {
            this.cns.bjB.reverse();
            aVar = this.cnp;
            if (this.cns.bjB.isReverse()) {
                i = 6;
            }
            aVar.cp(i);
        } else {
            this.cns.bjf.setSwitched(false);
            this.cns.bkm.setSwitched(false);
            this.cns.bjU.setSwitched(false);
            this.cns.bjL.setSwitched(false);
            this.cns.bjB.setSwitched(true);
            aVar = this.cnp;
            if (this.cns.bjB.isReverse()) {
                i = 6;
            }
            aVar.cp(i);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("asset_sort_type_");
        stringBuilder.append(agS());
        af.setInt(stringBuilder.toString(), this.cnp.AH());
    }

    private void agD() {
        int i = 11;
        com.iqoption.a.a aVar;
        if (this.cns.bjL.aHX()) {
            this.cns.bjL.reverse();
            aVar = this.cnp;
            if (this.cns.bjL.isReverse()) {
                i = 12;
            }
            aVar.cp(i);
        } else {
            this.cns.bjf.setSwitched(false);
            this.cns.bjU.setSwitched(false);
            this.cns.bjB.setSwitched(false);
            this.cns.bkm.setSwitched(false);
            this.cns.bjL.setSwitched(true);
            aVar = this.cnp;
            if (this.cns.bjL.isReverse()) {
                i = 12;
            }
            aVar.cp(i);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("asset_sort_type_");
        stringBuilder.append(agS());
        af.setInt(stringBuilder.toString(), this.cnp.AH());
    }

    private void agE() {
        int i = 7;
        com.iqoption.a.a aVar;
        if (this.cns.bkm.aHX()) {
            this.cns.bkm.reverse();
            aVar = this.cnp;
            if (this.cns.bkm.isReverse()) {
                i = 8;
            }
            aVar.cp(i);
        } else {
            this.cns.bjf.setSwitched(false);
            this.cns.bjU.setSwitched(false);
            this.cns.bjB.setSwitched(false);
            this.cns.bjL.setSwitched(false);
            this.cns.bkm.setSwitched(true);
            aVar = this.cnp;
            if (this.cns.bkm.isReverse()) {
                i = 8;
            }
            aVar.cp(i);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("asset_sort_type_");
        stringBuilder.append(agS());
        af.setInt(stringBuilder.toString(), this.cnp.AH());
    }

    private void agF() {
        int agG;
        int b;
        int b2;
        int b3;
        int b4;
        int b5;
        boolean HJ = com.iqoption.app.managers.feature.a.HJ();
        LinearLayout linearLayout = this.cns.bjS;
        Context context = getContext();
        if (f.bI(context)) {
            linearLayout.setVisibility(0);
            linearLayout.setOnClickListener(new o(this, linearLayout));
            cO(true);
        } else if (HJ || !n.bq(context)) {
            linearLayout.setVisibility(8);
        } else {
            linearLayout.setVisibility(0);
            linearLayout.setOnClickListener(new p(this));
            cO(false);
        }
        boolean HK = com.iqoption.app.managers.feature.a.HK();
        boolean HG = com.iqoption.app.managers.feature.a.HG();
        if (HJ) {
            agG = agG();
        } else {
            agG = 0;
        }
        int agG2 = !com.iqoption.app.managers.feature.a.HH() ? 0 : HG ? agG() : E(InstrumentType.DIGITAL_INSTRUMENT);
        int E = !com.iqoption.app.managers.feature.a.HI() ? 0 : E(InstrumentType.FX_INSTRUMENT);
        int E2 = !com.iqoption.app.managers.feature.a.HL() ? 0 : E(InstrumentType.FOREX_INSTRUMENT);
        int E3 = !com.iqoption.app.managers.feature.a.HM() ? 0 : E(InstrumentType.CRYPTO_INSTRUMENT);
        if (HK) {
            b = b(InstrumentType.CFD_INSTRUMENT, ActiveType.COMMODITY_ACTIVE);
        } else {
            b = 0;
        }
        if (HK) {
            b2 = b(InstrumentType.CFD_INSTRUMENT, ActiveType.INDEX_ACTIVE);
        } else {
            b2 = 0;
        }
        if (HK) {
            b3 = b(InstrumentType.CFD_INSTRUMENT, ActiveType.BOND_ACTIVE);
        } else {
            b3 = 0;
        }
        if (HK) {
            b4 = b(InstrumentType.CFD_INSTRUMENT, ActiveType.ETF_ACTIVE);
        } else {
            b4 = 0;
        }
        if (HK) {
            b5 = b(InstrumentType.CFD_INSTRUMENT, ActiveType.STOCK_ACTIVE);
        } else {
            b5 = 0;
        }
        boolean isSelected = this.cns.bkC.isSelected();
        if (agG == 0 && agG2 == 0 && E == 0) {
            this.cns.bkC.setSelected(false);
            this.cns.bkC.setVisibility(8);
            isSelected = false;
        }
        if (agG == 0) {
            this.cns.bjh.setVisibility(8);
        } else {
            this.cns.bjh.setVisibility(isSelected ? 0 : 8);
            this.cns.bkp.setText(com.iqoption.util.e.a.e(ActiveType.BINARY_ACTIVE));
            this.cns.bjm.setText(String.valueOf(agG));
        }
        if (agG2 == 0) {
            this.cns.bjD.setVisibility(8);
        } else {
            this.cns.bjD.setVisibility(isSelected ? 0 : 8);
            this.cns.bjq.setText(String.valueOf(agG2));
        }
        if (E == 0) {
            this.cns.bjH.setVisibility(8);
        } else {
            if (!af.DX().Fn()) {
                this.cny.add(new Pair(this.cns.bjH, Integer.valueOf(R.drawable.asset_list_fx_anim_bg)));
            }
            this.cns.bjH.setVisibility(isSelected ? 0 : 8);
            this.cns.bjt.setText(String.valueOf(E));
        }
        if (E2 == 0) {
            this.cns.bjG.setVisibility(8);
        } else {
            this.cns.bjG.setVisibility(0);
            this.cns.bjs.setText(String.valueOf(E2));
        }
        if (E3 == 0) {
            this.cns.bjz.setVisibility(8);
        } else {
            this.cns.bjz.setVisibility(0);
            this.cns.bjp.setText(String.valueOf(E3));
        }
        if (b == 0) {
            this.cns.bjk.setVisibility(8);
        } else {
            this.cns.bjk.setVisibility(0);
            this.cns.bjo.setText(String.valueOf(b));
        }
        if (b2 == 0) {
            this.cns.bjJ.setVisibility(8);
        } else {
            this.cns.bjJ.setVisibility(0);
            this.cns.bju.setText(String.valueOf(b2));
        }
        if (b3 == 0) {
            this.cns.bji.setVisibility(8);
        } else {
            this.cns.bji.setVisibility(0);
            this.cns.bjn.setText(String.valueOf(b3));
        }
        if (b4 == 0) {
            this.cns.bjE.setVisibility(8);
        } else {
            this.cns.bjE.setVisibility(0);
            this.cns.bjr.setText(String.valueOf(b4));
        }
        if (b5 == 0) {
            this.cns.bko.setVisibility(8);
            return;
        }
        this.cns.bko.setVisibility(0);
        this.cns.bjw.setText(String.valueOf(b5));
    }

    private void cO(boolean z) {
        LinearLayout linearLayout = this.cns.bjS;
        if (linearLayout.getBackground() == null) {
            boolean Fm;
            af aR = af.aR(getContext());
            if (z) {
                Fm = aR.Fm();
            } else {
                Fm = aR.Fl();
            }
            if (!Fm) {
                this.cny.add(new Pair(linearLayout, Integer.valueOf(R.drawable.asset_list_more_anim_bg)));
            } else if (z) {
                linearLayout.setBackgroundResource(R.drawable.option_type_bg);
            }
        }
    }

    private int E(InstrumentType instrumentType) {
        return com.iqoption.app.helpers.a.FI().d(instrumentType).size();
    }

    private int b(InstrumentType instrumentType, ActiveType activeType) {
        return com.iqoption.app.helpers.a.FI().a(instrumentType, activeType).size();
    }

    private int agG() {
        return com.iqoption.app.helpers.a.FI().FN().size();
    }

    private int e(InstrumentType instrumentType, String str) {
        return com.iqoption.app.helpers.a.FI().a(instrumentType, str).size();
    }

    private String agH() {
        com.iqoption.core.microservices.configuration.a.c cVar = (com.iqoption.core.microservices.configuration.a.c) this.cnv.amz().getValue();
        if (cVar == null) {
            return "";
        }
        return cVar.VE();
    }

    private void agI() {
        af.DX().bg(true);
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "more-opportunities_button-click").build());
        n.d(zzakw(), zzakw().getSupportFragmentManager());
        Drawable background = this.cns.bjS.getBackground();
        if (background instanceof LayerDrawable) {
            ((AnimationDrawable) ((LayerDrawable) background).getDrawable(1)).stop();
        }
        this.cns.bjS.setBackground(null);
    }

    public void az(View view) {
        boolean isSelected = view.isSelected() ^ 1;
        int i = 0;
        int i2 = isSelected ? 0 : 8;
        view.setSelected(isSelected);
        boolean HJ = com.iqoption.app.managers.feature.a.HJ();
        int agG = !com.iqoption.app.managers.feature.a.HJ() ? 0 : agG();
        int agG2 = !com.iqoption.app.managers.feature.a.HH() ? 0 : HJ ? agG() : E(InstrumentType.DIGITAL_INSTRUMENT);
        if (com.iqoption.app.managers.feature.a.HI()) {
            i = E(InstrumentType.FX_INSTRUMENT);
        }
        if (agG > 0) {
            this.cns.bjh.setVisibility(i2);
        } else {
            this.cns.bjh.setVisibility(8);
        }
        if (agG2 > 0) {
            this.cns.bjD.setVisibility(i2);
        } else {
            this.cns.bjD.setVisibility(8);
        }
        if (i > 0) {
            this.cns.bjH.setVisibility(i2);
        } else {
            this.cns.bjH.setVisibility(8);
        }
    }

    public void aA(View view) {
        FragmentManager fragmentManager = getFragmentManager();
        if (!view.isSelected() && fragmentManager != null) {
            ac acVar = this.cnq;
            if (acVar != null) {
                a(acVar, false);
            }
            if (acVar instanceof be) {
                y.a(false, getInstrumentType());
            }
            boolean HG = com.iqoption.app.managers.feature.a.HG();
            int id = view.getId();
            if (id == R.id.more_type) {
                this.cnq = new cl();
                if (this.cns.bjS.isSelected()) {
                    a(this.cnq, false);
                }
                aB(this.cns.bjS);
            } else if (id == R.id.localType) {
                this.cnq = new ck(agH());
                if (this.cns.bjP.isSelected()) {
                    a(this.cnq, false);
                }
            } else {
                ActiveType activeType;
                switch (id) {
                    case R.id.binaryType:
                        activeType = ActiveType.BINARY_ACTIVE;
                        hy("WHATS_NEW_DIALOG_TYPE_BINARY");
                        break;
                    case R.id.bondType:
                        activeType = ActiveType.BOND_ACTIVE;
                        break;
                    case R.id.commodityType:
                        activeType = ActiveType.COMMODITY_ACTIVE;
                        break;
                    case R.id.cryptoType:
                        activeType = ActiveType.CRYPTO_ACTIVE;
                        break;
                    case R.id.digitalType:
                        activeType = ActiveType.DIGITAL_ACTIVE;
                        if (!HG) {
                            hy("WHATS_NEW_DIALOG_TYPE_DIGITAL");
                            break;
                        }
                        break;
                    case R.id.etfType:
                        activeType = ActiveType.ETF_ACTIVE;
                        break;
                    case R.id.forexType:
                        activeType = ActiveType.FOREX_ACTIVE;
                        hy("WHATS_NEW_DIALOG_TYPE_FOREX");
                        break;
                    case R.id.fxType:
                        activeType = ActiveType.FX_ACTIVE;
                        if (!af.DX().Fn()) {
                            af.DX().bi(true);
                            aB(this.cns.bjH);
                            break;
                        }
                        break;
                    case R.id.indexType:
                        activeType = ActiveType.INDEX_ACTIVE;
                        break;
                    case R.id.stockType:
                        activeType = ActiveType.STOCK_ACTIVE;
                        break;
                    default:
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Unexpected: ");
                        stringBuilder.append(view);
                        throw new IllegalStateException(stringBuilder.toString());
                }
                this.cnq = new be(activeType.toInstrumentType(), activeType);
            }
            a(this.cnq, true);
            if (this.cns.bkC.isSelected()) {
                if (!a(ActiveType.DIGITAL_ACTIVE, ActiveType.BINARY_ACTIVE, ActiveType.FX_ACTIVE)) {
                    az(this.cns.bkC);
                }
            }
            if (this.cnq.aha() == TabType.MORE_TAB) {
                this.cns.bjO.setVisibility(8);
                this.cns.bja.setVisibility(8);
                this.cns.bjd.setVisibility(8);
                this.cns.bjI.setVisibility(8);
                com.iqoption.protrader.e.a(fragmentManager, R.id.activeMoreFragment);
                EventManager.Bm().a(new Event(Event.CATEGORY_BUTTON_PRESSED, "change-asset_more"));
            } else {
                com.iqoption.protrader.e.h(fragmentManager);
                this.cns.bja.setVisibility(0);
                this.cns.bjd.setVisibility(0);
                this.cns.bjI.setVisibility(0);
                if (this.cnq.aha() == TabType.LOCALE_ASSET_TAB) {
                    this.cns.bjO.setVisibility(0);
                } else {
                    this.cns.bjO.setVisibility(8);
                }
                ActiveType activeType2 = getActiveType();
                if (HG && activeType2 == ActiveType.DIGITAL_ACTIVE) {
                    this.cnq = new be(ActiveType.BINARY_ACTIVE.toInstrumentType(), ActiveType.BINARY_ACTIVE);
                }
                this.cnp.b(this.cnq);
                d(this.cnq);
                InstrumentType instrumentType = getInstrumentType();
                y.a(true, instrumentType);
                EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "change-asset_chose-option-type").setParameters(i.ZZ().l("instrument_type", instrumentType).aab()).build());
            }
            ay(view);
            agJ();
        }
    }

    private void agJ() {
        if (isAdded()) {
            FragmentManager childFragmentManager = getChildFragmentManager();
            if (a(ActiveType.CRYPTO_ACTIVE, ActiveType.FOREX_ACTIVE, ActiveType.COMMODITY_ACTIVE, ActiveType.STOCK_ACTIVE, ActiveType.ETF_ACTIVE, ActiveType.INDEX_ACTIVE, ActiveType.BOND_ACTIVE)) {
                com.iqoption.protrader.active.a.a(requireActivity(), childFragmentManager, R.id.activeProTraderFragment, getActiveType());
            } else {
                com.iqoption.protrader.active.a.h(childFragmentManager);
            }
        }
    }

    private void aB(@NonNull View view) {
        Drawable background = view.getBackground();
        if (background instanceof LayerDrawable) {
            ((AnimationDrawable) ((LayerDrawable) background).getDrawable(1)).stop();
        }
        if (view.getId() == R.id.fxType) {
            view.setBackgroundColor(getColor(R.color.grey_blur_10_with_bg_second_level));
        } else {
            view.setBackgroundResource(R.drawable.option_type_bg);
        }
    }

    private void hy(String str) {
        if (!com.iqoption.tutorial.c.q(requireFragmentManager()) && com.iqoption.fragment.dialog.whatsnew.a.y(requireContext(), str)) {
            com.iqoption.core.d.a.aSe.postDelayed(new q(this, str), 400);
        }
    }

    final /* synthetic */ void hz(String str) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            com.iqoption.fragment.dialog.whatsnew.a.b(requireActivity(), fragmentManager, str);
        }
    }

    private void agK() {
        h ams = com.iqoption.fragment.localeasset.a.ams();
        requireFragmentManager().beginTransaction().add(R.id.fragment, ams.bf(requireContext()), ams.getName()).addToBackStack(ams.getName()).commitAllowingStateLoss();
    }

    /* JADX WARNING: Missing block: B:9:0x0058, code:
            if (r1 != false) goto L_0x005a;
     */
    /* JADX WARNING: Missing block: B:10:0x005a, code:
            r10 = 2;
     */
    /* JADX WARNING: Missing block: B:15:0x006c, code:
            if (com.iqoption.app.helpers.a.FI().i(com.iqoption.core.data.model.InstrumentType.CFD_INSTRUMENT) != false) goto L_0x005a;
     */
    /* JADX WARNING: Missing block: B:16:0x006f, code:
            r10 = 1;
     */
    /* JADX WARNING: Missing block: B:18:0x007f, code:
            if (r9.cns.bkk.getNextView().getId() != com.iqoption.x.R.id.cfdSortContainer) goto L_0x0083;
     */
    /* JADX WARNING: Missing block: B:19:0x0081, code:
            r1 = 1;
     */
    /* JADX WARNING: Missing block: B:20:0x0083, code:
            r1 = null;
     */
    /* JADX WARNING: Missing block: B:21:0x0084, code:
            r7 = r9.cns.bje;
     */
    /* JADX WARNING: Missing block: B:22:0x0088, code:
            if (r10 != 2) goto L_0x008e;
     */
    /* JADX WARNING: Missing block: B:23:0x008a, code:
            r8 = com.iqoption.x.R.string.volume;
     */
    /* JADX WARNING: Missing block: B:24:0x008e, code:
            r8 = com.iqoption.x.R.string.assets;
     */
    /* JADX WARNING: Missing block: B:25:0x0091, code:
            r7.setText(r8);
     */
    /* JADX WARNING: Missing block: B:26:0x0094, code:
            switch(r10) {
                case 0: goto L_0x011d;
                case 1: goto L_0x010e;
                case 2: goto L_0x00e7;
                case 3: goto L_0x00c0;
                case 4: goto L_0x0099;
                default: goto L_0x0097;
            };
     */
    /* JADX WARNING: Missing block: B:27:0x0099, code:
            r9.cns.bkk.setVisibility(0);
            r9.cns.bkn.setVisibility(4);
            r9.cns.bjM.setVisibility(4);
     */
    /* JADX WARNING: Missing block: B:28:0x00ae, code:
            if (r1 == null) goto L_0x00b7;
     */
    /* JADX WARNING: Missing block: B:29:0x00b0, code:
            r9.cns.bkk.showNext();
     */
    /* JADX WARNING: Missing block: B:30:0x00b7, code:
            if (r0 == 0) goto L_0x00bd;
     */
    /* JADX WARNING: Missing block: B:31:0x00b9, code:
            if (r0 == 3) goto L_0x00bd;
     */
    /* JADX WARNING: Missing block: B:32:0x00bb, code:
            if (r0 != 4) goto L_0x0132;
     */
    /* JADX WARNING: Missing block: B:33:0x00bd, code:
            r0 = 5;
     */
    /* JADX WARNING: Missing block: B:34:0x00c0, code:
            r9.cns.bkk.setVisibility(0);
            r9.cns.bkn.setVisibility(0);
            r9.cns.bjM.setVisibility(0);
     */
    /* JADX WARNING: Missing block: B:35:0x00d5, code:
            if (r1 == null) goto L_0x00de;
     */
    /* JADX WARNING: Missing block: B:36:0x00d7, code:
            r9.cns.bkk.showNext();
     */
    /* JADX WARNING: Missing block: B:37:0x00de, code:
            if (r0 == 0) goto L_0x00e4;
     */
    /* JADX WARNING: Missing block: B:38:0x00e0, code:
            if (r0 == 3) goto L_0x00e4;
     */
    /* JADX WARNING: Missing block: B:39:0x00e2, code:
            if (r0 != 4) goto L_0x0132;
     */
    /* JADX WARNING: Missing block: B:40:0x00e4, code:
            r0 = 11;
     */
    /* JADX WARNING: Missing block: B:41:0x00e7, code:
            r9.cns.bkk.setVisibility(0);
            r9.cns.bkn.setVisibility(0);
            r9.cns.bjM.setVisibility(0);
     */
    /* JADX WARNING: Missing block: B:42:0x00fc, code:
            if (r1 == null) goto L_0x0105;
     */
    /* JADX WARNING: Missing block: B:43:0x00fe, code:
            r9.cns.bkk.showNext();
     */
    /* JADX WARNING: Missing block: B:44:0x0105, code:
            if (r0 == 0) goto L_0x010b;
     */
    /* JADX WARNING: Missing block: B:45:0x0107, code:
            if (r0 == 3) goto L_0x010b;
     */
    /* JADX WARNING: Missing block: B:46:0x0109, code:
            if (r0 != 4) goto L_0x0132;
     */
    /* JADX WARNING: Missing block: B:47:0x010b, code:
            r0 = 9;
     */
    /* JADX WARNING: Missing block: B:48:0x010e, code:
            r9.cns.bkk.setVisibility(8);
     */
    /* JADX WARNING: Missing block: B:49:0x0117, code:
            if (r0 == 0) goto L_0x011b;
     */
    /* JADX WARNING: Missing block: B:50:0x0119, code:
            if (r0 <= 2) goto L_0x0132;
     */
    /* JADX WARNING: Missing block: B:51:0x011b, code:
            r0 = 1;
     */
    /* JADX WARNING: Missing block: B:52:0x011d, code:
            r9.cns.bkk.setVisibility(0);
     */
    /* JADX WARNING: Missing block: B:53:0x0124, code:
            if (r1 != null) goto L_0x012d;
     */
    /* JADX WARNING: Missing block: B:54:0x0126, code:
            r9.cns.bkk.showNext();
     */
    /* JADX WARNING: Missing block: B:55:0x012d, code:
            if (r0 == 0) goto L_0x0131;
     */
    /* JADX WARNING: Missing block: B:56:0x012f, code:
            if (r0 <= 4) goto L_0x0132;
     */
    /* JADX WARNING: Missing block: B:57:0x0131, code:
            r0 = 3;
     */
    /* JADX WARNING: Missing block: B:58:0x0132, code:
            r9.cns.bjf.setSwitched(false);
            r9.cns.bjB.setSwitched(false);
            r9.cns.bkm.setSwitched(false);
            r9.cns.bjU.setSwitched(false);
            r9.cns.bjL.setSwitched(false);
     */
    /* JADX WARNING: Missing block: B:59:0x0155, code:
            switch(r0) {
                case 1: goto L_0x0203;
                case 2: goto L_0x01f4;
                case 3: goto L_0x01e5;
                case 4: goto L_0x01d6;
                case 5: goto L_0x01c7;
                case 6: goto L_0x01b8;
                case 7: goto L_0x01a9;
                case 8: goto L_0x019a;
                case 9: goto L_0x018a;
                case 10: goto L_0x017a;
                case 11: goto L_0x016a;
                case 12: goto L_0x015a;
                default: goto L_0x0158;
            };
     */
    /* JADX WARNING: Missing block: B:60:0x015a, code:
            r9.cns.bjL.setSwitched(true);
            r9.cns.bjL.setReverse(true);
     */
    /* JADX WARNING: Missing block: B:61:0x016a, code:
            r9.cns.bjL.setSwitched(true);
            r9.cns.bjL.setReverse(false);
     */
    /* JADX WARNING: Missing block: B:62:0x017a, code:
            r9.cns.bjf.setSwitched(true);
            r9.cns.bjf.setReverse(true);
     */
    /* JADX WARNING: Missing block: B:63:0x018a, code:
            r9.cns.bjf.setSwitched(true);
            r9.cns.bjf.setReverse(false);
     */
    /* JADX WARNING: Missing block: B:64:0x019a, code:
            r9.cns.bkm.setSwitched(true);
            r9.cns.bkm.setReverse(true);
     */
    /* JADX WARNING: Missing block: B:65:0x01a9, code:
            r9.cns.bkm.setSwitched(true);
            r9.cns.bkm.setReverse(false);
     */
    /* JADX WARNING: Missing block: B:66:0x01b8, code:
            r9.cns.bjB.setSwitched(true);
            r9.cns.bjB.setReverse(true);
     */
    /* JADX WARNING: Missing block: B:67:0x01c7, code:
            r9.cns.bjB.setSwitched(true);
            r9.cns.bjB.setReverse(false);
     */
    /* JADX WARNING: Missing block: B:68:0x01d6, code:
            r9.cns.bjU.setSwitched(true);
            r9.cns.bjU.setReverse(true);
     */
    /* JADX WARNING: Missing block: B:69:0x01e5, code:
            r9.cns.bjU.setSwitched(true);
            r9.cns.bjU.setReverse(false);
     */
    /* JADX WARNING: Missing block: B:70:0x01f4, code:
            r9.cns.bjf.setSwitched(true);
            r9.cns.bjf.setReverse(true);
     */
    /* JADX WARNING: Missing block: B:71:0x0203, code:
            r9.cns.bjf.setSwitched(true);
            r9.cns.bjf.setReverse(false);
     */
    /* JADX WARNING: Missing block: B:72:0x0211, code:
            r9.cnp.f(r0, false);
     */
    /* JADX WARNING: Missing block: B:73:0x0216, code:
            return;
     */
    private void d(com.iqoption.fragment.ac r10) {
        /*
        r9 = this;
        if (r10 == 0) goto L_0x0217;
    L_0x0002:
        r0 = r10.aha();
        r1 = com.iqoption.fragment.TabType.MORE_TAB;
        if (r0 != r1) goto L_0x000c;
    L_0x000a:
        goto L_0x0217;
    L_0x000c:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "asset_sort_type_";
        r0.append(r1);
        r1 = r9.agS();
        r0.append(r1);
        r0 = r0.toString();
        r0 = com.iqoption.app.af.getInt(r0);
        r1 = com.iqoption.fragment.a.AnonymousClass4.afM;
        r2 = r10.aha();
        r2 = r2.ordinal();
        r1 = r1[r2];
        r2 = 2;
        r3 = 3;
        r4 = 4;
        r5 = 0;
        r6 = 1;
        switch(r1) {
            case 1: goto L_0x0062;
            case 2: goto L_0x003a;
            default: goto L_0x0039;
        };
    L_0x0039:
        goto L_0x006f;
    L_0x003a:
        r10 = (com.iqoption.fragment.be) r10;
        r10 = r10.getActiveType();
        r1 = com.iqoption.app.helpers.a.FI();
        r1 = r1.b(r10);
        r7 = com.iqoption.fragment.a.AnonymousClass4.afL;
        r10 = r10.ordinal();
        r10 = r7[r10];
        switch(r10) {
            case 1: goto L_0x0060;
            case 2: goto L_0x0060;
            case 3: goto L_0x005c;
            case 4: goto L_0x005c;
            case 5: goto L_0x0058;
            case 6: goto L_0x0058;
            case 7: goto L_0x0058;
            case 8: goto L_0x0058;
            case 9: goto L_0x0058;
            case 10: goto L_0x0058;
            case 11: goto L_0x0054;
            default: goto L_0x0053;
        };
    L_0x0053:
        goto L_0x006f;
    L_0x0054:
        if (r1 == 0) goto L_0x006f;
    L_0x0056:
        r10 = 3;
        goto L_0x0070;
    L_0x0058:
        if (r1 == 0) goto L_0x006f;
    L_0x005a:
        r10 = 2;
        goto L_0x0070;
    L_0x005c:
        if (r1 == 0) goto L_0x006f;
    L_0x005e:
        r10 = 4;
        goto L_0x0070;
    L_0x0060:
        r10 = 0;
        goto L_0x0070;
    L_0x0062:
        r10 = com.iqoption.app.helpers.a.FI();
        r1 = com.iqoption.core.data.model.InstrumentType.CFD_INSTRUMENT;
        r10 = r10.i(r1);
        if (r10 == 0) goto L_0x006f;
    L_0x006e:
        goto L_0x005a;
    L_0x006f:
        r10 = 1;
    L_0x0070:
        r1 = r9.cns;
        r1 = r1.bkk;
        r1 = r1.getNextView();
        r1 = r1.getId();
        r7 = 2131362266; // 0x7f0a01da float:1.8344308E38 double:1.0530328745E-314;
        if (r1 != r7) goto L_0x0083;
    L_0x0081:
        r1 = 1;
        goto L_0x0084;
    L_0x0083:
        r1 = 0;
    L_0x0084:
        r7 = r9.cns;
        r7 = r7.bje;
        if (r10 != r2) goto L_0x008e;
    L_0x008a:
        r8 = 2131822711; // 0x7f110877 float:1.9278201E38 double:1.0532603645E-314;
        goto L_0x0091;
    L_0x008e:
        r8 = 2131820691; // 0x7f110093 float:1.9274104E38 double:1.0532593665E-314;
    L_0x0091:
        r7.setText(r8);
        switch(r10) {
            case 0: goto L_0x011d;
            case 1: goto L_0x010e;
            case 2: goto L_0x00e7;
            case 3: goto L_0x00c0;
            case 4: goto L_0x0099;
            default: goto L_0x0097;
        };
    L_0x0097:
        goto L_0x0132;
    L_0x0099:
        r10 = r9.cns;
        r10 = r10.bkk;
        r10.setVisibility(r5);
        r10 = r9.cns;
        r10 = r10.bkn;
        r10.setVisibility(r4);
        r10 = r9.cns;
        r10 = r10.bjM;
        r10.setVisibility(r4);
        if (r1 == 0) goto L_0x00b7;
    L_0x00b0:
        r10 = r9.cns;
        r10 = r10.bkk;
        r10.showNext();
    L_0x00b7:
        if (r0 == 0) goto L_0x00bd;
    L_0x00b9:
        if (r0 == r3) goto L_0x00bd;
    L_0x00bb:
        if (r0 != r4) goto L_0x0132;
    L_0x00bd:
        r0 = 5;
        goto L_0x0132;
    L_0x00c0:
        r10 = r9.cns;
        r10 = r10.bkk;
        r10.setVisibility(r5);
        r10 = r9.cns;
        r10 = r10.bkn;
        r10.setVisibility(r5);
        r10 = r9.cns;
        r10 = r10.bjM;
        r10.setVisibility(r5);
        if (r1 == 0) goto L_0x00de;
    L_0x00d7:
        r10 = r9.cns;
        r10 = r10.bkk;
        r10.showNext();
    L_0x00de:
        if (r0 == 0) goto L_0x00e4;
    L_0x00e0:
        if (r0 == r3) goto L_0x00e4;
    L_0x00e2:
        if (r0 != r4) goto L_0x0132;
    L_0x00e4:
        r0 = 11;
        goto L_0x0132;
    L_0x00e7:
        r10 = r9.cns;
        r10 = r10.bkk;
        r10.setVisibility(r5);
        r10 = r9.cns;
        r10 = r10.bkn;
        r10.setVisibility(r5);
        r10 = r9.cns;
        r10 = r10.bjM;
        r10.setVisibility(r5);
        if (r1 == 0) goto L_0x0105;
    L_0x00fe:
        r10 = r9.cns;
        r10 = r10.bkk;
        r10.showNext();
    L_0x0105:
        if (r0 == 0) goto L_0x010b;
    L_0x0107:
        if (r0 == r3) goto L_0x010b;
    L_0x0109:
        if (r0 != r4) goto L_0x0132;
    L_0x010b:
        r0 = 9;
        goto L_0x0132;
    L_0x010e:
        r10 = r9.cns;
        r10 = r10.bkk;
        r1 = 8;
        r10.setVisibility(r1);
        if (r0 == 0) goto L_0x011b;
    L_0x0119:
        if (r0 <= r2) goto L_0x0132;
    L_0x011b:
        r0 = 1;
        goto L_0x0132;
    L_0x011d:
        r10 = r9.cns;
        r10 = r10.bkk;
        r10.setVisibility(r5);
        if (r1 != 0) goto L_0x012d;
    L_0x0126:
        r10 = r9.cns;
        r10 = r10.bkk;
        r10.showNext();
    L_0x012d:
        if (r0 == 0) goto L_0x0131;
    L_0x012f:
        if (r0 <= r4) goto L_0x0132;
    L_0x0131:
        r0 = 3;
    L_0x0132:
        r10 = r9.cns;
        r10 = r10.bjf;
        r10.setSwitched(r5);
        r10 = r9.cns;
        r10 = r10.bjB;
        r10.setSwitched(r5);
        r10 = r9.cns;
        r10 = r10.bkm;
        r10.setSwitched(r5);
        r10 = r9.cns;
        r10 = r10.bjU;
        r10.setSwitched(r5);
        r10 = r9.cns;
        r10 = r10.bjL;
        r10.setSwitched(r5);
        switch(r0) {
            case 1: goto L_0x0203;
            case 2: goto L_0x01f4;
            case 3: goto L_0x01e5;
            case 4: goto L_0x01d6;
            case 5: goto L_0x01c7;
            case 6: goto L_0x01b8;
            case 7: goto L_0x01a9;
            case 8: goto L_0x019a;
            case 9: goto L_0x018a;
            case 10: goto L_0x017a;
            case 11: goto L_0x016a;
            case 12: goto L_0x015a;
            default: goto L_0x0158;
        };
    L_0x0158:
        goto L_0x0211;
    L_0x015a:
        r10 = r9.cns;
        r10 = r10.bjL;
        r10.setSwitched(r6);
        r10 = r9.cns;
        r10 = r10.bjL;
        r10.setReverse(r6);
        goto L_0x0211;
    L_0x016a:
        r10 = r9.cns;
        r10 = r10.bjL;
        r10.setSwitched(r6);
        r10 = r9.cns;
        r10 = r10.bjL;
        r10.setReverse(r5);
        goto L_0x0211;
    L_0x017a:
        r10 = r9.cns;
        r10 = r10.bjf;
        r10.setSwitched(r6);
        r10 = r9.cns;
        r10 = r10.bjf;
        r10.setReverse(r6);
        goto L_0x0211;
    L_0x018a:
        r10 = r9.cns;
        r10 = r10.bjf;
        r10.setSwitched(r6);
        r10 = r9.cns;
        r10 = r10.bjf;
        r10.setReverse(r5);
        goto L_0x0211;
    L_0x019a:
        r10 = r9.cns;
        r10 = r10.bkm;
        r10.setSwitched(r6);
        r10 = r9.cns;
        r10 = r10.bkm;
        r10.setReverse(r6);
        goto L_0x0211;
    L_0x01a9:
        r10 = r9.cns;
        r10 = r10.bkm;
        r10.setSwitched(r6);
        r10 = r9.cns;
        r10 = r10.bkm;
        r10.setReverse(r5);
        goto L_0x0211;
    L_0x01b8:
        r10 = r9.cns;
        r10 = r10.bjB;
        r10.setSwitched(r6);
        r10 = r9.cns;
        r10 = r10.bjB;
        r10.setReverse(r6);
        goto L_0x0211;
    L_0x01c7:
        r10 = r9.cns;
        r10 = r10.bjB;
        r10.setSwitched(r6);
        r10 = r9.cns;
        r10 = r10.bjB;
        r10.setReverse(r5);
        goto L_0x0211;
    L_0x01d6:
        r10 = r9.cns;
        r10 = r10.bjU;
        r10.setSwitched(r6);
        r10 = r9.cns;
        r10 = r10.bjU;
        r10.setReverse(r6);
        goto L_0x0211;
    L_0x01e5:
        r10 = r9.cns;
        r10 = r10.bjU;
        r10.setSwitched(r6);
        r10 = r9.cns;
        r10 = r10.bjU;
        r10.setReverse(r5);
        goto L_0x0211;
    L_0x01f4:
        r10 = r9.cns;
        r10 = r10.bjf;
        r10.setSwitched(r6);
        r10 = r9.cns;
        r10 = r10.bjf;
        r10.setReverse(r6);
        goto L_0x0211;
    L_0x0203:
        r10 = r9.cns;
        r10 = r10.bjf;
        r10.setSwitched(r6);
        r10 = r9.cns;
        r10 = r10.bjf;
        r10.setReverse(r5);
    L_0x0211:
        r10 = r9.cnp;
        r10.f(r0, r5);
        return;
    L_0x0217:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.fragment.a.d(com.iqoption.fragment.ac):void");
    }

    private void agL() {
        if (this.cns.bjI.isSelected()) {
            this.cns.bjI.setSelected(false);
            this.cns.bjX.setVisibility(8);
            am.a(getContext(), this.cns.bjX);
            return;
        }
        this.cns.bjI.setSelected(true);
        this.cns.bjX.setVisibility(0);
        this.cns.bjX.postDelayed(new r(this), 100);
    }

    final /* synthetic */ void agT() {
        if (isAdded()) {
            this.cns.bjX.requestFocus();
            this.cns.bjX.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, 0.0f, 0.0f, 0));
            this.cns.bjX.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 1, 0.0f, 0.0f, 0));
        }
    }

    public void agM() {
        if (isAdded() && this.cnp != null && agQ()) {
            this.cnp.b(this.cnq);
            com.iqoption.app.helpers.a.FI().k(getInstrumentType());
            y.a(true, getInstrumentType());
        }
    }

    private void agN() {
        if (isAdded() && this.cnp != null) {
            this.cnp.c(this.cnq);
        }
    }

    private void F(InstrumentType instrumentType) {
        if (isAdded() && this.cnp != null && this.cnq != null) {
            this.cnp.c(this.cnq);
        }
    }

    @Nullable
    private View a(ac acVar, boolean z) {
        return a(acVar, z, false);
    }

    @android.support.annotation.Nullable
    private android.view.View a(com.iqoption.fragment.ac r7, boolean r8, boolean r9) {
        /*
        r6 = this;
        r0 = 0;
        if (r7 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = com.iqoption.fragment.a.AnonymousClass4.afM;
        r2 = r7.aha();
        r2 = r2.ordinal();
        r1 = r1[r2];
        switch(r1) {
            case 1: goto L_0x008b;
            case 2: goto L_0x001f;
            case 3: goto L_0x0015;
            default: goto L_0x0013;
        };
    L_0x0013:
        goto L_0x0094;
    L_0x0015:
        r7 = r6.cns;
        r0 = r7.bjS;
        r7 = r6.cns;
        r7 = r7.bki;
        goto L_0x0095;
    L_0x001f:
        r1 = com.iqoption.fragment.a.AnonymousClass4.afL;
        r7 = (com.iqoption.fragment.be) r7;
        r7 = r7.getActiveType();
        r7 = r7.ordinal();
        r7 = r1[r7];
        switch(r7) {
            case 1: goto L_0x0082;
            case 2: goto L_0x0082;
            case 3: goto L_0x0079;
            case 4: goto L_0x0070;
            case 5: goto L_0x0067;
            case 6: goto L_0x005e;
            case 7: goto L_0x0055;
            case 8: goto L_0x004c;
            case 9: goto L_0x0043;
            case 10: goto L_0x003a;
            case 11: goto L_0x0031;
            default: goto L_0x0030;
        };
    L_0x0030:
        goto L_0x0094;
    L_0x0031:
        r7 = r6.cns;
        r0 = r7.bjz;
        r7 = r6.cns;
        r7 = r7.bkb;
        goto L_0x0095;
    L_0x003a:
        r7 = r6.cns;
        r0 = r7.bjG;
        r7 = r6.cns;
        r7 = r7.bke;
        goto L_0x0095;
    L_0x0043:
        r7 = r6.cns;
        r0 = r7.bjE;
        r7 = r6.cns;
        r7 = r7.bkd;
        goto L_0x0095;
    L_0x004c:
        r7 = r6.cns;
        r0 = r7.bko;
        r7 = r6.cns;
        r7 = r7.bkj;
        goto L_0x0095;
    L_0x0055:
        r7 = r6.cns;
        r0 = r7.bjk;
        r7 = r6.cns;
        r7 = r7.bka;
        goto L_0x0095;
    L_0x005e:
        r7 = r6.cns;
        r0 = r7.bjJ;
        r7 = r6.cns;
        r7 = r7.bkg;
        goto L_0x0095;
    L_0x0067:
        r7 = r6.cns;
        r0 = r7.bji;
        r7 = r6.cns;
        r7 = r7.bjZ;
        goto L_0x0095;
    L_0x0070:
        r7 = r6.cns;
        r0 = r7.bjH;
        r7 = r6.cns;
        r7 = r7.bkf;
        goto L_0x0095;
    L_0x0079:
        r7 = r6.cns;
        r0 = r7.bjD;
        r7 = r6.cns;
        r7 = r7.bkc;
        goto L_0x0095;
    L_0x0082:
        r7 = r6.cns;
        r0 = r7.bjh;
        r7 = r6.cns;
        r7 = r7.bjY;
        goto L_0x0095;
    L_0x008b:
        r7 = r6.cns;
        r0 = r7.bjP;
        r7 = r6.cns;
        r7 = r7.bkh;
        goto L_0x0095;
    L_0x0094:
        r7 = r0;
    L_0x0095:
        r1 = 1;
        r2 = 0;
        if (r0 == 0) goto L_0x00a2;
    L_0x0099:
        r3 = r0.isSelected();
        if (r3 == r8) goto L_0x00a0;
    L_0x009f:
        goto L_0x00a2;
    L_0x00a0:
        r3 = 0;
        goto L_0x00a3;
    L_0x00a2:
        r3 = 1;
    L_0x00a3:
        if (r3 == 0) goto L_0x00de;
    L_0x00a5:
        if (r0 == 0) goto L_0x00aa;
    L_0x00a7:
        r0.setSelected(r8);
    L_0x00aa:
        if (r7 == 0) goto L_0x00de;
    L_0x00ac:
        r3 = r6.getLineHeight();
        r4 = new com.iqoption.view.a.a.b;
        r4.<init>(r7);
        r7 = 2;
        r7 = new int[r7];
        if (r8 == 0) goto L_0x00bc;
    L_0x00ba:
        r5 = 0;
        goto L_0x00bd;
    L_0x00bc:
        r5 = r3;
    L_0x00bd:
        r7[r2] = r5;
        if (r8 == 0) goto L_0x00c2;
    L_0x00c1:
        r2 = r3;
    L_0x00c2:
        r7[r1] = r2;
        r7 = android.animation.ValueAnimator.ofInt(r7);
        r7.addUpdateListener(r4);
        if (r9 == 0) goto L_0x00d0;
    L_0x00cd:
        r8 = 0;
        goto L_0x00d2;
    L_0x00d0:
        r8 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
    L_0x00d2:
        r8 = r7.setDuration(r8);
        r9 = com.iqoption.view.a.a.d.dEM;
        r8.setInterpolator(r9);
        r7.start();
    L_0x00de:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.fragment.a.a(com.iqoption.fragment.ac, boolean, boolean):android.view.View");
    }

    private int getLineHeight() {
        if (this.cnz == 0) {
            this.cnz = ef(R.dimen.dp46);
        }
        return this.cnz;
    }

    private boolean zR() {
        FragmentManager fragmentManager = getFragmentManager();
        return fragmentManager != null && fragmentManager.findFragmentById(R.id.fragment) == this;
    }

    private void a(com.iqoption.tutorial.dictionary.b bVar) {
        this.cns.bjF.setOnClickListener(null);
        com.iqoption.tutorial.c.a(requireFragmentManager(), R.id.other_fragment, bVar, this);
    }

    private void agO() {
        if (this.aeq.aFx() && !this.aeq.c(TutorialAction.CHOOSE_INSTRUMENT)) {
            this.cns.biZ.setVisibility(8);
            this.aeq.a(this.cnw);
        }
        AnimatorListener anonymousClass2 = new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                for (Pair pair : a.this.cny) {
                    a.this.k((View) pair.first, ((Integer) pair.second).intValue());
                }
                a.this.cny.clear();
                a.this.agM();
                a.this.agJ();
            }
        };
        if (ax.dws) {
            int ef = ef(R.dimen.dp12);
            float f = (float) (-ef(R.dimen.dp6));
            this.cns.bkD.setTranslationX(f);
            this.cns.bkD.setTranslationY(f);
            this.cns.bkD.setAlpha(0.0f);
            this.cns.biZ.setTranslationX(f);
            this.cns.biZ.setTranslationY(f);
            this.cns.biZ.setAlpha(0.0f);
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(this.cns.bjl, ef, ef, (float) ef, (float) Math.hypot((double) this.cns.bjl.getWidth(), (double) this.cns.bjl.getHeight()));
            createCircularReveal.setDuration(400).setInterpolator(com.iqoption.view.a.a.d.dEM);
            ScrollView scrollView = this.cns.bkD;
            r6 = new PropertyValuesHolder[3];
            r6[0] = PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{0.0f});
            r6[1] = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{0.0f});
            r6[2] = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{1.0f});
            Animator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(scrollView, r6);
            ofPropertyValuesHolder.setDuration(300).setInterpolator(com.iqoption.view.a.a.d.dEM);
            ConstraintLayout constraintLayout = this.cns.biZ;
            r5 = new PropertyValuesHolder[3];
            r5[0] = PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{0.0f});
            r5[1] = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{0.0f});
            r5[2] = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{1.0f});
            Animator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(constraintLayout, r5);
            ofPropertyValuesHolder2.setDuration(300).setInterpolator(com.iqoption.view.a.a.d.dEM);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(createCircularReveal);
            animatorSet.play(ofPropertyValuesHolder2).with(ofPropertyValuesHolder).after(100);
            animatorSet.addListener(anonymousClass2);
            animatorSet.start();
        } else {
            float f2 = (float) (-ef(R.dimen.dp12));
            this.cns.bjl.setTranslationX(f2);
            this.cns.bjl.setTranslationY(f2);
            this.cns.bjl.setPivotX(1.0f);
            this.cns.bjl.setPivotY(1.0f);
            this.cns.bjl.setScaleX(0.3f);
            this.cns.bjl.setScaleY(0.3f);
            this.cns.bjl.animate().alpha(1.0f).scaleY(1.0f).scaleX(1.0f).translationX(0.0f).translationY(0.0f).setDuration(NF()).setListener(anonymousClass2).setInterpolator(com.iqoption.view.a.a.d.dEM).start();
        }
        this.cns.bjF.setAlpha(0.0f);
        this.cns.bjF.animate().alpha(1.0f);
    }

    public void onStart() {
        super.onStart();
        this.cnt.register();
    }

    public void onStop() {
        super.onStop();
        if (agQ()) {
            y.a(false, getInstrumentType());
        }
        this.cnt.unregister();
        if (this.cnp != null) {
            this.cnp.AG();
        }
    }

    public boolean onClose() {
        if (ajV().zN()) {
            am.a(getContext(), this.cns.bjX);
        } else {
            requireFragmentManager().popBackStack();
            IQApp.Dn().aE(new d(false, this.cnr));
        }
        this.aeq.b(this.cnw);
        this.aeq.b(this.cnx);
        return true;
    }

    public void ND() {
        agO();
    }

    public void NE() {
        int ef = ef(R.dimen.dp12);
        this.cns.bjl.setPivotX(1.0f);
        this.cns.bjl.setPivotY(1.0f);
        this.cns.bjl.animate().setDuration(NG()).translationY((float) (-ef)).scaleX(0.9f).scaleY(0.6f).alpha(0.0f).setInterpolator(com.iqoption.view.a.a.d.dEM).start();
        this.cns.bjF.animate().alpha(0.0f);
    }

    public void a(@NonNull TutorialAction tutorialAction) {
        ViewGroup viewGroup = this.cns.biZ;
        final boolean z = tutorialAction == TutorialAction.CHOOSE_INSTRUMENT;
        if (z) {
            viewGroup.setVisibility(0);
            viewGroup.setAlpha(0.0f);
        }
        viewGroup.animate().alpha(1.0f).setListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                if (z) {
                    a.this.agP();
                }
                a.this.cns.bjF.setOnClickListener(a.this.cnu);
            }
        });
    }

    private void agP() {
        this.aeq.b(this.cnw);
        this.aeq.a(this.cnx);
    }

    private void k(View view, @DrawableRes int i) {
        o.a(com.iqoption.core.d.a.aSc.c(new a(i)), new b(view), com.iqoption.core.d.a.aSe);
    }

    private boolean agQ() {
        return this.cnq != null && (this.cnq instanceof be);
    }

    @Nullable
    private InstrumentType getInstrumentType() {
        if (this.cnq instanceof be) {
            return ((be) this.cnq).getInstrumentType();
        }
        return this.cnq instanceof ck ? InstrumentType.CFD_INSTRUMENT : null;
    }

    private boolean a(ActiveType... activeTypeArr) {
        return a(this.cnq, activeTypeArr);
    }

    @Nullable
    private ActiveType getActiveType() {
        return this.cnq instanceof be ? ((be) this.cnq).getActiveType() : null;
    }

    private String agR() {
        if (this.cnq instanceof be) {
            return ((be) this.cnq).getInstrumentType().getServerValue();
        }
        return this.cnq.aha().name();
    }

    private String agS() {
        InstrumentType instrumentType = getInstrumentType();
        ActiveType activeType = getActiveType();
        if (instrumentType != null) {
            return instrumentType.toString();
        }
        if (activeType != null) {
            return activeType.toString();
        }
        return TabType.MORE_TAB.name();
    }

    private static boolean a(ac acVar, ActiveType... activeTypeArr) {
        if (acVar == null || !(acVar instanceof be)) {
            return false;
        }
        ActiveType activeType = ((be) acVar).getActiveType();
        for (ActiveType activeType2 : activeTypeArr) {
            if (activeType2 == activeType) {
                return true;
            }
        }
        return false;
    }
}
