package com.iqoption.charttools.model.indicator;

import com.google.gson.JsonArray;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a#\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010\u0007¨\u0006\b"}, aXE = {"checkKeysAndValues", "", "keys", "", "", "values", "Lcom/google/gson/JsonArray;", "([Ljava/lang/String;Lcom/google/gson/JsonArray;)V", "techtools_release"})
/* compiled from: MetaIndicator.kt */
public final class y {
    private static final void a(String[] strArr, JsonArray jsonArray) {
        if (strArr.length != jsonArray.size()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("keys and values does not match: ");
            stringBuilder.append(strArr);
            stringBuilder.append(", ");
            stringBuilder.append(jsonArray);
            throw new IllegalStateException(stringBuilder.toString());
        }
    }
}
