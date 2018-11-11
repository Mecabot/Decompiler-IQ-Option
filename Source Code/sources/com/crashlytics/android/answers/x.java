package com.crashlytics.android.answers;

import android.content.Context;
import io.fabric.sdk.android.services.b.b;
import io.fabric.sdk.android.services.b.c;
import io.fabric.sdk.android.services.common.j;
import java.util.UUID;

/* compiled from: SessionAnalyticsFilesManager */
class x extends b<SessionEvent> {
    private io.fabric.sdk.android.services.settings.b sN;

    x(Context context, ac acVar, j jVar, c cVar) {
        super(context, acVar, jVar, cVar, 100);
    }

    protected String gI() {
        UUID randomUUID = UUID.randomUUID();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("sa");
        stringBuilder.append("_");
        stringBuilder.append(randomUUID.toString());
        stringBuilder.append("_");
        stringBuilder.append(this.eoc.aUE());
        stringBuilder.append(".tap");
        return stringBuilder.toString();
    }

    protected int gJ() {
        return this.sN == null ? super.gJ() : this.sN.eoS;
    }

    protected int gK() {
        return this.sN == null ? super.gK() : this.sN.eoQ;
    }

    void a(io.fabric.sdk.android.services.settings.b bVar) {
        this.sN = bVar;
    }
}
