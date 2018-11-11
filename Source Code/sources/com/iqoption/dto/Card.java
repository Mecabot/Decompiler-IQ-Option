package com.iqoption.dto;

import com.google.android.gms.measurement.AppMeasurement.Param;
import org.json.JSONObject;

public class Card extends PaymentSystem {
    public static final String ONE_TAP_PAYMENT = "one-tap-payment";
    public String number;
    public String type;

    public Card(JSONObject jSONObject) {
        this.type = jSONObject.getString(Param.TYPE);
        this.id = jSONObject.getInt("id");
        this.number = jSONObject.getString("number");
        this.className = ONE_TAP_PAYMENT;
    }

    public String toString() {
        if (this.number == null || this.type == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.type);
        stringBuilder.append(" ");
        stringBuilder.append(this.number);
        return stringBuilder.toString();
    }
}
