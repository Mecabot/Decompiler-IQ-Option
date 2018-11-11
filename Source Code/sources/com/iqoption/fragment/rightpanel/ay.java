package com.iqoption.fragment.rightpanel;

import com.iqoption.core.microservices.tradingengine.response.active.a;
import com.iqoption.dto.Balance;
import com.iqoption.dto.Currencies;
import com.iqoption.dto.Currencies.ConversionCurrency;
import com.iqoption.util.l;

/* compiled from: TotalCommissionCalculator */
public class ay {
    public double a(double d, a aVar, boolean z) {
        if (aVar == null || !com.iqoption.app.helpers.a.FI().h(aVar.getInstrumentType())) {
            return d;
        }
        double d2;
        com.iqoption.core.microservices.tradingengine.response.a.a a = com.iqoption.app.helpers.a.FI().a(aVar.getInstrumentType(), Integer.valueOf(aVar.getActiveId()));
        if (a == null) {
            d2 = 0.0d;
        } else {
            d2 = a.f(d, l.aGa().doubleValue());
        }
        if (com.google.common.c.a.b(0.0d, d2, 0.001d)) {
            return d;
        }
        if (!z) {
            return d + d2;
        }
        com.iqoption.app.a Cw = com.iqoption.app.a.Cw();
        Balance CA = Cw.CA();
        ConversionCurrency CF = Cw.CF();
        double doubleValue = l.d(l.e(Double.valueOf(Balance.getBalanceValue(CA)), Double.valueOf(l.c(Cw.eh(Currencies.OTN_CURRENCY)).doubleValue())), Double.valueOf(l.c(CF).doubleValue())).doubleValue() - d2;
        return doubleValue < 0.0d ? d + Math.abs(doubleValue) : d + d2;
    }
}
