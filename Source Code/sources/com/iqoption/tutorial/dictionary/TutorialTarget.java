package com.iqoption.tutorial.dictionary;

import java.util.Collection;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0015\b\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, aXE = {"Lcom/iqoption/tutorial/dictionary/TutorialTarget;", "", "allowedActions", "", "Lcom/iqoption/tutorial/dictionary/TutorialAction;", "(Ljava/lang/String;ILjava/util/List;)V", "actions", "getActions", "()Ljava/util/List;", "TRADE_ROOM", "TRADE_ROOM_ANOTHER_INSTRUMENT", "INSTRUMENTS", "ASSETS", "IqOption-5.5.1_optionXRelease"})
/* compiled from: TutorialTarget.kt */
public enum TutorialTarget {
    TRADE_ROOM(u.i((Collection) c.duA, (Object) TutorialAction.CALL_PUT)),
    TRADE_ROOM_ANOTHER_INSTRUMENT(u.i((Collection) c.duA, (Object) TutorialAction.CALL_PUT_ANOTHER_INSTRUMENT)),
    INSTRUMENTS(l.cr(TutorialAction.CHOOSE_INSTRUMENT)),
    ASSETS(l.cr(TutorialAction.CHOOSE_ASSET));
    
    private final List<TutorialAction> actions;

    protected TutorialTarget(List<? extends TutorialAction> list) {
        h.e(list, "allowedActions");
        this.actions = list;
    }

    public final List<TutorialAction> getActions() {
        return this.actions;
    }
}
