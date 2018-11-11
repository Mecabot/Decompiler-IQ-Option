package com.iqoption.deposit.pro;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.FrameLayout;
import com.google.common.util.concurrent.s;
import com.iqoption.core.f;
import com.iqoption.d.af;
import com.iqoption.dto.ToastEntity;
import com.iqoption.service.WebSocketHandler;
import com.iqoption.util.ag;
import com.iqoption.x.R;
import java.util.ArrayList;
import kotlin.e.d;
import kotlin.i;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 32\u00020\u00012\u00020\u0002:\u000234B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010!\u001a\u00020\"J\b\u0010#\u001a\u00020\u001bH$J\b\u0010$\u001a\u00020\u001bH$J\b\u0010%\u001a\u00020\"H\u0014J\u0012\u0010&\u001a\u00020\"2\b\u0010'\u001a\u0004\u0018\u00010(H\u0014J\u0010\u0010)\u001a\u00020\"2\u0006\u0010*\u001a\u00020\u001bH\u0016J\u0010\u0010+\u001a\u00020\"2\u0006\u0010,\u001a\u00020-H\u0014J\b\u0010.\u001a\u00020\"H\u0014J\b\u0010/\u001a\u00020\"H\u0014J\u0010\u00100\u001a\u00020\"2\u0006\u00101\u001a\u00020\u001bH\u0016J\u0006\u00102\u001a\u00020\"R+\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058D@DX\u0002¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR/\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000¨\u00065"}, aXE = {"Lcom/iqoption/deposit/pro/ProDepositActivity;", "Lcom/iqoption/core/ui/activity/IQActivity;", "Lcom/iqoption/deposit/pro/OnDepositCloseListener;", "()V", "<set-?>", "Lcom/iqoption/databinding/ActivityProDepositBinding;", "binding", "getBinding", "()Lcom/iqoption/databinding/ActivityProDepositBinding;", "setBinding", "(Lcom/iqoption/databinding/ActivityProDepositBinding;)V", "binding$delegate", "Lkotlin/properties/ReadWriteProperty;", "defaultPreset", "Ljava/util/ArrayList;", "Lcom/iqoption/core/features/limit/CurrencyValue;", "Lkotlin/collections/ArrayList;", "getDefaultPreset", "()Ljava/util/ArrayList;", "defaultPreset$delegate", "Lkotlin/Lazy;", "paymentMethodId", "", "getPaymentMethodId", "()Ljava/lang/Long;", "paymentMethodId$delegate", "returnToParent", "", "getReturnToParent", "()Z", "returnToParent$delegate", "showSplashRunnable", "Ljava/lang/Runnable;", "hideSplash", "", "isDarkDeposit", "isFullScreen", "onCloseByBack", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDepositClose", "showKyc", "onNewIntent", "intent", "Landroid/content/Intent;", "onStart", "onStop", "showKycBeforeDep", "particularMethodBlocked", "showSplash", "Companion", "OpenConnectionCallback", "IqOption-5.5.1_optionXRelease"})
/* compiled from: ProDepositActivity.kt */
public abstract class b extends com.iqoption.core.ui.a.a implements a {
    private static final String TAG = "com.iqoption.deposit.pro.b";
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(b.class), "binding", "getBinding()Lcom/iqoption/databinding/ActivityProDepositBinding;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(b.class), "returnToParent", "getReturnToParent()Z")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(b.class), "paymentMethodId", "getPaymentMethodId()Ljava/lang/Long;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(b.class), "defaultPreset", "getDefaultPreset()Ljava/util/ArrayList;"))};
    public static final a ccm = new a();
    private final Runnable bVo = new c(this);
    private final d bXo = kotlin.e.a.euA.aYg();
    private final kotlin.d bXy = g.f(new ProDepositActivity$defaultPreset$2(this));
    private final kotlin.d cck = g.f(new ProDepositActivity$returnToParent$2(this));
    private final kotlin.d ccl = g.f(new ProDepositActivity$paymentMethodId$2(this));

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, aXE = {"Lcom/iqoption/deposit/pro/ProDepositActivity$Companion;", "", "()V", "ARG_DEFAULT_PRESET", "", "ARG_PAYMENT_METHOD_ID", "ARG_RETURN_TO_PARENT", "TAG", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ProDepositActivity.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
    /* compiled from: ProDepositActivity.kt */
    static final class c implements Runnable {
        final /* synthetic */ b this$0;

        c(b bVar) {
            this.this$0 = bVar;
        }

        public final void run() {
            this.this$0.zC();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u0016¨\u0006\f"}, aXE = {"Lcom/iqoption/deposit/pro/ProDepositActivity$OpenConnectionCallback;", "Lcom/iqoption/system/future/ReferenceFutureCallback;", "Lcom/iqoption/deposit/pro/ProDepositActivity;", "Ljava/lang/Void;", "activity", "(Lcom/iqoption/deposit/pro/ProDepositActivity;)V", "onFailure", "", "t", "", "onSuccess", "result", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ProDepositActivity.kt */
    private static final class b extends com.iqoption.system.c.b<b, Void> {
        public b(b bVar) {
            h.e(bVar, "activity");
            super(bVar, Void.class);
        }

        /* renamed from: a */
        public void z(b bVar, Void voidR) {
            h.e(bVar, "activity");
            super.z(bVar, voidR);
            com.iqoption.core.d.a.aSe.removeCallbacks(bVar.bVo);
            bVar.zB();
        }

        /* renamed from: a */
        public void c(b bVar, Throwable th) {
            h.e(bVar, "activity");
            h.e(th, "t");
            super.c(bVar, th);
            com.iqoption.core.d.a.aSe.removeCallbacks(bVar.bVo);
            bVar.zB();
        }
    }

    private final Long aaB() {
        kotlin.d dVar = this.ccl;
        j jVar = apP[2];
        return (Long) dVar.getValue();
    }

    private final ArrayList<com.iqoption.core.c.c.a> aaD() {
        kotlin.d dVar = this.bXy;
        j jVar = apP[3];
        return (ArrayList) dVar.getValue();
    }

    private final boolean adZ() {
        kotlin.d dVar = this.cck;
        j jVar = apP[1];
        return ((Boolean) dVar.getValue()).booleanValue();
    }

    protected final void a(af afVar) {
        h.e(afVar, "<set-?>");
        this.bXo.a(this, apP[0], afVar);
    }

    protected abstract boolean aci();

    protected final af adY() {
        return (af) this.bXo.b(this, apP[0]);
    }

    protected abstract boolean isFullScreen();

    static {
        if (b.class.getName() == null) {
            h.aXZ();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, R.layout.activity_pro_deposit);
        h.d(contentView, "DataBindingUtil.setConte…out.activity_pro_deposit)");
        a((af) contentView);
        if (!isFullScreen()) {
            FrameLayout frameLayout = adY().biK;
            h.d(frameLayout, "binding.proDepositRoot");
            frameLayout.setFitsSystemWindows(true);
        }
        if (bundle == null) {
            com.iqoption.core.ui.navigation.h a = c.cco.a(aci(), aaB(), aaD());
            getSupportFragmentManager().beginTransaction().add(R.id.proDepositContainer, a.bf(this), a.getName()).commitAllowingStateLoss();
        }
    }

    protected void onStart() {
        super.onStart();
        s bE = WebSocketHandler.aDm().bE(TAG);
        com.iqoption.core.d.a.aSe.postDelayed(this.bVo, 1000);
        ag.b(bE, new b(this));
    }

    protected void onNewIntent(Intent intent) {
        h.e(intent, "intent");
        super.onNewIntent(intent);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        h.d(supportFragmentManager, "supportFragmentManager");
        for (Fragment fragment : supportFragmentManager.getFragments()) {
            if ((fragment instanceof com.iqoption.core.ui.fragment.a) && ((com.iqoption.core.ui.fragment.a) fragment).r(intent)) {
                return;
            }
        }
    }

    protected void onStop() {
        WebSocketHandler.aDm().m(TAG, ToastEntity.ACTION_TOAST_DURATION);
        super.onStop();
    }

    public final void zC() {
        View findFocus = adY().getRoot().findFocus();
        if (findFocus != null) {
            findFocus.clearFocus();
        }
        adY().biL.show();
    }

    public final void zB() {
        adY().biL.hide();
    }

    public void cw(boolean z) {
        com.iqoption.kyc.activity.KycActivity.a aVar = new com.iqoption.kyc.activity.KycActivity.a(this);
        if (!z) {
            aVar.ic(com.iqoption.kyc.fragment.b.TAG);
        }
        aVar.dO(true).start();
    }

    public void cA(boolean z) {
        if (z) {
            new com.iqoption.kyc.activity.KycActivity.a(this).dQ(true).start();
            finish();
        } else if (adZ()) {
            com.iqoption.util.a.a(this, null);
        } else {
            finish();
        }
    }

    protected void Yv() {
        super.Yv();
        f.RQ().Ds().a("deposit-page_back", com.iqoption.deposit.c.c.ceC.aeh());
    }
}
