package com.iqoption.charttools;

import com.iqoption.core.h.d;
import io.reactivex.c.b;
import io.reactivex.e;
import io.reactivex.o;
import kotlin.i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "Lcom/iqoption/core/rx/LiveStreamSupplier;", "Lcom/iqoption/charttools/IndicatorsLibrary;", "kotlin.jvm.PlatformType", "invoke"})
/* compiled from: IndicatorsLibraryManager.kt */
final class IndicatorsLibraryManager$libraryStreamSupplier$2 extends Lambda implements kotlin.jvm.a.a<d<k>> {
    public static final IndicatorsLibraryManager$libraryStreamSupplier$2 asE = new IndicatorsLibraryManager$libraryStreamSupplier$2();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "Lcom/iqoption/charttools/MergedLibrary;", "remote", "Lcom/iqoption/charttools/RemoteLibrary;", "local", "Lcom/iqoption/charttools/LocalLibrary;", "apply"})
    /* compiled from: IndicatorsLibraryManager.kt */
    static final class a<T1, T2, R> implements b<p, m, k> {
        public static final a asO = new a();

        a() {
        }

        /* renamed from: a */
        public final n apply(p pVar, m mVar) {
            h.e(pVar, "remote");
            h.e(mVar, "local");
            return new n(pVar, mVar);
        }
    }

    IndicatorsLibraryManager$libraryStreamSupplier$2() {
        super(0);
    }

    /* renamed from: JJ */
    public final d<k> invoke() {
        AnonymousClass1 anonymousClass1 = AnonymousClass1.asF;
        AnonymousClass2 anonymousClass2 = AnonymousClass2.asI;
        e c = o.a(AnonymousClass3.a(AnonymousClass3.asK, 0, 1, null), AnonymousClass4.asN.invoke(), a.asO).aWk().c((org.a.b) e.aVV());
        h.d(c, "stream");
        return new d(c, l.asu, l.TAG);
    }
}
