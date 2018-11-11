package com.iqoption.charttools.constructor;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProvider.Factory;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.lifecycle.ViewModelStores;
import android.support.annotation.MainThread;
import android.support.v4.app.Fragment;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.iqoption.charttools.l;
import com.iqoption.charttools.model.indicator.constructor.InputItem;
import com.iqoption.charttools.model.indicator.x;
import com.iqoption.core.ui.viewmodel.DisposableViewModel;
import io.reactivex.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;

@kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 82\u00020\u0001:\u00018B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0007J\b\u0010$\u001a\u00020!H\u0007J\b\u0010%\u001a\u00020!H\u0007J\u000e\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'H\u0002J\b\u0010)\u001a\u00020!H\u0007J\b\u0010*\u001a\u00020!H\u0007J\b\u0010+\u001a\u00020!H\u0007J\u0010\u0010,\u001a\u00020!2\u0006\u0010-\u001a\u00020.H\u0007J\"\u0010/\u001a\u00020!2\b\b\u0002\u00100\u001a\u00020\u00122\u000e\b\u0002\u00101\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u0010\u00102\u001a\u00020!2\u0006\u00103\u001a\u000204H\u0007J\u0010\u00105\u001a\u00020!2\u0006\u00103\u001a\u00020\nH\u0002J\u0010\u00106\u001a\u00020!2\u0006\u00103\u001a\u000207H\u0007R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u000eX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\fR\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u000eX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\fR\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u000eX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00120\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\fR\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\u000eX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\fR\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000eX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000¨\u00069"}, aXE = {"Lcom/iqoption/charttools/constructor/IndicatorSettingsViewModel;", "Lcom/iqoption/core/ui/viewmodel/DisposableViewModel;", "inputData", "Lcom/iqoption/charttools/constructor/IndicatorSettingsInputData;", "(Lcom/iqoption/charttools/constructor/IndicatorSettingsInputData;)V", "constructor", "Lcom/iqoption/charttools/model/indicator/constructor/Constructor;", "inputItems", "Landroid/arch/lifecycle/LiveData;", "", "Lcom/iqoption/charttools/constructor/InputAdapterItem;", "getInputItems", "()Landroid/arch/lifecycle/LiveData;", "inputItemsData", "Lcom/iqoption/core/data/livedata/IQMutableLiveData;", "inputItemsHelper", "Lcom/iqoption/charttools/constructor/InputAdapterItemsHelper;", "isApplyButtonEnabled", "", "isApplyButtonEnabledData", "isInputHostOptionsOpened", "isInputHostOptionsOpenedData", "isInputSelectOptionsOpened", "isInputSelectOptionsOpenedData", "isRestoreButtonEnabled", "isRestoreButtonEnabledData", "title", "", "getTitle", "titleData", "values", "Lcom/google/gson/JsonArray;", "applyInputs", "", "outputViewModel", "Lcom/iqoption/charttools/constructor/IndicatorOutputViewModel;", "closeInputHostOptions", "closeInputSelectOptions", "collectValues", "Lio/reactivex/Single;", "Lcom/iqoption/charttools/model/indicator/ChartIndicator;", "openInputHostOptions", "openInputSelectOptions", "restoreInputs", "toggleGroupInfo", "item", "Lcom/iqoption/charttools/constructor/InputGroupTitle;", "updateButtonsState", "post", "items", "updateInputHost", "updated", "Lcom/iqoption/charttools/constructor/InputHost;", "updateInputItem", "updateInputSelect", "Lcom/iqoption/charttools/constructor/InputSelect;", "Companion", "techtools_release"})
/* compiled from: IndicatorSettingsViewModel.kt */
public final class IndicatorSettingsViewModel extends DisposableViewModel {
    private static final String TAG = "IndicatorSettingsViewModel";
    private static c atZ;
    public static final a aua = new a();
    private final e atJ = new e();
    private com.iqoption.charttools.model.indicator.constructor.a atK = com.iqoption.charttools.model.indicator.constructor.a.ayU.Ms();
    private JsonArray atL;
    private final com.iqoption.core.data.b.c<String> atM = new com.iqoption.core.data.b.c("");
    private final LiveData<String> atN = this.atM;
    private final com.iqoption.core.data.b.c<List<d>> atO = new com.iqoption.core.data.b.c(m.emptyList());
    private final LiveData<List<d>> atP = this.atO;
    private final com.iqoption.core.data.b.c<Boolean> atQ = new com.iqoption.core.data.b.c(Boolean.valueOf(false));
    private final LiveData<Boolean> atR = this.atQ;
    private final com.iqoption.core.data.b.c<Boolean> atS = new com.iqoption.core.data.b.c(Boolean.valueOf(true));
    private final LiveData<Boolean> atT = this.atS;
    private final com.iqoption.core.data.b.c<Boolean> atU = new com.iqoption.core.data.b.c(Boolean.valueOf(false));
    private final LiveData<Boolean> atV = this.atU;
    private final com.iqoption.core.data.b.c<Boolean> atW = new com.iqoption.core.data.b.c(Boolean.valueOf(false));
    private final LiveData<Boolean> atX = this.atW;
    private final c atY;

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "Lcom/iqoption/charttools/model/indicator/ChartIndicator;", "call"})
    /* compiled from: IndicatorSettingsViewModel.kt */
    static final class g<V> implements Callable<T> {
        final /* synthetic */ IndicatorSettingsViewModel this$0;

        g(IndicatorSettingsViewModel indicatorSettingsViewModel) {
            this.this$0 = indicatorSettingsViewModel;
        }

        /* renamed from: KY */
        public final com.iqoption.charttools.model.indicator.h call() {
            JsonArray a = this.this$0.atJ.a(this.this$0.atY.getActiveId(), this.this$0.atK.f(this.this$0.atL), (List) this.this$0.atO.getValue());
            com.iqoption.charttools.model.indicator.h JS = this.this$0.atY.JS();
            if (JS != null) {
                com.iqoption.charttools.model.indicator.h a2 = com.iqoption.charttools.model.indicator.h.a(JS, null, 0, false, a, 7, null);
                if (a2 != null) {
                    return a2;
                }
            }
            return new com.iqoption.charttools.model.indicator.h(this.this$0.atY.KJ(), 0, false, a);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "", "it", "", "Lcom/iqoption/charttools/constructor/InputAdapterItem;", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: IndicatorSettingsViewModel.kt */
    /* renamed from: com.iqoption.charttools.constructor.IndicatorSettingsViewModel$1 */
    static final class AnonymousClass1<T> implements io.reactivex.c.e<List<? extends d>> {
        final /* synthetic */ IndicatorSettingsViewModel this$0;

        AnonymousClass1(IndicatorSettingsViewModel indicatorSettingsViewModel) {
            this.this$0 = indicatorSettingsViewModel;
        }

        /* renamed from: C */
        public final void accept(List<? extends d> list) {
            com.iqoption.core.data.b.c e = this.this$0.atO;
            kotlin.jvm.internal.h.d(list, "it");
            Object obj = (((Collection) list).isEmpty() ^ 1) != 0 ? list : null;
            if (obj == null) {
                obj = l.cr(a.ats);
            }
            e.postValue(obj);
            IndicatorSettingsViewModel indicatorSettingsViewModel = this.this$0;
            kotlin.jvm.internal.h.d(list, "it");
            indicatorSettingsViewModel.a(true, (List) list);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J'\u0010\b\u001a\u0002H\t\"\n\b\u0000\u0010\t*\u0004\u0018\u00010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\t0\fH\u0016¢\u0006\u0002\u0010\rJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, aXE = {"Lcom/iqoption/charttools/constructor/IndicatorSettingsViewModel$Companion;", "Landroid/arch/lifecycle/ViewModelProvider$Factory;", "()V", "INPUT_DATA", "Lcom/iqoption/charttools/constructor/IndicatorSettingsInputData;", "TAG", "", "kotlin.jvm.PlatformType", "create", "T", "Landroid/arch/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroid/arch/lifecycle/ViewModel;", "get", "Lcom/iqoption/charttools/constructor/IndicatorSettingsViewModel;", "f", "Landroid/support/v4/app/Fragment;", "inputData", "techtools_release"})
    /* compiled from: IndicatorSettingsViewModel.kt */
    public static final class a implements Factory {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public <T extends ViewModel> T create(Class<T> cls) {
            kotlin.jvm.internal.h.e(cls, "modelClass");
            return new IndicatorSettingsViewModel(IndicatorSettingsViewModel.KX());
        }

        public final IndicatorSettingsViewModel a(Fragment fragment, c cVar) {
            ViewModelProvider viewModelProvider;
            kotlin.jvm.internal.h.e(fragment, "f");
            kotlin.jvm.internal.h.e(cVar, "inputData");
            a aVar = this;
            IndicatorSettingsViewModel.atZ = cVar;
            Factory factory = this;
            if (factory != null) {
                viewModelProvider = new ViewModelProvider(ViewModelStores.e(fragment), factory);
            } else {
                viewModelProvider = ViewModelProviders.d(fragment);
                kotlin.jvm.internal.h.d(viewModelProvider, "ViewModelProviders.of(f)");
            }
            ViewModel h = viewModelProvider.h(IndicatorSettingsViewModel.class);
            kotlin.jvm.internal.h.d(h, "if (factory != null) {\n …f(f)\n    }[T::class.java]");
            return (IndicatorSettingsViewModel) h;
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "indicator", "Lcom/iqoption/charttools/model/indicator/ChartIndicator;", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: IndicatorSettingsViewModel.kt */
    static final class b<T> implements io.reactivex.c.e<com.iqoption.charttools.model.indicator.h> {
        final /* synthetic */ IndicatorOutputViewModel auc;

        b(IndicatorOutputViewModel indicatorOutputViewModel) {
            this.auc = indicatorOutputViewModel;
        }

        /* renamed from: e */
        public final void accept(com.iqoption.charttools.model.indicator.h hVar) {
            com.iqoption.core.i.d(IndicatorSettingsViewModel.TAG, "Completed");
            IndicatorOutputViewModel indicatorOutputViewModel = this.auc;
            kotlin.jvm.internal.h.d(hVar, "indicator");
            indicatorOutputViewModel.d(hVar);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "error", "", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: IndicatorSettingsViewModel.kt */
    static final class c<T> implements io.reactivex.c.e<Throwable> {
        public static final c aud = new c();

        c() {
        }

        /* renamed from: o */
        public final void accept(Throwable th) {
            com.iqoption.core.i.w(IndicatorSettingsViewModel.TAG, "Could not apply inputs", th);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "Lio/reactivex/CompletableSource;", "kotlin.jvm.PlatformType", "indicator", "Lcom/iqoption/charttools/model/indicator/ChartIndicator;", "apply"})
    /* compiled from: IndicatorSettingsViewModel.kt */
    static final class d<T, R> implements io.reactivex.c.f<com.iqoption.charttools.model.indicator.h, io.reactivex.c> {
        final /* synthetic */ IndicatorSettingsViewModel this$0;

        d(IndicatorSettingsViewModel indicatorSettingsViewModel) {
            this.this$0 = indicatorSettingsViewModel;
        }

        /* renamed from: f */
        public final io.reactivex.c apply(com.iqoption.charttools.model.indicator.h hVar) {
            kotlin.jvm.internal.h.e(hVar, "indicator");
            if (hVar.getIndex() != 0) {
                return com.iqoption.charttools.f.a(com.iqoption.charttools.f.arM, this.this$0.atY.KI(), hVar.getIndex(), null, hVar.Mc(), false, 20, null);
            }
            return com.iqoption.charttools.f.arM.a(this.this$0.atY.KI(), hVar.KJ(), hVar.Mc()).aWj();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
    /* compiled from: IndicatorSettingsViewModel.kt */
    static final class e implements io.reactivex.c.a {
        public static final e aue = new e();

        e() {
        }

        public final void run() {
            com.iqoption.core.i.d(IndicatorSettingsViewModel.TAG, "Completed");
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "error", "", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: IndicatorSettingsViewModel.kt */
    static final class f<T> implements io.reactivex.c.e<Throwable> {
        public static final f auf = new f();

        f() {
        }

        /* renamed from: o */
        public final void accept(Throwable th) {
            com.iqoption.core.i.w(IndicatorSettingsViewModel.TAG, "Could not apply inputs", th);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/charttools/model/indicator/constructor/Constructor;", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: IndicatorSettingsViewModel.kt */
    static final class h<T> implements io.reactivex.c.e<com.iqoption.charttools.model.indicator.constructor.a> {
        final /* synthetic */ x asi;
        final /* synthetic */ IndicatorSettingsViewModel this$0;

        h(IndicatorSettingsViewModel indicatorSettingsViewModel, x xVar) {
            this.this$0 = indicatorSettingsViewModel;
            this.asi = xVar;
        }

        /* renamed from: a */
        public final void accept(com.iqoption.charttools.model.indicator.constructor.a aVar) {
            IndicatorSettingsViewModel indicatorSettingsViewModel = this.this$0;
            kotlin.jvm.internal.h.d(aVar, "it");
            indicatorSettingsViewModel.atK = aVar;
            this.this$0.atM.postValue(this.asi.Mi());
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, aXE = {"<anonymous>", "", "Lcom/iqoption/charttools/constructor/InputAdapterItem;", "hosts", "Lcom/iqoption/charttools/model/indicator/constructor/FigureHost;", "constructor", "Lcom/iqoption/charttools/model/indicator/constructor/Constructor;", "apply"})
    /* compiled from: IndicatorSettingsViewModel.kt */
    static final class i<T1, T2, R> implements io.reactivex.c.b<List<? extends com.iqoption.charttools.model.indicator.constructor.b>, com.iqoption.charttools.model.indicator.constructor.a, List<? extends d>> {
        final /* synthetic */ kotlin.jvm.a.a aug;
        final /* synthetic */ IndicatorSettingsViewModel this$0;

        i(IndicatorSettingsViewModel indicatorSettingsViewModel, kotlin.jvm.a.a aVar) {
            this.this$0 = indicatorSettingsViewModel;
            this.aug = aVar;
        }

        /* renamed from: a */
        public final List<d> apply(List<com.iqoption.charttools.model.indicator.constructor.b> list, com.iqoption.charttools.model.indicator.constructor.a aVar) {
            List list2;
            kotlin.jvm.internal.h.e(list, "hosts");
            kotlin.jvm.internal.h.e(aVar, "constructor");
            e b = this.this$0.atJ;
            InputItem[] f = aVar.f(this.this$0.atL);
            com.iqoption.charttools.model.indicator.constructor.c[] Mq = aVar.Mq();
            JsonArray d = this.this$0.atL;
            if (d != null) {
                Iterable<JsonElement> iterable = d;
                Collection arrayList = new ArrayList(n.e(iterable, 10));
                for (JsonElement jsonElement : iterable) {
                    kotlin.jvm.internal.h.d(jsonElement, "it");
                    arrayList.add(jsonElement.getAsString());
                }
                list2 = (List) arrayList;
            } else {
                list2 = aVar.Mp();
            }
            return b.a(f, Mq, list2, list, this.this$0.atL == null, this.aug);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "Lcom/iqoption/charttools/constructor/InputAdapterItem;", "constructor", "Lcom/iqoption/charttools/model/indicator/constructor/Constructor;", "apply"})
    /* compiled from: IndicatorSettingsViewModel.kt */
    static final class j<T, R> implements io.reactivex.c.f<T, R> {
        final /* synthetic */ kotlin.jvm.a.a aug;
        final /* synthetic */ IndicatorSettingsViewModel this$0;

        j(IndicatorSettingsViewModel indicatorSettingsViewModel, kotlin.jvm.a.a aVar) {
            this.this$0 = indicatorSettingsViewModel;
            this.aug = aVar;
        }

        /* renamed from: b */
        public final List<d> apply(com.iqoption.charttools.model.indicator.constructor.a aVar) {
            kotlin.jvm.internal.h.e(aVar, "constructor");
            return this.this$0.atJ.a(aVar.f(this.this$0.atL), aVar.Mq(), aVar.Mp(), m.emptyList(), false, this.aug);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "Lcom/iqoption/charttools/model/indicator/constructor/FigureHost;", "indicators", "Lcom/iqoption/charttools/model/indicator/ChartIndicator;", "apply"})
    /* compiled from: IndicatorSettingsViewModel.kt */
    static final class k<T, R> implements io.reactivex.c.f<T, R> {
        public static final k auh = new k();

        k() {
        }

        /* renamed from: m */
        public final List<com.iqoption.charttools.model.indicator.constructor.b> apply(List<com.iqoption.charttools.model.indicator.h> list) {
            kotlin.jvm.internal.h.e(list, "indicators");
            return m.f(m.f(m.b(u.ac(list), IndicatorSettingsViewModel$itemsStream$hostsStream$1$1.aui), IndicatorSettingsViewModel$itemsStream$hostsStream$1$2.auj));
        }
    }

    public IndicatorSettingsViewModel(c cVar) {
        o a;
        kotlin.jvm.internal.h.e(cVar, "inputData");
        this.atY = cVar;
        x KJ = this.atY.KJ();
        this.atK = com.iqoption.charttools.model.indicator.constructor.a.ayU.Ms();
        com.iqoption.charttools.model.indicator.h JS = this.atY.JS();
        this.atL = JS != null ? JS.Mc() : null;
        this.atM.setValue("");
        this.atO.setValue(l.cr(x.avb));
        this.atQ.setValue(Boolean.valueOf(false));
        this.atS.setValue(Boolean.valueOf(false));
        this.atW.setValue(Boolean.valueOf(false));
        this.atU.setValue(Boolean.valueOf(false));
        kotlin.jvm.a.a indicatorSettingsViewModel$onChanged$1 = new IndicatorSettingsViewModel$onChanged$1(this);
        o d = l.a(l.asx, KJ, null, 2, null).d(new h(this, KJ));
        if (KJ instanceof com.iqoption.charttools.model.indicator.k) {
            a = o.a(com.iqoption.charttools.f.arM.fn(this.atY.KI()).n(k.auh), d, new i(this, indicatorSettingsViewModel$onChanged$1));
        } else {
            a = d.n(new j(this, indicatorSettingsViewModel$onChanged$1));
        }
        io.reactivex.disposables.b a2 = a.h(com.iqoption.core.h.i.Yo()).a((io.reactivex.c.e) new AnonymousClass1(this), (io.reactivex.c.e) AnonymousClass2.aub);
        kotlin.jvm.internal.h.d(a2, "itemsStream\n            …\", it)\n                })");
        b(a2);
    }

    public static final /* synthetic */ c KX() {
        c cVar = atZ;
        if (cVar == null) {
            kotlin.jvm.internal.h.lS("INPUT_DATA");
        }
        return cVar;
    }

    public final LiveData<String> KL() {
        return this.atN;
    }

    public final LiveData<List<d>> KM() {
        return this.atP;
    }

    public final LiveData<Boolean> KN() {
        return this.atR;
    }

    public final LiveData<Boolean> KO() {
        return this.atT;
    }

    public final LiveData<Boolean> KP() {
        return this.atV;
    }

    public final LiveData<Boolean> KQ() {
        return this.atX;
    }

    @MainThread
    public final void b(s sVar) {
        kotlin.jvm.internal.h.e(sVar, "updated");
        a((d) sVar);
    }

    @MainThread
    public final void b(m mVar) {
        kotlin.jvm.internal.h.e(mVar, "updated");
        a((d) mVar);
    }

    private final void a(d dVar) {
        com.iqoption.core.data.b.c cVar = this.atO;
        List<d> O = u.O((Collection) this.atO.getValue());
        int i = 0;
        for (d Je : O) {
            if ((Je.Jf().intValue() == dVar.Jf().intValue() ? 1 : null) != null) {
                break;
            }
            i++;
        }
        i = -1;
        if (i != -1) {
            O.set(i, dVar);
        }
        cVar.setValue(O);
        a(this, false, null, 3, null);
    }

    @MainThread
    public final void KR() {
        this.atU.setValue(Boolean.valueOf(true));
    }

    @MainThread
    public final void KS() {
        this.atU.setValue(Boolean.valueOf(false));
    }

    @MainThread
    public final void KT() {
        this.atW.setValue(Boolean.valueOf(true));
    }

    @MainThread
    public final void KU() {
        this.atW.setValue(Boolean.valueOf(false));
    }

    @MainThread
    public final void b(l lVar) {
        kotlin.jvm.internal.h.e(lVar, "item");
        lVar.setExpanded(lVar.isExpanded() ^ true);
        com.iqoption.core.data.b.c cVar = this.atO;
        List<d> O = u.O((Collection) this.atO.getValue());
        int i = 0;
        for (d Je : O) {
            if ((Je.Jf().intValue() == lVar.Jf().intValue() ? 1 : null) != null) {
                break;
            }
            i++;
        }
        i = -1;
        if (i != -1) {
            if (lVar.isExpanded()) {
                i++;
                int intValue = lVar.Jf().intValue() + 1;
                String description = lVar.Lh().getDescription();
                if (description == null) {
                    description = "";
                }
                O.add(i, new k(intValue, description, lVar.Lh()));
            } else {
                O.remove(i + 1);
            }
        }
        cVar.setValue(O);
    }

    static /* synthetic */ void a(IndicatorSettingsViewModel indicatorSettingsViewModel, boolean z, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            list = (List) indicatorSettingsViewModel.atO.getValue();
        }
        indicatorSettingsViewModel.a(z, list);
    }

    private final void a(boolean z, List<? extends d> list) {
        boolean z2;
        int size = list.size();
        Boolean bool = null;
        Boolean bool2 = null;
        boolean z3 = false;
        if (size == 0) {
            bool = Boolean.valueOf(false);
        }
        Boolean bool3 = bool;
        int i = 0;
        while (true) {
            z2 = true;
            if (i < size) {
                if (bool2 == null && !((d) list.get(i)).isDefault()) {
                    bool2 = Boolean.valueOf(true);
                }
                if (bool3 == null && ((d) list.get(i)).KZ() && !((d) list.get(i)).isValid()) {
                    bool3 = Boolean.valueOf(false);
                }
                if (bool2 != null && r4 != null) {
                    break;
                }
                i++;
            } else {
                break;
            }
        }
        com.iqoption.core.data.b.c cVar;
        if (z) {
            cVar = this.atQ;
            if (bool2 != null) {
                z3 = bool2.booleanValue();
            }
            cVar.postValue(Boolean.valueOf(z3));
            cVar = this.atS;
            if (bool3 != null) {
                z2 = bool3.booleanValue();
            }
            cVar.postValue(Boolean.valueOf(z2));
            return;
        }
        cVar = this.atQ;
        if (bool2 != null) {
            z3 = bool2.booleanValue();
        }
        cVar.setValue(Boolean.valueOf(z3));
        cVar = this.atS;
        if (bool3 != null) {
            z2 = bool3.booleanValue();
        }
        cVar.setValue(Boolean.valueOf(z2));
    }

    @MainThread
    public final void KV() {
        com.iqoption.core.data.b.c cVar = this.atO;
        Iterable<d> iterable = (Iterable) this.atO.getValue();
        Collection arrayList = new ArrayList(n.e(iterable, 10));
        for (d Lb : iterable) {
            arrayList.add(Lb.Lb());
        }
        cVar.setValue((List) arrayList);
        this.atQ.setValue(Boolean.valueOf(false));
        this.atS.setValue(Boolean.valueOf(true));
    }

    @MainThread
    public final void a(IndicatorOutputViewModel indicatorOutputViewModel) {
        kotlin.jvm.internal.h.e(indicatorOutputViewModel, "outputViewModel");
        if (this.atY.KK()) {
            KW().h(com.iqoption.core.h.i.Yo()).a((io.reactivex.c.e) new b(indicatorOutputViewModel), (io.reactivex.c.e) c.aud);
        } else {
            KW().i(new d(this)).b(com.iqoption.core.h.i.Yo()).a(e.aue, f.auf);
        }
    }

    private final o<com.iqoption.charttools.model.indicator.h> KW() {
        o<com.iqoption.charttools.model.indicator.h> h = o.h((Callable) new g(this));
        kotlin.jvm.internal.h.d(h, "Single\n                .…      }\n                }");
        return h;
    }
}
