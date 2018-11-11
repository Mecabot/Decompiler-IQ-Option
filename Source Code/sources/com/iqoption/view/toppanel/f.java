package com.iqoption.view.toppanel;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.drawable.GradientDrawable;
import android.os.CountDownTimer;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.i;
import com.iqoption.analytics.EventManager;
import com.iqoption.app.managers.af;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.microservices.tradingengine.response.active.a;
import com.iqoption.core.util.d;
import com.iqoption.d.aiu;
import com.iqoption.dto.Event;
import com.iqoption.dto.entity.position.Position;
import com.iqoption.mobbtech.connect.request.api.a.c;
import com.iqoption.mobbtech.connect.response.options.b;
import com.iqoption.mobbtech.connect.response.options.e;
import com.iqoption.util.bg;
import com.iqoption.util.k;
import com.iqoption.util.l;
import com.iqoption.x.R;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/* compiled from: SellDelegate */
public class f extends e implements c, d {
    private aiu dKi;
    private ValueAnimator dKj;
    CountDownTimer dKk = null;
    private String dKl = getContext().getResources().getString(R.string.cancel);
    private String dKm = getContext().getResources().getString(R.string.sell);
    private String dKn = getContext().getResources().getString(R.string.sell_all);
    private final DecimalFormat dKo;
    private Double dKp;

    public f(com.iqoption.fragment.base.f fVar, b bVar) {
        super(fVar, bVar);
        a a = com.iqoption.app.helpers.a.FI().a(bVar.activeId, bVar.instrumentType);
        this.dKo = d.dY(a != null ? a.getPrecision() : 6);
    }

    private String g(b bVar) {
        return bVar.size() > 1 ? this.dKn : this.dKm;
    }

