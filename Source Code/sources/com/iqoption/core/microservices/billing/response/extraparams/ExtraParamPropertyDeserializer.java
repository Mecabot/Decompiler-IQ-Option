package com.iqoption.core.microservices.billing.response.extraparams;

import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0003J\"\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\u000f"}, aXE = {"Lcom/iqoption/core/microservices/billing/response/extraparams/ExtraParamPropertyDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lcom/iqoption/core/microservices/billing/response/extraparams/ExtraParamProperty;", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "deserializeProperty", "propertyObject", "Lcom/google/gson/JsonObject;", "Companion", "core_release"})
/* compiled from: ExtraParamPropertyDeserializer.kt */
public final class ExtraParamPropertyDeserializer implements JsonDeserializer<ExtraParamProperty> {
    private static final String TAG = "com.iqoption.core.microservices.billing.response.extraparams.ExtraParamPropertyDeserializer";
    public static final a aUf = new a();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, aXE = {"Lcom/iqoption/core/microservices/billing/response/extraparams/ExtraParamPropertyDeserializer$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "core_release"})
    /* compiled from: ExtraParamPropertyDeserializer.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* renamed from: a */
    public ExtraParamProperty deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        h.e(jsonElement, "json");
        h.e(type, "typeOfT");
        h.e(jsonDeserializationContext, "context");
        try {
            return b(jsonElement.getAsJsonObject(), jsonDeserializationContext);
        } catch (Exception e) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("error during deserialization property ");
            stringBuilder.append(jsonElement);
            com.iqoption.core.i.e(str, stringBuilder.toString(), e);
            return null;
        }
    }

    private final ExtraParamProperty b(JsonObject jsonObject, JsonDeserializationContext jsonDeserializationContext) {
        if (jsonObject != null && jsonObject.has(Param.TYPE)) {
            JsonElement jsonElement = jsonObject.get(Param.TYPE);
            String str = "";
            h.d(jsonElement, "jsonElement");
            if (jsonElement.isJsonPrimitive()) {
                str = jsonElement.getAsString();
                h.d(str, "jsonElement.asString");
            } else if (jsonElement.isJsonObject() && ((JsonObject) jsonElement).has("enum")) {
                str = "enum";
            }
            int hashCode = str.hashCode();
            if (hashCode != -906021636) {
                if (hashCode != -891985903) {
                    if (hashCode != 3118337) {
                        if (hashCode == 1958052158 && str.equals("integer")) {
                            return b.aUe.c(jsonObject);
                        }
                    } else if (str.equals("enum")) {
                        return a.aUd.a(jsonObject, jsonDeserializationContext);
                    }
                } else if (str.equals("string")) {
                    return d.aUj.d(jsonObject);
                }
            } else if (str.equals("select")) {
                return c.aUh.c(jsonObject, jsonDeserializationContext);
            }
            String str2 = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unsupported type ");
            stringBuilder.append(str);
            com.iqoption.core.i.e(str2, stringBuilder.toString());
        }
        return null;
    }
}
