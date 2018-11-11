package com.iqoption.util;

import android.content.Context;
import com.iqoption.app.IQApp;
import com.iqoption.dto.ChartTimeInterval;
import com.iqoption.x.R;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* compiled from: TimeUtil */
public class bf {
    private static final String TAG = "bf";
    public static DateFormat cZU = new SimpleDateFormat("HH:mm, dd MMM yyyy", Locale.getDefault());
    public static DateFormat cZV = new SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.getDefault());
    public static DateFormat cZW = new SimpleDateFormat("HH:mm, EEE", Locale.getDefault());
    public static DateFormat cZX = new SimpleDateFormat("dd MMM", Locale.getDefault());
    public static DateFormat cgq = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
    public static DateFormat cgr = new SimpleDateFormat("HH:mm", Locale.getDefault());
    public static DateFormat dwC = new SimpleDateFormat("mm:ss", Locale.getDefault());
    public static DateFormat dwD = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
    public static DateFormat dwE = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
    public static DateFormat dwF = new SimpleDateFormat("dd.MM.yyyy\nHH:mm", Locale.getDefault());
    public static DateFormat dwG = new SimpleDateFormat("HH:mm dd.MM.yyyy", Locale.getDefault());
    public static DateFormat dwH = new SimpleDateFormat("HH:mm, dd MMM", Locale.getDefault());
    public static DateFormat dwI = new SimpleDateFormat("d MMM H:mm:ss", Locale.getDefault());
    public static DateFormat dwJ = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.getDefault());

    public static String e(Context context, long j) {
        int i = (int) j;
        int i2 = (int) (j / 2592000);
        j %= 2592000;
        int i3 = (int) (j / 604800);
        j %= 604800;
        int i4 = (int) (j / 86400);
        j %= 86400;
        int i5 = (int) (j / 3600);
        int i6 = (int) ((j % 3600) / 60);
        if (i2 > 0) {
            return context.getResources().getQuantityString(R.plurals.months, i2, new Object[]{Integer.valueOf(i2)});
        } else if (i3 > 0) {
            return context.getResources().getQuantityString(R.plurals.weeks, i3, new Object[]{Integer.valueOf(i3)});
        } else if (i4 > 0) {
            return context.getResources().getQuantityString(R.plurals.days, i4, new Object[]{Integer.valueOf(i4)});
        } else if (i5 > 0) {
            return context.getResources().getQuantityString(R.plurals.hours, i5, new Object[]{Integer.valueOf(i5)});
        } else if (i6 > 0) {
            return context.getResources().getQuantityString(R.plurals.minutes, i6, new Object[]{Integer.valueOf(i6)});
        } else {
            return context.getResources().getQuantityString(R.plurals.seconds, i, new Object[]{Integer.valueOf(i)});
        }
    }

    public static String gI(int i) {
        int i2 = i % ChartTimeInterval.CANDLE_1M;
        int i3 = i2 / ChartTimeInterval.CANDLE_1W;
        i2 %= ChartTimeInterval.CANDLE_1W;
        int i4 = i2 / ChartTimeInterval.CANDLE_1D;
        i2 %= ChartTimeInterval.CANDLE_1D;
        int i5 = i2 / ChartTimeInterval.CANDLE_1H;
        i2 = (i2 % ChartTimeInterval.CANDLE_1H) / 60;
        if (i / ChartTimeInterval.CANDLE_1M > 0) {
            return String.format("%dM", new Object[]{Integer.valueOf(i / ChartTimeInterval.CANDLE_1M)});
        } else if (i3 > 0) {
            return String.format("%dW", new Object[]{Integer.valueOf(i3)});
        } else if (i4 > 0) {
            return String.format("%dD", new Object[]{Integer.valueOf(i4)});
        } else if (i5 > 0) {
            return String.format("%dH", new Object[]{Integer.valueOf(i5)});
        } else if (i2 > 0) {
            return String.format("%dm", new Object[]{Integer.valueOf(i2)});
        } else {
            return String.format("%ds", new Object[]{Integer.valueOf(i)});
        }
    }

    public static String t(long j, long j2) {
        return a(j, j2, false);
    }

    public static String u(long j, long j2) {
        int i = (int) ((j2 - j) / 1000);
        int i2 = i / ChartTimeInterval.CANDLE_1M;
        i = (i % ChartTimeInterval.CANDLE_1M) % ChartTimeInterval.CANDLE_1W;
        int i3 = i / ChartTimeInterval.CANDLE_1D;
        i %= ChartTimeInterval.CANDLE_1D;
        int i4 = i / ChartTimeInterval.CANDLE_1H;
        i %= ChartTimeInterval.CANDLE_1H;
        int i5 = i / 60;
        i %= 60;
        StringBuilder stringBuilder;
        if (i2 > 0) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(String.format(Locale.US, "%dM", new Object[]{Integer.valueOf(i2)}).toLowerCase());
            stringBuilder.append(" ");
            stringBuilder.append(String.format(Locale.US, "%dD", new Object[]{Integer.valueOf(i3)}).toLowerCase());
            return stringBuilder.toString();
        } else if (i3 > 0) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(String.format(Locale.US, "%dD", new Object[]{Integer.valueOf(i3)}).toLowerCase());
            stringBuilder.append(" ");
            stringBuilder.append(String.format(Locale.US, "%dH", new Object[]{Integer.valueOf(i4)}).toLowerCase());
            return stringBuilder.toString();
        } else {
            Object stringBuilder2;
            Object stringBuilder3;
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append(i4);
            stringBuilder4.append(":");
            if (i5 < 10) {
                StringBuilder stringBuilder5 = new StringBuilder();
                stringBuilder5.append("0");
                stringBuilder5.append(i5);
                stringBuilder2 = stringBuilder5.toString();
            } else {
                stringBuilder2 = Integer.valueOf(i5);
            }
            stringBuilder4.append(stringBuilder2);
            stringBuilder4.append(":");
            if (i < 10) {
                StringBuilder stringBuilder6 = new StringBuilder();
                stringBuilder6.append("0");
                stringBuilder6.append(i);
                stringBuilder3 = stringBuilder6.toString();
            } else {
                stringBuilder3 = Integer.valueOf(i);
            }
            stringBuilder4.append(stringBuilder3);
            return stringBuilder4.toString();
        }
    }

    public static String a(long j, long j2, boolean z) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j2);
        int i = instance.get(5);
        instance.setTimeInMillis(j);
        if (i == instance.get(5)) {
            instance.setTimeInMillis(j2);
            return (z ? dwD : cgr).format(instance.getTime());
        }
        int i2 = (int) ((j2 - j) / 1000);
        int i3 = i2 / ChartTimeInterval.CANDLE_1M;
        i2 %= ChartTimeInterval.CANDLE_1M;
        int i4 = i2 / ChartTimeInterval.CANDLE_1W;
        i2 %= ChartTimeInterval.CANDLE_1W;
        int i5 = i2 / ChartTimeInterval.CANDLE_1D;
        i2 %= ChartTimeInterval.CANDLE_1D;
        int i6 = i2 / ChartTimeInterval.CANDLE_1H;
        i2 %= ChartTimeInterval.CANDLE_1H;
        i4 = i2 / 60;
        i2 %= 60;
        StringBuilder stringBuilder;
        if (i3 > 0) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(String.format(Locale.US, "%dM", new Object[]{Integer.valueOf(i3)}).toLowerCase());
            stringBuilder.append(" ");
            stringBuilder.append(String.format(Locale.US, "%dD", new Object[]{Integer.valueOf(i5)}).toLowerCase());
            return stringBuilder.toString();
        } else if (i5 > 0) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(String.format(Locale.US, "%dD", new Object[]{Integer.valueOf(i5)}).toLowerCase());
            stringBuilder.append(" ");
            stringBuilder.append(String.format(Locale.US, "%dH", new Object[]{Integer.valueOf(i6)}).toLowerCase());
            return stringBuilder.toString();
        } else if (i6 <= 0) {
            return "";
        } else {
            if (z) {
                Object stringBuilder2;
                Object stringBuilder3;
                StringBuilder stringBuilder4 = new StringBuilder();
                stringBuilder4.append(i6);
                stringBuilder4.append(":");
                if (i4 < 10) {
                    StringBuilder stringBuilder5 = new StringBuilder();
                    stringBuilder5.append("0");
                    stringBuilder5.append(i4);
                    stringBuilder2 = stringBuilder5.toString();
                } else {
                    stringBuilder2 = Integer.valueOf(i4);
                }
                stringBuilder4.append(stringBuilder2);
                stringBuilder4.append(":");
                if (i2 < 10) {
                    StringBuilder stringBuilder6 = new StringBuilder();
                    stringBuilder6.append("0");
                    stringBuilder6.append(i2);
                    stringBuilder3 = stringBuilder6.toString();
                } else {
                    stringBuilder3 = Integer.valueOf(i2);
                }
                stringBuilder4.append(stringBuilder3);
                return stringBuilder4.toString();
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(String.format(Locale.US, "%dH", new Object[]{Integer.valueOf(i6)}).toLowerCase());
            stringBuilder.append(" ");
            stringBuilder.append(String.format(Locale.US, "%dm", new Object[]{Integer.valueOf(i4)}).toLowerCase());
            return stringBuilder.toString();
        }
    }

    public static String cj(long j) {
        long j2 = j / 60;
        j %= 60;
        String quantityString = IQApp.Dk().getResources().getQuantityString(R.plurals.seconds, (int) j, new Object[]{Integer.valueOf((int) j)});
        if (j2 == 0) {
            return quantityString;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(IQApp.Dk().getResources().getQuantityString(R.plurals.minutes, (int) j2, new Object[]{Integer.valueOf((int) j2)}));
        stringBuilder.append(" ");
        stringBuilder.append(quantityString);
        return stringBuilder.toString();
    }

    public static String ck(long j) {
        int round = j > 5 ? Math.round(((float) j) / 5.0f) * 5 : 5;
        int i = round / 60;
        round %= 60;
        if (i > 5) {
            round = 0;
        }
        if (i > 15) {
            i = Math.round(((float) i) / 5.0f) * 5;
        }
        int i2 = i / 60;
        i %= 60;
        StringBuilder stringBuilder = new StringBuilder();
        if (i2 > 0) {
            stringBuilder.append(String.format(Locale.US, "%dh", new Object[]{Integer.valueOf(i2)}));
        }
        if (i > 0) {
            Locale locale = Locale.US;
            String str = "%dm";
            Object[] objArr = new Object[1];
            if (round >= 30) {
                i++;
            }
            objArr[0] = Integer.valueOf(i);
            stringBuilder.append(String.format(locale, str, objArr));
        }
        if (stringBuilder.length() == 0 && round > 0) {
            stringBuilder.append(String.format(Locale.US, "%ds", new Object[]{Integer.valueOf(round)}));
        }
        return stringBuilder.toString();
    }

    public static String f(Context context, long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        Calendar instance2 = Calendar.getInstance();
        if (instance2.get(5) == instance.get(5)) {
            return context.getResources().getString(R.string.today);
        }
        if (instance2.get(5) - instance.get(5) == 1) {
            return context.getResources().getString(R.string.yesterday);
        }
        return cgq.format(new Date(TimeUnit.MILLISECONDS.toMillis(j)));
    }

    public static String c(long j, int i) {
        if (i != 1) {
            return cl(j);
        }
        return cl(j * 1000);
    }

    private static String cl(long j) {
        return cgr.format(new Date(j));
    }
}
