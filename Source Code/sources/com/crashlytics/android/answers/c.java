package com.crashlytics.android.answers;

import java.util.Map;
import org.json.JSONObject;

/* compiled from: AnswersAttributes */
class c {
    final Map<String, Object> attributes;

    public String toString() {
        return new JSONObject(this.attributes).toString();
    }
}
