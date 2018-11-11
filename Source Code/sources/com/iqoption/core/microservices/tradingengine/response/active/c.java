package com.iqoption.core.microservices.tradingengine.response.active;

import com.iqoption.core.data.model.InstrumentType;
import java.util.Map;
import kotlin.i;
import kotlin.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0010\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\"\u001a\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, aXE = {"capacityAssetMap", "", "Lcom/iqoption/core/data/model/InstrumentType;", "", "getCapacityAsset", "instrumentType", "core_release"})
/* compiled from: ActiveCapacities.kt */
public final class c {
    private static final Map<InstrumentType, Integer> aYs = ad.a(j.D(InstrumentType.CRYPTO_INSTRUMENT, Integer.valueOf(64)), j.D(InstrumentType.CFD_INSTRUMENT, Integer.valueOf(1024)), j.D(InstrumentType.FOREX_INSTRUMENT, Integer.valueOf(128)), j.D(InstrumentType.DIGITAL_INSTRUMENT, Integer.valueOf(128)), j.D(InstrumentType.FX_INSTRUMENT, Integer.valueOf(128)), j.D(InstrumentType.BINARY_INSTRUMENT, Integer.valueOf(128)), j.D(InstrumentType.TURBO_INSTRUMENT, Integer.valueOf(128)));

    public static final int D(InstrumentType instrumentType) {
        Integer num = (Integer) aYs.get(instrumentType);
        return num != null ? num.intValue() : 128;
    }
}
