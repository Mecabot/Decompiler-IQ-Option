package com.iqoption.core.microservices.d.a;

import com.google.android.gms.plus.PlusShare;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0006\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003J\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001d"}, aXE = {"Lcom/iqoption/core/microservices/resources/responses/ResourceData;", "", "resolution", "", "locale", "platformId", "", "metadata", "Lcom/google/gson/JsonElement;", "(Ljava/lang/String;Ljava/lang/String;ILcom/google/gson/JsonElement;)V", "getLocale", "()Ljava/lang/String;", "getMetadata", "()Lcom/google/gson/JsonElement;", "getPlatformId", "()I", "getResolution", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "getFileUrl", "getImageUrl", "hashCode", "toString", "core_release"})
/* compiled from: ResourceResponses.kt */
public final class a {
    @SerializedName("resolution")
    private final String aXn;
    @SerializedName("platformId")
    private final int aXo;
    @SerializedName("metadata")
    private final JsonElement aXp;
    @SerializedName("locale")
    private final String locale;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (h.E(this.aXn, aVar.aXn) && h.E(this.locale, aVar.locale)) {
                return (this.aXo == aVar.aXo ? 1 : null) != null && h.E(this.aXp, aVar.aXp);
            }
        }
    }

    public int hashCode() {
        String str = this.aXn;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.locale;
        hashCode = (((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.aXo) * 31;
        JsonElement jsonElement = this.aXp;
        if (jsonElement != null) {
            i = jsonElement.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ResourceData(resolution=");
        stringBuilder.append(this.aXn);
        stringBuilder.append(", locale=");
        stringBuilder.append(this.locale);
        stringBuilder.append(", platformId=");
        stringBuilder.append(this.aXo);
        stringBuilder.append(", metadata=");
        stringBuilder.append(this.aXp);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final String WA() {
        return this.aXn;
    }

    public final String US() {
        if (this.aXp.isJsonPrimitive()) {
            return this.aXp.getAsString();
        }
        return null;
    }

    public final String WB() {
        if (!this.aXp.isJsonPrimitive() && this.aXp.isJsonObject()) {
            JsonElement jsonElement = this.aXp.getAsJsonObject().get(PlusShare.KEY_CALL_TO_ACTION_URL);
            h.d(jsonElement, PlusShare.KEY_CALL_TO_ACTION_URL);
            if (jsonElement.isJsonPrimitive()) {
                return jsonElement.getAsString();
            }
        }
        return null;
    }
}
