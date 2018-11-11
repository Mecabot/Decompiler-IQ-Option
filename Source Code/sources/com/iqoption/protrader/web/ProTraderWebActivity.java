package com.iqoption.protrader.web;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentManager.BackStackEntry;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.iqoption.activity.b;
import com.iqoption.fragment.base.f;
import com.iqoption.x.R;
import java.io.Serializable;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014¨\u0006\t"}, aXE = {"Lcom/iqoption/protrader/web/ProTraderWebActivity;", "Lcom/iqoption/activity/IQActivity;", "()V", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: ProTraderWebActivity.kt */
public final class ProTraderWebActivity extends b {
    public static final a dek = new a();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, aXE = {"Lcom/iqoption/protrader/web/ProTraderWebActivity$Companion;", "", "()V", "EXTRA_TYPE", "", "show", "", "activity", "Landroid/app/Activity;", "type", "Lcom/iqoption/protrader/web/ProTraderWebType;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ProTraderWebActivity.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final void a(Activity activity, ProTraderWebType proTraderWebType) {
            h.e(activity, "activity");
            h.e(proTraderWebType, Param.TYPE);
            Intent intent = new Intent(activity, ProTraderWebActivity.class);
            intent.putExtra("EXTRA_TYPE", proTraderWebType);
            activity.startActivity(intent);
        }
    }

    public static final void a(Activity activity, ProTraderWebType proTraderWebType) {
        dek.a(activity, proTraderWebType);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_pro_trader_web);
        if (bundle == null) {
            Serializable serializableExtra = getIntent().getSerializableExtra("EXTRA_TYPE");
            if (serializableExtra == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.iqoption.protrader.web.ProTraderWebType");
            }
            ProTraderWebType proTraderWebType = (ProTraderWebType) serializableExtra;
            com.iqoption.protrader.web.a.a aVar = a.der;
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            h.d(supportFragmentManager, "supportFragmentManager");
            aVar.a(supportFragmentManager, R.id.proTraderFragment, proTraderWebType);
        }
    }

    public void onBackPressed() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        h.d(supportFragmentManager, "fm");
        if (supportFragmentManager.getBackStackEntryCount() > 0) {
            BackStackEntry backStackEntryAt = supportFragmentManager.getBackStackEntryAt(supportFragmentManager.getBackStackEntryCount() - 1);
            h.d(backStackEntryAt, "fm.getBackStackEntryAt(fm.backStackEntryCount - 1)");
            Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(backStackEntryAt.getName());
            if (findFragmentByTag != null && (findFragmentByTag instanceof f) && ((f) findFragmentByTag).aN()) {
                return;
            }
        }
        finish();
    }
}
