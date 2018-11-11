package com.iqoption.welcomeonboarding.registration;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.FragmentActivity;
import io.reactivex.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00060\bj\b\u0012\u0004\u0012\u00020\u0006`\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J&\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0014\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\rH\u0002J\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\rH\u0002J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u000fR\u001c\u0010\u0003\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, aXE = {"Lcom/iqoption/welcomeonboarding/registration/CountryViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "countriesHttpSupplier", "Lcom/iqoption/core/rx/LiveStreamSupplier;", "", "Lcom/iqoption/core/microservices/configuration/response/Country;", "filteredComparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "filter", "", "getCountries", "Lio/reactivex/Single;", "useSocket", "", "getCountriesHttp", "getMyCountry", "getMyCountryCode", "Lcom/iqoption/core/microservices/core/response/MyCountryResponse;", "loadCountries", "Lio/reactivex/Completable;", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: CountryViewModel.kt */
public final class CountryViewModel extends ViewModel {
    public static final a dMN = new a();
    private com.iqoption.core.h.d<List<com.iqoption.core.microservices.configuration.a.c>> dMM;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, aXE = {"Lcom/iqoption/welcomeonboarding/registration/CountryViewModel$Companion;", "", "()V", "create", "Lcom/iqoption/welcomeonboarding/registration/CountryViewModel;", "activity", "Landroid/support/v4/app/FragmentActivity;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: CountryViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final CountryViewModel K(FragmentActivity fragmentActivity) {
            h.e(fragmentActivity, "activity");
            ViewModel h = ViewModelProviders.b(fragmentActivity).h(CountryViewModel.class);
            h.d(h, "ViewModelProviders.of(ac…tryViewModel::class.java)");
            return (CountryViewModel) h;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, aXE = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
    /* compiled from: Comparisons.kt */
    public static final class b<T> implements Comparator<T> {
        final /* synthetic */ String dMO;

        public b(String str) {
            this.dMO = str;
        }

        public final int compare(T t, T t2) {
            boolean z = false;
            Comparable valueOf = Boolean.valueOf(v.a((CharSequence) ((com.iqoption.core.microservices.configuration.a.c) t).getName(), this.dMO, 0, false, 6, null) != 0);
            if (v.a((CharSequence) ((com.iqoption.core.microservices.configuration.a.c) t2).getName(), this.dMO, 0, false, 6, null) != 0) {
                z = true;
            }
            return b.c(valueOf, Boolean.valueOf(z));
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, aXE = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenBy$1"})
    /* compiled from: Comparisons.kt */
    public static final class c<T> implements Comparator<T> {
        final /* synthetic */ Comparator cba;

        public c(Comparator comparator) {
            this.cba = comparator;
        }

        public final int compare(T t, T t2) {
            int compare = this.cba.compare(t, t2);
            return compare != 0 ? compare : b.c(((com.iqoption.core.microservices.configuration.a.c) t).getName(), ((com.iqoption.core.microservices.configuration.a.c) t2).getName());
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "Lcom/iqoption/core/microservices/configuration/response/Country;", "countries", "apply"})
    /* compiled from: CountryViewModel.kt */
    static final class d<T, R> implements io.reactivex.c.f<T, R> {
        final /* synthetic */ String dMP;

        d(String str) {
            this.dMP = str;
        }

        /* renamed from: m */
        public final List<com.iqoption.core.microservices.configuration.a.c> apply(List<com.iqoption.core.microservices.configuration.a.c> list) {
            h.e(list, "countries");
            if (this.dMP == null) {
                return list;
            }
            Collection arrayList = new ArrayList();
            for (Object next : list) {
                String name = ((com.iqoption.core.microservices.configuration.a.c) next).getName();
                if (name == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                name = name.toLowerCase();
                h.d(name, "(this as java.lang.String).toLowerCase()");
                CharSequence charSequence = name;
                String str = this.dMP;
                if (str == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                str = str.toLowerCase();
                h.d(str, "(this as java.lang.String).toLowerCase()");
                if (v.b(charSequence, (CharSequence) str, false, 2, null)) {
                    arrayList.add(next);
                }
            }
            return (List) arrayList;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "Lcom/iqoption/core/microservices/configuration/response/Country;", "countries", "apply"})
    /* compiled from: CountryViewModel.kt */
    static final class e<T, R> implements io.reactivex.c.f<T, R> {
        final /* synthetic */ String dMP;
        final /* synthetic */ CountryViewModel dMQ;

        @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, aXE = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
        /* compiled from: Comparisons.kt */
        public static final class a<T> implements Comparator<T> {
            public final int compare(T t, T t2) {
                return b.c(((com.iqoption.core.microservices.configuration.a.c) t).getName(), ((com.iqoption.core.microservices.configuration.a.c) t2).getName());
            }
        }

        e(CountryViewModel countryViewModel, String str) {
            this.dMQ = countryViewModel;
            this.dMP = str;
        }

        /* renamed from: m */
        public final List<com.iqoption.core.microservices.configuration.a.c> apply(List<com.iqoption.core.microservices.configuration.a.c> list) {
            h.e(list, "countries");
            if (this.dMP != null) {
                return u.a((Iterable) list, this.dMQ.km(this.dMP));
            }
            return u.a((Iterable) list, (Comparator) new a());
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "Lcom/iqoption/core/microservices/configuration/response/Country;", "countries", "", "countryCode", "Lcom/iqoption/core/microservices/core/response/MyCountryResponse;", "apply"})
    /* compiled from: CountryViewModel.kt */
    static final class f<T1, T2, R> implements io.reactivex.c.b<List<? extends com.iqoption.core.microservices.configuration.a.c>, com.iqoption.core.microservices.core.a.a, com.iqoption.core.microservices.configuration.a.c> {
        public static final f dMR = new f();

        f() {
        }

        /* renamed from: a */
        public final com.iqoption.core.microservices.configuration.a.c apply(List<com.iqoption.core.microservices.configuration.a.c> list, com.iqoption.core.microservices.core.a.a aVar) {
            h.e(list, "countries");
            h.e(aVar, "countryCode");
            for (Object next : list) {
                if (h.E(((com.iqoption.core.microservices.configuration.a.c) next).VE(), aVar.VI())) {
                    break;
                }
            }
            Object next2 = null;
            if (next2 == null) {
                h.aXZ();
            }
            return (com.iqoption.core.microservices.configuration.a.c) next2;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/core/microservices/configuration/response/Country;", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: CountryViewModel.kt */
    static final class g<T> implements io.reactivex.c.e<com.iqoption.core.microservices.configuration.a.c> {
        public static final g dMS = new g();

        g() {
        }

        /* renamed from: e */
        public final void accept(com.iqoption.core.microservices.configuration.a.c cVar) {
            com.iqoption.core.f.RQ().Ds().a("geo-ip", (double) cVar.Jf().longValue(), false);
        }
    }

    private final o<List<com.iqoption.core.microservices.configuration.a.c>> SM() {
        com.iqoption.core.h.d dVar = this.dMM;
        o<List<com.iqoption.core.microservices.configuration.a.c>> aVY;
        if (dVar != null) {
            aVY = dVar.Yg().aVY();
            h.d(aVY, "countriesHttpCacheLocal.get().firstOrError()");
            return aVY;
        }
        io.reactivex.e aWk = com.iqoption.core.data.repository.c.aOM.SM().aWk();
        h.d(aWk, "GeneralRepository.getCountriesHttp().toFlowable()");
        this.dMM = new com.iqoption.core.h.d(aWk, 0, null, 6, null);
        dVar = this.dMM;
        if (dVar == null) {
            h.aXZ();
        }
        aVY = dVar.Yg().aVY();
        h.d(aVY, "countriesHttpSupplier!!.get().firstOrError()");
        return aVY;
    }

    public static /* synthetic */ o a(CountryViewModel countryViewModel, boolean z, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = (String) null;
        }
        return countryViewModel.j(z, str);
    }

    public final o<List<com.iqoption.core.microservices.configuration.a.c>> j(boolean z, String str) {
        o aVY;
        if (z) {
            aVY = com.iqoption.core.data.repository.c.aOM.SN().aVY();
        } else {
            aVY = SM();
        }
        o<List<com.iqoption.core.microservices.configuration.a.c>> n = aVY.n(new d(str)).n(new e(this, str));
        h.d(n, "countriesSingle.map { co…}\n            }\n        }");
        return n;
    }

    public final o<com.iqoption.core.microservices.configuration.a.c> fv(boolean z) {
        o<com.iqoption.core.microservices.configuration.a.c> d = o.a(a(this, z, null, 2, null), aLT(), f.dMR).d(g.dMS);
        h.d(d, "Single.zip<List<Country>…ouble(), false)\n        }");
        return d;
    }

    private final o<com.iqoption.core.microservices.core.a.a> aLT() {
        return com.iqoption.core.data.repository.b.a(com.iqoption.core.data.repository.b.aOJ, null, 1, null);
    }

    private final Comparator<com.iqoption.core.microservices.configuration.a.c> km(String str) {
        return new c(new b(str));
    }
}
