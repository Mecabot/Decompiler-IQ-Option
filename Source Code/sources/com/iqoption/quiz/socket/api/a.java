package com.iqoption.quiz.socket.api;

import io.reactivex.c.f;
import io.reactivex.e;
import java.util.List;
import java.util.UUID;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nH\u0016J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\nH\u0002J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, aXE = {"Lcom/iqoption/quiz/socket/api/ChatSocketApi;", "Lcom/iqoption/quiz/api/ChatApi;", "connect", "Lcom/iqoption/core/IQConnect;", "(Lcom/iqoption/core/IQConnect;)V", "chatApi", "Lcom/iqoption/quiz/socket/api/ChatSocketRequests;", "roomId", "", "getMessages", "Lio/reactivex/Flowable;", "", "Lcom/iqoption/quiz/api/response/chat/ChatMessageResponse;", "sendMessage", "chatMessage", "Lcom/iqoption/quiz/api/response/chat/ChatMessageSend;", "quiz_release"})
/* compiled from: ChatSocketApi.kt */
public final class a implements com.iqoption.quiz.api.a {
    private volatile String aUv;
    private final b dnK;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "Lio/reactivex/Flowable;", "", "Lcom/iqoption/quiz/api/response/chat/ChatMessageResponse;", "it", "", "apply"})
    /* compiled from: ChatSocketApi.kt */
    static final class a<T, R> implements f<T, org.a.b<? extends R>> {
        final /* synthetic */ a dnL;

        a(a aVar) {
            this.dnL = aVar;
        }

        /* renamed from: jx */
        public final e<List<com.iqoption.quiz.api.response.a.b>> apply(String str) {
            h.e(str, "it");
            return this.dnL.dnK.jz(str);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/quiz/api/response/chat/QuizChatRoom;", "apply"})
    /* compiled from: ChatSocketApi.kt */
    static final class b<T, R> implements f<T, R> {
        public static final b dnM = new b();

        b() {
        }

        /* renamed from: a */
        public final String apply(com.iqoption.quiz.api.response.a.f fVar) {
            h.e(fVar, "it");
            return fVar.getId();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: ChatSocketApi.kt */
    static final class c<T> implements io.reactivex.c.e<String> {
        final /* synthetic */ a dnL;

        c(a aVar) {
            this.dnL = aVar;
        }

        /* renamed from: jy */
        public final void accept(String str) {
            this.dnL.aUv = str;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "Lio/reactivex/Flowable;", "Lcom/iqoption/quiz/api/response/chat/ChatMessageResponse;", "kotlin.jvm.PlatformType", "it", "", "apply"})
    /* compiled from: ChatSocketApi.kt */
    static final class d<T, R> implements f<T, org.a.b<? extends R>> {
        final /* synthetic */ a dnL;
        final /* synthetic */ com.iqoption.quiz.api.response.a.c dnN;

        d(a aVar, com.iqoption.quiz.api.response.a.c cVar) {
            this.dnL = aVar;
            this.dnN = cVar;
        }

        /* renamed from: jx */
        public final e<com.iqoption.quiz.api.response.a.b> apply(String str) {
            h.e(str, "it");
            String text = this.dnN.getText();
            h.d(text, "chatMessage.text");
            Boolean aAO = this.dnN.aAO();
            h.d(aAO, "chatMessage.isLargeText");
            boolean booleanValue = aAO.booleanValue();
            String uuid = UUID.randomUUID().toString();
            h.d(uuid, "UUID.randomUUID().toString()");
            return this.dnL.dnK.a(new com.iqoption.quiz.api.response.a.d(str, text, booleanValue, uuid)).d((f) AnonymousClass1.dnO);
        }
    }

    public a(com.iqoption.core.h hVar) {
        h.e(hVar, "connect");
        this.dnK = new b(hVar);
    }

    public e<com.iqoption.quiz.api.response.a.b> a(com.iqoption.quiz.api.response.a.c cVar) {
        h.e(cVar, "chatMessage");
        e<com.iqoption.quiz.api.response.a.b> a = aCy().a((f) new d(this, cVar));
        h.d(a, "roomId().flatMap {\n     …se.create(it) }\n        }");
        return a;
    }

    public e<List<com.iqoption.quiz.api.response.a.b>> aAb() {
        e<List<com.iqoption.quiz.api.response.a.b>> a = aCy().a((f) new a(this));
        h.d(a, "roomId().flatMap {\n     …getMessages(it)\n        }");
        return a;
    }

    private final e<String> aCy() {
        String str = this.aUv;
        e<String> bW;
        if (str != null) {
            bW = e.bW(str);
            h.d(bW, "Flowable.just(roomId)");
            return bW;
        }
        bW = this.dnK.aCz().d((f) b.dnM).a((io.reactivex.c.e) new c(this));
        h.d(bW, "chatApi.getChatRoom().ma…Next { this.roomId = it }");
        return bW;
    }
}
