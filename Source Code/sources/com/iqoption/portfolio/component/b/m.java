package com.iqoption.portfolio.component.b;

import android.support.annotation.NonNull;
import com.iqoption.app.managers.c;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.microservices.tradingengine.response.active.a;
import com.iqoption.dto.Currencies.ConversionCurrency;
import com.iqoption.dto.entity.ActiveQuote;
import com.iqoption.dto.entity.position.Order;
import com.iqoption.util.l;

/* compiled from: PendingItem */
public final class m implements k {
    private final a aiJ;
    private final Order cpH;
    private final String dak;
    private double dao = -1.0d;

    public static String s(Order order) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("pendingItem:");
        stringBuilder.append(order.getId());
        return stringBuilder.toString();
    }

    public m(l lVar, Order order) {
        this.cpH = order;
        this.dak = s(order);
        this.aiJ = lVar.Jg();
    }

    @NonNull
    public String Ml() {
        return this.dak;
    }

    public int getViewType() {
        return Order.ON_MKT_OPEN.equals(this.cpH.getType()) ? 6 : 3;
    }

    public a Jg() {
        return this.aiJ;
    }

    public boolean isCall() {
        return Order.BUY.equalsIgnoreCase(this.cpH.getSide());
    }

    public boolean awR() {
        return this.aiJ.getInstrumentType() == InstrumentType.CRYPTO_INSTRUMENT;
    }

    public double axp() {
        return this.cpH.getPendingPrice();
    }

    public long getCreateTime() {
        return this.cpH.getCreateTime();
    }

    public double getInvestment() {
        return this.cpH.getInvestment();
    }

    public double axe() {
        if (this.dao == -1.0d) {
            ConversionCurrency CF = com.iqoption.app.a.Cw().CF();
            if (CF == null) {
                this.dao = 0.0d;
            } else {
                this.dao = l.e(Double.valueOf(getInvestment()), l.c(CF)).doubleValue() / axp();
            }
        }
        return this.dao;
    }

    public int getMultiplier() {
        return this.cpH.getLeverage();
    }

    public Double axq() {
        ActiveQuote da = c.Gn().da(this.aiJ.getActiveId());
        if (da == null) {
            return null;
        }
        double ask;
        if (isCall()) {
            ask = da.getAsk(this.cpH.getInstrumentType(), this.cpH.getLeverage());
        } else {
            ask = da.getBid(this.cpH.getInstrumentType(), this.cpH.getLeverage());
        }
        return Double.valueOf(ask);
    }

    public Double awO() {
        return this.cpH.getTakeProfitPrice();
    }

    public Double awN() {
        return this.cpH.getStopLosePrice();
    }

    public int awQ() {
        Double b = com.iqoption.dialog.c.a.b(this.cpH.getTakeProfitPrice(), Double.valueOf(this.cpH.getPendingPrice()), Order.BUY.equalsIgnoreCase(this.cpH.getSide()), this.cpH.getLeverageGL().intValue());
        if (b == null) {
            return 0;
        }
        return (int) Math.round(b.doubleValue());
    }

    public int awP() {
        Double b = com.iqoption.dialog.c.a.b(this.cpH.getStopLosePrice(), Double.valueOf(this.cpH.getPendingPrice()), Order.BUY.equalsIgnoreCase(this.cpH.getSide()), this.cpH.getLeverageGL().intValue());
        if (b == null) {
            return 0;
        }
        return (int) Math.round(b.doubleValue());
    }

    public String Xg() {
        return com.iqoption.util.e.a.E(this.aiJ);
    }

    public Order axr() {
        return this.cpH;
    }
}
