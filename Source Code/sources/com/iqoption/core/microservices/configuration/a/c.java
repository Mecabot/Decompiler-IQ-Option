package com.iqoption.core.microservices.configuration.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;
import com.iqoption.core.ui.widget.recyclerview.adapter.a.d;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003Bs\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0002\u0010\u0012J\t\u0010!\u001a\u00020\u0002HÆ\u0003J\t\u0010\"\u001a\u00020\u0010HÆ\u0003J\t\u0010#\u001a\u00020\u0010HÆ\u0003J\t\u0010$\u001a\u00020\u0006HÆ\u0003J\t\u0010%\u001a\u00020\bHÆ\u0003J\t\u0010&\u001a\u00020\bHÆ\u0003J\t\u0010'\u001a\u00020\u0002HÆ\u0003J\t\u0010(\u001a\u00020\u0006HÆ\u0003J\t\u0010)\u001a\u00020\u0006HÆ\u0003J\t\u0010*\u001a\u00020\u0006HÆ\u0003J\t\u0010+\u001a\u00020\u0006HÆ\u0003Jw\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010HÆ\u0001J\t\u0010-\u001a\u00020\bHÖ\u0001J\u0013\u0010.\u001a\u00020\u00102\b\u0010/\u001a\u0004\u0018\u000100HÖ\u0003J\t\u00101\u001a\u00020\bHÖ\u0001J\t\u00102\u001a\u00020\u0006HÖ\u0001J\u0019\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\bHÖ\u0001R\u0016\u0010\n\u001a\u00020\u00028\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u000e\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0004\u001a\u00020\u00028\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0011\u001a\u00020\u00108\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0019R\u0016\u0010\u000f\u001a\u00020\u00108\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0019R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0016\u0010\u000b\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0016\u0010\r\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0016\u0010\f\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\t\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001f¨\u00068"}, aXE = {"Lcom/iqoption/core/microservices/configuration/response/Country;", "Lcom/iqoption/core/ui/widget/recyclerview/adapter/diff/Identifiable;", "", "Landroid/os/Parcelable;", "id", "name", "", "phoneCode", "", "priority", "codeId", "nameFull", "nameShort", "nameIso", "domain", "isVisible", "", "isRegulated", "(JLjava/lang/String;IIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V", "getCodeId", "()J", "getDomain", "()Ljava/lang/String;", "getId", "()Ljava/lang/Long;", "()Z", "getName", "getNameFull", "getNameIso", "getNameShort", "getPhoneCode", "()I", "getPriority", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "core_release"})
/* compiled from: Country.kt */
public final class c implements Parcelable, d<Long> {
    public static final Creator CREATOR = new a();
    @SerializedName("is_regulated")
    private final boolean aMv;
    @SerializedName("code_id")
    private final long aVi;
    @SerializedName("domain")
    private final String domain;
    @SerializedName("id")
    private final long id;
    @SerializedName("is_visible")
    private final boolean isVisible;
    @SerializedName("name")
    private final String name;
    @SerializedName("name_full")
    private final String nameFull;
    @SerializedName("name_iso")
    private final String nameIso;
    @SerializedName("name_short")
    private final String nameShort;
    @SerializedName("phone_code")
    private final int phoneCode;
    @SerializedName("priority")
    private final int priority;

