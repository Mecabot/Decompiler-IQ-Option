package com.iqoption.fragment.rightpanel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.Fragment;
import com.iqoption.core.microservices.risks.response.overnightfee.d;
import io.reactivex.c.e;
import java.util.Calendar;
import java.util.HashMap;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0014J\u000e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00070\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, aXE = {"Lcom/iqoption/fragment/rightpanel/RightPanelViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "TAG", "", "kotlin.jvm.PlatformType", "calendar", "Ljava/util/Calendar;", "getCalendar", "()Ljava/util/Calendar;", "disposables", "Lio/reactivex/disposables/Disposable;", "overnightFee", "Landroid/arch/lifecycle/LiveData;", "Lcom/iqoption/core/microservices/risks/response/overnightfee/OvernightFeeMap;", "getOvernightFee", "()Landroid/arch/lifecycle/LiveData;", "overnightFeeMap", "Landroid/arch/lifecycle/MutableLiveData;", "userGroupId", "", "onCleared", "", "setActive", "active", "Lcom/iqoption/core/microservices/tradingengine/response/active/Active;", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: RightPanelViewModel.kt */
public final class RightPanelViewModel extends ViewModel {
    public static final a cHE = new a();
    private final String TAG = RightPanelViewModel.class.getSimpleName();
    private final long aqq = com.iqoption.app.a.Cw().Dj();
    private io.reactivex.disposables.b bcM;
    private final MutableLiveData<d> cHC = new MutableLiveData();
    private final LiveData<d> cHD = this.cHC;
    private final Calendar calendar = Calendar.getInstance();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, aXE = {"Lcom/iqoption/fragment/rightpanel/RightPanelViewModel$Companion;", "", "()V", "create", "Lcom/iqoption/fragment/rightpanel/RightPanelViewModel;", "f", "Landroid/support/v4/app/Fragment;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: RightPanelViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final RightPanelViewModel T(Fragment fragment) {
            h.e(fragment, "f");
            ViewModel h = ViewModelProviders.d(fragment).h(RightPanelViewModel.class);
            h.d(h, "ViewModelProviders.of(f)…nelViewModel::class.java)");
            return (RightPanelViewModel) h;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012H\u0010\u0002\u001aD\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005 \u0007*\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00060\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006H\n¢\u0006\u0002\b\b"}, aXE = {"<anonymous>", "", "it", "Ljava/util/HashMap;", "", "Lcom/iqoption/core/microservices/risks/response/overnightfee/OvernightFeeMap;", "Lkotlin/collections/HashMap;", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: RightPanelViewModel.kt */
    static final class b<T> implements e<HashMap<Integer, d>> {
        final /* synthetic */ int arW;
        final /* synthetic */ RightPanelViewModel cHF;

        b(RightPanelViewModel rightPanelViewModel, int i) {
            this.cHF = rightPanelViewModel;
            this.arW = i;
        }

        /* renamed from: d */
        public final void accept(HashMap<Integer, d> hashMap) {
            this.cHF.cHC.postValue(hashMap.get(Integer.valueOf(this.arW)));
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: RightPanelViewModel.kt */
    static final class c<T> implements e<Throwable> {
        final /* synthetic */ RightPanelViewModel cHF;

        c(RightPanelViewModel rightPanelViewModel) {
            this.cHF = rightPanelViewModel;
        }

        /* renamed from: o */
        public final void accept(Throwable th) {
            this.cHF.cHC.postValue(null);
            com.iqoption.core.i.w(this.cHF.TAG, th);
        }
    }

    public static final RightPanelViewModel T(Fragment fragment) {
        return cHE.T(fragment);
    }

    public final LiveData<d> amT() {
        return this.cHD;
    }

    public final Calendar getCalendar() {
        return this.calendar;
    }

    public final void x(com.iqoption.core.microservices.tradingengine.response.active.a aVar) {
        h.e(aVar, "active");
        int activeId = aVar.getActiveId();
        io.reactivex.disposables.b bVar = this.bcM;
        if (bVar != null) {
            bVar.dispose();
        }
        this.bcM = com.iqoption.asset.repository.c.aqA.d(this.aqq, aVar.getInstrumentType()).d(com.iqoption.core.h.i.Yo()).a((e) new b(this, activeId), (e) new c(this));
    }

    protected void onCleared() {
        super.onCleared();
        io.reactivex.disposables.b bVar = this.bcM;
        if (bVar != null) {
            bVar.dispose();
        }
    }
}
