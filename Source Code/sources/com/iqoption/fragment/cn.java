package com.iqoption.fragment;

import android.animation.Animator;
import android.databinding.DataBindingUtil;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.TextView;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.iqoption.analytics.n;
import com.iqoption.app.IQApp;
import com.iqoption.app.af;
import com.iqoption.app.managers.r;
import com.iqoption.app.managers.t;
import com.iqoption.core.i;
import com.iqoption.d.sj;
import com.iqoption.dto.Balance;
import com.iqoption.dto.Currencies;
import com.iqoption.dto.Currencies.ConversionCurrency;
import com.iqoption.dto.Event.Builder;
import com.iqoption.dto.entity.result.KycState;
import com.iqoption.fragment.base.f;
import com.iqoption.fragment.dialog.s;
import com.iqoption.portfolio.a.p;
import com.iqoption.system.a.e;
import com.iqoption.util.EventSenderLifecycleObserver;
import com.iqoption.util.ag;
import com.iqoption.util.au;
import com.iqoption.util.bc;
import com.iqoption.util.bg;
import com.iqoption.util.g;
import com.iqoption.util.l;
import com.iqoption.util.q;
import com.iqoption.x.R;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

/* compiled from: TokenBalanceFragment */
public class cn extends f {
    private Animator crg;
    private double crh = 0.0d;
    final JsonObject cri = new JsonObject();
    private final a crj = new a(this);
    private final c crk = new c(this);
    private final DecimalFormat crl = q.dX(2);
    private final DecimalFormat crm = l.aGc();
    private final t crn = new t(new co(this));
    private sj cro;
    private final boolean crp = com.iqoption.app.managers.feature.a.HE();

    /* compiled from: TokenBalanceFragment */
    private static final class a extends e<cn> {
        public a(cn cnVar) {
            super(cnVar);
        }

