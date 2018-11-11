package com.iqoption.core.microservices.core;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "Lcom/google/gson/JsonObject;", "kotlin.jvm.PlatformType", "it", "", "invoke"})
/* compiled from: CoreRequests.kt */
final class CoreRequests$getTerms$1 extends Lambda implements b<String, JsonObject> {
    public static final CoreRequests$getTerms$1 aVA = new CoreRequests$getTerms$1();

    CoreRequests$getTerms$1() {
        super(1);
    }

    /* renamed from: gF */
    public final JsonObject invoke(String str) {
        h.e(str, "it");
        JsonElement parse = new JsonParser().parse(str);
        h.d(parse, "JsonParser().parse(it)");
        return parse.getAsJsonObject();
    }
}
