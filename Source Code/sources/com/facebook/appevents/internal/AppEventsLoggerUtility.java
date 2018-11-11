package com.facebook.appevents.internal;

import android.content.Context;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.b;
import com.facebook.internal.q;
import com.facebook.internal.w;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class AppEventsLoggerUtility {
    private static final Map<GraphAPIActivityType, String> AB = new HashMap<GraphAPIActivityType, String>() {
        {
            put(GraphAPIActivityType.MOBILE_INSTALL_EVENT, "MOBILE_APP_INSTALL");
            put(GraphAPIActivityType.CUSTOM_APP_EVENTS, "CUSTOM_APP_EVENTS");
        }
    };

    public enum GraphAPIActivityType {
        MOBILE_INSTALL_EVENT,
        CUSTOM_APP_EVENTS
    }

    public static JSONObject a(GraphAPIActivityType graphAPIActivityType, b bVar, String str, boolean z, Context context) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("event", AB.get(graphAPIActivityType));
        String jX = AppEventsLogger.jX();
        if (jX != null) {
            jSONObject.put("app_user_id", jX);
        }
        jX = AppEventsLogger.km();
        if (jX != null) {
            jSONObject.put("ud", jX);
        }
        w.a(jSONObject, bVar, str, z);
        try {
            w.a(jSONObject, context);
        } catch (Exception e) {
            q.a(LoggingBehavior.APP_EVENTS, "AppEvents", "Fetching extended device info parameters failed: '%s'", e.toString());
        }
        jSONObject.put("application_package_name", context.getPackageName());
        return jSONObject;
    }
}
