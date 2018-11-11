package com.iqoption.portfolio.component;

import android.content.Context;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.v4.content.ContextCompat;
import android.support.v7.content.res.AppCompatResources;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.widget.TextView;
import com.iqoption.app.IQApp;
import com.iqoption.app.a;
import com.iqoption.app.managers.af;
import com.iqoption.core.util.p;
import com.iqoption.dto.Currencies;
import com.iqoption.dto.entity.position.Order;
import com.iqoption.util.bc;
import com.iqoption.util.bf;
import com.iqoption.util.l;
import com.iqoption.util.m;
import com.iqoption.util.q;
import com.iqoption.x.R;
import java.text.DateFormat;
import java.text.DecimalFormat;

/* compiled from: UIConfig */
public final class o {
    @ColorInt
    public final int ahg;
    @ColorInt
    public final int ahh;
    @ColorInt
    public final int ahi;
    private String cAK;
    public final String cZA;
    public final String cZB;
    public final String cZC;
    public final String cZD;
    public final String cZE;
    public final String cZF;
    public final String cZG;
    public final String cZH;
    public final String cZI;
    public final String cZJ;
    public final String cZK;
    public final String cZL;
    public final String cZM;
    public final String cZN;
    public final String cZO;
    public final String cZP;
    public final String cZQ;
    public final String cZR;
    public final DecimalFormat cZS;
    public final float cZT;
    private final DateFormat cZU;
    private final DateFormat cZV;
    private final DateFormat cZW;
    private final DateFormat cZX;
    private final String cZY;
    private final String cZZ;
    @ColorInt
    public final int cZr;
    public final Drawable cZs;
    public final Drawable cZt;
    public final Drawable cZu;
    public final Drawable cZv;
    private final Paint cZw;
    public final String cZx = Currencies.REPLACE_CURRENCY_MASK;
    public final String cZy;
    public final String cZz;
    private final DateFormat cgr;
    private String cgs;
    @ColorInt
    public final int cix;
    private final DecimalFormat crm;
    public ForegroundColorSpan daa;
    public ForegroundColorSpan dab;
    public ForegroundColorSpan dac;
    private DecimalFormat dad;
    public final LayoutInflater layoutInflater;
    private int precision;

    public o(Context context) {
        awJ();
        this.layoutInflater = LayoutInflater.from(context);
        this.ahg = ContextCompat.getColor(context, R.color.green);
        this.ahh = ContextCompat.getColor(context, R.color.red);
        this.cix = ContextCompat.getColor(context, R.color.grey_blur);
        this.cZr = ContextCompat.getColor(context, R.color.grey_blur_50);
        this.ahi = ContextCompat.getColor(context, R.color.white);
        this.cZs = AppCompatResources.getDrawable(context, R.drawable.ic_indicator_call_10dp);
        this.cZt = AppCompatResources.getDrawable(context, R.drawable.ic_indicator_put_10dp);
        this.cZu = AppCompatResources.getDrawable(context, R.drawable.ic_indicator_call_10dp);
        this.cZv = AppCompatResources.getDrawable(context, R.drawable.ic_indicator_put_10dp);
        this.cZy = String.format("%s %%s", new Object[]{context.getString(R.string.value1)});
        this.cZz = String.format("%s: %%s", new Object[]{context.getString(R.string.total_value)});
        this.cZA = String.format("%s: %%s", new Object[]{context.getString(R.string.total_investment)});
        this.cZB = String.format("%s: %%s", new Object[]{context.getString(R.string.amount_to_be_invested)});
        this.cZG = String.format("%s: %%s", new Object[]{context.getString(R.string.expiration_time)});
        this.cZE = String.format("%s %%s", new Object[]{context.getString(R.string.invested)});
        this.cZC = "%s, ";
        this.cZD = "%s ";
        this.cZF = "(%s)";
        this.cZH = String.format("%s %%s", new Object[]{context.getString(R.string.sell)});
        this.cZI = String.format("%s %%d", new Object[]{context.getString(R.string.cancel)});
        this.cZJ = String.format("%s (%%s)", new Object[]{context.getString(R.string.opened)});
        this.cZK = String.format("%s (%%s)", new Object[]{context.getString(R.string.pending)});
        this.cZL = "%s (%d)";
        this.cZM = String.format("%s %%s", new Object[]{context.getString(R.string.quantity_acronym)});
        this.cZN = context.getString(R.string.n_a);
        this.cZO = "%s %s";
        this.cZP = "~ %s";
        this.cZQ = "%s: ";
        this.cZR = "%s (%s)";
        this.cZU = bf.cZU;
        this.cZV = bf.dwH;
        this.cZW = bf.cZW;
        this.cgr = bf.cgr;
        this.cZX = bf.cZX;
        this.cZY = context.getString(R.string.today);
        this.cZZ = context.getString(R.string.yesterday);
        this.cZS = q.I("#", 6);
        this.crm = l.aGc();
        this.daa = new ForegroundColorSpan(this.ahg);
        this.dab = new ForegroundColorSpan(this.ahh);
        this.dac = new ForegroundColorSpan(this.cix);
        this.cZT = (float) context.getResources().getDimensionPixelSize(R.dimen.sp14);
        float dimension = context.getResources().getDimension(R.dimen.dp1);
        this.cZw = new Paint(1);
        this.cZw.setStyle(Style.STROKE);
        this.cZw.setStrokeCap(Cap.ROUND);
        this.cZw.setStrokeJoin(Join.ROUND);
        this.cZw.setStrokeWidth(dimension);
        this.cZw.setPathEffect(new DashPathEffect(new float[]{2.0f * dimension, dimension * 3.0f}, 0.0f));
        this.cZw.setColor(this.ahi);
    }

