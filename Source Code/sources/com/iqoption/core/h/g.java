package com.iqoption.core.h;

import com.google.common.util.concurrent.s;
import io.reactivex.c.b;
import io.reactivex.c.e;
import io.reactivex.o;
import java.util.concurrent.Executor;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a¢\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\u0005\"\u0004\b\u0003\u0010\u0006\"\u0004\b\u0004\u0010\u0007\"\u0004\b\u0005\u0010\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00012*\u0010\r\u001a&\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u00020\u000e\u001a\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\u0005\"\u0004\b\u0003\u0010\u0006\"\u0004\b\u0004\u0010\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00012$\u0010\r\u001a \u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u00020\u000f\u001an\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\u0005\"\u0004\b\u0003\u0010\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00012\u001e\u0010\r\u001a\u001a\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00020\u0010\u001aT\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00012\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u0011\u001aD\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00122\u0012\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u00142\u0016\u0010\r\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0016\u0012\u0004\u0012\u0002H\u00120\u0015\u001a\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0018\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0019¨\u0006\u001a"}, aXE = {"combineFlowables", "Lio/reactivex/Flowable;", "T", "T1", "T2", "T3", "T4", "T5", "s1", "s2", "s3", "s4", "s5", "combiner", "Lio/reactivex/functions/Function5;", "Lio/reactivex/functions/Function4;", "Lio/reactivex/functions/Function3;", "Lio/reactivex/functions/BiFunction;", "R", "list", "", "Lio/reactivex/functions/Function;", "", "toGuavaFuture", "Lcom/google/common/util/concurrent/ListenableFuture;", "Lio/reactivex/Single;", "core_release"})
/* compiled from: RxCommon.kt */
public final class g {

    @i(aXC = {1, 1, 11}, aXD = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, aXE = {"com/iqoption/core/rx/RxCommonKt$toGuavaFuture$1", "Lcom/google/common/util/concurrent/AbstractFuture;", "disposable", "Lio/reactivex/disposables/Disposable;", "addListener", "", "listener", "Ljava/lang/Runnable;", "executor", "Ljava/util/concurrent/Executor;", "cancel", "", "mayInterruptIfRunning", "core_release"})
    /* compiled from: RxCommon.kt */
    public static final class a extends com.google.common.util.concurrent.b<T> {
        private io.reactivex.disposables.b baB;
        final /* synthetic */ o baC;

        @i(aXC = {1, 1, 11}, aXD = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, aXE = {"<anonymous>", "", "T", "value", "kotlin.jvm.PlatformType", "accept", "(Ljava/lang/Object;)V"})
        /* compiled from: RxCommon.kt */
        static final class a<T> implements e<T> {
            final /* synthetic */ a baD;

            a(a aVar) {
                this.baD = aVar;
            }

            public final void accept(T t) {
                this.baD.a(t);
            }
        }

        @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "", "T", "error", "", "kotlin.jvm.PlatformType", "accept"})
        /* compiled from: RxCommon.kt */
        static final class b<T> implements e<Throwable> {
            final /* synthetic */ a baD;

            b(a aVar) {
                this.baD = aVar;
            }

            /* renamed from: o */
            public final void accept(Throwable th) {
                this.baD.a(th);
            }
        }

        a(o oVar) {
            this.baC = oVar;
        }

        public void a(Runnable runnable, Executor executor) {
            h.e(runnable, "listener");
            h.e(executor, "executor");
            super.a(runnable, executor);
            this.baB = this.baC.h(i.Yo()).g(io.reactivex.e.a.a(executor)).a((e) new a(this), (e) new b(this));
        }

        public boolean cancel(boolean z) {
            io.reactivex.disposables.b bVar = this.baB;
            if (bVar != null) {
                bVar.dispose();
            }
            this.baB = (io.reactivex.disposables.b) null;
            return super.cancel(z);
        }
    }

    public static final <T1, T2, T> io.reactivex.e<T> a(io.reactivex.e<T1> eVar, io.reactivex.e<T2> eVar2, b<T1, T2, T> bVar) {
        h.e(eVar, "s1");
        h.e(eVar2, "s2");
        h.e(bVar, "combiner");
        io.reactivex.e<T> a = io.reactivex.e.a((org.a.b) eVar, (org.a.b) eVar2, (b) bVar);
        h.d(a, "Flowable.combineLatest<T… T2, T>(s1, s2, combiner)");
        return a;
    }

    public static final <T1, T2, T3, T> io.reactivex.e<T> a(io.reactivex.e<T1> eVar, io.reactivex.e<T2> eVar2, io.reactivex.e<T3> eVar3, io.reactivex.c.g<T1, T2, T3, T> gVar) {
        h.e(eVar, "s1");
        h.e(eVar2, "s2");
        h.e(eVar3, "s3");
        h.e(gVar, "combiner");
        io.reactivex.e<T> a = io.reactivex.e.a((org.a.b) eVar, (org.a.b) eVar2, (org.a.b) eVar3, (io.reactivex.c.g) gVar);
        h.d(a, "Flowable.combineLatest<T… T>(s1, s2, s3, combiner)");
        return a;
    }

    public static final <T1, T2, T3, T4, T> io.reactivex.e<T> a(io.reactivex.e<T1> eVar, io.reactivex.e<T2> eVar2, io.reactivex.e<T3> eVar3, io.reactivex.e<T4> eVar4, io.reactivex.c.h<T1, T2, T3, T4, T> hVar) {
        h.e(eVar, "s1");
        h.e(eVar2, "s2");
        h.e(eVar3, "s3");
        h.e(eVar4, "s4");
        h.e(hVar, "combiner");
        io.reactivex.e<T> a = io.reactivex.e.a(eVar, eVar2, eVar3, eVar4, hVar);
        h.d(a, "Flowable.combineLatest<T…s1, s2, s3, s4, combiner)");
        return a;
    }

    public static final <T1, T2, T3, T4, T5, T> io.reactivex.e<T> a(io.reactivex.e<T1> eVar, io.reactivex.e<T2> eVar2, io.reactivex.e<T3> eVar3, io.reactivex.e<T4> eVar4, io.reactivex.e<T5> eVar5, io.reactivex.c.i<T1, T2, T3, T4, T5, T> iVar) {
        h.e(eVar, "s1");
        h.e(eVar2, "s2");
        h.e(eVar3, "s3");
        h.e(eVar4, "s4");
        h.e(eVar5, "s5");
        h.e(iVar, "combiner");
        io.reactivex.e<T> a = io.reactivex.e.a(eVar, eVar2, eVar3, eVar4, eVar5, iVar);
        h.d(a, "Flowable.combineLatest<T…s2, s3, s4, s5, combiner)");
        return a;
    }

    public static final <T> s<T> a(o<T> oVar) {
        h.e(oVar, "$receiver");
        return new a(oVar);
    }
}
