package com.iqoption.quiz.model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import com.iqoption.quiz.api.response.StatType;
import com.iqoption.quiz.api.response.j;
import com.iqoption.quiz.m;
import io.reactivex.k;
import io.reactivex.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;

@kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 #2\u00020\u0001:\u0001#B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00072\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\rH\u0002J\b\u0010 \u001a\u00020!H\u0014J\u000e\u0010\"\u001a\u00020!2\u0006\u0010\u001d\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bX\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0011X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n \u0014*\u0004\u0018\u00010\u00130\u0013X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n \u0014*\u0004\u0018\u00010\u00160\u0016X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\tR\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, aXE = {"Lcom/iqoption/quiz/model/LeaderBoardViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "disposable", "Lio/reactivex/disposables/CompositeDisposable;", "filter", "Landroid/arch/lifecycle/LiveData;", "Lcom/iqoption/quiz/model/LeaderBoardFilter;", "getFilter", "()Landroid/arch/lifecycle/LiveData;", "filterData", "Landroid/arch/lifecycle/MutableLiveData;", "leaders", "", "Lcom/iqoption/quiz/model/QuizLeaderBoardAdapterItem;", "getLeaders", "leadersData", "Lcom/iqoption/core/data/livedata/IQMutableLiveData;", "prefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "quizApi", "Lcom/iqoption/quiz/api/TriviaApi;", "youItem", "Lcom/iqoption/quiz/model/QuizLeaderBoardItem;", "getYouItem", "youItemData", "isFirstPlacesEqual", "", "newFilter", "it", "Lcom/iqoption/quiz/api/response/StatResponse;", "onCleared", "", "setFilter", "Companion", "quiz_release"})
/* compiled from: LeaderBoardViewModel.kt */
public final class LeaderBoardViewModel extends ViewModel {
    private static final String TAG = "LeaderBoardViewModel";
    public static final a dlq = new a();
    private final io.reactivex.disposables.a bco = new io.reactivex.disposables.a();
    private final com.iqoption.quiz.api.b dli = m.ayY().azi();
    private final SharedPreferences dlj = m.ayY().azk();
    private final MutableLiveData<LeaderBoardFilter> dlk = new MutableLiveData();
    private final LiveData<LeaderBoardFilter> dll = this.dlk;
    private final com.iqoption.core.data.b.c<List<j>> dlm = new com.iqoption.core.data.b.c(m.emptyList());
    private final LiveData<List<j>> dln = this.dlm;
    private final MutableLiveData<l> dlo = new MutableLiveData();
    private final LiveData<l> dlp = this.dlo;

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, aXE = {"Lcom/iqoption/quiz/model/LeaderBoardViewModel$Companion;", "", "()V", "PREF_QUIZ_LEADER_BOARD_FILTER", "", "TAG", "kotlin.jvm.PlatformType", "create", "Lcom/iqoption/quiz/model/LeaderBoardViewModel;", "f", "Landroid/support/v4/app/Fragment;", "quiz_release"})
    /* compiled from: LeaderBoardViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final LeaderBoardViewModel W(Fragment fragment) {
            kotlin.jvm.internal.h.e(fragment, "f");
            ViewModel h = ViewModelProviders.d(fragment).h(LeaderBoardViewModel.class);
            kotlin.jvm.internal.h.d(h, "ViewModelProviders.of(f)…ardViewModel::class.java)");
            return (LeaderBoardViewModel) h;
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012(\u0010\u0003\u001a$\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005 \u0006*\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00010\u0004H\n¢\u0006\u0002\b\u0007"}, aXE = {"<anonymous>", "", "Lcom/iqoption/quiz/model/QuizLeaderBoardItem;", "it", "", "Lcom/iqoption/quiz/api/response/StatResponse;", "kotlin.jvm.PlatformType", "apply"})
    /* compiled from: LeaderBoardViewModel.kt */
    static final class b<T, R> implements io.reactivex.c.f<T, R> {
        final /* synthetic */ LeaderBoardViewModel dlr;
        final /* synthetic */ LeaderBoardFilter dls;

        b(LeaderBoardViewModel leaderBoardViewModel, LeaderBoardFilter leaderBoardFilter) {
            this.dlr = leaderBoardViewModel;
            this.dls = leaderBoardFilter;
        }

        /* renamed from: m */
        public final List<l> apply(List<j> list) {
            kotlin.jvm.internal.h.e(list, "it");
            boolean a = this.dlr.a(this.dls, list);
            Iterable<j> iterable = list;
            Collection arrayList = new ArrayList(n.e(iterable, 10));
            for (j jVar : iterable) {
                kotlin.jvm.internal.h.d(jVar, "it");
                arrayList.add(new l(jVar, a ^ 1));
            }
            return (List) arrayList;
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "", "it", "", "Lcom/iqoption/quiz/model/QuizLeaderBoardItem;", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: LeaderBoardViewModel.kt */
    static final class c<T> implements io.reactivex.c.e<List<? extends l>> {
        final /* synthetic */ LeaderBoardViewModel dlr;

        c(LeaderBoardViewModel leaderBoardViewModel) {
            this.dlr = leaderBoardViewModel;
        }

        /* renamed from: C */
        public final void accept(List<l> list) {
            com.iqoption.core.data.b.c a = this.dlr.dlm;
            kotlin.jvm.internal.h.d(list, "it");
            a.setValue(list);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: LeaderBoardViewModel.kt */
    static final class d<T> implements io.reactivex.c.e<Throwable> {
        final /* synthetic */ LeaderBoardViewModel dlr;
        final /* synthetic */ LeaderBoardFilter dls;

        d(LeaderBoardViewModel leaderBoardViewModel, LeaderBoardFilter leaderBoardFilter) {
            this.dlr = leaderBoardViewModel;
            this.dls = leaderBoardFilter;
        }

        /* renamed from: o */
        public final void accept(Throwable th) {
            String Ki = LeaderBoardViewModel.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Could not load leaders by filter: ");
            stringBuilder.append(this.dls);
            com.iqoption.core.i.w(Ki, stringBuilder.toString(), th);
            this.dlr.dlm.setValue(l.cr(k.dlR));
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010 \n\u0000\u0010\u0000\u001aV\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004 \u0005*\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00020\u0002 \u0005**\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004 \u0005*\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012(\u0010\u0006\u001a$\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00030\u0003 \u0005*\u0010\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00030\u00030\b0\u0007H\n¢\u0006\u0002\b\t"}, aXE = {"<anonymous>", "Lio/reactivex/Maybe;", "Lkotlin/Pair;", "Lcom/iqoption/quiz/api/response/StatResponse;", "", "kotlin.jvm.PlatformType", "it", "", "", "apply"})
    /* compiled from: LeaderBoardViewModel.kt */
    static final class e<T, R> implements io.reactivex.c.f<T, k<? extends R>> {
        final /* synthetic */ LeaderBoardViewModel dlr;
        final /* synthetic */ LeaderBoardFilter dls;

        e(LeaderBoardViewModel leaderBoardViewModel, LeaderBoardFilter leaderBoardFilter) {
            this.dlr = leaderBoardViewModel;
            this.dls = leaderBoardFilter;
        }

        /* renamed from: aZ */
        public final io.reactivex.i<Pair<j, Boolean>> apply(List<j> list) {
            kotlin.jvm.internal.h.e(list, "it");
            for (Object next : list) {
                Object obj;
                if (((j) next).aAt().getId() == com.iqoption.core.f.RQ().Dr().getUserId()) {
                    obj = 1;
                    continue;
                } else {
                    obj = null;
                    continue;
                }
                if (obj != null) {
                    break;
                }
            }
            Object next2 = null;
            j jVar = (j) next2;
            if (jVar != null) {
                return io.reactivex.i.bZ(kotlin.j.D(jVar, Boolean.valueOf(this.dlr.a(this.dls, list))));
            }
            return io.reactivex.i.aWe();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "Lcom/iqoption/quiz/model/QuizLeaderBoardItem;", "<name for destructuring parameter 0>", "Lkotlin/Pair;", "Lcom/iqoption/quiz/api/response/StatResponse;", "", "apply"})
    /* compiled from: LeaderBoardViewModel.kt */
    static final class f<T, R> implements io.reactivex.c.f<T, R> {
        public static final f dlt = new f();

        f() {
        }

        /* renamed from: b */
        public final l apply(Pair<j, Boolean> pair) {
            kotlin.jvm.internal.h.e(pair, "<name for destructuring parameter 0>");
            return new l((j) pair.aXG(), ((Boolean) pair.aXH()).booleanValue() ^ 1);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/quiz/model/QuizLeaderBoardItem;", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: LeaderBoardViewModel.kt */
    static final class g<T> implements io.reactivex.c.e<l> {
        final /* synthetic */ LeaderBoardViewModel dlr;

        g(LeaderBoardViewModel leaderBoardViewModel) {
            this.dlr = leaderBoardViewModel;
        }

        /* renamed from: d */
        public final void accept(l lVar) {
            this.dlr.dlo.setValue(lVar);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: LeaderBoardViewModel.kt */
    static final class h<T> implements io.reactivex.c.e<Throwable> {
        final /* synthetic */ LeaderBoardFilter dls;

        h(LeaderBoardFilter leaderBoardFilter) {
            this.dls = leaderBoardFilter;
        }

        /* renamed from: o */
        public final void accept(Throwable th) {
            String Ki = LeaderBoardViewModel.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Could not load you by filter: ");
            stringBuilder.append(this.dls);
            com.iqoption.core.i.w(Ki, stringBuilder.toString(), th);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
    /* compiled from: LeaderBoardViewModel.kt */
    static final class i implements io.reactivex.c.a {
        final /* synthetic */ LeaderBoardViewModel dlr;

        i(LeaderBoardViewModel leaderBoardViewModel) {
            this.dlr = leaderBoardViewModel;
        }

        public final void run() {
            this.dlr.dlo.setValue(null);
        }
    }

    public LeaderBoardViewModel() {
        LeaderBoardFilter leaderBoardFilter;
        SharedPreferences sharedPreferences = this.dlj;
        try {
            leaderBoardFilter = LeaderBoardFilter.values()[this.dlj.getInt("PREF_QUIZ_LEADER_BOARD_FILTER", 0)];
        } catch (Exception unused) {
            leaderBoardFilter = LeaderBoardFilter.ALL;
        }
        d(leaderBoardFilter);
    }

    public final LiveData<LeaderBoardFilter> aBl() {
        return this.dll;
    }

    public final LiveData<List<j>> aBm() {
        return this.dln;
    }

    public final LiveData<l> aBn() {
        return this.dlp;
    }

    public final void d(LeaderBoardFilter leaderBoardFilter) {
        kotlin.jvm.internal.h.e(leaderBoardFilter, "newFilter");
        if (((LeaderBoardFilter) this.dll.getValue()) != leaderBoardFilter) {
            StatType statType;
            this.bco.clear();
            this.dlk.setValue(leaderBoardFilter);
            this.dlm.setValue(l.cr(m.dlY));
            com.iqoption.quiz.api.b bVar = this.dli;
            switch (leaderBoardFilter) {
                case LAST_GAME:
                    statType = StatType.GAME;
                    break;
                case ALL:
                    statType = StatType.TOTAL;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            o a = bVar.a(statType);
            this.bco.e(a.n(new b(this, leaderBoardFilter)).h(com.iqoption.core.h.i.Yo()).g(com.iqoption.core.h.i.Yp()).a((io.reactivex.c.e) new c(this), (io.reactivex.c.e) new d(this, leaderBoardFilter)));
            this.bco.e(a.aWl().h(new e(this, leaderBoardFilter)).j(f.dlt).f(com.iqoption.core.h.i.Yo()).e(com.iqoption.core.h.i.Yp()).a(new g(this), new h(leaderBoardFilter), new i(this)));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:? A:{SYNTHETIC, RETURN} */
    private final boolean a(com.iqoption.quiz.model.LeaderBoardFilter r5, java.util.List<com.iqoption.quiz.api.response.j> r6) {
        /*
        r4 = this;
        r0 = com.iqoption.quiz.model.LeaderBoardFilter.LAST_GAME;
        r1 = 1;
        r2 = 0;
        if (r5 != r0) goto L_0x0066;
    L_0x0006:
        r5 = r6.size();
        r0 = 2;
        if (r5 >= r0) goto L_0x000f;
    L_0x000d:
        r5 = 0;
        goto L_0x0063;
    L_0x000f:
        r5 = r6.size();
        if (r5 != r0) goto L_0x002e;
    L_0x0015:
        r5 = r6.get(r2);
        r5 = (com.iqoption.quiz.api.response.j) r5;
        r5 = r5.VZ();
        r6 = r6.get(r1);
        r6 = (com.iqoption.quiz.api.response.j) r6;
        r6 = r6.VZ();
        r5 = kotlin.jvm.internal.h.E(r5, r6);
        goto L_0x0063;
    L_0x002e:
        r5 = r6.get(r2);
        r5 = (com.iqoption.quiz.api.response.j) r5;
        r5 = r5.VZ();
        r3 = r6.get(r1);
        r3 = (com.iqoption.quiz.api.response.j) r3;
        r3 = r3.VZ();
        r5 = kotlin.jvm.internal.h.E(r5, r3);
        if (r5 != 0) goto L_0x0062;
    L_0x0048:
        r5 = r6.get(r1);
        r5 = (com.iqoption.quiz.api.response.j) r5;
        r5 = r5.VZ();
        r6 = r6.get(r0);
        r6 = (com.iqoption.quiz.api.response.j) r6;
        r6 = r6.VZ();
        r5 = kotlin.jvm.internal.h.E(r5, r6);
        if (r5 == 0) goto L_0x000d;
    L_0x0062:
        r5 = 1;
    L_0x0063:
        if (r5 == 0) goto L_0x0066;
    L_0x0065:
        goto L_0x0067;
    L_0x0066:
        r1 = 0;
    L_0x0067:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.quiz.model.LeaderBoardViewModel.a(com.iqoption.quiz.model.LeaderBoardFilter, java.util.List):boolean");
    }

    protected void onCleared() {
        super.onCleared();
        this.bco.clear();
    }
}
