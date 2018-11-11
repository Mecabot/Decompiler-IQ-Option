package com.iqoption.signals;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.MainThread;
import android.support.v4.app.FragmentActivity;
import com.google.common.collect.ImmutableList;
import io.reactivex.BackpressureStrategy;
import io.reactivex.f;
import io.reactivex.g;
import io.reactivex.processors.PublishProcessor;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.NoWhenBranchMatchedException;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0017H\u0007J\u0010\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u000eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00068F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\tR\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0015X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, aXE = {"Lcom/iqoption/signals/SignalsViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "newSignals", "Landroid/arch/lifecycle/LiveData;", "Lcom/iqoption/signals/SignalItem;", "getNewSignals", "()Landroid/arch/lifecycle/LiveData;", "newSignalsData", "Landroid/arch/lifecycle/MutableLiveData;", "signalFilterProcessor", "Lio/reactivex/processors/PublishProcessor;", "Lcom/iqoption/signals/SignalFilter;", "kotlin.jvm.PlatformType", "state", "Lcom/iqoption/signals/SignalsViewState;", "getState", "stateData", "viewStateStream", "Lio/reactivex/Flowable;", "onCleared", "", "reload", "setFilter", "filter", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: SignalsViewModel.kt */
public final class SignalsViewModel extends ViewModel {
    private static final String TAG = "com.iqoption.signals.SignalsViewModel";
    public static final c dry = new c();
    private final io.reactivex.disposables.a asp = new io.reactivex.disposables.a();
    private final MutableLiveData<l> azM;
    private final MutableLiveData<c> drv = new MutableLiveData();
    private final io.reactivex.e<l> drw;
    private final PublishProcessor<SignalFilter> drx = PublishProcessor.aXq();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, aXE = {"Lcom/iqoption/signals/SignalsViewModel$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "get", "Lcom/iqoption/signals/SignalsViewModel;", "f", "Landroid/support/v4/app/Fragment;", "activity", "Landroid/support/v4/app/FragmentActivity;", "Action", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: SignalsViewModel.kt */
    public static final class c {

        @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, aXE = {"Lcom/iqoption/signals/SignalsViewModel$Companion$Action;", "", "()V", "SignalGenerated", "SignalsReloaded", "Lcom/iqoption/signals/SignalsViewModel$Companion$Action$SignalsReloaded;", "Lcom/iqoption/signals/SignalsViewModel$Companion$Action$SignalGenerated;", "IqOption-5.5.1_optionXRelease"})
        /* compiled from: SignalsViewModel.kt */
        private static abstract class a {

            @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, aXE = {"Lcom/iqoption/signals/SignalsViewModel$Companion$Action$SignalGenerated;", "Lcom/iqoption/signals/SignalsViewModel$Companion$Action;", "signal", "Lcom/iqoption/core/microservices/pricemovements/response/Signal;", "(Lcom/iqoption/core/microservices/pricemovements/response/Signal;)V", "getSignal", "()Lcom/iqoption/core/microservices/pricemovements/response/Signal;", "IqOption-5.5.1_optionXRelease"})
            /* compiled from: SignalsViewModel.kt */
            public static final class a extends a {
                private final com.iqoption.core.microservices.pricemovements.a.a drd;

                public a(com.iqoption.core.microservices.pricemovements.a.a aVar) {
                    h.e(aVar, "signal");
                    super();
                    this.drd = aVar;
                }

                public final com.iqoption.core.microservices.pricemovements.a.a aEa() {
                    return this.drd;
                }
            }

            @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, aXE = {"Lcom/iqoption/signals/SignalsViewModel$Companion$Action$SignalsReloaded;", "Lcom/iqoption/signals/SignalsViewModel$Companion$Action;", "filter", "Lcom/iqoption/signals/SignalFilter;", "signals", "", "Lcom/iqoption/core/microservices/pricemovements/response/Signal;", "(Lcom/iqoption/signals/SignalFilter;Ljava/util/List;)V", "getFilter", "()Lcom/iqoption/signals/SignalFilter;", "getSignals", "()Ljava/util/List;", "IqOption-5.5.1_optionXRelease"})
            /* compiled from: SignalsViewModel.kt */
            public static final class b extends a {
                private final SignalFilter drH;
                private final List<com.iqoption.core.microservices.pricemovements.a.a> drI;

                public b(SignalFilter signalFilter, List<com.iqoption.core.microservices.pricemovements.a.a> list) {
                    h.e(signalFilter, "filter");
                    h.e(list, "signals");
                    super();
                    this.drH = signalFilter;
                    this.drI = list;
                }

                public final SignalFilter aEg() {
                    return this.drH;
                }

                public final List<com.iqoption.core.microservices.pricemovements.a.a> aEh() {
                    return this.drI;
                }
            }

            private a() {
            }

            public /* synthetic */ a(f fVar) {
                this();
            }
        }

        private c() {
        }

        public /* synthetic */ c(f fVar) {
            this();
        }

        public final SignalsViewModel A(FragmentActivity fragmentActivity) {
            h.e(fragmentActivity, "activity");
            return (SignalsViewModel) ViewModelProviders.b(fragmentActivity).h(SignalsViewModel.class);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
    /* compiled from: SignalsViewModel.kt */
    static final class d implements Runnable {
        final /* synthetic */ SignalsViewModel drz;

        d(SignalsViewModel signalsViewModel) {
            this.drz = signalsViewModel;
        }

        /* JADX WARNING: Missing block: B:3:0x0018, code:
            if (r1 != null) goto L_0x001d;
     */
        public final void run() {
            /*
            r2 = this;
            r0 = r2.drz;
            r0 = r0.drx;
            r1 = r2.drz;
            r1 = r1.azM;
            r1 = r1.getValue();
            r1 = (com.iqoption.signals.l) r1;
            if (r1 == 0) goto L_0x001b;
        L_0x0014:
            r1 = r1.aEg();
            if (r1 == 0) goto L_0x001b;
        L_0x001a:
            goto L_0x001d;
        L_0x001b:
            r1 = com.iqoption.signals.SignalFilter.ALL;
        L_0x001d:
            r0.e(r1);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iqoption.signals.SignalsViewModel.d.run():void");
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
    /* compiled from: SignalsViewModel.kt */
    static final class e implements Runnable {
        final /* synthetic */ SignalFilter drJ;
        final /* synthetic */ SignalsViewModel drz;

        e(SignalsViewModel signalsViewModel, SignalFilter signalFilter) {
            this.drz = signalsViewModel;
            this.drJ = signalFilter;
        }

        public final void run() {
            this.drz.drx.e(this.drJ);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u00040\u0003H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "", "subscriber", "Lio/reactivex/FlowableEmitter;", "Lcom/iqoption/signals/SignalsViewModel$Companion$Action;", "kotlin.jvm.PlatformType", "subscribe"})
    /* compiled from: SignalsViewModel.kt */
    /* renamed from: com.iqoption.signals.SignalsViewModel$1 */
    static final class AnonymousClass1<T> implements g<T> {
        final /* synthetic */ SignalsViewModel drz;

        AnonymousClass1(SignalsViewModel signalsViewModel) {
            this.drz = signalsViewModel;
        }

        public final void a(final f<a> fVar) {
            h.e(fVar, "subscriber");
            this.drz.asp.e(this.drz.drx.aWd().d((io.reactivex.c.f) AnonymousClass1.drA).c(com.iqoption.core.h.i.Yo()).a((io.reactivex.c.e) new io.reactivex.c.e<b>() {
                /* renamed from: a */
                public final void accept(b bVar) {
                    fVar.e(bVar);
                }
            }, (io.reactivex.c.e) AnonymousClass3.drC));
            this.drz.drx.e(SignalFilter.ALL);
            this.drz.asp.e(com.iqoption.core.microservices.pricemovements.a.aXg.Wu().d((io.reactivex.c.f) AnonymousClass4.drD).c(com.iqoption.core.h.i.Yo()).a((io.reactivex.c.e) new io.reactivex.c.e<a>() {
                /* renamed from: a */
                public final void accept(a aVar) {
                    fVar.e(aVar);
                }
            }, (io.reactivex.c.e) AnonymousClass6.drE));
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/signals/SignalsViewState;", "kotlin.jvm.PlatformType", "accept", "com/iqoption/signals/SignalsViewModel$3$1"})
    /* compiled from: SignalsViewModel.kt */
    static final class a<T> implements io.reactivex.c.e<l> {
        final /* synthetic */ SignalsViewModel drz;

        a(SignalsViewModel signalsViewModel) {
            this.drz = signalsViewModel;
        }

        /* renamed from: b */
        public final void accept(l lVar) {
            this.drz.azM.setValue(lVar);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: SignalsViewModel.kt */
    static final class b<T> implements io.reactivex.c.e<Throwable> {
        public static final b drG = new b();

        b() {
        }

        /* renamed from: o */
        public final void accept(Throwable th) {
            com.iqoption.core.i.w(SignalsViewModel.TAG, "ViewState's stream has been failed", th);
        }
    }

    public static final SignalsViewModel A(FragmentActivity fragmentActivity) {
        return dry.A(fragmentActivity);
    }

    public SignalsViewModel() {
        MutableLiveData mutableLiveData = new MutableLiveData();
        mutableLiveData.setValue(l.drL.aEm());
        this.azM = mutableLiveData;
        final AtomicReference atomicReference = new AtomicReference();
        io.reactivex.e d = io.reactivex.e.a((g) new AnonymousClass1(this), BackpressureStrategy.LATEST).a((io.reactivex.c.f) new io.reactivex.c.f<T, org.a.b<? extends R>>(this) {
            final /* synthetic */ SignalsViewModel drz;

            /* renamed from: a */
            public final io.reactivex.e<l> apply(a aVar) {
                h.e(aVar, "it");
                l lVar;
                if (aVar instanceof b) {
                    b bVar = (b) aVar;
                    lVar = new l(bVar.aEg(), bVar.aEh());
                    atomicReference.set(lVar);
                    return io.reactivex.e.bW(lVar);
                } else if (aVar instanceof a) {
                    lVar = (l) atomicReference.get();
                    if (lVar == null) {
                        return io.reactivex.e.aVU();
                    }
                    a aVar2 = (a) aVar;
                    int activeId = aVar2.aEa().getActiveId();
                    com.iqoption.app.helpers.a FI = com.iqoption.app.helpers.a.FI();
                    h.d(FI, "ActiveSettingHelper.instance()");
                    ImmutableList FO = FI.FO();
                    h.d(FO, "ActiveSettingHelper.instance().allActives");
                    for (Object next : FO) {
                        Object obj;
                        if (((com.iqoption.core.microservices.tradingengine.response.active.a) next).getActiveId() == activeId) {
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
                    com.iqoption.core.microservices.tradingengine.response.active.a aVar3 = (com.iqoption.core.microservices.tradingengine.response.active.a) next2;
                    if (aVar3 != null) {
                        this.drz.drv.postValue(l.drL.a(aVar2.aEa(), aVar3));
                    }
                    l b = lVar.b(aVar2.aEa());
                    atomicReference.set(b);
                    return io.reactivex.e.bW(b);
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
        }).c(com.iqoption.core.h.i.Yp()).d(com.iqoption.core.h.i.Yo());
        this.asp.e(d.a((io.reactivex.c.e) new a(this), (io.reactivex.c.e) b.drG));
        h.d(d, "Flowable\n               …    }))\n                }");
        this.drw = d;
    }

    public final LiveData<l> Qs() {
        return this.azM;
    }

    public final LiveData<c> aEf() {
        return this.drv;
    }

    protected void onCleared() {
        super.onCleared();
        this.asp.clear();
    }

    @MainThread
    public final void a(SignalFilter signalFilter) {
        h.e(signalFilter, "filter");
        l lVar = (l) this.azM.getValue();
        Object obj = null;
        if (signalFilter != (lVar != null ? lVar.aEg() : null)) {
            MutableLiveData mutableLiveData = this.azM;
            l lVar2 = (l) mutableLiveData.getValue();
            if (lVar2 != null) {
                obj = lVar2.c(signalFilter);
            }
            mutableLiveData.setValue(obj);
            com.iqoption.core.h.i.Yo().q(new e(this, signalFilter));
        }
    }

    @MainThread
    public final void reload() {
        com.iqoption.core.h.i.Yo().q(new d(this));
    }
}
