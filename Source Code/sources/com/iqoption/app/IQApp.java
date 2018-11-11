package com.iqoption.app;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.ProcessLifecycleOwner;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.text.TextUtils;
import android.util.SparseArray;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;
import com.google.common.b.d;
import com.google.common.base.Suppliers;
import com.google.common.base.n;
import com.google.common.util.concurrent.t;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.iqoption.analytics.EventManager;
import com.iqoption.analytics.sla.Sla;
import com.iqoption.app.managers.r;
import com.iqoption.charttools.templates.TemplateViewModel;
import com.iqoption.core.c;
import com.iqoption.core.connect.k;
import com.iqoption.core.connect.l;
import com.iqoption.core.feed.FeedFetcher;
import com.iqoption.core.gl.Graph;
import com.iqoption.core.h;
import com.iqoption.core.i;
import com.iqoption.dto.Event;
import com.iqoption.gl.NativeHandler;
import com.iqoption.microservice.configuration.f;
import com.iqoption.portfolio.g;
import com.iqoption.quiz.ad;
import com.iqoption.quiz.m;
import com.iqoption.quiz.s;
import com.iqoption.quiz.z;
import com.iqoption.service.WebSocketHandler;
import com.iqoption.util.Network;
import com.iqoption.util.ah;
import com.iqoption.util.be;
import com.iqoption.util.j;
import com.iqoption.x.R;
import io.card.payment.BuildConfig;
import io.reactivex.e;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;

