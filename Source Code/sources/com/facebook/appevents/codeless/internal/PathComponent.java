package com.facebook.appevents.codeless.internal;

import com.google.android.gms.plus.PlusShare;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import org.json.JSONObject;

public final class PathComponent {
    public final String Ah;
    public final int Ai;
    public final String className;
    public final String description;
    public final int id;
    public final int index;
    public final String tag;
    public final String text;

    public enum MatchBitmaskType {
        ID(1),
        TEXT(2),
        TAG(4),
        DESCRIPTION(8),
        HINT(16);
        
        private final int value;

        private MatchBitmaskType(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    PathComponent(JSONObject jSONObject) {
        this.className = jSONObject.getString("class_name");
        this.index = jSONObject.optInt(b.INDEX, -1);
        this.id = jSONObject.optInt("id");
        this.text = jSONObject.optString("text");
        this.tag = jSONObject.optString("tag");
        this.description = jSONObject.optString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION);
        this.Ah = jSONObject.optString("hint");
        this.Ai = jSONObject.optInt("match_bitmask");
    }
}
