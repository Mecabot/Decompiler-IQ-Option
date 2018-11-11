package com.iqoption.fragment.leftmenu;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentActivity;
import com.google.common.base.Optional;
import com.iqoption.app.af;
import com.iqoption.microservice.regulators.response.StatusType;
import com.iqoption.protrader.g;
import io.reactivex.c.f;
import io.reactivex.e;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\r\u001a\u00020\u000eH\u0002J\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0010J\u0006\u0010\u0013\u001a\u00020\fJ\u0006\u0010\u0014\u001a\u00020\fJ\u0006\u0010\u0015\u001a\u00020\fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, aXE = {"Lcom/iqoption/fragment/leftmenu/LeftMenuViewModel;", "Landroid/arch/lifecycle/AndroidViewModel;", "app", "Landroid/app/Application;", "(Landroid/app/Application;)V", "isOpened", "Landroid/arch/lifecycle/LiveData;", "", "()Landroid/arch/lifecycle/LiveData;", "isOpenedData", "Landroid/arch/lifecycle/MutableLiveData;", "close", "", "getPreferences", "Landroid/content/SharedPreferences;", "getProTraderApplicationStatus", "Lio/reactivex/Flowable;", "Lcom/google/common/base/Optional;", "Lcom/iqoption/microservice/regulators/response/StatusType;", "open", "setProTraderLeftMenuHidden", "toggle", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: LeftMenuViewModel.kt */
public final class LeftMenuViewModel extends AndroidViewModel {
    public static final a cCO = new a();
    private final MutableLiveData<Boolean> cCN;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, aXE = {"Lcom/iqoption/fragment/leftmenu/LeftMenuViewModel$Companion;", "", "()V", "get", "Lcom/iqoption/fragment/leftmenu/LeftMenuViewModel;", "activity", "Landroid/support/v4/app/FragmentActivity;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: LeftMenuViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final LeftMenuViewModel k(FragmentActivity fragmentActivity) {
            h.e(fragmentActivity, "activity");
            return (LeftMenuViewModel) ViewModelProviders.b(fragmentActivity).h(LeftMenuViewModel.class);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "Lcom/google/common/base/Optional;", "Lcom/iqoption/microservice/regulators/response/StatusType;", "kotlin.jvm.PlatformType", "it", "Lcom/iqoption/microservice/regulators/response/ProTraderApplicationStatus;", "apply"})
    /* compiled from: LeftMenuViewModel.kt */
    static final class b<T, R> implements f<T, R> {
        final /* synthetic */ Application cCP;
        final /* synthetic */ boolean cCQ;

        b(Application application, boolean z) {
            this.cCP = application;
            this.cCQ = z;
        }

        /* JADX WARNING: Missing block: B:8:0x0037, code:
            if (com.iqoption.core.ext.c.b(r5, com.iqoption.microservice.regulators.response.StatusType.PENDING, com.iqoption.microservice.regulators.response.StatusType.DECLINED) == true) goto L_0x0039;
     */
        /* renamed from: a */
        public final com.google.common.base.Optional<com.iqoption.microservice.regulators.response.StatusType> apply(com.iqoption.microservice.regulators.response.a r5) {
            /*
            r4 = this;
            r0 = "it";
            kotlin.jvm.internal.h.e(r5, r0);
            r5 = r5.ata();
            r0 = com.iqoption.microservice.regulators.response.StatusType.APPROVED;
            r1 = 0;
            if (r5 != r0) goto L_0x000f;
        L_0x000e:
            goto L_0x003a;
        L_0x000f:
            r0 = r4.cCP;
            r2 = "context";
            kotlin.jvm.internal.h.d(r0, r2);
            r0 = (android.content.Context) r0;
            r0 = com.iqoption.protrader.f.a(r0, r5);
            if (r0 == 0) goto L_0x001f;
        L_0x001e:
            goto L_0x0039;
        L_0x001f:
            r0 = r4.cCQ;
            if (r0 == 0) goto L_0x0024;
        L_0x0023:
            goto L_0x003a;
        L_0x0024:
            if (r5 == 0) goto L_0x003a;
        L_0x0026:
            r0 = 2;
            r0 = new com.iqoption.microservice.regulators.response.StatusType[r0];
            r2 = 0;
            r3 = com.iqoption.microservice.regulators.response.StatusType.PENDING;
            r0[r2] = r3;
            r2 = com.iqoption.microservice.regulators.response.StatusType.DECLINED;
            r3 = 1;
            r0[r3] = r2;
            r0 = com.iqoption.core.ext.c.b(r5, r0);
            if (r0 != r3) goto L_0x003a;
        L_0x0039:
            r1 = r5;
        L_0x003a:
            if (r1 == 0) goto L_0x0043;
        L_0x003c:
            r5 = com.google.common.base.Optional.E(r1);
            if (r5 == 0) goto L_0x0043;
        L_0x0042:
            goto L_0x004c;
        L_0x0043:
            r5 = com.google.common.base.Optional.pN();
            r0 = "Optional.absent()";
            kotlin.jvm.internal.h.d(r5, r0);
        L_0x004c:
            return r5;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iqoption.fragment.leftmenu.LeftMenuViewModel.b.a(com.iqoption.microservice.regulators.response.a):com.google.common.base.Optional<com.iqoption.microservice.regulators.response.StatusType>");
        }
    }

    public static final LeftMenuViewModel k(FragmentActivity fragmentActivity) {
        return cCO.k(fragmentActivity);
    }

    public LeftMenuViewModel(Application application) {
        h.e(application, "app");
        super(application);
        MutableLiveData mutableLiveData = new MutableLiveData();
        mutableLiveData.setValue(Boolean.valueOf(false));
        this.cCN = mutableLiveData;
    }

    public final LiveData<Boolean> alN() {
        return this.cCN;
    }

    public final void close() {
        this.cCN.setValue(Boolean.valueOf(false));
    }

    public final void toggle() {
        MutableLiveData mutableLiveData = this.cCN;
        mutableLiveData.setValue(Boolean.valueOf(h.E((Boolean) mutableLiveData.getValue(), Boolean.valueOf(true)) ^ true));
    }

    public final e<Optional<StatusType>> alO() {
        Application application = getApplication();
        com.iqoption.app.a aL = com.iqoption.app.a.aL((Context) application);
        h.d(aL, "account");
        e<Optional<StatusType>> aVU;
        if (aL.CU()) {
            aVU = e.aVU();
            h.d(aVU, "Flowable.empty()");
            return aVU;
        }
        aVU = g.ddT.bO(aL.getUserId()).d((f) new b(application, alQ().getBoolean("pro_trader_left_menu_hidden", false))).d(com.iqoption.core.h.i.Yo()).c(com.iqoption.core.h.i.Yp());
        h.d(aVU, "RegulatorsRepository.get…           .observeOn(ui)");
        return aVU;
    }

    public final void alP() {
        alQ().edit().putBoolean("pro_trader_left_menu_hidden", true).apply();
    }

    private final SharedPreferences alQ() {
        SharedPreferences Z = af.aR((Context) getApplication()).Z(com.iqoption.app.a.Cw().getUserId());
        h.d(Z, "Preferences.getInstance(…utUserPreferences(userId)");
        return Z;
    }
}
