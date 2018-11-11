package com.iqoption.fragment;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import com.google.common.base.Optional;
import com.google.common.util.concurrent.o;
import com.iqoption.activity.LicenseActivity;
import com.iqoption.analytics.EventManager;
import com.iqoption.app.af;
import com.iqoption.app.helpers.p;
import com.iqoption.core.i;
import com.iqoption.d.sp;
import com.iqoption.dto.Event;
import com.iqoption.dto.Event.Builder;
import com.iqoption.dto.PushSetting;
import com.iqoption.dto.entity.iqbus.Subscriptions;
import com.iqoption.dto.entity.iqbus.Subscriptions.Category;
import com.iqoption.dto.entity.iqbus.Subscriptions.Group;
import com.iqoption.fragment.base.g;
import com.iqoption.mobbtech.connect.request.api.f;
import com.iqoption.settings.SettingsViewModel;
import com.iqoption.util.aw;
import com.iqoption.util.v;
import com.iqoption.view.SettingItemView;
import com.iqoption.view.a.a.d;
import com.iqoption.x.R;
import java.util.Iterator;

/* compiled from: SettingsFragment */
public final class cc extends g implements OnClickListener, com.iqoption.view.SettingItemView.a, com.iqoption.view.SettingItemView.b {
    public static final String TAG = "com.iqoption.fragment.cc";
    private com.iqoption.settings.b cqN;
    private com.iqoption.app.managers.feature.b cqO;
    private LayoutInflater cqP;
    private sp cqQ;
    private SettingsViewModel cqR;

    /* compiled from: SettingsFragment */
    private static class c {
        private final cc cqZ;
        private final SettingItemView cra;
        private final PushSetting crb;

        /* synthetic */ c(cc ccVar, SettingItemView settingItemView, PushSetting pushSetting, AnonymousClass1 anonymousClass1) {
            this(ccVar, settingItemView, pushSetting);
        }

        private c(cc ccVar, SettingItemView settingItemView, PushSetting pushSetting) {
            this.cqZ = ccVar;
            this.cra = settingItemView;
            this.crb = pushSetting;
        }
    }

    /* compiled from: SettingsFragment */
    private static class a extends com.iqoption.system.c.b<cc, Subscriptions> {
        /* synthetic */ a(cc ccVar, AnonymousClass1 anonymousClass1) {
            this(ccVar);
        }

        private a(cc ccVar) {
            super((Object) ccVar);
        }

        /* renamed from: a */
        public void z(@NonNull cc ccVar, @NonNull Subscriptions subscriptions) {
            if (!ccVar.isDetached()) {
                ccVar.b(subscriptions);
            }
        }

        /* renamed from: a */
        public void c(@NonNull cc ccVar, Throwable th) {
            if (!ccVar.isDetached()) {
                ccVar.ahM();
            }
        }
    }

    /* compiled from: SettingsFragment */
    private static class b extends com.iqoption.system.c.b<c, Void> implements com.iqoption.mobbtech.connect.request.g.a {
        public b(c cVar) {
            super(cVar, Void.class);
        }

        public void onFinish() {
            c cVar = (c) getReferent();
            if (cVar != null && !cVar.cqZ.isDetached()) {
                cVar.cqZ.a(cVar.cra, cVar.crb);
            }
        }

        public void a(com.iqoption.mobbtech.connect.response.g gVar) {
            c cVar = (c) getReferent();
            if (cVar != null && !cVar.cqZ.isDetached()) {
                cVar.cqZ.a(cVar.cra, cVar.crb, gVar);
            }
        }
    }

    public String gF() {
        return "traderoom-settings";
    }

    public static void i(FragmentManager fragmentManager) {
        if (fragmentManager.findFragmentByTag(TAG) == null) {
            fragmentManager.beginTransaction().add(R.id.other_fragment, new cc(), TAG).addToBackStack(TAG).commit();
        }
    }

