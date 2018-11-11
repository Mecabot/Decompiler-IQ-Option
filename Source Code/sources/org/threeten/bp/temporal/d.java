package org.threeten.bp.temporal;

import org.threeten.bp.DayOfWeek;

/* compiled from: TemporalAdjusters */
public final class d {

    /* compiled from: TemporalAdjusters */
    private static final class a implements c {
        private final int fgJ;
        private final int fgK;

        private a(int i, DayOfWeek dayOfWeek) {
            org.threeten.bp.a.d.requireNonNull(dayOfWeek, "dayOfWeek");
            this.fgJ = i;
            this.fgK = dayOfWeek.getValue();
        }

        public a adjustInto(a aVar) {
            int i = aVar.get(ChronoField.DAY_OF_WEEK);
            if (this.fgJ < 2 && i == this.fgK) {
                return aVar;
            }
            if ((this.fgJ & 1) == 0) {
                i -= this.fgK;
                return aVar.d((long) (i >= 0 ? 7 - i : -i), ChronoUnit.DAYS);
            }
            int i2 = this.fgK - i;
            return aVar.c((long) (i2 >= 0 ? 7 - i2 : -i2), ChronoUnit.DAYS);
        }
    }

    public static c a(DayOfWeek dayOfWeek) {
        return new a(0, dayOfWeek);
    }

    public static c b(DayOfWeek dayOfWeek) {
        return new a(1, dayOfWeek);
    }
}
