package com.iqoption.chat.repository;

import com.google.common.util.concurrent.s;
import com.iqoption.microservice.chat.f;
import com.iqoption.microservice.chat.l;
import com.iqoption.microservice.chat.n;
import com.iqoption.util.ag;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003\u001c\u001d\u001eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bJ\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nJ\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u0004J\u0012\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00140\u0010J\u001c\u0010\u0015\u001a\u00020\f2\u0012\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00140\u0017H\u0016J\u000e\u0010\u0018\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bJ\u000e\u0010\u0019\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nJ\u000e\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u0004R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, aXE = {"Lcom/iqoption/chat/repository/RoomRepository;", "Lcom/iqoption/microservice/chat/ChatEventHandler$RoomListener;", "()V", "TAG", "", "kotlin.jvm.PlatformType", "lastSeenMessageListeners", "", "Lcom/iqoption/chat/repository/RoomRepository$LastSeenMessageListener;", "roomListeners", "Lcom/iqoption/chat/repository/RoomRepository$RoomListener;", "addLastSeenMessageListener", "", "listener", "addRoomListener", "getRoom", "Lcom/google/common/util/concurrent/ListenableFuture;", "Lcom/iqoption/microservice/chat/ChatRoom;", "id", "getRooms", "", "onChatRoomGenerated", "event", "Lcom/iqoption/microservice/chat/ChatEvent;", "removeLastSeenMessageListener", "removeRoomListener", "setRoomRead", "roomId", "Cache", "LastSeenMessageListener", "RoomListener", "IqOption-5.5.1_optionXRelease"})
/* compiled from: RoomRepository.kt */
public final class c implements com.iqoption.microservice.chat.d.e {
    private static final String TAG = "c";
    public static final c aJA = new c();
    private static final Set<c> aJy = new LinkedHashSet();
    private static final Set<b> aJz = new LinkedHashSet();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R(\u0010\u0003\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, aXE = {"Lcom/iqoption/chat/repository/RoomRepository$Cache;", "", "()V", "all", "Lcom/google/common/util/concurrent/ListenableFuture;", "", "Lcom/iqoption/microservice/chat/ChatRoom;", "getAll", "()Lcom/google/common/util/concurrent/ListenableFuture;", "setAll", "(Lcom/google/common/util/concurrent/ListenableFuture;)V", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: RoomRepository.kt */
    public static final class a {
        private static s<List<n>> aJB;
        public static final a aJC = new a();

        private a() {
        }

        public final s<List<n>> Qr() {
            return aJB;
        }

        public final void f(s<List<n>> sVar) {
            aJB = sVar;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, aXE = {"Lcom/iqoption/chat/repository/RoomRepository$LastSeenMessageListener;", "", "onLastSeenMessageChanged", "", "roomId", "", "messageId", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: RoomRepository.kt */
    public interface b {
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¨\u0006\u0007"}, aXE = {"Lcom/iqoption/chat/repository/RoomRepository$RoomListener;", "", "onRoomEvent", "", "chatRooms", "", "Lcom/iqoption/microservice/chat/ChatRoom;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: RoomRepository.kt */
    public interface c {
        void S(List<n> list);
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
    /* compiled from: RoomRepository.kt */
    static final class e implements Runnable {
        public static final e aJE = new e();

        e() {
        }

        public final void run() {
            a.aJC.f((s) null);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "Lcom/iqoption/microservice/chat/ChatRoom;", "it", "Lcom/iqoption/microservice/chat/ChatListResponse;", "apply"})
    /* compiled from: RoomRepository.kt */
    static final class d<F, T> implements com.google.common.base.d<I, O> {
        public static final d aJD = new d();

        d() {
        }

        /* renamed from: a */
        public final List<n> apply(f<n> fVar) {
            return fVar != null ? (List) fVar.getData() : null;
        }
    }

    private c() {
    }

    public void c(com.iqoption.microservice.chat.c<? extends List<n>> cVar) {
        h.e(cVar, "event");
        for (c S : aJy) {
            S.S((List) cVar.getData());
        }
    }

    public final void a(c cVar) {
        h.e(cVar, "listener");
        aJy.add(cVar);
    }

    public final void b(c cVar) {
        h.e(cVar, "listener");
        aJy.remove(cVar);
    }

    public final void a(b bVar) {
        h.e(bVar, "listener");
        aJz.add(bVar);
    }

    public final void b(b bVar) {
        h.e(bVar, "listener");
        aJz.remove(bVar);
    }

    public final s<List<n>> Qq() {
        s<List<n>> Qr = a.aJC.Qr();
        if (Qr != null) {
            return Qr;
        }
        s a = ag.a(l.cQj.arH(), (com.google.common.base.d) d.aJD);
        a.aJC.f(a);
        ag.a(a, (Runnable) e.aJE);
        h.d(a, "FutureUtils.transform(Ch…e.all = null })\n        }");
        return a;
    }

    public final s<n> fN(String str) {
        s<n> a;
        h.e(str, "id");
        kotlin.jvm.a.b roomRepository$getRoom$transformation$1 = new RoomRepository$getRoom$transformation$1(str);
        s Qr = a.aJC.Qr();
        if (Qr != null) {
            a = ag.a(Qr, (com.google.common.base.d) new e(roomRepository$getRoom$transformation$1));
            if (a != null) {
                return a;
            }
        }
        a = ag.a(Qq(), (com.google.common.base.d) new d(roomRepository$getRoom$transformation$1));
        h.d(a, "FutureUtils.transform(getRooms(), transformation)");
        return a;
    }

    public final void fO(String str) {
        h.e(str, "roomId");
        l.cQj.ih(str);
    }
}
