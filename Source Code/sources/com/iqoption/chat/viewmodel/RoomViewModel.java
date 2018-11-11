package com.iqoption.chat.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.MainThread;
import android.support.v4.app.Fragment;
import android.support.v7.util.DiffUtil.Callback;
import android.support.v7.util.DiffUtil.DiffResult;
import com.google.common.util.concurrent.s;
import com.iqoption.chat.component.af;
import com.iqoption.chat.component.ag;
import com.iqoption.chat.component.y;
import com.iqoption.chat.component.z;
import com.iqoption.microservice.chat.ChatRoomType;
import com.iqoption.util.bi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.jvm.internal.MutablePropertyReference1Impl;

@kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0006\u0001\u0001\u0001B\u0005¢\u0006\u0002\u0010\u0005J\u001e\u0010S\u001a\u00020T2\f\u0010U\u001a\b\u0012\u0004\u0012\u00020\u001b0\t2\u0006\u0010V\u001a\u00020\u0011H\u0002J(\u0010W\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\u000b0\b2\f\u0010U\u001a\b\u0012\u0004\u0012\u00020\u001b0\tH\u0002J\u0010\u0010X\u001a\u00020T2\u0006\u0010Y\u001a\u00020\u001bH\u0007J\u0016\u0010Z\u001a\u00020T2\u0006\u00107\u001a\u0002082\u0006\u0010[\u001a\u00020=J\u0006\u0010\\\u001a\u00020\u0011J,\u0010]\u001a\u00020T2\u0006\u0010^\u001a\u00020\u001b2\f\u0010_\u001a\b\u0012\u0004\u0012\u00020\u001b0\t2\f\u0010`\u001a\b\u0012\u0004\u0012\u00020\u001b0\tH\u0002J\u0006\u0010a\u001a\u00020TJ\u0006\u0010b\u001a\u00020TJ*\u0010c\u001a\b\u0012\u0004\u0012\u00020\u001b0\t2\f\u0010_\u001a\b\u0012\u0004\u0012\u00020\u001b0\t2\f\u0010`\u001a\b\u0012\u0004\u0012\u00020\u001b0\tH\u0002J0\u0010d\u001a\u00020T2\f\u0010`\u001a\b\u0012\u0004\u0012\u00020\u001b0\t2\u000e\b\u0002\u0010_\u001a\b\u0012\u0004\u0012\u00020\u001b0\t2\b\b\u0002\u0010V\u001a\u00020\u0011H\u0002J\u0016\u0010e\u001a\u00020T2\f\u0010f\u001a\b\u0012\u0004\u0012\u00020h0gH\u0016J\u0016\u0010i\u001a\u00020T2\f\u0010f\u001a\b\u0012\u0004\u0012\u00020h0gH\u0016J\b\u0010j\u001a\u00020TH\u0014J\u0016\u0010k\u001a\u00020T2\f\u0010U\u001a\b\u0012\u0004\u0012\u00020\u001b0\tH\u0016J\u0016\u0010l\u001a\u00020T2\f\u0010f\u001a\b\u0012\u0004\u0012\u00020h0gH\u0002J$\u0010m\u001a\u00020T2\u0006\u0010n\u001a\u0002082\u0006\u0010o\u001a\u00020\u00112\n\b\u0002\u0010p\u001a\u0004\u0018\u000108H\u0002J\u001c\u0010q\u001a\u00020T2\u0006\u0010o\u001a\u00020\u00112\n\b\u0002\u0010p\u001a\u0004\u0018\u000108H\u0002J\b\u0010r\u001a\u00020TH\u0002J\"\u0010s\u001a\u00020T2\u0006\u0010n\u001a\u0002082\u0006\u0010t\u001a\u00020R2\n\b\u0002\u0010u\u001a\u0004\u0018\u000108J\u0018\u0010v\u001a\u00020T2\u0006\u0010Y\u001a\u00020\u001b2\u0006\u0010w\u001a\u00020\u0011H\u0007J\u000e\u0010x\u001a\u00020T2\u0006\u0010Y\u001a\u000208J\u0010\u0010y\u001a\u00020T2\u0006\u0010z\u001a\u00020{H\u0007J\u000e\u0010|\u001a\u00020T2\u0006\u0010}\u001a\u000208J\u0006\u0010~\u001a\u00020TJ\b\u0010\u001a\u00020TH\u0002J\u0007\u0010\u0001\u001a\u00020TR)\u0010\u0006\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\u000b0\b0\u00078F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR&\u0010\u000e\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\u000b0\b0\u000fX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00078F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\rR\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\u000fX\u0004¢\u0006\u0002\n\u0000Rc\u0010\u001d\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u001aj\u0002`\u001c2\"\u0010\u0019\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u001aj\u0002`\u001c8B@BX\u0002¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u000e\u0010$\u001a\u00020%X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020(X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020(X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010.\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0004¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\b\u0012\u0004\u0012\u00020\u001b02X\u0004¢\u0006\u0002\n\u0000R\u0017\u00103\u001a\b\u0012\u0004\u0012\u0002040\u00078F¢\u0006\u0006\u001a\u0004\b5\u0010\rR\u0014\u00106\u001a\b\u0012\u0004\u0012\u0002040\u000fX\u0004¢\u0006\u0002\n\u0000R\u0011\u00107\u001a\u0002088F¢\u0006\u0006\u001a\u0004\b9\u0010:R\u000e\u0010;\u001a\u000208X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020=X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010>\u001a\b\u0012\u0004\u0012\u00020?0\u00078F¢\u0006\u0006\u001a\u0004\b@\u0010\rR\u0014\u0010A\u001a\b\u0012\u0004\u0012\u00020?0\u000fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010B\u001a\b\u0012\u0004\u0012\u0002080CX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010D\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010E0CX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010F\u001a\b\u0012\u0004\u0012\u00020G0\u00078F¢\u0006\u0006\u001a\u0004\bH\u0010\rR\u0017\u0010I\u001a\b\u0012\u0004\u0012\u00020J0\u00078F¢\u0006\u0006\u001a\u0004\bK\u0010\rR\u0014\u0010L\u001a\b\u0012\u0004\u0012\u00020J0\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020NX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010O\u001a\u000e\u0012\u0004\u0012\u00020Q\u0012\u0004\u0012\u00020R0PX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001"}, aXE = {"Lcom/iqoption/chat/viewmodel/RoomViewModel;", "Landroid/arch/lifecycle/ViewModel;", "Lcom/iqoption/chat/repository/MessageRepository$MessageListener;", "Lcom/iqoption/microservice/chat/ChatEventHandler$PublicTypingListener;", "Lcom/iqoption/microservice/chat/ChatEventHandler$TypingListener;", "()V", "adapterItems", "Landroid/arch/lifecycle/LiveData;", "Lkotlin/Pair;", "", "Lcom/iqoption/chat/component/MessageAdapterItem;", "Landroid/support/v7/util/DiffUtil$DiffResult;", "getAdapterItems", "()Landroid/arch/lifecycle/LiveData;", "adapterItemsData", "Landroid/arch/lifecycle/MutableLiveData;", "canLoadMore", "", "getCanLoadMore", "()Z", "canLoadMoreInternal", "chatRoom", "Lcom/iqoption/microservice/chat/ChatRoom;", "getChatRoom", "chatRoomData", "<set-?>", "Lkotlin/Function1;", "Lcom/iqoption/microservice/chat/ChatMessage;", "Lcom/iqoption/chat/viewmodel/MessagesConverter;", "converter", "getConverter", "()Lkotlin/jvm/functions/Function1;", "setConverter", "(Lkotlin/jvm/functions/Function1;)V", "converter$delegate", "Lkotlin/properties/ReadWriteProperty;", "diffCallback", "Lcom/iqoption/chat/viewmodel/RoomViewModel$DiffCallback;", "initialized", "isDenying", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isResolving", "loadingMissing", "loadingMore", "messageFilter", "Lcom/iqoption/chat/viewmodel/MessageFilter;", "messageList", "messageLock", "", "messagesToMerge", "", "rateSupportEvent", "Lcom/iqoption/chat/component/RateSupportEvent;", "getRateSupportEvent", "rateSupportEventData", "roomId", "", "getRoomId", "()Ljava/lang/String;", "roomIdInternal", "roomTypeInternal", "Lcom/iqoption/microservice/chat/ChatRoomType;", "sendMessageEvent", "Lcom/iqoption/chat/component/ResultEvent;", "getSendMessageEvent", "sendMessageEventData", "sendTextTypingLimiter", "Lcom/iqoption/util/WorkLimiter;", "sendTypingLimiter", "Ljava/lang/Void;", "state", "Lcom/iqoption/microservice/chat/ChatState;", "getState", "typingEvent", "Lcom/iqoption/chat/viewmodel/RoomViewModel$TypingInfo;", "getTypingEvent", "typingEventData", "typingHandler", "Landroid/os/Handler;", "typingMap", "", "Lcom/iqoption/microservice/chat/ChatTypingUser;", "", "convertAndPostResult", "", "messages", "setLastSeen", "convertToAdapterItems", "denySupportBot", "message", "init", "roomType", "isInitialized", "loadMissing", "firstMsg", "src", "diff", "loadMoreMessages", "markRoomRead", "merge", "mergeAndPostResult", "onChatPublicTypingEvent", "event", "Lcom/iqoption/microservice/chat/ChatEvent;", "Lcom/iqoption/microservice/chat/ChatTypingInfo;", "onChatTypingEvent", "onCleared", "onMessageEvent", "onTyping", "postRateSupportEvent", "messageId", "success", "error", "postSendMessageEvent", "postTypingEvent", "rateSupport", "rating", "comment", "resolveSupport", "isResolved", "sendMessage", "sendSuggestion", "suggestion", "Lcom/iqoption/core/microservices/chat/response/ChatSuggestion;", "sendTextTyping", "text", "sendTyping", "setLastSeenMessage", "subscribeForTyping", "Companion", "DiffCallback", "TypingInfo", "IqOption-5.5.1_optionXRelease"})
/* compiled from: RoomViewModel.kt */
public final class RoomViewModel extends ViewModel implements com.iqoption.chat.repository.b.a, com.iqoption.microservice.chat.d.d, com.iqoption.microservice.chat.d.g {
    private static final String TAG = "RoomViewModel";
    public static final a aLo = new a();
    static final /* synthetic */ kotlin.reflect.j[] apP = new kotlin.reflect.j[]{kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(RoomViewModel.class), "converter", "getConverter()Lkotlin/jvm/functions/Function1;"))};
    private boolean aKS;
    private final MutableLiveData<com.iqoption.microservice.chat.n> aKT = new MutableLiveData();
    private final MutableLiveData<Pair<List<y>, DiffResult>> aKU = new MutableLiveData();
    private final MutableLiveData<ag> aKV = new MutableLiveData();
    private final MutableLiveData<af> aKW = new MutableLiveData();
    private final Object aKX = new Object();
    private final e aKY = new e();
    private List<com.iqoption.microservice.chat.g> aKZ;
    private final List<com.iqoption.microservice.chat.g> aLa = new ArrayList();
    private AtomicBoolean aLb = new AtomicBoolean();
    private String aLc = "unknown";
    private ChatRoomType aLd = ChatRoomType.SUPPORT;
    private boolean aLe = true;
    private final Map<com.iqoption.microservice.chat.q, Integer> aLf = new LinkedHashMap();
    private final MutableLiveData<c> aLg = new MutableLiveData();
    private final Handler aLh = new Handler();
    private final b aLi = new b();
    private final kotlin.e.d aLj = kotlin.e.a.euA.aYg();
    private final bi<Void> aLk = new bi(new RoomViewModel$sendTypingLimiter$1(this), null, null, 6, null);
    private final bi<String> aLl = new bi(new RoomViewModel$sendTextTypingLimiter$1(this), null, null, 6, null);
    private final AtomicBoolean aLm = new AtomicBoolean();
    private final AtomicBoolean aLn = new AtomicBoolean();
    private boolean initialized;

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, aXE = {"Lcom/iqoption/chat/viewmodel/RoomViewModel$Companion;", "", "()V", "TAG", "", "get", "Lcom/iqoption/chat/viewmodel/RoomViewModel;", "fragment", "Landroid/support/v4/app/Fragment;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: RoomViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final RoomViewModel j(Fragment fragment) {
            kotlin.jvm.internal.h.e(fragment, "fragment");
            return (RoomViewModel) ViewModelProviders.d(fragment).h(RoomViewModel.class);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, aXE = {"Lcom/iqoption/chat/viewmodel/RoomViewModel$TypingInfo;", "", "name", "", "count", "", "(Ljava/lang/String;I)V", "getCount", "()I", "getName", "()Ljava/lang/String;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: RoomViewModel.kt */
    public static final class c {
        private final int count;
        private final String name;

        public c(String str, int i) {
            kotlin.jvm.internal.h.e(str, "name");
            this.name = str;
            this.count = i;
        }

        public final int getCount() {
            return this.count;
        }

        public final String getName() {
            return this.name;
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, aXE = {"<anonymous>", "", "run", "com/iqoption/chat/viewmodel/RoomViewModel$loadMissing$3$2"})
    /* compiled from: RoomViewModel.kt */
    static final class h implements Runnable {
        final /* synthetic */ com.iqoption.microservice.chat.g aLr;
        final /* synthetic */ List aLs;
        final /* synthetic */ RoomViewModel this$0;

        h(RoomViewModel roomViewModel, com.iqoption.microservice.chat.g gVar, List list) {
            this.this$0 = roomViewModel;
            this.aLr = gVar;
            this.aLs = list;
        }

        public final void run() {
            this.this$0.aLb.set(false);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, aXE = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
    /* compiled from: Comparisons.kt */
    public static final class j<T> implements Comparator<T> {
        public final int compare(T t, T t2) {
            return b.c(Long.valueOf(((com.iqoption.microservice.chat.g) t).getDate()), Long.valueOf(((com.iqoption.microservice.chat.g) t2).getDate()));
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
    /* compiled from: RoomViewModel.kt */
    static final class k implements Runnable {
        final /* synthetic */ com.iqoption.microservice.chat.q aLu;
        final /* synthetic */ RoomViewModel this$0;

        k(RoomViewModel roomViewModel, com.iqoption.microservice.chat.q qVar) {
            this.this$0 = roomViewModel;
            this.aLu = qVar;
        }

        public final void run() {
            Integer num = (Integer) this.this$0.aLf.get(this.aLu);
            int intValue = (num != null ? num.intValue() : 1) - 1;
            if (intValue == 0) {
                this.this$0.aLf.remove(this.aLu);
            } else {
                this.this$0.aLf.put(this.aLu, Integer.valueOf(intValue));
            }
            String Ki = RoomViewModel.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Reduce: ");
            stringBuilder.append(this.aLu);
            stringBuilder.append(", newCount: ");
            stringBuilder.append(intValue);
            com.iqoption.core.i.d(Ki, stringBuilder.toString());
            this.this$0.Rh();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0012H\u0016J\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000b¨\u0006\u0019"}, aXE = {"Lcom/iqoption/chat/viewmodel/RoomViewModel$DiffCallback;", "Landroid/support/v7/util/DiffUtil$Callback;", "()V", "idSupplier", "Lcom/iqoption/chat/component/MessageIdSupplier;", "newList", "", "Lcom/iqoption/chat/component/MessageAdapterItem;", "getNewList", "()Ljava/util/List;", "setNewList", "(Ljava/util/List;)V", "oldList", "getOldList", "setOldList", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "reset", "", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: RoomViewModel.kt */
    private static final class b extends Callback {
        private final z aDE = new z();
        private List<? extends y> aLp = m.emptyList();
        private List<? extends y> aLq = m.emptyList();

        public final void aa(List<? extends y> list) {
            kotlin.jvm.internal.h.e(list, "<set-?>");
            this.aLp = list;
        }

        public final void ab(List<? extends y> list) {
            kotlin.jvm.internal.h.e(list, "<set-?>");
            this.aLq = list;
        }

        public int getOldListSize() {
            return this.aLp.size();
        }

        public int getNewListSize() {
            return this.aLq.size();
        }

        public boolean areItemsTheSame(int i, int i2) {
            return this.aDE.a((y) this.aLp.get(i)) == this.aDE.a((y) this.aLq.get(i2));
        }

        public boolean areContentsTheSame(int i, int i2) {
            return kotlin.jvm.internal.h.E((y) this.aLp.get(i), (y) this.aLq.get(i2));
        }

        public final void reset() {
            this.aLp = m.emptyList();
            this.aLq = m.emptyList();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/microservice/chat/ChatRoom;", "call"})
    /* compiled from: RoomViewModel.kt */
    static final class d<T> implements com.iqoption.util.ag.e<V> {
        final /* synthetic */ RoomViewModel this$0;

        d(RoomViewModel roomViewModel) {
            this.this$0 = roomViewModel;
        }

        /* renamed from: h */
        public final void aU(com.iqoption.microservice.chat.n nVar) {
            kotlin.jvm.internal.h.e(nVar, "it");
            this.this$0.aKT.postValue(nVar);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/microservice/chat/ChatRoom;", "call"})
    /* compiled from: RoomViewModel.kt */
    static final class e<T> implements com.iqoption.util.ag.e<V> {
        final /* synthetic */ RoomViewModel this$0;

        e(RoomViewModel roomViewModel) {
            this.this$0 = roomViewModel;
        }

        /* renamed from: h */
        public final void aU(com.iqoption.microservice.chat.n nVar) {
            kotlin.jvm.internal.h.e(nVar, "it");
            this.this$0.aKT.postValue(nVar);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00012\u00020\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J\u0016\u0010\n\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002¨\u0006\u000e"}, aXE = {"com/iqoption/chat/viewmodel/RoomViewModel$init$callback$1", "Lcom/iqoption/util/FutureUtils$SuccessFutureCallback;", "Lcom/iqoption/microservice/chat/ChatDataResponse;", "Lcom/iqoption/core/microservices/chat/response/ChatSuggestions;", "Lcom/iqoption/util/FutureUtils$FailFutureCallback;", "call", "", "result", "throwable", "", "onSuggestionsLoaded", "suggestions", "", "Lcom/iqoption/core/microservices/chat/response/ChatSuggestion;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: RoomViewModel.kt */
    public static final class f implements com.iqoption.util.ag.a, com.iqoption.util.ag.e<com.iqoption.microservice.chat.b<? extends com.iqoption.core.microservices.b.a.b>> {
        final /* synthetic */ RoomViewModel this$0;

        f(RoomViewModel roomViewModel) {
            this.this$0 = roomViewModel;
        }

        /* renamed from: b */
        public void aU(com.iqoption.microservice.chat.b<com.iqoption.core.microservices.b.a.b> bVar) {
            kotlin.jvm.internal.h.e(bVar, "result");
            ac(((com.iqoption.core.microservices.b.a.b) bVar.getData()).Vz());
        }

        public void n(Throwable th) {
            kotlin.jvm.internal.h.e(th, "throwable");
            ac(m.emptyList());
        }

        private final void ac(List<com.iqoption.core.microservices.b.a.a> list) {
            this.this$0.g((kotlin.jvm.a.b) new h(list, new RoomViewModel$init$callback$1$onSuggestionsLoaded$1(this), new RoomViewModel$init$callback$1$onSuggestionsLoaded$2(this)));
            this.this$0.Rl();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "", "Lcom/iqoption/microservice/chat/ChatMessage;", "call", "com/iqoption/chat/viewmodel/RoomViewModel$loadMissing$3$1"})
    /* compiled from: RoomViewModel.kt */
    static final class g<T> implements com.iqoption.util.ag.e<V> {
        final /* synthetic */ com.iqoption.microservice.chat.g aLr;
        final /* synthetic */ List aLs;
        final /* synthetic */ RoomViewModel this$0;

        g(RoomViewModel roomViewModel, com.iqoption.microservice.chat.g gVar, List list) {
            this.this$0 = roomViewModel;
            this.aLr = gVar;
            this.aLs = list;
        }

        /* renamed from: Y */
        public final void aU(List<com.iqoption.microservice.chat.g> list) {
            kotlin.jvm.internal.h.e(list, "it");
            RoomViewModel.a(this.this$0, (List) list, this.aLs, false, 4, null);
            Pair pair = new Pair(u.bU(list), u.bW(list));
            String Ki = RoomViewModel.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Requested size: ");
            stringBuilder.append(list.size());
            stringBuilder.append(", first msg: ");
            stringBuilder.append(((com.iqoption.microservice.chat.g) pair.getFirst()).getId());
            stringBuilder.append(", last msg: ");
            stringBuilder.append(((com.iqoption.microservice.chat.g) pair.aXF()).getId());
            com.iqoption.core.i.d(Ki, stringBuilder.toString());
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "", "Lcom/iqoption/microservice/chat/ChatMessage;", "call"})
    /* compiled from: RoomViewModel.kt */
    static final class i<T> implements com.iqoption.util.ag.e<V> {
        final /* synthetic */ long aLt;
        final /* synthetic */ RoomViewModel this$0;

        i(RoomViewModel roomViewModel, long j) {
            this.this$0 = roomViewModel;
            this.aLt = j;
        }

        /* renamed from: Y */
        public final void aU(List<com.iqoption.microservice.chat.g> list) {
            kotlin.jvm.internal.h.e(list, "it");
            this.this$0.aKS = false;
            this.this$0.aLe = list.size() == 20;
            synchronized (this.this$0.aKX) {
                kotlin.l lVar;
                if (this.aLt == 0) {
                    RoomViewModel.a(this.this$0, (List) list, this.this$0.aLa, false, 4, null);
                    lVar = kotlin.l.etX;
                } else {
                    List e = this.this$0.aKZ;
                    if (e != null) {
                        List b = u.b((Collection) e, (Iterable) list);
                        this.this$0.aKZ = b;
                        this.this$0.b(b, false);
                        lVar = kotlin.l.etX;
                    }
                }
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "", "call"})
    /* compiled from: RoomViewModel.kt */
    static final class l<T> implements com.iqoption.util.ag.e<V> {
        final /* synthetic */ String aLv;
        final /* synthetic */ RoomViewModel this$0;

        l(RoomViewModel roomViewModel, String str) {
            this.this$0 = roomViewModel;
            this.aLv = str;
        }

        public /* synthetic */ void aU(Object obj) {
            cc(((Boolean) obj).booleanValue());
        }

        public final void cc(boolean z) {
            RoomViewModel.a(this.this$0, this.aLv, true, null, 4, null);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "", "call"})
    /* compiled from: RoomViewModel.kt */
    static final class m implements com.iqoption.util.ag.a {
        final /* synthetic */ String aLv;
        final /* synthetic */ RoomViewModel this$0;

        m(RoomViewModel roomViewModel, String str) {
            this.this$0 = roomViewModel;
            this.aLv = str;
        }

        public final void n(Throwable th) {
            kotlin.jvm.internal.h.e(th, "it");
            this.this$0.a(this.aLv, false, th.getMessage());
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/microservice/chat/ChatResponse;", "apply"})
    /* compiled from: RoomViewModel.kt */
    static final class n<F, T> implements com.google.common.base.d<I, O> {
        public static final n aLw = new n();

        n() {
        }

        public /* synthetic */ Object apply(Object obj) {
            return Boolean.valueOf(a((com.iqoption.microservice.chat.m) obj));
        }

        public final boolean a(com.iqoption.microservice.chat.m mVar) {
            if (mVar == null) {
                throw new RuntimeException("response is null");
            } else if (mVar.isSuccessful()) {
                return true;
            } else {
                throw new RuntimeException(mVar.getErrorMessage());
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/microservice/chat/ChatMessage;", "call"})
    /* compiled from: RoomViewModel.kt */
    static final class o<T> implements com.iqoption.util.ag.e<V> {
        final /* synthetic */ RoomViewModel this$0;

        o(RoomViewModel roomViewModel) {
            this.this$0 = roomViewModel;
        }

        /* renamed from: h */
        public final void aU(com.iqoption.microservice.chat.g gVar) {
            kotlin.jvm.internal.h.e(gVar, "it");
            this.this$0.R(l.cr(gVar));
            RoomViewModel.a(this.this$0, true, null, 2, null);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "", "call"})
    /* compiled from: RoomViewModel.kt */
    static final class p implements com.iqoption.util.ag.a {
        final /* synthetic */ RoomViewModel this$0;

        p(RoomViewModel roomViewModel) {
            this.this$0 = roomViewModel;
        }

        public final void n(Throwable th) {
            kotlin.jvm.internal.h.e(th, "it");
            this.this$0.d(false, th.getMessage());
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "Lcom/iqoption/microservice/chat/ChatMessage;", "it", "Lcom/iqoption/microservice/chat/ChatDataResponse;", "apply"})
    /* compiled from: RoomViewModel.kt */
    static final class q<F, T> implements com.google.common.base.d<I, O> {
        public static final q aLx = new q();

        q() {
        }

        /* renamed from: c */
        public final com.iqoption.microservice.chat.g apply(com.iqoption.microservice.chat.b<com.iqoption.microservice.chat.g> bVar) {
            if (bVar == null) {
                throw new RuntimeException("response is null");
            } else if (bVar.isSuccessful()) {
                return (com.iqoption.microservice.chat.g) bVar.getData();
            } else {
                throw new RuntimeException(bVar.getErrorMessage());
            }
        }
    }

    private final kotlin.jvm.a.b<List<com.iqoption.microservice.chat.g>, List<y>> Ri() {
        return (kotlin.jvm.a.b) this.aLj.b(this, apP[0]);
    }

    private final void g(kotlin.jvm.a.b<? super List<com.iqoption.microservice.chat.g>, ? extends List<? extends y>> bVar) {
        this.aLj.a(this, apP[0], bVar);
    }

    public RoomViewModel() {
        com.iqoption.chat.repository.b.aJu.a((com.iqoption.chat.repository.b.a) this);
    }

    static {
        kotlin.jvm.internal.h.d(RoomViewModel.class.getSimpleName(), "RoomViewModel::class.java.simpleName");
    }

    public final LiveData<com.iqoption.microservice.chat.n> Ra() {
        return this.aKT;
    }

    public final LiveData<Pair<List<y>, DiffResult>> Rb() {
        return this.aKU;
    }

    public final LiveData<ag> Rc() {
        return this.aKV;
    }

    public final LiveData<af> Rd() {
        return this.aKW;
    }

    public final LiveData<com.iqoption.microservice.chat.o> Qs() {
        return com.iqoption.chat.repository.f.aJG.Qs();
    }

    public final String Re() {
        return this.aLc;
    }

    public final boolean Rf() {
        return this.aLe;
    }

    public final LiveData<c> Rg() {
        return this.aLg;
    }

    public void R(List<com.iqoption.microservice.chat.g> list) {
        kotlin.jvm.internal.h.e(list, "messages");
        com.iqoption.microservice.chat.n nVar = (com.iqoption.microservice.chat.n) this.aKT.getValue();
        if (nVar != null) {
            Collection arrayList = new ArrayList();
            for (Object next : list) {
                if (kotlin.jvm.internal.h.E(((com.iqoption.microservice.chat.g) next).Re(), nVar.getId())) {
                    arrayList.add(next);
                }
            }
            List list2 = (List) arrayList;
            if (!list2.isEmpty()) {
                synchronized (this.aKX) {
                    kotlin.l lVar;
                    if (this.aKZ != null) {
                        a(this, list2, null, false, 6, null);
                        lVar = kotlin.l.etX;
                    } else {
                        this.aLa.addAll(list2);
                        for (Object next2 : this.aLa) {
                            if ((((com.iqoption.microservice.chat.g) next2).aru() ^ 1) != 0) {
                                break;
                            }
                        }
                        Object next22 = null;
                        com.iqoption.microservice.chat.g gVar = (com.iqoption.microservice.chat.g) next22;
                        if (gVar != null) {
                            com.iqoption.microservice.chat.n.cQr.am(Re(), gVar.getId());
                            lVar = kotlin.l.etX;
                        }
                    }
                }
            }
        }
    }

    public void e(com.iqoption.microservice.chat.c<com.iqoption.microservice.chat.p> cVar) {
        kotlin.jvm.internal.h.e(cVar, "event");
        g((com.iqoption.microservice.chat.c) cVar);
    }

    public void f(com.iqoption.microservice.chat.c<com.iqoption.microservice.chat.p> cVar) {
        kotlin.jvm.internal.h.e(cVar, "event");
        g((com.iqoption.microservice.chat.c) cVar);
    }

    private final void Rh() {
        int size = this.aLf.keySet().size();
        this.aLg.postValue(new c(size == 1 ? ((com.iqoption.microservice.chat.q) u.M(this.aLf.keySet())).getName() : "", size));
    }

    private final void g(com.iqoption.microservice.chat.c<com.iqoption.microservice.chat.p> cVar) {
        if ((kotlin.jvm.internal.h.E(this.aLc, ((com.iqoption.microservice.chat.p) cVar.getData()).Re()) ^ 1) == 0) {
            com.iqoption.microservice.chat.q arR = ((com.iqoption.microservice.chat.p) cVar.getData()).arR();
            Integer num = (Integer) this.aLf.get(arR);
            if (num == null || num.intValue() == 0) {
                this.aLf.put(arR, Integer.valueOf(1));
            } else {
                this.aLf.put(arR, Integer.valueOf(num.intValue() + 1));
            }
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Event: ");
            stringBuilder.append(arR);
            stringBuilder.append(", count: ");
            stringBuilder.append(num);
            com.iqoption.core.i.d(str, stringBuilder.toString());
            Rh();
            this.aLh.postDelayed(new k(this, arR), 3000);
        }
    }

    private final void a(List<com.iqoption.microservice.chat.g> list, List<com.iqoption.microservice.chat.g> list2, boolean z) {
        List c = c((List) list2, (List) list);
        this.aKZ = c;
        b(c, z);
    }

    private final void b(List<com.iqoption.microservice.chat.g> list, boolean z) {
        MutableLiveData mutableLiveData = this.aKU;
        kotlin.jvm.a.b bVar = this.aKY;
        Collection arrayList = new ArrayList();
        for (Object next : list) {
            if (((Boolean) bVar.invoke(next)).booleanValue()) {
                arrayList.add(next);
            }
        }
        mutableLiveData.postValue(Z((List) arrayList));
        if (z) {
            Rj();
        }
    }

    /* JADX WARNING: Missing block: B:3:0x0012, code:
            if (r1 != null) goto L_0x0019;
     */
    private final kotlin.Pair<java.util.List<com.iqoption.chat.component.y>, android.support.v7.util.DiffUtil.DiffResult> Z(java.util.List<com.iqoption.microservice.chat.g> r3) {
        /*
        r2 = this;
        r0 = r2.aLi;
        r1 = r2.aKU;
        r1 = r1.getValue();
        r1 = (kotlin.Pair) r1;
        if (r1 == 0) goto L_0x0015;
    L_0x000c:
        r1 = r1.getFirst();
        r1 = (java.util.List) r1;
        if (r1 == 0) goto L_0x0015;
    L_0x0014:
        goto L_0x0019;
    L_0x0015:
        r1 = kotlin.collections.m.emptyList();
    L_0x0019:
        r0.aa(r1);
        r0 = r2.Ri();
        r3 = r0.invoke(r3);
        r3 = (java.util.List) r3;
        r0 = r2.aLi;
        r0.ab(r3);
        r0 = r2.aLi;
        r0 = (android.support.v7.util.DiffUtil.Callback) r0;
        r1 = 0;
        r0 = android.support.v7.util.DiffUtil.calculateDiff(r0, r1);
        r1 = r2.aLi;
        r1.reset();
        r1 = new kotlin.Pair;
        r1.<init>(r3, r0);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.chat.viewmodel.RoomViewModel.Z(java.util.List):kotlin.Pair<java.util.List<com.iqoption.chat.component.y>, android.support.v7.util.DiffUtil$DiffResult>");
    }

    private final void Rj() {
        List list = this.aKZ;
        if (list != null) {
            com.iqoption.microservice.chat.g gVar = (com.iqoption.microservice.chat.g) u.bV(list);
            if (gVar != null) {
                com.iqoption.microservice.chat.n.cQr.am(Re(), gVar.getId());
            }
        }
    }

    private final List<com.iqoption.microservice.chat.g> c(List<com.iqoption.microservice.chat.g> list, List<com.iqoption.microservice.chat.g> list2) {
        if (list.isEmpty()) {
            return list2;
        }
        List<com.iqoption.microservice.chat.g> O = u.O((Collection) list);
        Pair D = kotlin.j.D(u.bU(O), u.bW(O));
        com.iqoption.microservice.chat.g gVar = (com.iqoption.microservice.chat.g) D.aXG();
        com.iqoption.microservice.chat.g gVar2 = (com.iqoption.microservice.chat.g) D.aXH();
        long date = gVar.getDate();
        long date2 = gVar2.getDate();
        for (com.iqoption.microservice.chat.g gVar3 : u.a((Iterable) list2, (Comparator) new j())) {
            int i = 0;
            if (gVar3.aru()) {
                for (com.iqoption.microservice.chat.g id : O) {
                    if (kotlin.jvm.internal.h.E(id.getId(), gVar3.getId())) {
                        break;
                    }
                    i++;
                }
                i = -1;
                if (i != -1) {
                    O.set(i, gVar3);
                }
            } else if (gVar3.getDate() <= date) {
                long date3 = gVar3.getDate();
                if (date2 <= date3) {
                    if (date >= date3) {
                        int i2 = 0;
                        for (com.iqoption.microservice.chat.g id2 : O) {
                            if (kotlin.jvm.internal.h.E(id2.getId(), gVar3.getId())) {
                                break;
                            }
                            i2++;
                        }
                        i2 = -1;
                        if (i2 != -1) {
                            O.set(i2, gVar3);
                        } else {
                            for (com.iqoption.microservice.chat.g id3 : O) {
                                if (kotlin.jvm.internal.h.E(id3.getId(), gVar3.arw())) {
                                    break;
                                }
                                i++;
                            }
                            i = -1;
                            if (i != -1) {
                                O.add(i, gVar3);
                            }
                        }
                    }
                }
            } else if (kotlin.jvm.internal.h.E(gVar.getId(), gVar3.arw())) {
                O.add(0, gVar3);
                date = gVar3.getDate();
                gVar = gVar3;
            } else if (!this.aLb.get()) {
                this.aLb.set(true);
                a(gVar, (List) O, (List) list2);
            }
        }
        return O;
    }

    private final void a(com.iqoption.microservice.chat.g gVar, List<com.iqoption.microservice.chat.g> list, List<com.iqoption.microservice.chat.g> list2) {
        Object obj;
        Collection arrayList = new ArrayList();
        for (Object next : list2) {
            if ((((com.iqoption.microservice.chat.g) next).aru() ^ 1) != 0) {
                arrayList.add(next);
            }
        }
        Iterator it = ((List) arrayList).iterator();
        if (it.hasNext()) {
            Object next2 = it.next();
            long date = ((com.iqoption.microservice.chat.g) next2).getDate();
            while (it.hasNext()) {
                Object next3 = it.next();
                long date2 = ((com.iqoption.microservice.chat.g) next3).getDate();
                if (date < date2) {
                    next2 = next3;
                    date = date2;
                }
            }
            obj = next2;
        } else {
            obj = null;
        }
        com.iqoption.microservice.chat.g gVar2 = (com.iqoption.microservice.chat.g) obj;
        if (gVar2 != null) {
            String id = gVar.getId();
            String id2 = gVar2.getId();
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Requesting missing for room: ");
            stringBuilder.append(Re());
            stringBuilder.append(" from msg: ");
            stringBuilder.append(id);
            stringBuilder.append(", to msg: ");
            stringBuilder.append(id2);
            com.iqoption.core.i.d(str, stringBuilder.toString());
            s a = com.iqoption.chat.repository.b.a(com.iqoption.chat.repository.b.aJu, Re(), id, id2, 0, 8, null);
            com.iqoption.util.ag.a(a, (com.iqoption.util.ag.e) new g(this, gVar, list));
            com.iqoption.util.ag.a(a, (Runnable) new h(this, gVar, list));
        }
    }

    protected void onCleared() {
        super.onCleared();
        this.aLh.removeCallbacks(null);
        com.iqoption.chat.repository.b.aJu.b((com.iqoption.chat.repository.b.a) this);
        if (this.aLd == ChatRoomType.SUPPORT || this.aLd == ChatRoomType.VIP) {
            com.iqoption.microservice.chat.d.cPG.b((com.iqoption.microservice.chat.d.g) this);
        } else if (this.aLd == ChatRoomType.GLOBAL) {
            com.iqoption.microservice.chat.d.cPG.b(this.aLc, (com.iqoption.microservice.chat.d.d) this);
        }
    }

    public final void b(String str, ChatRoomType chatRoomType) {
        kotlin.jvm.internal.h.e(str, "roomId");
        kotlin.jvm.internal.h.e(chatRoomType, "roomType");
        if (!this.initialized) {
            this.aLc = str;
            this.aLd = chatRoomType;
            this.initialized = true;
            com.iqoption.util.ag.a(com.iqoption.chat.repository.c.aJA.fN(str), (com.iqoption.util.ag.e) new d(this));
            com.iqoption.util.ag.a(com.iqoption.chat.repository.c.aJA.fN(str), (com.iqoption.util.ag.e) new e(this));
            if (chatRoomType == ChatRoomType.SUPPORT) {
                f fVar = new f(this);
                com.iqoption.util.ag.b(com.iqoption.microservice.chat.l.cQj.ij(this.aLc), fVar, fVar);
                return;
            }
            g((kotlin.jvm.a.b) new b(new RoomViewModel$init$3(this), new RoomViewModel$init$4(this)));
            Rl();
        }
    }

    public final void Rk() {
        Rj();
        com.iqoption.chat.repository.c.aJA.fO(Re());
    }

    public final void Rl() {
        if (this.initialized) {
            List list = this.aKZ;
            com.iqoption.microservice.chat.g gVar = list != null ? (com.iqoption.microservice.chat.g) u.bW(list) : null;
            if (this.aKS) {
                com.iqoption.core.i.d(TAG, "Already loading just right now");
                return;
            } else if (Rf()) {
                this.aKS = true;
                long date = gVar != null ? gVar.getDate() : 0;
                com.iqoption.util.ag.a(com.iqoption.chat.repository.b.aJu.a(Re(), date, 20), (com.iqoption.util.ag.e) new i(this, date));
                return;
            } else {
                com.iqoption.core.i.d(TAG, "Already all messages have been loaded");
                return;
            }
        }
        com.iqoption.core.i.d(TAG, "Has not been initialized yet");
    }

    public final void fV(String str) {
        kotlin.jvm.internal.h.e(str, "message");
        com.iqoption.util.ag.b(com.iqoption.util.ag.a(com.iqoption.microservice.chat.l.a(com.iqoption.microservice.chat.l.cQj, Re(), null, str, null, null, 26, null), (com.google.common.base.d) q.aLx), new o(this), new p(this));
    }

    static /* synthetic */ void a(RoomViewModel roomViewModel, boolean z, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = (String) null;
        }
        roomViewModel.d(z, str);
    }

    private final void d(boolean z, String str) {
        this.aKV.postValue(new ag(SystemClock.elapsedRealtime(), z, str));
    }

    public final void b(String str, int i, String str2) {
        kotlin.jvm.internal.h.e(str, "messageId");
        String str3 = null;
        if (!(str2 == null || (u.M(str2) ^ 1) == 0)) {
            str3 = str2;
        }
        com.iqoption.util.ag.b(com.iqoption.util.ag.a(com.iqoption.microservice.chat.l.cQj.c(str, i, str3), (com.google.common.base.d) n.aLw), new l(this, str), new m(this, str));
    }

    private final void a(String str, boolean z, String str2) {
        this.aKW.postValue(new af(str, SystemClock.elapsedRealtime(), z, str2));
    }

    public final void Rm() {
        this.aLk.bN(null);
    }

    public final void fW(String str) {
        kotlin.jvm.internal.h.e(str, "text");
        this.aLl.bN(str);
    }

    public final void Rn() {
        if (this.aLd == ChatRoomType.SUPPORT || this.aLd == ChatRoomType.VIP) {
            com.iqoption.microservice.chat.d.cPG.a((com.iqoption.microservice.chat.d.g) this);
        } else if (this.aLd == ChatRoomType.GLOBAL) {
            com.iqoption.microservice.chat.d.cPG.a(this.aLc, (com.iqoption.microservice.chat.d.d) this);
        }
    }

    @MainThread
    public final void c(com.iqoption.microservice.chat.g gVar, boolean z) {
        kotlin.jvm.internal.h.e(gVar, "message");
        if (!this.aLm.get()) {
            this.aLm.set(true);
            com.iqoption.util.af.a(com.iqoption.microservice.chat.l.cQj.r(gVar.getId(), z), null, null, new RoomViewModel$resolveSupport$1(this), null, 11, null);
        }
    }

    @MainThread
    public final void g(com.iqoption.microservice.chat.g gVar) {
        kotlin.jvm.internal.h.e(gVar, "message");
        if (!this.aLn.get()) {
            this.aLn.set(true);
            com.iqoption.util.af.a(com.iqoption.microservice.chat.l.cQj.ii(gVar.getId()), null, null, new RoomViewModel$denySupportBot$1(this), null, 11, null);
        }
    }

    @MainThread
    public final void c(com.iqoption.core.microservices.b.a.a aVar) {
        kotlin.jvm.internal.h.e(aVar, "suggestion");
        com.iqoption.util.af.a(com.iqoption.microservice.chat.l.a(com.iqoption.microservice.chat.l.cQj, Re(), null, aVar.getName(), null, aVar.getId(), 10, null), RoomViewModel$sendSuggestion$1.aLy, RoomViewModel$sendSuggestion$2.aLz, null, null, 12, null);
    }
}
