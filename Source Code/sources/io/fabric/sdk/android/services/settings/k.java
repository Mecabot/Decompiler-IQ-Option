package io.fabric.sdk.android.services.settings;

import android.support.v4.app.NotificationCompat;
import com.google.android.gms.plus.PlusShare;
import com.iqoption.dto.ChartTimeInterval;
import io.fabric.sdk.android.services.common.j;
import org.json.JSONObject;

/* compiled from: DefaultSettingsJsonTransform */
class k implements u {
    k() {
    }

    public s a(j jVar, JSONObject jSONObject) {
        int optInt = jSONObject.optInt("settings_version", 0);
        int optInt2 = jSONObject.optInt("cache_duration", ChartTimeInterval.CANDLE_1H);
        return new s(a(jVar, (long) optInt2, jSONObject), p(jSONObject.getJSONObject("app")), t(jSONObject.getJSONObject("session")), u(jSONObject.getJSONObject("prompt")), r(jSONObject.getJSONObject("features")), s(jSONObject.getJSONObject("analytics")), v(jSONObject.getJSONObject("beta")), optInt, optInt2);
    }

    private e p(JSONObject jSONObject) {
        String string = jSONObject.getString("identifier");
        String string2 = jSONObject.getString(NotificationCompat.CATEGORY_STATUS);
        String string3 = jSONObject.getString(PlusShare.KEY_CALL_TO_ACTION_URL);
        String string4 = jSONObject.getString("reports_url");
        String string5 = jSONObject.getString("ndk_reports_url");
        boolean optBoolean = jSONObject.optBoolean("update_required", false);
        c q = (jSONObject.has("icon") && jSONObject.getJSONObject("icon").has("hash")) ? q(jSONObject.getJSONObject("icon")) : null;
        return new e(string, string2, string3, string4, string5, optBoolean, q);
    }

    private c q(JSONObject jSONObject) {
        return new c(jSONObject.getString("hash"), jSONObject.getInt("width"), jSONObject.getInt("height"));
    }

    private m r(JSONObject jSONObject) {
        return new m(jSONObject.optBoolean("prompt_enabled", false), jSONObject.optBoolean("collect_logged_exceptions", true), jSONObject.optBoolean("collect_reports", true), jSONObject.optBoolean("collect_analytics", false), jSONObject.optBoolean("firebase_crashlytics_enabled", false));
    }

    private b s(JSONObject jSONObject) {
        return new b(jSONObject.optString(PlusShare.KEY_CALL_TO_ACTION_URL, "https://e.crashlytics.com/spi/v2/events"), jSONObject.optInt("flush_interval_secs", 600), jSONObject.optInt("max_byte_size_per_file", 8000), jSONObject.optInt("max_file_count_per_send", 1), jSONObject.optInt("max_pending_send_file_count", 100), jSONObject.optBoolean("forward_to_google_analytics", false), jSONObject.optBoolean("include_purchase_events_in_forwarded_events", false), jSONObject.optBoolean("track_custom_events", true), jSONObject.optBoolean("track_predefined_events", true), jSONObject.optInt("sampling_rate", 1), jSONObject.optBoolean("flush_on_background", true));
    }

    private p t(JSONObject jSONObject) {
        return new p(jSONObject.optInt("log_buffer_size", 64000), jSONObject.optInt("max_chained_exception_depth", 8), jSONObject.optInt("max_custom_exception_events", 64), jSONObject.optInt("max_custom_key_value_pairs", 64), jSONObject.optInt("identifier_mask", 255), jSONObject.optBoolean("send_session_without_crash", false), jSONObject.optInt("max_complete_sessions_count", 4));
    }

    private o u(JSONObject jSONObject) {
        return new o(jSONObject.optString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, "Send Crash Report?"), jSONObject.optString("message", "Looks like we crashed! Please help us fix the problem by sending a crash report."), jSONObject.optString("send_button_title", "Send"), jSONObject.optBoolean("show_cancel_button", true), jSONObject.optString("cancel_button_title", "Don't Send"), jSONObject.optBoolean("show_always_send_button", true), jSONObject.optString("always_send_button_title", "Always Send"));
    }

    private f v(JSONObject jSONObject) {
        return new f(jSONObject.optString("update_endpoint", t.epS), jSONObject.optInt("update_suspend_duration", ChartTimeInterval.CANDLE_1H));
    }

    private long a(j jVar, long j, JSONObject jSONObject) {
        if (jSONObject.has("expires_at")) {
            return jSONObject.getLong("expires_at");
        }
        return jVar.aUE() + (j * 1000);
    }
}
