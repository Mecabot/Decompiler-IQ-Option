package com.iqoption.microservice.vip;

import com.google.android.gms.plus.PlusShare;
import com.google.gson.annotations.SerializedName;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B5\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0004HÆ\u0003JE\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0006HÖ\u0001R\u0016\u0010\n\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\t\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006!"}, aXE = {"Lcom/iqoption/microservice/vip/TrainingSession;", "", "()V", "id", "", "title", "", "description", "logo", "duration", "categoryId", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JJ)V", "getCategoryId", "()J", "getDescription", "()Ljava/lang/String;", "getDuration", "getId", "getLogo", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "IqOption-5.5.1_optionXRelease"})
/* compiled from: VipManagerResposnses.kt */
public final class b {
    @SerializedName("logo")
    private final String cSN;
    @SerializedName("categoryId")
    private final long cSO;
    @SerializedName("description")
    private final String description;
    @SerializedName("duration")
    private final long duration;
    @SerializedName("id")
    private final long id;
    @SerializedName("title")
    private final String title;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if ((this.id == bVar.id ? 1 : null) != null && h.E(this.title, bVar.title) && h.E(this.description, bVar.description) && h.E(this.cSN, bVar.cSN)) {
                if ((this.duration == bVar.duration ? 1 : null) != null) {
                    if ((this.cSO == bVar.cSO ? 1 : null) != null) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.title;
        int i2 = 0;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.description;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.cSN;
        if (str != null) {
            i2 = str.hashCode();
        }
        i = (i + i2) * 31;
        long j2 = this.duration;
        i = (i + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        j2 = this.cSO;
        return i + ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TrainingSession(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", title=");
        stringBuilder.append(this.title);
        stringBuilder.append(", description=");
        stringBuilder.append(this.description);
        stringBuilder.append(", logo=");
        stringBuilder.append(this.cSN);
        stringBuilder.append(", duration=");
        stringBuilder.append(this.duration);
        stringBuilder.append(", categoryId=");
        stringBuilder.append(this.cSO);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public b(long j, String str, String str2, String str3, long j2, long j3) {
        h.e(str, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
        h.e(str2, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION);
        h.e(str3, "logo");
        this.id = j;
        this.title = str;
        this.description = str2;
        this.cSN = str3;
        this.duration = j2;
        this.cSO = j3;
    }

    public final long getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final long atc() {
        return this.cSO;
    }

    public b() {
        this(0, "", "", "", 0, 0);
    }
}
