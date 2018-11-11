package com.iqoption.quiz.api.response;

import com.google.android.gms.plus.PlusShare;
import com.google.gson.annotations.SerializedName;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B7\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0004HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0016\u0010\b\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\n\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006\u001f"}, aXE = {"Lcom/iqoption/quiz/api/response/InsightResponse;", "", "()V", "activeId", "", "optionType", "", "description", "timestampBegin", "", "timestampEnd", "(ILjava/lang/String;Ljava/lang/String;JJ)V", "getActiveId", "()I", "getDescription", "()Ljava/lang/String;", "getOptionType", "getTimestampBegin", "()J", "getTimestampEnd", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "quiz_release"})
/* compiled from: InsightResponse.kt */
public final class b {
    @SerializedName("asset_id")
    private final int activeId;
    @SerializedName("description")
    private final String description;
    @SerializedName("ts_1")
    private final long dik;
    @SerializedName("ts_2")
    private final long dil;
    @SerializedName("option_type")
    private final String optionType;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if ((this.activeId == bVar.activeId ? 1 : null) != null && h.E(this.optionType, bVar.optionType) && h.E(this.description, bVar.description)) {
                if ((this.dik == bVar.dik ? 1 : null) != null) {
                    if ((this.dil == bVar.dil ? 1 : null) != null) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int i = this.activeId * 31;
        String str = this.optionType;
        int i2 = 0;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.description;
        if (str != null) {
            i2 = str.hashCode();
        }
        i = (i + i2) * 31;
        long j = this.dik;
        i = (i + ((int) (j ^ (j >>> 32)))) * 31;
        j = this.dil;
        return i + ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("InsightResponse(activeId=");
        stringBuilder.append(this.activeId);
        stringBuilder.append(", optionType=");
        stringBuilder.append(this.optionType);
        stringBuilder.append(", description=");
        stringBuilder.append(this.description);
        stringBuilder.append(", timestampBegin=");
        stringBuilder.append(this.dik);
        stringBuilder.append(", timestampEnd=");
        stringBuilder.append(this.dil);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public b(int i, String str, String str2, long j, long j2) {
        h.e(str, "optionType");
        h.e(str2, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION);
        this.activeId = i;
        this.optionType = str;
        this.description = str2;
        this.dik = j;
        this.dil = j2;
    }

    public final int getActiveId() {
        return this.activeId;
    }

    public final String getOptionType() {
        return this.optionType;
    }

    public final String getDescription() {
        return this.description;
    }

    public final long aAg() {
        return this.dik;
    }

    public /* synthetic */ b(int i, String str, String str2, long j, long j2, int i2, f fVar) {
        if ((i2 & 1) != 0) {
            i = -1;
        }
        if ((i2 & 2) != 0) {
            str = "";
        }
        String str3 = str;
        if ((i2 & 4) != 0) {
            str2 = "";
        }
        String str4 = str2;
        long j3 = 0;
        long j4 = (i2 & 8) != 0 ? 0 : j;
        if ((i2 & 16) == 0) {
            j3 = j2;
        }
        this(i, str3, str4, j4, j3);
    }

    public final long aAh() {
        return this.dil;
    }

    public b() {
        this(-1, null, null, 0, 0, 30, null);
    }
}
