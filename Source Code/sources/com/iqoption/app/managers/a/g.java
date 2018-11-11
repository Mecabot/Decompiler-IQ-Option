package com.iqoption.app.managers.a;

import com.google.common.base.d;
import com.iqoption.dto.entity.result.StrikesResult;

final /* synthetic */ class g implements d {
    private final boolean aoe;

    g(boolean z) {
        this.aoe = z;
    }

    public Object apply(Object obj) {
        return e.a(this.aoe, (StrikesResult) obj);
    }
}
