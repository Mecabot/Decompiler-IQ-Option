package com.iqoption.welcomeonboarding;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.internal.view.SupportMenu;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.Toast;
import com.facebook.FacebookException;
import com.facebook.e;
import com.facebook.h;
import com.facebook.login.j;
import com.facebook.login.l;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.iqoption.analytics.EventManager;
import com.iqoption.app.af;
import com.iqoption.core.i;
import com.iqoption.core.ui.navigation.g;
import com.iqoption.core.ui.viewmodel.welcome.FacebookAuthViewModel;
import com.iqoption.d.al;
import com.iqoption.dto.Event;
import com.iqoption.dto.ToastEntity;
import com.iqoption.mobbtech.connect.RequestManager;
import com.iqoption.service.WebSocketHandler;
import com.iqoption.util.ag;
import com.iqoption.util.bg;
import com.iqoption.view.SplashView;
import com.iqoption.x.R;
import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONObject;

public class WelcomeOnboardingActivity extends com.iqoption.activity.a implements com.iqoption.core.ui.navigation.a, a, com.iqoption.welcomeonboarding.a.b.a, b, com.iqoption.welcomeonboarding.c.a.a, com.iqoption.welcomeonboarding.d.b.a {
    private static final String TAG = "com.iqoption.welcomeonboarding.WelcomeOnboardingActivity";
    private g aew = new g();
    private e bcs;
    private boolean dLD;
    private Collection<com.iqoption.welcomeonboarding.c.a> dLE = new ArrayList();
    private al dLF;
    private boolean dLG = false;
    private int dLH = -1;

    private static class a extends com.iqoption.system.c.b<WelcomeOnboardingActivity, com.iqoption.microservice.authorization.a.c> {
        public a(WelcomeOnboardingActivity welcomeOnboardingActivity) {
            super(welcomeOnboardingActivity, com.iqoption.microservice.authorization.a.c.class);
        }

        /* renamed from: a */
        public void z(@NonNull WelcomeOnboardingActivity welcomeOnboardingActivity, @NonNull com.iqoption.microservice.authorization.a.c cVar) {
            super.z(welcomeOnboardingActivity, cVar);
            i.v(WelcomeOnboardingActivity.TAG, "HideSplashCallback.onSuccess");
            welcomeOnboardingActivity.zB();
        }

        /* renamed from: a */
        public void c(@NonNull WelcomeOnboardingActivity welcomeOnboardingActivity, Throwable th) {
            super.c(welcomeOnboardingActivity, th);
            i.v(WelcomeOnboardingActivity.TAG, "HideSplashCallback.onFailure", th);
            welcomeOnboardingActivity.zB();
        }
    }

    private static class b extends com.iqoption.system.c.b<WelcomeOnboardingActivity, Void> {
        private final String aOu;

        public b(WelcomeOnboardingActivity welcomeOnboardingActivity, String str) {
            super(welcomeOnboardingActivity, Void.class);
            this.aOu = str;
        }

        /* renamed from: a */
        public void z(@NonNull WelcomeOnboardingActivity welcomeOnboardingActivity, Void voidR) {
            super.z(welcomeOnboardingActivity, voidR);
            com.iqoption.tutorial.b.bO(welcomeOnboardingActivity).eZ(com.iqoption.tutorial.utils.d.fc(true));
            com.iqoption.deposit.i.a(welcomeOnboardingActivity, this.aOu, true, true);
            com.iqoption.util.a.s(welcomeOnboardingActivity);
        }

        /* renamed from: a */
        public void c(@NonNull WelcomeOnboardingActivity welcomeOnboardingActivity, Throwable th) {
            super.c(welcomeOnboardingActivity, th);
            com.iqoption.app.a.b.aT(welcomeOnboardingActivity);
            com.iqoption.util.a.a(welcomeOnboardingActivity, welcomeOnboardingActivity.getIntent());
        }
    }

    private static class c extends com.iqoption.system.c.b<WelcomeOnboardingActivity, Boolean> {
        public c(WelcomeOnboardingActivity welcomeOnboardingActivity) {
            super((Object) welcomeOnboardingActivity);
        }

        /* renamed from: a */
        public void z(WelcomeOnboardingActivity welcomeOnboardingActivity, Boolean bool) {
            welcomeOnboardingActivity.aKB();
        }

        /* renamed from: a */
        public void c(WelcomeOnboardingActivity welcomeOnboardingActivity, Throwable th) {
            welcomeOnboardingActivity.zZ();
        }
    }

