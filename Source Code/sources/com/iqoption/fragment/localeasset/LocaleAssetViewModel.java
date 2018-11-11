package com.iqoption.fragment.localeasset;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.Fragment;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.microservices.configuration.a.c;
import com.iqoption.x.R;
import io.reactivex.c.e;
import io.reactivex.c.f;
import io.reactivex.disposables.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0011H\u0002J\b\u0010\u0019\u001a\u00020\u0015H\u0014J\u000e\u0010\u0010\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0011R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000bR\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, aXE = {"Lcom/iqoption/fragment/localeasset/LocaleAssetViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "TAG", "", "kotlin.jvm.PlatformType", "countries", "Landroid/arch/lifecycle/LiveData;", "", "Lcom/iqoption/fragment/localeasset/LocaleAssetContryItem;", "getCountries", "()Landroid/arch/lifecycle/LiveData;", "countriesData", "Landroid/arch/lifecycle/MutableLiveData;", "disposablesOnDestroy", "Lio/reactivex/disposables/CompositeDisposable;", "selectedCountry", "Lcom/iqoption/core/microservices/configuration/response/Country;", "getSelectedCountry", "selectedCountryData", "disposeOnDestroy", "", "disposable", "Lio/reactivex/disposables/Disposable;", "getDefaultCountry", "onCleared", "country", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: LocaleAssetViewModel.kt */
public final class LocaleAssetViewModel extends ViewModel {
    private static final List<String> cEs = m.listOf("es", "ch", "it", "de", "gb", "eu");
    public static final a cEt = new a();
    private final String TAG = LocaleAssetViewModel.class.getSimpleName();
    private final io.reactivex.disposables.a bbt = new io.reactivex.disposables.a();
    private final MutableLiveData<c> cEo = new MutableLiveData();
    private final LiveData<c> cEp = this.cEo;
    private final MutableLiveData<List<b>> cEq = new MutableLiveData();
    private final LiveData<List<b>> cEr = this.cEq;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, aXE = {"Lcom/iqoption/fragment/localeasset/LocaleAssetViewModel$Companion;", "", "()V", "avalilableTags", "", "", "getAvalilableTags", "()Ljava/util/List;", "create", "Lcom/iqoption/fragment/localeasset/LocaleAssetViewModel;", "fragment", "Landroid/support/v4/app/Fragment;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: LocaleAssetViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final List<String> amC() {
            return LocaleAssetViewModel.cEs;
        }

        public final LocaleAssetViewModel S(Fragment fragment) {
            h.e(fragment, "fragment");
            ViewModel h = ViewModelProviders.b(com.iqoption.core.ext.a.n(fragment)).h(LocaleAssetViewModel.class);
            h.d(h, "ViewModelProviders.of(fr…setViewModel::class.java)");
            return (LocaleAssetViewModel) h;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "Lcom/iqoption/fragment/localeasset/LocaleAssetContryItem;", "list", "Lcom/iqoption/core/microservices/configuration/response/Country;", "apply"})
    /* compiled from: LocaleAssetViewModel.kt */
    /* renamed from: com.iqoption.fragment.localeasset.LocaleAssetViewModel$1 */
    static final class AnonymousClass1<T, R> implements f<T, R> {
        final /* synthetic */ LocaleAssetViewModel cEu;

        @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, aXE = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
        /* compiled from: Comparisons.kt */
        public static final class a<T> implements Comparator<T> {
            public final int compare(T t, T t2) {
                return b.c(Boolean.valueOf(((b) t2).amu()), Boolean.valueOf(((b) t).amu()));
            }
        }

        AnonymousClass1(LocaleAssetViewModel localeAssetViewModel) {
            this.cEu = localeAssetViewModel;
        }

        /* renamed from: m */
        public final List<b> apply(List<c> list) {
            h.e(list, "list");
            Collection arrayList = new ArrayList();
            for (Object next : list) {
                c cVar = (c) next;
                List amC = LocaleAssetViewModel.cEt.amC();
                String VE = cVar.VE();
                if (VE == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                VE = VE.toLowerCase();
                h.d(VE, "(this as java.lang.String).toLowerCase()");
                if (amC.contains(VE)) {
                    arrayList.add(next);
                }
            }
            List i = u.i((Collection) (List) arrayList, (Object) this.cEu.amy());
            long Db = com.iqoption.core.f.RQ().Dr().Db();
            Iterable<c> iterable = i;
            for (Object next2 : iterable) {
                Object obj;
                if (((c) next2).Jf().longValue() == Db) {
                    obj = 1;
                    continue;
                } else {
                    obj = null;
                    continue;
                }
                if (obj != null) {
                    break;
                }
            }
            Object next22 = null;
            c cVar2 = (c) next22;
            if (cVar2 == null) {
                cVar2 = this.cEu.amy();
            }
            this.cEu.cEo.postValue(cVar2);
            arrayList = new ArrayList(n.e(iterable, 10));
            for (c cVar3 : iterable) {
                b bVar = new b(cVar3);
                bVar.eX(com.iqoption.app.helpers.a.FI().a(InstrumentType.CFD_INSTRUMENT, cVar3.VE()).size());
                bVar.dp(cVar3.Jf().longValue() == cVar2.Jf().longValue());
                bVar.do(cVar3.Jf().longValue() == cVar2.Jf().longValue());
                arrayList.add(bVar);
            }
            Collection arrayList2 = new ArrayList();
            for (Object next3 : (List) arrayList) {
                if ((((b) next3).amv() > 0 ? 1 : null) != null) {
                    arrayList2.add(next3);
                }
            }
            return u.a((Iterable) (List) arrayList2, (Comparator) new a());
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "", "it", "", "Lcom/iqoption/fragment/localeasset/LocaleAssetContryItem;", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: LocaleAssetViewModel.kt */
    /* renamed from: com.iqoption.fragment.localeasset.LocaleAssetViewModel$2 */
    static final class AnonymousClass2<T> implements e<List<? extends b>> {
        final /* synthetic */ LocaleAssetViewModel cEu;

        AnonymousClass2(LocaleAssetViewModel localeAssetViewModel) {
            this.cEu = localeAssetViewModel;
        }

        /* renamed from: C */
        public final void accept(List<b> list) {
            this.cEu.cEq.postValue(list);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: LocaleAssetViewModel.kt */
    /* renamed from: com.iqoption.fragment.localeasset.LocaleAssetViewModel$3 */
    static final class AnonymousClass3<T> implements e<Throwable> {
        final /* synthetic */ LocaleAssetViewModel cEu;

        AnonymousClass3(LocaleAssetViewModel localeAssetViewModel) {
            this.cEu = localeAssetViewModel;
        }

        /* renamed from: o */
        public final void accept(Throwable th) {
            this.cEu.cEq.postValue(null);
            com.iqoption.core.i.w(this.cEu.TAG, th);
        }
    }

    public LocaleAssetViewModel() {
        b a = com.iqoption.core.data.repository.c.aOM.SN().aVY().n(new AnonymousClass1(this)).h(com.iqoption.core.h.i.Yo()).a((e) new AnonymousClass2(this), (e) new AnonymousClass3(this));
        h.d(a, "GeneralRepository.getCou…      }\n                )");
        a(a);
    }

    private final c amy() {
        return new c(0, com.iqoption.core.f.getString(R.string.europe), 0, 0, 0, null, "eu", null, null, false, false, 1981, null);
    }

    public final LiveData<c> amz() {
        return this.cEp;
    }

    public final LiveData<List<b>> amA() {
        return this.cEr;
    }

    public final void d(c cVar) {
        Object obj;
        h.e(cVar, "country");
        this.cEo.postValue(cVar);
        MutableLiveData mutableLiveData = this.cEq;
        List list = (List) this.cEr.getValue();
        if (list != null) {
            Iterable<b> iterable = list;
            Collection arrayList = new ArrayList(n.e(iterable, 10));
            for (b bVar : iterable) {
                bVar.do(bVar.Jf().longValue() == cVar.Jf().longValue());
                arrayList.add(bVar);
            }
            obj = (List) arrayList;
        } else {
            obj = null;
        }
        mutableLiveData.postValue(obj);
    }

    private final void a(b bVar) {
        this.bbt.e(bVar);
    }

    protected void onCleared() {
        super.onCleared();
        this.bbt.clear();
    }
}
