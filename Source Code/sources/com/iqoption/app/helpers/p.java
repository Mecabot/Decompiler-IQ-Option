package com.iqoption.app.helpers;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.iqoption.app.managers.feature.b;
import com.iqoption.dto.entity.Feature;

/* compiled from: HighFrequencyHelper */
public final class p {
    private static Feature ame = b.HT().fd("hi-freq");
    private static JsonObject amf;
    private static Boolean amg;
    private static Integer subType;

    public static boolean isEnabled() {
        return (ame == null || ame.status.equalsIgnoreCase("disabled")) ? false : true;
    }

    public static boolean Gc() {
        if (!isEnabled()) {
            return false;
        }
        if (amg == null) {
            Ge();
            if (amf == null) {
                amg = Boolean.valueOf(false);
            } else {
                amg = Boolean.valueOf(amf.get("menu").getAsBoolean());
            }
        }
        return amg.booleanValue();
    }

    public static int Gd() {
        if (!isEnabled()) {
            return 1;
        }
        if (subType == null) {
            Ge();
            if (amf == null) {
                subType = Integer.valueOf(1);
            } else {
                subType = Integer.valueOf(amf.get("subtype").getAsInt());
            }
        }
        return subType.intValue();
    }

    private static void Ge() {
        JsonElement jsonElement = ame.params;
        if (jsonElement != null && jsonElement.isJsonObject()) {
            jsonElement = jsonElement.getAsJsonObject().get(ame.status);
            if (jsonElement.isJsonObject()) {
                amf = jsonElement.getAsJsonObject();
            }
        }
    }
}
