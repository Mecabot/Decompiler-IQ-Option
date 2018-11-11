package com.jumio.nv;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.jumio.MobileActivity;
import com.jumio.analytics.JumioAnalytics;
import com.jumio.analytics.MobileEvents;
import com.jumio.analytics.UserAction;
import com.jumio.commons.log.Log;
import com.jumio.commons.utils.DeviceRotationManager;
import com.jumio.commons.utils.ScreenUtil;
import com.jumio.commons.view.CompatibilityLayer;
import com.jumio.nv.enums.NVErrorCase;
import com.jumio.nv.extraction.NfcController;
import com.jumio.nv.models.InitiateModel;
import com.jumio.nv.view.fragment.INetverifyActivityCallback;
import com.jumio.nv.view.fragment.INetverifyFragmentCallback;
import com.jumio.nv.view.fragment.SelectionFragment;
import com.jumio.persistence.DataAccess;
import com.jumio.sdk.models.CredentialsModel;
import java.util.ArrayList;
import jumio.nv.core.a;
import jumio.nv.core.b.b;

public class NetverifyActivity extends MobileActivity implements INetverifyFragmentCallback, b {
    private final Object a;
    private ArrayList<Fragment> b;
    private INetverifyActivityCallback c;
    private Toolbar d;
    private TextView e;
    private LinearLayout f;
    private jumio.nv.core.b g;

    public NetverifyActivity() {
        this.a = new Object();
        this.b = null;
        this.c = null;
        this.b = new ArrayList();
        this.g = new jumio.nv.core.b();
        this.g.a((b) this);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setFinishOnTouchOutside(false);
        getWindow().addFlags(8192);
        setContentView(R.layout.activity_netverify);
        boolean z = true;
        this.g.a(this, getCredentials(), bundle == null);
        this.d = (Toolbar) findViewById(R.id.toolbar);
        this.e = (TextView) findViewById(R.id.toolbar_subtitle);
        this.e.setTag(Boolean.valueOf(true));
        this.f = (LinearLayout) findViewById(R.id.toolbarSubtitleContainer);
        setSupportActionBar(this.d);
        getNfcController();
        if (bundle == null) {
            startFragment(new SelectionFragment(), false, 0, 0);
        } else {
            int i = bundle.getInt("FragmentBackstackCount", 0);
            for (int i2 = 0; i2 < i; i2++) {
                this.b.add(getFragmentManager().getFragment(bundle, String.format("FragmentBackstack%d", new Object[]{Integer.valueOf(i2)})));
            }
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeActionContentDescription(getString(R.string.jumio_accessibility_quit_scan));
            TypedValue typedValue = new TypedValue();
            getTheme().resolveAttribute(R.attr.colorControlNormal, typedValue, true);
            Drawable drawable = CompatibilityLayer.getDrawable(getResources(), R.drawable.jumio_ic_clear);
            drawable.setColorFilter(typedValue.data, Mode.SRC_ATOP);
            getSupportActionBar().setHomeAsUpIndicator(drawable);
            getSupportActionBar().setShowHideAnimationEnabled(false);
        }
        if (!(getRotationManager().isScreenPortrait() || getRotationManager().isTablet())) {
            z = false;
        }
        handleOrientationChange(z, false);
    }

    protected void onStart() {
        super.onStart();
        this.g.a();
    }

    protected void onResume() {
        super.onResume();
        getNfcController().start(this);
        this.g.a((Context) this);
    }

    protected void onPause() {
        super.onPause();
        getNfcController().pause(this);
        this.g.b(this);
    }

    protected void onStop() {
        super.onStop();
        this.g.b();
    }

    public void onDestroy() {
        super.onDestroy();
        getNfcController().stop();
        this.g.c();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        boolean z = configuration.orientation == 1 || getRotationManager().isTablet();
        handleOrientationChange(z, true);
    }

