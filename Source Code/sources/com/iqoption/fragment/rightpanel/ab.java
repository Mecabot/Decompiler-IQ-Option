package com.iqoption.fragment.rightpanel;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.transition.Transition;
import android.support.transition.TransitionInflater;
import android.support.transition.TransitionListenerAdapter;
import android.support.transition.TransitionManager;
import android.support.v4.content.ContextCompat;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.iqoption.analytics.EventManager;
import com.iqoption.app.managers.a.k;
import com.iqoption.app.managers.af;
import com.iqoption.app.managers.tab.a.d;
import com.iqoption.app.managers.tab.a.g;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.d.aig;
import com.iqoption.dto.Event;
import com.iqoption.dto.entity.expiration.Expiration;
import com.iqoption.dto.entity.strike.Quote;
import com.iqoption.dto.entity.strike.Strike;
import com.iqoption.fragment.at;
import com.iqoption.gl.NativeHandler;
import com.iqoption.service.e.m;
import com.iqoption.system.a.e;
import com.iqoption.system.a.i;
import com.iqoption.util.aw;
import com.iqoption.util.bc;
import com.iqoption.util.l;
import com.iqoption.util.q;
import com.iqoption.view.h;
import com.iqoption.x.R;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* compiled from: DigitalRightPanelDelegate */
public final class ab extends au implements com.iqoption.view.a.b.a {
    private static final String TAG = "ab";
    private double aTA;
    private Integer activeId;
    private Expiration aop;
    private final y cEC = new y();
    private final SimpleDateFormat cED = new SimpleDateFormat("0:mm:ss", Locale.getDefault());
    private final com.iqoption.h.a.a cEE = com.iqoption.app.managers.tab.a.Il().Iu();
    private aw cEG;
    private x cEH;
    private int cEI;
    private int cEJ;
    private int cEK;
    private boolean cEL;
    private final DecimalFormat cEy = q.dX(2);
    private final a cGB = new a(this, null);
    private final b cGC = new b(this);
    private aw cGD;
    private aw cGE;
    private int cGF;
    private aig cGG;
    private aa cGH;
    private com.iqoption.core.ui.c.a cGI = new com.iqoption.core.ui.c.a();
    private com.iqoption.core.ui.c.a cGJ = new com.iqoption.core.ui.c.a();
    private com.iqoption.core.ui.c.a cGK;
    private View cGL;
    private View cGM;
    private Transition cGN;
    private InstrumentType instrumentType;

    /* compiled from: DigitalRightPanelDelegate */
    public static final class c {
        private final e cEY;
        private final ab cGX;

        public c(ab abVar) {
            this.cGX = abVar;
            this.cEY = new e(abVar);
        }