public class IQApp extends com.iqoption.app.a.b implements c {
    private static final String TAG = "com.iqoption.app.IQApp";
    private static Tracker akL;
    private static volatile IQApp akM;
    private static final String akZ;
    private volatile boolean akK;
    private final n<d> akN = Suppliers.a(q.ajD);
    private final n<d> akO = Suppliers.a(r.ajD);
    public final n<com.iqoption.b.a> akP = Suppliers.a(u.ajD);
    private final a akQ = new a();
    private final com.iqoption.analytics.a akR = new com.iqoption.analytics.a();
    private final Runnable akS = v.alc;
    private final n<f> akT = Suppliers.a(w.ajD);
    private volatile boolean akU;
    private final BroadcastReceiver akV = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            IQApp.this.akU = Network.dwp.aGr();
            IQApp.Dn().aE(new com.iqoption.app.b.c(IQApp.this.akU));
        }
    };
    private final s akW = x.ald;
    private final ad akX = new ad() {
        public e<Boolean> DH() {
            return WebSocketHandler.aDm().DH();
        }

        public String b(com.iqoption.core.microservices.tradingengine.response.active.a aVar) {
            return com.iqoption.util.e.a.s(aVar);
        }

        public String c(com.iqoption.core.microservices.tradingengine.response.active.a aVar) {
            return com.iqoption.util.e.a.I(aVar);
        }

        public void m(Activity activity) {
            if (activity instanceof com.iqoption.system.a) {
                ((com.iqoption.system.a) activity).aq(true);
            }
        }
    };
    private final n<h> akY = Suppliers.a(new y(this));

    private class b implements ActivityLifecycleCallbacks {
        private t<?> alm;

        private b() {
        }

        /* synthetic */ b(IQApp iQApp, AnonymousClass1 anonymousClass1) {
            this();
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            String DE = IQApp.akZ;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Activity: ");
            stringBuilder.append(activity.getClass().getSimpleName());
            stringBuilder.append(" created");
            i.d(DE, stringBuilder.toString());
        }

        public void onActivityStarted(Activity activity) {
            String DE = IQApp.akZ;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Activity: ");
            stringBuilder.append(activity.getClass().getSimpleName());
            stringBuilder.append(" started, isStarted=true");
            i.d(DE, stringBuilder.toString());
            if (!IQApp.this.akK) {
                IQApp.this.akK = true;
                IQApp.this.akU = Network.dwp.aGr();
                IQApp.this.registerReceiver(IQApp.this.akV, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                IQApp.Dn().aE(new com.iqoption.app.b.a(true));
            }
            if (this.alm != null) {
                this.alm.cancel(true);
            }
        }

        public void onActivityResumed(Activity activity) {
            String DE = IQApp.akZ;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Activity: ");
            stringBuilder.append(activity.getClass().getSimpleName());
            stringBuilder.append(" resumed, isStarted=true");
            i.d(DE, stringBuilder.toString());
            if (!IQApp.this.akK) {
                IQApp.this.akK = true;
                IQApp.this.akU = Network.dwp.aGr();
                IQApp.this.registerReceiver(IQApp.this.akV, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                IQApp.Dn().aE(new com.iqoption.app.b.a(true));
            }
            if (this.alm != null) {
                this.alm.cancel(true);
            }
        }

        public void onActivityPaused(Activity activity) {
            String DE = IQApp.akZ;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Activity: ");
            stringBuilder.append(activity.getClass().getSimpleName());
            stringBuilder.append(" paused, isStarted=false");
            i.d(DE, stringBuilder.toString());
            if (IQApp.this.akK) {
                IQApp.this.akK = false;
                be.a(IQApp.this, IQApp.this.akV);
            }
            this.alm = com.iqoption.core.d.a.aSc.a(IQApp.this.akS, 1000, TimeUnit.MILLISECONDS);
        }

        public void onActivityStopped(Activity activity) {
            String DE = IQApp.akZ;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Activity: ");
            stringBuilder.append(activity.getClass().getSimpleName());
            stringBuilder.append(" stopped");
            i.d(DE, stringBuilder.toString());
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            String DE = IQApp.akZ;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Activity: ");
            stringBuilder.append(activity.getClass().getSimpleName());
            stringBuilder.append(" saved");
            i.d(DE, stringBuilder.toString());
        }

        public void onActivityDestroyed(Activity activity) {
            String DE = IQApp.akZ;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Activity: ");
            stringBuilder.append(activity.getClass().getSimpleName());
            stringBuilder.append(" destroyed");
            i.d(DE, stringBuilder.toString());
        }
    }

    private static class a extends com.iqoption.system.a.d {
        private a() {
        }

        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        @com.google.common.b.e
        public void onDeadEvent(com.google.common.b.b bVar) {
            if ((bVar.uV() instanceof com.iqoption.service.websocket.a.b) && ((com.iqoption.service.websocket.a.b) bVar.uV()).dqy != null) {
                ((com.iqoption.service.websocket.a.b) bVar.uV()).dqy.h(new RuntimeException("Not found subscribers"));
            }
        }

        @com.google.common.b.e
        public void onMicroPortfolioClose(com.iqoption.portfolio.g.a aVar) {
            DW();
        }

        @com.google.common.b.e
        public void onPortfolioClose(g.c cVar) {
            DW();
        }

        private void DW() {
            com.iqoption.core.d.a.aSc.b(new Runnable() {
                private int counter;

                public void run() {
                    if (IQApp.Dk().isStarted()) {
                        int i = this.counter;
                        this.counter = i + 1;
                        if (i >= 10) {
                            i.d(IQApp.TAG, "cancel check for restoring portfolio");
                            throw new CancellationException();
                        }
                        return;
                    }
                    i.i(IQApp.TAG, "portfolio will be restored on next app launch");
                    af.i("portfolio_opened", true);
                    throw new CancellationException();
                }
            }, 500, 500, TimeUnit.MILLISECONDS);
        }
    }

    public Context getContext() {
        return this;
    }

    public static synchronized IQApp Dk() {
        IQApp iQApp;
        synchronized (IQApp.class) {
            iQApp = akM;
        }
        return iQApp;
    }

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(TAG);
        stringBuilder.append('.');
        stringBuilder.append("IQLifecycleCallbacks");
        akZ = stringBuilder.toString();
    }

    static final /* synthetic */ void DB() {
        i.v(TAG, "finish runnable");
        af.setLong("finish_time", System.currentTimeMillis());
        af.i("portfolio_check_background_time_on_start", true);
        Dn().aE(new com.iqoption.app.b.a(false));
    }

    public static f Dl() {
        return (f) Dk().akT.get();
    }

    public void onCreate() {
        super.onCreate();
        Graph.setRequiresInit();
        akM = this;
        io.reactivex.d.a.f(com.iqoption.core.h.h.baE);
        com.a.b.a.e(this);
        c.aMe.b(this);
        com.iqoption.core.util.g.bg(this);
        Network.dwp.initialize(this);
        m.a(z.a(this, this.akW, this.akX));
        ((com.iqoption.b.a) this.akP.get()).d(this);
        this.akQ.register();
        this.akR.register();
        FirebaseAnalytics.getInstance(this);
        com.iqoption.app.managers.feature.b.HT().HU();
        com.iqoption.core.d.a.aSc.execute(new z(this));
        com.iqoption.core.d.a.aSc.execute(aa.alc);
        com.iqoption.core.d.a.aSd.execute(ab.alc);
        com.facebook.h.Q(getApplicationContext());
        af.aR((Context) this).Ew();
        j.init();
        NativeHandler.instance().onStart();
        r.GT().initialize();
        com.iqoption.view.drawable.e.init();
        com.iqoption.chat.a.aCG.initialize();
        com.iqoption.app.managers.c.Gn().initialize();
        Lifecycle lifecycle = ProcessLifecycleOwner.S().getLifecycle();
        lifecycle.a(FeedFetcher.aQo);
        lifecycle.a(Sla.Ci());
        lifecycle.a(EventManager.Bm());
        registerActivityLifecycleCallbacks(new b(this, null));
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_SYSTEM, "app_launch").setValue(Double.valueOf(af.aR((Context) this).Eu() == 1 ? 1.0d : 0.0d)).build());
        TemplateViewModel.aAn = s.ala;
    }

    static final /* synthetic */ void Dy() {
        try {
            com.iqoption.system.d.a.aEv().initialize();
        } catch (Throwable e) {
            i.e(TAG, "error during initializing SNTP client", e);
        }
    }

    static final /* synthetic */ SparseArray Dx() {
        List<com.iqoption.core.microservices.tradingengine.response.active.a> FO = com.iqoption.app.helpers.a.FI().FO();
        SparseArray sparseArray = new SparseArray(FO.size());
        for (com.iqoption.core.microservices.tradingengine.response.active.a aVar : FO) {
            sparseArray.put(aVar.getActiveId(), aVar);
        }
        return sparseArray;
    }

    public static synchronized Tracker aP(Context context) {
        Tracker tracker;
        synchronized (IQApp.class) {
            if (akL == null) {
                akL = GoogleAnalytics.getInstance(context).newTracker((int) R.xml.global_tracker);
                akL.enableAdvertisingIdCollection(true);
            }
            tracker = akL;
        }
        return tracker;
    }

    public static boolean aQ(Context context) {
        return context.getResources().getBoolean(R.bool.isTablet) ^ 1;
    }

    public static d Dm() {
        return (d) akM.akO.get();
    }

    public static void aV(Object obj) {
        try {
            ((d) akM.akO.get()).unregister(obj);
        } catch (IllegalArgumentException unused) {
        }
    }

    public static d Dn() {
        return (d) akM.akN.get();
    }

    public static void aW(Object obj) {
        try {
            ((d) akM.akN.get()).unregister(obj);
        } catch (IllegalArgumentException unused) {
        }
    }

    public static void a(String str, Map<String, Object> map) {
        String str2 = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AppsFlyer track: ");
        stringBuilder.append(str);
        stringBuilder.append(", values: ");
        stringBuilder.append(map);
        i.v(str2, stringBuilder.toString());
        com.appsflyer.h.fA().a(Dk().getApplicationContext(), str, (Map) map);
    }

    public boolean isStarted() {
        return this.akK;
    }

    public boolean Do() {
        return this.akU;
    }

    public com.iqoption.core.b Dp() {
        return new com.iqoption.core.b() {
            public String DI() {
                return "";
            }

            public boolean DJ() {
                return false;
            }

            public String DL() {
                return BuildConfig.PRODUCT_VERSION;
            }

            public int DM() {
                return 17;
            }

            public boolean DP() {
                return false;
            }

            public boolean DQ() {
                return false;
            }

            public String getAppId() {
                return "com.iqoption.x";
            }

            public int getVersionCode() {
                return 388;
            }

            public String DK() {
                String EE = af.DX().EE();
                return !TextUtils.isEmpty(EE) ? EE : "606";
            }

            public String DN() {
                if (!TextUtils.isEmpty("")) {
                    return "";
                }
                if (!DJ() || TextUtils.isEmpty(com.iqoption.fragment.a.a.aMm)) {
                    return com.iqoption.core.data.d.a.aOz.DN();
                }
                return com.iqoption.fragment.a.a.aMm;
            }

            public String DO() {
                Object DO = com.iqoption.core.data.d.a.aOz.DO();
                if (TextUtils.isEmpty(DO)) {
                    return null;
                }
                if (System.currentTimeMillis() - com.iqoption.core.data.d.a.aOz.SC() > 86400000) {
                    return null;
                }
                return DO;
            }
        };
    }

    public Gson Dq() {
        return ah.aGg();
    }

    public com.iqoption.core.g Dr() {
        return a.Cw();
    }

    public io.reactivex.a aX(Object obj) {
        return io.reactivex.a.d(WebSocketHandler.aDm().bE(obj));
    }

    public boolean m(Object obj, int i) {
        return WebSocketHandler.aDm().m(obj, i);
    }

    public com.iqoption.core.a.e Ds() {
        return com.iqoption.analytics.f.Br();
    }

    final /* synthetic */ h Dv() {
        return new h() {
            private final n alg = Suppliers.a(new ac(this));
            private final n alh = Suppliers.a(new ad(this));

            public com.iqoption.core.connect.g DR() {
                return WebSocketHandler.aDm();
            }

            final /* synthetic */ l DV() {
                return new l() {
                    public <T> k<T> a(String str, Type type) {
                        return com.iqoption.mobbtech.connect.request.a.a.b.a(type, str);
                    }

                    public <T> k<T> b(String str, Class<T> cls) {
                        return com.iqoption.mobbtech.connect.request.a.a.b.d(cls, str);
                    }

                    public <T> k<T> a(String str, kotlin.jvm.a.b<? super JsonReader, ? extends T> bVar) {
                        return com.iqoption.mobbtech.connect.request.a.a.b.a((kotlin.jvm.a.b) bVar, str);
                    }
                };
            }

            final /* synthetic */ com.iqoption.core.connect.e DU() {
                return new com.iqoption.core.connect.e() {
                    public <T> com.iqoption.core.connect.d<T> c(String str, Class<T> cls) {
                        return new com.iqoption.app.managers.y.a(str, (Class) cls);
                    }

                    public <T> com.iqoption.core.connect.d<T> b(String str, Type type) {
                        return new com.iqoption.app.managers.y.a(str, type);
                    }
                };
            }

            public l DS() {
                return (l) this.alg.get();
            }

            public com.iqoption.core.connect.e DT() {
                return (com.iqoption.core.connect.e) this.alh.get();
            }
        };
    }

    public h Dt() {
        return (h) this.akY.get();
    }

    public com.iqoption.core.connect.a Du() {
        return Dl();
    }
}