    @NonNull
    public View f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        this.dKi = aiu.aA(layoutInflater, viewGroup, false);
        final GradientDrawable gradientDrawable = (GradientDrawable) this.dKi.bTi.getBackground();
        AnimatorUpdateListener gVar = new g(gradientDrawable);
        this.dKj = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(9676994), Integer.valueOf(865315010)});
        this.dKj.addUpdateListener(gVar);
        this.dKj.addListener(new AnimatorListener() {
            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                gradientDrawable.setColor(9676994);
            }

            public void onAnimationCancel(Animator animator) {
                gradientDrawable.setColor(9676994);
            }
        });
        this.dKj.setInterpolator(com.iqoption.view.a.a.d.dEM);
        this.dKj.setRepeatMode(2);
        this.dKi.bTh.setOnClickListener(new com.iqoption.view.d.b(500) {
            public void q(View view) {
                if (f.this.dKf != null) {
                    switch (f.this.dKf.instrumentType) {
                        case TURBO_INSTRUMENT:
                        case BINARY_INSTRUMENT:
                            ImmutableList sA = i.c(f.this.dKf.avh()).b(e.getId).c(Predicates.b(com.iqoption.mobbtech.connect.request.api.a.a.cUT)).sA();
                            if (!sA.isEmpty()) {
                                f.this.fr(true);
                                com.iqoption.mobbtech.connect.request.api.a.a.a(f.this.getContext(), sA);
                                EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "traderoom_buyback").setParameters(com.iqoption.core.util.i.ZZ().l("instrument_type", f.this.dKf.instrumentType).aab()).build());
                                break;
                            }
                            break;
                        case FX_INSTRUMENT:
                        case DIGITAL_INSTRUMENT:
                            if (com.google.common.c.a.c(f.this.dKf.getInvestSum().doubleValue() + f.this.dKf.getSellPnl(), 0.0d, 0.001d) > 0) {
                                f.this.f(f.this.dKf);
                                break;
                            } else {
                                com.iqoption.fragment.dialog.a.a((int) R.id.fragment, f.this.getSupportFragmentManager(), f.this.aKa().ajW(), f.this.dKf);
                                break;
                            }
                    }
                }
            }
        });
        a(this.dKf, null);
        return this.dKi.getRoot();
    }

    public boolean Xh() {
        boolean z = false;
        if (this.dKf == null) {
            return false;
        }
        a a = com.iqoption.app.helpers.a.FI().a(this.dKf.activeId, this.dKf.instrumentType);
        if (a == null) {
            return false;
        }
        switch (a.getInstrumentType()) {
            case TURBO_INSTRUMENT:
            case BINARY_INSTRUMENT:
                return a.Xh();
            case FX_INSTRUMENT:
            case DIGITAL_INSTRUMENT:
                if (a.Xh() && this.dKp != null) {
                    z = true;
                }
                return z;
            default:
                return false;
        }
    }

    public void a(b bVar, Position position) {
        super.a(bVar, position);
        if (this.dKi == null) {
            k.c(new RuntimeException("attempt to update delegate before then view has been created"));
            return;
        }
        fr(false);
        this.dKp = this.dKf.calculateBuybackAmountWithCancelable(af.Hu().Hw());
        this.dKi.bTh.setSelected(false);
        aKb();
        aKe();
        aKf();
    }

    private void aKb() {
        switch (this.dKf.instrumentType) {
            case TURBO_INSTRUMENT:
            case BINARY_INSTRUMENT:
                aKd();
                return;
            case FX_INSTRUMENT:
            case DIGITAL_INSTRUMENT:
                aKc();
                return;
            default:
                return;
        }
    }

    private void aKc() {
        if (this.dKf.instrumentType == InstrumentType.DIGITAL_INSTRUMENT || this.dKf.instrumentType == InstrumentType.FX_INSTRUMENT || this.dKf.isEmpty()) {
            if (this.dKf.size() > 1) {
                aKd();
                return;
            }
            e eVar = (e) this.dKf.avh().iterator().next();
            if (eVar instanceof Position) {
                Long instrumentStrikeValue = ((Position) eVar).getInstrumentStrikeValue();
                if (instrumentStrikeValue != null) {
                    this.dKi.bny.setText(this.dKo.format(((double) instrumentStrikeValue.longValue()) / 1000000.0d));
                } else {
                    this.dKi.bny.setText("");
                }
                if (eVar.isCall()) {
                    bg.f(this.dKi.bny, R.drawable.deal_green);
                } else {
                    bg.f(this.dKi.bny, R.drawable.deal_red);
                }
            }
        }
    }

    private void aKd() {
        this.dKi.bny.setText(com.iqoption.app.managers.a.k.aw(this.dKf.expTime.longValue() * 1000));
        bg.f(this.dKi.bny, R.drawable.ic_flag_8_8);
    }

    public void destroy() {
        aJU();
        aCX();
    }

    public void fr(boolean z) {
        if (z && this.dKi.bnn.getVisibility() == 8) {
            this.dKi.bTh.animate().alpha(0.0f).setListener(com.iqoption.view.a.a.a.a.ch(this.dKi.bTh)).start();
            this.dKi.bnn.animate().alpha(1.0f).setListener(com.iqoption.view.a.a.a.a.ci(this.dKi.bnn)).start();
        } else if (!z && this.dKi.bnn.getVisibility() == 0) {
            this.dKi.bTh.animate().alpha(1.0f).setListener(com.iqoption.view.a.a.a.a.ci(this.dKi.bTh)).start();
            this.dKi.bnn.animate().alpha(0.0f).setListener(com.iqoption.view.a.a.a.a.ch(this.dKi.bnn)).start();
        }
    }

    public void cw(long j) {
        aKe();
        if (aKf() && !this.dKj.isRunning() && this.dKi.bTh.isEnabled() && !this.dKi.bTh.isSelected()) {
            a a = com.iqoption.app.helpers.a.FI().a(this.dKf.activeId, this.dKf.instrumentType);
            if (a != null) {
                long longValue = (this.dKf.expTime.longValue() * 1000) - j;
                if (longValue < com.iqoption.app.managers.a.k.HB().i(a) && longValue > 0) {
                    this.dKj.setDuration(400);
                    this.dKj.setRepeatCount(((int) (longValue / 400)) + 1);
                    this.dKj.start();
                }
            }
        }
    }

    private void aJU() {
        this.dKj.cancel();
        this.dKi.bTh.setSelected(true);
        this.dKi.bTh.setEnabled(false);
        this.dKi.bTh.animate().alpha(0.2f).setListener(com.iqoption.view.a.a.a.a.ci(this.dKi.bTh)).start();
        this.dKi.bnn.animate().alpha(0.0f).setListener(com.iqoption.view.a.a.a.a.ch(this.dKi.bnn)).start();
    }

    private void fs(boolean z) {
        if (z) {
            this.dKi.bTh.setEnabled(true);
            this.dKi.bTh.setAlpha(1.0f);
            return;
        }
        this.dKj.cancel();
        this.dKi.bTh.animate().cancel();
        this.dKi.bTh.setEnabled(false);
        this.dKi.bTh.setAlpha(0.2f);
    }

    private void ft(boolean z) {
        fs(z);
        if (z) {
            this.dKi.bTj.setAlpha(1.0f);
            this.dKi.bTk.setAlpha(1.0f);
            return;
        }
        this.dKi.bTj.setText(this.dKh);
        this.dKi.bTj.setTextColor(this.dKg);
        this.dKi.bTh.setText(g(this.dKf));
        this.dKi.bTj.setAlpha(0.2f);
        this.dKi.bTk.setAlpha(0.2f);
    }

    private void aKe() {
        if (this.dKf != null) {
            CharSequence charSequence = this.dKh;
            CharSequence charSequence2 = this.dKh;
            int i = this.dKg;
            if (this.dKf.getInvestSum() != null) {
                charSequence = l.e(this.mask, this.dKf.getInvestSum());
                if (this.dKf.avk() != null) {
                    Number valueOf = Double.valueOf(this.dKf.avk().doubleValue() - this.dKf.getInvestSum().doubleValue());
                    String c = l.c(this.mask, valueOf);
                    i = c(valueOf);
                    charSequence2 = c;
                }
            }
            this.dKi.bnA.setText(charSequence);
            this.dKi.agS.setText(charSequence2);
            this.dKi.agS.setTextColor(i);
        }
    }

    private boolean aKf() {
        if (this.dKf == null) {
            ft(false);
            return false;
        }
        if (!aKh()) {
            this.dKp = this.dKf.calculateBuybackAmountWithCancelable(af.Hu().Hw());
            if (this.dKp != null) {
                x(this.dKp);
            } else {
                ft(false);
            }
        }
        return true;
    }

    private void x(Double d) {
        if (this.dKf != null && d != null) {
            CharSequence charSequence;
            String str = this.dKh;
            String str2 = this.dKh;
            int i = this.dKg;
            if (this.dKf.getInvestSum() == null || d == null) {
                charSequence = str;
            } else {
                Number valueOf = Double.valueOf(d.doubleValue() - this.dKf.getInvestSum().doubleValue());
                str2 = l.e(this.mask, d);
                charSequence = l.c(this.mask, valueOf);
                i = c(valueOf);
            }
            this.dKi.bTj.setText(charSequence);
            this.dKi.bTj.setTextColor(i);
            TextView textView = this.dKi.bTh;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(g(this.dKf));
            stringBuilder.append(" ");
            stringBuilder.append(str2);
            textView.setText(stringBuilder.toString());
            ft(true);
        }
    }

    @ColorInt
    private int c(Number number) {
        if (number.doubleValue() > 0.01d) {
            return this.ahg;
        }
        if (number.doubleValue() < 0.01d) {
            return this.ahh;
        }
        return this.dKg;
    }

    private void cz(long j) {
        long toSeconds = (TimeUnit.MILLISECONDS.toSeconds(j) + 1) * 2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("caNCELED inter SEC = ");
        long j2 = j / toSeconds;
        stringBuilder.append(j2);
        com.iqoption.core.i.d(stringBuilder.toString());
        this.dKk = new CountDownTimer(j, j2) {
            public void onTick(long j) {
                f.this.cA(j);
            }

            public void onFinish() {
                f.this.dKi.bTh.setText(f.this.g(f.this.dKf));
                f.this.aKf();
            }
        };
        this.dKk.start();
    }

    private boolean aKg() {
        return this.dKk != null;
    }

    private void aCX() {
        if (this.dKk != null) {
            this.dKk.cancel();
            this.dKk = null;
        }
    }

    private boolean aKh() {
        if (!Xh() || com.iqoption.app.helpers.a.FI().a(this.dKf.activeId, this.dKf.instrumentType) == null) {
            return false;
        }
        long Hw = af.Hu().Hw();
        if (this.dKf.isCancelable(Hw)) {
            if (!aKg()) {
                long cancelTimeLeft = this.dKf.getCancelTimeLeft(Hw);
                cz(cancelTimeLeft);
                cA(cancelTimeLeft);
            }
            return true;
        }
        this.dKi.bTh.setText(g(this.dKf));
        aCX();
        return false;
    }

    private void cA(long j) {
        long toSeconds = TimeUnit.MILLISECONDS.toSeconds(j) + 1;
        TextView textView = this.dKi.bTh;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.dKl);
        stringBuilder.append(" ");
        stringBuilder.append(toSeconds);
        textView.setText(stringBuilder.toString());
        fs(true);
    }

    public void f(b bVar) {
        if (this.dKf != null) {
            Iterator sI = this.dKf.avh().iterator();
            while (sI.hasNext()) {
                e eVar = (e) sI.next();
                if (!com.iqoption.mobbtech.connect.request.api.a.a.x(eVar.getId())) {
                    Position position = (Position) eVar;
                    fr(true);
                    c.k(position);
                }
            }
            EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "traderoom_sell").setParameters(com.iqoption.core.util.i.ZZ().l("instrument_type", this.dKf.instrumentType).aab()).build());
        }
    }

    public void x(e eVar) {
        if ((eVar instanceof Position) && !com.iqoption.mobbtech.connect.request.api.a.a.x(eVar.getId())) {
            Position position = (Position) eVar;
            fr(true);
            c.k(position);
            com.iqoption.gl.b.aow().startSellPosition(position.getPositionSplitId());
        }
    }
}