        public void amX() {
            at.a(this.cGX.getFragmentManager(), (int) R.id.fragment);
            EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "traderoom_expiration-time").build());
        }

        public void amY() {
            EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "deal-keyboard_keyboard").setValue(Double.valueOf(h.b(this.cGX.getFragmentManager(), R.id.fragment, this.cGX.UO()) ? 1.0d : 0.0d)).build());
        }

        public void bh(View view) {
            if (this.cGX.amS()) {
                this.cGX.bg(view);
            }
            this.cGX.ds(true);
            this.cEY.ane();
        }

        public void bi(View view) {
            if (this.cGX.amS()) {
                this.cGX.bg(view);
            }
            this.cGX.ds(false);
            this.cEY.ane();
        }

        public void anb() {
            this.cGX.amP();
            this.cEY.anf();
        }

        public void anc() {
            this.cGX.amP();
        }

        public void and() {
            Expiration IB = com.iqoption.app.managers.tab.a.Il().IB();
            if (IB != null) {
                this.cGX.h(IB);
            }
        }
    }

    /* compiled from: DigitalRightPanelDelegate */
    public static final class a extends e<ab> {
        /* synthetic */ a(ab abVar, AnonymousClass1 anonymousClass1) {
            this(abVar);
        }

        private a(ab abVar) {
            super(abVar);
        }

        @com.google.common.b.e
        public void onInitializationCompletedEvent(d dVar) {
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    ab abVar = (ab) a.this.drU.get();
                    if (abVar != null) {
                        abVar.amM();
                    }
                }
            });
        }

        @com.google.common.b.e
        public void onAmountChangedIQKeyboardEvent(final com.iqoption.view.h.a aVar) {
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    ab abVar = (ab) a.this.drU.get();
                    if (abVar != null) {
                        abVar.x(((Double) aVar.getValue()).doubleValue());
                    }
                }
            });
        }

        @com.google.common.b.e
        public void onShowedIQKeyboardEvent(final com.iqoption.view.h.b bVar) {
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    ab abVar = (ab) a.this.drU.get();
                    if (abVar != null) {
                        abVar.dr(((Boolean) bVar.getValue()).booleanValue());
                    }
                }
            });
        }

        @com.google.common.b.e
        public void onShowedExpirationFragmentEvent(final k.d dVar) {
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    ab abVar = (ab) a.this.drU.get();
                    if (abVar != null) {
                        abVar.dq(dVar.aos);
                    }
                }
            });
        }

        @com.google.common.b.e
        public void onChangeExpirationEvent(final com.iqoption.app.managers.a.k.a aVar) {
            if (aVar.aoq == com.iqoption.app.managers.tab.a.Il().ID()) {
                com.iqoption.core.d.a.aSe.execute(new Runnable() {
                    public void run() {
                        ab abVar = (ab) a.this.drU.get();
                        if (abVar != null) {
                            abVar.h(aVar.aop);
                        }
                    }
                });
            }
        }

        @com.google.common.b.e
        public void onChangeStrikeEvent(final com.iqoption.app.managers.a.k.b bVar) {
            if (bVar.aoq == com.iqoption.app.managers.tab.a.Il().ID()) {
                com.iqoption.core.d.a.aSe.execute(new Runnable() {
                    public void run() {
                        ab abVar = (ab) a.this.drU.get();
                        if (abVar != null) {
                            abVar.c((Strike) bVar.getValue());
                        }
                    }
                });
            }
        }
    }

    /* compiled from: DigitalRightPanelDelegate */
    public static class b extends i<ab> {
        public b(ab abVar) {
            super(abVar);
        }

        @com.google.common.b.e
        public void onChangeBalanceType(com.iqoption.service.e.b bVar) {
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    ab abVar = (ab) b.this.drU.get();
                    if (abVar != null) {
                        abVar.y(abVar.Ea());
                        abVar.amM();
                    }
                }
            });
        }

        @com.google.common.b.e
        public void onUpdateBalanceValue(m mVar) {
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    ab abVar = (ab) b.this.drU.get();
                    if (abVar != null) {
                        abVar.amM();
                    }
                }
            });
        }

        @com.google.common.b.e
        public void onChangeCurrentCurrency(com.iqoption.service.e.c cVar) {
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    ab abVar = (ab) b.this.drU.get();
                    if (abVar != null) {
                        abVar.amL();
                    }
                }
            });
        }
    }

    public ab(RightPanelFragment rightPanelFragment) {
        super(rightPanelFragment);
        com.iqoption.core.microservices.tradingengine.response.active.a Iw = com.iqoption.app.managers.tab.a.Il().Iw();
        if (Iw != null) {
            this.activeId = Integer.valueOf(Iw.getActiveId());
            this.instrumentType = Iw.getInstrumentType();
        }
        this.cEI = ContextCompat.getColor(getContext(), R.color.red);
        this.cEJ = ContextCompat.getColor(getContext(), R.color.white);
        this.cEK = rightPanelFragment.ef(R.dimen.dp24);
        this.cGF = rightPanelFragment.ef(R.dimen.sp10);
        this.cGB.register();
        this.cGC.register();
        com.iqoption.view.a.b.aIK().a((com.iqoption.view.a.b.a) this, Integer.valueOf(5));
    }

    public boolean amH() {
        return com.iqoption.settings.b.aDQ().aDX() ^ 1;
    }

    public void amI() {
        this.cGG.bSd.setType(amK());
        this.cGG.bSd.setExpiration(k.av(this.aop.expValue.longValue()));
        this.cEH.L(this.cGG.bSd);
    }

    public void amJ() {
        g IC = com.iqoption.app.managers.tab.a.Il().IC();
        if (IC != null) {
            com.iqoption.mobbtech.connect.request.api.a.c.a(IC.IR(), null, Long.valueOf((long) IC.getActiveId()), this.aTA, com.iqoption.app.a.Cw().getBalanceId().longValue(), this.cEL);
        }
    }

    public boolean amK() {
        return this.cEL;
    }

    public void x(double d) {
        y(d);
    }

    public double UO() {
        return this.aTA;
    }

    public void onTick(long j) {
        com.iqoption.app.managers.tab.a Il = com.iqoption.app.managers.tab.a.Il();
        com.iqoption.core.microservices.tradingengine.response.active.a Iw = Il.Iw();
        if (v(Iw)) {
            if (this.cEH.bl(this.cGG.bRp)) {
                if (b(Iw, j)) {
                    this.cGG.bRp.setTimeToClose(this.cED.format(this.cEC.bw(this.aop.expValue.longValue() - j)));
                } else {
                    amP();
                }
            } else if (b(Iw, j)) {
                amQ();
            } else {
                anT();
            }
            if (this.cEH.bl(this.cGG.bSd)) {
                this.cGG.bSd.setLevel(this.cEE.format(com.iqoption.gl.b.aow().glchTabGetActualValue(Il.IE())));
            }
            if (!this.cHt) {
                return;
            }
            if (af.Hu().Hz()) {
                this.cGH.amD();
                this.cGH.amF();
                return;
            }
            this.cGH.amE();
            this.cGH.amG();
        }
    }

    private boolean b(@NonNull com.iqoption.core.microservices.tradingengine.response.active.a aVar, long j) {
        if (j <= this.aop.expValue.longValue() - k.HB().c(aVar, this.aop) || j >= this.aop.expValue.longValue()) {
            return false;
        }
        return com.iqoption.app.managers.c.Gn().b(new com.iqoption.mobbtech.connect.response.options.i(Long.valueOf(this.aop.expValue.longValue() / 1000), Integer.valueOf(aVar.getActiveId()), aVar.getInstrumentType())) ^ 1;
    }

    private boolean v(@Nullable com.iqoption.core.microservices.tradingengine.response.active.a aVar) {
        return aVar != null && aw.equals(aVar.getInstrumentType(), this.instrumentType) && aVar.getActiveId() == this.activeId.intValue();
    }

    @NonNull
    View f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        this.cGG = (aig) DataBindingUtil.inflate(layoutInflater, R.layout.right_panel_delegate_digital, viewGroup, false);
        final c cVar = new c(this);
        this.cGG.a(cVar);
        aa aaVar = new aa(layoutInflater, this.cGG.bSi);
        this.cGH = aaVar;
        this.cGG.bSi.addView(this.cGH.getView(), 0);
        this.cGJ.clone((ConstraintLayout) this.cGH.getView());
        this.cGI.clone(getContext(), R.layout.right_panel_delegate_spot);
        this.cGK = this.cGJ;
        this.cGL = aaVar.getView().findViewById(R.id.buttonPutProfitFrameBackground);
        this.cGM = aaVar.getView().findViewById(R.id.buttonCallProfitFrameBackground);
        this.cGN = TransitionInflater.from(getContext()).inflateTransition(R.transition.spot);
        this.cGN.addListener(new TransitionListenerAdapter() {
            public void onTransitionStart(@NonNull Transition transition) {
                super.onTransitionStart(transition);
                ab.this.cGH.dE(true);
            }

            public void onTransitionEnd(@NonNull Transition transition) {
                super.onTransitionEnd(transition);
                ab.this.cGH.dE(false);
            }
        });
        cVar.getClass();
        aaVar.a(ac.b(cVar));
        cVar.getClass();
        aaVar.b(ad.b(cVar));
        this.cEH = new x(this.cEK, aaVar.getView(), this.cGG.bSd, this.cGG.bRp);
        this.cGD = new aw(this.cGG.bLU, this.cGG.bSe);
        this.cGE = new aw(this.cGG.bSl, this.cGG.bSk);
        this.cEG = new aw(this.cGG.bSc, this.cGG.bwO);
        this.cGG.bSd.setConfirmListener(new com.iqoption.view.d.b(1000) {
            public void q(View view) {
                cVar.anb();
            }
        });
        this.cGG.bSd.setCancelListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                cVar.anc();
            }
        });
        this.cGG.bRp.setBuyNewListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                cVar.and();
            }
        });
        y(Ea());
        h(com.iqoption.app.managers.tab.a.Il().Iz());
        c(com.iqoption.app.managers.tab.a.Il().Ix());
        return this.cGG.getRoot();
    }

    void w(@NonNull com.iqoption.core.microservices.tradingengine.response.active.a aVar) {
        super.w(aVar);
        this.activeId = Integer.valueOf(aVar.getActiveId());
        this.instrumentType = aVar.getInstrumentType();
    }

    void destroy() {
        super.destroy();
        this.cGB.unregister();
        this.cGC.unregister();
        com.iqoption.view.a.b.aIK().b((com.iqoption.view.a.b.a) this);
    }

    void y(double d) {
        if (d < 0.0d) {
            d = 0.0d;
        }
        this.aTA = d;
        if (this.cGG != null) {
            this.cGG.bSc.setText(l.a(d, this.cEy));
        }
        amM();
        anT();
    }

    private void amL() {
        this.cGG.bSc.setText(l.a(this.aTA, this.cEy));
    }

    private void amM() {
        if (this.cGG != null) {
            double doubleValue = com.iqoption.app.a.Cw().Cx().doubleValue();
            double[] N = l.N(getInstrumentType());
            if (this.aTA > doubleValue || this.aTA > N[1] || this.aTA < N[0]) {
                this.cGG.bSc.setTextColor(this.cEI);
            } else {
                this.cGG.bSc.setTextColor(this.cEJ);
            }
        }
    }

    void h(Expiration expiration) {
        this.aop = expiration;
        amN();
    }

    private void amN() {
        if (this.cGG != null) {
            com.iqoption.core.microservices.tradingengine.response.active.a Iw = com.iqoption.app.managers.tab.a.Il().Iw();
            if (v(Iw)) {
                this.cGG.bLU.setText(k.HB().a(Iw, this.aop.expValue.longValue()));
            } else {
                this.cGG.bLU.setText(null);
            }
            if (this.cEH.bl(this.cGG.bSd)) {
                this.cGG.bSd.setExpiration(k.av(this.aop.expValue.longValue()));
            }
        }
    }

    void c(Strike strike) {
        if (this.cGG != null) {
            Double lastSpotValue = strike != null ? strike.isSpot ? strike.getLastSpotValue() : strike.getValue() : null;
            if (lastSpotValue != null) {
                String format = com.iqoption.app.managers.tab.a.Il().Iu().format(lastSpotValue.doubleValue());
                this.cGG.bSl.setText(new bc().bM(new AbsoluteSizeSpan(this.cGF)).jO(format.substring(0, format.length() - 3)).aGw().jO(" ").B(format.subSequence(format.length() - 3, format.length())).aCT());
            } else {
                this.cGG.bSl.setText(null);
            }
            if (strike == null) {
                return;
            }
            if (strike.isSpot) {
                anV();
            } else {
                anU();
            }
        }
    }

    private void anT() {
        if (this.cGG != null) {
            Strike Ix = com.iqoption.app.managers.tab.a.Il().Ix();
            if (Ix != null) {
                double UO = UO();
                Quote c = com.iqoption.app.managers.c.Gn().c(Ix.call.id, InstrumentType.DIGITAL_INSTRUMENT);
                if (Quote.isQuoteAvailable(c)) {
                    this.cGH.g(c.getProfit(UO), c.getProfitPercent());
                    this.cGH.amD();
                } else {
                    this.cGH.anR();
                    this.cGH.amE();
                }
                Quote c2 = com.iqoption.app.managers.c.Gn().c(Ix.put.id, InstrumentType.DIGITAL_INSTRUMENT);
                if (Quote.isQuoteAvailable(c2)) {
                    this.cGH.h(c2.getProfit(UO), c2.getProfitPercent());
                    this.cGH.amF();
                } else {
                    this.cGH.anS();
                    this.cGH.amG();
                }
                NativeHandler.instance().singleThreadExecutor.execute(new ae(Ix, c, c2));
                return;
            }
            this.cGH.anR();
            this.cGH.anS();
            this.cGH.amE();
            this.cGH.amG();
        }
    }

    static final /* synthetic */ void a(Strike strike, Quote quote, Quote quote2) {
        String strikeKey = strike.getStrikeKey();
        double selfAskPrice = Quote.selfAskPrice(quote);
        double selfBidPrice = Quote.selfBidPrice(quote);
        double selfAskPrice2 = Quote.selfAskPrice(quote2);
        double selfBidPrice2 = Quote.selfBidPrice(quote2);
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("glchTabUpdateStrike strikeKey=");
        stringBuilder.append(strikeKey);
        stringBuilder.append(", instrumentCallAsk=");
        stringBuilder.append(selfAskPrice);
        stringBuilder.append(", instrumentCallBid=");
        stringBuilder.append(selfBidPrice);
        stringBuilder.append(", instrumentPutAsk=");
        stringBuilder.append(selfAskPrice2);
        stringBuilder.append(", instrumentPutBid=");
        stringBuilder.append(selfBidPrice2);
        com.iqoption.core.i.v(str, stringBuilder.toString());
        com.iqoption.gl.b.aow().glchTabUpdateStrike(strikeKey, selfAskPrice, selfBidPrice, selfAskPrice2, selfBidPrice2, Quote.isQuoteAvailable(quote), Quote.isQuoteAvailable(quote2));
    }

    private void dq(boolean z) {
        this.cGG.bSg.setSelected(z);
        this.cGG.bSf.setSelected(z);
        if (z) {
            this.cGD.select();
            this.cGE.select();
            return;
        }
        this.cGD.aoe();
        this.cGE.aoe();
    }

    private void dr(boolean z) {
        this.cGG.bRi.setSelected(z);
        this.cGG.bRh.setSelected(z);
        if (z) {
            this.cEG.select();
        } else {
            this.cEG.aoe();
        }
    }

    void amP() {
        this.cEH.L(this.cGH.getView());
    }

    private void anU() {
        com.iqoption.core.i.v(TAG, "callput try setCallPutDigital");
        if (this.cGK != null && this.cGK != this.cGJ) {
            com.iqoption.core.i.d(TAG, "callput ->setCallPutDigital");
            this.cGK = this.cGJ;
            TransitionManager.beginDelayedTransition((ConstraintLayout) this.cGH.getView(), this.cGN);
            this.cGJ.applyTo((ConstraintLayout) this.cGH.getView());
            this.cGL.setVisibility(0);
            this.cGM.setVisibility(0);
        }
    }

    private void anV() {
        com.iqoption.core.i.v(TAG, "callput try setCallPutSpot");
        if (this.cGK != null && this.cGK != this.cGI) {
            com.iqoption.core.i.d(TAG, "callput ->setCallPutSpot");
            this.cGK = this.cGI;
            TransitionManager.beginDelayedTransition((ConstraintLayout) this.cGH.getView(), this.cGN);
            this.cGI.applyTo((ConstraintLayout) this.cGH.getView());
            this.cGL.setVisibility(8);
            this.cGM.setVisibility(8);
        }
    }

    private void amQ() {
        this.cEH.L(this.cGG.bRp);
    }

    void ds(boolean z) {
        this.cEL = z;
    }

    @Nullable
    public InstrumentType getInstrumentType() {
        return this.instrumentType;
    }
}
