package com.iqoption.fragment.leftpanel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.FragmentActivity;
import com.iqoption.analytics.EventManager;
import com.iqoption.app.managers.c;
import com.iqoption.dto.Event;
import com.iqoption.fragment.leftpanel.b.f;
import com.iqoption.fragment.leftpanel.b.g;
import com.iqoption.mobbtech.connect.response.options.OptionEvents.l;
import com.iqoption.system.a.d;
import com.iqoption.videoeducation.j;
import io.reactivex.c.e;
import java.util.ArrayList;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u0000 *2\u00020\u0001:\u0002*+B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0019J\u0006\u0010#\u001a\u00020!J\b\u0010$\u001a\u00020!H\u0014J\u000e\u0010%\u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0019J\u0018\u0010&\u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\tH\u0002J\u0006\u0010(\u001a\u00020!J\u000e\u0010)\u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0019R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00060\u0006R\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\rX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\rX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\b8F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u000bR\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\rX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\b8F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u000bR\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00190\rX\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u001d0\b8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u000bR\u001a\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u001d0\rX\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, aXE = {"Lcom/iqoption/fragment/leftpanel/LeftPanelViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "disposable", "Lio/reactivex/disposables/CompositeDisposable;", "eventHandler", "Lcom/iqoption/fragment/leftpanel/LeftPanelViewModel$EventHandler;", "hasNewVideos", "Landroid/arch/lifecycle/LiveData;", "", "getHasNewVideos", "()Landroid/arch/lifecycle/LiveData;", "hasNewVideosData", "Landroid/arch/lifecycle/MutableLiveData;", "hasOpenedPositions", "getHasOpenedPositions", "hasOpenedPositionsData", "hasQuiz", "getHasQuiz", "()Z", "hasQuizUpdate", "getHasQuizUpdate", "isShown", "isShownData", "openedSection", "Lcom/iqoption/fragment/leftpanel/LeftPanelSection;", "getOpenedSection", "openedSectionData", "sections", "", "getSections", "sectionsData", "close", "", "section", "hide", "onCleared", "open", "sendAnalyticsEvent", "isOpen", "show", "toggle", "Companion", "EventHandler", "IqOption-5.5.1_optionXRelease"})
/* compiled from: LeftPanelViewModel.kt */
public final class LeftPanelViewModel extends ViewModel {
    private static final String TAG = "LeftPanelViewModel";
    public static final a cEc = new a();
    private final io.reactivex.disposables.a bco;
    private final MutableLiveData<Boolean> cDU;
    private final MutableLiveData<Boolean> cDV = new MutableLiveData();
    private final MutableLiveData<Boolean> cDW = new MutableLiveData();
    private final MutableLiveData<List<b>> cDX = new MutableLiveData();
    private final MutableLiveData<b> cDY = new MutableLiveData();
    private final b cDZ = new b();
    private final boolean cEa;
    private final boolean cEb;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, aXE = {"Lcom/iqoption/fragment/leftpanel/LeftPanelViewModel$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "get", "Lcom/iqoption/fragment/leftpanel/LeftPanelViewModel;", "activity", "Landroid/support/v4/app/FragmentActivity;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: LeftPanelViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final String Ll() {
            return LeftPanelViewModel.TAG;
        }

        public final LeftPanelViewModel l(FragmentActivity fragmentActivity) {
            h.e(fragmentActivity, "activity");
            return (LeftPanelViewModel) ViewModelProviders.b(fragmentActivity).h(LeftPanelViewModel.class);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, aXE = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept", "(Ljava/lang/Boolean;)V"})
    /* compiled from: LeftPanelViewModel.kt */
    /* renamed from: com.iqoption.fragment.leftpanel.LeftPanelViewModel$2 */
    static final class AnonymousClass2<T> implements e<Boolean> {
        final /* synthetic */ LeftPanelViewModel cEe;

        AnonymousClass2(LeftPanelViewModel leftPanelViewModel) {
            this.cEe = leftPanelViewModel;
        }

        /* renamed from: j */
        public final void accept(Boolean bool) {
            this.cEe.cDW.postValue(bool);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, aXE = {"Lcom/iqoption/fragment/leftpanel/LeftPanelViewModel$EventHandler;", "Lcom/iqoption/system/event/EventHandlerBase;", "(Lcom/iqoption/fragment/leftpanel/LeftPanelViewModel;)V", "onEvent", "", "event", "Lcom/iqoption/mobbtech/connect/response/options/OptionEvents$OpenOptionGroupsChangeEvents;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: LeftPanelViewModel.kt */
    public final class b extends d {
        @com.google.common.b.e
        public final void onEvent(l lVar) {
            h.e(lVar, "event");
            MutableLiveData a = LeftPanelViewModel.this.cDV;
            c Gn = c.Gn();
            h.d(Gn, "OptionManager.instance()");
            a.postValue(Boolean.valueOf(Gn.Gq() ^ 1));
        }
    }

    public static final LeftPanelViewModel l(FragmentActivity fragmentActivity) {
        return cEc.l(fragmentActivity);
    }

    public LeftPanelViewModel() {
        MutableLiveData mutableLiveData = new MutableLiveData();
        mutableLiveData.setValue(Boolean.valueOf(true));
        this.cDU = mutableLiveData;
        boolean z = com.iqoption.app.managers.feature.a.eX("iq-quiz") || com.iqoption.app.managers.feature.a.HN();
        this.cEa = z;
        this.cEb = com.iqoption.app.managers.feature.a.HN();
        this.bco = new io.reactivex.disposables.a();
        mutableLiveData = this.cDV;
        c Gn = c.Gn();
        h.d(Gn, "OptionManager.instance()");
        mutableLiveData.setValue(Boolean.valueOf(true ^ Gn.Gq()));
        List arrayList = new ArrayList();
        arrayList.add(b.c.cDP);
        if (com.iqoption.app.managers.feature.a.eW("smart-feed")) {
            arrayList.add(f.cDS);
        }
        if (com.iqoption.app.managers.feature.a.eX("iq-quiz") || com.iqoption.app.managers.feature.a.HN()) {
            arrayList.add(b.d.cDQ);
        }
        arrayList.add(b.e.cDR);
        if (com.iqoption.app.managers.feature.a.eW("video-education")) {
            this.bco.e(j.aHC().d((io.reactivex.c.f) AnonymousClass1.cEd).d(com.iqoption.core.h.i.Yo()).a((e) new AnonymousClass2(this), (e) AnonymousClass3.cEf));
            arrayList.add(g.cDT);
        }
        arrayList.add(com.iqoption.fragment.leftpanel.b.a.cDN);
        if (com.iqoption.app.managers.feature.a.eW("otn-token")) {
            arrayList.add(com.iqoption.fragment.leftpanel.b.b.cDO);
        }
        this.cDX.setValue(arrayList);
        this.cDZ.register();
    }

    public final LiveData<Boolean> amj() {
        return this.cDU;
    }

    public final LiveData<Boolean> amk() {
        return this.cDV;
    }

    public final LiveData<Boolean> aml() {
        return this.cDW;
    }

    public final LiveData<List<b>> amm() {
        return this.cDX;
    }

    public final LiveData<b> amn() {
        return this.cDY;
    }

    public final boolean amo() {
        return this.cEa;
    }

    public final boolean amp() {
        return this.cEb;
    }

    protected void onCleared() {
        super.onCleared();
        this.cDZ.unregister();
        this.bco.clear();
    }

    public final void d(b bVar) {
        h.e(bVar, "section");
        if (h.E((b) this.cDY.getValue(), bVar)) {
            this.cDY.setValue(null);
            a(bVar, false);
        }
    }

    public final void e(b bVar) {
        h.e(bVar, "section");
        if ((h.E((b) this.cDY.getValue(), bVar) ^ 1) != 0) {
            this.cDY.setValue(bVar);
            a(bVar, true);
        }
    }

    public final void f(b bVar) {
        h.e(bVar, "section");
        if (h.E((b) this.cDY.getValue(), bVar)) {
            this.cDY.setValue(null);
            a(bVar, false);
            return;
        }
        this.cDY.setValue(bVar);
        a(bVar, true);
    }

    private final void a(b bVar, boolean z) {
        if (amn().hasActiveObservers()) {
            EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, bVar.gF()).setValue(Double.valueOf(z ? 1.0d : 0.0d)).build());
        }
    }
}
