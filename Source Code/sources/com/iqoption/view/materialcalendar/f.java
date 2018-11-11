package com.iqoption.view.materialcalendar;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Calendar;
import java.util.Date;

/* compiled from: CalendarUtils */
public class f {
    public static Calendar d(@Nullable Date date) {
        Calendar instance = Calendar.getInstance();
        if (date != null) {
            instance.setTime(date);
        }
        a(instance, instance);
        return instance;
    }

    @NonNull
    public static Calendar getInstance() {
        Calendar instance = Calendar.getInstance();
        a(instance, instance);
        return instance;
    }

    public static void a(Calendar calendar, Calendar calendar2) {
        int e = e(calendar);
        int f = f(calendar);
        int g = g(calendar);
        calendar2.clear();
        calendar2.set(e, f, g);
    }

    public static int e(Calendar calendar) {
        return calendar.get(1);
    }

    public static int f(Calendar calendar) {
        return calendar.get(2);
    }

    public static int g(Calendar calendar) {
        return calendar.get(5);
    }

    public static int h(Calendar calendar) {
        return calendar.get(7);
    }
}
