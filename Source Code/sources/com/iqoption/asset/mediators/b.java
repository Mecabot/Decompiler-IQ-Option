package com.iqoption.asset.mediators;

import android.util.SparseArray;
import com.iqoption.core.data.model.InstrumentType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.TypeCastException;

@kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002&'B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002JF\u0010\u000f\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00100\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\fJ:\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00160\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\fJ$\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00110\u00062\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J*\u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u00100\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J>\u0010\u001d\u001a\"\u0012\u001e\u0012\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001e0\u00100\u00100\u00062\u0006\u0010\b\u001a\u00020\t2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0011H\u0002J$\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u00112\u0006\u0010$\u001a\u00020\u0004H\u0002J\u001a\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u00110\u00062\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006("}, aXE = {"Lcom/iqoption/asset/mediators/AssetStreamMediator;", "", "()V", "binaryTurboMerger", "Lcom/iqoption/asset/mediators/AssetStreamMediator$TypeMerger;", "getActiveFlowable", "Lio/reactivex/Flowable;", "Lcom/iqoption/asset/mediators/AssetStreamMediator$InstrumentActives;", "userId", "", "groupId", "isRegulate", "", "instrumentType", "Lcom/iqoption/core/data/model/InstrumentType;", "getActives", "", "", "Lcom/iqoption/core/microservices/tradingengine/response/active/Active;", "params", "Lcom/iqoption/asset/mediators/AssetStreamParams;", "getActivesDistinct", "Landroid/util/SparseArray;", "getCommissions", "Lcom/iqoption/core/microservices/risks/response/commission/CommissionData;", "userGroupId", "getLeverages", "", "Lcom/iqoption/core/microservices/tradingengine/response/leverage/LeverageInfo;", "getSpreadsFlowable", "Lcom/iqoption/core/microservices/topassets/response/spread/SpreadData;", "instrumentTypes", "mergeItems", "", "Lcom/iqoption/asset/mediators/AssetDisplayData;", "items", "typeMerger", "observeAssetDisplayData", "InstrumentActives", "TypeMerger", "asset_release"})
/* compiled from: AssetStreamMediator.kt */
public final class b {
    private static final b apV = new b(m.listOf(InstrumentType.TURBO_INSTRUMENT, InstrumentType.BINARY_INSTRUMENT));
    public static final b apW = new b();

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, aXE = {"Lcom/iqoption/asset/mediators/AssetStreamMediator$InstrumentActives;", "", "instrumentType", "Lcom/iqoption/core/data/model/InstrumentType;", "actives", "", "Lcom/iqoption/core/microservices/tradingengine/response/active/Active;", "(Lcom/iqoption/core/data/model/InstrumentType;Ljava/util/List;)V", "getActives", "()Ljava/util/List;", "getInstrumentType", "()Lcom/iqoption/core/data/model/InstrumentType;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "asset_release"})
    /* compiled from: AssetStreamMediator.kt */
    public static final class a {
        private final List<com.iqoption.core.microservices.tradingengine.response.active.a> apX;
        private final InstrumentType instrumentType;

        /* JADX WARNING: Missing block: B:6:0x001a, code:
            if (kotlin.jvm.internal.h.E(r2.apX, r3.apX) != false) goto L_0x001f;
     */
        public boolean equals(java.lang.Object r3) {
            /*
            r2 = this;
            if (r2 == r3) goto L_0x001f;
        L_0x0002:
            r0 = r3 instanceof com.iqoption.asset.mediators.b.a;
            if (r0 == 0) goto L_0x001d;
        L_0x0006:
            r3 = (com.iqoption.asset.mediators.b.a) r3;
            r0 = r2.instrumentType;
            r1 = r3.instrumentType;
            r0 = kotlin.jvm.internal.h.E(r0, r1);
            if (r0 == 0) goto L_0x001d;
        L_0x0012:
            r0 = r2.apX;
            r3 = r3.apX;
            r3 = kotlin.jvm.internal.h.E(r0, r3);
            if (r3 == 0) goto L_0x001d;
        L_0x001c:
            goto L_0x001f;
        L_0x001d:
            r3 = 0;
            return r3;
        L_0x001f:
            r3 = 1;
            return r3;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iqoption.asset.mediators.b.a.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            InstrumentType instrumentType = this.instrumentType;
            int i = 0;
            int hashCode = (instrumentType != null ? instrumentType.hashCode() : 0) * 31;
            List list = this.apX;
            if (list != null) {
                i = list.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("InstrumentActives(instrumentType=");
            stringBuilder.append(this.instrumentType);
            stringBuilder.append(", actives=");
            stringBuilder.append(this.apX);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public a(InstrumentType instrumentType, List<? extends com.iqoption.core.microservices.tradingengine.response.active.a> list) {
            kotlin.jvm.internal.h.e(instrumentType, "instrumentType");
            kotlin.jvm.internal.h.e(list, "actives");
            this.instrumentType = instrumentType;
            this.apX = list;
        }

        public final InstrumentType getInstrumentType() {
            return this.instrumentType;
        }

        public final List<com.iqoption.core.microservices.tradingengine.response.active.a> Jj() {
            return this.apX;
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, aXE = {"Lcom/iqoption/asset/mediators/AssetStreamMediator$TypeMerger;", "", "orderedTypesToMerge", "", "Lcom/iqoption/core/data/model/InstrumentType;", "(Ljava/util/List;)V", "getPriority", "", "instrumentType", "asset_release"})
    /* compiled from: AssetStreamMediator.kt */
    public static final class b {
        private final List<InstrumentType> apY;

        public b(List<? extends InstrumentType> list) {
            kotlin.jvm.internal.h.e(list, "orderedTypesToMerge");
            this.apY = list;
        }

        public final int s(InstrumentType instrumentType) {
            kotlin.jvm.internal.h.e(instrumentType, "instrumentType");
            int indexOf = this.apY.indexOf(instrumentType);
            return indexOf != -1 ? indexOf : ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "Lcom/iqoption/core/microservices/tradingengine/response/active/InstrumentActive;", "it", "Lcom/iqoption/core/microservices/tradingengine/response/active/UnderlyingResult;", "apply"})
    /* compiled from: AssetStreamMediator.kt */
    static final class c<T, R> implements io.reactivex.c.f<T, R> {
        public static final c apZ = new c();

        c() {
        }

        /* renamed from: a */
        public final List<com.iqoption.core.microservices.tradingengine.response.active.h> apply(com.iqoption.core.microservices.tradingengine.response.active.l lVar) {
            kotlin.jvm.internal.h.e(lVar, "it");
            return lVar.Xv();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "Lcom/iqoption/core/microservices/tradingengine/response/active/TurboBinaryActive;", "it", "Lcom/iqoption/core/microservices/tradingengine/response/active/ActiveSettingResult$ActiveSetting;", "apply"})
    /* compiled from: AssetStreamMediator.kt */
    static final class d<T, R> implements io.reactivex.c.f<T, R> {
        final /* synthetic */ InstrumentType aqa;

        d(InstrumentType instrumentType) {
            this.aqa = instrumentType;
        }

        /* renamed from: b */
        public final List<com.iqoption.core.microservices.tradingengine.response.active.k> apply(com.iqoption.core.microservices.tradingengine.response.active.e.a aVar) {
            kotlin.jvm.internal.h.e(aVar, "it");
            HashMap Xp = (this.aqa == InstrumentType.TURBO_INSTRUMENT ? aVar.Xl() : aVar.Xm()).Xp();
            if (Xp == null) {
                kotlin.jvm.internal.h.aXZ();
            }
            Collection values = Xp.values();
            kotlin.jvm.internal.h.d(values, "optionsMap.actives!!.values");
            return u.W(values);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "Lcom/iqoption/core/microservices/tradingengine/response/active/InstrumentActive;", "it", "Lcom/iqoption/core/microservices/tradingengine/response/active/InstrumentsResult;", "apply"})
    /* compiled from: AssetStreamMediator.kt */
    static final class e<T, R> implements io.reactivex.c.f<T, R> {
        public static final e aqb = new e();

        e() {
        }

        /* renamed from: a */
        public final List<com.iqoption.core.microservices.tradingengine.response.active.h> apply(com.iqoption.core.microservices.tradingengine.response.active.j jVar) {
            kotlin.jvm.internal.h.e(jVar, "it");
            return jVar.Xv();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "Lcom/iqoption/asset/mediators/AssetStreamMediator$InstrumentActives;", "activesMap", "", "Lcom/iqoption/core/microservices/tradingengine/response/active/Active;", "apply"})
    /* compiled from: AssetStreamMediator.kt */
    static final class f<T, R> implements io.reactivex.c.f<T, R> {
        final /* synthetic */ InstrumentType aqa;

        f(InstrumentType instrumentType) {
            this.aqa = instrumentType;
        }

        /* renamed from: G */
        public final a apply(List<? extends com.iqoption.core.microservices.tradingengine.response.active.a> list) {
            kotlin.jvm.internal.h.e(list, "activesMap");
            for (com.iqoption.core.microservices.tradingengine.response.active.a b : list) {
                b.b(this.aqa);
            }
            return new a(this.aqa, list);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "Lcom/iqoption/asset/mediators/AssetStreamMediator$InstrumentActives;", "error", "", "apply"})
    /* compiled from: AssetStreamMediator.kt */
    static final class g<T, R> implements io.reactivex.c.f<Throwable, a> {
        final /* synthetic */ InstrumentType aqa;

        g(InstrumentType instrumentType) {
            this.aqa = instrumentType;
        }

        /* renamed from: p */
        public final a apply(Throwable th) {
            kotlin.jvm.internal.h.e(th, "error");
            return new a(this.aqa, m.emptyList());
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00012*\u0010\u0005\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007 \b*\u0012\u0012\u000e\b\u0001\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u00060\u0006H\n¢\u0006\u0004\b\t\u0010\n"}, aXE = {"<anonymous>", "", "Lcom/iqoption/core/data/model/InstrumentType;", "", "Lcom/iqoption/core/microservices/tradingengine/response/active/Active;", "array", "", "", "kotlin.jvm.PlatformType", "apply", "([Ljava/lang/Object;)Ljava/util/Map;"})
    /* compiled from: AssetStreamMediator.kt */
    static final class h<T, R> implements io.reactivex.c.f<Object[], R> {
        public static final h aqc = new h();

        h() {
        }

        /* renamed from: p */
        public final Map<InstrumentType, List<com.iqoption.core.microservices.tradingengine.response.active.a>> apply(Object[] objArr) {
            kotlin.jvm.internal.h.e(objArr, "array");
            Collection arrayList = new ArrayList(objArr.length);
            for (Object obj : objArr) {
                if (obj == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.iqoption.asset.mediators.AssetStreamMediator.InstrumentActives");
                }
                a aVar = (a) obj;
                arrayList.add(kotlin.j.D(aVar.getInstrumentType(), aVar.Jj()));
            }
            return ad.ae((List) arrayList);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012*\u0010\u0003\u001a&\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005 \u0006*\u0012\u0012\u000e\b\u0001\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00040\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, aXE = {"<anonymous>", "Landroid/util/SparseArray;", "Lcom/iqoption/core/microservices/tradingengine/response/active/Active;", "array", "", "", "kotlin.jvm.PlatformType", "apply", "([Ljava/lang/Object;)Landroid/util/SparseArray;"})
    /* compiled from: AssetStreamMediator.kt */
    static final class i<T, R> implements io.reactivex.c.f<Object[], R> {
        public static final i aqd = new i();

        i() {
        }

        /* renamed from: q */
        public final SparseArray<com.iqoption.core.microservices.tradingengine.response.active.a> apply(Object[] objArr) {
            kotlin.jvm.internal.h.e(objArr, "array");
            SparseArray<com.iqoption.core.microservices.tradingengine.response.active.a> sparseArray = new SparseArray();
            for (Object obj : objArr) {
                Object obj2;
                if (!(obj2 instanceof a)) {
                    obj2 = null;
                }
                a aVar = (a) obj2;
                if (aVar != null) {
                    List<com.iqoption.core.microservices.tradingengine.response.active.a> Jj = aVar.Jj();
                    if (Jj != null) {
                        for (com.iqoption.core.microservices.tradingengine.response.active.a aVar2 : Jj) {
                            sparseArray.put(aVar2.getActiveId(), aVar2);
                        }
                    }
                }
            }
            return sparseArray;
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u001c\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012*\u0010\u0004\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006 \u0007*\u0012\u0012\u000e\b\u0001\u0012\n \u0007*\u0004\u0018\u00010\u00060\u00060\u00050\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, aXE = {"<anonymous>", "", "", "Lcom/iqoption/core/microservices/tradingengine/response/leverage/LeverageInfo;", "array", "", "", "kotlin.jvm.PlatformType", "apply", "([Ljava/lang/Object;)Ljava/util/Map;"})
    /* compiled from: AssetStreamMediator.kt */
    static final class j<T, R> implements io.reactivex.c.f<Object[], R> {
        public static final j aqe = new j();

        j() {
        }

        /* renamed from: p */
        public final Map<Integer, com.iqoption.core.microservices.tradingengine.response.b.a> apply(Object[] objArr) {
            kotlin.jvm.internal.h.e(objArr, "array");
            Map<Integer, com.iqoption.core.microservices.tradingengine.response.b.a> linkedHashMap = new LinkedHashMap();
            for (Object obj : objArr) {
                if (obj == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.iqoption.core.microservices.tradingengine.response.leverage.LeveragesResult");
                }
                SparseArray XL = ((com.iqoption.core.microservices.tradingengine.response.b.b) obj).XL();
                int size = XL.size();
                for (int i = 0; i < size; i++) {
                    com.iqoption.core.microservices.tradingengine.response.b.a aVar = (com.iqoption.core.microservices.tradingengine.response.b.a) XL.valueAt(XL.keyAt(i));
                    Integer valueOf = Integer.valueOf(aVar.getActiveId());
                    kotlin.jvm.internal.h.d(aVar, "leverage");
                    linkedHashMap.put(valueOf, aVar);
                }
            }
            return linkedHashMap;
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00010\u00012*\u0010\u0005\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007 \b*\u0012\u0012\u000e\b\u0001\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u00060\u0006H\n¢\u0006\u0004\b\t\u0010\n"}, aXE = {"<anonymous>", "", "Lcom/iqoption/core/data/model/InstrumentType;", "", "Lcom/iqoption/core/microservices/topassets/response/spread/SpreadData;", "array", "", "", "kotlin.jvm.PlatformType", "apply", "([Ljava/lang/Object;)Ljava/util/Map;"})
    /* compiled from: AssetStreamMediator.kt */
    static final class k<T, R> implements io.reactivex.c.f<Object[], R> {
        public static final k aqf = new k();

        k() {
        }

        /* renamed from: p */
        public final Map<InstrumentType, Map<Integer, com.iqoption.core.microservices.f.a.a.a>> apply(Object[] objArr) {
            kotlin.jvm.internal.h.e(objArr, "array");
            Collection arrayList = new ArrayList(objArr.length);
            for (Object obj : objArr) {
                if (obj == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.Int, com.iqoption.core.microservices.topassets.response.spread.SpreadData>");
                }
                Map map = (Map) obj;
                com.iqoption.core.microservices.f.a.a.a aVar = (com.iqoption.core.microservices.f.a.a.a) u.N((Iterable) map.values());
                arrayList.add(kotlin.j.D(aVar != null ? aVar.getInstrumentType() : null, map));
            }
            return ad.ae((List) arrayList);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u00006\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00010\u00042 \u0010\u0007\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00040\u00042\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u000fH\n¢\u0006\u0002\b\u0010"}, aXE = {"<anonymous>", "", "Lcom/iqoption/asset/mediators/AssetDisplayData;", "allActives", "", "Lcom/iqoption/core/data/model/InstrumentType;", "Lcom/iqoption/core/microservices/tradingengine/response/active/Active;", "spreadsMap", "", "Lcom/iqoption/core/microservices/topassets/response/spread/SpreadData;", "leveragesMap", "Lcom/iqoption/core/microservices/tradingengine/response/leverage/LeverageInfo;", "commissions", "Lcom/iqoption/core/microservices/risks/response/commission/CommissionData;", "favoriteIds", "", "apply"})
    /* compiled from: AssetStreamMediator.kt */
    static final class l<T1, T2, T3, T4, T5, R> implements io.reactivex.c.i<Map<InstrumentType, ? extends List<? extends com.iqoption.core.microservices.tradingengine.response.active.a>>, Map<InstrumentType, ? extends Map<Integer, ? extends com.iqoption.core.microservices.f.a.a.a>>, Map<Integer, ? extends com.iqoption.core.microservices.tradingengine.response.b.a>, List<? extends com.iqoption.core.microservices.risks.response.a.a>, Set<? extends Integer>, List<? extends a>> {
        final /* synthetic */ List aqg;
        final /* synthetic */ d aqh;

        l(List list, d dVar) {
            this.aqg = list;
            this.aqh = dVar;
        }

        public final List<a> a(Map<InstrumentType, ? extends List<? extends com.iqoption.core.microservices.tradingengine.response.active.a>> map, Map<InstrumentType, ? extends Map<Integer, com.iqoption.core.microservices.f.a.a.a>> map2, Map<Integer, com.iqoption.core.microservices.tradingengine.response.b.a> map3, List<com.iqoption.core.microservices.risks.response.a.a> list, Set<Integer> set) {
            Map map4 = map;
            Map<InstrumentType, ? extends Map<Integer, com.iqoption.core.microservices.f.a.a.a>> map5 = map2;
            Map<Integer, com.iqoption.core.microservices.tradingengine.response.b.a> map6 = map3;
            List<com.iqoption.core.microservices.risks.response.a.a> list2 = list;
            Set<Integer> set2 = set;
            kotlin.jvm.internal.h.e(map4, "allActives");
            kotlin.jvm.internal.h.e(map5, "spreadsMap");
            kotlin.jvm.internal.h.e(map6, "leveragesMap");
            kotlin.jvm.internal.h.e(list2, "commissions");
            kotlin.jvm.internal.h.e(set2, "favoriteIds");
            Iterable<com.iqoption.core.microservices.risks.response.a.a> iterable = list2;
            Collection arrayList = new ArrayList(n.e(iterable, 10));
            for (com.iqoption.core.microservices.risks.response.a.a aVar : iterable) {
                arrayList.add(kotlin.j.D(Integer.valueOf(aVar.getActiveId()), aVar));
            }
            Map ae = ad.ae((List) arrayList);
            List<a> arrayList2 = new ArrayList();
            for (InstrumentType instrumentType : this.aqg) {
                List list3 = (List) map4.get(instrumentType);
                if (list3 == null) {
                    list3 = m.emptyList();
                }
                Map map7 = (Map) map5.get(instrumentType);
                for (com.iqoption.core.microservices.tradingengine.response.active.a aVar2 : list3) {
                    int activeId = aVar2.getActiveId();
                    com.iqoption.core.microservices.f.a.a.a aVar3 = map7 != null ? (com.iqoption.core.microservices.f.a.a.a) map7.get(Integer.valueOf(activeId)) : null;
                    com.iqoption.core.microservices.tradingengine.response.b.a aVar4 = (com.iqoption.core.microservices.tradingengine.response.b.a) map6.get(Integer.valueOf(activeId));
                    com.iqoption.core.microservices.risks.response.a.a aVar5 = (com.iqoption.core.microservices.risks.response.a.a) ae.get(Integer.valueOf(activeId));
                    if (aVar3 != null && (this.aqh.Jl() == null || u.b((Iterable) this.aqh.Jl(), (Object) aVar2.getActiveType()))) {
                        if (instrumentType == InstrumentType.BINARY_INSTRUMENT) {
                            if ((aVar5 != null ? aVar5.WE() : null) == null) {
                            }
                        }
                        if (this.aqh.Jo() == null || ((Boolean) this.aqh.Jo().invoke(aVar2)).booleanValue()) {
                            arrayList2.add(new a(aVar2, aVar3, aVar4, aVar5, set2.contains(Integer.valueOf(aVar2.getActiveId()))));
                        }
                    }
                    Map<InstrumentType, ? extends List<? extends com.iqoption.core.microservices.tradingengine.response.active.a>> map42 = map;
                }
            }
            if (this.aqg.contains(InstrumentType.TURBO_INSTRUMENT) && this.aqg.contains(InstrumentType.BINARY_INSTRUMENT)) {
                arrayList2 = b.apW.a((List) arrayList2, b.apV);
            }
            Comparator Jm = this.aqh.Jm();
            if (Jm != null) {
                q.a(arrayList2, Jm);
            }
            Integer Jn = this.aqh.Jn();
            return (Jn == null || kotlin.jvm.internal.h.compare(arrayList2.size(), Jn.intValue()) <= 0) ? arrayList2 : arrayList2.subList(0, Jn.intValue());
        }
    }

    private b() {
    }

    public final io.reactivex.e<List<a>> a(d dVar) {
        kotlin.jvm.internal.h.e(dVar, "params");
        long userId = com.iqoption.core.f.Dr().getUserId();
        long Dj = com.iqoption.core.f.Dr().Dj();
        List Jk = dVar.Jk();
        io.reactivex.e a = a(dVar, userId, Dj, com.iqoption.core.f.Dr().Dh());
        io.reactivex.e bY = a(userId, Jk).bY(ad.emptyMap());
        kotlin.jvm.internal.h.d(bY, "getSpreadsFlowable(userI…rorReturnItem(emptyMap())");
        io.reactivex.e bY2 = b(userId, dVar).bY(ad.emptyMap());
        kotlin.jvm.internal.h.d(bY2, "getLeverages(userId, par…rorReturnItem(emptyMap())");
        io.reactivex.e bY3 = a(Dj, dVar).bY(m.emptyList());
        kotlin.jvm.internal.h.d(bY3, "getCommissions(userGroup…orReturnItem(emptyList())");
        return com.iqoption.core.h.g.a(a, bY, bY2, bY3, com.iqoption.asset.repository.a.aqo.az(userId), new l(Jk, dVar));
    }

    public final io.reactivex.e<Map<InstrumentType, List<com.iqoption.core.microservices.tradingengine.response.active.a>>> a(d dVar, long j, long j2, boolean z) {
        kotlin.jvm.internal.h.e(dVar, "params");
        Iterable<InstrumentType> Jk = dVar.Jk();
        Collection arrayList = new ArrayList(n.e(Jk, 10));
        for (InstrumentType a : Jk) {
            arrayList.add(apW.a(j, j2, z, a));
        }
        io.reactivex.e<Map<InstrumentType, List<com.iqoption.core.microservices.tradingengine.response.active.a>>> a2 = io.reactivex.e.a((Iterable) (List) arrayList, (io.reactivex.c.f) h.aqc);
        kotlin.jvm.internal.h.d(a2, "Flowable.combineLatest(f…      }.toMap()\n        }");
        return a2;
    }

    public static /* synthetic */ io.reactivex.e a(b bVar, d dVar, long j, long j2, boolean z, int i, Object obj) {
        return bVar.b((i & 1) != 0 ? new d(null, null, null, null, null, 31, null) : dVar, (i & 2) != 0 ? com.iqoption.core.f.Dr().getUserId() : j, (i & 4) != 0 ? com.iqoption.core.f.Dr().Dj() : j2, (i & 8) != 0 ? com.iqoption.core.f.Dr().Dh() : z);
    }

    public final io.reactivex.e<SparseArray<com.iqoption.core.microservices.tradingengine.response.active.a>> b(d dVar, long j, long j2, boolean z) {
        kotlin.jvm.internal.h.e(dVar, "params");
        Iterable<InstrumentType> Jk = dVar.Jk();
        Collection arrayList = new ArrayList(n.e(Jk, 10));
        for (InstrumentType a : Jk) {
            arrayList.add(apW.a(j, j2, z, a));
        }
        io.reactivex.e<SparseArray<com.iqoption.core.microservices.tradingengine.response.active.a>> a2 = io.reactivex.e.a((Iterable) (List) arrayList, (io.reactivex.c.f) i.aqd);
        kotlin.jvm.internal.h.d(a2, "Flowable.combineLatest(f…}\n            }\n        }");
        return a2;
    }

    private final io.reactivex.e<a> a(long j, long j2, boolean z, InstrumentType instrumentType) {
        io.reactivex.e d;
        switch (c.aoS[instrumentType.ordinal()]) {
            case 1:
            case 2:
                d = com.iqoption.asset.repository.f.aqT.b(j, j2, z, instrumentType).d((io.reactivex.c.f) c.apZ);
                break;
            case 3:
            case 4:
                d = com.iqoption.asset.repository.f.aqT.aF(j).d((io.reactivex.c.f) new d(instrumentType));
                break;
            default:
                d = com.iqoption.asset.repository.f.aqT.c(j, j2, z, instrumentType).d((io.reactivex.c.f) e.aqb);
                break;
        }
        io.reactivex.e<a> f = d.d((io.reactivex.c.f) new f(instrumentType)).f(new g(instrumentType));
        kotlin.jvm.internal.h.d(f, "when (instrumentType) {\n…umentType, emptyList()) }");
        return f;
    }

    private final io.reactivex.e<Map<InstrumentType, Map<Integer, com.iqoption.core.microservices.f.a.a.a>>> a(long j, List<? extends InstrumentType> list) {
        Iterable<InstrumentType> iterable = list;
        Collection arrayList = new ArrayList(n.e(iterable, 10));
        for (InstrumentType h : iterable) {
            arrayList.add(com.iqoption.asset.repository.e.aqK.h(j, h));
        }
        io.reactivex.e<Map<InstrumentType, Map<Integer, com.iqoption.core.microservices.f.a.a.a>>> a = io.reactivex.e.a((Iterable) (List) arrayList, (io.reactivex.c.f) k.aqf);
        kotlin.jvm.internal.h.d(a, "Flowable.combineLatest(f…      }.toMap()\n        }");
        return a;
    }

    private final io.reactivex.e<List<com.iqoption.core.microservices.risks.response.a.a>> a(long j, d dVar) {
        if (dVar.Jk().contains(InstrumentType.BINARY_INSTRUMENT)) {
            return com.iqoption.asset.repository.c.aqA.b(j, InstrumentType.BINARY_INSTRUMENT);
        }
        io.reactivex.e<List<com.iqoption.core.microservices.risks.response.a.a>> bW = io.reactivex.e.bW(m.emptyList());
        kotlin.jvm.internal.h.d(bW, "Flowable.just(emptyList())");
        return bW;
    }

    private final io.reactivex.e<Map<Integer, com.iqoption.core.microservices.tradingengine.response.b.a>> b(long j, d dVar) {
        Collection arrayList = new ArrayList();
        for (Object next : dVar.Jk()) {
            if (!((InstrumentType) next).isOption()) {
                arrayList.add(next);
            }
        }
        List list = (List) arrayList;
        io.reactivex.e<Map<Integer, com.iqoption.core.microservices.tradingengine.response.b.a>> bW;
        if (list.isEmpty()) {
            bW = io.reactivex.e.bW(ad.emptyMap());
            kotlin.jvm.internal.h.d(bW, "Flowable.just(emptyMap())");
            return bW;
        }
        Iterable<InstrumentType> iterable = list;
        Collection arrayList2 = new ArrayList(n.e(iterable, 10));
        for (InstrumentType i : iterable) {
            arrayList2.add(com.iqoption.asset.repository.f.aqT.i(j, i));
        }
        bW = io.reactivex.e.a((Iterable) (List) arrayList2, (io.reactivex.c.f) j.aqe);
        kotlin.jvm.internal.h.d(bW, "Flowable.combineLatest(n…everagesMap\n            }");
        return bW;
    }

    private final List<a> a(List<a> list, b bVar) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (a aVar : list) {
            int activeId = aVar.Jg().getActiveId();
            a aVar2 = (a) linkedHashMap.get(Integer.valueOf(activeId));
            if (aVar2 == null) {
                linkedHashMap.put(Integer.valueOf(activeId), aVar);
            } else {
                if (bVar.s(aVar.Jg().getInstrumentType()) > bVar.s(aVar2.Jg().getInstrumentType())) {
                    linkedHashMap.put(Integer.valueOf(activeId), aVar);
                }
            }
        }
        Collection values = linkedHashMap.values();
        kotlin.jvm.internal.h.d(values, "resultMap.values");
        return u.O(values);
    }
}
