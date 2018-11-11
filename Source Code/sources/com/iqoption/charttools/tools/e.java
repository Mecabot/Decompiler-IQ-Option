package com.iqoption.charttools.tools;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.os.Bundle;
import android.support.transition.Transition;
import android.support.transition.TransitionManager;
import android.support.transition.TransitionSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.iqoption.charttools.model.indicator.k;
import com.iqoption.charttools.model.indicator.l;
import com.iqoption.charttools.model.indicator.m;
import com.iqoption.charttools.model.indicator.n;
import com.iqoption.charttools.model.indicator.o;
import com.iqoption.charttools.model.indicator.p;
import com.iqoption.charttools.model.indicator.q;
import com.iqoption.charttools.model.indicator.r;
import com.iqoption.charttools.model.indicator.x;
import com.iqoption.d.sl;
import com.iqoption.fragment.cr;
import com.iqoption.templates.TemplateActivity;
import com.iqoption.traderoom.TradeRoomViewModel;
import com.iqoption.x.R;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 ]2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001]B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020,H\u0002J\u0010\u00109\u001a\u0002052\u0006\u00108\u001a\u00020,H\u0002J\u0018\u0010:\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00182\b\u0010;\u001a\u0004\u0018\u00010\u0017H\u0002J\b\u0010<\u001a\u00020=H\u0016J\u0014\u0010>\u001a\u0004\u0018\u00010,2\b\u0010;\u001a\u0004\u0018\u00010\u0017H\u0002J\b\u0010?\u001a\u00020=H\u0016J\u0014\u0010@\u001a\u0004\u0018\u00010A2\b\u0010;\u001a\u0004\u0018\u00010\u0017H\u0002J\b\u0010B\u001a\u00020\u001fH\u0016J\u0012\u0010C\u001a\u0002052\b\u0010D\u001a\u0004\u0018\u00010EH\u0016J&\u0010F\u001a\u0004\u0018\u00010,2\u0006\u0010G\u001a\u00020H2\b\u0010I\u001a\u0004\u0018\u00010%2\b\u0010D\u001a\u0004\u0018\u00010EH\u0016J\b\u0010J\u001a\u000205H\u0016J\u0010\u0010K\u001a\u0002052\u0006\u0010L\u001a\u00020MH\u0002J\u0010\u0010N\u001a\u0002052\u0006\u0010O\u001a\u00020PH\u0016J\u0010\u0010N\u001a\u0002052\u0006\u0010Q\u001a\u00020RH\u0016J\b\u0010S\u001a\u000205H\u0016J\u0010\u0010T\u001a\u0002052\u0006\u0010U\u001a\u00020VH\u0016J\u0010\u0010W\u001a\u0002052\u0006\u0010X\u001a\u00020YH\u0016J\b\u0010Z\u001a\u000205H\u0016J\u001a\u0010[\u001a\u0002052\u0006\u00108\u001a\u00020,2\b\u0010D\u001a\u0004\u0018\u00010EH\u0016J\u0012\u0010\\\u001a\u0002052\b\u00108\u001a\u0004\u0018\u00010,H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118VX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u0017\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00180\u0016X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000f\u001a\u0004\b\u001b\u0010\u001cR$\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001f8B@BX\u000e¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001b\u0010$\u001a\u00020%8VX\u0002¢\u0006\f\n\u0004\b(\u0010\u000f\u001a\u0004\b&\u0010'R\u0010\u0010)\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+X.¢\u0006\u0004\n\u0002\u0010-R\u001a\u0010.\u001a\u00020/X.¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u0006^"}, aXE = {"Lcom/iqoption/charttools/tools/ToolsFragment;", "Lcom/iqoption/fragment/base/IQAnimationFragment;", "Lcom/iqoption/charttools/tools/delegate/DelegateContext;", "Lcom/iqoption/charttools/tools/delegate/DelegateContext$Callbacks;", "()V", "binding", "Lcom/iqoption/databinding/FragmentToolsBinding;", "callbacks", "getCallbacks", "()Lcom/iqoption/charttools/tools/delegate/DelegateContext$Callbacks;", "changeTransition", "Landroid/support/transition/TransitionSet;", "getChangeTransition", "()Landroid/support/transition/TransitionSet;", "changeTransition$delegate", "Lkotlin/Lazy;", "commonDecoration", "Lcom/iqoption/widget/SeparatorDecoration;", "getCommonDecoration", "()Lcom/iqoption/widget/SeparatorDecoration;", "commonDecoration$delegate", "contentDelegates", "", "Lcom/iqoption/charttools/tools/ToolsScreen;", "Lcom/iqoption/charttools/tools/delegate/ContentDelegate;", "enterExitTransition", "Lcom/iqoption/charttools/tools/transition/CardPanelTransition;", "getEnterExitTransition", "()Lcom/iqoption/charttools/tools/transition/CardPanelTransition;", "enterExitTransition$delegate", "value", "", "isOpenLibrary", "()Z", "setOpenLibrary", "(Z)V", "parentView", "Landroid/view/ViewGroup;", "getParentView", "()Landroid/view/ViewGroup;", "parentView$delegate", "prevScreen", "sectionViews", "", "Landroid/view/View;", "[Landroid/view/View;", "viewModel", "Lcom/iqoption/charttools/tools/ToolsViewModel;", "getViewModel", "()Lcom/iqoption/charttools/tools/ToolsViewModel;", "setViewModel", "(Lcom/iqoption/charttools/tools/ToolsViewModel;)V", "animateEnter", "", "offset", "", "view", "animateExit", "getContentDelegate", "screen", "getHideAnimationDuration", "", "getSectionView", "getShowAnimationDuration", "getTransition", "Landroid/support/transition/Transition;", "onClose", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "onHideAnimation", "onOpenFigureSettings", "figure", "Lcom/iqoption/charttools/model/indicator/Figure;", "onOpenIndicatorSettings", "indicator", "Lcom/iqoption/charttools/model/indicator/ChartIndicator;", "meta", "Lcom/iqoption/charttools/model/indicator/MetaIndicator;", "onOpenTemplateActivity", "onOpenTemplateSettings", "templateItem", "Lcom/iqoption/charttools/tools/data/TemplateItem;", "onOpenVideoPlayer", "videoUrl", "", "onShowAnimation", "onViewCreated", "selectSection", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: ToolsFragment.kt */
public final class e extends com.iqoption.fragment.base.b implements com.iqoption.charttools.tools.delegate.c, com.iqoption.charttools.tools.delegate.c.a {
    private static final String TAG = "com.iqoption.charttools.tools.e";
    public static final a aAK = new a();
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(e.class), "commonDecoration", "getCommonDecoration()Lcom/iqoption/widget/SeparatorDecoration;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(e.class), "parentView", "getParentView()Landroid/view/ViewGroup;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(e.class), "enterExitTransition", "getEnterExitTransition()Lcom/iqoption/charttools/tools/transition/CardPanelTransition;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(e.class), "changeTransition", "getChangeTransition()Landroid/support/transition/TransitionSet;"))};
    public ToolsViewModel aAA;
    private sl aAB;
    private final kotlin.d aAC = g.f(new ToolsFragment$commonDecoration$2(this));
    private final kotlin.d aAD = g.f(new ToolsFragment$parentView$2(this));
    private final com.iqoption.charttools.tools.delegate.c.a aAE = this;
    private final kotlin.d aAF = g.f(ToolsFragment$enterExitTransition$2.aAM);
    private final kotlin.d aAG = g.f(ToolsFragment$changeTransition$2.aAL);
    private View[] aAH;
    private final Map<ToolsScreen, com.iqoption.charttools.tools.delegate.b<?>> aAI = new LinkedHashMap();
    private ToolsScreen aAJ;
    private HashMap atz;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u0019\u0010\u0007\u001a\n \b*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, aXE = {"Lcom/iqoption/charttools/tools/ToolsFragment$Companion;", "", "()V", "ARG_OPEN_LIBRARY", "", "DURATION", "", "TAG", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "newInstance", "Lcom/iqoption/charttools/tools/ToolsFragment;", "openLibrary", "", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ToolsFragment.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final String Ll() {
            return e.TAG;
        }

        public final e bZ(boolean z) {
            e eVar = new e();
            Bundle bundle = new Bundle();
            bundle.putBoolean("arg.openLibrary", z);
            eVar.setArguments(bundle);
            return eVar;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, aXE = {"com/iqoption/charttools/tools/ToolsFragment$onCreateView$1$clickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ToolsFragment.kt */
    public static final class b extends com.iqoption.core.ext.g {
        final /* synthetic */ e this$0;

        b(e eVar) {
            this.this$0 = eVar;
            super(0, 1, null);
        }

        public void q(View view) {
            h.e(view, "v");
            switch (view.getId()) {
                case R.id.activesTools:
                    this.this$0.Nv().e(ToolsScreen.ACTIVE_TOOLS);
                    return;
                case R.id.everything:
                    this.this$0.onClose();
                    return;
                case R.id.fibonacciArcButton:
                    this.this$0.c((k) l.ayq);
                    return;
                case R.id.fibonacciLinesButton:
                    this.this$0.c((k) m.ayr);
                    return;
                case R.id.fibonacciSpiralButton:
                    this.this$0.c((k) n.ays);
                    return;
                case R.id.horizontalLineButton:
                    this.this$0.c((k) o.ayt);
                    return;
                case R.id.indicators:
                    this.this$0.Nv().e(ToolsScreen.INDICATORS);
                    return;
                case R.id.lineButton:
                    this.this$0.c((k) p.ayu);
                    return;
                case R.id.otherSettingsTools:
                    this.this$0.Nv().e(ToolsScreen.SETTINGS);
                    return;
                case R.id.templatesTools:
                    d.aAz.Ns();
                    this.this$0.Nv().e(ToolsScreen.TEMPLATES);
                    return;
                case R.id.trendLineButton:
                    this.this$0.c((k) q.ayv);
                    return;
                case R.id.verticalLineButton:
                    this.this$0.c((k) r.ayw);
                    return;
                default:
                    return;
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "screen", "Lcom/iqoption/charttools/tools/ToolsScreen;", "onChanged"})
    /* compiled from: ToolsFragment.kt */
    static final class c<T> implements Observer<ToolsScreen> {
        final /* synthetic */ e this$0;

        c(e eVar) {
            this.this$0 = eVar;
        }

        /* renamed from: d */
        public final void onChanged(ToolsScreen toolsScreen) {
            sl a = e.a(this.this$0);
            this.this$0.B(this.this$0.a(toolsScreen));
            com.iqoption.charttools.tools.delegate.b b = this.this$0.b(toolsScreen);
            Transition c = this.this$0.c(toolsScreen);
            if (c != null) {
                TransitionManager.beginDelayedTransition(e.a(this.this$0).bDc, c);
            }
            this.this$0.Ny().removeAllViews();
            if (b != null) {
                if (this.this$0.Ny().getParent() == null) {
                    a.bDc.addView(this.this$0.Ny());
                }
                this.this$0.Ny().addView(b.getContentView());
            } else {
                a.bDc.removeView(this.this$0.Ny());
            }
            this.this$0.aAJ = toolsScreen;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, aXE = {"<anonymous>", "", "count", "", "onChanged", "(Ljava/lang/Integer;)V"})
    /* compiled from: ToolsFragment.kt */
    static final class d<T> implements Observer<Integer> {
        final /* synthetic */ e this$0;

        d(e eVar) {
            this.this$0 = eVar;
        }

        /* renamed from: b */
        public final void onChanged(Integer num) {
            if (num != null) {
                TextView textView = e.a(this.this$0).bDa;
                h.d(textView, "binding.activesToolsCount");
                textView.setText(h.compare(num.intValue(), 0) > 0 ? String.valueOf(num.intValue()) : "");
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, aXE = {"<anonymous>", "", "count", "", "onChanged", "(Ljava/lang/Integer;)V"})
    /* compiled from: ToolsFragment.kt */
    static final class e<T> implements Observer<Integer> {
        final /* synthetic */ e this$0;

        e(e eVar) {
            this.this$0 = eVar;
        }

        /* renamed from: b */
        public final void onChanged(Integer num) {
            if (num != null) {
                TextView textView = e.a(this.this$0).bCY;
                h.d(textView, "binding.activeTemplatesToolsCount");
                textView.setText(h.compare(num.intValue(), 0) > 0 ? String.valueOf(num.intValue()) : "");
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, aXE = {"<anonymous>", "", "isDisabled", "", "onChanged", "(Ljava/lang/Boolean;)V"})
    /* compiled from: ToolsFragment.kt */
    static final class f<T> implements Observer<Boolean> {
        final /* synthetic */ e this$0;

        f(e eVar) {
            this.this$0 = eVar;
        }

        /* renamed from: k */
        public final void onChanged(Boolean bool) {
            if (bool != null) {
                LinearLayout linearLayout = e.a(this.this$0).bCZ;
                h.d(linearLayout, "binding.activesTools");
                com.iqoption.core.ext.a.a((ViewGroup) linearLayout, bool.booleanValue() ^ 1);
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "event", "Lcom/iqoption/charttools/tools/Event;", "onChanged"})
    /* compiled from: ToolsFragment.kt */
    static final class g<T> implements Observer<a> {
        public static final g aAN = new g();

        g() {
        }

        /* renamed from: a */
        public final void onChanged(a aVar) {
            if (aVar instanceof b) {
                com.iqoption.app.a.b.eQ(((b) aVar).MY());
            }
        }
    }

    private final com.iqoption.charttools.tools.b.a NB() {
        kotlin.d dVar = this.aAF;
        j jVar = apP[2];
        return (com.iqoption.charttools.tools.b.a) dVar.getValue();
    }

    private final TransitionSet NC() {
        kotlin.d dVar = this.aAG;
        j jVar = apP[3];
        return (TransitionSet) dVar.getValue();
    }

    public void KH() {
        if (this.atz != null) {
            this.atz.clear();
        }
    }

    public long NF() {
        return 250;
    }

    public long NG() {
        return 250;
    }

    /* renamed from: Nw */
    public com.iqoption.widget.e Nx() {
        kotlin.d dVar = this.aAC;
        j jVar = apP[0];
        return (com.iqoption.widget.e) dVar.getValue();
    }

    public ViewGroup Ny() {
        kotlin.d dVar = this.aAD;
        j jVar = apP[1];
        return (ViewGroup) dVar.getValue();
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        KH();
    }

    private final boolean Nu() {
        return com.iqoption.core.ext.a.o(this).getBoolean("arg.openLibrary");
    }

    private final void bY(boolean z) {
        com.iqoption.core.ext.a.o(this).putBoolean("arg.openLibrary", z);
    }

    public ToolsViewModel Nv() {
        ToolsViewModel toolsViewModel = this.aAA;
        if (toolsViewModel == null) {
            h.lS("viewModel");
        }
        return toolsViewModel;
    }

    public void a(ToolsViewModel toolsViewModel) {
        h.e(toolsViewModel, "<set-?>");
        this.aAA = toolsViewModel;
    }

    public com.iqoption.charttools.tools.delegate.c.a Nz() {
        return this.aAE;
    }

    public void k(com.iqoption.charttools.model.indicator.h hVar) {
        h.e(hVar, "indicator");
        com.iqoption.app.managers.tab.a Il = com.iqoption.app.managers.tab.a.Il();
        h.d(Il, "TabHelper.instance()");
        com.iqoption.app.managers.tab.a.g IC = Il.IC();
        if (IC != null) {
            onClose();
            TradeRoomViewModel B = TradeRoomViewModel.dsq.B(com.iqoption.core.ext.a.n(this));
            String IM = IC.IM();
            h.d(IM, "tab.idString");
            B.d(new com.iqoption.charttools.constructor.c(IM, IC.getActiveId(), hVar, false, 8, null));
        }
    }

    public void d(x xVar) {
        h.e(xVar, "meta");
        com.iqoption.app.managers.tab.a Il = com.iqoption.app.managers.tab.a.Il();
        h.d(Il, "TabHelper.instance()");
        com.iqoption.app.managers.tab.a.g IC = Il.IC();
        if (IC != null) {
            onClose();
            TradeRoomViewModel B = TradeRoomViewModel.dsq.B(com.iqoption.core.ext.a.n(this));
            String IM = IC.IM();
            h.d(IM, "tab.idString");
            B.d(new com.iqoption.charttools.constructor.c(IM, IC.getActiveId(), xVar, null, false, 24, null));
        }
    }

    public void fH(String str) {
        h.e(str, "videoUrl");
        com.iqoption.fragment.base.j.a(com.iqoption.core.ext.a.n(this), com.iqoption.core.ext.a.n(this).getSupportFragmentManager(), str, null, true);
    }

    private final View a(ToolsScreen toolsScreen) {
        if (toolsScreen == null) {
            return null;
        }
        View view;
        sl slVar;
        switch (toolsScreen) {
            case ACTIVE_TOOLS:
                slVar = this.aAB;
                if (slVar == null) {
                    h.lS("binding");
                }
                view = slVar.bCZ;
                break;
            case INDICATORS:
                slVar = this.aAB;
                if (slVar == null) {
                    h.lS("binding");
                }
                view = slVar.bDj;
                break;
            case TEMPLATES:
                slVar = this.aAB;
                if (slVar == null) {
                    h.lS("binding");
                }
                view = slVar.bDo;
                break;
            case SETTINGS:
                slVar = this.aAB;
                if (slVar == null) {
                    h.lS("binding");
                }
                view = slVar.bDm;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return view;
    }

    private final com.iqoption.charttools.tools.delegate.b<?> b(ToolsScreen toolsScreen) {
        if (toolsScreen == null) {
            return null;
        }
        com.iqoption.charttools.tools.delegate.b<?> bVar = (com.iqoption.charttools.tools.delegate.b) this.aAI.get(toolsScreen);
        if (bVar == null) {
            switch (toolsScreen) {
                case ACTIVE_TOOLS:
                    bVar = new com.iqoption.charttools.tools.delegate.a(this);
                    break;
                case INDICATORS:
                    bVar = new com.iqoption.charttools.tools.delegate.d(this);
                    break;
                case TEMPLATES:
                    bVar = new com.iqoption.charttools.tools.delegate.f(this);
                    break;
                case SETTINGS:
                    bVar = new com.iqoption.charttools.tools.delegate.e(this);
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            this.aAI.put(toolsScreen, bVar);
        }
        return bVar;
    }

    private final Transition c(ToolsScreen toolsScreen) {
        if (this.aAJ == null || toolsScreen == null) {
            return NB();
        }
        return NC();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(ToolsViewModel.aBn.h(this));
        if (Nu()) {
            Nv().e(ToolsScreen.INDICATORS);
            bY(false);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.e(layoutInflater, "inflater");
        sl slVar = (sl) com.iqoption.core.ext.a.a(layoutInflater, (int) R.layout.fragment_tools, viewGroup, false, 4, null);
        this.aAB = slVar;
        OnClickListener bVar = new b(this);
        slVar.bDj.setOnClickListener(bVar);
        slVar.bCZ.setOnClickListener(bVar);
        if (com.iqoption.app.managers.feature.a.eX("templates")) {
            LinearLayout linearLayout = slVar.bDo;
            h.d(linearLayout, "templatesTools");
            com.iqoption.core.ext.a.L(linearLayout);
            slVar.bDo.setOnClickListener(bVar);
        }
        slVar.bDm.setOnClickListener(bVar);
        slVar.bDk.setOnClickListener(bVar);
        slVar.bDp.setOnClickListener(bVar);
        slVar.bDi.setOnClickListener(bVar);
        slVar.bDq.setOnClickListener(bVar);
        slVar.bDe.setOnClickListener(bVar);
        slVar.bDd.setOnClickListener(bVar);
        slVar.bDf.setOnClickListener(bVar);
        slVar.bDc.setOnClickListener(bVar);
        View[] viewArr = new View[4];
        LinearLayout linearLayout2 = slVar.bCZ;
        h.d(linearLayout2, "activesTools");
        viewArr[0] = linearLayout2;
        linearLayout2 = slVar.bDj;
        h.d(linearLayout2, "indicators");
        viewArr[1] = linearLayout2;
        linearLayout2 = slVar.bDo;
        h.d(linearLayout2, "templatesTools");
        viewArr[2] = linearLayout2;
        linearLayout2 = slVar.bDm;
        h.d(linearLayout2, "otherSettingsTools");
        viewArr[3] = linearLayout2;
        this.aAH = viewArr;
        return slVar.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        h.e(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        LifecycleOwner lifecycleOwner = this;
        Nv().NL().observe(lifecycleOwner, new c(this));
        Nv().NT().observe(lifecycleOwner, new d(this));
        Nv().NU().observe(lifecycleOwner, new e(this));
        Nv().NS().observe(lifecycleOwner, new f(this));
        Nv().NR().observe(lifecycleOwner, g.aAN);
    }

    private final void B(View view) {
        View[] viewArr = this.aAH;
        if (viewArr == null) {
            h.lS("sectionViews");
        }
        for (View view2 : viewArr) {
            view2.setSelected(h.E(view2, view));
        }
    }

    private final void c(k kVar) {
        cr ajW = ajW();
        if (ajW != null) {
            View view = ajW.crN;
            if (view != null) {
                view.setSelected(false);
            }
        }
        com.iqoption.core.ext.a.p(this).popBackStack();
        com.iqoption.app.managers.tab.a Il = com.iqoption.app.managers.tab.a.Il();
        h.d(Il, "TabHelper.instance()");
        com.iqoption.app.managers.tab.a.g IC = Il.IC();
        if (IC != null) {
            TradeRoomViewModel B = TradeRoomViewModel.dsq.B(com.iqoption.core.ext.a.n(this));
            String IM = IC.IM();
            h.d(IM, "tab.idString");
            B.d(new com.iqoption.charttools.constructor.c(IM, IC.getActiveId(), kVar, null, false, 24, null));
        }
    }

    public boolean onClose() {
        cr ajW = ajW();
        if (ajW != null) {
            View view = ajW.crN;
            if (view != null) {
                view.setSelected(false);
            }
        }
        com.iqoption.core.ext.a.p(this).popBackStack();
        return true;
    }

    public void ND() {
        float eN = eN(R.dimen.dp12);
        sl slVar = this.aAB;
        if (slVar == null) {
            h.lS("binding");
        }
        LinearLayout linearLayout = slVar.aOX;
        h.d(linearLayout, "mainContent");
        a(eN, (View) linearLayout);
        ViewGroup Ny = Ny();
        if (!h.E(Ny.getParent(), slVar.bDc)) {
            Ny = null;
        }
        if (Ny != null) {
            a(eN, (View) Ny);
        }
    }

    private final void a(float f, View view) {
        view.setAlpha(0.0f);
        view.setTranslationX(-f);
        view.setTranslationY(f);
        view.setPivotX(0.0f);
        view.setPivotY((float) view.getMeasuredHeight());
        com.iqoption.core.ext.a.c(view, 0.3f);
        ViewPropertyAnimator animate = view.animate();
        animate.alpha(1.0f);
        animate.translationX(0.0f).translationY(0.0f);
        animate.scaleX(1.0f).scaleY(1.0f);
        animate.setDuration(NF());
        animate.setInterpolator(com.iqoption.core.graphics.animation.i.TI());
        animate.start();
    }

    public void NE() {
        sl slVar = this.aAB;
        if (slVar == null) {
            h.lS("binding");
        }
        LinearLayout linearLayout = slVar.aOX;
        h.d(linearLayout, "mainContent");
        C(linearLayout);
        ViewGroup Ny = Ny();
        if (!h.E(Ny.getParent(), slVar.bDc)) {
            Ny = null;
        }
        if (Ny != null) {
            Ny.setPivotX(0.0f);
            Ny.setPivotY((float) Ny.getMeasuredHeight());
            C(Ny);
        }
    }

    private final void C(View view) {
        ViewPropertyAnimator animate = view.animate();
        animate.alpha(0.0f);
        animate.scaleY(0.7f).scaleX(0.7f);
        animate.setDuration(NG());
        animate.setInterpolator(com.iqoption.core.graphics.animation.i.TI());
        animate.start();
    }

    public void NA() {
        startActivity(new Intent(com.iqoption.core.ext.a.m(this), TemplateActivity.class));
    }

    public void a(com.iqoption.charttools.tools.data.l lVar) {
        h.e(lVar, "templateItem");
        Intent intent = new Intent(com.iqoption.core.ext.a.m(this), TemplateActivity.class);
        Bundle bundle = new Bundle();
        bundle.putLong("extra.templateId", lVar.Oh().getId());
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
