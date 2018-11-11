package com.facebook.appevents;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.facebook.FacebookException;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.internal.b;
import com.facebook.internal.q;
import com.facebook.internal.w;
import java.io.Serializable;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONObject;

class AppEvent implements Serializable {
    private static final long serialVersionUID = 1;
    private static final HashSet<String> yX = new HashSet();
    private final String checksum;
    private final boolean isImplicit;
    private final JSONObject jsonObject;
    private final String name;

    static class SerializationProxyV1 implements Serializable {
        private static final long serialVersionUID = -2488473066578201069L;
        private final boolean isImplicit;
        private final String jsonString;

        private Object readResolve() {
            return new AppEvent(this.jsonString, this.isImplicit, null);
        }
    }

    static class SerializationProxyV2 implements Serializable {
        private static final long serialVersionUID = 20160803001L;
        private final String checksum;
        private final boolean isImplicit;
        private final String jsonString;

        private SerializationProxyV2(String str, boolean z, String str2) {
            this.jsonString = str;
            this.isImplicit = z;
            this.checksum = str2;
        }

        private Object readResolve() {
            return new AppEvent(this.jsonString, this.isImplicit, this.checksum);
        }
    }

    public AppEvent(String str, String str2, Double d, Bundle bundle, boolean z, @Nullable UUID uuid) {
        this.jsonObject = a(str, str2, d, bundle, z, uuid);
        this.isImplicit = z;
        this.name = str2;
        this.checksum = kb();
    }

    public String getName() {
        return this.name;
    }

    private AppEvent(String str, boolean z, String str2) {
        this.jsonObject = new JSONObject(str);
        this.isImplicit = z;
        this.name = this.jsonObject.optString("_eventName");
        this.checksum = str2;
    }

    public boolean jZ() {
        return this.isImplicit;
    }

    public JSONObject jK() {
        return this.jsonObject;
    }

    public boolean ka() {
        if (this.checksum == null) {
            return true;
        }
        return kb().equals(this.checksum);
    }

    private static void bo(String str) {
        if (str == null || str.length() == 0 || str.length() > 40) {
            if (str == null) {
                str = "<None Provided>";
            }
            throw new FacebookException(String.format(Locale.ROOT, "Identifier '%s' must be less than %d characters", new Object[]{str, Integer.valueOf(40)}));
        }
        boolean contains;
        synchronized (yX) {
            contains = yX.contains(str);
        }
        if (!contains) {
            if (str.matches("^[0-9a-zA-Z_]+[0-9a-zA-Z _-]*$")) {
                synchronized (yX) {
                    yX.add(str);
                }
                return;
            }
            throw new FacebookException(String.format("Skipping event named '%s' due to illegal name - must be under 40 chars and alphanumeric, _, - or space, and not start with a space or hyphen.", new Object[]{str}));
        }
    }

    private static JSONObject a(String str, String str2, Double d, Bundle bundle, boolean z, @Nullable UUID uuid) {
        bo(str2);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("_eventName", str2);
        jSONObject.put("_eventName_md5", bp(str2));
        jSONObject.put("_logTime", System.currentTimeMillis() / 1000);
        jSONObject.put("_ui", str);
        if (uuid != null) {
            jSONObject.put("_session_id", uuid);
        }
        if (d != null) {
            jSONObject.put("_valueToSum", d.doubleValue());
        }
        if (z) {
            jSONObject.put("_implicitlyLogged", "1");
        }
        if (bundle != null) {
            for (String str3 : bundle.keySet()) {
                bo(str3);
                Object obj = bundle.get(str3);
                if ((obj instanceof String) || (obj instanceof Number)) {
                    jSONObject.put(str3, obj.toString());
                } else {
                    throw new FacebookException(String.format("Parameter value '%s' for key '%s' should be a string or a numeric type.", new Object[]{obj, str3}));
                }
            }
        }
        if (!z) {
            q.a(LoggingBehavior.APP_EVENTS, "AppEvents", "Created app event '%s'", jSONObject.toString());
        }
        return jSONObject;
    }

    private Object writeReplace() {
        return new SerializationProxyV2(this.jsonObject.toString(), this.isImplicit, this.checksum);
    }

    public String toString() {
        return String.format("\"%s\", implicit: %b, json: %s", new Object[]{this.jsonObject.optString("_eventName"), Boolean.valueOf(this.isImplicit), this.jsonObject.toString()});
    }

    private String kb() {
        if (VERSION.SDK_INT > 19) {
            return bp(this.jsonObject.toString());
        }
        Object arrayList = new ArrayList();
        Iterator keys = this.jsonObject.keys();
        while (keys.hasNext()) {
            arrayList.add(keys.next());
        }
        Collections.sort(arrayList);
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            stringBuilder.append(str);
            stringBuilder.append(" = ");
            stringBuilder.append(this.jsonObject.optString(str));
            stringBuilder.append(10);
        }
        return bp(stringBuilder.toString());
    }

    private static String bp(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            byte[] bytes = str.getBytes("UTF-8");
            instance.update(bytes, 0, bytes.length);
            return b.k(instance.digest());
        } catch (Exception e) {
            w.a("Failed to generate checksum: ", e);
            return "0";
        } catch (Exception e2) {
            w.a("Failed to generate checksum: ", e2);
            return "1";
        }
    }
}
