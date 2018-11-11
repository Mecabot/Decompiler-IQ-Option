package com.iqoption.fragment.rightpanel;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.iqoption.analytics.EventManager;
import com.iqoption.app.managers.a.k;
import com.iqoption.app.managers.af;
import com.iqoption.app.managers.tab.a.g;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.d.aio;
import com.iqoption.dto.Event;
import com.iqoption.dto.entity.expiration.Expiration;
import com.iqoption.fragment.az;
import com.iqoption.service.e.m;
import com.iqoption.system.a.e;
import com.iqoption.system.a.i;
import com.iqoption.tutorial.StepDoneType;
import com.iqoption.tutorial.TutorialViewModel;
import com.iqoption.tutorial.utils.d;
import com.iqoption.util.aw;
import com.iqoption.util.l;
import com.iqoption.util.q;
import com.iqoption.view.h;
import com.iqoption.x.R;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* compiled from: BinaryRightPanelDelegate */
public final class b extends au implements com.iqoption.view.a.b.a {
    private double aTA;
    private Integer activeId;
    private TutorialViewModel aeq;
    private final a cEA = new a(this, null);
    private final b cEB = new b(this);
    private final y cEC = new y();
    private final SimpleDateFormat cED = new SimpleDateFormat("0:mm:ss", Locale.getDefault());
    private final com.iqoption.h.a.a cEE = com.iqoption.app.managers.tab.a.Il().Iu();
    private aw cEF;
    private aw cEG;
    private x cEH;
    private int cEI;
    private int cEJ;
    private int cEK;
    private boolean cEL;
    private aio cEM;
    private at cEN;
    private final DecimalFormat cEy = q.I("#", 2);
    private int commission;
    private long expiration;
    private InstrumentType instrumentType;

    /* compiled from: BinaryRightPanelDelegate */
    public static final class c {
        private final b cEX;
        private final e cEY;

        public c(b bVar) {
            this.cEX = bVar;
            this.cEY = new e(bVar);
        }

