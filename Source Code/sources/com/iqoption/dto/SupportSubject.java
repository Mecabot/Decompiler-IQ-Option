package com.iqoption.dto;

import org.json.JSONObject;

public class SupportSubject {
    public int id;
    public String name;

    public SupportSubject(JSONObject jSONObject) {
        this.id = jSONObject.getInt("id");
        this.name = jSONObject.getString("name");
    }

    public String toString() {
        return this.name;
    }
}
