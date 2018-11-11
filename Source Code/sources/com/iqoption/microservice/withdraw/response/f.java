package com.iqoption.microservice.withdraw.response;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.gson.annotations.SerializedName;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002BE\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0002\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J\t\u0010 \u001a\u00020\u0004HÆ\u0003J\t\u0010!\u001a\u00020\u000bHÆ\u0003J\t\u0010\"\u001a\u00020\rHÆ\u0003J\t\u0010#\u001a\u00020\u0004HÆ\u0003JY\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u0004HÆ\u0001J\t\u0010%\u001a\u00020\u000bHÖ\u0001J\u0013\u0010&\u001a\u00020\r2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020\u000bHÖ\u0001J\t\u0010*\u001a\u00020\u0004HÖ\u0001J\u0019\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u000bHÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0005\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0016\u0010\u000e\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0016\u0010\t\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u00060"}, aXE = {"Lcom/iqoption/microservice/withdraw/response/PayoutField;", "Landroid/os/Parcelable;", "()V", "name", "", "langKey", "frontKey", "type", "Lcom/iqoption/microservice/withdraw/response/PayoutFieldType;", "regexp", "maxLength", "", "required", "", "placeholder", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/iqoption/microservice/withdraw/response/PayoutFieldType;Ljava/lang/String;IZLjava/lang/String;)V", "getFrontKey", "()Ljava/lang/String;", "getLangKey", "getMaxLength", "()I", "getName", "getPlaceholder", "getRegexp", "getRequired", "()Z", "getType", "()Lcom/iqoption/microservice/withdraw/response/PayoutFieldType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "IqOption-5.5.1_optionXRelease"})
/* compiled from: PayoutField.kt */
public final class f implements Parcelable {
    public static final Creator CREATOR = new a();
    @SerializedName("placeholder")
    private final String cTA;
    @SerializedName("lang_key")
    private final String cTw;
    @SerializedName("front_key")
    private final String cTx;
    @SerializedName("type")
    private final PayoutFieldType cTy;
    @SerializedName("regexp")
    private final String cTz;
    @SerializedName("maxLength")
    private final int maxLength;
    @SerializedName("name")
    private final String name;
    @SerializedName("required")
    private final boolean required;

    @i(aXC = {1, 1, 11})
    public static class a implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            h.e(parcel, "in");
            return new f(parcel.readString(), parcel.readString(), parcel.readString(), (PayoutFieldType) Enum.valueOf(PayoutFieldType.class, parcel.readString()), parcel.readString(), parcel.readInt(), parcel.readInt() != 0, parcel.readString());
        }

        public final Object[] newArray(int i) {
            return new f[i];
        }
    }

    public static /* bridge */ /* synthetic */ f a(f fVar, String str, String str2, String str3, PayoutFieldType payoutFieldType, String str4, int i, boolean z, String str5, int i2, Object obj) {
        f fVar2 = fVar;
        int i3 = i2;
        return fVar2.a((i3 & 1) != 0 ? fVar2.name : str, (i3 & 2) != 0 ? fVar2.cTw : str2, (i3 & 4) != 0 ? fVar2.cTx : str3, (i3 & 8) != 0 ? fVar2.cTy : payoutFieldType, (i3 & 16) != 0 ? fVar2.cTz : str4, (i3 & 32) != 0 ? fVar2.maxLength : i, (i3 & 64) != 0 ? fVar2.required : z, (i3 & 128) != 0 ? fVar2.cTA : str5);
    }

    public final f a(String str, String str2, String str3, PayoutFieldType payoutFieldType, String str4, int i, boolean z, String str5) {
        String str6 = str;
        h.e(str6, "name");
        String str7 = str2;
        h.e(str7, "langKey");
        String str8 = str3;
        h.e(str8, "frontKey");
        PayoutFieldType payoutFieldType2 = payoutFieldType;
        h.e(payoutFieldType2, Param.TYPE);
        String str9 = str4;
        h.e(str9, "regexp");
        String str10 = str5;
        h.e(str10, "placeholder");
        return new f(str6, str7, str8, payoutFieldType2, str9, i, z, str10);
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
            if (h.E(this.name, fVar.name) && h.E(this.cTw, fVar.cTw) && h.E(this.cTx, fVar.cTx) && h.E(this.cTy, fVar.cTy) && h.E(this.cTz, fVar.cTz)) {
                if ((this.maxLength == fVar.maxLength ? 1 : null) != null) {
                    return (this.required == fVar.required ? 1 : null) != null && h.E(this.cTA, fVar.cTA);
                }
            }
        }
    }

    public int hashCode() {
        String str = this.name;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.cTw;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.cTx;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        PayoutFieldType payoutFieldType = this.cTy;
        hashCode = (hashCode + (payoutFieldType != null ? payoutFieldType.hashCode() : 0)) * 31;
        str2 = this.cTz;
        hashCode = (((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.maxLength) * 31;
        int i2 = this.required;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        str2 = this.cTA;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PayoutField(name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", langKey=");
        stringBuilder.append(this.cTw);
        stringBuilder.append(", frontKey=");
        stringBuilder.append(this.cTx);
        stringBuilder.append(", type=");
        stringBuilder.append(this.cTy);
        stringBuilder.append(", regexp=");
        stringBuilder.append(this.cTz);
        stringBuilder.append(", maxLength=");
        stringBuilder.append(this.maxLength);
        stringBuilder.append(", required=");
        stringBuilder.append(this.required);
        stringBuilder.append(", placeholder=");
        stringBuilder.append(this.cTA);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        h.e(parcel, "parcel");
        parcel.writeString(this.name);
        parcel.writeString(this.cTw);
        parcel.writeString(this.cTx);
        parcel.writeString(this.cTy.name());
        parcel.writeString(this.cTz);
        parcel.writeInt(this.maxLength);
        parcel.writeInt(this.required);
        parcel.writeString(this.cTA);
    }

    public f(String str, String str2, String str3, PayoutFieldType payoutFieldType, String str4, int i, boolean z, String str5) {
        h.e(str, "name");
        h.e(str2, "langKey");
        h.e(str3, "frontKey");
        h.e(payoutFieldType, Param.TYPE);
        h.e(str4, "regexp");
        h.e(str5, "placeholder");
        this.name = str;
        this.cTw = str2;
        this.cTx = str3;
        this.cTy = payoutFieldType;
        this.cTz = str4;
        this.maxLength = i;
        this.required = z;
        this.cTA = str5;
    }

    public final String getName() {
        return this.name;
    }

    public final String atE() {
        return this.cTw;
    }

    public final String atF() {
        return this.cTx;
    }

    public final PayoutFieldType atG() {
        return this.cTy;
    }

    public final String atH() {
        return this.cTz;
    }

    public final boolean getRequired() {
        return this.required;
    }

    public final String getPlaceholder() {
        return this.cTA;
    }

    public f() {
        this("", "", "", PayoutFieldType.UNKNOWN, "", 0, false, "");
    }
}
