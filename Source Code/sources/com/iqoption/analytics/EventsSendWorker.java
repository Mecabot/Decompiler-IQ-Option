package com.iqoption.analytics;

import androidx.work.Worker;
import androidx.work.Worker.Result;
import com.iqoption.app.a;
import com.iqoption.dto.Event;
import com.iqoption.util.ah;
import com.iqoption.util.be;
import java.util.Iterator;

public class EventsSendWorker extends Worker {
    private static final String TAG = "com.iqoption.analytics.EventsSendWorker";

    /* JADX WARNING: Removed duplicated region for block: B:5:0x0013 A:{Splitter: B:1:0x0005, ExcHandler: com.iqoption.core.connect.http.HttpException (r0_1 'e' java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:5:0x0013, code:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:12:0x003b, code:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:13:0x003c, code:
            com.iqoption.core.i.d(TAG, "Error", r0);
     */
    /* JADX WARNING: Missing block: B:14:0x0046, code:
            com.iqoption.core.i.d(TAG, "Events send error", r0);
     */
    /* JADX WARNING: Missing block: B:15:?, code:
            return androidx.work.Worker.Result.RETRY;
     */
    /* JADX WARNING: Missing block: B:17:?, code:
            return androidx.work.Worker.Result.FAILURE;
     */
    @android.support.annotation.NonNull
    public androidx.work.Worker.Result bh() {
        /*
        r6 = this;
        com.iqoption.analytics.EventManager.Bo();
        r0 = androidx.work.Worker.Result.SUCCESS;
        r1 = com.iqoption.system.d.a.isInitialized();	 Catch:{ Exception -> 0x0015, HttpException -> 0x0013 }
        if (r1 != 0) goto L_0x001d;
    L_0x000b:
        r1 = com.iqoption.system.d.a.aEv();	 Catch:{ Exception -> 0x0015, HttpException -> 0x0013 }
        r1.initialize();	 Catch:{ Exception -> 0x0015, HttpException -> 0x0013 }
        goto L_0x001d;
    L_0x0013:
        r0 = move-exception;
        goto L_0x0046;
    L_0x0015:
        r1 = move-exception;
        r2 = TAG;	 Catch:{ HttpException -> 0x0013, Exception -> 0x003b }
        r3 = "NtpTime error";
        com.iqoption.core.i.d(r2, r3, r1);	 Catch:{ HttpException -> 0x0013, Exception -> 0x003b }
    L_0x001d:
        r1 = com.iqoption.analytics.EventManager.Bm();	 Catch:{ HttpException -> 0x0013, Exception -> 0x003b }
        r1 = r1.Bp();	 Catch:{ HttpException -> 0x0013, Exception -> 0x003b }
        r1 = r1.longValue();	 Catch:{ HttpException -> 0x0013, Exception -> 0x003b }
        r3 = 0;
        r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r5 <= 0) goto L_0x004f;
    L_0x002f:
        r6.Bt();	 Catch:{ HttpException -> 0x0013, Exception -> 0x003b }
        r1 = 1;
        r1 = java.lang.Boolean.valueOf(r1);	 Catch:{ HttpException -> 0x0013, Exception -> 0x003b }
        r6.g(r1);	 Catch:{ HttpException -> 0x0013, Exception -> 0x003b }
        goto L_0x004f;
    L_0x003b:
        r0 = move-exception;
        r1 = TAG;
        r2 = "Error";
        com.iqoption.core.i.d(r1, r2, r0);
        r0 = androidx.work.Worker.Result.FAILURE;
        goto L_0x004f;
    L_0x0046:
        r1 = TAG;
        r2 = "Events send error";
        com.iqoption.core.i.d(r1, r2, r0);
        r0 = androidx.work.Worker.Result.RETRY;
    L_0x004f:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.analytics.EventsSendWorker.bh():androidx.work.Worker$Result");
    }

    private Result Bt() {
        return g(Boolean.valueOf(false));
    }

    private Result g(Boolean bool) {
        EventManager Bm = EventManager.Bm();
        String deviceId = be.getDeviceId(getApplicationContext());
        long userId = a.Cw().getUserId();
        Object aw = Bm.aw(bool.booleanValue());
        while (!aw.isEmpty()) {
            Iterator it = aw.iterator();
            while (it.hasNext()) {
                Event event = (Event) it.next();
                event.device_id = deviceId;
                event.user_id = Long.valueOf(userId);
            }
            com.iqoption.core.microservices.event.a.aVG.gG(ah.aGh().toJson(aw));
            Bm.f(aw);
            aw = Bm.aw(bool.booleanValue());
        }
        return Result.SUCCESS;
    }
}
