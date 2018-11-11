package com.iqoption.microservice.chat;

import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.common.util.concurrent.s;
import com.google.gson.reflect.TypeToken;
import com.iqoption.dto.entity.position.Order;
import java.lang.reflect.Type;
import java.util.List;
import java.util.UUID;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\u0004J(\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004J\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0011\u001a\u00020\u0004J\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\t2\u0006\u0010\u0015\u001a\u00020\u0004J.\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\t2\u0006\u0010\u0011\u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u000eJ\u001a\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u00130\t2\u0006\u0010\u0011\u001a\u00020\u0004J4\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\t2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00042\b\b\u0002\u0010\u001b\u001a\u00020\u000eJ\u0012\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u00170\tJ\u0012\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u00130\tJ\u001e\u0010%\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010&\u001a\u00020'J\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\t2\u0006\u0010\u0011\u001a\u00020\u0004JN\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00130\t2\u0006\u0010\u0011\u001a\u00020\u00042\b\b\u0002\u0010+\u001a\u00020\u00042\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010.2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0004J\u001c\u00100\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0004J\u0014\u00101\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0011\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u00062"}, aXE = {"Lcom/iqoption/microservice/chat/ChatRequests;", "", "()V", "DENY_CHAT_SUPPORT_BOT", "", "REQUEST_CHAT_MESSAGE_SUGGESTIONS", "RESOLVE_CHAT_SUPPORT", "SEND_CHAT_HEARTBEAT", "denyChatSupportBot", "Lcom/google/common/util/concurrent/ListenableFuture;", "Lcom/iqoption/microservice/chat/ChatResponse;", "messageId", "rateSupportChat", "rate", "", "comment", "readChatMessage", "roomId", "requestChatClientManagerOnline", "Lcom/iqoption/microservice/chat/ChatDataResponse;", "Lcom/iqoption/microservice/chat/ChatClientManager;", "clientManagerId", "requestChatMessage", "Lcom/iqoption/microservice/chat/ChatListResponse;", "Lcom/iqoption/microservice/chat/ChatMessage;", "timestamp", "", "limit", "requestChatMessageSuggestions", "Lcom/iqoption/core/microservices/chat/response/ChatSuggestions;", "requestChatMissingMessage", "fromId", "toId", "requestChatRoom", "Lcom/iqoption/microservice/chat/ChatRoom;", "requestChatState", "Lcom/iqoption/microservice/chat/ChatState;", "resolveChatSupport", "isResolved", "", "sendChatHeartbeat", "Lcom/iqoption/microservice/chat/ChatHeartbeat;", "sendChatMessage", "requestId", "text", "attachments", "", "suggestionId", "sendChatTextTyping", "sendChatTyping", "IqOption-5.5.1_optionXRelease"})
/* compiled from: ChatRequests.kt */
public final class l {
    public static final l cQj = new l();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0003"}, aXE = {"com/iqoption/core/ext/GsonExtensionsKt$typeOf$1", "Lcom/google/gson/reflect/TypeToken;", "core_release", "com/iqoption/core/connect/BuilderFactoryExtensionsKt$create$$inlined$typeOf$2"})
    /* compiled from: GsonExtensions.kt */
    public static final class a extends TypeToken<f<? extends g>> {
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0003"}, aXE = {"com/iqoption/core/ext/GsonExtensionsKt$typeOf$1", "Lcom/google/gson/reflect/TypeToken;", "core_release", "com/iqoption/core/connect/BuilderFactoryExtensionsKt$create$$inlined$typeOf$2"})
    /* compiled from: GsonExtensions.kt */
    public static final class b extends TypeToken<b<? extends com.iqoption.core.microservices.b.a.b>> {
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0003"}, aXE = {"com/iqoption/core/ext/GsonExtensionsKt$typeOf$1", "Lcom/google/gson/reflect/TypeToken;", "core_release", "com/iqoption/core/connect/BuilderFactoryExtensionsKt$create$$inlined$typeOf$2"})
    /* compiled from: GsonExtensions.kt */
    public static final class c extends TypeToken<f<? extends g>> {
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0003"}, aXE = {"com/iqoption/core/ext/GsonExtensionsKt$typeOf$1", "Lcom/google/gson/reflect/TypeToken;", "core_release", "com/iqoption/core/connect/BuilderFactoryExtensionsKt$create$$inlined$typeOf$2"})
    /* compiled from: GsonExtensions.kt */
    public static final class d extends TypeToken<f<? extends n>> {
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0003"}, aXE = {"com/iqoption/core/ext/GsonExtensionsKt$typeOf$1", "Lcom/google/gson/reflect/TypeToken;", "core_release", "com/iqoption/core/connect/BuilderFactoryExtensionsKt$create$$inlined$typeOf$2"})
    /* compiled from: GsonExtensions.kt */
    public static final class e extends TypeToken<b<? extends o>> {
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0003"}, aXE = {"com/iqoption/core/ext/GsonExtensionsKt$typeOf$1", "Lcom/google/gson/reflect/TypeToken;", "core_release", "com/iqoption/core/connect/BuilderFactoryExtensionsKt$create$$inlined$typeOf$2"})
    /* compiled from: GsonExtensions.kt */
    public static final class f extends TypeToken<b<? extends g>> {
    }

    private l() {
    }

    public final s<m> c(String str, int i, String str2) {
        h.e(str, "messageId");
        return com.iqoption.core.f.DS().b("rate-support-chat", m.class).ga("rate-support-chat").j("message_id", str).j("rate", Integer.valueOf(i)).j("comment", str2).Sa();
    }

    public final s<m> ih(String str) {
        h.e(str, "roomId");
        return com.iqoption.core.f.DS().b("read-chat-message", m.class).j("room_id", str).Sa();
    }

    public final s<f<g>> c(String str, long j, int i) {
        h.e(str, "roomId");
        Type type = new a().getType();
        h.d(type, "object : TypeToken<T>() {}.type");
        return com.iqoption.core.f.DS().a("request-chat-message", type).j("room_id", str).j(Param.TIMESTAMP, Long.valueOf(j)).j(Order.LIMIT, Integer.valueOf(i)).Sa();
    }

    public final s<m> ii(String str) {
        h.e(str, "messageId");
        return com.iqoption.core.f.DS().b("deny-chat-support-bot", m.class).j("message_id", str).Sa();
    }

    public final s<m> r(String str, boolean z) {
        h.e(str, "messageId");
        return com.iqoption.core.f.DS().b("resolve-chat-support", m.class).j("message_id", str).j("is_resolved", Boolean.valueOf(z)).Sa();
    }

    public final s<f<g>> b(String str, String str2, String str3, int i) {
        h.e(str, "roomId");
        h.e(str2, "fromId");
        h.e(str3, "toId");
        Type type = new c().getType();
        h.d(type, "object : TypeToken<T>() {}.type");
        return com.iqoption.core.f.DS().a("request-chat-missing-message", type).j("room_id", str).j("from_id", str2).j("to_id", str3).j(Order.LIMIT, Integer.valueOf(i)).Sa();
    }

    public final s<f<n>> arH() {
        Type type = new d().getType();
        h.d(type, "object : TypeToken<T>() {}.type");
        return com.iqoption.core.f.DS().a("request-chat-room", type).Sa();
    }

    public final s<b<o>> arI() {
        Type type = new e().getType();
        h.d(type, "object : TypeToken<T>() {}.type");
        return com.iqoption.core.f.DS().a("request-chat-state", type).Sa();
    }

    public final s<b<com.iqoption.core.microservices.b.a.b>> ij(String str) {
        h.e(str, "roomId");
        Type type = new b().getType();
        h.d(type, "object : TypeToken<T>() {}.type");
        return com.iqoption.core.f.DS().a("request-chat-message-suggestions", type).dF(0).j("room_id", str).Sa();
    }

    public static /* synthetic */ s a(l lVar, String str, String str2, String str3, List list, String str4, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = UUID.randomUUID().toString();
            h.d(str2, "UUID.randomUUID().toString()");
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = (String) null;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            list = (List) null;
        }
        List list2 = list;
        if ((i & 16) != 0) {
            str4 = (String) null;
        }
        return lVar.a(str, str5, str6, list2, str4);
    }

    public final s<b<g>> a(String str, String str2, String str3, List<String> list, String str4) {
        h.e(str, "roomId");
        h.e(str2, "requestId");
        Type type = new f().getType();
        h.d(type, "object : TypeToken<T>() {}.type");
        return com.iqoption.core.f.DS().a("send-chat-message", type).dF(0).j("room_id", str).j("request_id", str2).j("text", str3).j("attachments", list).j("suggestion_id", str4).j("use_bot", Boolean.valueOf(com.iqoption.app.managers.feature.a.eW("support-bot"))).Sa();
    }

    public final s<m> al(String str, String str2) {
        h.e(str, "roomId");
        h.e(str2, "text");
        return com.iqoption.core.f.DS().b("send-chat-text-typing", m.class).j("room_id", str).j("text", str2).Sa();
    }

    public final s<m> ik(String str) {
        h.e(str, "roomId");
        return com.iqoption.core.f.DS().b("send-chat-typing", m.class).j("room_id", str).Sa();
    }
}
