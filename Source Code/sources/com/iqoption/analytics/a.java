package com.iqoption.analytics;

import com.google.common.b.e;
import com.iqoption.app.IQApp;
import com.iqoption.app.af;
import com.iqoption.deposit.g.b;
import com.iqoption.dto.Event;
import com.iqoption.system.a.d;
import java.util.concurrent.TimeUnit;

/* compiled from: AnalyticsEventHandler */
public class a extends d {
    private double aiT;
    private double aiU;

    @e
    public void onDepositStarted(b bVar) {
        this.aiT = bVar.bVq;
        this.aiU = bVar.aiU;
    }

    @e
    public void onDepositCompleted(com.iqoption.deposit.g.a aVar) {
        if (aVar.ajK && this.aiT == 0.0d && !af.eN("blue_first_deposit")) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("blue_first_deposit");
            stringBuilder.append(com.iqoption.app.a.Cw().getUserId());
            if (!af.eN(stringBuilder.toString()) && cE(30)) {
                IQApp.a("first_time_deposit", null);
                stringBuilder = new StringBuilder();
                stringBuilder.append("blue_first_deposit");
                stringBuilder.append(com.iqoption.app.a.Cw().getUserId());
                af.i(stringBuilder.toString(), true);
                EventManager.Bm().a(Event.Builder(Event.CATEGORY_SYSTEM, "first_time_deposit").setValue(Double.valueOf(this.aiU)).build());
            }
        }
    }

    private boolean cE(int i) {
        long EW = af.DX().EW();
        long currentTimeMillis = System.currentTimeMillis() - EW;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("time_first_login");
        stringBuilder.append(com.iqoption.app.a.Cw().getUserId());
        long j = af.getLong(stringBuilder.toString());
        long currentTimeMillis2 = System.currentTimeMillis() - j;
        long toMillis = TimeUnit.DAYS.toMillis((long) i);
        return EW > 0 && currentTimeMillis > 0 && currentTimeMillis <= toMillis && j > 0 && currentTimeMillis2 > 0 && currentTimeMillis2 <= toMillis;
    }
}
