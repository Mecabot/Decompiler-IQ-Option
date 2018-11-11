package com.iqoption.core.microservices.videoeducation.response;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B#\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0011\u001a\u00020\bHÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0014HÖ\u0001R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001f"}, aXE = {"Lcom/iqoption/core/microservices/videoeducation/response/Tag;", "Landroid/os/Parcelable;", "()V", "id", "", "localizedTitle", "", "isVisible", "", "(JLjava/lang/String;Z)V", "getId", "()J", "()Z", "getLocalizedTitle", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "core_release"})
/* compiled from: Tag.kt */
public final class f implements Parcelable {
    public static final Creator CREATOR = new a();
    @SerializedName("locale_title")
    private final String aZD;
    @SerializedName("id")
    private final long id;
    @SerializedName("visible")
    private final boolean isVisible;

    @i(aXC = {1, 1, 11})
    public static class a implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            h.e(parcel, "in");
            return new f(parcel.readLong(), parcel.readString(), parcel.readInt() != 0);
        }

        public final Object[] newArray(int i) {
            return new f[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if ((this.id == fVar.id ? 1 : null) != null && h.E(this.aZD, fVar.aZD)) {
                if ((this.isVisible == fVar.isVisible ? 1 : null) != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.aZD;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        int i2 = this.isVisible;
        if (i2 != 0) {
            i2 = 1;
        }
        return i + i2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Tag(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", localizedTitle=");
        stringBuilder.append(this.aZD);
        stringBuilder.append(", isVisible=");
        stringBuilder.append(this.isVisible);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        h.e(parcel, "parcel");
        parcel.writeLong(this.id);
        parcel.writeString(this.aZD);
        parcel.writeInt(this.isVisible);
    }

    public f(long j, String str, boolean z) {
        h.e(str, "localizedTitle");
        this.id = j;
        this.aZD = str;
        this.isVisible = z;
    }

    public final long getId() {
        return this.id;
    }

    public final String Mi() {
        return this.aZD;
    }

    public /* synthetic */ f(long j, String str, boolean z, int i, f fVar) {
        if ((i & 1) != 0) {
            j = -1;
        }
        if ((i & 2) != 0) {
            str = "";
        }
        if ((i & 4) != 0) {
            z = false;
        }
        this(j, str, z);
    }

    public f() {
        this(-1, null, false, 6, null);
    }
}
