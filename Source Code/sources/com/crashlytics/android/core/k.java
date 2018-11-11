package com.crashlytics.android.core;

import android.content.Context;
import android.util.Log;
import com.crashlytics.android.answers.j;
import com.crashlytics.android.answers.o;
import io.fabric.sdk.android.h;
import io.fabric.sdk.android.services.c.d;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.common.g;
import io.fabric.sdk.android.services.common.l;
import io.fabric.sdk.android.services.common.m;
import io.fabric.sdk.android.services.concurrency.Priority;
import io.fabric.sdk.android.services.concurrency.UnmetDependencyException;
import io.fabric.sdk.android.services.concurrency.i;
import io.fabric.sdk.android.services.network.c;
import io.fabric.sdk.android.services.network.e;
import io.fabric.sdk.android.services.settings.q;
import io.fabric.sdk.android.services.settings.s;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@io.fabric.sdk.android.services.concurrency.b({p.class})
/* compiled from: CrashlyticsCore */
public class k extends h<Void> {
    private boolean disabled;
    private c sp;
    private final long startTime;
    private i tS;
    private final ConcurrentHashMap<String, String> uR;
    private l uS;
    private l uT;
    private n uU;
    private j uV;
    private String uW;
    private float uX;
    private final ai uY;
    private p uZ;
    private String userId;
    private String userName;

    /* compiled from: CrashlyticsCore */
    private static final class a implements Callable<Boolean> {
        private final l uT;

        public a(l lVar) {
            this.uT = lVar;
        }

        public Boolean call() {
            if (!this.uT.isPresent()) {
                return Boolean.FALSE;
            }
            io.fabric.sdk.android.c.aUg().d("CrashlyticsCore", "Found previous crash marker.");
            this.uT.hD();
            return Boolean.TRUE;
        }
    }

    /* compiled from: CrashlyticsCore */
    private static final class b implements n {
        public void hB() {
        }

        private b() {
        }