        @com.google.common.b.e
        public void onBalanceFetched(com.iqoption.app.managers.r.a aVar) {
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    cn cnVar = (cn) a.this.drU.get();
                    if (cnVar != null && cnVar.isAdded()) {
                        cnVar.ahS();
                    }
                }
            });
        }

        @com.google.common.b.e
        public void onEmissionInfoFetchedEvent(com.iqoption.app.managers.r.b bVar) {
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    cn cnVar = (cn) a.this.drU.get();
                    if (cnVar != null && cnVar.isAdded()) {
                        cnVar.ahS();
                    }
                }
            });
        }

        @com.google.common.b.e
        public void onLeaderBoardResponseFetched(com.iqoption.app.managers.p.a aVar) {
            if (((Boolean) aVar.getValue()).booleanValue()) {
                com.iqoption.core.d.a.aSe.execute(new Runnable() {
                    public void run() {
                        cn cnVar = (cn) a.this.drU.get();
                        if (cnVar != null && cnVar.isAdded()) {
                            cnVar.ahU();
                        }
                    }
                });
            }
        }
    }

    /* compiled from: TokenBalanceFragment */
    private static class b extends com.iqoption.system.c.b<cn, List<Parcelable>> {
        private final String assetName;
        private final double cnV;
        private final double cnW;
        private final boolean cnX;

        public b(cn cnVar, double d, double d2, String str, boolean z) {
            super((Object) cnVar);
            this.cnV = d;
            this.cnW = d2;
            this.assetName = str;
            this.cnX = z;
        }

        /* renamed from: a */
        public void z(@NonNull cn cnVar, List<Parcelable> list) {
            List<Parcelable> list2 = list;
            super.z(cnVar, list);
            cnVar.au(false);
            com.iqoption.withdrawal.crypto.a.a(cnVar.ahQ(), R.id.other_fragment, (KycState) list2.get(0), (com.iqoption.microservice.a.b.a) list2.get(1), (com.iqoption.mobbtech.connect.response.e) list2.get(2), this.cnV, this.cnW, this.assetName, null, R.id.other_fragment, this.cnX);
        }

        /* renamed from: a */
        public void c(@NonNull cn cnVar, Throwable th) {
            super.c(cnVar, th);
            i.e("TokenBalanceFragment", "withdrawal initialize error", th);
            cnVar.au(false);
            com.iqoption.app.a.b.FG();
        }
    }

    /* compiled from: TokenBalanceFragment */
    private static class c extends com.iqoption.system.a.i<cn> {
        public c(cn cnVar) {
            super(cnVar);
        }

        @com.google.common.b.e
        public void onUpdateBalanceFragment(com.iqoption.service.e.l lVar) {
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    cn cnVar = (cn) c.this.drU.get();
                    if (cnVar != null && cnVar.isAdded()) {
                        cnVar.ahS();
                    }
                }
            });
        }
    }

    public static cn ahP() {
        return new cn();
    }

    @NonNull
    private FragmentManager ahQ() {
        return requireActivity().getSupportFragmentManager();
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.cro = (sj) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_token_balance, viewGroup, false);
        this.cro.a(this);
        this.cro.bwR.setLayoutTransition(bg.aGE());
        this.cro.bCg.setLayoutTransition(bg.aGE());
        if (!this.crp) {
            this.cro.bCj.setVisibility(8);
            this.cro.bCK.setVisibility(8);
            this.cro.bCP.setVisibility(8);
            this.cro.bCQ.setVisibility(8);
            this.cro.bCt.setVisibility(8);
            this.cro.bCk.setVisibility(8);
            this.cro.bCl.setVisibility(8);
            this.cro.bCp.setVisibility(8);
            this.cro.bCo.setVisibility(8);
            this.cro.bCN.setVisibility(8);
            this.cro.bCh.setVisibility(8);
            this.cro.bCu.setVisibility(8);
            this.cro.bCg.setBackground(null);
        }
        float dimension = getContext().getResources().getDimension(R.dimen.dp1);
        Paint paint = new Paint(1);
        paint.setStyle(Style.STROKE);
        paint.setStrokeCap(Cap.ROUND);
        paint.setStrokeJoin(Join.ROUND);
        paint.setStrokeWidth(dimension);
        paint.setPathEffect(new DashPathEffect(new float[]{2.0f * dimension, dimension * 3.0f}, 0.0f));
        paint.setColor(ContextCompat.getColor(getContext(), R.color.otn));
        this.cro.bCs.setBackground(new com.iqoption.view.drawable.a(paint));
        this.cro.bCD.setBackground(new com.iqoption.view.drawable.a(paint));
        this.cro.bCE.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                p.a(R.id.fragment, cn.this.ahQ());
            }
        });
        this.cro.bCR.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                com.iqoption.app.a Cw = com.iqoption.app.a.Cw();
                Balance CA = Cw.CA();
                if (CA != null) {
                    cn.this.au(true);
                    ConversionCurrency eh = Cw.eh(Balance.getCurrency(CA));
                    double doubleValue = CA.amount.doubleValue();
                    String name = eh != null ? eh.getName() : "";
                    ag.b(com.iqoption.withdrawal.crypto.a.d(0.0d, doubleValue, name), new b(cn.this, 0.0d, doubleValue, name, true));
                    n.a(doubleValue, name);
                }
            }
        });
        this.cro.bCz.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                boolean eN = af.eN("otn_commmision") ^ 1;
                cn.this.cro.bCB.setChecked(eN);
                af.i("otn_commmision", eN);
                IQApp.Dn().aE(new com.iqoption.fragment.bt.a().setValue(Boolean.valueOf(eN)));
                n.aA(eN);
            }
        });
        this.cro.bCP.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                boolean isSelected = view.isSelected() ^ 1;
                view.setSelected(isSelected);
                int i = 8;
                cn.this.cro.bCQ.setVisibility(isSelected ? 0 : 8);
                TextView textView = cn.this.cro.bCt;
                if (isSelected) {
                    i = 0;
                }
                textView.setVisibility(i);
            }
        });
        this.cro.bCF.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                boolean isSelected = view.isSelected() ^ 1;
                view.setSelected(isSelected);
                cn.this.cro.bCG.setVisibility(isSelected ? 0 : 8);
            }
        });
        this.cro.bCk.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                boolean isSelected = view.isSelected() ^ 1;
                view.setSelected(isSelected);
                int i = 8;
                cn.this.cro.bCl.setVisibility(isSelected ? 0 : 8);
                cn.this.cro.bCo.setVisibility(isSelected ? 0 : 8);
                cn.this.cro.bCp.setVisibility(isSelected ? 0 : 8);
                view = cn.this.cro.bCj;
                if (isSelected) {
                    i = 0;
                }
                view.setVisibility(i);
            }
        });
        this.cro.bCy.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                cn.this.ahR();
            }
        });
        ahS();
        return this.cro.getRoot();
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        getLifecycle().a(new EventSenderLifecycleObserver("otn_show-left-bar-menu", new cp(this)));
    }

    final /* synthetic */ kotlin.l g(Builder builder) {
        this.cri.add("pay_commission_otn", new JsonPrimitive(Boolean.valueOf(af.eN("otn_commmision"))));
        builder.setValue(Double.valueOf(this.crh)).setParameters(this.cri);
        return null;
    }

    private void ahR() {
        ahQ().beginTransaction().add(R.id.other_fragment, fb.ab(new g().aA("EXTRA_URL", "https://otn.org/?aff=6&afftrack=android_app").toBundle()), "WebFragment").setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).addToBackStack("WebFragment").commit();
    }

    private void ahS() {
        int i;
        com.iqoption.app.a Cw = com.iqoption.app.a.Cw();
        if (Cw.Cy() != 1 || Cw.CZ()) {
            i = 8;
            this.cro.bCE.setVisibility(8);
            this.cro.bCH.setVisibility(8);
            this.cro.bCd.setVisibility(8);
            this.cro.bCu.setVisibility(8);
            this.cro.bCR.setVisibility(8);
            this.cro.bCg.setVisibility(8);
            this.cro.bCk.setVisibility(8);
            this.cro.bCl.setVisibility(8);
            this.cro.bCo.setVisibility(8);
            this.cro.bCp.setVisibility(8);
            this.cro.bCL.setVisibility(8);
            this.cro.bCL.setVisibility(8);
            this.cro.bCM.setVisibility(0);
        } else {
            r rVar;
            ConversionCurrency eh = Cw.eh(Currencies.OTN_CURRENCY);
            ConversionCurrency eh2 = Cw.eh(Balance.getCurrency(Cw.cG(1)));
            String d = l.d(eh2);
            double doubleValue = l.c(eh2).doubleValue();
            double doubleValue2 = l.c(eh).doubleValue();
            this.cro.bCd.setVisibility(0);
            this.cro.bCg.setVisibility(0);
            r GT = r.GT();
            Balance CA = Cw.CA();
            if (CA == null) {
                ahT();
                a(doubleValue2, doubleValue, d);
                this.cro.bCE.setVisibility(8);
                this.cro.bCR.setVisibility(8);
                this.cro.bCF.setVisibility(8);
                this.cro.bCz.setVisibility(8);
                this.cro.bCu.setVisibility(0);
                rVar = GT;
            } else {
                this.cro.bCE.setVisibility(0);
                this.cro.bCR.setVisibility(0);
                ahT();
                Balance balance = CA;
                a(doubleValue2, doubleValue, d);
                if (Balance.getBalanceValue(balance) > 0.0d) {
                    this.cro.bCR.setEnabled(true);
                    this.cro.bCd.setVisibility(0);
                    this.cro.bCu.setVisibility(8);
                } else {
                    this.cro.bCR.setEnabled(false);
                    this.cro.bCd.setVisibility(8);
                    if (this.crp) {
                        this.cro.bCu.setVisibility(0);
                    }
                }
                this.crh = Balance.getBalanceValue(balance);
                this.cro.bCD.setText(l.a(Currencies.REPLACE_CURRENCY_MASK, Double.valueOf(this.crh), this.crm));
                this.cro.bCF.setVisibility(0);
                this.cro.bCz.setVisibility(0);
                this.cro.bCB.setChecked(af.eN("otn_commmision"));
                if (com.iqoption.app.managers.feature.b.HT().fg("show-otn-rate")) {
                    rVar = GT;
                    this.cro.bCC.setText(a(doubleValue2, Balance.getBalanceValue(balance), doubleValue, d));
                    this.cro.bCC.setVisibility(0);
                } else {
                    rVar = GT;
                    i = 8;
                    this.cro.bCC.setVisibility(8);
                    a(rVar, Currencies.REPLACE_CURRENCY_MASK, d, Double.valueOf(doubleValue));
                    a(rVar, Currencies.REPLACE_CURRENCY_MASK);
                }
            }
            i = 8;
            a(rVar, Currencies.REPLACE_CURRENCY_MASK, d, Double.valueOf(doubleValue));
            a(rVar, Currencies.REPLACE_CURRENCY_MASK);
        }
        this.cro.bCy.setVisibility(i);
        this.cro.bCx.setVisibility(i);
        if (this.cro.bCu.getVisibility() == 0 && af.eN("otn_loyalty_teaser_played_token_balance_panel")) {
            this.cro.bCu.aIv();
        }
    }

    private void a(Double d, Double d2) {
        if (isAdded()) {
            if (d != null) {
                bc aGw = new bc().bM(new ForegroundColorSpan(ContextCompat.getColor(getContext(), R.color.white))).jO(l.G(d.doubleValue())).aGw();
                if (d2 != null) {
                    aGw.bM(new ForegroundColorSpan(ContextCompat.getColor(getContext(), d2.doubleValue() >= 0.0d ? R.color.green : R.color.red))).jO(" (").jO(com.iqoption.core.util.p.n(d2.doubleValue())).jO(")").aGw();
                }
                this.cro.bCH.setText(aGw.aCT());
            } else {
                this.cro.bCH.setText(getString(R.string.n_a));
            }
        }
    }

    private void ahT() {
        if (this.crn.isEnabled()) {
            this.crn.Ho();
            return;
        }
        this.cro.bCH.setTextColor(ContextCompat.getColor(getContext(), R.color.grey_blur));
        this.cro.bCH.setText(getString(R.string.coming_soon));
    }

    private void a(double d, double d2, String str) {
        if (com.iqoption.app.managers.feature.b.HT().fg("show-otn-rate")) {
            this.cro.bCw.setText(l.a(str, l.d(l.e(Double.valueOf(1.0d), Double.valueOf(d)), Double.valueOf(d2)), this.crl));
            this.cro.bCv.setVisibility(0);
            return;
        }
        this.cro.bCv.setVisibility(8);
    }

    private void a(r rVar, String str, String str2, Double d) {
        if (this.crp) {
            Number He = rVar.He();
            if (He == null || He.doubleValue() <= 0.0d) {
                this.cro.bCi.setVisibility(8);
                this.cro.bCN.setVisibility(8);
                this.cro.bCu.setVisibility(0);
            } else {
                this.cro.bCO.setText(l.a(str2, Double.valueOf(l.d((Double) He, d).doubleValue()), this.crl));
                BigDecimal Hd = rVar.Hd();
                if (Hd != null) {
                    this.cro.bCs.setText(l.a(str, Double.valueOf(Hd.doubleValue()), this.crm));
                    BigDecimal Hi = rVar.Hi();
                    if (Hi != null) {
                        double j = au.j(Hi.doubleValue(), Hd.doubleValue());
                        str2 = getString(R.string.of_all_tokens_distributed_this_week_short);
                        if (com.google.common.c.a.b(j, 0.0d, 0.001d)) {
                            this.cro.bCi.setVisibility(8);
                        } else {
                            this.cro.bCi.setText(new bc().bM(new ForegroundColorSpan(ContextCompat.getColor(getContext(), R.color.otn))).jO(com.iqoption.core.util.p.a(j, "", 2)).aGw().jO(" ").jO(str2).aCT());
                            this.cro.bCi.setVisibility(0);
                        }
                    } else {
                        this.cro.bCi.setVisibility(8);
                    }
                } else {
                    this.cro.bCs.setText(null);
                }
                this.cro.bCN.setVisibility(0);
                this.cri.add("weekly_turnover_expected", new JsonPrimitive(He));
                if (!af.eN("first_show_turnover_info") && this.crg == null) {
                    this.crg = com.iqoption.util.b.bR(this.cro.bCq);
                    this.crg.start();
                }
            }
            ahU();
        }
    }

    private void ahU() {
        if (this.crp) {
            int as = com.iqoption.app.managers.p.GQ().as(0);
            int at = com.iqoption.app.managers.p.GQ().at(0);
            if (at == 0 || as == 0) {
                this.cro.bCT.setVisibility(8);
            } else {
                String[] split = getString(R.string.you_re_of).split(Currencies.REPLACE_CURRENCY_MASK);
                this.cro.bCT.setText(new bc().jO(split[0]).bM(new ForegroundColorSpan(ContextCompat.getColor(getContext(), R.color.otn))).jO(String.valueOf(as)).aGw().jO(split[1]).jO(String.valueOf(at)).aCT());
                this.cro.bCT.setVisibility(0);
            }
            if (this.cro.bCi.getVisibility() == 8 && this.cro.bCT.getVisibility() == 8) {
                this.cro.bCh.setVisibility(8);
            } else {
                this.cro.bCh.setVisibility(0);
            }
        }
    }

    private void a(r rVar, String str) {
        if (this.crp) {
            double d;
            this.cro.bCk.setVisibility(0);
            BigDecimal Hi = rVar.Hi();
            BigDecimal Hj = rVar.Hj();
            if (Hi != null) {
                this.cro.bCn.setText(l.a(str, Double.valueOf(Hi.doubleValue()), this.crm));
            } else {
                this.cro.bCn.setText(getString(R.string.n_a));
            }
            if (Hj != null) {
                this.cro.bCm.setText(l.a(str, Double.valueOf(Hj.doubleValue()), this.crm));
            } else {
                this.cro.bCm.setText(getString(R.string.n_a));
            }
            int size = rVar.Hm().size() + 1;
            BigDecimal Hh = rVar.Hh();
            BigDecimal Hg = rVar.Hg();
            this.cro.bCJ.setText(getString(R.string.tokens_left_week_n1, String.valueOf(size)));
            if (Hg == null) {
                d = 0.0d;
            } else {
                d = Hg.doubleValue();
            }
            d -= Hh == null ? 0.0d : Hh.doubleValue();
            this.cro.bCL.setText(d > 0.0d ? l.a(str, Double.valueOf(d), this.crm) : getString(R.string.n_a));
            this.cri.add("week_num", new JsonPrimitive(Integer.valueOf(size)));
        }
    }

    private void au(boolean z) {
        if (z) {
            this.cro.bCf.setVisibility(0);
            this.cro.bCS.setText(null);
            return;
        }
        this.cro.bCf.setVisibility(8);
        this.cro.bCS.setText(R.string.withdraw);
    }

    private String a(double d, double d2, double d3, String str) {
        this.cri.add("otn_usd_rate", new JsonPrimitive(l.d(l.e(Double.valueOf(1.0d), Double.valueOf(d)), Double.valueOf(d3))));
        return getString(R.string.you_have_n1_by_int_rate, l.a(str, Double.valueOf(r3.doubleValue() * d2), this.crl));
    }

    public void onPause() {
        super.onPause();
        this.crn.onPause();
        if (this.crg != null) {
            this.crg.cancel();
        }
    }

    public void onResume() {
        super.onResume();
        this.crn.onResume();
        if (this.crg != null && !this.crg.isRunning()) {
            this.crg.start();
        }
    }

    public void onStop() {
        super.onStop();
        this.crj.unregister();
        this.crk.unregister();
    }

    public void onStart() {
        super.onStart();
        this.crj.register();
        this.crk.register();
        r.GT().GV();
        if (com.iqoption.app.managers.feature.a.HF()) {
            com.iqoption.app.managers.p.GQ().ar(0);
        }
    }

    public Animation onCreateAnimation(int i, boolean z, int i2) {
        Animation onCreateAnimation = super.onCreateAnimation(i, z, i2);
        if (z && onCreateAnimation != null) {
            onCreateAnimation.setAnimationListener(com.iqoption.view.a.a.a.a.c(new cq(this)));
        }
        return onCreateAnimation;
    }

    final /* synthetic */ void ahW() {
        if (this.cro.bCu.getVisibility() == 0 && !af.eN("otn_loyalty_teaser_played_token_balance_panel")) {
            af.i("otn_loyalty_teaser_played_token_balance_panel", true);
            this.cro.bCu.play();
        }
    }

    public void ahV() {
        s.a(R.id.fragment, ahQ());
        af.i("first_show_turnover_info", true);
        if (this.crg != null) {
            this.crg.cancel();
            this.crg = null;
        }
        n.BL();
    }
}
