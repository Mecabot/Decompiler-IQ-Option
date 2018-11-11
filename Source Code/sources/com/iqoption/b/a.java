package com.iqoption.b;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.appsflyer.h;
import com.google.common.util.concurrent.n;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.google.common.util.concurrent.y;
import com.iqoption.analytics.EventManager;
import com.iqoption.analytics.f;
import com.iqoption.app.IQApp;
import com.iqoption.app.af;
import com.iqoption.mobbtech.connect.RequestManager;
import com.iqoption.mobbtech.connect.response.g;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/* compiled from: AppsFlyerHelper */
public class a {
    @Nullable
    static volatile Uri apE;
    private s<com.iqoption.b.b.a> apF;
    private Runnable apG = new Runnable() {
        private int count = 1;

        public void run() {
            if (this.count < 30) {
                Context Dk = IQApp.Dk();
                af aR = af.aR(Dk);
                if (aR.Eu() > 1) {
                    this.count = 30;
                }
                if (!aR.EA()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("apps_flyer_device_id", h.fA().u(Dk));
                    String clusterApi = IQApp.Dl().getClusterApi();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(clusterApi);
                    stringBuilder.append("api/appsflyer/link");
                    new com.iqoption.mobbtech.connect.request.a.a.a(RequestManager.b(stringBuilder.toString(), hashMap, Dk), new com.iqoption.mobbtech.connect.a.a() {
                        /* renamed from: a */
                        public void onSuccess(com.iqoption.mobbtech.connect.response.h hVar) {
                            af.DX().aV(true);
                        }

                        public void a(g gVar) {
                            a.this.ay(120000);
                        }
                    }, "api/appsflyer/link").auG();
                }
                this.count++;
            }
        }
    };

    public s<com.iqoption.b.b.a> d(Application application) {
        if (this.apF != null) {
            return this.apF;
        }
        h fA = h.fA();
        fA.A(false);
        s wb = y.wb();
        fA.a("fJrvgkPBeNgQNPv2DApof7", new b(wb));
        fA.c(application);
        f.Br().a(wb, "appsflyer-initialization", 0, false, "");
        o.a(wb, new n<com.iqoption.b.b.a>() {
            public void l(Throwable th) {
            }

            /* renamed from: a */
            public void onSuccess(com.iqoption.b.b.a aVar) {
                try {
                    EventManager.Bm().a(aVar.apO);
                } catch (Exception unused) {
                }
            }
        });
        if (af.DX().DN() != null) {
            this.apF = o.aR(null);
        } else {
            this.apF = wb;
        }
        return this.apF;
    }

    public s<com.iqoption.b.b.a> Jb() {
        if (this.apF != null) {
            return this.apF;
        }
        return o.b(new RuntimeException("appsflyer was not initialized"));
    }

    public s<com.iqoption.b.b.a> Jc() {
        return o.a(((a) IQApp.Dk().akP.get()).Jb(), 20000, TimeUnit.MILLISECONDS, com.iqoption.core.d.a.aSc);
    }

    public void ay(long j) {
        com.iqoption.core.d.a.aSc.a(this.apG, j, TimeUnit.MILLISECONDS);
    }

    @Nullable
    public static Uri k(@NonNull Context context, @Nullable Intent intent) {
        if (intent == null) {
            return null;
        }
        Uri c = a.a.c(context, intent);
        if (c != null) {
            return c;
        }
        c = intent.getData();
        if (c != null) {
            return c;
        }
        c = apE;
        if (c == null) {
            return null;
        }
        apE = null;
        intent.setData(c);
        return c;
    }
}
