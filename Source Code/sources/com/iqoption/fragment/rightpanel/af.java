package com.iqoption.fragment.rightpanel;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.iqoption.app.managers.a.k;
import com.iqoption.app.managers.tab.a.d;
import com.iqoption.app.managers.tab.a.g;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.d.ais;
import com.iqoption.dto.entity.expiration.Expiration;
import com.iqoption.dto.entity.strike.Quote;
import com.iqoption.dto.entity.strike.Strike;
import com.iqoption.fragment.at;
import com.iqoption.gl.NativeHandler;
import com.iqoption.service.e.m;
import com.iqoption.system.a.e;
import com.iqoption.system.a.i;
import com.iqoption.util.bc;
import com.iqoption.util.l;
import com.iqoption.util.q;
import com.iqoption.view.h;
import com.iqoption.x.R;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* compiled from: FxRightPanelDelegate */
public class af extends au implements com.iqoption.view.a.b.a {
    private double aTA;
    private final com.iqoption.core.microservices.tradingengine.response.active.a aiJ;
    private Expiration aop;
    private final y cEC = new y();
    private final SimpleDateFormat cED = new SimpleDateFormat("0:mm:ss", Locale.getDefault());
    private final com.iqoption.h.a.a cEE = com.iqoption.app.managers.tab.a.Il().Iu();
    private aw cEG;
    private x cEH;
    private final int cEI;
    private final int cEJ;
    private final int cEK;
    private boolean cEL;
    private final DecimalFormat cEy = q.dX(2);
    private aw cGD;
    private aw cGE;
    private final int cGF;
    private ais cGY;
    private final a cGZ = new a(this, null);
    private final b cHa = new b(this);
    private final boolean cHb;
    private final Map<Long, Double> cHc;

    /* compiled from: FxRightPanelDelegate */
    public static class c {
        private final af cHl;
        private final e cHm;

        c(af afVar) {
            this.cHl = afVar;
            this.cHm = new e(afVar);
        }

        public void amX() {
            at.a(this.cHl.getFragmentManager(), (int) R.id.fragment);
        }

        public void amY() {
            h.b(this.cHl.getFragmentManager(), R.id.fragment, this.cHl.UO());
        }

        public void bh(View view) {
            if (this.cHl.anY()) {
                if (this.cHl.amS()) {
                    this.cHl.bg(view);
                }
                this.cHl.ds(true);
                this.cHm.ane();
            }
        }

        public void bi(View view) {
            if (this.cHl.anY()) {
                if (this.cHl.amS()) {
                    this.cHl.bg(view);
                }
                this.cHl.ds(false);
                this.cHm.ane();
            }
        }

        public void anb() {
            this.cHl.amP();
            this.cHm.anf();
        }

        public void anc() {
            this.cHl.amP();
        }

        public void and() {
            com.iqoption.app.managers.tab.a.Il().IB();
        }
    }

    /* compiled from: FxRightPanelDelegate */
    private static class a extends e<af> {
        /* synthetic */ a(af afVar, AnonymousClass1 anonymousClass1) {
            this(afVar);
        }

        private a(af afVar) {
            super(afVar);
        }

        @com.google.common.b.e
        public void onInitializationCompletedEvent(d dVar) {
            com.iqoption.core.d.a.aSe.execute(new ah(this));
        }

        final /* synthetic */ void anZ() {
            af afVar = (af) this.drU.get();
            if (afVar != null) {
                afVar.amM();
            }
        }

        @com.google.common.b.e
        public void onAmountChangedIQKeyboardEvent(com.iqoption.view.h.a aVar) {
            com.iqoption.core.d.a.aSe.execute(new ai(this, aVar));
        }

        @com.google.common.b.e
        public void onShowedIQKeyboardEvent(com.iqoption.view.h.b bVar) {
            com.iqoption.core.d.a.aSe.execute(new aj(this, bVar));
        }

