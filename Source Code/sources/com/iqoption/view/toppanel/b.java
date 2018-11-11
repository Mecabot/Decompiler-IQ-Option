package com.iqoption.view.toppanel;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.common.base.e;
import com.iqoption.analytics.EventManager;
import com.iqoption.app.managers.a.k;
import com.iqoption.app.managers.af;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.microservices.tradingengine.response.active.a;
import com.iqoption.core.util.i;
import com.iqoption.core.util.p;
import com.iqoption.d.fg;
import com.iqoption.dto.Event;
import com.iqoption.dto.entity.position.Position;
import com.iqoption.fragment.base.f;
import com.iqoption.fragment.dialog.d;
import com.iqoption.mobbtech.connect.request.api.a.c;
import com.iqoption.util.ag;
import com.iqoption.util.h;
import com.iqoption.util.l;
import com.iqoption.x.R;

/* compiled from: CloseGroupDelegate */
public class b extends e implements c {
    private final com.iqoption.util.h.b agh = new com.iqoption.util.h.b() {
        public void f(double d) {
            b.this.dKb.bnv.setText(String.format(" (%s)", new Object[]{p.b(Double.valueOf(d))}));
            b.this.dKb.bnv.setTextColor(b.this.ahg);
        }

        public void g(double d) {
            b.this.dKb.bnv.setText(String.format(" (%s)", new Object[]{p.c(Double.valueOf(d))}));
            b.this.dKb.bnv.setTextColor(b.this.ahh);
        }

        public void h(double d) {
            b.this.dKb.bnv.setText(String.format(" (%s)", new Object[]{p.o(0.0d)}));
            b.this.dKb.bnv.setTextColor(b.this.dKg);
        }
    };
    private final com.iqoption.util.h.b dJZ = new com.iqoption.util.h.b() {
        public void f(double d) {
            b.this.dKb.bnu.setText(p.gX(l.e(b.this.mask, Double.valueOf(d))));
            b.this.dKb.bnu.setTextColor(b.this.ahg);
        }

        public void g(double d) {
            b.this.dKb.bnu.setText(p.gY(l.e(b.this.mask, Double.valueOf(d))));
            b.this.dKb.bnu.setTextColor(b.this.ahh);
        }

        public void h(double d) {
            b.this.dKb.bnu.setText(l.e(b.this.mask, Double.valueOf(0.0d)));
            b.this.dKb.bnu.setTextColor(b.this.dKg);
        }
    };
    private fg dKb;

    b(f fVar, com.iqoption.mobbtech.connect.response.options.b bVar) {
        super(fVar, bVar);
    }

