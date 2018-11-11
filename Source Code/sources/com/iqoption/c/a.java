package com.iqoption.c;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.analytics.HitBuilders.EventBuilder;
import com.google.android.gms.analytics.Tracker;
import com.google.common.base.Predicates;
import com.google.common.base.Suppliers;
import com.google.common.base.n;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.google.common.util.concurrent.y;
import com.iqoption.analytics.EventManager;
import com.iqoption.app.IQApp;
import com.iqoption.app.af;
import com.iqoption.core.i;
import com.iqoption.dto.Event;
import com.iqoption.dto.Event.Builder;
import com.iqoption.microservice.authorization.AuthException;
import com.iqoption.microservice.authorization.RegistrationException;
import com.iqoption.microservice.authorization.a.b;
import com.iqoption.microservice.authorization.a.d;
import com.iqoption.microservice.authorization.a.e;
import com.iqoption.mobbtech.connect.RequestManager;
import com.iqoption.mobbtech.connect.response.g;
import com.iqoption.mobbtech.connect.response.h;
import com.iqoption.util.ag;
import java.util.HashMap;
import java.util.Map;

/* compiled from: AuthManager */
public class a {
    private static final String TAG = "com.iqoption.c.a";
    private static final n<a> aqW = Suppliers.a(f.ajD);
    private volatile int aqX = 1;

    private a() {
    }

    public static a Jw() {
        return (a) aqW.get();
    }

    public s<Boolean> a(String str, String str2, String str3, boolean z, boolean z2, int i) {
        return b(str, str2, str3, z, z2, i);
    }

    private s<Boolean> b(String str, String str2, String str3, boolean z, boolean z2, int i) {
        s a;
        i.d(TAG, "--authViaEmail--");
        RequestManager.atO().atW();
        final Builder Builder = Event.Builder(Event.CATEGORY_SYSTEM, "login_request");
        n bVar = new b(str, str2, str3, z);
        if (i > 0) {
            int i2 = i;
            a = ag.a(bVar, Predicates.a(b.cPq, b.cPr, b.cPs, b.cPt), com.iqoption.core.d.a.aSd, i2, -1, "api/v1.0/login");
        } else {
            a = (s) bVar.get();
        }
        s a2 = ag.a(ag.a(a, new c(this, Builder, str, str2, str3, z2)), new d(this));
        ag.a(a2, new com.google.common.util.concurrent.n<Boolean>() {
            /* renamed from: f */
            public void onSuccess(Boolean bool) {
            }

            public void l(Throwable th) {
                a.this.a(th, Builder);
            }
        });
        return a2;
    }

    public static void Jx() {
        e(Event.Builder(Event.CATEGORY_SYSTEM, "login_request"));
    }

    private static void e(Builder builder) {
        aW(IQApp.Dk());
        EventManager.Bm().a(builder.setValue(Double.valueOf(1.0d)).calcDuration().setTechnicalLogs(Boolean.valueOf(true)).build());
    }

    public static void Jy() {
        IQApp.a(com.google.firebase.analytics.FirebaseAnalytics.a.LOGIN, null);
    }

    public s<d> d(long j, String str) {
        i.d(TAG, "--authViaToken--");
        if (j == -1) {
            return o.m(new RuntimeException("invalid user id"));
        }
        final Builder Builder = Event.Builder(Event.CATEGORY_SYSTEM, "login_request");
        s a = ag.a(new e(j, str), Predicates.pQ(), com.iqoption.core.d.a.aSd, 3, -1, "api/v1.0/login/token");
        ag.a(a, new com.google.common.util.concurrent.n<d>() {
            /* renamed from: a */
            public void onSuccess(d dVar) {
                a.e(Builder);
                a.this.i();
            }

            public void l(Throwable th) {
                a.this.a(th, Builder);
            }
        });
        return a;
    }

    private void a(Throwable th, Builder builder) {
        EventManager.Bm().a(builder.setValue(Double.valueOf(0.0d)).calcDuration().setTechnicalLogs(Boolean.valueOf(true)).build());
        Map hashMap = new HashMap();
        int i = -1;
        if (th instanceof AuthException) {
            AuthException authException = (AuthException) th;
            if (TextUtils.isEmpty(authException.errorMessage)) {
                com.iqoption.app.a.b.aT(IQApp.Dk());
            } else {
                com.iqoption.app.a.b.eQ(authException.errorMessage);
            }
            String str = "error";
            if (authException.status >= 0) {
                i = authException.status;
            } else if (TextUtils.isEmpty(authException.errorMessage)) {
                i = -100;
            }
            hashMap.put(str, Integer.valueOf(i));
        } else {
            com.iqoption.app.a.b.aT(IQApp.Dk());
            hashMap.put("error", Integer.valueOf(-1));
        }
        IQApp.a("login_failed", hashMap);
    }

