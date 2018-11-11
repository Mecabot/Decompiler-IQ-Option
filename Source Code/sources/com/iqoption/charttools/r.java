package com.iqoption.charttools;

import com.google.gson.JsonObject;
import io.reactivex.o;
import io.reactivex.processors.PublishProcessor;
import io.reactivex.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u000201B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J4\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\r2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\rJ\b\u0010\"\u001a\u00020#H\u0016J\u000e\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u0004J\b\u0010&\u001a\u00020'H\u0002J\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00142\u0006\u0010%\u001a\u00020\u0004J\u0012\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0014J<\u0010*\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\r2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\rJ\u0016\u0010+\u001a\u00020\u000e*\u00020,2\b\b\u0002\u0010-\u001a\u00020'H\u0002J\f\u0010.\u001a\u00020/*\u00020 H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\n0\n0\tX\u0004¢\u0006\u0002\n\u0000R'\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00150\u00150\u0019X\u0004¢\u0006\u0002\n\u0000¨\u00062"}, aXE = {"Lcom/iqoption/charttools/TemplateManager;", "Lcom/iqoption/core/manager/LogoutClearList$Clearable;", "()V", "DISPOSE_DELAY", "", "TAG", "", "kotlin.jvm.PlatformType", "onSuccessUpdate", "Lio/reactivex/functions/Consumer;", "Lcom/iqoption/charttools/TemplateUpdated;", "streamSupplier", "Lcom/iqoption/core/rx/LiveStreamSupplier;", "", "Lcom/iqoption/charttools/model/template/ChartTemplate;", "getStreamSupplier", "()Lcom/iqoption/core/rx/LiveStreamSupplier;", "streamSupplier$delegate", "Lkotlin/Lazy;", "templateEvents", "Lio/reactivex/Flowable;", "Lcom/iqoption/charttools/TemplateEvent;", "getTemplateEvents", "()Lio/reactivex/Flowable;", "templateEventsProcessor", "Lio/reactivex/processors/PublishProcessor;", "addTemplate", "Lio/reactivex/Completable;", "name", "chartConfig", "Lcom/iqoption/charttools/model/chart/ChartConfig;", "indicators", "Lcom/iqoption/charttools/model/indicator/ChartIndicator;", "figures", "clearOnLogout", "", "deleteTemplate", "id", "getLibrary", "Lcom/iqoption/charttools/IndicatorsLibrary;", "getTemplate", "getTemplates", "updateTemplate", "map", "Lcom/iqoption/core/microservices/techinstruments/response/Template;", "library", "serialize", "Lcom/google/gson/JsonObject;", "TemplatesComplexUpdate", "TemplatesUpdate", "techtools_release"})
/* compiled from: TemplateManager.kt */
public final class r implements com.iqoption.core.f.a.a {
    private static final String TAG = "r";
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(r.class), "streamSupplier", "getStreamSupplier()Lcom/iqoption/core/rx/LiveStreamSupplier;"))};
    private static final PublishProcessor<q> asT = PublishProcessor.aXq();
    private static final io.reactivex.e<q> asU;
    private static final io.reactivex.c.e<t> asV = f.atj;
    private static final kotlin.d asW = g.f(TemplateManager$streamSupplier$2.atk);
    public static final r asX = new r();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0016\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, aXE = {"Lcom/iqoption/charttools/TemplateManager$TemplatesComplexUpdate;", "", "changed", "", "Lcom/iqoption/charttools/model/template/ChartTemplate;", "removed", "", "(Ljava/util/List;[J)V", "getChanged", "()Ljava/util/List;", "getRemoved", "()[J", "techtools_release"})
    /* compiled from: TemplateManager.kt */
    public static final class a {
        private final List<com.iqoption.charttools.model.a.a> asY;
        private final long[] asZ;

        public a() {
            this(null, null, 3, null);
        }

        public a(List<com.iqoption.charttools.model.a.a> list, long[] jArr) {
            h.e(list, "changed");
            h.e(jArr, "removed");
            this.asY = list;
            this.asZ = jArr;
        }

        public /* synthetic */ a(List list, long[] jArr, int i, f fVar) {
            if ((i & 1) != 0) {
                list = m.emptyList();
            }
            if ((i & 2) != 0) {
                jArr = com.iqoption.core.ext.c.ST();
            }
            this(list, jArr);
        }

        public final List<com.iqoption.charttools.model.a.a> Kw() {
            return this.asY;
        }

        public final long[] Kx() {
            return this.asZ;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B;\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0000R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, aXE = {"Lcom/iqoption/charttools/TemplateManager$TemplatesUpdate;", "", "list", "", "Lcom/iqoption/charttools/model/template/ChartTemplate;", "minus", "", "update", "complexUpdate", "Lcom/iqoption/charttools/TemplateManager$TemplatesComplexUpdate;", "(Ljava/util/List;Ljava/lang/Long;Lcom/iqoption/charttools/model/template/ChartTemplate;Lcom/iqoption/charttools/TemplateManager$TemplatesComplexUpdate;)V", "getComplexUpdate", "()Lcom/iqoption/charttools/TemplateManager$TemplatesComplexUpdate;", "current", "getCurrent", "()Ljava/util/List;", "getList", "getMinus", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getUpdate", "()Lcom/iqoption/charttools/model/template/ChartTemplate;", "techtools_release"})
    /* compiled from: TemplateManager.kt */
    public static final class b {
        private final List<com.iqoption.charttools.model.a.a> ata;
        private final Long atb;
        private final com.iqoption.charttools.model.a.a atc;
        private final a atd;

        public b() {
            this(null, null, null, null, 15, null);
        }

        public b(List<com.iqoption.charttools.model.a.a> list, Long l, com.iqoption.charttools.model.a.a aVar, a aVar2) {
            this.ata = list;
            this.atb = l;
            this.atc = aVar;
            this.atd = aVar2;
        }

        public /* synthetic */ b(List list, Long l, com.iqoption.charttools.model.a.a aVar, a aVar2, int i, f fVar) {
            if ((i & 1) != 0) {
                list = (List) null;
            }
            if ((i & 2) != 0) {
                l = (Long) null;
            }
            if ((i & 4) != 0) {
                aVar = (com.iqoption.charttools.model.a.a) null;
            }
            if ((i & 8) != 0) {
                aVar2 = (a) null;
            }
            this(list, l, aVar, aVar2);
        }

        public final List<com.iqoption.charttools.model.a.a> Ky() {
            if (this.ata != null) {
                return this.ata;
            }
            if (this.atc != null) {
                return l.cr(this.atc);
            }
            a aVar = this.atd;
            if ((aVar != null ? aVar.Kw() : null) != null) {
                return this.atd.Kw();
            }
            return m.emptyList();
        }

        public final b a(b bVar) {
            b bVar2 = bVar;
            h.e(bVar2, "update");
            List<com.iqoption.charttools.model.a.a> O;
            int i;
            List<com.iqoption.charttools.model.a.a> Ky;
            int i2;
            if (bVar2.ata != null) {
                O = u.O((Collection) Ky());
                for (com.iqoption.charttools.model.a.a aVar : bVar2.ata) {
                    i = 0;
                    for (com.iqoption.charttools.model.a.a id : O) {
                        if ((id.getId() == aVar.getId() ? 1 : null) != null) {
                            break;
                        }
                        i++;
                    }
                    i = -1;
                    if (i != -1) {
                        O.set(i, aVar);
                    } else {
                        O.add(aVar);
                    }
                }
                return new b(O, null, null, null, 14, null);
            } else if (bVar2.atb != null) {
                List list;
                Ky = Ky();
                i2 = 0;
                for (com.iqoption.charttools.model.a.a id2 : Ky) {
                    long id3 = id2.getId();
                    Long l = bVar2.atb;
                    Object obj = (l != null && id3 == l.longValue()) ? 1 : null;
                    if (obj != null) {
                        break;
                    }
                    i2++;
                }
                i2 = -1;
                if (i2 != -1) {
                    List O2 = u.O((Collection) Ky);
                    O2.remove(i2);
                    list = O2;
                } else {
                    list = Ky;
                }
                return new b(list, null, null, null, 14, null);
            } else if (bVar2.atc != null) {
                List O3;
                Ky = Ky();
                com.iqoption.charttools.model.a.a aVar2 = bVar2.atc;
                i2 = 0;
                for (com.iqoption.charttools.model.a.a id22 : Ky) {
                    if ((id22.getId() == aVar2.getId() ? 1 : null) != null) {
                        break;
                    }
                    i2++;
                }
                i2 = -1;
                if (i2 != -1) {
                    O3 = u.O((Collection) Ky);
                    O3.set(i2, aVar2);
                } else {
                    O3 = u.O((Collection) Ky);
                    O3.add(aVar2);
                }
                return new b(O3, null, null, null, 14, null);
            } else if (bVar2.atd == null) {
                return this;
            } else {
                O = u.O((Collection) Ky());
                for (long j : bVar2.atd.Kx()) {
                    int i3 = 0;
                    for (com.iqoption.charttools.model.a.a id4 : O) {
                        if ((id4.getId() == j ? 1 : null) != null) {
                            break;
                        }
                        i3++;
                    }
                    i3 = -1;
                    if (i3 != -1) {
                        O.remove(i3);
                    }
                }
                for (com.iqoption.charttools.model.a.a aVar3 : bVar2.atd.Kw()) {
                    i = 0;
                    for (com.iqoption.charttools.model.a.a id5 : O) {
                        if ((id5.getId() == aVar3.getId() ? 1 : null) != null) {
                            break;
                        }
                        i++;
                    }
                    i = -1;
                    if (i != -1) {
                        O.set(i, aVar3);
                    } else {
                        O.add(aVar3);
                    }
                }
                return new b(O, null, null, null, 14, null);
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "Lio/reactivex/Single;", "Lcom/iqoption/charttools/TemplateUpdated;", "kotlin.jvm.PlatformType", "library", "Lcom/iqoption/charttools/IndicatorsLibrary;", "apply"})
    /* compiled from: TemplateManager.kt */
    static final class c<T, R> implements io.reactivex.c.f<T, s<? extends R>> {
        final /* synthetic */ String $name;
        final /* synthetic */ List asc;
        final /* synthetic */ com.iqoption.charttools.model.chart.a ate;
        final /* synthetic */ List atf;

        c(String str, com.iqoption.charttools.model.chart.a aVar, List list, List list2) {
            this.$name = str;
            this.ate = aVar;
            this.asc = list;
            this.atf = list2;
        }

        /* renamed from: c */
        public final o<t> apply(final k kVar) {
            h.e(kVar, "library");
            com.iqoption.core.microservices.techinstruments.a aVar = com.iqoption.core.microservices.techinstruments.a.aXU;
            String str = this.$name;
            com.iqoption.charttools.model.chart.a aVar2 = this.ate;
            JsonObject LO = aVar2 != null ? aVar2.LO() : null;
            Iterable<com.iqoption.charttools.model.indicator.h> iterable = this.asc;
            Collection arrayList = new ArrayList(n.e(iterable, 10));
            for (com.iqoption.charttools.model.indicator.h a : iterable) {
                arrayList.add(r.asX.c(a));
            }
            List list = (List) arrayList;
            iterable = this.atf;
            Collection arrayList2 = new ArrayList(n.e(iterable, 10));
            for (com.iqoption.charttools.model.indicator.h a2 : iterable) {
                arrayList2.add(r.asX.c(a2));
            }
            return aVar.a(str, LO, list, (List) arrayList2).n(new io.reactivex.c.f<T, R>() {
                /* renamed from: a */
                public final t apply(com.iqoption.core.microservices.techinstruments.a.e eVar) {
                    h.e(eVar, "it");
                    r rVar = r.asX;
                    k kVar = kVar;
                    h.d(kVar, "library");
                    return new t(rVar.a(eVar, kVar));
                }
            });
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
    /* compiled from: TemplateManager.kt */
    static final class d implements io.reactivex.c.a {
        final /* synthetic */ long ath;

        d(long j) {
            this.ath = j;
        }

        public final void run() {
            r.asT.e(new s(this.ath));
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u0001H\u0002H\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u0001H\u0002H\u0002\u0018\u00010\u00010\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, aXE = {"<anonymous>", "Lio/reactivex/Flowable;", "T", "kotlin.jvm.PlatformType", "it", "", "apply", "com/iqoption/core/ext/RxExtensionsKt$findOrEmpty$1"})
    /* compiled from: RxExtensions.kt */
    public static final class e<T, R> implements io.reactivex.c.f<T, org.a.b<? extends R>> {
        final /* synthetic */ long ati;

        public e(long j) {
            this.ati = j;
        }

        /* renamed from: J */
        public final io.reactivex.e<T> apply(List<? extends T> list) {
            h.e(list, "it");
            for (Object next : list) {
                Object obj;
                if (((com.iqoption.charttools.model.a.a) next).getId() == this.ati) {
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
            if (next2 != null) {
                return io.reactivex.e.bW(next2);
            }
            return io.reactivex.e.aVU();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "event", "Lcom/iqoption/charttools/TemplateUpdated;", "accept"})
    /* compiled from: TemplateManager.kt */
    static final class f<T> implements io.reactivex.c.e<t> {
        public static final f atj = new f();

        f() {
        }

        /* renamed from: a */
        public final void accept(t tVar) {
            h.e(tVar, "event");
            r.asT.e(tVar);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "Lio/reactivex/Single;", "Lcom/iqoption/charttools/TemplateUpdated;", "kotlin.jvm.PlatformType", "library", "Lcom/iqoption/charttools/IndicatorsLibrary;", "apply"})
    /* compiled from: TemplateManager.kt */
    static final class g<T, R> implements io.reactivex.c.f<T, s<? extends R>> {
        final /* synthetic */ String $name;
        final /* synthetic */ List asc;
        final /* synthetic */ com.iqoption.charttools.model.chart.a ate;
        final /* synthetic */ List atf;
        final /* synthetic */ long ath;

        g(long j, String str, com.iqoption.charttools.model.chart.a aVar, List list, List list2) {
            this.ath = j;
            this.$name = str;
            this.ate = aVar;
            this.asc = list;
            this.atf = list2;
        }

        /* JADX WARNING: Missing block: B:3:0x0013, code:
            if (r0 != null) goto L_0x001a;
     */
        /* renamed from: c */
        public final io.reactivex.o<com.iqoption.charttools.t> apply(final com.iqoption.charttools.k r11) {
            /*
            r10 = this;
            r0 = "library";
            kotlin.jvm.internal.h.e(r11, r0);
            r1 = com.iqoption.core.microservices.techinstruments.a.aXU;
            r2 = r10.ath;
            r4 = r10.$name;
            r0 = r10.ate;
            if (r0 == 0) goto L_0x0016;
        L_0x000f:
            r0 = r0.LO();
            if (r0 == 0) goto L_0x0016;
        L_0x0015:
            goto L_0x001a;
        L_0x0016:
            r0 = com.iqoption.core.ext.d.SX();
        L_0x001a:
            r5 = r0;
            r0 = r10.asc;
            r0 = (java.lang.Iterable) r0;
            r6 = new java.util.ArrayList;
            r7 = 10;
            r8 = kotlin.collections.n.e(r0, r7);
            r6.<init>(r8);
            r6 = (java.util.Collection) r6;
            r0 = r0.iterator();
        L_0x0030:
            r8 = r0.hasNext();
            if (r8 == 0) goto L_0x0046;
        L_0x0036:
            r8 = r0.next();
            r8 = (com.iqoption.charttools.model.indicator.h) r8;
            r9 = com.iqoption.charttools.r.asX;
            r8 = r9.c(r8);
            r6.add(r8);
            goto L_0x0030;
        L_0x0046:
            r6 = (java.util.List) r6;
            r0 = r10.atf;
            r0 = (java.lang.Iterable) r0;
            r8 = new java.util.ArrayList;
            r7 = kotlin.collections.n.e(r0, r7);
            r8.<init>(r7);
            r8 = (java.util.Collection) r8;
            r0 = r0.iterator();
        L_0x005b:
            r7 = r0.hasNext();
            if (r7 == 0) goto L_0x0071;
        L_0x0061:
            r7 = r0.next();
            r7 = (com.iqoption.charttools.model.indicator.h) r7;
            r9 = com.iqoption.charttools.r.asX;
            r7 = r9.c(r7);
            r8.add(r7);
            goto L_0x005b;
        L_0x0071:
            r7 = r8;
            r7 = (java.util.List) r7;
            r0 = r1.a(r2, r4, r5, r6, r7);
            r1 = new com.iqoption.charttools.r$g$1;
            r1.<init>(r11);
            r1 = (io.reactivex.c.f) r1;
            r11 = r0.n(r1);
            return r11;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iqoption.charttools.r.g.c(com.iqoption.charttools.k):io.reactivex.o<com.iqoption.charttools.t>");
        }
    }

    private final com.iqoption.core.h.d<List<com.iqoption.charttools.model.a.a>> Ku() {
        kotlin.d dVar = asW;
        j jVar = apP[0];
        return (com.iqoption.core.h.d) dVar.getValue();
    }

    static {
        PublishProcessor publishProcessor = asT;
        h.d(publishProcessor, "templateEventsProcessor");
        asU = publishProcessor;
    }

    private r() {
    }

    public final io.reactivex.e<q> Kt() {
        return asU;
    }

    public void Js() {
        com.iqoption.core.h.d.a(Ku(), null, 1, null);
    }

    public final io.reactivex.e<List<com.iqoption.charttools.model.a.a>> Kv() {
        return Ku().Yg();
    }

    public final io.reactivex.e<com.iqoption.charttools.model.a.a> aI(long j) {
        io.reactivex.e<com.iqoption.charttools.model.a.a> a = Kv().a((io.reactivex.c.f) new e(j));
        h.d(a, "flatMap {\n        val fo…e.empty()\n        }\n    }");
        return a;
    }

    public final io.reactivex.a a(String str, com.iqoption.charttools.model.chart.a aVar, List<com.iqoption.charttools.model.indicator.h> list, List<com.iqoption.charttools.model.indicator.h> list2) {
        h.e(str, "name");
        h.e(list, "indicators");
        h.e(list2, "figures");
        io.reactivex.a aWj = l.asx.Km().k(new c(str, aVar, list, list2)).d(asV).aWj();
        h.d(aWj, "IndicatorsLibraryManager…         .ignoreElement()");
        return aWj;
    }

    public final io.reactivex.a a(long j, String str, com.iqoption.charttools.model.chart.a aVar, List<com.iqoption.charttools.model.indicator.h> list, List<com.iqoption.charttools.model.indicator.h> list2) {
        h.e(str, "name");
        h.e(list, "indicators");
        h.e(list2, "figures");
        io.reactivex.a aWj = l.asx.Km().k(new g(j, str, aVar, list, list2)).d(asV).aWj();
        h.d(aWj, "IndicatorsLibraryManager…         .ignoreElement()");
        return aWj;
    }

    public final io.reactivex.a aJ(long j) {
        io.reactivex.a c = com.iqoption.core.microservices.techinstruments.a.aXU.aJ(j).c((io.reactivex.c.a) new d(j));
        h.d(c, "TechInstrumentsRequests\n…ed(id))\n                }");
        return c;
    }

    /* JADX WARNING: Missing block: B:3:0x001f, code:
            if ((r1.isEmpty() ^ 1) != 0) goto L_0x0023;
     */
    private final com.iqoption.charttools.model.a.a a(com.iqoption.core.microservices.techinstruments.a.e r10, com.iqoption.charttools.k r11) {
        /*
        r9 = this;
        r0 = r10.WV();
        r1 = r0.isJsonObject();
        r2 = 1;
        if (r1 == 0) goto L_0x0022;
    L_0x000b:
        r1 = r0.getAsJsonObject();
        r1 = r1.keySet();
        r3 = "it.asJsonObject.keySet()";
        kotlin.jvm.internal.h.d(r1, r3);
        r1 = (java.util.Collection) r1;
        r1 = r1.isEmpty();
        r1 = r1 ^ r2;
        if (r1 == 0) goto L_0x0022;
    L_0x0021:
        goto L_0x0023;
    L_0x0022:
        r2 = 0;
    L_0x0023:
        r1 = 0;
        if (r2 == 0) goto L_0x0027;
    L_0x0026:
        goto L_0x0028;
    L_0x0027:
        r0 = r1;
    L_0x0028:
        if (r0 == 0) goto L_0x002f;
    L_0x002a:
        r1 = new com.iqoption.charttools.model.chart.a;
        r1.<init>(r0);
    L_0x002f:
        r6 = r1;
        r0 = r10.JT();
        r0 = (java.lang.Iterable) r0;
        r1 = new java.util.ArrayList;
        r1.<init>();
        r1 = (java.util.Collection) r1;
        r0 = r0.iterator();
    L_0x0041:
        r2 = r0.hasNext();
        if (r2 == 0) goto L_0x0059;
    L_0x0047:
        r2 = r0.next();
        r2 = (com.google.gson.JsonObject) r2;
        r3 = com.iqoption.charttools.l.asx;
        r2 = r3.a(r11, r2);
        if (r2 == 0) goto L_0x0041;
    L_0x0055:
        r1.add(r2);
        goto L_0x0041;
    L_0x0059:
        r7 = r1;
        r7 = (java.util.List) r7;
        r0 = r10.Kr();
        r0 = (java.lang.Iterable) r0;
        r1 = new java.util.ArrayList;
        r1.<init>();
        r1 = (java.util.Collection) r1;
        r0 = r0.iterator();
    L_0x006d:
        r2 = r0.hasNext();
        if (r2 == 0) goto L_0x0085;
    L_0x0073:
        r2 = r0.next();
        r2 = (com.google.gson.JsonObject) r2;
        r3 = com.iqoption.charttools.l.asx;
        r2 = r3.a(r11, r2);
        if (r2 == 0) goto L_0x006d;
    L_0x0081:
        r1.add(r2);
        goto L_0x006d;
    L_0x0085:
        r8 = r1;
        r8 = (java.util.List) r8;
        r11 = new com.iqoption.charttools.model.a.a;
        r3 = r10.getId();
        r5 = r10.getName();
        r2 = r11;
        r2.<init>(r3, r5, r6, r7, r8);
        return r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.charttools.r.a(com.iqoption.core.microservices.techinstruments.a.e, com.iqoption.charttools.k):com.iqoption.charttools.model.a.a");
    }

    private final JsonObject c(com.iqoption.charttools.model.indicator.h hVar) {
        JsonObject jsonObject = new JsonObject();
        l.asx.a(jsonObject, hVar);
        return jsonObject;
    }
}
