package com.iqoption.core.microservices.busapi.response;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.NotificationCompat;
import com.google.gson.annotations.SerializedName;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0012HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001f"}, aXE = {"Lcom/iqoption/core/microservices/busapi/response/ForgetUserData;", "Landroid/os/Parcelable;", "status", "Lcom/iqoption/core/microservices/busapi/response/ForgetUserStatus;", "created", "", "expires", "(Lcom/iqoption/core/microservices/busapi/response/ForgetUserStatus;JJ)V", "getCreated", "()J", "getExpires", "getStatus", "()Lcom/iqoption/core/microservices/busapi/response/ForgetUserStatus;", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "core_release"})
/* compiled from: ForgetUserData.kt */
public final class a implements Parcelable {
    public static final Creator CREATOR = new a();
    @SerializedName("status")
    private final ForgetUserStatus aUo;
    @SerializedName("expires")
    private final long aUp;
    @SerializedName("created")
    private final long created;

    @i(aXC = {1, 1, 11})
    public static class a implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            h.e(parcel, "in");
            return new a((ForgetUserStatus) Enum.valueOf(ForgetUserStatus.class, parcel.readString()), parcel.readLong(), parcel.readLong());
        }

        public final Object[] newArray(int i) {
            return new a[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (h.E(this.aUo, aVar.aUo)) {
                if ((this.created == aVar.created ? 1 : null) != null) {
                    if ((this.aUp == aVar.aUp ? 1 : null) != null) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        ForgetUserStatus forgetUserStatus = this.aUo;
        int hashCode = (forgetUserStatus != null ? forgetUserStatus.hashCode() : 0) * 31;
        long j = this.created;
        hashCode = (hashCode + ((int) (j ^ (j >>> 32)))) * 31;
        j = this.aUp;
        return hashCode + ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ForgetUserData(status=");
        stringBuilder.append(this.aUo);
        stringBuilder.append(", created=");
        stringBuilder.append(this.created);
        stringBuilder.append(", expires=");
        stringBuilder.append(this.aUp);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        h.e(parcel, "parcel");
        parcel.writeString(this.aUo.name());
        parcel.writeLong(this.created);
        parcel.writeLong(this.aUp);
    }

    public a(ForgetUserStatus forgetUserStatus, long j, long j2) {
        h.e(forgetUserStatus, NotificationCompat.CATEGORY_STATUS);
        this.aUo = forgetUserStatus;
        this.created = j;
        this.aUp = j2;
    }

    public final ForgetUserStatus Vr() {
        return this.aUo;
    }

    public final long Vs() {
        return this.created;
    }

    public final long Vt() {
        return this.aUp;
    }
}