        public void amX() {
            az.a(this.cEX.getFragmentManager(), R.id.fragment);
            EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "traderoom_expiration-time").build());
        }

        public void amY() {
            EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "deal-keyboard_keyboard").setValue(Double.valueOf(h.b(this.cEX.getFragmentManager(), R.id.fragment, this.cEX.UO()) ? 1.0d : 0.0d)).build());
        }

        public void amZ() {
            this.cEX.y(this.cEX.UO() - 1.0d);
            EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "traderoom_deal-minus").build());
        }

        public void ana() {
            this.cEX.y(this.cEX.UO() + 1.0d);
            EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "traderoom_deal-plus").build());
        }

        public void bh(View view) {
            if (this.cEX.amS()) {
                this.cEX.bg(view);
            }
            this.cEX.ds(true);
            this.cEY.ane();
            this.cEX.aeq.a(d.aFX(), StepDoneType.TAP_ON_TARGET);
        }

        public void bi(View view) {
            if (this.cEX.amS()) {
                this.cEX.bg(view);
            }
            this.cEX.ds(false);
            this.cEY.ane();
            this.cEX.aeq.a(d.aFX(), StepDoneType.TAP_ON_TARGET);
        }

        public void anb() {
            this.cEX.amP();
            this.cEY.anf();
        }

        public void anc() {
            this.cEX.amP();
        }

        public void and() {
            com.iqoption.app.managers.tab.a.Il().IB();
        }
    }

    /* compiled from: BinaryRightPanelDelegate */
    public static final class a extends e<b> {
        /* synthetic */ a(b bVar, AnonymousClass1 anonymousClass1) {
            this(bVar);
        }

        private a(b bVar) {
            super(bVar);
        }

        @com.google.common.b.e
        public void onInitializationCompletedEvent(com.iqoption.app.managers.tab.a.d dVar) {
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    b bVar = (b) a.this.drU.get();
                    if (bVar != null) {
                        bVar.amM();
                    }
                }
            });
        }

        @com.google.common.b.e
        public void onAmountChangedIQKeyboardEvent(final com.iqoption.view.h.a aVar) {
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    b bVar = (b) a.this.drU.get();
                    if (bVar != null) {
                        bVar.x(((Double) aVar.getValue()).doubleValue());
                    }
                }
            });
        }

        @com.google.common.b.e
        public void onShowedIQKeyboardEvent(final com.iqoption.view.h.b bVar) {
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    b bVar = (b) a.this.drU.get();
                    if (bVar != null) {
                        bVar.dr(((Boolean) bVar.getValue()).booleanValue());
                    }
                }
            });
        }

        @com.google.common.b.e
        public void onShowedExpirationFragmentEvent(final k.d dVar) {
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    b bVar = (b) a.this.drU.get();
                    if (bVar != null) {
                        bVar.dq(dVar.aos);
                    }
                }
            });
        }

        @com.google.common.b.e
        public void onChangeCurrentActiveCommissionEvent(com.iqoption.app.helpers.a.c cVar) {
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    b bVar = (b) a.this.drU.get();
                    if (bVar != null) {
                        com.iqoption.core.microservices.tradingengine.response.active.a Iw = com.iqoption.app.managers.tab.a.Il().Iw();
                        if (Iw != null) {
                            bVar.dR(Iw.Xi().intValue());
                        }
                    }
                }
            });
        }

        @com.google.common.b.e
        public void onChangeExpirationEvent(final com.iqoption.app.managers.a.k.a aVar) {
            if (aVar.aoq == com.iqoption.app.managers.tab.a.Il().ID()) {
                com.iqoption.core.d.a.aSe.execute(new Runnable() {
                    public void run() {
                        b bVar = (b) a.this.drU.get();
                        if (bVar != null) {
                            bVar.br(aVar.aop.expValue.longValue());
                            bVar.amM();
                            com.iqoption.core.microservices.tradingengine.response.active.a Iw = com.iqoption.app.managers.tab.a.Il().Iw();
                            if (Iw != null) {
                                bVar.dR(Iw.Xi().intValue());
                            }
                        }
                    }
                });
            }
        }
    }

    /* compiled from: BinaryRightPanelDelegate */
    public static class b extends i<b> {
        public b(b bVar) {
            super(bVar);
        }

        @com.google.common.b.e
        public void onChangeBalanceType(com.iqoption.service.e.b bVar) {
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    b bVar = (b) b.this.drU.get();
                    if (bVar != null) {
                        bVar.y(bVar.Ea());
                        bVar.amM();
                    }
                }
            });
        }

        @com.google.common.b.e
        public void onUpdateBalanceValue(m mVar) {
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    b bVar = (b) b.this.drU.get();
                    if (bVar != null) {
                        bVar.amM();
                    }
                }
            });
        }

        @com.google.common.b.e
        public void onChangeCurrentCurrency(com.iqoption.service.e.c cVar) {
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    b bVar = (b) b.this.drU.get();
                    if (bVar != null) {
                        bVar.amL();
                        bVar.amO();
                    }
                }
            });
        }
    }

    b(RightPanelFragment rightPanelFragment, com.iqoption.core.microservices.tradingengine.response.active.a aVar) {
        super(rightPanelFragment);
        this.activeId = Integer.valueOf(aVar.getActiveId());
        this.instrumentType = aVar.getInstrumentType();
        this.cEI = ResourcesCompat.getColor(rightPanelFragment.getResources(), R.color.red, rightPanelFragment.getContext().getTheme());
        this.cEJ = ResourcesCompat.getColor(rightPanelFragment.getResources(), R.color.white, rightPanelFragment.getContext().getTheme());
        this.cEK = rightPanelFragment.getResources().getDimensionPixelSize(R.dimen.dp24);
        this.cEA.register();
        this.cEB.register();
        com.iqoption.view.a.b.aIK().a((com.iqoption.view.a.b.a) this);
        this.aeq = TutorialViewModel.D(rightPanelFragment.zzakw());
    }

    public void x(double d) {
        y(d);
    }

    public double UO() {
        return this.aTA;
    }

    public boolean amH() {
        return com.iqoption.settings.b.aDQ().aDX() ^ 1;
    }

    public void amI() {
        this.cEM.bSd.setType(amK());
        this.cEM.bSd.setExpiration(k.av(this.expiration));
        this.cEH.L(this.cEM.bSd);
    }

    public void amJ() {
        Long balanceId = com.iqoption.app.a.Cw().getBalanceId();
        g IC = com.iqoption.app.managers.tab.a.Il().IC();
        if (IC != null && balanceId != null) {
            com.iqoption.mobbtech.connect.request.api.a.a.a(IC.IM(), IC.getActiveId(), IC.getInstrumentType(), IC.IP(), this.aTA, balanceId.longValue(), 100 - this.commission, this.cEL);
        }
    }

    public boolean amK() {
        return this.cEL;
    }

    public void onTick(long j) {
        com.iqoption.app.managers.tab.a Il = com.iqoption.app.managers.tab.a.Il();
        com.iqoption.core.microservices.tradingengine.response.active.a Iw = Il.Iw();
        if (v(Iw)) {
            if (this.cEH.bl(this.cEM.bRp)) {
                if (b(Iw, j)) {
                    this.cEM.bRp.setTimeToClose(this.cED.format(this.cEC.bw(this.expiration - j)));
                } else {
                    amP();
                }
            } else if (b(Iw, j)) {
                amQ();
            }
            if (this.cEH.bl(this.cEM.bSd)) {
                this.cEM.bSd.setLevel(this.cEE.format(com.iqoption.gl.b.aow().glchTabGetActualValue(Il.IE())));
            }
            if (!this.cHt) {
                return;
            }
            if (af.Hu().Hz()) {
                this.cEN.amD();
                this.cEN.amF();
                return;
            }
            this.cEN.amE();
            this.cEN.amG();
        }
    }

    private boolean b(@NonNull com.iqoption.core.microservices.tradingengine.response.active.a aVar, long j) {
        if (j <= this.expiration - k.HB().c(aVar, Expiration.notInitilizedExpiration) || j >= this.expiration) {
            return false;
        }
        return com.iqoption.app.managers.c.Gn().b(new com.iqoption.mobbtech.connect.response.options.i(Long.valueOf(this.expiration / 1000), Integer.valueOf(aVar.getActiveId()), aVar.getInstrumentType())) ^ 1;
    }

    private boolean v(@Nullable com.iqoption.core.microservices.tradingengine.response.active.a aVar) {
        return aVar != null && aw.equals(aVar.getInstrumentType(), this.instrumentType) && aVar.getActiveId() == this.activeId.intValue();
    }

    @NonNull
    View f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        this.cEM = (aio) DataBindingUtil.inflate(layoutInflater, R.layout.right_panel_delegate_turbo_binary, viewGroup, false);
        final c cVar = new c(this);
        this.cEM.a(cVar);
        this.cEN = new a(layoutInflater, this.cEM.bSi);
        at atVar = this.cEN;
        cVar.getClass();
        atVar.a(c.b(cVar));
        atVar = this.cEN;
        cVar.getClass();
        atVar.b(d.b(cVar));
        this.cEM.bSi.addView(this.cEN.getView(), 0);
        this.cEF = new aw(this.cEM.bSS, this.cEM.bSe);
        this.cEG = new aw(this.cEM.bwP, this.cEM.bwO);
        this.cEH = new x(this.cEK, this.cEN.getView(), this.cEM.bSd, this.cEM.bRp);
        this.cEM.bSd.setConfirmListener(new com.iqoption.view.d.b(1000) {
            public void q(View view) {
                cVar.anb();
            }
        });
        this.cEM.bSd.setCancelListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                cVar.anc();
            }
        });
        this.cEM.bRp.setBuyNewListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                cVar.and();
            }
        });
        y(Ea());
        com.iqoption.core.microservices.tradingengine.response.active.a Iw = com.iqoption.app.managers.tab.a.Il().Iw();
        if (Iw != null) {
            dR(Iw.Xi().intValue());
        }
        br(com.iqoption.app.managers.tab.a.Il().IA());
        return this.cEM.getRoot();
    }

    void w(@NonNull com.iqoption.core.microservices.tradingengine.response.active.a aVar) {
        super.w(aVar);
        this.activeId = Integer.valueOf(aVar.getActiveId());
        this.instrumentType = aVar.getInstrumentType();
    }

    void destroy() {
        super.destroy();
        this.cEA.unregister();
        this.cEB.unregister();
        com.iqoption.view.a.b.aIK().b((com.iqoption.view.a.b.a) this);
    }

    void y(double d) {
        if (d < 0.0d) {
            d = 0.0d;
        }
        this.aTA = d;
        this.cEM.bwP.setText(l.a(d, this.cEy));
        amM();
        amO();
    }

    private void amL() {
        this.cEM.bwP.setText(l.a(this.aTA, this.cEy));
    }

    void amM() {
        if (this.cEM != null) {
            double doubleValue = com.iqoption.app.a.Cw().Cx().doubleValue();
            double[] N = l.N(getInstrumentType());
            if (this.aTA > doubleValue || this.aTA > N[1] || this.aTA < N[0]) {
                this.cEM.bwP.setTextColor(this.cEI);
            } else {
                this.cEM.bwP.setTextColor(this.cEJ);
            }
        }
    }

    void br(long j) {
        this.expiration = j;
        amN();
    }

    private void amN() {
        if (this.cEM != null) {
            com.iqoption.core.microservices.tradingengine.response.active.a Iw = com.iqoption.app.managers.tab.a.Il().Iw();
            if (v(Iw)) {
                this.cEM.bSS.setText(k.HB().a(Iw, this.expiration));
            } else {
                this.cEM.bSS.setText(null);
            }
            if (this.cEH.bl(this.cEM.bSd)) {
                this.cEM.bSd.setExpiration(k.av(this.expiration));
            }
        }
    }

    void dR(int i) {
        this.commission = i;
        amO();
    }

    private void amO() {
        if (this.cEM != null) {
            double d = (this.aTA * (200.0d - ((double) this.commission))) / 100.0d;
            int i = 100 - this.commission;
            this.cEN.g(d, i);
            this.cEN.h(d, i);
        }
    }

    void dq(boolean z) {
        this.cEM.bSg.setSelected(z);
        this.cEM.bSR.setSelected(z);
        if (z) {
            this.cEF.select();
        } else {
            this.cEF.aoe();
        }
    }

    void dr(boolean z) {
        this.cEM.bRi.setSelected(z);
        this.cEM.bRh.setSelected(z);
        if (z) {
            this.cEG.select();
        } else {
            this.cEG.aoe();
        }
    }

    void amP() {
        this.cEH.L(this.cEN.getView());
    }

    void amQ() {
        this.cEH.L(this.cEM.bRp);
    }

    void ds(boolean z) {
        this.cEL = z;
    }

    @Nullable
    public InstrumentType getInstrumentType() {
        return this.instrumentType;
    }
}
