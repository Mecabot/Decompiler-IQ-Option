package com.iqoption.chat.fragment;

import java.util.Calendar;
import java.util.TimeZone;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0016\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0011J\u000e\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0011J\u000e\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0011J\u000e\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0011J\u000e\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0011R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, aXE = {"Lcom/iqoption/chat/fragment/DateComparator;", "", "()V", "c", "Ljava/util/Calendar;", "kotlin.jvm.PlatformType", "c1", "c2", "utc", "Ljava/util/TimeZone;", "checkFieldsEquality", "", "field", "", "initCalendarForDayStart", "", "millis", "", "isTheSameDay", "d1", "d2", "isThisWeek", "d", "isThisYear", "isToday", "isYesterday", "IqOption-5.5.1_optionXRelease"})
/* compiled from: DateComparator.kt */
public final class e {
    private final TimeZone aFJ = TimeZone.getTimeZone("UTC");
    private final Calendar aFK = Calendar.getInstance(this.aFJ);
    private final Calendar aFL = Calendar.getInstance(this.aFJ);
    private final Calendar aFM = Calendar.getInstance(this.aFJ);

    public final boolean l(long j, long j2) {
        Calendar calendar = this.aFK;
        h.d(calendar, "c1");
        a(calendar, j);
        Calendar calendar2 = this.aFL;
        h.d(calendar2, "c2");
        a(calendar2, j2);
        calendar2 = this.aFK;
        h.d(calendar2, "c1");
        Calendar calendar3 = this.aFL;
        h.d(calendar3, "c2");
        if (a(calendar2, calendar3, 1)) {
            calendar2 = this.aFK;
            h.d(calendar2, "c1");
            calendar3 = this.aFL;
            h.d(calendar3, "c2");
            if (a(calendar2, calendar3, 6)) {
                return true;
            }
        }
        return false;
    }

    private final void a(Calendar calendar, long j) {
        calendar.setTimeInMillis(j);
        calendar.set(11, 0);
        calendar.clear(12);
        calendar.clear(13);
        calendar.clear(14);
    }

    private final boolean a(Calendar calendar, Calendar calendar2, int i) {
        return calendar.get(i) == calendar2.get(i);
    }

    public final boolean isToday(long j) {
        Calendar calendar = this.aFM;
        h.d(calendar, "c");
        a(calendar, System.currentTimeMillis());
        calendar = this.aFM;
        h.d(calendar, "c");
        return j >= calendar.getTimeInMillis();
    }

    public final boolean aK(long j) {
        boolean z = false;
        if (isToday(j)) {
            return false;
        }
        Calendar calendar = this.aFM;
        h.d(calendar, "c");
        a(calendar, System.currentTimeMillis());
        this.aFM.add(6, -1);
        calendar = this.aFM;
        h.d(calendar, "c");
        if (j >= calendar.getTimeInMillis()) {
            z = true;
        }
        return z;
    }

    public final boolean aL(long j) {
        Calendar calendar = this.aFM;
        h.d(calendar, "c");
        a(calendar, System.currentTimeMillis());
        this.aFM.set(6, 1);
        calendar = this.aFM;
        h.d(calendar, "c");
        long timeInMillis = calendar.getTimeInMillis();
        this.aFM.add(1, 1);
        calendar = this.aFM;
        h.d(calendar, "c");
        long timeInMillis2 = calendar.getTimeInMillis() - 1;
        if (timeInMillis <= j && timeInMillis2 >= j) {
            return true;
        }
        return false;
    }
}
