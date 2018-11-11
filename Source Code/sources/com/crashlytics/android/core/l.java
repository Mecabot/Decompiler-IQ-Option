package com.crashlytics.android.core;

import io.fabric.sdk.android.c;
import io.fabric.sdk.android.services.c.a;
import java.io.File;

/* compiled from: CrashlyticsFileMarker */
class l {
    private final a sc;
    private final String vb;

    public l(String str, a aVar) {
        this.vb = str;
        this.sc = aVar;
    }

    public boolean hC() {
        try {
            return hE().createNewFile();
        } catch (Throwable e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error creating marker: ");
            stringBuilder.append(this.vb);
            c.aUg().e("CrashlyticsCore", stringBuilder.toString(), e);
            return false;
        }
    }

    public boolean isPresent() {
        return hE().exists();
    }

    public boolean hD() {
        return hE().delete();
    }

    private File hE() {
        return new File(this.sc.getFilesDir(), this.vb);
    }
}
