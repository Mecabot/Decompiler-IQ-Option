package com.iqoption.dto;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import org.json.JSONObject;

public class Feed {
    public int amount;
    public String country;
    public long created;
    public String currency;
    public String direction;
    public String firstname;
    public String lastname;
    public long userId;
    public double value;

    public Feed(JSONObject jSONObject) {
        this.direction = jSONObject.getString("direction");
        this.amount = jSONObject.getInt("amount");
        this.currency = jSONObject.getString(b.CURRENCY);
        this.created = jSONObject.getLong("created") * 1000;
        this.value = jSONObject.getDouble(b.VALUE);
        this.userId = jSONObject.getLong("user_id");
        this.firstname = jSONObject.getString("user_firstname");
        this.lastname = jSONObject.getString("user_lastname");
        this.country = jSONObject.getString("country");
    }
}
