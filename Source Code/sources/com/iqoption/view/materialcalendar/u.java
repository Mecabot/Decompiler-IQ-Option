package com.iqoption.view.materialcalendar;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import java.util.Calendar;
import java.util.Collection;

@SuppressLint({"ViewConstructor"})
/* compiled from: WeekView */
public class u extends e {
    protected boolean d(b bVar) {
        return true;
    }

    protected int getRows() {
        return 2;
    }

    public u(@NonNull MaterialCalendarView materialCalendarView, b bVar, int i) {
        super(materialCalendarView, bVar, i);
    }

    protected void b(Collection<h> collection, Calendar calendar) {
        for (int i = 0; i < 7; i++) {
            a(collection, calendar);
        }
    }
}
