package io.fabric.sdk.android;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import io.fabric.sdk.android.a.b;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.concurrency.UnmetDependencyException;
import io.fabric.sdk.android.services.concurrency.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Fabric */
public class c {
    static volatile c emc;
    static final k emd = new b();
    private final Handler Kq;
    private final Context context;
    private AtomicBoolean dTU = new AtomicBoolean(false);
    private final Map<Class<? extends h>, h> eme;
    private final f<c> emf;
    private final f<?> emg;
    private a emh;
    private WeakReference<Activity> emi;
    final k emj;
    final boolean emk;
    private final ExecutorService executorService;
    private final IdManager tl;

    /* compiled from: Fabric */
    public static class a {
        private final Context context;
        private f<c> emf;
        private k emj;
        private boolean emk;
        private h[] emo;
        private h emp;
        private String emq;
        private String emr;
        private Handler handler;

        public a(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null.");
            }
            this.context = context;
        }

        public a a(h... hVarArr) {
            if (this.emo != null) {
                throw new IllegalStateException("Kits already set.");
            }
            this.emo = hVarArr;
            return this;
        }

        public c aUi() {
            HashMap hashMap;
            if (this.emp == null) {
                this.emp = h.aVc();
            }
            if (this.handler == null) {
                this.handler = new Handler(Looper.getMainLooper());
            }
            if (this.emj == null) {
                if (this.emk) {
                    this.emj = new b(3);
                } else {
                    this.emj = new b();
                }
            }
            if (this.emr == null) {
                this.emr = this.context.getPackageName();
            }
            if (this.emf == null) {
                this.emf = f.emv;
            }
            if (this.emo == null) {
                hashMap = new HashMap();
            } else {
                hashMap = c.I(Arrays.asList(this.emo));
            }
            HashMap hashMap2 = hashMap;
            Context applicationContext = this.context.getApplicationContext();
            return new c(applicationContext, hashMap2, this.emp, this.handler, this.emj, this.emk, this.emf, new IdManager(applicationContext, this.emr, this.emq, hashMap2.values()), c.cu(this.context));
        }
    }

    public String getIdentifier() {
        return "io.fabric.sdk.android:fabric";
    }

    public String getVersion() {
        return "1.4.3.25";
    }

    static c aUe() {
        if (emc != null) {
            return emc;
        }
        throw new IllegalStateException("Must Initialize Fabric before using singleton()");
    }

    c(Context context, Map<Class<? extends h>, h> map, h hVar, Handler handler, k kVar, boolean z, f fVar, IdManager idManager, Activity activity) {
        this.context = context;
        this.eme = map;
        this.executorService = hVar;
        this.Kq = handler;
        this.emj = kVar;
        this.emk = z;
        this.emf = fVar;
        this.emg = iR(map.size());
        this.tl = idManager;
        z(activity);
    }

    public static c a(Context context, h... hVarArr) {
        if (emc == null) {
            synchronized (c.class) {
                if (emc == null) {
                    a(new a(context).a(hVarArr).aUi());
                }
            }
        }
        return emc;
    }

    private static void a(c cVar) {
        emc = cVar;
        cVar.init();
    }

    public c z(Activity activity) {
        this.emi = new WeakReference(activity);
        return this;
    }

    public Activity getCurrentActivity() {
        return this.emi != null ? (Activity) this.emi.get() : null;
    }

    private void init() {
        this.emh = new a(this.context);
        this.emh.a(new b() {
            public void onActivityCreated(Activity activity, Bundle bundle) {
                c.this.z(activity);
            }

            public void onActivityStarted(Activity activity) {
                c.this.z(activity);
            }

            public void onActivityResumed(Activity activity) {
                c.this.z(activity);
            }
        });
        ct(this.context);
    }

    void ct(Context context) {
        StringBuilder stringBuilder;
        Future cv = cv(context);
        Collection gj = gj();
        l lVar = new l(cv, gj);
        List<h> arrayList = new ArrayList(gj);
        Collections.sort(arrayList);
        lVar.a(context, this, f.emv, this.tl);
        for (h a : arrayList) {
            a.a(context, this, this.emg, this.tl);
        }
        lVar.initialize();
        if (aUg().isLoggable("Fabric", 3)) {
            stringBuilder = new StringBuilder("Initializing ");
            stringBuilder.append(getIdentifier());
            stringBuilder.append(" [Version: ");
            stringBuilder.append(getVersion());
            stringBuilder.append("], with the following kits:\n");
        } else {
            stringBuilder = null;
        }
        for (h hVar : arrayList) {
            hVar.emx.a(lVar.emx);
            a(this.eme, hVar);
            hVar.initialize();
            if (stringBuilder != null) {
                stringBuilder.append(hVar.getIdentifier());
                stringBuilder.append(" [Version: ");
                stringBuilder.append(hVar.getVersion());
                stringBuilder.append("]\n");
            }
        }
        if (stringBuilder != null) {
            aUg().d("Fabric", stringBuilder.toString());
        }
    }

    void a(Map<Class<? extends h>, h> map, h hVar) {
        io.fabric.sdk.android.services.concurrency.b bVar = hVar.emy;
        if (bVar != null) {
            for (Class cls : bVar.value()) {
                if (cls.isInterface()) {
                    for (h hVar2 : map.values()) {
                        if (cls.isAssignableFrom(hVar2.getClass())) {
                            hVar.emx.a(hVar2.emx);
                        }
                    }
                } else if (((h) map.get(cls)) == null) {
                    throw new UnmetDependencyException("Referenced Kit was null, does the kit exist?");
                } else {
                    hVar.emx.a(((h) map.get(cls)).emx);
                }
            }
        }
    }

    private static Activity cu(Context context) {
        return context instanceof Activity ? (Activity) context : null;
    }

    public ExecutorService aUf() {
        return this.executorService;
    }

    public Collection<h> gj() {
        return this.eme.values();
    }

    public static <T extends h> T D(Class<T> cls) {
        return (h) aUe().eme.get(cls);
    }

    public static k aUg() {
        if (emc == null) {
            return emd;
        }
        return emc.emj;
    }

    public static boolean aUh() {
        if (emc == null) {
            return false;
        }
        return emc.emk;
    }

    private static Map<Class<? extends h>, h> I(Collection<? extends h> collection) {
        Map hashMap = new HashMap(collection.size());
        a(hashMap, (Collection) collection);
        return hashMap;
    }

    private static void a(Map<Class<? extends h>, h> map, Collection<? extends h> collection) {
        for (h hVar : collection) {
            map.put(hVar.getClass(), hVar);
            if (hVar instanceof i) {
                a((Map) map, ((i) hVar).gj());
            }
        }
    }

    f<?> iR(final int i) {
        return new f() {
            final CountDownLatch emm = new CountDownLatch(i);

            public void bR(Object obj) {
                this.emm.countDown();
                if (this.emm.getCount() == 0) {
                    c.this.dTU.set(true);
                    c.this.emf.bR(c.this);
                }
            }

            public void e(Exception exception) {
                c.this.emf.e(exception);
            }
        };
    }

    Future<Map<String, j>> cv(Context context) {
        return aUf().submit(new e(context.getPackageCodePath()));
    }
}
