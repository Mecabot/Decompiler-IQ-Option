package com.iqoption.fragment.rightpanel;

import android.arch.lifecycle.Observer;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.microservices.risks.response.overnightfee.d;
import com.iqoption.core.util.p;
import com.iqoption.d.aik;
import com.iqoption.dto.entity.ActiveQuote;
import com.iqoption.dto.entity.position.Order;
import com.iqoption.fragment.bq;
import com.iqoption.fragment.bq.c;
import com.iqoption.fragment.bw;
import com.iqoption.fragment.bx;
import com.iqoption.gl.NativeHandler;
import com.iqoption.system.a.e;
import com.iqoption.tutorial.StepDoneType;
import com.iqoption.tutorial.TutorialViewModel;
import com.iqoption.util.ag;
import com.iqoption.util.bc;
import com.iqoption.util.bg;
import com.iqoption.util.l;
import com.iqoption.util.q;
import com.iqoption.view.h;
import com.iqoption.x.R;
import java.text.DecimalFormat;
import java.util.Locale;

/* compiled from: CfdOnOpenRightPanelDelegate */
public class g extends au implements com.iqoption.view.a.b.a {
    private double aTA;
    private TutorialViewModel aeq;
    private final int ahg;
    private final int ahh;
    private final int ahi;
    private com.iqoption.core.microservices.tradingengine.response.active.a aiJ;
    private x cEH;
    private boolean cEL;
    private final e cEY = new e(this);
    private final DecimalFormat cEy = q.dX(2);
    private String cFe;
    private final a cFf = new a(this);
    private aik cFg;
    private final ay cFh = new ay();
    private Double cFi = null;
    private double cFj;
    private ax cFk;
    private ax cFl;
    private final boolean cFm;
    private final boolean cFn;
    private volatile Boolean cFo = null;
    private volatile Boolean cFp = null;
    @Nullable
    private d cFq = null;
    private final Observer<d> cFr = new h(this);
    private volatile Double ckA = null;
    private volatile Double ckB = null;
    private final boolean cki;
    private int multiplier;

    /* compiled from: CfdOnOpenRightPanelDelegate */
    private static class a extends e<g> {
        a(g gVar) {
            super(gVar);
        }

        @com.google.common.b.e
        public void onAmountChangedIQKeyboardEvent(com.iqoption.view.h.a aVar) {
            g gVar = (g) this.drU.get();
            if (gVar != null) {
                gVar.y(((Double) aVar.getValue()).doubleValue());
            }
        }

        @com.google.common.b.e
        public void onChosenMultiplierChooser(c cVar) {
            com.iqoption.app.managers.tab.a.g IC = com.iqoption.app.managers.tab.a.Il().IC();
            if (IC != null) {
                IC.a("tabSetting.multiplier", Integer.valueOf(cVar.multiplier));
            }
            g gVar = (g) this.drU.get();
            if (gVar != null) {
                gVar.setMultiplier(cVar.multiplier);
            }
        }

        @com.google.common.b.e
        public void onNativeChangeLimitOrderValueEvent(NativeHandler.c cVar) {
            g gVar = (g) this.drU.get();
            if (gVar != null && gVar.cFm) {
                gVar.j((Double) cVar.getValue());
                gVar.anB();
            }
        }

        @com.google.common.b.e
        public void onChangeLimitOrderValueEvent(com.iqoption.fragment.bx.a aVar) {
            g gVar = (g) this.drU.get();
            if (gVar != null && gVar.cFm) {
                gVar.j(aVar.value);
                if (aVar.cqy) {
                    gVar.anA();
                }
            }
        }

        @com.google.common.b.e
        public void onShowedPendingEdit(com.iqoption.fragment.bx.b bVar) {
            g gVar = (g) this.drU.get();
            if (gVar != null && gVar.cFm) {
                if (!bVar.aos) {
                    gVar.j(bVar.value);
                    gVar.anA();
                }
                gVar.dv(bVar.aos);
            }
        }

        @com.google.common.b.e
        public void onShowedOvernightFeeInfo(bw.c cVar) {
            com.iqoption.core.d.a.aSe.execute(new i(this, cVar));
        }

        final /* synthetic */ void a(bw.c cVar) {
            g gVar = (g) this.drU.get();
            if (gVar != null) {
                gVar.du(((Boolean) cVar.getValue()).booleanValue());
            }
        }

        @com.google.common.b.e
        public void onShowedLimitsDialogEvent(com.iqoption.dialog.c.b.b bVar) {
            g gVar = (g) this.drU.get();
            if (gVar != null) {
                gVar.m((Boolean) bVar.getValue());
            }
        }

