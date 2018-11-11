package com.iqoption.core.h;

import io.reactivex.e;
import java.util.concurrent.TimeUnit;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00102\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0001:\u0001\u0010B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001a\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, aXE = {"Lcom/iqoption/core/rx/RepeatTimerFunction;", "Lio/reactivex/functions/Function;", "Lio/reactivex/Flowable;", "", "Lorg/reactivestreams/Publisher;", "delay", "", "unit", "Ljava/util/concurrent/TimeUnit;", "(JLjava/util/concurrent/TimeUnit;)V", "getDelay", "()J", "getUnit", "()Ljava/util/concurrent/TimeUnit;", "apply", "errors", "Companion", "core_release"})
/* compiled from: RepeatTimerFunction.kt */
public final class f implements io.reactivex.c.f<e<Object>, org.a.b<?>> {
    private static final String TAG = "f";
    public static final a baz = new a();
    private final long aPv;
    private final TimeUnit unit;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0002¨\u0006\u0007"}, aXE = {"Lcom/iqoption/core/rx/RepeatTimerFunction$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "TAG$annotations", "core_release"})
    /* compiled from: RepeatTimerFunction.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "Lio/reactivex/Flowable;", "", "kotlin.jvm.PlatformType", "it", "", "apply"})
    /* compiled from: RepeatTimerFunction.kt */
    static final class b<T, R> implements io.reactivex.c.f<T, org.a.b<? extends R>> {
        final /* synthetic */ f baA;

        b(f fVar) {
            this.baA = fVar;
        }

        /* renamed from: bk */
        public final e<Long> apply(Object obj) {
            h.e(obj, "it");
            return e.e(this.baA.Yl(), this.baA.Ym());
        }
    }

    public f(long j, TimeUnit timeUnit) {
        h.e(timeUnit, "unit");
        this.aPv = j;
        this.unit = timeUnit;
    }

    public final long Yl() {
        return this.aPv;
    }

    public final TimeUnit Ym() {
        return this.unit;
    }

    /* renamed from: d */
    public org.a.b<?> apply(e<Object> eVar) {
        h.e(eVar, "errors");
        e a = eVar.a((io.reactivex.c.f) new b(this));
        h.d(a, "errors.flatMap {\n       …er(delay, unit)\n        }");
        return a;
    }
}
