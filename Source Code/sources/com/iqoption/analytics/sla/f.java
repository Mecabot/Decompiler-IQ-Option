package com.iqoption.analytics.sla;

import com.google.common.cache.RemovalNotification;
import com.google.common.cache.g;

final /* synthetic */ class f implements g {
    static final g ajE = new f();

    private f() {
    }

    public void onRemoval(RemovalNotification removalNotification) {
        Sla.a(removalNotification);
    }
}