        @com.google.common.b.e
        public void onLimitsChangeEvent(com.iqoption.dialog.c.b.a aVar) {
            g gVar = (g) this.drU.get();
            if (gVar != null) {
                gVar.a(aVar.ckA, aVar.ckB, aVar.cjX, aVar.cka);
                gVar.ant();
            }
        }
    }

    /* compiled from: CfdOnOpenRightPanelDelegate */
    private static class b extends com.iqoption.system.c.b<g, com.iqoption.core.microservices.tradingengine.response.c.a> {
        b(g gVar) {
            super((Object) gVar);
        }

        /* renamed from: a */
        public void z(@NonNull g gVar, @NonNull com.iqoption.core.microservices.tradingengine.response.c.a aVar) {
            super.z(gVar, aVar);
        }

        /* renamed from: a */
        public void c(@NonNull g gVar, Throwable th) {
            super.c(gVar, th);
        }
    }

    public boolean amH() {
        return true;
    }

    g(RightPanelFragment rightPanelFragment, com.iqoption.core.microservices.tradingengine.response.active.a aVar) {
        super(rightPanelFragment);
        x(aVar);
        Context context = rightPanelFragment.getContext();
        this.ahg = ContextCompat.getColor(context, R.color.green);
        this.ahh = ContextCompat.getColor(context, R.color.red);
        this.ahi = ContextCompat.getColor(context, R.color.white);
        com.iqoption.app.managers.feature.b HT = com.iqoption.app.managers.feature.b.HT();
        this.cFm = HT.ff("pending-order");
        this.cFn = HT.ff("margin-add-on");
        this.cki = HT.ff("trailing-stop");
        this.cFf.register();
        com.iqoption.view.a.b.aIK().a((com.iqoption.view.a.b.a) this);
        this.aeq = TutorialViewModel.D(rightPanelFragment.requireActivity());
        amT().observeForever(this.cFr);
    }

    private void x(com.iqoption.core.microservices.tradingengine.response.active.a aVar) {
        this.aiJ = aVar;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("%.");
        stringBuilder.append(aVar.getPrecision());
        stringBuilder.append("f");
        this.cFe = stringBuilder.toString();
    }

