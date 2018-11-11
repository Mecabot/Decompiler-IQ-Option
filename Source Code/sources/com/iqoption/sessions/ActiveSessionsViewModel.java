package com.iqoption.sessions;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Build.VERSION;
import android.support.v4.app.FragmentActivity;
import com.google.common.primitives.Longs;
import com.iqoption.mobbtech.connect.RequestManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bJ\b\u0010\u000e\u001a\u00020\u000fH\u0014J \u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0011H\u0002J \u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u0018R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u001a"}, aXE = {"Lcom/iqoption/sessions/ActiveSessionsViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "disposables", "", "Lio/reactivex/disposables/Disposable;", "sessionsDataSource", "Lcom/iqoption/core/microservices/auth/response/Session;", "getSessionsDataSource", "()Ljava/util/List;", "getActiveSessions", "Landroid/arch/lifecycle/LiveData;", "Lcom/iqoption/core/ui/Resource;", "Ljava/lang/Void;", "onCleared", "", "parseUserAgentString", "", "uaParser", "Lua_parser/Parser;", "platform", "", "ua", "terminateSessions", "", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: ActiveSessionsViewModel.kt */
public final class ActiveSessionsViewModel extends ViewModel {
    public static final a dqU = new a();
    private final List<io.reactivex.disposables.b> dqS = new ArrayList();
    private final List<com.iqoption.core.microservices.a.a.b> dqT = new ArrayList();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, aXE = {"Lcom/iqoption/sessions/ActiveSessionsViewModel$Companion;", "", "()V", "get", "Lcom/iqoption/sessions/ActiveSessionsViewModel;", "activity", "Landroid/support/v4/app/FragmentActivity;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ActiveSessionsViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final ActiveSessionsViewModel z(FragmentActivity fragmentActivity) {
            h.e(fragmentActivity, "activity");
            ViewModel h = ViewModelProviders.b(fragmentActivity).h(ActiveSessionsViewModel.class);
            h.d(h, "ViewModelProviders.of(ac…onsViewModel::class.java)");
            return (ActiveSessionsViewModel) h;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "Lcom/iqoption/core/microservices/auth/response/Session;", "sessionsResponse", "Lcom/iqoption/core/microservices/auth/response/SessionsResponse;", "apply"})
    /* compiled from: ActiveSessionsViewModel.kt */
    static final class b<T, R> implements io.reactivex.c.f<T, R> {
        final /* synthetic */ ActiveSessionsViewModel dqV;

        b(ActiveSessionsViewModel activeSessionsViewModel) {
            this.dqV = activeSessionsViewModel;
        }

        /* renamed from: a */
        public final List<com.iqoption.core.microservices.a.a.b> apply(com.iqoption.core.microservices.a.a.d dVar) {
            h.e(dVar, "sessionsResponse");
            List<com.iqoption.core.microservices.a.a.b> arrayList = new ArrayList();
            arrayList.addAll(dVar.Ut());
            if (VERSION.SDK_INT > 19) {
                try {
                    d.f fVar = new d.f();
                    for (com.iqoption.core.microservices.a.a.b bVar : arrayList) {
                        bVar.gw(this.dqV.a(fVar, bVar.Uq().Ur(), bVar.Uq().jx()));
                    }
                } catch (Throwable unused) {
                    for (com.iqoption.core.microservices.a.a.b gw : arrayList) {
                        gw.gw("");
                    }
                }
            } else {
                for (com.iqoption.core.microservices.a.a.b gw2 : arrayList) {
                    gw2.gw("");
                }
            }
            RequestManager atO = RequestManager.atO();
            h.d(atO, "RequestManager.getInstance()");
            final String atS = atO.atS();
            q.a(arrayList, new Comparator<com.iqoption.core.microservices.a.a.b>() {
                /* renamed from: a */
                public final int compare(com.iqoption.core.microservices.a.a.b bVar, com.iqoption.core.microservices.a.a.b bVar2) {
                    boolean E = h.E(atS, bVar.getId());
                    boolean E2 = h.E(atS, bVar2.getId());
                    if (E) {
                        return -1;
                    }
                    if (E2) {
                        return 1;
                    }
                    return -Longs.compare(bVar.Uq().ma(), bVar2.Uq().ma());
                }
            });
            return arrayList;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "", "it", "", "Lcom/iqoption/core/microservices/auth/response/Session;", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: ActiveSessionsViewModel.kt */
    static final class c<T> implements io.reactivex.c.e<List<com.iqoption.core.microservices.a.a.b>> {
        final /* synthetic */ MutableLiveData $liveData;
        final /* synthetic */ ActiveSessionsViewModel dqV;

        c(ActiveSessionsViewModel activeSessionsViewModel, MutableLiveData mutableLiveData) {
            this.dqV = activeSessionsViewModel;
            this.$liveData = mutableLiveData;
        }

        /* renamed from: C */
        public final void accept(List<com.iqoption.core.microservices.a.a.b> list) {
            this.dqV.aDO().clear();
            List aDO = this.dqV.aDO();
            h.d(list, "it");
            aDO.addAll(list);
            this.$liveData.postValue(com.iqoption.core.ui.c.a.a(com.iqoption.core.ui.c.baY, null, 1, null));
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: ActiveSessionsViewModel.kt */
    static final class d<T> implements io.reactivex.c.e<Throwable> {
        final /* synthetic */ MutableLiveData $liveData;

        d(MutableLiveData mutableLiveData) {
            this.$liveData = mutableLiveData;
        }

        /* renamed from: o */
        public final void accept(Throwable th) {
            this.$liveData.postValue(com.iqoption.core.ui.c.a.a(com.iqoption.core.ui.c.baY, th, th.getMessage(), null, 4, null));
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "", "it", "Lcom/iqoption/core/microservices/auth/response/SessionsResponse;", "apply"})
    /* compiled from: ActiveSessionsViewModel.kt */
    static final class e<T, R> implements io.reactivex.c.f<T, R> {
        public static final e dqX = new e();

        e() {
        }

        /* renamed from: a */
        public final List<String> apply(com.iqoption.core.microservices.a.a.d dVar) {
            h.e(dVar, "it");
            Iterable<com.iqoption.core.microservices.a.a.b> Ut = dVar.Ut();
            Collection arrayList = new ArrayList(n.e(Ut, 10));
            for (com.iqoption.core.microservices.a.a.b id : Ut) {
                arrayList.add(id.getId());
            }
            return (List) arrayList;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "", "sessions", "", "", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: ActiveSessionsViewModel.kt */
    static final class f<T> implements io.reactivex.c.e<List<? extends String>> {
        final /* synthetic */ MutableLiveData $liveData;
        final /* synthetic */ ActiveSessionsViewModel dqV;

        f(ActiveSessionsViewModel activeSessionsViewModel, MutableLiveData mutableLiveData) {
            this.dqV = activeSessionsViewModel;
            this.$liveData = mutableLiveData;
        }

        /* renamed from: C */
        public final void accept(List<String> list) {
            List aDO = this.dqV.aDO();
            Collection arrayList = new ArrayList();
            for (Object next : this.dqV.aDO()) {
                if (list.contains(((com.iqoption.core.microservices.a.a.b) next).getId())) {
                    arrayList.add(next);
                }
            }
            aDO.removeAll((List) arrayList);
            this.$liveData.postValue(com.iqoption.core.ui.c.a.a(com.iqoption.core.ui.c.baY, null, 1, null));
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: ActiveSessionsViewModel.kt */
    static final class g<T> implements io.reactivex.c.e<Throwable> {
        final /* synthetic */ MutableLiveData $liveData;

        g(MutableLiveData mutableLiveData) {
            this.$liveData = mutableLiveData;
        }

        /* renamed from: o */
        public final void accept(Throwable th) {
            this.$liveData.postValue(com.iqoption.core.ui.c.a.a(com.iqoption.core.ui.c.baY, th, th.getMessage(), null, 4, null));
        }
    }

    public final List<com.iqoption.core.microservices.a.a.b> aDO() {
        return this.dqT;
    }

    public final LiveData<com.iqoption.core.ui.c<Void>> aDP() {
        MutableLiveData mutableLiveData = new MutableLiveData();
        mutableLiveData.postValue(com.iqoption.core.ui.c.a.b(com.iqoption.core.ui.c.baY, null, 1, null));
        io.reactivex.disposables.b a = com.iqoption.core.microservices.a.a.aSK.Um().n(new b(this)).g(com.iqoption.core.h.i.Yp()).h(com.iqoption.core.h.i.Yo()).a((io.reactivex.c.e) new c(this, mutableLiveData), (io.reactivex.c.e) new d(mutableLiveData));
        List list = this.dqS;
        h.d(a, "disposable");
        list.add(a);
        return mutableLiveData;
    }

    public final LiveData<com.iqoption.core.ui.c<Void>> bk(List<com.iqoption.core.microservices.a.a.b> list) {
        h.e(list, "terminateSessions");
        Iterable<com.iqoption.core.microservices.a.a.b> iterable = list;
        Collection arrayList = new ArrayList(n.e(iterable, 10));
        for (com.iqoption.core.microservices.a.a.b id : iterable) {
            arrayList.add(id.getId());
        }
        List list2 = (List) arrayList;
        MutableLiveData mutableLiveData = new MutableLiveData();
        mutableLiveData.postValue(com.iqoption.core.ui.c.a.b(com.iqoption.core.ui.c.baY, null, 1, null));
        io.reactivex.disposables.b a = com.iqoption.core.microservices.a.a.aSK.al(list2).n(e.dqX).h(com.iqoption.core.h.i.Yo()).g(com.iqoption.core.h.i.Yp()).a((io.reactivex.c.e) new f(this, mutableLiveData), (io.reactivex.c.e) new g(mutableLiveData));
        List list3 = this.dqS;
        h.d(a, "disposable");
        list3.add(a);
        return mutableLiveData;
    }

    protected void onCleared() {
        for (io.reactivex.disposables.b dispose : this.dqS) {
            dispose.dispose();
        }
        this.dqS.clear();
        super.onCleared();
    }

    private final String a(d.f fVar, int i, String str) {
        d.a oh = fVar.oh(str);
        StringBuilder stringBuilder;
        if (i == 16 || i == 5 || i == 4 || i == 15) {
            if (oh.fkZ.fle == null || oh.fkZ.flf == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(oh.fkY.mk);
                stringBuilder.append(" ");
                stringBuilder.append(oh.fkY.fle);
                stringBuilder.append(".");
                stringBuilder.append(oh.fkY.flf);
                return stringBuilder.toString();
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(oh.fkY.mk);
            stringBuilder.append(" ");
            stringBuilder.append(oh.fkY.fle);
            stringBuilder.append(".");
            stringBuilder.append(oh.fkY.flf);
            stringBuilder.append(" (");
            stringBuilder.append(oh.fkZ.mk);
            stringBuilder.append(" ");
            stringBuilder.append(oh.fkZ.fle);
            stringBuilder.append(".");
            stringBuilder.append(oh.fkZ.flf);
            stringBuilder.append(")");
            return stringBuilder.toString();
        } else if (oh.fkZ.fle == null || oh.fkZ.flf == null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(oh.fla.mk);
            stringBuilder.append(" (");
            stringBuilder.append(oh.fkZ.mk);
            stringBuilder.append(")");
            return stringBuilder.toString();
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(oh.fla.mk);
            stringBuilder.append(" (");
            stringBuilder.append(oh.fkZ.mk);
            stringBuilder.append(" ");
            stringBuilder.append(oh.fkZ.fle);
            stringBuilder.append(".");
            stringBuilder.append(oh.fkZ.flf);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
    }
}
