package com.iqoption.tutorial.utils;

import com.iqoption.app.managers.feature.b;
import com.iqoption.app.managers.tab.a;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.dto.entity.Feature;
import com.iqoption.tutorial.dictionary.TutorialAction;
import com.iqoption.tutorial.dictionary.TutorialTarget;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005¨\u0006\b"}, aXE = {"getCurrentCallPutAction", "Lcom/iqoption/tutorial/dictionary/TutorialAction;", "getCurrentTradeRoomTarget", "Lcom/iqoption/tutorial/dictionary/TutorialTarget;", "isDefaultInstrumentSelected", "", "isTutorialSuitableForUser", "isNewUser", "IqOption-5.5.1_optionXRelease"})
/* compiled from: TutorialUtils.kt */
public final class d {
    public static final boolean fc(boolean z) {
        Feature fd = b.HT().fd("first-session");
        return z && u.b((Iterable) m.listOf("enabled-no-depo", "enabled-with-depo"), fd != null ? fd.status : null);
    }

    public static final TutorialTarget aFW() {
        if (aFY()) {
            return TutorialTarget.TRADE_ROOM;
        }
        return TutorialTarget.TRADE_ROOM_ANOTHER_INSTRUMENT;
    }

    public static final TutorialAction aFX() {
        if (aFY()) {
            return TutorialAction.CALL_PUT;
        }
        return TutorialAction.CALL_PUT_ANOTHER_INSTRUMENT;
    }

    public static final boolean aFY() {
        a Il = a.Il();
        h.d(Il, "TabHelper.instance()");
        com.iqoption.core.microservices.tradingengine.response.active.a Iw = Il.Iw();
        InstrumentType instrumentType = Iw != null ? Iw.getInstrumentType() : null;
        return instrumentType == null || e.aoS[instrumentType.ordinal()] == 1;
    }
}
