package io.fabric.sdk.android.services.common;

import android.content.Context;
import io.fabric.sdk.android.c;

/* compiled from: AdvertisingInfoReflectionStrategy */
class d implements f {
    private final Context context;

    public d(Context context) {
        this.context = context.getApplicationContext();
    }

    boolean cz(Context context) {
        boolean z = false;
        try {
            if (((Integer) Class.forName("com.google.android.gms.common.GooglePlayServicesUtil").getMethod("isGooglePlayServicesAvailable", new Class[]{Context.class}).invoke(null, new Object[]{context})).intValue() == 0) {
                z = true;
            }
            return z;
        } catch (Exception unused) {
            return false;
        }
    }

    public b aUu() {
        return cz(this.context) ? new b(aUz(), isLimitAdTrackingEnabled()) : null;
    }

    private String aUz() {
        try {
            return (String) Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info").getMethod("getId", new Class[0]).invoke(getInfo(), new Object[0]);
        } catch (Exception unused) {
            c.aUg().w("Fabric", "Could not call getId on com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
            return null;
        }
    }

    private boolean isLimitAdTrackingEnabled() {
        try {
            return ((Boolean) Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info").getMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(getInfo(), new Object[0])).booleanValue();
        } catch (Exception unused) {
            c.aUg().w("Fabric", "Could not call isLimitAdTrackingEnabled on com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
            return false;
        }
    }

    private Object getInfo() {
        try {
            return Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").getMethod("getAdvertisingIdInfo", new Class[]{Context.class}).invoke(null, new Object[]{this.context});
        } catch (Exception unused) {
            c.aUg().w("Fabric", "Could not call getAdvertisingIdInfo on com.google.android.gms.ads.identifier.AdvertisingIdClient");
            return null;
        }
    }
}
