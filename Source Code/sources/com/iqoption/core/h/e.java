package com.iqoption.core.h;

import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u0016*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\u0016B+\b\u0016\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB-\b\u0016\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\fB\u001f\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u000fJ\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016J\u0018\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u0004J\u0018\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u0004R\u0016\u0010\u0010\u001a\n \u0011*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, aXE = {"Lcom/iqoption/core/rx/LiveStreamSupplierHelper;", "Result", "Lcom/iqoption/core/rx/ILiveStreamSupplier;", "stream", "Lio/reactivex/Flowable;", "disposeDelay", "", "tag", "", "(Lio/reactivex/Flowable;JLjava/lang/String;)V", "initial", "updates", "(Lio/reactivex/Flowable;Lio/reactivex/Flowable;J)V", "supplier", "Lcom/iqoption/core/rx/LiveStreamSupplier;", "(Lcom/iqoption/core/rx/LiveStreamSupplier;Ljava/lang/String;)V", "logTag", "kotlin.jvm.PlatformType", "get", "setResetCacheStream", "resubscribeStream", "setResubscribeStream", "Companion", "core_release"})
/* compiled from: LiveStreamSupplierHelper.kt */
public final class e<Result> {
    private static final String TAG = "e";
    public static final a baw = new a();
    private final String bak;
    private final d<Result> bav;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, aXE = {"Lcom/iqoption/core/rx/LiveStreamSupplierHelper$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "core_release"})
    /* compiled from: LiveStreamSupplierHelper.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final String Ll() {
            return e.TAG;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "", "Result", "it", "", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: LiveStreamSupplierHelper.kt */
    static final class b<T> implements io.reactivex.c.e<Object> {
        final /* synthetic */ e bax;

        b(e eVar) {
            this.bax = eVar;
        }

        public final void accept(Object obj) {
            String Ll = e.baw.Ll();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("resubscribe ");
            stringBuilder.append(this.bax.bak);
            com.iqoption.core.i.d(Ll, stringBuilder.toString());
            this.bax.bav.Hq();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "", "Result", "it", "", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: LiveStreamSupplierHelper.kt */
    static final class c<T> implements io.reactivex.c.e<Throwable> {
        public static final c bay = new c();

        c() {
        }

        /* renamed from: o */
        public final void accept(Throwable th) {
        }
    }

    public e(d<Result> dVar, String str) {
        String Ll;
        h.e(dVar, "supplier");
        this.bav = dVar;
        if (str == null) {
            Ll = d.bat.Ll();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(d.bat.Ll());
            stringBuilder.append(':');
            stringBuilder.append(str);
            Ll = stringBuilder.toString();
        }
        this.bak = Ll;
    }

    static {
        h.d(e.class.getSimpleName(), "LiveStreamSupplierHelper::class.java.simpleName");
    }

    public e(io.reactivex.e<Result> eVar, long j, String str) {
        h.e(eVar, "stream");
        this(new d(eVar, j, null, 4, null), str);
    }

    public /* synthetic */ e(io.reactivex.e eVar, long j, String str, int i, f fVar) {
        if ((i & 2) != 0) {
            j = 0;
        }
        if ((i & 4) != 0) {
            str = (String) null;
        }
        this(eVar, j, str);
    }

    public final e<Result> c(io.reactivex.e<?> eVar) {
        h.e(eVar, "resubscribeStream");
        eVar.a((io.reactivex.c.e) new b(this), (io.reactivex.c.e) c.bay);
        return this;
    }

    public io.reactivex.e<Result> Yg() {
        return this.bav.Yg();
    }
}
