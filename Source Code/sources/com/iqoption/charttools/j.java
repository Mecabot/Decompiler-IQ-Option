package com.iqoption.charttools;

import com.google.gson.JsonObject;
import com.iqoption.charttools.model.indicator.h;
import com.iqoption.charttools.model.indicator.k;
import com.iqoption.core.gl.Graph;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\b\u0018\u0000 #2\u00020\u0001:\u0001#B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bH\u0002J\b\u0010\u0014\u001a\u00020\rH\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0016J\u0018\u0010\u0016\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u000e\u0010\u0019\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bJ(\u0010\u001a\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00100\u001c2\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0002J\u000e\u0010\u001d\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bJ\"\u0010\u001e\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u00122\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0002J*\u0010 \u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00122\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0002J\f\u0010\"\u001a\u00020\u000b*\u00020\u0010H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, aXE = {"Lcom/iqoption/charttools/GraphIndicatorsBridge;", "Lio/reactivex/disposables/Disposable;", "graph", "Lcom/iqoption/core/gl/Graph;", "(Lcom/iqoption/core/gl/Graph;)V", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "getGraph", "()Lcom/iqoption/core/gl/Graph;", "initializedTabs", "", "", "addIndicator", "", "tabId", "indicator", "Lcom/iqoption/charttools/model/indicator/ChartIndicator;", "animate", "", "clearAllIndicators", "dispose", "isDisposed", "removeIndicator", "indexOfRemoved", "", "removeTab", "replaceIndicators", "indicators", "", "selectTab", "setVolumeShown", "shown", "updateIndicator", "isValueChanged", "serialize", "Companion", "techtools_release"})
/* compiled from: GraphIndicatorsBridge.kt */
public final class j implements io.reactivex.disposables.b {
    private static final String TAG = "j";
    public static final a asr = new a();
    private final Set<String> aso = new LinkedHashSet();
    private final io.reactivex.disposables.a asp = new io.reactivex.disposables.a();
    private final Graph asq;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, aXE = {"Lcom/iqoption/charttools/GraphIndicatorsBridge$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "VOLUME_ID", "", "VOLUME_JSON", "techtools_release"})
    /* compiled from: GraphIndicatorsBridge.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "", "indicators", "", "Lcom/iqoption/charttools/model/indicator/ChartIndicator;", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: GraphIndicatorsBridge.kt */
    static final class b<T> implements io.reactivex.c.e<List<? extends h>> {
        final /* synthetic */ j ass;
        final /* synthetic */ String ast;

        b(j jVar, String str) {
            this.ass = jVar;
            this.ast = str;
        }

        /* renamed from: C */
        public final void accept(List<h> list) {
            if (this.ass.aso.add(this.ast) || f.arM.Kb()) {
                j jVar = this.ass;
                String str = this.ast;
                kotlin.jvm.internal.h.d(list, "indicators");
                jVar.a(str, (List) list, false);
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: GraphIndicatorsBridge.kt */
    static final class c<T> implements io.reactivex.c.e<Throwable> {
        final /* synthetic */ String ast;

        c(String str) {
            this.ast = str;
        }

        /* renamed from: o */
        public final void accept(Throwable th) {
            String Ki = j.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Could not load indicators for tab ID: ");
            stringBuilder.append(this.ast);
            com.iqoption.core.i.w(Ki, stringBuilder.toString());
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "event", "Lcom/iqoption/charttools/ActiveIndicatorEvent;", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: GraphIndicatorsBridge.kt */
    static final class d<T> implements io.reactivex.c.e<b> {
        final /* synthetic */ j ass;

        d(j jVar) {
            this.ass = jVar;
        }

        /* renamed from: c */
        public final void accept(b bVar) {
            if (bVar instanceof a) {
                j.a(this.ass, bVar.getKey(), ((a) bVar).JS(), false, 4, null);
            } else if (bVar instanceof e) {
                e eVar = (e) bVar;
                if (!eVar.JV()) {
                    j.a(this.ass, bVar.getKey(), eVar.JS(), eVar.isValueChanged(), false, 8, null);
                }
            } else if (bVar instanceof c) {
                this.ass.A(bVar.getKey(), ((c) bVar).JU());
            } else if (bVar instanceof d) {
                j.a(this.ass, bVar.getKey(), bVar.JT(), false, 4, null);
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, aXE = {"<anonymous>", "", "isVolumeEnabled", "", "kotlin.jvm.PlatformType", "accept", "(Ljava/lang/Boolean;)V"})
    /* compiled from: GraphIndicatorsBridge.kt */
    static final class e<T> implements io.reactivex.c.e<Boolean> {
        final /* synthetic */ j ass;
        final /* synthetic */ String ast;

        e(j jVar, String str) {
            this.ass = jVar;
            this.ast = str;
        }

        /* renamed from: j */
        public final void accept(Boolean bool) {
            j jVar = this.ass;
            String str = this.ast;
            kotlin.jvm.internal.h.d(bool, "isVolumeEnabled");
            j.a(jVar, str, bool.booleanValue(), false, 4, null);
        }
    }

    public j(Graph graph) {
        kotlin.jvm.internal.h.e(graph, "graph");
        this.asq = graph;
    }

    public final void fv(String str) {
        kotlin.jvm.internal.h.e(str, "tabId");
        this.asp.clear();
        this.asp.e(f.arM.fn(str).h(com.iqoption.core.h.i.Yr()).a((io.reactivex.c.e) new b(this, str), (io.reactivex.c.e) new c(str)));
        this.asp.e(f.arM.fm(str).d(com.iqoption.core.h.i.Yr()).c((io.reactivex.c.e) new d(this)));
        this.asp.e(f.arM.JZ().d(com.iqoption.core.h.i.Yr()).c((io.reactivex.c.e) new e(this, str)));
    }

    public final void fw(String str) {
        kotlin.jvm.internal.h.e(str, "tabId");
        this.aso.remove(str);
    }

    public boolean isDisposed() {
        return this.asp.isDisposed();
    }

    public void dispose() {
        this.asp.clear();
    }

    private final void a(String str, h hVar, boolean z) {
        this.asq.glchInstrumentAdd(str, hVar.getIndex(), a(hVar), z);
        if (hVar.KJ() instanceof k) {
            this.asq.glchInstrumentSelect(str, hVar.getIndex());
        }
    }

    static /* bridge */ /* synthetic */ void a(j jVar, String str, h hVar, boolean z, boolean z2, int i, Object obj) {
        if ((i & 8) != 0) {
            z2 = true;
        }
        jVar.a(str, hVar, z, z2);
    }

    private final void a(String str, h hVar, boolean z, boolean z2) {
        if (!this.asq.glchInstrumentExists(str, hVar.getIndex())) {
            this.asq.glchInstrumentAdd(str, hVar.getIndex(), a(hVar), z2);
        } else if (z) {
            this.asq.glchInstrumentUpdate(str, hVar.getIndex(), a(hVar));
        } else {
            this.asq.glchInstrumentHide(str, hVar.getIndex(), hVar.isHidden());
        }
    }

    private final void A(String str, int i) {
        if (this.asq.glchInstrumentExists(str, i)) {
            this.asq.glchInstrumentRemove(str, i);
        }
    }

    private final void a(String str, List<h> list, boolean z) {
        fx(str);
        for (h hVar : list) {
            if (!hVar.isHidden()) {
                this.asq.glchInstrumentAdd(str, hVar.getIndex(), a(hVar), z);
            }
        }
    }

    private final void fx(String str) {
        boolean glchInstrumentExists = this.asq.glchInstrumentExists(str, -2);
        this.asq.glchInstrumentRemoveAll(str);
        if (glchInstrumentExists) {
            this.asq.glchInstrumentAdd(str, -2, "{\"title\": \"\", \"type\": \"Volume\", \"id\": -2}", false);
        }
    }

    private final String a(h hVar) {
        JsonObject jsonObject = new JsonObject();
        l.asx.b(jsonObject, hVar);
        String jsonObject2 = jsonObject.toString();
        kotlin.jvm.internal.h.d(jsonObject2, "JsonObject().also { json…his)\n        }.toString()");
        return jsonObject2;
    }

    private final void c(String str, boolean z, boolean z2) {
        if (z) {
            if (!this.asq.glchInstrumentExists(str, -2)) {
                this.asq.glchInstrumentAdd(str, -2, "{\"title\": \"\", \"type\": \"Volume\", \"id\": -2}", z2);
            }
        } else if (this.asq.glchInstrumentExists(str, -2)) {
            this.asq.glchInstrumentRemove(str, -2);
        }
    }
}
