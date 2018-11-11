package com.iqoption.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.iqoption.app.af;
import com.iqoption.app.b.b.h;
import com.iqoption.core.microservices.busapi.response.ForgetUserStatus;
import com.iqoption.dialog.d;
import com.iqoption.gdpr.removal.PendingRemovalActivity;
import com.iqoption.system.a.e;
import com.iqoption.util.am;
import com.iqoption.util.fragmentstack.FragmentAwareLifecycleListener;

/* compiled from: IQActivity */
public abstract class b extends AppCompatActivity {
    private boolean adE;
    private boolean adF;
    private am adG;
    private FragmentAwareLifecycleListener adH;
    @NonNull
    private final a adI = new a(this);

    /* compiled from: IQActivity */
    private static class a extends e<b> {
        public a(b bVar) {
            super(bVar);
        }

        @com.google.common.b.e
        public void onForgetUserDataChanged(h hVar) {
            com.iqoption.core.d.a.aSe.execute(new c(this, hVar));
        }

        final /* synthetic */ void a(h hVar) {
            b bVar = (b) this.drU.get();
            if (bVar != null && !bVar.isDestroyed()) {
                bVar.a((com.iqoption.core.microservices.busapi.response.a) hVar.getValue());
            }
        }
    }

    public FragmentAwareLifecycleListener zG() {
        return this.adH;
    }

    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.adH = new FragmentAwareLifecycleListener(getSupportFragmentManager());
        getLifecycle().a(this.adH);
    }

    protected void onStop() {
        super.onStop();
    }

    protected void onStart() {
        super.onStart();
    }

    public void onResume() {
        super.onResume();
        this.adG = new am(this);
        af.aR((Context) this).aP(true);
        this.adF = true;
        this.adI.register();
        a(com.iqoption.app.a.aL((Context) this).CV());
    }

    public void onPause() {
        super.onPause();
        this.adG = null;
        af.aR((Context) this).aP(false);
        this.adF = false;
        this.adI.unregister();
    }

    protected void onDestroy() {
        super.onDestroy();
        this.adE = true;
    }

    public void zH() {
        new d().show(getSupportFragmentManager(), "ProcessingDialog");
    }

    public void zI() {
        d dVar = (d) getSupportFragmentManager().findFragmentByTag("ProcessingDialog");
        if (dVar != null) {
            getSupportFragmentManager().beginTransaction().remove(dVar).commitAllowingStateLoss();
        }
    }

    public boolean zJ() {
        return this.adE;
    }

    public boolean zK() {
        return this.adF;
    }

    public void zL() {
        if (this.adG != null) {
            this.adG.aGk();
        }
    }

    public void zM() {
        if (this.adG != null) {
            this.adG.aGl();
        }
    }

    public boolean zN() {
        return this.adG != null ? this.adG.zN() : false;
    }

    private void a(@Nullable com.iqoption.core.microservices.busapi.response.a aVar) {
        if (aVar != null && aVar.Vr() == ForgetUserStatus.WAITING) {
            b(aVar);
        }
    }

    protected void b(@NonNull com.iqoption.core.microservices.busapi.response.a aVar) {
        PendingRemovalActivity.a(this, aVar);
    }
}
