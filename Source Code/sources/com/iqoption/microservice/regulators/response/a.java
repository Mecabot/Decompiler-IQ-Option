package com.iqoption.microservice.regulators.response;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J+\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001e"}, aXE = {"Lcom/iqoption/microservice/regulators/response/ProTraderApplicationStatus;", "Landroid/os/Parcelable;", "statusType", "Lcom/iqoption/microservice/regulators/response/StatusType;", "applicationId", "", "comment", "(Lcom/iqoption/microservice/regulators/response/StatusType;Ljava/lang/String;Ljava/lang/String;)V", "getApplicationId", "()Ljava/lang/String;", "getComment", "getStatusType", "()Lcom/iqoption/microservice/regulators/response/StatusType;", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "IqOption-5.5.1_optionXRelease"})
/* compiled from: ProTraderApplicationStatus.kt */
public final class a implements Parcelable {
    public static final Creator CREATOR = new a();
    @SerializedName("application_id")
    private final String applicationId;
    @SerializedName("status")
    private final StatusType cSL;
    @SerializedName("comment")
    private final String comment;

    @i(aXC = {1, 1, 11})
    public static class a implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            StatusType statusType;
            h.e(parcel, "in");
            if (parcel.readInt() != 0) {
                statusType = (StatusType) Enum.valueOf(StatusType.class, parcel.readString());
            } else {
                statusType = null;
            }
            return new a(statusType, parcel.readString(), parcel.readString());
        }

        public final Object[] newArray(int i) {
            return new a[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    /* JADX WARNING: Missing block: B:8:0x0024, code:
            if (kotlin.jvm.internal.h.E(r2.comment, r3.comment) != false) goto L_0x0029;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x0029;
    L_0x0002:
        r0 = r3 instanceof com.iqoption.microservice.regulators.response.a;
        if (r0 == 0) goto L_0x0027;
    L_0x0006:
        r3 = (com.iqoption.microservice.regulators.response.a) r3;
        r0 = r2.cSL;
        r1 = r3.cSL;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0027;
    L_0x0012:
        r0 = r2.applicationId;
        r1 = r3.applicationId;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0027;
    L_0x001c:
        r0 = r2.comment;
        r3 = r3.comment;
        r3 = kotlin.jvm.internal.h.E(r0, r3);
        if (r3 == 0) goto L_0x0027;
    L_0x0026:
        goto L_0x0029;
    L_0x0027:
        r3 = 0;
        return r3;
    L_0x0029:
        r3 = 1;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.microservice.regulators.response.a.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        StatusType statusType = this.cSL;
        int i = 0;
        int hashCode = (statusType != null ? statusType.hashCode() : 0) * 31;
        String str = this.applicationId;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        str = this.comment;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ProTraderApplicationStatus(statusType=");
        stringBuilder.append(this.cSL);
        stringBuilder.append(", applicationId=");
        stringBuilder.append(this.applicationId);
        stringBuilder.append(", comment=");
        stringBuilder.append(this.comment);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        h.e(parcel, "parcel");
        Enum enumR = this.cSL;
        if (enumR != null) {
            parcel.writeInt(1);
            parcel.writeString(enumR.name());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.applicationId);
        parcel.writeString(this.comment);
    }

    public a(StatusType statusType, String str, String str2) {
        h.e(str, "applicationId");
        this.cSL = statusType;
        this.applicationId = str;
        this.comment = str2;
    }

    public final StatusType ata() {
        return this.cSL;
    }
}
