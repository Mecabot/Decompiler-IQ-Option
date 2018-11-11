package com.iqoption.fragment.rightpanel;

import com.google.common.base.Suppliers;
import com.google.common.base.n;
import java.util.Date;

/* compiled from: DateSupplier */
final class y {
    private final n<Date> cGv = Suppliers.a(z.ajD);

    y() {
    }

    Date bw(long j) {
        Date date = (Date) this.cGv.get();
        date.setTime(j);
        return date;
    }
}
