package io.fabric.sdk.android.services.settings;

import io.fabric.sdk.android.c;
import io.fabric.sdk.android.h;
import io.fabric.sdk.android.services.c.b;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import org.json.JSONObject;

/* compiled from: DefaultCachedSettingsIo */
class i implements g {
    private final h rR;

    public i(h hVar) {
        this.rR = hVar;
    }

    public JSONObject aVH() {
        Throwable e;
        c.aUg().d("Fabric", "Reading cached settings...");
        Closeable closeable = null;
        Closeable fileInputStream;
        try {
            JSONObject jSONObject;
            File file = new File(new b(this.rR).getFilesDir(), "com.crashlytics.settings.json");
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                try {
                    jSONObject = new JSONObject(CommonUtils.h(fileInputStream));
                    closeable = fileInputStream;
                } catch (Exception e2) {
                    e = e2;
                    try {
                        c.aUg().e("Fabric", "Failed to fetch cached settings", e);
                        CommonUtils.a(fileInputStream, "Error while closing settings cache file.");
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        closeable = fileInputStream;
                        CommonUtils.a(closeable, "Error while closing settings cache file.");
                        throw e;
                    }
                }
            }
            c.aUg().d("Fabric", "No cached settings found.");
            jSONObject = null;
            CommonUtils.a(closeable, "Error while closing settings cache file.");
            return jSONObject;
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
            c.aUg().e("Fabric", "Failed to fetch cached settings", e);
            CommonUtils.a(fileInputStream, "Error while closing settings cache file.");
            return null;
        } catch (Throwable th2) {
            e = th2;
            CommonUtils.a(closeable, "Error while closing settings cache file.");
            throw e;
        }
    }

    public void a(long j, JSONObject jSONObject) {
        Throwable e;
        c.aUg().d("Fabric", "Writing settings to cache file...");
        if (jSONObject != null) {
            Closeable closeable = null;
            try {
                jSONObject.put("expires_at", j);
                Closeable fileWriter = new FileWriter(new File(new b(this.rR).getFilesDir(), "com.crashlytics.settings.json"));
                try {
                    fileWriter.write(jSONObject.toString());
                    fileWriter.flush();
                    CommonUtils.a(fileWriter, "Failed to close settings writer.");
                } catch (Exception e2) {
                    e = e2;
                    closeable = fileWriter;
                    try {
                        c.aUg().e("Fabric", "Failed to cache settings", e);
                        CommonUtils.a(closeable, "Failed to close settings writer.");
                    } catch (Throwable th) {
                        e = th;
                        CommonUtils.a(closeable, "Failed to close settings writer.");
                        throw e;
                    }
                } catch (Throwable th2) {
                    e = th2;
                    closeable = fileWriter;
                    CommonUtils.a(closeable, "Failed to close settings writer.");
                    throw e;
                }
            } catch (Exception e3) {
                e = e3;
                c.aUg().e("Fabric", "Failed to cache settings", e);
                CommonUtils.a(closeable, "Failed to close settings writer.");
            }
        }
    }
}
