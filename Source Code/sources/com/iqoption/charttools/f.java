package com.iqoption.charttools;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.iqoption.charttools.model.indicator.x;
import io.reactivex.o;
import io.reactivex.processors.BehaviorProcessor;
import io.reactivex.processors.PublishProcessor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Pair;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1Impl;

@kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001DB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u000e2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&J\u001e\u0010'\u001a\u00020(2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010)\u001a\u00020!2\u0006\u0010*\u001a\u00020+J\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020\f0-2\u0006\u0010\"\u001a\u00020\u0004J\u001a\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000/0\u000e2\u0006\u0010\"\u001a\u00020\u0004J\u001a\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000/0-2\u0006\u0010\"\u001a\u00020\u0004J\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00180-J\u0006\u00103\u001a\u00020\u0018J\u0006\u00104\u001a\u00020\u0018J\u0006\u00105\u001a\u00020(J\u000e\u00106\u001a\u00020(2\u0006\u0010\"\u001a\u00020\u0004J\u0016\u00107\u001a\u00020(2\u0006\u0010\"\u001a\u00020\u00042\u0006\u00108\u001a\u00020!J\u000e\u00109\u001a\u00020(2\u0006\u0010\"\u001a\u00020\u0004J\u001c\u0010:\u001a\u00020(2\u0006\u0010\"\u001a\u00020\u00042\f\u0010;\u001a\b\u0012\u0004\u0012\u0002000/J\u0016\u0010<\u001a\u00020(2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u0018J\u000e\u0010>\u001a\u00020?2\u0006\u0010=\u001a\u00020\u0018J?\u0010@\u001a\u00020(2\u0006\u0010\"\u001a\u00020\u00042\u0006\u00108\u001a\u00020!2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\b\b\u0002\u0010B\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010CR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \t*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\f0\f0\u000bX\u0004¢\u0006\u0002\n\u0000R?\u0010\r\u001a&\u0012\f\u0012\n \t*\u0004\u0018\u00010\u000f0\u000f \t*\u0012\u0012\f\u0012\n \t*\u0004\u0018\u00010\u000f0\u000f\u0018\u00010\u000e0\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R;\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00172\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178B@BX\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006E"}, aXE = {"Lcom/iqoption/charttools/ActiveIndicatorsManager;", "", "()V", "KEY_ALL", "", "PREF_APPLY_TO_ALL_ASSETS_KEY", "PREF_NAME", "PREF_VOLUME_KEY", "TAG", "kotlin.jvm.PlatformType", "eventsProcessor", "Lio/reactivex/processors/FlowableProcessor;", "Lcom/iqoption/charttools/ActiveIndicatorEvent;", "helperStream", "Lio/reactivex/Single;", "Lcom/iqoption/charttools/ActiveIndicatorsManager$Helper;", "getHelperStream", "()Lio/reactivex/Single;", "helperStream$delegate", "Lkotlin/Lazy;", "prefs", "Lcom/iqoption/core/data/prefs/SharedPrefs;", "<set-?>", "Lio/reactivex/processors/BehaviorProcessor;", "", "volumeStateProcessor", "getVolumeStateProcessor", "()Lio/reactivex/processors/BehaviorProcessor;", "setVolumeStateProcessor", "(Lio/reactivex/processors/BehaviorProcessor;)V", "volumeStateProcessor$delegate", "Lkotlin/properties/ReadWriteProperty;", "addIndicator", "", "key", "metaIndicator", "Lcom/iqoption/charttools/model/indicator/MetaIndicator;", "values", "Lcom/google/gson/JsonArray;", "applyTemplate", "Lio/reactivex/Completable;", "activeId", "template", "Lcom/iqoption/charttools/model/template/ChartTemplate;", "getEvents", "Lio/reactivex/Flowable;", "getIndicators", "", "Lcom/iqoption/charttools/model/indicator/ChartIndicator;", "getIndicatorsStream", "getVolumeEnabledStream", "isApplyToAllAssetsEnabled", "isVolumeEnabled", "persistState", "removeAllIndicators", "removeIndicator", "index", "removeKey", "replaceIndicators", "indicators", "setApplyToAllAssetsEnabled", "enabled", "setVolumeEnabled", "", "updateIndicator", "isHidden", "isCallback", "(Ljava/lang/String;ILjava/lang/Boolean;Lcom/google/gson/JsonArray;Z)Lio/reactivex/Completable;", "Helper", "techtools_release"})
/* compiled from: ActiveIndicatorsManager.kt */
public final class f {
    private static final String TAG = "f";
    static final /* synthetic */ kotlin.reflect.j[] apP = new kotlin.reflect.j[]{kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(f.class), "volumeStateProcessor", "getVolumeStateProcessor()Lio/reactivex/processors/BehaviorProcessor;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(f.class), "helperStream", "getHelperStream()Lio/reactivex/Single;"))};
    private static final com.iqoption.core.data.d.c arI = new com.iqoption.core.data.d.c("active_indicators");
    private static final kotlin.e.d arJ = com.iqoption.core.e.c.bh(null);
    private static final kotlin.d arK = g.f(ActiveIndicatorsManager$helperStream$2.arY);
    private static final io.reactivex.processors.a<b> arL = PublishProcessor.aXq().aXp();
    public static final f arM = new f();

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0011\u001a\u00020\tJ\u0006\u0010\u0012\u001a\u00020\u0013J\u0018\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\tJ\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0013J\u000e\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\tJ\"\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0011\u001a\u00020\t2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u0010\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u000bR\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, aXE = {"Lcom/iqoption/charttools/ActiveIndicatorsManager$Helper;", "", "library", "Lcom/iqoption/charttools/IndicatorsLibrary;", "(Lcom/iqoption/charttools/IndicatorsLibrary;)V", "indexIncrement", "Ljava/util/concurrent/atomic/AtomicInteger;", "map", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "Lcom/iqoption/charttools/model/indicator/ChartIndicator;", "store", "Lcom/iqoption/core/data/filestore/FileStore;", "trashKeys", "", "getIndicators", "key", "newIndex", "", "parseIndicators", "persist", "", "removeIndicator", "id", "removeIndicators", "replaceIndicators", "indicators", "scheduleRewrite", "setIndicator", "indicator", "WriteTask", "techtools_release"})
    /* compiled from: ActiveIndicatorsManager.kt */
    private static final class a {
        private final com.iqoption.core.data.a.a arN = com.iqoption.core.data.a.b.gj("techtools/active_indicators");
        private AtomicInteger arO = new AtomicInteger(0);
        private final ConcurrentHashMap<String, List<com.iqoption.charttools.model.indicator.h>> arP = new ConcurrentHashMap();
        private final Set<String> arQ = new LinkedHashSet();
        private final k arR;

        @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, aXE = {"Lcom/iqoption/charttools/ActiveIndicatorsManager$Helper$WriteTask;", "Ljava/lang/Runnable;", "key", "", "(Lcom/iqoption/charttools/ActiveIndicatorsManager$Helper;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "run", "", "techtools_release"})
        /* compiled from: ActiveIndicatorsManager.kt */
        private final class a implements Runnable {
            final /* synthetic */ a arS;
            private final String key;

            public a(a aVar, String str) {
                kotlin.jvm.internal.h.e(str, "key");
                this.arS = aVar;
                this.key = str;
            }

            public void run() {
                this.arS.ft(this.key);
            }
        }

        public a(k kVar) {
            kotlin.jvm.internal.h.e(kVar, "library");
            this.arR = kVar;
        }

        private final void fr(String str) {
            com.iqoption.core.h.i.Yo().q(new a(this, str));
        }

        public final synchronized List<com.iqoption.charttools.model.indicator.h> fs(String str) {
            List<com.iqoption.charttools.model.indicator.h> list;
            kotlin.jvm.internal.h.e(str, "key");
            list = (List) this.arP.get(str);
            if (list == null) {
                list = fu(str);
                if (list == null) {
                    list = m.emptyList();
                }
                this.arP.put(str, list);
            }
            return list;
        }

        public final synchronized void fi(String str) {
            kotlin.jvm.internal.h.e(str, "key");
            this.arP.remove(str);
            this.arQ.add(str);
            fr(str);
        }

        public final synchronized List<com.iqoption.charttools.model.indicator.h> b(String str, List<com.iqoption.charttools.model.indicator.h> list) {
            kotlin.jvm.internal.h.e(str, "key");
            kotlin.jvm.internal.h.e(list, "indicators");
            this.arP.put(str, list);
            fr(str);
            return list;
        }

        public final synchronized List<com.iqoption.charttools.model.indicator.h> a(String str, com.iqoption.charttools.model.indicator.h hVar) {
            List<com.iqoption.charttools.model.indicator.h> b;
            kotlin.jvm.internal.h.e(str, "key");
            kotlin.jvm.internal.h.e(hVar, "indicator");
            List<com.iqoption.charttools.model.indicator.h> fs = fs(str);
            int i = 0;
            for (com.iqoption.charttools.model.indicator.h index : fs) {
                if ((index.getIndex() == hVar.getIndex() ? 1 : null) != null) {
                    break;
                }
                i++;
            }
            i = -1;
            if (i != -1) {
                b = com.iqoption.core.ext.c.b(fs, i, hVar);
            } else {
                b = u.i((Collection) fs, (Object) hVar);
            }
            this.arP.put(str, b);
            fr(str);
            return b;
        }

        public final synchronized List<com.iqoption.charttools.model.indicator.h> z(String str, int i) {
            List<com.iqoption.charttools.model.indicator.h> fs;
            com.iqoption.charttools.model.indicator.h hVar;
            kotlin.jvm.internal.h.e(str, "key");
            fs = fs(str);
            int i2 = 0;
            for (com.iqoption.charttools.model.indicator.h hVar2 : fs) {
                if ((hVar2.getIndex() == i ? 1 : null) != null) {
                    break;
                }
                i2++;
            }
            i2 = -1;
            if (i2 != -1) {
                if (((com.iqoption.charttools.model.indicator.h) fs.get(i2)).KJ().LY()) {
                    Collection arrayList = new ArrayList();
                    for (Object next : fs) {
                        hVar2 = (com.iqoption.charttools.model.indicator.h) next;
                        Object obj = (hVar2.getIndex() == i || ((hVar2.KJ() instanceof com.iqoption.charttools.model.indicator.k) && ((com.iqoption.charttools.model.indicator.k) hVar2.KJ()).a(hVar2.Mc()) == i)) ? 1 : null;
                        if (obj == null) {
                            arrayList.add(next);
                        }
                    }
                    fs = (List) arrayList;
                } else {
                    fs = com.iqoption.core.ext.c.a((List) fs, i2);
                }
            }
            this.arP.put(str, fs);
            fr(str);
            return fs;
        }

        public final synchronized void Kc() {
            String jsonArray;
            Set<Entry> entrySet = this.arP.entrySet();
            kotlin.jvm.internal.h.d(entrySet, "map.entries");
            for (Entry entry : entrySet) {
                String str = (String) entry.getKey();
                List<com.iqoption.charttools.model.indicator.h> list = (List) entry.getValue();
                com.iqoption.core.data.a.a aVar = this.arN;
                kotlin.jvm.internal.h.d(str, "key");
                JsonArray jsonArray2 = new JsonArray();
                kotlin.jvm.internal.h.d(list, "indicators");
                for (com.iqoption.charttools.model.indicator.h hVar : list) {
                    JsonObject jsonObject = new JsonObject();
                    l.asx.a(jsonObject, hVar);
                    jsonArray2.add((JsonElement) jsonObject);
                }
                jsonArray = jsonArray2.toString();
                kotlin.jvm.internal.h.d(jsonArray, "JsonArray().apply {\n    …             }.toString()");
                aVar.aa(str, jsonArray);
                this.arQ.remove(str);
            }
            for (String jsonArray3 : this.arQ) {
                this.arN.remove(jsonArray3);
            }
            this.arQ.clear();
        }

        public final synchronized void ft(String str) {
            kotlin.jvm.internal.h.e(str, "key");
            List<com.iqoption.charttools.model.indicator.h> list = (List) this.arP.get(str);
            if (list != null) {
                com.iqoption.core.data.a.a aVar = this.arN;
                JsonArray jsonArray = new JsonArray();
                for (com.iqoption.charttools.model.indicator.h hVar : list) {
                    JsonObject jsonObject = new JsonObject();
                    l.asx.a(jsonObject, hVar);
                    jsonArray.add((JsonElement) jsonObject);
                }
                String jsonArray2 = jsonArray.toString();
                kotlin.jvm.internal.h.d(jsonArray2, "JsonArray().apply {\n    …             }.toString()");
                aVar.aa(str, jsonArray2);
            } else if (this.arQ.contains(str)) {
                this.arN.remove(str);
                this.arQ.remove(str);
            }
        }

        public final int Kd() {
            return this.arO.incrementAndGet();
        }

        private final List<com.iqoption.charttools.model.indicator.h> fu(String str) {
            String text = this.arN.getText(str);
            List<com.iqoption.charttools.model.indicator.h> list = null;
            if (text == null) {
                return null;
            }
            try {
                Map linkedHashMap = new LinkedHashMap();
                JsonArray<JsonElement> jsonArray = (JsonArray) com.iqoption.core.ext.d.a(text, JsonArray.class, null, 2, null);
                if (jsonArray != null) {
                    Collection arrayList = new ArrayList();
                    for (JsonElement jsonElement : jsonArray) {
                        Object a;
                        kotlin.jvm.internal.h.d(jsonElement, "json");
                        if (jsonElement.isJsonObject()) {
                            l lVar = l.asx;
                            k kVar = this.arR;
                            JsonObject asJsonObject = jsonElement.getAsJsonObject();
                            kotlin.jvm.internal.h.d(asJsonObject, "json.asJsonObject");
                            a = lVar.a(kVar, asJsonObject);
                        } else {
                            a = null;
                        }
                        if (a != null) {
                            arrayList.add(a);
                        }
                    }
                    Iterable<com.iqoption.charttools.model.indicator.h> iterable = (List) arrayList;
                    Collection arrayList2 = new ArrayList(n.e(iterable, 10));
                    for (com.iqoption.charttools.model.indicator.h hVar : iterable) {
                        int Kd = Kd();
                        linkedHashMap.put(Integer.valueOf(hVar.getIndex()), Integer.valueOf(Kd));
                        x KJ = hVar.KJ();
                        JsonArray deepCopy = hVar.Mc().deepCopy();
                        if (KJ instanceof com.iqoption.charttools.model.indicator.k) {
                            com.iqoption.charttools.model.indicator.k kVar2 = (com.iqoption.charttools.model.indicator.k) KJ;
                            kotlin.jvm.internal.h.d(deepCopy, "this");
                            Integer num = (Integer) linkedHashMap.get(Integer.valueOf(kVar2.a(deepCopy)));
                            int intValue = num != null ? num.intValue() : -1;
                            if (intValue != -1) {
                                ((com.iqoption.charttools.model.indicator.k) KJ).a(intValue, deepCopy);
                            }
                        }
                        kotlin.jvm.internal.h.d(deepCopy, "indicator.values.deepCop…                        }");
                        arrayList2.add(com.iqoption.charttools.model.indicator.h.a(hVar, null, Kd, false, deepCopy, 5, null));
                    }
                    list = (List) arrayList2;
                }
            } catch (Throwable th) {
                String a2 = f.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Error during parsing active indicators by key ");
                stringBuilder.append(str);
                com.iqoption.core.i.w(a2, stringBuilder.toString(), th);
                this.arN.remove(str);
            }
            if (list == null) {
                if ((((CharSequence) text).length() > 0 ? 1 : null) != null) {
                    this.arN.remove(str);
                }
            }
            return list;
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "helper", "Lcom/iqoption/charttools/ActiveIndicatorsManager$Helper;", "apply"})
    /* compiled from: ActiveIndicatorsManager.kt */
    static final class b<T, R> implements io.reactivex.c.f<T, R> {
        final /* synthetic */ JsonArray $values;
        final /* synthetic */ x arT;
        final /* synthetic */ String arU;

        b(x xVar, JsonArray jsonArray, String str) {
            this.arT = xVar;
            this.$values = jsonArray;
            this.arU = str;
        }

        public /* synthetic */ Object apply(Object obj) {
            return Integer.valueOf(a((a) obj));
        }

        public final int a(a aVar) {
            kotlin.jvm.internal.h.e(aVar, "helper");
            int Kd = aVar.Kd();
            com.iqoption.charttools.model.indicator.h hVar = new com.iqoption.charttools.model.indicator.h(this.arT, Kd, false, this.$values);
            List a = aVar.a(this.arU, hVar);
            if (f.arM.Kb()) {
                aVar.a("all", hVar);
            }
            f.arL.e(new a(this.arU, a, hVar));
            return Kd;
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "helper", "Lcom/iqoption/charttools/ActiveIndicatorsManager$Helper;", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: ActiveIndicatorsManager.kt */
    static final class c<T> implements io.reactivex.c.e<a> {
        final /* synthetic */ String arU;
        final /* synthetic */ com.iqoption.charttools.model.a.a arV;
        final /* synthetic */ int arW;

        c(com.iqoption.charttools.model.a.a aVar, int i, String str) {
            this.arV = aVar;
            this.arW = i;
            this.arU = str;
        }

        /* renamed from: b */
        public final void accept(a aVar) {
            Iterable<com.iqoption.charttools.model.indicator.h> JT = this.arV.JT();
            Map linkedHashMap = new LinkedHashMap(j.be(ad.jn(n.e(JT, 10)), 16));
            for (com.iqoption.charttools.model.indicator.h index : JT) {
                Pair D = kotlin.j.D(Integer.valueOf(index.getIndex()), Integer.valueOf(aVar.Kd()));
                linkedHashMap.put(D.getFirst(), D.aXF());
            }
            Collection arrayList = new ArrayList();
            Iterator it = this.arV.JT().iterator();
            while (true) {
                Object obj = null;
                if (!it.hasNext()) {
                    break;
                }
                com.iqoption.charttools.model.indicator.h hVar = (com.iqoption.charttools.model.indicator.h) it.next();
                Integer num = (Integer) linkedHashMap.get(Integer.valueOf(hVar.getIndex()));
                if (num != null) {
                    obj = com.iqoption.charttools.model.indicator.h.a(hVar, null, num.intValue(), false, null, 13, null);
                }
                if (obj != null) {
                    arrayList.add(obj);
                }
            }
            List list = (List) arrayList;
            Collection arrayList2 = new ArrayList();
            for (com.iqoption.charttools.model.indicator.h hVar2 : this.arV.Kr()) {
                Object obj2;
                x KJ = hVar2.KJ();
                if (!(KJ instanceof com.iqoption.charttools.model.indicator.k)) {
                    KJ = null;
                }
                com.iqoption.charttools.model.indicator.k kVar = (com.iqoption.charttools.model.indicator.k) KJ;
                if (kVar == null || kVar.b(hVar2.Mc()) != this.arW) {
                    obj2 = null;
                } else {
                    int Kd = aVar.Kd();
                    Integer num2 = (Integer) linkedHashMap.get(Integer.valueOf(kVar.a(hVar2.Mc())));
                    int intValue = num2 != null ? num2.intValue() : -1;
                    JsonArray deepCopy = hVar2.Mc().deepCopy();
                    if (intValue != -1) {
                        kotlin.jvm.internal.h.d(deepCopy, "this");
                        kVar.a(intValue, deepCopy);
                    }
                    kotlin.jvm.internal.h.d(deepCopy, "figure.values.deepCopy()…                        }");
                    obj2 = com.iqoption.charttools.model.indicator.h.a(hVar2, null, Kd, false, deepCopy, 5, null);
                }
                if (obj2 != null) {
                    arrayList2.add(obj2);
                }
            }
            List b = u.b((Collection) list, (Iterable) (List) arrayList2);
            aVar.b(this.arU, b);
            if (f.arM.Kb()) {
                aVar.b("all", b);
            }
            f.arL.e(new d(this.arU, b));
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/charttools/ActiveIndicatorEvent;", "test"})
    /* compiled from: ActiveIndicatorsManager.kt */
    static final class d<T> implements io.reactivex.c.k<b> {
        final /* synthetic */ String arU;

        d(String str) {
            this.arU = str;
        }

        /* renamed from: a */
        public final boolean test(b bVar) {
            kotlin.jvm.internal.h.e(bVar, "it");
            return kotlin.jvm.internal.h.E(bVar.getKey(), this.arU);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "Lcom/iqoption/charttools/model/indicator/ChartIndicator;", "helper", "Lcom/iqoption/charttools/ActiveIndicatorsManager$Helper;", "apply"})
    /* compiled from: ActiveIndicatorsManager.kt */
    static final class e<T, R> implements io.reactivex.c.f<T, R> {
        final /* synthetic */ String arU;

        e(String str) {
            this.arU = str;
        }

        /* renamed from: c */
        public final List<com.iqoption.charttools.model.indicator.h> apply(a aVar) {
            kotlin.jvm.internal.h.e(aVar, "helper");
            if (!f.arM.Kb()) {
                return aVar.fs(this.arU);
            }
            List<com.iqoption.charttools.model.indicator.h> fs = aVar.fs("all");
            aVar.b(this.arU, fs);
            return fs;
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "Lcom/iqoption/charttools/model/indicator/ChartIndicator;", "it", "Lcom/iqoption/charttools/ActiveIndicatorEvent;", "apply"})
    /* compiled from: ActiveIndicatorsManager.kt */
    static final class f<T, R> implements io.reactivex.c.f<T, R> {
        public static final f arX = new f();

        f() {
        }

        /* renamed from: b */
        public final List<com.iqoption.charttools.model.indicator.h> apply(b bVar) {
            kotlin.jvm.internal.h.e(bVar, "it");
            return bVar.JT();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "helper", "Lcom/iqoption/charttools/ActiveIndicatorsManager$Helper;", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: ActiveIndicatorsManager.kt */
    static final class g<T> implements io.reactivex.c.e<a> {
        public static final g asa = new g();

        g() {
        }

        /* renamed from: b */
        public final void accept(a aVar) {
            aVar.Kc();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "helper", "Lcom/iqoption/charttools/ActiveIndicatorsManager$Helper;", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: ActiveIndicatorsManager.kt */
    static final class h<T> implements io.reactivex.c.e<a> {
        final /* synthetic */ String arU;
        final /* synthetic */ int asb;

        h(String str, int i) {
            this.arU = str;
            this.asb = i;
        }

        /* renamed from: b */
        public final void accept(a aVar) {
            List z = aVar.z(this.arU, this.asb);
            if (f.arM.Kb()) {
                aVar.z("all", this.asb);
            }
            f.arL.e(new c(this.arU, z, this.asb));
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "helper", "Lcom/iqoption/charttools/ActiveIndicatorsManager$Helper;", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: ActiveIndicatorsManager.kt */
    static final class i<T> implements io.reactivex.c.e<a> {
        final /* synthetic */ String arU;

        i(String str) {
            this.arU = str;
        }

        /* renamed from: b */
        public final void accept(a aVar) {
            aVar.fi(this.arU);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "helper", "Lcom/iqoption/charttools/ActiveIndicatorsManager$Helper;", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: ActiveIndicatorsManager.kt */
    static final class j<T> implements io.reactivex.c.e<a> {
        final /* synthetic */ String arU;
        final /* synthetic */ List asc;

        j(String str, List list) {
            this.arU = str;
            this.asc = list;
        }

        /* renamed from: b */
        public final void accept(a aVar) {
            aVar.b(this.arU, this.asc);
            if (f.arM.Kb()) {
                aVar.b("all", this.asc);
            }
            f.arL.e(new d(this.arU, this.asc));
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
    /* compiled from: ActiveIndicatorsManager.kt */
    static final class k implements io.reactivex.c.a {
        final /* synthetic */ boolean asd;

        k(boolean z) {
            this.asd = z;
        }

        public final void run() {
            f.arI.put("apply_to_all_assets", this.asd);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "helper", "Lcom/iqoption/charttools/ActiveIndicatorsManager$Helper;", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: ActiveIndicatorsManager.kt */
    static final class l<T> implements io.reactivex.c.e<a> {
        final /* synthetic */ String arU;

        l(String str) {
            this.arU = str;
        }

        /* renamed from: b */
        public final void accept(a aVar) {
            aVar.b("all", aVar.fs(this.arU));
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "helper", "Lcom/iqoption/charttools/ActiveIndicatorsManager$Helper;", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: ActiveIndicatorsManager.kt */
    static final class m<T> implements io.reactivex.c.e<a> {
        final /* synthetic */ JsonArray $values;
        final /* synthetic */ String arU;
        final /* synthetic */ int asb;
        final /* synthetic */ Boolean ase;
        final /* synthetic */ boolean asf;

        m(String str, int i, Boolean bool, JsonArray jsonArray, boolean z) {
            this.arU = str;
            this.asb = i;
            this.ase = bool;
            this.$values = jsonArray;
            this.asf = z;
        }

        /* renamed from: b */
        public final void accept(a aVar) {
            for (Object next : aVar.fs(this.arU)) {
                Object obj;
                if (((com.iqoption.charttools.model.indicator.h) next).getIndex() == this.asb) {
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
            com.iqoption.charttools.model.indicator.h hVar = (com.iqoption.charttools.model.indicator.h) next2;
            if (hVar != null) {
                com.iqoption.charttools.model.indicator.h a;
                if (this.ase != null && this.$values != null) {
                    a = com.iqoption.charttools.model.indicator.h.a(hVar, null, 0, this.ase.booleanValue(), this.$values, 3, null);
                } else if (this.ase != null) {
                    a = com.iqoption.charttools.model.indicator.h.a(hVar, null, 0, this.ase.booleanValue(), null, 11, null);
                } else if (this.$values != null) {
                    a = com.iqoption.charttools.model.indicator.h.a(hVar, null, 0, false, this.$values, 7, null);
                } else {
                    throw new IllegalArgumentException("Nothing to update");
                }
                com.iqoption.charttools.model.indicator.h hVar2 = a;
                List a2 = aVar.a(this.arU, hVar2);
                if (f.arM.Kb()) {
                    aVar.a("all", hVar2);
                }
                f.arL.e(new e(this.arU, a2, hVar2, this.asf, this.$values != null));
            }
        }
    }

    private final BehaviorProcessor<Boolean> JW() {
        return (BehaviorProcessor) arJ.b(this, apP[0]);
    }

    private final o<a> JX() {
        kotlin.d dVar = arK;
        kotlin.reflect.j jVar = apP[1];
        return (o) dVar.getValue();
    }

    private final void a(BehaviorProcessor<Boolean> behaviorProcessor) {
        arJ.a(this, apP[0], behaviorProcessor);
    }

    private f() {
    }

    public final io.reactivex.e<b> fm(String str) {
        kotlin.jvm.internal.h.e(str, "key");
        io.reactivex.e<b> a = arL.a((io.reactivex.c.k) new d(str));
        kotlin.jvm.internal.h.d(a, "eventsProcessor.filter { it.key == key }");
        return a;
    }

    public final io.reactivex.a JY() {
        io.reactivex.a aWj = JX().d(g.asa).aWj();
        kotlin.jvm.internal.h.d(aWj, "helperStream\n           …         .ignoreElement()");
        return aWj;
    }

    public final o<List<com.iqoption.charttools.model.indicator.h>> fn(String str) {
        kotlin.jvm.internal.h.e(str, "key");
        o<List<com.iqoption.charttools.model.indicator.h>> n = JX().n(new e(str));
        kotlin.jvm.internal.h.d(n, "helperStream\n           …      }\n                }");
        return n;
    }

    public final io.reactivex.e<List<com.iqoption.charttools.model.indicator.h>> fo(String str) {
        kotlin.jvm.internal.h.e(str, "key");
        io.reactivex.e<List<com.iqoption.charttools.model.indicator.h>> c = fn(str).aWk().c((org.a.b) fm(str).d((io.reactivex.c.f) f.arX));
        kotlin.jvm.internal.h.d(c, "getIndicators(key)\n     …y).map { it.indicators })");
        return c;
    }

    public final io.reactivex.a fp(String str) {
        kotlin.jvm.internal.h.e(str, "key");
        io.reactivex.a aWj = JX().d(new i(str)).aWj();
        kotlin.jvm.internal.h.d(aWj, "helperStream\n           …         .ignoreElement()");
        return aWj;
    }

    public final o<Integer> a(String str, x xVar, JsonArray jsonArray) {
        kotlin.jvm.internal.h.e(str, "key");
        kotlin.jvm.internal.h.e(xVar, "metaIndicator");
        kotlin.jvm.internal.h.e(jsonArray, "values");
        o<Integer> n = JX().n(new b(xVar, jsonArray, str));
        kotlin.jvm.internal.h.d(n, "helperStream\n           …      }\n                }");
        return n;
    }

    public static /* bridge */ /* synthetic */ io.reactivex.a a(f fVar, String str, int i, Boolean bool, JsonArray jsonArray, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            bool = (Boolean) null;
        }
        Boolean bool2 = bool;
        if ((i2 & 8) != 0) {
            jsonArray = (JsonArray) null;
        }
        return fVar.a(str, i, bool2, jsonArray, (i2 & 16) != 0 ? false : z);
    }

    public final io.reactivex.a a(String str, int i, Boolean bool, JsonArray jsonArray, boolean z) {
        kotlin.jvm.internal.h.e(str, "key");
        io.reactivex.a aWj = JX().d(new m(str, i, bool, jsonArray, z)).aWj();
        kotlin.jvm.internal.h.d(aWj, "helperStream\n           …         .ignoreElement()");
        return aWj;
    }

    public final io.reactivex.a a(String str, List<com.iqoption.charttools.model.indicator.h> list) {
        kotlin.jvm.internal.h.e(str, "key");
        kotlin.jvm.internal.h.e(list, "indicators");
        io.reactivex.a aWj = JX().d(new j(str, list)).aWj();
        kotlin.jvm.internal.h.d(aWj, "helperStream\n           …         .ignoreElement()");
        return aWj;
    }

    public final io.reactivex.a y(String str, int i) {
        kotlin.jvm.internal.h.e(str, "key");
        io.reactivex.a aWj = JX().d(new h(str, i)).aWj();
        kotlin.jvm.internal.h.d(aWj, "helperStream\n           …         .ignoreElement()");
        return aWj;
    }

    public final io.reactivex.a fq(String str) {
        kotlin.jvm.internal.h.e(str, "key");
        return a(str, m.emptyList());
    }

    public final io.reactivex.a a(String str, int i, com.iqoption.charttools.model.a.a aVar) {
        kotlin.jvm.internal.h.e(str, "key");
        kotlin.jvm.internal.h.e(aVar, "template");
        io.reactivex.a aWj = JX().d(new c(aVar, i, str)).aWj();
        kotlin.jvm.internal.h.d(aWj, "helperStream\n           …         .ignoreElement()");
        return aWj;
    }

    public final io.reactivex.e<Boolean> JZ() {
        BehaviorProcessor JW = JW();
        if (JW == null) {
            JW = BehaviorProcessor.cl(Boolean.valueOf(Ka()));
            arM.a(JW);
            kotlin.jvm.internal.h.d(JW, "BehaviorProcessor.create…eProcessor = it\n        }");
        }
        return JW;
    }

    public final void bF(boolean z) {
        arI.put("volume", z);
        BehaviorProcessor JW = JW();
        if (JW != null) {
            JW.e(Boolean.valueOf(z));
        }
    }

    public final boolean Ka() {
        BehaviorProcessor JW = JW();
        if (JW != null) {
            Boolean bool = (Boolean) JW.getValue();
            if (bool != null) {
                return bool.booleanValue();
            }
        }
        return com.iqoption.core.data.d.b.b.a(arI, "volume", false, 2, null);
    }

    public final io.reactivex.a k(String str, boolean z) {
        io.reactivex.a aWj;
        kotlin.jvm.internal.h.e(str, "key");
        if (z) {
            aWj = JX().d(new l(str)).aWj();
        } else {
            aWj = fp(str);
        }
        aWj = aWj.c((io.reactivex.c.a) new k(z));
        kotlin.jvm.internal.h.d(aWj, "completable\n            …nabled)\n                }");
        return aWj;
    }

    public final boolean Kb() {
        return com.iqoption.core.data.d.b.b.a(arI, "apply_to_all_assets", false, 2, null);
    }
}
