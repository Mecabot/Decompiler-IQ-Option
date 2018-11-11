package com.iqoption.chat.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import com.google.common.base.n;
import com.google.common.util.concurrent.s;
import com.iqoption.microservice.chat.l;
import com.iqoption.microservice.chat.o;
import com.iqoption.util.ag;
import com.iqoption.util.ag.e;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\u0016\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0013H\u0016R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, aXE = {"Lcom/iqoption/chat/repository/StateRepository;", "Lcom/iqoption/microservice/chat/ChatEventHandler$StateListener;", "()V", "TAG", "", "kotlin.jvm.PlatformType", "loadTask", "Lcom/google/common/util/concurrent/ListenableFuture;", "Lcom/iqoption/microservice/chat/ChatState;", "state", "Landroid/arch/lifecycle/LiveData;", "getState", "()Landroid/arch/lifecycle/LiveData;", "stateData", "Landroid/arch/lifecycle/MutableLiveData;", "loadState", "onChatStateUpdated", "", "event", "Lcom/iqoption/microservice/chat/ChatEvent;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: StateRepository.kt */
public final class f implements com.iqoption.microservice.chat.d.f {
    private static final String TAG = "f";
    private static volatile s<o> aJF;
    public static final f aJG = new f();
    private static final MutableLiveData<o> azM;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
    /* compiled from: StateRepository.kt */
    static final class d implements Runnable {
        public static final d aJL = new d();

        d() {
        }

        public final void run() {
            f.aJF = (s) null;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "Lcom/google/common/util/concurrent/ListenableFuture;", "Lcom/iqoption/microservice/chat/ChatState;", "kotlin.jvm.PlatformType", "get"})
    /* compiled from: StateRepository.kt */
    static final class a<T> implements n<s<V>> {
        public static final a aJH = new a();

        a() {
        }

        /* renamed from: Qu */
        public final s<o> get() {
            return ag.a(l.cQj.arI(), (com.google.common.base.d) AnonymousClass1.aJI);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/microservice/chat/ChatState;", "call"})
    /* compiled from: StateRepository.kt */
    static final class b<T> implements e<V> {
        public static final b aJJ = new b();

        b() {
        }

        /* renamed from: c */
        public final void aU(o oVar) {
            h.e(oVar, "it");
            f.azM.postValue(oVar);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "", "call"})
    /* compiled from: StateRepository.kt */
    static final class c implements com.iqoption.util.ag.a {
        public static final c aJK = new c();

        c() {
        }

        public final void n(Throwable th) {
            h.e(th, "it");
            com.iqoption.core.i.w(f.TAG, th.getMessage(), th);
        }
    }

    static {
        MutableLiveData mutableLiveData = new MutableLiveData();
        aJG.Qt();
        azM = mutableLiveData;
    }

    private f() {
    }

    public void d(com.iqoption.microservice.chat.c<o> cVar) {
        h.e(cVar, "event");
        azM.postValue(cVar.getData());
    }

    public final LiveData<o> Qs() {
        MutableLiveData mutableLiveData = azM;
        aJG.Qt();
        return mutableLiveData;
    }

    private final s<o> Qt() {
        s<o> sVar = aJF;
        if (sVar != null) {
            return sVar;
        }
        s a = ag.a((n) a.aJH, TAG);
        ag.b(a, b.aJJ, c.aJK);
        ag.a(a, (Runnable) d.aJL);
        h.d(a, "FutureUtils.retryFuture(…          }\n            }");
        return a;
    }
}