        @com.google.common.b.e
        public void onShowedExpirationFragmentEvent(k.d dVar) {
            com.iqoption.core.d.a.aSe.execute(new ak(this, dVar));
        }

        @com.google.common.b.e
        public void onChangeExpirationEvent(com.iqoption.app.managers.a.k.a aVar) {
            if (aVar.aoq == com.iqoption.app.managers.tab.a.Il().ID()) {
                com.iqoption.core.d.a.aSe.execute(new al(this, aVar));
            }
        }

        final /* synthetic */ void c(com.iqoption.app.managers.a.k.a aVar) {
            af afVar = (af) this.drU.get();
            if (afVar != null) {
                afVar.h(aVar.aop);
                afVar.anW();
                afVar.amM();
            }
        }

        @com.google.common.b.e
        public void onChangeStrikeEvent(com.iqoption.app.managers.a.k.b bVar) {
            if (bVar.aoq == com.iqoption.app.managers.tab.a.Il().ID()) {
                com.iqoption.core.d.a.aSe.execute(new am(this, bVar));
            }
        }
    }

    /* compiled from: FxRightPanelDelegate */
    public static class b extends i<af> {
        public b(af afVar) {
            super(afVar);
        }

        @com.google.common.b.e
        public void onChangeBalanceType(com.iqoption.service.e.b bVar) {
            com.iqoption.core.d.a.aSe.execute(new an(this));
        }

        final /* synthetic */ void aoc() {
            af afVar = (af) this.drU.get();
            if (afVar != null) {
                afVar.y(afVar.Ea());
                afVar.amM();
            }
        }

        @com.google.common.b.e
        public void onUpdateBalanceValue(m mVar) {
            com.iqoption.core.d.a.aSe.execute(new ao(this));
        }

        final /* synthetic */ void aob() {
            af afVar = (af) this.drU.get();
            if (afVar != null) {
                afVar.amM();
            }
        }

        @com.google.common.b.e
        public void onChangeCurrentCurrency(com.iqoption.service.e.c cVar) {
            com.iqoption.core.d.a.aSe.execute(new ap(this));
        }

        final /* synthetic */ void aoa() {
            af afVar = (af) this.drU.get();
            if (afVar != null) {
                afVar.amL();
            }
        }
    }

    af(RightPanelFragment rightPanelFragment, com.iqoption.core.microservices.tradingengine.response.active.a aVar) {
        super(rightPanelFragment);
        this.aiJ = aVar;
        this.cHc = com.iqoption.app.managers.feature.a.HQ();
        this.cHb = com.iqoption.app.managers.feature.a.eW("fx-show-expiration-line-mode");
        this.cEI = ContextCompat.getColor(getContext(), R.color.red);
        this.cEJ = ContextCompat.getColor(getContext(), R.color.white);
        this.cEK = rightPanelFragment.getResources().getDimensionPixelSize(R.dimen.dp24);
        this.cGF = rightPanelFragment.getResources().getDimensionPixelSize(R.dimen.sp10);
        this.cGZ.register();
        this.cHa.register();
        com.iqoption.view.a.b.aIK().a((com.iqoption.view.a.b.a) this, Integer.valueOf(5));
    }

    public boolean amH() {
        return com.iqoption.settings.b.aDQ().aDX() ^ 1;
    }

