package io.fabric.sdk.android.services.settings;

import android.annotation.SuppressLint;
import android.content.SharedPreferences.Editor;
import io.fabric.sdk.android.h;
import io.fabric.sdk.android.services.c.c;
import io.fabric.sdk.android.services.c.d;
import io.fabric.sdk.android.services.common.CommonUtils;
import org.json.JSONObject;

/* compiled from: DefaultSettingsController */
class j implements r {
    private final io.fabric.sdk.android.services.common.j eoc;
    private final v epl;
    private final u epm;
    private final g epn;
    private final w epo;
    private final h rR;
    private final c vE = new d(this.rR);

    public j(h hVar, v vVar, io.fabric.sdk.android.services.common.j jVar, u uVar, g gVar, w wVar) {
        this.rR = hVar;
        this.epl = vVar;
        this.eoc = jVar;
        this.epm = uVar;
        this.epn = gVar;
        this.epo = wVar;
    }

    public s aVI() {
        return a(SettingsCacheBehavior.USE_CACHE);
    }

    public s a(SettingsCacheBehavior settingsCacheBehavior) {
        Throwable e;
        s sVar = null;
        try {
            if (!(io.fabric.sdk.android.c.aUh() || aVL())) {
                sVar = b(settingsCacheBehavior);
            }
            if (sVar == null) {
                JSONObject a = this.epo.a(this.epl);
                if (a != null) {
                    s a2 = this.epm.a(this.eoc, a);
                    try {
                        this.epn.a(a2.epP, a);
                        f(a, "Loaded settings: ");
                        lP(aVJ());
                        sVar = a2;
                    } catch (Exception e2) {
                        e = e2;
                        sVar = a2;
                        io.fabric.sdk.android.c.aUg().e("Fabric", "Unknown error while loading Crashlytics settings. Crashes will be cached until settings can be retrieved.", e);
                        return sVar;
                    }
                }
            }
            if (sVar == null) {
                return b(SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION);
            }
        } catch (Exception e3) {
            e = e3;
        }
        return sVar;
    }

    private s b(SettingsCacheBehavior settingsCacheBehavior) {
        Throwable e;
        s sVar = null;
        try {
            if (SettingsCacheBehavior.SKIP_CACHE_LOOKUP.equals(settingsCacheBehavior)) {
                return null;
            }
            JSONObject aVH = this.epn.aVH();
            if (aVH != null) {
                s a = this.epm.a(this.eoc, aVH);
                if (a != null) {
                    f(aVH, "Loaded cached settings: ");
                    long aUE = this.eoc.aUE();
                    if (SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION.equals(settingsCacheBehavior) || !a.cM(aUE)) {
                        try {
                            io.fabric.sdk.android.c.aUg().d("Fabric", "Returning cached settings.");
                            return a;
                        } catch (Exception e2) {
                            e = e2;
                            sVar = a;
                            io.fabric.sdk.android.c.aUg().e("Fabric", "Failed to get cached settings", e);
                            return sVar;
                        }
                    }
                    io.fabric.sdk.android.c.aUg().d("Fabric", "Cached settings have expired.");
                    return null;
                }
                io.fabric.sdk.android.c.aUg().e("Fabric", "Failed to transform cached settings data.", null);
                return null;
            }
            io.fabric.sdk.android.c.aUg().d("Fabric", "No cached settings data found.");
            return null;
        } catch (Exception e3) {
            e = e3;
            io.fabric.sdk.android.c.aUg().e("Fabric", "Failed to get cached settings", e);
            return sVar;
        }
    }

    private void f(JSONObject jSONObject, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(jSONObject.toString());
        io.fabric.sdk.android.c.aUg().d("Fabric", stringBuilder.toString());
    }

    String aVJ() {
        return CommonUtils.g(CommonUtils.cQ(this.rR.getContext()));
    }

    String aVK() {
        return this.vE.aVG().getString("existing_instance_identifier", "");
    }

    @SuppressLint({"CommitPrefEdits"})
    boolean lP(String str) {
        Editor edit = this.vE.edit();
        edit.putString("existing_instance_identifier", str);
        return this.vE.a(edit);
    }

    boolean aVL() {
        return aVK().equals(aVJ()) ^ 1;
    }
}