        /* synthetic */ b(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public String getIdentifier() {
        return "com.crashlytics.sdk.android.crashlytics-core";
    }

    public String getVersion() {
        return "2.6.3.25";
    }

    public k() {
        this(1.0f, null, null, false);
    }

    k(float f, n nVar, ai aiVar, boolean z) {
        this(f, nVar, aiVar, z, l.lA("Crashlytics Exception Handler"));
    }

    k(float f, n nVar, ai aiVar, boolean z, ExecutorService executorService) {
        this.userId = null;
        this.uW = null;
        this.userName = null;
        this.uX = f;
        if (nVar == null) {
            nVar = new b();
        }
        this.uU = nVar;
        this.uY = aiVar;
        this.disabled = z;
        this.tS = new i(executorService);
        this.uR = new ConcurrentHashMap();
        this.startTime = System.currentTimeMillis();
    }

    protected boolean go() {
        return N(super.getContext());
    }

    boolean N(Context context) {
        Context context2 = context;
        if (this.disabled) {
            return false;
        }
        String cA = new g().cA(context2);
        if (cA == null) {
            return false;
        }
        String cQ = CommonUtils.cQ(context);
        if (e(cQ, CommonUtils.b(context2, "com.crashlytics.RequireBuildId", true))) {
            try {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Initializing Crashlytics ");
                stringBuilder.append(getVersion());
                io.fabric.sdk.android.c.aUg().i("CrashlyticsCore", stringBuilder.toString());
                io.fabric.sdk.android.services.c.a bVar = new io.fabric.sdk.android.services.c.b(this);
                this.uT = new l("crash_marker", bVar);
                this.uS = new l("initialization_marker", bVar);
                aj a = aj.a(new d(getContext(), "com.crashlytics.android.core.CrashlyticsCore"), this);
                e qVar = this.uY != null ? new q(this.uY) : null;
                this.sp = new io.fabric.sdk.android.services.network.b(io.fabric.sdk.android.c.aUg());
                this.sp.a(qVar);
                IdManager aUn = aUn();
                a a2 = a.a(context2, aUn, cA, cQ);
                au abVar = new ab(context2, a2.packageName);
                b b = u.b(this);
                o L = j.L(context);
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Installer package name is: ");
                stringBuilder2.append(a2.installerPackageName);
                io.fabric.sdk.android.c.aUg().d("CrashlyticsCore", stringBuilder2.toString());
                j jVar = r1;
                j jVar2 = new j(this, this.tS, this.sp, aUn, a, bVar, a2, abVar, b, L);
                this.uV = jVar;
                boolean hw = hw();
                hy();
                this.uV.a(Thread.getDefaultUncaughtExceptionHandler(), new m().cS(context2));
                if (hw && CommonUtils.cR(context)) {
                    io.fabric.sdk.android.c.aUg().d("CrashlyticsCore", "Crashlytics did not finish previous background initialization. Initializing synchronously.");
                    ht();
                    return false;
                }
                io.fabric.sdk.android.c.aUg().d("CrashlyticsCore", "Exception handling initialization successful");
                return true;
            } catch (Throwable e) {
                io.fabric.sdk.android.c.aUg().e("CrashlyticsCore", "Crashlytics was not started due to an exception during initialization", e);
                this.uV = null;
                return false;
            }
        }
        throw new UnmetDependencyException("This app relies on Crashlytics. Please sign up for access at https://fabric.io/sign_up,\ninstall an Android build tool and ask a team member to invite you to this app's organization.");
    }

    /* renamed from: gk */
    protected Void doInBackground() {
        hu();
        this.uV.hb();
        try {
            this.uV.hh();
            s aVN = q.aVM().aVN();
            if (aVN == null) {
                io.fabric.sdk.android.c.aUg().w("CrashlyticsCore", "Received null settings, skipping report submission!");
                hv();
                return null;
            }
            this.uV.a(aVN);
            if (aVN.epN.epr) {
                o hx = hx();
                if (!(hx == null || this.uV.a(hx))) {
                    io.fabric.sdk.android.c.aUg().d("CrashlyticsCore", "Could not finalize previous NDK sessions.");
                }
                if (!this.uV.a(aVN.epM)) {
                    io.fabric.sdk.android.c.aUg().d("CrashlyticsCore", "Could not finalize previous sessions.");
                }
                this.uV.a(this.uX, aVN);
                hv();
                return null;
            }
            io.fabric.sdk.android.c.aUg().d("CrashlyticsCore", "Collection of crash reports disabled in Crashlytics settings.");
            hv();
            return null;
        } catch (Throwable e) {
            io.fabric.sdk.android.c.aUg().e("CrashlyticsCore", "Crashlytics encountered a problem during asynchronous initialization.", e);
        } catch (Throwable th) {
            hv();
        }
    }

    public static k hq() {
        return (k) io.fabric.sdk.android.c.D(k.class);
    }

    public void c(Throwable th) {
        if (this.disabled || !ba("prior to logging exceptions.")) {
            return;
        }
        if (th == null) {
            io.fabric.sdk.android.c.aUg().e(5, "CrashlyticsCore", "Crashlytics is ignoring a request to log a null exception.");
        } else {
            this.uV.a(Thread.currentThread(), th);
        }
    }

    public void log(String str) {
        c(3, "CrashlyticsCore", str);
    }

    private void c(int i, String str, String str2) {
        if (!this.disabled && ba("prior to logging messages.")) {
            this.uV.b(System.currentTimeMillis() - this.startTime, d(i, str, str2));
        }
    }

    public void aI(String str) {
        if (!this.disabled && ba("prior to setting user data.")) {
            this.userId = bb(str);
            this.uV.a(this.userId, this.userName, this.uW);
        }
    }

    Map<String, String> getAttributes() {
        return Collections.unmodifiableMap(this.uR);
    }

    String hr() {
        return aUn().aUF() ? this.userId : null;
    }

    String hs() {
        return aUn().aUF() ? this.uW : null;
    }

    String getUserName() {
        return aUn().aUF() ? this.userName : null;
    }

    private void ht() {
        Callable anonymousClass1 = new io.fabric.sdk.android.services.concurrency.d<Void>() {
            public Void call() {
                return k.this.doInBackground();
            }

            public Priority hA() {
                return Priority.IMMEDIATE;
            }
        };
        for (i a : aUq()) {
            anonymousClass1.a(a);
        }
        Future submit = aUo().aUf().submit(anonymousClass1);
        io.fabric.sdk.android.c.aUg().d("CrashlyticsCore", "Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
        try {
            submit.get(4, TimeUnit.SECONDS);
        } catch (Throwable e) {
            io.fabric.sdk.android.c.aUg().e("CrashlyticsCore", "Crashlytics was interrupted during initialization.", e);
        } catch (Throwable e2) {
            io.fabric.sdk.android.c.aUg().e("CrashlyticsCore", "Problem encountered during Crashlytics initialization.", e2);
        } catch (Throwable e22) {
            io.fabric.sdk.android.c.aUg().e("CrashlyticsCore", "Crashlytics timed out during initialization.", e22);
        }
    }

    void hu() {
        this.tS.b(new Callable<Void>() {
            public Void call() {
                k.this.uS.hC();
                io.fabric.sdk.android.c.aUg().d("CrashlyticsCore", "Initialization marker file created.");
                return null;
            }
        });
    }

    void hv() {
        this.tS.submit(new Callable<Boolean>() {
            public Boolean call() {
                try {
                    boolean hD = k.this.uS.hD();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Initialization marker file removed: ");
                    stringBuilder.append(hD);
                    io.fabric.sdk.android.c.aUg().d("CrashlyticsCore", stringBuilder.toString());
                    return Boolean.valueOf(hD);
                } catch (Throwable e) {
                    io.fabric.sdk.android.c.aUg().e("CrashlyticsCore", "Problem encountered deleting Crashlytics initialization marker.", e);
                    return Boolean.valueOf(false);
                }
            }
        });
    }

    boolean hw() {
        return this.uS.isPresent();
    }

    void a(p pVar) {
        this.uZ = pVar;
    }

    o hx() {
        return this.uZ != null ? this.uZ.hF() : null;
    }

    private void hy() {
        if (Boolean.TRUE.equals((Boolean) this.tS.b(new a(this.uT)))) {
            try {
                this.uU.hB();
            } catch (Throwable e) {
                io.fabric.sdk.android.c.aUg().e("CrashlyticsCore", "Exception thrown by CrashlyticsListener while notifying of previous crash.", e);
            }
        }
    }

    void hz() {
        this.uT.hC();
    }

    private static String d(int i, String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CommonUtils.iT(i));
        stringBuilder.append("/");
        stringBuilder.append(str);
        stringBuilder.append(" ");
        stringBuilder.append(str2);
        return stringBuilder.toString();
    }

    private static boolean ba(String str) {
        k hq = hq();
        if (hq != null && hq.uV != null) {
            return true;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Crashlytics must be initialized by calling Fabric.with(Context) ");
        stringBuilder.append(str);
        io.fabric.sdk.android.c.aUg().e("CrashlyticsCore", stringBuilder.toString(), null);
        return false;
    }

    private static String bb(String str) {
        if (str == null) {
            return str;
        }
        str = str.trim();
        return str.length() > 1024 ? str.substring(0, 1024) : str;
    }

    static boolean e(String str, boolean z) {
        if (!z) {
            io.fabric.sdk.android.c.aUg().d("CrashlyticsCore", "Configured not to require a build ID.");
            return true;
        } else if (!CommonUtils.bc(str)) {
            return true;
        } else {
            Log.e("CrashlyticsCore", ".");
            Log.e("CrashlyticsCore", ".     |  | ");
            Log.e("CrashlyticsCore", ".     |  |");
            Log.e("CrashlyticsCore", ".     |  |");
            Log.e("CrashlyticsCore", ".   \\ |  | /");
            Log.e("CrashlyticsCore", ".    \\    /");
            Log.e("CrashlyticsCore", ".     \\  /");
            Log.e("CrashlyticsCore", ".      \\/");
            Log.e("CrashlyticsCore", ".");
            Log.e("CrashlyticsCore", "This app relies on Crashlytics. Please sign up for access at https://fabric.io/sign_up,\ninstall an Android build tool and ask a team member to invite you to this app's organization.");
            Log.e("CrashlyticsCore", ".");
            Log.e("CrashlyticsCore", ".      /\\");
            Log.e("CrashlyticsCore", ".     /  \\");
            Log.e("CrashlyticsCore", ".    /    \\");
            Log.e("CrashlyticsCore", ".   / |  | \\");
            Log.e("CrashlyticsCore", ".     |  |");
            Log.e("CrashlyticsCore", ".     |  |");
            Log.e("CrashlyticsCore", ".     |  |");
            Log.e("CrashlyticsCore", ".");
            return false;
        }
    }
}
