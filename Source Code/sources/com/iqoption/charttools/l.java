package com.iqoption.charttools;

import android.support.v4.util.LruCache;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.android.gms.plus.PlusShare;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import com.iqoption.charttools.model.indicator.aa;
import com.iqoption.charttools.model.indicator.ab;
import com.iqoption.charttools.model.indicator.ac;
import com.iqoption.charttools.model.indicator.ad;
import com.iqoption.charttools.model.indicator.ae;
import com.iqoption.charttools.model.indicator.af;
import com.iqoption.charttools.model.indicator.ag;
import com.iqoption.charttools.model.indicator.constructor.InputItem;
import com.iqoption.charttools.model.indicator.constructor.f;
import com.iqoption.charttools.model.indicator.g;
import com.iqoption.charttools.model.indicator.h;
import com.iqoption.charttools.model.indicator.m;
import com.iqoption.charttools.model.indicator.n;
import com.iqoption.charttools.model.indicator.o;
import com.iqoption.charttools.model.indicator.p;
import com.iqoption.charttools.model.indicator.q;
import com.iqoption.charttools.model.indicator.r;
import com.iqoption.charttools.model.indicator.s;
import com.iqoption.charttools.model.indicator.t;
import com.iqoption.charttools.model.indicator.u;
import com.iqoption.charttools.model.indicator.v;
import com.iqoption.charttools.model.indicator.w;
import com.iqoption.charttools.model.indicator.x;
import com.iqoption.core.gl.Graph;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0010\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002:;B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0012\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u0019J \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00192\u0006\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010 J\u0012\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001a0\u0019J \u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00130\u00192\u0006\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010 J\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\n0\u0019J\u0012\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001a0\u0019J\u000e\u0010%\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020&J\u0010\u0010'\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001e\u001a\u00020\u0015J\u0018\u0010(\u001a\u0004\u0018\u00010&2\u0006\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020+J\u0016\u0010,\u001a\u00020-2\u0006\u0010*\u001a\u00020+2\u0006\u0010\u0014\u001a\u00020&J\u0016\u0010.\u001a\u00020-2\u0006\u0010*\u001a\u00020+2\u0006\u0010\u0014\u001a\u00020&J\f\u0010/\u001a\u00020\u001b*\u000200H\u0002J;\u0010/\u001a\u00020\u0015*\u0002012\f\u00102\u001a\b\u0012\u0004\u0012\u000200032\f\u00104\u001a\b\u0012\u0004\u0012\u0002050\u001a2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0002¢\u0006\u0002\u00107J\u0014\u00108\u001a\u00020\u0013*\u00020\u00172\u0006\u00109\u001a\u00020\u0013H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0004\n\u0002\u0010\u0011¨\u0006<"}, aXE = {"Lcom/iqoption/charttools/IndicatorsLibraryManager;", "", "()V", "DISPOSE_DELAY", "", "TAG", "", "kotlin.jvm.PlatformType", "libraryStreamSupplier", "Lcom/iqoption/core/rx/LiveStreamSupplier;", "Lcom/iqoption/charttools/IndicatorsLibrary;", "getLibraryStreamSupplier", "()Lcom/iqoption/core/rx/LiveStreamSupplier;", "libraryStreamSupplier$delegate", "Lkotlin/Lazy;", "scriptCache", "com/iqoption/charttools/IndicatorsLibraryManager$scriptCache$1", "Lcom/iqoption/charttools/IndicatorsLibraryManager$scriptCache$1;", "buildScriptedInputs", "Lcom/iqoption/charttools/model/indicator/constructor/Inputs;", "indicator", "Lcom/iqoption/charttools/model/indicator/ScriptedIndicator;", "values", "Lcom/iqoption/charttools/model/indicator/constructor/ValuesIterator;", "getCategories", "Lio/reactivex/Single;", "", "Lcom/iqoption/charttools/model/IndicatorCategory;", "getConstructor", "Lcom/iqoption/charttools/model/indicator/constructor/Constructor;", "meta", "Lcom/iqoption/charttools/model/indicator/MetaIndicator;", "Lcom/google/gson/JsonArray;", "getIndicators", "getInputs", "getLibrary", "getMetaIndicators", "getParams", "Lcom/iqoption/charttools/model/indicator/ChartIndicator;", "getScript", "parseIndicator", "library", "json", "Lcom/google/gson/JsonObject;", "writeIndicator", "", "writeTitledIndicator", "map", "Lcom/iqoption/core/microservices/techinstruments/response/Category;", "Lcom/iqoption/core/microservices/techinstruments/response/Indicator;", "categories", "", "videos", "Lcom/iqoption/core/microservices/videoeducation/response/Video;", "indicatorCategories", "(Lcom/iqoption/core/microservices/techinstruments/response/Indicator;[Lcom/iqoption/core/microservices/techinstruments/response/Category;Ljava/util/List;Ljava/util/List;)Lcom/iqoption/charttools/model/indicator/ScriptedIndicator;", "overwrite", "inputs", "JsonHelper", "Persistor", "techtools_release"})
/* compiled from: IndicatorsLibraryManager.kt */
public final class l {
    private static final String TAG = "l";
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(l.class), "libraryStreamSupplier", "getLibraryStreamSupplier()Lcom/iqoption/core/rx/LiveStreamSupplier;"))};
    private static final long asu = TimeUnit.DAYS.toMillis(1);
    private static final e asv = new e(2097152);
    private static final kotlin.d asw = g.f(IndicatorsLibraryManager$libraryStreamSupplier$2.asE);
    public static final l asx = new l();

    @i(aXC = {1, 1, 11}, aXD = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\b\u001a\u0004\u0018\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eJ \u0010\u000f\u001a\u0004\u0018\u00010\f2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\tJ\u0018\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0015"}, aXE = {"Lcom/iqoption/charttools/IndicatorsLibraryManager$JsonHelper;", "", "()V", "HIDDEN", "", "ID", "LIBRARY_ID", "TYPE", "parseIndicator", "Lcom/iqoption/charttools/model/indicator/ChartIndicator;", "all", "", "Lcom/iqoption/charttools/model/indicator/MetaIndicator;", "json", "Lcom/google/gson/JsonObject;", "parseMeta", "writeIndicator", "", "indicator", "writeMeta", "meta", "techtools_release"})
    /* compiled from: IndicatorsLibraryManager.kt */
    private static final class a {
        public static final a asy = new a();

        private a() {
        }

        private final x a(List<? extends x> list, JsonObject jsonObject) {
            x xVar = null;
            String a = com.iqoption.core.ext.d.a(jsonObject, Param.TYPE, null, 2, null);
            if (a == null) {
                return null;
            }
            Collection arrayList = new ArrayList();
            for (Object next : list) {
                if (((x) next).fC(a)) {
                    arrayList.add(next);
                }
            }
            List list2 = (List) arrayList;
            if (u.h(list2, 0) instanceof v) {
                xVar = (x) list2.get(0);
            } else if ((list2.isEmpty() ^ 1) != 0) {
                Long a2 = com.iqoption.core.ext.d.a(jsonObject, "library_id", null, 2, null);
                if (a2 == null) {
                    return null;
                }
                long longValue = a2.longValue();
                for (x next2 : list2) {
                    Object obj;
                    x xVar2 = next2;
                    if (!(xVar2 instanceof ae)) {
                        xVar2 = null;
                    }
                    ae aeVar = (ae) xVar2;
                    if (aeVar == null || aeVar.getId() != longValue) {
                        obj = null;
                        continue;
                    } else {
                        obj = 1;
                        continue;
                    }
                    if (obj != null) {
                        xVar = next2;
                        break;
                    }
                }
                xVar = xVar;
            }
            return xVar;
        }

        private final void a(x xVar, JsonObject jsonObject) {
            jsonObject.addProperty(Param.TYPE, xVar.getType());
            if (xVar instanceof ae) {
                jsonObject.addProperty("library_id", (Number) Long.valueOf(((ae) xVar).getId()));
            }
        }

        public final h b(List<? extends x> list, JsonObject jsonObject) {
            kotlin.jvm.internal.h.e(list, "all");
            kotlin.jvm.internal.h.e(jsonObject, "json");
            x a = a((List) list, jsonObject);
            if (a != null) {
                return new h(a, com.iqoption.core.ext.d.a(jsonObject, "id", 0, 2, null), com.iqoption.core.ext.d.a(jsonObject, "hidden", false, 2, null), a.b(jsonObject));
            }
            return null;
        }

        public final void a(JsonObject jsonObject, h hVar) {
            kotlin.jvm.internal.h.e(jsonObject, "json");
            kotlin.jvm.internal.h.e(hVar, "indicator");
            x KJ = hVar.KJ();
            a(KJ, jsonObject);
            jsonObject.addProperty("id", (Number) Integer.valueOf(hVar.getIndex()));
            jsonObject.addProperty("hidden", Boolean.valueOf(hVar.isHidden()));
            KJ.a(jsonObject, hVar.Mc());
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\rJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0013J#\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00160\r\"\n\b\u0000\u0010\u0016\u0018\u0001*\u00020\u00012\u0006\u0010\u0017\u001a\u00020\tH\bJ8\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00132\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00100\r2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\rR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, aXE = {"Lcom/iqoption/charttools/IndicatorsLibraryManager$Persistor;", "", "()V", "PARENT_DIR", "", "SUBDIR_CATEGORIES", "SUBDIR_INDICATORS", "SUBDIR_SCRIPTS", "categoriesStore", "Lcom/iqoption/core/data/filestore/FileStore;", "indicatorsStore", "scriptsStore", "getCategories", "", "Lcom/iqoption/charttools/model/IndicatorCategory;", "getIndicators", "Lcom/iqoption/charttools/model/indicator/ScriptedIndicator;", "getScript", "id", "", "getVersion", "loadList", "T", "store", "saveLibrary", "", "version", "categories", "indicators", "scripts", "techtools_release"})
    /* compiled from: IndicatorsLibraryManager.kt */
    private static final class b {
        private static final com.iqoption.core.data.a.a asA = com.iqoption.core.data.a.b.gj("techtools/indicators_library/indicators");
        private static final com.iqoption.core.data.a.a asB = com.iqoption.core.data.a.b.gj("techtools/indicators_library/scripts");
        public static final b asC = new b();
        private static final com.iqoption.core.data.a.a asz = com.iqoption.core.data.a.b.gj("techtools/indicators_library/categories");

        private b() {
        }

        public final long Kn() {
            return com.iqoption.core.data.d.a.aOz.SE();
        }

        public final void a(long j, List<com.iqoption.charttools.model.a> list, List<ae> list2, List<String> list3) {
            kotlin.jvm.internal.h.e(list, "categories");
            kotlin.jvm.internal.h.e(list2, "indicators");
            kotlin.jvm.internal.h.e(list3, "scripts");
            com.iqoption.core.data.d.a.aOz.aO(j);
            asz.clear();
            for (com.iqoption.charttools.model.a aVar : list) {
                asz.aa(String.valueOf(aVar.getId()), com.iqoption.core.ext.d.a(aVar, null, 1, null));
            }
            asA.clear();
            asB.clear();
            int i = 0;
            for (ae aeVar : list2) {
                int i2 = i + 1;
                String valueOf = String.valueOf(aeVar.getId());
                asA.aa(valueOf, com.iqoption.core.ext.d.a(aeVar, null, 1, null));
                String str = (String) u.h(list3, i);
                if (str != null) {
                    asB.aa(valueOf, str);
                }
                i = i2;
            }
        }

        public final List<com.iqoption.charttools.model.a> Kj() {
            com.iqoption.core.data.a.a aVar = asz;
            Collection arrayList = new ArrayList();
            for (String gi : aVar.getKeys()) {
                Closeable jsonReader = new JsonReader(aVar.gi(gi));
                Throwable th = (Throwable) null;
                try {
                    Object a = com.iqoption.core.ext.d.a((JsonReader) jsonReader, com.iqoption.charttools.model.a.class, null, 2, null);
                    kotlin.c.b.a(jsonReader, th);
                    if (a != null) {
                        arrayList.add(a);
                    }
                } catch (Throwable th2) {
                    kotlin.c.b.a(jsonReader, th);
                }
            }
            return (List) arrayList;
        }

        public final List<ae> JT() {
            com.iqoption.core.data.a.a aVar = asA;
            Collection arrayList = new ArrayList();
            for (String gi : aVar.getKeys()) {
                Closeable jsonReader = new JsonReader(aVar.gi(gi));
                Throwable th = (Throwable) null;
                try {
                    Object a = com.iqoption.core.ext.d.a((JsonReader) jsonReader, ae.class, null, 2, null);
                    kotlin.c.b.a(jsonReader, th);
                    if (a != null) {
                        arrayList.add(a);
                    }
                } catch (Throwable th2) {
                    kotlin.c.b.a(jsonReader, th);
                }
            }
            return (List) arrayList;
        }

        public final String aG(long j) {
            return asB.getText(String.valueOf(j));
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "Lcom/iqoption/charttools/model/indicator/constructor/Inputs;", "call"})
    /* compiled from: IndicatorsLibraryManager.kt */
    static final class d<V> implements Callable<T> {
        final /* synthetic */ com.iqoption.charttools.model.indicator.constructor.h asD;
        final /* synthetic */ x asi;

        d(x xVar, com.iqoption.charttools.model.indicator.constructor.h hVar) {
            this.asi = xVar;
            this.asD = hVar;
        }

        /* renamed from: Ko */
        public final f call() {
            x xVar = this.asi;
            if (xVar instanceof p) {
                return com.iqoption.charttools.model.indicator.constructor.a.a.a(this.asD);
            }
            if (xVar instanceof q) {
                return com.iqoption.charttools.model.indicator.constructor.a.a.b(this.asD);
            }
            if (xVar instanceof o) {
                return com.iqoption.charttools.model.indicator.constructor.a.a.c(this.asD);
            }
            if (xVar instanceof r) {
                return com.iqoption.charttools.model.indicator.constructor.a.a.d(this.asD);
            }
            if (xVar instanceof m) {
                return com.iqoption.charttools.model.indicator.constructor.a.a.e(this.asD);
            }
            if (xVar instanceof com.iqoption.charttools.model.indicator.l) {
                return com.iqoption.charttools.model.indicator.constructor.a.a.f(this.asD);
            }
            if (xVar instanceof n) {
                return com.iqoption.charttools.model.indicator.constructor.a.a.g(this.asD);
            }
            if (xVar instanceof com.iqoption.charttools.model.indicator.f) {
                return com.iqoption.charttools.model.indicator.constructor.a.b.p(this.asD);
            }
            if (xVar instanceof com.iqoption.charttools.model.indicator.c) {
                return com.iqoption.charttools.model.indicator.constructor.a.b.o(this.asD);
            }
            if (xVar instanceof ab) {
                return com.iqoption.charttools.model.indicator.constructor.a.b.n(this.asD);
            }
            if (xVar instanceof ad) {
                return com.iqoption.charttools.model.indicator.constructor.a.b.q(this.asD);
            }
            if (xVar instanceof com.iqoption.charttools.model.indicator.a) {
                return com.iqoption.charttools.model.indicator.constructor.a.b.r(this.asD);
            }
            if (xVar instanceof com.iqoption.charttools.model.indicator.b) {
                return com.iqoption.charttools.model.indicator.constructor.a.b.s(this.asD);
            }
            if (xVar instanceof com.iqoption.charttools.model.indicator.d) {
                return com.iqoption.charttools.model.indicator.constructor.a.b.t(this.asD);
            }
            if (xVar instanceof g) {
                return com.iqoption.charttools.model.indicator.constructor.a.b.u(this.asD);
            }
            if (xVar instanceof s) {
                return com.iqoption.charttools.model.indicator.constructor.a.b.v(this.asD);
            }
            if (xVar instanceof w) {
                return com.iqoption.charttools.model.indicator.constructor.a.b.w(this.asD);
            }
            if (xVar instanceof ac) {
                return com.iqoption.charttools.model.indicator.constructor.a.b.x(this.asD);
            }
            if (xVar instanceof af) {
                return com.iqoption.charttools.model.indicator.constructor.a.b.y(this.asD);
            }
            if (xVar instanceof com.iqoption.charttools.model.indicator.e) {
                return com.iqoption.charttools.model.indicator.constructor.a.b.m(this.asD);
            }
            if (xVar instanceof com.iqoption.charttools.model.indicator.j) {
                return com.iqoption.charttools.model.indicator.constructor.a.b.l(this.asD);
            }
            if (xVar instanceof t) {
                return com.iqoption.charttools.model.indicator.constructor.a.b.j(this.asD);
            }
            if (xVar instanceof u) {
                return com.iqoption.charttools.model.indicator.constructor.a.b.k(this.asD);
            }
            if (xVar instanceof aa) {
                return com.iqoption.charttools.model.indicator.constructor.a.b.i(this.asD);
            }
            if (xVar instanceof ag) {
                return com.iqoption.charttools.model.indicator.constructor.a.b.h(this.asD);
            }
            if (xVar instanceof ae) {
                return l.asx.a((ae) this.asi, this.asD);
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "Lcom/iqoption/charttools/model/indicator/constructor/Constructor;", "inputs", "Lcom/iqoption/charttools/model/indicator/constructor/Inputs;", "apply"})
    /* compiled from: IndicatorsLibraryManager.kt */
    static final class c<T, R> implements io.reactivex.c.f<T, R> {
        final /* synthetic */ x asi;

        c(x xVar) {
            this.asi = xVar;
        }

        /* renamed from: a */
        public final com.iqoption.charttools.model.indicator.constructor.a apply(f fVar) {
            kotlin.jvm.internal.h.e(fVar, "inputs");
            return new com.iqoption.charttools.model.indicator.constructor.a(this.asi, this.asi.Mi(), fVar.Mq(), fVar.MD());
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J!\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0002\u0010\b¨\u0006\t"}, aXE = {"com/iqoption/charttools/IndicatorsLibraryManager$scriptCache$1", "Landroid/support/v4/util/LruCache;", "", "", "sizeOf", "", "key", "value", "(Ljava/lang/Long;Ljava/lang/String;)I", "techtools_release"})
    /* compiled from: IndicatorsLibraryManager.kt */
    public static final class e extends LruCache<Long, String> {
        e(int i) {
            super(i);
        }

        /* renamed from: b */
        protected int sizeOf(Long l, String str) {
            return (str != null ? str.length() : 0) * 2;
        }
    }

    private final com.iqoption.core.h.d<k> Kl() {
        kotlin.d dVar = asw;
        j jVar = apP[0];
        return (com.iqoption.core.h.d) dVar.getValue();
    }

    private l() {
    }

    private final com.iqoption.charttools.model.a a(com.iqoption.core.microservices.techinstruments.a.a aVar) {
        return new com.iqoption.charttools.model.a(aVar);
    }

    private final ae a(com.iqoption.core.microservices.techinstruments.a.b bVar, com.iqoption.core.microservices.techinstruments.a.a[] aVarArr, List<com.iqoption.core.microservices.videoeducation.response.g> list, List<com.iqoption.charttools.model.a> list2) {
        com.iqoption.core.microservices.videoeducation.response.g gVar;
        com.iqoption.core.microservices.techinstruments.a.a[] aVarArr2 = aVarArr;
        Set set = null;
        if (bVar.WQ() > 0) {
            for (Object next : list) {
                Object obj;
                if (((com.iqoption.core.microservices.videoeducation.response.g) next).getId() == bVar.WQ()) {
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
            Object next2 = null;
            gVar = (com.iqoption.core.microservices.videoeducation.response.g) next2;
        } else {
            gVar = null;
        }
        Collection arrayList = new ArrayList();
        for (com.iqoption.core.microservices.techinstruments.a.a aVar : aVarArr2) {
            if (aVar.WP().contains(Long.valueOf(bVar.getId()))) {
                arrayList.add(aVar);
            }
        }
        Collection arrayList2 = new ArrayList();
        for (com.iqoption.core.microservices.techinstruments.a.a aVar2 : (List) arrayList) {
            for (Object next3 : list2) {
                Object obj2;
                if (((com.iqoption.charttools.model.a) next3).getId() == aVar2.getId()) {
                    obj2 = 1;
                    continue;
                } else {
                    obj2 = null;
                    continue;
                }
                if (obj2 != null) {
                    break;
                }
            }
            Object next32 = null;
            com.iqoption.charttools.model.a aVar3 = (com.iqoption.charttools.model.a) next32;
            if (aVar3 != null) {
                arrayList2.add(aVar3);
            }
        }
        Set Y = u.Y((List) arrayList2);
        if ((Y.isEmpty() ^ 1) != 0) {
            set = Y;
        }
        return new ae(bVar, gVar, set);
    }

    public final io.reactivex.o<k> Km() {
        io.reactivex.o<k> aVY = Kl().Yg().aVY();
        kotlin.jvm.internal.h.d(aVY, "libraryStreamSupplier.ge…          .firstOrError()");
        return aVY;
    }

    public final io.reactivex.o<f> a(x xVar, JsonArray jsonArray) {
        kotlin.jvm.internal.h.e(xVar, "meta");
        io.reactivex.o<f> h = io.reactivex.o.h((Callable) new d(xVar, jsonArray != null ? new com.iqoption.charttools.model.indicator.constructor.h(jsonArray) : com.iqoption.charttools.model.indicator.constructor.h.azh.MJ()));
        kotlin.jvm.internal.h.d(h, "Single\n                .…      }\n                }");
        return h;
    }

    public final String a(ae aeVar) {
        kotlin.jvm.internal.h.e(aeVar, "meta");
        String str = (String) asv.get(Long.valueOf(aeVar.getId()));
        if (str != null) {
            return str;
        }
        str = b.asC.aG(aeVar.getId());
        if (str == null) {
            return null;
        }
        asv.put(Long.valueOf(aeVar.getId()), str);
        return str;
    }

    private final f a(ae aeVar, com.iqoption.charttools.model.indicator.constructor.h hVar) {
        String a = a(aeVar);
        if (a != null) {
            a = Graph.nCreateInputs(a);
            f fVar = null;
            if (a != null) {
                fVar = (f) com.iqoption.core.ext.d.a(a, f.class, null, 2, null);
            }
            if (fVar != null) {
                f a2 = asx.a(hVar, fVar);
                if (a2 != null) {
                    return a2;
                }
            }
        }
        return f.azd.MF();
    }

    private final f a(com.iqoption.charttools.model.indicator.constructor.h hVar, f fVar) {
        com.iqoption.charttools.model.indicator.constructor.c[] Mq = fVar.Mq();
        InputItem[] MD = fVar.MD();
        Collection arrayList = new ArrayList(MD.length);
        for (InputItem inputItem : MD) {
            arrayList.add(InputItem.a(inputItem, null, null, hVar.fE(inputItem.getValue()), null, null, null, null, false, 251, null));
        }
        Object[] toArray = ((List) arrayList).toArray(new InputItem[0]);
        if (toArray != null) {
            return new f(Mq, (InputItem[]) toArray);
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public final io.reactivex.o<com.iqoption.charttools.model.indicator.constructor.a> b(x xVar, JsonArray jsonArray) {
        kotlin.jvm.internal.h.e(xVar, "meta");
        io.reactivex.o<com.iqoption.charttools.model.indicator.constructor.a> n = a(xVar, jsonArray).n(new c(xVar));
        kotlin.jvm.internal.h.d(n, "getInputs(meta, values)\n….groups, inputs.inputs) }");
        return n;
    }

    public final h a(k kVar, JsonObject jsonObject) {
        kotlin.jvm.internal.h.e(kVar, "library");
        kotlin.jvm.internal.h.e(jsonObject, "json");
        return a.asy.b(kVar.getAll(), jsonObject);
    }

    public final void a(JsonObject jsonObject, h hVar) {
        kotlin.jvm.internal.h.e(jsonObject, "json");
        kotlin.jvm.internal.h.e(hVar, "indicator");
        a.asy.a(jsonObject, hVar);
    }

    public final void b(JsonObject jsonObject, h hVar) {
        kotlin.jvm.internal.h.e(jsonObject, "json");
        kotlin.jvm.internal.h.e(hVar, "indicator");
        a(jsonObject, hVar);
        x KJ = hVar.KJ();
        if (KJ instanceof ae) {
            String a = a((ae) KJ);
            if (a != null) {
                jsonObject.addProperty("script", a);
                return;
            }
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(KJ);
            stringBuilder.append(" does not have script");
            com.iqoption.core.i.w(str, stringBuilder.toString());
        } else if (KJ instanceof v) {
            jsonObject.addProperty(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, hVar.Ma());
        }
    }

    public final String b(h hVar) {
        kotlin.jvm.internal.h.e(hVar, "indicator");
        x KJ = hVar.KJ();
        if (KJ instanceof v) {
            return ((v) hVar.KJ()).e(hVar.Mc());
        }
        if (KJ instanceof ae) {
            String a = a((ae) hVar.KJ());
            if (a != null) {
                String nCreateParams = Graph.nCreateParams(a, hVar.Mc().toString());
                if (nCreateParams != null) {
                    return nCreateParams;
                }
            }
            return "";
        }
        throw new NoWhenBranchMatchedException();
    }
}
