package com.iqoption.fragment.b;

import com.google.common.collect.ImmutableSet;
import com.iqoption.dto.entity.iqbus.SignalLegacy;

/* compiled from: SignalManagerEvent */
public interface c {

    /* compiled from: SignalManagerEvent */
    public static class a implements c {
    }

    /* compiled from: SignalManagerEvent */
    public static class b implements c {
        private final ImmutableSet<Integer> cIf;
        private final SignalLegacy[] cIg;

        public b(ImmutableSet<Integer> immutableSet, SignalLegacy[] signalLegacyArr) {
            this.cIf = immutableSet;
            this.cIg = signalLegacyArr;
        }
    }
}
