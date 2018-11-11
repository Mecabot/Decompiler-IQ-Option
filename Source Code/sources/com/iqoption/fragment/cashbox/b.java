package com.iqoption.fragment.cashbox;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.regex.Pattern;

/* compiled from: CashboxUtils */
public final class b {
    public static final Pattern bVU = Pattern.compile("^[a-zA-Z0-9\\s\\.\\-]{2,}$");
    public static final Pattern bVV = Pattern.compile("^[0-9]{3,4}$");

    public static String h(Double d) {
        DecimalFormat decimalFormat = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
        decimalFormat.setMaximumFractionDigits(340);
        return decimalFormat.format(d);
    }

    public static boolean hJ(String str) {
        int i = 0;
        int i2 = 0;
        for (int length = str.length() - 1; length >= 0; length--) {
            int parseInt = Integer.parseInt(str.substring(length, length + 1));
            if (i != 0) {
                parseInt *= 2;
                if (parseInt > 9) {
                    parseInt = (parseInt % 10) + 1;
                }
            }
            i2 += parseInt;
            i ^= 1;
        }
        if (i2 % 10 == 0) {
            return true;
        }
        return false;
    }
}
