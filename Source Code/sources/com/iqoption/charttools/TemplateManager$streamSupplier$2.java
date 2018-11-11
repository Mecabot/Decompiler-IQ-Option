package com.iqoption.charttools;

import com.iqoption.core.h.d;
import com.iqoption.core.microservices.techinstruments.a.c;
import io.reactivex.c.f;
import io.reactivex.e;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "Lcom/iqoption/core/rx/LiveStreamSupplier;", "", "Lcom/iqoption/charttools/model/template/ChartTemplate;", "invoke"})
/* compiled from: TemplateManager.kt */
final class TemplateManager$streamSupplier$2 extends Lambda implements kotlin.jvm.a.a<d<List<? extends com.iqoption.charttools.model.a.a>>> {
    public static final TemplateManager$streamSupplier$2 atk = new TemplateManager$streamSupplier$2();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a>\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002 \u0004*\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, aXE = {"<anonymous>", "Lio/reactivex/Flowable;", "", "Lcom/iqoption/charttools/model/template/ChartTemplate;", "kotlin.jvm.PlatformType", "library", "Lcom/iqoption/charttools/IndicatorsLibrary;", "apply"})
    /* compiled from: TemplateManager.kt */
    static final class a<T, R> implements f<T, org.a.b<? extends R>> {
        public static final a atm = new a();

        @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "Lcom/iqoption/charttools/TemplateManager$TemplatesUpdate;", "it", "Lcom/iqoption/core/microservices/techinstruments/response/ModifiedTemplates;", "apply"})
        /* compiled from: TemplateManager.kt */
        static final class a<T, R> implements f<T, R> {
            final /* synthetic */ k atg;

            a(k kVar) {
                this.atg = kVar;
            }

            /* renamed from: a */
            public final com.iqoption.charttools.r.b apply(c cVar) {
                h.e(cVar, "it");
                AnonymousClass1 anonymousClass1 = AnonymousClass1.atl;
                k kVar = this.atg;
                h.d(kVar, "library");
                return new com.iqoption.charttools.r.b(null, null, null, new com.iqoption.charttools.r.a(anonymousClass1.B(kVar, cVar.Kw()), cVar.Kx()), 7, null);
            }
        }

        @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "Lcom/iqoption/charttools/TemplateManager$TemplatesUpdate;", "it", "Lcom/iqoption/charttools/TemplateEvent;", "apply"})
        /* compiled from: TemplateManager.kt */
        static final class b<T, R> implements f<T, R> {
            public static final b atp = new b();

            b() {
            }

            /* renamed from: a */
            public final com.iqoption.charttools.r.b apply(q qVar) {
                h.e(qVar, "it");
                return qVar.Ks();
            }
        }

        a() {
        }

        /* renamed from: d */
        public final e<List<com.iqoption.charttools.model.a.a>> apply(final k kVar) {
            h.e(kVar, "library");
            return com.iqoption.core.microservices.techinstruments.a.aXU.WN().n(new f<T, R>() {
                /* renamed from: K */
                public final com.iqoption.charttools.r.b apply(List<com.iqoption.core.microservices.techinstruments.a.e> list) {
                    h.e(list, "it");
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.atl;
                    k kVar = kVar;
                    h.d(kVar, "library");
                    return new com.iqoption.charttools.r.b(anonymousClass1.B(kVar, list), null, null, null, 14, null);
                }
            }).aWk().c((org.a.b) com.iqoption.core.microservices.techinstruments.a.aXU.WO().d((f) new a(kVar)).d((org.a.b) r.asX.Kt().d((f) b.atp))).a((io.reactivex.c.b) AnonymousClass2.atn).d((f) AnonymousClass3.ato);
        }
    }

    TemplateManager$streamSupplier$2() {
        super(0);
    }

    /* renamed from: JJ */
    public final d<List<com.iqoption.charttools.model.a.a>> invoke() {
        AnonymousClass1 anonymousClass1 = AnonymousClass1.atl;
        e m = l.asx.Km().m(a.atm);
        h.d(m, "stream");
        return new d(m, 10000, "Templates");
    }
}
