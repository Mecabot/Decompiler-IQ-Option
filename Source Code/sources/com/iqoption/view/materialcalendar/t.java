package com.iqoption.view.materialcalendar;

import android.support.annotation.NonNull;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/* compiled from: WeekPagerAdapter */
public class t extends d<u> {

    /* compiled from: WeekPagerAdapter */
    public static class a implements g {
        private final int count;
        private final b dHP;

        public a(@NonNull b bVar, @NonNull b bVar2, int i) {
            this.dHP = a(bVar, i);
            this.count = h(this.dHP, bVar2) + 1;
        }

        public int getCount() {
            return this.count;
        }

        public int e(b bVar) {
            return h(this.dHP, bVar);
        }

        public b hf(int i) {
            return b.c(new Date(this.dHP.getDate().getTime() + TimeUnit.MILLISECONDS.convert((long) (i * 7), TimeUnit.DAYS)));
        }

        private int h(@NonNull b bVar, @NonNull b bVar2) {
            return (int) (TimeUnit.DAYS.convert(((bVar2.getDate().getTime() - bVar.getDate().getTime()) + ((long) bVar2.getCalendar().get(16))) - ((long) bVar.getCalendar().get(16)), TimeUnit.MILLISECONDS) / 7);
        }

        private b a(@NonNull b bVar, int i) {
            Calendar instance = Calendar.getInstance();
            bVar.c(instance);
            while (instance.get(7) != i) {
                instance.add(7, -1);
            }
            return b.b(instance);
        }
    }

    public t(MaterialCalendarView materialCalendarView) {
        super(materialCalendarView);
    }

    /* renamed from: hn */
    protected u he(int i) {
        return new u(this.dGz, hf(i), this.dGz.getFirstDayOfWeek());
    }

    protected int a(u uVar) {
        return aJf().e(uVar.getFirstViewDay());
    }

    protected boolean bO(Object obj) {
        return obj instanceof u;
    }

    protected g d(b bVar, b bVar2) {
        return new a(bVar, bVar2, this.dGz.getFirstDayOfWeek());
    }
}
