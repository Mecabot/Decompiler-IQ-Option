package com.iqoption.verify;

import android.content.Context;
import com.google.common.util.concurrent.s;
import com.google.gson.Gson;
import com.iqoption.app.af;
import com.iqoption.util.ah;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bJ\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, aXE = {"Lcom/iqoption/verify/VerifyLocalStatusesRepository;", "", "preferences", "Lcom/iqoption/app/Preferences;", "gson", "Lcom/google/gson/Gson;", "(Lcom/iqoption/app/Preferences;Lcom/google/gson/Gson;)V", "getVerifyStatuses", "Lcom/google/common/util/concurrent/ListenableFuture;", "", "Lcom/iqoption/verify/VerifyStatus;", "setVerifyStatuses", "", "statuses", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: VerifyLocalStatusesRepository.kt */
public final class b {
    public static final a dxt = new a();
    private final af dqZ;
    private final Gson gson;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, aXE = {"Lcom/iqoption/verify/VerifyLocalStatusesRepository$Companion;", "", "()V", "newInstance", "Lcom/iqoption/verify/VerifyLocalStatusesRepository;", "context", "Landroid/content/Context;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: VerifyLocalStatusesRepository.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final b bU(Context context) {
            h.e(context, "context");
            af aR = af.aR(context);
            h.d(aR, "preferences");
            Gson aGg = ah.aGg();
            h.d(aGg, "Gsons.app()");
            return new b(aR, aGg, null);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "Lcom/iqoption/verify/VerifyStatus;", "kotlin.jvm.PlatformType", "call"})
    /* compiled from: VerifyLocalStatusesRepository.kt */
    static final class b<V> implements Callable<List<? extends d>> {
        final /* synthetic */ b dxu;

        b(b bVar) {
            this.dxu = bVar;
        }

        /* renamed from: aFH */
        public final List<d> call() {
            String Fo = this.dxu.dqZ.Fo();
            if (Fo != null) {
                return (List) this.dxu.gson.fromJson(Fo, c.dxw);
            }
            return m.emptyList();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "call"})
    /* compiled from: VerifyLocalStatusesRepository.kt */
    static final class c<V> implements Callable<l> {
        final /* synthetic */ b dxu;
        final /* synthetic */ List dxv;

        c(b bVar, List list) {
            this.dxu = bVar;
            this.dxv = list;
        }

        public /* synthetic */ Object call() {
            SW();
            return l.etX;
        }

        public final void SW() {
            this.dxu.dqZ.eJ(this.dxu.gson.toJson(this.dxv));
        }
    }

    private b(af afVar, Gson gson) {
        this.dqZ = afVar;
        this.gson = gson;
    }

    public /* synthetic */ b(af afVar, Gson gson, f fVar) {
        this(afVar, gson);
    }

    public final s<l> bt(List<d> list) {
        h.e(list, "statuses");
        Future submit = com.iqoption.core.d.a.aSc.submit(new c(this, list));
        h.d(submit, "Schedulers.io.submit<Uni…oJson(statuses)\n        }");
        return (s) submit;
    }

    public final s<List<d>> aGM() {
        Future submit = com.iqoption.core.d.a.aSc.submit(new b(this));
        h.d(submit, "Schedulers.io.submit<Lis…ATUS_LIST_TYPE)\n        }");
        return (s) submit;
    }
}
