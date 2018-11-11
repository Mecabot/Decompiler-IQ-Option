package com.iqoption.core.microservices.techinstruments.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\"\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002By\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0004¢\u0006\u0002\u0010\u0012J\t\u0010\"\u001a\u00020\u0004HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010$\u001a\u00020\u0004HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010'\u001a\u00020\u0006HÆ\u0003J\t\u0010(\u001a\u00020\u0004HÆ\u0003J\t\u0010)\u001a\u00020\u0006HÆ\u0003J\t\u0010*\u001a\u00020\fHÆ\u0003J\t\u0010+\u001a\u00020\u000eHÆ\u0003J\t\u0010,\u001a\u00020\fHÆ\u0003J}\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u0004HÆ\u0001J\t\u0010.\u001a\u00020\u000eHÖ\u0001J\u0013\u0010/\u001a\u00020\f2\b\u00100\u001a\u0004\u0018\u000101HÖ\u0003J\t\u00102\u001a\u00020\u000eHÖ\u0001J\t\u00103\u001a\u00020\u0006HÖ\u0001J\u0019\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u000eHÖ\u0001R\u0016\u0010\u000f\u001a\u00020\f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0011\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0016\u0010\r\u001a\u00020\u000e8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0016\u0010\n\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u0016\u0010\t\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016¨\u00069"}, aXE = {"Lcom/iqoption/core/microservices/techinstruments/response/Indicator;", "Landroid/os/Parcelable;", "()V", "id", "", "name", "", "description", "iconUrl", "videoId", "script", "hidden", "", "instanceCount", "", "canHostFigures", "suppressedLocal", "created", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;ZIZLjava/lang/String;J)V", "getCanHostFigures", "()Z", "getCreated", "()J", "getDescription", "()Ljava/lang/String;", "getHidden", "getIconUrl", "getId", "getInstanceCount", "()I", "getName", "getScript", "getSuppressedLocal", "getVideoId", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "core_release"})
/* compiled from: Indicator.kt */
public final class b implements Parcelable {
    public static final Creator CREATOR = new a();
    @SerializedName("video_id")
    private final long aXY;
    @SerializedName("script")
    private final String aXZ;
    @SerializedName("instance_count")
    private final int ayL;
    @SerializedName("suppressed_local")
    private final String ayM;
    @SerializedName("can_host_figures")
    private final boolean ayN;
    @SerializedName("hidden")
    private final boolean aza;
    @SerializedName("created")
    private final long created;
    @SerializedName("description")
    private final String description;
    @SerializedName("icon_url")
    private final String iconUrl;
    @SerializedName("id")
    private final long id;
    @SerializedName("name")
    private final String name;

    @i(aXC = {1, 1, 11})
    public static class a implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            h.e(parcel, "in");
            long readLong = parcel.readLong();
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            long readLong2 = parcel.readLong();
            String readString4 = parcel.readString();
            boolean z = true;
            boolean z2 = parcel.readInt() != 0;
            int readInt = parcel.readInt();
            if (parcel.readInt() == 0) {
                z = false;
            }
            return new b(readLong, readString, readString2, readString3, readLong2, readString4, z2, readInt, z, parcel.readString(), parcel.readLong());
        }

        public final Object[] newArray(int i) {
            return new b[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if ((this.id == bVar.id ? 1 : null) != null && h.E(this.name, bVar.name) && h.E(this.description, bVar.description) && h.E(this.iconUrl, bVar.iconUrl)) {
                if ((this.aXY == bVar.aXY ? 1 : null) != null && h.E(this.aXZ, bVar.aXZ)) {
                    if ((this.aza == bVar.aza ? 1 : null) != null) {
                        if ((this.ayL == bVar.ayL ? 1 : null) != null) {
                            if ((this.ayN == bVar.ayN ? 1 : null) != null && h.E(this.ayM, bVar.ayM)) {
                                if ((this.created == bVar.created ? 1 : null) != null) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.name;
        int i2 = 0;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.description;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.iconUrl;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        long j2 = this.aXY;
        i = (i + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        str = this.aXZ;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        int i3 = this.aza;
        if (i3 != 0) {
            i3 = 1;
        }
        i = (((i + i3) * 31) + this.ayL) * 31;
        i3 = this.ayN;
        if (i3 != 0) {
            i3 = 1;
        }
        i = (i + i3) * 31;
        str = this.ayM;
        if (str != null) {
            i2 = str.hashCode();
        }
        i = (i + i2) * 31;
        long j3 = this.created;
        return i + ((int) (j3 ^ (j3 >>> 32)));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Indicator(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", description=");
        stringBuilder.append(this.description);
        stringBuilder.append(", iconUrl=");
        stringBuilder.append(this.iconUrl);
        stringBuilder.append(", videoId=");
        stringBuilder.append(this.aXY);
        stringBuilder.append(", script=");
        stringBuilder.append(this.aXZ);
        stringBuilder.append(", hidden=");
        stringBuilder.append(this.aza);
        stringBuilder.append(", instanceCount=");
        stringBuilder.append(this.ayL);
        stringBuilder.append(", canHostFigures=");
        stringBuilder.append(this.ayN);
        stringBuilder.append(", suppressedLocal=");
        stringBuilder.append(this.ayM);
        stringBuilder.append(", created=");
        stringBuilder.append(this.created);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        h.e(parcel, "parcel");
        parcel.writeLong(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.description);
        parcel.writeString(this.iconUrl);
        parcel.writeLong(this.aXY);
        parcel.writeString(this.aXZ);
        parcel.writeInt(this.aza);
        parcel.writeInt(this.ayL);
        parcel.writeInt(this.ayN);
        parcel.writeString(this.ayM);
        parcel.writeLong(this.created);
    }

    public b(long j, String str, String str2, String str3, long j2, String str4, boolean z, int i, boolean z2, String str5, long j3) {
        h.e(str3, "iconUrl");
        h.e(str4, "script");
        this.id = j;
        this.name = str;
        this.description = str2;
        this.iconUrl = str3;
        this.aXY = j2;
        this.aXZ = str4;
        this.aza = z;
        this.ayL = i;
        this.ayN = z2;
        this.ayM = str5;
        this.created = j3;
    }

    public final long getId() {
        return this.id;
    }

    public /* synthetic */ b(long j, String str, String str2, String str3, long j2, String str4, boolean z, int i, boolean z2, String str5, long j3, int i2, f fVar) {
        int i3 = i2;
        this((i3 & 1) != 0 ? -1 : j, (i3 & 2) != 0 ? (String) null : str, (i3 & 4) != 0 ? (String) null : str2, (i3 & 8) != 0 ? "" : str3, (i3 & 16) != 0 ? -1 : j2, (i3 & 32) != 0 ? "" : str4, (i3 & 64) != 0 ? false : z, (i3 & 128) != 0 ? 1 : i, (i3 & 256) != 0 ? false : z2, (i3 & 512) != 0 ? (String) null : str5, (i3 & 1024) != 0 ? 0 : j3);
    }

    public final String getName() {
        return this.name;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final long WQ() {
        return this.aXY;
    }

    public final String getScript() {
        return this.aXZ;
    }

    public final int WR() {
        return this.ayL;
    }

    public final boolean LY() {
        return this.ayN;
    }

    public final String Mo() {
        return this.ayM;
    }

    public b() {
        this(-1, null, null, null, 0, null, false, 0, false, null, 0, 2046, null);
    }
}
