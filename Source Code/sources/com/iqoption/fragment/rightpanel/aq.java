package com.iqoption.fragment.rightpanel;

import com.iqoption.app.managers.tab.a.g;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.microservices.tradingengine.response.b.a;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, aXE = {"Lcom/iqoption/fragment/rightpanel/LeverageActiveProvider;", "", "()V", "DEFAULT_LEVERAGE", "", "getActiveLeverage", "leverageInfo", "Lcom/iqoption/core/microservices/tradingengine/response/leverage/LeverageInfo;", "instrumentType", "Lcom/iqoption/core/data/model/InstrumentType;", "getActiveLeverageInfo", "active", "Lcom/iqoption/core/microservices/tradingengine/response/active/Active;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: LeverageActiveProvider.kt */
public final class aq {
    public static final aq cHn = new aq();

    private aq() {
    }

    public static final a y(com.iqoption.core.microservices.tradingengine.response.active.a aVar) {
        h.e(aVar, "active");
        return com.iqoption.app.helpers.a.FI().a(aVar.getInstrumentType(), aVar.getActiveId());
    }

    public static final int a(a aVar, InstrumentType instrumentType) {
        int a;
        com.iqoption.app.managers.tab.a Il = com.iqoption.app.managers.tab.a.Il();
        h.d(Il, "TabHelper.instance()");
        g IC = Il.IC();
        Integer num = null;
        Number number = null;
        if (IC != null) {
            number = IC.fj("tabSetting.multiplier");
        }
        if (aVar != null) {
            boolean Dh = com.iqoption.app.a.Cw().Dh();
            if (number != null) {
                num = Integer.valueOf(number.intValue());
            }
            a = aVar.a(Dh, num);
        } else {
            a = 1;
        }
        return ar.a(a, instrumentType, aVar);
    }
}
