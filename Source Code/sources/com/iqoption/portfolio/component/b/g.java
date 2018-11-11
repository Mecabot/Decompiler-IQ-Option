package com.iqoption.portfolio.component.b;

import android.support.annotation.Nullable;
import com.google.common.base.e;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.microservices.tradingengine.response.active.a;
import com.iqoption.dto.Balance;
import com.iqoption.dto.entity.position.Position;
import com.iqoption.util.au;

/* compiled from: OpenCfdItem */
public class g extends j<Position> {
    private boolean dai;

    public int getViewType() {
        return 3;
    }

    public g(i iVar, Position position) {
        super(iVar, position);
    }

    public double getSelfMarginCall() {
        return ((Position) this.daq).getSelfMarginCall();
    }

    public int C(double d) {
        Double marginCallOpt = ((Position) this.daq).getMarginCallOpt();
        if (marginCallOpt == null) {
            d = ((Position) this.daq).getStopOutThreshold();
        } else {
            d = ((Position) this.daq).getStopOutThreshold() - au.j(d, marginCallOpt.doubleValue());
        }
        return (int) Math.round(d);
    }

    @Nullable
    public Double awN() {
        return ((Position) this.daq).getStopLoseValue();
    }

    @Nullable
    public Double awO() {
        return ((Position) this.daq).getTakeProfitValue();
    }

    public int awP() {
        return (int) Math.round(((Position) this.daq).getTpslPercent(((Position) this.daq).getStopLoseValue()));
    }

    public int awQ() {
        return (int) Math.round(((Position) this.daq).getTpslPercent(((Position) this.daq).getTakeProfitValue()));
    }

    public int getMultiplier() {
        Integer valueOf = Integer.valueOf(((Position) this.daq).getLeverage());
        return valueOf != null ? valueOf.intValue() : 0;
    }

    public boolean awR() {
        a Jg = Jg();
        return Jg != null && Jg.getInstrumentType() == InstrumentType.CRYPTO_INSTRUMENT;
    }

    public Double getCommission() {
        Double commission = ((Position) this.daq).getCommission();
        if (commission == null) {
            return null;
        }
        double c = au.c(commission.doubleValue(), 2);
        if (com.google.common.c.a.b(0.0d, c, 0.001d)) {
            return null;
        }
        return Double.valueOf(c);
    }

    public Double getSwap() {
        Double swap = ((Position) this.daq).getSwap();
        if (swap == null || com.google.common.c.a.b(0.0d, swap.doubleValue(), 0.001d)) {
            return null;
        }
        return swap;
    }

    public boolean awS() {
        a Jg = Jg();
        return Jg != null && com.iqoption.util.e.a.G(Jg);
    }

    public boolean isWithdrawalable() {
        Object obj = 1 == Balance.getBalanceType(com.iqoption.app.a.Cw().d(((Position) this.daq).getUserBalanceId())) ? 1 : null;
        a Jg = Jg();
        if (obj != null && Jg != null && com.iqoption.util.e.a.F(Jg) && Position.isLong((Position) this.daq) && ((Integer) e.h(Integer.valueOf(((Position) this.daq).getLeverage()), Integer.valueOf(1))).intValue() == 1) {
            return true;
        }
        return false;
    }

    public boolean awT() {
        return this.dai;
    }

    public void au(boolean z) {
        this.dai = z;
    }
}
