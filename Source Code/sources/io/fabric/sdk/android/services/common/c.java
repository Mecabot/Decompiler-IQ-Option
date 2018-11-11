package io.fabric.sdk.android.services.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import io.fabric.sdk.android.services.c.d;

/* compiled from: AdvertisingInfoProvider */
class c {
    private final Context context;
    private final io.fabric.sdk.android.services.c.c vE;

    public c(Context context) {
        this.context = context.getApplicationContext();
        this.vE = new d(context, "TwitterAdvertisingInfoPreferences");
    }

    public b aUu() {
        b aUv = aUv();
        if (c(aUv)) {
            io.fabric.sdk.android.c.aUg().d("Fabric", "Using AdvertisingInfo from Preference Store");
            a(aUv);
            return aUv;
        }
        aUv = aUy();
        b(aUv);
        return aUv;
    }

    private void a(final b bVar) {
        new Thread(new h() {
            public void id() {
                b a = c.this.aUy();
                if (!bVar.equals(a)) {
                    io.fabric.sdk.android.c.aUg().d("Fabric", "Asychronously getting Advertising Info and storing it to preferences");
                    c.this.b(a);
                }
            }
        }).start();
    }

    @SuppressLint({"CommitPrefEdits"})
    private void b(b bVar) {
        if (c(bVar)) {
            this.vE.a(this.vE.edit().putString("advertising_id", bVar.emJ).putBoolean("limit_ad_tracking_enabled", bVar.emK));
        } else {
            this.vE.a(this.vE.edit().remove("advertising_id").remove("limit_ad_tracking_enabled"));
        }
    }

    protected b aUv() {
        return new b(this.vE.aVG().getString("advertising_id", ""), this.vE.aVG().getBoolean("limit_ad_tracking_enabled", false));
    }

    public f aUw() {
        return new d(this.context);
    }

    public f aUx() {
        return new e(this.context);
    }

    private boolean c(b bVar) {
        return (bVar == null || TextUtils.isEmpty(bVar.emJ)) ? false : true;
    }

    private b aUy() {
        b aUu = aUw().aUu();
        if (c(aUu)) {
            io.fabric.sdk.android.c.aUg().d("Fabric", "Using AdvertisingInfo from Reflection Provider");
        } else {
            aUu = aUx().aUu();
            if (c(aUu)) {
                io.fabric.sdk.android.c.aUg().d("Fabric", "Using AdvertisingInfo from Service Provider");
            } else {
                io.fabric.sdk.android.c.aUg().d("Fabric", "AdvertisingInfo not present");
            }
        }
        return aUu;
    }
}
