package com.iqoption.util;

import android.support.annotation.Nullable;
import com.iqoption.app.IQApp;
import com.iqoption.app.a;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.dto.Balance;
import com.iqoption.dto.Currencies;
import com.iqoption.dto.Currencies.ConversionCurrency;
import com.iqoption.fragment.rightpanel.as;
import com.iqoption.gl.b;
import java.text.DecimalFormat;
import java.util.Locale;

/* compiled from: CurrencyUtils */
public class l {
    public static String b(Number number) {
        if (number.doubleValue() > 0.01d) {
            return "+";
        }
        return number.doubleValue() < -0.01d ? "-" : "";
    }

    public static String CD() {
        return a.Cw().CD();
    }

    public static String p(Double d) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(b(d));
        stringBuilder.append(CD());
        return e(stringBuilder.toString(), Double.valueOf(Math.abs(d.doubleValue())));
    }

    public static String q(Double d) {
        return d(CD(), d);
    }

    public static String r(Double d) {
        return e(CD(), d);
    }

    public static String s(Double d) {
        String f;
        Balance cG = a.Cw().cG(1);
        if (cG != null) {
            f = a.Cw().f(cG.id);
        } else {
            f = CD();
        }
        return e(f, d);
    }

    public static String a(double d, DecimalFormat decimalFormat) {
        return String.format(Locale.US, CD(), new Object[]{decimalFormat.format(d)});
    }

    public static String c(String str, Double d) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(b(d));
        stringBuilder.append(str);
        return e(stringBuilder.toString(), Double.valueOf(Math.abs(d.doubleValue())));
    }

    public static String d(String str, Double d) {
        return String.format(Locale.US, str, new Object[]{t(d)});
    }

    public static String t(Double d) {
        if (Math.abs(d.doubleValue() - ((double) d.intValue())) > 0.001d) {
            return v(d);
        }
        return u(d);
    }

    public static String e(String str, Double d) {
        return String.format(Locale.US, str, new Object[]{v(d)});
    }

    public static String a(String str, Double d, DecimalFormat decimalFormat) {
        return String.format(Locale.US, str, new Object[]{decimalFormat.format(d)});
    }

    public static String u(Double d) {
        return q.dY(0).format(d);
    }

    public static String v(Double d) {
        return q.dY(2).format(d);
    }

    public static String a(Double d, String str, Double d2) {
        return e(str, d(d2, d));
    }

    public static Double aGa() {
        return c(a.Cw().CF());
    }

    public static Double w(Double d) {
        return d(d, c(a.Cw().CF()));
    }

    public static Double d(Double d, Double d2) {
        return Double.valueOf(d.doubleValue() / d2.doubleValue());
    }

    public static Double e(Double d, Double d2) {
        return Double.valueOf(d.doubleValue() * d2.doubleValue());
    }

    public static void aGb() {
        String mask;
        a Cw = a.Cw();
        ConversionCurrency CF = Cw.CF();
        Double c = c(CF);
        if (CF != null) {
            mask = CF.getMask();
        } else {
            mask = Cw.CD();
        }
        b.aow().glchSetProfitMaskText(mask);
        b.aow().glchTabSetDollarRate(c.doubleValue());
    }

    public static double[] N(@Nullable InstrumentType instrumentType) {
        Double valueOf = Double.valueOf(instrumentType != null ? as.H(instrumentType) : -1.0d);
        double[] dArr = new double[2];
        ConversionCurrency CF = a.aL(IQApp.Dk()).CF();
        if (CF != null) {
            dArr[0] = CF.getMinDealAmount().doubleValue();
            dArr[1] = CF.getMaxDealAmount().doubleValue();
        } else {
            dArr[0] = 1.0d;
            dArr[1] = Double.MAX_VALUE;
        }
        dArr[0] = Math.max(dArr[0], valueOf.doubleValue());
        return dArr;
    }

    public static Double c(ConversionCurrency conversionCurrency) {
        if (conversionCurrency == null || conversionCurrency.rateUsd == null || conversionCurrency.unit == null) {
            return Double.valueOf(1.0d);
        }
        return Double.valueOf(conversionCurrency.rateUsd.doubleValue() / conversionCurrency.unit.doubleValue());
    }

    public static String d(ConversionCurrency conversionCurrency) {
        return conversionCurrency == null ? Currencies.REPLACE_CURRENCY_MASK : conversionCurrency.getMask();
    }

    public static String e(ConversionCurrency conversionCurrency) {
        return conversionCurrency == null ? "" : conversionCurrency.getName();
    }

    public static int f(ConversionCurrency conversionCurrency) {
        return conversionCurrency == null ? 2 : conversionCurrency.getMinorUnits();
    }

    public static int g(ConversionCurrency conversionCurrency) {
        return conversionCurrency == null ? 6 : conversionCurrency.getMinorUnits();
    }

    public static DecimalFormat aGc() {
        return q.dX(g(a.Cw().eh(Currencies.OTN_CURRENCY)));
    }

    public static String G(double d) {
        return String.format(Locale.US, "$%.2f", new Object[]{Double.valueOf(d)});
    }

    public static double H(double d) {
        ConversionCurrency CF = a.Cw().CF();
        if (Currencies.EUR_CURRENCY.equalsIgnoreCase(e(CF))) {
            return d;
        }
        return au.a(d(e(Double.valueOf(d), c(a.Cw().eh(Currencies.EUR_CURRENCY))), c(CF)).doubleValue(), -1, 0);
    }
}
