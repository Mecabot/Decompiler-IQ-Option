package com.iqoption.core.ext;

import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import com.iqoption.core.f;
import java.lang.reflect.Type;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a\u0011\u0010\u000e\u001a\u00020\u000f\"\u0006\b\u0000\u0010\u0010\u0018\u0001H\b\u001a&\u0010\u0011\u001a\u0004\u0018\u0001H\u0010\"\u0006\b\u0000\u0010\u0010\u0018\u0001*\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\b¢\u0006\u0002\u0010\u0015\u001a)\u0010\u0011\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u0010*\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0017\u001a&\u0010\u0011\u001a\u0004\u0018\u0001H\u0010\"\u0006\b\u0000\u0010\u0010\u0018\u0001*\u00020\u00182\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\b¢\u0006\u0002\u0010\u0019\u001a)\u0010\u0011\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u0010*\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u001a\u001a&\u0010\u0011\u001a\u0004\u0018\u0001H\u0010\"\u0006\b\u0000\u0010\u0010\u0018\u0001*\u00020\u001b2\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\b¢\u0006\u0002\u0010\u001c\u001a)\u0010\u0011\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u0010*\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u001d\u001a&\u0010\u001e\u001a\u0004\u0018\u0001H\u0010\"\u0006\b\u0000\u0010\u0010\u0018\u0001*\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\b¢\u0006\u0002\u0010\u0015\u001a/\u0010\u001e\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u0010*\u00020\u00122\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u00100 2\b\b\u0002\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010!\u001a&\u0010\u001e\u001a\u0004\u0018\u0001H\u0010\"\u0006\b\u0000\u0010\u0010\u0018\u0001*\u00020\u00182\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\b¢\u0006\u0002\u0010\u0019\u001a/\u0010\u001e\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u0010*\u00020\u00182\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u00100 2\b\b\u0002\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\"\u001a&\u0010\u001e\u001a\u0004\u0018\u0001H\u0010\"\u0006\b\u0000\u0010\u0010\u0018\u0001*\u00020\u001b2\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\b¢\u0006\u0002\u0010\u001c\u001a/\u0010\u001e\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u0010*\u00020\u001b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u00100 2\b\b\u0002\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010#\u001a\n\u0010$\u001a\u00020\u0018*\u00020\u001b\u001a\u001e\u0010$\u001a\u00020%*\u00020\u001b2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020%0'\u001a\u001c\u0010(\u001a\u00020\u0005*\u00020\u00052\u0006\u0010)\u001a\u00020\u00052\b\b\u0002\u0010*\u001a\u00020\t\u001a\u001c\u0010+\u001a\u00020,*\u0004\u0018\u00010\u00012\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020,\u001a\u001c\u00100\u001a\u000201*\u0004\u0018\u00010\u00012\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000201\u001a\u001c\u00102\u001a\u00020.*\u0004\u0018\u00010\u00012\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.\u001a\u001c\u00103\u001a\u00020\u001b*\u0004\u0018\u00010\u00012\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u001b\u001a\u001c\u00104\u001a\u00020,*\u00020\u00052\u0006\u00105\u001a\u00020\u001b2\b\b\u0002\u0010/\u001a\u00020,\u001a\u001c\u00106\u001a\u00020.*\u00020\u00052\u0006\u00105\u001a\u00020\u001b2\b\b\u0002\u0010/\u001a\u00020.\u001a\u001c\u00107\u001a\u000201*\u00020\u00052\u0006\u00105\u001a\u00020\u001b2\b\b\u0002\u0010/\u001a\u000201\u001a6\u00108\u001a\u0002H\u0010\"\u0010\b\u0000\u0010\u0010\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u001009*\u00020\u00052\u0006\u00105\u001a\u00020\u001b2\b\b\u0002\u0010/\u001a\u0002H\u0010H\b¢\u0006\u0002\u0010:\u001a\u001c\u0010;\u001a\u00020<*\u00020\u00052\u0006\u00105\u001a\u00020\u001b2\b\b\u0002\u0010/\u001a\u00020<\u001a\u001c\u0010=\u001a\u00020.*\u00020\u00052\u0006\u00105\u001a\u00020\u001b2\b\b\u0002\u0010/\u001a\u00020.\u001a\u001c\u0010>\u001a\u00020\u0001*\u00020\u00052\u0006\u00105\u001a\u00020\u001b2\b\b\u0002\u0010/\u001a\u00020\u0001\u001a\u001c\u0010?\u001a\u00020\u0005*\u00020\u00052\u0006\u00105\u001a\u00020\u001b2\b\b\u0002\u0010/\u001a\u00020\u0005\u001a\u001c\u0010@\u001a\u00020A*\u00020\u00052\u0006\u00105\u001a\u00020\u001b2\b\b\u0002\u0010/\u001a\u00020A\u001a%\u0010B\u001a\u0004\u0018\u00010,*\u00020\u00052\u0006\u00105\u001a\u00020\u001b2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010,¢\u0006\u0002\u0010C\u001a:\u0010D\u001a\u0004\u0018\u0001H\u0010\"\u0010\b\u0000\u0010\u0010\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u001009*\u00020\u00052\u0006\u00105\u001a\u00020\u001b2\n\b\u0002\u0010/\u001a\u0004\u0018\u0001H\u0010H\b¢\u0006\u0002\u0010:\u001a%\u0010E\u001a\u0004\u0018\u00010.*\u00020\u00052\u0006\u00105\u001a\u00020\u001b2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010.¢\u0006\u0002\u0010F\u001a \u0010G\u001a\u0004\u0018\u00010\u0001*\u00020\u00052\u0006\u00105\u001a\u00020\u001b2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0001\u001a \u0010H\u001a\u0004\u0018\u00010\u0005*\u00020\u00052\u0006\u00105\u001a\u00020\u001b2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0005\u001a%\u0010I\u001a\u0004\u0018\u00010A*\u00020\u00052\u0006\u00105\u001a\u00020\u001b2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010A¢\u0006\u0002\u0010J\u001a \u0010K\u001a\u0004\u0018\u00010\u001b*\u00020\u00052\u0006\u00105\u001a\u00020\u001b2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u001b\u001a\u001c\u0010L\u001a\u00020\u001b*\u00020\u00052\u0006\u00105\u001a\u00020\u001b2\b\b\u0002\u0010/\u001a\u00020\u001b\u001a$\u0010M\u001a\u0002H\u0010\"\u0006\b\u0000\u0010\u0010\u0018\u0001*\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\b¢\u0006\u0002\u0010\u0015\u001a'\u0010M\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0010*\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0017\u001a$\u0010M\u001a\u0002H\u0010\"\u0006\b\u0000\u0010\u0010\u0018\u0001*\u00020\u00182\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\b¢\u0006\u0002\u0010\u0019\u001a'\u0010M\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0010*\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u001a\u001a$\u0010M\u001a\u0002H\u0010\"\u0006\b\u0000\u0010\u0010\u0018\u0001*\u00020\u001b2\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\b¢\u0006\u0002\u0010\u001c\u001a'\u0010M\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0010*\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u001d\u001a$\u0010N\u001a\u0002H\u0010\"\u0006\b\u0000\u0010\u0010\u0018\u0001*\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\b¢\u0006\u0002\u0010\u0015\u001a-\u0010N\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0010*\u00020\u00122\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u00100 2\b\b\u0002\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010!\u001a$\u0010N\u001a\u0002H\u0010\"\u0006\b\u0000\u0010\u0010\u0018\u0001*\u00020\u00182\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\b¢\u0006\u0002\u0010\u0019\u001a-\u0010N\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0010*\u00020\u00182\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u00100 2\b\b\u0002\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\"\u001a$\u0010N\u001a\u0002H\u0010\"\u0006\b\u0000\u0010\u0010\u0018\u0001*\u00020\u001b2\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\b¢\u0006\u0002\u0010\u001c\u001a-\u0010N\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0010*\u00020\u001b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u00100 2\b\b\u0002\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010#\u001a\u0016\u0010O\u001a\u00020\u001b*\u0004\u0018\u00010P2\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u001a\u0016\u0010Q\u001a\u00020\u0001*\u0004\u0018\u00010P2\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u001a\u0016\u0010R\u001a\u00020\u0005*\u0004\u0018\u00010P2\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u001a\u0016\u0010S\u001a\u00020\u0012*\u0004\u0018\u00010P2\b\b\u0002\u0010\u0013\u001a\u00020\u0014\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006T"}, aXE = {"EMPTY_JSON_ARRAY", "Lcom/google/gson/JsonArray;", "getEMPTY_JSON_ARRAY", "()Lcom/google/gson/JsonArray;", "EMPTY_JSON_OBJECT", "Lcom/google/gson/JsonObject;", "getEMPTY_JSON_OBJECT", "()Lcom/google/gson/JsonObject;", "KEEP", "Lcom/iqoption/core/ext/ConflictResolver;", "getKEEP", "()Lcom/iqoption/core/ext/ConflictResolver;", "OVERWRITE", "getOVERWRITE", "typeOf", "Ljava/lang/reflect/Type;", "T", "fromGson", "Lcom/google/gson/JsonElement;", "gson", "Lcom/google/gson/Gson;", "(Lcom/google/gson/JsonElement;Lcom/google/gson/Gson;)Ljava/lang/Object;", "type", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/Gson;)Ljava/lang/Object;", "Lcom/google/gson/stream/JsonReader;", "(Lcom/google/gson/stream/JsonReader;Lcom/google/gson/Gson;)Ljava/lang/Object;", "(Lcom/google/gson/stream/JsonReader;Ljava/lang/reflect/Type;Lcom/google/gson/Gson;)Ljava/lang/Object;", "", "(Ljava/lang/String;Lcom/google/gson/Gson;)Ljava/lang/Object;", "(Ljava/lang/String;Ljava/lang/reflect/Type;Lcom/google/gson/Gson;)Ljava/lang/Object;", "fromJson", "cls", "Ljava/lang/Class;", "(Lcom/google/gson/JsonElement;Ljava/lang/Class;Lcom/google/gson/Gson;)Ljava/lang/Object;", "(Lcom/google/gson/stream/JsonReader;Ljava/lang/Class;Lcom/google/gson/Gson;)Ljava/lang/Object;", "(Ljava/lang/String;Ljava/lang/Class;Lcom/google/gson/Gson;)Ljava/lang/Object;", "jsonReader", "", "block", "Lkotlin/Function1;", "merge", "another", "conflictResolver", "optAsBoolean", "", "i", "", "defVal", "optAsDouble", "", "optAsInt", "optAsString", "optBoolean", "key", "optColor", "optDouble", "optEnum", "", "(Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/Enum;)Ljava/lang/Enum;", "optFloat", "", "optInt", "optJsonArray", "optJsonObject", "optLong", "", "optNullableBoolean", "(Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/Boolean;)Ljava/lang/Boolean;", "optNullableEnum", "optNullableInt", "(Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/Integer;)Ljava/lang/Integer;", "optNullableJsonArray", "optNullableJsonObject", "optNullableLong", "(Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/Long;)Ljava/lang/Long;", "optNullableString", "optString", "parseGson", "parseJson", "toJson", "", "toJsonArray", "toJsonObject", "toJsonTree", "core_release"})
/* compiled from: GsonExtensions.kt */
public final class d {
    private static final JsonObject aPp = new JsonObject();
    private static final JsonArray aPq = new JsonArray();
    private static final b aPr = new a();
    private static final b aPs = new b();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0016¨\u0006\b"}, aXE = {"com/iqoption/core/ext/GsonExtensionsKt$KEEP$1", "Lcom/iqoption/core/ext/ConflictResolver;", "resolve", "Lcom/google/gson/JsonElement;", "key", "", "src", "dst", "core_release"})
    /* compiled from: GsonExtensions.kt */
    public static final class a implements b {
        a() {
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0016¨\u0006\b"}, aXE = {"com/iqoption/core/ext/GsonExtensionsKt$OVERWRITE$1", "Lcom/iqoption/core/ext/ConflictResolver;", "resolve", "Lcom/google/gson/JsonElement;", "key", "", "src", "dst", "core_release"})
    /* compiled from: GsonExtensions.kt */
    public static final class b implements b {
        b() {
        }
    }

    public static final JsonObject SX() {
        return aPp;
    }

    public static final String a(Object obj, Gson gson) {
        h.e(gson, "gson");
        String toJson = gson.toJson(obj);
        h.d(toJson, "gson.toJson(this)");
        return toJson;
    }

    public static /* synthetic */ String a(Object obj, Gson gson, int i, Object obj2) {
        if ((i & 1) != 0) {
            gson = f.RQ().Dq();
        }
        return a(obj, gson);
    }

    public static final JsonElement b(Object obj, Gson gson) {
        h.e(gson, "gson");
        JsonElement toJsonTree = gson.toJsonTree(obj);
        h.d(toJsonTree, "gson.toJsonTree(this)");
        return toJsonTree;
    }

    public static /* synthetic */ JsonElement b(Object obj, Gson gson, int i, Object obj2) {
        if ((i & 1) != 0) {
            gson = f.RQ().Dq();
        }
        return b(obj, gson);
    }

    public static final <T> T a(String str, Class<T> cls, Gson gson) {
        h.e(str, "$receiver");
        h.e(cls, "cls");
        h.e(gson, "gson");
        return gson.fromJson(str, (Class) cls);
    }

    public static final <T> T b(String str, Class<T> cls, Gson gson) {
        h.e(str, "$receiver");
        h.e(cls, "cls");
        h.e(gson, "gson");
        return gson.fromJson(str, (Class) cls);
    }

    public static final <T> T a(String str, Type type, Gson gson) {
        h.e(str, "$receiver");
        h.e(type, Param.TYPE);
        h.e(gson, "gson");
        return gson.fromJson(str, type);
    }

    public static final <T> T a(JsonElement jsonElement, Class<T> cls, Gson gson) {
        h.e(jsonElement, "$receiver");
        h.e(cls, "cls");
        h.e(gson, "gson");
        return gson.fromJson(jsonElement, (Class) cls);
    }

    public static final <T> T a(JsonReader jsonReader, Class<T> cls, Gson gson) {
        h.e(jsonReader, "$receiver");
        h.e(cls, "cls");
        h.e(gson, "gson");
        return gson.fromJson(jsonReader, (Type) cls);
    }

    public static final <T> T b(JsonReader jsonReader, Class<T> cls, Gson gson) {
        h.e(jsonReader, "$receiver");
        h.e(cls, "cls");
        h.e(gson, "gson");
        return gson.fromJson(jsonReader, (Type) cls);
    }

    public static final boolean a(JsonObject jsonObject, String str, boolean z) {
        h.e(jsonObject, "$receiver");
        h.e(str, "key");
        JsonElement jsonElement = jsonObject.get(str);
        if (jsonElement == null) {
            return z;
        }
        if (!jsonElement.isJsonPrimitive()) {
            jsonElement = null;
        }
        return jsonElement != null ? jsonElement.getAsBoolean() : z;
    }

    public static final Boolean a(JsonObject jsonObject, String str, Boolean bool) {
        h.e(jsonObject, "$receiver");
        h.e(str, "key");
        JsonElement jsonElement = jsonObject.get(str);
        if (jsonElement == null) {
            return bool;
        }
        if (!jsonElement.isJsonPrimitive()) {
            jsonElement = null;
        }
        return jsonElement != null ? Boolean.valueOf(jsonElement.getAsBoolean()) : bool;
    }

    public static final int a(JsonObject jsonObject, String str, int i) {
        h.e(jsonObject, "$receiver");
        h.e(str, "key");
        JsonElement jsonElement = jsonObject.get(str);
        if (jsonElement == null) {
            return i;
        }
        if (!jsonElement.isJsonPrimitive()) {
            jsonElement = null;
        }
        return jsonElement != null ? jsonElement.getAsInt() : i;
    }

    public static final Integer a(JsonObject jsonObject, String str, Integer num) {
        h.e(jsonObject, "$receiver");
        h.e(str, "key");
        JsonElement jsonElement = jsonObject.get(str);
        if (jsonElement == null) {
            return num;
        }
        if (!jsonElement.isJsonPrimitive()) {
            jsonElement = null;
        }
        return jsonElement != null ? Integer.valueOf(jsonElement.getAsInt()) : num;
    }

    public static final Long a(JsonObject jsonObject, String str, Long l) {
        h.e(jsonObject, "$receiver");
        h.e(str, "key");
        JsonElement jsonElement = jsonObject.get(str);
        if (jsonElement == null) {
            return l;
        }
        if (!jsonElement.isJsonPrimitive()) {
            jsonElement = null;
        }
        return jsonElement != null ? Long.valueOf(jsonElement.getAsLong()) : l;
    }

    public static final String a(JsonObject jsonObject, String str, String str2) {
        h.e(jsonObject, "$receiver");
        h.e(str, "key");
        JsonElement jsonElement = jsonObject.get(str);
        if (jsonElement != null) {
            if (!jsonElement.isJsonPrimitive()) {
                jsonElement = null;
            }
            if (jsonElement != null) {
                String asString = jsonElement.getAsString();
                if (asString != null) {
                    return asString;
                }
            }
        }
        return str2;
    }

    public static final JsonArray a(JsonObject jsonObject, String str, JsonArray jsonArray) {
        h.e(jsonObject, "$receiver");
        h.e(str, "key");
        h.e(jsonArray, "defVal");
        JsonElement jsonElement = jsonObject.get(str);
        if (jsonElement != null) {
            if (!jsonElement.isJsonArray()) {
                jsonElement = null;
            }
            if (jsonElement != null) {
                JsonArray asJsonArray = jsonElement.getAsJsonArray();
                if (asJsonArray != null) {
                    return asJsonArray;
                }
            }
        }
        return jsonArray;
    }

    public static final double a(JsonArray jsonArray, int i, double d) {
        if (jsonArray == null) {
            return d;
        }
        Double d2 = null;
        if (jsonArray.size() > i) {
            JsonElement jsonElement = jsonArray.get(i);
            if (jsonElement != null) {
                d2 = Double.valueOf(jsonElement.getAsDouble());
            }
        }
        return d2 != null ? d2.doubleValue() : d;
    }

    public static final int a(JsonArray jsonArray, int i, int i2) {
        if (jsonArray == null) {
            return i2;
        }
        Integer num = null;
        if (jsonArray.size() > i) {
            JsonElement jsonElement = jsonArray.get(i);
            if (jsonElement != null) {
                num = Integer.valueOf(jsonElement.getAsInt());
            }
        }
        return num != null ? num.intValue() : i2;
    }

    public static final String a(JsonArray jsonArray, int i, String str) {
        h.e(str, "defVal");
        if (jsonArray == null) {
            return str;
        }
        String str2 = null;
        if (jsonArray.size() > i) {
            JsonElement jsonElement = jsonArray.get(i);
            if (jsonElement != null) {
                str2 = jsonElement.getAsString();
            }
        }
        return str2 != null ? str2 : str;
    }
}
