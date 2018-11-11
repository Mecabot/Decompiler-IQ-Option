package jumio.bam;

import com.jumio.bam.enums.CreditCardType;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: CreditCardUtil */
public class ab {
    public static void a(StringBuilder stringBuilder, CreditCardType creditCardType) {
        if (stringBuilder != null && stringBuilder.length() >= 4) {
            d(stringBuilder);
            switch (creditCardType) {
                case UNKNOWN:
                case VISA:
                case MASTER_CARD:
                case DISCOVER:
                case CHINA_UNIONPAY:
                case JCB:
                    b(stringBuilder);
                    break;
                case AMERICAN_EXPRESS:
                    c(stringBuilder);
                    break;
                case DINERS_CLUB:
                    if (!stringBuilder.subSequence(0, 2).equals("36")) {
                        b(stringBuilder);
                        break;
                    } else {
                        c(stringBuilder);
                        break;
                    }
            }
            if (stringBuilder.charAt(stringBuilder.length() - 1) == ' ') {
                stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
            }
        }
    }

    private static void b(StringBuilder stringBuilder) {
        int length = stringBuilder.length() / 4;
        for (int i = 1; i <= length; i++) {
            stringBuilder.insert(((i * 4) + i) - 1, " ");
        }
    }

    private static void c(StringBuilder stringBuilder) {
        if (stringBuilder.length() > 10) {
            stringBuilder.insert(10, " ");
        }
        if (stringBuilder.length() > 4) {
            stringBuilder.insert(4, " ");
        }
    }

    private static void d(StringBuilder stringBuilder) {
        while (true) {
            int indexOf = stringBuilder.indexOf(" ");
            if (indexOf > -1) {
                stringBuilder.delete(indexOf, indexOf + 1);
            } else {
                return;
            }
        }
    }

    public static String a() {
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2;
        String format = new SimpleDateFormat("MM", Locale.getDefault()).format(new Date());
        if (format.length() == 1) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("0");
            stringBuilder.append(format);
            format = stringBuilder.toString();
        }
        String format2 = new SimpleDateFormat("yy", Locale.getDefault()).format(new Date());
        String str = "((";
        if (Integer.valueOf(format).intValue() > 9) {
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str);
            stringBuilder2.append("(1[");
            stringBuilder2.append(format.charAt(1));
            stringBuilder2.append("-2])");
            format = stringBuilder2.toString();
        } else {
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str);
            stringBuilder2.append("(0[");
            stringBuilder2.append(format.charAt(1));
            stringBuilder2.append("-9]|1[0-2])");
            format = stringBuilder2.toString();
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(format);
        stringBuilder3.append("/");
        format = stringBuilder3.toString();
        str = String.valueOf(Integer.valueOf(format2).intValue() + 1);
        if (str.length() == 1) {
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("0");
            stringBuilder2.append(str);
            str = stringBuilder2.toString();
        }
        String valueOf = String.valueOf(Integer.valueOf(format2).intValue() + 10);
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append(format);
        stringBuilder4.append("(");
        stringBuilder4.append(format2);
        stringBuilder4.append(")");
        format = stringBuilder4.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(format);
        stringBuilder.append(")|(");
        format = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(format);
        stringBuilder.append("(0[1-9]|1[0-2])");
        format = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(format);
        stringBuilder.append("/");
        format = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(format);
        stringBuilder.append("(");
        stringBuilder.append(str.charAt(0));
        stringBuilder.append("[");
        stringBuilder.append(str.charAt(1));
        stringBuilder.append("-9]|[");
        stringBuilder.append(valueOf.charAt(0));
        stringBuilder.append("-9][0-9])");
        format = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(format);
        stringBuilder.append("))");
        return stringBuilder.toString();
    }

    public static void a(StringBuilder stringBuilder) {
        d(stringBuilder);
        for (int i = 6; i < stringBuilder.length() - 4; i++) {
            if (stringBuilder.charAt(i) != ' ') {
                stringBuilder.setCharAt(i, 'X');
            }
        }
    }
}
