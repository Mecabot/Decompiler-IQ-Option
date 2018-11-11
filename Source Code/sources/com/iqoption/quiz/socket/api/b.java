package com.iqoption.quiz.socket.api;

import com.google.gson.reflect.TypeToken;
import com.iqoption.core.connect.l;
import io.reactivex.processors.PublishProcessor;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00152\u0006\u0010\u0016\u001a\u00020\u0006H\u0002J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00152\u0006\u0010\u0016\u001a\u00020\u0006H\u0002J\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0015J\u001a\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u00152\u0006\u0010\u0016\u001a\u00020\u0006J\u001c\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u001f0\u00152\u0006\u0010\u0016\u001a\u00020\u0006H\u0002J\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00130\u00152\u0006\u0010!\u001a\u00020\"J\u0016\u0010#\u001a\u00020$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001fH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, aXE = {"Lcom/iqoption/quiz/socket/api/ChatSocketRequests;", "", "connect", "Lcom/iqoption/core/IQConnect;", "(Lcom/iqoption/core/IQConnect;)V", "CHAT_QUIZ_CHAT_MESSAGE_ADDED", "", "CHAT_QUIZ_CHAT_MESSAGE_DELETED", "CHAT_REQUEST_QUIZ_CHAT_HISTORY", "CHAT_SEND_QUIZ_CHAT_MESSAGE", "MAX_CHAT_SIZE", "", "REQUEST_QUIZ_CHAT_ROOM_FOR_USER", "eventBuilder", "Lcom/iqoption/core/connect/EventBuilderFactory;", "requestBuilder", "Lcom/iqoption/core/connect/RequestBuilderFactory;", "sendMessageSubject", "Lio/reactivex/processors/FlowableProcessor;", "Lcom/iqoption/quiz/api/response/chat/ChatMessageSocketResponse;", "chatMessageAdded", "Lio/reactivex/Flowable;", "roomId", "chatMessageDeleted", "Lcom/iqoption/quiz/api/response/chat/ChatMessageDeleted;", "getChatRoom", "Lcom/iqoption/quiz/api/response/chat/QuizChatRoom;", "getMessages", "", "Lcom/iqoption/quiz/api/response/chat/ChatMessageResponse;", "getMessagesDirect", "", "sendMessage", "chatMessage", "Lcom/iqoption/quiz/api/response/chat/ChatMessageSendSocket;", "shrink", "", "messages", "quiz_release"})
/* compiled from: ChatSocketRequests.kt */
public final class b {
    private final String dnP = "chat.send-quiz-chat-message";
    private final String dnQ = "chat.request-quiz-chat-history";
    private final String dnR = "request-quiz-chat-room-for-user";
    private final String dnS = "quiz-chat-message-added";
    private final String dnT = "quiz-chat-message-deleted";
    private final io.reactivex.processors.a<com.iqoption.quiz.api.response.a.e> dnU;
    private final l dnV;
    private final com.iqoption.core.connect.e dnW;
    private final int dnX;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "Lcom/iqoption/quiz/api/response/chat/ChatMessageResponse;", "it", "Lcom/iqoption/quiz/api/response/chat/ChatMessageSocketResponse;", "apply"})
    /* compiled from: ChatSocketRequests.kt */
    static final class a<T, R> implements io.reactivex.c.f<T, R> {
        final /* synthetic */ b dnY;
        final /* synthetic */ List dnZ;

        a(b bVar, List list) {
            this.dnY = bVar;
            this.dnZ = list;
        }

        /* renamed from: m */
        public final List<com.iqoption.quiz.api.response.a.b> apply(List<com.iqoption.quiz.api.response.a.e> list) {
            List<com.iqoption.quiz.api.response.a.b> list2;
            h.e(list, "it");
            synchronized (this.dnZ) {
                List list3 = this.dnZ;
                Iterable<com.iqoption.quiz.api.response.a.e> iterable = list;
                Collection arrayList = new ArrayList(n.e(iterable, 10));
                for (com.iqoption.quiz.api.response.a.e a : iterable) {
                    arrayList.add(com.iqoption.quiz.api.response.a.b.a(a));
                }
                list3.addAll(0, (List) arrayList);
                this.dnY.bh(this.dnZ);
                list2 = this.dnZ;
            }
            return list2;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "Lcom/iqoption/quiz/api/response/chat/ChatMessageResponse;", "it", "Lcom/iqoption/quiz/api/response/chat/ChatMessageSocketResponse;", "apply"})
    /* compiled from: ChatSocketRequests.kt */
    static final class b<T, R> implements io.reactivex.c.f<T, R> {
        final /* synthetic */ b dnY;
        final /* synthetic */ List dnZ;

        b(b bVar, List list) {
            this.dnY = bVar;
            this.dnZ = list;
        }

        /* renamed from: c */
        public final List<com.iqoption.quiz.api.response.a.b> apply(com.iqoption.quiz.api.response.a.e eVar) {
            List<com.iqoption.quiz.api.response.a.b> list;
            h.e(eVar, "it");
            com.iqoption.quiz.api.response.a.b a = com.iqoption.quiz.api.response.a.b.a(eVar);
            synchronized (this.dnZ) {
                for (Object next : this.dnZ) {
                    Long id = ((com.iqoption.quiz.api.response.a.b) next).getId();
                    h.d(a, "newMessage");
                    if (h.E(id, a.getId())) {
                        break;
                    }
                }
                Object next2 = null;
                if (next2 == null) {
                    List list2 = this.dnZ;
                    h.d(a, "newMessage");
                    list2.add(a);
                    this.dnY.bh(this.dnZ);
                }
                list = this.dnZ;
            }
            return list;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "Lcom/iqoption/quiz/api/response/chat/ChatMessageResponse;", "deletedMessage", "Lcom/iqoption/quiz/api/response/chat/ChatMessageDeleted;", "apply"})
    /* compiled from: ChatSocketRequests.kt */
    static final class c<T, R> implements io.reactivex.c.f<T, R> {
        final /* synthetic */ List dnZ;

        c(List list) {
            this.dnZ = list;
        }

        /* renamed from: a */
        public final List<com.iqoption.quiz.api.response.a.b> apply(com.iqoption.quiz.api.response.a.a aVar) {
            List<com.iqoption.quiz.api.response.a.b> list;
            h.e(aVar, "deletedMessage");
            synchronized (this.dnZ) {
                int i = 0;
                for (com.iqoption.quiz.api.response.a.b id : this.dnZ) {
                    Long id2 = id.getId();
                    Object obj = (id2 != null && id2.longValue() == aVar.aAL()) ? 1 : null;
                    if (obj != null) {
                        break;
                    }
                    i++;
                }
                i = -1;
                if (i != -1) {
                    this.dnZ.remove(i);
                }
                list = this.dnZ;
            }
            return list;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "Lcom/iqoption/quiz/api/response/chat/ChatMessageResponse;", "it", "Lcom/iqoption/quiz/api/response/chat/ChatMessageSocketResponse;", "apply"})
    /* compiled from: ChatSocketRequests.kt */
    static final class d<T, R> implements io.reactivex.c.f<T, R> {
        final /* synthetic */ b dnY;
        final /* synthetic */ List dnZ;

        d(b bVar, List list) {
            this.dnY = bVar;
            this.dnZ = list;
        }

        /* renamed from: c */
        public final List<com.iqoption.quiz.api.response.a.b> apply(com.iqoption.quiz.api.response.a.e eVar) {
            List<com.iqoption.quiz.api.response.a.b> list;
            h.e(eVar, "it");
            com.iqoption.quiz.api.response.a.b a = com.iqoption.quiz.api.response.a.b.a(eVar);
            synchronized (this.dnZ) {
                for (Object next : this.dnZ) {
                    Long id = ((com.iqoption.quiz.api.response.a.b) next).getId();
                    h.d(a, "sentMessage");
                    if (h.E(id, a.getId())) {
                        break;
                    }
                }
                Object next2 = null;
                if (next2 == null) {
                    List list2 = this.dnZ;
                    h.d(a, "sentMessage");
                    list2.add(a);
                    this.dnY.bh(this.dnZ);
                }
                list = this.dnZ;
            }
            return list;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "Lcom/iqoption/quiz/api/response/chat/ChatMessageResponse;", "it", "", "apply"})
    /* compiled from: ChatSocketRequests.kt */
    static final class e<T, R> implements io.reactivex.c.f<T, R> {
        final /* synthetic */ List dnZ;

        e(List list) {
            this.dnZ = list;
        }

        /* renamed from: m */
        public final List<com.iqoption.quiz.api.response.a.b> apply(List<com.iqoption.quiz.api.response.a.b> list) {
            h.e(list, "it");
            synchronized (this.dnZ) {
                list = u.W(list);
            }
            return list;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0003"}, aXE = {"com/iqoption/core/ext/GsonExtensionsKt$typeOf$1", "Lcom/google/gson/reflect/TypeToken;", "core_release", "com/iqoption/core/connect/BuilderFactoryExtensionsKt$create$$inlined$typeOf$2"})
    /* compiled from: GsonExtensions.kt */
    public static final class f extends TypeToken<List<com.iqoption.quiz.api.response.a.e>> {
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/quiz/api/response/chat/ChatMessageSocketResponse;", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: ChatSocketRequests.kt */
    static final class g<T> implements io.reactivex.c.e<com.iqoption.quiz.api.response.a.e> {
        final /* synthetic */ b dnY;

        g(b bVar) {
            this.dnY = bVar;
        }

        /* renamed from: d */
        public final void accept(com.iqoption.quiz.api.response.a.e eVar) {
            this.dnY.dnU.e(eVar);
        }
    }

    public b(com.iqoption.core.h hVar) {
        h.e(hVar, "connect");
        io.reactivex.processors.a aXp = PublishProcessor.aXq().aXp();
        h.d(aXp, "PublishProcessor.create<…esponse>().toSerialized()");
        this.dnU = aXp;
        this.dnV = hVar.DS();
        this.dnW = hVar.DT();
        this.dnX = 1000;
    }

    public final io.reactivex.e<com.iqoption.quiz.api.response.a.e> a(com.iqoption.quiz.api.response.a.d dVar) {
        h.e(dVar, "chatMessage");
        io.reactivex.e<com.iqoption.quiz.api.response.a.e> a = this.dnV.b(this.dnP, com.iqoption.quiz.api.response.a.e.class).cd(false).j("room_id", dVar.Re()).j("text", dVar.getText()).j("is_large_text", Boolean.valueOf(dVar.aAP())).j("request_id", dVar.auD()).Sb().aWk().a((io.reactivex.c.e) new g(this));
        h.d(a, "requestBuilder\n         …ssageSubject.onNext(it) }");
        return a;
    }

    public final io.reactivex.e<List<com.iqoption.quiz.api.response.a.b>> jz(String str) {
        h.e(str, "roomId");
        List arrayList = new ArrayList();
        io.reactivex.e d = jA(str).d((io.reactivex.c.f) new a(this, arrayList)).c((org.a.b) jB(str).d((io.reactivex.c.f) new b(this, arrayList))).d((org.a.b) jC(str).d((io.reactivex.c.f) new c(arrayList))).d((org.a.b) this.dnU.d((io.reactivex.c.f) new d(this, arrayList))).c(com.iqoption.core.h.i.Yo()).a(1000, TimeUnit.MILLISECONDS, true).d((io.reactivex.c.f) new e(arrayList));
        h.d(d, "getMessagesDirect(roomId…                        }");
        return new com.iqoption.core.h.d(d, 10000, null, 4, null).Yg();
    }

    private final void bh(List<com.iqoption.quiz.api.response.a.b> list) {
        if (list.size() > this.dnX) {
            list.subList(0, list.size() - (this.dnX / 2)).clear();
        }
    }

    private final io.reactivex.e<List<com.iqoption.quiz.api.response.a.e>> jA(String str) {
        l lVar = this.dnV;
        String str2 = this.dnQ;
        Type type = new f().getType();
        h.d(type, "object : TypeToken<T>() {}.type");
        io.reactivex.e<List<com.iqoption.quiz.api.response.a.e>> aWk = lVar.a(str2, type).j("room_id", str).cd(false).Sb().aWk();
        h.d(aWk, "requestBuilder\n         …            .toFlowable()");
        return aWk;
    }

    public final io.reactivex.e<com.iqoption.quiz.api.response.a.f> aCz() {
        io.reactivex.e<com.iqoption.quiz.api.response.a.f> aWk = this.dnV.b(this.dnR, com.iqoption.quiz.api.response.a.f.class).cd(false).Sb().aWk();
        h.d(aWk, "requestBuilder\n         …            .toFlowable()");
        return aWk;
    }

    private final io.reactivex.e<com.iqoption.quiz.api.response.a.e> jB(String str) {
        return this.dnW.c(this.dnS, com.iqoption.quiz.api.response.a.e.class).h("room_id", str).Hr();
    }

    private final io.reactivex.e<com.iqoption.quiz.api.response.a.a> jC(String str) {
        return this.dnW.c(this.dnT, com.iqoption.quiz.api.response.a.a.class).h("room_id", str).Hr();
    }
}
