package com.iqoption.quiz.model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.FragmentActivity;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.util.p;
import com.iqoption.quiz.m;
import io.reactivex.c.e;
import io.reactivex.c.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.d;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 !2\u00020\u0001:\u0002!\"B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0014J\"\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050 2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00170\u0005H\u0002R'\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00048FX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0004¢\u0006\u0002\n\u0000R!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00048FX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0010\u0010\b¨\u0006#"}, aXE = {"Lcom/iqoption/quiz/model/QuizInsightsViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "insights", "Landroid/arch/lifecycle/LiveData;", "", "Lcom/iqoption/quiz/model/QuizInsightsAdapterItem;", "getInsights", "()Landroid/arch/lifecycle/LiveData;", "insights$delegate", "Lkotlin/Lazy;", "quizApi", "Lcom/iqoption/quiz/api/TriviaApi;", "kotlin.jvm.PlatformType", "showInsights", "", "getShowInsights", "showInsights$delegate", "createQuizInsightItem", "Lcom/iqoption/quiz/model/QuizInsightItem;", "asset", "Lcom/iqoption/asset/mediators/AssetDisplayData;", "insight", "Lcom/iqoption/quiz/api/response/InsightResponse;", "getName", "", "active", "Lcom/iqoption/core/microservices/tradingengine/response/active/Active;", "getShortName", "onCleared", "", "subscribeForInsightsData", "Lio/reactivex/Flowable;", "Companion", "ShowInsightsLiveData", "quiz_release"})
/* compiled from: QuizInsightsViewModel.kt */
public final class QuizInsightsViewModel extends ViewModel {
    private static final String TAG = "QuizInsightsViewModel";
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(QuizInsightsViewModel.class), "insights", "getInsights()Landroid/arch/lifecycle/LiveData;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(QuizInsightsViewModel.class), "showInsights", "getShowInsights()Landroid/arch/lifecycle/LiveData;"))};
    public static final a dlH = new a();
    private final d dlF = g.f(new QuizInsightsViewModel$insights$2(this));
    private final d dlG = g.f(new QuizInsightsViewModel$showInsights$2(this));
    private final com.iqoption.quiz.api.b dli = m.ayY().azi();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, aXE = {"Lcom/iqoption/quiz/model/QuizInsightsViewModel$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "create", "Lcom/iqoption/quiz/model/QuizInsightsViewModel;", "activity", "Landroid/support/v4/app/FragmentActivity;", "quiz_release"})
    /* compiled from: QuizInsightsViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final QuizInsightsViewModel w(FragmentActivity fragmentActivity) {
            h.e(fragmentActivity, "activity");
            ViewModel h = ViewModelProviders.b(fragmentActivity).h(QuizInsightsViewModel.class);
            h.d(h, "ViewModelProviders.of(ac…htsViewModel::class.java)");
            return (QuizInsightsViewModel) h;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "Lcom/iqoption/quiz/model/QuizInsightItem;", "assets", "Lcom/iqoption/asset/mediators/AssetDisplayData;", "apply"})
    /* compiled from: QuizInsightsViewModel.kt */
    static final class c<T, R> implements f<T, R> {
        final /* synthetic */ List dlQ;
        final /* synthetic */ QuizInsightsViewModel this$0;

        c(QuizInsightsViewModel quizInsightsViewModel, List list) {
            this.this$0 = quizInsightsViewModel;
            this.dlQ = list;
        }

        /* renamed from: m */
        public final List<e> apply(List<com.iqoption.asset.mediators.a> list) {
            h.e(list, "assets");
            Collection arrayList = new ArrayList();
            for (com.iqoption.quiz.api.response.b bVar : this.dlQ) {
                Object obj;
                Object obj2;
                Iterator it = list.iterator();
                Object obj3;
                do {
                    obj = null;
                    if (!it.hasNext()) {
                        obj2 = null;
                        break;
                    }
                    obj2 = it.next();
                    com.iqoption.asset.mediators.a aVar = (com.iqoption.asset.mediators.a) obj2;
                    if (bVar.getActiveId() == aVar.Jg().getActiveId() && h.E(bVar.getOptionType(), aVar.Jg().getInstrumentType().getServerValue())) {
                        obj3 = 1;
                        continue;
                    } else {
                        obj3 = null;
                        continue;
                    }
                } while (obj3 == null);
                com.iqoption.asset.mediators.a aVar2 = (com.iqoption.asset.mediators.a) obj2;
                if (aVar2 != null) {
                    obj = this.this$0.a(aVar2, bVar);
                }
                if (obj != null) {
                    arrayList.add(obj);
                }
            }
            return (List) arrayList;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004¢\u0006\u0002\u0010\u0007J\u0006\u0010\u001f\u001a\u00020 J\b\u0010!\u001a\u00020 H\u0002R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0002X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\n \u0013*\u0004\u0018\u00010\u00120\u0012X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000bR\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001b¨\u0006\""}, aXE = {"Lcom/iqoption/quiz/model/QuizInsightsViewModel$ShowInsightsLiveData;", "Landroid/arch/lifecycle/MediatorLiveData;", "", "insights", "Landroid/arch/lifecycle/LiveData;", "", "Lcom/iqoption/quiz/model/QuizInsightsAdapterItem;", "(Landroid/arch/lifecycle/LiveData;)V", "disposable", "Lio/reactivex/disposables/CompositeDisposable;", "getDisposable", "()Lio/reactivex/disposables/CompositeDisposable;", "insightListIsEmpty", "getInsightListIsEmpty", "()Z", "setInsightListIsEmpty", "(Z)V", "quizApi", "Lcom/iqoption/quiz/api/TriviaApi;", "kotlin.jvm.PlatformType", "timeStampsDisposable", "getTimeStampsDisposable", "timestampBegin", "", "getTimestampBegin", "()J", "setTimestampBegin", "(J)V", "timestampEnd", "getTimestampEnd", "setTimestampEnd", "onCleared", "", "updateValue", "quiz_release"})
    /* compiled from: QuizInsightsViewModel.kt */
    private static final class b extends MediatorLiveData<Boolean> {
        private final io.reactivex.disposables.a bco = new io.reactivex.disposables.a();
        private long dik;
        private long dil;
        private boolean dlI = true;
        private final io.reactivex.disposables.a dlJ = new io.reactivex.disposables.a();
        private final com.iqoption.quiz.api.b dli = m.ayY().azi();

        @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00060\u0003H\n¢\u0006\u0002\b\u0007"}, aXE = {"<anonymous>", "", "it", "", "Lcom/iqoption/quiz/api/response/InsightResponse;", "kotlin.jvm.PlatformType", "", "accept"})
        /* compiled from: QuizInsightsViewModel.kt */
        /* renamed from: com.iqoption.quiz.model.QuizInsightsViewModel$b$1 */
        static final class AnonymousClass1<T> implements e<List<com.iqoption.quiz.api.response.b>> {
            final /* synthetic */ b dlK;

            AnonymousClass1(b bVar) {
                this.dlK = bVar;
            }

            /* renamed from: C */
            public final void accept(List<com.iqoption.quiz.api.response.b> list) {
                if (this.dlK.aAg() == 0 && list != null && (list.isEmpty() ^ 1) == 1) {
                    this.dlK.bR(((com.iqoption.quiz.api.response.b) list.get(0)).aAg());
                    this.dlK.bS(((com.iqoption.quiz.api.response.b) list.get(0)).aAh());
                    this.dlK.eL(false);
                    this.dlK.awG();
                }
            }
        }

        @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "", "Lcom/iqoption/quiz/model/QuizInsightsAdapterItem;", "onChanged"})
        /* compiled from: QuizInsightsViewModel.kt */
        /* renamed from: com.iqoption.quiz.model.QuizInsightsViewModel$b$3 */
        static final class AnonymousClass3<T> implements Observer<List<? extends f>> {
            final /* synthetic */ b dlK;

            @i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
            /* compiled from: QuizInsightsViewModel.kt */
            /* renamed from: com.iqoption.quiz.model.QuizInsightsViewModel$b$3$1 */
            static final class AnonymousClass1 implements Runnable {
                final /* synthetic */ AnonymousClass3 dlM;

                AnonymousClass1(AnonymousClass3 anonymousClass3) {
                    this.dlM = anonymousClass3;
                }

                public final void run() {
                    this.dlM.dlK.awG();
                }
            }

            @i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
            /* compiled from: QuizInsightsViewModel.kt */
            /* renamed from: com.iqoption.quiz.model.QuizInsightsViewModel$b$3$2 */
            static final class AnonymousClass2 implements Runnable {
                final /* synthetic */ AnonymousClass3 dlM;

                AnonymousClass2(AnonymousClass3 anonymousClass3) {
                    this.dlM = anonymousClass3;
                }

                public final void run() {
                    this.dlM.dlK.awG();
                }
            }

            AnonymousClass3(b bVar) {
                this.dlK = bVar;
            }

            /* renamed from: L */
            public final void onChanged(List<? extends f> list) {
                f fVar;
                if (list != null) {
                    for (Object next : list) {
                        Object obj;
                        if (((f) next) == h.dlD) {
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
                    fVar = (f) next2;
                } else {
                    fVar = null;
                }
                if (fVar == null) {
                    f fVar2;
                    if (list != null) {
                        for (Object next3 : list) {
                            if (((f) next3) instanceof e) {
                                break;
                            }
                        }
                        Object next32 = null;
                        fVar2 = (f) next32;
                    } else {
                        fVar2 = null;
                    }
                    if (!(fVar2 instanceof e)) {
                        fVar2 = null;
                    }
                    e eVar = (e) fVar2;
                    if (eVar == null) {
                        this.dlK.eL(true);
                        this.dlK.bR(0);
                        this.dlK.bS(0);
                    } else {
                        this.dlK.eL(false);
                        long j = (long) 1000;
                        this.dlK.bR(eVar.aAg() * j);
                        this.dlK.bS(eVar.aAh() * j);
                        if (!com.iqoption.core.ext.c.aS(this.dlK.aAh())) {
                            this.dlK.aBt().clear();
                            if (!com.iqoption.core.ext.c.aS(this.dlK.aAg())) {
                                this.dlK.aBt().e(com.iqoption.core.h.i.Yo().b(new AnonymousClass1(this), com.iqoption.core.ext.c.aT(this.dlK.aAg()) + 1, TimeUnit.MILLISECONDS));
                            }
                            this.dlK.aBt().e(com.iqoption.core.h.i.Yo().b(new AnonymousClass2(this), com.iqoption.core.ext.c.aT(this.dlK.aAh()) + 1, TimeUnit.MILLISECONDS));
                        }
                    }
                    this.dlK.awG();
                }
            }
        }

        public b(LiveData<List<f>> liveData) {
            h.e(liveData, "insights");
            io.reactivex.disposables.a aVar = this.dlJ;
            com.iqoption.quiz.api.b bVar = this.dli;
            h.d(bVar, "quizApi");
            aVar.e(bVar.aAd().cQ(1).d(com.iqoption.core.h.i.Yo()).c(com.iqoption.core.h.i.Yp()).a((e) new AnonymousClass1(this), (e) AnonymousClass2.dlL));
            a(liveData, new AnonymousClass3(this));
        }

        public final long aAg() {
            return this.dik;
        }

        public final void bR(long j) {
            this.dik = j;
        }

        public final long aAh() {
            return this.dil;
        }

        public final void bS(long j) {
            this.dil = j;
        }

        public final void eL(boolean z) {
            this.dlI = z;
        }

        public final io.reactivex.disposables.a aBt() {
            return this.bco;
        }

        public final void onCleared() {
            this.bco.clear();
            this.dlJ.clear();
        }

        private final void awG() {
            boolean z = (this.dlI || !com.iqoption.core.ext.c.aS(this.dik) || com.iqoption.core.ext.c.aS(this.dil)) ? false : true;
            setValue(Boolean.valueOf(z));
        }
    }

    public final LiveData<List<f>> aBr() {
        d dVar = this.dlF;
        j jVar = apP[0];
        return (LiveData) dVar.getValue();
    }

    public final LiveData<Boolean> aBs() {
        d dVar = this.dlG;
        j jVar = apP[1];
        return (LiveData) dVar.getValue();
    }

    protected void onCleared() {
        LiveData aBs = aBs();
        if (!(aBs instanceof b)) {
            aBs = null;
        }
        b bVar = (b) aBs;
        if (bVar != null) {
            bVar.onCleared();
        }
        super.onCleared();
    }

    private final io.reactivex.e<List<f>> ba(List<com.iqoption.quiz.api.response.b> list) {
        Iterable<com.iqoption.quiz.api.response.b> iterable = list;
        Collection arrayList = new ArrayList(n.e(iterable, 10));
        for (com.iqoption.quiz.api.response.b bVar : iterable) {
            InstrumentType fromServerValue = InstrumentType.Companion.fromServerValue(bVar.getOptionType());
            if (fromServerValue == InstrumentType.UNKNOWN) {
                String str = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("unknown instrument ");
                stringBuilder.append(bVar);
                stringBuilder.append(".optionType");
                com.iqoption.core.i.e(str, stringBuilder.toString());
            }
            arrayList.add(fromServerValue);
        }
        io.reactivex.e<List<f>> d = com.iqoption.asset.mediators.b.apW.a(new com.iqoption.asset.mediators.d(u.W(u.Y((List) arrayList)), null, null, null, null, 28, null)).d((f) new c(this, list));
        h.d(d, "AssetStreamMediator.obse…htItems\n                }");
        return d;
    }

    private final e a(com.iqoption.asset.mediators.a aVar, com.iqoption.quiz.api.response.b bVar) {
        String str;
        String format;
        double doubleValue;
        int i;
        com.iqoption.core.microservices.tradingengine.response.active.a Jg = aVar.Jg();
        com.iqoption.core.microservices.f.a.a.a Jh = aVar.Jh();
        Double h = com.iqoption.core.microservices.f.a.a.a.aYn.h(Jh.WZ());
        Double h2 = com.iqoption.core.microservices.f.a.a.a.aYn.h(Jh.WY());
        int activeId = Jg.getActiveId();
        InstrumentType instrumentType = Jg.getInstrumentType();
        long aAg = bVar.aAg();
        long aAh = bVar.aAh();
        String description = bVar.getDescription();
        String s = s(Jg);
        if (s == null) {
            s = "";
        }
        String str2 = s;
        s = E(Jg);
        if (s == null) {
            s = "";
        }
        String str3 = s;
        if (h == null) {
            str = "";
        } else {
            kotlin.jvm.internal.m mVar = kotlin.jvm.internal.m.euz;
            Locale locale = Locale.US;
            h.d(locale, "Locale.US");
            Object[] objArr = new Object[]{h};
            format = String.format(locale, "$%.2f", Arrays.copyOf(objArr, objArr.length));
            h.d(format, "java.lang.String.format(locale, format, *args)");
            str = format;
        }
        int i2 = activeId;
        format = (h2 == null || h.a(h2, 0.0d)) ? "" : p.d(h2.doubleValue(), 2);
        String str4 = format;
        if (h2 != null) {
            doubleValue = h2.doubleValue();
            i = 0;
        } else {
            i = 0;
            doubleValue = 0.0d;
        }
        return new e(i2, instrumentType, aAg, aAh, description, str2, str3, str, str4, doubleValue < ((double) i), Jg.getImage());
    }

    private final String s(com.iqoption.core.microservices.tradingengine.response.active.a aVar) {
        return m.ayY().azo().b(aVar);
    }

    private final String E(com.iqoption.core.microservices.tradingengine.response.active.a aVar) {
        return m.ayY().azo().c(aVar);
    }
}
