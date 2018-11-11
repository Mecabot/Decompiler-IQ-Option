package com.crashlytics.android.core;

import android.content.Context;
import android.os.Build.VERSION;
import com.iqoption.dto.ChartTimeInterval;
import java.io.BufferedReader;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: BinaryImagesConverter */
class c {
    private final Context context;
    private final a tn;

    /* compiled from: BinaryImagesConverter */
    interface a {
        String d(File file);
    }

    c(Context context, a aVar) {
        this.context = context;
        this.tn = aVar;
    }

    byte[] aO(String str) {
        return a(aP(str));
    }

    byte[] a(BufferedReader bufferedReader) {
        return a(b(bufferedReader));
    }

    private JSONArray b(BufferedReader bufferedReader) {
        JSONArray jSONArray = new JSONArray();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return jSONArray;
            }
            JSONObject aQ = aQ(readLine);
            if (aQ != null) {
                jSONArray.put(aQ);
            }
        }
    }

    private JSONArray aP(String str) {
        JSONArray jSONArray = new JSONArray();
        try {
            String[] split = b(new JSONObject(str).getJSONArray("maps")).split("\\|");
            for (String aQ : split) {
                JSONObject aQ2 = aQ(aQ);
                if (aQ2 != null) {
                    jSONArray.put(aQ2);
                }
            }
            return jSONArray;
        } catch (Throwable e) {
            io.fabric.sdk.android.c.aUg().w("CrashlyticsCore", "Unable to parse proc maps string", e);
            return jSONArray;
        }
    }

    private JSONObject aQ(String str) {
        ak bj = al.bj(str);
        if (bj == null || !a(bj)) {
            return null;
        }
        try {
            try {
                return a(this.tn.d(aR(bj.path)), bj);
            } catch (Throwable e) {
                io.fabric.sdk.android.c.aUg().d("CrashlyticsCore", "Could not create a binary image json string", e);
                return null;
            }
        } catch (Throwable e2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Could not generate ID for file ");
            stringBuilder.append(bj.path);
            io.fabric.sdk.android.c.aUg().d("CrashlyticsCore", stringBuilder.toString(), e2);
            return null;
        }
    }

    private File aR(String str) {
        File file = new File(str);
        return !file.exists() ? c(file) : file;
    }

    private File c(File file) {
        if (VERSION.SDK_INT < 9) {
            return file;
        }
        if (file.getAbsolutePath().startsWith("/data")) {
            try {
                file = new File(this.context.getPackageManager().getApplicationInfo(this.context.getPackageName(), 0).nativeLibraryDir, file.getName());
            } catch (Throwable e) {
                io.fabric.sdk.android.c.aUg().e("CrashlyticsCore", "Error getting ApplicationInfo", e);
            }
        }
        return file;
    }

    private static byte[] a(JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("binary_images", jSONArray);
            return jSONObject.toString().getBytes();
        } catch (Throwable e) {
            io.fabric.sdk.android.c.aUg().w("CrashlyticsCore", "Binary images string is null", e);
            return new byte[0];
        }
    }

    private static JSONObject a(String str, ak akVar) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("base_address", akVar.vG);
        jSONObject.put("size", akVar.size);
        jSONObject.put("name", akVar.path);
        jSONObject.put("uuid", str);
        return jSONObject;
    }

    private static String b(JSONArray jSONArray) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < jSONArray.length(); i++) {
            stringBuilder.append(jSONArray.getString(i));
        }
        return stringBuilder.toString();
    }

    private static boolean a(ak akVar) {
        return (akVar.vH.indexOf(ChartTimeInterval.CANDLE_2m) == -1 || akVar.path.indexOf(47) == -1) ? false : true;
    }
}
