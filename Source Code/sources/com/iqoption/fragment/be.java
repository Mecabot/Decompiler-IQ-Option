package com.iqoption.fragment;

import com.iqoption.core.data.model.ActiveType;
import com.iqoption.core.data.model.InstrumentType;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, aXE = {"Lcom/iqoption/fragment/InstrumentTab;", "Lcom/iqoption/fragment/AssetTab;", "instrumentType", "Lcom/iqoption/core/data/model/InstrumentType;", "activeType", "Lcom/iqoption/core/data/model/ActiveType;", "(Lcom/iqoption/core/data/model/InstrumentType;Lcom/iqoption/core/data/model/ActiveType;)V", "getActiveType", "()Lcom/iqoption/core/data/model/ActiveType;", "getInstrumentType", "()Lcom/iqoption/core/data/model/InstrumentType;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: TabTypes.kt */
public final class be extends ac {
    private final ActiveType activeType;
    private final InstrumentType instrumentType;

    public be(InstrumentType instrumentType, ActiveType activeType) {
        h.e(instrumentType, "instrumentType");
        h.e(activeType, "activeType");
        super(TabType.ACTIVE_TAB, null);
        this.instrumentType = instrumentType;
        this.activeType = activeType;
    }

    public final ActiveType getActiveType() {
        return this.activeType;
    }

    public final InstrumentType getInstrumentType() {
        return this.instrumentType;
    }
}