    public static void j(FragmentManager fragmentManager) {
        if (fragmentManager.findFragmentByTag(TAG) == null) {
            Fragment ccVar = new cc();
            ccVar.setArguments(new com.iqoption.util.g().v("arg_flag", true).toBundle());
            fragmentManager.beginTransaction().add(R.id.other_fragment, ccVar, TAG).addToBackStack(TAG).commit();
        }
    }

    public View getContentView() {
        return this.cqQ.getRoot();
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.backButton) {
            onClose();
        } else if (id == R.id.openLicenses) {
            getContext().startActivity(LicenseActivity.aI(getContext()));
        }
    }

    public boolean a(@NonNull SettingItemView settingItemView, boolean z) {
        if (z) {
            return false;
        }
        v.b(getContext(), new cd(settingItemView));
        return true;
    }

    public void b(@NonNull SettingItemView settingItemView, boolean z) {
        double d = 0.0d;
        EventManager Bm;
        Builder Builder;
        switch (settingItemView.getId()) {
            case R.id.buyInClickClickSetting:
                this.cqN.eV(z);
                Bm = EventManager.Bm();
                Builder = Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "trading-settings_purchase-buy-oneclick");
                if (z) {
                    d = 1.0d;
                }
                Bm.a(Builder.setValue(Double.valueOf(d)).build());
                return;
            case R.id.expPanelSetting:
                this.cqN.eQ(z);
                Bm = EventManager.Bm();
                Builder = Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "trading-settings_traderoom-expirations-panel");
                if (z) {
                    d = 1.0d;
                }
                Bm.a(Builder.setValue(Double.valueOf(d)).build());
                return;
            case R.id.hiLowChartSetting:
                this.cqN.aT(z);
                Bm = EventManager.Bm();
                Builder = Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "trading-settings_hi-low-chart");
                if (z) {
                    d = 1.0d;
                }
                Bm.a(Builder.setValue(Double.valueOf(d)).build());
                return;
            case R.id.investmentAmountSetting:
                this.cqN.dI(z);
                Bm = EventManager.Bm();
                Builder = Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "trading-settings_investment-amount");
                if (z) {
                    d = 1.0d;
                }
                Bm.a(Builder.setValue(Double.valueOf(d)).build());
                return;
            case R.id.latestMovementsSetting:
                this.cqN.eS(z);
                Bm = EventManager.Bm();
                Builder = Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "trading-settings_latest-movements");
                if (z) {
                    d = 1.0d;
                }
                Bm.a(Builder.setValue(Double.valueOf(d)).build());
                return;
            case R.id.liveDealsSetting:
                this.cqN.setLiveDealsEnabled(z);
                Bm = EventManager.Bm();
                Builder = Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "trading-settings_traderoom-live-deals");
                if (z) {
                    d = 1.0d;
                }
                Bm.a(Builder.setValue(Double.valueOf(d)).build());
                return;
            case R.id.marginAddOnSetting:
                this.cqN.aR(z);
                Bm = EventManager.Bm();
                Builder = Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "settings_enable-margin-add-on");
                if (z) {
                    d = 1.0d;
                }
                Bm.a(Builder.setValue(Double.valueOf(d)).build());
                return;
            case R.id.sellWithConfirmationForexClickSetting:
                this.cqN.eW(z);
                Bm = EventManager.Bm();
                Builder = Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "trading-settings_purchase-sell-with-confirmation-forex");
                if (z) {
                    d = 1.0d;
                }
                Bm.a(Builder.setValue(Double.valueOf(d)).build());
                return;
            case R.id.shareMyLiveDealsSetting:
                this.cqR.eX(z).a(ce.cqT, cf.cpR);
                Bm = EventManager.Bm();
                Builder = Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "trading-settings_traderoom-share-my-live-deals");
                if (z) {
                    d = 1.0d;
                }
                Bm.a(Builder.setValue(Double.valueOf(d)).build());
                return;
            case R.id.sharpJumpSetting:
                this.cqN.eR(z);
                Bm = EventManager.Bm();
                Builder = Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "trading-settings_sharp-jump-movements");
                if (z) {
                    d = 1.0d;
                }
                Bm.a(Builder.setValue(Double.valueOf(d)).build());
                return;
            case R.id.soundSetting:
                this.cqN.eT(z);
                Bm = EventManager.Bm();
                Builder = Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "trading-settings_sound");
                if (z) {
                    d = 1.0d;
                }
                Bm.a(Builder.setValue(Double.valueOf(d)).build());
                return;
            case R.id.topAssetSetting:
                this.cqN.eU(z);
                Bm = EventManager.Bm();
                Builder = Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "trading-settings_top-asset");
                if (z) {
                    d = 1.0d;
                }
                Bm.a(Builder.setValue(Double.valueOf(d)).build());
                return;
            case R.id.tradersMoodSetting:
                this.cqN.bU(z);
                Bm = EventManager.Bm();
                Builder = Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "trading-settings_traderoom-traders-mood");
                if (z) {
                    d = 1.0d;
                }
                Bm.a(Builder.setValue(Double.valueOf(d)).build());
                return;
            case R.id.trailingStopSetting:
                this.cqN.aS(z);
                Bm = EventManager.Bm();
                Builder = Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "settings_enable-trailing-stop-Setting");
                if (z) {
                    d = 1.0d;
                }
                Bm.a(Builder.setValue(Double.valueOf(d)).build());
                return;
            default:
                return;
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.cqN = com.iqoption.settings.b.aDQ();
        this.cqO = com.iqoption.app.managers.feature.b.HT();
    }

    public void onDestroy() {
        super.onDestroy();
        this.cqN = null;
        this.cqO = null;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.cqP = layoutInflater.cloneInContext(new ContextThemeWrapper(getContext(), (int) R.style.PushSettingsTheme));
        boolean z = false;
        this.cqQ = (sp) DataBindingUtil.inflate(this.cqP, R.layout.fragment_traderoom_settings, viewGroup, false);
        this.cqQ.a(this);
        this.cqQ.bDt.setSmoothScrollingEnabled(true);
        this.cqQ.aOU.setOnClickListener(this);
        this.cqQ.bDB.setOnClickListener(this);
        this.cqQ.bDu.setChecked(this.cqN.aDR());
        this.cqQ.bDu.setOnToggleListener(this);
        this.cqQ.bDL.setChecked(this.cqN.MU());
        this.cqQ.bDL.setOnToggleListener(this);
        this.cqQ.bDz.setChecked(this.cqN.MV());
        this.cqQ.bDz.setOnToggleListener(this);
        this.cqQ.bDH.setEnabled(false);
        this.cqQ.bDJ.setChecked(this.cqN.aDU());
        this.cqQ.bDJ.setOnToggleListener(this);
        this.cqQ.bDx.setChecked(this.cqN.aDW());
        this.cqQ.bDx.setOnToggleListener(this);
        this.cqQ.bDs.setChecked(this.cqN.aDX());
        this.cqQ.bDs.setToggleHandler(this);
        this.cqQ.bDs.setOnToggleListener(this);
        this.cqQ.bDG.setChecked(this.cqN.Fq());
        this.cqQ.bDG.setOnToggleListener(this);
        boolean ff = this.cqO.ff("margin-add-on");
        if (ff) {
            this.cqQ.bDA.setChecked(this.cqN.En());
            this.cqQ.bDA.setOnToggleListener(this);
        }
        int i = 8;
        this.cqQ.bDA.setVisibility(ff ? 0 : 8);
        ff = this.cqO.ff("trailing-stop");
        if (ff) {
            this.cqQ.bDM.setChecked(this.cqN.Eo());
            this.cqQ.bDM.setOnToggleListener(this);
        }
        SettingItemView settingItemView = this.cqQ.bDM;
        if (ff) {
            i = 0;
        }
        settingItemView.setVisibility(i);
        this.cqQ.bDI.setChecked(this.cqN.aDS());
        this.cqQ.bDI.setOnToggleListener(this);
        this.cqQ.bDy.setChecked(this.cqN.aDT());
        this.cqQ.bDy.setOnToggleListener(this);
        this.cqQ.bDK.setChecked(this.cqN.aDV());
        this.cqQ.bDK.setOnToggleListener(this);
        ahK();
        ahL();
        if (getArguments() != null && getArguments().getBoolean("arg_flag", false)) {
            z = true;
        }
        if (ff && z) {
            this.cqQ.bDD.post(new cg(this));
        }
        this.cqQ.bDv.setChecked(this.cqN.Ep());
        this.cqQ.bDv.setOnToggleListener(this);
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    final /* synthetic */ void ahN() {
        this.cqQ.bDt.smoothScrollTo(0, this.cqQ.bDD.getTop());
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.cqQ.bDM, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{1.0f, 1.05f, 1.0f, 1.05f, 1.0f}), PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{1.0f, 1.05f, 1.0f, 1.05f, 1.0f})});
        ofPropertyValuesHolder.setDuration(1200);
        ofPropertyValuesHolder.setInterpolator(d.aQW);
        ofPropertyValuesHolder.start();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.cqR = SettingsViewModel.X(this);
        a(this.cqR.aDY().a(new ch(this), new ci(this)));
    }

    final /* synthetic */ void a(Optional optional) {
        boolean z = true;
        this.cqQ.bDH.setEnabled(true);
        Boolean XN = optional.isPresent() ? ((com.iqoption.core.microservices.usersettings.b.a.a) optional.get()).XN() : null;
        this.cqQ.bDH.setOnToggleListener(null);
        SettingItemView settingItemView = this.cqQ.bDH;
        if (XN != null) {
            z = XN.booleanValue();
        }
        settingItemView.setChecked(z);
        this.cqQ.bDH.setOnToggleListener(this);
    }

    final /* synthetic */ void v(Throwable th) {
        this.cqQ.bDH.setEnabled(true);
        this.cqQ.bDH.setOnToggleListener(this);
        i.e("Unable to load user setting", th);
    }

    private void ahK() {
        boolean ff = this.cqO.ff("top-assets");
        boolean ff2 = this.cqO.ff("price-movements");
        boolean Gc = p.Gc();
        if (ff2 || ff || Gc) {
            if (!ff2) {
                this.cqQ.bDI.setVisibility(8);
                this.cqQ.bDy.setVisibility(8);
            } else if (!Gc) {
                this.cqQ.bDy.setVisibility(8);
            }
            if (!ff) {
                this.cqQ.bDK.setVisibility(8);
                return;
            }
            return;
        }
        this.cqQ.bDw.setVisibility(8);
    }

    private void ahL() {
        if (this.cqO.ff("price-movements")) {
            this.cqQ.bDE.setVisibility(8);
            return;
        }
        this.cqQ.bDE.setVisibility(0);
        this.cqQ.bDF.removeAllViews();
        if (com.iqoption.app.managers.feature.b.HT().ff("notification-subscription-ms")) {
            this.cqQ.bDC.setVisibility(0);
            o.a(f.auw(), new a(this, null), com.iqoption.core.d.a.aSe);
            return;
        }
        this.cqQ.bDC.setVisibility(8);
        for (PushSetting pushSetting : com.iqoption.app.managers.a.Gf().Gh()) {
            if (pushSetting.id.intValue() < 5) {
                SettingItemView settingItemView = (SettingItemView) this.cqP.inflate(R.layout.push_setting_item_view, this.cqQ.bDF, false);
                settingItemView.setTag(pushSetting.id);
                settingItemView.setLabel(pushSetting.name);
                settingItemView.setChecked(pushSetting.enabled.booleanValue());
                settingItemView.setOnToggleListener(new cj(this, pushSetting, settingItemView));
                this.cqQ.bDF.addView(settingItemView, new LayoutParams(-1, -2));
            }
        }
    }

    final /* synthetic */ void a(PushSetting pushSetting, SettingItemView settingItemView, SettingItemView settingItemView2, boolean z) {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "settings_push").setParameters(com.iqoption.core.util.i.ZZ().l("push_id", pushSetting.id).aab()).setValue(Double.valueOf(z ? 1.0d : 0.0d)).build());
        com.iqoption.mobbtech.connect.request.g.a((long) pushSetting.id.intValue(), z, new b(new c(this, settingItemView, pushSetting, null)), getContext());
        settingItemView.setProgressVisible(true);
    }

    void b(@Nullable Subscriptions subscriptions) {
        this.cqQ.bDC.setVisibility(8);
        if (subscriptions == null || subscriptions.categories == null) {
            this.cqQ.bDC.setVisibility(8);
            return;
        }
        this.cqQ.bDF.removeAllViews();
        Iterator it = subscriptions.categories.iterator();
        while (it.hasNext()) {
            Category category = (Category) it.next();
            if (category.groups != null) {
                Iterator it2 = category.groups.iterator();
                while (it2.hasNext()) {
                    final Group group = (Group) it2.next();
                    if (group.id.longValue() < 5) {
                        SettingItemView settingItemView = (SettingItemView) this.cqP.inflate(R.layout.push_setting_item_view, this.cqQ.bDF, false);
                        settingItemView.setTag(group.id);
                        settingItemView.setLabel(group.title);
                        settingItemView.setChecked(group.enabled.booleanValue());
                        settingItemView.setOnToggleListener(new com.iqoption.view.SettingItemView.a() {
                            public void b(@NonNull SettingItemView settingItemView, boolean z) {
                                EventManager Bm = EventManager.Bm();
                                String str = Event.CATEGORY_BUTTON_PRESSED;
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("push-settings_");
                                stringBuilder.append(group.id);
                                Bm.a(Event.Builder(str, stringBuilder.toString()).setValue(Double.valueOf(z ? 1.0d : 0.0d)).build());
                                group.enabled = Boolean.valueOf(z);
                                af.aR(cc.this.getContext()).a(group.id.longValue(), group.enabled.booleanValue());
                                f.a(group.id, group.enabled);
                            }
                        });
                        this.cqQ.bDF.addView(settingItemView, new LayoutParams(-1, -2));
                    }
                }
            }
        }
        this.cqQ.bDC.setVisibility(8);
    }

    void ahM() {
        this.cqQ.bDC.setVisibility(8);
        com.iqoption.app.a.b.aT(getContext());
    }

    void a(@NonNull SettingItemView settingItemView, @NonNull PushSetting pushSetting) {
        Iterator it = com.iqoption.app.managers.a.Gf().Gh().iterator();
        while (it.hasNext()) {
            PushSetting pushSetting2 = (PushSetting) it.next();
            if (aw.equals(pushSetting2.id, pushSetting.id)) {
                pushSetting2.enabled = pushSetting.enabled;
                break;
            }
        }
        settingItemView.setProgressVisible(false);
    }

    void a(@NonNull SettingItemView settingItemView, @NonNull PushSetting pushSetting, @NonNull com.iqoption.mobbtech.connect.response.g gVar) {
        Iterator it = com.iqoption.app.managers.a.Gf().Gh().iterator();
        while (it.hasNext()) {
            PushSetting pushSetting2 = (PushSetting) it.next();
            if (pushSetting2.id.intValue() == 16842960) {
                pushSetting2.enabled = Boolean.valueOf(pushSetting.enabled.booleanValue() ^ 1);
                break;
            }
        }
        settingItemView.setChecked(pushSetting.enabled.booleanValue() ^ 1);
        settingItemView.setProgressVisible(false);
        gVar.bG(getContext());
    }
}