    @i(aXC = {1, 1, 11})
    public static class a implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            h.e(parcel, "in");
            long readLong = parcel.readLong();
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            long readLong2 = parcel.readLong();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            boolean z = false;
            boolean z2 = parcel.readInt() != 0;
            if (parcel.readInt() != 0) {
                z = true;
            }
            return new c(readLong, readString, readInt, readInt2, readLong2, readString2, readString3, readString4, readString5, z2, z);
        }

        public final Object[] newArray(int i) {
            return new c[i];
        }
    }

    public c() {
        this(0, null, 0, 0, 0, null, null, null, null, false, false, 2047, null);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            if ((Jf().longValue() == cVar.Jf().longValue() ? 1 : null) != null && h.E(this.name, cVar.name)) {
                if ((this.phoneCode == cVar.phoneCode ? 1 : null) != null) {
                    if ((this.priority == cVar.priority ? 1 : null) != null) {
                        if ((this.aVi == cVar.aVi ? 1 : null) != null && h.E(this.nameFull, cVar.nameFull) && h.E(this.nameShort, cVar.nameShort) && h.E(this.nameIso, cVar.nameIso) && h.E(this.domain, cVar.domain)) {
                            if ((this.isVisible == cVar.isVisible ? 1 : null) != null) {
                                if ((this.aMv == cVar.aMv ? 1 : null) != null) {
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
        long longValue = Jf().longValue();
        int i = ((int) (longValue ^ (longValue >>> 32))) * 31;
        String str = this.name;
        int i2 = 0;
        i = (((((i + (str != null ? str.hashCode() : 0)) * 31) + this.phoneCode) * 31) + this.priority) * 31;
        long j = this.aVi;
        i = (i + ((int) (j ^ (j >>> 32)))) * 31;
        str = this.nameFull;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.nameShort;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.nameIso;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.domain;
        if (str != null) {
            i2 = str.hashCode();
        }
        i = (i + i2) * 31;
        int i3 = this.isVisible;
        if (i3 != 0) {
            i3 = 1;
        }
        i = (i + i3) * 31;
        i3 = this.aMv;
        if (i3 != 0) {
            i3 = 1;
        }
        return i + i3;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Country(id=");
        stringBuilder.append(Jf());
        stringBuilder.append(", name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", phoneCode=");
        stringBuilder.append(this.phoneCode);
        stringBuilder.append(", priority=");
        stringBuilder.append(this.priority);
        stringBuilder.append(", codeId=");
        stringBuilder.append(this.aVi);
        stringBuilder.append(", nameFull=");
        stringBuilder.append(this.nameFull);
        stringBuilder.append(", nameShort=");
        stringBuilder.append(this.nameShort);
        stringBuilder.append(", nameIso=");
        stringBuilder.append(this.nameIso);
        stringBuilder.append(", domain=");
        stringBuilder.append(this.domain);
        stringBuilder.append(", isVisible=");
        stringBuilder.append(this.isVisible);
        stringBuilder.append(", isRegulated=");
        stringBuilder.append(this.aMv);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        h.e(parcel, "parcel");
        parcel.writeLong(this.id);
        parcel.writeString(this.name);
        parcel.writeInt(this.phoneCode);
        parcel.writeInt(this.priority);
        parcel.writeLong(this.aVi);
        parcel.writeString(this.nameFull);
        parcel.writeString(this.nameShort);
        parcel.writeString(this.nameIso);
        parcel.writeString(this.domain);
        parcel.writeInt(this.isVisible);
        parcel.writeInt(this.aMv);
    }

    public c(long j, String str, int i, int i2, long j2, String str2, String str3, String str4, String str5, boolean z, boolean z2) {
        h.e(str, "name");
        h.e(str2, "nameFull");
        h.e(str3, "nameShort");
        h.e(str4, "nameIso");
        h.e(str5, "domain");
        this.id = j;
        this.name = str;
        this.phoneCode = i;
        this.priority = i2;
        this.aVi = j2;
        this.nameFull = str2;
        this.nameShort = str3;
        this.nameIso = str4;
        this.domain = str5;
        this.isVisible = z;
        this.aMv = z2;
    }

    /* renamed from: getId */
    public Long Jf() {
        return Long.valueOf(this.id);
    }

    public final String getName() {
        return this.name;
    }

    public final String VE() {
        return this.nameShort;
    }

    public /* synthetic */ c(long j, String str, int i, int i2, long j2, String str2, String str3, String str4, String str5, boolean z, boolean z2, int i3, f fVar) {
        int i4 = i3;
        this((i4 & 1) != 0 ? -1 : j, (i4 & 2) != 0 ? "" : str, (i4 & 4) != 0 ? 0 : i, (i4 & 8) != 0 ? 0 : i2, (i4 & 16) != 0 ? -1 : j2, (i4 & 32) != 0 ? "" : str2, (i4 & 64) != 0 ? "" : str3, (i4 & 128) != 0 ? "" : str4, (i4 & 256) != 0 ? "" : str5, (i4 & 512) != 0 ? false : z, (i4 & 1024) != 0 ? false : z2);
    }

    public final boolean Dh() {
        return this.aMv;
    }
}
