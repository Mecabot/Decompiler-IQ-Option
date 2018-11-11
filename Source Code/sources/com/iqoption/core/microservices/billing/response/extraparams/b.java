package com.iqoption.core.microservices.billing.response.extraparams;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.android.gms.plus.PlusShare;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.iqoption.core.microservices.billing.response.extraparams.ExtraParamProperty.PropertyType;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u0015\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\n\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\t\u0010\u0011\u001a\u00020\bHÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\bHÖ\u0001R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, aXE = {"Lcom/iqoption/core/microservices/billing/response/extraparams/ExtraParamIntegerProperty;", "Lcom/iqoption/core/microservices/billing/response/extraparams/ExtraParamProperty;", "_title", "", "(Ljava/lang/String;)V", "component1", "copy", "describeContents", "", "equals", "", "other", "", "getTitle", "getType", "Lcom/iqoption/core/microservices/billing/response/extraparams/ExtraParamProperty$PropertyType;", "getTypeName", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "core_release"})
/* compiled from: ExtraParamIntegerProperty.kt */
public final class b implements ExtraParamProperty {
    public static final Creator CREATOR = new b();
    public static final a aUe = new a();
    private final String _title;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, aXE = {"Lcom/iqoption/core/microservices/billing/response/extraparams/ExtraParamIntegerProperty$Companion;", "", "()V", "TYPE_NAME", "", "fromJson", "Lcom/iqoption/core/microservices/billing/response/extraparams/ExtraParamIntegerProperty;", "jsonObject", "Lcom/google/gson/JsonObject;", "core_release"})
    /* compiled from: ExtraParamIntegerProperty.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final b c(JsonObject jsonObject) {
            String str = null;
            if (jsonObject != null && jsonObject.has(Param.TYPE)) {
                JsonElement jsonElement = jsonObject.get(Param.TYPE);
                h.d(jsonElement, "jsonObject.get(\"type\")");
                if (h.E("integer", jsonElement.getAsString())) {
                    if (jsonObject.has(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE)) {
                        JsonElement jsonElement2 = jsonObject.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
                        h.d(jsonElement2, "jsonObject.get(\"title\")");
                        str = jsonElement2.getAsString();
                    }
                    return new b(str);
                }
            }
            return null;
        }
    }

    @i(aXC = {1, 1, 11})
    public static class b implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            h.e(parcel, "in");
            return new b(parcel.readString());
        }

        public final Object[] newArray(int i) {
            return new b[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    /* JADX WARNING: Missing block: B:4:0x0010, code:
            if (kotlin.jvm.internal.h.E(r1._title, ((com.iqoption.core.microservices.billing.response.extraparams.b) r2)._title) != false) goto L_0x0015;
     */
    public boolean equals(java.lang.Object r2) {
        /*
        r1 = this;
        if (r1 == r2) goto L_0x0015;
    L_0x0002:
        r0 = r2 instanceof com.iqoption.core.microservices.billing.response.extraparams.b;
        if (r0 == 0) goto L_0x0013;
    L_0x0006:
        r2 = (com.iqoption.core.microservices.billing.response.extraparams.b) r2;
        r0 = r1._title;
        r2 = r2._title;
        r2 = kotlin.jvm.internal.h.E(r0, r2);
        if (r2 == 0) goto L_0x0013;
    L_0x0012:
        goto L_0x0015;
    L_0x0013:
        r2 = 0;
        return r2;
    L_0x0015:
        r2 = 1;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.microservices.billing.response.extraparams.b.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this._title;
        return str != null ? str.hashCode() : 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ExtraParamIntegerProperty(_title=");
        stringBuilder.append(this._title);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        h.e(parcel, "parcel");
        parcel.writeString(this._title);
    }

    public b(String str) {
        this._title = str;
    }

    public PropertyType Vh() {
        return PropertyType.integerType;
    }

    public String getTitle() {
        return this._title;
    }
}
