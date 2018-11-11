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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u0011\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\t\u0010\r\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0006HÖ\u0001R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u001e"}, aXE = {"Lcom/iqoption/core/microservices/billing/response/extraparams/ExtraParamEnumProperty;", "Lcom/iqoption/core/microservices/billing/response/extraparams/ExtraParamProperty;", "_title", "", "enumValues", "", "", "(Ljava/lang/String;Ljava/util/List;)V", "getEnumValues", "()Ljava/util/List;", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "getTitle", "getType", "Lcom/iqoption/core/microservices/billing/response/extraparams/ExtraParamProperty$PropertyType;", "getTypeName", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "core_release"})
/* compiled from: ExtraParamEnumProperty.kt */
public final class a implements ExtraParamProperty {
    public static final Creator CREATOR = new c();
    private static final String TAG = "com.iqoption.core.microservices.billing.response.extraparams.a";
    private static final Type aUc = new b().getType();
    public static final a aUd = new a();
    private final String _title;
    private final List<Integer> aUb;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eR\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00070\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, aXE = {"Lcom/iqoption/core/microservices/billing/response/extraparams/ExtraParamEnumProperty$Companion;", "", "()V", "LIST_TYPE", "Ljava/lang/reflect/Type;", "kotlin.jvm.PlatformType", "TAG", "", "TYPE_NAME", "fromJson", "Lcom/iqoption/core/microservices/billing/response/extraparams/ExtraParamEnumProperty;", "jsonObject", "Lcom/google/gson/JsonObject;", "context", "Lcom/google/gson/JsonDeserializationContext;", "core_release"})
    /* compiled from: ExtraParamEnumProperty.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final a a(JsonObject jsonObject, JsonDeserializationContext jsonDeserializationContext) {
            h.e(jsonDeserializationContext, "context");
            if (jsonObject != null && jsonObject.has(Param.TYPE)) {
                JsonElement jsonElement = jsonObject.get(Param.TYPE);
                h.d(jsonElement, "jsonObject.get(\"type\")");
                if (jsonElement.isJsonObject()) {
                    jsonElement = jsonObject.get(Param.TYPE);
                    if (jsonElement == null) {
                        throw new TypeCastException("null cannot be cast to non-null type com.google.gson.JsonObject");
                    } else if (((JsonObject) jsonElement).has("enum")) {
                        String asString;
                        if (jsonObject.has(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE)) {
                            jsonElement = jsonObject.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
                            h.d(jsonElement, "jsonObject.get(\"title\")");
                            asString = jsonElement.getAsString();
                        } else {
                            asString = null;
                        }
                        List list = (List) null;
                        try {
                            JsonElement jsonElement2 = jsonObject.get(Param.TYPE);
                            if (jsonElement2 == null) {
                                throw new TypeCastException("null cannot be cast to non-null type com.google.gson.JsonObject");
                            }
                            List list2;
                            jsonElement2 = ((JsonObject) jsonElement2).get("enum");
                            h.d(jsonElement2, "jsonEnumElement");
                            if (jsonElement2.isJsonArray()) {
                                list2 = (List) jsonDeserializationContext.deserialize(jsonElement2, a.aUc);
                                return new a(asString, list2);
                            }
                            list2 = list;
                            return new a(asString, list2);
                        } catch (Exception e) {
                            String Ki = a.TAG;
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("unable to parse enum property ");
                            stringBuilder.append(jsonObject);
                            com.iqoption.core.i.e(Ki, stringBuilder.toString(), e);
                        }
                    }
                }
            }
            return null;
        }
    }

    @i(aXC = {1, 1, 11})
    public static class c implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            List arrayList;
            h.e(parcel, "in");
            String readString = parcel.readString();
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add(Integer.valueOf(parcel.readInt()));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            return new a(readString, arrayList);
        }

        public final Object[] newArray(int i) {
            return new a[i];
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, aXE = {"com/iqoption/core/microservices/billing/response/extraparams/ExtraParamEnumProperty$Companion$LIST_TYPE$1", "Lcom/google/gson/reflect/TypeToken;", "", "", "core_release"})
    /* compiled from: ExtraParamEnumProperty.kt */
    public static final class b extends TypeToken<List<? extends Integer>> {
        b() {
        }
    }

    public int describeContents() {
        return 0;
    }

    /* JADX WARNING: Missing block: B:6:0x001a, code:
            if (kotlin.jvm.internal.h.E(r2.aUb, r3.aUb) != false) goto L_0x001f;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x001f;
    L_0x0002:
        r0 = r3 instanceof com.iqoption.core.microservices.billing.response.extraparams.a;
        if (r0 == 0) goto L_0x001d;
    L_0x0006:
        r3 = (com.iqoption.core.microservices.billing.response.extraparams.a) r3;
        r0 = r2._title;
        r1 = r3._title;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x001d;
    L_0x0012:
        r0 = r2.aUb;
        r3 = r3.aUb;
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
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.microservices.billing.response.extraparams.a.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this._title;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List list = this.aUb;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ExtraParamEnumProperty(_title=");
        stringBuilder.append(this._title);
        stringBuilder.append(", enumValues=");
        stringBuilder.append(this.aUb);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        h.e(parcel, "parcel");
        parcel.writeString(this._title);
        Collection<Integer> collection = this.aUb;
        if (collection != null) {
            parcel.writeInt(1);
            parcel.writeInt(collection.size());
            for (Integer intValue : collection) {
                parcel.writeInt(intValue.intValue());
            }
            return;
        }
        parcel.writeInt(0);
    }

    public a(String str, List<Integer> list) {
        this._title = str;
        this.aUb = list;
    }

    public final List<Integer> Vi() {
        return this.aUb;
    }

    public PropertyType Vh() {
        return PropertyType.enumType;
    }

    public String getTitle() {
        return this._title;
    }
}
