package com.iqoption.chat.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import com.iqoption.chat.repository.c.c;
import com.iqoption.microservice.chat.n;
import com.iqoption.util.ag;
import com.iqoption.util.ag.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.d;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0003J$\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\b\u0010\u0010\u001a\u00020\rH\u0014J\u0016\u0010\u0011\u001a\u00020\r2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u0006\u0010\u0012\u001a\u00020\rJ\u0006\u0010\u0013\u001a\u00020\rR\u001d\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, aXE = {"Lcom/iqoption/chat/viewmodel/RoomsViewModel;", "Landroid/arch/lifecycle/ViewModel;", "Lcom/iqoption/chat/repository/RoomRepository$RoomListener;", "()V", "chatRooms", "Landroid/arch/lifecycle/LiveData;", "", "Lcom/iqoption/microservice/chat/ChatRoom;", "getChatRooms", "()Landroid/arch/lifecycle/LiveData;", "chatRoomsData", "Landroid/arch/lifecycle/MutableLiveData;", "merge", "", "initial", "portion", "onCleared", "onRoomEvent", "subscribeForChanges", "unsubscribeForChanges", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: RoomsViewModel.kt */
public final class RoomsViewModel extends ViewModel implements c {
    private static final String TAG = "RoomsViewModel";
    private static final d aKb = g.f(RoomsViewModel$Companion$instance$2.aLD);
    public static final a aLC = new a();
    private final MutableLiveData<List<n>> aLA;
    private final LiveData<List<n>> aLB = this.aLA;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, aXE = {"Lcom/iqoption/chat/viewmodel/RoomsViewModel$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "instance", "Lcom/iqoption/chat/viewmodel/RoomsViewModel;", "getInstance", "()Lcom/iqoption/chat/viewmodel/RoomsViewModel;", "instance$delegate", "Lkotlin/Lazy;", "get", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: RoomsViewModel.kt */
    public static final class a {
        static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "instance", "getInstance()Lcom/iqoption/chat/viewmodel/RoomsViewModel;"))};

        private final RoomsViewModel Rr() {
            d QF = RoomsViewModel.aKb;
            j jVar = apP[0];
            return (RoomsViewModel) QF.getValue();
        }

        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final RoomsViewModel Rs() {
            return Rr();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "", "Lcom/iqoption/microservice/chat/ChatRoom;", "call"})
    /* compiled from: RoomsViewModel.kt */
    static final class b<T> implements e<V> {
        final /* synthetic */ MutableLiveData receiver$0;

        b(MutableLiveData mutableLiveData) {
            this.receiver$0 = mutableLiveData;
        }

        /* renamed from: Y */
        public final void aU(List<n> list) {
            h.e(list, "it");
            this.receiver$0.postValue(list);
        }
    }

    public RoomsViewModel() {
        com.iqoption.chat.repository.c.aJA.a((c) this);
        MutableLiveData mutableLiveData = new MutableLiveData();
        ag.a(com.iqoption.chat.repository.c.aJA.Qq(), (e) new b(mutableLiveData));
        this.aLA = mutableLiveData;
    }

    static {
        h.d(RoomsViewModel.class.getSimpleName(), "RoomsViewModel::class.java.simpleName");
    }

    public final LiveData<List<n>> Ro() {
        return this.aLB;
    }

    public void S(List<n> list) {
        h.e(list, "chatRooms");
        List list2 = (List) this.aLA.getValue();
        if (list2 != null) {
            d(list2, list);
        }
    }

    private final void d(List<n> list, List<n> list2) {
        Iterable iterable = list2;
        Collection arrayList = new ArrayList();
        for (Object next : iterable) {
            if (((n) next).aru()) {
                arrayList.add(next);
            }
        }
        List list3 = (List) arrayList;
        Iterable iterable2 = list3;
        Collection arrayList2 = new ArrayList();
        for (Object next2 : u.e(iterable, iterable2)) {
            if (!list.contains((n) next2)) {
                arrayList2.add(next2);
            }
        }
        Iterable iterable3 = (List) arrayList2;
        List e = u.e((Iterable) u.e(iterable, iterable3), iterable2);
        Collection arrayList3 = new ArrayList();
        for (Object next3 : list) {
            if (list3.contains((n) next3)) {
                arrayList3.add(next3);
            }
        }
        Iterable<Object> b = u.b((Collection) (List) arrayList3, iterable3);
        arrayList = new ArrayList(n.e(b, 10));
        for (Object obj : b) {
            Object obj2;
            for (Object next4 : e) {
                if (h.E(((n) next4).getId(), obj2.getId())) {
                    break;
                }
            }
            Object next42 = null;
            n nVar = (n) next42;
            if (nVar != null) {
                obj2 = nVar;
            }
            arrayList.add(obj2);
        }
        list3 = (List) arrayList;
    }

    protected void onCleared() {
        super.onCleared();
        com.iqoption.chat.repository.c.aJA.b((c) this);
        Rq();
    }

    public final void Rp() {
        com.iqoption.microservice.chat.d.cPG.a((com.iqoption.microservice.chat.d.e) com.iqoption.chat.repository.c.aJA);
    }

    public final void Rq() {
        com.iqoption.microservice.chat.d.cPG.b((com.iqoption.microservice.chat.d.e) com.iqoption.chat.repository.c.aJA);
    }
}