    @NonNull
    View f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        int i = 0;
        this.cFg = (aik) DataBindingUtil.inflate(layoutInflater, R.layout.right_panel_delegate_on_open_cfd, viewGroup, false);
        this.cFk = new ax(this.cFg.bSL.bRc, this.cFg.bSL.bRf, this.cFg.bSL.bRs);
        this.cFl = new ax(this.cFg.bSK.bRc, this.cFg.bSK.bRf, this.cFg.bSK.bQQ, getContext().getResources().getDimension(R.dimen.dp48));
        this.cEH = new x(new w(this.cFg.bSK.getRoot()), this.cFg.bSL.getRoot(), this.cFg.bSK.getRoot());
        this.cFg.bSK.bQS.setLayoutTransition(bg.aGE());
        ang();
        anp();
        anu();
        this.cFg.bSK.bRa.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                Point K = bg.K(view);
                bw.a(g.this.getFragmentManager(), R.id.fragment, K.x, K.y, g.this.aTA, g.this.multiplier, g.this.cEL, g.this.cFq);
            }
        });
        this.cFg.bSK.bRa.setText(new bc().jO(getContext().getString(R.string.overnight_fee).toUpperCase()).C(' ').bM(new ImageSpan(getContext(), R.drawable.ic_info_commission, 1)).C(' ').aGw().aCT());
        if (!this.cFm) {
            i = 8;
        }
        this.cFg.bSL.bRG.setVisibility(i);
        this.cFg.bSK.bRd.setVisibility(i);
        any();
        return this.cFg.getRoot();
    }

    private void ang() {
        OnClickListener anonymousClass2 = new com.iqoption.view.d.b() {
            public void q(View view) {
                switch (view.getId()) {
                    case R.id.amountLayout:
                        h.b(g.this.getFragmentManager(), R.id.fragment, g.this.aTA);
                        return;
                    case R.id.amountMinus:
                        g.this.ani();
                        return;
                    case R.id.amountPlus:
                        g.this.anh();
                        return;
                    case R.id.buttonCall:
                        g.this.bh(view);
                        return;
                    case R.id.buttonPut:
                        g.this.bi(view);
                        return;
                    case R.id.cancelPendingOrder:
                    case R.id.cancelSubmitPendingOrder:
                        g.this.any();
                        return;
                    case R.id.limitsLayoutConfirm:
                        g.this.ank();
                        return;
                    case R.id.multiplierLayout:
                        bq.a(g.this.getFragmentManager(), R.id.fragment, g.this.aiJ.getInstrumentType(), g.this.aiJ.getActiveId());
                        return;
                    case R.id.pendingLayout:
                        bx.a(g.this.getFragmentManager(), g.this.aiJ.getInstrumentType(), g.this.aiJ.getActiveId(), g.this.cFi, true);
                        return;
                    case R.id.pendingLayoutConfirm:
                        bx.a(g.this.getFragmentManager(), g.this.aiJ.getInstrumentType(), g.this.aiJ.getActiveId(), g.this.cFi, true);
                        return;
                    default:
                        return;
                }
            }
        };
        this.cFg.bSL.bRG.setOnClickListener(anonymousClass2);
        this.cFg.bSL.bRh.setOnClickListener(anonymousClass2);
        this.cFg.bSL.bRA.setOnClickListener(anonymousClass2);
        this.cFg.bSL.bRn.setOnClickListener(anonymousClass2);
        this.cFg.bSL.bRo.setOnClickListener(anonymousClass2);
        this.cFg.bSL.bRs.setOnClickListener(anonymousClass2);
        this.cFg.bSL.bRM.setOnClickListener(anonymousClass2);
        this.cFg.bSL.bRN.setOnClickListener(anonymousClass2);
        this.cFg.bSK.bQQ.setOnClickListener(anonymousClass2);
        this.cFg.bSK.bQW.setOnClickListener(anonymousClass2);
        this.cFg.bSK.bRd.setOnClickListener(anonymousClass2);
        this.cFg.bSK.bQM.setOnClickListener(new com.iqoption.view.d.b(1000) {
            public void q(View view) {
                if (g.this.cFi == null) {
                    g.this.anm();
                } else {
                    g.this.anl();
                }
            }
        });
        this.cFg.bSK.bQN.setOnClickListener(new com.iqoption.view.d.b(1000) {
            public void q(View view) {
                if (g.this.cFi == null) {
                    g.this.anb();
                } else {
                    g.this.anj();
                }
            }
        });
    }

    private void anh() {
        y(this.aTA + 1.0d);
    }

    private void ani() {
        if (this.aTA - 1.0d >= 0.0d) {
            y(this.aTA - 1.0d);
        } else {
            y(0.0d);
        }
    }

    private void anb() {
        this.cEY.anf();
        ano();
        anz();
        ann();
    }

    private void anj() {
        boolean anf = this.cEY.anf();
        ano();
        if (anf) {
            any();
        }
        anz();
        ann();
    }

    private void ank() {
        com.iqoption.dialog.c.b.a(getFragmentManager(), this.aiJ.getActiveId(), this.aiJ.getInstrumentType(), this.cEL, this.cFi, this.ckA, this.ckB, this.cFo, this.multiplier, this.aTA, this.cFp);
    }

    private void anl() {
        ano();
        anz();
        ann();
    }

    private void anm() {
        ano();
        any();
        ann();
    }

    private void ann() {
        this.ckA = null;
        this.ckB = null;
        this.cFo = null;
        this.cFp = null;
    }

    private void ano() {
        this.cEH.L(this.cFg.bSL.getRoot());
    }

    private void bi(View view) {
        this.aeq.a(com.iqoption.tutorial.utils.d.aFX(), StepDoneType.TAP_ON_TARGET);
        if (amS()) {
            bg(view);
        }
        this.cEL = false;
        this.cEY.ane();
    }

    private void bh(View view) {
        this.aeq.a(com.iqoption.tutorial.utils.d.aFX(), StepDoneType.TAP_ON_TARGET);
        if (amS()) {
            bg(view);
        }
        this.cEL = true;
        this.cEY.ane();
    }

    private void anp() {
        y(Ea());
    }

    private void y(double d) {
        this.aTA = d;
        anq();
        amL();
        amM();
        anv();
    }

    private void anq() {
        if (this.cEH.bl(this.cFg.bSK.getRoot())) {
            ant();
            anr();
            return;
        }
        ans();
    }

    private void anr() {
        if (this.cFq == null || this.multiplier <= 1) {
            this.cFg.bSK.bQZ.setVisibility(8);
            return;
        }
        Double i = this.cFq.i(getCalendar().get(7), this.cEL);
        if (i != null) {
            this.cFg.bSK.bRb.setText(p.e(i.doubleValue(), 4));
        } else {
            this.cFg.bSK.bRb.setText(R.string.n_a);
        }
        this.cFg.bSK.bQZ.setVisibility(0);
    }

    private void ans() {
        this.cFj = this.cFh.a(this.aTA, this.aiJ, false);
    }

    private void ant() {
        if (this.cEH.bl(this.cFg.bSK.getRoot())) {
            this.cFg.bSK.blS.setText(l.a(this.aTA, this.cEy));
            this.cFg.bSK.blT.setText(p.ea(this.multiplier));
            this.cFg.bSK.bQN.setBackgroundResource(this.cEL ? R.drawable.btn_green_background : R.drawable.btn_red_background);
            this.cFg.bSK.bQN.setText(this.cFi == null ? R.string.confirm : R.string.submit);
            this.cFg.bSK.bru.setText(l.a(this.cFj, this.cEy));
            this.cFg.bSK.bQR.setText(anx());
            if (this.ckA == null && this.ckB == null) {
                this.cFg.bSK.bQY.setText(getContext().getString(R.string.not_set).toUpperCase());
            } else {
                this.cFg.bSK.bQY.setText(new bc().bM(new ForegroundColorSpan(this.ckA == null ? this.ahi : this.ahg)).jO(this.ckA == null ? getContext().getString(R.string.n_a) : p.n(this.ckA.doubleValue())).aGw().jO(" ").bM(new ForegroundColorSpan(this.ckB == null ? this.ahi : this.ahh)).jO(this.ckB == null ? getContext().getString(R.string.n_a) : p.n(this.ckB.doubleValue())).aGw().aCT());
            }
        }
    }

    private void amL() {
        this.cFg.bSL.bwP.setText(l.a(this.aTA, this.cEy));
    }

    private void amM() {
        double doubleValue = com.iqoption.app.a.Cw().Cx().doubleValue();
        double[] N = l.N(getInstrumentType());
        if (this.cFj > doubleValue || this.cFj > N[1] || this.cFj < N[0]) {
            this.cFg.bSL.bwP.setTextColor(this.ahh);
        } else {
            this.cFg.bSL.bwP.setTextColor(this.ahi);
        }
    }

    @Nullable
    public InstrumentType getInstrumentType() {
        return this.aiJ != null ? this.aiJ.instrumentType : null;
    }

    private void anu() {
        com.iqoption.core.microservices.tradingengine.response.b.a y = aq.y(this.aiJ);
        if (y == null) {
            this.cFg.bSL.bRA.setOnClickListener(null);
        }
        setMultiplier(aq.a(y, getInstrumentType()));
    }

    private void setMultiplier(int i) {
        this.multiplier = i;
        anw();
        anv();
    }

    private void anv() {
        this.cFg.bSL.blC.setText(l.a(this.aTA * ((double) this.multiplier), this.cEy));
    }

    private void anw() {
        this.cFg.bSL.bRD.setText(p.ea(this.multiplier));
    }

    private void a(Double d, Double d2, Boolean bool, Boolean bool2) {
        this.ckA = d;
        this.ckB = d2;
        this.cFo = bool;
        this.cFp = bool2;
    }

    private void m(Boolean bool) {
        this.cFg.bSK.bQW.setSelected(bool.booleanValue());
    }

    public void amI() {
        this.cFg.bSK.bQR.setText(anx());
        this.cEH.L(this.cFg.bSK.getRoot());
        ant();
        anA();
    }

    private CharSequence anx() {
        String string = getContext().getString(this.cEL ? R.string.buy : R.string.sell);
        String string2 = getContext().getString(R.string.mkt_on_open_order_n1, new Object[]{string});
        CharSequence spannableString = new SpannableString(string2.toUpperCase(Locale.getDefault()));
        int indexOf = string2.indexOf(string);
        spannableString.setSpan(new ForegroundColorSpan(this.cEL ? this.ahg : this.ahh), indexOf, string.length() + indexOf, 17);
        return spannableString;
    }

    public void amJ() {
        Boolean valueOf;
        Double currentOpenPriceEnrolled = this.cFi != null ? this.cFi : ActiveQuote.getCurrentOpenPriceEnrolled(this.aiJ.getActiveId(), this.cEL, getInstrumentType(), this.multiplier);
        Double a = com.iqoption.dialog.c.a.a(this.ckA, currentOpenPriceEnrolled, this.cEL, this.multiplier);
        currentOpenPriceEnrolled = com.iqoption.dialog.c.a.a(this.ckB, currentOpenPriceEnrolled, this.cEL, this.multiplier);
        if (this.cFn) {
            valueOf = Boolean.valueOf(this.cFo == null ? com.iqoption.settings.b.aDQ().En() : this.cFo.booleanValue());
        } else {
            valueOf = null;
        }
        if (this.cki) {
            Boolean.valueOf(this.cFp == null ? com.iqoption.settings.b.aDQ().Eo() : this.cFp.booleanValue());
        }
        ag.b(com.iqoption.mobbtech.connect.request.api.a.c.a(new com.iqoption.mobbtech.connect.request.api.a.c.a().a((com.iqoption.core.microservices.tradingengine.response.active.h) this.aiJ).fs(this.multiplier).z(this.aTA).bF(com.iqoption.app.a.Cw().getBalanceId().longValue()).ec(this.cEL).iC(Order.ON_MKT_OPEN).m(this.cFi).n(a).o(currentOpenPriceEnrolled).q(valueOf)), new b(this));
    }

    public boolean amK() {
        return this.cEL;
    }

    public double UO() {
        return this.aTA;
    }

    public void onTick(long j) {
        if (this.aiJ.ba(j)) {
            com.iqoption.view.a.b.aIK().b((com.iqoption.view.a.b.a) this);
            amU().aod();
            amU().resetDelegate();
        }
    }

    void destroy() {
        amT().removeObserver(this.cFr);
        com.iqoption.view.a.b.aIK().b((com.iqoption.view.a.b.a) this);
        this.cFf.unregister();
        super.destroy();
    }

    void w(@NonNull com.iqoption.core.microservices.tradingengine.response.active.a aVar) {
        super.w(aVar);
        x(aVar);
        anu();
        ano();
        ann();
        any();
        anq();
    }

    private void j(Double d) {
        if (this.cFm) {
            if (d == null && this.cFi != null) {
                this.cFg.bSL.bRf.setText(R.string.mkt_on_open_market);
                this.cFg.bSK.bRf.setText(R.string.mkt_on_open_market);
                this.cFg.bSL.bRE.animate().alpha(0.0f).setDuration(200).setInterpolator(com.iqoption.view.a.a.d.dEM);
                this.cFg.bSL.bRF.animate().alpha(0.0f).setDuration(200).setInterpolator(com.iqoption.view.a.a.d.dEM);
                this.cFg.bSL.bRj.animate().alpha(1.0f).setDuration(200).setInterpolator(com.iqoption.view.a.a.d.dEM);
                this.cFg.bSL.bRk.animate().alpha(1.0f).setDuration(200).setInterpolator(com.iqoption.view.a.a.d.dEM);
            } else if (d != null) {
                this.cFg.bSL.bRf.setText(String.format(Locale.US, this.cFe, new Object[]{d}));
                this.cFg.bSK.bRf.setText(String.format(Locale.US, this.cFe, new Object[]{d}));
                if (this.cFi == null) {
                    this.cFg.bSL.bRE.animate().alpha(1.0f).setDuration(200).setInterpolator(com.iqoption.view.a.a.d.dEM);
                    this.cFg.bSL.bRF.animate().alpha(1.0f).setDuration(200).setInterpolator(com.iqoption.view.a.a.d.dEM);
                    this.cFg.bSL.bRj.animate().alpha(0.45f).setDuration(200).setInterpolator(com.iqoption.view.a.a.d.dEM);
                    this.cFg.bSL.bRk.animate().alpha(0.45f).setDuration(200).setInterpolator(com.iqoption.view.a.a.d.dEM);
                }
            }
            this.cFi = d;
            ant();
        }
    }

    private void du(boolean z) {
        this.cFg.bSK.bRa.setSelected(z);
    }

    private void dv(boolean z) {
        this.cFg.bSL.bRG.setSelected(z);
        this.cFg.bSK.bRd.setSelected(z);
        if (z) {
            this.cFk.eY(1);
            this.cFl.eY(1);
            return;
        }
        anB();
    }

    private void any() {
        if (this.cFm) {
            if (this.cEH.bl(this.cFg.bSK.getRoot())) {
                anA();
            } else {
                anz();
            }
            j(null);
            anB();
        }
    }

    private void anz() {
        if (this.cFm) {
            com.iqoption.gl.b.aow().glchSetLimitOrder(-1.0d, this.cEL, 0);
        }
    }

    private void anA() {
        if (this.cFm && this.cEH.bl(this.cFg.bSK.getRoot())) {
            com.iqoption.gl.b.aow().glchSetLimitOrder(this.cFi == null ? -1.0d : this.cFi.doubleValue(), this.cEL, 1);
        }
    }

    private void anB() {
        if (this.cFi == null) {
            this.cFk.eY(0);
            this.cFl.eY(0);
            return;
        }
        this.cFk.eY(2);
        this.cFl.eY(2);
    }
}
