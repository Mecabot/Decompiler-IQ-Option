package com.jumio.analytics;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import java.util.Map;
import org.json.JSONObject;

public class Payload<T> {
    private MetaInfo mMetaInfo;
    private T mValue;

    public Payload(T t, MetaInfo metaInfo) {
        this.mValue = t;
        this.mMetaInfo = metaInfo;
    }

    public MetaInfo getMetaInfo() {
        return this.mMetaInfo;
    }

    public T getValue() {
        return this.mValue;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        if (this.mValue instanceof Map) {
            jSONObject.put(b.VALUE, new JSONObject((Map) this.mValue));
        } else {
            jSONObject.put(b.VALUE, this.mValue);
        }
        if (this.mMetaInfo != null && this.mMetaInfo.size() > 0) {
            jSONObject.put("metainfo", new JSONObject(this.mMetaInfo));
        }
        return jSONObject;
    }
}
