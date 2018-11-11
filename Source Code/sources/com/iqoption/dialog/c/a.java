package com.iqoption.dialog.c;

import android.support.annotation.Nullable;
import com.google.common.b.d;
import com.iqoption.app.IQApp;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.dto.entity.ActiveQuote;
import com.iqoption.dto.entity.position.Position;
import com.iqoption.mobbtech.connect.request.api.a.c;
import com.iqoption.mobbtech.connect.request.api.f;
import com.iqoption.settings.b;

/* compiled from: LimitsCalculatedHelper */
public class a {
    private double amZ;
    private boolean cjU;
    private double cjV;
    private int cjW;
    private Boolean cjX;
    private Double cjY;
    private Double cjZ;
    private Boolean cka;
    private boolean ckb;
    private final double ckc;
    private InstrumentType instrumentType;
    private int leverage;
    private Position position;

    public a(Position position) {
        this.cjU = Position.isLong(position);
        this.leverage = position.getLeverage();
        this.cjV = position.getOpenPriceEnrolled().doubleValue();
        this.cjY = position.getStopLoseValue();
        this.cjZ = position.getTakeProfitValue();
        this.cjW = position.getActiveId();
        this.instrumentType = position.getInstrumentType();
        this.amZ = position.getInvestSum().doubleValue();
        this.position = position;
        this.ckc = position.getStopOutThreshold();
    }

    public a(int i, InstrumentType instrumentType, boolean z, int i2, double d) {
        this.cjU = z;
        this.leverage = i2;
        this.cjW = i;
        this.instrumentType = instrumentType;
        this.amZ = d;
        this.ckc = Position.getDefaultStopOut(instrumentType, z ? Position.TYPE_LONG : Position.TYPE_SHORT);
    }

    public double getStopOutThreshold() {
        return this.ckc;
    }

    public boolean cD(boolean z) {
        return ((this.position != null && this.position.isTrailingStop()) || z) && !this.ckb;
    }

    public boolean afb() {
        return (this.position != null && this.position.isTrailingStop()) || (this.cka != null ? !this.cka.booleanValue() : !b.aDQ().Eo());
    }

    public void cE(boolean z) {
        this.cka = Boolean.valueOf(z);
    }

    public double p(double d) {
        return (((((double) (this.cjU ? 1 : -1)) * 100.0d) * ((double) this.leverage)) * (d - this.cjV)) / this.cjV;
    }

    public double getTpslValue(double d) {
        return this.cjV * ((((d / ((double) this.leverage)) / 100.0d) * ((double) (this.cjU ? 1 : -1))) + 1.0d);
    }

    public static Double a(Double d, Double d2, boolean z, int i) {
        if (d == null || d2 == null) {
            return null;
        }
        return Double.valueOf(d2.doubleValue() * ((((d.doubleValue() / ((double) i)) / 100.0d) * ((double) (z ? 1 : -1))) + 1.0d));
    }

    public static Double b(Double d, Double d2, boolean z, int i) {
        if (d == null || d2 == null) {
            return null;
        }
        return Double.valueOf((((((double) (z ? 1 : -1)) * 100.0d) * ((double) i)) * (d.doubleValue() - d2.doubleValue())) / d2.doubleValue());
    }

    public boolean cF(boolean z) {
        if (this.position != null) {
            return this.position.isAutoMarginCall();
        }
        if (this.cjX == null) {
            return b.aDQ().En() && z;
        } else {
            return this.cjX.booleanValue();
        }
    }

    public InstrumentType getInstrumentType() {
        return this.instrumentType;
    }

    public boolean isLong() {
        return this.cjU;
    }

    public int getLeverage() {
        return this.leverage;
    }

    public int afc() {
        return this.cjW;
    }

    public double GN() {
        return this.amZ;
    }

    public Double getStopLoseValue() {
        return this.cjY;
    }

    public Double getTakeProfitValue() {
        return this.cjZ;
    }

    public double afd() {
        return this.cjV;
    }

    public void cG(boolean z) {
        this.cjX = Boolean.valueOf(z);
    }

    public void cH(boolean z) {
        this.ckb = z;
    }

    public void e(Double d) {
        this.cjV = d == null ? 0.0d : d.doubleValue();
    }

    public void f(Double d) {
        this.cjY = d;
    }

    public void g(Double d) {
        this.cjZ = d;
    }

    public void b(Double d, Double d2) {
        if (afg()) {
            c.a(this.position.getId(), d, d2, Boolean.valueOf(this.cka == null ? this.position.isTrailingStop() : this.cka.booleanValue()));
            if (this.cjX != null && !this.cjX.equals(Boolean.valueOf(this.position.isAutoMarginCall()))) {
                f.b(this.position.getId(), this.cjX);
                return;
            }
            return;
        }
        d Dn = IQApp.Dn();
        Double d3 = null;
        d = d == null ? null : Double.valueOf(p(d.doubleValue()));
        if (d2 != null) {
            d3 = Double.valueOf(p(d2.doubleValue()));
        }
        Dn.aE(new com.iqoption.dialog.c.b.a(d, d3, this.cjX, this.cka));
    }

    @Nullable
    public Double afe() {
        if (afg()) {
            return ActiveQuote.getCurrentSellPriceEnrolled(this.cjW, isLong(), getInstrumentType(), getLeverage());
        }
        ActiveQuote da = com.iqoption.app.managers.c.Gn().da(this.cjW);
        if (da == null) {
            return null;
        }
        return Double.valueOf(this.cjV - (da.getSpread(getInstrumentType(), getLeverage()) * ((double) (isLong() ? 1 : -1))));
    }

    @Nullable
    public Double aff() {
        return afg() ? Double.valueOf((this.position.getSellPnl() / this.amZ) * 100.0d) : null;
    }

    public boolean afg() {
        return this.position != null;
    }
}
