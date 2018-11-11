package com.iqoption.gdpr.removal;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import com.iqoption.gdpr.removal.a.c;
import com.iqoption.util.am;
import com.iqoption.util.am.b;
import com.iqoption.x.R;
import kotlin.d;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u00012\u00020\u0002:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\b\u0010\u0010\u001a\u00020\fH\u0016J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0005H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0004\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000¨\u0006\u0014"}, aXE = {"Lcom/iqoption/gdpr/removal/PendingRemovalActivity;", "Landroid/support/v7/app/AppCompatActivity;", "Lcom/iqoption/gdpr/removal/PendingRemovalDialog$OnPendingRemovalCloseListener;", "()V", "isFullScreen", "", "()Z", "isFullScreen$delegate", "Lkotlin/Lazy;", "systemUiHider", "Lcom/iqoption/util/KeyboardUtil$SystemUiHider;", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPendingRemovalClose", "onWindowFocusChanged", "hasFocus", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: PendingRemovalActivity.kt */
public final class PendingRemovalActivity extends AppCompatActivity implements c {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(PendingRemovalActivity.class), "isFullScreen", "isFullScreen()Z"))};
    public static final a cIm = new a();
    private b adL;
    private final d cIl = g.f(new PendingRemovalActivity$isFullScreen$2(this));

    @i(aXC = {1, 1, 11}, aXD = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, aXE = {"Lcom/iqoption/gdpr/removal/PendingRemovalActivity$Companion;", "", "()V", "ARG_FLAGS", "", "ARG_FORGET_USER_DATA", "ARG_FULL_SCREEN", "ARG_ORIENTATION", "start", "", "activity", "Landroid/support/v4/app/FragmentActivity;", "forgetUserData", "Lcom/iqoption/core/microservices/busapi/response/ForgetUserData;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: PendingRemovalActivity.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final void a(FragmentActivity fragmentActivity, com.iqoption.core.microservices.busapi.response.a aVar) {
            h.e(fragmentActivity, "activity");
            h.e(aVar, "forgetUserData");
            Intent intent = new Intent(fragmentActivity, PendingRemovalActivity.class);
            intent.putExtra("ARG_FORGET_USER_DATA", aVar);
            intent.putExtra("ARG_ORIENTATION", fragmentActivity.getRequestedOrientation());
            intent.putExtra("ARG_FULL_SCREEN", fragmentActivity instanceof com.iqoption.activity.d);
            Window window = fragmentActivity.getWindow();
            h.d(window, "activity.window");
            intent.putExtra("ARG_FLAGS", window.getAttributes().flags);
            fragmentActivity.startActivity(intent);
        }
    }

    public static final void a(FragmentActivity fragmentActivity, com.iqoption.core.microservices.busapi.response.a aVar) {
        cIm.a(fragmentActivity, aVar);
    }

    private final boolean isFullScreen() {
        d dVar = this.cIl;
        j jVar = apP[0];
        return ((Boolean) dVar.getValue()).booleanValue();
    }

    public void onBackPressed() {
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (!isFullScreen()) {
            return;
        }
        b bVar;
        if (z) {
            bVar = this.adL;
            if (bVar == null) {
                h.lS("systemUiHider");
            }
            bVar.register();
            return;
        }
        bVar = this.adL;
        if (bVar == null) {
            h.lS("systemUiHider");
        }
        bVar.unregister();
    }

    protected void onCreate(Bundle bundle) {
        setRequestedOrientation(getIntent().getIntExtra("ARG_ORIENTATION", 0));
        int intExtra = getIntent().getIntExtra("ARG_FLAGS", 0);
        getWindow().setFlags(intExtra, 1024);
        getWindow().setFlags(intExtra, 134217728);
        super.onCreate(bundle);
        Activity activity = this;
        b u = am.u(activity);
        h.d(u, "KeyboardUtil.newSystemUiHider(this)");
        this.adL = u;
        if (isFullScreen()) {
            u = this.adL;
            if (u == null) {
                h.lS("systemUiHider");
            }
            u.aGp();
            u = this.adL;
            if (u == null) {
                h.lS("systemUiHider");
            }
            u.register();
        }
        DataBindingUtil.setContentView(activity, R.layout.activity_pending_removal);
        if (bundle == null) {
            com.iqoption.core.microservices.busapi.response.a aVar = (com.iqoption.core.microservices.busapi.response.a) getIntent().getParcelableExtra("ARG_FORGET_USER_DATA");
            com.iqoption.gdpr.removal.a.a aVar2 = a.cIs;
            FragmentActivity fragmentActivity = this;
            h.d(aVar, "forgetUserData");
            aVar2.b(fragmentActivity, aVar);
        }
    }

    public void aoo() {
        finish();
    }
}
