package com.iqoption.core.microservices.billing.response.extraparams;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.android.gms.plus.PlusShare;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.iqoption.core.microservices.billing.response.extraparams.ExtraParamProperty.PropertyType;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u0017\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J-\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\t\u0010\u0016\u001a\u00020\rHÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\rHÖ\u0001R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u001e"}, aXE = {"Lcom/iqoption/core/microservices/billing/response/extraparams/ExtraParamSelectProperty;", "Lcom/iqoption/core/microservices/billing/response/extraparams/ExtraParamProperty;", "_title", "", "values", "", "(Ljava/lang/String;Ljava/util/Map;)V", "getValues", "()Ljava/util/Map;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "getTitle", "getType", "Lcom/iqoption/core/microservices/billing/response/extraparams/ExtraParamProperty$PropertyType;", "getTypeName", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "core_release"})
/* compiled from: ExtraParamSelectProperty.kt */
public final class c implements ExtraParamProperty {
    public static final Creator CREATOR = new c();
    private static final String TAG = "com.iqoption.core.microservices.billing.response.extraparams.c";
    private static final Type aUg = new b().getType();
    public static final a aUh = new a();
    private final String _title;
    private final Map<String, String> values;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eR\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00070\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, aXE = {"Lcom/iqoption/core/microservices/billing/response/extraparams/ExtraParamSelectProperty$Companion;", "", "()V", "MAP_TYPE", "Ljava/lang/reflect/Type;", "kotlin.jvm.PlatformType", "TAG", "", "TYPE_NAME", "fromJson", "Lcom/iqoption/core/microservices/billing/response/extraparams/ExtraParamSelectProperty;", "jsonObject", "Lcom/google/gson/JsonObject;", "context", "Lcom/google/gson/JsonDeserializationContext;", "core_release"})
    /* compiled from: ExtraParamSelectProperty.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final c c(JsonObject jsonObject, JsonDeserializationContext jsonDeserializationContext) {
            h.e(jsonDeserializationContext, "context");
            if (jsonObject != null && jsonObject.has(Param.TYPE) && jsonObject.has("values")) {
                JsonElement jsonElement = jsonObject.get("values");
                h.d(jsonElement, "jsonObject.get(\"values\")");
                if (jsonElement.isJsonObject()) {
                    String asString;
                    Map map;
                    if (jsonObject.has(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE)) {
                        jsonElement = jsonObject.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
                        h.d(jsonElement, "jsonObject.get(\"title\")");
                        asString = jsonElement.getAsString();
                    } else {
                        asString = null;
                    }
                    Map map2 = (Map) null;
                    try {
                        JsonElement jsonElement2 = jsonObject.get("values");
                        h.d(jsonElement2, "jsonSelectElement");
                        if (jsonElement2.isJsonObject()) {
                            map = (Map) jsonDeserializationContext.deserialize(jsonElement2, c.aUg);
                            return new c(asString, map);
                        }
                    } catch (Exception e) {
                        String Ki = c.TAG;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("unable to parse select property ");
                        stringBuilder.append(jsonObject);
                        com.iqoption.core.i.e(Ki, stringBuilder.toString(), e);
                    }
                    map = map2;
                    return new c(asString, map);
                }
            }
            return null;
        }
    }

    @i(aXC = {1, 1, 11})
    public static class c implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            Map linkedHashMap;
            h.e(parcel, "in");
            String readString = parcel.readString();
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                linkedHashMap = new LinkedHashMap(readInt);
                while (readInt != 0) {
                    linkedHashMap.put(parcel.readString(), parcel.readString());
                    readInt--;
                }
            } else {
                linkedHashMap = null;
            }
            return new c(readString, linkedHashMap);
        }

        public final Object[] newArray(int i) {
            return new c[i];
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, aXE = {"com/iqoption/core/microservices/billing/response/extraparams/ExtraParamSelectProperty$Companion$MAP_TYPE$1", "Lcom/google/gson/reflect/TypeToken;", "", "", "core_release"})
    /* compiled from: ExtraParamSelectProperty.kt */
    public static final class b extends TypeToken<Map<String, ? extends String>> {
        b() {
        }
    }

    public int describeContents() {
        return 0;
    }

    /* JADX WARNING: Missing block: B:6:0x001a, code:
            if (kotlin.jvm.internal.h.E(r2.values, r3.values) != false) goto L_0x001f;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x001f;
    L_0x0002:
        r0 = r3 instanceof com.iqoption.core.microservices.billing.response.extraparams.c;
        if (r0 == 0) goto L_0x001d;
    L_0x0006:
        r3 = (com.iqoption.core.microservices.billing.response.extraparams.c) r3;
        r0 = r2._title;
        r1 = r3._title;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x001d;
    L_0x0012:
        r0 = r2.values;
        r3 = r3.values;
        r3 = kotlin.jvm.internal.h.E(r0, r3);
        if (r3 == 0) goto L_0x001d;
    L_0x001c:
        goto L_0x001f;
    L_0x001d:
        r3 = 0;
        return r3;
    L_0x001f:
        r3 = 1;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.microservices.billing.response.extraparams.c.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this._title;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Map map = this.values;
        if (map != null) {
            i = map.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ExtraParamSelectProperty(_title=");
        stringBuilder.append(this._title);
        stringBuilder.append(", values=");
        stringBuilder.append(this.values);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        h.e(parcel, "parcel");
        parcel.writeString(this._title);
        Map map = this.values;
        if (map != null) {
            parcel.writeInt(1);
            parcel.writeInt(map.size());
            for (Entry next : map.entrySet()) {
                parcel.writeString((String) next.getKey());
                parcel.writeString((String) next.getValue());
            }
            return;
        }
        parcel.writeInt(0);
    }

    public c(String str, Map<String, String> map) {
        this._title = str;
        this.values = map;
    }

    public final Map<String, String> Vk() {
        return this.values;
    }

    public PropertyType Vh() {
        return PropertyType.selectType;
    }

    public String getTitle() {
        return this._title;
    }
}
