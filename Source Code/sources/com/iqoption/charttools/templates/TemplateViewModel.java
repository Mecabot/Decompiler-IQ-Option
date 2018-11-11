package com.iqoption.charttools.templates;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProvider.Factory;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.lifecycle.ViewModelStores;
import android.support.annotation.MainThread;
import android.support.annotation.WorkerThread;
import android.support.v4.app.Fragment;
import android.util.SparseArray;
import com.iqoption.charttools.model.chart.ChartColor;
import com.iqoption.charttools.model.chart.ChartType;
import com.iqoption.charttools.model.indicator.k;
import com.iqoption.charttools.r;
import com.iqoption.core.ui.viewmodel.DisposableViewModel;
import io.reactivex.o;
import io.reactivex.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 O2\u00020\u0001:\u0001OB\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u000fJ\b\u00108\u001a\u00020\u001bH\u0002J\b\u00109\u001a\u000206H\u0007J\u0006\u0010:\u001a\u00020\u000fJ\u0010\u0010;\u001a\u0002062\u0006\u0010<\u001a\u00020.H\u0003J\u000e\u0010=\u001a\u0002062\u0006\u0010>\u001a\u00020\u0017J\u0006\u0010?\u001a\u000206J\u000e\u0010@\u001a\u0002062\u0006\u0010A\u001a\u00020\u001bJ\u000e\u0010B\u001a\u0002062\u0006\u0010A\u001a\u00020\u001bJ\u0010\u0010C\u001a\u0002062\u0006\u0010D\u001a\u00020\u001bH\u0007J\u000e\u0010E\u001a\u0002062\u0006\u0010A\u001a\u00020\u001bJ\u000e\u0010F\u001a\u0002062\u0006\u0010A\u001a\u00020\u001bJ\u000e\u0010G\u001a\u0002062\u0006\u0010A\u001a\u00020\u001bJ\u000e\u0010H\u001a\u0002062\u0006\u0010A\u001a\u00020\u001bJ\u000e\u0010I\u001a\u0002062\u0006\u0010>\u001a\u00020\u0017J\u000e\u0010J\u001a\u0002062\u0006\u0010K\u001a\u00020LJ\b\u0010M\u001a\u000206H\u0002J\u001a\u0010N\u001a\u000206*\b\u0012\u0004\u0012\u00020\u001b0\u00142\u0006\u0010A\u001a\u00020\u001bH\u0002R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000bR\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u0014X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000bR\u001a\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u0014X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000bR\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0014X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001b0\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u000bR\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0014X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001b0\b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u000bR\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001b0\u0014X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001b0\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u000bR\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0014X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001b0\b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u000bR\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0014X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001b0\b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u000bR\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0014X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001b0\b¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u000bR\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0014X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001b0\b¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u000bR\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0014X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001b0\b¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u000bR\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0014X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u000bR\u0014\u00100\u001a\b\u0012\u0004\u0012\u00020.01X\u0004¢\u0006\u0002\n\u0000R\u0012\u00102\u001a\u0004\u0018\u000103X\u0004¢\u0006\u0004\n\u0002\u00104¨\u0006P"}, aXE = {"Lcom/iqoption/charttools/templates/TemplateViewModel;", "Lcom/iqoption/core/ui/viewmodel/DisposableViewModel;", "inputData", "Lcom/iqoption/charttools/templates/TemplateInputData;", "activesProvider", "Lcom/iqoption/charttools/templates/DistinctActivesProvider;", "(Lcom/iqoption/charttools/templates/TemplateInputData;Lcom/iqoption/charttools/templates/DistinctActivesProvider;)V", "actionResult", "Landroid/arch/lifecycle/LiveData;", "Lcom/iqoption/charttools/templates/TemplateActionResult;", "getActionResult", "()Landroid/arch/lifecycle/LiveData;", "actionResultData", "Lcom/iqoption/core/data/livedata/IQLiveEvent;", "currentTemplateName", "", "deleteMode", "", "getDeleteMode", "deleteModeData", "Lcom/iqoption/core/data/livedata/IQMutableLiveData;", "instrumentItems", "", "Lcom/iqoption/charttools/templates/InstrumentAdapterItem;", "getInstrumentItems", "instrumentItemsData", "isAutoScaleEnabled", "", "isAutoScaleEnabledData", "isChartSettingsEnabled", "isChartSettingsEnabledData", "isHeikenAshiEnabled", "isHeikenAshiEnabledData", "isLiveDealsEnabled", "isLiveDealsEnabledData", "isSaveButtonEnabled", "isSaveButtonEnabledData", "isShowLinesSnippet", "isShowLinesSnippetData", "isShowSaveProgress", "isShowSaveProgressData", "isTradersMoodEnabled", "isTradersMoodEnabledData", "isVolumeEnabled", "isVolumeEnabledData", "state", "Lcom/iqoption/charttools/templates/TemplateInitialState;", "getState$techtools_release", "stateData", "Landroid/arch/lifecycle/MutableLiveData;", "templateId", "", "Ljava/lang/Long;", "changeTemplateName", "", "newTemplateName", "checkIsSaveButtonEnabled", "delete", "getTitle", "onInitialStateSet", "initialState", "removeInstrument", "item", "save", "setAutoScaleEnabled", "enabled", "setChartSettingsEnabled", "setDeleteConfirmationShown", "shown", "setHeikenAshiEnabled", "setLiveDealsEnabled", "setTradersMoodEnabled", "setVolumeEnabled", "toggleInstrumentVisibility", "updateInstrument", "indicator", "Lcom/iqoption/charttools/model/indicator/ChartIndicator;", "updateSaveButton", "setEnabled", "Companion", "techtools_release"})
/* compiled from: TemplateViewModel.kt */
public final class TemplateViewModel extends DisposableViewModel {
    public static final String TAG = "TemplateViewModel";
    public static a aAn = new b();
    private static l aAo;
    public static final a aAp = new a();
    private final LiveData<Boolean> aAa = this.azZ;
    private final com.iqoption.core.data.b.c<Boolean> aAb = new com.iqoption.core.data.b.c(Boolean.valueOf(false));
    private final LiveData<Boolean> aAc = this.aAb;
    private final com.iqoption.core.data.b.c<Boolean> aAd = new com.iqoption.core.data.b.c(Boolean.valueOf(false));
    private final LiveData<Boolean> aAe = this.aAd;
    private final com.iqoption.core.data.b.c<Boolean> aAf = new com.iqoption.core.data.b.c(Boolean.valueOf(false));
    private final LiveData<Boolean> aAg = this.aAf;
    private final com.iqoption.core.data.b.c<Boolean> aAh = new com.iqoption.core.data.b.c(Boolean.valueOf(false));
    private final LiveData<Boolean> aAi = this.aAh;
    private final com.iqoption.core.data.b.c<Boolean> aAj = new com.iqoption.core.data.b.c(Boolean.valueOf(false));
    private final LiveData<Boolean> aAk = this.aAj;
    private final com.iqoption.core.data.b.b<g> aAl = new com.iqoption.core.data.b.b();
    private final LiveData<g> aAm = this.aAl;
    private final Long azJ;
    private final MutableLiveData<k> azM = new MutableLiveData();
    private final LiveData<k> azN = this.azM;
    private String azO = "";
    private final com.iqoption.core.data.b.c<List<d>> azP = new com.iqoption.core.data.b.c(m.emptyList());
    private final LiveData<List<d>> azQ = this.azP;
    private final com.iqoption.core.data.b.c<Boolean> azR = new com.iqoption.core.data.b.c(Boolean.valueOf(false));
    private final LiveData<Boolean> azS = this.azR;
    private final com.iqoption.core.data.b.c<Boolean> azT = new com.iqoption.core.data.b.c(Boolean.valueOf(false));
    private final LiveData<Boolean> azU = this.azT;
    private final com.iqoption.core.data.b.c<Integer> azV = new com.iqoption.core.data.b.c(Integer.valueOf(1));
    private final LiveData<Integer> azW = this.azV;
    private final com.iqoption.core.data.b.c<Boolean> azX = new com.iqoption.core.data.b.c(Boolean.valueOf(true));
    private final LiveData<Boolean> azY = this.azX;
    private final com.iqoption.core.data.b.c<Boolean> azZ = new com.iqoption.core.data.b.c(Boolean.valueOf(false));

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, aXE = {"<anonymous>", "", "run", "com/iqoption/charttools/templates/TemplateViewModel$delete$1$1"})
    /* compiled from: TemplateViewModel.kt */
    static final class c implements Runnable {
        final /* synthetic */ TemplateViewModel aAq;

        c(TemplateViewModel templateViewModel) {
            this.aAq = templateViewModel;
        }

        public final void run() {
            com.iqoption.charttools.a.a aVar = com.iqoption.charttools.a.a.atr;
            int i = 0;
            int i2 = 0;
            for (d dVar : (Iterable) this.aAq.azP.getValue()) {
                if (dVar instanceof c) {
                    i++;
                } else if (dVar instanceof b) {
                    i2++;
                }
            }
            aVar.Y(i, i2);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
    /* compiled from: TemplateViewModel.kt */
    static final class f implements Runnable {
        public static final f aAv = new f();

        f() {
        }

        public final void run() {
            com.iqoption.charttools.a.a.atr.KA();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "initialState", "Lcom/iqoption/charttools/templates/TemplateInitialState;", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: TemplateViewModel.kt */
    /* renamed from: com.iqoption.charttools.templates.TemplateViewModel$2 */
    static final class AnonymousClass2<T> implements io.reactivex.c.e<k> {
        final /* synthetic */ TemplateViewModel aAq;

        AnonymousClass2(TemplateViewModel templateViewModel) {
            this.aAq = templateViewModel;
        }

        /* renamed from: c */
        public final void accept(k kVar) {
            TemplateViewModel templateViewModel = this.aAq;
            kotlin.jvm.internal.h.d(kVar, "initialState");
            templateViewModel.b(kVar);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u000f\u001a\u0002H\u0010\"\b\b\u0000\u0010\u0010*\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0013H\u0016¢\u0006\u0002\u0010\u0014J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000bJ\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u000bR\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\r8\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, aXE = {"Lcom/iqoption/charttools/templates/TemplateViewModel$Companion;", "Landroid/arch/lifecycle/ViewModelProvider$Factory;", "()V", "ACTIVES_PROVIDER", "Lcom/iqoption/charttools/templates/DistinctActivesProvider;", "DELETE_MODE_CONFIRMATION", "", "DELETE_MODE_HIDDEN", "DELETE_MODE_NORMAL", "DELETE_MODE_PROGRESS", "INPUT_DATA", "Lcom/iqoption/charttools/templates/TemplateInputData;", "TAG", "", "kotlin.jvm.PlatformType", "create", "T", "Landroid/arch/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroid/arch/lifecycle/ViewModel;", "get", "Lcom/iqoption/charttools/templates/TemplateViewModel;", "f", "Landroid/support/v4/app/Fragment;", "inputData", "a", "Landroid/support/v4/app/FragmentActivity;", "techtools_release"})
    /* compiled from: TemplateViewModel.kt */
    public static final class a implements Factory {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public <T extends ViewModel> T create(Class<T> cls) {
            kotlin.jvm.internal.h.e(cls, "modelClass");
            return new TemplateViewModel(TemplateViewModel.No(), TemplateViewModel.aAn);
        }

        public final TemplateViewModel a(Fragment fragment, l lVar) {
            ViewModelProvider viewModelProvider;
            kotlin.jvm.internal.h.e(fragment, "f");
            kotlin.jvm.internal.h.e(lVar, "inputData");
            a aVar = this;
            TemplateViewModel.aAo = lVar;
            Factory factory = this;
            if (factory != null) {
                viewModelProvider = new ViewModelProvider(ViewModelStores.e(fragment), factory);
            } else {
                viewModelProvider = ViewModelProviders.d(fragment);
                kotlin.jvm.internal.h.d(viewModelProvider, "ViewModelProviders.of(f)");
            }
            ViewModel h = viewModelProvider.h(TemplateViewModel.class);
            kotlin.jvm.internal.h.d(h, "if (factory != null) {\n …f(f)\n    }[T::class.java]");
            return (TemplateViewModel) h;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\u0016¨\u0006\u0006"}, aXE = {"com/iqoption/charttools/templates/TemplateViewModel$Companion$ACTIVES_PROVIDER$1", "Lcom/iqoption/charttools/templates/DistinctActivesProvider;", "get", "Lio/reactivex/Single;", "Landroid/util/SparseArray;", "Lcom/iqoption/core/microservices/tradingengine/response/active/Active;", "techtools_release"})
    /* compiled from: TemplateViewModel.kt */
    public static final class b implements a {
        b() {
        }

        public o<SparseArray<com.iqoption.core.microservices.tradingengine.response.active.a>> DF() {
            o<SparseArray<com.iqoption.core.microservices.tradingengine.response.active.a>> aVY = com.iqoption.asset.mediators.b.a(com.iqoption.asset.mediators.b.apW, null, 0, 0, false, 15, null).aVY();
            kotlin.jvm.internal.h.d(aVY, "AssetStreamMediator.getA…          .firstOrError()");
            return aVY;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, aXE = {"<anonymous>", "", "run", "com/iqoption/charttools/templates/TemplateViewModel$delete$1$2"})
    /* compiled from: TemplateViewModel.kt */
    static final class d implements io.reactivex.c.a {
        final /* synthetic */ TemplateViewModel aAq;

        d(TemplateViewModel templateViewModel) {
            this.aAq = templateViewModel;
        }

        public final void run() {
            this.aAq.aAl.postValue(h.azn);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept", "com/iqoption/charttools/templates/TemplateViewModel$delete$1$3"})
    /* compiled from: TemplateViewModel.kt */
    static final class e<T> implements io.reactivex.c.e<Throwable> {
        final /* synthetic */ TemplateViewModel aAq;

        e(TemplateViewModel templateViewModel) {
            this.aAq = templateViewModel;
        }

        /* renamed from: o */
        public final void accept(Throwable th) {
            com.iqoption.core.i.w(TemplateViewModel.TAG, "Error during deleting template", th);
            this.aAq.aAl.postValue(new m(com.iqoption.core.f.getString(com.iqoption.charttools.o.i.could_not_delete_template)));
            this.aAq.azV.setValue(Integer.valueOf(2));
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
    /* compiled from: TemplateViewModel.kt */
    static final class g implements io.reactivex.c.a {
        final /* synthetic */ TemplateViewModel aAq;

        g(TemplateViewModel templateViewModel) {
            this.aAq = templateViewModel;
        }

        public final void run() {
            this.aAq.aAl.postValue(n.azL);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: TemplateViewModel.kt */
    static final class h<T> implements io.reactivex.c.e<Throwable> {
        final /* synthetic */ TemplateViewModel aAq;

        h(TemplateViewModel templateViewModel) {
            this.aAq = templateViewModel;
        }

        /* renamed from: o */
        public final void accept(Throwable th) {
            com.iqoption.core.i.w(TemplateViewModel.TAG, "Error during saving template", th);
            this.aAq.aAl.postValue(new m(com.iqoption.core.f.getString(com.iqoption.charttools.o.i.could_not_save_template)));
            this.aAq.aAj.postValue(Boolean.valueOf(false));
        }
    }

    public static final /* synthetic */ l No() {
        l lVar = aAo;
        if (lVar == null) {
            kotlin.jvm.internal.h.lS("INPUT_DATA");
        }
        return lVar;
    }

    public TemplateViewModel(final l lVar, a aVar) {
        kotlin.jvm.internal.h.e(lVar, "inputData");
        kotlin.jvm.internal.h.e(aVar, "activesProvider");
        this.azJ = lVar.MW();
        io.reactivex.disposables.b a = aVar.DF().h(com.iqoption.core.h.i.Yo()).k(new io.reactivex.c.f<T, s<? extends R>>(this) {
            final /* synthetic */ TemplateViewModel aAq;

            /* renamed from: a */
            public final o<k> apply(final SparseArray<com.iqoption.core.microservices.tradingengine.response.active.a> sparseArray) {
                kotlin.jvm.internal.h.e(sparseArray, "actives");
                if (this.aAq.azJ != null) {
                    return r.asX.aI(this.aAq.azJ.longValue()).aVY().n(new io.reactivex.c.f<T, R>() {
                        /* renamed from: a */
                        public final k apply(com.iqoption.charttools.model.a.a aVar) {
                            kotlin.jvm.internal.h.e(aVar, "template");
                            SparseArray sparseArray = sparseArray;
                            kotlin.jvm.internal.h.d(sparseArray, "actives");
                            return new k(aVar, sparseArray);
                        }
                    });
                }
                if (lVar.MX() != null) {
                    return com.iqoption.charttools.f.arM.fn(lVar.KI()).n(new io.reactivex.c.f<T, R>(this) {
                        final /* synthetic */ AnonymousClass1 aAt;

                        /* renamed from: M */
                        public final k apply(List<com.iqoption.charttools.model.indicator.h> list) {
                            kotlin.jvm.internal.h.e(list, "instruments");
                            Iterable iterable = list;
                            ArrayList arrayList = new ArrayList();
                            ArrayList arrayList2 = new ArrayList();
                            for (Object next : iterable) {
                                if (((com.iqoption.charttools.model.indicator.h) next).KJ() instanceof k) {
                                    arrayList.add(next);
                                } else {
                                    arrayList2.add(next);
                                }
                            }
                            Pair pair = new Pair(arrayList, arrayList2);
                            List list2 = (List) pair.aXG();
                            List list3 = (List) pair.aXH();
                            SparseArray sparseArray = sparseArray;
                            kotlin.jvm.internal.h.d(sparseArray, "actives");
                            return new k(sparseArray, list3, list2, lVar.MX(), null, null, 48, null);
                        }
                    });
                }
                throw new IllegalArgumentException("Input data is invalid");
            }
        }).h(com.iqoption.core.h.i.Yo()).a((io.reactivex.c.e) new AnonymousClass2(this), (io.reactivex.c.e) AnonymousClass3.aAu);
        kotlin.jvm.internal.h.d(a, "activesProvider.get()\n  …error)\n                })");
        b(a);
    }

    public final LiveData<k> MZ() {
        return this.azN;
    }

    public final LiveData<List<d>> Na() {
        return this.azQ;
    }

    public final LiveData<Boolean> Nb() {
        return this.azS;
    }

    public final LiveData<Boolean> Nc() {
        return this.azU;
    }

    public final LiveData<Integer> Nd() {
        return this.azW;
    }

    public final LiveData<Boolean> Ne() {
        return this.azY;
    }

    public final LiveData<Boolean> Nf() {
        return this.aAa;
    }

    public final LiveData<Boolean> Ng() {
        return this.aAc;
    }

    public final LiveData<Boolean> Nh() {
        return this.aAe;
    }

    public final LiveData<Boolean> Ni() {
        return this.aAg;
    }

    public final LiveData<Boolean> Nj() {
        return this.aAi;
    }

    public final LiveData<Boolean> Nk() {
        return this.aAk;
    }

    public final LiveData<g> Nl() {
        return this.aAm;
    }

    @WorkerThread
    private final void b(k kVar) {
        this.azO = kVar.getName();
        this.azM.postValue(kVar);
        this.azP.postValue(kVar.Ik());
        this.azV.postValue(Integer.valueOf(this.azJ != null ? 2 : 1));
        com.iqoption.core.data.b.c cVar = this.azR;
        Iterable<d> Ik = kVar.Ik();
        boolean z = false;
        if (!(Ik instanceof Collection) || !((Collection) Ik).isEmpty()) {
            for (d dVar : Ik) {
                if (dVar instanceof b) {
                    z = true;
                    break;
                }
            }
        }
        cVar.postValue(Boolean.valueOf(z));
        this.azX.postValue(Boolean.valueOf(kVar.MR()));
        this.azZ.postValue(Boolean.valueOf(kVar.MS()));
        this.aAb.postValue(Boolean.valueOf(kVar.MT()));
        this.aAf.postValue(Boolean.valueOf(kVar.MU()));
        this.aAd.postValue(Boolean.valueOf(kVar.MV()));
        this.aAh.postValue(Boolean.valueOf(kVar.Ka()));
        this.azT.postValue(Boolean.valueOf(Nn()));
    }

    public final String getTitle() {
        int i;
        if (this.azJ == null) {
            i = com.iqoption.charttools.o.i.create_template;
        } else {
            i = com.iqoption.charttools.o.i.edit_template;
        }
        return com.iqoption.core.f.getString(i);
    }

    public final void d(d dVar) {
        kotlin.jvm.internal.h.e(dVar, "item");
        List list = (List) this.azP.getValue();
        if (list.isEmpty()) {
            com.iqoption.core.i.d(TAG, "Could not remove instrument: list is null or empty");
            return;
        }
        this.azP.setValue(u.d((Iterable) list, (Object) dVar));
        if (dVar instanceof c) {
            com.iqoption.charttools.a.a.atr.fy(((c) dVar).JS().KJ().getType());
        } else if (dVar instanceof b) {
            com.iqoption.charttools.a.a.atr.fy(((b) dVar).MM().KJ().getType());
            com.iqoption.core.data.b.c cVar = this.azR;
            Iterable<d> iterable = (Iterable) this.azP.getValue();
            boolean z = false;
            if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                for (d dVar2 : iterable) {
                    if (dVar2 instanceof b) {
                        z = true;
                        break;
                    }
                }
            }
            cVar.setValue(Boolean.valueOf(z));
        }
        Nm();
    }

    public final void e(d dVar) {
        kotlin.jvm.internal.h.e(dVar, "item");
        List<d> list = (List) this.azP.getValue();
        if (list.isEmpty()) {
            com.iqoption.core.i.d(TAG, "Could not update instrument: list is null or empty");
            return;
        }
        Object cVar;
        boolean isHidden;
        if (dVar instanceof c) {
            c cVar2 = (c) dVar;
            isHidden = cVar2.JS().isHidden() ^ 1;
            com.iqoption.charttools.a.a.atr.m(cVar2.JS().KJ().getType(), isHidden);
            cVar = new c(cVar2.getName(), com.iqoption.charttools.model.indicator.h.a(cVar2.JS(), null, 0, isHidden, null, 11, null), null, 4, null);
        } else if (dVar instanceof b) {
            b bVar = (b) dVar;
            isHidden = bVar.MM().isHidden() ^ 1;
            com.iqoption.charttools.a.a.atr.m(bVar.MM().KJ().getType(), isHidden);
            cVar = new b(bVar.getName(), bVar.ML(), com.iqoption.charttools.model.indicator.h.a(bVar.MM(), null, 0, isHidden, null, 11, null), null, 8, null);
        } else {
            cVar = null;
        }
        if (cVar == null) {
            com.iqoption.core.i.d(TAG, "Could not update instrument: type is not supported");
            return;
        }
        com.iqoption.core.data.b.c cVar3 = this.azP;
        int i = 0;
        for (d E : list) {
            if (kotlin.jvm.internal.h.E(E, dVar)) {
                break;
            }
            i++;
        }
        i = -1;
        cVar3.setValue(com.iqoption.core.ext.c.b(list, i, cVar));
        Nm();
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0049 A:{LOOP_END, LOOP:0: B:3:0x001e->B:17:0x0049} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x004d A:{SYNTHETIC, EDGE_INSN: B:47:0x004d->B:19:0x004d ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ac A:{LOOP_END, LOOP:1: B:26:0x0081->B:40:0x00ac} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00b0 A:{SYNTHETIC, EDGE_INSN: B:49:0x00b0->B:42:0x00b0 ?: BREAK  } */
    public final void j(com.iqoption.charttools.model.indicator.h r15) {
        /*
        r14 = this;
        r0 = "indicator";
        kotlin.jvm.internal.h.e(r15, r0);
        r0 = r14.azP;
        r0 = r0.getValue();
        r0 = (java.util.List) r0;
        r1 = r15.KJ();
        r1 = r1 instanceof com.iqoption.charttools.model.indicator.k;
        r2 = 0;
        r3 = -1;
        r4 = 1;
        r5 = 0;
        if (r1 == 0) goto L_0x007c;
    L_0x0019:
        r1 = r0.iterator();
        r6 = 0;
    L_0x001e:
        r7 = r1.hasNext();
        if (r7 == 0) goto L_0x004c;
    L_0x0024:
        r7 = r1.next();
        r7 = (com.iqoption.charttools.templates.d) r7;
        r8 = r7 instanceof com.iqoption.charttools.templates.b;
        if (r8 != 0) goto L_0x002f;
    L_0x002e:
        r7 = r2;
    L_0x002f:
        r7 = (com.iqoption.charttools.templates.b) r7;
        if (r7 == 0) goto L_0x0045;
    L_0x0033:
        r7 = r7.MM();
        if (r7 == 0) goto L_0x0045;
    L_0x0039:
        r7 = r7.getIndex();
        r8 = r15.getIndex();
        if (r7 != r8) goto L_0x0045;
    L_0x0043:
        r7 = 1;
        goto L_0x0046;
    L_0x0045:
        r7 = 0;
    L_0x0046:
        if (r7 == 0) goto L_0x0049;
    L_0x0048:
        goto L_0x004d;
    L_0x0049:
        r6 = r6 + 1;
        goto L_0x001e;
    L_0x004c:
        r6 = -1;
    L_0x004d:
        if (r6 == r3) goto L_0x00c9;
    L_0x004f:
        r1 = r0.get(r6);
        if (r1 != 0) goto L_0x005d;
    L_0x0055:
        r15 = new kotlin.TypeCastException;
        r0 = "null cannot be cast to non-null type com.iqoption.charttools.templates.FigureItem";
        r15.<init>(r0);
        throw r15;
    L_0x005d:
        r1 = (com.iqoption.charttools.templates.b) r1;
        r2 = new com.iqoption.charttools.templates.b;
        r8 = r1.getName();
        r9 = r1.ML();
        r11 = 0;
        r12 = 8;
        r13 = 0;
        r7 = r2;
        r10 = r15;
        r7.<init>(r8, r9, r10, r11, r12, r13);
        r15 = r14.azP;
        r0 = com.iqoption.core.ext.c.b(r0, r6, r2);
        r15.setValue(r0);
        goto L_0x00c9;
    L_0x007c:
        r1 = r0.iterator();
        r6 = 0;
    L_0x0081:
        r7 = r1.hasNext();
        if (r7 == 0) goto L_0x00af;
    L_0x0087:
        r7 = r1.next();
        r7 = (com.iqoption.charttools.templates.d) r7;
        r8 = r7 instanceof com.iqoption.charttools.templates.c;
        if (r8 != 0) goto L_0x0092;
    L_0x0091:
        r7 = r2;
    L_0x0092:
        r7 = (com.iqoption.charttools.templates.c) r7;
        if (r7 == 0) goto L_0x00a8;
    L_0x0096:
        r7 = r7.JS();
        if (r7 == 0) goto L_0x00a8;
    L_0x009c:
        r7 = r7.getIndex();
        r8 = r15.getIndex();
        if (r7 != r8) goto L_0x00a8;
    L_0x00a6:
        r7 = 1;
        goto L_0x00a9;
    L_0x00a8:
        r7 = 0;
    L_0x00a9:
        if (r7 == 0) goto L_0x00ac;
    L_0x00ab:
        goto L_0x00b0;
    L_0x00ac:
        r6 = r6 + 1;
        goto L_0x0081;
    L_0x00af:
        r6 = -1;
    L_0x00b0:
        if (r6 == r3) goto L_0x00c9;
    L_0x00b2:
        r1 = new com.iqoption.charttools.templates.c;
        r8 = r15.Ma();
        r10 = 0;
        r11 = 4;
        r12 = 0;
        r7 = r1;
        r9 = r15;
        r7.<init>(r8, r9, r10, r11, r12);
        r15 = r14.azP;
        r0 = com.iqoption.core.ext.c.b(r0, r6, r1);
        r15.setValue(r0);
    L_0x00c9:
        r14.Nm();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.charttools.templates.TemplateViewModel.j(com.iqoption.charttools.model.indicator.h):void");
    }

    @MainThread
    public final void bQ(boolean z) {
        this.azV.setValue(Integer.valueOf(z ? 3 : 2));
    }

    @MainThread
    public final void delete() {
        Long l = this.azJ;
        if (l != null) {
            long longValue = l.longValue();
            this.azV.setValue(Integer.valueOf(4));
            io.reactivex.disposables.b a = r.asX.aJ(longValue).d((io.reactivex.c) io.reactivex.a.p(new c(this))).b(com.iqoption.core.h.i.Yo()).a(new d(this), new e(this));
            kotlin.jvm.internal.h.d(a, "TemplateManager\n        …AL\n                    })");
            b(a);
        }
    }

    public final void save() {
        k kVar = (k) this.azN.getValue();
        if (kVar != null) {
            com.iqoption.charttools.model.chart.a aVar;
            io.reactivex.a a;
            this.aAj.setValue(Boolean.valueOf(true));
            if (kotlin.jvm.internal.h.E((Boolean) this.azY.getValue(), Boolean.valueOf(true))) {
                ChartType MP = kVar.MP();
                ChartColor MQ = kVar.MQ();
                Integer LR = kVar.LR();
                Boolean bool = (Boolean) this.aAa.getValue();
                if (bool == null) {
                    bool = Boolean.valueOf(false);
                }
                Boolean bool2 = bool;
                bool = (Boolean) this.aAc.getValue();
                if (bool == null) {
                    bool = Boolean.valueOf(false);
                }
                Boolean bool3 = bool;
                bool = (Boolean) this.aAg.getValue();
                if (bool == null) {
                    bool = Boolean.valueOf(false);
                }
                Boolean bool4 = bool;
                bool = (Boolean) this.aAe.getValue();
                if (bool == null) {
                    bool = Boolean.valueOf(false);
                }
                Boolean bool5 = bool;
                bool = (Boolean) this.aAi.getValue();
                if (bool == null) {
                    bool = Boolean.valueOf(false);
                }
                com.iqoption.charttools.model.chart.a aVar2 = new com.iqoption.charttools.model.chart.a(MP, MQ, LR, bool2, bool3, bool4, bool5, bool);
            } else {
                aVar = null;
            }
            Collection arrayList = new ArrayList();
            for (d dVar : (Iterable) this.azP.getValue()) {
                d dVar2;
                if (!(dVar2 instanceof c)) {
                    dVar2 = null;
                }
                c cVar = (c) dVar2;
                Object JS = cVar != null ? cVar.JS() : null;
                if (JS != null) {
                    arrayList.add(JS);
                }
            }
            List list = (List) arrayList;
            Collection arrayList2 = new ArrayList();
            for (d dVar3 : (Iterable) this.azP.getValue()) {
                d dVar32;
                if (!(dVar32 instanceof b)) {
                    dVar32 = null;
                }
                b bVar = (b) dVar32;
                Object MM = bVar != null ? bVar.MM() : null;
                if (MM != null) {
                    arrayList2.add(MM);
                }
            }
            List list2 = (List) arrayList2;
            if (this.azJ == null) {
                a = r.asX.a(this.azO, aVar, list, list2);
            } else {
                a = r.asX.a(this.azJ.longValue(), this.azO, aVar, list, list2);
            }
            io.reactivex.disposables.b a2 = a.d((io.reactivex.c) io.reactivex.a.p(f.aAv)).b(com.iqoption.core.h.i.Yo()).a(new g(this), new h(this));
            kotlin.jvm.internal.h.d(a2, "addOrUpdateTemplate\n    …false)\n                })");
            b(a2);
        }
    }

    public final void fF(String str) {
        kotlin.jvm.internal.h.e(str, "newTemplateName");
        if (!kotlin.jvm.internal.h.E(this.azO, str)) {
            this.azO = v.trim(str).toString();
            Nm();
        }
    }

    public final void bR(boolean z) {
        com.iqoption.charttools.a.a.atr.bG(z);
        a(this.azX, z);
    }

    public final void bS(boolean z) {
        com.iqoption.charttools.a.a.atr.bI(z);
        a(this.azZ, z);
    }

    public final void bT(boolean z) {
        com.iqoption.charttools.a.a.atr.bH(z);
        a(this.aAb, z);
    }

    public final void bU(boolean z) {
        com.iqoption.charttools.a.a.atr.bJ(z);
        a(this.aAf, z);
    }

    public final void setLiveDealsEnabled(boolean z) {
        com.iqoption.charttools.a.a.atr.bK(z);
        a(this.aAd, z);
    }

    public final void bF(boolean z) {
        com.iqoption.charttools.a.a.atr.bL(z);
        a(this.aAh, z);
    }

    private final void a(com.iqoption.core.data.b.c<Boolean> cVar, boolean z) {
        if (((Boolean) cVar.getValue()).booleanValue() != z) {
            cVar.setValue(Boolean.valueOf(z));
            Nm();
        }
    }

    private final void Nm() {
        com.iqoption.core.ext.a.a(this.azT, Boolean.valueOf(Nn()));
    }

    private final boolean Nn() {
        k kVar = (k) this.azN.getValue();
        if (kVar == null) {
            return false;
        }
        if ((((CharSequence) this.azO).length() == 0 ? 1 : null) != null || (((List) this.azP.getValue()).isEmpty() && kotlin.jvm.internal.h.E((Boolean) this.azY.getValue(), Boolean.valueOf(false)))) {
            return false;
        }
        if (this.azJ != null && (kotlin.jvm.internal.h.E(this.azO, kVar.getName()) ^ 1) == 0 && (kotlin.jvm.internal.h.E((Boolean) this.azY.getValue(), Boolean.valueOf(kVar.MR())) ^ 1) == 0 && (kotlin.jvm.internal.h.E((Boolean) this.aAa.getValue(), Boolean.valueOf(kVar.MS())) ^ 1) == 0 && (kotlin.jvm.internal.h.E((Boolean) this.aAc.getValue(), Boolean.valueOf(kVar.MT())) ^ 1) == 0 && (kotlin.jvm.internal.h.E((Boolean) this.aAg.getValue(), Boolean.valueOf(kVar.MU())) ^ 1) == 0 && (kotlin.jvm.internal.h.E((Boolean) this.aAe.getValue(), Boolean.valueOf(kVar.MV())) ^ 1) == 0 && (kotlin.jvm.internal.h.E((Boolean) this.aAi.getValue(), Boolean.valueOf(kVar.Ka())) ^ 1) == 0 && (kotlin.jvm.internal.h.E((List) this.azP.getValue(), kVar.Ik()) ^ 1) == 0) {
            return false;
        }
        return true;
    }
}