    public DecimalFormat ga(int i) {
        gb(i);
        return this.dad;
    }

    private void gb(int i) {
        if (this.dad == null || this.precision != i) {
            this.precision = i;
            StringBuilder stringBuilder = new StringBuilder("0.");
            for (int i2 = 0; i2 < i; i2++) {
                stringBuilder.append("0");
            }
            if (this.dad == null) {
                this.dad = new DecimalFormat(stringBuilder.toString());
            } else {
                this.dad.applyPattern(stringBuilder.toString());
            }
        }
    }

    public String B(double d) {
        return l.e(this.cgs, Double.valueOf(d));
    }

    public String e(int i, double d) {
        return ga(i).format(d);
    }

    public String aM(long j) {
        if (m.aQ(j)) {
            return this.cgr.format(Long.valueOf(j));
        }
        if (m.cf(j)) {
            return this.cZW.format(Long.valueOf(j));
        }
        if (m.aL(j)) {
            return this.cZV.format(Long.valueOf(j));
        }
        return this.cZU.format(Long.valueOf(j));
    }

    public String bM(long j) {
        if (m.aQ(j)) {
            return this.cZY;
        }
        if (m.aK(j)) {
            return this.cZZ;
        }
        return this.cZX.format(Long.valueOf(j));
    }

    public CharSequence d(double d, String str) {
        if (str != null) {
            return new bc().jO(this.cZS.format(d)).jO(" ").bM(this.dac).jO(str).aCT();
        }
        return this.cZS.format(d);
    }

    public void awJ() {
        a Cw = a.Cw();
        this.cgs = Cw.CD();
        this.cAK = l.d(Cw.eh(Currencies.OTN_CURRENCY));
    }

    public String c(com.iqoption.portfolio.component.b.m mVar) {
        String O = com.iqoption.util.e.a.O(mVar.Jg().getInstrumentType());
        if (!Order.ON_MKT_OPEN.equals(mVar.axr().getType())) {
            return O;
        }
        return IQApp.Dk().getString(R.string.portfolio_mkt_on_open_n1, new Object[]{O});
    }

    public void a(com.iqoption.core.microservices.tradingengine.response.active.a aVar, TextView textView) {
        long Hw = af.Hu().Hw();
        long bb = aVar.bb(Hw);
        if (bb == Long.MAX_VALUE) {
            textView.setText(R.string.not_available);
        } else if (aVar.ba(Hw)) {
            textView.setText("");
        } else {
            textView.setText(bf.u(Hw, bb));
        }
    }

    public String i(double d, int i) {
        if (i == 1) {
            return B(d);
        }
        return String.format(this.cZO, new Object[]{B(d), p.ea(i)});
    }

    public Drawable awK() {
        return new com.iqoption.view.drawable.a(this.cZw);
    }

    public String a(double d, boolean z, int i) {
        if (z) {
            return e(i, d);
        }
        return B(d);
    }
}
