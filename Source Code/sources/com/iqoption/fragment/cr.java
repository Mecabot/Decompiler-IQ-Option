package com.iqoption.fragment;

import android.annotation.SuppressLint;
import android.arch.lifecycle.LiveData;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.util.Pair;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.google.android.gms.analytics.HitBuilders.ScreenViewBuilder;
import com.google.android.gms.analytics.Tracker;
import com.google.common.base.Optional;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.y;
import com.iqoption.activity.TradeRoomActivity;
import com.iqoption.analytics.EventManager;
import com.iqoption.app.IQApp;
import com.iqoption.app.af;
import com.iqoption.app.b.b.m;
import com.iqoption.app.b.b.p;
import com.iqoption.app.managers.ae;
import com.iqoption.app.managers.tab.a.g;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.gl.Graph;
import com.iqoption.core.h.i;
import com.iqoption.core.microservices.popupserver.response.PopupAnchor;
import com.iqoption.core.microservices.popupserver.response.PopupFormat;
import com.iqoption.core.ui.widget.gl.GLGraphSurfaceLifecycleObserver;
import com.iqoption.core.ui.widget.gl.GLGraphSurfaceView;
import com.iqoption.dialog.aa;
import com.iqoption.dialog.j;
import com.iqoption.dialog.r;
import com.iqoption.dialog.u;
import com.iqoption.dto.Balance;
import com.iqoption.dto.Event;
import com.iqoption.dto.Event.Builder;
import com.iqoption.dto.ToastEntity;
import com.iqoption.dto.entity.Feature;
import com.iqoption.dto.entity.Feature.UpdateEvent;
import com.iqoption.dto.entity.iqbus.SignalLegacy;
import com.iqoption.dto.entity.result.KycState;
import com.iqoption.dto.event.OtnEmissionExecuted;
import com.iqoption.fragment.dialog.popup.PopupViewModel;
import com.iqoption.fragment.leftpanel.LeftPanelViewModel;
import com.iqoption.fragment.rightpanel.RightPanelFragment;
import com.iqoption.gl.NativeHandler;
import com.iqoption.gl.NativeHandler.k;
import com.iqoption.gl.NativeHandler.l;
import com.iqoption.gl.NativeHandler.q;
import com.iqoption.mobbtech.connect.request.h;
import com.iqoption.mobbtech.connect.response.CardStatus;
import com.iqoption.portfolio.a.z;
import com.iqoption.service.e.n;
import com.iqoption.signals.SignalsViewModel;
import com.iqoption.traderoom.TradeRoomViewModel;
import com.iqoption.tutorial.StepDoneType;
import com.iqoption.tutorial.TutorialViewModel;
import com.iqoption.tutorial.dictionary.TutorialAction;
import com.iqoption.util.Network;
import com.iqoption.util.ag;
import com.iqoption.util.bf;
import com.iqoption.util.bg;
import com.iqoption.view.ChartTypeView;
import com.iqoption.view.LocalToast;
import com.iqoption.view.MultiAssetSpinner;
import com.iqoption.view.toppanel.TopPanelFragment;
import com.iqoption.widget.CounterView;
import com.iqoption.x.R;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: TradeFragment */
public class cr extends com.iqoption.fragment.base.f implements com.iqoption.fragment.dialog.d.a, com.iqoption.fragment.ex.b {
    public static final String TAG = "com.iqoption.fragment.cr";
    private PopupViewModel aep;
    private TextView agM;
    private TextView bUE;
    private RightPanelFragment crA;
    private TopPanelFragment crB;
    public boolean crC = false;
    public boolean crD = false;
    public a crE = new a(this, null);
    public e crF = new e(this);
    private final h crG = new h(this);
    public final y<Boolean> crH = y.wb();
    private boolean crI = false;
    private boolean crJ;
    @NonNull
    private TradeRoomViewModel crK;
    @Nullable
    private ao crL = null;
    private boolean crM;
    public View crN;
    public ChartTypeView crO;
    private long crP = 0;
    public com.iqoption.gl.a crQ;
    private BroadcastReceiver crR = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            cr.this.a(intent, true);
        }
    };
    private Pair<InstrumentType, long[]> crS = null;
    Builder crT;
    private f crU = new f(this, null);
    private PopupWindow crV;
    private long crW = 0;
    public MultiAssetSpinner cru;
    private View crv;
    private CounterView crw;
    protected ImageView crx;
    protected ViewGroup cry;
    public LocalToast crz;

    /* compiled from: TradeFragment */
    private static class f implements com.iqoption.view.a.b.a {
        private final WeakReference<cr> ckC;

        /* synthetic */ f(cr crVar, TradeFragment$1 tradeFragment$1) {
            this(crVar);
        }

        private f(cr crVar) {
            this.ckC = new WeakReference(crVar);
        }

        public void onTick(long j) {
            cr crVar = (cr) this.ckC.get();
            if (crVar != null && crVar.isAdded()) {
                crVar.bj(j);
            }
        }
    }

    /* compiled from: TradeFragment */
    public static class a extends com.iqoption.system.a.d {
        private final WeakReference<cr> ckC;
        private boolean csg;
        private Runnable csh;

        /* synthetic */ a(cr crVar, TradeFragment$1 tradeFragment$1) {
            this(crVar);
        }

        private a(cr crVar) {
            this.ckC = new WeakReference(crVar);
        }

        @SuppressLint({"CheckResult"})
        @com.google.common.b.e
        public void onUpdateInstrumentParamstEvent(k kVar) {
            int intValue = ((Integer) kVar.getValue()).intValue();
            com.iqoption.charttools.f.arM.fn(com.iqoption.app.managers.tab.a.Il().IE()).l(new dp(intValue)).f(i.Yo()).e(i.Yp()).a(new dq(this), new eb(intValue));
        }

        final /* synthetic */ void u(com.iqoption.charttools.model.indicator.h hVar) {
            cr crVar = (cr) this.ckC.get();
            g IC = com.iqoption.app.managers.tab.a.Il().IC();
            if (crVar != null && crVar.isAdded() && IC != null) {
                TradeRoomViewModel.B(crVar.requireActivity()).d(new com.iqoption.charttools.constructor.c(IC.IM(), IC.getActiveId(), hVar, false));
            }
        }

        @com.google.common.b.e
        public void onAskForSellingPositionEvent(com.iqoption.gl.NativeHandler.a aVar) {
            com.iqoption.core.d.a.aSe.execute(new eh(this, aVar));
        }

        @com.google.common.b.e
        public void onRequestMarginCallEvent(l lVar) {
            if (com.iqoption.app.managers.feature.b.HT().ff("margin-add-on")) {
                com.iqoption.core.d.a.aSe.execute(new ei(this, lVar));
            }
        }

        @com.google.common.b.e
        public void onFeeInfoPressedEvent(NativeHandler.h hVar) {
            com.iqoption.core.d.a.aSe.execute(new ej(this, hVar));
        }

        @com.google.common.b.e
        public void onEmissionExecuted(OtnEmissionExecuted otnEmissionExecuted) {
            com.iqoption.core.d.a.aSe.execute(new ek(this, otnEmissionExecuted));
        }

        @com.google.common.b.e
        public void onTotalPnl(com.iqoption.app.managers.c.g gVar) {
            com.iqoption.core.d.a.aSe.execute(new el(this, gVar));
        }

        @com.google.common.b.e
        public void onTabChanged(com.iqoption.app.managers.tab.a.i iVar) {
            com.iqoption.core.d.a.aSe.execute(new em(this));
        }

        final /* synthetic */ void aiB() {
            cr crVar = (cr) this.ckC.get();
            if (crVar != null) {
                crVar.ahZ();
            }
        }

        @com.google.common.b.e
        public void onAccountGroupIdChange(com.iqoption.app.b.b.i iVar) {
            com.iqoption.core.d.a.aSe.execute(new en(this));
        }

        final /* synthetic */ void aiA() {
            cr crVar = (cr) this.ckC.get();
            if (crVar != null && crVar.isAdded()) {
                crVar.crG.aua();
            }
        }

        @com.google.common.b.e
        public void onAccountActivated(com.iqoption.app.b.b.a aVar) {
            com.iqoption.core.d.a.aSe.execute(new dr(this, aVar));
        }

        @com.google.common.b.e
        public void onLocalToastTapEvent(com.iqoption.view.LocalToast.b bVar) {
            if (this.csh == null) {
                this.csh = new ds(this, bVar);
                com.iqoption.core.d.a.aSe.postDelayed(this.csh, 200);
            }
        }

        @com.google.common.b.e
        public void onVisibleCandlesSizeChangedEvent(q qVar) {
            com.iqoption.core.d.a.aSe.execute(new dt(this, qVar));
        }

        @com.google.common.b.e
        public void onClickSmallDealViewEvent(com.iqoption.gl.NativeHandler.e eVar) {
            com.iqoption.core.d.a.aSe.execute(new du(this, eVar));
        }

        @com.google.common.b.e
        public void onClickTradersMoodViewEvent(com.iqoption.gl.NativeHandler.f fVar) {
            com.iqoption.core.d.a.aSe.execute(new dv(this));
        }

        final /* synthetic */ void aiz() {
            cr crVar = (cr) this.ckC.get();
            if (crVar != null && crVar.isAdded()) {
                crVar.onClickTradersMoodView();
            }
        }

        @com.google.common.b.e
        public void onDeferredOrderExecutedEvent(com.iqoption.mobbtech.connect.response.options.OptionEvents.e eVar) {
            com.iqoption.core.d.a.aSe.execute(new dw(this, eVar));
        }

        @com.google.common.b.e
        public void onDeferredOrderCreatedEvent(com.iqoption.mobbtech.connect.response.options.OptionEvents.d dVar) {
            com.iqoption.core.d.a.aSe.execute(new dx(this, dVar));
        }

        @com.google.common.b.e
        public void onFeatureUpdateEvent(UpdateEvent updateEvent) {
            Optional e = com.google.common.collect.i.c(updateEvent.features).e(dy.$instance);
            if (e.isPresent()) {
                com.iqoption.core.d.a.aSe.execute(new dz(this, "disabled".equalsIgnoreCase(((Feature) e.get()).status) ^ 1));
            }
        }

        final /* synthetic */ void cZ(boolean z) {
            cr crVar = (cr) this.ckC.get();
            if (crVar != null && crVar.isAdded()) {
                if (z) {
                    aa.e(crVar.requireFragmentManager());
                } else {
                    aa.h(crVar.requireFragmentManager());
                }
            }
        }

        @com.google.common.b.e
        public void onKycDaysLeftToVerify(com.iqoption.app.b.b.l lVar) {
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    cr crVar = (cr) a.this.ckC.get();
                    if (crVar != null && crVar.isAdded() && crVar.getView() != null) {
                        crVar.aio();
                    }
                }
            });
        }

        @com.google.common.b.e
        public void onInvestmentAmountSettingChanged(final com.iqoption.settings.a.d dVar) {
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    cr crVar = (cr) a.this.ckC.get();
                    if (crVar != null && crVar.isAdded()) {
                        crVar.crQ.dI(((Boolean) dVar.getValue()).booleanValue());
                    }
                }
            });
        }

        @com.google.common.b.e
        public void onTradersMoodSettingChanged(com.iqoption.settings.a.l lVar) {
            com.iqoption.core.d.a.aSc.execute(new ea(lVar));
        }

        @com.google.common.b.e
        public void onLiveDealsSettingChanged(com.iqoption.settings.a.f fVar) {
            com.iqoption.core.d.a.aSe.execute(new ec(fVar));
        }

        @com.google.common.b.e
        public void onExpirationPanelSettingChanged(final com.iqoption.settings.a.b bVar) {
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    cr crVar = (cr) a.this.ckC.get();
                    if (crVar != null && crVar.isAdded()) {
                        crVar.cX(((Boolean) bVar.getValue()).booleanValue());
                    }
                }
            });
        }

        @com.google.common.b.e
        public void onTickedNotReadCount(p pVar) {
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    cr crVar = (cr) a.this.ckC.get();
                    if (crVar != null && crVar.isAdded()) {
                        crVar.aiq();
                    }
                }
            });
        }

        @com.google.common.b.e
        public void onUpdateKyc(n nVar) {
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    cr crVar = (cr) a.this.ckC.get();
                    if (crVar != null && crVar.isAdded() && crVar.getView() != null) {
                        crVar.aiq();
                    }
                }
            });
        }

        @com.google.common.b.e
        public void onInitializationCompletedEvent(com.iqoption.app.managers.tab.a.d dVar) {
            com.iqoption.core.d.a.aSe.execute(new ed(this));
            com.iqoption.core.d.a.aSc.execute(ee.alc);
        }

        final /* synthetic */ void aiy() {
            cr crVar = (cr) this.ckC.get();
            if (crVar != null && crVar.isAdded()) {
                crVar.aii();
            }
        }

        static final /* synthetic */ void aix() {
            Graph aow = com.iqoption.gl.b.aow();
            com.iqoption.settings.b aDQ = com.iqoption.settings.b.aDQ();
            aow.glchTabSetTradersMoodEnable(aDQ.MU());
            aow.setLiveDealsEnabled(aDQ.MV());
        }

        @com.google.common.b.e
        public void onToastEntity(final ToastEntity toastEntity) {
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    cr crVar = (cr) a.this.ckC.get();
                    if (crVar != null && crVar.isAdded() && crVar.crz != null) {
                        crVar.crz.e(toastEntity).aIn();
                    }
                }
            });
        }

        @com.google.common.b.e
        public void onChangeCommissionPaidEvent(final com.iqoption.app.helpers.a.a aVar) {
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    cr crVar = (cr) a.this.ckC.get();
                    if (crVar != null && crVar.isAdded()) {
                        o.a(crVar.crH, new com.iqoption.system.c.a<Boolean>() {
                            /* renamed from: f */
                            public void onSuccess(Boolean bool) {
                                cr crVar = (cr) a.this.ckC.get();
                                if (crVar != null && crVar.isAdded()) {
                                    aq.a(crVar.zzakw(), crVar.getFragmentManager(), R.id.fragment, aVar.instrumentType, aVar.amd);
                                }
                            }
                        }, com.iqoption.core.d.a.aSe);
                    }
                }
            });
        }

        @com.google.common.b.e
        public void onPersonalDataPolicyChanged(m mVar) {
            com.iqoption.core.d.a.aSe.execute(new ef(this, mVar));
        }

        @com.google.common.b.e
        public void onAccountIsTrial(final com.iqoption.app.b.b.k kVar) {
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    cr crVar = (cr) a.this.ckC.get();
                    if (crVar != null && crVar.isAdded() && crVar.getTradeRoomActivity() != null && !((Boolean) kVar.getValue()).booleanValue()) {
                        crVar.a(crVar.getTradeRoomActivity(), com.iqoption.app.a.aL(crVar.getContext()).CS());
                    }
                }
            });
        }

        @com.google.common.b.e
        public void onTemplateApplied(com.iqoption.charttools.tools.ToolsViewModel.f fVar) {
            com.iqoption.core.d.a.aSe.execute(new eg(this));
        }

        final /* synthetic */ void aiw() {
            cr crVar = (cr) this.ckC.get();
            if (crVar != null && crVar.isAdded()) {
                crVar.ahZ();
            }
        }
    }

    /* compiled from: TradeFragment */
    private class b extends com.iqoption.system.c.b<cr, com.iqoption.microservice.a.b.a> {
        private final boolean csF;

        public b(cr crVar, boolean z) {
            super((Object) crVar);
            this.csF = z;
        }

        /* renamed from: a */
        public void z(@NonNull cr crVar, @NonNull com.iqoption.microservice.a.b.a aVar) {
            super.z(crVar, aVar);
            if (crVar.isAdded()) {
                crVar.a(aVar, this.csF);
            }
        }
    }

    /* compiled from: TradeFragment */
    private class c extends com.iqoption.system.c.b<cr, Boolean> {
        private final int activeId;
        private final InstrumentType instrumentType;

        c(cr crVar, Bundle bundle) {
            super(crVar, Boolean.class);
            this.activeId = Integer.parseInt(bundle.getString("active_id"));
            this.instrumentType = InstrumentType.fromServerValueNullable(bundle.getString("instrument_type"));
        }

        c(cr crVar, InstrumentType instrumentType, int i) {
            super(crVar, Boolean.class);
            this.activeId = i;
            this.instrumentType = instrumentType;
        }

        /* renamed from: a */
        public void z(@NonNull cr crVar, @NonNull Boolean bool) {
            if (this.activeId != 0 && this.instrumentType != null && com.iqoption.app.helpers.a.FI().a(Integer.valueOf(this.activeId), this.instrumentType) != null) {
                com.iqoption.app.managers.tab.a.Il().d(this.activeId, this.instrumentType);
            }
        }
    }

    /* compiled from: TradeFragment */
    private class d extends com.iqoption.system.c.b<cr, Boolean> {
        d(cr crVar) {
            super(crVar, Boolean.class);
        }

        /* renamed from: a */
        public void z(@NonNull cr crVar, @NonNull Boolean bool) {
            if ((com.iqoption.app.managers.feature.a.eX("iq-quiz") || com.iqoption.app.managers.feature.a.HN()) && crVar.zzakw() != null) {
                LeftPanelViewModel.l(crVar.zzakw()).e(com.iqoption.fragment.leftpanel.b.d.cDQ);
            }
        }
    }

    /* compiled from: TradeFragment */
    private static class e extends com.iqoption.system.a.i<cr> {
        public e(cr crVar) {
            super(crVar);
        }

        @com.google.common.b.e
        public void onTopTradersEvent(com.iqoption.service.e.k kVar) {
            com.iqoption.core.d.a.aSc.execute(new eo(kVar));
        }

        @com.google.common.b.e
        public void onSignalIsShown(com.iqoption.fragment.b.c.a aVar) {
            com.iqoption.core.d.a.aSe.execute(new ep(this));
        }

        final /* synthetic */ void aiI() {
            cr crVar = (cr) this.drU.get();
            if (crVar != null && crVar.isAdded() && crVar.getView() != null) {
                com.iqoption.fragment.b.a.aof().a(crVar.getContext(), crVar.getView().getRootView(), 0);
            }
        }

        @com.google.common.b.e
        public void onUpdateKYC(n nVar) {
            com.iqoption.core.d.a.aSe.execute(new eq(this));
        }

        final /* synthetic */ void aiH() {
            cr crVar = (cr) this.drU.get();
            if (crVar != null && crVar.isAdded()) {
                crVar.aiq();
            }
        }

        @com.google.common.b.e
        public void onLoyalShow(com.iqoption.service.e.f fVar) {
            com.iqoption.core.d.a.aSe.execute(new er(this));
        }

        final /* synthetic */ void aiG() {
            cr crVar = (cr) this.drU.get();
            if (crVar != null && crVar.isAdded()) {
                crVar.aig();
            }
        }

        @com.google.common.b.e
        public void onShowRelogin(com.iqoption.service.e.h hVar) {
            com.iqoption.core.d.a.aSe.execute(new es(this));
        }

        final /* synthetic */ void aiF() {
            cr crVar = (cr) this.drU.get();
            if (crVar != null && crVar.isAdded()) {
                crVar.getTradeRoomActivity().Ao();
            }
        }

        @com.google.common.b.e
        public void onChangeBalanceType(com.iqoption.service.e.b bVar) {
            com.iqoption.core.i.d(cr.TAG, "BALANCE onChangeBalanceType");
            com.iqoption.core.d.a.aSe.execute(new et(this, bVar));
        }

        @com.google.common.b.e
        public void onUpdateBalanceValue(com.iqoption.service.e.m mVar) {
            com.iqoption.core.d.a.aSe.execute(new eu(this));
        }

        final /* synthetic */ void aiE() {
            cr crVar = (cr) this.drU.get();
            if (crVar != null && crVar.isAdded()) {
                crVar.ahc();
            }
        }

        @com.google.common.b.e
        public void onChangeCurrentCurrency(com.iqoption.service.e.c cVar) {
            com.iqoption.core.d.a.aSe.execute(new ev(this));
        }

        final /* synthetic */ void aiD() {
            cr crVar = (cr) this.drU.get();
            if (crVar != null && crVar.isAdded()) {
                crVar.aid();
            }
        }

        @com.google.common.b.e
        public void onSocketClosedAfterForeground(com.iqoption.service.e.i iVar) {
            com.iqoption.core.d.a.aSe.execute(new ew(this));
        }

        final /* synthetic */ void aiC() {
            cr crVar = (cr) this.drU.get();
            if (crVar != null && crVar.isAdded()) {
                crVar.crI = true;
            }
        }
    }

    public void aiq() {
    }

    public void air() {
    }

    public static cr ahX() {
        return new cr();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.crG.g(getTradeRoomActivity());
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.trade_room, viewGroup, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        setRetainInstance(false);
        this.crK = TradeRoomViewModel.B(requireActivity());
        this.aep = PopupViewModel.j(requireActivity());
        com.iqoption.traderoom.a aVar = new com.iqoption.traderoom.a(this);
        LiveData aeS = this.crK.aeS();
        aVar.getClass();
        aeS.observe(this, cs.a(aVar));
        getLifecycle().a(new TradeFragment$1(this));
        Y(view);
        aR(view);
        aia();
        a(requireActivity().getIntent(), false);
        this.crF.register();
        com.iqoption.app.helpers.a.FI().clear();
        com.iqoption.app.managers.a.k.HB().clear();
        com.iqoption.app.managers.tab.a.Il().a(this);
        this.crG.aua();
    }

    private void cT(boolean z) {
        com.iqoption.fragment.leftmenu.h.alI().setCardVerificationFailed(z);
    }

    private void aB(@NonNull List<com.iqoption.mobbtech.connect.response.q> list) {
        for (com.iqoption.mobbtech.connect.response.q a : list) {
            a(a);
        }
    }

    private void a(@NonNull com.iqoption.mobbtech.connect.response.q qVar) {
        String string;
        int i;
        String number = qVar.getNumber();
        number = number.substring(number.length() - 4);
        CardStatus auX = qVar.auX();
        switch (auX) {
            case VERIFIED:
                string = getString(R.string.your_card_n1_has_been_verified, number);
                i = R.drawable.local_toast_type_indicator_green;
                break;
            case DECLINED:
                number = getString(R.string.your_verification_request_for_the_card_n1_declined, number);
                break;
            case FAILED:
                number = getString(R.string.your_card_verification_has_failed);
                break;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unexpected status for toast: ");
                stringBuilder.append(auX);
                throw new IllegalStateException(stringBuilder.toString());
        }
        string = number;
        i = R.drawable.local_toast_type_indicator_red;
        this.crz.a(i, qVar.getId(), string, 4000, new ct(this, qVar)).aIn();
    }

    private void aR(View view) {
        this.crA = (RightPanelFragment) getChildFragmentManager().findFragmentById(R.id.instrumentFragment);
        this.crB = (TopPanelFragment) getChildFragmentManager().findFragmentById(R.id.shortOpenOption);
        this.crN = view.findViewById(R.id.buttonTools);
        this.crN.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                view.setSelected(true);
                cr.this.crK.eY(false);
                com.iqoption.charttools.tools.d.aAz.Np();
            }
        });
        this.crO = (ChartTypeView) view.findViewById(R.id.buttonChartType);
        this.crO.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                TutorialViewModel.D(cr.this.zzakw()).a(TutorialAction.CHART_TYPE, StepDoneType.TAP_ON_TARGET);
                cr.this.getFragmentManager().beginTransaction().add(R.id.fragment, aj.ahg(), aj.TAG).addToBackStack(aj.TAG).commit();
                cr.this.crO.setSelected(true);
            }
        });
        aip();
    }

    public void eD(int i) {
        if (System.currentTimeMillis() - this.crP >= 1000 && this.crz != null) {
            this.crP = System.currentTimeMillis();
            g IC = com.iqoption.app.managers.tab.a.Il().IC();
            if (IC != null) {
                String string = getString(IC.IX().chartType == 3 ? R.string.bars : R.string.candles);
                final Builder Builder = Event.Builder(Event.CATEGORY_POPUP_SERVED, "traderoom_unable-to-scale");
                this.crz.a(R.drawable.local_toast_type_indicator_red, 2131820781, getString(R.string.cannot_show_selected_scale_for_current_size, bf.gI(i), string), 4000, new com.iqoption.a.b.a() {
                    public void a(View view, int i) {
                        EventManager.Bm().a(Builder.calcDuration().setValue(Double.valueOf((double) i)).build());
                    }
                }).aIn();
            }
        }
    }

    public void ahY() {
        this.crz.a((int) R.drawable.local_toast_type_indicator_green, 2131822929, getString(R.string.your_email_address_has_been_linked_to_the_account), getString(R.string.security_settings), 30000).aIn();
    }

    public void ahZ() {
        g IC = com.iqoption.app.managers.tab.a.Il().IC();
        if (IC != null) {
            com.iqoption.app.managers.tab.a.h IX = IC.IX();
            this.crO.aB(IX.chartType, IX.candleSize);
            this.crO.setIsShowDot(IX.apB);
        }
    }

    private void aia() {
        Object Ec = af.aR(zzakw()).Ec();
        Object Ed = af.aR(zzakw()).Ed();
        if (!TextUtils.isEmpty(Ed) || !TextUtils.isEmpty(Ec)) {
            new r(getTradeRoomActivity(), Ed, Ec).show();
        }
    }

    private void Y(View view) {
        GLGraphSurfaceView gLGraphSurfaceView = (GLGraphSurfaceView) view.findViewById(R.id.glGraphView);
        getLifecycle().a(new GLGraphSurfaceLifecycleObserver(gLGraphSurfaceView));
        this.crQ = new com.iqoption.gl.a(requireContext(), com.iqoption.gl.b.aow());
        gLGraphSurfaceView.setController(this.crQ);
        this.cru = (MultiAssetSpinner) view.findViewById(R.id.multiAssetSpinner);
        this.cry = (ViewGroup) view.findViewById(R.id.balanceCell);
        this.cry.setLayoutTransition(bg.aGE());
        OnClickListener anonymousClass5 = new com.iqoption.view.d.b() {
            public void q(View view) {
                com.iqoption.app.a aL = com.iqoption.app.a.aL(cr.this.zzakw());
                if (aL.Cz() == null || aL.Cz().size() == 0) {
                    cr.this.crK.a(new do(this, view));
                    return;
                }
                if (cr.this.cry.isSelected()) {
                    cr.this.cry.setSelected(false);
                    ad adVar = (ad) cr.this.getFragmentManager().findFragmentByTag("BalanceFragment");
                    if (adVar != null) {
                        adVar.onBackPressed();
                    }
                } else {
                    cr.this.cry.setSelected(true);
                    cr.this.getFragmentManager().beginTransaction().add(R.id.fragment, ad.eu(0), "BalanceFragment").addToBackStack("BalanceFragment").commit();
                }
                cr.this.crx.animate().rotation(270.0f).setInterpolator(com.iqoption.view.a.a.d.dEM).start();
            }

            final /* synthetic */ void aS(View view) {
                cr.this.ahc();
                q(view);
            }
        };
        this.crv = view.findViewById(R.id.badConnection);
        View findViewById = view.findViewById(R.id.totalBalanceTitle);
        this.agM = (TextView) view.findViewById(R.id.totalBalance);
        this.crx = (ImageView) view.findViewById(R.id.arrow_balance);
        this.crw = (CounterView) view.findViewById(R.id.balance);
        this.crw.setOnClickListener(anonymousClass5);
        this.crx.setOnClickListener(anonymousClass5);
        this.agM.setOnClickListener(anonymousClass5);
        findViewById.setOnClickListener(anonymousClass5);
        this.bUE = (TextView) view.findViewById(R.id.deposit);
        this.bUE.setOnTouchListener(new com.iqoption.view.d.d());
        this.bUE.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                if (com.iqoption.app.a.Cw().CZ()) {
                    com.iqoption.welcomeonboarding.registration.f.a(cr.this.zzakw(), cr.this.getFragmentManager());
                    EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "traderoom_open-account").build());
                    return;
                }
                cr.this.getTradeRoomActivity().Aq();
                EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "traderoom_deposit").build());
            }
        });
        this.crz = (LocalToast) view.findViewById(R.id.localToast);
        cU(false);
    }

    public void onNewIntent(Intent intent) {
        a(intent, false);
    }

    private void a(Intent intent, boolean z) {
        if (intent != null) {
            Bundle extras = intent.getExtras();
            if (extras != null && !u(intent)) {
                b(extras, z);
            }
        }
    }

    /* JADX WARNING: Missing block: B:53:0x00e0, code:
            if (r4.equals("1") != false) goto L_0x00e4;
     */
    public void b(android.os.Bundle r18, boolean r19) {
        /*
        r17 = this;
        r7 = r17;
        r0 = r18;
        r1 = r19;
        r2 = 0;
        r7.crJ = r2;
        if (r0 == 0) goto L_0x0241;
    L_0x000b:
        r3 = r17.isAdded();
        if (r3 != 0) goto L_0x0013;
    L_0x0011:
        goto L_0x0241;
    L_0x0013:
        r3 = "push_id";
        r3 = r0.getString(r3);	 Catch:{ Exception -> 0x0240 }
        r4 = "token_id";
        r4 = r0.getString(r4);	 Catch:{ Exception -> 0x0240 }
        r5 = android.text.TextUtils.isEmpty(r3);	 Catch:{ Exception -> 0x0240 }
        r6 = 0;
        if (r5 != 0) goto L_0x003d;
    L_0x0027:
        r5 = android.text.TextUtils.isEmpty(r4);	 Catch:{ Exception -> 0x0240 }
        if (r5 != 0) goto L_0x003d;
    L_0x002d:
        r4 = com.google.common.primitives.Longs.cN(r4);	 Catch:{ Exception -> 0x0240 }
        r3 = com.google.common.primitives.Longs.cN(r3);	 Catch:{ Exception -> 0x0240 }
        if (r3 == 0) goto L_0x003e;
    L_0x0037:
        if (r4 == 0) goto L_0x003e;
    L_0x0039:
        com.iqoption.mobbtech.connect.request.api.f.a(r3, r4);	 Catch:{ Exception -> 0x0240 }
        goto L_0x003e;
    L_0x003d:
        r3 = r6;
    L_0x003e:
        r4 = "type";
        r4 = r0.getString(r4);	 Catch:{ Exception -> 0x0240 }
        r5 = android.text.TextUtils.isEmpty(r4);	 Catch:{ Exception -> 0x0240 }
        if (r5 == 0) goto L_0x004c;
    L_0x004b:
        return;
    L_0x004c:
        r5 = "o_type";
        r5 = r0.getString(r5);	 Catch:{ Exception -> 0x0240 }
        r8 = "a_id";
        r8 = r0.getString(r8);	 Catch:{ Exception -> 0x0240 }
        r9 = com.iqoption.app.managers.feature.b.HT();	 Catch:{ Exception -> 0x0240 }
        r10 = -1;
        r11 = r4.hashCode();	 Catch:{ Exception -> 0x0240 }
        switch(r11) {
            case 49: goto L_0x00da;
            case 50: goto L_0x00d0;
            case 1601: goto L_0x00c5;
            case 1602: goto L_0x00bb;
            case 1603: goto L_0x00b1;
            case 1605: goto L_0x00a7;
            case 1660: goto L_0x009d;
            case 1664: goto L_0x0092;
            case 1665: goto L_0x0087;
            case 1667: goto L_0x007d;
            case 1668: goto L_0x0071;
            case 1691: goto L_0x0066;
            default: goto L_0x0064;
        };	 Catch:{ Exception -> 0x0240 }
    L_0x0064:
        goto L_0x00e3;
    L_0x0066:
        r2 = "50";
        r2 = r4.equals(r2);	 Catch:{ Exception -> 0x0240 }
        if (r2 == 0) goto L_0x00e3;
    L_0x006e:
        r2 = 6;
        goto L_0x00e4;
    L_0x0071:
        r2 = "48";
        r2 = r4.equals(r2);	 Catch:{ Exception -> 0x0240 }
        if (r2 == 0) goto L_0x00e3;
    L_0x0079:
        r2 = 10;
        goto L_0x00e4;
    L_0x007d:
        r2 = "47";
        r2 = r4.equals(r2);	 Catch:{ Exception -> 0x0240 }
        if (r2 == 0) goto L_0x00e3;
    L_0x0085:
        r2 = 4;
        goto L_0x00e4;
    L_0x0087:
        r2 = "45";
        r2 = r4.equals(r2);	 Catch:{ Exception -> 0x0240 }
        if (r2 == 0) goto L_0x00e3;
    L_0x008f:
        r2 = 9;
        goto L_0x00e4;
    L_0x0092:
        r2 = "44";
        r2 = r4.equals(r2);	 Catch:{ Exception -> 0x0240 }
        if (r2 == 0) goto L_0x00e3;
    L_0x009a:
        r2 = 8;
        goto L_0x00e4;
    L_0x009d:
        r2 = "40";
        r2 = r4.equals(r2);	 Catch:{ Exception -> 0x0240 }
        if (r2 == 0) goto L_0x00e3;
    L_0x00a5:
        r2 = 7;
        goto L_0x00e4;
    L_0x00a7:
        r2 = "27";
        r2 = r4.equals(r2);	 Catch:{ Exception -> 0x0240 }
        if (r2 == 0) goto L_0x00e3;
    L_0x00af:
        r2 = 5;
        goto L_0x00e4;
    L_0x00b1:
        r2 = "25";
        r2 = r4.equals(r2);	 Catch:{ Exception -> 0x0240 }
        if (r2 == 0) goto L_0x00e3;
    L_0x00b9:
        r2 = 3;
        goto L_0x00e4;
    L_0x00bb:
        r2 = "24";
        r2 = r4.equals(r2);	 Catch:{ Exception -> 0x0240 }
        if (r2 == 0) goto L_0x00e3;
    L_0x00c3:
        r2 = 2;
        goto L_0x00e4;
    L_0x00c5:
        r2 = "23";
        r2 = r4.equals(r2);	 Catch:{ Exception -> 0x0240 }
        if (r2 == 0) goto L_0x00e3;
    L_0x00cd:
        r2 = 11;
        goto L_0x00e4;
    L_0x00d0:
        r2 = "2";
        r2 = r4.equals(r2);	 Catch:{ Exception -> 0x0240 }
        if (r2 == 0) goto L_0x00e3;
    L_0x00d8:
        r2 = 1;
        goto L_0x00e4;
    L_0x00da:
        r11 = "1";
        r11 = r4.equals(r11);	 Catch:{ Exception -> 0x0240 }
        if (r11 == 0) goto L_0x00e3;
    L_0x00e2:
        goto L_0x00e4;
    L_0x00e3:
        r2 = -1;
    L_0x00e4:
        switch(r2) {
            case 0: goto L_0x01c2;
            case 1: goto L_0x01c2;
            case 2: goto L_0x0195;
            case 3: goto L_0x0183;
            case 4: goto L_0x0177;
            case 5: goto L_0x0163;
            case 6: goto L_0x0159;
            case 7: goto L_0x0159;
            case 8: goto L_0x012c;
            case 9: goto L_0x011a;
            case 10: goto L_0x010e;
            case 11: goto L_0x00ec;
            default: goto L_0x00e7;
        };	 Catch:{ Exception -> 0x0240 }
    L_0x00e7:
        r1 = "text";
        goto L_0x01f0;
    L_0x00ec:
        r0 = android.text.TextUtils.isEmpty(r8);	 Catch:{ Exception -> 0x0240 }
        if (r0 != 0) goto L_0x0240;
    L_0x00f2:
        r0 = android.text.TextUtils.isEmpty(r5);	 Catch:{ Exception -> 0x0240 }
        if (r0 != 0) goto L_0x0240;
    L_0x00f8:
        r0 = java.lang.Integer.parseInt(r8);	 Catch:{ Exception -> 0x0240 }
        r1 = java.lang.Integer.parseInt(r5);	 Catch:{ Exception -> 0x0240 }
        r1 = com.iqoption.core.microservices.tradingengine.response.active.a.dP(r1);	 Catch:{ Exception -> 0x0240 }
        r2 = new com.iqoption.fragment.cr$c;	 Catch:{ Exception -> 0x0240 }
        r2.<init>(r7, r1, r0);	 Catch:{ Exception -> 0x0240 }
        r7.a(r2);	 Catch:{ Exception -> 0x0240 }
        goto L_0x0240;
    L_0x010e:
        r0 = r7.crH;	 Catch:{ Exception -> 0x0240 }
        r1 = new com.iqoption.fragment.cr$d;	 Catch:{ Exception -> 0x0240 }
        r1.<init>(r7);	 Catch:{ Exception -> 0x0240 }
        com.iqoption.util.ag.b(r0, r1);	 Catch:{ Exception -> 0x0240 }
        goto L_0x0240;
    L_0x011a:
        r2 = "invitation_type";
        r2 = r0.getString(r2);	 Catch:{ Exception -> 0x0240 }
        r3 = "text";
        r0 = r0.getString(r3);	 Catch:{ Exception -> 0x0240 }
        r7.g(r2, r0, r1);	 Catch:{ Exception -> 0x0240 }
        goto L_0x0240;
    L_0x012c:
        r2 = "id";
        r2 = r0.getString(r2);	 Catch:{ Exception -> 0x0240 }
        r9 = java.lang.Long.parseLong(r2);	 Catch:{ Exception -> 0x0240 }
        r2 = "card_number";
        r11 = r0.getString(r2);	 Catch:{ Exception -> 0x0240 }
        r2 = "expired";
        r12 = r0.getString(r2);	 Catch:{ Exception -> 0x0240 }
        r2 = "status";
        r0 = r0.getString(r2);	 Catch:{ Exception -> 0x0240 }
        r13 = com.iqoption.mobbtech.connect.response.CardStatus.fromServerValue(r0);	 Catch:{ Exception -> 0x0240 }
        r0 = new com.iqoption.mobbtech.connect.response.q;	 Catch:{ Exception -> 0x0240 }
        r14 = 0;
        r8 = r0;
        r8.<init>(r9, r11, r12, r13, r14);	 Catch:{ Exception -> 0x0240 }
        r7.a(r0, r1);	 Catch:{ Exception -> 0x0240 }
        goto L_0x0240;
    L_0x0159:
        r1 = new com.iqoption.fragment.cr$c;	 Catch:{ Exception -> 0x0240 }
        r1.<init>(r7, r0);	 Catch:{ Exception -> 0x0240 }
        r7.a(r1);	 Catch:{ Exception -> 0x0240 }
        goto L_0x0240;
    L_0x0163:
        r0 = "margin-add-on";
        r0 = r9.ff(r0);	 Catch:{ Exception -> 0x0240 }
        if (r0 == 0) goto L_0x0240;
    L_0x016b:
        r0 = r17.getFragmentManager();	 Catch:{ Exception -> 0x0240 }
        r1 = 2131362845; // 0x7f0a041d float:1.8345482E38 double:1.0530331605E-314;
        com.iqoption.fragment.bg.a(r0, r1);	 Catch:{ Exception -> 0x0240 }
        goto L_0x0240;
    L_0x0177:
        r1 = r7.crH;	 Catch:{ Exception -> 0x0240 }
        r2 = new com.iqoption.fragment.cr$c;	 Catch:{ Exception -> 0x0240 }
        r2.<init>(r7, r0);	 Catch:{ Exception -> 0x0240 }
        com.iqoption.util.ag.b(r1, r2);	 Catch:{ Exception -> 0x0240 }
        goto L_0x0240;
    L_0x0183:
        r1 = "pending-order";
        r1 = r9.ff(r1);	 Catch:{ Exception -> 0x0240 }
        if (r1 == 0) goto L_0x0240;
    L_0x018b:
        r1 = new com.iqoption.fragment.cr$c;	 Catch:{ Exception -> 0x0240 }
        r1.<init>(r7, r0);	 Catch:{ Exception -> 0x0240 }
        r7.a(r1);	 Catch:{ Exception -> 0x0240 }
        goto L_0x0240;
    L_0x0195:
        r1 = "otn-token";
        r1 = r9.fg(r1);	 Catch:{ Exception -> 0x0240 }
        if (r1 == 0) goto L_0x0240;
    L_0x019d:
        r1 = "count";
        r1 = r0.getString(r1);	 Catch:{ Exception -> 0x0240 }
        r1 = com.iqoption.dto.event.OtnEmissionExecuted.parseCount(r1);	 Catch:{ Exception -> 0x0240 }
        r3 = "commission_volume_enrolled";
        r3 = r0.getString(r3);	 Catch:{ Exception -> 0x0240 }
        r3 = java.lang.Double.parseDouble(r3);	 Catch:{ Exception -> 0x0240 }
        r5 = "total_commissions_enrolled";
        r0 = r0.getString(r5);	 Catch:{ Exception -> 0x0240 }
        r5 = java.lang.Double.parseDouble(r0);	 Catch:{ Exception -> 0x0240 }
        r0 = r7;
        r0.d(r1, r3, r5);	 Catch:{ Exception -> 0x0240 }
        goto L_0x0240;
    L_0x01c2:
        r1 = "positions";
        r0 = r0.getString(r1);	 Catch:{ Exception -> 0x0240 }
        r1 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Exception -> 0x0240 }
        if (r1 != 0) goto L_0x0240;
    L_0x01ce:
        r1 = android.text.TextUtils.isEmpty(r5);	 Catch:{ Exception -> 0x0240 }
        if (r1 != 0) goto L_0x0240;
    L_0x01d4:
        r1 = java.lang.Integer.parseInt(r5);	 Catch:{ Exception -> 0x0240 }
        r1 = com.iqoption.core.microservices.tradingengine.response.active.a.dP(r1);	 Catch:{ Exception -> 0x0240 }
        r2 = com.iqoption.util.ah.aGg();	 Catch:{ Exception -> 0x0240 }
        r3 = long[].class;
        r0 = r2.fromJson(r0, r3);	 Catch:{ Exception -> 0x0240 }
        r0 = (long[]) r0;	 Catch:{ Exception -> 0x0240 }
        r2 = new android.support.v4.util.Pair;	 Catch:{ Exception -> 0x0240 }
        r2.<init>(r1, r0);	 Catch:{ Exception -> 0x0240 }
        r7.crS = r2;	 Catch:{ Exception -> 0x0240 }
        goto L_0x0240;
    L_0x01f0:
        r13 = r0.getString(r1);	 Catch:{ Exception -> 0x0240 }
        r0 = android.text.TextUtils.isEmpty(r13);	 Catch:{ Exception -> 0x0240 }
        if (r0 != 0) goto L_0x0240;
    L_0x01fa:
        r11 = 2131822122; // 0x7f11062a float:1.9277007E38 double:1.0532600735E-314;
        r0 = android.text.TextUtils.isEmpty(r8);	 Catch:{ Exception -> 0x0240 }
        if (r0 != 0) goto L_0x022d;
    L_0x0203:
        r0 = android.text.TextUtils.isEmpty(r5);	 Catch:{ Exception -> 0x0240 }
        if (r0 != 0) goto L_0x022d;
    L_0x0209:
        r0 = java.lang.Integer.parseInt(r8);	 Catch:{ Exception -> 0x0240 }
        r1 = java.lang.Integer.parseInt(r5);	 Catch:{ Exception -> 0x0240 }
        r1 = com.iqoption.core.microservices.tradingengine.response.active.a.dP(r1);	 Catch:{ Exception -> 0x0240 }
        if (r1 != 0) goto L_0x021f;
    L_0x0217:
        r1 = com.iqoption.app.helpers.a.FI();	 Catch:{ Exception -> 0x0240 }
        r1 = r1.cY(r0);	 Catch:{ Exception -> 0x0240 }
    L_0x021f:
        r2 = new com.iqoption.fragment.ao;	 Catch:{ Exception -> 0x0240 }
        r2.<init>(r0, r1, r3, r4);	 Catch:{ Exception -> 0x0240 }
        r7.crL = r2;	 Catch:{ Exception -> 0x0240 }
        r0 = 2131821911; // 0x7f110557 float:1.9276579E38 double:1.0532599693E-314;
        r6 = r7.getString(r0);	 Catch:{ Exception -> 0x0240 }
    L_0x022d:
        r14 = r6;
        r0 = r7.crz;	 Catch:{ Exception -> 0x0240 }
        if (r0 == 0) goto L_0x0240;
    L_0x0232:
        r9 = r7.crz;	 Catch:{ Exception -> 0x0240 }
        r10 = 2131232269; // 0x7f08060d float:1.8080642E38 double:1.0529686474E-314;
        r15 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r0 = r9.a(r10, r11, r13, r14, r15);	 Catch:{ Exception -> 0x0240 }
        r0.aIn();	 Catch:{ Exception -> 0x0240 }
    L_0x0240:
        return;
    L_0x0241:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.fragment.cr.b(android.os.Bundle, boolean):void");
    }

    private void a(@NonNull c cVar) {
        this.crJ = true;
        ag.b(this.crH, cVar);
    }

    private boolean u(Intent intent) {
        if (!isAdded() || intent == null || !intent.hasExtra("signal")) {
            return false;
        }
        com.iqoption.core.i.v(TAG, "signal from intent");
        final SignalLegacy fromJson = SignalLegacy.fromJson(intent.getStringExtra("signal"));
        if (fromJson == null) {
            return false;
        }
        com.iqoption.core.d.a.aSe.postDelayed(new Runnable() {
            public void run() {
                if (cr.this.isAdded() && cr.this.getView() != null) {
                    com.iqoption.a.p.a(fromJson, cr.this.getView());
                }
            }
        }, 3000);
        intent.removeExtra("signal");
        return true;
    }

    public double UO() {
        return this.crA.UO();
    }

    public boolean aib() {
        if (!isAdded() || !af.aR(zzakw()).Es().booleanValue() || !com.iqoption.dialog.c.bk(getContext()) || (!Locale.getDefault().getLanguage().equals("ru") && !Locale.getDefault().getLanguage().equals("en"))) {
            return false;
        }
        com.iqoption.dialog.c.a(getContext(), getFragmentManager());
        com.iqoption.dialog.c.d(getContext(), false);
        return true;
    }

    public void aic() {
        com.iqoption.util.l.aGb();
    }

    public void aid() {
        aic();
    }

    public void hB(String str) {
        if (this.crw != null) {
            this.crw.setValue(str);
        }
    }

    public void eE(@ColorRes int i) {
        if (this.crw != null) {
            ColorStateList colorStateList = ContextCompat.getColorStateList(getContext(), i);
            this.crw.setTextColor(colorStateList);
            this.agM.setTextColor(colorStateList);
        }
    }

    private void a(com.iqoption.app.managers.c.g gVar) {
        if (this.agM != null) {
            this.agM.setText(com.iqoption.util.l.q(Double.valueOf(com.iqoption.app.a.aL(getContext()).Cx().doubleValue() + gVar.GO())));
        }
    }

    public void ahc() {
        if (isAdded()) {
            com.iqoption.app.a Cw = com.iqoption.app.a.Cw();
            hB(Cw.getBalanceText());
            a(com.iqoption.app.managers.c.Gn().GA());
            b(Cw);
            a(Cw);
        }
    }

    private void a(com.iqoption.app.a aVar) {
        j.a(requireActivity(), requireFragmentManager(), aVar);
    }

    private void b(com.iqoption.app.a aVar) {
        af DX = af.DX();
        if (!DX.Ez()) {
            if ((aVar.CZ() || aVar.Cy() == 4) && aVar.Cx().doubleValue() >= 40000.0d) {
                IQApp.a("achieve_40000", null);
                DX.aU(true);
            }
        }
    }

    public void cU(boolean z) {
        if (isAdded()) {
            com.iqoption.app.a aL = com.iqoption.app.a.aL(zzakw());
            if (aL.CZ()) {
                this.bUE.setText(getString(R.string.deposit_with_real_money));
                eE(R.color.selectable_orange_100_to_75);
            } else {
                SpannableString spannableString;
                this.bUE.setTextColor(ContextCompat.getColor(requireContext(), R.color.green));
                TextView textView = this.bUE;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("+ ");
                stringBuilder.append(getString(R.string.deposit));
                textView.setText(stringBuilder.toString());
                String string;
                if (aL.Cy() == 2) {
                    eE(R.color.selectable_purple_100_to_75);
                    string = getString(R.string.your_balance_type_has_been_changed_to, getString(R.string.tournament_balance));
                    spannableString = new SpannableString(string);
                    spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getContext(), R.color.purple)), string.indexOf(r0), string.length(), 33);
                } else if (aL.Cy() == 4) {
                    eE(R.color.selectable_orange_100_to_75);
                    string = getString(R.string.your_balance_type_has_been_changed_to, getString(R.string.practice_balance));
                    spannableString = new SpannableString(string);
                    spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getContext(), R.color.orange)), string.indexOf(r0), string.length(), 33);
                } else {
                    eE(R.color.selectable_green_100_to_75);
                    string = getString(R.string.your_balance_type_has_been_changed_to, getString(R.string.real_balance));
                    spannableString = new SpannableString(string);
                    spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getContext(), R.color.green)), string.indexOf(r0), string.length(), 33);
                    if (!z && cV(true) && this.crH != null && this.crH.isDone()) {
                        com.iqoption.core.d.a.aSe.postDelayed(new Runnable() {
                            public void run() {
                                cr.this.cW(false);
                            }
                        }, 800);
                    }
                }
                SpannableString spannableString2 = spannableString;
                if (z) {
                    this.crz.a((int) R.drawable.local_toast_type_indicator_grey, 2131822918, spannableString2, 4000).aIn();
                }
            }
        }
    }

    public void aie() {
        if (com.iqoption.app.managers.af.Hu().Hx()) {
            if (com.iqoption.app.managers.af.Hu().Hy()) {
                if (this.crv.getVisibility() == 8 && !Network.dwp.aGr()) {
                    this.crv.setVisibility(0);
                    this.crT = Event.Builder(Event.CATEGORY_POPUP_SERVED, "internet-connection-lost");
                }
            } else if (this.crv.getVisibility() == 0) {
                this.crv.setVisibility(8);
                if (this.crT != null) {
                    EventManager.Bm().a(this.crT.calcDuration().setTechnicalLogs(Boolean.valueOf(true)).build());
                }
            }
        }
    }

    private void startTimer() {
        com.iqoption.view.a.b.aIK().a(this.crU, Integer.valueOf(5));
    }

    private void afr() {
        com.iqoption.view.a.b.aIK().b(this.crU);
    }

    private void bj(long j) {
        if (isAdded() && com.iqoption.app.helpers.a.FI().FW()) {
            aie();
        }
    }

    public void aif() {
        if (requireFragmentManager().findFragmentByTag(com.iqoption.feed.b.TAG) == null) {
            fc.c(requireActivity(), requireFragmentManager());
        }
    }

    private void aig() {
        af.DX().Ee();
    }

    public void onPause() {
        super.onPause();
        com.iqoption.core.i.d("TradeFragment onPause");
        afr();
        LocalBroadcastManager.getInstance(requireActivity()).unregisterReceiver(this.crR);
    }

    public void onResume() {
        super.onResume();
        com.iqoption.core.i.d("TradeFragment onResume");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.iqoption.push.broadcast.event");
        LocalBroadcastManager.getInstance(requireActivity()).registerReceiver(this.crR, intentFilter);
        Tracker aP = IQApp.aP(getContext());
        aP.setScreenName("Traderoom");
        aP.send(((ScreenViewBuilder) new ScreenViewBuilder().setCustomDimension(2, aP.get("&cid"))).build());
        u(requireActivity().getIntent());
        startTimer();
        aij();
    }

    public boolean cV(boolean z) {
        if (!com.iqoption.app.managers.feature.a.eW("kyc-block-real-trading-only") || !com.iqoption.app.a.Cw().Dh() || !KycState.isBlocked() || com.iqoption.app.a.Cw().isVerified()) {
            return false;
        }
        boolean z2 = true;
        if (!z) {
            return true;
        }
        Balance CC = com.iqoption.app.a.Cw().CC();
        if (CC == null || CC.type.intValue() != 1) {
            z2 = false;
        }
        return z2;
    }

    public void cW(boolean z) {
        if (cV(false)) {
            ag.b(com.iqoption.microservice.a.a.eb(true), new b(this, z));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00cb  */
    /* JADX WARNING: Missing block: B:20:0x0054, code:
            if (r13.equals("INITIATED") != false) goto L_0x0058;
     */
    /* JADX WARNING: Missing block: B:39:0x00bf, code:
            if (r13.equals("INITIATED") != false) goto L_0x00c3;
     */
    private void a(com.iqoption.microservice.a.b.a r13, boolean r14) {
        /*
        r12 = this;
        r0 = r13.cRL;
        if (r0 == 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r0 = 1;
        r1 = 0;
        r2 = 2;
        r3 = 3;
        r4 = 1350822958; // 0x5083ec2e float:1.77063485E10 double:6.67395217E-315;
        r5 = 1090724009; // 0x410320a9 float:8.195474 double:5.38889262E-315;
        r6 = 68184684; // 0x4106a6c float:1.6975985E-36 double:3.368771E-316;
        r7 = -1757359925; // 0xffffffff9740d0cb float:-6.230208E-25 double:NaN;
        r8 = -1;
        r9 = 2131100171; // 0x7f06020b float:1.7812716E38 double:1.0529033823E-314;
        r10 = 2131821226; // 0x7f1102aa float:1.927519E38 double:1.053259631E-314;
        r11 = 2131362845; // 0x7f0a041d float:1.8345482E38 double:1.0530331605E-314;
        if (r14 == 0) goto L_0x008c;
    L_0x0021:
        r13 = r13.cRM;
        r14 = r13.hashCode();
        if (r14 == r7) goto L_0x004e;
    L_0x0029:
        if (r14 == r6) goto L_0x0044;
    L_0x002b:
        if (r14 == r5) goto L_0x003a;
    L_0x002d:
        if (r14 == r4) goto L_0x0030;
    L_0x002f:
        goto L_0x0057;
    L_0x0030:
        r14 = "DECLINED";
        r13 = r13.equals(r14);
        if (r13 == 0) goto L_0x0057;
    L_0x0038:
        r0 = 3;
        goto L_0x0058;
    L_0x003a:
        r14 = "VERIFYING";
        r13 = r13.equals(r14);
        if (r13 == 0) goto L_0x0057;
    L_0x0042:
        r0 = 2;
        goto L_0x0058;
    L_0x0044:
        r14 = "NOT_UPLOADED";
        r13 = r13.equals(r14);
        if (r13 == 0) goto L_0x0057;
    L_0x004c:
        r0 = 0;
        goto L_0x0058;
    L_0x004e:
        r14 = "INITIATED";
        r13 = r13.equals(r14);
        if (r13 == 0) goto L_0x0057;
    L_0x0056:
        goto L_0x0058;
    L_0x0057:
        r0 = -1;
    L_0x0058:
        switch(r0) {
            case 0: goto L_0x005d;
            case 1: goto L_0x005d;
            case 2: goto L_0x005d;
            case 3: goto L_0x005d;
            default: goto L_0x005b;
        };
    L_0x005b:
        goto L_0x0150;
    L_0x005d:
        r13 = r12.zzakw();
        r14 = r12.getFragmentManager();
        r13 = com.iqoption.fragment.ex.a.b(r13, r14, r11);
        r13 = r13.Q(r12);
        r13 = r13.eG(r9);
        r14 = 2131822206; // 0x7f11067e float:1.9277177E38 double:1.053260115E-314;
        r13 = r13.eH(r14);
        r14 = 2131822646; // 0x7f110836 float:1.927807E38 double:1.0532603324E-314;
        r13 = r13.eI(r14);
        r13 = r13.eJ(r10);
        r13 = r13.eK(r10);
        r13.show();
        goto L_0x0150;
    L_0x008c:
        r13 = r13.cRM;
        r14 = r13.hashCode();
        if (r14 == r7) goto L_0x00b9;
    L_0x0094:
        if (r14 == r6) goto L_0x00af;
    L_0x0096:
        if (r14 == r5) goto L_0x00a5;
    L_0x0098:
        if (r14 == r4) goto L_0x009b;
    L_0x009a:
        goto L_0x00c2;
    L_0x009b:
        r14 = "DECLINED";
        r13 = r13.equals(r14);
        if (r13 == 0) goto L_0x00c2;
    L_0x00a3:
        r0 = 3;
        goto L_0x00c3;
    L_0x00a5:
        r14 = "VERIFYING";
        r13 = r13.equals(r14);
        if (r13 == 0) goto L_0x00c2;
    L_0x00ad:
        r0 = 2;
        goto L_0x00c3;
    L_0x00af:
        r14 = "NOT_UPLOADED";
        r13 = r13.equals(r14);
        if (r13 == 0) goto L_0x00c2;
    L_0x00b7:
        r0 = 0;
        goto L_0x00c3;
    L_0x00b9:
        r14 = "INITIATED";
        r13 = r13.equals(r14);
        if (r13 == 0) goto L_0x00c2;
    L_0x00c1:
        goto L_0x00c3;
    L_0x00c2:
        r0 = -1;
    L_0x00c3:
        r13 = 2131820617; // 0x7f110049 float:1.9273954E38 double:1.05325933E-314;
        switch(r0) {
            case 0: goto L_0x0123;
            case 1: goto L_0x0123;
            case 2: goto L_0x00f6;
            case 3: goto L_0x00cb;
            default: goto L_0x00c9;
        };
    L_0x00c9:
        goto L_0x0150;
    L_0x00cb:
        r14 = r12.zzakw();
        r0 = r12.getFragmentManager();
        r14 = com.iqoption.fragment.ex.a.b(r14, r0, r11);
        r14 = r14.Q(r12);
        r14 = r14.eG(r9);
        r13 = r14.eH(r13);
        r14 = 2131822333; // 0x7f1106fd float:1.9277434E38 double:1.053260178E-314;
        r13 = r13.eI(r14);
        r13 = r13.eJ(r10);
        r13 = r13.eK(r10);
        r13.show();
        goto L_0x0150;
    L_0x00f6:
        r14 = r12.zzakw();
        r0 = r12.getFragmentManager();
        r14 = com.iqoption.fragment.ex.a.b(r14, r0, r11);
        r14 = r14.Q(r12);
        r0 = 2131100013; // 0x7f06016d float:1.7812395E38 double:1.0529033043E-314;
        r14 = r14.eG(r0);
        r13 = r14.eH(r13);
        r14 = 2131821073; // 0x7f110211 float:1.9274879E38 double:1.0532595552E-314;
        r13 = r13.eI(r14);
        r14 = 2131821236; // 0x7f1102b4 float:1.927521E38 double:1.053259636E-314;
        r13 = r13.eJ(r14);
        r13.show();
        goto L_0x0150;
    L_0x0123:
        r14 = r12.zzakw();
        r0 = r12.getFragmentManager();
        r14 = com.iqoption.fragment.ex.a.b(r14, r0, r11);
        r14 = r14.Q(r12);
        r14 = r14.eG(r9);
        r13 = r14.eH(r13);
        r14 = 2131822620; // 0x7f11081c float:1.9278017E38 double:1.0532603196E-314;
        r13 = r13.eI(r14);
        r14 = 2131822619; // 0x7f11081b float:1.9278015E38 double:1.053260319E-314;
        r13 = r13.eJ(r14);
        r13 = r13.eK(r14);
        r13.show();
    L_0x0150:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.fragment.cr.a(com.iqoption.microservice.a.b.a, boolean):void");
    }

    public void eF(int i) {
        if (i == R.string.go_to_documents) {
            new com.iqoption.kyc.activity.KycActivity.a(zzakw()).ic(com.iqoption.kyc.fragment.jumio.e.TAG).start();
        } else if (i == R.string.upload_documents) {
            new com.iqoption.kyc.activity.KycActivity.a(zzakw()).ic(com.iqoption.kyc.fragment.jumio.d.TAG).start();
        }
    }

    public void onStart() {
        super.onStart();
        com.iqoption.core.i.d("TradeFragment onStart");
        this.crE.register();
        if (this.crI) {
            this.crI = false;
            this.crG.aua();
        }
        ahc();
        com.iqoption.fragment.leftmenu.h.alI().onStart();
    }

    public void onStop() {
        super.onStop();
        com.iqoption.core.i.d("TradeFragment clear");
        this.crE.unregister();
        com.iqoption.fragment.leftmenu.h.alI().onStop();
    }

    public void onDestroyView() {
        super.onDestroyView();
        com.iqoption.core.i.d("TradeFragment onDestroy");
        com.iqoption.app.managers.tab.a.Il().onStop();
        com.iqoption.app.managers.a.Gf().clear();
        this.crF.unregister();
        this.crE.unregister();
    }

    public boolean onBackPressed() {
        if (!isAdded()) {
            return false;
        }
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager.getBackStackEntryCount() <= 0) {
            return false;
        }
        Fragment findFragmentByTag = fragmentManager.findFragmentByTag(fragmentManager.getBackStackEntryAt(fragmentManager.getBackStackEntryCount() - 1).getName());
        if (findFragmentByTag != null && (findFragmentByTag instanceof com.iqoption.fragment.base.f) && ((com.iqoption.fragment.base.f) findFragmentByTag).aN()) {
            return true;
        }
        fragmentManager.popBackStack();
        return true;
    }

    private void a(@NonNull com.iqoption.mobbtech.connect.response.q qVar, boolean z) {
        a(this.crK.e(io.reactivex.e.bW(Collections.singletonList(qVar))).a(new de(this, z), dh.cpR));
    }

    private void aih() {
        a(this.crK.aEE().a(new di(this), dj.cpR));
    }

    private void g(String str, String str2, boolean z) {
        if (z) {
            this.crz.a((int) R.drawable.local_toast_type_indicator_green, -1, str2, 30000, new dk(this, str)).aIn();
            return;
        }
        hC(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003b  */
    private void hC(java.lang.String r4) {
        /*
        r3 = this;
        r0 = r3.zzakw();
        r1 = r4.hashCode();
        r2 = -268371060; // 0xfffffffff000fb8c float:-1.5967273E29 double:NaN;
        if (r1 == r2) goto L_0x002c;
    L_0x000d:
        r2 = 200040924; // 0xbec61dc float:9.1051136E-32 double:9.88333483E-316;
        if (r1 == r2) goto L_0x0022;
    L_0x0012:
        r2 = 354422628; // 0x15200f64 float:3.2323884E-26 double:1.751080446E-315;
        if (r1 == r2) goto L_0x0018;
    L_0x0017:
        goto L_0x0036;
    L_0x0018:
        r1 = "selected-reminder";
        r4 = r4.equals(r1);
        if (r4 == 0) goto L_0x0036;
    L_0x0020:
        r4 = 1;
        goto L_0x0037;
    L_0x0022:
        r1 = "pro-benefits";
        r4 = r4.equals(r1);
        if (r4 == 0) goto L_0x0036;
    L_0x002a:
        r4 = 0;
        goto L_0x0037;
    L_0x002c:
        r1 = "protrader_application";
        r4 = r4.equals(r1);
        if (r4 == 0) goto L_0x0036;
    L_0x0034:
        r4 = 2;
        goto L_0x0037;
    L_0x0036:
        r4 = -1;
    L_0x0037:
        switch(r4) {
            case 0: goto L_0x0045;
            case 1: goto L_0x0041;
            case 2: goto L_0x003b;
            default: goto L_0x003a;
        };
    L_0x003a:
        goto L_0x0048;
    L_0x003b:
        r4 = com.iqoption.protrader.web.ProTraderWebType.APPLY;
        com.iqoption.protrader.web.ProTraderWebActivity.a(r0, r4);
        goto L_0x0048;
    L_0x0041:
        com.iqoption.protrader.dialog.d.u(r0);
        goto L_0x0048;
    L_0x0045:
        com.iqoption.protrader.dialog.a.u(r0);
    L_0x0048:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.fragment.cr.hC(java.lang.String):void");
    }

    private void a(@NonNull TradeRoomActivity tradeRoomActivity, @NonNull com.iqoption.core.microservices.busapi.response.b bVar) {
        if (com.iqoption.gdpr.a.bt(getContext()) && bVar.Vu() == null) {
            com.iqoption.gdpr.b.n(tradeRoomActivity);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        getTradeRoomActivity().onActivityResult(i, i2, intent);
    }

    private void aii() {
        com.iqoption.core.i.d(TAG, "initilizedComplited");
        if (isAdded()) {
            aic();
            ahc();
            cU(false);
            ahZ();
            com.iqoption.fragment.leftmenu.h.alI().alK();
            ae.aU(getContext());
            if (aim() || !ail()) {
                getTradeRoomActivity().zB();
            } else {
                com.iqoption.core.d.a.aSe.postDelayed(new dl(new WeakReference(getTradeRoomActivity())), 1000);
            }
            if (com.iqoption.app.managers.feature.b.HT().ff("platform-troubles")) {
                aa.e(getFragmentManager());
            } else {
                a(getTradeRoomActivity(), com.iqoption.app.a.aL(getContext()).CS());
                aih();
                if (!com.iqoption.fragment.dialog.whatsnew.a.e(requireActivity(), requireFragmentManager())) {
                    if (com.iqoption.app.managers.feature.a.HJ() || af.DX().Fk()) {
                        aib();
                    } else if (!com.iqoption.fragment.dialog.n.d(requireActivity(), requireActivity().getSupportFragmentManager())) {
                        aib();
                    }
                }
                aiq();
                ais();
                aio();
                cW(true);
                ain();
                aig();
                u.c(requireActivity(), requireFragmentManager());
                aif();
                if (!com.iqoption.app.a.aL(getContext()).CZ()) {
                    aij();
                    this.crK.aED().observe(this, new dm(this));
                    a(this.crK.aEF().a(new dn(this), cu.cpR));
                }
            }
            aik();
            af.DX().Ey();
            this.crH.P(Boolean.valueOf(true));
        }
    }

    private void aij() {
        if (!com.iqoption.app.a.aL(getContext()).CZ() && com.iqoption.app.helpers.a.FI().FW()) {
            c(this.crK.aEC().a(new cv(this), cw.cpR));
        }
    }

    private void aik() {
        SignalsViewModel.A(requireActivity()).aEf().observe(this, new cx(new AtomicLong()));
    }

    public boolean ail() {
        if (this.crJ) {
            return false;
        }
        long currentTimeMillis;
        if (af.eN("portfolio_check_background_time_on_start")) {
            currentTimeMillis = System.currentTimeMillis() - af.getLong("finish_time");
            af.i("portfolio_check_background_time_on_start", false);
        } else {
            currentTimeMillis = 0;
        }
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("IQApp try open portfolio, pref.opened: ");
        stringBuilder.append(af.get("portfolio_opened", false));
        stringBuilder.append(", timeout: ");
        stringBuilder.append(currentTimeMillis);
        stringBuilder.append('/');
        stringBuilder.append(com.iqoption.portfolio.f.cYm);
        com.iqoption.core.i.d(str, stringBuilder.toString());
        if ((af.get("portfolio_first_launch", true) || af.get("portfolio_opened", false) || currentTimeMillis > com.iqoption.portfolio.f.cYm) && !com.iqoption.app.managers.c.Gn().Gq()) {
            com.iqoption.core.i.d(TAG, "open portfolio");
            z.c(getTradeRoomActivity());
            af.i("portfolio_first_launch", false);
            return true;
        }
        af.i("portfolio_opened", false);
        af.i("portfolio_first_launch", false);
        return false;
    }

    public boolean aim() {
        SharedPreferences azk = com.iqoption.quiz.m.ayY().azk();
        if ((!com.iqoption.app.managers.feature.a.eX("iq-quiz") && !com.iqoption.app.managers.feature.a.HN()) || (!azk.getBoolean("QUIZ_OPEN_FROM_LANDING", false) && (azk.getBoolean("PREF_REFCODE_WAS_USED", false) || TextUtils.isEmpty(azk.getString("QUIZ_REFCODE_WHEN_INSTALL", ""))))) {
            return false;
        }
        LeftPanelViewModel.l(requireActivity()).e(com.iqoption.fragment.leftpanel.b.d.cDQ);
        return true;
    }

    private void ain() {
        if (this.crS != null) {
            com.iqoption.dialog.a.h.a(getFragmentManager(), (InstrumentType) this.crS.first, (long[]) this.crS.second);
        }
        this.crS = null;
    }

    private void aio() {
        int intValue = ((Integer) com.iqoption.app.a.aL(getContext()).akx.getValue()).intValue();
        if (intValue != 0 && intValue != -1) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(getString(R.string.kyc_days_left_to_verify));
            stringBuilder.append(": ");
            stringBuilder.append(intValue);
            this.crz.a((int) R.drawable.local_toast_type_indicator_red, 2131821426, stringBuilder.toString(), getString(R.string.account_verification_2), 30000).aIn();
        }
    }

    public void a(String str, int i, boolean z, int i2) {
        if (isAdded() && this.crO != null) {
            if (z) {
                g fh = com.iqoption.app.managers.tab.a.Il().fh(str);
                if (fh != null) {
                    fh.W(i2, i);
                    if (com.iqoption.app.managers.tab.a.Il().a(fh)) {
                        this.crO.aB(i2, i);
                        EventManager.Bm().a(Event.Builder(Event.CATEGORY_SYSTEM, "chart_chart-scale-changed").setValue(Double.valueOf((double) i)).build());
                    }
                    com.iqoption.core.d.a.aSd.execute(cy.alc);
                }
            } else {
                eD(i);
            }
        }
    }

    public void a(InstrumentType instrumentType, String str, String str2, int i) {
        if (isAdded() && !getTradeRoomActivity().zJ()) {
            com.iqoption.dialog.a.h.a(getFragmentManager(), instrumentType, str);
        }
    }

    public void onClickTradersMoodView() {
        if (System.currentTimeMillis() - this.crW >= 1000 && isAdded()) {
            this.crW = System.currentTimeMillis();
            getResources().getDimensionPixelOffset(R.dimen.dp20);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.dp200);
            View textView = new TextView(getContext());
            textView.setLayoutParams(new LayoutParams(-1, -2));
            textView.setTextColor(ContextCompat.getColor(getContext(), R.color.grey_blur_50));
            textView.setTextSize(0, (float) getResources().getDimensionPixelSize(R.dimen.sp9));
            textView.setText(R.string.iq4_hint_traders_choise);
            if (this.crV != null) {
                this.crV.dismiss();
            }
            this.crV = new PopupWindow(textView, dimensionPixelOffset, -2);
            this.crV.setAnimationStyle(R.style.TradeMoodInfoPopup);
            this.crV.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.cashback_left_bg));
            if (VERSION.SDK_INT >= 21) {
                this.crV.setElevation((float) getResources().getDimensionPixelOffset(R.dimen.dp12));
            }
            this.crV.setOutsideTouchable(true);
            this.crV.setOnDismissListener(new cz(this));
            com.iqoption.core.d.a.aSe.postDelayed(new da(this), 10000);
        }
    }

    final /* synthetic */ void aiu() {
        this.crV = null;
    }

    final /* synthetic */ void ait() {
        if (isAdded() && this.crV != null) {
            this.crV.dismiss();
        }
    }

    public void hD(String str) {
        if (this.crz != null && !TextUtils.isEmpty(str)) {
            this.crz.a((int) R.drawable.local_toast_type_indicator_red, (long) str.hashCode(), str, 4000).aIn();
        }
    }

    void aip() {
        cX(com.iqoption.settings.b.aDQ().aDR());
    }

    void cX(boolean z) {
        if (z) {
            if (this.crB.isHidden()) {
                getChildFragmentManager().beginTransaction().show(this.crB).commit();
            }
        } else if (!this.crB.isHidden()) {
            getChildFragmentManager().beginTransaction().hide(this.crB).commit();
        }
    }

    public void o(com.iqoption.mobbtech.connect.response.options.e eVar) {
        if (this.crB != null) {
            this.crB.o(eVar);
        }
    }

    public void b(com.iqoption.mobbtech.connect.response.options.b bVar) {
        if (this.crB != null) {
            this.crB.b(bVar);
        }
    }

    private void ais() {
        if (!this.crM) {
            this.crM = true;
            this.aep.a(PopupFormat.NEW_BAKS_MOBILE).observe(this, new db(this));
            this.aep.a(PopupAnchor.MOBILE_LEGAL_UPDATE).observe(this, new dc(this));
            this.aep.a(PopupFormat.NPS).observe(this, new dd(this));
            this.aep.a(PopupFormat.WHATS_NEW, PopupAnchor.TWO_BUTTON_V1).observe(this, new df(this));
        }
    }

    private void d(double d, double d2, double d3) {
        com.iqoption.fragment.dialog.f.a(zzakw(), R.id.fragment, getFragmentManager(), d, d2, d3);
    }

    public static void a(@DrawableRes int i, String str, long j) {
        IQApp.Dn().aE(new ToastEntity(i, (long) str.hashCode(), str, null, j));
    }

    public void dQ(String str) {
        getTradeRoomActivity().dQ(str);
    }

    public void h(String str, long j) {
        if (str.hashCode() == -740075017) {
            boolean equals = str.equals("WelcomeTrendingFragment");
        }
    }

    public void i(String str, long j) {
        if (str.hashCode() == -740075017) {
            boolean equals = str.equals("WelcomeTrendingFragment");
        }
    }
}
