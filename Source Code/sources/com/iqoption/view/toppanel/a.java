package com.iqoption.view.toppanel;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.iqoption.analytics.EventManager;
import com.iqoption.app.managers.a.k;
import com.iqoption.app.managers.af;
import com.iqoption.core.util.i;
import com.iqoption.core.util.p;
import com.iqoption.d.fi;
import com.iqoption.dto.Event;
import com.iqoption.dto.entity.position.Position;
import com.iqoption.fragment.base.f;
import com.iqoption.fragment.dialog.d;
import com.iqoption.mobbtech.connect.request.api.a.c;
import com.iqoption.mobbtech.connect.response.options.e;
import com.iqoption.util.bg;
import com.iqoption.util.h;
import com.iqoption.util.h.b;
import com.iqoption.util.l;
import com.iqoption.util.q;
import com.iqoption.x.R;

/* compiled from: CloseCfdForexPositionDelegate */
public class a extends e implements d {
    private final b agh = new b() {
        public void f(double d) {
            a.this.dJW.bnv.setText(String.format(" (%s)", new Object[]{p.b(Double.valueOf(d))}));
            a.this.dJW.bnv.setTextColor(a.this.ahg);
        }

        public void g(double d) {
            a.this.dJW.bnv.setText(String.format(" (%s)", new Object[]{p.c(Double.valueOf(d))}));
            a.this.dJW.bnv.setTextColor(a.this.ahh);
        }

        public void h(double d) {
            a.this.dJW.bnv.setText(String.format(" (%s)", new Object[]{p.o(0.0d)}));
            a.this.dJW.bnv.setTextColor(a.this.dKg);
        }
    };
    private fi dJW;
    private Position dJX;
    private int dJY = 6;
    private final b dJZ = new b() {
        public void f(double d) {
            a.this.dJW.bnu.setText(p.gX(l.e(a.this.mask, Double.valueOf(d))));
            a.this.dJW.bnu.setTextColor(a.this.ahg);
        }

        public void g(double d) {
            a.this.dJW.bnu.setText(p.gY(l.e(a.this.mask, Double.valueOf(d))));
            a.this.dJW.bnu.setTextColor(a.this.ahh);
        }

        public void h(double d) {
            a.this.dJW.bnu.setText(l.e(a.this.mask, Double.valueOf(0.0d)));
            a.this.dJW.bnu.setTextColor(a.this.dKg);
        }
    };

    a(f fVar, com.iqoption.mobbtech.connect.response.options.b bVar, Position position) {
        super(fVar, bVar);
        this.dJX = position;
    }

