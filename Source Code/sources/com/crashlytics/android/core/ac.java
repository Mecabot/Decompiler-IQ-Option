package com.crashlytics.android.core;

import io.fabric.sdk.android.c;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import org.json.JSONObject;

/* compiled from: MetaDataStore */
class ac {
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private final File vx;

    public ac(File file) {
        this.vx = file;
    }

    public void a(String str, av avVar) {
        Throwable e;
        File bg = bg(str);
        Closeable closeable = null;
        try {
            String a = a(avVar);
            Closeable bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(bg), UTF_8));
            try {
                bufferedWriter.write(a);
                bufferedWriter.flush();
                CommonUtils.a(bufferedWriter, "Failed to close user metadata file.");
            } catch (Exception e2) {
                e = e2;
                closeable = bufferedWriter;
                try {
                    c.aUg().e("CrashlyticsCore", "Error serializing user metadata.", e);
                    CommonUtils.a(closeable, "Failed to close user metadata file.");
                } catch (Throwable th) {
                    e = th;
                    CommonUtils.a(closeable, "Failed to close user metadata file.");
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                closeable = bufferedWriter;
                CommonUtils.a(closeable, "Failed to close user metadata file.");
                throw e;
            }
        } catch (Exception e3) {
            e = e3;
            c.aUg().e("CrashlyticsCore", "Error serializing user metadata.", e);
            CommonUtils.a(closeable, "Failed to close user metadata file.");
        }
    }

    public av bf(String str) {
        Throwable e;
        File bg = bg(str);
        if (!bg.exists()) {
            return av.wc;
        }
        Closeable closeable = null;
        try {
            Closeable fileInputStream = new FileInputStream(bg);
            try {
                av bi = bi(CommonUtils.h(fileInputStream));
                CommonUtils.a(fileInputStream, "Failed to close user metadata file.");
                return bi;
            } catch (Exception e2) {
                e = e2;
                closeable = fileInputStream;
                try {
                    c.aUg().e("CrashlyticsCore", "Error deserializing user metadata.", e);
                    CommonUtils.a(closeable, "Failed to close user metadata file.");
                    return av.wc;
                } catch (Throwable th) {
                    e = th;
                    CommonUtils.a(closeable, "Failed to close user metadata file.");
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                closeable = fileInputStream;
                CommonUtils.a(closeable, "Failed to close user metadata file.");
                throw e;
            }
        } catch (Exception e3) {
            e = e3;
            c.aUg().e("CrashlyticsCore", "Error deserializing user metadata.", e);
            CommonUtils.a(closeable, "Failed to close user metadata file.");
            return av.wc;
        }
    }

    public File bg(String str) {
        File file = this.vx;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("user");
        stringBuilder.append(".meta");
        return new File(file, stringBuilder.toString());
    }

    public File bh(String str) {
        File file = this.vx;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("keys");
        stringBuilder.append(".meta");
        return new File(file, stringBuilder.toString());
    }

    private static av bi(String str) {
        JSONObject jSONObject = new JSONObject(str);
        return new av(a(jSONObject, "userId"), a(jSONObject, "userName"), a(jSONObject, "userEmail"));
    }

    private static String a(final av avVar) {
        return new JSONObject() {
        }.toString();
    }

    private static String a(JSONObject jSONObject, String str) {
        return !jSONObject.isNull(str) ? jSONObject.optString(str, null) : null;
    }
}
