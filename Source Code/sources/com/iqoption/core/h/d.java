package com.iqoption.core.h;

import io.reactivex.BackpressureStrategy;
import java.util.concurrent.TimeUnit;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\b\u0016\u0018\u0000 )*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001)B+\b\u0016\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB9\b\u0016\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\fB\u001d\b\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\rJ\u0016\u0010\u001f\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00018\u00008\u00000\u0013H\u0002J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016J\b\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\"H\u0002J\u0018\u0010$\u001a\u00020\"2\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004J\u0006\u0010&\u001a\u00020\"J\b\u0010'\u001a\u00020\"H\u0002J\b\u0010(\u001a\u00020\"H\u0002R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \u0011*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R,\u0010\u0012\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00018\u00008\u00000\u00138\u0004@\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, aXE = {"Lcom/iqoption/core/rx/LiveStreamSupplier;", "Result", "Lcom/iqoption/core/rx/ILiveStreamSupplier;", "stream", "Lio/reactivex/Flowable;", "disposeDelay", "", "tag", "", "(Lio/reactivex/Flowable;JLjava/lang/String;)V", "initial", "updates", "(Lio/reactivex/Flowable;Lio/reactivex/Flowable;JLjava/lang/String;)V", "(JLjava/lang/String;)V", "cancelStreamDisposable", "Lio/reactivex/disposables/Disposable;", "logTag", "kotlin.jvm.PlatformType", "processor", "Lio/reactivex/subjects/Subject;", "getProcessor", "()Lio/reactivex/subjects/Subject;", "setProcessor", "(Lio/reactivex/subjects/Subject;)V", "getStream", "()Lio/reactivex/Flowable;", "setStream", "(Lio/reactivex/Flowable;)V", "streamDisposable", "subscribeCount", "", "createProcessor", "get", "performSubscribe", "", "performUnsubscribe", "resetCache", "newStream", "resubscribe", "scheduleDisposeStream", "subscribeStream", "Companion", "core_release"})
/* compiled from: LiveStreamSupplier.kt */
public class d<Result> {
    private static final String TAG = "d";
    public static final a bat = new a();
    private final String bak;
    protected io.reactivex.e<Result> bal;
    private volatile io.reactivex.disposables.b ban;
    private volatile io.reactivex.disposables.b bao;
    private volatile io.reactivex.subjects.c<Result> bap;
    private int baq;
    private final long bas;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, aXE = {"Lcom/iqoption/core/rx/LiveStreamSupplier$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "core_release"})
    /* compiled from: LiveStreamSupplier.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final String Ll() {
            return d.TAG;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, aXE = {"<anonymous>", "", "Result", "run"})
    /* compiled from: LiveStreamSupplier.kt */
    static final class d implements Runnable {
        final /* synthetic */ d bau;

        d(d dVar) {
            this.bau = dVar;
        }

        public final void run() {
            synchronized (this.bau) {
                io.reactivex.disposables.b e = this.bau.ban;
                Object obj = (e == null || e.isDisposed()) ? 1 : null;
                if (obj != null) {
                    com.iqoption.core.i.d(this.bau.bak, "Stream is null or has been disposed already");
                    return;
                }
                com.iqoption.core.i.d(this.bau.bak, "Disposing stream");
                e = this.bau.ban;
                if (e != null) {
                    e.dispose();
                }
                this.bau.ban = (io.reactivex.disposables.b) null;
                l lVar = l.etX;
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "", "Result", "it", "Lorg/reactivestreams/Subscription;", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: LiveStreamSupplier.kt */
    static final class b<T> implements io.reactivex.c.e<org.a.d> {
        final /* synthetic */ d bau;

        b(d dVar) {
            this.bau = dVar;
        }

        public final void accept(org.a.d dVar) {
            this.bau.Yh();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, aXE = {"<anonymous>", "", "Result", "run"})
    /* compiled from: LiveStreamSupplier.kt */
    static final class c implements io.reactivex.c.a {
        final /* synthetic */ d bau;

        c(d dVar) {
            this.bau = dVar;
        }

        public final void run() {
            this.bau.Yk();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, aXE = {"<anonymous>", "", "Result", "it", "kotlin.jvm.PlatformType", "accept", "(Ljava/lang/Object;)V"})
    /* compiled from: LiveStreamSupplier.kt */
    static final class e<T> implements io.reactivex.c.e<Result> {
        final /* synthetic */ d bau;

        e(d dVar) {
            this.bau = dVar;
        }

        public final void accept(Result result) {
            com.iqoption.core.f.Dp().DJ();
            this.bau.Ye().e(result);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "", "Result", "it", "", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: LiveStreamSupplier.kt */
    static final class f<T> implements io.reactivex.c.e<Throwable> {
        final /* synthetic */ d bau;

        f(d dVar) {
            this.bau = dVar;
        }

        /* renamed from: o */
        public final void accept(Throwable th) {
            com.iqoption.core.i.w(this.bau.bak, th.getMessage(), th);
            this.bau.Ye().onError(th);
            com.iqoption.core.i.d(this.bau.bak, "Recreating processor");
            this.bau.a(this.bau.Yf());
        }
    }

    protected d() {
        this(0, null, 3, null);
    }

    protected d(long j, String str) {
        String str2;
        this.bas = j;
        if (str == null) {
            str2 = TAG;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(TAG);
            stringBuilder.append(':');
            stringBuilder.append(str);
            str2 = stringBuilder.toString();
        }
        this.bak = str2;
        this.bap = Yf();
    }

    public d(io.reactivex.e<Result> eVar, long j, String str) {
        h.e(eVar, "stream");
        this(j, str);
        this.bal = eVar;
    }

    public /* synthetic */ d(io.reactivex.e eVar, long j, String str, int i, f fVar) {
        if ((i & 2) != 0) {
            j = 0;
        }
        if ((i & 4) != 0) {
            str = (String) null;
        }
        this(eVar, j, str);
    }

    public /* synthetic */ d(io.reactivex.e eVar, io.reactivex.e eVar2, long j, String str, int i, f fVar) {
        if ((i & 4) != 0) {
            j = 0;
        }
        long j2 = j;
        if ((i & 8) != 0) {
            str = (String) null;
        }
        this(eVar, eVar2, j2, str);
    }

    public d(io.reactivex.e<Result> eVar, io.reactivex.e<Result> eVar2, long j, String str) {
        h.e(eVar, "initial");
        h.e(eVar2, "updates");
        io.reactivex.e c = eVar.c((org.a.b) eVar2);
        h.d(c, "initial.concatWith(updates)");
        this(c, j, str);
    }

    protected final void a(io.reactivex.e<Result> eVar) {
        h.e(eVar, "<set-?>");
        this.bal = eVar;
    }

    protected final io.reactivex.subjects.c<Result> Ye() {
        return this.bap;
    }

    protected final void a(io.reactivex.subjects.c<Result> cVar) {
        h.e(cVar, "<set-?>");
        this.bap = cVar;
    }

    public static /* synthetic */ void a(d dVar, io.reactivex.e eVar, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resetCache");
        }
        if ((i & 1) != 0) {
            eVar = (io.reactivex.e) null;
        }
        dVar.b(eVar);
    }

    public final synchronized void b(io.reactivex.e<Result> eVar) {
        if (!(this.bap.aXx() || this.bap.aXy())) {
            this.bap.onComplete();
        }
        this.bap = Yf();
        if (eVar != null) {
            com.iqoption.core.i.d(this.bak, "Resetting stream");
            this.bal = eVar;
            Hq();
        }
    }

    public final synchronized void Hq() {
        io.reactivex.disposables.b bVar = this.ban;
        if (bVar != null) {
            bVar.dispose();
        }
        if (this.baq > 0) {
            com.iqoption.core.i.d(this.bak, "Resubscribing to new stream");
            Yi();
        }
    }

    private final io.reactivex.subjects.c<Result> Yf() {
        return io.reactivex.subjects.a.aXw().aXB();
    }

    public synchronized io.reactivex.e<Result> Yg() {
        io.reactivex.e<Result> d;
        com.iqoption.core.i.d(TAG, "Create new stream");
        d = this.bap.a(BackpressureStrategy.LATEST).c(i.Yo()).b((io.reactivex.c.e) new b(this)).d((io.reactivex.c.a) new c(this));
        h.d(d, "processor\n              … { performUnsubscribe() }");
        return d;
    }

    private final synchronized void Yh() {
        int i = 1;
        this.baq++;
        int i2 = this.baq;
        String str = this.bak;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Incrementing subscriber's counter: ");
        stringBuilder.append(this.baq);
        com.iqoption.core.i.d(str, stringBuilder.toString());
        if (this.baq == 1) {
            io.reactivex.disposables.b bVar = this.bao;
            Object obj = (bVar == null || bVar.isDisposed()) ? null : 1;
            if (obj != null) {
                com.iqoption.core.i.d(this.bak, "Disposing cancelling disposable");
                bVar = this.bao;
                if (bVar != null) {
                    bVar.dispose();
                }
                this.bao = (io.reactivex.disposables.b) null;
            }
            bVar = this.ban;
            if (!(bVar == null || bVar.isDisposed())) {
                i = 0;
            }
            if (i != 0) {
                Yi();
            }
        }
    }

    private final void Yi() {
        com.iqoption.core.i.d(this.bak, "Subscribing");
        io.reactivex.e eVar = this.bal;
        if (eVar == null) {
            h.lS("stream");
        }
        this.ban = eVar.d(i.Yo()).a((io.reactivex.c.e) new e(this), (io.reactivex.c.e) new f(this));
    }

    private final synchronized void Yj() {
        this.bao = i.Yo().b(new d(this), this.bas, TimeUnit.MILLISECONDS);
    }

    private final synchronized void Yk() {
        this.baq--;
        int i = this.baq;
        String str = this.bak;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Decrementing subscriber's counter: ");
        stringBuilder.append(this.baq);
        com.iqoption.core.i.d(str, stringBuilder.toString());
        if (this.baq == 0) {
            Yj();
        }
    }
}
