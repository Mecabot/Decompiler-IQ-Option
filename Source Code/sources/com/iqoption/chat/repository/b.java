package com.iqoption.chat.repository;

import com.google.common.util.concurrent.s;
import com.iqoption.microservice.chat.f;
import com.iqoption.microservice.chat.g;
import com.iqoption.microservice.chat.l;
import com.iqoption.util.ag;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\"B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eJ \u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J.\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u0006\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017J4\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u0017J\u001c\u0010\u001b\u001a\u00020\u00102\u0012\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u001dH\u0016J\u001c\u0010\u001e\u001a\u00020\u00102\u0012\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u001dH\u0016J\u0016\u0010\u001f\u001a\u00020\u00102\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u000e\u0010!\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eR\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0004¢\u0006\u0002\n\u0000R&\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, aXE = {"Lcom/iqoption/chat/repository/MessageRepository;", "Lcom/iqoption/microservice/chat/ChatEventHandler$MessagesListener;", "Lcom/iqoption/microservice/chat/ChatEventHandler$PublicMessagesListener;", "()V", "TAG", "", "kotlin.jvm.PlatformType", "cache", "", "Lcom/google/common/util/concurrent/ListenableFuture;", "", "Lcom/iqoption/microservice/chat/ChatMessage;", "messageListeners", "", "Lcom/iqoption/chat/repository/MessageRepository$MessageListener;", "addMessageListener", "", "listener", "createCacheKey", "roomId", "timestamp", "", "limit", "", "getMessages", "fromId", "toId", "onChatMessageGenerated", "event", "Lcom/iqoption/microservice/chat/ChatEvent;", "onChatMessagePublicGenerated", "onMessageEvent", "messages", "removeMessageListener", "MessageListener", "IqOption-5.5.1_optionXRelease"})
/* compiled from: MessageRepository.kt */
public final class b implements com.iqoption.microservice.chat.d.b, com.iqoption.microservice.chat.d.c {
    private static final String TAG = "b";
    private static final Set<a> aJs = new LinkedHashSet();
    private static final Map<String, s<List<g>>> aJt = new LinkedHashMap();
    public static final b aJu = new b();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¨\u0006\u0007"}, aXE = {"Lcom/iqoption/chat/repository/MessageRepository$MessageListener;", "", "onMessageEvent", "", "messages", "", "Lcom/iqoption/microservice/chat/ChatMessage;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: MessageRepository.kt */
    public interface a {
        void R(List<g> list);
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, aXE = {"<anonymous>", "", "run", "com/iqoption/chat/repository/MessageRepository$getMessages$2$1"})
    /* compiled from: MessageRepository.kt */
    static final class b implements Runnable {
        final /* synthetic */ String aJv;

        b(String str) {
            this.aJv = str;
        }

        public final void run() {
            b.aJt.remove(this.aJv);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "Lcom/iqoption/microservice/chat/ChatMessage;", "it", "Lcom/iqoption/microservice/chat/ChatListResponse;", "apply"})
    /* compiled from: MessageRepository.kt */
    static final class c<F, T> implements com.google.common.base.d<I, O> {
        public static final c aJw = new c();

        c() {
        }

        /* renamed from: a */
        public final List<g> apply(f<g> fVar) {
            return fVar != null ? (List) fVar.getData() : null;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "Lcom/iqoption/microservice/chat/ChatMessage;", "it", "Lcom/iqoption/microservice/chat/ChatListResponse;", "apply"})
    /* compiled from: MessageRepository.kt */
    static final class d<F, T> implements com.google.common.base.d<I, O> {
        public static final d aJx = new d();

        d() {
        }

        /* renamed from: a */
        public final List<g> apply(f<g> fVar) {
            return fVar != null ? (List) fVar.getData() : null;
        }
    }

    private b() {
    }

    public void a(com.iqoption.microservice.chat.c<? extends List<g>> cVar) {
        h.e(cVar, "event");
        R((List) cVar.getData());
    }

    public void b(com.iqoption.microservice.chat.c<? extends List<g>> cVar) {
        h.e(cVar, "event");
        R((List) cVar.getData());
    }

    private final void R(List<g> list) {
        for (a R : aJs) {
            R.R(list);
        }
    }

    public final void a(a aVar) {
        h.e(aVar, "listener");
        aJs.add(aVar);
    }

    public final void b(a aVar) {
        h.e(aVar, "listener");
        aJs.remove(aVar);
    }

    public static /* bridge */ /* synthetic */ s a(b bVar, String str, long j, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j = 0;
        }
        if ((i2 & 4) != 0) {
            i = 20;
        }
        return bVar.a(str, j, i);
    }

    public final s<List<g>> a(String str, long j, int i) {
        h.e(str, "roomId");
        String b = b(str, j, i);
        s<List<g>> sVar = (s) aJt.get(b);
        if (sVar != null) {
            com.iqoption.core.i.d(TAG, "Cached future is returned");
            return sVar;
        }
        s a = ag.a(l.cQj.c(str, j, i), (com.google.common.base.d) c.aJw);
        com.iqoption.core.i.d(TAG, "New future is returned");
        Map map = aJt;
        h.d(a, "this");
        map.put(b, a);
        ag.a(a, (Runnable) new b(b));
        h.d(a, "FutureUtils.transform(Ch…ve(cacheKey) })\n        }");
        return a;
    }

    public static /* bridge */ /* synthetic */ s a(b bVar, String str, String str2, String str3, int i, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            i = 20;
        }
        return bVar.a(str, str2, str3, i);
    }

    public final s<List<g>> a(String str, String str2, String str3, int i) {
        h.e(str, "roomId");
        h.e(str2, "fromId");
        h.e(str3, "toId");
        s<List<g>> a = ag.a(l.cQj.b(str, str2, str3, i), (com.google.common.base.d) d.aJx);
        h.d(a, "FutureUtils.transform(Ch…Id, limit), { it?.data })");
        return a;
    }

    private final String b(String str, long j, int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(':');
        stringBuilder.append(j);
        stringBuilder.append(':');
        stringBuilder.append(i);
        return stringBuilder.toString();
    }
}
