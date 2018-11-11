package org.threeten.bp.a;

import org.threeten.bp.temporal.a;
import org.threeten.bp.temporal.c;
import org.threeten.bp.temporal.h;

/* compiled from: DefaultInterfaceTemporal */
public abstract class b extends c implements a {
    public a b(c cVar) {
        return cVar.adjustInto(this);
    }

    public a c(long j, h hVar) {
        return j == Long.MIN_VALUE ? d(Long.MAX_VALUE, hVar).d(1, hVar) : d(-j, hVar);
    }
}
