package com.iqoption.verify;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentManager.BackStackEntry;
import com.google.common.util.concurrent.s;
import com.iqoption.core.ui.navigation.g;
import com.iqoption.d.aj;
import com.iqoption.dto.ToastEntity;
import com.iqoption.mobbtech.connect.response.q;
import com.iqoption.service.WebSocketHandler;
import com.iqoption.util.ag;
import com.iqoption.util.bg;
import com.iqoption.verify.list.f;
import com.iqoption.x.R;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u001f2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u001f B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0006\u0010\u000f\u001a\u00020\fJ\b\u0010\u0010\u001a\u00020\fH\u0016J\u0012\u0010\u0011\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u0010\u0014\u001a\u00020\fH\u0014J\b\u0010\u0015\u001a\u00020\fH\u0014J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\"\u0010\u0017\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0012\u0010\u001c\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\u0010\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0006\u0010\u001e\u001a\u00020\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, aXE = {"Lcom/iqoption/verify/VerifyCardsActivity;", "Lcom/iqoption/activity/IQActivity;", "Lcom/iqoption/verify/list/VerifyCardsFragment$ShowDetailsCallback;", "Lcom/iqoption/core/ui/navigation/BackController;", "()V", "backController", "Lcom/iqoption/core/ui/navigation/FirstWinBackController;", "binding", "Lcom/iqoption/databinding/ActivityVerifyCardsBinding;", "showSplashRunnable", "Ljava/lang/Runnable;", "addListener", "", "listener", "Lcom/iqoption/core/ui/navigation/BackListener;", "hideSplash", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onStop", "removeListener", "showCard", "card", "Lcom/iqoption/mobbtech/connect/response/VerifyCard;", "refreshDescription", "", "showCardList", "showDetails", "showSplash", "Companion", "OpenConnectionCallback", "IqOption-5.5.1_optionXRelease"})
/* compiled from: VerifyCardsActivity.kt */
public final class VerifyCardsActivity extends com.iqoption.activity.b implements com.iqoption.core.ui.navigation.a, com.iqoption.verify.list.f.b {
    private static final String TAG = "com.iqoption.verify.VerifyCardsActivity";
    public static final a dxn = new a();
    private final g aew = new g();
    private final Runnable bVo = new c(this);
    private aj dxm;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0002J&\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007J\"\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, aXE = {"Lcom/iqoption/verify/VerifyCardsActivity$Companion;", "", "()V", "ARG_CARD", "", "ARG_REFRESH_DESCRIPTION", "TAG", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "card", "Lcom/iqoption/mobbtech/connect/response/VerifyCard;", "refreshDescription", "", "start", "", "activity", "Landroid/app/Activity;", "startForResult", "fragment", "Landroid/support/v4/app/Fragment;", "requestCode", "", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: VerifyCardsActivity.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final void a(Activity activity, q qVar, boolean z) {
            h.e(activity, "activity");
            activity.startActivity(a((Context) activity, qVar, z));
        }

        public final void a(Fragment fragment, int i, q qVar) {
            h.e(fragment, "fragment");
            fragment.startActivityForResult(a(this, com.iqoption.core.ext.a.m(fragment), qVar, false, 4, null), i);
        }

        private final Intent a(Context context, q qVar, boolean z) {
            Intent intent = new Intent(context, VerifyCardsActivity.class);
            if (qVar != null) {
                intent.putExtra("ARG_CARD", qVar);
            }
            intent.putExtra("ARG_REFRESH_DESCRIPTION", z);
            return intent;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
    /* compiled from: VerifyCardsActivity.kt */
    static final class c implements Runnable {
        final /* synthetic */ VerifyCardsActivity dxo;

        c(VerifyCardsActivity verifyCardsActivity) {
            this.dxo = verifyCardsActivity;
        }

        public final void run() {
            this.dxo.zC();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u0016¨\u0006\f"}, aXE = {"Lcom/iqoption/verify/VerifyCardsActivity$OpenConnectionCallback;", "Lcom/iqoption/system/future/ReferenceFutureCallback;", "Lcom/iqoption/verify/VerifyCardsActivity;", "Ljava/lang/Void;", "activity", "(Lcom/iqoption/verify/VerifyCardsActivity;)V", "onFailure", "", "t", "", "onSuccess", "result", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: VerifyCardsActivity.kt */
    private static final class b extends com.iqoption.system.c.b<VerifyCardsActivity, Void> {
        public b(VerifyCardsActivity verifyCardsActivity) {
            h.e(verifyCardsActivity, "activity");
            super(verifyCardsActivity, Void.class);
        }

        /* renamed from: a */
        public void z(VerifyCardsActivity verifyCardsActivity, Void voidR) {
            h.e(verifyCardsActivity, "activity");
            super.z(verifyCardsActivity, voidR);
            com.iqoption.core.d.a.aSe.removeCallbacks(verifyCardsActivity.bVo);
            verifyCardsActivity.zB();
        }

        /* renamed from: a */
        public void c(VerifyCardsActivity verifyCardsActivity, Throwable th) {
            h.e(verifyCardsActivity, "activity");
            h.e(th, "t");
            super.c(verifyCardsActivity, th);
            com.iqoption.core.d.a.aSe.removeCallbacks(verifyCardsActivity.bVo);
            verifyCardsActivity.zB();
        }
    }

    public static final void a(Activity activity, q qVar, boolean z) {
        dxn.a(activity, qVar, z);
    }

    public static final void start(Activity activity) {
        a.a(dxn, activity, null, false, 6, null);
    }

    static {
        if (VerifyCardsActivity.class.getName() == null) {
            h.aXZ();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, R.layout.activity_verify_cards);
        h.d(contentView, "DataBindingUtil.setConte…ut.activity_verify_cards)");
        this.dxm = (aj) contentView;
        aj ajVar = this.dxm;
        if (ajVar == null) {
            h.lS("binding");
        }
        bg.bV(ajVar.biN);
        q qVar = (q) getIntent().getParcelableExtra("ARG_CARD");
        if (qVar != null) {
            a(bundle, qVar, getIntent().getBooleanExtra("ARG_REFRESH_DESCRIPTION", false));
        } else {
            ak(bundle);
        }
    }

    private final void a(Bundle bundle, q qVar, boolean z) {
        if (bundle == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, com.iqoption.verify.status.a.dxZ.b(qVar, z), com.iqoption.verify.status.a.TAG).commit();
        }
    }

    private final void ak(Bundle bundle) {
        f aGV;
        if (bundle == null) {
            aGV = f.dxP.aGV();
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, aGV, f.TAG).addToBackStack(f.TAG).commit();
        } else {
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(f.TAG);
            if (findFragmentByTag == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.iqoption.verify.list.VerifyCardsFragment");
            }
            aGV = (f) findFragmentByTag;
        }
        aGV.a((com.iqoption.verify.list.f.b) this);
    }

    protected void onStart() {
        super.onStart();
        s bE = WebSocketHandler.aDm().bE(TAG);
        com.iqoption.core.d.a.aSe.postDelayed(this.bVo, 1000);
        ag.b(bE, new b(this));
    }

    protected void onStop() {
        WebSocketHandler.aDm().m(TAG, ToastEntity.ACTION_TOAST_DURATION);
        super.onStop();
    }

    public final void zC() {
        aj ajVar = this.dxm;
        if (ajVar == null) {
            h.lS("binding");
        }
        ajVar.biL.show();
    }

    public final void zB() {
        aj ajVar = this.dxm;
        if (ajVar == null) {
            h.lS("binding");
        }
        ajVar.biL.hide();
    }

    public void b(q qVar) {
        h.e(qVar, "card");
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, com.iqoption.verify.details.a.dxA.e(qVar), com.iqoption.verify.details.a.TAG).addToBackStack(com.iqoption.verify.details.a.TAG).commit();
    }

    public void onBackPressed() {
        if (!this.aew.onBackPressed()) {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            h.d(supportFragmentManager, "fm");
            if (supportFragmentManager.getBackStackEntryCount() > 0) {
                BackStackEntry backStackEntryAt = supportFragmentManager.getBackStackEntryAt(supportFragmentManager.getBackStackEntryCount() - 1);
                h.d(backStackEntryAt, "fm.getBackStackEntryAt(fm.backStackEntryCount - 1)");
                Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(backStackEntryAt.getName());
                if (findFragmentByTag != null && (findFragmentByTag instanceof com.iqoption.view.e.a) && ((com.iqoption.view.e.a) findFragmentByTag).onBackPressed()) {
                    return;
                }
            }
            for (Fragment fragment : supportFragmentManager.getFragments()) {
                h.d(fragment, "fragment");
                if (fragment.isVisible() && (fragment instanceof com.iqoption.view.e.a) && ((com.iqoption.view.e.a) fragment).onBackPressed()) {
                    return;
                }
            }
            super.onBackPressed();
        }
    }

    public void a(com.iqoption.core.ui.navigation.b bVar) {
        h.e(bVar, "listener");
        this.aew.a(bVar);
    }

    public void b(com.iqoption.core.ui.navigation.b bVar) {
        h.e(bVar, "listener");
        this.aew.b(bVar);
    }
}
