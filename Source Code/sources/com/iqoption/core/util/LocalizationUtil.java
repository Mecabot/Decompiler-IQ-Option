package com.iqoption.core.util;

import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.google.gson.stream.JsonReader;
import com.iqoption.core.data.d.a;
import com.iqoption.core.data.d.c;
import com.iqoption.core.data.d.d;
import com.iqoption.core.i;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

public class LocalizationUtil {
    private static final String TAG = "com.iqoption.core.util.LocalizationUtil";
    private static Map<String, String> bhd;

    public static class LocalizationException extends Exception {
        public LocalizationException(String str) {
            super(str);
        }
    }

    @Nullable
    public static String translate(String str) {
        if (bhd == null || bhd.isEmpty()) {
            init();
        }
        String str2 = (String) bhd.get(str);
        if (str2 == null) {
            b.c(new LocalizationException(str));
        }
        return str2;
    }

    public static String gW(String str) {
        String translate = translate(str);
        return translate == null ? str : translate;
    }

    @WorkerThread
    public static void aa(String str, String str2) {
        new c("localized_pref_name").put("localization_json", str2);
        a.aOz.gl(str);
        d.aOE.SG();
    }

    public static String SD() {
        String SD = a.aOz.SD();
        return SD != null ? SD : "0";
    }

    @WorkerThread
    public static void init() {
        Object string = new c("localized_pref_name").getString("localization_json", "");
        if (TextUtils.isEmpty(string)) {
            i.e(TAG, "localization json in not exist");
        } else {
            bhd = new HashMap(9000);
            try {
                JsonReader jsonReader = new JsonReader(new StringReader(string));
                jsonReader.setLenient(true);
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    bhd.put(jsonReader.nextName(), jsonReader.nextString());
                }
                jsonReader.endObject();
                jsonReader.close();
            } catch (Throwable e) {
                i.e(TAG, "localization json parse Exception", e);
                i.fZ("localization json parse Exception");
                i.r(e);
            }
        }
        if (bhd == null) {
            bhd = new HashMap();
        }
    }
}
