package com.iqoption.tutorial;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Handler;
import android.support.annotation.MainThread;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentManager.OnBackStackChangedListener;
import com.google.common.util.concurrent.n;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.iqoption.dto.ToastEntity;
import com.iqoption.dto.entity.Feature;
import com.iqoption.tutorial.dictionary.TutorialAction;
import com.iqoption.tutorial.dictionary.TutorialTarget;
import com.iqoption.util.ag;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\r\b\u0007\u0018\u0000 =2\u00020\u0001:\u0001=B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001fJ\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\b\u0010#\u001a\u00020\bH\u0002J\u0014\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0%H\u0002J\u0012\u0010&\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001d\u001a\u00020\u0018H\u0002J\b\u0010'\u001a\u00020(H\u0002J\u000e\u0010)\u001a\u00020(2\u0006\u0010\u001d\u001a\u00020\u0018J\u0006\u0010*\u001a\u00020(J\b\u0010+\u001a\u00020\u001cH\u0002J\u0010\u0010,\u001a\u00020(2\u0006\u0010-\u001a\u00020\u000bH\u0002J\u000e\u0010.\u001a\u00020\u001c2\u0006\u0010/\u001a\u00020\u0010J\u0010\u00100\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020\u000bH\u0002J\u000e\u00101\u001a\u00020\u001c2\u0006\u0010/\u001a\u00020\u0010J\u0019\u00102\u001a\u00020\u001c2\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0002\u00104J\u0006\u00105\u001a\u00020(J\u001c\u00106\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u0015\u00107\u001a\u00020\u001c2\b\u00108\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u00104J\u001e\u00109\u001a\u00020(2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020<0;2\u0006\u0010\u001d\u001a\u00020\u0018H\u0002R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000¨\u0006>"}, aXE = {"Lcom/iqoption/tutorial/TutorialViewModel;", "Landroid/arch/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "actionsRepositories", "", "", "Lcom/iqoption/tutorial/TutorialActionsRepository;", "allStepsCache", "", "Lcom/iqoption/tutorial/dictionary/TutorialStep;", "backStackChangedListener", "com/iqoption/tutorial/TutorialViewModel$backStackChangedListener$1", "Lcom/iqoption/tutorial/TutorialViewModel$backStackChangedListener$1;", "currentObserver", "Lcom/iqoption/tutorial/TutorialObserver;", "dictionaryRepository", "Lcom/iqoption/tutorial/dictionary/TutorialDictionaryRepository;", "handler", "Landroid/os/Handler;", "nextStepRunnable", "Ljava/lang/Runnable;", "showingAction", "Lcom/iqoption/tutorial/dictionary/TutorialAction;", "toastToShow", "Lcom/iqoption/dto/ToastEntity;", "addPerformedAction", "", "action", "doneType", "Lcom/iqoption/tutorial/StepDoneType;", "filterAlreadyPerformed", "source", "filterByTargetAndAlreadyPerformed", "getActionsRepository", "getAllSteps", "Lcom/google/common/util/concurrent/ListenableFuture;", "getSubstituteAction", "hasObserver", "", "isActionPerformed", "isTutorialEnabled", "loadNextStep", "matchTarget", "step", "observeNextStep", "tutorialObserver", "performNextStep", "removeNextStepObserver", "scheduleNextStep", "stepTime", "(Ljava/lang/Long;)V", "scheduleNextStepIfAllowed", "skipNextStepsIfForbidden", "updateTimeAndScheduleNextStep", "nextTime", "wasPerformed", "performedActions", "", "", "Companion", "IqOption-5.5.1_optionXRelease"})
@MainThread
/* compiled from: TutorialViewModel.kt */
public final class TutorialViewModel extends AndroidViewModel {
    public static final a duq = new a();
    private final com.iqoption.tutorial.dictionary.a dui;
    private final Map<Long, b> duj = new LinkedHashMap();
    private List<com.iqoption.tutorial.dictionary.b> duk;
    private e dul;
    private TutorialAction dum;
    private ToastEntity dun;
    private final b duo = new b(this);
    private final Runnable dup = new e(this);
    private final Handler handler = new Handler();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, aXE = {"Lcom/iqoption/tutorial/TutorialViewModel$Companion;", "", "()V", "INITIAL_STEP_DELAY_MILLIS", "", "create", "Lcom/iqoption/tutorial/TutorialViewModel;", "activity", "Landroid/support/v4/app/FragmentActivity;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: TutorialViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final TutorialViewModel D(FragmentActivity fragmentActivity) {
            h.e(fragmentActivity, "activity");
            ViewModel h = ViewModelProviders.b(fragmentActivity).h(TutorialViewModel.class);
            h.d(h, "ViewModelProviders.of(ac…ialViewModel::class.java]");
            return (TutorialViewModel) h;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
    /* compiled from: TutorialViewModel.kt */
    static final class e implements Runnable {
        final /* synthetic */ TutorialViewModel dur;

        e(TutorialViewModel tutorialViewModel) {
            this.dur = tutorialViewModel;
        }

        public final void run() {
            e b = this.dur.dul;
            if (b == null) {
                h.aXZ();
            }
            if (b.aFt().AB()) {
                this.dur.aFA();
                return;
            }
            this.dur.aFz().D(null);
            b.getFragmentManager().addOnBackStackChangedListener(this.dur.duo);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, aXE = {"com/iqoption/tutorial/TutorialViewModel$backStackChangedListener$1", "Landroid/support/v4/app/FragmentManager$OnBackStackChangedListener;", "onBackStackChanged", "", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: TutorialViewModel.kt */
    public static final class b implements OnBackStackChangedListener {
        final /* synthetic */ TutorialViewModel dur;

        b(TutorialViewModel tutorialViewModel) {
            this.dur = tutorialViewModel;
        }

        public void onBackStackChanged() {
            if (this.dur.aFy()) {
                e b = this.dur.dul;
                if (b == null) {
                    h.aXZ();
                }
                b.getFragmentManager().removeOnBackStackChangedListener(this);
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¨\u0006\n"}, aXE = {"com/iqoption/tutorial/TutorialViewModel$getAllSteps$1", "Lcom/google/common/util/concurrent/FutureCallback;", "", "Lcom/iqoption/tutorial/dictionary/TutorialStep;", "onFailure", "", "throwable", "", "onSuccess", "result", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: TutorialViewModel.kt */
    public static final class c implements n<List<? extends com.iqoption.tutorial.dictionary.b>> {
        final /* synthetic */ TutorialViewModel dur;

        c(TutorialViewModel tutorialViewModel) {
            this.dur = tutorialViewModel;
        }

        /* renamed from: B */
        public void onSuccess(List<com.iqoption.tutorial.dictionary.b> list) {
            this.dur.duk = list;
        }

        public void l(Throwable th) {
            this.dur.duk = (List) null;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¨\u0006\n"}, aXE = {"com/iqoption/tutorial/TutorialViewModel$loadNextStep$1", "Lcom/google/common/util/concurrent/FutureCallback;", "", "Lcom/iqoption/tutorial/dictionary/TutorialStep;", "onFailure", "", "throwable", "", "onSuccess", "allSteps", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: TutorialViewModel.kt */
    public static final class d implements n<List<? extends com.iqoption.tutorial.dictionary.b>> {
        final /* synthetic */ TutorialViewModel dur;

        d(TutorialViewModel tutorialViewModel) {
            this.dur = tutorialViewModel;
        }

        /* JADX WARNING: Missing block: B:2:0x0008, code:
            if (r2 != null) goto L_0x000f;
     */
        /* renamed from: B */
        public void onSuccess(java.util.List<com.iqoption.tutorial.dictionary.b> r2) {
            /*
            r1 = this;
            if (r2 == 0) goto L_0x000b;
        L_0x0002:
            r0 = r1.dur;
            r2 = r0.bp(r2);
            if (r2 == 0) goto L_0x000b;
        L_0x000a:
            goto L_0x000f;
        L_0x000b:
            r2 = kotlin.collections.m.emptyList();
        L_0x000f:
            r0 = r1.dur;
            r2 = r0.br(r2);
            r0 = r2.isEmpty();
            if (r0 != 0) goto L_0x002e;
        L_0x001b:
            r0 = r1.dur;
            r0 = r0.aFC();
            if (r0 == 0) goto L_0x002e;
        L_0x0023:
            r0 = r1.dur;
            r2 = kotlin.collections.u.bU(r2);
            r2 = (com.iqoption.tutorial.dictionary.b) r2;
            r0.f(r2);
        L_0x002e:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iqoption.tutorial.TutorialViewModel.d.B(java.util.List):void");
        }

        public void l(Throwable th) {
            this.dur.duk = (List) null;
        }
    }

    public static final TutorialViewModel D(FragmentActivity fragmentActivity) {
        return duq.D(fragmentActivity);
    }

    public TutorialViewModel(Application application) {
        h.e(application, "application");
        super(application);
        this.dui = com.iqoption.tutorial.dictionary.a.duv.bP(application);
    }

    public final boolean aFx() {
        b aFz = aFz();
        Feature fd = com.iqoption.app.managers.feature.b.HT().fd("first-session");
        Object obj = fd != null ? fd.status : null;
        if (!h.E(obj, "enabled-with-depo") && (!h.E(obj, "enabled-no-depo") || aFz.aFj())) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null || !aFz.aFi()) {
            return false;
        }
        return true;
    }

    public final void a(e eVar) {
        h.e(eVar, "tutorialObserver");
        if (aFx()) {
            this.dul = eVar;
            h aFv = eVar.aFv();
            if (!(this.dun == null || aFv == null)) {
                ToastEntity toastEntity = this.dun;
                if (toastEntity == null) {
                    h.aXZ();
                }
                aFv.c(toastEntity);
                this.dun = (ToastEntity) null;
            }
            a(this, null, 1, null);
        }
    }

    public final void b(e eVar) {
        h.e(eVar, "tutorialObserver");
        if ((h.E(this.dul, eVar) ^ 1) == 0) {
            this.handler.removeCallbacks(this.dup);
            eVar = this.dul;
            if (eVar != null) {
                FragmentManager fragmentManager = eVar.getFragmentManager();
                if (fragmentManager != null) {
                    fragmentManager.removeOnBackStackChangedListener(this.duo);
                }
            }
            this.dul = (e) null;
            b aFz = aFz();
            Long aFl = aFz.aFl();
            if (aFl != null && aFl.longValue() == -1) {
                aFz.D(null);
            }
            TutorialAction tutorialAction = this.dum;
            if (tutorialAction != null) {
                aFz.b(tutorialAction);
            }
            this.dum = (TutorialAction) null;
        }
    }

    public final void E(Long l) {
        aFz().D(l);
        F(l);
    }

    public final boolean aFy() {
        if (aFz().aFl() == null) {
            e eVar = this.dul;
            if (eVar != null) {
                f aFt = eVar.aFt();
                if (aFt != null && aFt.AB()) {
                    a(this, null, 1, null);
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean c(TutorialAction tutorialAction) {
        h.e(tutorialAction, "action");
        return aFz().aFm().contains(tutorialAction.getValue());
    }

    public final void a(TutorialAction tutorialAction, StepDoneType stepDoneType) {
        h.e(tutorialAction, "action");
        h.e(stepDoneType, "doneType");
        b aFz = aFz();
        boolean b = aFz.b(tutorialAction);
        List list = this.duk;
        Object obj = stepDoneType == StepDoneType.TAP_ON_TARGET ? 1 : null;
        if (!l.dus.contains(tutorialAction) && ((obj == null || !l.dut.contains(tutorialAction)) && list != null && b && tutorialAction == this.dum)) {
            ToastType toastType;
            if (aFz.aFk() || obj == null) {
                toastType = (!bq(list).isEmpty() || stepDoneType == StepDoneType.ILLEGAL_STATE) ? null : ToastType.LAST_CLOSED;
            } else {
                aFz.fb(true);
                toastType = ToastType.FIRST_DONE;
            }
            if (toastType != null) {
                Application application = getApplication();
                h.d(application, "getApplication()");
                ToastEntity a = i.a(application, toastType);
                e eVar = this.dul;
                h aFv = eVar != null ? eVar.aFv() : null;
                if (aFv != null) {
                    aFv.c(a);
                } else {
                    this.dun = a;
                }
            }
        }
        this.dum = (TutorialAction) null;
    }

    private final b aFz() {
        Application application = getApplication();
        Context context = application;
        long userId = com.iqoption.app.a.aL(context).getUserId();
        if (!this.duj.containsKey(Long.valueOf(userId))) {
            Map map = this.duj;
            Long valueOf = Long.valueOf(userId);
            com.iqoption.tutorial.b.a aVar = b.dtS;
            h.d(application, "context");
            map.put(valueOf, aVar.d(context, userId));
        }
        Object obj = this.duj.get(Long.valueOf(userId));
        if (obj == null) {
            h.aXZ();
        }
        return (b) obj;
    }

    static /* synthetic */ void a(TutorialViewModel tutorialViewModel, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            l = tutorialViewModel.aFz().aFl();
        }
        tutorialViewModel.F(l);
    }

    private final void F(Long l) {
        this.handler.removeCallbacks(this.dup);
        long currentTimeMillis = System.currentTimeMillis();
        if (this.dul == null) {
            return;
        }
        if (l == null || l.longValue() != -1) {
            e eVar = this.dul;
            if (eVar == null) {
                h.aXZ();
            }
            if (eVar.aFw() && l == null && aFz().aFm().isEmpty()) {
                this.handler.postDelayed(this.dup, 5000);
                return;
            }
            eVar = this.dul;
            if (eVar == null) {
                h.aXZ();
            }
            if (!eVar.aFw() || l == null || l.longValue() <= currentTimeMillis) {
                this.handler.post(this.dup);
            } else {
                this.handler.postDelayed(this.dup, l.longValue() - currentTimeMillis);
            }
        }
    }

    private final void aFA() {
        ag.b(aFB(), new d(this));
    }

    private final s<List<com.iqoption.tutorial.dictionary.b>> aFB() {
        s<List<com.iqoption.tutorial.dictionary.b>> aFF;
        if (this.duk == null) {
            aFF = this.dui.aFF();
            ag.b(aFF, new c(this));
            return aFF;
        }
        aFF = o.aR(this.duk);
        h.d(aFF, "Futures.immediateFuture(allStepsCache)");
        return aFF;
    }

    private final List<com.iqoption.tutorial.dictionary.b> bp(List<com.iqoption.tutorial.dictionary.b> list) {
        Set aFm = aFz().aFm();
        Collection arrayList = new ArrayList();
        for (Object next : list) {
            com.iqoption.tutorial.dictionary.b bVar = (com.iqoption.tutorial.dictionary.b) next;
            Object obj = (!e(bVar) || a(aFm, bVar.aFI())) ? null : 1;
            if (obj != null) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }

    private final List<com.iqoption.tutorial.dictionary.b> bq(List<com.iqoption.tutorial.dictionary.b> list) {
        Set aFm = aFz().aFm();
        Collection arrayList = new ArrayList();
        for (Object next : list) {
            if ((a(aFm, ((com.iqoption.tutorial.dictionary.b) next).aFI()) ^ 1) != 0) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }

    private final List<com.iqoption.tutorial.dictionary.b> br(List<com.iqoption.tutorial.dictionary.b> list) {
        if (list.isEmpty()) {
            return list;
        }
        com.iqoption.app.a aL = com.iqoption.app.a.aL((Context) getApplication());
        h.d(aL, "IQAccount.getInstance(getApplication())");
        int i = 0;
        Object obj = aL.Cy() == 4 ? 1 : null;
        b aFz = aFz();
        int i2 = 0;
        for (com.iqoption.tutorial.dictionary.b aFI : list) {
            TutorialAction aFI2 = aFI.aFI();
            if (aFI2 != TutorialAction.PRACTICE_BALANCE || obj == null) {
                if ((aFI2 != TutorialAction.CALL_PUT && aFI2 != TutorialAction.CALL_PUT_ANOTHER_INSTRUMENT) || obj != null) {
                    i = i2;
                    break;
                }
                aFz.b(aFI2);
            } else {
                aFz.b(TutorialAction.PRACTICE_BALANCE);
            }
            i2++;
        }
        if (i != 0) {
            list = list.subList(i, list.size());
        }
        return list;
    }

    private final boolean e(com.iqoption.tutorial.dictionary.b bVar) {
        e eVar = this.dul;
        if (eVar != null) {
            g aFs = eVar.aFs();
            if (aFs != null) {
                TutorialTarget AA = aFs.AA();
                if (AA != null) {
                    List actions = AA.getActions();
                    if (actions != null && actions.contains(bVar.aFI())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private final boolean a(Set<String> set, TutorialAction tutorialAction) {
        TutorialAction d = d(tutorialAction);
        return set.contains(tutorialAction.getValue()) || (d != null && set.contains(d.getValue()));
    }

    private final TutorialAction d(TutorialAction tutorialAction) {
        if (k.aoS[tutorialAction.ordinal()] != 1) {
            return null;
        }
        return TutorialAction.CALL_PUT_ANOTHER_INSTRUMENT;
    }

    private final void f(com.iqoption.tutorial.dictionary.b bVar) {
        aFz().D(Long.valueOf(-1));
        this.dum = bVar.aFI();
        e eVar = this.dul;
        if (eVar == null) {
            h.aXZ();
        }
        eVar.aFu().c(bVar);
    }

    private final boolean aFC() {
        return this.dul != null;
    }
}
