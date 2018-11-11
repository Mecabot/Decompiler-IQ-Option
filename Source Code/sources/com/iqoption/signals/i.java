package com.iqoption.signals;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.android.gms.plus.PlusShare;
import com.google.common.base.f;
import com.iqoption.analytics.EventManager;
import com.iqoption.core.ext.g;
import com.iqoption.d.sf;
import com.iqoption.dto.Event;
import com.iqoption.dto.Event.Builder;
import com.iqoption.fragment.leftpanel.LeftPanelViewModel;
import com.iqoption.fragment.leftpanel.b.e;
import com.iqoption.x.R;
import java.util.HashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;

@kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000¨\u0006\u001a"}, aXE = {"Lcom/iqoption/signals/SignalsFragment;", "Lcom/iqoption/core/ui/fragment/IQFragment;", "()V", "binding", "Lcom/iqoption/databinding/FragmentSignalsBinding;", "filtersWindow", "Lcom/iqoption/widget/window/OptionsWindow;", "getFiltersWindow", "()Lcom/iqoption/widget/window/OptionsWindow;", "filtersWindow$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/iqoption/signals/SignalsViewModel;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "showSignal", "", "signalItem", "Lcom/iqoption/signals/SignalItem;", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: SignalsFragment.kt */
public final class i extends com.iqoption.core.ui.fragment.b {
    private static final String TAG = "com.iqoption.signals.i";
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(i.class), "filtersWindow", "getFiltersWindow()Lcom/iqoption/widget/window/OptionsWindow;"))};
    public static final c drr = new c();
    private HashMap atz;
    private sf dro;
    private SignalsViewModel drp;
    private final kotlin.d drq = g.f(new SignalsFragment$filtersWindow$2(this));

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tR\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, aXE = {"Lcom/iqoption/signals/SignalsFragment$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "newInstance", "Lcom/iqoption/signals/SignalsFragment;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: SignalsFragment.kt */
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(f fVar) {
            this();
        }

        public final String Ll() {
            return i.TAG;
        }

        public final i aEd() {
            return new i();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$setOnDelayedClickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "core_release"})
    /* compiled from: AndroidExtensions.kt */
    public static final class a extends g {
        final /* synthetic */ kotlin.jvm.a.b aPd;

        public a(kotlin.jvm.a.b bVar) {
            this.aPd = bVar;
            super(0, 1, null);
        }

        public void q(View view) {
            h.e(view, "v");
            this.aPd.invoke(view);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$setOnDelayedClickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "core_release"})
    /* compiled from: AndroidExtensions.kt */
    public static final class b extends g {
        final /* synthetic */ kotlin.jvm.a.b aPd;

        public b(kotlin.jvm.a.b bVar) {
            this.aPd = bVar;
            super(0, 1, null);
        }

        public void q(View view) {
            h.e(view, "v");
            this.aPd.invoke(view);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/signals/SignalsViewState;", "onChanged", "com/iqoption/signals/SignalsFragment$onCreateView$1$1"})
    /* compiled from: SignalsFragment.kt */
    static final class d<T> implements Observer<l> {
        final /* synthetic */ h dru;
        final /* synthetic */ sf receiver$0;
        final /* synthetic */ i this$0;

        d(sf sfVar, h hVar, i iVar) {
            this.receiver$0 = sfVar;
            this.dru = hVar;
            this.this$0 = iVar;
        }

        /* renamed from: a */
        public final void onChanged(l lVar) {
            if (lVar != null) {
                int i;
                TextView textView = this.receiver$0.bAZ;
                h.d(textView, "filter");
                i iVar = this.this$0;
                switch (lVar.aEg()) {
                    case ALL:
                        i = R.string.all_signals;
                        break;
                    case GAP:
                        i = R.string.gap;
                        break;
                    case SHARP_JUMP:
                        i = R.string.sharp_jump_drop;
                        break;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
                textView.setText(iVar.getString(i));
                this.dru.setItems(lVar.getItems());
            }
        }
    }

    private final com.iqoption.widget.a.a aEc() {
        kotlin.d dVar = this.drq;
        j jVar = apP[0];
        return (com.iqoption.widget.a.a) dVar.getValue();
    }

    public void KH() {
        if (this.atz != null) {
            this.atz.clear();
        }
    }

    public View dj(int i) {
        if (this.atz == null) {
            this.atz = new HashMap();
        }
        View view = (View) this.atz.get(Integer.valueOf(i));
        if (view == null) {
            view = getView();
            if (view == null) {
                return null;
            }
            view = view.findViewById(i);
            this.atz.put(Integer.valueOf(i), view);
        }
        return view;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        KH();
    }

    public static final /* synthetic */ SignalsViewModel b(i iVar) {
        SignalsViewModel signalsViewModel = iVar.drp;
        if (signalsViewModel == null) {
            h.lS("viewModel");
        }
        return signalsViewModel;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.e(layoutInflater, "inflater");
        this.dro = (sf) com.iqoption.core.ext.a.a((Fragment) this, (int) R.layout.fragment_signals, viewGroup, false, 4, null);
        SignalsViewModel A = SignalsViewModel.dry.A(com.iqoption.core.ext.a.n(this));
        h.d(A, "SignalsViewModel.get(act)");
        this.drp = A;
        sf sfVar = this.dro;
        if (sfVar == null) {
            h.lS("binding");
        }
        kotlin.jvm.a.b signalsFragment$onCreateView$$inlined$apply$lambda$1 = new SignalsFragment$onCreateView$$inlined$apply$lambda$1(sfVar, this);
        TextView textView = sfVar.agA;
        h.d(textView, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
        textView.setOnClickListener(new a(signalsFragment$onCreateView$$inlined$apply$lambda$1));
        textView = sfVar.bAZ;
        h.d(textView, "filter");
        textView.setOnClickListener(new b(signalsFragment$onCreateView$$inlined$apply$lambda$1));
        h hVar = new h(new SignalsFragment$onCreateView$$inlined$apply$lambda$2(this));
        sfVar.bCa.setHasFixedSize(true);
        RecyclerView recyclerView = sfVar.bCa;
        h.d(recyclerView, "signalList");
        recyclerView.setAdapter(hVar);
        SignalsViewModel signalsViewModel = this.drp;
        if (signalsViewModel == null) {
            h.lS("viewModel");
        }
        signalsViewModel.Qs().observe(this, new d(sfVar, hVar, this));
        A = this.drp;
        if (A == null) {
            h.lS("viewModel");
        }
        A.reload();
        sfVar = this.dro;
        if (sfVar == null) {
            h.lS("binding");
        }
        return sfVar.getRoot();
    }

    private final void c(c cVar) {
        com.iqoption.core.microservices.pricemovements.a.a aEa = cVar.aEa();
        com.iqoption.core.microservices.tradingengine.response.active.a Jg = cVar.Jg();
        com.iqoption.app.managers.tab.a.Il().d(aEa.getActiveId(), Jg.getInstrumentType());
        String s = com.iqoption.util.e.a.s(Jg);
        String type = cVar.getType();
        String value = cVar.getValue();
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, f.equal(Integer.valueOf(aEa.getType()), Integer.valueOf(10)) ? "signals_show-signal-move-now" : "signals_show-signal-today").setValue(Double.valueOf((double) aEa.getId())).setParameters(com.iqoption.core.util.i.ZZ().l(Param.TYPE, Integer.valueOf(aEa.getType())).l("created", Long.valueOf(aEa.Vs())).l("active_id", Integer.valueOf(aEa.getActiveId())).l("start_time", Long.valueOf(aEa.getStartTime())).l("finish_time", Long.valueOf(aEa.Wv())).l("start_value", Double.valueOf(aEa.Ww())).l("finish_value", Double.valueOf(aEa.Wx())).l("isHigh", Boolean.valueOf(aEa.Wz())).aab()).build());
        com.iqoption.gl.b.aow().glchTabShowSignal(0, aEa.getActiveId(), aEa.getStartTime(), aEa.Wv(), aEa.Ww(), aEa.Wx(), s, type, value, true, aEa.getId(), Jg.getInstrumentType().getOptionActiveOrInstrumentValue());
        EventManager Bm = EventManager.Bm();
        Builder Builder = Event.Builder(Event.CATEGORY_POPUP_SERVED, "left-bar_new-tab-signals-history");
        com.iqoption.app.managers.tab.a Il = com.iqoption.app.managers.tab.a.Il();
        h.d(Il, "TabHelper.instance()");
        Bm.a(Builder.setValue(Double.valueOf((double) Il.IG())).setParameters(com.iqoption.core.util.i.ZZ().l("instrument_type", Jg.getInstrumentType().getServerValue()).aab()).build());
        LeftPanelViewModel.cEc.l(com.iqoption.core.ext.a.n(this)).d(e.cDR);
    }
}
