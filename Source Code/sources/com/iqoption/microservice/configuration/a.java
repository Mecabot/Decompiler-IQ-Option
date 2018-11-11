package com.iqoption.microservice.configuration;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.common.base.e;
import com.google.common.base.j;
import com.google.common.base.n;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.iqoption.app.IQApp;
import com.iqoption.app.af;
import com.iqoption.core.i;
import com.iqoption.dto.entity.configuration.Configuration;
import com.iqoption.mobbtech.connect.RequestManager;
import com.iqoption.mobbtech.connect.response.MobbErrorException;
import com.iqoption.mobbtech.connect.response.g;
import com.iqoption.util.Network;
import com.iqoption.util.ag;
import com.iqoption.util.be;
import com.iqoption.util.k;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ApiConfig */
public class a extends BroadcastReceiver implements f {
    private static final String TAG = "com.iqoption.microservice.configuration.a";
    @Nullable
    private volatile com.iqoption.core.connect.a cQA;
    @NonNull
    private com.iqoption.core.connect.a cQB;
    private boolean cQC;
    private AtomicInteger cQD = new AtomicInteger();
    private volatile s<Configuration> cQE;
    private volatile boolean cQF = false;
    @Nullable
    private String cQG;

    public a() {
        if (Objects.equals("https://iqoption.com/", af.DX().getHost())) {
            this.cQB = new i();
        } else {
            this.cQB = new h();
        }
        arW();
    }

    public synchronized s<?> bz(Context context) {
        boolean isAuthorized = com.iqoption.app.a.aL(IQApp.Dk()).isAuthorized();
        Configuration bs = af.DX().bs(isAuthorized);
        if (!this.cQC) {
            context.getApplicationContext().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.cQC = true;
        }
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("API_CONGIFURATION. Get config from ");
        stringBuilder.append(arS());
        i.d(str, stringBuilder.toString());
        if (ag.j(this.cQE)) {
            i.d(TAG, "API_CONGIFURATION get config request is in progress already");
            return this.cQE;
        }
        final AtomicInteger atomicInteger = new AtomicInteger();
        n anonymousClass1 = new n<s<Configuration>>() {
            /* renamed from: Qu */
            public s<Configuration> get() {
                a.this.cQF = false;
                final String a = a.this.arS();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(a);
                stringBuilder.append("api/configuration");
                s auF = new com.iqoption.mobbtech.connect.request.a.a.i(Configuration.class, RequestManager.e(stringBuilder.toString(), IQApp.Dk()), "api/configuration").auF();
                a.this.cQF = false;
                ag.a(auF, new com.google.common.util.concurrent.n<Configuration>() {
                    /* renamed from: b */
                    public void onSuccess(Configuration configuration) {
                        String jy = a.TAG;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("api config result: ");
                        stringBuilder.append(configuration);
                        i.i(jy, stringBuilder.toString());
                    }

                    public void l(@NonNull Throwable th) {
                        String jy = a.TAG;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("api configuration error host=");
                        stringBuilder.append(a);
                        i.e(jy, stringBuilder.toString(), th);
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("api configuration error host=");
                        stringBuilder2.append(a);
                        com.crashlytics.android.a.log(stringBuilder2.toString());
                        a.this.fj(atomicInteger.incrementAndGet());
                        if (Network.dwp.aGr()) {
                            k.c(th);
                        }
                        g E = MobbErrorException.E(th);
                        if (E != null) {
                            Map hashMap = new HashMap();
                            String str = "error";
                            int code = E.getCode() >= 0 ? E.getCode() : TextUtils.isEmpty(E.getErrorMessage()) ? -100 : -1;
                            hashMap.put(str, Integer.valueOf(code));
                            IQApp.a("api_config_failed", hashMap);
                        }
                    }
                });
                return auF;
            }
        };
        j bVar = new b(this, atomicInteger);
        c cVar = new c(this, bVar, bs, atomicInteger);
        if (isAuthorized && RequestManager.atO().atT()) {
            bVar = cVar;
        }
        s<?> b = o.b(ag.a(anonymousClass1, bVar, com.iqoption.core.d.a.aSd, isAuthorized ? this.cQD.get() : ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, -1, 5000, "api/configuration"), new d(this, bs), MoreExecutors.vV());
        if (bs != null) {
            this.cQE = b;
            i.d(TAG, "request config but use restored if failed");
            return o.b(this.cQE, Throwable.class, new e(bs), MoreExecutors.vV());
        }
        this.cQE = b;
        i.d(TAG, "request config");
        return b;
    }

