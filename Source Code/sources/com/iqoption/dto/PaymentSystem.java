package com.iqoption.dto;

import org.json.JSONObject;

public class PaymentSystem {
    public String className;
    public String depositUrl;
    public int id;
    public boolean isFrame;
    public String name;

    public PaymentSystem(JSONObject jSONObject) {
        this.name = jSONObject.getString("name");
        this.depositUrl = jSONObject.getString("action");
        this.id = jSONObject.getJSONObject("fields").getInt("payment_method_id");
        boolean z = true;
        if (jSONObject.getInt("iframe") != 1) {
            z = false;
        }
        this.isFrame = z;
        this.className = jSONObject.getString("className");
    }

    public String toString() {
        return this.name != null ? this.name : "";
    }
}
