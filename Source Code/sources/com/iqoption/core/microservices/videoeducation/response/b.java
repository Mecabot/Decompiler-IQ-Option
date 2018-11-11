package com.iqoption.core.microservices.videoeducation.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.plus.PlusShare;
import com.google.gson.annotations.SerializedName;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B#\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0011HÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00048\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0006\u001a\u00020\u00048\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u001d"}, aXE = {"Lcom/iqoption/core/microservices/videoeducation/response/ImageLink;", "Lcom/iqoption/core/microservices/videoeducation/response/LocalePlatformLink;", "()V", "url", "", "locale", "platform", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLocale", "()Ljava/lang/String;", "getPlatform", "getUrl", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "core_release"})
/* compiled from: ImageLink.kt */
public final class b implements c {
    public static final Creator CREATOR = new a();
    @SerializedName("platform")
    private final String aZG;
    @SerializedName("locale")
    private final String locale;
    @SerializedName("image")
    private final String url;

    @i(aXC = {1, 1, 11})
    public static class a implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            h.e(parcel, "in");
            return new b(parcel.readString(), parcel.readString(), parcel.readString());
        }

        public final Object[] newArray(int i) {
            return new b[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    /* JADX WARNING: Missing block: B:8:0x002c, code:
            if (kotlin.jvm.internal.h.E(XR(), r3.XR()) != false) goto L_0x0031;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x0031;
    L_0x0002:
        r0 = r3 instanceof com.iqoption.core.microservices.videoeducation.response.b;
        if (r0 == 0) goto L_0x002f;
    L_0x0006:
        r3 = (com.iqoption.core.microservices.videoeducation.response.b) r3;
        r0 = r2.url;
        r1 = r3.url;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x002f;
    L_0x0012:
        r0 = r2.getLocale();
        r1 = r3.getLocale();
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x002f;
    L_0x0020:
        r0 = r2.XR();
        r3 = r3.XR();
        r3 = kotlin.jvm.internal.h.E(r0, r3);
        if (r3 == 0) goto L_0x002f;
    L_0x002e:
        goto L_0x0031;
    L_0x002f:
        r3 = 0;
        return r3;
    L_0x0031:
        r3 = 1;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.microservices.videoeducation.response.b.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.url;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String locale = getLocale();
        hashCode = (hashCode + (locale != null ? locale.hashCode() : 0)) * 31;
        locale = XR();
        if (locale != null) {
            i = locale.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ImageLink(url=");
        stringBuilder.append(this.url);
        stringBuilder.append(", locale=");
        stringBuilder.append(getLocale());
        stringBuilder.append(", platform=");
        stringBuilder.append(XR());
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        h.e(parcel, "parcel");
        parcel.writeString(this.url);
        parcel.writeString(this.locale);
        parcel.writeString(this.aZG);
    }

    public b(String str, String str2, String str3) {
        h.e(str, PlusShare.KEY_CALL_TO_ACTION_URL);
        h.e(str2, "locale");
        h.e(str3, "platform");
        this.url = str;
        this.locale = str2;
        this.aZG = str3;
    }

    public final String getUrl() {
        return this.url;
    }

    public String getLocale() {
        return this.locale;
    }

    public /* synthetic */ b(String str, String str2, String str3, int i, f fVar) {
        if ((i & 1) != 0) {
            str = "";
        }
        if ((i & 2) != 0) {
            str2 = "all_ALL";
        }
        if ((i & 4) != 0) {
            str3 = "mobile";
        }
        this(str, str2, str3);
    }

    public String XR() {
        return this.aZG;
    }

    public b() {
        this("", null, null, 6, null);
    }
}
