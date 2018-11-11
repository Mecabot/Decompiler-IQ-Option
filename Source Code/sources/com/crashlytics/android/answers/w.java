package com.crashlytics.android.answers;

import java.util.Set;

/* compiled from: SamplingEventFilter */
class w implements n {
    static final Set<Type> sM = new SamplingEventFilter$1();
    final int sL;

    public w(int i) {
        this.sL = i;
    }

    public boolean a(SessionEvent sessionEvent) {
        Object obj = (sM.contains(sessionEvent.sU) && sessionEvent.sT.tg == null) ? 1 : null;
        Object obj2 = Math.abs(sessionEvent.sT.te.hashCode() % this.sL) != 0 ? 1 : null;
        if (obj == null || obj2 == null) {
            return false;
        }
        return true;
    }
}
