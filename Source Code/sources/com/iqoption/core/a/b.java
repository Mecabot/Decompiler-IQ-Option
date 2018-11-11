package com.iqoption.core.a;

import com.google.gson.JsonObject;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0000\bf\u0018\u00002\u00020\u0001J#\u0010\u0002\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u0002H\u0004H&¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\rH&¨\u0006\u000e"}, aXE = {"Lcom/iqoption/core/analytics/AnalyticsPropertyEvent;", "Lcom/iqoption/core/analytics/AnalyticsSendEvent;", "addProperty", "", "T", "name", "", "value", "(Ljava/lang/String;Ljava/lang/Object;)V", "setProperty", "parameters", "Lcom/google/gson/JsonObject;", "setValue", "", "core_release"})
/* compiled from: AnalyticsPropertyEvent.kt */
public interface b extends d {
    void a(JsonObject jsonObject);

    void a(Number number);
}
