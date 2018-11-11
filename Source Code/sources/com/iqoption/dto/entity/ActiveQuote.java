package com.iqoption.dto.entity;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.iqoption.app.managers.b.a;
import com.iqoption.app.managers.c;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.util.l;

public final class ActiveQuote {
    private final int activeId;
    private volatile double ask;
    private volatile double bid;
    private final a lastCalculatedBidAsk;
    private final int precision;
    private volatile double val;

    public ActiveQuote(int i, double d, double d2, double d3, int i2) {
        this.activeId = i;
        this.val = d;
        this.bid = d2;
        this.ask = d3;
        this.precision = i2;
        this.lastCalculatedBidAsk = new a(i, i2);
    }

    public int getActiveId() {
        return this.activeId;
    }

    public double getVal() {
        return this.val;
    }

    public double getBid(InstrumentType instrumentType, int i) {
        if (!(this.lastCalculatedBidAsk.getLeverage() == i && this.lastCalculatedBidAsk.getInstrumentType() == instrumentType)) {
            this.lastCalculatedBidAsk.b(i, instrumentType);
        }
        return this.lastCalculatedBidAsk.c(this.bid, this.ask);
    }

    public double getAsk(InstrumentType instrumentType, int i) {
        if (!(this.lastCalculatedBidAsk.getLeverage() == i && this.lastCalculatedBidAsk.getInstrumentType() == instrumentType)) {
            this.lastCalculatedBidAsk.b(i, instrumentType);
        }
        return this.lastCalculatedBidAsk.d(this.bid, this.ask);
    }

    public double getSpread(InstrumentType instrumentType, int i) {
        return getAsk(instrumentType, i) - getBid(instrumentType, i);
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ActiveQuote activeQuote = (ActiveQuote) obj;
        if (this.activeId != activeQuote.activeId || Double.compare(activeQuote.val, this.val) != 0 || Double.compare(activeQuote.bid, this.bid) != 0) {
            return false;
        }
        if (Double.compare(activeQuote.ask, this.ask) != 0) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int i = this.activeId;
        long doubleToLongBits = Double.doubleToLongBits(this.val);
        i = (i * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
        doubleToLongBits = Double.doubleToLongBits(this.bid);
        i = (i * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
        doubleToLongBits = Double.doubleToLongBits(this.ask);
        return (i * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
    }

    public double getBidPrice(InstrumentType instrumentType, int i) {
        return getConvertedBidPrice(this, instrumentType, i).doubleValue();
    }

    public double getAskPrice(InstrumentType instrumentType, int i) {
        return getConvertedAskPrice(this, instrumentType, i).doubleValue();
    }

    private static Double getConvertedBidPrice(@NonNull ActiveQuote activeQuote, InstrumentType instrumentType, int i) {
        return l.w(Double.valueOf(activeQuote.getBid(instrumentType, i)));
    }

    private static Double getConvertedAskPrice(@NonNull ActiveQuote activeQuote, InstrumentType instrumentType, int i) {
        return l.w(Double.valueOf(activeQuote.getAsk(instrumentType, i)));
    }

    public void update(double d, double d2, double d3) {
        this.val = d;
        this.bid = d2;
        this.ask = d3;
        this.lastCalculatedBidAsk.reset();
    }

    @Nullable
    public static Double getCurrentSellPriceEnrolled(int i, boolean z, InstrumentType instrumentType, int i2) {
        ActiveQuote da = c.Gn().da(i);
        if (da == null) {
            return null;
        }
        return Double.valueOf(z ? da.getBid(instrumentType, i2) : da.getAsk(instrumentType, i2));
    }

    @Nullable
    public static Double getCurrentOpenPriceEnrolled(int i, boolean z, InstrumentType instrumentType, int i2) {
        ActiveQuote da = c.Gn().da(i);
        if (da == null) {
            return null;
        }
        return Double.valueOf(z ? da.getAsk(instrumentType, i2) : da.getBid(instrumentType, i2));
    }
}
