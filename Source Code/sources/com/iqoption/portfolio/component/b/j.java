package com.iqoption.portfolio.component.b;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.iqoption.app.managers.af;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.ext.c;
import com.iqoption.core.microservices.tradingengine.response.active.a;
import com.iqoption.mobbtech.connect.response.options.e;

/* compiled from: OpenItem */
public abstract class j<T extends e> implements f {
    private final a aiJ;
    private final com.iqoption.portfolio.a cYf = new com.iqoption.portfolio.a();
    private final String dak;
    protected final i dap;
    protected final T daq;

    public static <T extends e> String v(T t) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("item:");
        stringBuilder.append(t.getId());
        return stringBuilder.toString();
    }

    public j(i iVar, T t) {
        this.dap = iVar;
        this.daq = t;
        this.dak = v(t);
        this.aiJ = com.iqoption.app.helpers.a.FI().a(Integer.valueOf(t.getActiveId()), t.getInstrumentType());
    }

    @NonNull
    public String Ml() {
        return this.dak;
    }

    public void awb() {
        this.cYf.a(this.daq.getInvestSum().doubleValue(), this.daq.getSellPnl(), this.daq.getExpPnl(), this.daq.getCancelTimeLeft(af.Hu().Hw()));
    }

    public com.iqoption.portfolio.a avU() {
        return this.cYf;
    }

    public boolean isCall() {
        return this.daq.isCall();
    }

    public double axc() {
        Double openUnderlyingPrice = this.daq.getOpenUnderlyingPrice();
        return openUnderlyingPrice != null ? openUnderlyingPrice.doubleValue() : 0.0d;
    }

    public long axd() {
        return this.daq.getCreateTime();
    }

    public double axe() {
        return ((Double) com.google.common.base.e.h(this.daq.getOptionCount(), Double.valueOf(0.0d))).doubleValue();
    }

    public double axf() {
        return ((Double) com.google.common.base.e.h(this.daq.getOptionOptPrice(), Double.valueOf(0.0d))).doubleValue();
    }

    public boolean axg() {
        return c.b(this.daq.getInstrumentType(), InstrumentType.FX_INSTRUMENT, InstrumentType.DIGITAL_INSTRUMENT);
    }

    public boolean axh() {
        return InstrumentType.FX_INSTRUMENT == this.daq.getInstrumentType();
    }

    public double axi() {
        return this.daq.getUnderlyingPrice();
    }

    public int axj() {
        return this.aiJ != null ? this.aiJ.getPrecision() : 6;
    }

    public long getId() {
        return this.daq.getId().longValue();
    }

    public T axk() {
        return this.daq;
    }

    @Nullable
    public a Jg() {
        return this.aiJ;
    }

    @Nullable
    public String Xg() {
        return this.aiJ != null ? com.iqoption.util.e.a.E(this.aiJ) : null;
    }

    public long axl() {
        return this.dap.getId();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Item{parent=");
        stringBuilder.append(this.dap);
        stringBuilder.append(", position=");
        stringBuilder.append(this.daq);
        stringBuilder.append(", active=");
        stringBuilder.append(this.aiJ);
        stringBuilder.append(", calculation=");
        stringBuilder.append(this.cYf);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
