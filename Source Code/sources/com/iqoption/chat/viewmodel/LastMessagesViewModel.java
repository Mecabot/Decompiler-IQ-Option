package com.iqoption.chat.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.SystemClock;
import com.google.common.util.concurrent.s;
import com.iqoption.microservice.chat.g;
import com.iqoption.microservice.chat.n;
import com.iqoption.util.ag;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.l;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0001)B\u0005¢\u0006\u0002\u0010\u0003J*\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00062\u0018\u0010\u0015\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0004\u0012\u00020\u00130\u0016H\u0002J\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u00182\u0006\u0010\u0014\u001a\u00020\u0006J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0014\u001a\u00020\u0006J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u0006H\u0002J\u000e\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u0006J\u001c\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u001f0\u001e2\u0006\u0010\u0014\u001a\u00020\u0006H\u0002J\b\u0010 \u001a\u00020\u0013H\u0014J\u0016\u0010!\u001a\u00020\u00132\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\f0\u001fH\u0016J\u001a\u0010#\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00062\b\u0010$\u001a\u0004\u0018\u00010\fH\u0002J\u0018\u0010%\u001a\u00020\u00132\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u001fJ\u0018\u0010(\u001a\u00020\u00132\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u001fR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\tX\u0004¢\u0006\u0002\n\u0000R \u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, aXE = {"Lcom/iqoption/chat/viewmodel/LastMessagesViewModel;", "Landroid/arch/lifecycle/ViewModel;", "Lcom/iqoption/chat/repository/MessageRepository$MessageListener;", "()V", "cacheTimeRegistry", "", "", "", "emptyRooms", "", "lastMessages", "Landroid/arch/lifecycle/MutableLiveData;", "Lcom/iqoption/microservice/chat/ChatMessage;", "loadingRegistry", "messagesToAdd", "", "messagesToClear", "messagesToSwap", "changeLastMessage", "", "roomId", "changeBlock", "Lkotlin/Function1;", "getLastMessage", "Landroid/arch/lifecycle/LiveData;", "getLastMessageImmediate", "isMessageExpired", "", "isMessageLoading", "loadLastMessage", "Lcom/google/common/util/concurrent/ListenableFuture;", "", "onCleared", "onMessageEvent", "messages", "postLastMessage", "message", "subscribeForChanges", "chatRooms", "Lcom/iqoption/microservice/chat/ChatRoom;", "unsubscribeForChanges", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: LastMessagesViewModel.kt */
public final class LastMessagesViewModel extends ViewModel implements com.iqoption.chat.repository.b.a {
    private static final String TAG = "LastMessagesViewModel";
    private static final long aKM = TimeUnit.SECONDS.toMillis(10);
    public static final a aKN = new a();
    private static final kotlin.d aKb = g.f(LastMessagesViewModel$Companion$instance$2.aKO);
    private final Map<String, MutableLiveData<g>> aKF = new LinkedHashMap();
    private final Map<String, Long> aKG = new LinkedHashMap();
    private final Set<String> aKH = new LinkedHashSet();
    private final Set<String> aKI = new LinkedHashSet();
    private final List<String> aKJ = new ArrayList();
    private final List<g> aKK = new ArrayList();
    private final List<g> aKL = new ArrayList();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0011\u001a\u00020\fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, aXE = {"Lcom/iqoption/chat/viewmodel/LastMessagesViewModel$Companion;", "", "()V", "CACHE_LIFE_TIME", "", "getCACHE_LIFE_TIME", "()J", "TAG", "", "getTAG", "()Ljava/lang/String;", "instance", "Lcom/iqoption/chat/viewmodel/LastMessagesViewModel;", "getInstance", "()Lcom/iqoption/chat/viewmodel/LastMessagesViewModel;", "instance$delegate", "Lkotlin/Lazy;", "get", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: LastMessagesViewModel.kt */
    public static final class a {
        static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "instance", "getInstance()Lcom/iqoption/chat/viewmodel/LastMessagesViewModel;"))};

        private final LastMessagesViewModel QX() {
            kotlin.d QF = LastMessagesViewModel.aKb;
            j jVar = apP[0];
            return (LastMessagesViewModel) QF.getValue();
        }

        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final LastMessagesViewModel QY() {
            return QX();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
    /* compiled from: LastMessagesViewModel.kt */
    static final class c implements Runnable {
        final /* synthetic */ LastMessagesViewModel aKP;
        final /* synthetic */ String aKQ;

        c(LastMessagesViewModel lastMessagesViewModel, String str) {
            this.aKP = lastMessagesViewModel;
            this.aKQ = str;
        }

        public final void run() {
            this.aKP.aKH.remove(this.aKQ);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "", "Lcom/iqoption/microservice/chat/ChatMessage;", "call", "com/iqoption/chat/viewmodel/LastMessagesViewModel$getLastMessage$2$1"})
    /* compiled from: LastMessagesViewModel.kt */
    static final class b<T> implements com.iqoption.util.ag.e<V> {
        final /* synthetic */ String aEY;
        final /* synthetic */ LastMessagesViewModel aKP;

        b(LastMessagesViewModel lastMessagesViewModel, String str) {
            this.aKP = lastMessagesViewModel;
            this.aEY = str;
        }

        /* renamed from: Y */
        public final void aU(List<g> list) {
            h.e(list, "it");
            this.aKP.a(this.aEY, (g) u.bV(list));
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "Lcom/iqoption/microservice/chat/ChatMessage;", "it", "apply"})
    /* compiled from: LastMessagesViewModel.kt */
    static final class d<F, T> implements com.google.common.base.d<I, O> {
        public static final d aKR = new d();

        d() {
        }

        /* renamed from: m */
        public final List<g> apply(List<g> list) {
            if (list == null) {
                return null;
            }
            Collection arrayList = new ArrayList();
            for (Object next : list) {
                if ((((g) next).aru() ^ 1) != 0) {
                    arrayList.add(next);
                }
            }
            return (List) arrayList;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "", "Lcom/iqoption/microservice/chat/ChatMessage;", "call"})
    /* compiled from: LastMessagesViewModel.kt */
    static final class e<T> implements com.iqoption.util.ag.e<V> {
        final /* synthetic */ MutableLiveData receiver$0;

        e(MutableLiveData mutableLiveData) {
            this.receiver$0 = mutableLiveData;
        }

        /* renamed from: Y */
        public final void aU(List<g> list) {
            h.e(list, "it");
            this.receiver$0.postValue(u.bV(list));
        }
    }

    public LastMessagesViewModel() {
        com.iqoption.chat.repository.b.aJu.a((com.iqoption.chat.repository.b.a) this);
    }

    static {
        h.d(LastMessagesViewModel.class.getSimpleName(), "LastMessagesViewModel::class.java.simpleName");
    }

    public void R(List<g> list) {
        MutableLiveData mutableLiveData;
        h.e(list, "messages");
        this.aKJ.clear();
        this.aKK.clear();
        this.aKL.clear();
        for (g gVar : list) {
            this.aKI.remove(gVar.Re());
            mutableLiveData = (MutableLiveData) this.aKF.get(gVar.Re());
            if (mutableLiveData != null) {
                g gVar2 = (g) mutableLiveData.getValue();
                if (gVar2 != null) {
                    if (h.E(gVar2.getId(), gVar.getId())) {
                        if (gVar.aru()) {
                            this.aKJ.add(gVar.Re());
                        } else {
                            this.aKK.add(gVar);
                        }
                    } else if (gVar2.getDate() < gVar.getDate()) {
                        this.aKL.add(gVar);
                    }
                } else if (!fT(gVar.Re())) {
                    this.aKL.add(gVar);
                }
            }
        }
        Collection arrayList = new ArrayList();
        Iterator it = this.aKJ.iterator();
        while (true) {
            Object obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            String str = (String) next;
            for (Object next2 : this.aKL) {
                if (h.E(((g) next2).Re(), str)) {
                    obj = next2;
                    break;
                }
            }
            if ((obj != null ? 1 : null) != null) {
                arrayList.add(next);
            }
        }
        List list2 = (List) arrayList;
        for (String str2 : this.aKJ) {
            for (Object next3 : this.aKL) {
                if (h.E(((g) next3).Re(), str2)) {
                    break;
                }
            }
            Object next32 = null;
            if (next32 == null) {
                mutableLiveData = (MutableLiveData) this.aKF.get(str2);
                if (mutableLiveData != null) {
                    ag.a(fU(str2), (com.iqoption.util.ag.e) new e(mutableLiveData));
                }
            }
        }
        for (g gVar3 : this.aKK) {
            a(gVar3.Re(), gVar3);
        }
        for (g gVar32 : this.aKL) {
            a(gVar32.Re(), gVar32);
        }
    }

    private final void c(String str, kotlin.jvm.a.b<? super MutableLiveData<g>, l> bVar) {
        MutableLiveData mutableLiveData = (MutableLiveData) this.aKF.get(str);
        if (mutableLiveData != null) {
            bVar.invoke(mutableLiveData);
            this.aKG.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
        }
    }

    private final void a(String str, g gVar) {
        c(str, new LastMessagesViewModel$postLastMessage$1(gVar));
    }

    protected void onCleared() {
        super.onCleared();
        com.iqoption.chat.repository.b.aJu.b((com.iqoption.chat.repository.b.a) this);
        a(this, null, 1, null);
    }

    public final g fQ(String str) {
        h.e(str, "roomId");
        MutableLiveData mutableLiveData = (MutableLiveData) this.aKF.get(str);
        return mutableLiveData != null ? (g) mutableLiveData.getValue() : null;
    }

    public final LiveData<g> fR(String str) {
        h.e(str, "roomId");
        MutableLiveData mutableLiveData = (MutableLiveData) this.aKF.get(str);
        if (mutableLiveData == null) {
            mutableLiveData = new MutableLiveData();
            this.aKF.put(str, mutableLiveData);
        }
        if (fS(str) && !fT(str)) {
            ag.a(fU(str), (com.iqoption.util.ag.e) new b(this, str));
        }
        return mutableLiveData;
    }

    private final boolean fS(String str) {
        Long l = (Long) this.aKG.get(str);
        boolean z = true;
        if (l != null) {
            if (SystemClock.elapsedRealtime() - l.longValue() <= aKM) {
                z = false;
            }
        }
        String str2 = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("last message for chat: ");
        stringBuilder.append(str);
        stringBuilder.append(' ');
        stringBuilder.append(z ? "is expired" : "is NOT expired");
        com.iqoption.core.i.d(str2, stringBuilder.toString());
        return z;
    }

    public final boolean fT(String str) {
        h.e(str, "roomId");
        boolean contains = this.aKH.contains(str);
        String str2 = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("last message for chat: ");
        stringBuilder.append(str);
        stringBuilder.append(' ');
        stringBuilder.append(contains ? "is being loaded" : "is NOT being loaded");
        com.iqoption.core.i.d(str2, stringBuilder.toString());
        return contains;
    }

    private final s<List<g>> fU(String str) {
        String str2 = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("load last message for chat: ");
        stringBuilder.append(str);
        com.iqoption.core.i.d(str2, stringBuilder.toString());
        s a = ag.a(com.iqoption.chat.repository.b.a(com.iqoption.chat.repository.b.aJu, str, 0, 3, 2, null), (com.google.common.base.d) d.aKR);
        this.aKH.add(str);
        ag.a(a, (Runnable) new c(this, str));
        h.d(a, "future");
        return a;
    }

    public final void W(List<n> list) {
        if (list != null) {
            Collection arrayList = new ArrayList();
            for (Object next : list) {
                if (((n) next).isPublic()) {
                    arrayList.add(next);
                }
            }
            Iterable<n> iterable = (List) arrayList;
            Collection arrayList2 = new ArrayList(n.e(iterable, 10));
            for (n id : iterable) {
                arrayList2.add(id.getId());
            }
            com.iqoption.microservice.chat.d.cPG.a((List) arrayList2, (com.iqoption.microservice.chat.d.c) com.iqoption.chat.repository.b.aJu);
        }
    }

    public static /* synthetic */ void a(LastMessagesViewModel lastMessagesViewModel, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = (List) null;
        }
        lastMessagesViewModel.X(list);
    }

    public final void X(List<n> list) {
        if (list != null) {
            Collection arrayList = new ArrayList();
            for (Object next : list) {
                if (((n) next).isPublic()) {
                    arrayList.add(next);
                }
            }
            Iterable<n> iterable = (List) arrayList;
            Collection arrayList2 = new ArrayList(n.e(iterable, 10));
            for (n id : iterable) {
                arrayList2.add(id.getId());
            }
            com.iqoption.microservice.chat.d.cPG.b((List) arrayList2, (com.iqoption.microservice.chat.d.c) com.iqoption.chat.repository.b.aJu);
        }
    }
}