    @NonNull
    public View f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        this.dKb = fg.g(layoutInflater, viewGroup, false);
        this.dKb.bnt.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                if (b.this.dKf != null) {
                    switch (b.this.dKf.instrumentType) {
                        case FOREX_INSTRUMENT:
                            if (!com.iqoption.settings.b.aDQ().Fq()) {
                                b.this.f(b.this.dKf);
                                break;
                            } else {
                                d.a((int) R.id.fragment, b.this.getSupportFragmentManager(), b.this.aKa().ajW(), b.this.dKf);
                                break;
                            }
                        case CRYPTO_INSTRUMENT:
                        case CFD_INSTRUMENT:
                            d.a((int) R.id.fragment, b.this.getSupportFragmentManager(), b.this.aKa().ajW(), b.this.dKf);
                            break;
                    }
                }
            }
        });
        aJX();
        a(this.dKf, null);
        return this.dKb.getRoot();
    }

    private void aJX() {
        int i = 8;
        if (this.dKf != null && InstrumentType.CRYPTO_INSTRUMENT == this.dKf.instrumentType && this.dKf.avh().size() == 1 && (this.dKf.avh().get(0) instanceof Position)) {
            final Position position = (Position) this.dKf.avh().get(0);
            FrameLayout frameLayout = this.dKb.bne;
            if (position != null && position.isWithdrawalable()) {
                i = 0;
            }
            frameLayout.setVisibility(i);
            this.dKb.bne.setOnClickListener(new com.iqoption.view.d.b() {
                public void q(View view) {
                    b.this.dKb.bnf.performClick();
                }
            });
            this.dKb.bnf.setOnClickListener(new com.iqoption.view.d.b() {
                public void q(View view) {
                    b.this.eg(true);
                    double doubleValue = ((Double) e.h(position.getInvestSum(), Double.valueOf(0.0d))).doubleValue();
                    double doubleValue2 = ((Double) e.h(position.getAbsCount(), Double.valueOf(0.0d))).doubleValue();
                    a a = com.iqoption.app.helpers.a.FI().a(Integer.valueOf(position.getActiveId()), position.getInstrumentType());
                    String E = a != null ? com.iqoption.util.e.a.E(a) : "";
                    ag.b(com.iqoption.withdrawal.crypto.a.d(doubleValue, doubleValue2, E), new a(b.this, doubleValue, doubleValue2, E, position));
                }
            });
            return;
        }
        this.dKb.bne.setVisibility(8);
    }

    public void eg(boolean z) {
        if (z) {
            this.dKb.bnf.setVisibility(4);
            this.dKb.bng.setVisibility(0);
            return;
        }
        this.dKb.bng.setVisibility(8);
        this.dKb.bnf.setVisibility(0);
    }

    public void a(com.iqoption.mobbtech.connect.response.options.b bVar, Position position) {
        super.a(bVar, position);
        aJY();
        fr(false);
        aJW();
        cx(af.Hu().Hw());
        aJX();
    }

    private void aJY() {
        if (this.dKf != null) {
            a a = com.iqoption.app.helpers.a.FI().a(this.dKf.activeId, this.dKf.instrumentType);
            Object obj = (a == null || !a.isExpired()) ? null : 1;
            if (obj != null) {
                this.dKb.bny.setText(k.aw(this.dKf.expTime.longValue() * 1000));
                this.dKb.bnz.setVisibility(0);
                return;
            }
            this.dKb.bnz.setVisibility(8);
        }
    }

    public void destroy() {
        aJU();
    }

    public void fr(boolean z) {
        if (z && this.dKb.bnn.getVisibility() == 8) {
            this.dKb.bnt.animate().alpha(0.0f).setListener(com.iqoption.view.a.a.a.a.ch(this.dKb.bnt)).start();
            this.dKb.bnn.animate().alpha(1.0f).setListener(com.iqoption.view.a.a.a.a.ci(this.dKb.bnn)).start();
        } else if (!z && this.dKb.bnn.getVisibility() == 0) {
            this.dKb.bnt.animate().alpha(1.0f).setListener(com.iqoption.view.a.a.a.a.ci(this.dKb.bnt)).start();
            this.dKb.bnn.animate().alpha(0.0f).setListener(com.iqoption.view.a.a.a.a.ch(this.dKb.bnn)).start();
        }
    }

    public void cw(long j) {
        aJW();
        cx(j);
    }

    private void aJU() {
        this.dKb.bnt.setSelected(true);
        this.dKb.bnt.setEnabled(false);
        this.dKb.bnt.animate().alpha(0.2f).setListener(com.iqoption.view.a.a.a.a.ci(this.dKb.bnt)).start();
        this.dKb.bnn.animate().alpha(0.0f).setListener(com.iqoption.view.a.a.a.a.ch(this.dKb.bnn)).start();
    }

    private void fs(boolean z) {
        if (z) {
            this.dKb.bnt.setEnabled(true);
            this.dKb.bnt.setAlpha(1.0f);
            return;
        }
        this.dKb.bnt.animate().cancel();
        this.dKb.bnt.setEnabled(false);
        this.dKb.bnt.setAlpha(0.2f);
    }

    private void ft(boolean z) {
        fs(z);
        if (z) {
            this.dKb.bnu.setAlpha(1.0f);
            this.dKb.bnw.setAlpha(1.0f);
            return;
        }
        this.dKb.bnu.setText(this.dKh);
        this.dKb.bnu.setTextColor(this.dKg);
        this.dKb.bnu.setAlpha(0.2f);
        this.dKb.bnw.setAlpha(0.2f);
    }

    private void aJW() {
        if (this.dKf != null) {
            CharSequence charSequence = this.dKh;
            if (this.dKf.getInvestSum() != null) {
                charSequence = l.e(this.mask, this.dKf.getInvestSum());
            }
            this.dKb.bnA.setText(charSequence);
            this.dKb.bnx.setText(String.valueOf(this.dKf.avh().size()));
        }
    }

    private boolean cx(long j) {
        if (cy(j)) {
            aJZ();
            return true;
        }
        ft(false);
        return false;
    }

    private void aJZ() {
        if (this.dKf != null) {
            double sellPnl = this.dKf.getSellPnl();
            Double valueOf = Double.valueOf((100.0d * sellPnl) / this.dKf.getInvestSum().doubleValue());
            h.a(sellPnl, this.dJZ);
            h.a(valueOf.doubleValue(), this.agh);
            ft(true);
        }
    }

    public boolean cy(long j) {
        if (this.dKf == null) {
            return false;
        }
        a a = com.iqoption.app.helpers.a.FI().a(this.dKf.activeId, this.dKf.instrumentType);
        if (a == null || !a.ba(j)) {
            return false;
        }
        return true;
    }

    public void f(com.iqoption.mobbtech.connect.response.options.b bVar) {
        if (this.dKf != null && c.r(this.dKf.avh())) {
            fr(true);
            EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "traderoom_sell").setParameters(i.ZZ().l("instrument_type", this.dKf.instrumentType).aab()).build());
        }
    }
}
