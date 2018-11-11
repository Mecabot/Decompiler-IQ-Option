package com.iqoption.app.managers.a;

import com.google.common.util.concurrent.s;
import com.iqoption.app.managers.c;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.microservices.tradingengine.response.active.a;
import com.iqoption.dto.entity.result.ExpirationsResult;
import com.iqoption.dto.entity.result.StrikesResult;
import com.iqoption.dto.entity.strike.GroupStrikeKey;
import com.iqoption.dto.entity.strike.Quote;
import com.iqoption.dto.entity.strike.Strike;
import com.iqoption.gl.b;
import com.iqoption.mobbtech.connect.request.api.f;

/* compiled from: ExpirationFxHelper */
public class j extends e {
    protected s<ExpirationsResult> o(a aVar) {
        return f.a(aVar.getInstrumentType(), aVar.Xf(), aVar.getActiveId(), "trading-instruments-fx-option");
    }

    protected s<StrikesResult> a(GroupStrikeKey groupStrikeKey) {
        return f.a(groupStrikeKey, "trading-instruments-fx-option");
    }

    protected s<? extends StrikesResult> b(GroupStrikeKey groupStrikeKey) {
        return f.b(groupStrikeKey, "trading-instruments-fx-option");
    }

    protected void a(Strike strike, String str, Integer num) {
        double doubleValue;
        double doubleValue2;
        double d;
        double d2;
        Strike strike2 = strike;
        Quote c = c.Gn().c(strike2.call.id, InstrumentType.FX_INSTRUMENT);
        Quote c2 = c.Gn().c(strike2.put.id, InstrumentType.FX_INSTRUMENT);
        double d3 = 0.0d;
        if (c != null) {
            doubleValue = c.askPrice == null ? 0.0d : c.askPrice.doubleValue();
            doubleValue2 = c.bidPrice == null ? 0.0d : c.bidPrice.doubleValue();
        } else {
            doubleValue = 0.0d;
            doubleValue2 = doubleValue;
        }
        if (c2 != null) {
            double doubleValue3 = c2.askPrice == null ? 0.0d : c2.askPrice.doubleValue();
            if (c2.bidPrice != null) {
                d3 = c2.bidPrice.doubleValue();
            }
            d = d3;
            d2 = doubleValue3;
        } else {
            d2 = 0.0d;
            d = d2;
        }
        b.aow().glchTabAddStrike(num.intValue(), (double) (strike2.expiration / 1000), strike2.optionType.getOptionActiveOrInstrumentValue(), str, (int) strike2.period, strike.getValue().doubleValue(), doubleValue, doubleValue2, d2, d, 1, 1, strike2.isSpot);
    }
}
