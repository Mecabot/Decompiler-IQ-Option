package com.iqoption.mobbtech.connect.response.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.common.b.e;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.n;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.iqoption.app.IQApp;
import com.iqoption.core.i;
import com.iqoption.service.WebSocketHandler;
import com.iqoption.system.a.d;
import com.iqoption.system.a.f;
import com.iqoption.system.a.g;
import com.iqoption.system.a.h;
import com.iqoption.util.ag;
import com.iqoption.util.k;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: CashBoxManager */
public class a {
    private static final String TAG = "com.iqoption.mobbtech.connect.response.a.a";
    private static final long cWd = TimeUnit.HOURS.toMillis(20);
    private static final long cWe = TimeUnit.HOURS.toMillis(1);
    private static final long cWf = TimeUnit.MINUTES.toMillis(30);
    @SuppressLint({"StaticFieldLeak"})
    private static volatile a cWg;
    @Nullable
    private volatile com.iqoption.core.microservices.billing.response.b.a cWh;
    @Nullable
    private com.iqoption.core.microservices.billing.response.deposit.b cWi;
    @Nullable
    private volatile s<com.iqoption.core.microservices.billing.response.deposit.b> cWj;
    @Nullable
    private k cWk;
    private g cWl = new f(new a(this, null), new b(this, null));
    @Nullable
    private Context context;
    private ScheduledExecutorService singleThreadExecutor = Executors.newSingleThreadScheduledExecutor();

    /* compiled from: CashBoxManager */
    private class a extends d {
        private a() {
        }

        /* synthetic */ a(a aVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        @e
        public void onWithdrawalEvent(l lVar) {
            i.d(a.TAG, "event=WithdrawalEvent");
            a.this.avc();
        }

        @e
        public void onDocumentsAreApproved(com.iqoption.app.b.b.f fVar) {
            String DE = a.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("IQAccountEvents.DocumentsAreApproved ");
            stringBuilder.append(fVar);
            i.d(DE, stringBuilder.toString());
            a.this.avc();
        }
    }

    /* compiled from: CashBoxManager */
    private class b extends h {
        private b() {
        }

        /* synthetic */ b(a aVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        @e
        public void onOpenWebSocket(com.iqoption.service.e.g gVar) {
            i.d(a.TAG, "event=WebSocketEvents.OpenWebSocket");
            a.this.avc();
        }
    }

    public static a ava() {
        if (cWg == null) {
            synchronized (a.class) {
                if (cWg == null) {
                    cWg = new a();
                }
            }
        }
        return cWg;
    }

    public void onStart() {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onStart, current value isStart=");
        stringBuilder.append(isStarted());
        i.d(str, stringBuilder.toString());
        if (!isStarted()) {
            this.context = IQApp.Dk().getApplicationContext();
            this.cWk = new k(com.iqoption.app.a.Cw().Dh());
            this.singleThreadExecutor = Executors.newSingleThreadScheduledExecutor();
            this.cWj = avb();
            this.cWl.register();
            if (!this.cWj.isCancelled()) {
                this.singleThreadExecutor.scheduleAtFixedRate(new Runnable() {
                    public void run() {
                        if (a.this.cWj != null && !a.this.cWj.isCancelled() && !a.this.cWj.isDone()) {
                            Log.i(a.TAG, "session and cashbox request is in progress already, skip");
                        } else if (IQApp.Dk().isStarted()) {
                            a.this.cWj = a.this.avb();
                        }
                    }
                }, cWd, cWd, TimeUnit.MILLISECONDS);
                this.singleThreadExecutor.scheduleAtFixedRate(new b(this), cWf, cWe, TimeUnit.MILLISECONDS);
            }
        }
    }

    final /* synthetic */ void ave() {
        if (IQApp.Dk().isStarted()) {
            avb();
        }
    }

    public void onStop() {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onStop, isStart=");
        stringBuilder.append(isStarted());
        i.d(str, stringBuilder.toString());
        if (isStarted()) {
            this.context = null;
            this.cWk = null;
            this.cWj = null;
            this.cWi = null;
            this.cWh = null;
            this.singleThreadExecutor.shutdownNow();
            this.cWl.unregister();
        }
    }

    public void restart() {
        ava().onStop();
        ava().onStart();
    }

    private boolean isStarted() {
        return this.cWk != null;
    }

    public boolean ef(boolean z) {
        return this.cWk != null && this.cWk.Dh() == z;
    }

    public s<com.iqoption.core.microservices.billing.response.deposit.b> iL(String str) {
        k.log(str);
        if (!isStarted()) {
            throw new RuntimeException("cashbox manager should be started");
        } else if (this.cWi != null) {
            return o.aR(this.cWi);
        } else {
            if (this.cWj != null && !this.cWj.isCancelled()) {
                return this.cWj;
            }
            this.cWj = avb();
            return this.cWj;
        }
    }

    public s<com.iqoption.core.microservices.billing.response.b.a> iM(String str) {
        if (!isStarted()) {
            throw new RuntimeException("cashbox manager should be started");
        } else if (this.cWh != null) {
            return o.aR(this.cWh);
        } else {
            return o.a(iL(str), new c(this));
        }
    }

    private s<com.iqoption.core.microservices.billing.response.deposit.b> avb() {
        i.d(TAG, "initSessionAndCashBoxCounting");
        if (WebSocketHandler.aDm().isAuthorized()) {
            s a = o.a(o.a(ag.a(new d(this), "CashBoxRequests.createSession"), e.ari), new f(this));
            o.a(a, new n<com.iqoption.core.microservices.billing.response.deposit.b>() {
                /* renamed from: h */
                public void onSuccess(com.iqoption.core.microservices.billing.response.deposit.b bVar) {
                }

                public void l(Throwable th) {
                    i.e(a.TAG, "CashBoxCounting error", th);
                    com.crashlytics.android.a.log("CashBoxCounting error");
                    k.c(th);
                    a.this.cWj = null;
                }
            });
            return a;
        }
        i.w(TAG, "initSessionAndCashBoxCounting cancelled - Web socket is not authorized");
        return o.vT();
    }

    final /* synthetic */ s avd() {
        return com.iqoption.mobbtech.connect.request.api.b.bF(this.context);
    }

    private s<com.iqoption.core.microservices.billing.response.deposit.b> f(com.iqoption.core.microservices.billing.response.b.a aVar) {
        i.d(TAG, "requestCashBoxCounting");
        boolean z = com.iqoption.app.managers.feature.a.eW("kyc-deposit-limit") && com.iqoption.app.a.Cw().Dh() && !com.iqoption.app.a.Cw().isVerified();
        s a = ag.a(com.iqoption.mobbtech.connect.request.api.b.d(this.context, aVar.getHost(), aVar.Uy(), z), g.$instance);
        ag.a(a, new h(this), MoreExecutors.vV());
        return a;
    }

    final /* synthetic */ void F(Throwable th) {
        i.e(TAG, "CashboxCounting error", th);
        this.cWj = null;
    }

    private void avc() {
        com.iqoption.core.d.a.aSe.execute(new i(this));
    }
}