    private static class d extends com.iqoption.system.c.b<WelcomeOnboardingActivity, Boolean> {
        public d(WelcomeOnboardingActivity welcomeOnboardingActivity) {
            super((Object) welcomeOnboardingActivity);
        }

        /* renamed from: a */
        public void z(WelcomeOnboardingActivity welcomeOnboardingActivity, Boolean bool) {
            welcomeOnboardingActivity.ki(null);
        }

        /* renamed from: a */
        public void c(WelcomeOnboardingActivity welcomeOnboardingActivity, Throwable th) {
            welcomeOnboardingActivity.zZ();
        }
    }

    public void zB() {
    }

    public void zC() {
    }

    @NonNull
    public static Intent a(@NonNull Context context, @NonNull com.iqoption.core.ui.viewmodel.welcome.c cVar) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create welcome onvoarding activity intent, welcomeScreen=");
        stringBuilder.append(cVar);
        i.d(str, stringBuilder.toString());
        Intent intent = new Intent(context, WelcomeOnboardingActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("ARG_WELCOME_PARAMS", cVar);
        intent.putExtras(bundle);
        return intent;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dLF = (al) DataBindingUtil.setContentView(this, R.layout.activity_welcome_onboarding);
        if (af.DX().Dh()) {
            this.dLF.biO.setVisibility(0);
        }
        Bundle extras = getIntent().getExtras();
        if (extras == null || !extras.containsKey("ARG_WELCOME_PARAMS")) {
            i.e(TAG, "WelcomeScreenFeature name should be specified");
            finish();
            return;
        }
        com.iqoption.core.ui.viewmodel.welcome.c cVar = (com.iqoption.core.ui.viewmodel.welcome.c) extras.getParcelable("ARG_WELCOME_PARAMS");
        boolean z = cVar instanceof com.iqoption.core.ui.viewmodel.welcome.b;
        if (bundle == null) {
            Fragment kk;
            if (z) {
                kk = com.iqoption.welcomeonboarding.c.a.kk(((com.iqoption.core.ui.viewmodel.welcome.b) cVar).Ze().name());
            } else if (cVar instanceof com.iqoption.core.ui.viewmodel.welcome.a) {
                kk = com.iqoption.welcomeonboarding.registration.e.aMl();
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unexpected case: ");
                stringBuilder.append(cVar);
                throw new IllegalStateException(stringBuilder.toString());
            }
            getSupportFragmentManager().beginTransaction().add(R.id.content, kk, TAG).commit();
            if (this.dLG || !z) {
                this.dLF.biP.setVisibility(8);
                this.dLF.biQ.setVisibility(8);
            } else {
                this.dLF.biQ.setVisibility(0);
                this.dLF.biP.setVisibility(0);
                Drawable bVar = new com.iqoption.view.drawable.b();
                Parcelable parcelableExtra = getIntent().getParcelableExtra("com.iqoption.view.SplashView.extra.sharedState");
                bVar.c(SplashView.a(parcelableExtra));
                bVar.aIW();
                Rect b = SplashView.b(parcelableExtra);
                this.dLF.biP.setImageDrawable(bVar);
                bg.a(this.dLF.getRoot(), new d(this, b));
            }
        } else {
            this.dLG = bundle.getBoolean("animation_was_played", false);
            if (this.dLG || !z) {
                this.dLF.biP.setVisibility(8);
                this.dLF.biQ.setVisibility(8);
            }
        }
        this.bcs = com.facebook.e.a.iL();
        f(com.facebook.a.ik());
        j.nB().a(this.bcs, new com.facebook.g<l>() {
            /* renamed from: a */
            public void onSuccess(l lVar) {
                WelcomeOnboardingActivity.this.f(lVar.jo());
            }

            public void onCancel() {
                clear();
            }

            public void b(FacebookException facebookException) {
                clear();
            }

            private void clear() {
                FacebookAuthViewModel.Zc();
                WelcomeOnboardingActivity.this.zB();
                com.iqoption.app.a.aL(WelcomeOnboardingActivity.this).aM(WelcomeOnboardingActivity.this);
                RequestManager.atO().atW();
            }
        });
    }

    final /* synthetic */ void h(Rect rect) {
        Rect J = bg.J(this.dLF.biP);
        this.dLF.biP.setTranslationX((float) (rect.left - J.left));
        this.dLF.biP.setTranslationY((float) (rect.top - J.top));
        new Handler().postDelayed(new f(this), 500);
    }

