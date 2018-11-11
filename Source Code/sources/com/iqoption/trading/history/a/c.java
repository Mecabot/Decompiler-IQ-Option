package com.iqoption.trading.history.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.v4.content.ContextCompat;
import android.support.v7.content.res.AppCompatResources;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.dto.Balance;
import com.iqoption.dto.Currencies;
import com.iqoption.util.bf;
import com.iqoption.util.l;
import com.iqoption.util.m;
import com.iqoption.util.q;
import com.iqoption.x.R;
import java.text.DateFormat;
import java.text.DecimalFormat;

/* compiled from: UIConfig */
public final class c {
    @ColorInt
    public final int ahg;
    @ColorInt
    public final int ahh;
    @ColorInt
    public final int ahi;
    public final String cZE;
    public final String cZN;
    public final DecimalFormat cZS;
    private final DateFormat cZU;
    private final DateFormat cZX;
    private final String cZY;
    private final String cZZ;
    @ColorInt
    public final int cZr;
    public final Drawable cZs;
    public final Drawable cZt;
    private String cgs = Currencies.REPLACE_CURRENCY_MASK;
    @ColorInt
    public final int cix;
    public ForegroundColorSpan daa;
    public ForegroundColorSpan dab;
    private DecimalFormat dad;
    public ForegroundColorSpan dsP;
    public final LayoutInflater layoutInflater;
    private int precision;

    /* compiled from: UIConfig */
    public interface a {
        c cc(long j);
    }

    public String F(double d) {
        return d > 0.0d ? "+" : d < 0.0d ? "-" : "";
    }

    public c(Context context) {
        this.layoutInflater = LayoutInflater.from(context);
        this.ahg = ContextCompat.getColor(context, R.color.green);
        this.ahh = ContextCompat.getColor(context, R.color.red);
        this.cix = ContextCompat.getColor(context, R.color.grey_blur);
        this.cZr = ContextCompat.getColor(context, R.color.grey_blur_50);
        this.ahi = ContextCompat.getColor(context, R.color.white);
        this.cZs = AppCompatResources.getDrawable(context, R.drawable.ic_triangle_top_green_10);
        this.cZt = AppCompatResources.getDrawable(context, R.drawable.ic_triangle_down_red_10);
        this.cZE = String.format("%s %%s", new Object[]{context.getString(R.string.invested)});
        this.cZN = context.getString(R.string.n_a);
        this.cZU = bf.cZU;
        this.cZX = bf.cZX;
        this.cZY = context.getString(R.string.today);
        this.cZZ = context.getString(R.string.yesterday);
        this.cZS = q.I("#", 6);
        this.daa = new ForegroundColorSpan(this.ahg);
        this.dab = new ForegroundColorSpan(this.ahh);
        this.dsP = new ForegroundColorSpan(this.ahi);
    }

    public c cd(long j) {
        com.iqoption.app.a Cw = com.iqoption.app.a.Cw();
        this.cgs = l.d(Cw.eh(Balance.getCurrency(Cw.d(Long.valueOf(j)))));
        return this;
    }

    private DecimalFormat ga(int i) {
        gb(i);
        return this.dad;
    }

    private void gb(int i) {
        if (this.dad == null || this.precision != i) {
            this.precision = i;
            this.dad = q.dY(i);
        }
    }

    public String B(double d) {
        return l.e(this.cgs, Double.valueOf(d));
    }

    public String e(int i, double d) {
        return ga(i).format(d);
    }

    public String ce(long j) {
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

    public String a(double d, InstrumentType instrumentType, int i) {
        if (instrumentType == InstrumentType.FX_INSTRUMENT) {
            return e(i, d);
        }
        return B(d);
    }

    public ForegroundColorSpan E(double d) {
        if (d > 0.0d) {
            return this.daa;
        }
        if (d < 0.0d) {
            return this.dab;
        }
        return this.dsP;
    }
}