    @NonNull
    public View f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        this.dJW = fi.h(layoutInflater, viewGroup, false);
        this.dJW.bnt.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                if (a.this.dJX != null && !com.iqoption.mobbtech.connect.request.api.a.a.x(a.this.dJX.getId())) {
                    switch (a.this.dJX.getInstrumentType()) {
                        case FOREX_INSTRUMENT:
                            if (!com.iqoption.settings.b.aDQ().Fq()) {
                                a.this.x(a.this.dJX);
                                break;
                            } else {
                                d.a((int) R.id.other_fragment, a.this.getSupportFragmentManager(), a.this.aKa().ajW(), a.this.dJX);
                                break;
                            }
                        case CRYPTO_INSTRUMENT:
                        case CFD_INSTRUMENT:
                            d.a((int) R.id.other_fragment, a.this.getSupportFragmentManager(), a.this.aKa().ajW(), a.this.dJX);
                            break;
                    }
                }
            }
        });
        this.dJW.bno.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                if (a.this.dJX != null) {
                    EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "traderoom_open-tpsl-limits-settings").build());
                    com.iqoption.dialog.c.b.a(a.this.getSupportFragmentManager(), (int) R.id.other_fragment, a.this.dJX);
                }
            }
        });
        a(this.dKf, this.dJX);
        return this.dJW.getRoot();
    }

    private void aJS() {
        this.dJW.bns.setText(q.dY(this.dJY).format(this.dJX.getOpenPriceEnrolled()));
    }

    public void a(com.iqoption.mobbtech.connect.response.options.b bVar, Position position) {
        super.a(bVar, position);
        this.dJX = position;
        com.iqoption.core.microservices.tradingengine.response.active.a a = com.iqoption.app.helpers.a.FI().a(Integer.valueOf(this.dJX.getActiveId()), this.dJX.getInstrumentType());
        K(a);
        if (a != null) {
            this.dJY = a.getPrecision();
        }
        fr(false);
        aJV();
        aJW();
        aJS();
        aJT();
        cx(af.Hu().Hw());
    }

    private void K(com.iqoption.core.microservices.tradingengine.response.active.a aVar) {
        Object obj = (aVar == null || !aVar.isExpired()) ? null : 1;
        if (obj != null) {
            this.dJW.bny.setText(k.aw(this.dJX.getExpireTime()));
            this.dJW.bnz.setVisibility(0);
            return;
        }
        this.dJW.bnz.setVisibility(8);
    }

    private void aJT() {
        double sellPnl = this.dJX.getSellPnl();
        Double valueOf = Double.valueOf((100.0d * sellPnl) / this.dJX.getInvestSum().doubleValue());
        h.a(sellPnl, this.dJZ);
        h.a(valueOf.doubleValue(), this.agh);
    }

    public void destroy() {
        aJU();
    }

    public void fr(boolean z) {
        if (z && this.dJW.bnn.getVisibility() == 8) {
            this.dJW.bnt.animate().alpha(0.0f).setListener(com.iqoption.view.a.a.a.a.ch(this.dJW.bnt)).start();
            this.dJW.bnn.animate().alpha(1.0f).setListener(com.iqoption.view.a.a.a.a.ci(this.dJW.bnn)).start();
        } else if (!z && this.dJW.bnn.getVisibility() == 0) {
            this.dJW.bnt.animate().alpha(1.0f).setListener(com.iqoption.view.a.a.a.a.ci(this.dJW.bnt)).start();
            this.dJW.bnn.animate().alpha(0.0f).setListener(com.iqoption.view.a.a.a.a.ch(this.dJW.bnn)).start();
        }
    }

    public void cw(long j) {
        aJT();
        cx(j);
    }

    private void aJU() {
        this.dJW.bnt.setSelected(true);
        this.dJW.bnt.setEnabled(false);
        this.dJW.bnt.animate().alpha(0.2f).setListener(com.iqoption.view.a.a.a.a.ci(this.dJW.bnt)).start();
        this.dJW.bnn.animate().alpha(0.0f).setListener(com.iqoption.view.a.a.a.a.ch(this.dJW.bnn)).start();
    }

    private void fs(boolean z) {
        if (z) {
            this.dJW.bnt.setEnabled(true);
            this.dJW.bnt.setAlpha(1.0f);
            return;
        }
        this.dJW.bnt.animate().cancel();
        this.dJW.bnt.setEnabled(false);
        this.dJW.bnt.setAlpha(0.2f);
    }

    private void ft(boolean z) {
        fs(z);
    }

    private void aJV() {
        if (this.dJX != null) {
            if (Position.isLong(this.dJX)) {
                this.dJW.bnB.setText(R.string.buy);
                this.dJW.bnB.setTextColor(this.ahg);
                bg.f(this.dJW.bnB, R.drawable.deal_green);
            } else {
                this.dJW.bnB.setText(R.string.sell);
                this.dJW.bnB.setTextColor(this.ahh);
                bg.f(this.dJW.bnB, R.drawable.deal_red);
            }
        }
    }

    private void aJW() {
        if (this.dJX != null) {
            String str = this.dKh;
            if (this.dJX.getInvestSum() != null) {
                str = l.e(this.mask, this.dJX.getInvestSum());
            }
            this.dJW.bnA.setText(String.format("%s %s", new Object[]{str, p.ea(this.dJX.getLeverage())}));
        }
    }

    private boolean cx(long j) {
        if (cy(j)) {
            return true;
        }
        ft(false);
        return false;
    }

    public boolean cy(long j) {
        if (this.dJX == null) {
            return false;
        }
        com.iqoption.core.microservices.tradingengine.response.active.a a = com.iqoption.app.helpers.a.FI().a(Integer.valueOf(this.dJX.getActiveId()), this.dJX.getInstrumentType());
        if (a == null || !a.ba(j)) {
            return false;
        }
        return true;
    }

    public void x(e eVar) {
        fr(true);
        c.k(this.dJX);
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "traderoom_sell").setParameters(i.ZZ().l("instrument_type", this.dJX.getInstrumentType()).aab()).build());
    }
}
