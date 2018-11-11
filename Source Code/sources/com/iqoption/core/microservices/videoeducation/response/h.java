package com.iqoption.core.microservices.videoeducation.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.plus.PlusShare;
import com.google.gson.annotations.SerializedName;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B7\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u0004HÆ\u0001J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\b\u001a\u00020\u00048\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\t\u001a\u00020\u00048\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006$"}, aXE = {"Lcom/iqoption/core/microservices/videoeducation/response/VideoLink;", "Lcom/iqoption/core/microservices/videoeducation/response/LocalePlatformLink;", "()V", "format", "", "duration", "", "url", "locale", "platform", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDuration", "()I", "getFormat", "()Ljava/lang/String;", "getLocale", "getPlatform", "getUrl", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "core_release"})
/* compiled from: VideoLink.kt */
public final class h implements c {
    public static final Creator CREATOR = new a();
    @SerializedName("platform")
    private final String aZG;
    @SerializedName("format")
    private final String aZP;
    @SerializedName("duration")
    private final int duration;
    @SerializedName("locale")
    private final String locale;
    @SerializedName("video")
    private final String url;

    @i(aXC = {1, 1, 11})
    public static class a implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            kotlin.jvm.internal.h.e(parcel, "in");
            return new h(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        public final Object[] newArray(int i) {
            return new h[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            if (kotlin.jvm.internal.h.E(this.aZP, hVar.aZP)) {
                return (this.duration == hVar.duration ? 1 : null) != null && kotlin.jvm.internal.h.E(this.url, hVar.url) && kotlin.jvm.internal.h.E(getLocale(), hVar.getLocale()) && kotlin.jvm.internal.h.E(XR(), hVar.XR());
            }
        }
    }

    public int hashCode() {
        String str = this.aZP;
        int i = 0;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.duration) * 31;
        String str2 = this.url;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = getLocale();
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = XR();
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("VideoLink(format=");
        stringBuilder.append(this.aZP);
        stringBuilder.append(", duration=");
        stringBuilder.append(this.duration);
        stringBuilder.append(", url=");
        stringBuilder.append(this.url);
        stringBuilder.append(", locale=");
        stringBuilder.append(getLocale());
        stringBuilder.append(", platform=");
        stringBuilder.append(XR());
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        kotlin.jvm.internal.h.e(parcel, "parcel");
        parcel.writeString(this.aZP);
        parcel.writeInt(this.duration);
        parcel.writeString(this.url);
        parcel.writeString(this.locale);
        parcel.writeString(this.aZG);
    }

    public h(String str, int i, String str2, String str3, String str4) {
        kotlin.jvm.internal.h.e(str, "format");
        kotlin.jvm.internal.h.e(str2, PlusShare.KEY_CALL_TO_ACTION_URL);
        kotlin.jvm.internal.h.e(str3, "locale");
        kotlin.jvm.internal.h.e(str4, "platform");
        this.aZP = str;
        this.duration = i;
        this.url = str2;
        this.locale = str3;
        this.aZG = str4;
    }

    public final int getDuration() {
        return this.duration;
    }

    public final String getUrl() {
        return this.url;
    }

    public String getLocale() {
        return this.locale;
    }

    public /* synthetic */ h(String str, int i, String str2, String str3, String str4, int i2, f fVar) {
        if ((i2 & 1) != 0) {
            str = "";
        }
        int i3 = (i2 & 2) != 0 ? 0 : i;
        if ((i2 & 4) != 0) {
            str2 = "";
        }
        String str5 = str2;
        if ((i2 & 8) != 0) {
            str3 = "all_ALL";
        }
        String str6 = str3;
        if ((i2 & 16) != 0) {
            str4 = "mobile";
        }
        this(str, i3, str5, str6, str4);
    }

    public String XR() {
        return this.aZG;
    }

    public h() {
        this("", 0, null, null, null, 30, null);
    }
}
