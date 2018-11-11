package io.card.payment;

import java.text.CharacterIterator;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.StringCharacterIterator;
import java.util.Calendar;
import java.util.Date;

/* compiled from: CreditCardNumber */
class c {
    public static boolean hc(String str) {
        r0 = new int[2][];
        boolean z = false;
        r0[0] = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        r0[1] = new int[]{0, 2, 4, 6, 8, 1, 3, 5, 7, 9};
        CharacterIterator stringCharacterIterator = new StringCharacterIterator(str);
        char last = stringCharacterIterator.last();
        int i = 0;
        int i2 = 0;
        while (last != 65535) {
            if (!Character.isDigit(last)) {
                return false;
            }
            int i3 = i2 + 1;
            i += r0[i2 & 1][last - 48];
            last = stringCharacterIterator.previous();
            i2 = i3;
        }
        if (i % 10 == 0) {
            z = true;
        }
        return z;
    }

    public static String ll(String str) {
        return a(str, true, null);
    }

    public static String a(String str, boolean z, CardType cardType) {
        String lq = z ? k.lq(str) : str;
        if (cardType == null) {
            cardType = CardType.fromCardNumber(lq);
        }
        int numberLength = cardType.numberLength();
        if (lq.length() == numberLength) {
            if (numberLength == 16) {
                return ln(lq);
            }
            if (numberLength == 15) {
                return lm(lq);
            }
        }
        return str;
    }

    private static String lm(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (i < 15) {
            if (i == 4 || i == 10) {
                stringBuilder.append(' ');
            }
            stringBuilder.append(str.charAt(i));
            i++;
        }
        return stringBuilder.toString();
    }

    private static String ln(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (i < 16) {
            if (i != 0 && i % 4 == 0) {
                stringBuilder.append(' ');
            }
            stringBuilder.append(str.charAt(i));
            i++;
        }
        return stringBuilder.toString();
    }

    public static boolean aU(int i, int i2) {
        if (i < 1 || 12 < i) {
            return false;
        }
        Calendar instance = Calendar.getInstance();
        int i3 = instance.get(1);
        int i4 = instance.get(2) + 1;
        if (i2 < i3) {
            return false;
        }
        return (i2 != i3 || i >= i4) && i2 <= i3 + 15;
    }

    public static SimpleDateFormat iP(int i) {
        if (i == 4) {
            return new SimpleDateFormat("MMyy");
        }
        return i == 6 ? new SimpleDateFormat("MMyyyy") : null;
    }

    public static Date lo(String str) {
        str = k.lq(str);
        SimpleDateFormat iP = iP(str.length());
        if (iP == null) {
            return null;
        }
        try {
            iP.setLenient(false);
            return iP.parse(str);
        } catch (ParseException unused) {
            return null;
        }
    }
}
