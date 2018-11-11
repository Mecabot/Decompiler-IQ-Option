package com.iqoption.view.materialcalendar;

import android.support.annotation.NonNull;
import android.support.v4.util.SparseArrayCompat;

/* compiled from: MonthPagerAdapter */
class m extends d<n> {

    /* compiled from: MonthPagerAdapter */
    public static class a implements g {
        private final int count;
        private final b dHP;
        private SparseArrayCompat<b> dHQ = new SparseArrayCompat();

        public a(@NonNull b bVar, @NonNull b bVar2) {
            this.dHP = b.q(bVar.getYear(), bVar.getMonth(), 1);
            this.count = e(b.q(bVar2.getYear(), bVar2.getMonth(), 1)) + 1;
        }

        public int getCount() {
            return this.count;
        }

        public int e(b bVar) {
            return ((bVar.getYear() - this.dHP.getYear()) * 12) + (bVar.getMonth() - this.dHP.getMonth());
        }

        public b hf(int i) {
            b bVar = (b) this.dHQ.get(i);
            if (bVar != null) {
                return bVar;
            }
            int year = this.dHP.getYear() + (i / 12);
            int month = this.dHP.getMonth() + (i % 12);
            if (month >= 12) {
                year++;
                month -= 12;
            }
            bVar = b.q(year, month, 1);
            this.dHQ.put(i, bVar);
            return bVar;
        }
    }

    m(MaterialCalendarView materialCalendarView) {
        super(materialCalendarView);
    }

    /* renamed from: hm */
    protected n he(int i) {
        return new n(this.dGz, hf(i), this.dGz.getFirstDayOfWeek());
    }

    protected int a(n nVar) {
        return aJf().e(nVar.aJy());
    }

    protected boolean bO(Object obj) {
        return obj instanceof n;
    }

    protected g d(b bVar, b bVar2) {
        return new a(bVar, bVar2);
    }
}
