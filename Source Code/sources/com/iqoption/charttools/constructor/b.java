package com.iqoption.charttools.constructor;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalFocusChangeListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.iqoption.core.util.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0002#$B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000f\u001a\u00020\u0010H\u0002J&\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0010H\u0016J\b\u0010\u001a\u001a\u00020\u0010H\u0016J\b\u0010\u001b\u001a\u00020\u0010H\u0016J\u0010\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\"H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000¨\u0006%"}, aXE = {"Lcom/iqoption/charttools/constructor/IndicatorSettingsFragment;", "Lcom/iqoption/core/ui/fragment/IQFragment;", "Lcom/iqoption/charttools/constructor/InputItemsAdapter$Callbacks;", "()V", "binding", "Lcom/iqoption/charttools/databinding/FragmentIndicatorSettingsBinding;", "inputData", "Lcom/iqoption/charttools/constructor/IndicatorSettingsInputData;", "getInputData", "()Lcom/iqoption/charttools/constructor/IndicatorSettingsInputData;", "isCustomAnimationsEnabled", "", "()Z", "viewModel", "Lcom/iqoption/charttools/constructor/IndicatorSettingsViewModel;", "eatFocus", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onEnterAnimation", "onExitAnimation", "onItemHostRequest", "item", "Lcom/iqoption/charttools/constructor/InputHost;", "onItemSelectRequest", "Lcom/iqoption/charttools/constructor/InputSelect;", "onItemToggled", "Lcom/iqoption/charttools/constructor/InputGroupTitle;", "Companion", "Navigator", "techtools_release"})
/* compiled from: IndicatorSettingsFragment.kt */
public final class b extends com.iqoption.core.ui.fragment.b implements com.iqoption.charttools.constructor.o.a {
    public static final String TAG = "com.iqoption.charttools.constructor.b";
    public static final a aty = new a();
    private IndicatorSettingsViewModel atw;
    private com.iqoption.charttools.b.a atx;
    private HashMap atz;

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\n \u0007*\u0004\u0018\u00010\u00040\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, aXE = {"Lcom/iqoption/charttools/constructor/IndicatorSettingsFragment$Companion;", "", "()V", "ARG_INPUT_DATA", "", "ARG_NAVIGATOR", "TAG", "kotlin.jvm.PlatformType", "makeArgs", "Landroid/os/Bundle;", "inputData", "Lcom/iqoption/charttools/constructor/IndicatorSettingsInputData;", "newInstance", "Lcom/iqoption/charttools/constructor/IndicatorSettingsFragment;", "techtools_release"})
    /* compiled from: IndicatorSettingsFragment.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final b a(c cVar) {
            kotlin.jvm.internal.h.e(cVar, "inputData");
            b bVar = new b();
            bVar.setArguments(b.aty.b(cVar));
            return bVar;
        }

        public final Bundle b(c cVar) {
            kotlin.jvm.internal.h.e(cVar, "inputData");
            Bundle bundle = new Bundle();
            bundle.putParcelable("arg.inputData", cVar);
            return bundle;
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "newFocus", "onGlobalFocusChanged"})
    /* compiled from: IndicatorSettingsFragment.kt */
    static final class f implements OnGlobalFocusChangeListener {
        public static final f atD = new f();

        f() {
        }

        public final void onGlobalFocusChanged(View view, View view2) {
            if (view2 != null && !(view2 instanceof EditText)) {
                j.a(view2.getContext(), view2);
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\n¸\u0006\u0000"}, aXE = {"com/iqoption/charttools/constructor/IndicatorSettingsFragment$onCreateView$1$clickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "outputViewModel", "Lcom/iqoption/charttools/constructor/IndicatorOutputViewModel;", "getOutputViewModel", "()Lcom/iqoption/charttools/constructor/IndicatorOutputViewModel;", "onDelayClick", "", "v", "Landroid/view/View;", "techtools_release"})
    /* compiled from: IndicatorSettingsFragment.kt */
    public static final class b extends com.iqoption.core.ext.g {
        private final IndicatorOutputViewModel atA = IndicatorOutputViewModel.atv.d(com.iqoption.core.ext.a.n(this.atB));
        final /* synthetic */ b atB;
        final /* synthetic */ b atC;

        b(b bVar, b bVar2) {
            this.atB = bVar;
            this.atC = bVar2;
            super(0, 1, null);
        }

        public void q(View view) {
            kotlin.jvm.internal.h.e(view, "v");
            int id = view.getId();
            if (id == com.iqoption.charttools.o.g.outside || id == com.iqoption.charttools.o.g.btnBack) {
                this.atB.back();
            } else if (id == com.iqoption.charttools.o.g.btnRestore) {
                b.a(this.atB).KV();
            } else if (id == com.iqoption.charttools.o.g.btnApply) {
                b.a(this.atB).a(this.atA);
                this.atB.back();
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, aXE = {"<anonymous>", "", "title", "", "onChanged", "com/iqoption/charttools/constructor/IndicatorSettingsFragment$onCreateView$1$2"})
    /* compiled from: IndicatorSettingsFragment.kt */
    static final class c<T> implements Observer<String> {
        final /* synthetic */ b atB;
        final /* synthetic */ b atC;

        c(b bVar, b bVar2) {
            this.atB = bVar;
            this.atC = bVar2;
        }

        /* renamed from: fz */
        public final void onChanged(String str) {
            if (str != null) {
                TextView textView = b.b(this.atB).agA;
                kotlin.jvm.internal.h.d(textView, "binding.title");
                textView.setText(str);
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "isOpened", "", "onChanged", "(Ljava/lang/Boolean;)V", "com/iqoption/charttools/constructor/IndicatorSettingsFragment$onCreateView$1$4"})
    /* compiled from: IndicatorSettingsFragment.kt */
    static final class d<T> implements Observer<Boolean> {
        final /* synthetic */ b atB;
        final /* synthetic */ b atC;

        d(b bVar, b bVar2) {
            this.atB = bVar;
            this.atC = bVar2;
        }

        /* renamed from: k */
        public final void onChanged(Boolean bool) {
            if (bool != null) {
                kotlin.jvm.internal.h.d(bool, "it");
                if (!bool.booleanValue()) {
                    Fragment findFragmentByTag = com.iqoption.core.ext.a.q(this.atB).findFragmentByTag(t.auM.Ll());
                    if (!(findFragmentByTag instanceof t)) {
                        findFragmentByTag = null;
                    }
                    t tVar = (t) findFragmentByTag;
                    if (tVar != null) {
                        FragmentManager q = com.iqoption.core.ext.a.q(this.atB);
                        FragmentTransaction beginTransaction = q.beginTransaction();
                        kotlin.jvm.internal.h.d(beginTransaction, "ft");
                        beginTransaction.remove(tVar);
                        beginTransaction.commitAllowingStateLoss();
                        q.executePendingTransactions();
                    }
                } else if (com.iqoption.core.ext.a.q(this.atB).findFragmentByTag(t.auM.Ll()) == null) {
                    FragmentManager q2 = com.iqoption.core.ext.a.q(this.atB);
                    FragmentTransaction beginTransaction2 = q2.beginTransaction();
                    kotlin.jvm.internal.h.d(beginTransaction2, "ft");
                    beginTransaction2.add(com.iqoption.charttools.o.g.content, new t(), t.auM.Ll());
                    beginTransaction2.commitAllowingStateLoss();
                    q2.executePendingTransactions();
                }
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "isOpened", "", "onChanged", "(Ljava/lang/Boolean;)V", "com/iqoption/charttools/constructor/IndicatorSettingsFragment$onCreateView$1$5"})
    /* compiled from: IndicatorSettingsFragment.kt */
    static final class e<T> implements Observer<Boolean> {
        final /* synthetic */ b atB;
        final /* synthetic */ b atC;

        e(b bVar, b bVar2) {
            this.atB = bVar;
            this.atC = bVar2;
        }

        /* renamed from: k */
        public final void onChanged(Boolean bool) {
            if (bool != null) {
                kotlin.jvm.internal.h.d(bool, "it");
                if (!bool.booleanValue()) {
                    Fragment findFragmentByTag = com.iqoption.core.ext.a.q(this.atB).findFragmentByTag(n.aux.Ll());
                    if (!(findFragmentByTag instanceof n)) {
                        findFragmentByTag = null;
                    }
                    n nVar = (n) findFragmentByTag;
                    if (nVar != null) {
                        FragmentManager q = com.iqoption.core.ext.a.q(this.atB);
                        FragmentTransaction beginTransaction = q.beginTransaction();
                        kotlin.jvm.internal.h.d(beginTransaction, "ft");
                        beginTransaction.remove(nVar);
                        beginTransaction.commitAllowingStateLoss();
                        q.executePendingTransactions();
                    }
                } else if (com.iqoption.core.ext.a.q(this.atB).findFragmentByTag(n.aux.Ll()) == null) {
                    FragmentManager q2 = com.iqoption.core.ext.a.q(this.atB);
                    FragmentTransaction beginTransaction2 = q2.beginTransaction();
                    kotlin.jvm.internal.h.d(beginTransaction2, "ft");
                    beginTransaction2.add(com.iqoption.charttools.o.g.content, new n(), n.aux.Ll());
                    beginTransaction2.commitAllowingStateLoss();
                    q2.executePendingTransactions();
                }
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "items", "", "Lcom/iqoption/charttools/constructor/InputAdapterItem;", "onChanged"})
    /* compiled from: IndicatorSettingsFragment.kt */
    static final class g<T> implements Observer<List<? extends d>> {
        final /* synthetic */ o atE;

        g(o oVar) {
            this.atE = oVar;
        }

        /* renamed from: L */
        public final void onChanged(List<? extends d> list) {
            if (list != null) {
                com.iqoption.core.ui.widget.recyclerview.adapter.a aVar = this.atE;
                kotlin.jvm.internal.h.d(list, "it");
                com.iqoption.core.ui.widget.recyclerview.adapter.a.a(aVar, list, null, 2, null);
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, aXE = {"<anonymous>", "", "isEnabled", "", "onChanged", "(Ljava/lang/Boolean;)V"})
    /* compiled from: IndicatorSettingsFragment.kt */
    static final class h<T> implements Observer<Boolean> {
        final /* synthetic */ com.iqoption.charttools.b.a atF;

        h(com.iqoption.charttools.b.a aVar) {
            this.atF = aVar;
        }

        /* renamed from: k */
        public final void onChanged(Boolean bool) {
            if (bool != null) {
                TextView textView = this.atF.awO;
                kotlin.jvm.internal.h.d(textView, "btnRestore");
                kotlin.jvm.internal.h.d(bool, "it");
                textView.setEnabled(bool.booleanValue());
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, aXE = {"<anonymous>", "", "isEnabled", "", "onChanged", "(Ljava/lang/Boolean;)V"})
    /* compiled from: IndicatorSettingsFragment.kt */
    static final class i<T> implements Observer<Boolean> {
        final /* synthetic */ com.iqoption.charttools.b.a atF;

        i(com.iqoption.charttools.b.a aVar) {
            this.atF = aVar;
        }

        /* renamed from: k */
        public final void onChanged(Boolean bool) {
            if (bool != null) {
                TextView textView = this.atF.awM;
                kotlin.jvm.internal.h.d(textView, "btnApply");
                kotlin.jvm.internal.h.d(bool, "it");
                textView.setEnabled(bool.booleanValue());
            }
        }
    }

    public boolean KE() {
        return true;
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

    public static final /* synthetic */ com.iqoption.charttools.b.a b(b bVar) {
        com.iqoption.charttools.b.a aVar = bVar.atx;
        if (aVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        return aVar;
    }

    private final c KC() {
        Parcelable parcelable = com.iqoption.core.ext.a.o(this).getParcelable("arg.inputData");
        if (parcelable == null) {
            kotlin.jvm.internal.h.aXZ();
        }
        return (c) parcelable;
    }

    public void a(l lVar) {
        kotlin.jvm.internal.h.e(lVar, "item");
        KD();
        IndicatorSettingsViewModel indicatorSettingsViewModel = this.atw;
        if (indicatorSettingsViewModel == null) {
            kotlin.jvm.internal.h.lS("viewModel");
        }
        indicatorSettingsViewModel.b(lVar);
    }

    public void a(s sVar) {
        kotlin.jvm.internal.h.e(sVar, "item");
        KD();
        InputSelectViewModel g = InputSelectViewModel.auQ.g(this);
        IndicatorSettingsViewModel indicatorSettingsViewModel = this.atw;
        if (indicatorSettingsViewModel == null) {
            kotlin.jvm.internal.h.lS("viewModel");
        }
        g.a(indicatorSettingsViewModel, sVar);
        IndicatorSettingsViewModel indicatorSettingsViewModel2 = this.atw;
        if (indicatorSettingsViewModel2 == null) {
            kotlin.jvm.internal.h.lS("viewModel");
        }
        indicatorSettingsViewModel2.KR();
    }

    public void a(m mVar) {
        kotlin.jvm.internal.h.e(mVar, "item");
        KD();
        InputHostViewModel f = InputHostViewModel.auD.f(this);
        IndicatorSettingsViewModel indicatorSettingsViewModel = this.atw;
        if (indicatorSettingsViewModel == null) {
            kotlin.jvm.internal.h.lS("viewModel");
        }
        f.a(indicatorSettingsViewModel, mVar);
        IndicatorSettingsViewModel indicatorSettingsViewModel2 = this.atw;
        if (indicatorSettingsViewModel2 == null) {
            kotlin.jvm.internal.h.lS("viewModel");
        }
        indicatorSettingsViewModel2.KT();
    }

    private final void KD() {
        com.iqoption.charttools.b.a aVar = this.atx;
        if (aVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        aVar.agA.requestFocus();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.h.e(layoutInflater, "inflater");
        this.atx = (com.iqoption.charttools.b.a) com.iqoption.core.ext.a.a(layoutInflater, com.iqoption.charttools.o.h.fragment_indicator_settings, viewGroup, false, 4, null);
        b bVar = this;
        com.iqoption.charttools.b.a aVar = this.atx;
        if (aVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        o oVar = new o(bVar);
        RecyclerView recyclerView = aVar.awR;
        kotlin.jvm.internal.h.d(recyclerView, "inputList");
        recyclerView.setAdapter(oVar);
        aVar.awR.addItemDecoration(new p(oVar));
        aVar.awR.addOnScrollListener(new q());
        recyclerView = aVar.awR;
        kotlin.jvm.internal.h.d(recyclerView, "inputList");
        LayoutManager layoutManager = recyclerView.getLayoutManager();
        kotlin.jvm.internal.h.d(layoutManager, "inputList.layoutManager");
        layoutManager.setItemPrefetchEnabled(false);
        View view = aVar.awQ;
        kotlin.jvm.internal.h.d(view, com.google.firebase.analytics.FirebaseAnalytics.b.CONTENT);
        view.getViewTreeObserver().addOnGlobalFocusChangeListener(f.atD);
        b bVar2 = new b(this, bVar);
        FrameLayout frameLayout = aVar.awS;
        if (frameLayout != null) {
            frameLayout.setOnClickListener(bVar2);
        }
        OnClickListener onClickListener = bVar2;
        aVar.awN.setOnClickListener(onClickListener);
        aVar.awO.setOnClickListener(onClickListener);
        aVar.awM.setOnClickListener(onClickListener);
        this.atw = IndicatorSettingsViewModel.aua.a(bVar, KC());
        IndicatorSettingsViewModel indicatorSettingsViewModel = this.atw;
        if (indicatorSettingsViewModel == null) {
            kotlin.jvm.internal.h.lS("viewModel");
        }
        LifecycleOwner lifecycleOwner = bVar;
        indicatorSettingsViewModel.KL().observe(lifecycleOwner, new c(this, bVar));
        indicatorSettingsViewModel = this.atw;
        if (indicatorSettingsViewModel == null) {
            kotlin.jvm.internal.h.lS("viewModel");
        }
        indicatorSettingsViewModel.KM().observe(lifecycleOwner, new g(oVar));
        IndicatorSettingsViewModel indicatorSettingsViewModel2 = this.atw;
        if (indicatorSettingsViewModel2 == null) {
            kotlin.jvm.internal.h.lS("viewModel");
        }
        indicatorSettingsViewModel2.KP().observe(lifecycleOwner, new d(this, bVar));
        indicatorSettingsViewModel2 = this.atw;
        if (indicatorSettingsViewModel2 == null) {
            kotlin.jvm.internal.h.lS("viewModel");
        }
        indicatorSettingsViewModel2.KQ().observe(lifecycleOwner, new e(this, bVar));
        IndicatorSettingsViewModel indicatorSettingsViewModel3 = this.atw;
        if (indicatorSettingsViewModel3 == null) {
            kotlin.jvm.internal.h.lS("viewModel");
        }
        indicatorSettingsViewModel3.KN().observe(lifecycleOwner, new h(aVar));
        indicatorSettingsViewModel3 = this.atw;
        if (indicatorSettingsViewModel3 == null) {
            kotlin.jvm.internal.h.lS("viewModel");
        }
        indicatorSettingsViewModel3.KO().observe(lifecycleOwner, new i(aVar));
        com.iqoption.charttools.b.a aVar2 = this.atx;
        if (aVar2 == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        return aVar2.getRoot();
    }

    public void onDestroyView() {
        super.onDestroyView();
        j.n(zzakw());
        KH();
    }

    public void KF() {
        ObjectAnimator ofFloat;
        super.KF();
        AnimatorSet animatorSet = new AnimatorSet();
        com.iqoption.core.ext.a.a((Animator) animatorSet, Yw());
        animatorSet.setInterpolator(com.iqoption.core.graphics.animation.i.TI());
        List arrayList = new ArrayList();
        com.iqoption.charttools.b.a aVar = this.atx;
        if (aVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        if (aVar.awS != null) {
            aVar = this.atx;
            if (aVar == null) {
                kotlin.jvm.internal.h.lS("binding");
            }
            ofFloat = ObjectAnimator.ofFloat(aVar.awS, View.ALPHA, new float[]{0.0f, 1.0f});
            kotlin.jvm.internal.h.d(ofFloat, "ObjectAnimator.ofFloat(b…side, View.ALPHA, 0f, 1f)");
            arrayList.add(ofFloat);
        }
        aVar = this.atx;
        if (aVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        ofFloat = ObjectAnimator.ofPropertyValuesHolder(aVar.awQ, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f, 1.0f}), PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{1.15f, 1.0f}), PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{1.15f, 1.0f})});
        kotlin.jvm.internal.h.d(ofFloat, "ObjectAnimator.ofPropert…View.SCALE_Y, 1.15f, 1f))");
        arrayList.add(ofFloat);
        animatorSet.playTogether(arrayList);
        animatorSet.start();
    }

    public void KG() {
        ObjectAnimator ofFloat;
        super.KG();
        AnimatorSet animatorSet = new AnimatorSet();
        com.iqoption.core.ext.a.a((Animator) animatorSet, Yx());
        animatorSet.setInterpolator(com.iqoption.core.graphics.animation.i.TI());
        List arrayList = new ArrayList();
        com.iqoption.charttools.b.a aVar = this.atx;
        if (aVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        if (aVar.awS != null) {
            aVar = this.atx;
            if (aVar == null) {
                kotlin.jvm.internal.h.lS("binding");
            }
            ofFloat = ObjectAnimator.ofFloat(aVar.awS, View.ALPHA, new float[]{0.0f});
            kotlin.jvm.internal.h.d(ofFloat, "ObjectAnimator.ofFloat(b….outside, View.ALPHA, 0f)");
            arrayList.add(ofFloat);
        }
        aVar = this.atx;
        if (aVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        View view = aVar.awQ;
        r6 = new PropertyValuesHolder[3];
        r6[0] = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f});
        r6[1] = PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{1.15f});
        r6[2] = PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{1.15f});
        ofFloat = ObjectAnimator.ofPropertyValuesHolder(view, r6);
        kotlin.jvm.internal.h.d(ofFloat, "ObjectAnimator.ofPropert…oat(View.SCALE_Y, 1.15f))");
        arrayList.add(ofFloat);
        animatorSet.playTogether(arrayList);
        animatorSet.start();
    }
}
