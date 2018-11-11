package com.iqoption.core.microservices.d.a;

import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.gson.annotations.SerializedName;
import java.util.Collections;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B9\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\u000bHÆ\u0003JG\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00072\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0004HÖ\u0001R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\""}, aXE = {"Lcom/iqoption/core/microservices/resources/responses/ResourceElement;", "", "()V", "id", "", "type", "tags", "", "data", "Lcom/iqoption/core/microservices/resources/responses/ResourceData;", "updatedAt", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;J)V", "getData", "()Ljava/util/List;", "getId", "()Ljava/lang/String;", "getTags", "getType", "getUpdatedAt", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "core_release"})
/* compiled from: ResourceResponses.kt */
public final class b {
    public static final a aXs = new a();
    @SerializedName("data")
    private final List<a> aXq;
    @SerializedName("updated_at")
    private final long aXr;
    @SerializedName("tags")
    private final List<String> gD;
    @SerializedName("id")
    private final String id;
    @SerializedName("type")
    private final String type;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, aXE = {"Lcom/iqoption/core/microservices/resources/responses/ResourceElement$Companion;", "", "()V", "TYPE_ANIMATION", "", "TYPE_FILE", "TYPE_IMAGE", "TYPE_JSON", "core_release"})
    /* compiled from: ResourceResponses.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (h.E(this.id, bVar.id) && h.E(this.type, bVar.type) && h.E(this.gD, bVar.gD) && h.E(this.aXq, bVar.aXq)) {
                if ((this.aXr == bVar.aXr ? 1 : null) != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.type;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        List list = this.gD;
        hashCode = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        list = this.aXq;
        if (list != null) {
            i = list.hashCode();
        }
        hashCode = (hashCode + i) * 31;
        long j = this.aXr;
        return hashCode + ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ResourceElement(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", type=");
        stringBuilder.append(this.type);
        stringBuilder.append(", tags=");
        stringBuilder.append(this.gD);
        stringBuilder.append(", data=");
        stringBuilder.append(this.aXq);
        stringBuilder.append(", updatedAt=");
        stringBuilder.append(this.aXr);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public b(String str, String str2, List<String> list, List<a> list2, long j) {
        h.e(str, "id");
        h.e(str2, Param.TYPE);
        h.e(list, "tags");
        h.e(list2, "data");
        this.id = str;
        this.type = str2;
        this.gD = list;
        this.aXq = list2;
        this.aXr = j;
    }

    public final String getId() {
        return this.id;
    }

    public final String getType() {
        return this.type;
    }

    public final List<a> WC() {
        return this.aXq;
    }

    public final long WD() {
        return this.aXr;
    }

    public b() {
        List emptyList = Collections.emptyList();
        h.d(emptyList, "Collections.emptyList()");
        List emptyList2 = Collections.emptyList();
        h.d(emptyList2, "Collections.emptyList()");
        this("", "", emptyList, emptyList2, 0);
    }
}