    /* renamed from: Jz */
    public s<Boolean> i() {
        return o.a(com.iqoption.microservice.authorization.a.by(IQApp.Dk()), new com.google.common.base.d<e, Boolean>() {
            /* renamed from: a */
            public Boolean apply(e eVar) {
                if (eVar.cPy == null || eVar.cPy.token == null) {
                    return Boolean.valueOf(false);
                }
                com.iqoption.app.a aL = com.iqoption.app.a.aL(IQApp.Dk());
                aL.eq(eVar.cPy.token);
                aL.aN(IQApp.Dk());
                return Boolean.valueOf(true);
            }
        });
    }

    public void h(String str, String str2, String str3) {
        Context Dk = IQApp.Dk();
        af aR = af.aR(Dk);
        aR.aW(true);
        aR.eA(str);
        com.iqoption.app.a aL = com.iqoption.app.a.aL(Dk);
        aL.setPassword(str2);
        aL.en(str);
        aL.ep(str3);
        aL.aN(IQApp.Dk());
    }

    public s<Boolean> JA() {
        final s wb = y.wb();
        com.iqoption.mobbtech.connect.request.a.a(new com.iqoption.mobbtech.connect.a.a() {
            /* renamed from: a */
            public void onSuccess(h hVar) {
                Context Dk = IQApp.Dk();
                af aR = af.aR(Dk);
                com.iqoption.mobbtech.connect.request.n.a(Dk, null, false, true);
                aR.aW(true);
                aR.Et();
                aR.h(Boolean.valueOf(true));
                aR.cN(0);
                aR.ah(System.currentTimeMillis());
                com.iqoption.app.a aL = com.iqoption.app.a.aL(Dk);
                aL.FD();
                aL.aH(true);
                wb.P(Boolean.valueOf(true));
            }

            public void a(g gVar) {
                if (gVar != null) {
                    gVar.bG(IQApp.Dk());
                }
                wb.h(new Throwable("AnonymRegister Request error"));
            }
        });
        return wb;
    }

    public s<Boolean> a(boolean z, String str, String str2, String str3, String str4, Integer num, @Nullable Long l) {
        final s wb = y.wb();
        com.iqoption.mobbtech.connect.request.n.a(z, str, str2, str3, str4, num, l, new com.iqoption.mobbtech.connect.request.n.a() {
            public void onSuccess() {
                a.this.i();
                wb.P(Boolean.valueOf(true));
            }

            public void a(RegistrationException registrationException) {
                wb.h(registrationException);
            }
        });
        return wb;
    }

    public s<Boolean> a(String str, String str2, String str3, String str4, String str5, int i) {
        final s wb = y.wb();
        com.iqoption.mobbtech.connect.request.n.b(str2, str3, str, str4, i, str5, new com.iqoption.mobbtech.connect.request.n.a() {
            public void onSuccess() {
                wb.P(Boolean.valueOf(true));
            }

            public void a(RegistrationException registrationException) {
                wb.h(registrationException);
            }
        });
        return wb;
    }

    public s<Boolean> b(String str, String str2, String str3, String str4, String str5, int i) {
        final s wb = y.wb();
        com.iqoption.mobbtech.connect.request.n.a(str2, str3, str, str4, i, str5, new com.iqoption.mobbtech.connect.request.n.a() {
            public void onSuccess() {
                wb.P(Boolean.valueOf(true));
            }

            public void a(RegistrationException registrationException) {
                wb.h(registrationException);
            }
        });
        return wb;
    }

    private static void aW(Context context) {
        Tracker aP = IQApp.aP(context);
        aP.send(((EventBuilder) ((EventBuilder) new EventBuilder().setCustomMetric(1, (float) com.iqoption.app.a.aL(context).getUserId())).setCategory("Android").setAction("Login").setLabel("Form").setCustomDimension(2, aP.get("&cid"))).build());
    }
}