    public void handleOrientationChange(boolean z, boolean z2) {
        this.e.getLayoutParams().height = ScreenUtil.dpToPx((Context) this, z ? 72 : 48);
        ((LayoutParams) findViewById(R.id.spinnerContainer).getLayoutParams()).topMargin = ScreenUtil.dpToPx((Context) this, z ? 88 : 54);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            bundle.putInt("FragmentBackstackCount", this.b.size());
            for (int i = 0; i < this.b.size(); i++) {
                getFragmentManager().putFragment(bundle, String.format("FragmentBackstack%d", new Object[]{Integer.valueOf(i)}), (Fragment) this.b.get(i));
            }
        }
    }

    public void onBackPressed() {
        String str = null;
        JumioAnalytics.add(MobileEvents.userAction(JumioAnalytics.getSessionId(), null, UserAction.BACK));
        if (!(this.c != null ? this.c.onBackButtonPressed() : false)) {
            Object obj = 1;
            if (this.b.size() <= 1) {
                obj = null;
            }
            if (obj != null) {
                closeFragment(0, R.animator.nv_fade_out);
                return;
            }
            InitiateModel initiateModel = (InitiateModel) DataAccess.load((Context) this, InitiateModel.class);
            jumio.nv.core.b bVar = this.g;
            int code = NVErrorCase.CANCEL_TYPE_USER.code();
            String localizedMessage = NVErrorCase.CANCEL_TYPE_USER.localizedMessage(this);
            if (initiateModel != null) {
                str = initiateModel.getJumioScanRef();
            }
            bVar.a(this, new a(code, 0, localizedMessage, str));
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return false;
        }
        if (this.c == null || !this.c.onHomeButtonPressed()) {
            String str = null;
            JumioAnalytics.add(MobileEvents.userAction(JumioAnalytics.getSessionId(), null, UserAction.CLOSE));
            InitiateModel initiateModel = (InitiateModel) DataAccess.load((Context) this, InitiateModel.class);
            jumio.nv.core.b bVar = this.g;
            int code = NVErrorCase.CANCEL_TYPE_USER.code();
            String localizedMessage = NVErrorCase.CANCEL_TYPE_USER.localizedMessage(this);
            if (initiateModel != null) {
                str = initiateModel.getJumioScanRef();
            }
            bVar.a(this, new a(code, 0, localizedMessage, str));
        }
        return true;
    }

    public void registerActivityCallback(INetverifyActivityCallback iNetverifyActivityCallback) {
        this.c = iNetverifyActivityCallback;
    }

    public CredentialsModel getCredentials() {
        return super.getCredentialsModel();
    }

    public void startFragment(Fragment fragment, boolean z, int i, int i2) {
        synchronized (this.a) {
            if (isFinishing()) {
                return;
            }
            this.c = null;
            FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
            beginTransaction.setCustomAnimations(i, i2);
            if (this.b.size() > 0) {
                Fragment fragment2 = (Fragment) this.b.get(this.b.size() - 1);
                if (z) {
                    this.b.remove(fragment2);
                }
                beginTransaction.detach(fragment2);
            }
            if (fragment != null) {
                beginTransaction.add(R.id.fragment_container, fragment);
                this.b.add(fragment);
            }
            try {
                beginTransaction.commitAllowingStateLoss();
            } catch (Throwable e) {
                Log.printStackTrace(e);
            }
        }
    }

    public void closeFragment(int i, int i2) {
        synchronized (this.a) {
            this.c = null;
            if (isFinishing()) {
                return;
            } else if (this.b.size() == 0) {
                return;
            } else {
                Fragment fragment = (Fragment) this.b.get(this.b.size() - 1);
                FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
                beginTransaction.setCustomAnimations(i, i2);
                beginTransaction.remove(fragment);
                this.b.remove(fragment);
                if (this.b.size() > 0) {
                    beginTransaction.attach((Fragment) this.b.get(this.b.size() - 1));
                }
                try {
                    beginTransaction.commitAllowingStateLoss();
                } catch (Throwable e) {
                    Log.printStackTrace(e);
                }
            }
        }
    }

    public NfcController getNfcController() {
        return this.g.c(getApplicationContext());
    }

    public DeviceRotationManager getRotationManager() {
        return this.g.d();
    }

    public void animateActionbar(boolean z, final boolean z2) {
        AnimatorSet animatorSet = new AnimatorSet();
        Toolbar toolbar = this.d;
        String str = "alpha";
        float[] fArr = new float[2];
        float f = 0.5f;
        float f2 = 1.0f;
        fArr[0] = z ? 0.5f : 1.0f;
        if (z) {
            f = 1.0f;
        }
        fArr[1] = f;
        Animator ofFloat = ObjectAnimator.ofFloat(toolbar, str, fArr);
        ofFloat.setDuration(150);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        Builder play = animatorSet.play(ofFloat);
        if (z2 != ((Boolean) this.e.getTag()).booleanValue()) {
            this.e.setTag(Boolean.valueOf(z2));
            TextView textView = this.e;
            String str2 = "alpha";
            float[] fArr2 = new float[2];
            float f3 = 0.0f;
            fArr2[0] = z2 ? 0.0f : 1.0f;
            if (!z2) {
                f2 = 0.0f;
            }
            fArr2[1] = f2;
            Animator ofFloat2 = ObjectAnimator.ofFloat(textView, str2, fArr2);
            ofFloat2.setDuration(150);
            ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
            LinearLayout linearLayout = this.f;
            str2 = "translationY";
            float[] fArr3 = new float[2];
            fArr3[0] = z2 ? (float) (-this.f.getHeight()) : 0.0f;
            if (!z2) {
                f3 = (float) (-this.f.getHeight());
            }
            fArr3[1] = f3;
            Animator ofFloat3 = ObjectAnimator.ofFloat(linearLayout, str2, fArr3);
            ofFloat3.setDuration(150);
            ofFloat3.setInterpolator(new AccelerateDecelerateInterpolator());
            ofFloat3.addListener(new AnimatorListener() {
                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                    if (z2) {
                        NetverifyActivity.this.f.setVisibility(0);
                    }
                }

                public void onAnimationEnd(Animator animator) {
                    if (!z2) {
                        NetverifyActivity.this.f.setVisibility(8);
                    }
                }
            });
            if (z2) {
                play.with(ofFloat3).before(ofFloat2);
            } else {
                play.with(ofFloat2).before(ofFloat3);
            }
        }
        animatorSet.start();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (!getNfcController().consumeIntent(i, intent)) {
            super.onActivityResult(i, i2, intent);
        }
    }

    public void setUiAutomationId(int i) {
        setUiAutomationString(getResources().getString(i));
    }

    public void setUiAutomationString(String str) {
        findViewById(R.id.fragment_container).setContentDescription(str);
    }

    public void finishSDK(Intent intent) {
        synchronized (this.a) {
            intent.setAction("");
            int intExtra = intent.getIntExtra("com.jumio.nv.RESULT", 0);
            intent.removeExtra("com.jumio.nv.RESULT");
            setResult(intExtra, intent);
            finish();
        }
    }
}
