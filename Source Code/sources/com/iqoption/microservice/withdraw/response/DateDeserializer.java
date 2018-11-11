package com.iqoption.microservice.withdraw.response;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import java.lang.reflect.Type;
import java.util.Date;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, aXE = {"Lcom/iqoption/microservice/withdraw/response/DateDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Ljava/util/Date;", "()V", "deserialize", "jsonElement", "Lcom/google/gson/JsonElement;", "typeOF", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: WithdrawPayout.kt */
final class DateDeserializer implements JsonDeserializer<Date> {
    /* renamed from: g */
    public Date deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        h.e(jsonElement, "jsonElement");
        h.e(type, "typeOF");
        h.e(jsonDeserializationContext, "context");
        Date parse = m.aKx.parse(jsonElement.getAsString());
        h.d(parse, "DATE_FORMATTER.parse(jsonElement.asString)");
        return parse;
    }
}
