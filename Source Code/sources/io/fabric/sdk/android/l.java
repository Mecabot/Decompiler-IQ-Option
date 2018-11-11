package io.fabric.sdk.android;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.DeliveryMechanism;
import io.fabric.sdk.android.services.common.g;
import io.fabric.sdk.android.services.network.b;
import io.fabric.sdk.android.services.network.c;
import io.fabric.sdk.android.services.settings.d;
import io.fabric.sdk.android.services.settings.e;
import io.fabric.sdk.android.services.settings.h;
import io.fabric.sdk.android.services.settings.n;
import io.fabric.sdk.android.services.settings.q;
import io.fabric.sdk.android.services.settings.s;
import io.fabric.sdk.android.services.settings.x;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

/* compiled from: Onboarding */
class l extends h<Boolean> {
    private String applicationLabel;
    private PackageManager emA;
    private PackageInfo emB;
    private String emC;
    private final Future<Map<String, j>> emD;
    private final Collection<h> emE;
    private String installerPackageName;
    private String packageName;
    private final c rU = new b();
    private String tm;
    private String versionName;

    public String getIdentifier() {
        return "io.fabric.sdk.android:fabric";
    }

    public String getVersion() {
        return "1.4.3.25";
    }

    public l(Future<Map<String, j>> future, Collection<h> collection) {
        this.emD = future;
        this.emE = collection;
    }

    protected boolean go() {
        try {
            this.installerPackageName = aUn().getInstallerPackageName();
            this.emA = getContext().getPackageManager();
            this.packageName = getContext().getPackageName();
            this.emB = this.emA.getPackageInfo(this.packageName, 0);
            this.tm = Integer.toString(this.emB.versionCode);
            this.versionName = this.emB.versionName == null ? "0.0" : this.emB.versionName;
            this.applicationLabel = this.emA.getApplicationLabel(getContext().getApplicationInfo()).toString();
            this.emC = Integer.toString(getContext().getApplicationInfo().targetSdkVersion);
            return true;
        } catch (Throwable e) {
            c.aUg().e("Fabric", "Failed init", e);
            return false;
        }
    }

    /* renamed from: gp */
    protected Boolean doInBackground() {
        boolean a;
        String cO = CommonUtils.cO(getContext());
        s aUs = aUs();
        if (aUs != null) {
            try {
                Map map;
                if (this.emD != null) {
                    map = (Map) this.emD.get();
                } else {
                    map = new HashMap();
                }
                a = a(cO, aUs.epL, b(map, this.emE).values());
            } catch (Throwable e) {
                c.aUg().e("Fabric", "Error performing auto configuration.", e);
            }
            return Boolean.valueOf(a);
        }
        a = false;
        return Boolean.valueOf(a);
    }

    private s aUs() {
        try {
            q.aVM().a(this, this.tl, this.rU, this.tm, this.versionName, gq()).aVO();
            return q.aVM().aVN();
        } catch (Throwable e) {
            c.aUg().e("Fabric", "Error dealing with settings", e);
            return null;
        }
    }

    Map<String, j> b(Map<String, j> map, Collection<h> collection) {
        for (h hVar : collection) {
            if (!map.containsKey(hVar.getIdentifier())) {
                map.put(hVar.getIdentifier(), new j(hVar.getIdentifier(), hVar.getVersion(), "binary"));
            }
        }
        return map;
    }

    private boolean a(String str, e eVar, Collection<j> collection) {
        if ("new".equals(eVar.status)) {
            if (b(str, eVar, collection)) {
                return q.aVM().aVP();
            }
            c.aUg().e("Fabric", "Failed to create app with Crashlytics service.", null);
            return false;
        } else if ("configured".equals(eVar.status)) {
            return q.aVM().aVP();
        } else {
            if (eVar.eph) {
                c.aUg().d("Fabric", "Server says an update is required - forcing a full App update.");
                c(str, eVar, collection);
            }
            return true;
        }
    }

    private boolean b(String str, e eVar, Collection<j> collection) {
        return new h(this, gq(), eVar.url, this.rU).a(a(n.K(getContext(), str), collection));
    }

    private boolean c(String str, e eVar, Collection<j> collection) {
        return a(eVar, n.K(getContext(), str), (Collection) collection);
    }

    private boolean a(e eVar, n nVar, Collection<j> collection) {
        return new x(this, gq(), eVar.url, this.rU).a(a(nVar, collection));
    }

    private d a(n nVar, Collection<j> collection) {
        return new d(new g().cA(getContext()), aUn().aUH(), this.versionName, this.tm, CommonUtils.g(CommonUtils.cQ(r1)), this.applicationLabel, DeliveryMechanism.determineFrom(this.installerPackageName).getId(), this.emC, "0", nVar, collection);
    }

    String gq() {
        return CommonUtils.I(getContext(), "com.crashlytics.ApiEndpoint");
    }
}
