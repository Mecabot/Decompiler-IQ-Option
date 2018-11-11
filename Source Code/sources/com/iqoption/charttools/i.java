package com.iqoption.charttools;

import com.iqoption.charttools.model.indicator.x;
import com.iqoption.core.data.d.c;
import io.reactivex.c.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;

@kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000bJ\u0012\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0016J\u000e\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000bJ\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\n*\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0012\u0010\u001b\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \u0007*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R'\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, aXE = {"Lcom/iqoption/charttools/FavoriteIndicatorsManager;", "", "()V", "PREF_KEY", "", "PREF_NAME", "TAG", "kotlin.jvm.PlatformType", "favoritesProcessor", "Lcom/iqoption/core/rx/IQBehaviorProcessor;", "", "Lcom/iqoption/charttools/model/indicator/MetaIndicator;", "getFavoritesProcessor", "()Lcom/iqoption/core/rx/IQBehaviorProcessor;", "favoritesProcessor$delegate", "Lkotlin/Lazy;", "prefs", "Lcom/iqoption/core/data/prefs/SharedPrefs;", "add", "Lio/reactivex/Completable;", "meta", "getFavorites", "Lio/reactivex/Flowable;", "remove", "deserialize", "library", "Lcom/iqoption/charttools/IndicatorsLibrary;", "serialize", "techtools_release"})
/* compiled from: FavoriteIndicatorsManager.kt */
public final class i {
    private static final String TAG = "i";
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(i.class), "favoritesProcessor", "getFavoritesProcessor()Lcom/iqoption/core/rx/IQBehaviorProcessor;"))};
    private static final c arI = new c("favorite_indicators");
    private static final d asg = g.f(FavoriteIndicatorsManager$favoritesProcessor$2.asj);
    public static final i ash = new i();

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "", "favorites", "", "Lcom/iqoption/charttools/model/indicator/MetaIndicator;", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: FavoriteIndicatorsManager.kt */
    static final class a<T> implements e<List<? extends x>> {
        final /* synthetic */ x asi;

        a(x xVar) {
            this.asi = xVar;
        }

        /* renamed from: C */
        public final void accept(List<? extends x> list) {
            if (!list.contains(this.asi)) {
                h.d(list, "favorites");
                List i = u.i((Collection) list, (Object) this.asi);
                i.ash.Kf().e(i);
                i.arI.put("uids", i.ash.H(i));
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "", "favorites", "", "Lcom/iqoption/charttools/model/indicator/MetaIndicator;", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: FavoriteIndicatorsManager.kt */
    static final class b<T> implements e<List<? extends x>> {
        final /* synthetic */ x asi;

        b(x xVar) {
            this.asi = xVar;
        }

        /* renamed from: C */
        public final void accept(List<? extends x> list) {
            if (list.contains(this.asi)) {
                h.d(list, "favorites");
                List d = u.d((Iterable) list, (Object) this.asi);
                i.ash.Kf().e(d);
                i.arI.put("uids", i.ash.H(d));
            }
        }
    }

    private final com.iqoption.core.h.a<List<x>> Kf() {
        d dVar = asg;
        j jVar = apP[0];
        return (com.iqoption.core.h.a) dVar.getValue();
    }

    private i() {
    }

    private final String H(List<? extends x> list) {
        return u.a(list, "|", null, null, 0, null, FavoriteIndicatorsManager$serialize$1.asn, 30, null);
    }

    private final List<x> a(String str, k kVar) {
        Collection arrayList = new ArrayList();
        for (String str2 : v.b((CharSequence) str, new String[]{"|"}, false, 0, 6, null)) {
            for (Object next : kVar.JT()) {
                if (h.E(((x) next).Ml(), str2)) {
                    break;
                }
            }
            Object next2 = null;
            x xVar = (x) next2;
            if (xVar != null) {
                arrayList.add(xVar);
            }
        }
        return (List) arrayList;
    }

    public final io.reactivex.e<List<x>> Kg() {
        return Kf();
    }

    public final io.reactivex.a a(x xVar) {
        h.e(xVar, "meta");
        io.reactivex.a aWj = Kf().aVY().d(new a(xVar)).aWj();
        h.d(aWj, "favoritesProcessor\n     …         .ignoreElement()");
        return aWj;
    }

    public final io.reactivex.a b(x xVar) {
        h.e(xVar, "meta");
        io.reactivex.a aWj = Kf().aVY().d(new b(xVar)).aWj();
        h.d(aWj, "favoritesProcessor\n     …         .ignoreElement()");
        return aWj;
    }
}
