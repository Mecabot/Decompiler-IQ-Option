package com.iqoption.app.managers.a;

import com.google.common.base.d;
import com.iqoption.app.managers.a.k.c;
import com.iqoption.dto.entity.result.ExpirationsResult;
import java.util.concurrent.ConcurrentSkipListSet;

final /* synthetic */ class f implements d {
    private final e aob;
    private final ConcurrentSkipListSet aoc;
    private final c aod;

    f(e eVar, ConcurrentSkipListSet concurrentSkipListSet, c cVar) {
        this.aob = eVar;
        this.aoc = concurrentSkipListSet;
        this.aod = cVar;
    }

    public Object apply(Object obj) {
        return this.aob.a(this.aoc, this.aod, (ExpirationsResult) obj);
    }
}
