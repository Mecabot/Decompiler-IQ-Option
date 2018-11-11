package com.iqoption.core.microservices.risks.response.overnightfee;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.iqoption.core.ext.d;
import java.util.HashMap;
import java.util.TimeZone;
import kotlin.i;
import kotlin.jvm.internal.h;

@JsonAdapter(a.class)
@i(aXC = {1, 1, 11}, aXD = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0011B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\u0015\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u001f\u0010\n\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u0004HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, aXE = {"Lcom/iqoption/core/microservices/risks/response/overnightfee/OvernightFeeResult;", "", "data", "Ljava/util/HashMap;", "", "Lcom/iqoption/core/microservices/risks/response/overnightfee/OvernightFeeMap;", "(Ljava/util/HashMap;)V", "getData", "()Ljava/util/HashMap;", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "Adapter", "core_release"})
/* compiled from: OvernightFeeResult.kt */
public final class e {
    private final HashMap<Integer, d> aXJ;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¨\u0006\f"}, aXE = {"Lcom/iqoption/core/microservices/risks/response/overnightfee/OvernightFeeResult$Adapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/iqoption/core/microservices/risks/response/overnightfee/OvernightFeeResult;", "()V", "read", "reader", "Lcom/google/gson/stream/JsonReader;", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", "value", "core_release"})
    /* compiled from: OvernightFeeResult.kt */
    public static final class a extends TypeAdapter<e> {
        /* renamed from: a */
        public void write(JsonWriter jsonWriter, e eVar) {
            h.e(jsonWriter, "out");
            h.e(eVar, b.VALUE);
            jsonWriter.jsonValue(d.a(eVar, null, 1, null));
        }

        /* renamed from: k */
        public e read(JsonReader jsonReader) {
            h.e(jsonReader, "reader");
            e eVar = new e(new HashMap());
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                if (h.E(jsonReader.nextName(), "items")) {
                    TimeZone timeZone = TimeZone.getDefault();
                    h.d(timeZone, "TimeZone.getDefault()");
                    long rawOffset = (long) timeZone.getRawOffset();
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        c cVar = (c) d.b(jsonReader, c.class, null, 2, null);
                        eVar.WM().put(Integer.valueOf(cVar.getActiveId()), cVar.aY(rawOffset));
                    }
                    jsonReader.endArray();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            return eVar;
        }
    }

    /* JADX WARNING: Missing block: B:4:0x0010, code:
            if (kotlin.jvm.internal.h.E(r1.aXJ, ((com.iqoption.core.microservices.risks.response.overnightfee.e) r2).aXJ) != false) goto L_0x0015;
     */
    public boolean equals(java.lang.Object r2) {
        /*
        r1 = this;
        if (r1 == r2) goto L_0x0015;
    L_0x0002:
        r0 = r2 instanceof com.iqoption.core.microservices.risks.response.overnightfee.e;
        if (r0 == 0) goto L_0x0013;
    L_0x0006:
        r2 = (com.iqoption.core.microservices.risks.response.overnightfee.e) r2;
        r0 = r1.aXJ;
        r2 = r2.aXJ;
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
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.microservices.risks.response.overnightfee.e.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        HashMap hashMap = this.aXJ;
        return hashMap != null ? hashMap.hashCode() : 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("OvernightFeeResult(data=");
        stringBuilder.append(this.aXJ);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public e(HashMap<Integer, d> hashMap) {
        h.e(hashMap, "data");
        this.aXJ = hashMap;
    }

    public final HashMap<Integer, d> WM() {
        return this.aXJ;
    }
}