    public void amI() {
        this.cGY.bSd.setType(amK());
        this.cGY.bSd.setExpiration(k.av(this.aop.expValue.longValue()));
        this.cEH.L(this.cGY.bSd);
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

    public double UO() {
        return this.aTA;
    }

    @NonNull
    View f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        final c cVar = new c(this);
        this.cGY = (ais) DataBindingUtil.inflate(layoutInflater, R.layout.right_panel_fx_delegate, viewGroup, false);
        this.cGY.a(cVar);
        this.cGD = new aw(this.cGY.bLU, this.cGY.bSe);
        this.cGE = new aw(this.cGY.bSl, this.cGY.bSk);
        this.cEG = new aw(this.cGY.bSc, this.cGY.bwO);
        this.cEH = new x(this.cEK, this.cGY.bTa, this.cGY.bSd, this.cGY.bRp);
        this.cGY.bSd.setConfirmListener(new com.iqoption.view.d.b(1000) {
            public void q(View view) {
                cVar.anb();
            }
        });
        this.cGY.bSd.setCancelListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                cVar.anc();
            }
        });
        this.cGY.bRp.setBuyNewListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                cVar.and();
            }
        });
        this.cGY.bSY.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                cVar.bh(view);
            }
        });
        this.cGY.bSZ.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                cVar.bi(view);
            }
        });
        y(Ea());
        h(com.iqoption.app.managers.tab.a.Il().Iz());
        c(com.iqoption.app.managers.tab.a.Il().Ix());
        return this.cGY.getRoot();
    }

    void h(Expiration expiration) {
        this.aop = expiration;
        amN();
    }

    private void anW() {
        if (this.cHb && this.aop != null && this.aop.expInterval != null && TimeUnit.HOURS.toMillis(1) <= this.aop.expInterval.longValue()) {
            g IC = com.iqoption.app.managers.tab.a.Il().IC();
            if (IC != null) {
                IC.di(60);
            }
        }
    }

    void y(double d) {
        if (d < 0.0d) {
            d = 0.0d;
        }
        this.aTA = d;
        if (this.cGY != null) {
            this.cGY.bSc.setText(l.a(d, this.cEy));
        }
        amM();
        anT();
    }

    void c(Strike strike) {
        if (this.cGY != null) {
            Double lastSpotValue = strike != null ? strike.isSpot ? strike.getLastSpotValue() : strike.getValue() : null;
            if (lastSpotValue != null) {
                String format = com.iqoption.app.managers.tab.a.Il().Iu().format(lastSpotValue.doubleValue());
                this.cGY.bSl.setText(new bc().bM(new AbsoluteSizeSpan(this.cGF)).jO(format.substring(0, format.length() - 3)).aGw().jO(" ").B(format.subSequence(format.length() - 3, format.length())).aCT());
                return;
            }
            this.cGY.bSl.setText(null);
        }
    }

    private void amN() {
        if (this.cGY != null) {
            this.cGY.bLU.setText(k.HB().a(this.aiJ, this.aop.expValue.longValue()));
            if (this.cEH.bl(this.cGY.bSd)) {
                this.cGY.bSd.setExpiration(k.av(this.aop.expValue.longValue()));
            }
        }
    }

    private double[] anX() {
        double[] N = l.N(getInstrumentType());
        if (!(com.iqoption.core.util.l.x(this.cHc) || this.aop == null || this.aop.expInterval == null)) {
            Double d = (Double) this.cHc.get(this.aop.expInterval);
            if (d != null) {
                N[0] = l.H(d.doubleValue());
            }
        }
        return N;
    }

    private void amM() {
        if (this.cGY != null) {
            double doubleValue = com.iqoption.app.a.Cw().Cx().doubleValue();
            double[] anX = anX();
            if (this.aTA > doubleValue || this.aTA > anX[1] || this.aTA < anX[0]) {
                this.cGY.bSc.setTextColor(this.cEI);
            } else {
                this.cGY.bSc.setTextColor(this.cEJ);
            }
        }
    }

    private boolean anY() {
        double doubleValue = com.iqoption.app.a.Cw().Cx().doubleValue();
        double[] anX = anX();
        if (this.aTA > doubleValue) {
            return true;
        }
        if (this.aTA > anX[1]) {
            dt(true);
            return false;
        } else if (this.aTA >= anX[0]) {
            return true;
        } else {
            dt(false);
            return false;
        }
    }

    private void ds(boolean z) {
        this.cEL = z;
    }

    private void anT() {
        if (this.cGY != null) {
            Strike Ix = com.iqoption.app.managers.tab.a.Il().Ix();
            if (Ix != null) {
                Quote c = com.iqoption.app.managers.c.Gn().c(Ix.call.id, InstrumentType.FX_INSTRUMENT);
                if (isQuoteAvailable(c)) {
                    au.bn(this.cGY.bSY);
                } else {
                    au.bo(this.cGY.bSY);
                }
                Quote c2 = com.iqoption.app.managers.c.Gn().c(Ix.put.id, InstrumentType.FX_INSTRUMENT);
                if (isQuoteAvailable(c2)) {
                    au.bn(this.cGY.bSZ);
                } else {
                    au.bo(this.cGY.bSZ);
                }
                NativeHandler.instance().singleThreadExecutor.execute(new ag(Ix, c, c2));
                return;
            }
            au.bo(this.cGY.bSY);
            au.bo(this.cGY.bSZ);
        }
    }

    void destroy() {
        super.destroy();
        this.cGZ.unregister();
        this.cHa.unregister();
        com.iqoption.view.a.b.aIK().b((com.iqoption.view.a.b.a) this);
    }

    @Nullable
    public InstrumentType getInstrumentType() {
        return this.aiJ != null ? this.aiJ.instrumentType : null;
    }

    public void onTick(long j) {
        com.iqoption.app.managers.tab.a Il = com.iqoption.app.managers.tab.a.Il();
        if (this.cEH.bl(this.cGY.bRp)) {
            if (b(this.aiJ, j)) {
                this.cGY.bRp.setTimeToClose(this.cED.format(this.cEC.bw(this.aop.expValue.longValue() - j)));
            } else {
                amP();
            }
        } else if (b(this.aiJ, j)) {
            com.iqoption.app.managers.tab.a.Il().d(com.iqoption.app.managers.tab.a.Il().IC());
            amQ();
        } else {
            anT();
        }
        if (this.cEH.bl(this.cGY.bSd)) {
            this.cGY.bSd.setLevel(this.cEE.format(com.iqoption.gl.b.aow().glchTabGetActualValue(Il.IE())));
        }
        if (!this.cHt) {
            return;
        }
        if (com.iqoption.app.managers.af.Hu().Hz()) {
            au.bn(this.cGY.bSY);
            au.bn(this.cGY.bSZ);
            return;
        }
        au.bo(this.cGY.bSY);
        au.bo(this.cGY.bSZ);
    }

    private boolean b(@NonNull com.iqoption.core.microservices.tradingengine.response.active.a aVar, long j) {
        if (j <= this.aop.expValue.longValue() - k.HB().c(aVar, this.aop) || j >= this.aop.expValue.longValue()) {
            return false;
        }
        return com.iqoption.app.managers.c.Gn().b(new com.iqoption.mobbtech.connect.response.options.i(Long.valueOf(this.aop.expValue.longValue() / 1000), Integer.valueOf(aVar.getActiveId()), aVar.getInstrumentType())) ^ 1;
    }

    void amP() {
        this.cEH.L(this.cGY.bTa);
    }

    void amQ() {
        this.cEH.L(this.cGY.bRp);
    }

    private void amL() {
        this.cGY.bSc.setText(l.a(this.aTA, this.cEy));
    }

    void dq(boolean z) {
        this.cGY.bSg.setSelected(z);
        this.cGY.bSf.setSelected(z);
        if (z) {
            this.cGD.select();
            this.cGE.select();
            return;
        }
        this.cGD.aoe();
        this.cGE.aoe();
    }

    void dr(boolean z) {
        this.cGY.bRi.setSelected(z);
        this.cGY.bRh.setSelected(z);
        if (z) {
            this.cEG.select();
        } else {
            this.cEG.aoe();
        }
    }

    private static boolean isQuoteAvailable(Quote quote) {
        return (quote == null || quote.askPrice == null || quote.getProfitPercent() <= 0) ? false : true;
    }
}
