package com.iqoption.app.managers.feature;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.iqoption.core.ui.viewmodel.welcome.WelcomeScreenFeature;
import com.iqoption.core.util.i;
import com.iqoption.dto.entity.Feature;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: FeatureTools */
public final class a {
    public static boolean eW(String str) {
        return b.HT().ff(str);
    }

    public static boolean eX(String str) {
        Feature fd = b.HT().fd(str);
        return fd != null && "enabled".equals(fd.status);
    }

    public static String eY(String str) {
        Feature fd = b.HT().fd(str);
        if (fd == null) {
            return null;
        }
        return fd.status;
    }

    public static WelcomeScreenFeature HC() {
        return a(b.HT().fd("new-welcome-screen"));
    }

    public static WelcomeScreenFeature a(Feature feature) {
        return a(feature, WelcomeScreenFeature.disabled);
    }

    private static WelcomeScreenFeature a(Feature feature, WelcomeScreenFeature welcomeScreenFeature) {
        if (feature == null || feature.status == null) {
            return welcomeScreenFeature;
        }
        if (eZ(feature.status)) {
            return WelcomeScreenFeature.valueOf(feature.status);
        }
        return feature.status.equals("default-welcome-screen") ? WelcomeScreenFeature.welcome2 : welcomeScreenFeature;
    }

    public static boolean eZ(String str) {
        try {
            WelcomeScreenFeature.valueOf(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean HD() {
        return b.HT().fg("otn-token");
    }

    public static boolean HE() {
        return b.HT().fg("hide-emission") ^ 1;
    }

    public static boolean HF() {
        return b.HT().fg("otn-leaderboard");
    }

    public static boolean HG() {
        return !b.fa(b.fb("binary-instrument")) && b.fa(b.fb("fake-digital"));
    }

    public static boolean HH() {
        return b.fa(b.fb("digital-instrument"));
    }

    public static boolean HI() {
        return b.fa(b.fb("fx-options-instrument"));
    }

    public static boolean HJ() {
        return b.fa(b.fb("binary-instrument"));
    }

    public static boolean HK() {
        return b.fa(b.fb("cfd-instrument"));
    }

    public static boolean HL() {
        return b.fa(b.fb("forex-instrument"));
    }

    public static boolean HM() {
        return b.fa(b.fb("crypto-instrument"));
    }

    public static boolean HN() {
        Feature fe = b.HT().fe("iq-quiz");
        if (!(fe == null || fe.status == null || !fe.status.equals("enabled"))) {
            JsonElement jsonElement = fe.params;
            if (jsonElement != null && jsonElement.isJsonObject() && jsonElement.getAsJsonObject().has("update") && jsonElement.getAsJsonObject().has("versions")) {
                JsonObject asJsonObject = jsonElement.getAsJsonObject();
                JsonElement jsonElement2 = asJsonObject.get("update");
                jsonElement = asJsonObject.get("versions");
                if (!jsonElement2.isJsonPrimitive() || !jsonElement2.getAsBoolean() || !jsonElement.isJsonArray()) {
                    return false;
                }
                JsonArray asJsonArray = jsonElement.getAsJsonArray();
                int fc = b.fc("iq-quiz");
                Iterator it = asJsonArray.iterator();
                while (it.hasNext()) {
                    if (((JsonElement) it.next()).getAsInt() == fc) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static Double bw(boolean z) {
        Feature fd = b.HT().fd("first-demo-deal");
        if (fd == null || fd.status == null || fd.status.equals("disabled")) {
            return null;
        }
        JsonElement jsonElement = fd.params;
        if (jsonElement != null && jsonElement.isJsonObject()) {
            JsonElement jsonElement2 = jsonElement.getAsJsonObject().get(fd.status);
            if (jsonElement2 != null && jsonElement2.isJsonObject()) {
                return Double.valueOf(jsonElement2.getAsJsonObject().get(z ? "demo" : "notdemo").getAsDouble());
            }
        }
        return null;
    }

    public static int HO() {
        Feature fd = b.HT().fd("first-deal-forex");
        if (fd == null || fd.status == null || fd.status.equals("disabled")) {
            return -1;
        }
        JsonElement jsonElement = fd.params;
        if (jsonElement != null && jsonElement.isJsonObject()) {
            JsonElement jsonElement2 = jsonElement.getAsJsonObject().get(fd.status);
            if (jsonElement2 != null && jsonElement2.isJsonObject()) {
                return jsonElement2.getAsJsonObject().get("percent").getAsInt();
            }
        }
        return -1;
    }

    public static int HP() {
        Feature fd = b.HT().fd("auto-crypto-withdraw");
        if (fd == null || fd.status == null) {
            return 119;
        }
        JsonElement jsonElement = fd.params;
        if (jsonElement != null && jsonElement.isJsonObject()) {
            JsonElement jsonElement2 = jsonElement.getAsJsonObject().get(fd.status);
            if (jsonElement2 != null && jsonElement2.isJsonObject()) {
                return jsonElement2.getAsJsonObject().get("id").getAsInt();
            }
        }
        return 119;
    }

    public static Map<Long, Double> HQ() {
        Feature fd = b.HT().fd("fx-min-deal-amount");
        Map<Long, Double> hashMap = new HashMap();
        if (fd == null || fd.status == null || fd.status.equals("disabled")) {
            return hashMap;
        }
        JsonElement jsonElement = fd.params;
        if (jsonElement != null && jsonElement.isJsonArray()) {
            JsonArray asJsonArray = jsonElement.getAsJsonArray();
            for (int i = 0; i < asJsonArray.size(); i++) {
                JsonObject asJsonObject = asJsonArray.get(i).getAsJsonObject();
                Long d = i.d(asJsonObject.get("period"));
                Double c = i.c(asJsonObject.get("min_deal_amount"));
                if (!(d == null || c == null)) {
                    hashMap.put(Long.valueOf(d.longValue() * 1000), c);
                }
            }
        }
        return hashMap;
    }

    public static boolean HR() {
        return eW("jumio-card-verification");
    }
}
