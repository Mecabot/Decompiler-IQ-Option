package com.iqoption.deposit.c;

import android.content.res.Resources;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.iqoption.core.f;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, aXE = {"Lcom/iqoption/deposit/util/DepositAnalyticUtils;", "", "()V", "getDepositScreenParams", "Lcom/google/gson/JsonObject;", "deposit_release"})
/* compiled from: DepositAnalyticUtils.kt */
public final class c {
    public static final c ceC = new c();

    private c() {
    }

    public final JsonObject aeh() {
        JsonObject jsonObject = new JsonObject();
        Resources resources = f.RR().getResources();
        h.d(resources, "appContext.resources");
        int i = 1;
        if (resources.getConfiguration().orientation == 1) {
            i = 0;
        }
        jsonObject.add("landscape", new JsonPrimitive((Number) Integer.valueOf(i)));
        return jsonObject;
    }
}