    final /* synthetic */ boolean a(j jVar, Configuration configuration, AtomicInteger atomicInteger, Configuration configuration2) {
        boolean a = a(configuration2);
        String arS = arS();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("api config (authorized user): cluster or socket path are not found. host=");
        stringBuilder.append(arS);
        arS = stringBuilder.toString();
        Object obj = (a || !jVar.apply(configuration2)) ? null : 1;
        if (obj != null && configuration == null) {
            if (atomicInteger.incrementAndGet() >= 10) {
                IQApp.Dn().aE(new g());
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(arS);
                stringBuilder2.append(". Perform logout.");
                com.crashlytics.android.a.log(stringBuilder2.toString());
                k.c(new ApiConfigException(arS));
            } else {
                fj(atomicInteger.get());
            }
        }
        return a;
    }

    private void fj(int i) {
        if (i % 2 == 0 && (this.cQB instanceof i)) {
            ((i) this.cQB).arZ();
        }
    }

    private static boolean a(Configuration configuration) {
        return (configuration.getClusterApi() == null || configuration.getClusterWebsocket() == null) ? false : true;
    }

    private String arS() {
        return !TextUtils.isEmpty(this.cQG) ? this.cQG : this.cQB.getClusterApi();
    }

    public void bA(Context context) {
        i.v(TAG, "release");
        if (this.cQC) {
            be.a(context.getApplicationContext(), this);
            this.cQC = false;
        }
        if (ag.j(this.cQE)) {
            this.cQE.cancel(true);
            this.cQE = null;
        }
    }

    private com.iqoption.core.connect.a arT() {
        if (this.cQA != null) {
            return this.cQA;
        }
        if (this.cQF) {
            i.w(TAG, "Api config is not initialized. DEFAULT PROD config is used", new Throwable());
        }
        return this.cQB;
    }

    public boolean arU() {
        return !arV() && getClusterApi().contains("sandbox");
    }

    public boolean arV() {
        String clusterApi = getClusterApi();
        return clusterApi == null || !(clusterApi.contains("://int.iqoption") || clusterApi.contains("://build.sandbox") || clusterApi.contains("sandbox3.mobbtech.com"));
    }

    public boolean isInitialized() {
        return this.cQA != null;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE") && this.cQA == null && !ag.j(this.cQE) && Network.dwp.aGr()) {
            bz(context);
        }
    }

    public void setTc(Boolean bool) {
        com.iqoption.core.connect.a arT = arT();
        if (arT != null) {
            arT.setTc(bool);
        }
    }

    public String getClusterApi() {
        String clusterApi = arT().getClusterApi();
        if (clusterApi != null) {
            return be.jP(clusterApi);
        }
        if (this.cQF) {
            i.w(TAG, "DEFAULT PROD config is used for clusterApi (Null clusterApi is received from server)", new Throwable());
        }
        return be.jP(this.cQB.getClusterApi());
    }

    public String in(String str) {
        String clusterApi = this.cQA == null ? null : this.cQA.getClusterApi();
        if (clusterApi != null) {
            return be.jP(clusterApi);
        }
        clusterApi = arS();
        String str2 = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("-- DEBUG OR PROD_DEFAULT host is used -- ");
        stringBuilder.append(clusterApi);
        stringBuilder.append(" for ");
        stringBuilder.append(str == null ? "NULL" : str.toUpperCase());
        i.i(str2, stringBuilder.toString());
        return be.jP(clusterApi);
    }

    public String getClusterWebsocket() {
        String clusterWebsocket = arT().getClusterWebsocket();
        if (clusterWebsocket != null) {
            return be.jP(clusterWebsocket);
        }
        if (this.cQF) {
            i.w(TAG, "DEFAULT PROD config is used for clusterWebSocket (Null clusterWebSocket is received from server)", new Throwable());
        }
        return be.jP(this.cQB.getClusterWebsocket());
    }

    @Nullable
    public String getAuthApi() {
        return be.jP((String) e.h(arT().getAuthApi(), this.cQB.getAuthApi()));
    }

    public String getAvatarsApi() {
        return be.jP((String) e.h(arT().getAvatarsApi(), this.cQB.getAvatarsApi()));
    }

    public String getEventApi() {
        return be.jP((String) e.h(arT().getEventApi(), this.cQB.getEventApi()));
    }

    public String getChatApi() {
        return be.jP((String) e.h(arT().getChatApi(), this.cQB.getChatApi()));
    }

    public s<?> B(Context context, String str) {
        return o.aR(null);
    }

    public void aP(List<String> list) {
        com.iqoption.core.data.d.a.aOz.ag(list);
        i.arX();
        arW();
    }

    private void arW() {
        this.cQD.set(i.arY() * 6);
    }
}
