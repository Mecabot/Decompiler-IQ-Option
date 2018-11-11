package com.iqoption.charttools.templates;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.transition.AutoTransition;
import android.support.transition.TransitionManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.SwitchCompat;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.android.gms.plus.PlusShare;
import com.iqoption.charttools.constructor.IndicatorOutputViewModel;
import com.iqoption.charttools.model.chart.ChartColor;
import com.iqoption.charttools.model.chart.ChartType;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.TypeCastException;

@kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0014J&\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\f\u0010\u0015\u001a\u00020\u0016*\u00020\u0017H\u0002J\u001f\u0010\u0018\u001a\u00020\u0016*\b\u0012\u0004\u0012\u00020\u000e0\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002¢\u0006\u0002\u0010\u001cJ3\u0010\u001d\u001a\u00020\u0016*\b\u0012\u0004\u0012\u00020\u000e0\u00192\u0006\u0010\u001e\u001a\u00020\u001b2\u0012\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\u0019\"\u00020\u000eH\u0002¢\u0006\u0002\u0010 R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, aXE = {"Lcom/iqoption/charttools/templates/TemplateFragment;", "Lcom/iqoption/core/ui/fragment/IQFragment;", "()V", "inputData", "Lcom/iqoption/charttools/templates/TemplateInputData;", "getInputData", "()Lcom/iqoption/charttools/templates/TemplateInputData;", "templateViewModel", "Lcom/iqoption/charttools/templates/TemplateViewModel;", "transition", "Landroid/support/transition/AutoTransition;", "onCreateTransitionProvider", "Lcom/iqoption/core/ui/animation/transitions/TransitionProvider;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "observeTemplateContent", "", "Lcom/iqoption/charttools/databinding/FragmentTemplateBinding;", "setWidgetsShown", "", "shown", "", "([Landroid/view/View;Z)V", "showWidgets", "goneOthers", "widgetsToShow", "([Landroid/view/View;Z[Landroid/view/View;)V", "Companion", "techtools_release"})
/* compiled from: TemplateFragment.kt */
public final class i extends com.iqoption.core.ui.fragment.b {
    public static final String TAG = "com.iqoption.charttools.templates.i";
    public static final a azq = new a();
    private HashMap atz;
    private TemplateViewModel azo;
    private final AutoTransition azp;

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00040\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, aXE = {"Lcom/iqoption/charttools/templates/TemplateFragment$Companion;", "", "()V", "ARG_INPUT_DATA", "", "TAG", "kotlin.jvm.PlatformType", "makeArgs", "Landroid/os/Bundle;", "inputData", "Lcom/iqoption/charttools/templates/TemplateInputData;", "tabId", "config", "Lcom/iqoption/charttools/model/chart/ChartConfig;", "templateId", "", "techtools_release"})
    /* compiled from: TemplateFragment.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final Bundle f(String str, long j) {
            kotlin.jvm.internal.h.e(str, "tabId");
            return a(new l(str, Long.valueOf(j)));
        }

        public final Bundle a(String str, com.iqoption.charttools.model.chart.a aVar) {
            kotlin.jvm.internal.h.e(str, "tabId");
            kotlin.jvm.internal.h.e(aVar, "config");
            return a(new l(str, aVar));
        }

        public final Bundle a(l lVar) {
            kotlin.jvm.internal.h.e(lVar, "inputData");
            Bundle bundle = new Bundle();
            bundle.putParcelable("arg.inputData", lVar);
            return bundle;
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, aXE = {"<anonymous>", "", "switcher", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "isChecked", "", "onCheckedChanged", "com/iqoption/charttools/templates/TemplateFragment$onCreateView$1$onSwitchCheckChangeListener$1"})
    /* compiled from: TemplateFragment.kt */
    static final class q implements OnCheckedChangeListener {
        final /* synthetic */ i azt;

        q(i iVar) {
            this.azt = iVar;
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            kotlin.jvm.internal.h.d(compoundButton, "switcher");
            int id = compoundButton.getId();
            if (id == com.iqoption.charttools.o.g.switchChartSettings) {
                i.a(this.azt).bR(z);
            } else if (id == com.iqoption.charttools.o.g.switchHeikenAshi) {
                i.a(this.azt).bT(z);
            } else if (id == com.iqoption.charttools.o.g.switchAutoScale) {
                i.a(this.azt).bS(z);
            } else if (id == com.iqoption.charttools.o.g.switchTradersMood) {
                i.a(this.azt).bU(z);
            } else if (id == com.iqoption.charttools.o.g.switchLiveDeals) {
                i.a(this.azt).setLiveDealsEnabled(z);
            } else if (id == com.iqoption.charttools.o.g.switchVolume) {
                i.a(this.azt).bF(z);
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "items", "", "Lcom/iqoption/charttools/templates/InstrumentAdapterItem;", "onChanged"})
    /* compiled from: TemplateFragment.kt */
    static final class b<T> implements Observer<List<? extends d>> {
        final /* synthetic */ e azr;

        b(e eVar) {
            this.azr = eVar;
        }

        /* renamed from: L */
        public final void onChanged(List<? extends d> list) {
            if (list != null) {
                this.azr.ap(list);
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, aXE = {"<anonymous>", "", "it", "", "onChanged", "(Ljava/lang/Boolean;)V"})
    /* compiled from: TemplateFragment.kt */
    static final class c<T> implements Observer<Boolean> {
        final /* synthetic */ com.iqoption.charttools.b.d azs;

        c(com.iqoption.charttools.b.d dVar) {
            this.azs = dVar;
        }

        /* renamed from: k */
        public final void onChanged(Boolean bool) {
            if (bool != null) {
                SwitchCompat switchCompat = this.azs.axr;
                kotlin.jvm.internal.h.d(switchCompat, "switchTradersMood");
                if ((kotlin.jvm.internal.h.E(Boolean.valueOf(switchCompat.isChecked()), bool) ^ 1) != 0) {
                    switchCompat = this.azs.axr;
                    kotlin.jvm.internal.h.d(switchCompat, "switchTradersMood");
                    switchCompat.setChecked(bool.booleanValue());
                }
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, aXE = {"<anonymous>", "", "it", "", "onChanged", "(Ljava/lang/Boolean;)V"})
    /* compiled from: TemplateFragment.kt */
    static final class d<T> implements Observer<Boolean> {
        final /* synthetic */ com.iqoption.charttools.b.d azs;

        d(com.iqoption.charttools.b.d dVar) {
            this.azs = dVar;
        }

        /* renamed from: k */
        public final void onChanged(Boolean bool) {
            if (bool != null) {
                SwitchCompat switchCompat = this.azs.axq;
                kotlin.jvm.internal.h.d(switchCompat, "switchLiveDeals");
                if ((kotlin.jvm.internal.h.E(Boolean.valueOf(switchCompat.isChecked()), bool) ^ 1) != 0) {
                    switchCompat = this.azs.axq;
                    kotlin.jvm.internal.h.d(switchCompat, "switchLiveDeals");
                    switchCompat.setChecked(bool.booleanValue());
                }
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, aXE = {"<anonymous>", "", "it", "", "onChanged", "(Ljava/lang/Boolean;)V"})
    /* compiled from: TemplateFragment.kt */
    static final class e<T> implements Observer<Boolean> {
        final /* synthetic */ com.iqoption.charttools.b.d azs;

        e(com.iqoption.charttools.b.d dVar) {
            this.azs = dVar;
        }

        /* renamed from: k */
        public final void onChanged(Boolean bool) {
            if (bool != null) {
                SwitchCompat switchCompat = this.azs.axs;
                kotlin.jvm.internal.h.d(switchCompat, "switchVolume");
                if ((kotlin.jvm.internal.h.E(Boolean.valueOf(switchCompat.isChecked()), bool) ^ 1) != 0) {
                    switchCompat = this.azs.axs;
                    kotlin.jvm.internal.h.d(switchCompat, "switchVolume");
                    switchCompat.setChecked(bool.booleanValue());
                }
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "output", "Lcom/iqoption/charttools/model/indicator/ChartIndicator;", "onChanged"})
    /* compiled from: TemplateFragment.kt */
    static final class f<T> implements Observer<com.iqoption.charttools.model.indicator.h> {
        final /* synthetic */ i azt;

        f(i iVar) {
            this.azt = iVar;
        }

        /* renamed from: i */
        public final void onChanged(com.iqoption.charttools.model.indicator.h hVar) {
            if (hVar != null) {
                i.a(this.azt).j(hVar);
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, aXE = {"<anonymous>", "", "isShow", "", "onChanged", "(Ljava/lang/Boolean;)V"})
    /* compiled from: TemplateFragment.kt */
    static final class g<T> implements Observer<Boolean> {
        final /* synthetic */ com.iqoption.charttools.b.d azs;

        g(com.iqoption.charttools.b.d dVar) {
            this.azs = dVar;
        }

        /* renamed from: k */
        public final void onChanged(Boolean bool) {
            if (bool == null) {
                return;
            }
            TextView textView;
            if (bool.booleanValue()) {
                textView = this.azs.axk;
                kotlin.jvm.internal.h.d(textView, "linesSnippet");
                com.iqoption.core.ext.a.L(textView);
                return;
            }
            textView = this.azs.axk;
            kotlin.jvm.internal.h.d(textView, "linesSnippet");
            com.iqoption.core.ext.a.M(textView);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, aXE = {"<anonymous>", "", "isEnabled", "", "onChanged", "(Ljava/lang/Boolean;)V"})
    /* compiled from: TemplateFragment.kt */
    static final class h<T> implements Observer<Boolean> {
        final /* synthetic */ com.iqoption.charttools.b.d azs;

        h(com.iqoption.charttools.b.d dVar) {
            this.azs = dVar;
        }

        /* renamed from: k */
        public final void onChanged(Boolean bool) {
            if (bool != null) {
                FrameLayout frameLayout = this.azs.axa;
                kotlin.jvm.internal.h.d(frameLayout, "btnSave");
                frameLayout.setEnabled(bool.booleanValue());
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\u000fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0005R\u0019\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, aXE = {"com/iqoption/charttools/templates/TemplateFragment$observeTemplateContent$4", "Landroid/arch/lifecycle/Observer;", "", "isPortrait", "", "()Z", "widgets", "", "Landroid/view/View;", "getWidgets", "()[Landroid/view/View;", "[Landroid/view/View;", "onChanged", "", "mode", "(Ljava/lang/Integer;)V", "techtools_release"})
    /* compiled from: TemplateFragment.kt */
    public static final class i implements Observer<Integer> {
        final /* synthetic */ com.iqoption.charttools.b.d azs;
        final /* synthetic */ i azt;
        private final View[] azu;
        private final boolean isPortrait;

        i(i iVar, com.iqoption.charttools.b.d dVar) {
            this.azt = iVar;
            this.azs = dVar;
            Resources resources = iVar.getResources();
            kotlin.jvm.internal.h.d(resources, "resources");
            this.isPortrait = resources.getConfiguration().orientation == 1;
            this.azu = this.isPortrait ? new View[]{this.azs.awZ, this.azs.awY, this.azs.awX, this.azs.axl} : new View[]{this.azs.axa, this.azs.awZ, this.azs.awY, this.azs.awX, this.azs.axl};
        }

        /* renamed from: b */
        public void onChanged(Integer num) {
            View view = this.azs.axv;
            if (view == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
            }
            TransitionManager.beginDelayedTransition((ViewGroup) view, this.azt.azp);
            i iVar;
            View[] viewArr;
            boolean z;
            View[] viewArr2;
            View[] viewArr3;
            boolean z2;
            View view2;
            if (num != null && num.intValue() == 1) {
                iVar = this.azt;
                viewArr = this.azu;
                z = this.isPortrait;
                viewArr2 = new View[1];
                FrameLayout frameLayout = this.azs.axa;
                kotlin.jvm.internal.h.d(frameLayout, "btnSave");
                viewArr2[0] = frameLayout;
                iVar.a(viewArr, z, viewArr2);
            } else if (num != null && num.intValue() == 2) {
                iVar = this.azt;
                viewArr3 = this.azu;
                z2 = this.isPortrait;
                viewArr = new View[2];
                view2 = this.azs.awZ;
                kotlin.jvm.internal.h.d(view2, "btnDelete");
                viewArr[0] = view2;
                FrameLayout frameLayout2 = this.azs.axa;
                kotlin.jvm.internal.h.d(frameLayout2, "btnSave");
                viewArr[1] = frameLayout2;
                iVar.a(viewArr3, z2, viewArr);
            } else if (num != null && num.intValue() == 3) {
                iVar = this.azt;
                viewArr3 = this.azu;
                z2 = this.isPortrait;
                viewArr = new View[2];
                view2 = this.azs.awY;
                kotlin.jvm.internal.h.d(view2, "btnConfirm");
                viewArr[0] = view2;
                view = this.azs.awX;
                kotlin.jvm.internal.h.d(view, "btnCancel");
                viewArr[1] = view;
                iVar.a(viewArr3, z2, viewArr);
            } else if (num != null && num.intValue() == 4) {
                iVar = this.azt;
                viewArr = this.azu;
                z = this.isPortrait;
                viewArr2 = new View[1];
                ProgressBar progressBar = this.azs.axl;
                kotlin.jvm.internal.h.d(progressBar, "progressDelete");
                viewArr2[0] = progressBar;
                iVar.a(viewArr, z, viewArr2);
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, aXE = {"<anonymous>", "", "showProgress", "", "onChanged", "(Ljava/lang/Boolean;)V"})
    /* compiled from: TemplateFragment.kt */
    static final class j<T> implements Observer<Boolean> {
        final /* synthetic */ com.iqoption.charttools.b.d azs;
        final /* synthetic */ i azt;

        j(i iVar, com.iqoption.charttools.b.d dVar) {
            this.azt = iVar;
            this.azs = dVar;
        }

        /* renamed from: k */
        public final void onChanged(Boolean bool) {
            if (bool != null) {
                TransitionManager.beginDelayedTransition(this.azs.axa, this.azt.azp);
                ProgressBar progressBar;
                TextView textView;
                if (bool.booleanValue()) {
                    progressBar = this.azs.axc;
                    kotlin.jvm.internal.h.d(progressBar, "btnSaveProgress");
                    com.iqoption.core.ext.a.L(progressBar);
                    textView = this.azs.axb;
                    kotlin.jvm.internal.h.d(textView, "btnSaveLabel");
                    com.iqoption.core.ext.a.hide(textView);
                    return;
                }
                progressBar = this.azs.axc;
                kotlin.jvm.internal.h.d(progressBar, "btnSaveProgress");
                com.iqoption.core.ext.a.M(progressBar);
                textView = this.azs.axb;
                kotlin.jvm.internal.h.d(textView, "btnSaveLabel");
                com.iqoption.core.ext.a.L(textView);
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "result", "Lcom/iqoption/charttools/templates/TemplateActionResult;", "onChanged"})
    /* compiled from: TemplateFragment.kt */
    static final class k<T> implements Observer<g> {
        final /* synthetic */ i azt;

        k(i iVar) {
            this.azt = iVar;
        }

        /* renamed from: a */
        public final void onChanged(g gVar) {
            if ((gVar instanceof n) || kotlin.jvm.internal.h.E(gVar, h.azn)) {
                this.azt.back();
            } else if (gVar instanceof m) {
                com.iqoption.core.f.C(((m) gVar).MY(), 1);
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\u0011R\u001a\u0010\u0003\u001a\u00020\u0002X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0019\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, aXE = {"com/iqoption/charttools/templates/TemplateFragment$observeTemplateContent$7", "Landroid/arch/lifecycle/Observer;", "", "firstTime", "getFirstTime", "()Z", "setFirstTime", "(Z)V", "widgets", "", "Landroid/view/View;", "getWidgets", "()[Landroid/view/View;", "[Landroid/view/View;", "onChanged", "", "isEnabled", "(Ljava/lang/Boolean;)V", "techtools_release"})
    /* compiled from: TemplateFragment.kt */
    public static final class l implements Observer<Boolean> {
        final /* synthetic */ com.iqoption.charttools.b.d azs;
        final /* synthetic */ i azt;
        private final View[] azu;
        private boolean azv = true;

        l(i iVar, com.iqoption.charttools.b.d dVar) {
            this.azt = iVar;
            this.azs = dVar;
            View[] viewArr = new View[7];
            FrameLayout frameLayout = this.azs.axg;
            kotlin.jvm.internal.h.d(frameLayout, "containerChartType");
            viewArr[0] = frameLayout;
            frameLayout = this.azs.axf;
            kotlin.jvm.internal.h.d(frameLayout, "containerCandleSize");
            viewArr[1] = frameLayout;
            SwitchCompat switchCompat = this.azs.axp;
            kotlin.jvm.internal.h.d(switchCompat, "switchHeikenAshi");
            viewArr[2] = switchCompat;
            switchCompat = this.azs.axn;
            kotlin.jvm.internal.h.d(switchCompat, "switchAutoScale");
            viewArr[3] = switchCompat;
            switchCompat = this.azs.axr;
            kotlin.jvm.internal.h.d(switchCompat, "switchTradersMood");
            viewArr[4] = switchCompat;
            switchCompat = this.azs.axq;
            kotlin.jvm.internal.h.d(switchCompat, "switchLiveDeals");
            viewArr[5] = switchCompat;
            switchCompat = this.azs.axs;
            kotlin.jvm.internal.h.d(switchCompat, "switchVolume");
            viewArr[6] = switchCompat;
            this.azu = viewArr;
        }

        /* renamed from: k */
        public void onChanged(Boolean bool) {
            if (bool != null) {
                SwitchCompat switchCompat = this.azs.axo;
                kotlin.jvm.internal.h.d(switchCompat, "switchChartSettings");
                if ((kotlin.jvm.internal.h.E(Boolean.valueOf(switchCompat.isChecked()), bool) ^ 1) != 0) {
                    switchCompat = this.azs.axo;
                    kotlin.jvm.internal.h.d(switchCompat, "switchChartSettings");
                    switchCompat.setChecked(bool.booleanValue());
                }
                if (this.azv && this.azt.MN().MW() == null) {
                    this.azv = false;
                } else {
                    TransitionManager.beginDelayedTransition(this.azs.axt, this.azt.azp);
                }
                this.azt.a(this.azu, bool.booleanValue());
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, aXE = {"<anonymous>", "", "it", "", "onChanged", "(Ljava/lang/Boolean;)V"})
    /* compiled from: TemplateFragment.kt */
    static final class m<T> implements Observer<Boolean> {
        final /* synthetic */ com.iqoption.charttools.b.d azs;

        m(com.iqoption.charttools.b.d dVar) {
            this.azs = dVar;
        }

        /* renamed from: k */
        public final void onChanged(Boolean bool) {
            if (bool != null) {
                SwitchCompat switchCompat = this.azs.axp;
                kotlin.jvm.internal.h.d(switchCompat, "switchHeikenAshi");
                if ((kotlin.jvm.internal.h.E(Boolean.valueOf(switchCompat.isChecked()), bool) ^ 1) != 0) {
                    switchCompat = this.azs.axp;
                    kotlin.jvm.internal.h.d(switchCompat, "switchHeikenAshi");
                    switchCompat.setChecked(bool.booleanValue());
                }
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, aXE = {"<anonymous>", "", "it", "", "onChanged", "(Ljava/lang/Boolean;)V"})
    /* compiled from: TemplateFragment.kt */
    static final class n<T> implements Observer<Boolean> {
        final /* synthetic */ com.iqoption.charttools.b.d azs;

        n(com.iqoption.charttools.b.d dVar) {
            this.azs = dVar;
        }

        /* renamed from: k */
        public final void onChanged(Boolean bool) {
            if (bool != null) {
                SwitchCompat switchCompat = this.azs.axn;
                kotlin.jvm.internal.h.d(switchCompat, "switchAutoScale");
                if ((kotlin.jvm.internal.h.E(Boolean.valueOf(switchCompat.isChecked()), bool) ^ 1) != 0) {
                    switchCompat = this.azs.axn;
                    kotlin.jvm.internal.h.d(switchCompat, "switchAutoScale");
                    switchCompat.setChecked(bool.booleanValue());
                }
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, aXE = {"com/iqoption/charttools/templates/TemplateFragment$observeTemplateContent$instrumentsAdapter$1", "Lcom/iqoption/charttools/templates/viewholder/ViewHolderCallback;", "onItemDeleteClick", "", "item", "Lcom/iqoption/charttools/templates/InstrumentAdapterItem;", "onItemSettingsClick", "onItemVisibilityClick", "techtools_release"})
    /* compiled from: TemplateFragment.kt */
    public static final class o implements com.iqoption.charttools.templates.a.d {
        final /* synthetic */ i azt;

        o(i iVar) {
            this.azt = iVar;
        }

        public void a(d dVar) {
            kotlin.jvm.internal.h.e(dVar, "item");
            i.a(this.azt).e(dVar);
        }

        public void b(d dVar) {
            kotlin.jvm.internal.h.e(dVar, "item");
            String KI = this.azt.MN().KI();
            com.iqoption.charttools.model.indicator.h JS = dVar instanceof c ? ((c) dVar).JS() : dVar instanceof b ? ((b) dVar).MM() : null;
            if (JS != null) {
                com.iqoption.charttools.constructor.b a = com.iqoption.charttools.constructor.b.aty.a(new com.iqoption.charttools.constructor.c(KI, JS, true));
                FragmentManager childFragmentManager = this.azt.getChildFragmentManager();
                kotlin.jvm.internal.h.d(childFragmentManager, "childFragmentManager");
                FragmentTransaction beginTransaction = childFragmentManager.beginTransaction();
                kotlin.jvm.internal.h.d(beginTransaction, "ft");
                beginTransaction.add(com.iqoption.charttools.o.g.content, a, com.iqoption.charttools.constructor.b.TAG);
                beginTransaction.addToBackStack(null);
                beginTransaction.commitAllowingStateLoss();
                childFragmentManager.executePendingTransactions();
            }
        }

        public void c(d dVar) {
            kotlin.jvm.internal.h.e(dVar, "item");
            i.a(this.azt).d(dVar);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, aXE = {"com/iqoption/charttools/templates/TemplateFragment$onCreateView$1$onButtonClickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "techtools_release"})
    /* compiled from: TemplateFragment.kt */
    public static final class p extends com.iqoption.core.ext.g {
        final /* synthetic */ i azt;

        p(i iVar) {
            this.azt = iVar;
            super(0, 1, null);
        }

        public void q(View view) {
            kotlin.jvm.internal.h.e(view, "v");
            int id = view.getId();
            if (id == com.iqoption.charttools.o.g.btnBack) {
                com.iqoption.charttools.a.a.atr.Kz();
                this.azt.back();
            } else if (id == com.iqoption.charttools.o.g.btnDelete) {
                i.a(this.azt).bQ(true);
            } else if (id == com.iqoption.charttools.o.g.btnCancel) {
                i.a(this.azt).bQ(false);
            } else if (id == com.iqoption.charttools.o.g.btnConfirm) {
                i.a(this.azt).delete();
            } else if (id == com.iqoption.charttools.o.g.btnSave) {
                i.a(this.azt).save();
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, aXE = {"<anonymous>", "", "state", "Lcom/iqoption/charttools/templates/TemplateInitialState;", "onChanged", "com/iqoption/charttools/templates/TemplateFragment$onCreateView$1$1"})
    /* compiled from: TemplateFragment.kt */
    static final class r<T> implements Observer<k> {
        final /* synthetic */ com.iqoption.charttools.b.d azs;
        final /* synthetic */ i azt;
        final /* synthetic */ AtomicBoolean azw;

        r(com.iqoption.charttools.b.d dVar, AtomicBoolean atomicBoolean, i iVar) {
            this.azs = dVar;
            this.azw = atomicBoolean;
            this.azt = iVar;
        }

        /* renamed from: a */
        public final void onChanged(k kVar) {
            TransitionManager.beginDelayedTransition(this.azs.axu, this.azt.azp);
            if (kVar != null) {
                LinearLayout linearLayout = this.azs.axt;
                kotlin.jvm.internal.h.d(linearLayout, "templateContent");
                com.iqoption.core.ext.a.L(linearLayout);
                ProgressBar progressBar = this.azs.axm;
                kotlin.jvm.internal.h.d(progressBar, "progressTemplate");
                com.iqoption.core.ext.a.M(progressBar);
                this.azw.set(true);
                this.azs.axi.setText(kVar.getName());
                this.azw.set(false);
                EditText editText = this.azs.axi;
                kotlin.jvm.internal.h.d(editText, "inputName");
                com.iqoption.core.ext.a.c(editText);
                TextView textView = this.azs.axe;
                kotlin.jvm.internal.h.d(textView, "chartType");
                ChartType MP = kVar.MP();
                CharSequence charSequence = null;
                if (MP != null) {
                    switch (MP) {
                        case zone:
                            charSequence = this.azt.getString(com.iqoption.charttools.o.i.area);
                            break;
                        case linear:
                            charSequence = this.azt.getString(com.iqoption.charttools.o.i.linear);
                            break;
                        case candles:
                            String string;
                            ChartColor MQ = kVar.MQ();
                            if (MQ != null) {
                                switch (MQ) {
                                    case mono:
                                        string = this.azt.getString(com.iqoption.charttools.o.i.candles_grey);
                                        break;
                                    case redGreen:
                                        string = this.azt.getString(com.iqoption.charttools.o.i.candles);
                                        break;
                                }
                            }
                            charSequence = string;
                            break;
                        case bar:
                            charSequence = this.azt.getString(com.iqoption.charttools.o.i.bars);
                            break;
                    }
                }
                textView.setText(charSequence);
                textView = this.azs.axd;
                kotlin.jvm.internal.h.d(textView, "candleSize");
                textView.setText(kVar.MO());
                RecyclerView recyclerView = this.azs.axj;
                kotlin.jvm.internal.h.d(recyclerView, "instrumentsList");
                if (recyclerView.getAdapter() == null) {
                    this.azt.a(this.azs);
                    return;
                }
                return;
            }
            LinearLayout linearLayout2 = this.azs.axt;
            kotlin.jvm.internal.h.d(linearLayout2, "templateContent");
            com.iqoption.core.ext.a.M(linearLayout2);
            ProgressBar progressBar2 = this.azs.axm;
            kotlin.jvm.internal.h.d(progressBar2, "progressTemplate");
            com.iqoption.core.ext.a.L(progressBar2);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, aXE = {"com/iqoption/charttools/templates/TemplateFragment$onCreateView$1$2", "Lcom/iqoption/core/util/TextWatcherAdapter;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "techtools_release"})
    /* compiled from: TemplateFragment.kt */
    public static final class s extends com.iqoption.core.util.r {
        final /* synthetic */ i azt;
        final /* synthetic */ AtomicBoolean azw;

        s(AtomicBoolean atomicBoolean, i iVar) {
            this.azw = atomicBoolean;
            this.azt = iVar;
        }

        public void afterTextChanged(Editable editable) {
            kotlin.jvm.internal.h.e(editable, "s");
            if (!this.azw.get()) {
                i.a(this.azt).fF(editable.toString());
            }
        }
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

    public i() {
        AutoTransition autoTransition = new AutoTransition();
        autoTransition.setOrdering(0);
        this.azp = autoTransition;
    }

    private final l MN() {
        Parcelable parcelable = com.iqoption.core.ext.a.o(this).getParcelable("arg.inputData");
        kotlin.jvm.internal.h.d(parcelable, "args.getParcelable(ARG_INPUT_DATA)");
        return (l) parcelable;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.h.e(layoutInflater, "inflater");
        com.iqoption.charttools.b.d dVar = (com.iqoption.charttools.b.d) com.iqoption.core.ext.a.a((Fragment) this, com.iqoption.charttools.o.h.fragment_template, viewGroup, false, 4, null);
        OnClickListener pVar = new p(this);
        dVar.awN.setOnClickListener(pVar);
        dVar.awZ.setOnClickListener(pVar);
        dVar.axa.setOnClickListener(pVar);
        dVar.awY.setOnClickListener(pVar);
        dVar.awX.setOnClickListener(pVar);
        FrameLayout frameLayout = dVar.axa;
        kotlin.jvm.internal.h.d(frameLayout, "btnSave");
        frameLayout.setEnabled(false);
        com.iqoption.charttools.a.a aVar = com.iqoption.charttools.a.a.atr;
        EditText editText = dVar.axi;
        kotlin.jvm.internal.h.d(editText, "inputName");
        aVar.b(editText);
        OnCheckedChangeListener qVar = new q(this);
        dVar.axo.setOnCheckedChangeListener(qVar);
        dVar.axp.setOnCheckedChangeListener(qVar);
        dVar.axn.setOnCheckedChangeListener(qVar);
        dVar.axr.setOnCheckedChangeListener(qVar);
        dVar.axq.setOnCheckedChangeListener(qVar);
        dVar.axs.setOnCheckedChangeListener(qVar);
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.azo = TemplateViewModel.aAp.a(this, MN());
        TextView textView = dVar.agA;
        kotlin.jvm.internal.h.d(textView, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
        TemplateViewModel templateViewModel = this.azo;
        if (templateViewModel == null) {
            kotlin.jvm.internal.h.lS("templateViewModel");
        }
        textView.setText(templateViewModel.getTitle());
        TemplateViewModel templateViewModel2 = this.azo;
        if (templateViewModel2 == null) {
            kotlin.jvm.internal.h.lS("templateViewModel");
        }
        templateViewModel2.MZ().observe(this, new r(dVar, atomicBoolean, this));
        RecyclerView recyclerView = dVar.axj;
        kotlin.jvm.internal.h.d(recyclerView, "instrumentsList");
        recyclerView.setItemAnimator((ItemAnimator) null);
        dVar.axi.addTextChangedListener(new s(atomicBoolean, this));
        com.iqoption.core.ui.navigation.a YH = YH();
        if (YH != null) {
            getLifecycle().a(new TemplateFragment$onCreateView$$inlined$let$lambda$1(YH, YH, this));
        }
        return dVar.getRoot();
    }

    private final void a(com.iqoption.charttools.b.d dVar) {
        i iVar = this;
        e eVar = new e(new o(this));
        RecyclerView recyclerView = dVar.axj;
        kotlin.jvm.internal.h.d(recyclerView, "instrumentsList");
        recyclerView.setAdapter(eVar);
        dVar.axj.addItemDecoration(new f(eVar));
        TemplateViewModel templateViewModel = this.azo;
        if (templateViewModel == null) {
            kotlin.jvm.internal.h.lS("templateViewModel");
        }
        LifecycleOwner lifecycleOwner = iVar;
        templateViewModel.Na().observe(lifecycleOwner, new b(eVar));
        TemplateViewModel templateViewModel2 = this.azo;
        if (templateViewModel2 == null) {
            kotlin.jvm.internal.h.lS("templateViewModel");
        }
        templateViewModel2.Nb().observe(lifecycleOwner, new g(dVar));
        templateViewModel2 = this.azo;
        if (templateViewModel2 == null) {
            kotlin.jvm.internal.h.lS("templateViewModel");
        }
        templateViewModel2.Nc().observe(lifecycleOwner, new h(dVar));
        templateViewModel2 = this.azo;
        if (templateViewModel2 == null) {
            kotlin.jvm.internal.h.lS("templateViewModel");
        }
        templateViewModel2.Nd().observe(lifecycleOwner, new i(this, dVar));
        templateViewModel2 = this.azo;
        if (templateViewModel2 == null) {
            kotlin.jvm.internal.h.lS("templateViewModel");
        }
        templateViewModel2.Nk().observe(lifecycleOwner, new j(this, dVar));
        templateViewModel2 = this.azo;
        if (templateViewModel2 == null) {
            kotlin.jvm.internal.h.lS("templateViewModel");
        }
        templateViewModel2.Nl().observe(lifecycleOwner, new k(this));
        templateViewModel2 = this.azo;
        if (templateViewModel2 == null) {
            kotlin.jvm.internal.h.lS("templateViewModel");
        }
        templateViewModel2.Ne().observe(lifecycleOwner, new l(this, dVar));
        templateViewModel2 = this.azo;
        if (templateViewModel2 == null) {
            kotlin.jvm.internal.h.lS("templateViewModel");
        }
        templateViewModel2.Ng().observe(lifecycleOwner, new m(dVar));
        templateViewModel2 = this.azo;
        if (templateViewModel2 == null) {
            kotlin.jvm.internal.h.lS("templateViewModel");
        }
        templateViewModel2.Nf().observe(lifecycleOwner, new n(dVar));
        templateViewModel2 = this.azo;
        if (templateViewModel2 == null) {
            kotlin.jvm.internal.h.lS("templateViewModel");
        }
        templateViewModel2.Ni().observe(lifecycleOwner, new c(dVar));
        templateViewModel2 = this.azo;
        if (templateViewModel2 == null) {
            kotlin.jvm.internal.h.lS("templateViewModel");
        }
        templateViewModel2.Nh().observe(lifecycleOwner, new d(dVar));
        templateViewModel2 = this.azo;
        if (templateViewModel2 == null) {
            kotlin.jvm.internal.h.lS("templateViewModel");
        }
        templateViewModel2.Nj().observe(lifecycleOwner, new e(dVar));
        IndicatorOutputViewModel.atv.d(com.iqoption.core.ext.a.n(this)).KB().observe(lifecycleOwner, new f(this));
    }

    protected com.iqoption.core.ui.b.b.e JO() {
        return new com.iqoption.core.ui.b.b.a(this, null, 2, null);
    }

    private final void a(View[] viewArr, boolean z, View... viewArr2) {
        for (View view : viewArr) {
            if (i.b((Object[]) viewArr2, (Object) view)) {
                com.iqoption.core.ext.a.L(view);
            } else if (z) {
                com.iqoption.core.ext.a.M(view);
            } else {
                com.iqoption.core.ext.a.hide(view);
            }
        }
    }

    private final void a(View[] viewArr, boolean z) {
        int i = 0;
        int length;
        if (z) {
            length = viewArr.length;
            while (i < length) {
                com.iqoption.core.ext.a.L(viewArr[i]);
                i++;
            }
            return;
        }
        length = viewArr.length;
        while (i < length) {
            com.iqoption.core.ext.a.M(viewArr[i]);
            i++;
        }
    }
}
