package com.iqoption.dto;

import android.content.Context;
import com.iqoption.app.a;
import org.json.JSONObject;

public class SupportMessage {
    public boolean canBeRated;
    public Long created;
    public long id;
    public int rate;
    public String subject;
    public String text;
    private long userIdFrom;

    public SupportMessage(JSONObject jSONObject) {
        this.id = jSONObject.getLong("id");
        this.subject = jSONObject.getString("subject");
        this.text = jSONObject.getString("text");
        this.created = Long.valueOf(jSONObject.getLong("created") * 1000);
        this.userIdFrom = jSONObject.getLong("user_id_from");
        this.rate = jSONObject.optInt("mark", 0);
        this.canBeRated = jSONObject.optBoolean("can_be_rated", false);
    }

    public boolean isIncoming(Context context) {
        return this.userIdFrom != a.aL(context).getUserId();
    }
}
