package com.iqoption.fragment.leftmenu;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import com.google.common.util.concurrent.g;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.iqoption.microservice.chat.ChatRoomType;
import com.iqoption.microservice.chat.n;
import com.iqoption.util.ag;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001b2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0011\u001a\u00020\u0012H\u0014J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0006H\u0016J\u0016\u0010\u0016\u001a\u00020\u00122\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0016J\b\u0010\u001a\u001a\u00020\u0012H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, aXE = {"Lcom/iqoption/fragment/leftmenu/SupportUnreadIndicatorViewModel;", "Landroid/arch/lifecycle/ViewModel;", "Lcom/iqoption/chat/repository/RoomRepository$LastSeenMessageListener;", "Lcom/iqoption/chat/repository/MessageRepository$MessageListener;", "()V", "supportLastSeenMessage", "", "supportRoomId", "supportUnreadCount", "Landroid/arch/lifecycle/LiveData;", "", "getSupportUnreadCount", "()Landroid/arch/lifecycle/LiveData;", "supportUnreadCountLoadingIndicator", "Ljava/util/concurrent/atomic/AtomicBoolean;", "supportUnreadCountMutableData", "Landroid/arch/lifecycle/MutableLiveData;", "onCleared", "", "onLastSeenMessageChanged", "roomId", "messageId", "onMessageEvent", "messages", "", "Lcom/iqoption/microservice/chat/ChatMessage;", "reloadSupportUnreadCount", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: SupportUnreadIndicatorViewModel.kt */
public final class SupportUnreadIndicatorViewModel extends ViewModel implements com.iqoption.chat.repository.b.a, com.iqoption.chat.repository.c.b {
    private static final String TAG = "SupportUnreadIndicatorViewModel";
    public static final a cCZ = new a();
    private String aLO;
    private final AtomicBoolean cCW = new AtomicBoolean();
    private String cCX;
    private final MutableLiveData<Integer> cCY;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, aXE = {"Lcom/iqoption/fragment/leftmenu/SupportUnreadIndicatorViewModel$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "get", "Lcom/iqoption/fragment/leftmenu/SupportUnreadIndicatorViewModel;", "activity", "Landroid/support/v4/app/FragmentActivity;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: SupportUnreadIndicatorViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
    /* compiled from: SupportUnreadIndicatorViewModel.kt */
    static final class d implements Runnable {
        final /* synthetic */ SupportUnreadIndicatorViewModel cDa;

        d(SupportUnreadIndicatorViewModel supportUnreadIndicatorViewModel) {
            this.cDa = supportUnreadIndicatorViewModel;
        }

        public final void run() {
            this.cDa.cCW.set(false);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "", "call"})
    /* compiled from: SupportUnreadIndicatorViewModel.kt */
    static final class b<T> implements com.iqoption.util.ag.e<V> {
        final /* synthetic */ SupportUnreadIndicatorViewModel cDa;

        b(SupportUnreadIndicatorViewModel supportUnreadIndicatorViewModel) {
            this.cDa = supportUnreadIndicatorViewModel;
        }

        public /* synthetic */ void aU(Object obj) {
            eW(((Number) obj).intValue());
        }

        public final void eW(int i) {
            this.cDa.cCY.postValue(Integer.valueOf(i));
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "", "call"})
    /* compiled from: SupportUnreadIndicatorViewModel.kt */
    static final class c implements com.iqoption.util.ag.a {
        final /* synthetic */ SupportUnreadIndicatorViewModel cDa;

        c(SupportUnreadIndicatorViewModel supportUnreadIndicatorViewModel) {
            this.cDa = supportUnreadIndicatorViewModel;
        }

        public final void n(Throwable th) {
            h.e(th, "it");
            com.iqoption.core.i.w(SupportUnreadIndicatorViewModel.TAG, th.getMessage(), th);
            this.cDa.cCY.postValue(Integer.valueOf(0));
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0007"}, aXE = {"<anonymous>", "Lcom/google/common/util/concurrent/ListenableFuture;", "", "kotlin.jvm.PlatformType", "it", "", "Lcom/iqoption/microservice/chat/ChatRoom;", "apply"})
    /* compiled from: SupportUnreadIndicatorViewModel.kt */
    static final class e<I, O> implements g<I, O> {
        final /* synthetic */ SupportUnreadIndicatorViewModel cDa;

        e(SupportUnreadIndicatorViewModel supportUnreadIndicatorViewModel) {
            this.cDa = supportUnreadIndicatorViewModel;
        }

        /* renamed from: aG */
        public final s<Integer> aP(List<n> list) {
            n nVar = null;
            if (list != null) {
                Object obj;
                for (Object next : list) {
                    Object obj2;
                    if (((n) next).Qh() == ChatRoomType.SUPPORT) {
                        obj2 = 1;
                        continue;
                    } else {
                        obj2 = null;
                        continue;
                    }
                    if (obj2 != null) {
                        obj = next;
                        break;
                    }
                }
                nVar = (n) obj;
            }
            if (nVar == null) {
                return o.aR(Integer.valueOf(0));
            }
            this.cDa.aLO = nVar.getId();
            this.cDa.cCX = nVar.arJ();
            final SupportUnreadIndicatorViewModel$reloadSupportUnreadCount$future$1$1 supportUnreadIndicatorViewModel$reloadSupportUnreadCount$future$1$1 = new SupportUnreadIndicatorViewModel$reloadSupportUnreadCount$future$1$1(nVar);
            return ag.a(com.iqoption.chat.repository.b.a(com.iqoption.chat.repository.b.aJu, nVar.getId(), 0, 10, 2, null), (com.google.common.base.d) new com.google.common.base.d<I, O>() {
                public /* synthetic */ Object apply(Object obj) {
                    return Integer.valueOf(aI((List) obj));
                }

                public final int aI(List<com.iqoption.microservice.chat.g> list) {
                    return supportUnreadIndicatorViewModel$reloadSupportUnreadCount$future$1$1.aH(list);
                }
            });
        }
    }

    public SupportUnreadIndicatorViewModel() {
        MutableLiveData mutableLiveData = new MutableLiveData();
        alT();
        this.cCY = mutableLiveData;
        com.iqoption.chat.repository.c.aJA.a((com.iqoption.chat.repository.c.b) this);
        com.iqoption.chat.repository.b.aJu.a((com.iqoption.chat.repository.b.a) this);
    }

    public final LiveData<Integer> alS() {
        return this.cCY;
    }

    public void R(List<com.iqoption.microservice.chat.g> list) {
        h.e(list, "messages");
        Iterable<com.iqoption.microservice.chat.g> iterable = list;
        Object obj = null;
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            for (com.iqoption.microservice.chat.g Re : iterable) {
                if (h.E(Re.Re(), this.aLO)) {
                    obj = 1;
                    break;
                }
            }
        }
        if (obj != null) {
            alT();
        }
    }

    private final void alT() {
        if (!this.cCW.get()) {
            this.cCW.set(true);
            s a = ag.a(com.iqoption.chat.repository.c.aJA.Qq(), (g) new e(this));
            ag.b(a, new b(this), new c(this));
            ag.a(a, (Runnable) new d(this));
        }
    }

    protected void onCleared() {
        super.onCleared();
        com.iqoption.chat.repository.c.aJA.b((com.iqoption.chat.repository.c.b) this);
        com.iqoption.chat.repository.b.aJu.b((com.iqoption.chat.repository.b.a) this);
    }
}
