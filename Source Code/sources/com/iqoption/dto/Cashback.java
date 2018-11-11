package com.iqoption.dto;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import org.json.JSONObject;

public class Cashback {
    public boolean cashbackEnabled = false;
    public double collected;
    public double current;
    public double earned;
    public double high;
    public boolean isLastLevelNotified;
    public int level;
    public double willGet;

    public void asJson(JSONObject jSONObject) {
        this.cashbackEnabled = jSONObject.getBoolean("enabled");
        if (this.cashbackEnabled) {
            this.level = jSONObject.getInt(b.LEVEL);
            this.current = jSONObject.getDouble("cashback_in_progress");
            this.high = jSONObject.getDouble("cashback_this_level");
            this.collected = jSONObject.getDouble("cashback_on_balance");
            this.earned = jSONObject.getDouble("cashback_prev_level");
            this.willGet = jSONObject.getDouble("cashback_this_level");
            if (jSONObject.has("last_level_notified") && !jSONObject.getBoolean("last_level_notified")) {
                this.isLastLevelNotified = true;
            }
        }
    }
}
