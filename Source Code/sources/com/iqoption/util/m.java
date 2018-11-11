package com.iqoption.util;

import android.text.format.DateUtils;
import com.google.common.base.Suppliers;
import com.google.common.base.n;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/* compiled from: DateUtils */
public class m {
    private static n<DateFormat> duX = Suppliers.a(n.ajD);

    public static boolean aQ(long j) {
        return DateUtils.isToday(j);
    }

    public static boolean cf(long j) {
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.clear(12);
        instance.clear(13);
        instance.clear(14);
        instance.set(7, instance.getFirstDayOfWeek());
        long timeInMillis = instance.getTimeInMillis();
        instance.add(3, 1);
        long timeInMillis2 = instance.getTimeInMillis();
        if (j < timeInMillis || j >= timeInMillis2) {
            return false;
        }
        return true;
    }

    public static boolean aL(long j) {
        Calendar instance = Calendar.getInstance();
        instance.set(6, 1);
        instance.set(11, 0);
        instance.clear(12);
        instance.clear(13);
        instance.clear(14);
        long timeInMillis = instance.getTimeInMillis();
        instance.add(1, 1);
        long timeInMillis2 = instance.getTimeInMillis();
        if (j < timeInMillis || j >= timeInMillis2) {
            return false;
        }
        return true;
    }

    public static boolean aK(long j) {
        boolean z = false;
        if (aQ(j)) {
            return false;
        }
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.clear(12);
        instance.clear(13);
        instance.clear(14);
        instance.add(6, -1);
        if (j >= instance.getTimeInMillis()) {
            z = true;
        }
        return z;
    }

    public static String aR(long j) {
        return ((DateFormat) duX.get()).format(Long.valueOf(j));
    }

    public static int aGd() {
        return (int) (((long) TimeZone.getDefault().getOffset(new Date().getTime())) / 3600000);
    }
}
