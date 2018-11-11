package com.iqoption.core.microservices.techinstruments.a;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.iqoption.core.ext.d;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002BC\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\nHÆ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\nHÆ\u0003JG\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, aXE = {"Lcom/iqoption/core/microservices/techinstruments/response/Template;", "", "()V", "id", "", "name", "", "chart", "Lcom/google/gson/JsonObject;", "indicators", "", "figures", "(JLjava/lang/String;Lcom/google/gson/JsonObject;Ljava/util/List;Ljava/util/List;)V", "getChart", "()Lcom/google/gson/JsonObject;", "getFigures", "()Ljava/util/List;", "getId", "()J", "getIndicators", "getName", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "core_release"})
/* compiled from: Template.kt */
public final class e {
    @SerializedName("chart")
    private final JsonObject aYe;
    @SerializedName("indicators")
    private final List<JsonObject> arF;
    @SerializedName("figures")
    private final List<JsonObject> asP;
    @SerializedName("id")
    private final long id;
    @SerializedName("name")
    private final String name;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            return ((this.id > eVar.id ? 1 : (this.id == eVar.id ? 0 : -1)) == 0 ? 1 : null) != null && h.E(this.name, eVar.name) && h.E(this.aYe, eVar.aYe) && h.E(this.arF, eVar.arF) && h.E(this.asP, eVar.asP);
        }
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.name;
        int i2 = 0;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        JsonObject jsonObject = this.aYe;
        i = (i + (jsonObject != null ? jsonObject.hashCode() : 0)) * 31;
        List list = this.arF;
        i = (i + (list != null ? list.hashCode() : 0)) * 31;
        list = this.asP;
        if (list != null) {
            i2 = list.hashCode();
        }
        return i + i2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Template(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", chart=");
        stringBuilder.append(this.aYe);
        stringBuilder.append(", indicators=");
        stringBuilder.append(this.arF);
        stringBuilder.append(", figures=");
        stringBuilder.append(this.asP);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public e(long j, String str, JsonObject jsonObject, List<JsonObject> list, List<JsonObject> list2) {
        h.e(str, "name");
        h.e(jsonObject, "chart");
        h.e(list, "indicators");
        h.e(list2, "figures");
        this.id = j;
        this.name = str;
        this.aYe = jsonObject;
        this.arF = list;
        this.asP = list2;
    }

    public final long getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public /* synthetic */ e(long j, String str, JsonObject jsonObject, List list, List list2, int i, f fVar) {
        if ((i & 1) != 0) {
            j = -1;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = "";
        }
        String str2 = str;
        if ((i & 4) != 0) {
            jsonObject = d.SX();
        }
        JsonObject jsonObject2 = jsonObject;
        if ((i & 8) != 0) {
            list = m.emptyList();
        }
        List list3 = list;
        if ((i & 16) != 0) {
            list2 = m.emptyList();
        }
        this(j2, str2, jsonObject2, list3, list2);
    }

    public final JsonObject WV() {
        return this.aYe;
    }

    public final List<JsonObject> JT() {
        return this.arF;
    }

    public final List<JsonObject> Kr() {
        return this.asP;
    }

    public e() {
        this(-1, null, null, null, null, 30, null);
    }
}