    final /* synthetic */ void aKH() {
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.content);
        if (findFragmentById != null && (findFragmentById instanceof com.iqoption.welcomeonboarding.c.a)) {
            a(((com.iqoption.welcomeonboarding.c.a) findFragmentById).aKV());
            this.dLG = true;
        }
    }

    private void a(final com.iqoption.welcomeonboarding.c.a.a aVar) {
        TimeInterpolator linearInterpolator = new LinearInterpolator();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dLF.biQ, View.ALPHA, new float[]{1.0f, 0.0f});
        ofFloat.setDuration(400);
        ofFloat.setInterpolator(linearInterpolator);
        ofFloat.setStartDelay(300);
        ofFloat.start();
        this.dLF.biP.setPivotY(0.0f);
        Rect J = bg.J(this.dLF.biP);
        Rect aLe = aVar.aLe();
        if (aLe == null) {
            aLe = J;
        }
        float height = (((float) aLe.height()) * 0.75f) / getResources().getDimension(R.dimen.dp100);
        float height2 = (((float) (aLe.top - J.top)) + (((float) aLe.height()) * 0.125f)) + this.dLF.biP.getTranslationY();
        ImageView imageView = this.dLF.biP;
        r4 = new PropertyValuesHolder[4];
        r4[0] = PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{0.0f});
        r4[1] = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{height2});
        r4[2] = PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{1.0f, height});
        r4[3] = PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{1.0f, height});
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(imageView, r4);
        ofPropertyValuesHolder.setDuration(600);
        ofPropertyValuesHolder.setInterpolator(new DecelerateInterpolator(1.2f));
        ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (!WelcomeOnboardingActivity.this.isDestroyed()) {
                    WelcomeOnboardingActivity.this.dLF.biP.setVisibility(8);
                    WelcomeOnboardingActivity.this.dLF.biQ.setVisibility(8);
                    aVar.fu(true);
                }
            }
        });
        ofPropertyValuesHolder.start();
    }

    protected void onStart() {
        super.onStart();
        int i = getResources().getConfiguration().orientation;
        if (this.dLH != i) {
            EventManager.Bm().a(Event.Builder(Event.CATEGORY_SYSTEM, "screen-orientation_change-orientation").setValue(Double.valueOf(i == 1 ? 0.0d : 1.0d)).setTechnicalLogs(Boolean.valueOf(true)).build());
            this.dLH = i;
        }
    }

    public void onSaveInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        bundle.putBoolean("animation_was_played", this.dLG);
        super.onSaveInstanceState(bundle, persistableBundle);
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        if (bundle != null) {
            this.dLG = bundle.getBoolean("animation_was_played", false);
            if (this.dLG) {
                this.dLF.biP.setVisibility(8);
                this.dLF.biQ.setVisibility(8);
            }
        }
    }

    protected void onStop() {
        super.onStop();
        WebSocketHandler.aDm().m(TAG, ToastEntity.ACTION_TOAST_DURATION);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onActivityResult requestCode:");
        stringBuilder.append(i);
        i.d(str, stringBuilder.toString());
        super.onActivityResult(i, i2, intent);
        if ((SupportMenu.USER_MASK & i) == h.jf()) {
            this.bcs.onActivityResult(h.jf(), i2, intent);
        } else {
            zB();
        }
        for (com.iqoption.welcomeonboarding.c.a onActivityResult : this.dLE) {
            onActivityResult.onActivityResult(i, i2, intent);
        }
    }

    protected void b(String str, String str2, String str3, String str4, String str5) {
        if (com.iqoption.app.a.Cw().CZ()) {
            o.a(o.a(com.iqoption.c.a.Jw().a(str2, str3, str, str4, str5, 5), new com.google.common.util.concurrent.g<Boolean, Boolean>() {
                /* renamed from: u */
                public s<Boolean> aP(Boolean bool) {
                    return com.iqoption.c.a.Jw().i();
                }
            }), new d(this), com.iqoption.core.d.a.aSe);
        } else {
            o.a(o.a(com.iqoption.c.a.Jw().b(str, str2, str3, str4, str5, 5), new com.google.common.util.concurrent.g<Boolean, Boolean>() {
                /* renamed from: u */
                public s<Boolean> aP(Boolean bool) {
                    return com.iqoption.c.a.Jw().i();
                }
            }), new c(this), com.iqoption.core.d.a.aSe);
        }
    }

    public void a(com.iqoption.welcomeonboarding.c.a aVar) {
        this.dLE.add(aVar);
    }

    public void b(com.iqoption.welcomeonboarding.c.a aVar) {
        this.dLE.remove(aVar);
    }

    public void aKE() {
        getSupportFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.content, com.iqoption.welcomeonboarding.b.c.aKN(), com.iqoption.welcomeonboarding.b.c.TAG).addToBackStack(com.iqoption.welcomeonboarding.b.c.TAG).commitAllowingStateLoss();
    }

    public void aKF() {
        getSupportFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.content, com.iqoption.welcomeonboarding.registration.e.aMl(), com.iqoption.welcomeonboarding.registration.e.TAG).addToBackStack(com.iqoption.welcomeonboarding.registration.e.TAG).commitAllowingStateLoss();
    }

    public void j(String str, String str2, String str3) {
        af DX = af.DX();
        DX.eE(str);
        DX.eF(str2);
        DX.ag(System.currentTimeMillis());
        if (!TextUtils.isEmpty(str3)) {
            DX.eG(str3);
        }
        getSupportFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.content, com.iqoption.welcomeonboarding.d.b.aMC(), com.iqoption.welcomeonboarding.d.b.TAG).addToBackStack(com.iqoption.welcomeonboarding.registration.e.TAG).commitAllowingStateLoss();
    }

    public void aKC() {
        getSupportFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.content, com.iqoption.welcomeonboarding.a.b.aKK(), com.iqoption.welcomeonboarding.a.b.TAG).addToBackStack(com.iqoption.welcomeonboarding.a.b.TAG).commitAllowingStateLoss();
    }

    public void aKA() {
        i.v(TAG, "showTradeRoom");
        com.iqoption.util.a.a(this, getIntent());
    }

    public void onBackPressed() {
        if (!this.aew.onBackPressed()) {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            if (supportFragmentManager.getBackStackEntryCount() > 0) {
                Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(supportFragmentManager.getBackStackEntryAt(supportFragmentManager.getBackStackEntryCount() - 1).getName());
                if (findFragmentByTag != null && (findFragmentByTag instanceof com.iqoption.view.e.a) && ((com.iqoption.view.e.a) findFragmentByTag).onBackPressed()) {
                    return;
                }
            }
            if (getSupportFragmentManager().getBackStackEntryCount() == 0 || getSupportFragmentManager().isStateSaved()) {
                super.onBackPressed();
            } else {
                getSupportFragmentManager().popBackStack();
            }
        }
    }

    public void aKD() {
        onBackPressed();
    }

    public void ki(String str) {
        i.v(TAG, "openFirstScreenAfterRegistration");
        zC();
        ag.b(WebSocketHandler.aDm().bE(TAG), new b(this, str));
    }

    public void aKB() {
        i.v(TAG, "onLoginDone");
        com.iqoption.util.a.a(this, getIntent());
    }

    public void aKG() {
        i.v(TAG, "onTwoStepAuthDone");
        com.iqoption.util.a.a(this, getIntent());
    }

    private void zZ() {
        i.v(TAG, "relogin");
        FacebookAuthViewModel.Zc();
        zF();
        ag.b(com.iqoption.c.g.aX(this), new a(this));
    }

    private void f(com.facebook.a aVar) {
        i.v(TAG, "authFacebook");
        if (!this.dLD && aVar != null) {
            this.dLD = true;
            zC();
            com.facebook.i a = com.facebook.i.a(aVar, new e(this, aVar, new c(this)));
            Bundle bundle = new Bundle();
            bundle.putString("fields", "id,first_name,last_name,email");
            a.setParameters(bundle);
            a.jr();
        }
    }

    final /* synthetic */ void a(com.facebook.a aVar, c cVar, JSONObject jSONObject, com.facebook.l lVar) {
        this.dLD = false;
        if (jSONObject != null) {
            String optString = jSONObject.optString("email");
            if (TextUtils.isEmpty(optString)) {
                zB();
                Toast.makeText(this, R.string.facebook_email_null, 1).show();
                FacebookAuthViewModel.Zc();
                return;
            }
            o.a(com.iqoption.c.a.Jw().b(optString, jSONObject.optString("first_name"), jSONObject.optString("last_name"), jSONObject.optString("id"), aVar.getToken(), 4), cVar, com.iqoption.core.d.a.aSe);
        } else {
            zZ();
        }
    }

    public void kj(String str) {
        com.iqoption.app.a.b.b(str, this);
        aKD();
    }

    public void a(com.iqoption.core.ui.navigation.b bVar) {
        this.aew.a(bVar);
    }

    public void b(com.iqoption.core.ui.navigation.b bVar) {
        this.aew.b(bVar);
    }
}
