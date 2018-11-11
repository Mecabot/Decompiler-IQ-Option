package com.iqoption.core.util;

import android.util.LruCache;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Arrays;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.m;

@i(aXC = {1, 1, 11}, aXD = {"\u00004\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a&\u0010\u0006\u001a\u00020\u0004*\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f\u001a\u001c\u0010\r\u001a\u00020\u0004*\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\n\u001a>\u0010\r\u001a\u00020\u0004*\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0010\u001a\u00020\n2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f\u001a\n\u0010\u0013\u001a\u00020\u0004*\u00020\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, aXE = {"DEFAULT_PRECISION", "", "formatterCache", "Landroid/util/LruCache;", "", "Ljava/text/DecimalFormat;", "format", "Ljava/math/BigDecimal;", "pattern", "useGrouping", "", "rounding", "Ljava/math/RoundingMode;", "formatAmount", "currency", "Lcom/iqoption/core/microservices/billing/response/deposit/CurrencyBilling;", "softPattern", "minorUnits", "mask", "formatPercent", "core_release"})
/* compiled from: CurrencyFormatting.kt */
public final class c {
    private static final LruCache<String, DecimalFormat> bgD = new LruCache(100);

    public static /* bridge */ /* synthetic */ String a(BigDecimal bigDecimal, com.iqoption.core.microservices.billing.response.deposit.c cVar, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return a(bigDecimal, cVar, z);
    }

    public static final String a(BigDecimal bigDecimal, com.iqoption.core.microservices.billing.response.deposit.c cVar, boolean z) {
        h.e(bigDecimal, "$receiver");
        h.e(cVar, b.CURRENCY);
        return a(bigDecimal, 0, cVar.getMask(), z, false, null, 25, null);
    }

    public static /* bridge */ /* synthetic */ String a(BigDecimal bigDecimal, int i, String str, boolean z, boolean z2, RoundingMode roundingMode, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 2;
        }
        if ((i2 & 2) != 0) {
            str = (String) null;
        }
        String str2 = str;
        boolean z3 = (i2 & 4) != 0 ? false : z;
        boolean z4 = (i2 & 8) != 0 ? true : z2;
        if ((i2 & 16) != 0) {
            roundingMode = RoundingMode.HALF_EVEN;
        }
        return a(bigDecimal, i, str2, z3, z4, roundingMode);
    }

    public static final String a(BigDecimal bigDecimal, int i, String str, boolean z, boolean z2, RoundingMode roundingMode) {
        h.e(bigDecimal, "$receiver");
        h.e(roundingMode, "rounding");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("0.");
        stringBuilder.append(u.l(z ? "#" : "0", i));
        String a = a(bigDecimal, stringBuilder.toString(), z2, roundingMode);
        if (str == null) {
            return a;
        }
        m mVar = m.euz;
        Object[] objArr = new Object[]{a};
        a = String.format(str, Arrays.copyOf(objArr, objArr.length));
        h.d(a, "java.lang.String.format(format, *args)");
        return a;
    }

    public static final String a(BigDecimal bigDecimal, String str, boolean z, RoundingMode roundingMode) {
        h.e(bigDecimal, "$receiver");
        h.e(str, "pattern");
        h.e(roundingMode, "rounding");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("|useGrouping:");
        stringBuilder.append(z);
        stringBuilder.append("|rounding:");
        stringBuilder.append(roundingMode);
        String stringBuilder2 = stringBuilder.toString();
        DecimalFormat decimalFormat = (DecimalFormat) bgD.get(stringBuilder2);
        if (decimalFormat == null) {
            decimalFormat = new DecimalFormat(str);
            if (z) {
                DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
                decimalFormatSymbols.setGroupingSeparator(',');
                decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
                decimalFormat.setGroupingUsed(true);
            }
            decimalFormat.setRoundingMode(roundingMode);
            bgD.put(stringBuilder2, decimalFormat);
        }
        String format = decimalFormat.format(bigDecimal);
        h.d(format, "formatter.format(this)");
        return format;
    }
}
