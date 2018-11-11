package com.iqoption.microservice.chat;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.iqoption.util.ah;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0018\bÆ\u0002\u0018\u00002\u00020\u0001:\u0007@ABCDEFB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u001e\u001a\u00020\u001f\"\u0004\b\u0000\u0010 2\f\u0010!\u001a\b\u0012\u0004\u0012\u0002H 0\"2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u00020\u001f0$H\u0002J\u0016\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020)J\u000e\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\u000fJ\u000e\u0010,\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\u0013J\u001c\u0010-\u001a\u00020\u001f2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00040/2\u0006\u0010+\u001a\u00020\u0015J\u0016\u00100\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0017J\u000e\u00102\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\u0019J\u000e\u00103\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\u001bJ\u000e\u00104\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\u001dJ@\u00105\u001a\u00020\u001f\"\u0006\b\u0000\u0010 \u0018\u00012\u0006\u00106\u001a\u00020\u00042\f\u0010!\u001a\b\u0012\u0004\u0012\u0002H 0\u000e2\u0006\u0010+\u001a\u0002H 2\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0004H\b¢\u0006\u0002\u00107J\u000e\u00108\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\u000fJ\u000e\u00109\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\u0013J\u001c\u0010:\u001a\u00020\u001f2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00040/2\u0006\u0010+\u001a\u00020\u0015J\u0016\u0010;\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0017J\u000e\u0010<\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\u0019J\u000e\u0010=\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\u001bJ\u000e\u0010>\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\u001dJ@\u0010?\u001a\u00020\u001f\"\u0006\b\u0000\u0010 \u0018\u00012\u0006\u00106\u001a\u00020\u00042\f\u0010!\u001a\b\u0012\u0004\u0012\u0002H 0\u000e2\u0006\u0010+\u001a\u0002H 2\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0004H\b¢\u0006\u0002\u00107R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \f*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \f*\u0004\u0018\u00010\u00110\u0011X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006G"}, aXE = {"Lcom/iqoption/microservice/chat/ChatEventHandler;", "", "()V", "EVENT_CHAT_CLIENT_MANAGER_ONLINE_CHANGED", "", "EVENT_CHAT_MESSAGE_GENERATED", "EVENT_CHAT_MESSAGE_PUBLIC_GENERATED", "EVENT_CHAT_PUBLIC_TYPING", "EVENT_CHAT_ROOM_GENERATED", "EVENT_CHAT_STATE_UPDATED", "EVENT_CHAT_TYPING", "TAG", "kotlin.jvm.PlatformType", "clientManagerOnlineListeners", "", "Lcom/iqoption/microservice/chat/ChatEventHandler$ClientManagerOnlineListener;", "gson", "Lcom/google/gson/Gson;", "messagesListeners", "Lcom/iqoption/microservice/chat/ChatEventHandler$MessagesListener;", "publicMessagesListeners", "Lcom/iqoption/microservice/chat/ChatEventHandler$PublicMessagesListener;", "publicTypingListeners", "Lcom/iqoption/microservice/chat/ChatEventHandler$PublicTypingListener;", "roomListeners", "Lcom/iqoption/microservice/chat/ChatEventHandler$RoomListener;", "stateListeners", "Lcom/iqoption/microservice/chat/ChatEventHandler$StateListener;", "typingListeners", "Lcom/iqoption/microservice/chat/ChatEventHandler$TypingListener;", "notifyListeners", "", "T", "listeners", "", "callback", "Lkotlin/Function1;", "onHandle", "", "name", "json", "Lcom/google/gson/stream/JsonReader;", "subscribeForClientManagerOnline", "listener", "subscribeForMessages", "subscribeForPublicMessages", "roomIds", "", "subscribeForPublicTyping", "roomId", "subscribeForRoom", "subscribeForState", "subscribeForTyping", "subscribeTemplate", "event", "(Ljava/lang/String;Ljava/util/Set;Ljava/lang/Object;Ljava/lang/String;)V", "unsubscribeForClientManagerOnline", "unsubscribeForMessages", "unsubscribeForPublicMessages", "unsubscribeForPublicTyping", "unsubscribeForRoom", "unsubscribeForState", "unsubscribeForTyping", "unsubscribeTemplate", "ClientManagerOnlineListener", "MessagesListener", "PublicMessagesListener", "PublicTypingListener", "RoomListener", "StateListener", "TypingListener", "IqOption-5.5.1_optionXRelease"})
/* compiled from: ChatEventHandler.kt */
public final class d {
    private static final String TAG = "d";
    private static final Set<e> aJy = new LinkedHashSet();
    private static final Set<a> cPA = new LinkedHashSet();
    private static final Set<f> cPB = new LinkedHashSet();
    private static final Set<b> cPC = new LinkedHashSet();
    private static final Set<g> cPD = new LinkedHashSet();
    private static final Set<c> cPE = new LinkedHashSet();
    private static final Set<d> cPF = new LinkedHashSet();
    public static final d cPG = new d();
    private static final Gson gson = ah.aGg();

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¨\u0006\u0007"}, aXE = {"Lcom/iqoption/microservice/chat/ChatEventHandler$ClientManagerOnlineListener;", "", "onChatClientManagerOnlineChanged", "", "event", "Lcom/iqoption/microservice/chat/ChatEvent;", "Lcom/iqoption/microservice/chat/ChatClientManagerOnlineChangedInfo;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ChatEventHandler.kt */
    public interface a {
        void h(c<Object> cVar);
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005H&¨\u0006\b"}, aXE = {"Lcom/iqoption/microservice/chat/ChatEventHandler$MessagesListener;", "", "onChatMessageGenerated", "", "event", "Lcom/iqoption/microservice/chat/ChatEvent;", "", "Lcom/iqoption/microservice/chat/ChatMessage;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ChatEventHandler.kt */
    public interface b {
        void b(c<? extends List<g>> cVar);
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005H&¨\u0006\b"}, aXE = {"Lcom/iqoption/microservice/chat/ChatEventHandler$PublicMessagesListener;", "", "onChatMessagePublicGenerated", "", "event", "Lcom/iqoption/microservice/chat/ChatEvent;", "", "Lcom/iqoption/microservice/chat/ChatMessage;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ChatEventHandler.kt */
    public interface c {
        void a(c<? extends List<g>> cVar);
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¨\u0006\u0007"}, aXE = {"Lcom/iqoption/microservice/chat/ChatEventHandler$PublicTypingListener;", "", "onChatPublicTypingEvent", "", "event", "Lcom/iqoption/microservice/chat/ChatEvent;", "Lcom/iqoption/microservice/chat/ChatTypingInfo;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ChatEventHandler.kt */
    public interface d {
        void e(c<p> cVar);
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005H&¨\u0006\b"}, aXE = {"Lcom/iqoption/microservice/chat/ChatEventHandler$RoomListener;", "", "onChatRoomGenerated", "", "event", "Lcom/iqoption/microservice/chat/ChatEvent;", "", "Lcom/iqoption/microservice/chat/ChatRoom;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ChatEventHandler.kt */
    public interface e {
        void c(c<? extends List<n>> cVar);
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¨\u0006\u0007"}, aXE = {"Lcom/iqoption/microservice/chat/ChatEventHandler$StateListener;", "", "onChatStateUpdated", "", "event", "Lcom/iqoption/microservice/chat/ChatEvent;", "Lcom/iqoption/microservice/chat/ChatState;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ChatEventHandler.kt */
    public interface f {
        void d(c<o> cVar);
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¨\u0006\u0007"}, aXE = {"Lcom/iqoption/microservice/chat/ChatEventHandler$TypingListener;", "", "onChatTypingEvent", "", "event", "Lcom/iqoption/microservice/chat/ChatEvent;", "Lcom/iqoption/microservice/chat/ChatTypingInfo;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ChatEventHandler.kt */
    public interface g {
        void f(c<p> cVar);
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, aXE = {"com/iqoption/microservice/chat/ChatEventHandler$onHandle$handled$event$1", "Lcom/google/gson/reflect/TypeToken;", "Lcom/iqoption/microservice/chat/ChatEvent;", "Lcom/iqoption/microservice/chat/ChatClientManagerOnlineChangedInfo;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ChatEventHandler.kt */
    public static final class h extends TypeToken<c<? extends Object>> {
        h() {
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, aXE = {"com/iqoption/microservice/chat/ChatEventHandler$onHandle$handled$event$2", "Lcom/google/gson/reflect/TypeToken;", "Lcom/iqoption/microservice/chat/ChatEvent;", "Lcom/iqoption/microservice/chat/ChatState;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ChatEventHandler.kt */
    public static final class i extends TypeToken<c<? extends o>> {
        i() {
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, aXE = {"com/iqoption/microservice/chat/ChatEventHandler$onHandle$handled$event$3", "Lcom/google/gson/reflect/TypeToken;", "Lcom/iqoption/microservice/chat/ChatListEvent;", "Lcom/iqoption/microservice/chat/ChatRoom;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ChatEventHandler.kt */
    public static final class j extends TypeToken<e<? extends n>> {
        j() {
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, aXE = {"com/iqoption/microservice/chat/ChatEventHandler$onHandle$handled$event$4", "Lcom/google/gson/reflect/TypeToken;", "Lcom/iqoption/microservice/chat/ChatListEvent;", "Lcom/iqoption/microservice/chat/ChatMessage;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ChatEventHandler.kt */
    public static final class k extends TypeToken<e<? extends g>> {
        k() {
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, aXE = {"com/iqoption/microservice/chat/ChatEventHandler$onHandle$handled$event$5", "Lcom/google/gson/reflect/TypeToken;", "Lcom/iqoption/microservice/chat/ChatEvent;", "Lcom/iqoption/microservice/chat/ChatTypingInfo;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ChatEventHandler.kt */
    public static final class l extends TypeToken<c<? extends p>> {
        l() {
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, aXE = {"com/iqoption/microservice/chat/ChatEventHandler$onHandle$handled$event$6", "Lcom/google/gson/reflect/TypeToken;", "Lcom/iqoption/microservice/chat/ChatListEvent;", "Lcom/iqoption/microservice/chat/ChatMessage;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ChatEventHandler.kt */
    public static final class m extends TypeToken<e<? extends g>> {
        m() {
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, aXE = {"com/iqoption/microservice/chat/ChatEventHandler$onHandle$handled$event$7", "Lcom/google/gson/reflect/TypeToken;", "Lcom/iqoption/microservice/chat/ChatEvent;", "Lcom/iqoption/microservice/chat/ChatTypingInfo;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ChatEventHandler.kt */
    public static final class n extends TypeToken<c<? extends p>> {
        n() {
        }
    }

    private d() {
    }

    public final void a(e eVar) {
        kotlin.jvm.internal.h.e(eVar, "listener");
        String str = "chat-room-generated";
        Set set = aJy;
        String str2 = (String) null;
        synchronized (set) {
            com.iqoption.core.f.DT().c(str, e.class).h("room_id", str2).Hs().bv(true);
            set.add(eVar);
        }
    }

    public final void b(e eVar) {
        kotlin.jvm.internal.h.e(eVar, "listener");
        String str = "chat-room-generated";
        Set set = aJy;
        String str2 = (String) null;
        synchronized (set) {
            com.iqoption.core.f.DT().c(str, e.class).h("room_id", str2).Hs().bv(false);
            set.remove(eVar);
        }
    }

    public final void a(f fVar) {
        kotlin.jvm.internal.h.e(fVar, "listener");
        String str = "chat-state-updated";
        Set set = cPB;
        String str2 = (String) null;
        synchronized (set) {
            com.iqoption.core.f.DT().c(str, f.class).h("room_id", str2).Hs().bv(true);
            set.add(fVar);
        }
    }

    public final void a(b bVar) {
        kotlin.jvm.internal.h.e(bVar, "listener");
        String str = "chat-message-generated";
        Set set = cPC;
        String str2 = (String) null;
        synchronized (set) {
            com.iqoption.core.f.DT().c(str, b.class).h("room_id", str2).Hs().bv(true);
            set.add(bVar);
        }
    }

    public final void a(g gVar) {
        kotlin.jvm.internal.h.e(gVar, "listener");
        String str = "chat-typing";
        Set set = cPD;
        String str2 = (String) null;
        synchronized (set) {
            com.iqoption.core.f.DT().c(str, g.class).h("room_id", str2).Hs().bv(true);
            set.add(gVar);
        }
    }

    public final void b(g gVar) {
        kotlin.jvm.internal.h.e(gVar, "listener");
        String str = "chat-typing";
        Set set = cPD;
        String str2 = (String) null;
        synchronized (set) {
            com.iqoption.core.f.DT().c(str, g.class).h("room_id", str2).Hs().bv(false);
            set.remove(gVar);
        }
    }

    public final void a(List<String> list, c cVar) {
        kotlin.jvm.internal.h.e(list, "roomIds");
        kotlin.jvm.internal.h.e(cVar, "listener");
        for (String str : list) {
            d dVar = cPG;
            String str2 = "chat-message-public-generated";
            Set set = cPE;
            synchronized (set) {
                com.iqoption.core.f.DT().c(str2, c.class).h("room_id", str).Hs().bv(true);
                set.add(cVar);
            }
        }
    }

    public final void b(List<String> list, c cVar) {
        kotlin.jvm.internal.h.e(list, "roomIds");
        kotlin.jvm.internal.h.e(cVar, "listener");
        for (String str : list) {
            d dVar = cPG;
            String str2 = "chat-message-public-generated";
            Set set = cPE;
            synchronized (set) {
                com.iqoption.core.f.DT().c(str2, c.class).h("room_id", str).Hs().bv(false);
                set.remove(cVar);
            }
        }
    }

    public final void a(String str, d dVar) {
        kotlin.jvm.internal.h.e(str, "roomId");
        kotlin.jvm.internal.h.e(dVar, "listener");
        String str2 = "chat-public-typing";
        Set set = cPF;
        synchronized (set) {
            com.iqoption.core.f.DT().c(str2, d.class).h("room_id", str).Hs().bv(true);
            set.add(dVar);
        }
    }

    public final void b(String str, d dVar) {
        kotlin.jvm.internal.h.e(str, "roomId");
        kotlin.jvm.internal.h.e(dVar, "listener");
        String str2 = "chat-public-typing";
        Set set = cPF;
        synchronized (set) {
            com.iqoption.core.f.DT().c(str2, d.class).h("room_id", str).Hs().bv(false);
            set.remove(dVar);
        }
    }

    private final <T> void a(Set<? extends T> set, kotlin.jvm.a.b<? super T, kotlin.l> bVar) {
        synchronized (set) {
            for (Object invoke : set) {
                bVar.invoke(invoke);
            }
            kotlin.l lVar = kotlin.l.etX;
        }
    }

    public final boolean a(String str, JsonReader jsonReader) {
        kotlin.jvm.internal.h.e(str, "name");
        kotlin.jvm.internal.h.e(jsonReader, "json");
        switch (str.hashCode()) {
            case -1366036570:
                if (str.equals("chat-public-typing")) {
                    a(cPF, (kotlin.jvm.a.b) new ChatEventHandler$onHandle$handled$7((c) gson.fromJson(jsonReader, new n().getType())));
                    return true;
                }
                break;
            case -1288903118:
                if (str.equals("chat-room-generated")) {
                    a(aJy, (kotlin.jvm.a.b) new ChatEventHandler$onHandle$handled$3((e) gson.fromJson(jsonReader, new j().getType())));
                    return true;
                }
                break;
            case 175475732:
                if (str.equals("chat-message-generated")) {
                    a(cPC, (kotlin.jvm.a.b) new ChatEventHandler$onHandle$handled$4((e) gson.fromJson(jsonReader, new k().getType())));
                    return true;
                }
                break;
            case 392502534:
                if (str.equals("chat-message-public-generated")) {
                    a(cPE, (kotlin.jvm.a.b) new ChatEventHandler$onHandle$handled$6((e) gson.fromJson(jsonReader, new m().getType())));
                    return true;
                }
                break;
            case 401269735:
                if (str.equals("chat-client-manager-online-changed")) {
                    a(cPA, (kotlin.jvm.a.b) new ChatEventHandler$onHandle$handled$1((c) gson.fromJson(jsonReader, new h().getType())));
                    return true;
                }
                break;
            case 503296458:
                if (str.equals("chat-state-updated")) {
                    a(cPB, (kotlin.jvm.a.b) new ChatEventHandler$onHandle$handled$2((c) gson.fromJson(jsonReader, new i().getType())));
                    return true;
                }
                break;
            case 730179980:
                if (str.equals("chat-typing")) {
                    a(cPD, (kotlin.jvm.a.b) new ChatEventHandler$onHandle$handled$5((c) gson.fromJson(jsonReader, new l().getType())));
                    return true;
                }
                break;
        }
        return false;
    }
}
