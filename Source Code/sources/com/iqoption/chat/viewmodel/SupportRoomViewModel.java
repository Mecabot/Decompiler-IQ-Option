package com.iqoption.chat.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import com.google.common.util.concurrent.s;
import com.iqoption.microservice.chat.g;
import com.iqoption.util.ag;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u0017\u001a\u00020\u0018J\b\u0010\u0019\u001a\u00020\u0018H\u0014J\u0016\u0010\u001a\u001a\u00020\u00182\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0016R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0006R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\tX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, aXE = {"Lcom/iqoption/chat/viewmodel/SupportRoomViewModel;", "Landroid/arch/lifecycle/ViewModel;", "Lcom/iqoption/chat/repository/MessageRepository$MessageListener;", "()V", "isSupportAvatarLoading", "", "()Z", "supportAvatar", "Landroid/arch/lifecycle/LiveData;", "", "getSupportAvatar", "()Landroid/arch/lifecycle/LiveData;", "supportAvatarData", "Landroid/arch/lifecycle/MutableLiveData;", "supportAvatarLoading", "Ljava/util/concurrent/atomic/AtomicBoolean;", "supportRoomId", "getSupportRoomId", "()Ljava/lang/String;", "setSupportRoomId", "(Ljava/lang/String;)V", "userId", "", "loadSupportAvatar", "", "onCleared", "onMessageEvent", "messages", "", "Lcom/iqoption/microservice/chat/ChatMessage;", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: SupportRoomViewModel.kt */
public final class SupportRoomViewModel extends ViewModel implements com.iqoption.chat.repository.b.a {
    private static final String TAG = "SupportRoomViewModel";
    private static final kotlin.d aKb = g.f(SupportRoomViewModel$Companion$instance$2.aLS);
    public static final a aLR = new a();
    public String aLO;
    private final MutableLiveData<String> aLP = new MutableLiveData();
    private final AtomicBoolean aLQ = new AtomicBoolean();
    private final long userId = com.iqoption.app.a.Cw().getUserId();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0019\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, aXE = {"Lcom/iqoption/chat/viewmodel/SupportRoomViewModel$Companion;", "", "()V", "NO_AVATAR", "", "TAG", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "instance", "Lcom/iqoption/chat/viewmodel/SupportRoomViewModel;", "getInstance", "()Lcom/iqoption/chat/viewmodel/SupportRoomViewModel;", "instance$delegate", "Lkotlin/Lazy;", "get", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: SupportRoomViewModel.kt */
    public static final class a {
        static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "instance", "getInstance()Lcom/iqoption/chat/viewmodel/SupportRoomViewModel;"))};

        private final SupportRoomViewModel RC() {
            kotlin.d QF = SupportRoomViewModel.aKb;
            j jVar = apP[0];
            return (SupportRoomViewModel) QF.getValue();
        }

        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final SupportRoomViewModel RD() {
            return RC();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
    /* compiled from: SupportRoomViewModel.kt */
    static final class d implements Runnable {
        final /* synthetic */ SupportRoomViewModel aLT;

        d(SupportRoomViewModel supportRoomViewModel) {
            this.aLT = supportRoomViewModel;
        }

        public final void run() {
            this.aLT.aLQ.set(false);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "", "call"})
    /* compiled from: SupportRoomViewModel.kt */
    static final class b<T> implements com.iqoption.util.ag.e<V> {
        final /* synthetic */ SupportRoomViewModel aLT;

        b(SupportRoomViewModel supportRoomViewModel) {
            this.aLT = supportRoomViewModel;
        }

        /* renamed from: fY */
        public final void aU(String str) {
            h.e(str, "it");
            this.aLT.aLP.postValue(str);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "", "call"})
    /* compiled from: SupportRoomViewModel.kt */
    static final class c implements com.iqoption.util.ag.a {
        final /* synthetic */ SupportRoomViewModel aLT;

        c(SupportRoomViewModel supportRoomViewModel) {
            this.aLT = supportRoomViewModel;
        }

        public final void n(Throwable th) {
            h.e(th, "it");
            this.aLT.aLP.postValue("no_avatar");
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "", "Lcom/iqoption/microservice/chat/ChatMessage;", "apply"})
    /* compiled from: SupportRoomViewModel.kt */
    static final class e<F, T> implements com.google.common.base.d<I, O> {
        final /* synthetic */ SupportRoomViewModel aLT;

        e(SupportRoomViewModel supportRoomViewModel) {
            this.aLT = supportRoomViewModel;
        }

        /* JADX WARNING: Removed duplicated region for block: B:24:0x004d  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0051  */
        /* JADX WARNING: Removed duplicated region for block: B:32:? A:{SYNTHETIC, RETURN} */
        /* renamed from: ae */
        public final java.lang.String apply(java.util.List<com.iqoption.microservice.chat.g> r11) {
            /*
            r10 = this;
            r0 = 0;
            r1 = 0;
            r2 = 1;
            if (r11 == 0) goto L_0x003c;
        L_0x0005:
            r11 = (java.lang.Iterable) r11;
            r11 = r11.iterator();
        L_0x000b:
            r3 = r11.hasNext();
            if (r3 == 0) goto L_0x0032;
        L_0x0011:
            r3 = r11.next();
            r4 = r3;
            r4 = (com.iqoption.microservice.chat.g) r4;
            r5 = r4.aro();
            r7 = r10.aLT;
            r7 = r7.userId;
            r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));
            if (r9 == 0) goto L_0x002e;
        L_0x0026:
            r4 = r4.art();
            if (r4 != 0) goto L_0x002e;
        L_0x002c:
            r4 = 1;
            goto L_0x002f;
        L_0x002e:
            r4 = 0;
        L_0x002f:
            if (r4 == 0) goto L_0x000b;
        L_0x0031:
            goto L_0x0033;
        L_0x0032:
            r3 = r1;
        L_0x0033:
            r3 = (com.iqoption.microservice.chat.g) r3;
            if (r3 == 0) goto L_0x003c;
        L_0x0037:
            r11 = r3.arr();
            goto L_0x003d;
        L_0x003c:
            r11 = r1;
        L_0x003d:
            r3 = r11;
            r3 = (java.lang.CharSequence) r3;
            if (r3 == 0) goto L_0x0048;
        L_0x0042:
            r3 = r3.length();
            if (r3 != 0) goto L_0x0049;
        L_0x0048:
            r0 = 1;
        L_0x0049:
            r0 = r0 ^ r2;
            if (r0 == 0) goto L_0x004d;
        L_0x004c:
            goto L_0x004e;
        L_0x004d:
            r11 = r1;
        L_0x004e:
            if (r11 == 0) goto L_0x0051;
        L_0x0050:
            goto L_0x0053;
        L_0x0051:
            r11 = "no_avatar";
        L_0x0053:
            return r11;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iqoption.chat.viewmodel.SupportRoomViewModel.e.ae(java.util.List):java.lang.String");
        }
    }

    public SupportRoomViewModel() {
        com.iqoption.chat.repository.b.aJu.a((com.iqoption.chat.repository.b.a) this);
    }

    public final void fX(String str) {
        h.e(str, "<set-?>");
        this.aLO = str;
    }

    public final LiveData<String> Rz() {
        return this.aLP;
    }

    public final boolean RA() {
        return this.aLQ.get();
    }

    public void R(List<g> list) {
        h.e(list, "messages");
        for (Object next : list) {
            String Re = ((g) next).Re();
            String str = this.aLO;
            if (str == null) {
                h.lS("supportRoomId");
            }
            if (h.E(Re, str)) {
                break;
            }
        }
        Object next2 = null;
        g gVar = (g) next2;
        if (gVar != null && (h.E(gVar.arr(), (String) this.aLP.getValue()) ^ 1) != 0) {
            RB();
        }
    }

    public final void RB() {
        if (!this.aLQ.get()) {
            this.aLQ.set(true);
            com.iqoption.chat.repository.b bVar = com.iqoption.chat.repository.b.aJu;
            String str = this.aLO;
            if (str == null) {
                h.lS("supportRoomId");
            }
            s a = ag.a(com.iqoption.chat.repository.b.a(bVar, str, 0, 10, 2, null), (com.google.common.base.d) new e(this));
            ag.b(a, new b(this), new c(this));
            ag.a(a, (Runnable) new d(this));
        }
    }

    protected void onCleared() {
        super.onCleared();
        com.iqoption.chat.repository.b.aJu.b((com.iqoption.chat.repository.b.a) this);
    }
}
